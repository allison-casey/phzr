(ns phzr.game-objects.graphics
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Graphics
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Graphics object belongs.
    * options (Phaser.Types.GameObjects.Graphics.Options) {optional} - Options that set the position and default style of this Graphics object."
  ([scene]
   (js/Phaser.GameObjects.Graphics. (clj->phaser scene)))
  ([scene options]
   (js/Phaser.GameObjects.Graphics. (clj->phaser scene)
                                    (clj->phaser options))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([graphics event fn]
   (phaser->clj
    (.addListener graphics
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([graphics event fn context]
   (phaser->clj
    (.addListener graphics
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn arc
  "Draw an arc.

  This method can be used to create circles, or parts of circles.

  Make sure you call `beginPath` before starting the arc unless you wish for the arc to automatically
  close when filled or stroked.

  Use the optional `overshoot` argument increase the number of iterations that take place when
  the arc is rendered in WebGL. This is useful if you're drawing an arc with an especially thick line,
  as it will allow the arc to fully join-up. Try small values at first, i.e. 0.01.

  Call {@link Phaser.GameObjects.Graphics#fillPath} or {@link Phaser.GameObjects.Graphics#strokePath} after calling
  this method to draw the arc.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the center of the circle.
    * y (number) - The y coordinate of the center of the circle.
    * radius (number) - The radius of the circle.
    * start-angle (number) - The starting angle, in radians.
    * end-angle (number) - The ending angle, in radians.
    * anticlockwise (boolean) {optional} - Whether the drawing should be anticlockwise or clockwise.
    * overshoot (number) {optional} - This value allows you to increase the segment iterations in WebGL rendering. Useful if the arc has a thick stroke and needs to overshoot to join-up cleanly. Use small numbers such as 0.01 to start with and increase as needed.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y radius start-angle end-angle]
   (phaser->clj
    (.arc graphics
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser start-angle)
          (clj->phaser end-angle))))
  ([graphics x y radius start-angle end-angle anticlockwise]
   (phaser->clj
    (.arc graphics
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser start-angle)
          (clj->phaser end-angle)
          (clj->phaser anticlockwise))))
  ([graphics x y radius start-angle end-angle anticlockwise overshoot]
   (phaser->clj
    (.arc graphics
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser start-angle)
          (clj->phaser end-angle)
          (clj->phaser anticlockwise)
          (clj->phaser overshoot)))))

(defn begin-path
  "Start a new shape path.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.beginPath graphics))))

(defn clear
  "Clear the command buffer and reset the fill style and line style to their defaults.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.clear graphics))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.clearAlpha graphics))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.clearMask graphics)))
  ([graphics destroy-mask]
   (phaser->clj
    (.clearMask graphics
                (clj->phaser destroy-mask)))))

(defn close-path
  "Close the current path.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.closePath graphics))))

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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([graphics]
   (phaser->clj
    (.createBitmapMask graphics)))
  ([graphics renderable]
   (phaser->clj
    (.createBitmapMask graphics
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([graphics]
   (phaser->clj
    (.createGeometryMask graphics)))
  ([graphics graphics]
   (phaser->clj
    (.createGeometryMask graphics
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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([graphics]
   (phaser->clj
    (.destroy graphics)))
  ([graphics from-scene]
   (phaser->clj
    (.destroy graphics
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([graphics]
   (phaser->clj
    (.disableInteractive graphics))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([graphics event]
   (phaser->clj
    (.emit graphics
           (clj->phaser event))))
  ([graphics event args]
   (phaser->clj
    (.emit graphics
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([graphics]
   (phaser->clj
    (.eventNames graphics))))

(defn fill
  "Fill the current path.

  This is an alias for `Graphics.fillPath` and does the same thing.
  It was added to match the CanvasRenderingContext 2D API.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.fill graphics))))

(defn fill-circle
  "Fill a circle with the given position and radius.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the center of the circle.
    * y (number) - The y coordinate of the center of the circle.
    * radius (number) - The radius of the circle.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y radius]
   (phaser->clj
    (.fillCircle graphics
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser radius)))))

(defn fill-circle-shape
  "Fill the given circle.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The circle to fill.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics circle]
   (phaser->clj
    (.fillCircleShape graphics
                      (clj->phaser circle)))))

(defn fill-ellipse
  "Fill an ellipse with the given position and size.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the center of the ellipse.
    * y (number) - The y coordinate of the center of the ellipse.
    * width (number) - The width of the ellipse.
    * height (number) - The height of the ellipse.
    * smoothness (integer) {optional} - The number of points to draw the ellipse with.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y width height]
   (phaser->clj
    (.fillEllipse graphics
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([graphics x y width height smoothness]
   (phaser->clj
    (.fillEllipse graphics
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser smoothness)))))

(defn fill-ellipse-shape
  "Fill the given ellipse.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The ellipse to fill.
    * smoothness (integer) {optional} - The number of points to draw the ellipse with.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics ellipse]
   (phaser->clj
    (.fillEllipseShape graphics
                       (clj->phaser ellipse))))
  ([graphics ellipse smoothness]
   (phaser->clj
    (.fillEllipseShape graphics
                       (clj->phaser ellipse)
                       (clj->phaser smoothness)))))

(defn fill-gradient-style
  "Sets a gradient fill style. This is a WebGL only feature.

  The gradient color values represent the 4 corners of an untransformed rectangle.
  The gradient is used to color all filled shapes and paths drawn after calling this method.
  If you wish to turn a gradient off, call `fillStyle` and provide a new single fill color.

  When filling a triangle only the first 3 color values provided are used for the 3 points of a triangle.

  This feature is best used only on rectangles and triangles. All other shapes will give strange results.

  Note that for objects such as arcs or ellipses, or anything which is made out of triangles, each triangle used
  will be filled with a gradient on its own. There is no ability to gradient fill a shape or path as a single
  entity at this time.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * top-left (integer) - The tint being applied to the top-left of the Game Object.
    * top-right (integer) - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) - The tint being applied to the bottom-right of the Game Object.
    * alpha (number) {optional} - The fill alpha.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.fillGradientStyle graphics
                        (clj->phaser top-left)
                        (clj->phaser top-right)
                        (clj->phaser bottom-left)
                        (clj->phaser bottom-right))))
  ([graphics top-left top-right bottom-left bottom-right alpha]
   (phaser->clj
    (.fillGradientStyle graphics
                        (clj->phaser top-left)
                        (clj->phaser top-right)
                        (clj->phaser bottom-left)
                        (clj->phaser bottom-right)
                        (clj->phaser alpha)))))

(defn fill-path
  "Fill the current path.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.fillPath graphics))))

(defn fill-point
  "Fill a point at the given position.

  Draws a square at the given position, 1 pixel in size by default.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the point.
    * y (number) - The y coordinate of the point.
    * size (number) {optional} - The size of the square to draw.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y]
   (phaser->clj
    (.fillPoint graphics
                (clj->phaser x)
                (clj->phaser y))))
  ([graphics x y size]
   (phaser->clj
    (.fillPoint graphics
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser size)))))

(defn fill-point-shape
  "Fill the given point.

  Draws a square at the given position, 1 pixel in size by default.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * point (Phaser.Geom.Point | Phaser.Math.Vector2 | object) - The point to fill.
    * size (number) {optional} - The size of the square to draw.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics point]
   (phaser->clj
    (.fillPointShape graphics
                     (clj->phaser point))))
  ([graphics point size]
   (phaser->clj
    (.fillPointShape graphics
                     (clj->phaser point)
                     (clj->phaser size)))))

