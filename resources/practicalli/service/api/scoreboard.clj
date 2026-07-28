;; --------------------------------------------------
;; {{top/ns}}.{{main/ns}}.api.scoreboard
;;
;; Example route and handler function
;; using clojure.spec response validation
;; --------------------------------------------------


(ns {{top/ns}}.{{main/ns}}.api.scoreboard
  "Gameboard API Scoreboard across all games"
  (:require
   [ring.util.response :refer [response]]
   [clojure.spec.alpha :as spec]))


;; --------------------------------------------------
;; Value Specifications
(spec/def ::game-id string?)
(spec/def ::game-name string?)
(spec/def ::high-score string?)
;; --------------------------------------------------


;; --------------------------------------------------
;; Mock scores for the Gameboard service

(def scores
  "Simple status report for external monitoring services, e.g. Pingdom
  Return:
  - `constantly` returns an anonymous function that returns a ring response hash-map"
  (constantly (response {::game-id "347938472938439487492"
                         ::game-name "Polymous"
                         ::high-score "344398799666"})))
;; --------------------------------------------------


;; --------------------------------------------------
;; Routes

(defn routes
  "Reitit route configuration for scoreboard endpoints
  Responses validated with {{top/ns}}.{{main/ns}}.spec clojure.spec"
  []
  ["/scoreboard"
   {:swagger {:tags ["Scoreboard Endpoints"]}
    :get {:summary "Scoreboard across all games"
          :description "Return all the high scores for every game registered"
          :handler scores
          :responses
          {200
           {:body (spec/keys :req [::game-id ::game-name ::high-score])}}}}])
;; --------------------------------------------------
