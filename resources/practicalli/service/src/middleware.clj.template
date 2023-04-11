(ns {{top/ns}}.{{main/ns}}.middleware
  (:require
   [com.brunobonacci.mulog :as mulog]))


;; --------------------------------------------------
;; Logging middleware
;; https://github.com/BrunoBonacci/mulog/blob/master/doc/ring-tracking.md


(defn wrap-trace-events
  "Log event trace for each api event with mulog/log."
  [handler id]
  (fn [request]
    ;; Add context of each request to all trace events generated for the specific request
    (mulog/with-context
     {:uri            (get request :uri)
      :request-method (get request :request-method)}

     ;; track the request duration and outcome
     (mulog/trace :io.redefine.datawarp/http-request
                  ;; add key/value pairs for tracking event only
                  {:pairs [:content-type     (get-in request [:headers "content-type"])
                           :content-encoding (get-in request [:headers "content-encoding"])
                           :middleware       id]
                   ;; capture http status code from the response
                   :capture (fn [{:keys [status]}] {:http-status status})}

                  ;; call the request handler
                  (handler request)))))

;; --------------------------------------------------
