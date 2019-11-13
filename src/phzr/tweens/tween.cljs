(ns phzr.tweens.tween
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove update]))

(defn ->Tween
  "  Parameters:
    * parent (Phaser.Tweens.TweenManager | Phaser.Tweens.Timeline) - A reference to the parent of this Tween. Either the Tween Manager or a Tween Timeline instance.
    * data (Array.<Phaser.Types.Tweens.TweenDataConfig>) - An array of TweenData objects, each containing a unique property to be tweened.
    * targets (array) - An array of targets to be tweened."
  ([parent data targets]
   (js/Phaser.Tweens.Tween. (clj->phaser parent)
                            (clj->phaser data)
                            (clj->phaser targets))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([tween event fn]
   (phaser->clj
    (.addListener tween
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([tween event fn context]
   (phaser->clj
    (.addListener tween
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn calc-duration
  "Internal method that calculates the overall duration of the Tween."
  ([tween]
   (phaser->clj
    (.calcDuration tween))))

(defn complete
  "Flags the Tween as being complete, whatever stage of progress it is at.

  If an onComplete callback has been defined it will automatically invoke it, unless a `delay`
  argument is provided, in which case the Tween will delay for that period of time before calling the callback.

  If you don't need a delay, or have an onComplete callback, then call `Tween.stop` instead.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * delay (number) {optional} - The time to wait before invoking the complete callback. If zero it will fire immediately.

  Returns:  this - This Tween instance."
  ([tween]
   (phaser->clj
    (.complete tween)))
  ([tween delay]
   (phaser->clj
    (.complete tween
               (clj->phaser delay)))))

(defn destroy
  "Removes all listeners."
  ([tween]
   (phaser->clj
    (.destroy tween))))

(defn dispatch-tween-data-event
  "Internal method that will emit a TweenData based Event and invoke the given callback.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (Phaser.Types.Tweens.Event) - The Event to be dispatched.
    * callback (function) - The callback to be invoked. Can be `null` or `undefined` to skip invocation.
    * tween-data (Phaser.Types.Tweens.TweenDataConfig) - The TweenData object that caused this event."
  ([tween event callback tween-data]
   (phaser->clj
    (.dispatchTweenDataEvent tween
                             (clj->phaser event)
                             (clj->phaser callback)
                             (clj->phaser tween-data)))))

(defn dispatch-tween-event
  "Internal method that will emit a Tween based Event and invoke the given callback.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (Phaser.Types.Tweens.Event) - The Event to be dispatched.
    * callback (function) - The callback to be invoked. Can be `null` or `undefined` to skip invocation."
  ([tween event callback]
   (phaser->clj
    (.dispatchTweenEvent tween
                         (clj->phaser event)
                         (clj->phaser callback)))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([tween event]
   (phaser->clj
    (.emit tween
           (clj->phaser event))))
  ([tween event args]
   (phaser->clj
    (.emit tween
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([tween]
   (phaser->clj
    (.eventNames tween))))

(defn get-time-scale
  "Returns the scale of the time applied to this Tween.

  Returns:  number - The timescale of this tween (between 0 and 1)"
  ([tween]
   (phaser->clj
    (.getTimeScale tween))))

(defn get-value
  "Returns the current value of the specified Tween Data.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * index (integer) {optional} - The Tween Data to return the value from.

  Returns:  number - The value of the requested Tween Data."
  ([tween]
   (phaser->clj
    (.getValue tween)))
  ([tween index]
   (phaser->clj
    (.getValue tween
               (clj->phaser index)))))

(defn has-target
  "See if this Tween is currently acting upon the given target.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * target (object) - The target to check against this Tween.

  Returns:  boolean - `true` if the given target is a target of this Tween, otherwise `false`."
  ([tween target]
   (phaser->clj
    (.hasTarget tween
                (clj->phaser target)))))

(defn init
  "Called by TweenManager.preUpdate as part of its loop to check pending and active tweens.
  Should not be called directly.

  Returns:  boolean - Returns `true` if this Tween should be moved from the pending list to the active list by the Tween Manager."
  ([tween]
   (phaser->clj
    (.init tween))))

(defn is-paused
  "Checks if the Tween is currently paused.

  Returns:  boolean - `true` if the Tween is paused, otherwise `false`."
  ([tween]
   (phaser->clj
    (.isPaused tween))))

(defn is-playing
  "Checks if the Tween is currently active.

  Returns:  boolean - `true` if the Tween is active, otherwise `false`."
  ([tween]
   (phaser->clj
    (.isPlaying tween))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([tween event]
   (phaser->clj
    (.listenerCount tween
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([tween event]
   (phaser->clj
    (.listeners tween
                (clj->phaser event)))))

(defn make-active
  "Internal method that makes this Tween active within the TweenManager
  and emits the onActive event and callback."
  ([tween]
   (phaser->clj
    (.makeActive tween))))

(defn next-state
  "Internal method that advances to the next state of the Tween during playback."
  ([tween]
   (phaser->clj
    (.nextState tween))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([tween event]
   (phaser->clj
    (.off tween
          (clj->phaser event))))
  ([tween event fn]
   (phaser->clj
    (.off tween
          (clj->phaser event)
          (clj->phaser fn))))
  ([tween event fn context]
   (phaser->clj
    (.off tween
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([tween event fn context once]
   (phaser->clj
    (.off tween
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([tween event fn]
   (phaser->clj
    (.on tween
         (clj->phaser event)
         (clj->phaser fn))))
  ([tween event fn context]
   (phaser->clj
    (.on tween
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([tween event fn]
   (phaser->clj
    (.once tween
           (clj->phaser event)
           (clj->phaser fn))))
  ([tween event fn context]
   (phaser->clj
    (.once tween
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "Pauses the Tween immediately. Use `resume` to continue playback.

  Returns:  this - - This Tween instance."
  ([tween]
   (phaser->clj
    (.pause tween))))

(defn play
  "Starts a Tween playing.

  You only need to call this method if you have configured the tween to be paused on creation.

  If the Tween is already playing, calling this method again will have no effect. If you wish to
  restart the Tween, use `Tween.restart` instead.

  Calling this method after the Tween has completed will start the Tween playing again from the start.
  This is the same as calling `Tween.seek(0)` and then `Tween.play()`.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * reset-from-timeline (boolean) {optional} - Is this Tween being played as part of a Timeline?

  Returns:  this - This Tween instance."
  ([tween]
   (phaser->clj
    (.play tween)))
  ([tween reset-from-timeline]
   (phaser->clj
    (.play tween
           (clj->phaser reset-from-timeline)))))

(defn remove
  "Immediately removes this Tween from the TweenManager and all of its internal arrays,
  no matter what stage it as it. Then sets the tween state to `REMOVED`.

  You should dispose of your reference to this tween after calling this method, to
  free it from memory.

  Returns:  this - This Tween instance."
  ([tween]
   (phaser->clj
    (.remove tween))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([tween]
   (phaser->clj
    (.removeAllListeners tween)))
  ([tween event]
   (phaser->clj
    (.removeAllListeners tween
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([tween event]
   (phaser->clj
    (.removeListener tween
                     (clj->phaser event))))
  ([tween event fn]
   (phaser->clj
    (.removeListener tween
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([tween event fn context]
   (phaser->clj
    (.removeListener tween
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([tween event fn context once]
   (phaser->clj
    (.removeListener tween
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-tween-data
  "Internal method that resets all of the Tween Data, including the progress and elapsed values.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * reset-from-loop (boolean) - Has this method been called as part of a loop?"
  ([tween reset-from-loop]
   (phaser->clj
    (.resetTweenData tween
                     (clj->phaser reset-from-loop)))))

(defn restart
  "Restarts the tween from the beginning.

  Returns:  this - This Tween instance."
  ([tween]
   (phaser->clj
    (.restart tween))))

(defn resume
  "Resumes the playback of a previously paused Tween.

  Returns:  this - - This Tween instance."
  ([tween]
   (phaser->clj
    (.resume tween))))

(defn seek
  "Seeks to a specific point in the Tween.

  **Note:** You cannot seek a Tween that repeats or loops forever, or that has an unusually long total duration.

  The given position is a value between 0 and 1 which represents how far through the Tween to seek to.
  A value of 0.5 would seek to half-way through the Tween, where-as a value of zero would seek to the start.

  Note that the seek takes the entire duration of the Tween into account, including delays, loops and repeats.
  For example, a Tween that lasts for 2 seconds, but that loops 3 times, would have a total duration of 6 seconds,
  so seeking to 0.5 would seek to 3 seconds into the Tween, as that's half-way through its _entire_ duration.

  Seeking works by resetting the Tween to its initial values and then iterating through the Tween at `delta`
  jumps per step. The longer the Tween, the longer this can take.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * to-position (number) - A value between 0 and 1 which represents the progress point to seek to.
    * delta (number) {optional} - The size of each step when seeking through the Tween. A higher value completes faster but at a cost of less precision.

  Returns:  this - This Tween instance."
  ([tween to-position]
   (phaser->clj
    (.seek tween
           (clj->phaser to-position))))
  ([tween to-position delta]
   (phaser->clj
    (.seek tween
           (clj->phaser to-position)
           (clj->phaser delta)))))

(defn set-callback
  "Sets an event based callback to be invoked during playback.

  Calling this method will replace a previously set callback for the given type, if any exists.

  The types available are:

  `onActive` When the Tween is moved from the pending to the active list in the Tween Manager, even if playback paused.
  `onStart` When the Tween starts playing after a delayed state. Will happen at the same time as `onActive` if it has no delay.
  `onYoyo` When a TweenData starts a yoyo. This happens _after_ the `hold` delay expires, if set.
  `onRepeat` When a TweenData repeats playback. This happens _after_ the `repeatDelay` expires, if set.
  `onComplete` When the Tween finishes playback fully or `Tween.stop` is called. Never invoked if tween is set to repeat infinitely.
  `onUpdate` When a TweenData updates a property on a source target during playback.
  `onLoop` When a Tween loops. This happens _after_ the `loopDelay` expires, if set.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * type (string) - Type of the callback to set.
    * callback (function) - The function to invoke when this callback happens.
    * params (array) {optional} - An array of parameters for specified callbacks types.
    * scope (any) {optional} - The context the callback will be invoked in.

  Returns:  this - This Tween instance."
  ([tween type callback]
   (phaser->clj
    (.setCallback tween
                  (clj->phaser type)
                  (clj->phaser callback))))
  ([tween type callback params]
   (phaser->clj
    (.setCallback tween
                  (clj->phaser type)
                  (clj->phaser callback)
                  (clj->phaser params))))
  ([tween type callback params scope]
   (phaser->clj
    (.setCallback tween
                  (clj->phaser type)
                  (clj->phaser callback)
                  (clj->phaser params)
                  (clj->phaser scope)))))

(defn set-state-from-end
  "Internal method used as part of the playback process that sets a tween to play in reverse.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The Tween to update.
    * tween-data (Phaser.Types.Tweens.TweenDataConfig) - The TweenData property to update.
    * diff (number) - Any extra time that needs to be accounted for in the elapsed and progress values.

  Returns:  integer - The state of this Tween."
  ([tween tween tween-data diff]
   (phaser->clj
    (.setStateFromEnd tween
                      (clj->phaser tween)
                      (clj->phaser tween-data)
                      (clj->phaser diff)))))

(defn set-state-from-start
  "Internal method used as part of the playback process that sets a tween to play from the start.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The Tween to update.
    * tween-data (Phaser.Types.Tweens.TweenDataConfig) - The TweenData property to update.
    * diff (number) - Any extra time that needs to be accounted for in the elapsed and progress values.

  Returns:  integer - The state of this Tween."
  ([tween tween tween-data diff]
   (phaser->clj
    (.setStateFromStart tween
                        (clj->phaser tween)
                        (clj->phaser tween-data)
                        (clj->phaser diff)))))

(defn set-time-scale
  "Set the scale the time applied to this Tween. A value of 1 runs in real-time. A value of 0.5 runs 50% slower, and so on.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * value (number) - The scale factor for timescale.

  Returns:  this - - This Tween instance."
  ([tween value]
   (phaser->clj
    (.setTimeScale tween
                   (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([tween]
   (phaser->clj
    (.shutdown tween))))

(defn stop
  "Stops the Tween immediately, whatever stage of progress it is at and flags it for removal by the TweenManager.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * reset-to (number) {optional} - If you want to seek the tween, provide a value between 0 and 1.

  Returns:  this - This Tween instance."
  ([tween]
   (phaser->clj
    (.stop tween)))
  ([tween reset-to]
   (phaser->clj
    (.stop tween
           (clj->phaser reset-to)))))

(defn update
  "Internal method that advances the Tween based on the time values.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * timestamp (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate.

  Returns:  boolean - Returns `true` if this Tween has finished and should be removed from the Tween Manager, otherwise returns `false`."
  ([tween timestamp delta]
   (phaser->clj
    (.update tween
             (clj->phaser timestamp)
             (clj->phaser delta)))))

(defn update-to
  "Updates the 'end' value of the given property across all matching targets.

  Calling this does not adjust the duration of the tween, or the current progress.

  You can optionally tell it to set the 'start' value to be the current value (before the change).

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * key (string) - The property to set the new value for.
    * value (*) - The new value of the property.
    * start-to-current (boolean) {optional} - Should this change set the start value to be the current value?

  Returns:  this - - This Tween instance."
  ([tween key value]
   (phaser->clj
    (.updateTo tween
               (clj->phaser key)
               (clj->phaser value))))
  ([tween key value start-to-current]
   (phaser->clj
    (.updateTo tween
               (clj->phaser key)
               (clj->phaser value)
               (clj->phaser start-to-current)))))

(defn update-tween-data
  "Internal method that advances the TweenData based on the time value given.

  Parameters:
    * tween (Phaser.Tweens.Tween) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The Tween to update.
    * tween-data (Phaser.Types.Tweens.TweenDataConfig) - The TweenData property to update.
    * delta (number) - Either a value in ms, or 1 if Tween.useFrames is true.

  Returns:  boolean - True if the tween is not complete (e.g., playing), or false if the tween is complete."
  ([tween tween tween-data delta]
   (phaser->clj
    (.updateTweenData tween
                      (clj->phaser tween)
                      (clj->phaser tween-data)
                      (clj->phaser delta)))))