(defn fill-points
  "Fill the shape represented by the given array of points.

  Pass `closeShape` to automatically close the shape by joining the last to the first point.

  Pass `closePath` to automatically close the path before it is filled.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * points (array | Array.<Phaser.Geom.Point>) - The points to fill.
    * close-shape (boolean) {optional} - When `true`, the shape is closed by joining the last point to the first point.
    * close-path (boolean) {optional} - When `true`, the path is closed before being stroked.
    * end-index (integer) {optional} - The index of `points` to stop at. Defaults to `points.length`.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics points]
   (phaser->clj
    (.fillPoints graphics
                 (clj->phaser points))))
  ([graphics points close-shape]
   (phaser->clj
    (.fillPoints graphics
                 (clj->phaser points)
                 (clj->phaser close-shape))))
  ([graphics points close-shape close-path]
   (phaser->clj
    (.fillPoints graphics
                 (clj->phaser points)
                 (clj->phaser close-shape)
                 (clj->phaser close-path))))
  ([graphics points close-shape close-path end-index]
   (phaser->clj
    (.fillPoints graphics
                 (clj->phaser points)
                 (clj->phaser close-shape)
                 (clj->phaser close-path)
                 (clj->phaser end-index)))))

(defn fill-rect
  "Fill a rectangle with the given position and size.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the top-left of the rectangle.
    * y (number) - The y coordinate of the top-left of the rectangle.
    * width (number) - The width of the rectangle.
    * height (number) - The height of the rectangle.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y width height]
   (phaser->clj
    (.fillRect graphics
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser width)
               (clj->phaser height)))))

