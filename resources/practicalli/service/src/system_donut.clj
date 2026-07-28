;; ---------------------------------------------------------
;; {{top/ns}}.{{main/ns}}
;;
;; {{description}}
;;
;; Start the service using donut configuration and an environment profile.
;; ---------------------------------------------------------

(ns {{top/ns}}.{{main/ns}}.system
  "Service component lifecycle management"
  (:gen-class)
  (:require
   ;; Application dependencies
   [{{top/ns}}.{{main/ns}}.router :as router]

   ;; Component system
   [donut.system :as donut]
   ;; [{{top/ns}}.{{main/ns}}.parse-system :as parse-system]

   ;; System dependencies
   [org.httpkit.server     :as http-server]
   [com.brunobonacci.mulog :as mulog]))

;; ---------------------------------------------------------
;; Donut Party System configuration

(def main
  "System Component management with Donut"
  {::donut/defs
   ;; Option: move :env data to resources/config.edn and parse with aero reader
   {:env
    {:app-version "0.1.0"
     :app-env "prod"
     :http-port (or (System/getenv "SERVICE_HTTP_PORT") 8080)
     :persistence
     {:database-host (or (System/getenv "POSTGRES_HOST") "http://localhost")
      :database-port (or (System/getenv "POSTGRES_PORT") "5432")
      :database-username (or (System/getenv "POSTGRES_USERNAME") "clojure")
      :database-password (or (System/getenv "POSTGRES_PASSWORD") "clojure")
      :database-schema (or (System/getenv "POSTGRES_SCHEMA") "clojure")}}

     ;; Configure data API connections
     ;; TODO: example system defined with aero
     ;; :data-api
     ;; {:game-service-base-url  #or [#env GAME_SERVICE_BASE_URL "http://localhost"]
     ;;  :llamasoft-api-uri  #or [#env LAMASOFT_API_URI "http://localhost"]
     ;;  :polybus-report-uri "/report/polybus"
     ;;  :moose-life-report-uri "/api/v1/report/moose-life"
     ;;  :minotaur-arcade-report-uri "/api/v2/minotar-arcade"
     ;;  :gridrunner-revolution-report-uri "/api/v1.1/gridrunner"
     ;;  :space-giraffe-report-uri "/api/v1/games/space-giraffe"}
     
    ;; mulog publisher for a given publisher type, i.e. console, cloud-watch
    :event-log
    {:publisher
     #::donut{:start (fn mulog-publisher-start
                       [{{:keys [global-context publisher]} ::donut/config}]
                       (mulog/set-global-context! global-context)
                       (mulog/log ::log-publish-component
                                  :publisher-config publisher
                                  :local-time (java.time.LocalDateTime/now))
                       (mulog/start-publisher! publisher))

              :stop (fn mulog-publisher-stop
                      [{::donut/keys [instance]}]
                      (mulog/log ::log-publish-component-shutdown :publisher instance :local-time (java.time.LocalDateTime/now))
                      ;; Pause so final messages have chance to be published
                      (Thread/sleep 250)
                      (instance))

              :config {:global-context {:app-name "{{top/ns}} {{main/ns}} service" 
                                        :version (donut/ref [:env :app-version])
                                        :environment (donut/ref [:env :app-env])}
                       ;; Publish events to console in json format
                       ;; optionally add `:transform` function to filter events before publishing
                       :publisher {:type :console-json 
                                   :pretty? false 
                                   #_#_:transform identity}}}}

    ;; HTTP server start - returns function to stop the server
    :http
    {:server
     #::donut{:start (fn http-kit-run-server
                       [{{:keys [handler options]} ::donut/config}]
                       (mulog/log ::http-server-component
                                  :handler handler
                                  :port (options :port)
                                  :local-time (java.time.LocalDateTime/now))
                       (http-server/run-server handler options))

              :stop  (fn http-kit-stop-server
                       [{::donut/keys [instance]}]
                       (mulog/log ::http-server-component-shutdown
                                  :http-server-instance instance
                                  :local-time (java.time.LocalDateTime/now))
                       (instance))

              :config {:handler (donut/local-ref [:handler])
                       :options {:port  (donut/ref [:env :http-port])
                                 :join? true}}}

     ;; Function handling all requests, passing system environment
     ;; Configure environment for router application, e.g. database connection details, etc.
     :handler (router/app (donut/ref [:env :persistence]))}}})

;; End of Donut Party System configuration
;; ---------------------------------------------------------
