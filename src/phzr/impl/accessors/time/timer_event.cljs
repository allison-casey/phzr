(ns phzr.impl.accessors.time.timer-event)

(def timer-event-get-properties
  {:args "args"
   :callback "callback"
   :callback-scope "callbackScope"
   :delay "delay"
   :elapsed "elapsed"
   :has-dispatched "hasDispatched"
   :loop "loop"
   :paused "paused"
   :repeat "repeat"
   :repeat-count "repeatCount"
   :start-at "startAt"
   :time-scale "timeScale"})

(def timer-event-set-properties
  {:args "args"
   :callback "callback"
   :callback-scope "callbackScope"
   :elapsed "elapsed"
   :has-dispatched "hasDispatched"
   :paused "paused"
   :repeat-count "repeatCount"
   :start-at "startAt"
   :time-scale "timeScale"})