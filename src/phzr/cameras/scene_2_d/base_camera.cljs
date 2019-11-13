(ns phzr.cameras.scene-2-d.base-camera
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->BaseCamera
  "  Parameters:
    * x (number) - The x position of the Camera, relative to the top-left of the game canvas.
    * y (number) - The y position of the Camera, relative to the top-left of the game canvas.
    * width (number) - The width of the Camera, in pixels.
    * height (number) - The height of the Camera, in pixels."
  ([x y width height]
   (js/Phaser.Cameras.Scene2D.BaseCamera. (clj->phaser x)
                                          (clj->phaser y)
                                          (clj->phaser width)
                                          (clj->phaser height))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-camera event fn]
   (phaser->clj
    (.addListener base-camera
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([base-camera event fn context]
   (phaser->clj
    (.addListener base-camera
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn center-on
  "Moves the Camera so that it is centered on the given coordinates, bounds allowing.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) - The horizontal coordinate to center on.
    * y (number) - The vertical coordinate to center on.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera x y]
   (phaser->clj
    (.centerOn base-camera
               (clj->phaser x)
               (clj->phaser y)))))

(defn center-on-x
  "Moves the Camera horizontally so that it is centered on the given x coordinate, bounds allowing.
  Calling this does not change the scrollY value.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) - The horizontal coordinate to center on.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera x]
   (phaser->clj
    (.centerOnX base-camera
                (clj->phaser x)))))

(defn center-on-y
  "Moves the Camera vertically so that it is centered on the given y coordinate, bounds allowing.
  Calling this does not change the scrollX value.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * y (number) - The vertical coordinate to center on.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera y]
   (phaser->clj
    (.centerOnY base-camera
                (clj->phaser y)))))

