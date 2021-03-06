(ns phzr.physics.matter.sprite
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Sprite
  "  Parameters:
    * world (Phaser.Physics.Matter.World) - [description]
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.
    * options (object) {optional} - Matter.js configuration object."
  ([world x y texture]
   (js/Phaser.Physics.Matter.Sprite. (clj->phaser world)
                                     (clj->phaser x)
                                     (clj->phaser y)
                                     (clj->phaser texture)))
  ([world x y texture frame]
   (js/Phaser.Physics.Matter.Sprite. (clj->phaser world)
                                     (clj->phaser x)
                                     (clj->phaser y)
                                     (clj->phaser texture)
                                     (clj->phaser frame)))
  ([world x y texture frame options]
   (js/Phaser.Physics.Matter.Sprite. (clj->phaser world)
                                     (clj->phaser x)
                                     (clj->phaser y)
                                     (clj->phaser texture)
                                     (clj->phaser frame)
                                     (clj->phaser options))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([sprite event fn]
   (phaser->clj
    (.addListener sprite
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([sprite event fn context]
   (phaser->clj
    (.addListener sprite
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn apply-force
  "Applies a force to a body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * force (Phaser.Math.Vector2) - A Vector that specifies the force to apply.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite force]
   (phaser->clj
    (.applyForce sprite
                 (clj->phaser force)))))

(defn apply-force-from
  "Applies a force to a body from a given position.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * position (Phaser.Math.Vector2) - The position in which the force comes from.
    * force (Phaser.Math.Vector2) - A Vector that specifies the force to apply.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite position force]
   (phaser->clj
    (.applyForceFrom sprite
                     (clj->phaser position)
                     (clj->phaser force)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.clearAlpha sprite))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.clearMask sprite)))
  ([sprite destroy-mask]
   (phaser->clj
    (.clearMask sprite
                (clj->phaser destroy-mask)))))

(defn clear-tint
  "Clears all tint values associated with this Game Object.

  Immediately sets the color values back to 0xffffff and the tint type to 'additive',
  which results in no visible change to the texture.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.clearTint sprite))))

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
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([sprite]
   (phaser->clj
    (.createBitmapMask sprite)))
  ([sprite renderable]
   (phaser->clj
    (.createBitmapMask sprite
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([sprite]
   (phaser->clj
    (.createGeometryMask sprite)))
  ([sprite graphics]
   (phaser->clj
    (.createGeometryMask sprite
                         (clj->phaser graphics)))))

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
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([sprite]
   (phaser->clj
    (.destroy sprite)))
  ([sprite from-scene]
   (phaser->clj
    (.destroy sprite
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([sprite]
   (phaser->clj
    (.disableInteractive sprite))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([sprite event]
   (phaser->clj
    (.emit sprite
           (clj->phaser event))))
  ([sprite event args]
   (phaser->clj
    (.emit sprite
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([sprite]
   (phaser->clj
    (.eventNames sprite))))

(defn get-bottom-center
  "Gets the bottom-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getBottomCenter sprite)))
  ([sprite output]
   (phaser->clj
    (.getBottomCenter sprite
                      (clj->phaser output))))
  ([sprite output include-parent]
   (phaser->clj
    (.getBottomCenter sprite
                      (clj->phaser output)
                      (clj->phaser include-parent)))))

(defn get-bottom-left
  "Gets the bottom-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getBottomLeft sprite)))
  ([sprite output]
   (phaser->clj
    (.getBottomLeft sprite
                    (clj->phaser output))))
  ([sprite output include-parent]
   (phaser->clj
    (.getBottomLeft sprite
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-bottom-right
  "Gets the bottom-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getBottomRight sprite)))
  ([sprite output]
   (phaser->clj
    (.getBottomRight sprite
                     (clj->phaser output))))
  ([sprite output include-parent]
   (phaser->clj
    (.getBottomRight sprite
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-bounds
  "Gets the bounds of this Game Object, regardless of origin.
  The values are stored and returned in a Rectangle, or Rectangle-like, object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Geom.Rectangle | object) {optional} - An object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getBounds sprite)))
  ([sprite output]
   (phaser->clj
    (.getBounds sprite
                (clj->phaser output)))))

(defn get-center
  "Gets the center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getCenter sprite)))
  ([sprite output]
   (phaser->clj
    (.getCenter sprite
                (clj->phaser output)))))

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
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([sprite key]
   (phaser->clj
    (.getData sprite
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([sprite]
   (phaser->clj
    (.getIndexList sprite))))

(defn get-left-center
  "Gets the left-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getLeftCenter sprite)))
  ([sprite output]
   (phaser->clj
    (.getLeftCenter sprite
                    (clj->phaser output))))
  ([sprite output include-parent]
   (phaser->clj
    (.getLeftCenter sprite
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([sprite]
   (phaser->clj
    (.getLocalTransformMatrix sprite)))
  ([sprite temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix sprite
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([sprite]
   (phaser->clj
    (.getParentRotation sprite))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([sprite]
   (phaser->clj
    (.getPipelineName sprite))))

(defn get-right-center
  "Gets the right-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getRightCenter sprite)))
  ([sprite output]
   (phaser->clj
    (.getRightCenter sprite
                     (clj->phaser output))))
  ([sprite output include-parent]
   (phaser->clj
    (.getRightCenter sprite
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-top-center
  "Gets the top-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getTopCenter sprite)))
  ([sprite output]
   (phaser->clj
    (.getTopCenter sprite
                   (clj->phaser output))))
  ([sprite output include-parent]
   (phaser->clj
    (.getTopCenter sprite
                   (clj->phaser output)
                   (clj->phaser include-parent)))))

(defn get-top-left
  "Gets the top-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getTopLeft sprite)))
  ([sprite output]
   (phaser->clj
    (.getTopLeft sprite
                 (clj->phaser output))))
  ([sprite output include-parent]
   (phaser->clj
    (.getTopLeft sprite
                 (clj->phaser output)
                 (clj->phaser include-parent)))))

(defn get-top-right
  "Gets the top-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([sprite]
   (phaser->clj
    (.getTopRight sprite)))
  ([sprite output]
   (phaser->clj
    (.getTopRight sprite
                  (clj->phaser output))))
  ([sprite output include-parent]
   (phaser->clj
    (.getTopRight sprite
                  (clj->phaser output)
                  (clj->phaser include-parent)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([sprite]
   (phaser->clj
    (.getWorldTransformMatrix sprite)))
  ([sprite temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix sprite
                              (clj->phaser temp-matrix))))
  ([sprite temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix sprite
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([sprite]
   (phaser->clj
    (.initPipeline sprite)))
  ([sprite pipeline-name]
   (phaser->clj
    (.initPipeline sprite
                   (clj->phaser pipeline-name)))))

(defn is-sensor
  "[description]

  Returns:  boolean - [description]"
  ([sprite]
   (phaser->clj
    (.isSensor sprite))))

(defn is-static
  "[description]

  Returns:  boolean - [description]"
  ([sprite]
   (phaser->clj
    (.isStatic sprite))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([sprite event]
   (phaser->clj
    (.listenerCount sprite
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([sprite event]
   (phaser->clj
    (.listeners sprite
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([sprite event]
   (phaser->clj
    (.off sprite
          (clj->phaser event))))
  ([sprite event fn]
   (phaser->clj
    (.off sprite
          (clj->phaser event)
          (clj->phaser fn))))
  ([sprite event fn context]
   (phaser->clj
    (.off sprite
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([sprite event fn context once]
   (phaser->clj
    (.off sprite
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([sprite event fn]
   (phaser->clj
    (.on sprite
         (clj->phaser event)
         (clj->phaser fn))))
  ([sprite event fn context]
   (phaser->clj
    (.on sprite
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([sprite event fn]
   (phaser->clj
    (.once sprite
           (clj->phaser event)
           (clj->phaser fn))))
  ([sprite event fn context]
   (phaser->clj
    (.once sprite
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn play
  "Start playing the given animation.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * key (string) - The string-based key of the animation to play.
    * ignore-if-playing (boolean) {optional} - If an animation is already playing then ignore this call.
    * start-frame (integer) {optional} - Optionally start the animation playing from this frame index.

  Returns:  Phaser.GameObjects.Sprite - This Game Object."
  ([sprite key]
   (phaser->clj
    (.play sprite
           (clj->phaser key))))
  ([sprite key ignore-if-playing]
   (phaser->clj
    (.play sprite
           (clj->phaser key)
           (clj->phaser ignore-if-playing))))
  ([sprite key ignore-if-playing start-frame]
   (phaser->clj
    (.play sprite
           (clj->phaser key)
           (clj->phaser ignore-if-playing)
           (clj->phaser start-frame)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([sprite]
   (phaser->clj
    (.removeAllListeners sprite)))
  ([sprite event]
   (phaser->clj
    (.removeAllListeners sprite
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
  ([sprite]
   (phaser->clj
    (.removeInteractive sprite))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([sprite event]
   (phaser->clj
    (.removeListener sprite
                     (clj->phaser event))))
  ([sprite event fn]
   (phaser->clj
    (.removeListener sprite
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([sprite event fn context]
   (phaser->clj
    (.removeListener sprite
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([sprite event fn context once]
   (phaser->clj
    (.removeListener sprite
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-flip
  "Resets the horizontal and vertical flipped state of this Game Object back to their default un-flipped state.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.resetFlip sprite))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([sprite]
   (phaser->clj
    (.resetPipeline sprite))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([sprite value]
   (phaser->clj
    (.setActive sprite
                (clj->phaser value)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setAlpha sprite)))
  ([sprite top-left]
   (phaser->clj
    (.setAlpha sprite
               (clj->phaser top-left))))
  ([sprite top-left top-right]
   (phaser->clj
    (.setAlpha sprite
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([sprite top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha sprite
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([sprite top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha sprite
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setAngle sprite)))
  ([sprite degrees]
   (phaser->clj
    (.setAngle sprite
               (clj->phaser degrees)))))

(defn set-angular-velocity
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setAngularVelocity sprite
                         (clj->phaser value)))))

(defn set-blend-mode
  "Sets the Blend Mode being used by this Game Object.

  This can be a const, such as `Phaser.BlendModes.SCREEN`, or an integer, such as 4 (for Overlay)

  Under WebGL only the following Blend Modes are available:

  * ADD
  * MULTIPLY
  * SCREEN
  * ERASE (only works when rendering to a framebuffer, like a Render Texture)

  Canvas has more available depending on browser support.

  You can also create your own custom Blend Modes in WebGL.

  Blend modes have different effects under Canvas and WebGL, and from browser to browser, depending
  on support. Blend Modes also cause a WebGL batch flush should it encounter a new blend mode. For these
  reasons try to be careful about the construction of your Scene and the frequency in which blend modes
  are used.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([sprite value]
   (phaser->clj
    (.setBlendMode sprite
                   (clj->phaser value)))))

(defn set-body
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * config (object) - [description]
    * options (object) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite config options]
   (phaser->clj
    (.setBody sprite
              (clj->phaser config)
              (clj->phaser options)))))

(defn set-bounce
  "Sets the restitution on the physics object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - A Number that defines the restitution (elasticity) of the body. The value is always positive and is in the range (0, 1). A value of 0 means collisions may be perfectly inelastic and no bouncing may occur. A value of 0.8 means the body may bounce back with approximately 80% of its kinetic energy. Note that collision response is based on pairs of bodies, and that restitution values are combined with the following formula: `Math.max(bodyA.restitution, bodyB.restitution)`

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setBounce sprite
                (clj->phaser value)))))

(defn set-circle
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * radius (number) - [description]
    * options (object) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite radius options]
   (phaser->clj
    (.setCircle sprite
                (clj->phaser radius)
                (clj->phaser options)))))

(defn set-collides-with
  "Sets the collision mask for this Game Object's Matter Body. Two Matter Bodies with different collision groups will only collide if each one includes the other's category in its mask based on a bitwise AND, i.e. `(categoryA & maskB) !== 0` and `(categoryB & maskA) !== 0` are both true.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * categories (number | Array.<number>) - A unique category bitfield, or an array of them.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite categories]
   (phaser->clj
    (.setCollidesWith sprite
                      (clj->phaser categories)))))

(defn set-collision-category
  "Sets the collision category of this Game Object's Matter Body. This number must be a power of two between 2^0 (= 1) and 2^31. Two bodies with different collision groups (see {@link #setCollisionGroup}) will only collide if their collision categories are included in their collision masks (see {@link #setCollidesWith}).

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - Unique category bitfield.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setCollisionCategory sprite
                           (clj->phaser value)))))

(defn set-collision-group
  "Sets the collision group of this Game Object's Matter Body. If this is zero or two Matter Bodies have different values, they will collide according to the usual rules (see {@link #setCollisionCategory} and {@link #setCollisionGroup}). If two Matter Bodies have the same positive value, they will always collide; if they have the same negative value, they will never collide.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - Unique group index.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setCollisionGroup sprite
                        (clj->phaser value)))))

(defn set-crop
  "Applies a crop to a texture based Game Object, such as a Sprite or Image.

  The crop is a rectangle that limits the area of the texture frame that is visible during rendering.

  Cropping a Game Object does not change its size, dimensions, physics body or hit area, it just
  changes what is shown when rendered.

  The crop coordinates are relative to the texture frame, not the Game Object, meaning 0 x 0 is the top-left.

  Therefore, if you had a Game Object that had an 800x600 sized texture, and you wanted to show only the left
  half of it, you could call `setCrop(0, 0, 400, 600)`.

  It is also scaled to match the Game Object scale automatically. Therefore a crop rect of 100x50 would crop
  an area of 200x100 when applied to a Game Object that had a scale factor of 2.

  You can either pass in numeric values directly, or you can provide a single Rectangle object as the first argument.

  Call this method with no arguments at all to reset the crop, or toggle the property `isCropped` to `false`.

  You should do this if the crop rectangle becomes the same size as the frame itself, as it will allow
  the renderer to skip several internal calculations.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number | Phaser.Geom.Rectangle) {optional} - The x coordinate to start the crop from. Or a Phaser.Geom.Rectangle object, in which case the rest of the arguments are ignored.
    * y (number) {optional} - The y coordinate to start the crop from.
    * width (number) {optional} - The width of the crop rectangle in pixels.
    * height (number) {optional} - The height of the crop rectangle in pixels.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setCrop sprite)))
  ([sprite x]
   (phaser->clj
    (.setCrop sprite
              (clj->phaser x))))
  ([sprite x y]
   (phaser->clj
    (.setCrop sprite
              (clj->phaser x)
              (clj->phaser y))))
  ([sprite x y width]
   (phaser->clj
    (.setCrop sprite
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width))))
  ([sprite x y width height]
   (phaser->clj
    (.setCrop sprite
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width)
              (clj->phaser height)))))

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
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([sprite key]
   (phaser->clj
    (.setData sprite
              (clj->phaser key))))
  ([sprite key data]
   (phaser->clj
    (.setData sprite
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([sprite]
   (phaser->clj
    (.setDataEnabled sprite))))

(defn set-density
  "Sets density of the body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - The new density of the body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setDensity sprite
                 (clj->phaser value)))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite value]
   (phaser->clj
    (.setDepth sprite
               (clj->phaser value)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setDisplayOrigin sprite)))
  ([sprite x]
   (phaser->clj
    (.setDisplayOrigin sprite
                       (clj->phaser x))))
  ([sprite x y]
   (phaser->clj
    (.setDisplayOrigin sprite
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite width height]
   (phaser->clj
    (.setDisplaySize sprite
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-existing-body
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * body (MatterJS.Body) - [description]
    * add-to-world (boolean) {optional} - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite body]
   (phaser->clj
    (.setExistingBody sprite
                      (clj->phaser body))))
  ([sprite body add-to-world]
   (phaser->clj
    (.setExistingBody sprite
                      (clj->phaser body)
                      (clj->phaser add-to-world)))))

(defn set-fixed-rotation
  "[description]

  Returns:  this - This Game Object."
  ([sprite]
   (phaser->clj
    (.setFixedRotation sprite))))

(defn set-flip
  "Sets the horizontal and vertical flipped state of this Game Object.

  A Game Object that is flipped will render inversed on the flipped axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.
    * y (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([sprite x y]
   (phaser->clj
    (.setFlip sprite
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-flip-x
  "Sets the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([sprite value]
   (phaser->clj
    (.setFlipX sprite
               (clj->phaser value)))))

(defn set-flip-y
  "Sets the vertical flipped state of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([sprite value]
   (phaser->clj
    (.setFlipY sprite
               (clj->phaser value)))))

(defn set-frame
  "Sets the frame this Game Object will use to render with.

  The Frame has to belong to the current Texture being used.

  It can be either a string or an index.

  Calling `setFrame` will modify the `width` and `height` properties of your Game Object.
  It will also change the `origin` if the Frame has a custom pivot point, as exported from packages like Texture Packer.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * frame (string | integer) - The name or index of the frame within the Texture.
    * update-size (boolean) {optional} - Should this call adjust the size of the Game Object?
    * update-origin (boolean) {optional} - Should this call adjust the origin of the Game Object?

  Returns:  this - This Game Object instance."
  ([sprite frame]
   (phaser->clj
    (.setFrame sprite
               (clj->phaser frame))))
  ([sprite frame update-size]
   (phaser->clj
    (.setFrame sprite
               (clj->phaser frame)
               (clj->phaser update-size))))
  ([sprite frame update-size update-origin]
   (phaser->clj
    (.setFrame sprite
               (clj->phaser frame)
               (clj->phaser update-size)
               (clj->phaser update-origin)))))

(defn set-friction
  "Sets new friction values for this Game Object's Matter Body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - The new friction of the body, between 0 and 1, where 0 allows the Body to slide indefinitely, while 1 allows it to stop almost immediately after a force is applied.
    * air (number) {optional} - If provided, the new air resistance of the Body. The higher the value, the faster the Body will slow as it moves through space. 0 means the body has no air resistance.
    * fstatic (number) {optional} - If provided, the new static friction of the Body. The higher the value (e.g. 10), the more force it will take to initially get the Body moving when it is nearly stationary. 0 means the body will never 'stick' when it is nearly stationary.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setFriction sprite
                  (clj->phaser value))))
  ([sprite value air]
   (phaser->clj
    (.setFriction sprite
                  (clj->phaser value)
                  (clj->phaser air))))
  ([sprite value air fstatic]
   (phaser->clj
    (.setFriction sprite
                  (clj->phaser value)
                  (clj->phaser air)
                  (clj->phaser fstatic)))))

(defn set-friction-air
  "Sets a new air resistance for this Game Object's Matter Body. A value of 0 means the Body will never slow as it moves through space. The higher the value, the faster a Body slows when moving through space.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - The new air resistance for the Body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setFrictionAir sprite
                     (clj->phaser value)))))

(defn set-friction-static
  "Sets a new static friction for this Game Object's Matter Body. A value of 0 means the Body will never 'stick' when it is nearly stationary. The higher the value (e.g. 10), the more force it will take to initially get the Body moving when it is nearly stationary.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - The new static friction for the Body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setFrictionStatic sprite
                        (clj->phaser value)))))

(defn set-ignore-gravity
  "A togglable function for ignoring world gravity in real-time on the current body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - Set to true to ignore the effect of world gravity, or false to not ignore it.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setIgnoreGravity sprite
                       (clj->phaser value)))))

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
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([sprite]
   (phaser->clj
    (.setInteractive sprite)))
  ([sprite shape]
   (phaser->clj
    (.setInteractive sprite
                     (clj->phaser shape))))
  ([sprite shape callback]
   (phaser->clj
    (.setInteractive sprite
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([sprite shape callback drop-zone]
   (phaser->clj
    (.setInteractive sprite
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
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([sprite mask]
   (phaser->clj
    (.setMask sprite
              (clj->phaser mask)))))

(defn set-mass
  "Sets the mass of the Game Object's Matter Body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) - The new mass of the body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setMass sprite
              (clj->phaser value)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([sprite value]
   (phaser->clj
    (.setName sprite
              (clj->phaser value)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setOrigin sprite)))
  ([sprite x]
   (phaser->clj
    (.setOrigin sprite
                (clj->phaser x))))
  ([sprite x y]
   (phaser->clj
    (.setOrigin sprite
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setOriginFromFrame sprite))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite pipeline-name]
   (phaser->clj
    (.setPipeline sprite
                  (clj->phaser pipeline-name)))))

(defn set-polygon
  "Set the body on the Game Object to a polygon shape.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * radius (number) - The radius of the polygon.
    * sides (number) - The amount of sides creating the polygon.
    * options (object) - A matterjs config object.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite radius sides options]
   (phaser->clj
    (.setPolygon sprite
                 (clj->phaser radius)
                 (clj->phaser sides)
                 (clj->phaser options)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setPosition sprite)))
  ([sprite x]
   (phaser->clj
    (.setPosition sprite
                  (clj->phaser x))))
  ([sprite x y]
   (phaser->clj
    (.setPosition sprite
                  (clj->phaser x)
                  (clj->phaser y))))
  ([sprite x y z]
   (phaser->clj
    (.setPosition sprite
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([sprite x y z w]
   (phaser->clj
    (.setPosition sprite
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
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setRandomPosition sprite)))
  ([sprite x]
   (phaser->clj
    (.setRandomPosition sprite
                        (clj->phaser x))))
  ([sprite x y]
   (phaser->clj
    (.setRandomPosition sprite
                        (clj->phaser x)
                        (clj->phaser y))))
  ([sprite x y width]
   (phaser->clj
    (.setRandomPosition sprite
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([sprite x y width height]
   (phaser->clj
    (.setRandomPosition sprite
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rectangle
  "Set the body on a Game Object to a rectangle.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * width (number) - Width of the rectangle.
    * height (number) - Height of the rectangle.
    * options (object) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite width height options]
   (phaser->clj
    (.setRectangle sprite
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser options)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setRotation sprite)))
  ([sprite radians]
   (phaser->clj
    (.setRotation sprite
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([sprite x]
   (phaser->clj
    (.setScale sprite
               (clj->phaser x))))
  ([sprite x y]
   (phaser->clj
    (.setScale sprite
               (clj->phaser x)
               (clj->phaser y)))))

(defn set-scroll-factor
  "Sets the scroll factor of this Game Object.

  The scroll factor controls the influence of the movement of a Camera upon this Game Object.

  When a camera scrolls it will change the location at which this Game Object is rendered on-screen.
  It does not change the Game Objects actual position values.

  A value of 1 means it will move exactly in sync with a camera.
  A value of 0 means it will not move at all, even if the camera moves.
  Other values control the degree to which the camera movement is mapped to this Game Object.

  Please be aware that scroll factor values other than 1 are not taken in to consideration when
  calculating physics collisions. Bodies always collide based on their world position, but changing
  the scroll factor is a visual adjustment to where the textures are rendered, which can offset
  them from physics bodies if not accounted for in your code.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([sprite x]
   (phaser->clj
    (.setScrollFactor sprite
                      (clj->phaser x))))
  ([sprite x y]
   (phaser->clj
    (.setScrollFactor sprite
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-sensor
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setSensor sprite
                (clj->phaser value)))))

(defn set-size
  "Sets the internal size of this Game Object, as used for frame or physics body creation.

  This will not change the size that the Game Object is rendered in-game.
  For that you need to either set the scale of the Game Object (`setScale`) or call the
  `setDisplaySize` method, which is the same thing as changing the scale but allows you
  to do so by giving pixel values.

  If you have enabled this Game Object for input, changing the size will _not_ change the
  size of the hit area. To do this you should adjust the `input.hitArea` object directly.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite width height]
   (phaser->clj
    (.setSize sprite
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-size-to-frame
  "Sets the size of this Game Object to be that of the given Frame.

  This will not change the size that the Game Object is rendered in-game.
  For that you need to either set the scale of the Game Object (`setScale`) or call the
  `setDisplaySize` method, which is the same thing as changing the scale but allows you
  to do so by giving pixel values.

  If you have enabled this Game Object for input, changing the size will _not_ change the
  size of the hit area. To do this you should adjust the `input.hitArea` object directly.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * frame (Phaser.Textures.Frame) - The frame to base the size of this Game Object on.

  Returns:  this - This Game Object instance."
  ([sprite frame]
   (phaser->clj
    (.setSizeToFrame sprite
                     (clj->phaser frame)))))

(defn set-sleep-end-event
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setSleepEndEvent sprite
                       (clj->phaser value)))))

(defn set-sleep-events
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * start (boolean) - [description]
    * end (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite start end]
   (phaser->clj
    (.setSleepEvents sprite
                     (clj->phaser start)
                     (clj->phaser end)))))

(defn set-sleep-start-event
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setSleepStartEvent sprite
                         (clj->phaser value)))))

(defn set-sleep-threshold
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) {optional} - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite]
   (phaser->clj
    (.setSleepThreshold sprite)))
  ([sprite value]
   (phaser->clj
    (.setSleepThreshold sprite
                        (clj->phaser value)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([sprite value]
   (phaser->clj
    (.setState sprite
               (clj->phaser value)))))

(defn set-static
  "[description]

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite value]
   (phaser->clj
    (.setStatic sprite
                (clj->phaser value)))))

(defn set-texture
  "Sets the texture and frame this Game Object will use to render with.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * key (string) - The key of the texture to be used, as stored in the Texture Manager.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.

  Returns:  this - This Game Object instance."
  ([sprite key]
   (phaser->clj
    (.setTexture sprite
                 (clj->phaser key))))
  ([sprite key frame]
   (phaser->clj
    (.setTexture sprite
                 (clj->phaser key)
                 (clj->phaser frame)))))

(defn set-tint
  "Sets an additive tint on this Game Object.

  The tint works by taking the pixel color values from the Game Objects texture, and then
  multiplying it by the color value of the tint. You can provide either one color value,
  in which case the whole Game Object will be tinted in that color. Or you can provide a color
  per corner. The colors are blended together across the extent of the Game Object.

  To modify the tint color once set, either call this method again with new values or use the
  `tint` property to set all colors at once. Or, use the properties `tintTopLeft`, `tintTopRight,
  `tintBottomLeft` and `tintBottomRight` to set the corner color values independently.

  To remove a tint call `clearTint`.

  To swap this from being an additive tint to a fill based tint set the property `tintFill` to `true`.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If no other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setTint sprite)))
  ([sprite top-left]
   (phaser->clj
    (.setTint sprite
              (clj->phaser top-left))))
  ([sprite top-left top-right]
   (phaser->clj
    (.setTint sprite
              (clj->phaser top-left)
              (clj->phaser top-right))))
  ([sprite top-left top-right bottom-left]
   (phaser->clj
    (.setTint sprite
              (clj->phaser top-left)
              (clj->phaser top-right)
              (clj->phaser bottom-left))))
  ([sprite top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTint sprite
              (clj->phaser top-left)
              (clj->phaser top-right)
              (clj->phaser bottom-left)
              (clj->phaser bottom-right)))))

(defn set-tint-fill
  "Sets a fill-based tint on this Game Object.

  Unlike an additive tint, a fill-tint literally replaces the pixel colors from the texture
  with those in the tint. You can use this for effects such as making a player flash 'white'
  if hit by something. You can provide either one color value, in which case the whole
  Game Object will be rendered in that color. Or you can provide a color per corner. The colors
  are blended together across the extent of the Game Object.

  To modify the tint color once set, either call this method again with new values or use the
  `tint` property to set all colors at once. Or, use the properties `tintTopLeft`, `tintTopRight,
  `tintBottomLeft` and `tintBottomRight` to set the corner color values independently.

  To remove a tint call `clearTint`.

  To swap this from being a fill-tint to an additive tint set the property `tintFill` to `false`.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If not other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setTintFill sprite)))
  ([sprite top-left]
   (phaser->clj
    (.setTintFill sprite
                  (clj->phaser top-left))))
  ([sprite top-left top-right]
   (phaser->clj
    (.setTintFill sprite
                  (clj->phaser top-left)
                  (clj->phaser top-right))))
  ([sprite top-left top-right bottom-left]
   (phaser->clj
    (.setTintFill sprite
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left))))
  ([sprite top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTintFill sprite
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left)
                  (clj->phaser bottom-right)))))

(defn set-trapezoid
  "Creates a new matterjs trapezoid body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * width (number) - The width of the trapezoid.
    * height (number) - The height of the trapezoid.
    * slope (number) - The angle of slope for the trapezoid.
    * options (object) - A matterjs config object for the body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite width height slope options]
   (phaser->clj
    (.setTrapezoid sprite
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser slope)
                   (clj->phaser options)))))

(defn set-velocity
  "Sets both the horizontal and vertical velocity of the physics body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number) - The horizontal velocity value.
    * y (number) {optional} - The vertical velocity value, it can be either positive or negative. If not given, it will be the same as the `x` value.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite x]
   (phaser->clj
    (.setVelocity sprite
                  (clj->phaser x))))
  ([sprite x y]
   (phaser->clj
    (.setVelocity sprite
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-velocity-x
  "Sets the horizontal velocity of the physics body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * x (number) - The horizontal velocity value.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite x]
   (phaser->clj
    (.setVelocityX sprite
                   (clj->phaser x)))))

(defn set-velocity-y
  "Sets vertical velocity of the physics body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * y (number) - The vertical velocity value.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite y]
   (phaser->clj
    (.setVelocityY sprite
                   (clj->phaser y)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([sprite value]
   (phaser->clj
    (.setVisible sprite
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setW sprite)))
  ([sprite value]
   (phaser->clj
    (.setW sprite
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setX sprite)))
  ([sprite value]
   (phaser->clj
    (.setX sprite
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setY sprite)))
  ([sprite value]
   (phaser->clj
    (.setY sprite
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.setZ sprite)))
  ([sprite value]
   (phaser->clj
    (.setZ sprite
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([sprite]
   (phaser->clj
    (.shutdown sprite))))

(defn thrust
  "Apply thrust to the forward position of the body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * speed (number) - A speed value to be applied to a directional force.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite speed]
   (phaser->clj
    (.thrust sprite
             (clj->phaser speed)))))

(defn thrust-back
  "Apply thrust to the back position of the body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * speed (number) - A speed value to be applied to a directional force.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite speed]
   (phaser->clj
    (.thrustBack sprite
                 (clj->phaser speed)))))

(defn thrust-left
  "Apply thrust to the left position of the body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * speed (number) - A speed value to be applied to a directional force.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite speed]
   (phaser->clj
    (.thrustLeft sprite
                 (clj->phaser speed)))))

(defn thrust-right
  "Apply thrust to the right position of the body.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * speed (number) - A speed value to be applied to a directional force.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([sprite speed]
   (phaser->clj
    (.thrustRight sprite
                  (clj->phaser speed)))))

(defn to-json
  "Build a JSON representation of this Sprite.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([sprite]
   (phaser->clj
    (.toJSON sprite))))

(defn toggle-flip-x
  "Toggles the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.toggleFlipX sprite))))

(defn toggle-flip-y
  "Toggles the vertical flipped state of this Game Object.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.toggleFlipY sprite))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * args (*) {optional} - args"
  ([sprite]
   (phaser->clj
    (.update sprite)))
  ([sprite args]
   (phaser->clj
    (.update sprite
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([sprite]
   (phaser->clj
    (.updateDisplayOrigin sprite))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * sprite (Phaser.Physics.Matter.Sprite) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([sprite camera]
   (phaser->clj
    (.willRender sprite
                 (clj->phaser camera)))))