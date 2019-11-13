(ns phzr.game-objects.shader
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load flush update]))

(defn ->Shader
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs. A Game Object can only belong to one Scene at a time.
    * key (string | Phaser.Display.BaseShader) - The key of the shader to use from the shader cache, or a BaseShader instance.
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * width (number) {optional} - The width of the Game Object.
    * height (number) {optional} - The height of the Game Object.
    * textures (Array.<string>) {optional} - Optional array of texture keys to bind to the iChannel0...3 uniforms. The textures must already exist in the Texture Manager.
    * texture-data (any) {optional} - Additional texture data if you want to create shader with none NPOT textures."
  ([scene key]
   (js/Phaser.GameObjects.Shader. (clj->phaser scene)
                                  (clj->phaser key)))
  ([scene key x]
   (js/Phaser.GameObjects.Shader. (clj->phaser scene)
                                  (clj->phaser key)
                                  (clj->phaser x)))
  ([scene key x y]
   (js/Phaser.GameObjects.Shader. (clj->phaser scene)
                                  (clj->phaser key)
                                  (clj->phaser x)
                                  (clj->phaser y)))
  ([scene key x y width]
   (js/Phaser.GameObjects.Shader. (clj->phaser scene)
                                  (clj->phaser key)
                                  (clj->phaser x)
                                  (clj->phaser y)
                                  (clj->phaser width)))
  ([scene key x y width height]
   (js/Phaser.GameObjects.Shader. (clj->phaser scene)
                                  (clj->phaser key)
                                  (clj->phaser x)
                                  (clj->phaser y)
                                  (clj->phaser width)
                                  (clj->phaser height)))
  ([scene key x y width height textures]
   (js/Phaser.GameObjects.Shader. (clj->phaser scene)
                                  (clj->phaser key)
                                  (clj->phaser x)
                                  (clj->phaser y)
                                  (clj->phaser width)
                                  (clj->phaser height)
                                  (clj->phaser textures)))
  ([scene key x y width height textures texture-data]
   (js/Phaser.GameObjects.Shader. (clj->phaser scene)
                                  (clj->phaser key)
                                  (clj->phaser x)
                                  (clj->phaser y)
                                  (clj->phaser width)
                                  (clj->phaser height)
                                  (clj->phaser textures)
                                  (clj->phaser texture-data))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([shader event fn]
   (phaser->clj
    (.addListener shader
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([shader event fn context]
   (phaser->clj
    (.addListener shader
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.clearMask shader)))
  ([shader destroy-mask]
   (phaser->clj
    (.clearMask shader
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
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([shader]
   (phaser->clj
    (.createBitmapMask shader)))
  ([shader renderable]
   (phaser->clj
    (.createBitmapMask shader
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([shader]
   (phaser->clj
    (.createGeometryMask shader)))
  ([shader graphics]
   (phaser->clj
    (.createGeometryMask shader
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
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([shader]
   (phaser->clj
    (.destroy shader)))
  ([shader from-scene]
   (phaser->clj
    (.destroy shader
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([shader]
   (phaser->clj
    (.disableInteractive shader))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([shader event]
   (phaser->clj
    (.emit shader
           (clj->phaser event))))
  ([shader event args]
   (phaser->clj
    (.emit shader
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([shader]
   (phaser->clj
    (.eventNames shader))))

(defn flush
  "Called automatically during render.

  Sets the active shader, loads the vertex buffer and then draws."
  ([shader]
   (phaser->clj
    (.flush shader))))

(defn get-bottom-center
  "Gets the bottom-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getBottomCenter shader)))
  ([shader output]
   (phaser->clj
    (.getBottomCenter shader
                      (clj->phaser output))))
  ([shader output include-parent]
   (phaser->clj
    (.getBottomCenter shader
                      (clj->phaser output)
                      (clj->phaser include-parent)))))

(defn get-bottom-left
  "Gets the bottom-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getBottomLeft shader)))
  ([shader output]
   (phaser->clj
    (.getBottomLeft shader
                    (clj->phaser output))))
  ([shader output include-parent]
   (phaser->clj
    (.getBottomLeft shader
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-bottom-right
  "Gets the bottom-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getBottomRight shader)))
  ([shader output]
   (phaser->clj
    (.getBottomRight shader
                     (clj->phaser output))))
  ([shader output include-parent]
   (phaser->clj
    (.getBottomRight shader
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-bounds
  "Gets the bounds of this Game Object, regardless of origin.
  The values are stored and returned in a Rectangle, or Rectangle-like, object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Geom.Rectangle | object) {optional} - An object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getBounds shader)))
  ([shader output]
   (phaser->clj
    (.getBounds shader
                (clj->phaser output)))))

(defn get-center
  "Gets the center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getCenter shader)))
  ([shader output]
   (phaser->clj
    (.getCenter shader
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
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([shader key]
   (phaser->clj
    (.getData shader
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([shader]
   (phaser->clj
    (.getIndexList shader))))

(defn get-left-center
  "Gets the left-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getLeftCenter shader)))
  ([shader output]
   (phaser->clj
    (.getLeftCenter shader
                    (clj->phaser output))))
  ([shader output include-parent]
   (phaser->clj
    (.getLeftCenter shader
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([shader]
   (phaser->clj
    (.getLocalTransformMatrix shader)))
  ([shader temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix shader
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([shader]
   (phaser->clj
    (.getParentRotation shader))))

(defn get-right-center
  "Gets the right-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getRightCenter shader)))
  ([shader output]
   (phaser->clj
    (.getRightCenter shader
                     (clj->phaser output))))
  ([shader output include-parent]
   (phaser->clj
    (.getRightCenter shader
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-top-center
  "Gets the top-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getTopCenter shader)))
  ([shader output]
   (phaser->clj
    (.getTopCenter shader
                   (clj->phaser output))))
  ([shader output include-parent]
   (phaser->clj
    (.getTopCenter shader
                   (clj->phaser output)
                   (clj->phaser include-parent)))))

(defn get-top-left
  "Gets the top-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getTopLeft shader)))
  ([shader output]
   (phaser->clj
    (.getTopLeft shader
                 (clj->phaser output))))
  ([shader output include-parent]
   (phaser->clj
    (.getTopLeft shader
                 (clj->phaser output)
                 (clj->phaser include-parent)))))

(defn get-top-right
  "Gets the top-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([shader]
   (phaser->clj
    (.getTopRight shader)))
  ([shader output]
   (phaser->clj
    (.getTopRight shader
                  (clj->phaser output))))
  ([shader output include-parent]
   (phaser->clj
    (.getTopRight shader
                  (clj->phaser output)
                  (clj->phaser include-parent)))))

(defn get-uniform
  "Returns the uniform object for the given key, or `null` if the uniform couldn't be found.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * key (string) - The key of the uniform to return the value for.

  Returns:  any - A reference to the uniform object. This is not a copy, so modifying it will update the original object also."
  ([shader key]
   (phaser->clj
    (.getUniform shader
                 (clj->phaser key)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([shader]
   (phaser->clj
    (.getWorldTransformMatrix shader)))
  ([shader temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix shader
                              (clj->phaser temp-matrix))))
  ([shader temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix shader
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([shader event]
   (phaser->clj
    (.listenerCount shader
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([shader event]
   (phaser->clj
    (.listeners shader
                (clj->phaser event)))))

(defn load
  "Called automatically during render.

  This method performs matrix ITRS and then stores the resulting value in the `uViewMatrix` uniform.
  It then sets up the vertex buffer and shader, updates and syncs the uniforms ready
  for flush to be called.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * matrix-2-d (Phaser.GameObjects.Components.TransformMatrix) {optional} - The transform matrix to use during rendering."
  ([shader]
   (phaser->clj
    (.load shader)))
  ([shader matrix-2-d]
   (phaser->clj
    (.load shader
           (clj->phaser matrix-2-d)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([shader event]
   (phaser->clj
    (.off shader
          (clj->phaser event))))
  ([shader event fn]
   (phaser->clj
    (.off shader
          (clj->phaser event)
          (clj->phaser fn))))
  ([shader event fn context]
   (phaser->clj
    (.off shader
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([shader event fn context once]
   (phaser->clj
    (.off shader
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([shader event fn]
   (phaser->clj
    (.on shader
         (clj->phaser event)
         (clj->phaser fn))))
  ([shader event fn context]
   (phaser->clj
    (.on shader
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([shader event fn]
   (phaser->clj
    (.once shader
           (clj->phaser event)
           (clj->phaser fn))))
  ([shader event fn context]
   (phaser->clj
    (.once shader
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn proj-ortho
  "Sets this shader to use an orthographic projection matrix.
  This matrix is stored locally in the `projectionMatrix` property,
  as well as being bound to the `uProjectionMatrix` uniform.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * left (number) - The left value.
    * right (number) - The right value.
    * bottom (number) - The bottom value.
    * top (number) - The top value."
  ([shader left right bottom top]
   (phaser->clj
    (.projOrtho shader
                (clj->phaser left)
                (clj->phaser right)
                (clj->phaser bottom)
                (clj->phaser top)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([shader]
   (phaser->clj
    (.removeAllListeners shader)))
  ([shader event]
   (phaser->clj
    (.removeAllListeners shader
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
  ([shader]
   (phaser->clj
    (.removeInteractive shader))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([shader event]
   (phaser->clj
    (.removeListener shader
                     (clj->phaser event))))
  ([shader event fn]
   (phaser->clj
    (.removeListener shader
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([shader event fn context]
   (phaser->clj
    (.removeListener shader
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([shader event fn context once]
   (phaser->clj
    (.removeListener shader
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([shader value]
   (phaser->clj
    (.setActive shader
                (clj->phaser value)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setAngle shader)))
  ([shader degrees]
   (phaser->clj
    (.setAngle shader
               (clj->phaser degrees)))))

(defn set-channel-0
  "A short-cut method that will directly set the texture being used by the `iChannel0` sampler2D uniform.

  The textureKey given is the key from the Texture Manager cache. You cannot use a single frame
  from a texture, only the full image. Also, lots of shaders expect textures to be power-of-two sized.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * texture-key (string) - The key of the texture, as stored in the Texture Manager. Must already be loaded.
    * texture-data (any) {optional} - Additional texture data.

  Returns:  this - This Shader instance."
  ([shader texture-key]
   (phaser->clj
    (.setChannel0 shader
                  (clj->phaser texture-key))))
  ([shader texture-key texture-data]
   (phaser->clj
    (.setChannel0 shader
                  (clj->phaser texture-key)
                  (clj->phaser texture-data)))))

(defn set-channel-1
  "A short-cut method that will directly set the texture being used by the `iChannel1` sampler2D uniform.

  The textureKey given is the key from the Texture Manager cache. You cannot use a single frame
  from a texture, only the full image. Also, lots of shaders expect textures to be power-of-two sized.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * texture-key (string) - The key of the texture, as stored in the Texture Manager. Must already be loaded.
    * texture-data (any) {optional} - Additional texture data.

  Returns:  this - This Shader instance."
  ([shader texture-key]
   (phaser->clj
    (.setChannel1 shader
                  (clj->phaser texture-key))))
  ([shader texture-key texture-data]
   (phaser->clj
    (.setChannel1 shader
                  (clj->phaser texture-key)
                  (clj->phaser texture-data)))))

(defn set-channel-2
  "A short-cut method that will directly set the texture being used by the `iChannel2` sampler2D uniform.

  The textureKey given is the key from the Texture Manager cache. You cannot use a single frame
  from a texture, only the full image. Also, lots of shaders expect textures to be power-of-two sized.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * texture-key (string) - The key of the texture, as stored in the Texture Manager. Must already be loaded.
    * texture-data (any) {optional} - Additional texture data.

  Returns:  this - This Shader instance."
  ([shader texture-key]
   (phaser->clj
    (.setChannel2 shader
                  (clj->phaser texture-key))))
  ([shader texture-key texture-data]
   (phaser->clj
    (.setChannel2 shader
                  (clj->phaser texture-key)
                  (clj->phaser texture-data)))))

(defn set-channel-3
  "A short-cut method that will directly set the texture being used by the `iChannel3` sampler2D uniform.

  The textureKey given is the key from the Texture Manager cache. You cannot use a single frame
  from a texture, only the full image. Also, lots of shaders expect textures to be power-of-two sized.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * texture-key (string) - The key of the texture, as stored in the Texture Manager. Must already be loaded.
    * texture-data (any) {optional} - Additional texture data.

  Returns:  this - This Shader instance."
  ([shader texture-key]
   (phaser->clj
    (.setChannel3 shader
                  (clj->phaser texture-key))))
  ([shader texture-key texture-data]
   (phaser->clj
    (.setChannel3 shader
                  (clj->phaser texture-key)
                  (clj->phaser texture-data)))))

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
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([shader key]
   (phaser->clj
    (.setData shader
              (clj->phaser key))))
  ([shader key data]
   (phaser->clj
    (.setData shader
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([shader]
   (phaser->clj
    (.setDataEnabled shader))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([shader value]
   (phaser->clj
    (.setDepth shader
               (clj->phaser value)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setDisplayOrigin shader)))
  ([shader x]
   (phaser->clj
    (.setDisplayOrigin shader
                       (clj->phaser x))))
  ([shader x y]
   (phaser->clj
    (.setDisplayOrigin shader
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([shader width height]
   (phaser->clj
    (.setDisplaySize shader
                     (clj->phaser width)
                     (clj->phaser height)))))

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
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([shader]
   (phaser->clj
    (.setInteractive shader)))
  ([shader shape]
   (phaser->clj
    (.setInteractive shader
                     (clj->phaser shape))))
  ([shader shape callback]
   (phaser->clj
    (.setInteractive shader
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([shader shape callback drop-zone]
   (phaser->clj
    (.setInteractive shader
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
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([shader mask]
   (phaser->clj
    (.setMask shader
              (clj->phaser mask)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([shader value]
   (phaser->clj
    (.setName shader
              (clj->phaser value)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setOrigin shader)))
  ([shader x]
   (phaser->clj
    (.setOrigin shader
                (clj->phaser x))))
  ([shader x y]
   (phaser->clj
    (.setOrigin shader
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setOriginFromFrame shader))))

(defn set-pointer
  "Binds a Phaser Pointer object to this Shader.

  The screen position of the pointer will be set in to the shaders `mouse` uniform
  automatically every frame. Call this method with no arguments to unbind the pointer.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * pointer (Phaser.Input.Pointer) {optional} - The Pointer to bind to this shader.

  Returns:  this - This Shader instance."
  ([shader]
   (phaser->clj
    (.setPointer shader)))
  ([shader pointer]
   (phaser->clj
    (.setPointer shader
                 (clj->phaser pointer)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setPosition shader)))
  ([shader x]
   (phaser->clj
    (.setPosition shader
                  (clj->phaser x))))
  ([shader x y]
   (phaser->clj
    (.setPosition shader
                  (clj->phaser x)
                  (clj->phaser y))))
  ([shader x y z]
   (phaser->clj
    (.setPosition shader
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([shader x y z w]
   (phaser->clj
    (.setPosition shader
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
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setRandomPosition shader)))
  ([shader x]
   (phaser->clj
    (.setRandomPosition shader
                        (clj->phaser x))))
  ([shader x y]
   (phaser->clj
    (.setRandomPosition shader
                        (clj->phaser x)
                        (clj->phaser y))))
  ([shader x y width]
   (phaser->clj
    (.setRandomPosition shader
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([shader x y width height]
   (phaser->clj
    (.setRandomPosition shader
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-render-to-texture
  "Changes this Shader so instead of rendering to the display list it renders to a
  WebGL Framebuffer and WebGL Texture instead. This allows you to use the output
  of this shader as an input for another shader, by mapping a sampler2D uniform
  to it.

  After calling this method the `Shader.framebuffer` and `Shader.glTexture` properties
  are populated.

  Additionally, you can provide a key to this method. Doing so will create a Phaser Texture
  from this Shader and save it into the Texture Manager, allowing you to then use it for
  any texture-based Game Object, such as a Sprite or Image:

  ```javascript
  var shader = this.add.shader('myShader', x, y, width, height);

  shader.setRenderToTexture('doodle');

  this.add.image(400, 300, 'doodle');
  ```

  Note that it stores an active reference to this Shader. That means as this shader updates,
  so does the texture and any object using it to render with. Also, if you destroy this
  shader, be sure to clear any objects that may have been using it as a texture too.

  You can access the Phaser Texture that is created via the `Shader.texture` property.

  By default it will create a single base texture. You can add frames to the texture
  by using the `Texture.add` method. After doing this, you can then allow Game Objects
  to use a specific frame from a Render Texture.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * key (string) {optional} - The unique key to store the texture as within the global Texture Manager.
    * flip-y (boolean) {optional} - Does this texture need vertically flipping before rendering? This should usually be set to `true` if being fed from a buffer.

  Returns:  this - This Shader instance."
  ([shader]
   (phaser->clj
    (.setRenderToTexture shader)))
  ([shader key]
   (phaser->clj
    (.setRenderToTexture shader
                         (clj->phaser key))))
  ([shader key flip-y]
   (phaser->clj
    (.setRenderToTexture shader
                         (clj->phaser key)
                         (clj->phaser flip-y)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setRotation shader)))
  ([shader radians]
   (phaser->clj
    (.setRotation shader
                  (clj->phaser radians)))))

(defn set-sampler-2-d
  "Sets a sampler2D uniform on this shader.

  The textureKey given is the key from the Texture Manager cache. You cannot use a single frame
  from a texture, only the full image. Also, lots of shaders expect textures to be power-of-two sized.

  If you wish to use another Shader as a sampler2D input for this shader, see the `Shader.setSampler2DBuffer` method.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * uniform-key (string) - The key of the sampler2D uniform to be updated, i.e. `iChannel0`.
    * texture-key (string) - The key of the texture, as stored in the Texture Manager. Must already be loaded.
    * texture-index (integer) {optional} - The texture index.
    * texture-data (any) {optional} - Additional texture data.

  Returns:  this - This Shader instance."
  ([shader uniform-key texture-key]
   (phaser->clj
    (.setSampler2D shader
                   (clj->phaser uniform-key)
                   (clj->phaser texture-key))))
  ([shader uniform-key texture-key texture-index]
   (phaser->clj
    (.setSampler2D shader
                   (clj->phaser uniform-key)
                   (clj->phaser texture-key)
                   (clj->phaser texture-index))))
  ([shader uniform-key texture-key texture-index texture-data]
   (phaser->clj
    (.setSampler2D shader
                   (clj->phaser uniform-key)
                   (clj->phaser texture-key)
                   (clj->phaser texture-index)
                   (clj->phaser texture-data)))))

(defn set-sampler-2-d-buffer
  "Sets a sampler2D uniform on this shader where the source texture is a WebGLTexture.

  This allows you to feed the output from one Shader into another:

  ```javascript
  let shader1 = this.add.shader(baseShader1, 0, 0, 512, 512).setRenderToTexture();
  let shader2 = this.add.shader(baseShader2, 0, 0, 512, 512).setRenderToTexture('output');

  shader1.setSampler2DBuffer('iChannel0', shader2.glTexture, 512, 512);
  shader2.setSampler2DBuffer('iChannel0', shader1.glTexture, 512, 512);
  ```

  In the above code, the result of baseShader1 is fed into Shader2 as the `iChannel0` sampler2D uniform.
  The result of baseShader2 is then fed back into shader1 again, creating a feedback loop.

  If you wish to use an image from the Texture Manager as a sampler2D input for this shader,
  see the `Shader.setSampler2D` method.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * uniform-key (string) - The key of the sampler2D uniform to be updated, i.e. `iChannel0`.
    * texture (WebGLTexture) - A WebGLTexture reference.
    * width (integer) - The width of the texture.
    * height (integer) - The height of the texture.
    * texture-index (integer) {optional} - The texture index.
    * texture-data (any) {optional} - Additional texture data.

  Returns:  this - This Shader instance."
  ([shader uniform-key texture width height]
   (phaser->clj
    (.setSampler2DBuffer shader
                         (clj->phaser uniform-key)
                         (clj->phaser texture)
                         (clj->phaser width)
                         (clj->phaser height))))
  ([shader uniform-key texture width height texture-index]
   (phaser->clj
    (.setSampler2DBuffer shader
                         (clj->phaser uniform-key)
                         (clj->phaser texture)
                         (clj->phaser width)
                         (clj->phaser height)
                         (clj->phaser texture-index))))
  ([shader uniform-key texture width height texture-index texture-data]
   (phaser->clj
    (.setSampler2DBuffer shader
                         (clj->phaser uniform-key)
                         (clj->phaser texture)
                         (clj->phaser width)
                         (clj->phaser height)
                         (clj->phaser texture-index)
                         (clj->phaser texture-data)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([shader x]
   (phaser->clj
    (.setScale shader
               (clj->phaser x))))
  ([shader x y]
   (phaser->clj
    (.setScale shader
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
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([shader x]
   (phaser->clj
    (.setScrollFactor shader
                      (clj->phaser x))))
  ([shader x y]
   (phaser->clj
    (.setScrollFactor shader
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-shader
  "Sets the fragment and, optionally, the vertex shader source code that this Shader will use.
  This will immediately delete the active shader program, if set, and then create a new one
  with the given source. Finally, the shader uniforms are initialized.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * key (string | Phaser.Display.BaseShader) - The key of the shader to use from the shader cache, or a BaseShader instance.
    * textures (Array.<string>) {optional} - Optional array of texture keys to bind to the iChannel0...3 uniforms. The textures must already exist in the Texture Manager.
    * texture-data (any) {optional} - Additional texture data.

  Returns:  this - This Shader instance."
  ([shader key]
   (phaser->clj
    (.setShader shader
                (clj->phaser key))))
  ([shader key textures]
   (phaser->clj
    (.setShader shader
                (clj->phaser key)
                (clj->phaser textures))))
  ([shader key textures texture-data]
   (phaser->clj
    (.setShader shader
                (clj->phaser key)
                (clj->phaser textures)
                (clj->phaser texture-data)))))

(defn set-size
  "Sets the internal size of this Game Object, as used for frame or physics body creation.

  This will not change the size that the Game Object is rendered in-game.
  For that you need to either set the scale of the Game Object (`setScale`) or call the
  `setDisplaySize` method, which is the same thing as changing the scale but allows you
  to do so by giving pixel values.

  If you have enabled this Game Object for input, changing the size will _not_ change the
  size of the hit area. To do this you should adjust the `input.hitArea` object directly.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([shader width height]
   (phaser->clj
    (.setSize shader
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([shader value]
   (phaser->clj
    (.setState shader
               (clj->phaser value)))))

(defn set-uniform
  "Sets a property of a uniform already present on this shader.

  To modify the value of a uniform such as a 1f or 1i use the `value` property directly:

  ```javascript
  shader.setUniform('size.value', 16);
  ```

  You can use dot notation to access deeper values, for example:

  ```javascript
  shader.setUniform('resolution.value.x', 512);
  ```

  The change to the uniform will take effect the next time the shader is rendered.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * key (string) - The key of the uniform to modify. Use dots for deep properties, i.e. `resolution.value.x`.
    * value (any) - The value to set into the uniform.

  Returns:  this - This Shader instance."
  ([shader key value]
   (phaser->clj
    (.setUniform shader
                 (clj->phaser key)
                 (clj->phaser value)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([shader value]
   (phaser->clj
    (.setVisible shader
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setW shader)))
  ([shader value]
   (phaser->clj
    (.setW shader
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setX shader)))
  ([shader value]
   (phaser->clj
    (.setX shader
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setY shader)))
  ([shader value]
   (phaser->clj
    (.setY shader
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.setZ shader)))
  ([shader value]
   (phaser->clj
    (.setZ shader
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([shader]
   (phaser->clj
    (.shutdown shader))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([shader]
   (phaser->clj
    (.toJSON shader))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * args (*) {optional} - args"
  ([shader]
   (phaser->clj
    (.update shader)))
  ([shader args]
   (phaser->clj
    (.update shader
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([shader]
   (phaser->clj
    (.updateDisplayOrigin shader))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * shader (Phaser.GameObjects.Shader) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([shader camera]
   (phaser->clj
    (.willRender shader
                 (clj->phaser camera)))))