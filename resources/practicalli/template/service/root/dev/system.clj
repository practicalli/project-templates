;; ---------------------------------------------------
;; System component management for REPL workflow
;;
;; automatically loaded via the `dev/user.clj` namespace
;;
;; NOTE: standard IntegrantREPL code, maintenance should not be required
;; ---------------------------------------------------


(ns system
  "Configure the system components and provide convenience functions
  to "
  (:require
   ;; REPL workflow
   [integrant.repl       :as ig-repl]
   [integrant.repl.state :as ig-state]

   ;; Environment parsing
   [practicalli.service.parse-system :as parse-system]))


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
  ([] (go :dev))
  ([profile] (environment-prep! profile) (ig-repl/go)))


(defn reset
  "Read updates from the configuration and restart the system services with Integrant-repl"
  ([] (reset :dev))
  ([profile] (environment-prep! profile) (ig-repl/reset)))


(defn reset-all
  "Read updates from the configuration and restart the system services with Integrant-repl"
  ([] (reset-all :dev))
  ([profile] (environment-prep! profile) (ig-repl/reset-all)))


(defn stop
  "Shutdown all services"
  []
  (ig-repl/halt))


(defn system
  "The running system configuration"
  []
  ig-state/system)


(defn config
  "The current system configuration used by Integrant"
  []
  ig-state/config)

;; End of Integrant REPL convenience functions
;; ---------------------------------------------------------
