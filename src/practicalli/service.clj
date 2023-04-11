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
