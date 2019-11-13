(ns phzr.game-objects.blitter
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Blitter
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs. It can only belong to one Scene at any given time.
    * x (number) {optional} - The x coordinate of this Game Object in world space.
    * y (number) {optional} - The y coordinate of this Game Object in world space.
    * texture (string) {optional} - The key of the texture this Game Object will use for rendering. The Texture must already exist in the Texture Manager.
    * frame (string | integer) {optional} - The Frame of the Texture that this Game Object will use. Only set if the Texture has multiple frames, such as a Texture Atlas or Sprite Sheet."
  ([scene]
   (js/Phaser.GameObjects.Blitter. (clj->phaser scene)))
  ([scene x]
   (js/Phaser.GameObjects.Blitter. (clj->phaser scene)
                                   (clj->phaser x)))
  ([scene x y]
   (js/Phaser.GameObjects.Blitter. (clj->phaser scene)
                                   (clj->phaser x)
                                   (clj->phaser y)))
  ([scene x y texture]
   (js/Phaser.GameObjects.Blitter. (clj->phaser scene)
                                   (clj->phaser x)
                                   (clj->phaser y)
                                   (clj->phaser texture)))
  ([scene x y texture frame]
   (js/Phaser.GameObjects.Blitter. (clj->phaser scene)
                                   (clj->phaser x)
                                   (clj->phaser y)
                                   (clj->phaser texture)
                                   (clj->phaser frame))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([blitter event fn]
   (phaser->clj
    (.addListener blitter
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([blitter event fn context]
   (phaser->clj
    (.addListener blitter
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn child-can-render
  "Checks if the given child can render or not, by checking its `visible` and `alpha` values.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * child (Phaser.GameObjects.Bob) - The Bob to check for rendering.

  Returns:  boolean - Returns `true` if the given child can render, otherwise `false`."
  ([blitter child]
   (phaser->clj
    (.childCanRender blitter
                     (clj->phaser child)))))

(defn clear
  "Removes all Bobs from the children List and clears the dirty flag."
  ([blitter]
   (phaser->clj
    (.clear blitter))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.clearAlpha blitter))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.clearMask blitter)))
  ([blitter destroy-mask]
   (phaser->clj
    (.clearMask blitter
                (clj->phaser destroy-mask)))))

(defn create
  "Creates a new Bob in this Blitter.

  The Bob is created at the given coordinates, relative to the Blitter and uses the given frame.
  A Bob can use any frame belonging to the texture bound to the Blitter.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * x (number) - The x position of the Bob. Bob coordinate are relative to the position of the Blitter object.
    * y (number) - The y position of the Bob. Bob coordinate are relative to the position of the Blitter object.
    * frame (string | integer | Phaser.Textures.Frame) {optional} - The Frame the Bob will use. It _must_ be part of the Texture the parent Blitter object is using.
    * visible (boolean) {optional} - Should the created Bob render or not?
    * index (integer) {optional} - The position in the Blitters Display List to add the new Bob at. Defaults to the top of the list.

  Returns:  Phaser.GameObjects.Bob - The newly created Bob object."
  ([blitter x y]
   (phaser->clj
    (.create blitter
             (clj->phaser x)
             (clj->phaser y))))
  ([blitter x y frame]
   (phaser->clj
    (.create blitter
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser frame))))
  ([blitter x y frame visible]
   (phaser->clj
    (.create blitter
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser frame)
             (clj->phaser visible))))
  ([blitter x y frame visible index]
   (phaser->clj
    (.create blitter
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser frame)
             (clj->phaser visible)
             (clj->phaser index)))))

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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([blitter]
   (phaser->clj
    (.createBitmapMask blitter)))
  ([blitter renderable]
   (phaser->clj
    (.createBitmapMask blitter
                       (clj->phaser renderable)))))

