(ns phzr.game-objects.render-texture
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->RenderTexture
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs. A Game Object can only belong to one Scene at a time.
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * width (integer) {optional} - The width of the Render Texture.
    * height (integer) {optional} - The height of the Render Texture."
  ([scene]
   (js/Phaser.GameObjects.RenderTexture. (clj->phaser scene)))
  ([scene x]
   (js/Phaser.GameObjects.RenderTexture. (clj->phaser scene)
                                         (clj->phaser x)))
  ([scene x y]
   (js/Phaser.GameObjects.RenderTexture. (clj->phaser scene)
                                         (clj->phaser x)
                                         (clj->phaser y)))
  ([scene x y width]
   (js/Phaser.GameObjects.RenderTexture. (clj->phaser scene)
                                         (clj->phaser x)
                                         (clj->phaser y)
                                         (clj->phaser width)))
  ([scene x y width height]
   (js/Phaser.GameObjects.RenderTexture. (clj->phaser scene)
                                         (clj->phaser x)
                                         (clj->phaser y)
                                         (clj->phaser width)
                                         (clj->phaser height))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([render-texture event fn]
   (phaser->clj
    (.addListener render-texture
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([render-texture event fn context]
   (phaser->clj
    (.addListener render-texture
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn clear
  "Clears the Render Texture.

  Returns:  this - This Render Texture instance."
  ([render-texture]
   (phaser->clj
    (.clear render-texture))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.clearAlpha render-texture))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.clearMask render-texture)))
  ([render-texture destroy-mask]
   (phaser->clj
    (.clearMask render-texture
                (clj->phaser destroy-mask)))))

(defn clear-tint
  "Clears all tint values associated with this Game Object.

  Immediately sets the color values back to 0xffffff and the tint type to 'additive',
  which results in no visible change to the texture.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.clearTint render-texture))))

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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([render-texture]
   (phaser->clj
    (.createBitmapMask render-texture)))
  ([render-texture renderable]
   (phaser->clj
    (.createBitmapMask render-texture
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([render-texture]
   (phaser->clj
    (.createGeometryMask render-texture)))
  ([render-texture graphics]
   (phaser->clj
    (.createGeometryMask render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([render-texture]
   (phaser->clj
    (.destroy render-texture)))
  ([render-texture from-scene]
   (phaser->clj
    (.destroy render-texture
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([render-texture]
   (phaser->clj
    (.disableInteractive render-texture))))

(defn draw
  "Draws the given object, or an array of objects, to this Render Texture.

  It can accept any of the following:

  * Any renderable Game Object, such as a Sprite, Text, Graphics or TileSprite.
  * Dynamic and Static Tilemap Layers.
  * A Group. The contents of which will be iterated and drawn in turn.
  * A Container. The contents of which will be iterated fully, and drawn in turn.
  * A Scene's Display List. Pass in `Scene.children` to draw the whole list.
  * Another Render Texture.
  * A Texture Frame instance.
  * A string. This is used to look-up a texture from the Texture Manager.

  Note: You cannot draw a Render Texture to itself.

  If passing in a Group or Container it will only draw children that return `true`
  when their `willRender()` method is called. I.e. a Container with 10 children,
  5 of which have `visible=false` will only draw the 5 visible ones.

  If passing in an array of Game Objects it will draw them all, regardless if
  they pass a `willRender` check or not.

  You can pass in a string in which case it will look for a texture in the Texture
  Manager matching that string, and draw the base frame. If you need to specify
  exactly which frame to draw then use the method `drawFrame` instead.

  You can pass in the `x` and `y` coordinates to draw the objects at. The use of
  the coordinates differ based on what objects are being drawn. If the object is
  a Group, Container or Display List, the coordinates are _added_ to the positions
  of the children. For all other types of object, the coordinates are exact.

  The `alpha` and `tint` values are only used by Texture Frames.
  Game Objects use their own alpha and tint values when being drawn.

  Calling this method causes the WebGL batch to flush, so it can write the texture
  data to the framebuffer being used internally. The batch is flushed at the end,
  after the entries have been iterated. So if you've a bunch of objects to draw,
  try and pass them in an array in one single call, rather than making lots of
  separate calls.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * entries (any) - Any renderable Game Object, or Group, Container, Display List, other Render Texture, Texture Frame or an array of any of these.
    * x (number) {optional} - The x position to draw the Frame at, or the offset applied to the object.
    * y (number) {optional} - The y position to draw the Frame at, or the offset applied to the object.
    * alpha (number) {optional} - The alpha value. Only used for Texture Frames and if not specified defaults to the `globalAlpha` property. Game Objects use their own current alpha value.
    * tint (number) {optional} - WebGL only. The tint color value. Only used for Texture Frames and if not specified defaults to the `globalTint` property. Game Objects use their own current tint value.

  Returns:  this - This Render Texture instance."
  ([render-texture entries]
   (phaser->clj
    (.draw render-texture
           (clj->phaser entries))))
  ([render-texture entries x]
   (phaser->clj
    (.draw render-texture
           (clj->phaser entries)
           (clj->phaser x))))
  ([render-texture entries x y]
   (phaser->clj
    (.draw render-texture
           (clj->phaser entries)
           (clj->phaser x)
           (clj->phaser y))))
  ([render-texture entries x y alpha]
   (phaser->clj
    (.draw render-texture
           (clj->phaser entries)
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser alpha))))
  ([render-texture entries x y alpha tint]
   (phaser->clj
    (.draw render-texture
           (clj->phaser entries)
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser alpha)
           (clj->phaser tint)))))

(defn draw-frame
  "Draws the Texture Frame to the Render Texture at the given position.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  ```javascript
  var rt = this.add.renderTexture(0, 0, 800, 600);
  rt.drawFrame(key, frame);
  ```

  You can optionally provide a position, alpha and tint value to apply to the frame
  before it is drawn.

  Calling this method will cause a batch flush, so if you've got a stack of things to draw
  in a tight loop, try using the `draw` method instead.

  If you need to draw a Sprite to this Render Texture, use the `draw` method instead.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * key (string) - The key of the texture to be used, as stored in the Texture Manager.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.
    * x (number) {optional} - The x position to draw the frame at.
    * y (number) {optional} - The y position to draw the frame at.
    * alpha (number) {optional} - The alpha to use. If not specified it uses the `globalAlpha` property.
    * tint (number) {optional} - WebGL only. The tint color to use. If not specified it uses the `globalTint` property.

  Returns:  this - This Render Texture instance."
  ([render-texture key]
   (phaser->clj
    (.drawFrame render-texture
                (clj->phaser key))))
  ([render-texture key frame]
   (phaser->clj
    (.drawFrame render-texture
                (clj->phaser key)
                (clj->phaser frame))))
  ([render-texture key frame x]
   (phaser->clj
    (.drawFrame render-texture
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser x))))
  ([render-texture key frame x y]
   (phaser->clj
    (.drawFrame render-texture
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser x)
                (clj->phaser y))))
  ([render-texture key frame x y alpha]
   (phaser->clj
    (.drawFrame render-texture
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser alpha))))
  ([render-texture key frame x y alpha tint]
   (phaser->clj
    (.drawFrame render-texture
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser alpha)
                (clj->phaser tint)))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([render-texture event]
   (phaser->clj
    (.emit render-texture
           (clj->phaser event))))
  ([render-texture event args]
   (phaser->clj
    (.emit render-texture
           (clj->phaser event)
           (clj->phaser args)))))

(defn erase
  "Draws the given object, or an array of objects, to this Render Texture using a blend mode of ERASE.
  This has the effect of erasing any filled pixels in the objects from this Render Texture.

  It can accept any of the following:

  * Any renderable Game Object, such as a Sprite, Text, Graphics or TileSprite.
  * Dynamic and Static Tilemap Layers.
  * A Group. The contents of which will be iterated and drawn in turn.
  * A Container. The contents of which will be iterated fully, and drawn in turn.
  * A Scene's Display List. Pass in `Scene.children` to draw the whole list.
  * Another Render Texture.
  * A Texture Frame instance.
  * A string. This is used to look-up a texture from the Texture Manager.

  Note: You cannot erase a Render Texture from itself.

  If passing in a Group or Container it will only draw children that return `true`
  when their `willRender()` method is called. I.e. a Container with 10 children,
  5 of which have `visible=false` will only draw the 5 visible ones.

  If passing in an array of Game Objects it will draw them all, regardless if
  they pass a `willRender` check or not.

  You can pass in a string in which case it will look for a texture in the Texture
  Manager matching that string, and draw the base frame.

  You can pass in the `x` and `y` coordinates to draw the objects at. The use of
  the coordinates differ based on what objects are being drawn. If the object is
  a Group, Container or Display List, the coordinates are _added_ to the positions
  of the children. For all other types of object, the coordinates are exact.

  Calling this method causes the WebGL batch to flush, so it can write the texture
  data to the framebuffer being used internally. The batch is flushed at the end,
  after the entries have been iterated. So if you've a bunch of objects to draw,
  try and pass them in an array in one single call, rather than making lots of
  separate calls.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * entries (any) - Any renderable Game Object, or Group, Container, Display List, other Render Texture, Texture Frame or an array of any of these.
    * x (number) {optional} - The x position to draw the Frame at, or the offset applied to the object.
    * y (number) {optional} - The y position to draw the Frame at, or the offset applied to the object.

  Returns:  this - This Render Texture instance."
  ([render-texture entries]
   (phaser->clj
    (.erase render-texture
            (clj->phaser entries))))
  ([render-texture entries x]
   (phaser->clj
    (.erase render-texture
            (clj->phaser entries)
            (clj->phaser x))))
  ([render-texture entries x y]
   (phaser->clj
    (.erase render-texture
            (clj->phaser entries)
            (clj->phaser x)
            (clj->phaser y)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([render-texture]
   (phaser->clj
    (.eventNames render-texture))))

(defn fill
  "Fills the Render Texture with the given color.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * rgb (number) - The color to fill the Render Texture with.
    * alpha (number) {optional} - The alpha value used by the fill.
    * x (number) {optional} - The left coordinate of the fill rectangle.
    * y (number) {optional} - The top coordinate of the fill rectangle.
    * width (number) {optional} - The width of the fill rectangle.
    * height (number) {optional} - The height of the fill rectangle.

  Returns:  this - This Render Texture instance."
  ([render-texture rgb]
   (phaser->clj
    (.fill render-texture
           (clj->phaser rgb))))
  ([render-texture rgb alpha]
   (phaser->clj
    (.fill render-texture
           (clj->phaser rgb)
           (clj->phaser alpha))))
  ([render-texture rgb alpha x]
   (phaser->clj
    (.fill render-texture
           (clj->phaser rgb)
           (clj->phaser alpha)
           (clj->phaser x))))
  ([render-texture rgb alpha x y]
   (phaser->clj
    (.fill render-texture
           (clj->phaser rgb)
           (clj->phaser alpha)
           (clj->phaser x)
           (clj->phaser y))))
  ([render-texture rgb alpha x y width]
   (phaser->clj
    (.fill render-texture
           (clj->phaser rgb)
           (clj->phaser alpha)
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width))))
  ([render-texture rgb alpha x y width height]
   (phaser->clj
    (.fill render-texture
           (clj->phaser rgb)
           (clj->phaser alpha)
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)))))

(defn get-bottom-center
  "Gets the bottom-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getBottomCenter render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getBottomCenter render-texture
                      (clj->phaser output))))
  ([render-texture output include-parent]
   (phaser->clj
    (.getBottomCenter render-texture
                      (clj->phaser output)
                      (clj->phaser include-parent)))))

(defn get-bottom-left
  "Gets the bottom-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getBottomLeft render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getBottomLeft render-texture
                    (clj->phaser output))))
  ([render-texture output include-parent]
   (phaser->clj
    (.getBottomLeft render-texture
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-bottom-right
  "Gets the bottom-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getBottomRight render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getBottomRight render-texture
                     (clj->phaser output))))
  ([render-texture output include-parent]
   (phaser->clj
    (.getBottomRight render-texture
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-bounds
  "Gets the bounds of this Game Object, regardless of origin.
  The values are stored and returned in a Rectangle, or Rectangle-like, object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Geom.Rectangle | object) {optional} - An object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getBounds render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getBounds render-texture
                (clj->phaser output)))))

(defn get-center
  "Gets the center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getCenter render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getCenter render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([render-texture key]
   (phaser->clj
    (.getData render-texture
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([render-texture]
   (phaser->clj
    (.getIndexList render-texture))))

(defn get-left-center
  "Gets the left-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getLeftCenter render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getLeftCenter render-texture
                    (clj->phaser output))))
  ([render-texture output include-parent]
   (phaser->clj
    (.getLeftCenter render-texture
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([render-texture]
   (phaser->clj
    (.getLocalTransformMatrix render-texture)))
  ([render-texture temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix render-texture
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([render-texture]
   (phaser->clj
    (.getParentRotation render-texture))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([render-texture]
   (phaser->clj
    (.getPipelineName render-texture))))

(defn get-right-center
  "Gets the right-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getRightCenter render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getRightCenter render-texture
                     (clj->phaser output))))
  ([render-texture output include-parent]
   (phaser->clj
    (.getRightCenter render-texture
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-top-center
  "Gets the top-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getTopCenter render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getTopCenter render-texture
                   (clj->phaser output))))
  ([render-texture output include-parent]
   (phaser->clj
    (.getTopCenter render-texture
                   (clj->phaser output)
                   (clj->phaser include-parent)))))

(defn get-top-left
  "Gets the top-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getTopLeft render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getTopLeft render-texture
                 (clj->phaser output))))
  ([render-texture output include-parent]
   (phaser->clj
    (.getTopLeft render-texture
                 (clj->phaser output)
                 (clj->phaser include-parent)))))

(defn get-top-right
  "Gets the top-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([render-texture]
   (phaser->clj
    (.getTopRight render-texture)))
  ([render-texture output]
   (phaser->clj
    (.getTopRight render-texture
                  (clj->phaser output))))
  ([render-texture output include-parent]
   (phaser->clj
    (.getTopRight render-texture
                  (clj->phaser output)
                  (clj->phaser include-parent)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([render-texture]
   (phaser->clj
    (.getWorldTransformMatrix render-texture)))
  ([render-texture temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix render-texture
                              (clj->phaser temp-matrix))))
  ([render-texture temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix render-texture
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([render-texture]
   (phaser->clj
    (.initPipeline render-texture)))
  ([render-texture pipeline-name]
   (phaser->clj
    (.initPipeline render-texture
                   (clj->phaser pipeline-name)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([render-texture event]
   (phaser->clj
    (.listenerCount render-texture
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([render-texture event]
   (phaser->clj
    (.listeners render-texture
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([render-texture event]
   (phaser->clj
    (.off render-texture
          (clj->phaser event))))
  ([render-texture event fn]
   (phaser->clj
    (.off render-texture
          (clj->phaser event)
          (clj->phaser fn))))
  ([render-texture event fn context]
   (phaser->clj
    (.off render-texture
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([render-texture event fn context once]
   (phaser->clj
    (.off render-texture
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([render-texture event fn]
   (phaser->clj
    (.on render-texture
         (clj->phaser event)
         (clj->phaser fn))))
  ([render-texture event fn context]
   (phaser->clj
    (.on render-texture
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([render-texture event fn]
   (phaser->clj
    (.once render-texture
           (clj->phaser event)
           (clj->phaser fn))))
  ([render-texture event fn context]
   (phaser->clj
    (.once render-texture
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([render-texture]
   (phaser->clj
    (.removeAllListeners render-texture)))
  ([render-texture event]
   (phaser->clj
    (.removeAllListeners render-texture
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
  ([render-texture]
   (phaser->clj
    (.removeInteractive render-texture))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([render-texture event]
   (phaser->clj
    (.removeListener render-texture
                     (clj->phaser event))))
  ([render-texture event fn]
   (phaser->clj
    (.removeListener render-texture
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([render-texture event fn context]
   (phaser->clj
    (.removeListener render-texture
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([render-texture event fn context once]
   (phaser->clj
    (.removeListener render-texture
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-flip
  "Resets the horizontal and vertical flipped state of this Game Object back to their default un-flipped state.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.resetFlip render-texture))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([render-texture]
   (phaser->clj
    (.resetPipeline render-texture))))

(defn resize
  "Resizes the Render Texture to the new dimensions given.

  If Render Texture was created from specific frame, only the size of the frame will be changed. The size of the source
  texture will not change.

  If Render Texture was not created from specific frame, the following will happen:
  In WebGL it will destroy and then re-create the frame buffer being used by the Render Texture.
  In Canvas it will resize the underlying canvas element.
  Both approaches will erase everything currently drawn to the Render Texture.

  If the dimensions given are the same as those already being used, calling this method will do nothing.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * width (number) - The new width of the Render Texture.
    * height (number) {optional} - The new height of the Render Texture. If not specified, will be set the same as the `width`.

  Returns:  this - This Render Texture."
  ([render-texture width]
   (phaser->clj
    (.resize render-texture
             (clj->phaser width))))
  ([render-texture width height]
   (phaser->clj
    (.resize render-texture
             (clj->phaser width)
             (clj->phaser height)))))

(defn save-texture
  "Stores a copy of this Render Texture in the Texture Manager using the given key.

  After doing this, any texture based Game Object, such as a Sprite, can use the contents of this
  Render Texture by using the texture key:

  ```javascript
  var rt = this.add.renderTexture(0, 0, 128, 128);

  // Draw something to the Render Texture

  rt.saveTexture('doodle');

  this.add.image(400, 300, 'doodle');
  ```

  Updating the contents of this Render Texture will automatically update _any_ Game Object
  that is using it as a texture. Calling `saveTexture` again will not save another copy
  of the same texture, it will just rename the key of the existing copy.

  By default it will create a single base texture. You can add frames to the texture
  by using the `Texture.add` method. After doing this, you can then allow Game Objects
  to use a specific frame from a Render Texture.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * key (string) - The unique key to store the texture as within the global Texture Manager.

  Returns:  Phaser.Textures.Texture - The Texture that was saved."
  ([render-texture key]
   (phaser->clj
    (.saveTexture render-texture
                  (clj->phaser key)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([render-texture value]
   (phaser->clj
    (.setActive render-texture
                (clj->phaser value)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setAlpha render-texture)))
  ([render-texture top-left]
   (phaser->clj
    (.setAlpha render-texture
               (clj->phaser top-left))))
  ([render-texture top-left top-right]
   (phaser->clj
    (.setAlpha render-texture
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([render-texture top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha render-texture
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([render-texture top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha render-texture
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setAngle render-texture)))
  ([render-texture degrees]
   (phaser->clj
    (.setAngle render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([render-texture value]
   (phaser->clj
    (.setBlendMode render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([render-texture key]
   (phaser->clj
    (.setData render-texture
              (clj->phaser key))))
  ([render-texture key data]
   (phaser->clj
    (.setData render-texture
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([render-texture]
   (phaser->clj
    (.setDataEnabled render-texture))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture value]
   (phaser->clj
    (.setDepth render-texture
               (clj->phaser value)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setDisplayOrigin render-texture)))
  ([render-texture x]
   (phaser->clj
    (.setDisplayOrigin render-texture
                       (clj->phaser x))))
  ([render-texture x y]
   (phaser->clj
    (.setDisplayOrigin render-texture
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture width height]
   (phaser->clj
    (.setDisplaySize render-texture
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-flip
  "Sets the horizontal and vertical flipped state of this Game Object.

  A Game Object that is flipped will render inversed on the flipped axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.
    * y (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([render-texture x y]
   (phaser->clj
    (.setFlip render-texture
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-flip-x
  "Sets the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([render-texture value]
   (phaser->clj
    (.setFlipX render-texture
               (clj->phaser value)))))

(defn set-flip-y
  "Sets the vertical flipped state of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([render-texture value]
   (phaser->clj
    (.setFlipY render-texture
               (clj->phaser value)))))

(defn set-global-alpha
  "Set the alpha to use when rendering this Render Texture.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * alpha (number) - The alpha value.

  Returns:  this - This Render Texture."
  ([render-texture alpha]
   (phaser->clj
    (.setGlobalAlpha render-texture
                     (clj->phaser alpha)))))

(defn set-global-tint
  "Set the tint to use when rendering this Render Texture.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * tint (integer) - The tint value.

  Returns:  this - This Render Texture."
  ([render-texture tint]
   (phaser->clj
    (.setGlobalTint render-texture
                    (clj->phaser tint)))))

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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([render-texture]
   (phaser->clj
    (.setInteractive render-texture)))
  ([render-texture shape]
   (phaser->clj
    (.setInteractive render-texture
                     (clj->phaser shape))))
  ([render-texture shape callback]
   (phaser->clj
    (.setInteractive render-texture
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([render-texture shape callback drop-zone]
   (phaser->clj
    (.setInteractive render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([render-texture mask]
   (phaser->clj
    (.setMask render-texture
              (clj->phaser mask)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([render-texture value]
   (phaser->clj
    (.setName render-texture
              (clj->phaser value)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setOrigin render-texture)))
  ([render-texture x]
   (phaser->clj
    (.setOrigin render-texture
                (clj->phaser x))))
  ([render-texture x y]
   (phaser->clj
    (.setOrigin render-texture
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setOriginFromFrame render-texture))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture pipeline-name]
   (phaser->clj
    (.setPipeline render-texture
                  (clj->phaser pipeline-name)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setPosition render-texture)))
  ([render-texture x]
   (phaser->clj
    (.setPosition render-texture
                  (clj->phaser x))))
  ([render-texture x y]
   (phaser->clj
    (.setPosition render-texture
                  (clj->phaser x)
                  (clj->phaser y))))
  ([render-texture x y z]
   (phaser->clj
    (.setPosition render-texture
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([render-texture x y z w]
   (phaser->clj
    (.setPosition render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setRandomPosition render-texture)))
  ([render-texture x]
   (phaser->clj
    (.setRandomPosition render-texture
                        (clj->phaser x))))
  ([render-texture x y]
   (phaser->clj
    (.setRandomPosition render-texture
                        (clj->phaser x)
                        (clj->phaser y))))
  ([render-texture x y width]
   (phaser->clj
    (.setRandomPosition render-texture
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([render-texture x y width height]
   (phaser->clj
    (.setRandomPosition render-texture
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setRotation render-texture)))
  ([render-texture radians]
   (phaser->clj
    (.setRotation render-texture
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([render-texture x]
   (phaser->clj
    (.setScale render-texture
               (clj->phaser x))))
  ([render-texture x y]
   (phaser->clj
    (.setScale render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([render-texture x]
   (phaser->clj
    (.setScrollFactor render-texture
                      (clj->phaser x))))
  ([render-texture x y]
   (phaser->clj
    (.setScrollFactor render-texture
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-size
  "Sets the size of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture width height]
   (phaser->clj
    (.setSize render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([render-texture value]
   (phaser->clj
    (.setState render-texture
               (clj->phaser value)))))

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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If no other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setTint render-texture)))
  ([render-texture top-left]
   (phaser->clj
    (.setTint render-texture
              (clj->phaser top-left))))
  ([render-texture top-left top-right]
   (phaser->clj
    (.setTint render-texture
              (clj->phaser top-left)
              (clj->phaser top-right))))
  ([render-texture top-left top-right bottom-left]
   (phaser->clj
    (.setTint render-texture
              (clj->phaser top-left)
              (clj->phaser top-right)
              (clj->phaser bottom-left))))
  ([render-texture top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTint render-texture
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
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If not other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setTintFill render-texture)))
  ([render-texture top-left]
   (phaser->clj
    (.setTintFill render-texture
                  (clj->phaser top-left))))
  ([render-texture top-left top-right]
   (phaser->clj
    (.setTintFill render-texture
                  (clj->phaser top-left)
                  (clj->phaser top-right))))
  ([render-texture top-left top-right bottom-left]
   (phaser->clj
    (.setTintFill render-texture
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left))))
  ([render-texture top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTintFill render-texture
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left)
                  (clj->phaser bottom-right)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture value]
   (phaser->clj
    (.setVisible render-texture
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setW render-texture)))
  ([render-texture value]
   (phaser->clj
    (.setW render-texture
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setX render-texture)))
  ([render-texture value]
   (phaser->clj
    (.setX render-texture
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setY render-texture)))
  ([render-texture value]
   (phaser->clj
    (.setY render-texture
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.setZ render-texture)))
  ([render-texture value]
   (phaser->clj
    (.setZ render-texture
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([render-texture]
   (phaser->clj
    (.shutdown render-texture))))

(defn snapshot
  "Takes a snapshot of the whole of this Render Texture.

  The snapshot is taken immediately.

  To capture just a portion of the Render Texture see the `snapshotArea` method. To capture a specific pixel, see `snapshotPixel`.

  Snapshots work by using the WebGL `readPixels` feature to grab every pixel from the frame buffer into an ArrayBufferView.
  It then parses this, copying the contents to a temporary Canvas and finally creating an Image object from it,
  which is the image returned to the callback provided. All in all, this is a computationally expensive and blocking process,
  which gets more expensive the larger the canvas size gets, so please be careful how you employ this in your game.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot image is created.
    * type (string) {optional} - The format of the image to create, usually `image/png` or `image/jpeg`.
    * encoder-options (number) {optional} - The image quality, between 0 and 1. Used for image formats with lossy compression, such as `image/jpeg`.

  Returns:  this - This Render Texture instance."
  ([render-texture callback]
   (phaser->clj
    (.snapshot render-texture
               (clj->phaser callback))))
  ([render-texture callback type]
   (phaser->clj
    (.snapshot render-texture
               (clj->phaser callback)
               (clj->phaser type))))
  ([render-texture callback type encoder-options]
   (phaser->clj
    (.snapshot render-texture
               (clj->phaser callback)
               (clj->phaser type)
               (clj->phaser encoder-options)))))

(defn snapshot-area
  "Takes a snapshot of the given area of this Render Texture.

  The snapshot is taken immediately.

  To capture the whole Render Texture see the `snapshot` method. To capture a specific pixel, see `snapshotPixel`.

  Snapshots work by using the WebGL `readPixels` feature to grab every pixel from the frame buffer into an ArrayBufferView.
  It then parses this, copying the contents to a temporary Canvas and finally creating an Image object from it,
  which is the image returned to the callback provided. All in all, this is a computationally expensive and blocking process,
  which gets more expensive the larger the canvas size gets, so please be careful how you employ this in your game.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (integer) - The x coordinate to grab from.
    * y (integer) - The y coordinate to grab from.
    * width (integer) - The width of the area to grab.
    * height (integer) - The height of the area to grab.
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot image is created.
    * type (string) {optional} - The format of the image to create, usually `image/png` or `image/jpeg`.
    * encoder-options (number) {optional} - The image quality, between 0 and 1. Used for image formats with lossy compression, such as `image/jpeg`.

  Returns:  this - This Render Texture instance."
  ([render-texture x y width height callback]
   (phaser->clj
    (.snapshotArea render-texture
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback))))
  ([render-texture x y width height callback type]
   (phaser->clj
    (.snapshotArea render-texture
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback)
                   (clj->phaser type))))
  ([render-texture x y width height callback type encoder-options]
   (phaser->clj
    (.snapshotArea render-texture
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback)
                   (clj->phaser type)
                   (clj->phaser encoder-options)))))

(defn snapshot-pixel
  "Takes a snapshot of the given pixel from this Render Texture.

  The snapshot is taken immediately.

  To capture the whole Render Texture see the `snapshot` method. To capture a specific portion, see `snapshotArea`.

  Unlike the other two snapshot methods, this one will send your callback a `Color` object containing the color data for
  the requested pixel. It doesn't need to create an internal Canvas or Image object, so is a lot faster to execute,
  using less memory, than the other snapshot methods.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * x (integer) - The x coordinate of the pixel to get.
    * y (integer) - The y coordinate of the pixel to get.
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot pixel data is extracted.

  Returns:  this - This Render Texture instance."
  ([render-texture x y callback]
   (phaser->clj
    (.snapshotPixel render-texture
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser callback)))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([render-texture]
   (phaser->clj
    (.toJSON render-texture))))

(defn toggle-flip-x
  "Toggles the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.toggleFlipX render-texture))))

(defn toggle-flip-y
  "Toggles the vertical flipped state of this Game Object.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.toggleFlipY render-texture))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * args (*) {optional} - args"
  ([render-texture]
   (phaser->clj
    (.update render-texture)))
  ([render-texture args]
   (phaser->clj
    (.update render-texture
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([render-texture]
   (phaser->clj
    (.updateDisplayOrigin render-texture))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * render-texture (Phaser.GameObjects.RenderTexture) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([render-texture camera]
   (phaser->clj
    (.willRender render-texture
                 (clj->phaser camera)))))