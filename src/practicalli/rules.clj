;; ---------------------------------------------------------
;; Declarative rule sets for deps-new templates
;;
;; Pre-defined rule sets returned by `template-edn` function,
;; based on command line options passed when creating a new project
;; ---------------------------------------------------------

(ns practicalli.rules
  "Declarative rule sets for template options")

;; ---------------------------------------------------------
;; Service rules

(def base
  "Common declarative rules for all templates"
  [["api" "src/{{top/file}}/{{main/file}}/api"
    {"system_admin.clj.template" "system_admin.clj"
     "scoreboard.clj.template" "scoreboard.clj"}]
   ["build" ""
    {"build.clj.template" "build.clj"
     "deps_donut.edn.template"  "deps.edn"}
    :only]
   ["dev" "dev"
    {"mulog.clj" "mulog.clj"
     "portal.clj" "portal.clj"
     "user.clj" "user.clj"}
    :only]
   ["docker" ""
    {"compose-service.yaml.template" "compose.yaml"
     "compose-service-postgres.yaml.template"  "compose-service-postgres.yaml"
     "Dockerfile.template" "Dockerfile"}]
   ["src" "src/{{top/file}}/{{main/file}}"
    {"middleware.clj.template" "middleware.clj"
     "router_config.clj.template" "router.clj"
     "service_donut.clj.template" "service.clj"
     "spec.clj.template" "spec.clj"
     "system_donut.clj.template" "system.clj"}
    :only]
   ["test" "test/{{top/file}}/{{main/file}}"
    {"service_test.clj.template" "service_test.clj"}]])

(def donut
  "Practicalli Service template with `:component :donut` option"
  [["api" "src/{{top/file}}/{{main/file}}/api"
    {"system_admin.clj.template" "system_admin.clj"
     "scoreboard_config.clj.template" "scoreboard.clj"}]
   ["build" ""
    {"build.clj.template" "build.clj"
     "deps_donut.edn.template"  "deps.edn"}
    :only]
   ["dev" "dev"
    {"mulog_events.clj" "mulog_events.clj"
     "portal.clj" "portal.clj"
     "system_repl_donut.clj.template" "system_repl.clj"
     "user_donut.clj" "user.clj"}
    :only]
   ["docker" ""
    {"compose-service.yaml.template" "compose.yaml"
     "compose-service-postgres.yaml.template"  "compose-service-postgres.yaml"
     "Dockerfile.template" "Dockerfile"}]
   ["resources" ""
    {"config_donut_env.edn.template" "config_donut_env.edn"}
    :only]
   ["src" "src/{{top/file}}/{{main/file}}"
    {"middleware.clj.template" "middleware.clj"
     "router_config.clj.template" "router.clj"
     "service_donut.clj.template" "service.clj"
     "spec.clj.template" "spec.clj"
     "system_donut.clj.template" "system.clj"}
    :only]
   ["test" "test/{{top/file}}/{{main/file}}"
    {"service_test.clj.template" "service_test.clj"}]])

(def integrant
  "Practicalli Service template with `:component :integrant` option"
  [["api" "src/{{top/file}}/{{main/file}}/api"
    {"system_admin.clj.template" "system_admin.clj"
     "scoreboard_config.clj.template" "scoreboard.clj"}]
   ["build" ""
    {"build.clj.template" "build.clj"
     "deps_integrant.edn.template"  "deps.edn"}
    :only]
   ["dev" "dev"
    {"mulog_events.clj" "mulog_events.clj"
     "portal.clj" "portal.clj"
     "system_repl_integrant.clj.template" "system_repl.clj"
     "user_integrant.clj" "user.clj"}
    :only]
   ["docker" ""
    {"compose-service.yaml.template" "compose.yaml"
     "compose-service-postgres.yaml.template"  "compose-service-postgres.yaml"
     "Dockerfile.template" "Dockerfile"}]
   ["resources" "resources"
    {"config_integrant.edn.template" "config.edn"}
    :only]
   ["src" "src/{{top/file}}/{{main/file}}"
    {"middleware.clj.template" "middleware.clj"
     "parse_system_integrant.clj.template" "parse_system.clj"
     "router_config.clj.template" "router.clj"
     "service_integrant.clj.template" "service.clj"
     "spec.clj.template" "spec.clj"
     "system_integrant.clj.template" "system.clj"}
    :only]
   ["test" "test/{{top/file}}/{{main/file}}"
    {"service_test.clj.template" "service_test.clj"}]])

;; End of Service rules
;; ---------------------------------------------------------

