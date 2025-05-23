;; ---------------------------------------------------------
;; REPL workflow development tools
;;
;; Include development tool libraries vai aliases from practicalli/clojure-cli-config
;; Start Rich Terminal UI REPL prompt:
;; `clojure -M:repl/reloaded`
;;
;; Or call clojure jack-in from an editor to start a repl
;; including the `:dev/reloaded` alias
;; - alias included in the Emacs `.dir-locals.el` file
;; ---------------------------------------------------------

#_{:clj-kondo/ignore [:unused-namespace :unused-referred-var]}
(ns user
  "Tools for REPL Driven Development"
  (:require
   ;; Service
   [system-repl
    :refer
    [config restart restart-all start stop system]]  ; System component commands

   ;; REPL Workflow
   [portal]                                ; launch portal instance
   [portal.api :as inspect]                ; inspect tools
   [clojure.tools.namespace.repl
    :refer [set-refresh-dirs]]

   ;; Logging
   [com.brunobonacci.mulog :as mulog]      ; Event Logging
   [mulog-events]))                        ; Global context & Tap publisher

;; ---------------------------------------------------------
;; Help

(println "---------------------------------------------------------")
(println "Loading custom user namespace tools...")
(println "---------------------------------------------------------")

(defn help
  "Print help menu for REPL session"
  []
  (println "---------------------------------------------------------")
  (println "System components:")
  (println "(start)                        ; starts all components in system config")
  (println "(restart)                      ; read system config, reloads changed namespaces & restarts system")
  (println "(restart-all)                  ; as above with all namespaces reloaded")
  (println "(stop)                         ; shutdown all components in the system")
  (println "(system)                       ; show configuration of the running system")
  (println "(config)                       ; show system configuration")
  (println)
  (println "Hotload libraries:             ; Clojure 1.12.x")
  (println "(add-lib 'library-name)")
  (println "(add-libs '{domain/library-name {:mvn/version \"v1.2.3\"}})")
  (println "(sync-deps)                    ; load dependencies from deps.edn")
  (println "- deps-* lsp snippets for adding library")
  (println)
  (println "Portal Inspector:")
  (println "- portal started by default, listening to all evaluations")
  (println "(inspect/clear)                ; clear all values in portal")
  (println "(remove-tap #'inspect/submit)  ; stop sending to portal")
  (println "(inspect/close)                ; close portal")
  (println)
  (println "Mulog Publisher:")
  (println "- mulog publisher started by default")
  (println "(mulog-events/stop)            ; stop publishing log events")
  (println)
  (println "(help)                         ; print help text")
  (println "---------------------------------------------------------"))

(help)

;; End of Help
;; ---------------------------------------------------------

;; ---------------------------------------------------------
;; Avoid reloading `dev` code
;; - code in `dev` directory should be evaluated if changed to reload into repl
(println
 "Set Integrant REPL refresh directories to "
 (set-refresh-dirs "src" "resources"))
;; ---------------------------------------------------------

;; ---------------------------------------------------------
;; Mulog event logging
;; `mulog-publisher` namespace used to launch tap> events to tap-source (portal)

;; set event global context - information added to every event for REPL workflow
(mulog/set-global-context! {:app-name "{{main/ns}} Service",
                            :version "0.1.0", :env "dev"})

;; Example mulog event message
(mulog/log ::dev-user-ns ::ns (ns-publics *ns*))
;; ---------------------------------------------------------

;; ---------------------------------------------------------
;; Hotload libraries into running REPL
;; `deps-*` LSP snippets to add dependency forms
(comment
  ;; Require for Clojure 1.11.x and earlier
  (require '[clojure.tools.deps.alpha.repl :refer [add-libs]])
  (add-libs '{domain/library-name {:mvn/version "1.0.0"}})

  ;; Clojure 1.12.x only
  #_(add-lib 'library-name)   ; find and add library
  #_(sync-deps)               ; load dependencies in deps.edn (if not yet loaded)
  #_()) ; End of rich comment
;; ---------------------------------------------------------

;; ---------------------------------------------------------
;; Portal Data Inspector
(comment
  ;; Open a portal inspector in browser window - light theme
  ;; (inspect/open {:portal.colors/theme :portal.colors/solarized-light})

  (inspect/clear) ; Clear all values in portal window (allows garbage collection)

  (remove-tap #'inspect/submit) ; Remove portal from `tap>` sources

  (mulog-events/stop) ; stop tap publisher

  (inspect/close) ; Close the portal window

  (inspect/docs) ; View docs locally via Portal

  #_()) ; End of rich comment

;; ---------------------------------------------------------
