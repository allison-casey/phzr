(ns phzr.physics.impact.impact-sprite
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->ImpactSprite
  "  Parameters:
    * world (Phaser.Physics.Impact.World) - [description]
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with."
  ([world x y texture]
   (js/Phaser.Physics.Impact.ImpactSprite. (clj->phaser world)
                                           (clj->phaser x)
                                           (clj->phaser y)
                                           (clj->phaser texture)))
  ([world x y texture frame]
   (js/Phaser.Physics.Impact.ImpactSprite. (clj->phaser world)
                                           (clj->phaser x)
                                           (clj->phaser y)
                                           (clj->phaser texture)
                                           (clj->phaser frame))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([impact-sprite event fn]
   (phaser->clj
    (.addListener impact-sprite
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([impact-sprite event fn context]
   (phaser->clj
    (.addListener impact-sprite
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.clearAlpha impact-sprite))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.clearMask impact-sprite)))
  ([impact-sprite destroy-mask]
   (phaser->clj
    (.clearMask impact-sprite
                (clj->phaser destroy-mask)))))

(defn clear-tint
  "Clears all tint values associated with this Game Object.

  Immediately sets the color values back to 0xffffff and the tint type to 'additive',
  which results in no visible change to the texture.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.clearTint impact-sprite))))

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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([impact-sprite]
   (phaser->clj
    (.createBitmapMask impact-sprite)))
  ([impact-sprite renderable]
   (phaser->clj
    (.createBitmapMask impact-sprite
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([impact-sprite]
   (phaser->clj
    (.createGeometryMask impact-sprite)))
  ([impact-sprite graphics]
   (phaser->clj
    (.createGeometryMask impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([impact-sprite]
   (phaser->clj
    (.destroy impact-sprite)))
  ([impact-sprite from-scene]
   (phaser->clj
    (.destroy impact-sprite
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([impact-sprite]
   (phaser->clj
    (.disableInteractive impact-sprite))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([impact-sprite event]
   (phaser->clj
    (.emit impact-sprite
           (clj->phaser event))))
  ([impact-sprite event args]
   (phaser->clj
    (.emit impact-sprite
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([impact-sprite]
   (phaser->clj
    (.eventNames impact-sprite))))

(defn get-body-type
  "[description]

  Returns:  number - [description]"
  ([impact-sprite]
   (phaser->clj
    (.getBodyType impact-sprite))))

(defn get-bottom-center
  "Gets the bottom-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getBottomCenter impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getBottomCenter impact-sprite
                      (clj->phaser output))))
  ([impact-sprite output include-parent]
   (phaser->clj
    (.getBottomCenter impact-sprite
                      (clj->phaser output)
                      (clj->phaser include-parent)))))

(defn get-bottom-left
  "Gets the bottom-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getBottomLeft impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getBottomLeft impact-sprite
                    (clj->phaser output))))
  ([impact-sprite output include-parent]
   (phaser->clj
    (.getBottomLeft impact-sprite
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-bottom-right
  "Gets the bottom-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getBottomRight impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getBottomRight impact-sprite
                     (clj->phaser output))))
  ([impact-sprite output include-parent]
   (phaser->clj
    (.getBottomRight impact-sprite
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-bounds
  "Gets the bounds of this Game Object, regardless of origin.
  The values are stored and returned in a Rectangle, or Rectangle-like, object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Geom.Rectangle | object) {optional} - An object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getBounds impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getBounds impact-sprite
                (clj->phaser output)))))

(defn get-center
  "Gets the center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getCenter impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getCenter impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([impact-sprite key]
   (phaser->clj
    (.getData impact-sprite
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([impact-sprite]
   (phaser->clj
    (.getIndexList impact-sprite))))

(defn get-left-center
  "Gets the left-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getLeftCenter impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getLeftCenter impact-sprite
                    (clj->phaser output))))
  ([impact-sprite output include-parent]
   (phaser->clj
    (.getLeftCenter impact-sprite
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([impact-sprite]
   (phaser->clj
    (.getLocalTransformMatrix impact-sprite)))
  ([impact-sprite temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix impact-sprite
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([impact-sprite]
   (phaser->clj
    (.getParentRotation impact-sprite))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([impact-sprite]
   (phaser->clj
    (.getPipelineName impact-sprite))))

(defn get-right-center
  "Gets the right-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getRightCenter impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getRightCenter impact-sprite
                     (clj->phaser output))))
  ([impact-sprite output include-parent]
   (phaser->clj
    (.getRightCenter impact-sprite
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-top-center
  "Gets the top-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getTopCenter impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getTopCenter impact-sprite
                   (clj->phaser output))))
  ([impact-sprite output include-parent]
   (phaser->clj
    (.getTopCenter impact-sprite
                   (clj->phaser output)
                   (clj->phaser include-parent)))))

(defn get-top-left
  "Gets the top-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getTopLeft impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getTopLeft impact-sprite
                 (clj->phaser output))))
  ([impact-sprite output include-parent]
   (phaser->clj
    (.getTopLeft impact-sprite
                 (clj->phaser output)
                 (clj->phaser include-parent)))))

(defn get-top-right
  "Gets the top-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([impact-sprite]
   (phaser->clj
    (.getTopRight impact-sprite)))
  ([impact-sprite output]
   (phaser->clj
    (.getTopRight impact-sprite
                  (clj->phaser output))))
  ([impact-sprite output include-parent]
   (phaser->clj
    (.getTopRight impact-sprite
                  (clj->phaser output)
                  (clj->phaser include-parent)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([impact-sprite]
   (phaser->clj
    (.getWorldTransformMatrix impact-sprite)))
  ([impact-sprite temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix impact-sprite
                              (clj->phaser temp-matrix))))
  ([impact-sprite temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix impact-sprite
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([impact-sprite]
   (phaser->clj
    (.initPipeline impact-sprite)))
  ([impact-sprite pipeline-name]
   (phaser->clj
    (.initPipeline impact-sprite
                   (clj->phaser pipeline-name)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([impact-sprite event]
   (phaser->clj
    (.listenerCount impact-sprite
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([impact-sprite event]
   (phaser->clj
    (.listeners impact-sprite
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([impact-sprite event]
   (phaser->clj
    (.off impact-sprite
          (clj->phaser event))))
  ([impact-sprite event fn]
   (phaser->clj
    (.off impact-sprite
          (clj->phaser event)
          (clj->phaser fn))))
  ([impact-sprite event fn context]
   (phaser->clj
    (.off impact-sprite
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([impact-sprite event fn context once]
   (phaser->clj
    (.off impact-sprite
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([impact-sprite event fn]
   (phaser->clj
    (.on impact-sprite
         (clj->phaser event)
         (clj->phaser fn))))
  ([impact-sprite event fn context]
   (phaser->clj
    (.on impact-sprite
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([impact-sprite event fn]
   (phaser->clj
    (.once impact-sprite
           (clj->phaser event)
           (clj->phaser fn))))
  ([impact-sprite event fn context]
   (phaser->clj
    (.once impact-sprite
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn play
  "Start playing the given animation.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * key (string) - The string-based key of the animation to play.
    * ignore-if-playing (boolean) {optional} - If an animation is already playing then ignore this call.
    * start-frame (integer) {optional} - Optionally start the animation playing from this frame index.

  Returns:  Phaser.GameObjects.Sprite - This Game Object."
  ([impact-sprite key]
   (phaser->clj
    (.play impact-sprite
           (clj->phaser key))))
  ([impact-sprite key ignore-if-playing]
   (phaser->clj
    (.play impact-sprite
           (clj->phaser key)
           (clj->phaser ignore-if-playing))))
  ([impact-sprite key ignore-if-playing start-frame]
   (phaser->clj
    (.play impact-sprite
           (clj->phaser key)
           (clj->phaser ignore-if-playing)
           (clj->phaser start-frame)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([impact-sprite]
   (phaser->clj
    (.removeAllListeners impact-sprite)))
  ([impact-sprite event]
   (phaser->clj
    (.removeAllListeners impact-sprite
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
  ([impact-sprite]
   (phaser->clj
    (.removeInteractive impact-sprite))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([impact-sprite event]
   (phaser->clj
    (.removeListener impact-sprite
                     (clj->phaser event))))
  ([impact-sprite event fn]
   (phaser->clj
    (.removeListener impact-sprite
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([impact-sprite event fn context]
   (phaser->clj
    (.removeListener impact-sprite
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([impact-sprite event fn context once]
   (phaser->clj
    (.removeListener impact-sprite
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-flip
  "Resets the horizontal and vertical flipped state of this Game Object back to their default un-flipped state.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.resetFlip impact-sprite))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([impact-sprite]
   (phaser->clj
    (.resetPipeline impact-sprite))))

(defn set-acceleration
  "Sets the horizontal and vertical acceleration of this body.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - The amount of horizontal acceleration to apply.
    * y (number) - The amount of vertical acceleration to apply.

  Returns:  this - This Game Object."
  ([impact-sprite x y]
   (phaser->clj
    (.setAcceleration impact-sprite
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-acceleration-x
  "Sets the horizontal acceleration of this body.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - The amount of acceleration to apply.

  Returns:  this - This Game Object."
  ([impact-sprite x]
   (phaser->clj
    (.setAccelerationX impact-sprite
                       (clj->phaser x)))))

(defn set-acceleration-y
  "Sets the vertical acceleration of this body.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * y (number) - The amount of acceleration to apply.

  Returns:  this - This Game Object."
  ([impact-sprite y]
   (phaser->clj
    (.setAccelerationY impact-sprite
                       (clj->phaser y)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([impact-sprite value]
   (phaser->clj
    (.setActive impact-sprite
                (clj->phaser value)))))

(defn set-active-collision
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setActiveCollision impact-sprite))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setAlpha impact-sprite)))
  ([impact-sprite top-left]
   (phaser->clj
    (.setAlpha impact-sprite
               (clj->phaser top-left))))
  ([impact-sprite top-left top-right]
   (phaser->clj
    (.setAlpha impact-sprite
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([impact-sprite top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha impact-sprite
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([impact-sprite top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha impact-sprite
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setAngle impact-sprite)))
  ([impact-sprite degrees]
   (phaser->clj
    (.setAngle impact-sprite
               (clj->phaser degrees)))))

(defn set-avs-b
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setAvsB impact-sprite))))

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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([impact-sprite value]
   (phaser->clj
    (.setBlendMode impact-sprite
                   (clj->phaser value)))))

(defn set-body-scale
  "Sets the scale of the physics body.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * scale-x (number) - The horizontal scale of the body.
    * scale-y (number) {optional} - The vertical scale of the body. If not given, will use the horizontal scale value.

  Returns:  this - This Game Object."
  ([impact-sprite scale-x]
   (phaser->clj
    (.setBodyScale impact-sprite
                   (clj->phaser scale-x))))
  ([impact-sprite scale-x scale-y]
   (phaser->clj
    (.setBodyScale impact-sprite
                   (clj->phaser scale-x)
                   (clj->phaser scale-y)))))

(defn set-body-size
  "Sets the size of the physics body.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * width (number) - The width of the body in pixels.
    * height (number) {optional} - The height of the body in pixels.

  Returns:  this - This Game Object."
  ([impact-sprite width]
   (phaser->clj
    (.setBodySize impact-sprite
                  (clj->phaser width))))
  ([impact-sprite width height]
   (phaser->clj
    (.setBodySize impact-sprite
                  (clj->phaser width)
                  (clj->phaser height)))))

(defn set-bounce
  "Sets the impact physics bounce, or restitution, value.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (number) - A value between 0 (no rebound) and 1 (full rebound)

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite value]
   (phaser->clj
    (.setBounce impact-sprite
                (clj->phaser value)))))

(defn set-bvs-a
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setBvsA impact-sprite))))

(defn set-check-against-a
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setCheckAgainstA impact-sprite))))

(defn set-check-against-b
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setCheckAgainstB impact-sprite))))

(defn set-check-against-none
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setCheckAgainstNone impact-sprite))))

(defn set-collide-callback
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * callback (CollideCallback) - [description]
    * scope (*) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite callback scope]
   (phaser->clj
    (.setCollideCallback impact-sprite
                         (clj->phaser callback)
                         (clj->phaser scope)))))

(defn set-collides-never
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setCollidesNever impact-sprite))))

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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number | Phaser.Geom.Rectangle) {optional} - The x coordinate to start the crop from. Or a Phaser.Geom.Rectangle object, in which case the rest of the arguments are ignored.
    * y (number) {optional} - The y coordinate to start the crop from.
    * width (number) {optional} - The width of the crop rectangle in pixels.
    * height (number) {optional} - The height of the crop rectangle in pixels.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setCrop impact-sprite)))
  ([impact-sprite x]
   (phaser->clj
    (.setCrop impact-sprite
              (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setCrop impact-sprite
              (clj->phaser x)
              (clj->phaser y))))
  ([impact-sprite x y width]
   (phaser->clj
    (.setCrop impact-sprite
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width))))
  ([impact-sprite x y width height]
   (phaser->clj
    (.setCrop impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([impact-sprite key]
   (phaser->clj
    (.setData impact-sprite
              (clj->phaser key))))
  ([impact-sprite key data]
   (phaser->clj
    (.setData impact-sprite
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([impact-sprite]
   (phaser->clj
    (.setDataEnabled impact-sprite))))

(defn set-debug
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * show-body (boolean) - [description]
    * show-velocity (boolean) - [description]
    * body-color (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite show-body show-velocity body-color]
   (phaser->clj
    (.setDebug impact-sprite
               (clj->phaser show-body)
               (clj->phaser show-velocity)
               (clj->phaser body-color)))))

(defn set-debug-body-color
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite value]
   (phaser->clj
    (.setDebugBodyColor impact-sprite
                        (clj->phaser value)))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite value]
   (phaser->clj
    (.setDepth impact-sprite
               (clj->phaser value)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setDisplayOrigin impact-sprite)))
  ([impact-sprite x]
   (phaser->clj
    (.setDisplayOrigin impact-sprite
                       (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setDisplayOrigin impact-sprite
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite width height]
   (phaser->clj
    (.setDisplaySize impact-sprite
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-fixed-collision
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setFixedCollision impact-sprite))))

(defn set-flip
  "Sets the horizontal and vertical flipped state of this Game Object.

  A Game Object that is flipped will render inversed on the flipped axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.
    * y (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([impact-sprite x y]
   (phaser->clj
    (.setFlip impact-sprite
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-flip-x
  "Sets the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([impact-sprite value]
   (phaser->clj
    (.setFlipX impact-sprite
               (clj->phaser value)))))

(defn set-flip-y
  "Sets the vertical flipped state of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([impact-sprite value]
   (phaser->clj
    (.setFlipY impact-sprite
               (clj->phaser value)))))

(defn set-frame
  "Sets the frame this Game Object will use to render with.

  The Frame has to belong to the current Texture being used.

  It can be either a string or an index.

  Calling `setFrame` will modify the `width` and `height` properties of your Game Object.
  It will also change the `origin` if the Frame has a custom pivot point, as exported from packages like Texture Packer.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * frame (string | integer) - The name or index of the frame within the Texture.
    * update-size (boolean) {optional} - Should this call adjust the size of the Game Object?
    * update-origin (boolean) {optional} - Should this call adjust the origin of the Game Object?

  Returns:  this - This Game Object instance."
  ([impact-sprite frame]
   (phaser->clj
    (.setFrame impact-sprite
               (clj->phaser frame))))
  ([impact-sprite frame update-size]
   (phaser->clj
    (.setFrame impact-sprite
               (clj->phaser frame)
               (clj->phaser update-size))))
  ([impact-sprite frame update-size update-origin]
   (phaser->clj
    (.setFrame impact-sprite
               (clj->phaser frame)
               (clj->phaser update-size)
               (clj->phaser update-origin)))))

(defn set-friction
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite x y]
   (phaser->clj
    (.setFriction impact-sprite
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-friction-x
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite x]
   (phaser->clj
    (.setFrictionX impact-sprite
                   (clj->phaser x)))))

(defn set-friction-y
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * y (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite y]
   (phaser->clj
    (.setFrictionY impact-sprite
                   (clj->phaser y)))))

(defn set-game-object
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - [description]
    * sync (boolean) {optional} - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite game-object]
   (phaser->clj
    (.setGameObject impact-sprite
                    (clj->phaser game-object))))
  ([impact-sprite game-object sync]
   (phaser->clj
    (.setGameObject impact-sprite
                    (clj->phaser game-object)
                    (clj->phaser sync)))))

(defn set-gravity
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite value]
   (phaser->clj
    (.setGravity impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([impact-sprite]
   (phaser->clj
    (.setInteractive impact-sprite)))
  ([impact-sprite shape]
   (phaser->clj
    (.setInteractive impact-sprite
                     (clj->phaser shape))))
  ([impact-sprite shape callback]
   (phaser->clj
    (.setInteractive impact-sprite
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([impact-sprite shape callback drop-zone]
   (phaser->clj
    (.setInteractive impact-sprite
                     (clj->phaser shape)
                     (clj->phaser callback)
                     (clj->phaser drop-zone)))))

(defn set-lite-collision
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setLiteCollision impact-sprite))))

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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([impact-sprite mask]
   (phaser->clj
    (.setMask impact-sprite
              (clj->phaser mask)))))

(defn set-max-velocity
  "Sets the maximum velocity this body can travel at.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - The maximum allowed horizontal velocity.
    * y (number) {optional} - The maximum allowed vertical velocity. If not given, defaults to the horizontal value.

  Returns:  this - This Game Object."
  ([impact-sprite x]
   (phaser->clj
    (.setMaxVelocity impact-sprite
                     (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setMaxVelocity impact-sprite
                     (clj->phaser x)
                     (clj->phaser y)))))

(defn set-min-bounce-velocity
  "Sets the minimum velocity the body is allowed to be moving to be considered for rebound.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (number) - The minimum allowed velocity.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite value]
   (phaser->clj
    (.setMinBounceVelocity impact-sprite
                           (clj->phaser value)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([impact-sprite value]
   (phaser->clj
    (.setName impact-sprite
              (clj->phaser value)))))

(defn set-offset
  "[description]

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]
    * width (number) {optional} - [description]
    * height (number) {optional} - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite x y]
   (phaser->clj
    (.setOffset impact-sprite
                (clj->phaser x)
                (clj->phaser y))))
  ([impact-sprite x y width]
   (phaser->clj
    (.setOffset impact-sprite
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width))))
  ([impact-sprite x y width height]
   (phaser->clj
    (.setOffset impact-sprite
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setOrigin impact-sprite)))
  ([impact-sprite x]
   (phaser->clj
    (.setOrigin impact-sprite
                (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setOrigin impact-sprite
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setOriginFromFrame impact-sprite))))

(defn set-passive-collision
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setPassiveCollision impact-sprite))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite pipeline-name]
   (phaser->clj
    (.setPipeline impact-sprite
                  (clj->phaser pipeline-name)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setPosition impact-sprite)))
  ([impact-sprite x]
   (phaser->clj
    (.setPosition impact-sprite
                  (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setPosition impact-sprite
                  (clj->phaser x)
                  (clj->phaser y))))
  ([impact-sprite x y z]
   (phaser->clj
    (.setPosition impact-sprite
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([impact-sprite x y z w]
   (phaser->clj
    (.setPosition impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setRandomPosition impact-sprite)))
  ([impact-sprite x]
   (phaser->clj
    (.setRandomPosition impact-sprite
                        (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setRandomPosition impact-sprite
                        (clj->phaser x)
                        (clj->phaser y))))
  ([impact-sprite x y width]
   (phaser->clj
    (.setRandomPosition impact-sprite
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([impact-sprite x y width height]
   (phaser->clj
    (.setRandomPosition impact-sprite
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setRotation impact-sprite)))
  ([impact-sprite radians]
   (phaser->clj
    (.setRotation impact-sprite
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([impact-sprite x]
   (phaser->clj
    (.setScale impact-sprite
               (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setScale impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([impact-sprite x]
   (phaser->clj
    (.setScrollFactor impact-sprite
                      (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setScrollFactor impact-sprite
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-size
  "Sets the internal size of this Game Object, as used for frame or physics body creation.

  This will not change the size that the Game Object is rendered in-game.
  For that you need to either set the scale of the Game Object (`setScale`) or call the
  `setDisplaySize` method, which is the same thing as changing the scale but allows you
  to do so by giving pixel values.

  If you have enabled this Game Object for input, changing the size will _not_ change the
  size of the hit area. To do this you should adjust the `input.hitArea` object directly.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite width height]
   (phaser->clj
    (.setSize impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * frame (Phaser.Textures.Frame) - The frame to base the size of this Game Object on.

  Returns:  this - This Game Object instance."
  ([impact-sprite frame]
   (phaser->clj
    (.setSizeToFrame impact-sprite
                     (clj->phaser frame)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([impact-sprite value]
   (phaser->clj
    (.setState impact-sprite
               (clj->phaser value)))))

(defn set-texture
  "Sets the texture and frame this Game Object will use to render with.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * key (string) - The key of the texture to be used, as stored in the Texture Manager.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.

  Returns:  this - This Game Object instance."
  ([impact-sprite key]
   (phaser->clj
    (.setTexture impact-sprite
                 (clj->phaser key))))
  ([impact-sprite key frame]
   (phaser->clj
    (.setTexture impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If no other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setTint impact-sprite)))
  ([impact-sprite top-left]
   (phaser->clj
    (.setTint impact-sprite
              (clj->phaser top-left))))
  ([impact-sprite top-left top-right]
   (phaser->clj
    (.setTint impact-sprite
              (clj->phaser top-left)
              (clj->phaser top-right))))
  ([impact-sprite top-left top-right bottom-left]
   (phaser->clj
    (.setTint impact-sprite
              (clj->phaser top-left)
              (clj->phaser top-right)
              (clj->phaser bottom-left))))
  ([impact-sprite top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTint impact-sprite
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
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If not other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setTintFill impact-sprite)))
  ([impact-sprite top-left]
   (phaser->clj
    (.setTintFill impact-sprite
                  (clj->phaser top-left))))
  ([impact-sprite top-left top-right]
   (phaser->clj
    (.setTintFill impact-sprite
                  (clj->phaser top-left)
                  (clj->phaser top-right))))
  ([impact-sprite top-left top-right bottom-left]
   (phaser->clj
    (.setTintFill impact-sprite
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left))))
  ([impact-sprite top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTintFill impact-sprite
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left)
                  (clj->phaser bottom-right)))))

(defn set-type-a
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setTypeA impact-sprite))))

(defn set-type-b
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setTypeB impact-sprite))))

(defn set-type-none
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.setTypeNone impact-sprite))))

(defn set-velocity
  "Sets the horizontal and vertical velocities of the physics body.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - The horizontal velocity value.
    * y (number) {optional} - The vertical velocity value. If not given, defaults to the horizontal value.

  Returns:  this - This Game Object."
  ([impact-sprite x]
   (phaser->clj
    (.setVelocity impact-sprite
                  (clj->phaser x))))
  ([impact-sprite x y]
   (phaser->clj
    (.setVelocity impact-sprite
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-velocity-x
  "Sets the horizontal velocity of the physics body.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * x (number) - The horizontal velocity value.

  Returns:  this - This Game Object."
  ([impact-sprite x]
   (phaser->clj
    (.setVelocityX impact-sprite
                   (clj->phaser x)))))

(defn set-velocity-y
  "Sets the vertical velocity of the physics body.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * y (number) - The vertical velocity value.

  Returns:  this - This Game Object."
  ([impact-sprite y]
   (phaser->clj
    (.setVelocityY impact-sprite
                   (clj->phaser y)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite value]
   (phaser->clj
    (.setVisible impact-sprite
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setW impact-sprite)))
  ([impact-sprite value]
   (phaser->clj
    (.setW impact-sprite
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setX impact-sprite)))
  ([impact-sprite value]
   (phaser->clj
    (.setX impact-sprite
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setY impact-sprite)))
  ([impact-sprite value]
   (phaser->clj
    (.setY impact-sprite
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.setZ impact-sprite)))
  ([impact-sprite value]
   (phaser->clj
    (.setZ impact-sprite
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([impact-sprite]
   (phaser->clj
    (.shutdown impact-sprite))))

(defn sync-game-object
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-sprite]
   (phaser->clj
    (.syncGameObject impact-sprite))))

(defn to-json
  "Build a JSON representation of this Sprite.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([impact-sprite]
   (phaser->clj
    (.toJSON impact-sprite))))

(defn toggle-flip-x
  "Toggles the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.toggleFlipX impact-sprite))))

(defn toggle-flip-y
  "Toggles the vertical flipped state of this Game Object.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.toggleFlipY impact-sprite))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * args (*) {optional} - args"
  ([impact-sprite]
   (phaser->clj
    (.update impact-sprite)))
  ([impact-sprite args]
   (phaser->clj
    (.update impact-sprite
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([impact-sprite]
   (phaser->clj
    (.updateDisplayOrigin impact-sprite))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * impact-sprite (Phaser.Physics.Impact.ImpactSprite) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([impact-sprite camera]
   (phaser->clj
    (.willRender impact-sprite
                 (clj->phaser camera)))))