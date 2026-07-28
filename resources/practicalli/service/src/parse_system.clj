;; --------------------------------------------------
;; Prepare system configuration with juxt/aero
;; --------------------------------------------------

(ns {{top/ns}}.{{main/ns}}.parse-system
  (:require
   [aero.core       :as aero]
   [clojure.java.io :as io]

   ;; Debug aero parsing - comment by default
   ;; [com.brunobonacci.mulog :as mulog]
   ))

;; --------------------------------------------------
;; Parse system configuration
;; - update system configuration with respect to a given profile

(defn aero-config
  "Profile specific configuration for all services.
  Profiles supported: :dev :test :prod"
  [profile]
  ;; (mulog/log ::aero-parse-config :profile profile :local-time (java.time.LocalDateTime/now)
  (aero/read-config (io/resource "config.edn") {:profile profile}))

;; End of Aero Parsing
;; ---------------------------------------------------------
