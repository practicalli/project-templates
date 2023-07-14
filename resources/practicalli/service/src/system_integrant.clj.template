;; ---------------------------------------------------------
;; {{top/ns}}.{{main/ns}}
;;
;; {{description}}
;;
;; Start the service using Integrant configuration and an environment profile.
;; A profile is injected into the configuration in the `practicalli.gameboard.environment` namespace
;; and the resulting configuration is used by Integrant to start the system components
;;
;; The service consist of
;; - httpkit web application server
;; - metosin/reitit for routing and ring for request / response management
;; - mulog event logging service
;;
;; Related namespaces
;; `resources/config.edn` system configuration with environment #profile placeholders
;; `{{top/ns}}.environment` injects profile & other aero tag values into a resulting configuration
;; ---------------------------------------------------------

(ns {{top/ns}}.{{main/ns}}.system
  "Service component lifecycle management"
  (:gen-class)
  (:require
   ;; Application dependencies
   [{{top/ns}}.{{main/ns}}.router :as router]

   ;; Component system
   [{{top/ns}}.{{main/ns}}.parse-system :as parse-system]

   ;; System dependencies
   [org.httpkit.server     :as http-server]
   [integrant.core         :as ig]
   [com.brunobonacci.mulog :as mulog]))

;; --------------------------------------------------
;; Configure and start application components

(defn initialise
  "initialise the system using Integrant"
  [profile]
  (ig/init (parse-system/aero-prep profile)))

;; Start mulog publisher for the given publisher type, i.e. console, cloud-watch
#_{:clj-kondo/ignore [:unused-binding]}
(defmethod ig/init-key ::log-publish
  [_ {:keys [mulog] :as config}]
  (mulog/log ::log-publish-component :publisher-config mulog :local-time (java.time.LocalDateTime/now))
  (let [publisher (mulog/start-publisher! mulog)]
    publisher))

;; Connection for Relational Database Persistence
;; return hash-map of connection values: endpoint, access-key, secret-key
;; TODO: add example of connection pool
(defmethod ig/init-key ::relational-store
  [_ {:keys [connection] :as config}]
  (mulog/log ::persistence-component :connection connection :local-time (java.time.LocalDateTime/now))
  config)

;; Connections for data services
(defmethod ig/init-key ::data-provider
  [_ config]
  (mulog/log ::data-provider-component :configuration config :local-time (java.time.LocalDateTime/now))
  config)

;; Configure environment for router application, e.g. database connection details, etc.
(defmethod ig/init-key ::router
  [_ config]
  (mulog/log ::app-routing-component :app-config config)
  (router/app config))

;; HTTP server start - returns function to stop the server
(defmethod ig/init-key ::http-server
  [_ {:keys [handler port join?]}]
  (mulog/log ::http-server-component :handler handler :port port :local-time (java.time.LocalDateTime/now))
  (http-server/run-server handler {:port port :join? join?}))

;; Shutdown HTTP service
(defmethod ig/halt-key! ::http-server
  [_ http-server-instance]
  (mulog/log ::http-server-component-shutdown  :http-server-object http-server-instance :local-time (java.time.LocalDateTime/now))
  ;; Calling http instance shuts down that instance
  (http-server-instance))

;; Shutdown Log publishing
(defmethod ig/halt-key! ::log-publish
  [_ publisher]
  (mulog/log ::log-publish-component-shutdown :publisher-object publisher :local-time (java.time.LocalDateTime/now))
  ;; Pause so final messages have chance to be published
  (Thread/sleep 250)
  ;; Call publisher again to stop publishing
  (publisher))

(defn stop
  "Stop service using Integrant halt!"
  [system]
  (mulog/log ::http-server-sigterm :system system :local-time (java.time.LocalDateTime/now))
  ;; (println "Shutdown of service via Integrant")
  (ig/halt! system))

;; --------------------------------------------------