(defn center-to-bounds
  "Moves the Camera so that it is looking at the center of the Camera Bounds, if enabled.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.centerToBounds base-camera))))

(defn center-to-size
  "Moves the Camera so that it is re-centered based on its viewport size.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.centerToSize base-camera))))

(defn clamp-x
  "Takes an x value and checks it's within the range of the Camera bounds, adjusting if required.
  Do not call this method if you are not using camera bounds.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) - The value to horizontally scroll clamp.

  Returns:  number - The adjusted value to use as scrollX."
  ([base-camera x]
   (phaser->clj
    (.clampX base-camera
             (clj->phaser x)))))

(defn clamp-y
  "Takes a y value and checks it's within the range of the Camera bounds, adjusting if required.
  Do not call this method if you are not using camera bounds.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * y (number) - The value to vertically scroll clamp.

  Returns:  number - The adjusted value to use as scrollY."
  ([base-camera y]
   (phaser->clj
    (.clampY base-camera
             (clj->phaser y)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([base-camera]
   (phaser->clj
    (.clearAlpha base-camera))))

(defn clear-mask
  "Clears the mask that this Camera was using.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.clearMask base-camera)))
  ([base-camera destroy-mask]
   (phaser->clj
    (.clearMask base-camera
                (clj->phaser destroy-mask)))))

(defn cull
  "Takes an array of Game Objects and returns a new array featuring only those objects
  visible by this camera.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * renderable-objects (Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to cull.

  Returns:  Array.<Phaser.GameObjects.GameObject> - An array of Game Objects visible to this Camera."
  ([base-camera renderable-objects]
   (phaser->clj
    (.cull base-camera
           (clj->phaser renderable-objects)))))

(defn destroy
  "Destroys this Camera instance and its internal properties and references.
  Once destroyed you cannot use this Camera again, even if re-added to a Camera Manager.

  This method is called automatically by `CameraManager.remove` if that methods `runDestroy` argument is `true`, which is the default.

  Unless you have a specific reason otherwise, always use `CameraManager.remove` and allow it to handle the camera destruction,
  rather than calling this method directly."
  ([base-camera]
   (phaser->clj
    (.destroy base-camera))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([base-camera event]
   (phaser->clj
    (.emit base-camera
           (clj->phaser event))))
  ([base-camera event args]
   (phaser->clj
    (.emit base-camera
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([base-camera]
   (phaser->clj
    (.eventNames base-camera))))

(defn get-bounds
  "Returns a rectangle containing the bounds of the Camera.

  If the Camera does not have any bounds the rectangle will be empty.

  The rectangle is a copy of the bounds, so is safe to modify.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - An optional Rectangle to store the bounds in. If not given, a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle - A rectangle containing the bounds of this Camera."
  ([base-camera]
   (phaser->clj
    (.getBounds base-camera)))
  ([base-camera out]
   (phaser->clj
    (.getBounds base-camera
                (clj->phaser out)))))

(defn get-scroll
  "Calculates what the Camera.scrollX and scrollY values would need to be in order to move
  the Camera so it is centered on the given x and y coordinates, without actually moving
  the Camera there. The results are clamped based on the Camera bounds, if set.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) - The horizontal coordinate to center on.
    * y (number) - The vertical coordinate to center on.
    * out (Phaser.Math.Vector2) {optional} - A Vec2 to store the values in. If not given a new Vec2 is created.

  Returns:  Phaser.Math.Vector2 - The scroll coordinates stored in the `x` and `y` properties."
  ([base-camera x y]
   (phaser->clj
    (.getScroll base-camera
                (clj->phaser x)
                (clj->phaser y))))
  ([base-camera x y out]
   (phaser->clj
    (.getScroll base-camera
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser out)))))

(defn get-world-point
  "Converts the given `x` and `y` coordinates into World space, based on this Cameras transform.
  You can optionally provide a Vector2, or similar object, to store the results in.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) - The x position to convert to world space.
    * y (number) - The y position to convert to world space.
    * output (object | Phaser.Math.Vector2) {optional} - An optional object to store the results in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 - An object holding the converted values in its `x` and `y` properties."
  ([base-camera x y]
   (phaser->clj
    (.getWorldPoint base-camera
                    (clj->phaser x)
                    (clj->phaser y))))
  ([base-camera x y output]
   (phaser->clj
    (.getWorldPoint base-camera
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser output)))))

(defn ignore
  "Given a Game Object, or an array of Game Objects, it will update all of their camera filter settings
  so that they are ignored by this Camera. This means they will not be rendered by this Camera.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * entries (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject> | Phaser.GameObjects.Group) - The Game Object, or array of Game Objects, to be ignored by this Camera.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera entries]
   (phaser->clj
    (.ignore base-camera
             (clj->phaser entries)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([base-camera event]
   (phaser->clj
    (.listenerCount base-camera
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([base-camera event]
   (phaser->clj
    (.listeners base-camera
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-camera event]
   (phaser->clj
    (.off base-camera
          (clj->phaser event))))
  ([base-camera event fn]
   (phaser->clj
    (.off base-camera
          (clj->phaser event)
          (clj->phaser fn))))
  ([base-camera event fn context]
   (phaser->clj
    (.off base-camera
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([base-camera event fn context once]
   (phaser->clj
    (.off base-camera
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-camera event fn]
   (phaser->clj
    (.on base-camera
         (clj->phaser event)
         (clj->phaser fn))))
  ([base-camera event fn context]
   (phaser->clj
    (.on base-camera
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-camera event fn]
   (phaser->clj
    (.once base-camera
           (clj->phaser event)
           (clj->phaser fn))))
  ([base-camera event fn context]
   (phaser->clj
    (.once base-camera
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-camera]
   (phaser->clj
    (.removeAllListeners base-camera)))
  ([base-camera event]
   (phaser->clj
    (.removeAllListeners base-camera
                         (clj->phaser event)))))

(defn remove-bounds
  "If this Camera has previously had movement bounds set on it, this will remove them.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.removeBounds base-camera))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-camera event]
   (phaser->clj
    (.removeListener base-camera
                     (clj->phaser event))))
  ([base-camera event fn]
   (phaser->clj
    (.removeListener base-camera
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([base-camera event fn context]
   (phaser->clj
    (.removeListener base-camera
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([base-camera event fn context once]
   (phaser->clj
    (.removeListener base-camera
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn set-alpha
  "Set the Alpha level of this Camera. The alpha controls the opacity of the Camera as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * value (number) {optional} - The Camera alpha value.

  Returns:  this - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.setAlpha base-camera)))
  ([base-camera value]
   (phaser->clj
    (.setAlpha base-camera
               (clj->phaser value)))))

(defn set-angle
  "Set the rotation of this Camera. This causes everything it renders to appear rotated.

  Rotating a camera does not rotate the viewport itself, it is applied during rendering.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * value (number) {optional} - The cameras angle of rotation, given in degrees.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.setAngle base-camera)))
  ([base-camera value]
   (phaser->clj
    (.setAngle base-camera
               (clj->phaser value)))))

(defn set-background-color
  "Sets the background color for this Camera.

  By default a Camera has a transparent background but it can be given a solid color, with any level
  of transparency, via this method.

  The color value can be specified using CSS color notation, hex or numbers.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * color (string | number | Phaser.Types.Display.InputColorObject) {optional} - The color value. In CSS, hex or numeric color notation.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.setBackgroundColor base-camera)))
  ([base-camera color]
   (phaser->clj
    (.setBackgroundColor base-camera
                         (clj->phaser color)))))

(defn set-bounds
  "Set the bounds of the Camera. The bounds are an axis-aligned rectangle.

  The Camera bounds controls where the Camera can scroll to, stopping it from scrolling off the
  edges and into blank space. It does not limit the placement of Game Objects, or where
  the Camera viewport can be positioned.

  Temporarily disable the bounds by changing the boolean `Camera.useBounds`.

  Clear the bounds entirely by calling `Camera.removeBounds`.

  If you set bounds that are smaller than the viewport it will stop the Camera from being
  able to scroll. The bounds can be positioned where-ever you wish. By default they are from
  0x0 to the canvas width x height. This means that the coordinate 0x0 is the top left of
  the Camera bounds. However, you can position them anywhere. So if you wanted a game world
  that was 2048x2048 in size, with 0x0 being the center of it, you can set the bounds x/y
  to be -1024, -1024, with a width and height of 2048. Depending on your game you may find
  it easier for 0x0 to be the top-left of the bounds, or you may wish 0x0 to be the middle.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (integer) - The top-left x coordinate of the bounds.
    * y (integer) - The top-left y coordinate of the bounds.
    * width (integer) - The width of the bounds, in pixels.
    * height (integer) - The height of the bounds, in pixels.
    * center-on (boolean) {optional} - If `true` the Camera will automatically be centered on the new bounds.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera x y width height]
   (phaser->clj
    (.setBounds base-camera
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height))))
  ([base-camera x y width height center-on]
   (phaser->clj
    (.setBounds base-camera
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser center-on)))))

(defn set-mask
  "Sets the mask to be applied to this Camera during rendering.

  The mask must have been previously created and can be either a GeometryMask or a BitmapMask.

  Bitmap Masks only work on WebGL. Geometry Masks work on both WebGL and Canvas.

  If a mask is already set on this Camera it will be immediately replaced.

  Masks have no impact on physics or input detection. They are purely a rendering component
  that allows you to limit what is visible during the render pass.

  Note: You cannot mask a Camera that has `renderToTexture` set.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Camera will use when rendering.
    * fixed-position (boolean) {optional} - Should the mask translate along with the Camera, or be fixed in place and not impacted by the Cameras transform?

  Returns:  this - This Camera instance."
  ([base-camera mask]
   (phaser->clj
    (.setMask base-camera
              (clj->phaser mask))))
  ([base-camera mask fixed-position]
   (phaser->clj
    (.setMask base-camera
              (clj->phaser mask)
              (clj->phaser fixed-position)))))

(defn set-name
  "Sets the name of this Camera.
  This value is for your own use and isn't used internally.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * value (string) {optional} - The name of the Camera.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.setName base-camera)))
  ([base-camera value]
   (phaser->clj
    (.setName base-camera
              (clj->phaser value)))))

(defn set-origin
  "Sets the rotation origin of this Camera.

  The values are given in the range 0 to 1 and are only used when calculating Camera rotation.

  By default the camera rotates around the center of the viewport.

  Changing the origin allows you to adjust the point in the viewport from which rotation happens.
  A value of 0 would rotate from the top-left of the viewport. A value of 1 from the bottom right.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.setOrigin base-camera)))
  ([base-camera x]
   (phaser->clj
    (.setOrigin base-camera
                (clj->phaser x))))
  ([base-camera x y]
   (phaser->clj
    (.setOrigin base-camera
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-position
  "Set the position of the Camera viewport within the game.

  This does not change where the camera is 'looking'. See `setScroll` to control that.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) - The top-left x coordinate of the Camera viewport.
    * y (number) {optional} - The top-left y coordinate of the Camera viewport.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera x]
   (phaser->clj
    (.setPosition base-camera
                  (clj->phaser x))))
  ([base-camera x y]
   (phaser->clj
    (.setPosition base-camera
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-rotation
  "Set the rotation of this Camera. This causes everything it renders to appear rotated.

  Rotating a camera does not rotate the viewport itself, it is applied during rendering.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * value (number) {optional} - The rotation of the Camera, in radians.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.setRotation base-camera)))
  ([base-camera value]
   (phaser->clj
    (.setRotation base-camera
                  (clj->phaser value)))))

(defn set-round-pixels
  "Should the Camera round pixel values to whole integers when rendering Game Objects?

  In some types of game, especially with pixel art, this is required to prevent sub-pixel aliasing.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * value (boolean) - `true` to round Camera pixels, `false` to not.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera value]
   (phaser->clj
    (.setRoundPixels base-camera
                     (clj->phaser value)))))

(defn set-scene
  "Sets the Scene the Camera is bound to.

  Also populates the `resolution` property and updates the internal size values.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene the camera is bound to.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera scene]
   (phaser->clj
    (.setScene base-camera
               (clj->phaser scene)))))

(defn set-scroll
  "Set the position of where the Camera is looking within the game.
  You can also modify the properties `Camera.scrollX` and `Camera.scrollY` directly.
  Use this method, or the scroll properties, to move your camera around the game world.

  This does not change where the camera viewport is placed. See `setPosition` to control that.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) - The x coordinate of the Camera in the game world.
    * y (number) {optional} - The y coordinate of the Camera in the game world.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera x]
   (phaser->clj
    (.setScroll base-camera
                (clj->phaser x))))
  ([base-camera x y]
   (phaser->clj
    (.setScroll base-camera
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-size
  "Set the size of the Camera viewport.

  By default a Camera is the same size as the game, but can be made smaller via this method,
  allowing you to create mini-cam style effects by creating and positioning a smaller Camera
  viewport within your game.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * width (integer) - The width of the Camera viewport.
    * height (integer) {optional} - The height of the Camera viewport.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera width]
   (phaser->clj
    (.setSize base-camera
              (clj->phaser width))))
  ([base-camera width height]
   (phaser->clj
    (.setSize base-camera
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-viewport
  "This method sets the position and size of the Camera viewport in a single call.

  If you're trying to change where the Camera is looking at in your game, then see
  the method `Camera.setScroll` instead. This method is for changing the viewport
  itself, not what the camera can see.

  By default a Camera is the same size as the game, but can be made smaller via this method,
  allowing you to create mini-cam style effects by creating and positioning a smaller Camera
  viewport within your game.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * x (number) - The top-left x coordinate of the Camera viewport.
    * y (number) - The top-left y coordinate of the Camera viewport.
    * width (integer) - The width of the Camera viewport.
    * height (integer) {optional} - The height of the Camera viewport.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera x y width]
   (phaser->clj
    (.setViewport base-camera
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width))))
  ([base-camera x y width height]
   (phaser->clj
    (.setViewport base-camera
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height)))))

(defn set-visible
  "Sets the visibility of this Camera.

  An invisible Camera will skip rendering and input tests of everything it can see.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * value (boolean) - The visible state of the Camera.

  Returns:  this - This Camera instance."
  ([base-camera value]
   (phaser->clj
    (.setVisible base-camera
                 (clj->phaser value)))))

(defn set-zoom
  "Set the zoom value of the Camera.

  Changing to a smaller value, such as 0.5, will cause the camera to 'zoom out'.
  Changing to a larger value, such as 2, will cause the camera to 'zoom in'.

  A value of 1 means 'no zoom' and is the default.

  Changing the zoom does not impact the Camera viewport in any way, it is only applied during rendering.

  Parameters:
    * base-camera (Phaser.Cameras.Scene2D.BaseCamera) - Targeted instance for method
    * value (number) {optional} - The zoom value of the Camera. The minimum it can be is 0.001.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([base-camera]
   (phaser->clj
    (.setZoom base-camera)))
  ([base-camera value]
   (phaser->clj
    (.setZoom base-camera
              (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([base-camera]
   (phaser->clj
    (.shutdown base-camera))))

(defn to-json
  "Returns an Object suitable for JSON storage containing all of the Camera viewport and rendering properties.

  Returns:  Phaser.Types.Cameras.Scene2D.JSONCamera - A well-formed object suitable for conversion to JSON."
  ([base-camera]
   (phaser->clj
    (.toJSON base-camera))))