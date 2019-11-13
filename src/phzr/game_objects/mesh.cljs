(ns phzr.game-objects.mesh
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Mesh
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs. A Game Object can only belong to one Scene at a time.
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * vertices (Array.<number>) - An array containing the vertices data for this Mesh.
    * uv (Array.<number>) - An array containing the uv data for this Mesh.
    * colors (Array.<number>) - An array containing the color data for this Mesh.
    * alphas (Array.<number>) - An array containing the alpha data for this Mesh.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with."
  ([scene x y vertices uv colors alphas texture]
   (js/Phaser.GameObjects.Mesh. (clj->phaser scene)
                                (clj->phaser x)
                                (clj->phaser y)
                                (clj->phaser vertices)
                                (clj->phaser uv)
                                (clj->phaser colors)
                                (clj->phaser alphas)
                                (clj->phaser texture)))
  ([scene x y vertices uv colors alphas texture frame]
   (js/Phaser.GameObjects.Mesh. (clj->phaser scene)
                                (clj->phaser x)
                                (clj->phaser y)
                                (clj->phaser vertices)
                                (clj->phaser uv)
                                (clj->phaser colors)
                                (clj->phaser alphas)
                                (clj->phaser texture)
                                (clj->phaser frame))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([mesh event fn]
   (phaser->clj
    (.addListener mesh
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([mesh event fn context]
   (phaser->clj
    (.addListener mesh
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.clearMask mesh)))
  ([mesh destroy-mask]
   (phaser->clj
    (.clearMask mesh
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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([mesh]
   (phaser->clj
    (.createBitmapMask mesh)))
  ([mesh renderable]
   (phaser->clj
    (.createBitmapMask mesh
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([mesh]
   (phaser->clj
    (.createGeometryMask mesh)))
  ([mesh graphics]
   (phaser->clj
    (.createGeometryMask mesh
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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([mesh]
   (phaser->clj
    (.destroy mesh)))
  ([mesh from-scene]
   (phaser->clj
    (.destroy mesh
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([mesh]
   (phaser->clj
    (.disableInteractive mesh))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([mesh event]
   (phaser->clj
    (.emit mesh
           (clj->phaser event))))
  ([mesh event args]
   (phaser->clj
    (.emit mesh
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([mesh]
   (phaser->clj
    (.eventNames mesh))))

(defn get-bottom-center
  "Gets the bottom-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getBottomCenter mesh)))
  ([mesh output]
   (phaser->clj
    (.getBottomCenter mesh
                      (clj->phaser output))))
  ([mesh output include-parent]
   (phaser->clj
    (.getBottomCenter mesh
                      (clj->phaser output)
                      (clj->phaser include-parent)))))

(defn get-bottom-left
  "Gets the bottom-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getBottomLeft mesh)))
  ([mesh output]
   (phaser->clj
    (.getBottomLeft mesh
                    (clj->phaser output))))
  ([mesh output include-parent]
   (phaser->clj
    (.getBottomLeft mesh
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-bottom-right
  "Gets the bottom-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getBottomRight mesh)))
  ([mesh output]
   (phaser->clj
    (.getBottomRight mesh
                     (clj->phaser output))))
  ([mesh output include-parent]
   (phaser->clj
    (.getBottomRight mesh
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-bounds
  "Gets the bounds of this Game Object, regardless of origin.
  The values are stored and returned in a Rectangle, or Rectangle-like, object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Geom.Rectangle | object) {optional} - An object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getBounds mesh)))
  ([mesh output]
   (phaser->clj
    (.getBounds mesh
                (clj->phaser output)))))

(defn get-center
  "Gets the center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getCenter mesh)))
  ([mesh output]
   (phaser->clj
    (.getCenter mesh
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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([mesh key]
   (phaser->clj
    (.getData mesh
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([mesh]
   (phaser->clj
    (.getIndexList mesh))))

(defn get-left-center
  "Gets the left-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getLeftCenter mesh)))
  ([mesh output]
   (phaser->clj
    (.getLeftCenter mesh
                    (clj->phaser output))))
  ([mesh output include-parent]
   (phaser->clj
    (.getLeftCenter mesh
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([mesh]
   (phaser->clj
    (.getLocalTransformMatrix mesh)))
  ([mesh temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix mesh
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([mesh]
   (phaser->clj
    (.getParentRotation mesh))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([mesh]
   (phaser->clj
    (.getPipelineName mesh))))

(defn get-right-center
  "Gets the right-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getRightCenter mesh)))
  ([mesh output]
   (phaser->clj
    (.getRightCenter mesh
                     (clj->phaser output))))
  ([mesh output include-parent]
   (phaser->clj
    (.getRightCenter mesh
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-top-center
  "Gets the top-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getTopCenter mesh)))
  ([mesh output]
   (phaser->clj
    (.getTopCenter mesh
                   (clj->phaser output))))
  ([mesh output include-parent]
   (phaser->clj
    (.getTopCenter mesh
                   (clj->phaser output)
                   (clj->phaser include-parent)))))

(defn get-top-left
  "Gets the top-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getTopLeft mesh)))
  ([mesh output]
   (phaser->clj
    (.getTopLeft mesh
                 (clj->phaser output))))
  ([mesh output include-parent]
   (phaser->clj
    (.getTopLeft mesh
                 (clj->phaser output)
                 (clj->phaser include-parent)))))

(defn get-top-right
  "Gets the top-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([mesh]
   (phaser->clj
    (.getTopRight mesh)))
  ([mesh output]
   (phaser->clj
    (.getTopRight mesh
                  (clj->phaser output))))
  ([mesh output include-parent]
   (phaser->clj
    (.getTopRight mesh
                  (clj->phaser output)
                  (clj->phaser include-parent)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([mesh]
   (phaser->clj
    (.getWorldTransformMatrix mesh)))
  ([mesh temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix mesh
                              (clj->phaser temp-matrix))))
  ([mesh temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix mesh
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([mesh]
   (phaser->clj
    (.initPipeline mesh)))
  ([mesh pipeline-name]
   (phaser->clj
    (.initPipeline mesh
                   (clj->phaser pipeline-name)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([mesh event]
   (phaser->clj
    (.listenerCount mesh
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([mesh event]
   (phaser->clj
    (.listeners mesh
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([mesh event]
   (phaser->clj
    (.off mesh
          (clj->phaser event))))
  ([mesh event fn]
   (phaser->clj
    (.off mesh
          (clj->phaser event)
          (clj->phaser fn))))
  ([mesh event fn context]
   (phaser->clj
    (.off mesh
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([mesh event fn context once]
   (phaser->clj
    (.off mesh
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([mesh event fn]
   (phaser->clj
    (.on mesh
         (clj->phaser event)
         (clj->phaser fn))))
  ([mesh event fn context]
   (phaser->clj
    (.on mesh
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([mesh event fn]
   (phaser->clj
    (.once mesh
           (clj->phaser event)
           (clj->phaser fn))))
  ([mesh event fn context]
   (phaser->clj
    (.once mesh
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([mesh]
   (phaser->clj
    (.removeAllListeners mesh)))
  ([mesh event]
   (phaser->clj
    (.removeAllListeners mesh
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
  ([mesh]
   (phaser->clj
    (.removeInteractive mesh))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([mesh event]
   (phaser->clj
    (.removeListener mesh
                     (clj->phaser event))))
  ([mesh event fn]
   (phaser->clj
    (.removeListener mesh
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([mesh event fn context]
   (phaser->clj
    (.removeListener mesh
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([mesh event fn context once]
   (phaser->clj
    (.removeListener mesh
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([mesh]
   (phaser->clj
    (.resetPipeline mesh))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([mesh value]
   (phaser->clj
    (.setActive mesh
                (clj->phaser value)))))

(defn set-alpha
  "This method is left intentionally empty and does not do anything.
  It is retained to allow a Mesh or Quad to be added to a Container."
  ([mesh]
   (phaser->clj
    (.setAlpha mesh))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.setAngle mesh)))
  ([mesh degrees]
   (phaser->clj
    (.setAngle mesh
               (clj->phaser degrees)))))

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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([mesh value]
   (phaser->clj
    (.setBlendMode mesh
                   (clj->phaser value)))))

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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([mesh key]
   (phaser->clj
    (.setData mesh
              (clj->phaser key))))
  ([mesh key data]
   (phaser->clj
    (.setData mesh
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([mesh]
   (phaser->clj
    (.setDataEnabled mesh))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh value]
   (phaser->clj
    (.setDepth mesh
               (clj->phaser value)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh width height]
   (phaser->clj
    (.setDisplaySize mesh
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-frame
  "Sets the frame this Game Object will use to render with.

  The Frame has to belong to the current Texture being used.

  It can be either a string or an index.

  Calling `setFrame` will modify the `width` and `height` properties of your Game Object.
  It will also change the `origin` if the Frame has a custom pivot point, as exported from packages like Texture Packer.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * frame (string | integer) - The name or index of the frame within the Texture.
    * update-size (boolean) {optional} - Should this call adjust the size of the Game Object?
    * update-origin (boolean) {optional} - Should this call adjust the origin of the Game Object?

  Returns:  this - This Game Object instance."
  ([mesh frame]
   (phaser->clj
    (.setFrame mesh
               (clj->phaser frame))))
  ([mesh frame update-size]
   (phaser->clj
    (.setFrame mesh
               (clj->phaser frame)
               (clj->phaser update-size))))
  ([mesh frame update-size update-origin]
   (phaser->clj
    (.setFrame mesh
               (clj->phaser frame)
               (clj->phaser update-size)
               (clj->phaser update-origin)))))

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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([mesh]
   (phaser->clj
    (.setInteractive mesh)))
  ([mesh shape]
   (phaser->clj
    (.setInteractive mesh
                     (clj->phaser shape))))
  ([mesh shape callback]
   (phaser->clj
    (.setInteractive mesh
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([mesh shape callback drop-zone]
   (phaser->clj
    (.setInteractive mesh
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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([mesh mask]
   (phaser->clj
    (.setMask mesh
              (clj->phaser mask)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([mesh value]
   (phaser->clj
    (.setName mesh
              (clj->phaser value)))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh pipeline-name]
   (phaser->clj
    (.setPipeline mesh
                  (clj->phaser pipeline-name)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.setPosition mesh)))
  ([mesh x]
   (phaser->clj
    (.setPosition mesh
                  (clj->phaser x))))
  ([mesh x y]
   (phaser->clj
    (.setPosition mesh
                  (clj->phaser x)
                  (clj->phaser y))))
  ([mesh x y z]
   (phaser->clj
    (.setPosition mesh
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([mesh x y z w]
   (phaser->clj
    (.setPosition mesh
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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.setRandomPosition mesh)))
  ([mesh x]
   (phaser->clj
    (.setRandomPosition mesh
                        (clj->phaser x))))
  ([mesh x y]
   (phaser->clj
    (.setRandomPosition mesh
                        (clj->phaser x)
                        (clj->phaser y))))
  ([mesh x y width]
   (phaser->clj
    (.setRandomPosition mesh
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([mesh x y width height]
   (phaser->clj
    (.setRandomPosition mesh
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.setRotation mesh)))
  ([mesh radians]
   (phaser->clj
    (.setRotation mesh
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([mesh x]
   (phaser->clj
    (.setScale mesh
               (clj->phaser x))))
  ([mesh x y]
   (phaser->clj
    (.setScale mesh
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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([mesh x]
   (phaser->clj
    (.setScrollFactor mesh
                      (clj->phaser x))))
  ([mesh x y]
   (phaser->clj
    (.setScrollFactor mesh
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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh width height]
   (phaser->clj
    (.setSize mesh
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
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * frame (Phaser.Textures.Frame) - The frame to base the size of this Game Object on.

  Returns:  this - This Game Object instance."
  ([mesh frame]
   (phaser->clj
    (.setSizeToFrame mesh
                     (clj->phaser frame)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([mesh value]
   (phaser->clj
    (.setState mesh
               (clj->phaser value)))))

(defn set-texture
  "Sets the texture and frame this Game Object will use to render with.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * key (string | Phaser.Textures.Texture) - The key of the texture to be used, as stored in the Texture Manager, or a Texture instance.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.

  Returns:  this - This Game Object instance."
  ([mesh key]
   (phaser->clj
    (.setTexture mesh
                 (clj->phaser key))))
  ([mesh key frame]
   (phaser->clj
    (.setTexture mesh
                 (clj->phaser key)
                 (clj->phaser frame)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([mesh value]
   (phaser->clj
    (.setVisible mesh
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.setW mesh)))
  ([mesh value]
   (phaser->clj
    (.setW mesh
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.setX mesh)))
  ([mesh value]
   (phaser->clj
    (.setX mesh
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.setY mesh)))
  ([mesh value]
   (phaser->clj
    (.setY mesh
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([mesh]
   (phaser->clj
    (.setZ mesh)))
  ([mesh value]
   (phaser->clj
    (.setZ mesh
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([mesh]
   (phaser->clj
    (.shutdown mesh))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([mesh]
   (phaser->clj
    (.toJSON mesh))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * args (*) {optional} - args"
  ([mesh]
   (phaser->clj
    (.update mesh)))
  ([mesh args]
   (phaser->clj
    (.update mesh
             (clj->phaser args)))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * mesh (Phaser.GameObjects.Mesh) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([mesh camera]
   (phaser->clj
    (.willRender mesh
                 (clj->phaser camera)))))