(ns phzr.game-objects.dynamic-bitmap-text
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->DynamicBitmapText
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs. It can only belong to one Scene at any given time.
    * x (number) - The x coordinate of this Game Object in world space.
    * y (number) - The y coordinate of this Game Object in world space.
    * font (string) - The key of the font to use from the Bitmap Font cache.
    * text (string | Array.<string>) {optional} - The string, or array of strings, to be set as the content of this Bitmap Text.
    * size (number) {optional} - The font size of this Bitmap Text.
    * align (integer) {optional} - The alignment of the text in a multi-line BitmapText object."
  ([scene x y font]
   (js/Phaser.GameObjects.DynamicBitmapText. (clj->phaser scene)
                                             (clj->phaser x)
                                             (clj->phaser y)
                                             (clj->phaser font)))
  ([scene x y font text]
   (js/Phaser.GameObjects.DynamicBitmapText. (clj->phaser scene)
                                             (clj->phaser x)
                                             (clj->phaser y)
                                             (clj->phaser font)
                                             (clj->phaser text)))
  ([scene x y font text size]
   (js/Phaser.GameObjects.DynamicBitmapText. (clj->phaser scene)
                                             (clj->phaser x)
                                             (clj->phaser y)
                                             (clj->phaser font)
                                             (clj->phaser text)
                                             (clj->phaser size)))
  ([scene x y font text size align]
   (js/Phaser.GameObjects.DynamicBitmapText. (clj->phaser scene)
                                             (clj->phaser x)
                                             (clj->phaser y)
                                             (clj->phaser font)
                                             (clj->phaser text)
                                             (clj->phaser size)
                                             (clj->phaser align))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dynamic-bitmap-text event fn]
   (phaser->clj
    (.addListener dynamic-bitmap-text
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([dynamic-bitmap-text event fn context]
   (phaser->clj
    (.addListener dynamic-bitmap-text
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.clearAlpha dynamic-bitmap-text))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.clearMask dynamic-bitmap-text)))
  ([dynamic-bitmap-text destroy-mask]
   (phaser->clj
    (.clearMask dynamic-bitmap-text
                (clj->phaser destroy-mask)))))

(defn clear-tint
  "Clears all tint values associated with this Game Object.

  Immediately sets the color values back to 0xffffff and the tint type to 'additive',
  which results in no visible change to the texture.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.clearTint dynamic-bitmap-text))))

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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.createBitmapMask dynamic-bitmap-text)))
  ([dynamic-bitmap-text renderable]
   (phaser->clj
    (.createBitmapMask dynamic-bitmap-text
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.createGeometryMask dynamic-bitmap-text)))
  ([dynamic-bitmap-text graphics]
   (phaser->clj
    (.createGeometryMask dynamic-bitmap-text
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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([dynamic-bitmap-text]
   (phaser->clj
    (.destroy dynamic-bitmap-text)))
  ([dynamic-bitmap-text from-scene]
   (phaser->clj
    (.destroy dynamic-bitmap-text
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.disableInteractive dynamic-bitmap-text))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([dynamic-bitmap-text event]
   (phaser->clj
    (.emit dynamic-bitmap-text
           (clj->phaser event))))
  ([dynamic-bitmap-text event args]
   (phaser->clj
    (.emit dynamic-bitmap-text
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([dynamic-bitmap-text]
   (phaser->clj
    (.eventNames dynamic-bitmap-text))))

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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([dynamic-bitmap-text key]
   (phaser->clj
    (.getData dynamic-bitmap-text
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.getIndexList dynamic-bitmap-text))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.getLocalTransformMatrix dynamic-bitmap-text)))
  ([dynamic-bitmap-text temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix dynamic-bitmap-text
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.getParentRotation dynamic-bitmap-text))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.getPipelineName dynamic-bitmap-text))))

