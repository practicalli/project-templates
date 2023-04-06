;; ---------------------------------------------------------
;; Unit and specification tests for practicalli/service template
;;
;; Test the template.edn file of the application template
;; using the deps-new specification
;; ---------------------------------------------------------


(ns practicalli.service-test
  (:require [clojure.edn :as edn]
            [clojure.java.io :as io]
            [clojure.spec.alpha :as spec]
            [clojure.test :refer [deftest is testing]]
            [org.corfield.new] ; deps-new Specs
            #_[practicalli.service :as service]))


(def project-template
  "Project template hash-map"
  (edn/read-string (slurp (io/resource "practicalli/service/template.edn"))))

(deftest valid-template-test
  (testing "template.edn is valid."
    (is (spec/valid? :org.corfield.new/template project-template)
        (spec/explain-str :org.corfield.new/template project-template))))