(defn fill-rect-shape
  "Fill the given rectangle.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The rectangle to fill.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics rect]
   (phaser->clj
    (.fillRectShape graphics
                    (clj->phaser rect)))))

(defn fill-rounded-rect
  "Fill a rounded rectangle with the given position, size and radius.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the top-left of the rectangle.
    * y (number) - The y coordinate of the top-left of the rectangle.
    * width (number) - The width of the rectangle.
    * height (number) - The height of the rectangle.
    * radius (Phaser.Types.GameObjects.Graphics.RoundedRectRadius | number) {optional} - The corner radius; It can also be an object to specify different radii for corners.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y width height]
   (phaser->clj
    (.fillRoundedRect graphics
                      (clj->phaser x)
                      (clj->phaser y)
                      (clj->phaser width)
                      (clj->phaser height))))
  ([graphics x y width height radius]
   (phaser->clj
    (.fillRoundedRect graphics
                      (clj->phaser x)
                      (clj->phaser y)
                      (clj->phaser width)
                      (clj->phaser height)
                      (clj->phaser radius)))))

(defn fill-style
  "Set the current fill style.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * color (number) - The fill color.
    * alpha (number) {optional} - The fill alpha.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics color]
   (phaser->clj
    (.fillStyle graphics
                (clj->phaser color))))
  ([graphics color alpha]
   (phaser->clj
    (.fillStyle graphics
                (clj->phaser color)
                (clj->phaser alpha)))))

(defn fill-triangle
  "Fill a triangle with the given points.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x-0 (number) - The x coordinate of the first point.
    * y-0 (number) - The y coordinate of the first point.
    * x-1 (number) - The x coordinate of the second point.
    * y-1 (number) - The y coordinate of the second point.
    * x-2 (number) - The x coordinate of the third point.
    * y-2 (number) - The y coordinate of the third point.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x-0 y-0 x-1 y-1 x-2 y-2]
   (phaser->clj
    (.fillTriangle graphics
                   (clj->phaser x-0)
                   (clj->phaser y-0)
                   (clj->phaser x-1)
                   (clj->phaser y-1)
                   (clj->phaser x-2)
                   (clj->phaser y-2)))))

(defn fill-triangle-shape
  "Fill the given triangle.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The triangle to fill.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics triangle]
   (phaser->clj
    (.fillTriangleShape graphics
                        (clj->phaser triangle)))))

