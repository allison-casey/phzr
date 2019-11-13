(ns phzr.core.time-step
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->TimeStep
  "  Parameters:
    * game (Phaser.Game) - A reference to the Phaser.Game instance that owns this Time Step.
    * config (Phaser.Types.Core.FPSConfig) - No description"
  ([game config]
   (js/Phaser.Core.TimeStep. (clj->phaser game)
                             (clj->phaser config))))

(defn blur
  "Called by the Game instance when the DOM window.onBlur event triggers."
  ([time-step]
   (phaser->clj
    (.blur time-step))))

(defn destroy
  "Destroys the TimeStep. This will stop Request Animation Frame, stop the step, clear the callbacks and null
  any objects."
  ([time-step]
   (phaser->clj
    (.destroy time-step))))

(defn focus
  "Called by the Game instance when the DOM window.onFocus event triggers."
  ([time-step]
   (phaser->clj
    (.focus time-step))))

(defn get-duration
  "Gets the duration which the game has been running, in seconds.

  Returns:  number - The duration in seconds."
  ([time-step]
   (phaser->clj
    (.getDuration time-step))))

(defn get-duration-ms
  "Gets the duration which the game has been running, in ms.

  Returns:  number - The duration in ms."
  ([time-step]
   (phaser->clj
    (.getDurationMS time-step))))

(defn pause
  "Called when the visibility API says the game is 'hidden' (tab switch out of view, etc)"
  ([time-step]
   (phaser->clj
    (.pause time-step))))

(defn reset-delta
  "Resets the time, lastTime, fps averages and delta history.
  Called automatically when a browser sleeps them resumes."
  ([time-step]
   (phaser->clj
    (.resetDelta time-step))))

(defn resume
  "Called when the visibility API says the game is 'visible' again (tab switch back into view, etc)"
  ([time-step]
   (phaser->clj
    (.resume time-step))))

(defn sleep
  "Sends the TimeStep to sleep, stopping Request Animation Frame (or SetTimeout) and toggling the `running` flag to false."
  ([time-step]
   (phaser->clj
    (.sleep time-step))))

(defn start
  "Starts the Time Step running, if it is not already doing so.
  Called automatically by the Game Boot process.

  Parameters:
    * time-step (Phaser.Core.TimeStep) - Targeted instance for method
    * callback (Phaser.Types.Core.TimeStepCallback) - The callback to be invoked each time the Time Step steps."
  ([time-step callback]
   (phaser->clj
    (.start time-step
            (clj->phaser callback)))))

(defn step
  "The main step method. This is called each time the browser updates, either by Request Animation Frame,
  or by Set Timeout. It is responsible for calculating the delta values, frame totals, cool down history and more.
  You generally should never call this method directly."
  ([time-step]
   (phaser->clj
    (.step time-step))))

(defn stop
  "Stops the TimeStep running.

  Returns:  Phaser.Core.TimeStep - The TimeStep object."
  ([time-step]
   (phaser->clj
    (.stop time-step))))

(defn tick
  "Manually calls `TimeStep.step`."
  ([time-step]
   (phaser->clj
    (.tick time-step))))

(defn wake
  "Wakes-up the TimeStep, restarting Request Animation Frame (or SetTimeout) and toggling the `running` flag to true.
  The `seamless` argument controls if the wake-up should adjust the start time or not.

  Parameters:
    * time-step (Phaser.Core.TimeStep) - Targeted instance for method
    * seamless (boolean) {optional} - Adjust the startTime based on the lastTime values."
  ([time-step]
   (phaser->clj
    (.wake time-step)))
  ([time-step seamless]
   (phaser->clj
    (.wake time-step
           (clj->phaser seamless)))))