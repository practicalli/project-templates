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
   [practicalli.hole-in-one.router :as router]

   ;; Component system
   [donut.system :as donut]
   [aero.core    :as aero]

   ;; System dependencies
   [org.httpkit.server     :as http-server]
   [com.brunobonacci.mulog :as mulog]))


;; ---------------------------------------------------------
;; Parse system config with aero

;; Use aero for all configuration
(defn parse-config [& [profile]]
  (aero/read-config (io/resource "resources/config.edn")
                    (when profile {:profile profile})))


    ;; End of Parse system config with aero
;; ---------------------------------------------------------



;; ---------------------------------------------------------
;; Donut Party System configuration

(def base-system
  "System Component management with Donut"
  {::donut/defs
   ;; Option: move :env data to resources/config.edn and parse with aero reader
   {:env {}
    
    ;; mulog publisher for a given publisher type, i.e. console, cloud-watch
    :event-log
    {:publisher
     #::donut{:start (fn mulog-publisher-start
                       [{{:keys [publisher]} ::donut/config}]
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

              :config {:publisher {:type :console :pretty? true}}}}

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
                                 :join? false}}}

     ;; Function handling all requests, passing system environment
     ;; Configure environment for router application, e.g. database connection details, etc.
     :handler (router/app (donut/ref [:env :persistence]))}}})

;; End of Donut Party System configuration
;; ---------------------------------------------------------

;; ---------------------------------------------------------
;; Donut named systems

(defmethod ds/named-system :base
  [_]
  base-system)

(defmethod ds/named-system :dev
  [_]
  (ds/system :base {[:env] (env-config :dev)}))

(defmethod ds/named-system :donut.system/repl
  [_]
  (ds/system :dev))

(defmethod ds/named-system :prod
  [_]
  (ds/system :base {[:env] (env-config :prod)}))

;; End of Donut named systems
;; ---------------------------------------------------------



