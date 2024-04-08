;; ---------------------------------------------------------
;; Donut System REPL
;;
;; Tools for REPl workflow with Donut system components
;; ---------------------------------------------------------

(ns system-repl
  "Tools for REPl workflow with Donut system components"
  (:require
   [donut.system :as donut]
   [donut.system.repl :as donut-repl]
   [donut.system.repl.state :as donut-repl-state]
   [{{top/ns}}.{{main/ns}}.system :as system]))


;; ---------------------------------------------------------
;; Donut named systems
;; `:donut.system/repl` is default named system,
;; bound to `{{top/ns}}.{{main/ns}}.system` configuration
(defmethod donut/named-system :donut.system/repl
  [_] system/main)

;; `dev` system, partially overriding main system configuration
;; to support the development workflow
(defmethod donut/named-system :dev
  [_] (donut/system :donut.system/repl
                    {[:env :app-env] "dev"
                     [:env :app-version] "0.0.0-SNAPSHOT"
                     [:services :http-server ::donut/config :options :join?] false
                     [:services :event-log-publisher ::donut/config]
                     {:publisher {:type :console :pretty? true}}}))
;; ---------------------------------------------------------

;; ---------------------------------------------------------
;; Donut REPL workflow helper functions

(defn start
  "Start services using a named-system configuration,
  use `:dev` named-system by default"
  ([] (start :dev))
  ([named-system] (donut-repl/start named-system)))

(defn stop
  "Stop the currently running system"
  []  (donut-repl/stop))

(defn restart
  "Restart the system with donut repl,
  Uses clojure.tools.namespace.repl to reload namespaces
  `(clojure.tools.namespace.repl/refresh :after 'donut.system.repl/start)`"
  [] (donut-repl/restart))

(defn system
  "Return: fully qualified hash-map of system state"
  [] donut-repl-state/system)
;; ---------------------------------------------------------
