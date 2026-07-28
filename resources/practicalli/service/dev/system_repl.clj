;; ---------------------------------------------------------
;; System REPL - Atom Restart 
;;
;; Tools for REPl workflow with Aton reference to HTTP server 
;; https://practical.li/clojure-web-services/app-servers/simple-restart/
;; ---------------------------------------------------------

(ns system-repl
  (:require 
    [clojure.tools.namespace.repl :refer [refresh]]
    [{{top/ns}}.{{main/ns}}.service :as service]))
            
;; ---------------------------------------------------------
;; HTTP Server State

(defonce http-server-instance (atom nil))
;; ---------------------------------------------------------


;; ---------------------------------------------------------
;; REPL workflow commands

(defn stop
  "Gracefully shutdown the server, waiting 100ms"
  []
  (when-not (nil? @http-server-instance)
    (@http-server-instance :timeout 100)
    (reset! http-server-instance nil)
    (println "INFO: HTTP server shutting down...")))

(defn start
  "Start the application server and run the application"
  [& port]
  (let [port (Integer/parseInt
              (or (first port)
                  (System/getenv "PORT")
                  "8080"))]
    (println "INFO: Starting server on port:" port)

    (reset! http-server-instance
            (service/http-server-start port))))


(defn restart
  "Stop the http server, refresh changed namespace and start the http server again"
  []
  (stop)
  (refresh)  ;; Refresh changed namespaces
  (start))
;; ---------------------------------------------------------

