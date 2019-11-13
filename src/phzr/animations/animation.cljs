(ns phzr.animations.animation
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Animation
  "  Parameters:
    * manager (Phaser.Animations.AnimationManager) - A reference to the global Animation Manager
    * key (string) - The unique identifying string for this animation.
    * config (Phaser.Types.Animations.Animation) - The Animation configuration."
  ([manager key config]
   (js/Phaser.Animations.Animation. (clj->phaser manager)
                                    (clj->phaser key)
                                    (clj->phaser config))))

(defn add-frame
  "Add frames to the end of the animation.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * config (string | Array.<Phaser.Types.Animations.AnimationFrame>) - [description]

  Returns:  Phaser.Animations.Animation - This Animation object."
  ([animation config]
   (phaser->clj
    (.addFrame animation
               (clj->phaser config)))))

(defn add-frame-at
  "Add frame/s into the animation.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * index (integer) - The index to insert the frame at within the animation.
    * config (string | Array.<Phaser.Types.Animations.AnimationFrame>) - [description]

  Returns:  Phaser.Animations.Animation - This Animation object."
  ([animation index config]
   (phaser->clj
    (.addFrameAt animation
                 (clj->phaser index)
                 (clj->phaser config)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation event fn]
   (phaser->clj
    (.addListener animation
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([animation event fn context]
   (phaser->clj
    (.addListener animation
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn check-frame
  "Check if the given frame index is valid.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * index (integer) - The index to be checked.

  Returns:  boolean - `true` if the index is valid, otherwise `false`."
  ([animation index]
   (phaser->clj
    (.checkFrame animation
                 (clj->phaser index)))))

(defn destroy
  "[description]"
  ([animation]
   (phaser->clj
    (.destroy animation))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([animation event]
   (phaser->clj
    (.emit animation
           (clj->phaser event))))
  ([animation event args]
   (phaser->clj
    (.emit animation
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([animation]
   (phaser->clj
    (.eventNames animation))))

(defn get-frame-by-progress
  "Returns the frame closest to the given progress value between 0 and 1.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * value (number) - A value between 0 and 1.

  Returns:  Phaser.Animations.AnimationFrame - The frame closest to the given progress value."
  ([animation value]
   (phaser->clj
    (.getFrameByProgress animation
                         (clj->phaser value)))))

(defn get-frames
  "[description]

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * texture-manager (Phaser.Textures.TextureManager) - [description]
    * frames (string | Array.<Phaser.Types.Animations.AnimationFrame>) - [description]
    * default-texture-key (string) {optional} - [description]

  Returns:  Array.<Phaser.Animations.AnimationFrame> - [description]"
  ([animation texture-manager frames]
   (phaser->clj
    (.getFrames animation
                (clj->phaser texture-manager)
                (clj->phaser frames))))
  ([animation texture-manager frames default-texture-key]
   (phaser->clj
    (.getFrames animation
                (clj->phaser texture-manager)
                (clj->phaser frames)
                (clj->phaser default-texture-key)))))

(defn get-last-frame
  "Returns the animation last frame.

  Returns:  Phaser.Animations.AnimationFrame - component - The Animation Last Frame."
  ([animation]
   (phaser->clj
    (.getLastFrame animation))))

(defn get-next-tick
  "[description]

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * component (Phaser.GameObjects.Components.Animation) - [description]"
  ([animation component]
   (phaser->clj
    (.getNextTick animation
                  (clj->phaser component)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([animation event]
   (phaser->clj
    (.listenerCount animation
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([animation event]
   (phaser->clj
    (.listeners animation
                (clj->phaser event)))))

(defn next-frame
  "Advance the animation frame.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * component (Phaser.GameObjects.Components.Animation) - The Animation Component to advance."
  ([animation component]
   (phaser->clj
    (.nextFrame animation
                (clj->phaser component)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation event]
   (phaser->clj
    (.off animation
          (clj->phaser event))))
  ([animation event fn]
   (phaser->clj
    (.off animation
          (clj->phaser event)
          (clj->phaser fn))))
  ([animation event fn context]
   (phaser->clj
    (.off animation
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([animation event fn context once]
   (phaser->clj
    (.off animation
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation event fn]
   (phaser->clj
    (.on animation
         (clj->phaser event)
         (clj->phaser fn))))
  ([animation event fn context]
   (phaser->clj
    (.on animation
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation event fn]
   (phaser->clj
    (.once animation
           (clj->phaser event)
           (clj->phaser fn))))
  ([animation event fn context]
   (phaser->clj
    (.once animation
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "[description]

  Returns:  Phaser.Animations.Animation - This Animation object."
  ([animation]
   (phaser->clj
    (.pause animation))))

(defn previous-frame
  "[description]

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * component (Phaser.GameObjects.Components.Animation) - [description]"
  ([animation component]
   (phaser->clj
    (.previousFrame animation
                    (clj->phaser component)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation]
   (phaser->clj
    (.removeAllListeners animation)))
  ([animation event]
   (phaser->clj
    (.removeAllListeners animation
                         (clj->phaser event)))))

(defn remove-frame
  "[description]

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * frame (Phaser.Animations.AnimationFrame) - [description]

  Returns:  Phaser.Animations.Animation - This Animation object."
  ([animation frame]
   (phaser->clj
    (.removeFrame animation
                  (clj->phaser frame)))))

(defn remove-frame-at
  "Removes a frame from the AnimationFrame array at the provided index
  and updates the animation accordingly.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * index (integer) - The index in the AnimationFrame array

  Returns:  Phaser.Animations.Animation - This Animation object."
  ([animation index]
   (phaser->clj
    (.removeFrameAt animation
                    (clj->phaser index)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation event]
   (phaser->clj
    (.removeListener animation
                     (clj->phaser event))))
  ([animation event fn]
   (phaser->clj
    (.removeListener animation
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([animation event fn context]
   (phaser->clj
    (.removeListener animation
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([animation event fn context once]
   (phaser->clj
    (.removeListener animation
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn repeat-animation
  "[description]

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * component (Phaser.GameObjects.Components.Animation) - [description]"
  ([animation component]
   (phaser->clj
    (.repeatAnimation animation
                      (clj->phaser component)))))

(defn resume
  "[description]

  Returns:  Phaser.Animations.Animation - This Animation object."
  ([animation]
   (phaser->clj
    (.resume animation))))

(defn set-frame
  "Sets the texture frame the animation uses for rendering.

  Parameters:
    * animation (Phaser.Animations.Animation) - Targeted instance for method
    * component (Phaser.GameObjects.Components.Animation) - [description]"
  ([animation component]
   (phaser->clj
    (.setFrame animation
               (clj->phaser component)))))

(defn shutdown
  "Removes all listeners."
  ([animation]
   (phaser->clj
    (.shutdown animation))))

(defn to-json
  "Converts the animation data to JSON.

  Returns:  Phaser.Types.Animations.JSONAnimation - [description]"
  ([animation]
   (phaser->clj
    (.toJSON animation))))

(defn update-frame-sequence
  "[description]

  Returns:  Phaser.Animations.Animation - This Animation object."
  ([animation]
   (phaser->clj
    (.updateFrameSequence animation))))