;; ---------------------------------------------------
;; System component management for REPL workflow
;;
;; System config components defined in `resources/config.edn`
;;
;; `system` namespace automatically loaded via the `dev/user.clj` namespace
;;
;; Commands:
;; `(start)` starts all components in system config
;; `(restart)` reads system config, reloads changed namespaces & restarts system
;; `(restart-all)` as above with all namespaces reloaded
;; `(stop)` shutdown all components in the system (gracefully where appropriate)
;; `(system)` show configuration of the running system
;; `(config)` system configuration
;;
;; NOTE: standard IntegrantREPL code, maintenance should not be required
;; ---------------------------------------------------


(ns system
  "Configure the system components and provide Integrant REPL convenience functions
  to start/stop/restart components and show system configuration"
  (:require
   ;; REPL workflow
   [integrant.repl       :as ig-repl]
   [integrant.repl.state :as ig-state]

   ;; Environment parsing
   [{{top/ns}}.{{main/ns}}.parse-system :as parse-system]))


(println "Loading system namespace for Integrant REPL")


;; ---------------------------------------------------------
;; System Configuration
;; - `resources/config.edn` Integrant & Aero system configuration

(defn environment-prep!
  "Parse system configuration with aero-reader and apply the given profile values
  Return: Integrant configuration to be used to start the system
  integrant.repl/set-prep! takes an anonymous function that returns an integrant configuration
  Arguments: profile - a keyword determining the environment - :dev :test :stage :live"

  [profile]
  (ig-repl/set-prep! #(parse-system/aero-prep profile)))

;; ---------------------------------------------------------


;; ---------------------------------------------------------
;; Integrant REPL convenience functions
;; - enable use of aero profiles (`dev`, `stage`, `prod`)
;; - simplify Integrant REPL commands for managing the system

(defn start
  "Prepare configuration and start the system services with Integrant-repl"
  ([] (start :dev))
  ([profile] (environment-prep! profile) (ig-repl/go)))


(defn restart
  "Read updates from the system configuration, reloads changed namespaces
  and restart the system services with Integrant-repl"
  ([] (restart :dev))
  ([profile] (environment-prep! profile) (ig-repl/reset)))


(defn restart-all
  "Read updates from the configuration, reloads all namespaces
  and restart the system services with Integrant-repl"
  ([] (restart-all :dev))
  ([profile] (environment-prep! profile) (ig-repl/reset-all)))


(defn stop
  "Shutdown all services"
  []
  (ig-repl/halt))


(defn system
  "The running system configuration,
  including component references and specific profile values"
  []
  ig-state/system)


(defn config
  "The current system configuration used by Integrant"
  []
  ig-state/config)

;; End of Integrant REPL convenience functions
;; ---------------------------------------------------------
