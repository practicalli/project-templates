;; ---------------------------------------------------------
;; Programatic Transformation
;;
;; Define transformations based on data in the template and
;; passed via the command line
;;
;; `data-fn` enrich template data
;; `template-fn` modify declarative template rules
;; ---------------------------------------------------------


(ns practicalli.application
  "Programmatic transformation of template data transformation rules"
  (:require
   [clojure.pprint :as pprint]))


(defn data-fn
  "Example data-fn handler.

  Result is merged onto existing options data."
  [data]
  ;; returning nil means no changes to options data
  (println "data-fn")
  (pprint/pprint data)
  nil)

(defn template-fn
  "Example template-fn handler.

  Result is used as the EDN for the template."
  [edn data]
  ;; must return the whole EDN hash map
  (println "template-fn data")
  (pprint/pprint data)
  (println "template-fn edn")
  (pprint/pprint edn)
  edn)
