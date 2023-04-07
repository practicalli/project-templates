;; ---------------------------------------------------------
;; Programatic Transformation
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

  (cond->> data
    (= (data :component) "integrant") (assoc edn :transform []))

  edn)

(comment

  (def template-edn)
  {:description "TODO: Provide a meaningful description of the project",
   :transform
   [["build" ""
     {"build.clj.template" "build.clj", "deps.edn.template" "deps.edn"}]
    ["src" "src/{{top/file}}"
     {"service.clj.template" "{{main/file}}.clj"}]
    ["test" "test/{{top/file}}"
     {"service_test.clj.template" "{{main/file}}_test.clj"}]],
   :kaocha-version "1.80.1274",
   :data-fn practicalli.template.service/data-fn,
   :template-fn practicalli.template.service/template-fn,
   :clojure-cli-version "1.11.1",
   :mulog-version "0.9.0",
   :tools-build-tag "v0.9.4",
   :tools-build-sha "76b78fe"}

  (assoc template-edn :transform [[]])

  (def integrant-transform
    [["build" ""
      {"build.clj.template" "build.clj"
       "deps-integrant.edn.template" "deps.edn"}]
     ["src" "src/{{top/file}}"
      {"service-integrant.clj.template" "{{main/file}}.clj"}]
     ["test" "test/{{top/file}}"
      {"service_test.clj.template" "{{main/file}}_test.clj"}]])

  #_()) ; End of rich comment



(comment

  ;; Optional features
  :component nil ; one of "integrant" "mount" "donut"
  :persistence nil ; one of "postgres" "h2" "crux"
  :router nil ; one of "reitit"

  ;; Example data passed to `data-fn`
  {data-fn
   {:artifact/id "service",
    :now/year "2023",
    :top "practicalli.gameboard",
    :name "practicalli.gameboard/service",
    :now/date "2023-03-31",
    :template "practicalli.template/service",
    :group/id "practicalli.gameboard",
    :target-dir "gameboard",
    :template-dir
    "/home/practicalli/projects/practicalli/project-templates/resources/practicalli/service",
    :developer "Practicalli",
    :version "0.1.0-SNAPSHOT",
    :main "service",
    :scm/repo "service",
    :user "practicalli",
    :scm/domain "github.com",
    :raw-name "practicalli.gameboard/service",
    :scm/user "practicalli.gameboard"}}

  ;; Example `data` passed to `template-fn`
  {:artifact/id "service",
   :now/year "2023",
   :top "practicalli.gameboard",
   :name "practicalli.gameboard/service",
   :now/date "2023-03-31",
   :template "practicalli.template/service",
   :group/id "practicalli.gameboard",
   :target-dir "gameboard",
   :template-dir
   "/home/practicalli/projects/practicalli/project-templates/resources/practicalli/service",
   :developer "Practicalli",
   :version "0.1.0-SNAPSHOT",
   :main "service",
   :scm/repo "service",
   :user "practicalli",
   :scm/domain "github.com",
   :raw-name "practicalli.gameboard/service",
   :scm/user "practicalli.gameboard"}

  ;; Example `edn` passed to `template-fn`
  {:description "TODO: Provide a meaningful description of the project",
   :transform
   [["build"
     ""
     {"build.clj.template" "build.clj", "deps.edn.template" "deps.edn"}]
    ["src"
     "src/{{top/file}}"
     {"service.clj.template" "{{main/file}}.clj"}]
    ["test"
     "test/{{top/file}}"
     {"service_test.clj.template" "{{main/file}}_test.clj"}]],
   :kaocha-version "1.80.1274",
   :data-fn practicalli.template.service/data-fn,
   :template-fn practicalli.template.service/template-fn,
   :clojure-cli-version "1.11.1",
   :mulog-version "0.9.0",
   :tools-build-tag "v0.9.4",
   :tools-build-sha "76b78fe"}

  #_()) ;; End of rich comment
