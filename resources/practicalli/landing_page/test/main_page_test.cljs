;; ---------------------------------------------------------
;; {{top/ns}}.{{main/ns}}-test
;;
;; Example unit tests for {{top/ns}}.{{main/ns}}
;;
;; - `deftest` - test a specific function
;; - `testing` logically group assertions within a function test
;; - `is` assertion:  expected value then function call
;; ---------------------------------------------------------

(ns {{top/ns}}.{{main/ns}}-test
    (:require
     [cljs.test :refer-macros [deftest is testing]]
     [{{top/ns}}.{{main/ns}} :as {{main/ns}}]))


(deftest main-page-test
  (testing "TODO: Group together assertions in a meaningful scenario"
    (is (true? true))
    ))


;; Possible tests
;; - structure of landing page, e.g. are all sections present
;; - important pieces of data, e.g. last updated has a correct form of value