(comment

;;   (defn merge-ruleset
;;     "Merges two rule sets together"
;;     []
;;     (let [merged []
;;           rules (into [] (comp cat (map first) (distinct)) [col [x]])]
;;       (into [] mapcat merged) rules))
;;
;;   (let [col [["src" "src/top/main" {"service.clj.template" "service.clj"}]
;;              ["dev" "" {"user_donut.clj" "user.clj"}]]
;;         x   ["dev" "" {"mulog.clj" "mulog.clj"}]
;;         ks (into [] (comp cat (map first) (distinct)) [col [x]])
;;         mrg (fn [& fns]
;;               (fn [[a] [b]]
;;                 [(mapv #(%1 %2 %3) fns a b)]))
;;         m (->> col
;;                (group-by first)
;;                (merge-with (mrg #(first %&) str merge) {(first x) [x]}))]
;;     (into [] (mapcat m) ks))
;; ;; [["src" "src/top/main" {"service.clj.template" "service.clj"}]
;; ;;  ["dev" "" {"mulog.clj" "mulog.clj", "user_donut.clj" "user.clj"}]]
;;
;;   (let [col [["src" "src/top/main" {"service.clj.template" "service.clj"}
;;               ["dev" "" {"user_donut.clj" "user.clj"}]]]
;;         x   ["dev" "" {"mulog.clj" "mulog.clj"}]
;;         key-func (juxt first second)
;;         mrg (fn [& fns]
;;               (fn [[a] [b]]
;;                 [(mapv #(%1 %2 %3) fns a b)]))
;;         m (->> col
;;                (group-by key-func)
;;                (merge-with (mrg #(first %&) #(first %&) merge) {(key-func x) [x]}))]
;;     (into [] (comp cat (map key-func) (distinct) (mapcat m)) [col [x]])))

  (merge
   {"user_donut.clj" "user.clj"}
   {"mulog.clj" "mulog.clj"})
;; {"user_donut.clj" "user.clj", "mulog.clj" "mulog.clj"}

  (merge-with merge
              ["src" "src/top/main" {"service.clj.template" "service.clj"}
               ["dev" "" {"user_donut.clj" "user.clj"}]]
              ["dev" "" {"mulog.clj" "mulog.clj"}])

  (merge-with merge
              {"src" {"service.clj.template" "service.clj"}}
              {"dev" {"user_donut.clj" "user.clj"}}
              {"dev" {"mulog.clj" "mulog.clj"}})
;; {"src" {"service.clj.template" "service.clj"},
;;  "dev" {"user_donut.clj" "user.clj", "mulog.clj" "mulog.clj"}}

  (conj
   [["src" "src/top/main" {"service.clj.template" "service.clj"}]
    ["dev" "" {"user_donut.clj" "user.clj"}]]
   ["dev" "" {"mulog.clj" "mulog.clj"}])
;;[["src" "src/top/main" {"service.clj.template" "service.clj"}]
;; ["dev" "" {"user_donut.clj" "user.clj"}]
;; ["dev" "" {"mulog.clj" "mulog.clj"}]]

  (into
   [["dev" "" {"mulog.clj" "mulog.clj"}]]
   [["src" "src/top/main" {"service.clj.template" "service.clj"}]
    ["dev" "" {"user_donut.clj" "user.clj"}]])
;;[["dev" "" {"mulog.clj" "mulog.clj"}]
;; ["src" "src/top/main" {"service.clj.template" "service.clj"}]
;; ["dev" "" {"user_donut.clj" "user.clj"}]]

  (into
   [["src" "src/top/main" {"service.clj.template" "service.clj"}]
    ["dev" "" {"user_donut.clj" "user.clj"}]]
   [["dev" "" {"mulog.clj" "mulog.clj"}]])
;;[["src" "src/top/main" {"service.clj.template" "service.clj"}]
;; ["dev" "" {"user_donut.clj" "user.clj"}]
;; ["dev" "" {"mulog.clj" "mulog.clj"}]]

  (into
   [["src" "src/top/main" {"service.clj.template" "service.clj"}]
    ["dev" "" {"user_donut.clj" "user.clj"}]]
   ["dev" "" {"mulog.clj" "mulog.clj"}])
;;[["src" "src/top/main" {"service.clj.template" "service.clj"}]
;; ["dev" "" {"user_donut.clj" "user.clj"}]
;; "dev"
;; ""
;; {"mulog.clj" "mulog.clj"}]

  (assoc
   [["src" "src/top/main" {"service.clj.template" "service.clj"}]
    ["dev" "" {"user_donut.clj" "user.clj"}]]
   "dev" {"mulog.clj" "mulog.clj"})

  (conj
   []
   ["dev" "" {"user_donut.clj" "user.clj"}]
   ["dev" "" {"mulog.clj" "mulog.clj"}])
;;[["dev" "" {"user_donut.clj" "user.clj"}]
;; ["dev" "" {"mulog.clj" "mulog.clj"}]]

  (["dev" "" {"user_donut.clj" "user.clj"}]
   ["dev" "" {"mulog.clj" "mulog.clj"}]))
