;; ---------------------------------------------------------
;; Unit and specification tests for practicalli/application template
;;
;; Test the template.edn file of the application template
;; using the deps-new specification
;; ---------------------------------------------------------


(ns practicalli.application-test
  (:require
   [clojure.edn :as edn]
   [clojure.java.io :as io]
   [clojure.spec.alpha :as spec]
   [clojure.test :refer [deftest is testing]]
   [org.corfield.new]
   ;; deps-new Specs
   #_[practicalli.application :as application]))


(deftest valid-template-test
  (testing "template.edn is valid."
    (let [template (edn/read-string (slurp (io/resource "practicalli/application/template.edn")))]
      (is (spec/valid? :org.corfield.new/template template)
          (spec/explain-str :org.corfield.new/template template)))))
