(ns phzr.cameras.scene-2-d.camera
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Camera
  "  Parameters:
    * x (number) - The x position of the Camera, relative to the top-left of the game canvas.
    * y (number) - The y position of the Camera, relative to the top-left of the game canvas.
    * width (number) - The width of the Camera, in pixels.
    * height (number) - The height of the Camera, in pixels."
  ([x y width height]
   (js/Phaser.Cameras.Scene2D.Camera. (clj->phaser x)
                                      (clj->phaser y)
                                      (clj->phaser width)
                                      (clj->phaser height))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([camera event fn]
   (phaser->clj
    (.addListener camera
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([camera event fn context]
   (phaser->clj
    (.addListener camera
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn center-on
  "Moves the Camera so that it is centered on the given coordinates, bounds allowing.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The horizontal coordinate to center on.
    * y (number) - The vertical coordinate to center on.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera x y]
   (phaser->clj
    (.centerOn camera
               (clj->phaser x)
               (clj->phaser y)))))

(defn center-on-x
  "Moves the Camera horizontally so that it is centered on the given x coordinate, bounds allowing.
  Calling this does not change the scrollY value.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The horizontal coordinate to center on.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera x]
   (phaser->clj
    (.centerOnX camera
                (clj->phaser x)))))

(defn center-on-y
  "Moves the Camera vertically so that it is centered on the given y coordinate, bounds allowing.
  Calling this does not change the scrollX value.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * y (number) - The vertical coordinate to center on.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera y]
   (phaser->clj
    (.centerOnY camera
                (clj->phaser y)))))

(defn center-to-bounds
  "Moves the Camera so that it is looking at the center of the Camera Bounds, if enabled.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera]
   (phaser->clj
    (.centerToBounds camera))))

(defn center-to-size
  "Moves the Camera so that it is re-centered based on its viewport size.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera]
   (phaser->clj
    (.centerToSize camera))))

(defn clamp-x
  "Takes an x value and checks it's within the range of the Camera bounds, adjusting if required.
  Do not call this method if you are not using camera bounds.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The value to horizontally scroll clamp.

  Returns:  number - The adjusted value to use as scrollX."
  ([camera x]
   (phaser->clj
    (.clampX camera
             (clj->phaser x)))))

(defn clamp-y
  "Takes a y value and checks it's within the range of the Camera bounds, adjusting if required.
  Do not call this method if you are not using camera bounds.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * y (number) - The value to vertically scroll clamp.

  Returns:  number - The adjusted value to use as scrollY."
  ([camera y]
   (phaser->clj
    (.clampY camera
             (clj->phaser y)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([camera]
   (phaser->clj
    (.clearAlpha camera))))

(defn clear-mask
  "Clears the mask that this Camera was using.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Camera instance."
  ([camera]
   (phaser->clj
    (.clearMask camera)))
  ([camera destroy-mask]
   (phaser->clj
    (.clearMask camera
                (clj->phaser destroy-mask)))))

(defn clear-render-to-texture
  "If this Camera was set to render to a texture, this will clear the resources it was using and
  redirect it to render back to the primary Canvas again.

  If you only wish to temporarily disable rendering to a texture then you can toggle the
  property `renderToTexture` instead.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.clearRenderToTexture camera))))

(defn clear-tint
  "Clears all tint values associated with this Game Object.

  Immediately sets the color values back to 0xffffff and the tint type to 'additive',
  which results in no visible change to the texture.

  Returns:  this - This Game Object instance."
  ([camera]
   (phaser->clj
    (.clearTint camera))))

