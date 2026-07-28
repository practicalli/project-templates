;; ---------------------------------------------------------
;; {{top/ns}}.{{main/ns}}.service-test
;;
;; Example unit tests for {{top/ns}}.{{main/ns}}
;;
;; - `deftest` - test a specific function
;; - `testing` logically group assertions within a function test
;; - `is` assertion:  expected value then function call
;; ---------------------------------------------------------

(ns {{top/ns}}.{{main/ns}}.service-test
  (:require [clojure.test :refer [deftest is testing]]
            [{{top/ns}}.{{main/ns}}.service :as {{main/ns}}]))

(deftest service-test
  (testing "TODO: Start with a failing test, make it pass, then refactor"

    ;; TODO: fix greet function to pass test
    (is (= "{{top/ns}} {{main/ns}} service developed by the secret engineering team"
           ({{main/ns}}/greet)))

    ;; TODO: fix test by calling greet with {:team-name "Practicalli Engineering"}
    (is (= ({{main/ns}}/greet "Practicalli Engineering")
           "{{top/ns}} {{main/ns}} service developed by the Practicalli Engineering team"))))
