(ns phzr.animations.animation-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [get load remove]))

(defn ->AnimationManager
  "  Parameters:
    * game (Phaser.Game) - A reference to the Phaser.Game instance."
  ([game]
   (js/Phaser.Animations.AnimationManager. (clj->phaser game))))

(defn add
  "Adds an existing Animation to the Animation Manager.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - The key under which the Animation should be added. The Animation will be updated with it. Must be unique.
    * animation (Phaser.Animations.Animation) - The Animation which should be added to the Animation Manager.

  Returns:  Phaser.Animations.AnimationManager - This Animation Manager."
  ([animation-manager key animation]
   (phaser->clj
    (.add animation-manager
          (clj->phaser key)
          (clj->phaser animation)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation-manager event fn]
   (phaser->clj
    (.addListener animation-manager
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([animation-manager event fn context]
   (phaser->clj
    (.addListener animation-manager
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn boot
  "Registers event listeners after the Game boots."
  ([animation-manager]
   (phaser->clj
    (.boot animation-manager))))

(defn create
  "Creates a new Animation and adds it to the Animation Manager.

  Animations are global. Once created, you can use them in any Scene in your game. They are not Scene specific.

  If an invalid key is given this method will return `false`.

  If you pass the key of an animation that already exists in the Animation Manager, that animation will be returned.

  A brand new animation is only created if the key is valid and not already in use.

  If you wish to re-use an existing key, call `AnimationManager.remove` first, then this method.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * config (Phaser.Types.Animations.Animation) - The configuration settings for the Animation.

  Returns:  Phaser.Animations.Animation | false - The Animation that was created, or `false` is the key is already in use."
  ([animation-manager config]
   (phaser->clj
    (.create animation-manager
             (clj->phaser config)))))

(defn destroy
  "Destroy this Animation Manager and clean up animation definitions and references to other objects.
  This method should not be called directly. It will be called automatically as a response to a `destroy` event from the Phaser.Game instance."
  ([animation-manager]
   (phaser->clj
    (.destroy animation-manager))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([animation-manager event]
   (phaser->clj
    (.emit animation-manager
           (clj->phaser event))))
  ([animation-manager event args]
   (phaser->clj
    (.emit animation-manager
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([animation-manager]
   (phaser->clj
    (.eventNames animation-manager))))

(defn exists
  "Checks to see if the given key is already in use within the Animation Manager or not.

  Animations are global. Keys created in one scene can be used from any other Scene in your game. They are not Scene specific.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - The key of the Animation to check.

  Returns:  boolean - `true` if the Animation already exists in the Animation Manager, or `false` if the key is available."
  ([animation-manager key]
   (phaser->clj
    (.exists animation-manager
             (clj->phaser key)))))

(defn from-json
  "Loads this Animation Manager's Animations and settings from a JSON object.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * data (string | Phaser.Types.Animations.JSONAnimations | Phaser.Types.Animations.JSONAnimation) - The JSON object to parse.
    * clear-current-animations (boolean) {optional} - If set to `true`, the current animations will be removed (`anims.clear()`). If set to `false` (default), the animations in `data` will be added.

  Returns:  Array.<Phaser.Animations.Animation> - An array containing all of the Animation objects that were created as a result of this call."
  ([animation-manager data]
   (phaser->clj
    (.fromJSON animation-manager
               (clj->phaser data))))
  ([animation-manager data clear-current-animations]
   (phaser->clj
    (.fromJSON animation-manager
               (clj->phaser data)
               (clj->phaser clear-current-animations)))))

(defn generate-frame-names
  "[description]

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - The key for the texture containing the animation frames.
    * config (Phaser.Types.Animations.GenerateFrameNames) {optional} - The configuration object for the animation frame names.

  Returns:  Array.<Phaser.Types.Animations.AnimationFrame> - The array of {@link Phaser.Types.Animations.AnimationFrame} objects."
  ([animation-manager key]
   (phaser->clj
    (.generateFrameNames animation-manager
                         (clj->phaser key))))
  ([animation-manager key config]
   (phaser->clj
    (.generateFrameNames animation-manager
                         (clj->phaser key)
                         (clj->phaser config)))))

(defn generate-frame-numbers
  "Generate an array of {@link Phaser.Types.Animations.AnimationFrame} objects from a texture key and configuration object.

  Generates objects with numbered frame names, as configured by the given {@link Phaser.Types.Animations.GenerateFrameNumbers}.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - The key for the texture containing the animation frames.
    * config (Phaser.Types.Animations.GenerateFrameNumbers) - The configuration object for the animation frames.

  Returns:  Array.<Phaser.Types.Animations.AnimationFrame> - The array of {@link Phaser.Types.Animations.AnimationFrame} objects."
  ([animation-manager key config]
   (phaser->clj
    (.generateFrameNumbers animation-manager
                           (clj->phaser key)
                           (clj->phaser config)))))

(defn get
  "Get an Animation.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - The key of the Animation to retrieve.

  Returns:  Phaser.Animations.Animation - The Animation."
  ([animation-manager key]
   (phaser->clj
    (.get animation-manager
          (clj->phaser key)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([animation-manager event]
   (phaser->clj
    (.listenerCount animation-manager
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([animation-manager event]
   (phaser->clj
    (.listeners animation-manager
                (clj->phaser event)))))

(defn load
  "Load an Animation into a Game Object's Animation Component.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to load the animation into.
    * key (string) - The key of the animation to load.
    * start-frame (string | integer) {optional} - The name of a start frame to set on the loaded animation.

  Returns:  Phaser.GameObjects.GameObject - The Game Object with the animation loaded into it."
  ([animation-manager child key]
   (phaser->clj
    (.load animation-manager
           (clj->phaser child)
           (clj->phaser key))))
  ([animation-manager child key start-frame]
   (phaser->clj
    (.load animation-manager
           (clj->phaser child)
           (clj->phaser key)
           (clj->phaser start-frame)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation-manager event]
   (phaser->clj
    (.off animation-manager
          (clj->phaser event))))
  ([animation-manager event fn]
   (phaser->clj
    (.off animation-manager
          (clj->phaser event)
          (clj->phaser fn))))
  ([animation-manager event fn context]
   (phaser->clj
    (.off animation-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([animation-manager event fn context once]
   (phaser->clj
    (.off animation-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation-manager event fn]
   (phaser->clj
    (.on animation-manager
         (clj->phaser event)
         (clj->phaser fn))))
  ([animation-manager event fn context]
   (phaser->clj
    (.on animation-manager
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation-manager event fn]
   (phaser->clj
    (.once animation-manager
           (clj->phaser event)
           (clj->phaser fn))))
  ([animation-manager event fn context]
   (phaser->clj
    (.once animation-manager
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause-all
  "Pause all animations.

  Returns:  Phaser.Animations.AnimationManager - This Animation Manager."
  ([animation-manager]
   (phaser->clj
    (.pauseAll animation-manager))))

(defn play
  "Play an animation on the given Game Objects that have an Animation Component.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - The key of the animation to play on the Game Object.
    * child (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - The Game Objects to play the animation on.

  Returns:  Phaser.Animations.AnimationManager - This Animation Manager."
  ([animation-manager key child]
   (phaser->clj
    (.play animation-manager
           (clj->phaser key)
           (clj->phaser child)))))

(defn remove
  "Remove an animation.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - The key of the animation to remove.

  Returns:  Phaser.Animations.Animation - [description]"
  ([animation-manager key]
   (phaser->clj
    (.remove animation-manager
             (clj->phaser key)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation-manager]
   (phaser->clj
    (.removeAllListeners animation-manager)))
  ([animation-manager event]
   (phaser->clj
    (.removeAllListeners animation-manager
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([animation-manager event]
   (phaser->clj
    (.removeListener animation-manager
                     (clj->phaser event))))
  ([animation-manager event fn]
   (phaser->clj
    (.removeListener animation-manager
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([animation-manager event fn context]
   (phaser->clj
    (.removeListener animation-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([animation-manager event fn context once]
   (phaser->clj
    (.removeListener animation-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn resume-all
  "Resume all paused animations.

  Returns:  Phaser.Animations.AnimationManager - This Animation Manager."
  ([animation-manager]
   (phaser->clj
    (.resumeAll animation-manager))))

(defn shutdown
  "Removes all listeners."
  ([animation-manager]
   (phaser->clj
    (.shutdown animation-manager))))

(defn stagger-play
  "Takes an array of Game Objects that have an Animation Component and then
  starts the given animation playing on them, each one offset by the
  `stagger` amount given to this method.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - The key of the animation to play on the Game Objects.
    * children (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to play the animation on. They must have an Animation Component.
    * stagger (number) {optional} - The amount of time, in milliseconds, to offset each play time by.

  Returns:  Phaser.Animations.AnimationManager - This Animation Manager."
  ([animation-manager key children]
   (phaser->clj
    (.staggerPlay animation-manager
                  (clj->phaser key)
                  (clj->phaser children))))
  ([animation-manager key children stagger]
   (phaser->clj
    (.staggerPlay animation-manager
                  (clj->phaser key)
                  (clj->phaser children)
                  (clj->phaser stagger)))))

(defn to-json
  "Get the animation data as javascript object by giving key, or get the data of all animations as array of objects, if key wasn't provided.

  Parameters:
    * animation-manager (Phaser.Animations.AnimationManager) - Targeted instance for method
    * key (string) - [description]

  Returns:  Phaser.Types.Animations.JSONAnimations - [description]"
  ([animation-manager key]
   (phaser->clj
    (.toJSON animation-manager
             (clj->phaser key)))))