(defn cull
  "Takes an array of Game Objects and returns a new array featuring only those objects
  visible by this camera.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * renderable-objects (Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to cull.

  Returns:  Array.<Phaser.GameObjects.GameObject> - An array of Game Objects visible to this Camera."
  ([camera renderable-objects]
   (phaser->clj
    (.cull camera
           (clj->phaser renderable-objects)))))

(defn destroy
  "Destroys this Camera instance. You rarely need to call this directly.

  Called by the Camera Manager. If you wish to destroy a Camera please use `CameraManager.remove` as
  cameras are stored in a pool, ready for recycling later, and calling this directly will prevent that."
  ([camera]
   (phaser->clj
    (.destroy camera))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([camera event]
   (phaser->clj
    (.emit camera
           (clj->phaser event))))
  ([camera event args]
   (phaser->clj
    (.emit camera
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([camera]
   (phaser->clj
    (.eventNames camera))))

(defn fade
  "Fades the Camera from transparent to the given color over the duration specified.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * red (integer) {optional} - The amount to fade the red channel towards. A value between 0 and 255.
    * green (integer) {optional} - The amount to fade the green channel towards. A value between 0 and 255.
    * blue (integer) {optional} - The amount to fade the blue channel towards. A value between 0 and 255.
    * force (boolean) {optional} - Force the effect to start immediately, even if already running.
    * callback (function) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent two arguments: A reference to the camera and a progress amount between 0 and 1 indicating how complete the effect is.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.fade camera)))
  ([camera duration]
   (phaser->clj
    (.fade camera
           (clj->phaser duration))))
  ([camera duration red]
   (phaser->clj
    (.fade camera
           (clj->phaser duration)
           (clj->phaser red))))
  ([camera duration red green]
   (phaser->clj
    (.fade camera
           (clj->phaser duration)
           (clj->phaser red)
           (clj->phaser green))))
  ([camera duration red green blue]
   (phaser->clj
    (.fade camera
           (clj->phaser duration)
           (clj->phaser red)
           (clj->phaser green)
           (clj->phaser blue))))
  ([camera duration red green blue force]
   (phaser->clj
    (.fade camera
           (clj->phaser duration)
           (clj->phaser red)
           (clj->phaser green)
           (clj->phaser blue)
           (clj->phaser force))))
  ([camera duration red green blue force callback]
   (phaser->clj
    (.fade camera
           (clj->phaser duration)
           (clj->phaser red)
           (clj->phaser green)
           (clj->phaser blue)
           (clj->phaser force)
           (clj->phaser callback))))
  ([camera duration red green blue force callback context]
   (phaser->clj
    (.fade camera
           (clj->phaser duration)
           (clj->phaser red)
           (clj->phaser green)
           (clj->phaser blue)
           (clj->phaser force)
           (clj->phaser callback)
           (clj->phaser context)))))

(defn fade-from
  "Fades the Camera from the given color to transparent over the duration specified.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * red (integer) {optional} - The amount to fade the red channel towards. A value between 0 and 255.
    * green (integer) {optional} - The amount to fade the green channel towards. A value between 0 and 255.
    * blue (integer) {optional} - The amount to fade the blue channel towards. A value between 0 and 255.
    * force (boolean) {optional} - Force the effect to start immediately, even if already running.
    * callback (function) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent two arguments: A reference to the camera and a progress amount between 0 and 1 indicating how complete the effect is.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.fadeFrom camera)))
  ([camera duration]
   (phaser->clj
    (.fadeFrom camera
               (clj->phaser duration))))
  ([camera duration red]
   (phaser->clj
    (.fadeFrom camera
               (clj->phaser duration)
               (clj->phaser red))))
  ([camera duration red green]
   (phaser->clj
    (.fadeFrom camera
               (clj->phaser duration)
               (clj->phaser red)
               (clj->phaser green))))
  ([camera duration red green blue]
   (phaser->clj
    (.fadeFrom camera
               (clj->phaser duration)
               (clj->phaser red)
               (clj->phaser green)
               (clj->phaser blue))))
  ([camera duration red green blue force]
   (phaser->clj
    (.fadeFrom camera
               (clj->phaser duration)
               (clj->phaser red)
               (clj->phaser green)
               (clj->phaser blue)
               (clj->phaser force))))
  ([camera duration red green blue force callback]
   (phaser->clj
    (.fadeFrom camera
               (clj->phaser duration)
               (clj->phaser red)
               (clj->phaser green)
               (clj->phaser blue)
               (clj->phaser force)
               (clj->phaser callback))))
  ([camera duration red green blue force callback context]
   (phaser->clj
    (.fadeFrom camera
               (clj->phaser duration)
               (clj->phaser red)
               (clj->phaser green)
               (clj->phaser blue)
               (clj->phaser force)
               (clj->phaser callback)
               (clj->phaser context)))))

(defn fade-in
  "Fades the Camera in from the given color over the duration specified.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * red (integer) {optional} - The amount to fade the red channel towards. A value between 0 and 255.
    * green (integer) {optional} - The amount to fade the green channel towards. A value between 0 and 255.
    * blue (integer) {optional} - The amount to fade the blue channel towards. A value between 0 and 255.
    * callback (function) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent two arguments: A reference to the camera and a progress amount between 0 and 1 indicating how complete the effect is.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.fadeIn camera)))
  ([camera duration]
   (phaser->clj
    (.fadeIn camera
             (clj->phaser duration))))
  ([camera duration red]
   (phaser->clj
    (.fadeIn camera
             (clj->phaser duration)
             (clj->phaser red))))
  ([camera duration red green]
   (phaser->clj
    (.fadeIn camera
             (clj->phaser duration)
             (clj->phaser red)
             (clj->phaser green))))
  ([camera duration red green blue]
   (phaser->clj
    (.fadeIn camera
             (clj->phaser duration)
             (clj->phaser red)
             (clj->phaser green)
             (clj->phaser blue))))
  ([camera duration red green blue callback]
   (phaser->clj
    (.fadeIn camera
             (clj->phaser duration)
             (clj->phaser red)
             (clj->phaser green)
             (clj->phaser blue)
             (clj->phaser callback))))
  ([camera duration red green blue callback context]
   (phaser->clj
    (.fadeIn camera
             (clj->phaser duration)
             (clj->phaser red)
             (clj->phaser green)
             (clj->phaser blue)
             (clj->phaser callback)
             (clj->phaser context)))))