(defn generate-texture
  "Generate a texture from this Graphics object.

  If `key` is a string it'll generate a new texture using it and add it into the
  Texture Manager (assuming no key conflict happens).

  If `key` is a Canvas it will draw the texture to that canvas context. Note that it will NOT
  automatically upload it to the GPU in WebGL mode.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * key (string | HTMLCanvasElement) - The key to store the texture with in the Texture Manager, or a Canvas to draw to.
    * width (integer) {optional} - The width of the graphics to generate.
    * height (integer) {optional} - The height of the graphics to generate.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics key]
   (phaser->clj
    (.generateTexture graphics
                      (clj->phaser key))))
  ([graphics key width]
   (phaser->clj
    (.generateTexture graphics
                      (clj->phaser key)
                      (clj->phaser width))))
  ([graphics key width height]
   (phaser->clj
    (.generateTexture graphics
                      (clj->phaser key)
                      (clj->phaser width)
                      (clj->phaser height)))))

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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([graphics key]
   (phaser->clj
    (.getData graphics
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([graphics]
   (phaser->clj
    (.getIndexList graphics))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([graphics]
   (phaser->clj
    (.getLocalTransformMatrix graphics)))
  ([graphics temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix graphics
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([graphics]
   (phaser->clj
    (.getParentRotation graphics))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([graphics]
   (phaser->clj
    (.getPipelineName graphics))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([graphics]
   (phaser->clj
    (.getWorldTransformMatrix graphics)))
  ([graphics temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix graphics
                              (clj->phaser temp-matrix))))
  ([graphics temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix graphics
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([graphics]
   (phaser->clj
    (.initPipeline graphics)))
  ([graphics pipeline-name]
   (phaser->clj
    (.initPipeline graphics
                   (clj->phaser pipeline-name)))))

(defn line-between
  "Draw a line between the given points.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x-1 (number) - The x coordinate of the start point of the line.
    * y-1 (number) - The y coordinate of the start point of the line.
    * x-2 (number) - The x coordinate of the end point of the line.
    * y-2 (number) - The y coordinate of the end point of the line.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x-1 y-1 x-2 y-2]
   (phaser->clj
    (.lineBetween graphics
                  (clj->phaser x-1)
                  (clj->phaser y-1)
                  (clj->phaser x-2)
                  (clj->phaser y-2)))))

(defn line-gradient-style
  "Sets a gradient line style. This is a WebGL only feature.

  The gradient color values represent the 4 corners of an untransformed rectangle.
  The gradient is used to color all stroked shapes and paths drawn after calling this method.
  If you wish to turn a gradient off, call `lineStyle` and provide a new single line color.

  This feature is best used only on single lines. All other shapes will give strange results.

  Note that for objects such as arcs or ellipses, or anything which is made out of triangles, each triangle used
  will be filled with a gradient on its own. There is no ability to gradient stroke a shape or path as a single
  entity at this time.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * line-width (number) - The stroke width.
    * top-left (integer) - The tint being applied to the top-left of the Game Object.
    * top-right (integer) - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) - The tint being applied to the bottom-right of the Game Object.
    * alpha (number) {optional} - The fill alpha.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics line-width top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.lineGradientStyle graphics
                        (clj->phaser line-width)
                        (clj->phaser top-left)
                        (clj->phaser top-right)
                        (clj->phaser bottom-left)
                        (clj->phaser bottom-right))))
  ([graphics line-width top-left top-right bottom-left bottom-right alpha]
   (phaser->clj
    (.lineGradientStyle graphics
                        (clj->phaser line-width)
                        (clj->phaser top-left)
                        (clj->phaser top-right)
                        (clj->phaser bottom-left)
                        (clj->phaser bottom-right)
                        (clj->phaser alpha)))))

(defn line-style
  "Set the current line style.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * line-width (number) - The stroke width.
    * color (number) - The stroke color.
    * alpha (number) {optional} - The stroke alpha.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics line-width color]
   (phaser->clj
    (.lineStyle graphics
                (clj->phaser line-width)
                (clj->phaser color))))
  ([graphics line-width color alpha]
   (phaser->clj
    (.lineStyle graphics
                (clj->phaser line-width)
                (clj->phaser color)
                (clj->phaser alpha)))))

