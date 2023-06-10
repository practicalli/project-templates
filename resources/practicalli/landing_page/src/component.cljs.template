;; ---------------------------------------------------------
;; {{top/ns}}.component
;;
;; A function generates a page component which is assembled by the main page
;; The main page calls a function with specific data to generate the component
;; ---------------------------------------------------------

(ns {{top/ns}}.component)


;; ---------------------------------------------------------
;; Helper functions

(defn separator
  "A separator to provide a gap between components.
  Each separator has an id which is used to jump to that section,
  ensuring the top of the component is not hidden by the navigation bar"
  [identifier]
  [:div {:class "level"
         :id    identifier}
   [:h5 {:class "is-size-5 is-invisible"}
    identifier]])

;; End of Helper functions
;; ---------------------------------------------------------

;; ---------------------------------------------------------
;; Component functions

(defn navigation
  [web-assets]
  [:nav {:class "navbar is-fixed-top is-info"
         :role "navigation"
         :aria-label "main navigation"}
   ;; Layout menu with margins to match all other content
   [:div {:class "container"}
    [:div {:class "navbar-brand"}
     [:a {:class "navbar-item"
          :href  "/"}
      [:img {:src (web-assets :logo)}]]
     [:span {:class       "navbar-burger burger"
             :data-target "navbarPracticalli"}
      ;; Empty spans needed for navbar burger
      [:span] [:span] [:span]]]
    [:div {:id    "navbarPracticalli"
           :class "navbar-menu"}
     [:div {:class "navbar-start"}

      [:a {:class "navbar-item"
           :href  "/blog/"} "Blog"]

      [:a {:class "navbar-item"
           :href  "#catalog"} "Catalog"]

      [:a {:class "navbar-item"
           :href  "#contact"} "Contact"]

      [:a {:class "navbar-item"
           :href  "#support"} "Support"]

      [:a {:class "navbar-item"
           :href  "#resources"} "Resources"]]

     [:div {:class "navbar-end"}

      [:a {:class "navbar-item has-text-weight-bold"
           :href  (web-assets :status)
           :target "_blank"} "Status"]

      [:span {:class "navbar-item"}
       [:a {:class  "button is-inverted"
            :target "_blank"
            :href   (web-assets :repository)}
        [:span {:class "icon"}
         [:i {:class "fab fa-github"}]]
        [:span "Issues/PRs"]]]]]]])


(defn title-banner
  "Top banner and navigation for the website"
  [web-assets]
  [:section {:class "section"}
   [:div {:class "container"}
    [:div {:class "columns is-vcentered"}

     [:div {:class "column is-2 is-offset-1"}
      [:img {:src   (-> web-assets :landing-page :logo)
             :width "160px"}]]

     [:div {:class "column"}
      [:h1 {:class "title is-1"}
       "Practicalli"]
      [:h3 {:class "subtitle"}
       "Practical approaches to learning Functional Programming with Clojure"]
      [:h4 {:class "subtitle"}
       "(-> idea :learn :design :document :code :test :deploy)"]
      [:div {:div "content"}
       "Getting started with Clojure programming via YouTube broadcasts, screencasts and books. Learn how to "
       [:a {:href "https://practicalli.github.io/clojure/clojure-cli/"}
        "use Clojure CLI tools"]
       " to create and develop Clojure projects.  Follow guides to install and get started with "
       [:a {:href "https://practicalli.github.io/clojure/clojure-editors/"}
        "Clojure aware editors"]
       "."]]]]])

(defn item
  "Visualisation of an item in the catalog"
  [data]
  data)

(defn catalog
  "Catalog of items in a carousel"
  [data]
  data)


(defn support
  "Ways in which you can contact {{top/ns}}"
  [support-channels]
  [:div {:class "container"}
   [:div {:class "box"}
    [:h2 {:class "title has-text-centered"}
     "Support"]
    [:div {:class "columns"}

     [:div {:class "column"}
      [:a {:href   (-> support-channels :youtube-subscribe :url)
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (-> support-channels :youtube-subscribe :logo)}]]]
      [:p {:class "has-text-centered"}
       "Subscribe and share free video tutorials"]]

     [:div {:class "column"}
      [:a {:href   (-> support-channels :github-sponsors :url)
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (-> support-channels :github-sponsors :logo)}]]]

      [:p {:class "has-text-centered"}
       "Join the many sponsors via GitHub"]]

     [:div {:class "column"}
      [:a {:href   (-> support-channels :paypal-me :url)
           :target "_blank"}
       [:figure {:class "image"}
        [:img {:src (-> support-channels :paypal-me :logo)}]]]

      [:p {:class "has-text-centered"}
       "Direct Contributions in any currency"]]

     ]]])