(defn fade-out
  "Fades the Camera out to the given color over the duration specified.
  This is an alias for Camera.fade that forces the fade to start, regardless of existing fades.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * red (integer) {optional} - The amount to fade the red channel towards. A value between 0 and 255.
    * green (integer) {optional} - The amount to fade the green channel towards. A value between 0 and 255.
    * blue (integer) {optional} - The amount to fade the blue channel towards. A value between 0 and 255.
    * callback (function) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent two arguments: A reference to the camera and a progress amount between 0 and 1 indicating how complete the effect is.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.fadeOut camera)))
  ([camera duration]
   (phaser->clj
    (.fadeOut camera
              (clj->phaser duration))))
  ([camera duration red]
   (phaser->clj
    (.fadeOut camera
              (clj->phaser duration)
              (clj->phaser red))))
  ([camera duration red green]
   (phaser->clj
    (.fadeOut camera
              (clj->phaser duration)
              (clj->phaser red)
              (clj->phaser green))))
  ([camera duration red green blue]
   (phaser->clj
    (.fadeOut camera
              (clj->phaser duration)
              (clj->phaser red)
              (clj->phaser green)
              (clj->phaser blue))))
  ([camera duration red green blue callback]
   (phaser->clj
    (.fadeOut camera
              (clj->phaser duration)
              (clj->phaser red)
              (clj->phaser green)
              (clj->phaser blue)
              (clj->phaser callback))))
  ([camera duration red green blue callback context]
   (phaser->clj
    (.fadeOut camera
              (clj->phaser duration)
              (clj->phaser red)
              (clj->phaser green)
              (clj->phaser blue)
              (clj->phaser callback)
              (clj->phaser context)))))

(defn flash
  "Flashes the Camera by setting it to the given color immediately and then fading it away again quickly over the duration specified.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * red (integer) {optional} - The amount to fade the red channel towards. A value between 0 and 255.
    * green (integer) {optional} - The amount to fade the green channel towards. A value between 0 and 255.
    * blue (integer) {optional} - The amount to fade the blue channel towards. A value between 0 and 255.
    * force (boolean) {optional} - Force the effect to start immediately, even if already running.
    * callback (function) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent two arguments: A reference to the camera and a progress amount between 0 and 1 indicating how complete the effect is.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.flash camera)))
  ([camera duration]
   (phaser->clj
    (.flash camera
            (clj->phaser duration))))
  ([camera duration red]
   (phaser->clj
    (.flash camera
            (clj->phaser duration)
            (clj->phaser red))))
  ([camera duration red green]
   (phaser->clj
    (.flash camera
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green))))
  ([camera duration red green blue]
   (phaser->clj
    (.flash camera
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue))))
  ([camera duration red green blue force]
   (phaser->clj
    (.flash camera
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue)
            (clj->phaser force))))
  ([camera duration red green blue force callback]
   (phaser->clj
    (.flash camera
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue)
            (clj->phaser force)
            (clj->phaser callback))))
  ([camera duration red green blue force callback context]
   (phaser->clj
    (.flash camera
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue)
            (clj->phaser force)
            (clj->phaser callback)
            (clj->phaser context)))))

(defn get-bounds
  "Returns a rectangle containing the bounds of the Camera.

  If the Camera does not have any bounds the rectangle will be empty.

  The rectangle is a copy of the bounds, so is safe to modify.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - An optional Rectangle to store the bounds in. If not given, a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle - A rectangle containing the bounds of this Camera."
  ([camera]
   (phaser->clj
    (.getBounds camera)))
  ([camera out]
   (phaser->clj
    (.getBounds camera
                (clj->phaser out)))))

(defn get-scroll
  "Calculates what the Camera.scrollX and scrollY values would need to be in order to move
  the Camera so it is centered on the given x and y coordinates, without actually moving
  the Camera there. The results are clamped based on the Camera bounds, if set.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The horizontal coordinate to center on.
    * y (number) - The vertical coordinate to center on.
    * out (Phaser.Math.Vector2) {optional} - A Vec2 to store the values in. If not given a new Vec2 is created.

  Returns:  Phaser.Math.Vector2 - The scroll coordinates stored in the `x` and `y` properties."
  ([camera x y]
   (phaser->clj
    (.getScroll camera
                (clj->phaser x)
                (clj->phaser y))))
  ([camera x y out]
   (phaser->clj
    (.getScroll camera
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser out)))))

(defn get-world-point
  "Converts the given `x` and `y` coordinates into World space, based on this Cameras transform.
  You can optionally provide a Vector2, or similar object, to store the results in.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The x position to convert to world space.
    * y (number) - The y position to convert to world space.
    * output (object | Phaser.Math.Vector2) {optional} - An optional object to store the results in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 - An object holding the converted values in its `x` and `y` properties."
  ([camera x y]
   (phaser->clj
    (.getWorldPoint camera
                    (clj->phaser x)
                    (clj->phaser y))))
  ([camera x y output]
   (phaser->clj
    (.getWorldPoint camera
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser output)))))

