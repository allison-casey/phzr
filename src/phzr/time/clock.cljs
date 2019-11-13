(ns phzr.time.clock
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Clock
  "  Parameters:
    * scene (Phaser.Scene) - The Scene which owns this Clock."
  ([scene]
   (js/Phaser.Time.Clock. (clj->phaser scene))))

(defn add-event
  "Creates a Timer Event and adds it to the Clock at the start of the frame.

  Parameters:
    * clock (Phaser.Time.Clock) - Targeted instance for method
    * config (Phaser.Types.Time.TimerEventConfig) - The configuration for the Timer Event.

  Returns:  Phaser.Time.TimerEvent - The Timer Event which was created."
  ([clock config]
   (phaser->clj
    (.addEvent clock
               (clj->phaser config)))))

(defn clear-pending-events
  "Clears and recreates the array of pending Timer Events.

  Returns:  Phaser.Time.Clock - This Clock object."
  ([clock]
   (phaser->clj
    (.clearPendingEvents clock))))

(defn delayed-call
  "Creates a Timer Event and adds it to the Clock at the start of the frame.

  This is a shortcut for {@link #addEvent} which can be shorter and is compatible with the syntax of the GreenSock Animation Platform (GSAP).

  Parameters:
    * clock (Phaser.Time.Clock) - Targeted instance for method
    * delay (number) - The delay of the function call, in milliseconds.
    * callback (function) - The function to call after the delay expires.
    * args (Array.<*>) - The arguments to call the function with.
    * callback-scope (*) - The scope (`this` object) to call the function with.

  Returns:  Phaser.Time.TimerEvent - The Timer Event which was created."
  ([clock delay callback args callback-scope]
   (phaser->clj
    (.delayedCall clock
                  (clj->phaser delay)
                  (clj->phaser callback)
                  (clj->phaser args)
                  (clj->phaser callback-scope)))))

(defn pre-update
  "Updates the arrays of active and pending Timer Events. Called at the start of the frame.

  Parameters:
    * clock (Phaser.Time.Clock) - Targeted instance for method
    * time (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([clock time delta]
   (phaser->clj
    (.preUpdate clock
                (clj->phaser time)
                (clj->phaser delta)))))

(defn remove-all-events
  "Schedules all active Timer Events for removal at the start of the frame.

  Returns:  Phaser.Time.Clock - This Clock object."
  ([clock]
   (phaser->clj
    (.removeAllEvents clock))))

(defn update
  "Updates the Clock's internal time and all of its Timer Events.

  Parameters:
    * clock (Phaser.Time.Clock) - Targeted instance for method
    * time (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([clock time delta]
   (phaser->clj
    (.update clock
             (clj->phaser time)
             (clj->phaser delta)))))