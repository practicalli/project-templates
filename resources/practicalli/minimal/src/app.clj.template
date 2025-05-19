;; ---------------------------------------------------------
;; {{top/ns}}.{{main/ns}}
;;
;; {{description}}
;; ---------------------------------------------------------

(ns {{top/ns}}.{{main/ns}}
  (:gen-class)
  (:require
   [com.brunobonacci.mulog :as mulog]))

;; ---------------------------------------------------------
;; Application

(defn greet
  "Greeting message via Clojure CLI clojure.exec"
  ([] (greet {:team-name "secret engineering"}))
  ([{:keys [team-name]}]
   (str "{{top/ns}} {{main/ns}} service developed by the " team-name " team")))


(defn -main
  "Entry point into the application via clojure.main -M"
  [& args]
  (let [team (first args)]
    (mulog/set-global-context!
     {:app-name "{{top/ns}} {{main/ns}}" :version  "{{version}}"})
    (mulog/log ::application-starup :arguments args)
    (if team
      (println (greet team))
      (println (greet)))))

;; ---------------------------------------------------------


;; ---------------------------------------------------------
;; Rick Comment
(comment

  (-main)
  (-main {:team-name "Clojure Engineering"})

  #_()) ; End of rich comment block
;; ---------------------------------------------------------
