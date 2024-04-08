;; ---------------------------------------------------------
;; Mulog Global Context and Custom Publisher
;;
;; - tap publisher for use with Portal and other tap sources
;; - publish all mulog events to Portal tap source
;;
;; NOTE: Mulog global context set in system configuration
;; ---------------------------------------------------------

(ns mulog-events
  (:require
   [com.brunobonacci.mulog        :as mulog]
   [com.brunobonacci.mulog.buffer :as mulog-buffer]))

;; ---------------------------------------------------------
;; Mulog event publishing

(deftype TapPublisher
         [buffer transform]
  com.brunobonacci.mulog.publisher.PPublisher
  (agent-buffer [_] buffer)
  (publish-delay [_] 200)
  (publish [_ buffer]
    (doseq [item (transform (map second (mulog-buffer/items buffer)))]
      (tap> item))
    (mulog-buffer/clear buffer)))

#_{:clj-kondo/ignore [:unused-private-var]}
(defn ^:private tap-events
  [{:keys [transform] :as _config}]
  (TapPublisher. (mulog-buffer/agent-buffer 10000) (or transform identity)))

(def tap-publisher
  "Start mulog custom tap publisher to send all events to Portal
  and other tap sources
  `mulog-tap-publisher` to stop publisher"
  (mulog/start-publisher!
   {:type :custom, :fqn-function "mulog-events/tap-events"}))

#_{:clj-kondo/ignore [:unused-public-var]}
(defn stop
  "Stop mulog tap publisher to ensure multiple publishers are not started
 Recommended before using `(restart)` or evaluating the `user` namespace"
  []
  tap-publisher)

;; Example mulog event message
;; (mulog/log ::dev-user-ns :message "Example event message" :ns (ns-publics *ns*))
;; ---------------------------------------------------------