(defn get-text-bounds
  "Calculate the bounds of this Bitmap Text.

  An object is returned that contains the position, width and height of the Bitmap Text in local and global
  contexts.

  Local size is based on just the font size and a [0, 0] position.

  Global size takes into account the Game Object's scale, world position and display origin.

  Also in the object is data regarding the length of each line, should this be a multi-line BitmapText.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * round (boolean) {optional} - Whether to round the results to the nearest integer.

  Returns:  Phaser.Types.GameObjects.BitmapText.BitmapTextSize - An object that describes the size of this Bitmap Text."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.getTextBounds dynamic-bitmap-text)))
  ([dynamic-bitmap-text round]
   (phaser->clj
    (.getTextBounds dynamic-bitmap-text
                    (clj->phaser round)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.getWorldTransformMatrix dynamic-bitmap-text)))
  ([dynamic-bitmap-text temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix dynamic-bitmap-text
                              (clj->phaser temp-matrix))))
  ([dynamic-bitmap-text temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix dynamic-bitmap-text
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.initPipeline dynamic-bitmap-text)))
  ([dynamic-bitmap-text pipeline-name]
   (phaser->clj
    (.initPipeline dynamic-bitmap-text
                   (clj->phaser pipeline-name)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([dynamic-bitmap-text event]
   (phaser->clj
    (.listenerCount dynamic-bitmap-text
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([dynamic-bitmap-text event]
   (phaser->clj
    (.listeners dynamic-bitmap-text
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dynamic-bitmap-text event]
   (phaser->clj
    (.off dynamic-bitmap-text
          (clj->phaser event))))
  ([dynamic-bitmap-text event fn]
   (phaser->clj
    (.off dynamic-bitmap-text
          (clj->phaser event)
          (clj->phaser fn))))
  ([dynamic-bitmap-text event fn context]
   (phaser->clj
    (.off dynamic-bitmap-text
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([dynamic-bitmap-text event fn context once]
   (phaser->clj
    (.off dynamic-bitmap-text
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dynamic-bitmap-text event fn]
   (phaser->clj
    (.on dynamic-bitmap-text
         (clj->phaser event)
         (clj->phaser fn))))
  ([dynamic-bitmap-text event fn context]
   (phaser->clj
    (.on dynamic-bitmap-text
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dynamic-bitmap-text event fn]
   (phaser->clj
    (.once dynamic-bitmap-text
           (clj->phaser event)
           (clj->phaser fn))))
  ([dynamic-bitmap-text event fn context]
   (phaser->clj
    (.once dynamic-bitmap-text
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.removeAllListeners dynamic-bitmap-text)))
  ([dynamic-bitmap-text event]
   (phaser->clj
    (.removeAllListeners dynamic-bitmap-text
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
  ([dynamic-bitmap-text]
   (phaser->clj
    (.removeInteractive dynamic-bitmap-text))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dynamic-bitmap-text event]
   (phaser->clj
    (.removeListener dynamic-bitmap-text
                     (clj->phaser event))))
  ([dynamic-bitmap-text event fn]
   (phaser->clj
    (.removeListener dynamic-bitmap-text
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([dynamic-bitmap-text event fn context]
   (phaser->clj
    (.removeListener dynamic-bitmap-text
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([dynamic-bitmap-text event fn context once]
   (phaser->clj
    (.removeListener dynamic-bitmap-text
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.resetPipeline dynamic-bitmap-text))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setActive dynamic-bitmap-text
                (clj->phaser value)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setAlpha dynamic-bitmap-text)))
  ([dynamic-bitmap-text top-left]
   (phaser->clj
    (.setAlpha dynamic-bitmap-text
               (clj->phaser top-left))))
  ([dynamic-bitmap-text top-left top-right]
   (phaser->clj
    (.setAlpha dynamic-bitmap-text
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([dynamic-bitmap-text top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha dynamic-bitmap-text
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([dynamic-bitmap-text top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha dynamic-bitmap-text
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setAngle dynamic-bitmap-text)))
  ([dynamic-bitmap-text degrees]
   (phaser->clj
    (.setAngle dynamic-bitmap-text
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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setBlendMode dynamic-bitmap-text
                   (clj->phaser value)))))

(defn set-center-align
  "Set the lines of text in this BitmapText to be center-aligned.
  This only has any effect if this BitmapText contains more than one line of text.

  Returns:  this - This BitmapText Object."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setCenterAlign dynamic-bitmap-text))))

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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([dynamic-bitmap-text key]
   (phaser->clj
    (.setData dynamic-bitmap-text
              (clj->phaser key))))
  ([dynamic-bitmap-text key data]
   (phaser->clj
    (.setData dynamic-bitmap-text
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setDataEnabled dynamic-bitmap-text))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setDepth dynamic-bitmap-text
               (clj->phaser value)))))

(defn set-display-callback
  "Set a callback that alters how each character of the Bitmap Text is rendered.

  The callback receives a {@link Phaser.Types.GameObjects.BitmapText.DisplayCallbackConfig} object that contains information about the character that's
  about to be rendered.

  It should return an object with `x`, `y`, `scale` and `rotation` properties that will be used instead of the
  usual values when rendering.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * callback (Phaser.Types.GameObjects.BitmapText.DisplayCallback) - The display callback to set.

  Returns:  Phaser.GameObjects.DynamicBitmapText - This Game Object."
  ([dynamic-bitmap-text callback]
   (phaser->clj
    (.setDisplayCallback dynamic-bitmap-text
                         (clj->phaser callback)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setDisplayOrigin dynamic-bitmap-text)))
  ([dynamic-bitmap-text x]
   (phaser->clj
    (.setDisplayOrigin dynamic-bitmap-text
                       (clj->phaser x))))
  ([dynamic-bitmap-text x y]
   (phaser->clj
    (.setDisplayOrigin dynamic-bitmap-text
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-font
  "Changes the font this BitmapText is using to render.

  The new texture is loaded and applied to the BitmapText. The existing test, size and alignment are preserved,
  unless overridden via the arguments.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * font (string) - The key of the font to use from the Bitmap Font cache.
    * size (number) {optional} - The font size of this Bitmap Text. If not specified the current size will be used.
    * align (integer) {optional} - The alignment of the text in a multi-line BitmapText object. If not specified the current alignment will be used.

  Returns:  this - This BitmapText Object."
  ([dynamic-bitmap-text font]
   (phaser->clj
    (.setFont dynamic-bitmap-text
              (clj->phaser font))))
  ([dynamic-bitmap-text font size]
   (phaser->clj
    (.setFont dynamic-bitmap-text
              (clj->phaser font)
              (clj->phaser size))))
  ([dynamic-bitmap-text font size align]
   (phaser->clj
    (.setFont dynamic-bitmap-text
              (clj->phaser font)
              (clj->phaser size)
              (clj->phaser align)))))

(defn set-font-size
  "Set the font size of this Bitmap Text.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * size (number) - The font size to set.

  Returns:  this - This BitmapText Object."
  ([dynamic-bitmap-text size]
   (phaser->clj
    (.setFontSize dynamic-bitmap-text
                  (clj->phaser size)))))

(defn set-frame
  "Sets the frame this Game Object will use to render with.

  The Frame has to belong to the current Texture being used.

  It can be either a string or an index.

  Calling `setFrame` will modify the `width` and `height` properties of your Game Object.
  It will also change the `origin` if the Frame has a custom pivot point, as exported from packages like Texture Packer.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * frame (string | integer) - The name or index of the frame within the Texture.
    * update-size (boolean) {optional} - Should this call adjust the size of the Game Object?
    * update-origin (boolean) {optional} - Should this call adjust the origin of the Game Object?

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text frame]
   (phaser->clj
    (.setFrame dynamic-bitmap-text
               (clj->phaser frame))))
  ([dynamic-bitmap-text frame update-size]
   (phaser->clj
    (.setFrame dynamic-bitmap-text
               (clj->phaser frame)
               (clj->phaser update-size))))
  ([dynamic-bitmap-text frame update-size update-origin]
   (phaser->clj
    (.setFrame dynamic-bitmap-text
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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setInteractive dynamic-bitmap-text)))
  ([dynamic-bitmap-text shape]
   (phaser->clj
    (.setInteractive dynamic-bitmap-text
                     (clj->phaser shape))))
  ([dynamic-bitmap-text shape callback]
   (phaser->clj
    (.setInteractive dynamic-bitmap-text
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([dynamic-bitmap-text shape callback drop-zone]
   (phaser->clj
    (.setInteractive dynamic-bitmap-text
                     (clj->phaser shape)
                     (clj->phaser callback)
                     (clj->phaser drop-zone)))))

(defn set-left-align
  "Set the lines of text in this BitmapText to be left-aligned.
  This only has any effect if this BitmapText contains more than one line of text.

  Returns:  this - This BitmapText Object."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setLeftAlign dynamic-bitmap-text))))

(defn set-letter-spacing
  "Sets the letter spacing between each character of this Bitmap Text.
  Can be a positive value to increase the space, or negative to reduce it.
  Spacing is applied after the kerning values have been set.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * spacing (number) {optional} - The amount of horizontal space to add between each character.

  Returns:  this - This BitmapText Object."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setLetterSpacing dynamic-bitmap-text)))
  ([dynamic-bitmap-text spacing]
   (phaser->clj
    (.setLetterSpacing dynamic-bitmap-text
                       (clj->phaser spacing)))))

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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text mask]
   (phaser->clj
    (.setMask dynamic-bitmap-text
              (clj->phaser mask)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setName dynamic-bitmap-text
              (clj->phaser value)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setOrigin dynamic-bitmap-text)))
  ([dynamic-bitmap-text x]
   (phaser->clj
    (.setOrigin dynamic-bitmap-text
                (clj->phaser x))))
  ([dynamic-bitmap-text x y]
   (phaser->clj
    (.setOrigin dynamic-bitmap-text
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setOriginFromFrame dynamic-bitmap-text))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text pipeline-name]
   (phaser->clj
    (.setPipeline dynamic-bitmap-text
                  (clj->phaser pipeline-name)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setPosition dynamic-bitmap-text)))
  ([dynamic-bitmap-text x]
   (phaser->clj
    (.setPosition dynamic-bitmap-text
                  (clj->phaser x))))
  ([dynamic-bitmap-text x y]
   (phaser->clj
    (.setPosition dynamic-bitmap-text
                  (clj->phaser x)
                  (clj->phaser y))))
  ([dynamic-bitmap-text x y z]
   (phaser->clj
    (.setPosition dynamic-bitmap-text
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([dynamic-bitmap-text x y z w]
   (phaser->clj
    (.setPosition dynamic-bitmap-text
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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setRandomPosition dynamic-bitmap-text)))
  ([dynamic-bitmap-text x]
   (phaser->clj
    (.setRandomPosition dynamic-bitmap-text
                        (clj->phaser x))))
  ([dynamic-bitmap-text x y]
   (phaser->clj
    (.setRandomPosition dynamic-bitmap-text
                        (clj->phaser x)
                        (clj->phaser y))))
  ([dynamic-bitmap-text x y width]
   (phaser->clj
    (.setRandomPosition dynamic-bitmap-text
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([dynamic-bitmap-text x y width height]
   (phaser->clj
    (.setRandomPosition dynamic-bitmap-text
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-right-align
  "Set the lines of text in this BitmapText to be right-aligned.
  This only has any effect if this BitmapText contains more than one line of text.

  Returns:  this - This BitmapText Object."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setRightAlign dynamic-bitmap-text))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setRotation dynamic-bitmap-text)))
  ([dynamic-bitmap-text radians]
   (phaser->clj
    (.setRotation dynamic-bitmap-text
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text x]
   (phaser->clj
    (.setScale dynamic-bitmap-text
               (clj->phaser x))))
  ([dynamic-bitmap-text x y]
   (phaser->clj
    (.setScale dynamic-bitmap-text
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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text x]
   (phaser->clj
    (.setScrollFactor dynamic-bitmap-text
                      (clj->phaser x))))
  ([dynamic-bitmap-text x y]
   (phaser->clj
    (.setScrollFactor dynamic-bitmap-text
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-scroll-x
  "Set the horizontal scroll position of this Bitmap Text.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (number) - The horizontal scroll position to set.

  Returns:  Phaser.GameObjects.DynamicBitmapText - This Game Object."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setScrollX dynamic-bitmap-text
                 (clj->phaser value)))))

(defn set-scroll-y
  "Set the vertical scroll position of this Bitmap Text.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (number) - The vertical scroll position to set.

  Returns:  Phaser.GameObjects.DynamicBitmapText - This Game Object."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setScrollY dynamic-bitmap-text
                 (clj->phaser value)))))

(defn set-size
  "Set the crop size of this Bitmap Text.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * width (number) - The width of the crop.
    * height (number) - The height of the crop.

  Returns:  Phaser.GameObjects.DynamicBitmapText - This Game Object."
  ([dynamic-bitmap-text width height]
   (phaser->clj
    (.setSize dynamic-bitmap-text
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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setState dynamic-bitmap-text
               (clj->phaser value)))))

(defn set-text
  "Set the textual content of this BitmapText.

  An array of strings will be converted into multi-line text. Use the align methods to change multi-line alignment.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (string | Array.<string>) - The string, or array of strings, to be set as the content of this BitmapText.

  Returns:  this - This BitmapText Object."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setText dynamic-bitmap-text
              (clj->phaser value)))))

(defn set-texture
  "Sets the texture and frame this Game Object will use to render with.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * key (string | Phaser.Textures.Texture) - The key of the texture to be used, as stored in the Texture Manager, or a Texture instance.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text key]
   (phaser->clj
    (.setTexture dynamic-bitmap-text
                 (clj->phaser key))))
  ([dynamic-bitmap-text key frame]
   (phaser->clj
    (.setTexture dynamic-bitmap-text
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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If no other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setTint dynamic-bitmap-text)))
  ([dynamic-bitmap-text top-left]
   (phaser->clj
    (.setTint dynamic-bitmap-text
              (clj->phaser top-left))))
  ([dynamic-bitmap-text top-left top-right]
   (phaser->clj
    (.setTint dynamic-bitmap-text
              (clj->phaser top-left)
              (clj->phaser top-right))))
  ([dynamic-bitmap-text top-left top-right bottom-left]
   (phaser->clj
    (.setTint dynamic-bitmap-text
              (clj->phaser top-left)
              (clj->phaser top-right)
              (clj->phaser bottom-left))))
  ([dynamic-bitmap-text top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTint dynamic-bitmap-text
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
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If not other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setTintFill dynamic-bitmap-text)))
  ([dynamic-bitmap-text top-left]
   (phaser->clj
    (.setTintFill dynamic-bitmap-text
                  (clj->phaser top-left))))
  ([dynamic-bitmap-text top-left top-right]
   (phaser->clj
    (.setTintFill dynamic-bitmap-text
                  (clj->phaser top-left)
                  (clj->phaser top-right))))
  ([dynamic-bitmap-text top-left top-right bottom-left]
   (phaser->clj
    (.setTintFill dynamic-bitmap-text
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left))))
  ([dynamic-bitmap-text top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTintFill dynamic-bitmap-text
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left)
                  (clj->phaser bottom-right)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setVisible dynamic-bitmap-text
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setW dynamic-bitmap-text)))
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setW dynamic-bitmap-text
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setX dynamic-bitmap-text)))
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setX dynamic-bitmap-text
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setY dynamic-bitmap-text)))
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setY dynamic-bitmap-text
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.setZ dynamic-bitmap-text)))
  ([dynamic-bitmap-text value]
   (phaser->clj
    (.setZ dynamic-bitmap-text
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.shutdown dynamic-bitmap-text))))

(defn to-json
  "Build a JSON representation of this Bitmap Text.

  Returns:  Phaser.Types.GameObjects.BitmapText.JSONBitmapText - A JSON representation of this Bitmap Text."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.toJSON dynamic-bitmap-text))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * args (*) {optional} - args"
  ([dynamic-bitmap-text]
   (phaser->clj
    (.update dynamic-bitmap-text)))
  ([dynamic-bitmap-text args]
   (phaser->clj
    (.update dynamic-bitmap-text
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([dynamic-bitmap-text]
   (phaser->clj
    (.updateDisplayOrigin dynamic-bitmap-text))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * dynamic-bitmap-text (Phaser.GameObjects.DynamicBitmapText) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([dynamic-bitmap-text camera]
   (phaser->clj
    (.willRender dynamic-bitmap-text
                 (clj->phaser camera)))))