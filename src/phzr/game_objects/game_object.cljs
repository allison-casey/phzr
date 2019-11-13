(ns phzr.game-objects.game-object
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->GameObject
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs.
    * type (string) - A textual representation of the type of Game Object, i.e. `sprite`."
  ([scene type]
   (js/Phaser.GameObjects.GameObject. (clj->phaser scene)
                                      (clj->phaser type))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([game-object event fn]
   (phaser->clj
    (.addListener game-object
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([game-object event fn context]
   (phaser->clj
    (.addListener game-object
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
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([game-object]
   (phaser->clj
    (.destroy game-object)))
  ([game-object from-scene]
   (phaser->clj
    (.destroy game-object
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([game-object]
   (phaser->clj
    (.disableInteractive game-object))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([game-object event]
   (phaser->clj
    (.emit game-object
           (clj->phaser event))))
  ([game-object event args]
   (phaser->clj
    (.emit game-object
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([game-object]
   (phaser->clj
    (.eventNames game-object))))

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
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([game-object key]
   (phaser->clj
    (.getData game-object
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([game-object]
   (phaser->clj
    (.getIndexList game-object))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([game-object event]
   (phaser->clj
    (.listenerCount game-object
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([game-object event]
   (phaser->clj
    (.listeners game-object
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([game-object event]
   (phaser->clj
    (.off game-object
          (clj->phaser event))))
  ([game-object event fn]
   (phaser->clj
    (.off game-object
          (clj->phaser event)
          (clj->phaser fn))))
  ([game-object event fn context]
   (phaser->clj
    (.off game-object
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([game-object event fn context once]
   (phaser->clj
    (.off game-object
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([game-object event fn]
   (phaser->clj
    (.on game-object
         (clj->phaser event)
         (clj->phaser fn))))
  ([game-object event fn context]
   (phaser->clj
    (.on game-object
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([game-object event fn]
   (phaser->clj
    (.once game-object
           (clj->phaser event)
           (clj->phaser fn))))
  ([game-object event fn context]
   (phaser->clj
    (.once game-object
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([game-object]
   (phaser->clj
    (.removeAllListeners game-object)))
  ([game-object event]
   (phaser->clj
    (.removeAllListeners game-object
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
  ([game-object]
   (phaser->clj
    (.removeInteractive game-object))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([game-object event]
   (phaser->clj
    (.removeListener game-object
                     (clj->phaser event))))
  ([game-object event fn]
   (phaser->clj
    (.removeListener game-object
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([game-object event fn context]
   (phaser->clj
    (.removeListener game-object
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([game-object event fn context once]
   (phaser->clj
    (.removeListener game-object
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([game-object value]
   (phaser->clj
    (.setActive game-object
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
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([game-object key]
   (phaser->clj
    (.setData game-object
              (clj->phaser key))))
  ([game-object key data]
   (phaser->clj
    (.setData game-object
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([game-object]
   (phaser->clj
    (.setDataEnabled game-object))))

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
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([game-object]
   (phaser->clj
    (.setInteractive game-object)))
  ([game-object shape]
   (phaser->clj
    (.setInteractive game-object
                     (clj->phaser shape))))
  ([game-object shape callback]
   (phaser->clj
    (.setInteractive game-object
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([game-object shape callback drop-zone]
   (phaser->clj
    (.setInteractive game-object
                     (clj->phaser shape)
                     (clj->phaser callback)
                     (clj->phaser drop-zone)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([game-object value]
   (phaser->clj
    (.setName game-object
              (clj->phaser value)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([game-object value]
   (phaser->clj
    (.setState game-object
               (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([game-object]
   (phaser->clj
    (.shutdown game-object))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([game-object]
   (phaser->clj
    (.toJSON game-object))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * args (*) {optional} - args"
  ([game-object]
   (phaser->clj
    (.update game-object)))
  ([game-object args]
   (phaser->clj
    (.update game-object
             (clj->phaser args)))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * game-object (Phaser.GameObjects.GameObject) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([game-object camera]
   (phaser->clj
    (.willRender game-object
                 (clj->phaser camera)))))