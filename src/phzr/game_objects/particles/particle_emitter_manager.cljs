(ns phzr.game-objects.particles.particle-emitter-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->ParticleEmitterManager
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Emitter Manager belongs.
    * texture (string) - The key of the Texture this Emitter Manager will use to render particles, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Emitter Manager will use to render particles.
    * emitters (Phaser.Types.GameObjects.Particles.ParticleEmitterConfig | Array.<Phaser.Types.GameObjects.Particles.ParticleEmitterConfig>) {optional} - Configuration settings for one or more emitters to create."
  ([scene texture]
   (js/Phaser.GameObjects.Particles.ParticleEmitterManager. (clj->phaser scene)
                                                            (clj->phaser texture)))
  ([scene texture frame]
   (js/Phaser.GameObjects.Particles.ParticleEmitterManager. (clj->phaser scene)
                                                            (clj->phaser texture)
                                                            (clj->phaser frame)))
  ([scene texture frame emitters]
   (js/Phaser.GameObjects.Particles.ParticleEmitterManager. (clj->phaser scene)
                                                            (clj->phaser texture)
                                                            (clj->phaser frame)
                                                            (clj->phaser emitters))))

(defn add-emitter
  "Adds an existing Particle Emitter to this Emitter Manager.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * emitter (Phaser.GameObjects.Particles.ParticleEmitter) - The Particle Emitter to add to this Emitter Manager.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - The Particle Emitter that was added to this Emitter Manager."
  ([particle-emitter-manager emitter]
   (phaser->clj
    (.addEmitter particle-emitter-manager
                 (clj->phaser emitter)))))

