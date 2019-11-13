(ns phzr.input.input-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->InputPlugin
  "  Parameters:
    * scene (Phaser.Scene) - A reference to the Scene that this Input Plugin is responsible for."
  ([scene]
   (js/Phaser.Input.InputPlugin. (clj->phaser scene))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([input-plugin event fn]
   (phaser->clj
    (.addListener input-plugin
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([input-plugin event fn context]
   (phaser->clj
    (.addListener input-plugin
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn add-pointer
  "Adds new Pointer objects to the Input Manager.

  By default Phaser creates 2 pointer objects: `mousePointer` and `pointer1`.

  You can create more either by calling this method, or by setting the `input.activePointers` property
  in the Game Config, up to a maximum of 10 pointers.

  The first 10 pointers are available via the `InputPlugin.pointerX` properties, once they have been added
  via this method.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * quantity (integer) {optional} - The number of new Pointers to create. A maximum of 10 is allowed in total.

  Returns:  Array.<Phaser.Input.Pointer> - An array containing all of the new Pointer objects that were created."
  ([input-plugin]
   (phaser->clj
    (.addPointer input-plugin)))
  ([input-plugin quantity]
   (phaser->clj
    (.addPointer input-plugin
                 (clj->phaser quantity)))))

(defn clear
  "Clears a Game Object so it no longer has an Interactive Object associated with it.
  The Game Object is then queued for removal from the Input Plugin on the next update.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object that will have its Interactive Object removed.
    * skip-queue (boolean) {optional} - Skip adding this Game Object into the removal queue?

  Returns:  Phaser.GameObjects.GameObject - The Game Object that had its Interactive Object removed."
  ([input-plugin game-object]
   (phaser->clj
    (.clear input-plugin
            (clj->phaser game-object))))
  ([input-plugin game-object skip-queue]
   (phaser->clj
    (.clear input-plugin
            (clj->phaser game-object)
            (clj->phaser skip-queue)))))

(defn disable
  "Disables Input on a single Game Object.

  An input disabled Game Object still retains its Interactive Object component and can be re-enabled
  at any time, by passing it to `InputPlugin.enable`.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object to have its input system disabled."
  ([input-plugin game-object]
   (phaser->clj
    (.disable input-plugin
              (clj->phaser game-object)))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([input-plugin event]
   (phaser->clj
    (.emit input-plugin
           (clj->phaser event))))
  ([input-plugin event args]
   (phaser->clj
    (.emit input-plugin
           (clj->phaser event)
           (clj->phaser args)))))

(defn enable
  "Enable a Game Object for interaction.

  If the Game Object already has an Interactive Object component, it is enabled and returned.

  Otherwise, a new Interactive Object component is created and assigned to the Game Object's `input` property.

  Input works by using hit areas, these are nearly always geometric shapes, such as rectangles or circles, that act as the hit area
  for the Game Object. However, you can provide your own hit area shape and callback, should you wish to handle some more advanced
  input detection.

  If no arguments are provided it will try and create a rectangle hit area based on the texture frame the Game Object is using. If
  this isn't a texture-bound object, such as a Graphics or BitmapText object, this will fail, and you'll need to provide a specific
  shape for it to use.

  You can also provide an Input Configuration Object as the only argument to this method.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object to be enabled for input.
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - The 'contains' function to invoke to check if the pointer is within the hit area.
    * drop-zone (boolean) {optional} - Is this Game Object a drop zone or not?

  Returns:  Phaser.Input.InputPlugin - This Input Plugin."
  ([input-plugin game-object]
   (phaser->clj
    (.enable input-plugin
             (clj->phaser game-object))))
  ([input-plugin game-object shape]
   (phaser->clj
    (.enable input-plugin
             (clj->phaser game-object)
             (clj->phaser shape))))
  ([input-plugin game-object shape callback]
   (phaser->clj
    (.enable input-plugin
             (clj->phaser game-object)
             (clj->phaser shape)
             (clj->phaser callback))))
  ([input-plugin game-object shape callback drop-zone]
   (phaser->clj
    (.enable input-plugin
             (clj->phaser game-object)
             (clj->phaser shape)
             (clj->phaser callback)
             (clj->phaser drop-zone)))))

(defn enable-debug
  "Creates an Input Debug Shape for the given Game Object.

  The Game Object must have _already_ been enabled for input prior to calling this method.

  This is intended to assist you during development and debugging.

  Debug Shapes can only be created for Game Objects that are using standard Phaser Geometry for input,
  including: Circle, Ellipse, Line, Polygon, Rectangle and Triangle.

  Game Objects that are using their automatic hit areas are using Rectangles by default, so will also work.

  The Debug Shape is created and added to the display list and is then kept in sync with the Game Object
  it is connected with. Should you need to modify it yourself, such as to hide it, you can access it via
  the Game Object property: `GameObject.input.hitAreaDebug`.

  Calling this method on a Game Object that already has a Debug Shape will first destroy the old shape,
  before creating a new one. If you wish to remove the Debug Shape entirely, you should call the
  method `InputPlugin.removeDebug`.

  Note that the debug shape will only show the outline of the input area. If the input test is using a
  pixel perfect check, for example, then this is not displayed. If you are using a custom shape, that
  doesn't extend one of the base Phaser Geometry objects, as your hit area, then this method will not
  work.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object to create the input debug shape for.
    * color (number) {optional} - The outline color of the debug shape.

  Returns:  Phaser.Input.InputPlugin - This Input Plugin."
  ([input-plugin game-object]
   (phaser->clj
    (.enableDebug input-plugin
                  (clj->phaser game-object))))
  ([input-plugin game-object color]
   (phaser->clj
    (.enableDebug input-plugin
                  (clj->phaser game-object)
                  (clj->phaser color)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([input-plugin]
   (phaser->clj
    (.eventNames input-plugin))))

(defn get-drag-state
  "Returns the drag state of the given Pointer for this Input Plugin.

  The state will be one of the following:

  0 = Not dragging anything
  1 = Primary button down and objects below, so collect a draglist
  2 = Pointer being checked if meets drag criteria
  3 = Pointer meets criteria, notify the draglist
  4 = Pointer actively dragging the draglist and has moved
  5 = Pointer actively dragging but has been released, notify draglist

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * pointer (Phaser.Input.Pointer) - The Pointer to get the drag state for.

  Returns:  integer - The drag state of the given Pointer."
  ([input-plugin pointer]
   (phaser->clj
    (.getDragState input-plugin
                   (clj->phaser pointer)))))

(defn hit-test-pointer
  "Takes the given Pointer and performs a hit test against it, to see which interactive Game Objects
  it is currently above.

  The hit test is performed against which-ever Camera the Pointer is over. If it is over multiple
  cameras, it starts checking the camera at the top of the camera list, and if nothing is found, iterates down the list.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * pointer (Phaser.Input.Pointer) - The Pointer to check against the Game Objects.

  Returns:  Array.<Phaser.GameObjects.GameObject> - An array of all the interactive Game Objects the Pointer was above."
  ([input-plugin pointer]
   (phaser->clj
    (.hitTestPointer input-plugin
                     (clj->phaser pointer)))))

(defn is-active
  "Checks to see if both this plugin and the Scene to which it belongs is active.

  Returns:  boolean - `true` if the plugin and the Scene it belongs to is active."
  ([input-plugin]
   (phaser->clj
    (.isActive input-plugin))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([input-plugin event]
   (phaser->clj
    (.listenerCount input-plugin
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([input-plugin event]
   (phaser->clj
    (.listeners input-plugin
                (clj->phaser event)))))

(defn make-pixel-perfect
  "Creates a function that can be passed to `setInteractive`, `enable` or `setHitArea` that will handle
  pixel-perfect input detection on an Image or Sprite based Game Object, or any custom class that extends them.

  The following will create a sprite that is clickable on any pixel that has an alpha value >= 1.

  ```javascript
  this.add.sprite(x, y, key).setInteractive(this.input.makePixelPerfect());
  ```

  The following will create a sprite that is clickable on any pixel that has an alpha value >= 150.

  ```javascript
  this.add.sprite(x, y, key).setInteractive(this.input.makePixelPerfect(150));
  ```

  Once you have made an Interactive Object pixel perfect it impacts all input related events for it: down, up,
  dragstart, drag, etc.

  As a pointer interacts with the Game Object it will constantly poll the texture, extracting a single pixel from
  the given coordinates and checking its color values. This is an expensive process, so should only be enabled on
  Game Objects that really need it.

  You cannot make non-texture based Game Objects pixel perfect. So this will not work on Graphics, BitmapText,
  Render Textures, Text, Tilemaps, Containers or Particles.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * alpha-tolerance (integer) {optional} - The alpha level that the pixel should be above to be included as a successful interaction.

  Returns:  function - A Pixel Perfect Handler for use as a hitArea shape callback."
  ([input-plugin]
   (phaser->clj
    (.makePixelPerfect input-plugin)))
  ([input-plugin alpha-tolerance]
   (phaser->clj
    (.makePixelPerfect input-plugin
                       (clj->phaser alpha-tolerance)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([input-plugin event]
   (phaser->clj
    (.off input-plugin
          (clj->phaser event))))
  ([input-plugin event fn]
   (phaser->clj
    (.off input-plugin
          (clj->phaser event)
          (clj->phaser fn))))
  ([input-plugin event fn context]
   (phaser->clj
    (.off input-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([input-plugin event fn context once]
   (phaser->clj
    (.off input-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([input-plugin event fn]
   (phaser->clj
    (.on input-plugin
         (clj->phaser event)
         (clj->phaser fn))))
  ([input-plugin event fn context]
   (phaser->clj
    (.on input-plugin
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([input-plugin event fn]
   (phaser->clj
    (.once input-plugin
           (clj->phaser event)
           (clj->phaser fn))))
  ([input-plugin event fn context]
   (phaser->clj
    (.once input-plugin
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([input-plugin]
   (phaser->clj
    (.removeAllListeners input-plugin)))
  ([input-plugin event]
   (phaser->clj
    (.removeAllListeners input-plugin
                         (clj->phaser event)))))

(defn remove-debug
  "Removes an Input Debug Shape from the given Game Object.

  The shape is destroyed immediately and the `hitAreaDebug` property is set to `null`.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object to remove the input debug shape from.

  Returns:  Phaser.Input.InputPlugin - This Input Plugin."
  ([input-plugin game-object]
   (phaser->clj
    (.removeDebug input-plugin
                  (clj->phaser game-object)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([input-plugin event]
   (phaser->clj
    (.removeListener input-plugin
                     (clj->phaser event))))
  ([input-plugin event fn]
   (phaser->clj
    (.removeListener input-plugin
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([input-plugin event fn context]
   (phaser->clj
    (.removeListener input-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([input-plugin event fn context once]
   (phaser->clj
    (.removeListener input-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn set-default-cursor
  "Tells the Input system to set a custom cursor.

  This cursor will be the default cursor used when interacting with the game canvas.

  If an Interactive Object also sets a custom cursor, this is the cursor that is reset after its use.

  Any valid CSS cursor value is allowed, including paths to image files, i.e.:

  ```javascript
  this.input.setDefaultCursor('url(assets/cursors/sword.cur), pointer');
  ```

  Please read about the differences between browsers when it comes to the file formats and sizes they support:

  https://developer.mozilla.org/en-US/docs/Web/CSS/cursor
  https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_User_Interface/Using_URL_values_for_the_cursor_property

  It's up to you to pick a suitable cursor format that works across the range of browsers you need to support.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * cursor (string) - The CSS to be used when setting the default cursor.

  Returns:  Phaser.Input.InputPlugin - This Input instance."
  ([input-plugin cursor]
   (phaser->clj
    (.setDefaultCursor input-plugin
                       (clj->phaser cursor)))))

(defn set-drag-state
  "Sets the drag state of the given Pointer for this Input Plugin.

  The state must be one of the following values:

  0 = Not dragging anything
  1 = Primary button down and objects below, so collect a draglist
  2 = Pointer being checked if meets drag criteria
  3 = Pointer meets criteria, notify the draglist
  4 = Pointer actively dragging the draglist and has moved
  5 = Pointer actively dragging but has been released, notify draglist

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * pointer (Phaser.Input.Pointer) - The Pointer to set the drag state for.
    * state (integer) - The drag state value. An integer between 0 and 5."
  ([input-plugin pointer state]
   (phaser->clj
    (.setDragState input-plugin
                   (clj->phaser pointer)
                   (clj->phaser state)))))

(defn set-draggable
  "Sets the draggable state of the given array of Game Objects.

  They can either be set to be draggable, or can have their draggable state removed by passing `false`.

  A Game Object will not fire drag events unless it has been specifically enabled for drag.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-objects (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to change the draggable state on.
    * value (boolean) {optional} - Set to `true` if the Game Objects should be made draggable, `false` if they should be unset.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin game-objects]
   (phaser->clj
    (.setDraggable input-plugin
                   (clj->phaser game-objects))))
  ([input-plugin game-objects value]
   (phaser->clj
    (.setDraggable input-plugin
                   (clj->phaser game-objects)
                   (clj->phaser value)))))

(defn set-global-top-only
  "When set to `true` the global Input Manager will emulate DOM behavior by only emitting events from
  the top-most Scene in the Scene List. By default, if a Scene receives an input event it will then stop the event
  from flowing down to any Scenes below it in the Scene list. To disable this behavior call this method with `false`.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * value (boolean) - Set to `true` to stop processing input events on the Scene that receives it, or `false` to let the event continue down the Scene list.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin value]
   (phaser->clj
    (.setGlobalTopOnly input-plugin
                       (clj->phaser value)))))

(defn set-hit-area
  "Sets the hit area for the given array of Game Objects.

  A hit area is typically one of the geometric shapes Phaser provides, such as a `Phaser.Geom.Rectangle`
  or `Phaser.Geom.Circle`. However, it can be any object as long as it works with the provided callback.

  If no hit area is provided a Rectangle is created based on the size of the Game Object, if possible
  to calculate.

  The hit area callback is the function that takes an `x` and `y` coordinate and returns a boolean if
  those values fall within the area of the shape or not. All of the Phaser geometry objects provide this,
  such as `Phaser.Geom.Rectangle.Contains`.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-objects (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to set the hit area on.
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - The 'contains' function to invoke to check if the pointer is within the hit area.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin game-objects]
   (phaser->clj
    (.setHitArea input-plugin
                 (clj->phaser game-objects))))
  ([input-plugin game-objects shape]
   (phaser->clj
    (.setHitArea input-plugin
                 (clj->phaser game-objects)
                 (clj->phaser shape))))
  ([input-plugin game-objects shape callback]
   (phaser->clj
    (.setHitArea input-plugin
                 (clj->phaser game-objects)
                 (clj->phaser shape)
                 (clj->phaser callback)))))

(defn set-hit-area-circle
  "Sets the hit area for an array of Game Objects to be a `Phaser.Geom.Circle` shape, using
  the given coordinates and radius to control its position and size.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-objects (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to set as having a circle hit area.
    * x (number) - The center of the circle.
    * y (number) - The center of the circle.
    * radius (number) - The radius of the circle.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - The hit area callback. If undefined it uses Circle.Contains.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin game-objects x y radius]
   (phaser->clj
    (.setHitAreaCircle input-plugin
                       (clj->phaser game-objects)
                       (clj->phaser x)
                       (clj->phaser y)
                       (clj->phaser radius))))
  ([input-plugin game-objects x y radius callback]
   (phaser->clj
    (.setHitAreaCircle input-plugin
                       (clj->phaser game-objects)
                       (clj->phaser x)
                       (clj->phaser y)
                       (clj->phaser radius)
                       (clj->phaser callback)))))

(defn set-hit-area-ellipse
  "Sets the hit area for an array of Game Objects to be a `Phaser.Geom.Ellipse` shape, using
  the given coordinates and dimensions to control its position and size.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-objects (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to set as having an ellipse hit area.
    * x (number) - The center of the ellipse.
    * y (number) - The center of the ellipse.
    * width (number) - The width of the ellipse.
    * height (number) - The height of the ellipse.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - The hit area callback. If undefined it uses Ellipse.Contains.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin game-objects x y width height]
   (phaser->clj
    (.setHitAreaEllipse input-plugin
                        (clj->phaser game-objects)
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height))))
  ([input-plugin game-objects x y width height callback]
   (phaser->clj
    (.setHitAreaEllipse input-plugin
                        (clj->phaser game-objects)
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)
                        (clj->phaser callback)))))

(defn set-hit-area-from-texture
  "Sets the hit area for an array of Game Objects to be a `Phaser.Geom.Rectangle` shape, using
  the Game Objects texture frame to define the position and size of the hit area.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-objects (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to set as having an ellipse hit area.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - The hit area callback. If undefined it uses Rectangle.Contains.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin game-objects]
   (phaser->clj
    (.setHitAreaFromTexture input-plugin
                            (clj->phaser game-objects))))
  ([input-plugin game-objects callback]
   (phaser->clj
    (.setHitAreaFromTexture input-plugin
                            (clj->phaser game-objects)
                            (clj->phaser callback)))))

(defn set-hit-area-rectangle
  "Sets the hit area for an array of Game Objects to be a `Phaser.Geom.Rectangle` shape, using
  the given coordinates and dimensions to control its position and size.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-objects (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to set as having a rectangular hit area.
    * x (number) - The top-left of the rectangle.
    * y (number) - The top-left of the rectangle.
    * width (number) - The width of the rectangle.
    * height (number) - The height of the rectangle.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - The hit area callback. If undefined it uses Rectangle.Contains.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin game-objects x y width height]
   (phaser->clj
    (.setHitAreaRectangle input-plugin
                          (clj->phaser game-objects)
                          (clj->phaser x)
                          (clj->phaser y)
                          (clj->phaser width)
                          (clj->phaser height))))
  ([input-plugin game-objects x y width height callback]
   (phaser->clj
    (.setHitAreaRectangle input-plugin
                          (clj->phaser game-objects)
                          (clj->phaser x)
                          (clj->phaser y)
                          (clj->phaser width)
                          (clj->phaser height)
                          (clj->phaser callback)))))

(defn set-hit-area-triangle
  "Sets the hit area for an array of Game Objects to be a `Phaser.Geom.Triangle` shape, using
  the given coordinates to control the position of its points.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-objects (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to set as having a  triangular hit area.
    * x-1 (number) - The x coordinate of the first point of the triangle.
    * y-1 (number) - The y coordinate of the first point of the triangle.
    * x-2 (number) - The x coordinate of the second point of the triangle.
    * y-2 (number) - The y coordinate of the second point of the triangle.
    * x-3 (number) - The x coordinate of the third point of the triangle.
    * y-3 (number) - The y coordinate of the third point of the triangle.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - The hit area callback. If undefined it uses Triangle.Contains.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin game-objects x-1 y-1 x-2 y-2 x-3 y-3]
   (phaser->clj
    (.setHitAreaTriangle input-plugin
                         (clj->phaser game-objects)
                         (clj->phaser x-1)
                         (clj->phaser y-1)
                         (clj->phaser x-2)
                         (clj->phaser y-2)
                         (clj->phaser x-3)
                         (clj->phaser y-3))))
  ([input-plugin game-objects x-1 y-1 x-2 y-2 x-3 y-3 callback]
   (phaser->clj
    (.setHitAreaTriangle input-plugin
                         (clj->phaser game-objects)
                         (clj->phaser x-1)
                         (clj->phaser y-1)
                         (clj->phaser x-2)
                         (clj->phaser y-2)
                         (clj->phaser x-3)
                         (clj->phaser y-3)
                         (clj->phaser callback)))))

(defn set-poll-always
  "Sets the Pointers to always poll.

  When a pointer is polled it runs a hit test to see which Game Objects are currently below it,
  or being interacted with it, regardless if the Pointer has actually moved or not.

  You should enable this if you want objects in your game to fire over / out events, and the objects
  are constantly moving, but the pointer may not have. Polling every frame has additional computation
  costs, especially if there are a large number of interactive objects in your game.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin]
   (phaser->clj
    (.setPollAlways input-plugin))))

(defn set-poll-on-move
  "Sets the Pointers to only poll when they are moved or updated.

  When a pointer is polled it runs a hit test to see which Game Objects are currently below it,
  or being interacted with it.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin]
   (phaser->clj
    (.setPollOnMove input-plugin))))

(defn set-poll-rate
  "Sets the poll rate value. This is the amount of time that should have elapsed before a pointer
  will be polled again. See the `setPollAlways` and `setPollOnMove` methods.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * value (number) - The amount of time, in ms, that should elapsed before re-polling the pointers.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin value]
   (phaser->clj
    (.setPollRate input-plugin
                  (clj->phaser value)))))

(defn set-top-only
  "When set to `true` this Input Plugin will emulate DOM behavior by only emitting events from
  the top-most Game Objects in the Display List.

  If set to `false` it will emit events from all Game Objects below a Pointer, not just the top one.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * value (boolean) - `true` to only include the top-most Game Object, or `false` to include all Game Objects in a hit test.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin value]
   (phaser->clj
    (.setTopOnly input-plugin
                 (clj->phaser value)))))

(defn sort-game-objects
  "Given an array of Game Objects, sort the array and return it, so that the objects are in depth index order
  with the lowest at the bottom.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * game-objects (Array.<Phaser.GameObjects.GameObject>) - An array of Game Objects to be sorted.

  Returns:  Array.<Phaser.GameObjects.GameObject> - The sorted array of Game Objects."
  ([input-plugin game-objects]
   (phaser->clj
    (.sortGameObjects input-plugin
                      (clj->phaser game-objects)))))

(defn stop-propagation
  "This method should be called from within an input event handler, such as `pointerdown`.

  When called, it stops the Input Manager from allowing _this specific event_ to be processed by any other Scene
  not yet handled in the scene list.

  Returns:  Phaser.Input.InputPlugin - This InputPlugin object."
  ([input-plugin]
   (phaser->clj
    (.stopPropagation input-plugin))))

(defn update-poll
  "This is called automatically by the Input Manager.
  It emits events for plugins to listen to and also handles polling updates, if enabled.

  Parameters:
    * input-plugin (Phaser.Input.InputPlugin) - Targeted instance for method
    * time (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate.

  Returns:  boolean - `true` if the plugin and the Scene it belongs to is active."
  ([input-plugin time delta]
   (phaser->clj
    (.updatePoll input-plugin
                 (clj->phaser time)
                 (clj->phaser delta)))))