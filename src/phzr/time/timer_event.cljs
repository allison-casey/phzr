(ns phzr.time.timer-event
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove]))

(defn ->TimerEvent
  "  Parameters:
    * config (Phaser.Types.Time.TimerEventConfig) - The configuration for the Timer Event, including its delay and callback."
  ([config]
   (js/Phaser.Time.TimerEvent. (clj->phaser config))))

(defn destroy
  "Destroys all object references in the Timer Event, i.e. its callback, scope, and arguments.

  Normally, this method is only called by the Clock when it shuts down. As such, it doesn't stop the Timer Event. If called manually, the Timer Event will still be updated by the Clock, but it won't do anything when it fires."
  ([timer-event]
   (phaser->clj
    (.destroy timer-event))))

(defn get-elapsed
  "Returns the local elapsed time for the current iteration of the Timer Event.

  Returns:  number - The local elapsed time in milliseconds."
  ([timer-event]
   (phaser->clj
    (.getElapsed timer-event))))

(defn get-elapsed-seconds
  "Returns the local elapsed time for the current iteration of the Timer Event in seconds.

  Returns:  number - The local elapsed time in seconds."
  ([timer-event]
   (phaser->clj
    (.getElapsedSeconds timer-event))))

(defn get-overall-progress
  "Gets the progress of the timer overall, factoring in repeats.

  Returns:  number - The overall progress of the Timer Event, between 0 and 1."
  ([timer-event]
   (phaser->clj
    (.getOverallProgress timer-event))))

(defn get-progress
  "Gets the progress of the current iteration, not factoring in repeats.

  Returns:  number - A number between 0 and 1 representing the current progress."
  ([timer-event]
   (phaser->clj
    (.getProgress timer-event))))

(defn get-repeat-count
  "Returns the number of times this Timer Event will repeat before finishing.

  This should not be confused with the number of times the Timer Event will fire before finishing. A return value of 0 doesn't indicate that the Timer Event has finished running - it indicates that it will not repeat after the next time it fires.

  Returns:  number - How many times the Timer Event will repeat."
  ([timer-event]
   (phaser->clj
    (.getRepeatCount timer-event))))

(defn remove
  "Forces the Timer Event to immediately expire, thus scheduling its removal in the next frame.

  Parameters:
    * timer-event (Phaser.Time.TimerEvent) - Targeted instance for method
    * dispatch-callback (boolean) {optional} - If `true`, the function of the Timer Event will be called before its removal."
  ([timer-event]
   (phaser->clj
    (.remove timer-event)))
  ([timer-event dispatch-callback]
   (phaser->clj
    (.remove timer-event
             (clj->phaser dispatch-callback)))))

(defn reset
  "Completely reinitializes the Timer Event, regardless of its current state, according to a configuration object.

  Parameters:
    * timer-event (Phaser.Time.TimerEvent) - Targeted instance for method
    * config (Phaser.Types.Time.TimerEventConfig) - The new state for the Timer Event.

  Returns:  Phaser.Time.TimerEvent - This TimerEvent object."
  ([timer-event config]
   (phaser->clj
    (.reset timer-event
            (clj->phaser config)))))