(defn add-gravity-well
  "Adds an existing Gravity Well object to this Emitter Manager.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * well (Phaser.GameObjects.Particles.GravityWell) - The Gravity Well to add to this Emitter Manager.

  Returns:  Phaser.GameObjects.Particles.GravityWell - The Gravity Well that was added to this Emitter Manager."
  ([particle-emitter-manager well]
   (phaser->clj
    (.addGravityWell particle-emitter-manager
                     (clj->phaser well)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([particle-emitter-manager event fn]
   (phaser->clj
    (.addListener particle-emitter-manager
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([particle-emitter-manager event fn context]
   (phaser->clj
    (.addListener particle-emitter-manager
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.clearMask particle-emitter-manager)))
  ([particle-emitter-manager destroy-mask]
   (phaser->clj
    (.clearMask particle-emitter-manager
                (clj->phaser destroy-mask)))))

(defn create-bitmap-mask
  "Creates and returns a Bitmap Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a renderable Game Object.
  A renderable Game Object is one that uses a texture to render with, such as an
  Image, Sprite, Render Texture or BitmapText.

  If you do not provide a renderable object, and this Game Object has a texture,
  it will use itself as the object. This means you can call this method to create
  a Bitmap Mask from any renderable Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([particle-emitter-manager]
   (phaser->clj
    (.createBitmapMask particle-emitter-manager)))
  ([particle-emitter-manager renderable]
   (phaser->clj
    (.createBitmapMask particle-emitter-manager
                       (clj->phaser renderable)))))

(defn create-emitter
  "Creates a new Particle Emitter object, adds it to this Emitter Manager and returns a reference to it.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * config (Phaser.Types.GameObjects.Particles.ParticleEmitterConfig) - Configuration settings for the Particle Emitter to create.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - The Particle Emitter that was created."
  ([particle-emitter-manager config]
   (phaser->clj
    (.createEmitter particle-emitter-manager
                    (clj->phaser config)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([particle-emitter-manager]
   (phaser->clj
    (.createGeometryMask particle-emitter-manager)))
  ([particle-emitter-manager graphics]
   (phaser->clj
    (.createGeometryMask particle-emitter-manager
                         (clj->phaser graphics)))))

(defn create-gravity-well
  "Creates a new Gravity Well, adds it to this Emitter Manager and returns a reference to it.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * config (Phaser.Types.GameObjects.Particles.GravityWellConfig) - Configuration settings for the Gravity Well to create.

  Returns:  Phaser.GameObjects.Particles.GravityWell - The Gravity Well that was created."
  ([particle-emitter-manager config]
   (phaser->clj
    (.createGravityWell particle-emitter-manager
                        (clj->phaser config)))))

(defn destroy
  "Destroys this Game Object removing it from the Display List and Update List and
  severing all ties to parent resources.

  Also removes itself from the Input Manager and Physics Manager if previously enabled.

  Use this to remove a Game Object from your game if you don't ever plan to use it again.
  As long as no reference to it exists within your own code it should become free for
  garbage collection by the browser.

  If you just want to temporarily disable an object then look at using the
  Game Object Pool instead of destroying it, as destroyed objects cannot be resurrected.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([particle-emitter-manager]
   (phaser->clj
    (.destroy particle-emitter-manager)))
  ([particle-emitter-manager from-scene]
   (phaser->clj
    (.destroy particle-emitter-manager
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([particle-emitter-manager]
   (phaser->clj
    (.disableInteractive particle-emitter-manager))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([particle-emitter-manager event]
   (phaser->clj
    (.emit particle-emitter-manager
           (clj->phaser event))))
  ([particle-emitter-manager event args]
   (phaser->clj
    (.emit particle-emitter-manager
           (clj->phaser event)
           (clj->phaser args)))))

(defn emit-particle
  "Emits particles from each active emitter.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * count (integer) {optional} - The number of particles to release from each emitter. The default is the emitter's own {@link Phaser.GameObjects.Particles.ParticleEmitter#quantity}.
    * x (number) {optional} - The x-coordinate to to emit particles from. The default is the x-coordinate of the emitter's current location.
    * y (number) {optional} - The y-coordinate to to emit particles from. The default is the y-coordinate of the emitter's current location.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - This Emitter Manager."
  ([particle-emitter-manager]
   (phaser->clj
    (.emitParticle particle-emitter-manager)))
  ([particle-emitter-manager count]
   (phaser->clj
    (.emitParticle particle-emitter-manager
                   (clj->phaser count))))
  ([particle-emitter-manager count x]
   (phaser->clj
    (.emitParticle particle-emitter-manager
                   (clj->phaser count)
                   (clj->phaser x))))
  ([particle-emitter-manager count x y]
   (phaser->clj
    (.emitParticle particle-emitter-manager
                   (clj->phaser count)
                   (clj->phaser x)
                   (clj->phaser y)))))

(defn emit-particle-at
  "Emits particles from each active emitter.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * x (number) {optional} - The x-coordinate to to emit particles from. The default is the x-coordinate of the emitter's current location.
    * y (number) {optional} - The y-coordinate to to emit particles from. The default is the y-coordinate of the emitter's current location.
    * count (integer) {optional} - The number of particles to release from each emitter. The default is the emitter's own {@link Phaser.GameObjects.Particles.ParticleEmitter#quantity}.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - This Emitter Manager."
  ([particle-emitter-manager]
   (phaser->clj
    (.emitParticleAt particle-emitter-manager)))
  ([particle-emitter-manager x]
   (phaser->clj
    (.emitParticleAt particle-emitter-manager
                     (clj->phaser x))))
  ([particle-emitter-manager x y]
   (phaser->clj
    (.emitParticleAt particle-emitter-manager
                     (clj->phaser x)
                     (clj->phaser y))))
  ([particle-emitter-manager x y count]
   (phaser->clj
    (.emitParticleAt particle-emitter-manager
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser count)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([particle-emitter-manager]
   (phaser->clj
    (.eventNames particle-emitter-manager))))

(defn get-data
  "Retrieves the value for the given key in this Game Objects Data Manager, or undefined if it doesn't exist.

  You can also access values via the `values` object. For example, if you had a key called `gold` you can do either:

  ```javascript
  sprite.getData('gold');
  ```

  Or access the value directly:

  ```javascript
  sprite.data.values.gold;
  ```

  You can also pass in an array of keys, in which case an array of values will be returned:

  ```javascript
  sprite.getData([ 'gold', 'armor', 'health' ]);
  ```

  This approach is useful for destructuring arrays in ES6.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([particle-emitter-manager key]
   (phaser->clj
    (.getData particle-emitter-manager
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([particle-emitter-manager]
   (phaser->clj
    (.getIndexList particle-emitter-manager))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([particle-emitter-manager]
   (phaser->clj
    (.getLocalTransformMatrix particle-emitter-manager)))
  ([particle-emitter-manager temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix particle-emitter-manager
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([particle-emitter-manager]
   (phaser->clj
    (.getParentRotation particle-emitter-manager))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([particle-emitter-manager]
   (phaser->clj
    (.getPipelineName particle-emitter-manager))))

(defn get-processors
  "Gets all active particle processors (gravity wells).

  Returns:  Array.<Phaser.GameObjects.Particles.GravityWell> - - The active gravity wells."
  ([particle-emitter-manager]
   (phaser->clj
    (.getProcessors particle-emitter-manager))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([particle-emitter-manager]
   (phaser->clj
    (.getWorldTransformMatrix particle-emitter-manager)))
  ([particle-emitter-manager temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix particle-emitter-manager
                              (clj->phaser temp-matrix))))
  ([particle-emitter-manager temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix particle-emitter-manager
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([particle-emitter-manager]
   (phaser->clj
    (.initPipeline particle-emitter-manager)))
  ([particle-emitter-manager pipeline-name]
   (phaser->clj
    (.initPipeline particle-emitter-manager
                   (clj->phaser pipeline-name)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([particle-emitter-manager event]
   (phaser->clj
    (.listenerCount particle-emitter-manager
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([particle-emitter-manager event]
   (phaser->clj
    (.listeners particle-emitter-manager
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([particle-emitter-manager event]
   (phaser->clj
    (.off particle-emitter-manager
          (clj->phaser event))))
  ([particle-emitter-manager event fn]
   (phaser->clj
    (.off particle-emitter-manager
          (clj->phaser event)
          (clj->phaser fn))))
  ([particle-emitter-manager event fn context]
   (phaser->clj
    (.off particle-emitter-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([particle-emitter-manager event fn context once]
   (phaser->clj
    (.off particle-emitter-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([particle-emitter-manager event fn]
   (phaser->clj
    (.on particle-emitter-manager
         (clj->phaser event)
         (clj->phaser fn))))
  ([particle-emitter-manager event fn context]
   (phaser->clj
    (.on particle-emitter-manager
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([particle-emitter-manager event fn]
   (phaser->clj
    (.once particle-emitter-manager
           (clj->phaser event)
           (clj->phaser fn))))
  ([particle-emitter-manager event fn context]
   (phaser->clj
    (.once particle-emitter-manager
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "Pauses this Emitter Manager.

  This has the effect of pausing all emitters, and all particles of those emitters, currently under its control.

  The particles will still render, but they will not have any of their logic updated.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - This Emitter Manager."
  ([particle-emitter-manager]
   (phaser->clj
    (.pause particle-emitter-manager))))

(defn pre-update
  "Updates all active emitters.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * time (integer) - The current timestamp as generated by the Request Animation Frame or SetTimeout.
    * delta (number) - The delta time, in ms, elapsed since the last frame."
  ([particle-emitter-manager time delta]
   (phaser->clj
    (.preUpdate particle-emitter-manager
                (clj->phaser time)
                (clj->phaser delta)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([particle-emitter-manager]
   (phaser->clj
    (.removeAllListeners particle-emitter-manager)))
  ([particle-emitter-manager event]
   (phaser->clj
    (.removeAllListeners particle-emitter-manager
                         (clj->phaser event)))))

(defn remove-interactive
  "If this Game Object has previously been enabled for input, this will queue it
  for removal, causing it to no longer be interactive. The removal happens on
  the next game step, it is not immediate.

  The Interactive Object that was assigned to this Game Object will be destroyed,
  removed from the Input Manager and cleared from this Game Object.

  If you wish to re-enable this Game Object at a later date you will need to
  re-create its InteractiveObject by calling `setInteractive` again.

  If you wish to only temporarily stop an object from receiving input then use
  `disableInteractive` instead, as that toggles the interactive state, where-as
  this erases it completely.

  If you wish to resize a hit area, don't remove and then set it as being
  interactive. Instead, access the hitarea object directly and resize the shape
  being used. I.e.: `sprite.input.hitArea.setSize(width, height)` (assuming the
  shape is a Rectangle, which it is by default.)

  Returns:  this - This GameObject."
  ([particle-emitter-manager]
   (phaser->clj
    (.removeInteractive particle-emitter-manager))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([particle-emitter-manager event]
   (phaser->clj
    (.removeListener particle-emitter-manager
                     (clj->phaser event))))
  ([particle-emitter-manager event fn]
   (phaser->clj
    (.removeListener particle-emitter-manager
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([particle-emitter-manager event fn context]
   (phaser->clj
    (.removeListener particle-emitter-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([particle-emitter-manager event fn context once]
   (phaser->clj
    (.removeListener particle-emitter-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([particle-emitter-manager]
   (phaser->clj
    (.resetPipeline particle-emitter-manager))))

(defn resume
  "Resumes this Emitter Manager, should it have been previously paused.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - This Emitter Manager."
  ([particle-emitter-manager]
   (phaser->clj
    (.resume particle-emitter-manager))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([particle-emitter-manager value]
   (phaser->clj
    (.setActive particle-emitter-manager
                (clj->phaser value)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.setAngle particle-emitter-manager)))
  ([particle-emitter-manager degrees]
   (phaser->clj
    (.setAngle particle-emitter-manager
               (clj->phaser degrees)))))

(defn set-data
  "Allows you to store a key value pair within this Game Objects Data Manager.

  If the Game Object has not been enabled for data (via `setDataEnabled`) then it will be enabled
  before setting the value.

  If the key doesn't already exist in the Data Manager then it is created.

  ```javascript
  sprite.setData('name', 'Red Gem Stone');
  ```

  You can also pass in an object of key value pairs as the first argument:

  ```javascript
  sprite.setData({ name: 'Red Gem Stone', level: 2, owner: 'Link', gold: 50 });
  ```

  To get a value back again you can call `getData`:

  ```javascript
  sprite.getData('gold');
  ```

  Or you can access the value directly via the `values` property, where it works like any other variable:

  ```javascript
  sprite.data.values.gold += 50;
  ```

  When the value is first set, a `setdata` event is emitted from this Game Object.

  If the key already exists, a `changedata` event is emitted instead, along an event named after the key.
  For example, if you updated an existing key called `PlayerLives` then it would emit the event `changedata-PlayerLives`.
  These events will be emitted regardless if you use this method to set the value, or the direct `values` setter.

  Please note that the data keys are case-sensitive and must be valid JavaScript Object property strings.
  This means the keys `gold` and `Gold` are treated as two unique values within the Data Manager.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([particle-emitter-manager key]
   (phaser->clj
    (.setData particle-emitter-manager
              (clj->phaser key))))
  ([particle-emitter-manager key data]
   (phaser->clj
    (.setData particle-emitter-manager
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([particle-emitter-manager]
   (phaser->clj
    (.setDataEnabled particle-emitter-manager))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager value]
   (phaser->clj
    (.setDepth particle-emitter-manager
               (clj->phaser value)))))

(defn set-emitter-frames
  "Assigns texture frames to an emitter.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * frames (Phaser.Textures.Frame | Array.<Phaser.Textures.Frame>) - The texture frames.
    * emitter (Phaser.GameObjects.Particles.ParticleEmitter) - The particle emitter to modify.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - This Emitter Manager."
  ([particle-emitter-manager frames emitter]
   (phaser->clj
    (.setEmitterFrames particle-emitter-manager
                       (clj->phaser frames)
                       (clj->phaser emitter)))))

(defn set-frame
  "Sets the frame this Emitter Manager will use to render with.

  The Frame has to belong to the current Texture being used.

  It can be either a string or an index.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - This Emitter Manager."
  ([particle-emitter-manager]
   (phaser->clj
    (.setFrame particle-emitter-manager)))
  ([particle-emitter-manager frame]
   (phaser->clj
    (.setFrame particle-emitter-manager
               (clj->phaser frame)))))

(defn set-interactive
  "Pass this Game Object to the Input Manager to enable it for Input.

  Input works by using hit areas, these are nearly always geometric shapes, such as rectangles or circles, that act as the hit area
  for the Game Object. However, you can provide your own hit area shape and callback, should you wish to handle some more advanced
  input detection.

  If no arguments are provided it will try and create a rectangle hit area based on the texture frame the Game Object is using. If
  this isn't a texture-bound object, such as a Graphics or BitmapText object, this will fail, and you'll need to provide a specific
  shape for it to use.

  You can also provide an Input Configuration Object as the only argument to this method.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([particle-emitter-manager]
   (phaser->clj
    (.setInteractive particle-emitter-manager)))
  ([particle-emitter-manager shape]
   (phaser->clj
    (.setInteractive particle-emitter-manager
                     (clj->phaser shape))))
  ([particle-emitter-manager shape callback]
   (phaser->clj
    (.setInteractive particle-emitter-manager
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([particle-emitter-manager shape callback drop-zone]
   (phaser->clj
    (.setInteractive particle-emitter-manager
                     (clj->phaser shape)
                     (clj->phaser callback)
                     (clj->phaser drop-zone)))))

(defn set-mask
  "Sets the mask that this Game Object will use to render with.

  The mask must have been previously created and can be either a GeometryMask or a BitmapMask.
  Note: Bitmap Masks only work on WebGL. Geometry Masks work on both WebGL and Canvas.

  If a mask is already set on this Game Object it will be immediately replaced.

  Masks are positioned in global space and are not relative to the Game Object to which they
  are applied. The reason for this is that multiple Game Objects can all share the same mask.

  Masks have no impact on physics or input detection. They are purely a rendering component
  that allows you to limit what is visible during the render pass.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager mask]
   (phaser->clj
    (.setMask particle-emitter-manager
              (clj->phaser mask)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([particle-emitter-manager value]
   (phaser->clj
    (.setName particle-emitter-manager
              (clj->phaser value)))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager pipeline-name]
   (phaser->clj
    (.setPipeline particle-emitter-manager
                  (clj->phaser pipeline-name)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.setPosition particle-emitter-manager)))
  ([particle-emitter-manager x]
   (phaser->clj
    (.setPosition particle-emitter-manager
                  (clj->phaser x))))
  ([particle-emitter-manager x y]
   (phaser->clj
    (.setPosition particle-emitter-manager
                  (clj->phaser x)
                  (clj->phaser y))))
  ([particle-emitter-manager x y z]
   (phaser->clj
    (.setPosition particle-emitter-manager
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([particle-emitter-manager x y z w]
   (phaser->clj
    (.setPosition particle-emitter-manager
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z)
                  (clj->phaser w)))))

(defn set-random-position
  "Sets the position of this Game Object to be a random position within the confines of
  the given area.

  If no area is specified a random position between 0 x 0 and the game width x height is used instead.

  The position does not factor in the size of this Game Object, meaning that only the origin is
  guaranteed to be within the area.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.setRandomPosition particle-emitter-manager)))
  ([particle-emitter-manager x]
   (phaser->clj
    (.setRandomPosition particle-emitter-manager
                        (clj->phaser x))))
  ([particle-emitter-manager x y]
   (phaser->clj
    (.setRandomPosition particle-emitter-manager
                        (clj->phaser x)
                        (clj->phaser y))))
  ([particle-emitter-manager x y width]
   (phaser->clj
    (.setRandomPosition particle-emitter-manager
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([particle-emitter-manager x y width height]
   (phaser->clj
    (.setRandomPosition particle-emitter-manager
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.setRotation particle-emitter-manager)))
  ([particle-emitter-manager radians]
   (phaser->clj
    (.setRotation particle-emitter-manager
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager x]
   (phaser->clj
    (.setScale particle-emitter-manager
               (clj->phaser x))))
  ([particle-emitter-manager x y]
   (phaser->clj
    (.setScale particle-emitter-manager
               (clj->phaser x)
               (clj->phaser y)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([particle-emitter-manager value]
   (phaser->clj
    (.setState particle-emitter-manager
               (clj->phaser value)))))

(defn set-texture
  "Sets the texture and frame this Emitter Manager will use to render with.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * key (string) - The key of the texture to be used, as stored in the Texture Manager.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - This Emitter Manager."
  ([particle-emitter-manager key]
   (phaser->clj
    (.setTexture particle-emitter-manager
                 (clj->phaser key))))
  ([particle-emitter-manager key frame]
   (phaser->clj
    (.setTexture particle-emitter-manager
                 (clj->phaser key)
                 (clj->phaser frame)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager value]
   (phaser->clj
    (.setVisible particle-emitter-manager
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.setW particle-emitter-manager)))
  ([particle-emitter-manager value]
   (phaser->clj
    (.setW particle-emitter-manager
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.setX particle-emitter-manager)))
  ([particle-emitter-manager value]
   (phaser->clj
    (.setX particle-emitter-manager
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.setY particle-emitter-manager)))
  ([particle-emitter-manager value]
   (phaser->clj
    (.setY particle-emitter-manager
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter-manager]
   (phaser->clj
    (.setZ particle-emitter-manager)))
  ([particle-emitter-manager value]
   (phaser->clj
    (.setZ particle-emitter-manager
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([particle-emitter-manager]
   (phaser->clj
    (.shutdown particle-emitter-manager))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([particle-emitter-manager]
   (phaser->clj
    (.toJSON particle-emitter-manager))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * args (*) {optional} - args"
  ([particle-emitter-manager]
   (phaser->clj
    (.update particle-emitter-manager)))
  ([particle-emitter-manager args]
   (phaser->clj
    (.update particle-emitter-manager
             (clj->phaser args)))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * particle-emitter-manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([particle-emitter-manager camera]
   (phaser->clj
    (.willRender particle-emitter-manager
                 (clj->phaser camera)))))