(defn ignore
  "Given a Game Object, or an array of Game Objects, it will update all of their camera filter settings
  so that they are ignored by this Camera. This means they will not be rendered by this Camera.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * entries (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject> | Phaser.GameObjects.Group) - The Game Object, or array of Game Objects, to be ignored by this Camera.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera entries]
   (phaser->clj
    (.ignore camera
             (clj->phaser entries)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([camera event]
   (phaser->clj
    (.listenerCount camera
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([camera event]
   (phaser->clj
    (.listeners camera
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([camera event]
   (phaser->clj
    (.off camera
          (clj->phaser event))))
  ([camera event fn]
   (phaser->clj
    (.off camera
          (clj->phaser event)
          (clj->phaser fn))))
  ([camera event fn context]
   (phaser->clj
    (.off camera
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([camera event fn context once]
   (phaser->clj
    (.off camera
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([camera event fn]
   (phaser->clj
    (.on camera
         (clj->phaser event)
         (clj->phaser fn))))
  ([camera event fn context]
   (phaser->clj
    (.on camera
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([camera event fn]
   (phaser->clj
    (.once camera
           (clj->phaser event)
           (clj->phaser fn))))
  ([camera event fn context]
   (phaser->clj
    (.once camera
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pan
  "This effect will scroll the Camera so that the center of its viewport finishes at the given destination,
  over the duration and with the ease specified.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The destination x coordinate to scroll the center of the Camera viewport to.
    * y (number) - The destination y coordinate to scroll the center of the Camera viewport to.
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * ease (string | function) {optional} - The ease to use for the pan. Can be any of the Phaser Easing constants or a custom function.
    * force (boolean) {optional} - Force the pan effect to start immediately, even if already running.
    * callback (Phaser.Types.Cameras.Scene2D.CameraPanCallback) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent four arguments: A reference to the camera, a progress amount between 0 and 1 indicating how complete the effect is,
the current camera scroll x coordinate and the current camera scroll y coordinate.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera x y]
   (phaser->clj
    (.pan camera
          (clj->phaser x)
          (clj->phaser y))))
  ([camera x y duration]
   (phaser->clj
    (.pan camera
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser duration))))
  ([camera x y duration ease]
   (phaser->clj
    (.pan camera
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser duration)
          (clj->phaser ease))))
  ([camera x y duration ease force]
   (phaser->clj
    (.pan camera
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser duration)
          (clj->phaser ease)
          (clj->phaser force))))
  ([camera x y duration ease force callback]
   (phaser->clj
    (.pan camera
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser duration)
          (clj->phaser ease)
          (clj->phaser force)
          (clj->phaser callback))))
  ([camera x y duration ease force callback context]
   (phaser->clj
    (.pan camera
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser duration)
          (clj->phaser ease)
          (clj->phaser force)
          (clj->phaser callback)
          (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([camera]
   (phaser->clj
    (.removeAllListeners camera)))
  ([camera event]
   (phaser->clj
    (.removeAllListeners camera
                         (clj->phaser event)))))

(defn remove-bounds
  "If this Camera has previously had movement bounds set on it, this will remove them.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera]
   (phaser->clj
    (.removeBounds camera))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([camera event]
   (phaser->clj
    (.removeListener camera
                     (clj->phaser event))))
  ([camera event fn]
   (phaser->clj
    (.removeListener camera
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([camera event fn context]
   (phaser->clj
    (.removeListener camera
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([camera event fn context once]
   (phaser->clj
    (.removeListener camera
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-flip
  "Resets the horizontal and vertical flipped state of this Game Object back to their default un-flipped state.

  Returns:  this - This Game Object instance."
  ([camera]
   (phaser->clj
    (.resetFlip camera))))

(defn reset-fx
  "Resets any active FX, such as a fade, flash or shake. Useful to call after a fade in order to
  remove the fade.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.resetFX camera))))

(defn set-alpha
  "Set the Alpha level of this Camera. The alpha controls the opacity of the Camera as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (number) {optional} - The Camera alpha value.

  Returns:  this - This Camera instance."
  ([camera]
   (phaser->clj
    (.setAlpha camera)))
  ([camera value]
   (phaser->clj
    (.setAlpha camera
               (clj->phaser value)))))

(defn set-angle
  "Set the rotation of this Camera. This causes everything it renders to appear rotated.

  Rotating a camera does not rotate the viewport itself, it is applied during rendering.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (number) {optional} - The cameras angle of rotation, given in degrees.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera]
   (phaser->clj
    (.setAngle camera)))
  ([camera value]
   (phaser->clj
    (.setAngle camera
               (clj->phaser value)))))

(defn set-background-color
  "Sets the background color for this Camera.

  By default a Camera has a transparent background but it can be given a solid color, with any level
  of transparency, via this method.

  The color value can be specified using CSS color notation, hex or numbers.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * color (string | number | Phaser.Types.Display.InputColorObject) {optional} - The color value. In CSS, hex or numeric color notation.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera]
   (phaser->clj
    (.setBackgroundColor camera)))
  ([camera color]
   (phaser->clj
    (.setBackgroundColor camera
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
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (integer) - The top-left x coordinate of the bounds.
    * y (integer) - The top-left y coordinate of the bounds.
    * width (integer) - The width of the bounds, in pixels.
    * height (integer) - The height of the bounds, in pixels.
    * center-on (boolean) {optional} - If `true` the Camera will automatically be centered on the new bounds.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera x y width height]
   (phaser->clj
    (.setBounds camera
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height))))
  ([camera x y width height center-on]
   (phaser->clj
    (.setBounds camera
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser center-on)))))

(defn set-deadzone
  "Sets the Camera dead zone.

  The deadzone is only used when the camera is following a target.

  It defines a rectangular region within which if the target is present, the camera will not scroll.
  If the target moves outside of this area, the camera will begin scrolling in order to follow it.

  The deadzone rectangle is re-positioned every frame so that it is centered on the mid-point
  of the camera. This allows you to use the object for additional game related checks, such as
  testing if an object is within it or not via a Rectangle.contains call.

  The `lerp` values that you can set for a follower target also apply when using a deadzone.

  Calling this method with no arguments will reset an active deadzone.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * width (number) {optional} - The width of the deadzone rectangle in pixels. If not specified the deadzone is removed.
    * height (number) {optional} - The height of the deadzone rectangle in pixels.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.setDeadzone camera)))
  ([camera width]
   (phaser->clj
    (.setDeadzone camera
                  (clj->phaser width))))
  ([camera width height]
   (phaser->clj
    (.setDeadzone camera
                  (clj->phaser width)
                  (clj->phaser height)))))

(defn set-flip
  "Sets the horizontal and vertical flipped state of this Game Object.

  A Game Object that is flipped will render inversed on the flipped axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.
    * y (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([camera x y]
   (phaser->clj
    (.setFlip camera
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-flip-x
  "Sets the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([camera value]
   (phaser->clj
    (.setFlipX camera
               (clj->phaser value)))))

(defn set-flip-y
  "Sets the vertical flipped state of this Game Object.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([camera value]
   (phaser->clj
    (.setFlipY camera
               (clj->phaser value)))))

(defn set-follow-offset
  "Sets the horizontal and vertical offset of the camera from its follow target.
  The values are subtracted from the targets position during the Cameras update step.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) {optional} - The horizontal offset from the camera follow target.x position.
    * y (number) {optional} - The vertical offset from the camera follow target.y position.

  Returns:  this - This Camera instance."
  ([camera]
   (phaser->clj
    (.setFollowOffset camera)))
  ([camera x]
   (phaser->clj
    (.setFollowOffset camera
                      (clj->phaser x))))
  ([camera x y]
   (phaser->clj
    (.setFollowOffset camera
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-lerp
  "Sets the linear interpolation value to use when following a target.

  The default values of 1 means the camera will instantly snap to the target coordinates.
  A lower value, such as 0.1 means the camera will more slowly track the target, giving
  a smooth transition. You can set the horizontal and vertical values independently, and also
  adjust this value in real-time during your game.

  Be sure to keep the value between 0 and 1. A value of zero will disable tracking on that axis.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) {optional} - The amount added to the horizontal linear interpolation of the follow target.
    * y (number) {optional} - The amount added to the vertical linear interpolation of the follow target.

  Returns:  this - This Camera instance."
  ([camera]
   (phaser->clj
    (.setLerp camera)))
  ([camera x]
   (phaser->clj
    (.setLerp camera
              (clj->phaser x))))
  ([camera x y]
   (phaser->clj
    (.setLerp camera
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-mask
  "Sets the mask to be applied to this Camera during rendering.

  The mask must have been previously created and can be either a GeometryMask or a BitmapMask.

  Bitmap Masks only work on WebGL. Geometry Masks work on both WebGL and Canvas.

  If a mask is already set on this Camera it will be immediately replaced.

  Masks have no impact on physics or input detection. They are purely a rendering component
  that allows you to limit what is visible during the render pass.

  Note: You cannot mask a Camera that has `renderToTexture` set.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Camera will use when rendering.
    * fixed-position (boolean) {optional} - Should the mask translate along with the Camera, or be fixed in place and not impacted by the Cameras transform?

  Returns:  this - This Camera instance."
  ([camera mask]
   (phaser->clj
    (.setMask camera
              (clj->phaser mask))))
  ([camera mask fixed-position]
   (phaser->clj
    (.setMask camera
              (clj->phaser mask)
              (clj->phaser fixed-position)))))

(defn set-name
  "Sets the name of this Camera.
  This value is for your own use and isn't used internally.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (string) {optional} - The name of the Camera.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera]
   (phaser->clj
    (.setName camera)))
  ([camera value]
   (phaser->clj
    (.setName camera
              (clj->phaser value)))))

(defn set-origin
  "Sets the rotation origin of this Camera.

  The values are given in the range 0 to 1 and are only used when calculating Camera rotation.

  By default the camera rotates around the center of the viewport.

  Changing the origin allows you to adjust the point in the viewport from which rotation happens.
  A value of 0 would rotate from the top-left of the viewport. A value of 1 from the bottom right.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Camera instance."
  ([camera]
   (phaser->clj
    (.setOrigin camera)))
  ([camera x]
   (phaser->clj
    (.setOrigin camera
                (clj->phaser x))))
  ([camera x y]
   (phaser->clj
    (.setOrigin camera
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-pipeline
  "Sets the WebGL pipeline this Camera is using when rendering to a texture.

  You can pass either the string-based name of the pipeline, or a reference to the pipeline itself.

  Call this method with no arguments to clear any previously set pipeline.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * pipeline (string | Phaser.Renderer.WebGL.WebGLPipeline) {optional} - The WebGL Pipeline to render with, can be either a string which is the name of the pipeline, or a pipeline reference. Or if left empty it will clear the pipeline.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.setPipeline camera)))
  ([camera pipeline]
   (phaser->clj
    (.setPipeline camera
                  (clj->phaser pipeline)))))

(defn set-position
  "Set the position of the Camera viewport within the game.

  This does not change where the camera is 'looking'. See `setScroll` to control that.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The top-left x coordinate of the Camera viewport.
    * y (number) {optional} - The top-left y coordinate of the Camera viewport.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera x]
   (phaser->clj
    (.setPosition camera
                  (clj->phaser x))))
  ([camera x y]
   (phaser->clj
    (.setPosition camera
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-render-to-texture
  "Sets the Camera to render to a texture instead of to the main canvas.

  The Camera will redirect all Game Objects it's asked to render to this texture.

  During the render sequence, the texture itself will then be rendered to the main canvas.

  Doing this gives you the ability to modify the texture before this happens,
  allowing for special effects such as Camera specific shaders, or post-processing
  on the texture.

  If running under Canvas the Camera will render to its `canvas` property.

  If running under WebGL the Camera will create a frame buffer, which is stored in its `framebuffer` and `glTexture` properties.

  If you set a camera to render to a texture then it will emit 2 events during the render loop:

  First, it will emit the event `prerender`. This happens right before any Game Object's are drawn to the Camera texture.

  Then, it will emit the event `postrender`. This happens after all Game Object's have been drawn, but right before the
  Camera texture is rendered to the main game canvas. It's the final point at which you can manipulate the texture before
  it appears in-game.

  You should not enable this unless you plan on actually using the texture it creates
  somehow, otherwise you're just doubling the work required to render your game.

  To temporarily disable rendering to a texture, toggle the `renderToTexture` boolean.

  If you no longer require the Camera to render to a texture, call the `clearRenderToTexture` method,
  which will delete the respective textures and free-up resources.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * pipeline (string | Phaser.Renderer.WebGL.WebGLPipeline) {optional} - An optional WebGL Pipeline to render with, can be either a string which is the name of the pipeline, or a pipeline reference.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.setRenderToTexture camera)))
  ([camera pipeline]
   (phaser->clj
    (.setRenderToTexture camera
                         (clj->phaser pipeline)))))

(defn set-rotation
  "Set the rotation of this Camera. This causes everything it renders to appear rotated.

  Rotating a camera does not rotate the viewport itself, it is applied during rendering.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (number) {optional} - The rotation of the Camera, in radians.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera]
   (phaser->clj
    (.setRotation camera)))
  ([camera value]
   (phaser->clj
    (.setRotation camera
                  (clj->phaser value)))))

(defn set-round-pixels
  "Should the Camera round pixel values to whole integers when rendering Game Objects?

  In some types of game, especially with pixel art, this is required to prevent sub-pixel aliasing.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (boolean) - `true` to round Camera pixels, `false` to not.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera value]
   (phaser->clj
    (.setRoundPixels camera
                     (clj->phaser value)))))

(defn set-scene
  "Sets the Scene the Camera is bound to.

  Also populates the `resolution` property and updates the internal size values.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene the camera is bound to.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera scene]
   (phaser->clj
    (.setScene camera
               (clj->phaser scene)))))

(defn set-scroll
  "Set the position of where the Camera is looking within the game.
  You can also modify the properties `Camera.scrollX` and `Camera.scrollY` directly.
  Use this method, or the scroll properties, to move your camera around the game world.

  This does not change where the camera viewport is placed. See `setPosition` to control that.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The x coordinate of the Camera in the game world.
    * y (number) {optional} - The y coordinate of the Camera in the game world.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera x]
   (phaser->clj
    (.setScroll camera
                (clj->phaser x))))
  ([camera x y]
   (phaser->clj
    (.setScroll camera
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-size
  "Set the size of the Camera viewport.

  By default a Camera is the same size as the game, but can be made smaller via this method,
  allowing you to create mini-cam style effects by creating and positioning a smaller Camera
  viewport within your game.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * width (integer) - The width of the Camera viewport.
    * height (integer) {optional} - The height of the Camera viewport.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera width]
   (phaser->clj
    (.setSize camera
              (clj->phaser width))))
  ([camera width height]
   (phaser->clj
    (.setSize camera
              (clj->phaser width)
              (clj->phaser height)))))

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
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If no other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([camera]
   (phaser->clj
    (.setTint camera)))
  ([camera top-left]
   (phaser->clj
    (.setTint camera
              (clj->phaser top-left))))
  ([camera top-left top-right]
   (phaser->clj
    (.setTint camera
              (clj->phaser top-left)
              (clj->phaser top-right))))
  ([camera top-left top-right bottom-left]
   (phaser->clj
    (.setTint camera
              (clj->phaser top-left)
              (clj->phaser top-right)
              (clj->phaser bottom-left))))
  ([camera top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTint camera
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
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If not other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([camera]
   (phaser->clj
    (.setTintFill camera)))
  ([camera top-left]
   (phaser->clj
    (.setTintFill camera
                  (clj->phaser top-left))))
  ([camera top-left top-right]
   (phaser->clj
    (.setTintFill camera
                  (clj->phaser top-left)
                  (clj->phaser top-right))))
  ([camera top-left top-right bottom-left]
   (phaser->clj
    (.setTintFill camera
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left))))
  ([camera top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTintFill camera
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left)
                  (clj->phaser bottom-right)))))

(defn set-viewport
  "This method sets the position and size of the Camera viewport in a single call.

  If you're trying to change where the Camera is looking at in your game, then see
  the method `Camera.setScroll` instead. This method is for changing the viewport
  itself, not what the camera can see.

  By default a Camera is the same size as the game, but can be made smaller via this method,
  allowing you to create mini-cam style effects by creating and positioning a smaller Camera
  viewport within your game.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * x (number) - The top-left x coordinate of the Camera viewport.
    * y (number) - The top-left y coordinate of the Camera viewport.
    * width (integer) - The width of the Camera viewport.
    * height (integer) {optional} - The height of the Camera viewport.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera x y width]
   (phaser->clj
    (.setViewport camera
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width))))
  ([camera x y width height]
   (phaser->clj
    (.setViewport camera
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height)))))

(defn set-visible
  "Sets the visibility of this Camera.

  An invisible Camera will skip rendering and input tests of everything it can see.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (boolean) - The visible state of the Camera.

  Returns:  this - This Camera instance."
  ([camera value]
   (phaser->clj
    (.setVisible camera
                 (clj->phaser value)))))

(defn set-zoom
  "Set the zoom value of the Camera.

  Changing to a smaller value, such as 0.5, will cause the camera to 'zoom out'.
  Changing to a larger value, such as 2, will cause the camera to 'zoom in'.

  A value of 1 means 'no zoom' and is the default.

  Changing the zoom does not impact the Camera viewport in any way, it is only applied during rendering.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * value (number) {optional} - The zoom value of the Camera. The minimum it can be is 0.001.

  Returns:  Phaser.Cameras.Scene2D.BaseCamera - This Camera instance."
  ([camera]
   (phaser->clj
    (.setZoom camera)))
  ([camera value]
   (phaser->clj
    (.setZoom camera
              (clj->phaser value)))))

(defn shake
  "Shakes the Camera by the given intensity over the duration specified.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * intensity (number | Phaser.Math.Vector2) {optional} - The intensity of the shake.
    * force (boolean) {optional} - Force the shake effect to start immediately, even if already running.
    * callback (function) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent two arguments: A reference to the camera and a progress amount between 0 and 1 indicating how complete the effect is.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.shake camera)))
  ([camera duration]
   (phaser->clj
    (.shake camera
            (clj->phaser duration))))
  ([camera duration intensity]
   (phaser->clj
    (.shake camera
            (clj->phaser duration)
            (clj->phaser intensity))))
  ([camera duration intensity force]
   (phaser->clj
    (.shake camera
            (clj->phaser duration)
            (clj->phaser intensity)
            (clj->phaser force))))
  ([camera duration intensity force callback]
   (phaser->clj
    (.shake camera
            (clj->phaser duration)
            (clj->phaser intensity)
            (clj->phaser force)
            (clj->phaser callback))))
  ([camera duration intensity force callback context]
   (phaser->clj
    (.shake camera
            (clj->phaser duration)
            (clj->phaser intensity)
            (clj->phaser force)
            (clj->phaser callback)
            (clj->phaser context)))))

(defn shutdown
  "Removes all listeners."
  ([camera]
   (phaser->clj
    (.shutdown camera))))

(defn start-follow
  "Sets the Camera to follow a Game Object.

  When enabled the Camera will automatically adjust its scroll position to keep the target Game Object
  in its center.

  You can set the linear interpolation value used in the follow code.
  Use low lerp values (such as 0.1) to automatically smooth the camera motion.

  If you find you're getting a slight 'jitter' effect when following an object it's probably to do with sub-pixel
  rendering of the targets position. This can be rounded by setting the `roundPixels` argument to `true` to
  force full pixel rounding rendering. Note that this can still be broken if you have specified a non-integer zoom
  value on the camera. So be sure to keep the camera zoom to integers.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * target (Phaser.GameObjects.GameObject | object) - The target for the Camera to follow.
    * round-pixels (boolean) {optional} - Round the camera position to whole integers to avoid sub-pixel rendering?
    * lerp-x (number) {optional} - A value between 0 and 1. This value specifies the amount of linear interpolation to use when horizontally tracking the target. The closer the value to 1, the faster the camera will track.
    * lerp-y (number) {optional} - A value between 0 and 1. This value specifies the amount of linear interpolation to use when vertically tracking the target. The closer the value to 1, the faster the camera will track.
    * offset-x (number) {optional} - The horizontal offset from the camera follow target.x position.
    * offset-y (number) {optional} - The vertical offset from the camera follow target.y position.

  Returns:  this - This Camera instance."
  ([camera target]
   (phaser->clj
    (.startFollow camera
                  (clj->phaser target))))
  ([camera target round-pixels]
   (phaser->clj
    (.startFollow camera
                  (clj->phaser target)
                  (clj->phaser round-pixels))))
  ([camera target round-pixels lerp-x]
   (phaser->clj
    (.startFollow camera
                  (clj->phaser target)
                  (clj->phaser round-pixels)
                  (clj->phaser lerp-x))))
  ([camera target round-pixels lerp-x lerp-y]
   (phaser->clj
    (.startFollow camera
                  (clj->phaser target)
                  (clj->phaser round-pixels)
                  (clj->phaser lerp-x)
                  (clj->phaser lerp-y))))
  ([camera target round-pixels lerp-x lerp-y offset-x]
   (phaser->clj
    (.startFollow camera
                  (clj->phaser target)
                  (clj->phaser round-pixels)
                  (clj->phaser lerp-x)
                  (clj->phaser lerp-y)
                  (clj->phaser offset-x))))
  ([camera target round-pixels lerp-x lerp-y offset-x offset-y]
   (phaser->clj
    (.startFollow camera
                  (clj->phaser target)
                  (clj->phaser round-pixels)
                  (clj->phaser lerp-x)
                  (clj->phaser lerp-y)
                  (clj->phaser offset-x)
                  (clj->phaser offset-y)))))

(defn stop-follow
  "Stops a Camera from following a Game Object, if previously set via `Camera.startFollow`.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera]
   (phaser->clj
    (.stopFollow camera))))