(defn line-to
  "Draw a line from the current drawing position to the given position.

  Moves the current drawing position to the given position.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate to draw the line to.
    * y (number) - The y coordinate to draw the line to.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y]
   (phaser->clj
    (.lineTo graphics
             (clj->phaser x)
             (clj->phaser y)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([graphics event]
   (phaser->clj
    (.listenerCount graphics
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([graphics event]
   (phaser->clj
    (.listeners graphics
                (clj->phaser event)))))

(defn move-to
  "Move the current drawing position to the given position.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate to move to.
    * y (number) - The y coordinate to move to.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y]
   (phaser->clj
    (.moveTo graphics
             (clj->phaser x)
             (clj->phaser y)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([graphics event]
   (phaser->clj
    (.off graphics
          (clj->phaser event))))
  ([graphics event fn]
   (phaser->clj
    (.off graphics
          (clj->phaser event)
          (clj->phaser fn))))
  ([graphics event fn context]
   (phaser->clj
    (.off graphics
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([graphics event fn context once]
   (phaser->clj
    (.off graphics
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([graphics event fn]
   (phaser->clj
    (.on graphics
         (clj->phaser event)
         (clj->phaser fn))))
  ([graphics event fn context]
   (phaser->clj
    (.on graphics
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([graphics event fn]
   (phaser->clj
    (.once graphics
           (clj->phaser event)
           (clj->phaser fn))))
  ([graphics event fn context]
   (phaser->clj
    (.once graphics
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([graphics]
   (phaser->clj
    (.removeAllListeners graphics)))
  ([graphics event]
   (phaser->clj
    (.removeAllListeners graphics
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
  ([graphics]
   (phaser->clj
    (.removeInteractive graphics))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([graphics event]
   (phaser->clj
    (.removeListener graphics
                     (clj->phaser event))))
  ([graphics event fn]
   (phaser->clj
    (.removeListener graphics
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([graphics event fn context]
   (phaser->clj
    (.removeListener graphics
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([graphics event fn context once]
   (phaser->clj
    (.removeListener graphics
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([graphics]
   (phaser->clj
    (.resetPipeline graphics))))

(defn restore
  "Restores the most recently saved state of the Graphics by popping from the state stack.

  Use {@link Phaser.GameObjects.Graphics#save} to save the current state, and call this afterwards to restore that state.

  If there is no saved state, this command does nothing.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.restore graphics))))

(defn rotate-canvas
  "Inserts a rotation command into this Graphics objects command buffer.

  All objects drawn _after_ calling this method will be rotated
  by the given amount.

  This does not change the rotation of the Graphics object itself,
  only of the objects drawn by it after calling this method.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * radians (number) - The rotation angle, in radians.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics radians]
   (phaser->clj
    (.rotateCanvas graphics
                   (clj->phaser radians)))))

(defn save
  "Saves the state of the Graphics by pushing the current state onto a stack.

  The most recently saved state can then be restored with {@link Phaser.GameObjects.Graphics#restore}.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.save graphics))))

(defn scale-canvas
  "Inserts a scale command into this Graphics objects command buffer.

  All objects drawn _after_ calling this method will be scaled
  by the given amount.

  This does not change the scale of the Graphics object itself,
  only of the objects drawn by it after calling this method.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The horizontal scale to apply.
    * y (number) - The vertical scale to apply.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y]
   (phaser->clj
    (.scaleCanvas graphics
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([graphics value]
   (phaser->clj
    (.setActive graphics
                (clj->phaser value)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setAlpha graphics)))
  ([graphics top-left]
   (phaser->clj
    (.setAlpha graphics
               (clj->phaser top-left))))
  ([graphics top-left top-right]
   (phaser->clj
    (.setAlpha graphics
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([graphics top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha graphics
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([graphics top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha graphics
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setAngle graphics)))
  ([graphics degrees]
   (phaser->clj
    (.setAngle graphics
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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([graphics value]
   (phaser->clj
    (.setBlendMode graphics
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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([graphics key]
   (phaser->clj
    (.setData graphics
              (clj->phaser key))))
  ([graphics key data]
   (phaser->clj
    (.setData graphics
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([graphics]
   (phaser->clj
    (.setDataEnabled graphics))))

(defn set-default-styles
  "Set the default style settings for this Graphics object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * options (Phaser.Types.GameObjects.Graphics.Styles) - The styles to set as defaults.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics options]
   (phaser->clj
    (.setDefaultStyles graphics
                       (clj->phaser options)))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([graphics value]
   (phaser->clj
    (.setDepth graphics
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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([graphics]
   (phaser->clj
    (.setInteractive graphics)))
  ([graphics shape]
   (phaser->clj
    (.setInteractive graphics
                     (clj->phaser shape))))
  ([graphics shape callback]
   (phaser->clj
    (.setInteractive graphics
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([graphics shape callback drop-zone]
   (phaser->clj
    (.setInteractive graphics
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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([graphics mask]
   (phaser->clj
    (.setMask graphics
              (clj->phaser mask)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([graphics value]
   (phaser->clj
    (.setName graphics
              (clj->phaser value)))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([graphics pipeline-name]
   (phaser->clj
    (.setPipeline graphics
                  (clj->phaser pipeline-name)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setPosition graphics)))
  ([graphics x]
   (phaser->clj
    (.setPosition graphics
                  (clj->phaser x))))
  ([graphics x y]
   (phaser->clj
    (.setPosition graphics
                  (clj->phaser x)
                  (clj->phaser y))))
  ([graphics x y z]
   (phaser->clj
    (.setPosition graphics
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([graphics x y z w]
   (phaser->clj
    (.setPosition graphics
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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setRandomPosition graphics)))
  ([graphics x]
   (phaser->clj
    (.setRandomPosition graphics
                        (clj->phaser x))))
  ([graphics x y]
   (phaser->clj
    (.setRandomPosition graphics
                        (clj->phaser x)
                        (clj->phaser y))))
  ([graphics x y width]
   (phaser->clj
    (.setRandomPosition graphics
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([graphics x y width height]
   (phaser->clj
    (.setRandomPosition graphics
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setRotation graphics)))
  ([graphics radians]
   (phaser->clj
    (.setRotation graphics
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([graphics x]
   (phaser->clj
    (.setScale graphics
               (clj->phaser x))))
  ([graphics x y]
   (phaser->clj
    (.setScale graphics
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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([graphics x]
   (phaser->clj
    (.setScrollFactor graphics
                      (clj->phaser x))))
  ([graphics x y]
   (phaser->clj
    (.setScrollFactor graphics
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
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([graphics value]
   (phaser->clj
    (.setState graphics
               (clj->phaser value)))))

(defn set-texture
  "Sets the texture frame this Graphics Object will use when drawing all shapes defined after calling this.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  Once set, all shapes will use this texture. Call this method with no arguments to clear it.

  The textures are not tiled. They are stretched to the dimensions of the shapes being rendered. For this reason,
  it works best with seamless / tileable textures.

  The mode argument controls how the textures are combined with the fill colors. The default value (0) will
  multiply the texture by the fill color. A value of 1 will use just the fill color, but the alpha data from the texture,
  and a value of 2 will use just the texture and no fill color at all.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * key (string) {optional} - The key of the texture to be used, as stored in the Texture Manager. Leave blank to clear a previously set texture.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.
    * mode (number) {optional} - The texture tint mode. 0 is multiply, 1 is alpha only and 2 is texture only.

  Returns:  this - This Game Object."
  ([graphics]
   (phaser->clj
    (.setTexture graphics)))
  ([graphics key]
   (phaser->clj
    (.setTexture graphics
                 (clj->phaser key))))
  ([graphics key frame]
   (phaser->clj
    (.setTexture graphics
                 (clj->phaser key)
                 (clj->phaser frame))))
  ([graphics key frame mode]
   (phaser->clj
    (.setTexture graphics
                 (clj->phaser key)
                 (clj->phaser frame)
                 (clj->phaser mode)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([graphics value]
   (phaser->clj
    (.setVisible graphics
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setW graphics)))
  ([graphics value]
   (phaser->clj
    (.setW graphics
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setX graphics)))
  ([graphics value]
   (phaser->clj
    (.setX graphics
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setY graphics)))
  ([graphics value]
   (phaser->clj
    (.setY graphics
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([graphics]
   (phaser->clj
    (.setZ graphics)))
  ([graphics value]
   (phaser->clj
    (.setZ graphics
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([graphics]
   (phaser->clj
    (.shutdown graphics))))

(defn slice
  "Creates a pie-chart slice shape centered at `x`, `y` with the given radius.
  You must define the start and end angle of the slice.

  Setting the `anticlockwise` argument to `true` creates a shape similar to Pacman.
  Setting it to `false` creates a shape like a slice of pie.

  This method will begin a new path and close the path at the end of it.
  To display the actual slice you need to call either `strokePath` or `fillPath` after it.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The horizontal center of the slice.
    * y (number) - The vertical center of the slice.
    * radius (number) - The radius of the slice.
    * start-angle (number) - The start angle of the slice, given in radians.
    * end-angle (number) - The end angle of the slice, given in radians.
    * anticlockwise (boolean) {optional} - Whether the drawing should be anticlockwise or clockwise.
    * overshoot (number) {optional} - This value allows you to overshoot the endAngle by this amount. Useful if the arc has a thick stroke and needs to overshoot to join-up cleanly.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y radius start-angle end-angle]
   (phaser->clj
    (.slice graphics
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser radius)
            (clj->phaser start-angle)
            (clj->phaser end-angle))))
  ([graphics x y radius start-angle end-angle anticlockwise]
   (phaser->clj
    (.slice graphics
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser radius)
            (clj->phaser start-angle)
            (clj->phaser end-angle)
            (clj->phaser anticlockwise))))
  ([graphics x y radius start-angle end-angle anticlockwise overshoot]
   (phaser->clj
    (.slice graphics
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser radius)
            (clj->phaser start-angle)
            (clj->phaser end-angle)
            (clj->phaser anticlockwise)
            (clj->phaser overshoot)))))

(defn stroke
  "Stroke the current path.

  This is an alias for `Graphics.strokePath` and does the same thing.
  It was added to match the CanvasRenderingContext 2D API.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.stroke graphics))))

(defn stroke-circle
  "Stroke a circle with the given position and radius.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the center of the circle.
    * y (number) - The y coordinate of the center of the circle.
    * radius (number) - The radius of the circle.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y radius]
   (phaser->clj
    (.strokeCircle graphics
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser radius)))))

(defn stroke-circle-shape
  "Stroke the given circle.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The circle to stroke.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics circle]
   (phaser->clj
    (.strokeCircleShape graphics
                        (clj->phaser circle)))))

(defn stroke-ellipse
  "Stroke an ellipse with the given position and size.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the center of the ellipse.
    * y (number) - The y coordinate of the center of the ellipse.
    * width (number) - The width of the ellipse.
    * height (number) - The height of the ellipse.
    * smoothness (integer) {optional} - The number of points to draw the ellipse with.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y width height]
   (phaser->clj
    (.strokeEllipse graphics
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser width)
                    (clj->phaser height))))
  ([graphics x y width height smoothness]
   (phaser->clj
    (.strokeEllipse graphics
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser width)
                    (clj->phaser height)
                    (clj->phaser smoothness)))))

(defn stroke-ellipse-shape
  "Stroke the given ellipse.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The ellipse to stroke.
    * smoothness (integer) {optional} - The number of points to draw the ellipse with.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics ellipse]
   (phaser->clj
    (.strokeEllipseShape graphics
                         (clj->phaser ellipse))))
  ([graphics ellipse smoothness]
   (phaser->clj
    (.strokeEllipseShape graphics
                         (clj->phaser ellipse)
                         (clj->phaser smoothness)))))

(defn stroke-line-shape
  "Draw the given line.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to stroke.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics line]
   (phaser->clj
    (.strokeLineShape graphics
                      (clj->phaser line)))))

(defn stroke-path
  "Stroke the current path.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics]
   (phaser->clj
    (.strokePath graphics))))

(defn stroke-points
  "Stroke the shape represented by the given array of points.

  Pass `closeShape` to automatically close the shape by joining the last to the first point.

  Pass `closePath` to automatically close the path before it is stroked.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * points (array | Array.<Phaser.Geom.Point>) - The points to stroke.
    * close-shape (boolean) {optional} - When `true`, the shape is closed by joining the last point to the first point.
    * close-path (boolean) {optional} - When `true`, the path is closed before being stroked.
    * end-index (integer) {optional} - The index of `points` to stop drawing at. Defaults to `points.length`.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics points]
   (phaser->clj
    (.strokePoints graphics
                   (clj->phaser points))))
  ([graphics points close-shape]
   (phaser->clj
    (.strokePoints graphics
                   (clj->phaser points)
                   (clj->phaser close-shape))))
  ([graphics points close-shape close-path]
   (phaser->clj
    (.strokePoints graphics
                   (clj->phaser points)
                   (clj->phaser close-shape)
                   (clj->phaser close-path))))
  ([graphics points close-shape close-path end-index]
   (phaser->clj
    (.strokePoints graphics
                   (clj->phaser points)
                   (clj->phaser close-shape)
                   (clj->phaser close-path)
                   (clj->phaser end-index)))))

(defn stroke-rect
  "Stroke a rectangle with the given position and size.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the top-left of the rectangle.
    * y (number) - The y coordinate of the top-left of the rectangle.
    * width (number) - The width of the rectangle.
    * height (number) - The height of the rectangle.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y width height]
   (phaser->clj
    (.strokeRect graphics
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser width)
                 (clj->phaser height)))))

(defn stroke-rect-shape
  "Stroke the given rectangle.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The rectangle to stroke.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics rect]
   (phaser->clj
    (.strokeRectShape graphics
                      (clj->phaser rect)))))

(defn stroke-rounded-rect
  "Stroke a rounded rectangle with the given position, size and radius.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The x coordinate of the top-left of the rectangle.
    * y (number) - The y coordinate of the top-left of the rectangle.
    * width (number) - The width of the rectangle.
    * height (number) - The height of the rectangle.
    * radius (Phaser.Types.GameObjects.Graphics.RoundedRectRadius | number) {optional} - The corner radius; It can also be an object to specify different radii for corners.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y width height]
   (phaser->clj
    (.strokeRoundedRect graphics
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height))))
  ([graphics x y width height radius]
   (phaser->clj
    (.strokeRoundedRect graphics
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)
                        (clj->phaser radius)))))

(defn stroke-triangle
  "Stroke a triangle with the given points.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x-0 (number) - The x coordinate of the first point.
    * y-0 (number) - The y coordinate of the first point.
    * x-1 (number) - The x coordinate of the second point.
    * y-1 (number) - The y coordinate of the second point.
    * x-2 (number) - The x coordinate of the third point.
    * y-2 (number) - The y coordinate of the third point.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x-0 y-0 x-1 y-1 x-2 y-2]
   (phaser->clj
    (.strokeTriangle graphics
                     (clj->phaser x-0)
                     (clj->phaser y-0)
                     (clj->phaser x-1)
                     (clj->phaser y-1)
                     (clj->phaser x-2)
                     (clj->phaser y-2)))))

(defn stroke-triangle-shape
  "Stroke the given triangle.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The triangle to stroke.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics triangle]
   (phaser->clj
    (.strokeTriangleShape graphics
                          (clj->phaser triangle)))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([graphics]
   (phaser->clj
    (.toJSON graphics))))

(defn translate-canvas
  "Inserts a translation command into this Graphics objects command buffer.

  All objects drawn _after_ calling this method will be translated
  by the given amount.

  This does not change the position of the Graphics object itself,
  only of the objects drawn by it after calling this method.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * x (number) - The horizontal translation to apply.
    * y (number) - The vertical translation to apply.

  Returns:  Phaser.GameObjects.Graphics - This Game Object."
  ([graphics x y]
   (phaser->clj
    (.translateCanvas graphics
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * args (*) {optional} - args"
  ([graphics]
   (phaser->clj
    (.update graphics)))
  ([graphics args]
   (phaser->clj
    (.update graphics
             (clj->phaser args)))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * graphics (Phaser.GameObjects.Graphics) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([graphics camera]
   (phaser->clj
    (.willRender graphics
                 (clj->phaser camera)))))