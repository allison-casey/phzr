(ns phzr.tweens.timeline
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Timeline
  "  Parameters:
    * manager (Phaser.Tweens.TweenManager) - The Tween Manager which owns this Timeline."
  ([manager]
   (js/Phaser.Tweens.Timeline. (clj->phaser manager))))

(defn add
  "Creates a new Tween, based on the given Tween Config, and adds it to this Timeline.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * config (Phaser.Types.Tweens.TweenBuilderConfig | object) - The configuration object for the Tween.

  Returns:  this - This Timeline object."
  ([timeline config]
   (phaser->clj
    (.add timeline
          (clj->phaser config)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([timeline event fn]
   (phaser->clj
    (.addListener timeline
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([timeline event fn context]
   (phaser->clj
    (.addListener timeline
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn calc-duration
  "Calculates the total duration of the timeline.

  Computes all tween durations and returns the full duration of the timeline.

  The resulting number is stored in the timeline, not as a return value."
  ([timeline]
   (phaser->clj
    (.calcDuration timeline))))

(defn destroy
  "Stops all the Tweens in the Timeline immediately, whatever stage of progress they are at and flags
  them for removal by the TweenManager."
  ([timeline]
   (phaser->clj
    (.destroy timeline))))

(defn dispatch-timeline-event
  "Internal method that will emit a Timeline based Event and invoke the given callback.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (Phaser.Types.Tweens.Event) - The Event to be dispatched.
    * callback (function) - The callback to be invoked. Can be `null` or `undefined` to skip invocation."
  ([timeline event callback]
   (phaser->clj
    (.dispatchTimelineEvent timeline
                            (clj->phaser event)
                            (clj->phaser callback)))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([timeline event]
   (phaser->clj
    (.emit timeline
           (clj->phaser event))))
  ([timeline event args]
   (phaser->clj
    (.emit timeline
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([timeline]
   (phaser->clj
    (.eventNames timeline))))

(defn get-relative-offset
  "Parses the relative offset value, returning a positive or negative number.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * value (string) - The relative offset, in the format of '-=500', for example. The first character determines whether it will be a positive or negative number. Spacing matters here.
    * base (number) - The value to use as the offset.

  Returns:  number - The parsed offset value."
  ([timeline value base]
   (phaser->clj
    (.getRelativeOffset timeline
                        (clj->phaser value)
                        (clj->phaser base)))))

(defn get-time-scale
  "Gets the value of the time scale applied to this Timeline. A value of 1 runs in real-time.
  A value of 0.5 runs 50% slower, and so on.

  Returns:  number - The value of the time scale applied to this Timeline."
  ([timeline]
   (phaser->clj
    (.getTimeScale timeline))))

(defn has-offset
  "Checks whether a Tween has an offset value.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The Tween to check.

  Returns:  boolean - `true` if the tween has a non-null offset."
  ([timeline tween]
   (phaser->clj
    (.hasOffset timeline
                (clj->phaser tween)))))

(defn has-target
  "Checks if any of the Tweens in this Timeline as operating on the target object.

  Returns `false` if no Tweens operate on the target object.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * target (object) - The target to check all Tweens against.

  Returns:  boolean - `true` if there is at least a single Tween that operates on the target object, otherwise `false`."
  ([timeline target]
   (phaser->clj
    (.hasTarget timeline
                (clj->phaser target)))))

(defn init
  "Initializes the timeline, which means all Tweens get their init() called, and the total duration will be computed.
  Returns a boolean indicating whether the timeline is auto-started or not.

  Returns:  boolean - `true` if the Timeline is started. `false` if it is paused."
  ([timeline]
   (phaser->clj
    (.init timeline))))

(defn is-offset-absolute
  "Checks whether the offset value is a number or a directive that is relative to previous tweens.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * value (number) - The offset value to be evaluated.

  Returns:  boolean - `true` if the result is a number, `false` if it is a directive like ' -= 1000'."
  ([timeline value]
   (phaser->clj
    (.isOffsetAbsolute timeline
                       (clj->phaser value)))))

(defn is-offset-relative
  "Checks if the offset is a relative value rather than an absolute one.
  If the value is just a number, this returns false.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * value (string) - The offset value to be evaluated.

  Returns:  boolean - `true` if the value is relative, i.e ' -= 1000'. If `false`, the offset is absolute."
  ([timeline value]
   (phaser->clj
    (.isOffsetRelative timeline
                       (clj->phaser value)))))

(defn is-playing
  "Check whether or not the Timeline is playing.

  Returns:  boolean - `true` if this Timeline is active, otherwise `false`."
  ([timeline]
   (phaser->clj
    (.isPlaying timeline))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([timeline event]
   (phaser->clj
    (.listenerCount timeline
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([timeline event]
   (phaser->clj
    (.listeners timeline
                (clj->phaser event)))))

(defn make-active
  "Passed a Tween to the Tween Manager and requests it be made active.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The tween object to make active.

  Returns:  Phaser.Tweens.TweenManager - The Timeline's Tween Manager reference."
  ([timeline tween]
   (phaser->clj
    (.makeActive timeline
                 (clj->phaser tween)))))

(defn next-state
  "Updates the Timeline's `state` and fires callbacks and events."
  ([timeline]
   (phaser->clj
    (.nextState timeline))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([timeline event]
   (phaser->clj
    (.off timeline
          (clj->phaser event))))
  ([timeline event fn]
   (phaser->clj
    (.off timeline
          (clj->phaser event)
          (clj->phaser fn))))
  ([timeline event fn context]
   (phaser->clj
    (.off timeline
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([timeline event fn context once]
   (phaser->clj
    (.off timeline
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([timeline event fn]
   (phaser->clj
    (.on timeline
         (clj->phaser event)
         (clj->phaser fn))))
  ([timeline event fn context]
   (phaser->clj
    (.on timeline
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([timeline event fn]
   (phaser->clj
    (.once timeline
           (clj->phaser event)
           (clj->phaser fn))))
  ([timeline event fn context]
   (phaser->clj
    (.once timeline
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "Pauses the Timeline, retaining its internal state.

  Calling this on a Timeline that is already paused has no effect and fires no event.

  Returns:  this - This Timeline object."
  ([timeline]
   (phaser->clj
    (.pause timeline))))

(defn play
  "Starts playing the Timeline."
  ([timeline]
   (phaser->clj
    (.play timeline))))

(defn queue
  "Adds an existing Tween to this Timeline.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The Tween to be added to this Timeline.

  Returns:  this - This Timeline object."
  ([timeline tween]
   (phaser->clj
    (.queue timeline
            (clj->phaser tween)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([timeline]
   (phaser->clj
    (.removeAllListeners timeline)))
  ([timeline event]
   (phaser->clj
    (.removeAllListeners timeline
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([timeline event]
   (phaser->clj
    (.removeListener timeline
                     (clj->phaser event))))
  ([timeline event fn]
   (phaser->clj
    (.removeListener timeline
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([timeline event fn context]
   (phaser->clj
    (.removeListener timeline
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([timeline event fn context once]
   (phaser->clj
    (.removeListener timeline
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-tweens
  "Resets all of the timeline's tweens back to their initial states.
  The boolean parameter indicates whether tweens that are looping should reset as well, or not.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * reset-from-loop (boolean) - If `true`, resets all looping tweens to their initial values."
  ([timeline reset-from-loop]
   (phaser->clj
    (.resetTweens timeline
                  (clj->phaser reset-from-loop)))))

(defn resume
  "Resumes a paused Timeline from where it was when it was paused.

  Calling this on a Timeline that isn't paused has no effect and fires no event.

  Returns:  this - This Timeline object."
  ([timeline]
   (phaser->clj
    (.resume timeline))))

(defn set-callback
  "Sets a callback for the Timeline.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * type (string) - The internal type of callback to set.
    * callback (function) - Timeline allows multiple tweens to be linked together to create a streaming sequence.
    * params (array) {optional} - The parameters to pass to the callback.
    * scope (object) {optional} - The context scope of the callback.

  Returns:  this - This Timeline object."
  ([timeline type callback]
   (phaser->clj
    (.setCallback timeline
                  (clj->phaser type)
                  (clj->phaser callback))))
  ([timeline type callback params]
   (phaser->clj
    (.setCallback timeline
                  (clj->phaser type)
                  (clj->phaser callback)
                  (clj->phaser params))))
  ([timeline type callback params scope]
   (phaser->clj
    (.setCallback timeline
                  (clj->phaser type)
                  (clj->phaser callback)
                  (clj->phaser params)
                  (clj->phaser scope)))))

(defn set-time-scale
  "Sets the value of the time scale applied to this Timeline. A value of 1 runs in real-time.
  A value of 0.5 runs 50% slower, and so on.

  The value isn't used when calculating total duration of the tween, it's a run-time delta adjustment only.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * value (number) - The time scale value to set.

  Returns:  this - This Timeline object."
  ([timeline value]
   (phaser->clj
    (.setTimeScale timeline
                   (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([timeline]
   (phaser->clj
    (.shutdown timeline))))

(defn stop
  "Stops the Timeline immediately, whatever stage of progress it is at and flags it for removal by the TweenManager."
  ([timeline]
   (phaser->clj
    (.stop timeline))))

(defn update
  "Returns 'true' if this Timeline has finished and should be removed from the Tween Manager.
  Otherwise, returns false.

  Parameters:
    * timeline (Phaser.Tweens.Timeline) - Targeted instance for method
    * timestamp (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate.

  Returns:  boolean - Returns `true` if this Timeline has finished and should be removed from the Tween Manager."
  ([timeline timestamp delta]
   (phaser->clj
    (.update timeline
             (clj->phaser timestamp)
             (clj->phaser delta)))))