(defn to-json
  "Returns an Object suitable for JSON storage containing all of the Camera viewport and rendering properties.

  Returns:  Phaser.Types.Cameras.Scene2D.JSONCamera - A well-formed object suitable for conversion to JSON."
  ([camera]
   (phaser->clj
    (.toJSON camera))))

(defn toggle-flip-x
  "Toggles the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Returns:  this - This Game Object instance."
  ([camera]
   (phaser->clj
    (.toggleFlipX camera))))

(defn toggle-flip-y
  "Toggles the vertical flipped state of this Game Object.

  Returns:  this - This Game Object instance."
  ([camera]
   (phaser->clj
    (.toggleFlipY camera))))

(defn zoom-to
  "This effect will zoom the Camera to the given scale, over the duration and with the ease specified.

  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - Targeted instance for method
    * zoom (number) - The target Camera zoom value.
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * ease (string | function) {optional} - The ease to use for the pan. Can be any of the Phaser Easing constants or a custom function.
    * force (boolean) {optional} - Force the pan effect to start immediately, even if already running.
    * callback (Phaser.Types.Cameras.Scene2D.CameraPanCallback) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent four arguments: A reference to the camera, a progress amount between 0 and 1 indicating how complete the effect is,
the current camera scroll x coordinate and the current camera scroll y coordinate.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - This Camera instance."
  ([camera zoom]
   (phaser->clj
    (.zoomTo camera
             (clj->phaser zoom))))
  ([camera zoom duration]
   (phaser->clj
    (.zoomTo camera
             (clj->phaser zoom)
             (clj->phaser duration))))
  ([camera zoom duration ease]
   (phaser->clj
    (.zoomTo camera
             (clj->phaser zoom)
             (clj->phaser duration)
             (clj->phaser ease))))
  ([camera zoom duration ease force]
   (phaser->clj
    (.zoomTo camera
             (clj->phaser zoom)
             (clj->phaser duration)
             (clj->phaser ease)
             (clj->phaser force))))
  ([camera zoom duration ease force callback]
   (phaser->clj
    (.zoomTo camera
             (clj->phaser zoom)
             (clj->phaser duration)
             (clj->phaser ease)
             (clj->phaser force)
             (clj->phaser callback))))
  ([camera zoom duration ease force callback context]
   (phaser->clj
    (.zoomTo camera
             (clj->phaser zoom)
             (clj->phaser duration)
             (clj->phaser ease)
             (clj->phaser force)
             (clj->phaser callback)
             (clj->phaser context)))))