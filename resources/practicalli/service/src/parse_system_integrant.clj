;; --------------------------------------------------
;; Prepare system configuration with juxt/aero
;;
;; aero parsing of Integrant configuration from `user` and `service` namespaces
;;
;; Integrant and Integrant-repl are separate workflows for managing system components
;; however they share the same parsing of the system configuration code with Aero
;; - Integrant manages components when the service is run via `main` function
;; - Integrant REPL manages components during development from `user` namespace
;; --------------------------------------------------


(ns {{top/ns}}.{{main/ns}}.parse-system
  (:require
   [aero.core       :as aero]
   [clojure.java.io :as io]
   [integrant.core  :as ig]

   ;; Debug aero parsing - comment by default
   ;; [com.brunobonacci.mulog :as mulog]
   ))

;; --------------------------------------------------
;; Parse system configuration
;; - update system configuration with respect to a given profile

;; Parse Integrant key with with aero tag literals
;; returning key/value from given profile value
#_{:clj-kondo/ignore [:unused-binding]}
(defmethod aero/reader 'ig/ref
  [_ tag value]
  ;; (mulog/log ::aero-parse-key :key _ :tag tag :value value :local-time (java.time.LocalDateTime/now)
  (ig/ref value))

(defn aero-config
  "Profile specific configuration for all services.
  Profiles supported: :dev :test :prod"
  [profile]
  ;; (mulog/log ::aero-parse-config :profile profile :local-time (java.time.LocalDateTime/now)
  (aero/read-config (io/resource "config.edn") {:profile profile}))

(defn aero-prep
  "Parse the system config and update values for the given profile (:dev, :test :prod)
  Top-level keys in `config.edn` use fully qualified namespace name for `ig/init-key` defmethod
  `ig/load-namespaces` automatically loads each namespace referenced by a top-level key
  Return: configuration hash-map for specified profile (:dev :test :prod) with aero tags resolved"
  [profile]
  (let [config (aero-config profile)]
    ;; (mulog/log ::integrant-load-namespaces :config config :local-time (java.time.LocalDateTime/now)
    (ig/load-namespaces config)
    config))

;; End of Aero Parsing
;; ---------------------------------------------------------