(defn resources
  "Useful resources for learning and practicing Clojure"
  []
  [:div {:class "container"}
   [:div {:class "box"}
    [:div {:class "columns"}

     [:div {:class "column"}
      [:h4 {:class "title is-4"} "Discovering Clojure"]
      [:table {:class "table"}
       [:tbody
        [:tr
         [:th
          [:a {:href "https://clojuredocs.org/" :target "_blank"} "Clojure docs"]]
         [:td "docs for functions"]]
        [:tr
         [:th
          [:a {:href "https://clojure.org/" :target "_blank"} "Clojure.org"]]
         [:td "language and concepts"]]
        [:tr
         [:th
          [:a {:href "https://cljdoc.org/" :target "_blank"} "CljDocs"]]
         [:td "search library docs"]]
        [:tr
         [:th
          [:a {:href "https://borkdude.github.io/re-find.web/" :target "_blank"} "re-find"]]
         [:td "suggest Clojure function from args & return value"]]
        [:tr
         [:th
          [:a {:href "https://clojuredesign.club/" :target "_blank"} "Clojure Design Club"]]
         [:td "podcast discussing Clojure design"]]]]]


     [:div {:class "column"}
      [:h4 {:class "title is-4"} "Practicing Clojure"]
      [:table {:class "table"}
       [:tbody
        [:tr
         [:th
          [:a {:href "https://4clojure.oxal.org/" :target "_blank"} "4Ever-Clojure"]]
         [:td "learn Clojure functions"]]
        [:tr
         [:th
          [:a {:href "https://exercism.io/tracks/clojure" :target "_blank"} "Exercism"]]
         [:td "code practice & mentorship"]]
        [:tr
         [:th
          [:a {:href "https://www.codingame.com/" :target "_blank"} "CodinGame"]]
         [:td "practice & learn the fun way"]]]]]

     [:div {:class "column"}
      [:h4 {:class "title is-4"} "Clojure ebooks"]
      [:table {:class "table"}
       [:tbody
        [:tr
         [:th
          [:a {:href "https://github.com/clojure-cookbook/clojure-cookbook"
               :target "_blank"} "Clojure Cookbook"]]]
        [:tr
         [:th
          [:a {:href "http://practical.li/clojure" :target "_blank"} "Practicalli Clojure"]]]
        [:tr
         [:th
          [:a {:href "http://practical.li/clojure-web-services" :target "_blank"} "Practicalli Clojure Web Services"]]]
        [:tr
         [:th
          [:a {:href "http://funcool.github.io/clojurescript-unraveled/" :target "_blank"} "ClojureScript Unraveled"]]]
        [:tr
         [:th
          [:a {:href "https://www.braveclojure.com/clojure-for-the-brave-and-true/" :target "_blank"} "Brave Clojure"]]]]]]

     [:div {:class "column"}
      [:h4 {:class "title is-4"} "Clojure Videos"]
      [:table {:class "table"}
       [:tbody
        [:tr
         [:th
          [:a {:href "https://www.youtube.com/watch?v=9A9qsaZZefw&list=PLAC43CFB134E85266" :target "_blank"} "Clojure Language Overview"]]
         [:td "describing language concepts"]]
        [:tr
         [:th
          [:a {:href "https://www.youtube.com/playlist?list=PLpr9V-R8ZxiDjyU7cQYWOEFBDR1t7t0wv" :target "_blank"} "Practising Clojure"]]
         [:td "100+ hours of Clojure coding"]]
        [:tr
         [:th
          [:a {:href "http://www.parens-of-the-dead.com/" :target "_blank"} "Parens of the dead"]]
         [:td "REPL driven development of a card game"]]
        [:tr
         [:th
          [:a {:href "https://www.youtube.com/user/ClojureTV" :target "_blank"} "Clojure TV"]]
         [:td "conference talks"]]
        ]]]]]])

;; End of Component functions
;; ---------------------------------------------------------
