(ns phzr.game-objects.zone
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Zone
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs.
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * width (number) {optional} - The width of the Game Object.
    * height (number) {optional} - The height of the Game Object."
  ([scene x y]
   (js/Phaser.GameObjects.Zone. (clj->phaser scene)
                                (clj->phaser x)
                                (clj->phaser y)))
  ([scene x y width]
   (js/Phaser.GameObjects.Zone. (clj->phaser scene)
                                (clj->phaser x)
                                (clj->phaser y)
                                (clj->phaser width)))
  ([scene x y width height]
   (js/Phaser.GameObjects.Zone. (clj->phaser scene)
                                (clj->phaser x)
                                (clj->phaser y)
                                (clj->phaser width)
                                (clj->phaser height))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([zone event fn]
   (phaser->clj
    (.addListener zone
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([zone event fn context]
   (phaser->clj
    (.addListener zone
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

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
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([zone]
   (phaser->clj
    (.destroy zone)))
  ([zone from-scene]
   (phaser->clj
    (.destroy zone
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([zone]
   (phaser->clj
    (.disableInteractive zone))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([zone event]
   (phaser->clj
    (.emit zone
           (clj->phaser event))))
  ([zone event args]
   (phaser->clj
    (.emit zone
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([zone]
   (phaser->clj
    (.eventNames zone))))

(defn get-bottom-center
  "Gets the bottom-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getBottomCenter zone)))
  ([zone output]
   (phaser->clj
    (.getBottomCenter zone
                      (clj->phaser output))))
  ([zone output include-parent]
   (phaser->clj
    (.getBottomCenter zone
                      (clj->phaser output)
                      (clj->phaser include-parent)))))

(defn get-bottom-left
  "Gets the bottom-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getBottomLeft zone)))
  ([zone output]
   (phaser->clj
    (.getBottomLeft zone
                    (clj->phaser output))))
  ([zone output include-parent]
   (phaser->clj
    (.getBottomLeft zone
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-bottom-right
  "Gets the bottom-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getBottomRight zone)))
  ([zone output]
   (phaser->clj
    (.getBottomRight zone
                     (clj->phaser output))))
  ([zone output include-parent]
   (phaser->clj
    (.getBottomRight zone
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-bounds
  "Gets the bounds of this Game Object, regardless of origin.
  The values are stored and returned in a Rectangle, or Rectangle-like, object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Geom.Rectangle | object) {optional} - An object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getBounds zone)))
  ([zone output]
   (phaser->clj
    (.getBounds zone
                (clj->phaser output)))))

(defn get-center
  "Gets the center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getCenter zone)))
  ([zone output]
   (phaser->clj
    (.getCenter zone
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
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([zone key]
   (phaser->clj
    (.getData zone
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([zone]
   (phaser->clj
    (.getIndexList zone))))

(defn get-left-center
  "Gets the left-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getLeftCenter zone)))
  ([zone output]
   (phaser->clj
    (.getLeftCenter zone
                    (clj->phaser output))))
  ([zone output include-parent]
   (phaser->clj
    (.getLeftCenter zone
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([zone]
   (phaser->clj
    (.getLocalTransformMatrix zone)))
  ([zone temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix zone
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([zone]
   (phaser->clj
    (.getParentRotation zone))))

(defn get-right-center
  "Gets the right-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getRightCenter zone)))
  ([zone output]
   (phaser->clj
    (.getRightCenter zone
                     (clj->phaser output))))
  ([zone output include-parent]
   (phaser->clj
    (.getRightCenter zone
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-top-center
  "Gets the top-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getTopCenter zone)))
  ([zone output]
   (phaser->clj
    (.getTopCenter zone
                   (clj->phaser output))))
  ([zone output include-parent]
   (phaser->clj
    (.getTopCenter zone
                   (clj->phaser output)
                   (clj->phaser include-parent)))))

(defn get-top-left
  "Gets the top-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getTopLeft zone)))
  ([zone output]
   (phaser->clj
    (.getTopLeft zone
                 (clj->phaser output))))
  ([zone output include-parent]
   (phaser->clj
    (.getTopLeft zone
                 (clj->phaser output)
                 (clj->phaser include-parent)))))

(defn get-top-right
  "Gets the top-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([zone]
   (phaser->clj
    (.getTopRight zone)))
  ([zone output]
   (phaser->clj
    (.getTopRight zone
                  (clj->phaser output))))
  ([zone output include-parent]
   (phaser->clj
    (.getTopRight zone
                  (clj->phaser output)
                  (clj->phaser include-parent)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([zone]
   (phaser->clj
    (.getWorldTransformMatrix zone)))
  ([zone temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix zone
                              (clj->phaser temp-matrix))))
  ([zone temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix zone
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([zone event]
   (phaser->clj
    (.listenerCount zone
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([zone event]
   (phaser->clj
    (.listeners zone
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([zone event]
   (phaser->clj
    (.off zone
          (clj->phaser event))))
  ([zone event fn]
   (phaser->clj
    (.off zone
          (clj->phaser event)
          (clj->phaser fn))))
  ([zone event fn context]
   (phaser->clj
    (.off zone
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([zone event fn context once]
   (phaser->clj
    (.off zone
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([zone event fn]
   (phaser->clj
    (.on zone
         (clj->phaser event)
         (clj->phaser fn))))
  ([zone event fn context]
   (phaser->clj
    (.on zone
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([zone event fn]
   (phaser->clj
    (.once zone
           (clj->phaser event)
           (clj->phaser fn))))
  ([zone event fn context]
   (phaser->clj
    (.once zone
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([zone]
   (phaser->clj
    (.removeAllListeners zone)))
  ([zone event]
   (phaser->clj
    (.removeAllListeners zone
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
  ([zone]
   (phaser->clj
    (.removeInteractive zone))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([zone event]
   (phaser->clj
    (.removeListener zone
                     (clj->phaser event))))
  ([zone event fn]
   (phaser->clj
    (.removeListener zone
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([zone event fn context]
   (phaser->clj
    (.removeListener zone
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([zone event fn context once]
   (phaser->clj
    (.removeListener zone
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([zone value]
   (phaser->clj
    (.setActive zone
                (clj->phaser value)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setAngle zone)))
  ([zone degrees]
   (phaser->clj
    (.setAngle zone
               (clj->phaser degrees)))))

(defn set-circle-drop-zone
  "Sets this Zone to be a Circular Drop Zone.
  The circle is centered on this Zones `x` and `y` coordinates.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * radius (number) - The radius of the Circle that will form the Drop Zone.

  Returns:  Phaser.GameObjects.Zone - This Game Object."
  ([zone radius]
   (phaser->clj
    (.setCircleDropZone zone
                        (clj->phaser radius)))))

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
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([zone key]
   (phaser->clj
    (.setData zone
              (clj->phaser key))))
  ([zone key data]
   (phaser->clj
    (.setData zone
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([zone]
   (phaser->clj
    (.setDataEnabled zone))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([zone value]
   (phaser->clj
    (.setDepth zone
               (clj->phaser value)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setDisplayOrigin zone)))
  ([zone x]
   (phaser->clj
    (.setDisplayOrigin zone
                       (clj->phaser x))))
  ([zone x y]
   (phaser->clj
    (.setDisplayOrigin zone
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-display-size
  "Sets the display size of this Game Object.
  Calling this will adjust the scale.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  Phaser.GameObjects.Zone - This Game Object."
  ([zone width height]
   (phaser->clj
    (.setDisplaySize zone
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-drop-zone
  "Allows you to define your own Geometry shape to be used as a Drop Zone.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * shape (object) - A Geometry shape instance, such as Phaser.Geom.Ellipse, or your own custom shape.
    * callback (Phaser.Types.Input.HitAreaCallback) - A function that will return `true` if the given x/y coords it is sent are within the shape.

  Returns:  Phaser.GameObjects.Zone - This Game Object."
  ([zone shape callback]
   (phaser->clj
    (.setDropZone zone
                  (clj->phaser shape)
                  (clj->phaser callback)))))

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
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([zone]
   (phaser->clj
    (.setInteractive zone)))
  ([zone shape]
   (phaser->clj
    (.setInteractive zone
                     (clj->phaser shape))))
  ([zone shape callback]
   (phaser->clj
    (.setInteractive zone
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([zone shape callback drop-zone]
   (phaser->clj
    (.setInteractive zone
                     (clj->phaser shape)
                     (clj->phaser callback)
                     (clj->phaser drop-zone)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([zone value]
   (phaser->clj
    (.setName zone
              (clj->phaser value)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setOrigin zone)))
  ([zone x]
   (phaser->clj
    (.setOrigin zone
                (clj->phaser x))))
  ([zone x y]
   (phaser->clj
    (.setOrigin zone
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setOriginFromFrame zone))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setPosition zone)))
  ([zone x]
   (phaser->clj
    (.setPosition zone
                  (clj->phaser x))))
  ([zone x y]
   (phaser->clj
    (.setPosition zone
                  (clj->phaser x)
                  (clj->phaser y))))
  ([zone x y z]
   (phaser->clj
    (.setPosition zone
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([zone x y z w]
   (phaser->clj
    (.setPosition zone
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
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setRandomPosition zone)))
  ([zone x]
   (phaser->clj
    (.setRandomPosition zone
                        (clj->phaser x))))
  ([zone x y]
   (phaser->clj
    (.setRandomPosition zone
                        (clj->phaser x)
                        (clj->phaser y))))
  ([zone x y width]
   (phaser->clj
    (.setRandomPosition zone
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([zone x y width height]
   (phaser->clj
    (.setRandomPosition zone
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rectangle-drop-zone
  "Sets this Zone to be a Rectangle Drop Zone.
  The rectangle is centered on this Zones `x` and `y` coordinates.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * width (number) - The width of the rectangle drop zone.
    * height (number) - The height of the rectangle drop zone.

  Returns:  Phaser.GameObjects.Zone - This Game Object."
  ([zone width height]
   (phaser->clj
    (.setRectangleDropZone zone
                           (clj->phaser width)
                           (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setRotation zone)))
  ([zone radians]
   (phaser->clj
    (.setRotation zone
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([zone x]
   (phaser->clj
    (.setScale zone
               (clj->phaser x))))
  ([zone x y]
   (phaser->clj
    (.setScale zone
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
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([zone x]
   (phaser->clj
    (.setScrollFactor zone
                      (clj->phaser x))))
  ([zone x y]
   (phaser->clj
    (.setScrollFactor zone
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-size
  "Sets the size of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.
    * resize-input (boolean) {optional} - If this Zone has a Rectangle for a hit area this argument will resize the hit area as well.

  Returns:  Phaser.GameObjects.Zone - This Game Object."
  ([zone width height]
   (phaser->clj
    (.setSize zone
              (clj->phaser width)
              (clj->phaser height))))
  ([zone width height resize-input]
   (phaser->clj
    (.setSize zone
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser resize-input)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([zone value]
   (phaser->clj
    (.setState zone
               (clj->phaser value)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([zone value]
   (phaser->clj
    (.setVisible zone
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setW zone)))
  ([zone value]
   (phaser->clj
    (.setW zone
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setX zone)))
  ([zone value]
   (phaser->clj
    (.setX zone
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setY zone)))
  ([zone value]
   (phaser->clj
    (.setY zone
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.setZ zone)))
  ([zone value]
   (phaser->clj
    (.setZ zone
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([zone]
   (phaser->clj
    (.shutdown zone))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([zone]
   (phaser->clj
    (.toJSON zone))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * args (*) {optional} - args"
  ([zone]
   (phaser->clj
    (.update zone)))
  ([zone args]
   (phaser->clj
    (.update zone
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([zone]
   (phaser->clj
    (.updateDisplayOrigin zone))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * zone (Phaser.GameObjects.Zone) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([zone camera]
   (phaser->clj
    (.willRender zone
                 (clj->phaser camera)))))