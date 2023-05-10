;; ---------------------------------------------------------
;; Programatic Transformation
;;
;; Define transformations based on data in the template and
;; passed via the command line
;;
;; `data-fn` enrich template data
;; `template-fn` modify declarative template rules
;; ---------------------------------------------------------


(ns practicalli.landing-page
  "Programmatic transformation of template substitution data
  and declarative transformation rules"
  (:require
   [clojure.pprint :as print]))


#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn substitutions
  "Update keys & values available in the substitution data,
  from the template.edn, derived values and command line options
  Return:
  - hash-map to be merged into the existing substitution data"
  [data]

  ;; Simple example:
  #_(when (= (data :specification) "clojure.spec")
      {:clojure-spec true})

  nil) ; returning nil means no changes to options data


#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn template-edn
  "Update data in the template.edn configuration.
  E.g. derive new declarative transformation rules from
  template substitutions, derived values and values passed
  to the template via the command line
  Return
  - new template.edn configuration"
  [edn data]
  (println "Data used in template-edn")
  (print/pprint data)
  edn)
