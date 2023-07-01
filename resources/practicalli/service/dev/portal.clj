(ns portal
  (:require
   ;; Data inspector
   [portal.api :as inspect]))


;; ---------------------------------------------------------
;; Start Portal and capture all evaluation results

;; Open Portal window in browser with dark theme
;; https://cljdoc.org/d/djblue/portal/0.37.1/doc/ui-concepts/themes
;; Portal options:
;; - light theme {:portal.colors/theme :portal.colors/solarized-light}
;; - dark theme  {:portal.colors/theme :portal.colors/gruvbox}

(def instance
  "Open portal window if no portal sessions have been created.
   A portal session is created when opening a portal window"
  (or (seq (inspect/sessions))
      (inspect/open {:portal.colors/theme :portal.colors/gruvbox})))

;; Add portal as tapsource (add to clojure.core/tapset)
(add-tap #'portal.api/submit)
;; ---------------------------------------------------------
