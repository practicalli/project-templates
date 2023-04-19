;; ---------------------------------------------------------
;; Mulog Custom Publishers
;;
;; - tap publisher for use with Portal and other tap sources
;; ---------------------------------------------------------


(ns mulog-publisher
  (:require
   [com.brunobonacci.mulog.buffer :as mulog-buffer]))

(deftype TapPublisher [buffer transform]
  com.brunobonacci.mulog.publisher.PPublisher
  (agent-buffer [_] buffer)

  (publish-delay [_] 200)

  (publish [_ buffer]
    (doseq [item (transform (map second (mulog-buffer/items buffer)))]
      (tap> item))
    (mulog-buffer/clear buffer)))

#_{:clj-kondo/ignore [:clojure-lsp/unused-public-var]}
(defn tap
  [{:keys [transform] :as _config}]
  (TapPublisher. (mulog-buffer/agent-buffer 10000) (or transform identity)))
