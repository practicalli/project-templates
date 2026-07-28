;; ---------------------------------------------------------
;; {{top/ns}}.data
;;
;; Data used to generate components that make up the main page
;; ---------------------------------------------------------

(ns {{top/ns}}.data)

(def assets
  "Information used to generate content, enabling use across multiple components
  and avoiding hard-coded component data"
  {:organisation {:logo "https://placehold.co/120x120/EEE/31343C?font=open-sans&text=logo"
                  :banner "https://placehold.co/820x200/EEE/31343C?font=open-sans&text=Clojure"
                  :website "https://practical.li"
                  :status "https://status.practical.li/"
                  :repository "https://github.com/{{developer}}"}

   :catalog
   [{:name "Practicalli Clojure"
     :description "Clojure development workflow and tools"
     :reference "https://practical.li/clojure"
     :image "https://placehold.co/640x400/EEE/31343C?font=open-sans&text=Clojure"}
    {:name "Practicalli ClojureScript"
     :description "Learn ClojureScript the practical way"
     :reference "https://practical.li/clojurescript"
     :image "https://placehold.co/640x400/EEE/31343C?font=open-sans&text=ClojureScript"}]

   :support
   {:youtube-subscribe
    {:url "https://www.youtube.com/practicalli?sub_confirmation=1"
     :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/buttons/practicalli-youtube-channel-subscribe-button.png"}

    :github-sponsors
    {:url  "https://github.com/sponsors/{{developer}}/"
     :logo "https://raw.githubusercontent.com/practicalli/graphic-design/live/buttons/practicalli-github-sponsors-button.png"}}})
