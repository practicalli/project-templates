;; ---------------------------------------------------------
;; Service template programatic Transformation
;;
;; Define transformations based on data in the template and
;; passed via the command line
;;
;; `data-fn` enrich template data
;; `template-fn` modify declarative template rules
;; ---------------------------------------------------------


(ns practicalli.service
  "Programmatic transformation of template data transformation rules"
  (:require
   [clojure.pprint :as pprint]
   [clojure.string :as string]))

(defn data-fn
  "Update keys & values available in the substitution data
  Return:
  - hash-map to be merged into the substitution data"
  [data]
  ;; returning nil means no changes to options data

  ;; When using practicalli/service template,
  ;; derive the service name
  {:service-name (first (string/split (data :main) #"\."))}

  #_(when (= (data :component) "integrant")
      {:integrant-repl true}))


(defn template-fn
  "Derive new declarative transformation rules from substitution data
  and values passed to the template via the command line
  Return
  - updated template.edn configuration"
  [edn data]
  ;; must return the whole EDN hash map
  (println "template-fn data")
  (pprint/pprint data)
  (println "template-fn edn")
  (pprint/pprint edn)
  edn)