(defn create-from-callback
  "Creates multiple Bob objects within this Blitter and then passes each of them to the specified callback.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * callback (CreateCallback) - The callback to invoke after creating a bob. It will be sent two arguments: The Bob and the index of the Bob.
    * quantity (integer) - The quantity of Bob objects to create.
    * frame (string | integer | Phaser.Textures.Frame | Array.<string> | Array.<integer> | Array.<Phaser.Textures.Frame>) {optional} - The Frame the Bobs will use. It must be part of the Blitter Texture.
    * visible (boolean) {optional} - Should the created Bob render or not?

  Returns:  Array.<Phaser.GameObjects.Bob> - An array of Bob objects that were created."
  ([blitter callback quantity]
   (phaser->clj
    (.createFromCallback blitter
                         (clj->phaser callback)
                         (clj->phaser quantity))))
  ([blitter callback quantity frame]
   (phaser->clj
    (.createFromCallback blitter
                         (clj->phaser callback)
                         (clj->phaser quantity)
                         (clj->phaser frame))))
  ([blitter callback quantity frame visible]
   (phaser->clj
    (.createFromCallback blitter
                         (clj->phaser callback)
                         (clj->phaser quantity)
                         (clj->phaser frame)
                         (clj->phaser visible)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([blitter]
   (phaser->clj
    (.createGeometryMask blitter)))
  ([blitter graphics]
   (phaser->clj
    (.createGeometryMask blitter
                         (clj->phaser graphics)))))

(defn create-multiple
  "Creates multiple Bobs in one call.

  The amount created is controlled by a combination of the `quantity` argument and the number of frames provided.

  If the quantity is set to 10 and you provide 2 frames, then 20 Bobs will be created. 10 with the first
  frame and 10 with the second.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * quantity (integer) - The quantity of Bob objects to create.
    * frame (string | integer | Phaser.Textures.Frame | Array.<string> | Array.<integer> | Array.<Phaser.Textures.Frame>) {optional} - The Frame the Bobs will use. It must be part of the Blitter Texture.
    * visible (boolean) {optional} - Should the created Bob render or not?

  Returns:  Array.<Phaser.GameObjects.Bob> - An array of Bob objects that were created."
  ([blitter quantity]
   (phaser->clj
    (.createMultiple blitter
                     (clj->phaser quantity))))
  ([blitter quantity frame]
   (phaser->clj
    (.createMultiple blitter
                     (clj->phaser quantity)
                     (clj->phaser frame))))
  ([blitter quantity frame visible]
   (phaser->clj
    (.createMultiple blitter
                     (clj->phaser quantity)
                     (clj->phaser frame)
                     (clj->phaser visible)))))

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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([blitter]
   (phaser->clj
    (.destroy blitter)))
  ([blitter from-scene]
   (phaser->clj
    (.destroy blitter
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([blitter]
   (phaser->clj
    (.disableInteractive blitter))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([blitter event]
   (phaser->clj
    (.emit blitter
           (clj->phaser event))))
  ([blitter event args]
   (phaser->clj
    (.emit blitter
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([blitter]
   (phaser->clj
    (.eventNames blitter))))

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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([blitter key]
   (phaser->clj
    (.getData blitter
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([blitter]
   (phaser->clj
    (.getIndexList blitter))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([blitter]
   (phaser->clj
    (.getLocalTransformMatrix blitter)))
  ([blitter temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix blitter
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([blitter]
   (phaser->clj
    (.getParentRotation blitter))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([blitter]
   (phaser->clj
    (.getPipelineName blitter))))

(defn get-render-list
  "Returns an array of Bobs to be rendered.
  If the Blitter is dirty then a new list is generated and stored in `renderList`.

  Returns:  Array.<Phaser.GameObjects.Bob> - An array of Bob objects that will be rendered this frame."
  ([blitter]
   (phaser->clj
    (.getRenderList blitter))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([blitter]
   (phaser->clj
    (.getWorldTransformMatrix blitter)))
  ([blitter temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix blitter
                              (clj->phaser temp-matrix))))
  ([blitter temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix blitter
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([blitter]
   (phaser->clj
    (.initPipeline blitter)))
  ([blitter pipeline-name]
   (phaser->clj
    (.initPipeline blitter
                   (clj->phaser pipeline-name)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([blitter event]
   (phaser->clj
    (.listenerCount blitter
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([blitter event]
   (phaser->clj
    (.listeners blitter
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([blitter event]
   (phaser->clj
    (.off blitter
          (clj->phaser event))))
  ([blitter event fn]
   (phaser->clj
    (.off blitter
          (clj->phaser event)
          (clj->phaser fn))))
  ([blitter event fn context]
   (phaser->clj
    (.off blitter
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([blitter event fn context once]
   (phaser->clj
    (.off blitter
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([blitter event fn]
   (phaser->clj
    (.on blitter
         (clj->phaser event)
         (clj->phaser fn))))
  ([blitter event fn context]
   (phaser->clj
    (.on blitter
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([blitter event fn]
   (phaser->clj
    (.once blitter
           (clj->phaser event)
           (clj->phaser fn))))
  ([blitter event fn context]
   (phaser->clj
    (.once blitter
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([blitter]
   (phaser->clj
    (.removeAllListeners blitter)))
  ([blitter event]
   (phaser->clj
    (.removeAllListeners blitter
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
  ([blitter]
   (phaser->clj
    (.removeInteractive blitter))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([blitter event]
   (phaser->clj
    (.removeListener blitter
                     (clj->phaser event))))
  ([blitter event fn]
   (phaser->clj
    (.removeListener blitter
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([blitter event fn context]
   (phaser->clj
    (.removeListener blitter
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([blitter event fn context once]
   (phaser->clj
    (.removeListener blitter
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([blitter]
   (phaser->clj
    (.resetPipeline blitter))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([blitter value]
   (phaser->clj
    (.setActive blitter
                (clj->phaser value)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setAlpha blitter)))
  ([blitter top-left]
   (phaser->clj
    (.setAlpha blitter
               (clj->phaser top-left))))
  ([blitter top-left top-right]
   (phaser->clj
    (.setAlpha blitter
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([blitter top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha blitter
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([blitter top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha blitter
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setAngle blitter)))
  ([blitter degrees]
   (phaser->clj
    (.setAngle blitter
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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([blitter value]
   (phaser->clj
    (.setBlendMode blitter
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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([blitter key]
   (phaser->clj
    (.setData blitter
              (clj->phaser key))))
  ([blitter key data]
   (phaser->clj
    (.setData blitter
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([blitter]
   (phaser->clj
    (.setDataEnabled blitter))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter value]
   (phaser->clj
    (.setDepth blitter
               (clj->phaser value)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter width height]
   (phaser->clj
    (.setDisplaySize blitter
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-frame
  "Sets the frame this Game Object will use to render with.

  The Frame has to belong to the current Texture being used.

  It can be either a string or an index.

  Calling `setFrame` will modify the `width` and `height` properties of your Game Object.
  It will also change the `origin` if the Frame has a custom pivot point, as exported from packages like Texture Packer.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * frame (string | integer) - The name or index of the frame within the Texture.
    * update-size (boolean) {optional} - Should this call adjust the size of the Game Object?
    * update-origin (boolean) {optional} - Should this call adjust the origin of the Game Object?

  Returns:  this - This Game Object instance."
  ([blitter frame]
   (phaser->clj
    (.setFrame blitter
               (clj->phaser frame))))
  ([blitter frame update-size]
   (phaser->clj
    (.setFrame blitter
               (clj->phaser frame)
               (clj->phaser update-size))))
  ([blitter frame update-size update-origin]
   (phaser->clj
    (.setFrame blitter
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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([blitter]
   (phaser->clj
    (.setInteractive blitter)))
  ([blitter shape]
   (phaser->clj
    (.setInteractive blitter
                     (clj->phaser shape))))
  ([blitter shape callback]
   (phaser->clj
    (.setInteractive blitter
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([blitter shape callback drop-zone]
   (phaser->clj
    (.setInteractive blitter
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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([blitter mask]
   (phaser->clj
    (.setMask blitter
              (clj->phaser mask)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([blitter value]
   (phaser->clj
    (.setName blitter
              (clj->phaser value)))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter pipeline-name]
   (phaser->clj
    (.setPipeline blitter
                  (clj->phaser pipeline-name)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setPosition blitter)))
  ([blitter x]
   (phaser->clj
    (.setPosition blitter
                  (clj->phaser x))))
  ([blitter x y]
   (phaser->clj
    (.setPosition blitter
                  (clj->phaser x)
                  (clj->phaser y))))
  ([blitter x y z]
   (phaser->clj
    (.setPosition blitter
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([blitter x y z w]
   (phaser->clj
    (.setPosition blitter
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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setRandomPosition blitter)))
  ([blitter x]
   (phaser->clj
    (.setRandomPosition blitter
                        (clj->phaser x))))
  ([blitter x y]
   (phaser->clj
    (.setRandomPosition blitter
                        (clj->phaser x)
                        (clj->phaser y))))
  ([blitter x y width]
   (phaser->clj
    (.setRandomPosition blitter
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([blitter x y width height]
   (phaser->clj
    (.setRandomPosition blitter
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setRotation blitter)))
  ([blitter radians]
   (phaser->clj
    (.setRotation blitter
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([blitter x]
   (phaser->clj
    (.setScale blitter
               (clj->phaser x))))
  ([blitter x y]
   (phaser->clj
    (.setScale blitter
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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([blitter x]
   (phaser->clj
    (.setScrollFactor blitter
                      (clj->phaser x))))
  ([blitter x y]
   (phaser->clj
    (.setScrollFactor blitter
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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter width height]
   (phaser->clj
    (.setSize blitter
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
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * frame (Phaser.Textures.Frame) - The frame to base the size of this Game Object on.

  Returns:  this - This Game Object instance."
  ([blitter frame]
   (phaser->clj
    (.setSizeToFrame blitter
                     (clj->phaser frame)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([blitter value]
   (phaser->clj
    (.setState blitter
               (clj->phaser value)))))

(defn set-texture
  "Sets the texture and frame this Game Object will use to render with.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * key (string | Phaser.Textures.Texture) - The key of the texture to be used, as stored in the Texture Manager, or a Texture instance.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.

  Returns:  this - This Game Object instance."
  ([blitter key]
   (phaser->clj
    (.setTexture blitter
                 (clj->phaser key))))
  ([blitter key frame]
   (phaser->clj
    (.setTexture blitter
                 (clj->phaser key)
                 (clj->phaser frame)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([blitter value]
   (phaser->clj
    (.setVisible blitter
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setW blitter)))
  ([blitter value]
   (phaser->clj
    (.setW blitter
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setX blitter)))
  ([blitter value]
   (phaser->clj
    (.setX blitter
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setY blitter)))
  ([blitter value]
   (phaser->clj
    (.setY blitter
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([blitter]
   (phaser->clj
    (.setZ blitter)))
  ([blitter value]
   (phaser->clj
    (.setZ blitter
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([blitter]
   (phaser->clj
    (.shutdown blitter))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([blitter]
   (phaser->clj
    (.toJSON blitter))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * args (*) {optional} - args"
  ([blitter]
   (phaser->clj
    (.update blitter)))
  ([blitter args]
   (phaser->clj
    (.update blitter
             (clj->phaser args)))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([blitter camera]
   (phaser->clj
    (.willRender blitter
                 (clj->phaser camera)))))