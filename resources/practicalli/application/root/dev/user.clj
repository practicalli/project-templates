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


(ns user
  "Tools for REPL Driven Development"
  (:require
   ;; REPL Workflow
   [clojure.tools.namespace.repl :as namespace]

   ;; REPL Workflow
   [portal.api :as inspect]                          ; Data inspector

   ;; Logging
   [com.brunobonacci.mulog :as mulog]                ; Event Logging
   [mulog-publisher]                                 ; Tap mulog events
   ))

;; ---------------------------------------------------------
;; Help

(println "---------------------------------------------------------")
(println "Loading custom user namespace tools...")
(println "---------------------------------------------------------")

(defn help
  []
  (println "---------------------------------------------------------")
  (println "Namesapece Management:")
  (println "(namespace/refresh)            ; refresh all changed namespaces")
  (println "(namespace/refresh-all)        ; refresh all namespaces")
  (println)
  (println "Hotload libraries:             ; Clojure 1.12.x")
  (println "(add-lib 'library-name)")
  (println "(add-libs '{domain/library-name {:mvn/version \"v1.2.3\")")
  (println "(sync-deps)                    ; load dependencies from deps.edn")
  (println "- deps-* lsp snippets for adding library")
  (println)
  (println "Portal Inspector:")
  (println "- portal started by default, listening to all evaluations")
  (println "(inspect/clear)                ; clear all values in portal")
  (println "(remove-tap #'inspect/submit)  ; stop sending to portal")
  (println "(inspect/close)                ; close portal")
  (println)
  (println "(help)                         ; print help text")
  (println "---------------------------------------------------------"))

(help)

;; End of Help
;; ---------------------------------------------------------


;; ---------------------------------------------------------
;; Start Portal and capture all evaluation results

;; Open Portal window in browser with dark theme
;; https://cljdoc.org/d/djblue/portal/0.37.1/doc/ui-concepts/themes
(inspect/open {:portal.colors/theme :portal.colors/gruvbox})
;; (inspect/open {:portal.colors/theme :portal.colors/solarized-light})

;; Add portal as a tap> target and listen to all evaluation results (via nREPL)
(add-tap #'portal.api/submit)

;; ---------------------------------------------------------


;; ---------------------------------------------------------
;; Mulog events and publishing

;; set event global context - information added to every event for REPL workflow
(mulog/set-global-context! {:app-name "Practicalli Service",
                            :version "0.1.0", :env "dev"})

(def mulog-tap-publisher
  "Start mulog custom tap publisher to send all events to Portal
  and other tap sources
  `mulog-tap-publisher` to stop publisher"
  (mulog/start-publisher!
   {:type :custom, :fqn-function "mulog-publisher/tap"}))

(mulog/log ::emacs-event ::ns (ns-publics *ns*))

;; Stop mulog publisher
#_mulog-tap-publisher

;; ---------------------------------------------------------


;; ---------------------------------------------------------
;; Hotload libraries into running REPL
;; `deps-*` LSP snippets to add dependency forms
(comment
  ;; Require for Clojure 1.11.x and earlier
  (require '[clojure.tools.deps.alpha.repl :refer [add-libs]])

  (add-libs '{domain/library-name {:mvn/version "1.0.0"}})

  ;; Clojure 1.12.x only
  (add-lib 'library-name)   ; find and add library
  (sync-deps)               ; load dependencies in deps.edn (if not yet loaded)
  #_()) ; End of rich comment
;; ---------------------------------------------------------

;; ---------------------------------------------------------
;; Portal Data Inspector
(comment
  ;; Open a portal inspector in browser window - light theme
  ;; (inspect/open {:portal.colors/theme :portal.colors/solarized-light})

  (inspect/clear) ; Clear all values in portal window (allows garbage collection)

  (remove-tap #'inspect/submit) ; Remove portal from `tap>` sources

  (inspect/close) ; Close the portal window

  (inspect/docs) ; View docs locally via Portal

  #_()) ; End of rich comment

;; ---------------------------------------------------------
