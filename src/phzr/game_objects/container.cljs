(ns phzr.game-objects.container
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [sort count remove reverse shuffle replace iterate update]))

(defn ->Container
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs. A Game Object can only belong to one Scene at a time.
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * children (Array.<Phaser.GameObjects.GameObject>) {optional} - An optional array of Game Objects to add to this Container."
  ([scene]
   (js/Phaser.GameObjects.Container. (clj->phaser scene)))
  ([scene x]
   (js/Phaser.GameObjects.Container. (clj->phaser scene)
                                     (clj->phaser x)))
  ([scene x y]
   (js/Phaser.GameObjects.Container. (clj->phaser scene)
                                     (clj->phaser x)
                                     (clj->phaser y)))
  ([scene x y children]
   (js/Phaser.GameObjects.Container. (clj->phaser scene)
                                     (clj->phaser x)
                                     (clj->phaser y)
                                     (clj->phaser children))))

(defn add
  "Adds the given Game Object, or array of Game Objects, to this Container.

  Each Game Object must be unique within the Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - The Game Object, or array of Game Objects, to add to the Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child]
   (phaser->clj
    (.add container
          (clj->phaser child)))))

(defn add-at
  "Adds the given Game Object, or array of Game Objects, to this Container at the specified position.

  Existing Game Objects in the Container are shifted up.

  Each Game Object must be unique within the Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - The Game Object, or array of Game Objects, to add to the Container.
    * index (integer) {optional} - The position to insert the Game Object/s at.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child]
   (phaser->clj
    (.addAt container
            (clj->phaser child))))
  ([container child index]
   (phaser->clj
    (.addAt container
            (clj->phaser child)
            (clj->phaser index)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([container event fn]
   (phaser->clj
    (.addListener container
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([container event fn context]
   (phaser->clj
    (.addListener container
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn bring-to-top
  "Brings the given Game Object to the top of this Container.
  This will cause it to render on-top of any other objects in the Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to bring to the top of the Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child]
   (phaser->clj
    (.bringToTop container
                 (clj->phaser child)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.clearAlpha container))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.clearMask container)))
  ([container destroy-mask]
   (phaser->clj
    (.clearMask container
                (clj->phaser destroy-mask)))))

(defn count
  "Returns the total number of Game Objects in this Container that have a property
  matching the given value.

  For example: `count('visible', true)` would count all the elements that have their visible property set.

  You can optionally limit the operation to the `startIndex` - `endIndex` range.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * property (string) - The property to check.
    * value (any) - The value to check.
    * start-index (integer) {optional} - An optional start index to search from.
    * end-index (integer) {optional} - An optional end index to search up to (but not included)

  Returns:  integer - The total number of Game Objects in this Container with a property matching the given value."
  ([container property value]
   (phaser->clj
    (.count container
            (clj->phaser property)
            (clj->phaser value))))
  ([container property value start-index]
   (phaser->clj
    (.count container
            (clj->phaser property)
            (clj->phaser value)
            (clj->phaser start-index))))
  ([container property value start-index end-index]
   (phaser->clj
    (.count container
            (clj->phaser property)
            (clj->phaser value)
            (clj->phaser start-index)
            (clj->phaser end-index)))))

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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([container]
   (phaser->clj
    (.createBitmapMask container)))
  ([container renderable]
   (phaser->clj
    (.createBitmapMask container
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([container]
   (phaser->clj
    (.createGeometryMask container)))
  ([container graphics]
   (phaser->clj
    (.createGeometryMask container
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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([container]
   (phaser->clj
    (.destroy container)))
  ([container from-scene]
   (phaser->clj
    (.destroy container
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([container]
   (phaser->clj
    (.disableInteractive container))))

(defn each
  "Passes all Game Objects in this Container to the given callback.

  A copy of the Container is made before passing each entry to your callback.
  This protects against the callback itself modifying the Container.

  If you know for sure that the callback will not change the size of this Container
  then you can use the more performant `Container.iterate` method instead.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * callback (function) - The function to call.
    * context (object) {optional} - Value to use as `this` when executing callback.
    * args (*) {optional} - Additional arguments that will be passed to the callback, after the child.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container callback]
   (phaser->clj
    (.each container
           (clj->phaser callback))))
  ([container callback context]
   (phaser->clj
    (.each container
           (clj->phaser callback)
           (clj->phaser context))))
  ([container callback context args]
   (phaser->clj
    (.each container
           (clj->phaser callback)
           (clj->phaser context)
           (clj->phaser args)))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([container event]
   (phaser->clj
    (.emit container
           (clj->phaser event))))
  ([container event args]
   (phaser->clj
    (.emit container
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([container]
   (phaser->clj
    (.eventNames container))))

(defn exists
  "Returns `true` if the given Game Object is a direct child of this Container.

  This check does not scan nested Containers.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to check for within this Container.

  Returns:  boolean - True if the Game Object is an immediate child of this Container, otherwise false."
  ([container child]
   (phaser->clj
    (.exists container
             (clj->phaser child)))))

(defn get-all
  "Returns all Game Objects in this Container.

  You can optionally specify a matching criteria using the `property` and `value` arguments.

  For example: `getAll('body')` would return only Game Objects that have a body property.

  You can also specify a value to compare the property to:

  `getAll('visible', true)` would return only Game Objects that have their visible property set to `true`.

  Optionally you can specify a start and end index. For example if this Container had 100 Game Objects,
  and you set `startIndex` to 0 and `endIndex` to 50, it would return matches from only
  the first 50 Game Objects.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * property (string) {optional} - The property to test on each Game Object in the Container.
    * value (any) {optional} - If property is set then the `property` must strictly equal this value to be included in the results.
    * start-index (integer) {optional} - An optional start index to search from.
    * end-index (integer) {optional} - An optional end index to search up to (but not included)

  Returns:  Array.<Phaser.GameObjects.GameObject> - An array of matching Game Objects from this Container."
  ([container]
   (phaser->clj
    (.getAll container)))
  ([container property]
   (phaser->clj
    (.getAll container
             (clj->phaser property))))
  ([container property value]
   (phaser->clj
    (.getAll container
             (clj->phaser property)
             (clj->phaser value))))
  ([container property value start-index]
   (phaser->clj
    (.getAll container
             (clj->phaser property)
             (clj->phaser value)
             (clj->phaser start-index))))
  ([container property value start-index end-index]
   (phaser->clj
    (.getAll container
             (clj->phaser property)
             (clj->phaser value)
             (clj->phaser start-index)
             (clj->phaser end-index)))))

(defn get-at
  "Returns the Game Object at the given position in this Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * index (integer) - The position to get the Game Object from.

  Returns:  Phaser.GameObjects.GameObject - The Game Object at the specified index, or `null` if none found."
  ([container index]
   (phaser->clj
    (.getAt container
            (clj->phaser index)))))

(defn get-bounds
  "Gets the bounds of this Container. It works by iterating all children of the Container,
  getting their respective bounds, and then working out a min-max rectangle from that.
  It does not factor in if the children render or not, all are included.

  Some children are unable to return their bounds, such as Graphics objects, in which case
  they are skipped.

  Depending on the quantity of children in this Container it could be a really expensive call,
  so cache it and only poll it as needed.

  The values are stored and returned in a Rectangle object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * output (Phaser.Geom.Rectangle) {optional} - A Geom.Rectangle object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle - The values stored in the output object."
  ([container]
   (phaser->clj
    (.getBounds container)))
  ([container output]
   (phaser->clj
    (.getBounds container
                (clj->phaser output)))))

(defn get-bounds-transform-matrix
  "Returns the world transform matrix as used for Bounds checks.

  The returned matrix is temporal and shouldn't be stored.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The world transform matrix."
  ([container]
   (phaser->clj
    (.getBoundsTransformMatrix container))))

(defn get-by-name
  "Searches for the first instance of a child with its `name` property matching the given argument.
  Should more than one child have the same name only the first is returned.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * name (string) - The name to search for.

  Returns:  Phaser.GameObjects.GameObject - The first child with a matching name, or `null` if none were found."
  ([container name]
   (phaser->clj
    (.getByName container
                (clj->phaser name)))))

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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([container key]
   (phaser->clj
    (.getData container
              (clj->phaser key)))))

(defn get-first
  "Gets the first Game Object in this Container.

  You can also specify a property and value to search for, in which case it will return the first
  Game Object in this Container with a matching property and / or value.

  For example: `getFirst('visible', true)` would return the first Game Object that had its `visible` property set.

  You can limit the search to the `startIndex` - `endIndex` range.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * property (string) - The property to test on each Game Object in the Container.
    * value (*) - The value to test the property against. Must pass a strict (`===`) comparison check.
    * start-index (integer) {optional} - An optional start index to search from.
    * end-index (integer) {optional} - An optional end index to search up to (but not included)

  Returns:  Phaser.GameObjects.GameObject - The first matching Game Object, or `null` if none was found."
  ([container property value]
   (phaser->clj
    (.getFirst container
               (clj->phaser property)
               (clj->phaser value))))
  ([container property value start-index]
   (phaser->clj
    (.getFirst container
               (clj->phaser property)
               (clj->phaser value)
               (clj->phaser start-index))))
  ([container property value start-index end-index]
   (phaser->clj
    (.getFirst container
               (clj->phaser property)
               (clj->phaser value)
               (clj->phaser start-index)
               (clj->phaser end-index)))))

(defn get-index
  "Returns the index of the given Game Object in this Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to search for in this Container.

  Returns:  integer - The index of the Game Object in this Container, or -1 if not found."
  ([container child]
   (phaser->clj
    (.getIndex container
               (clj->phaser child)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([container]
   (phaser->clj
    (.getIndexList container))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([container]
   (phaser->clj
    (.getLocalTransformMatrix container)))
  ([container temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix container
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([container]
   (phaser->clj
    (.getParentRotation container))))

(defn get-random
  "Returns a random Game Object from this Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * start-index (integer) {optional} - An optional start index.
    * length (integer) {optional} - An optional length, the total number of elements (from the startIndex) to choose from.

  Returns:  Phaser.GameObjects.GameObject - A random child from the Container, or `null` if the Container is empty."
  ([container]
   (phaser->clj
    (.getRandom container)))
  ([container start-index]
   (phaser->clj
    (.getRandom container
                (clj->phaser start-index))))
  ([container start-index length]
   (phaser->clj
    (.getRandom container
                (clj->phaser start-index)
                (clj->phaser length)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([container]
   (phaser->clj
    (.getWorldTransformMatrix container)))
  ([container temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix container
                              (clj->phaser temp-matrix))))
  ([container temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix container
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn iterate
  "Passes all Game Objects in this Container to the given callback.

  Only use this method when you absolutely know that the Container will not be modified during
  the iteration, i.e. by removing or adding to its contents.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * callback (function) - The function to call.
    * context (object) {optional} - Value to use as `this` when executing callback.
    * args (*) {optional} - Additional arguments that will be passed to the callback, after the child.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container callback]
   (phaser->clj
    (.iterate container
              (clj->phaser callback))))
  ([container callback context]
   (phaser->clj
    (.iterate container
              (clj->phaser callback)
              (clj->phaser context))))
  ([container callback context args]
   (phaser->clj
    (.iterate container
              (clj->phaser callback)
              (clj->phaser context)
              (clj->phaser args)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([container event]
   (phaser->clj
    (.listenerCount container
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([container event]
   (phaser->clj
    (.listeners container
                (clj->phaser event)))))

(defn move-down
  "Moves the given Game Object down one place in this Container, unless it's already at the bottom.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to be moved in the Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child]
   (phaser->clj
    (.moveDown container
               (clj->phaser child)))))

(defn move-to
  "Moves a Game Object to a new position within this Container.

  The Game Object must already be a child of this Container.

  The Game Object is removed from its old position and inserted into the new one.
  Therefore the Container size does not change. Other children will change position accordingly.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to move.
    * index (integer) - The new position of the Game Object in this Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child index]
   (phaser->clj
    (.moveTo container
             (clj->phaser child)
             (clj->phaser index)))))

(defn move-up
  "Moves the given Game Object up one place in this Container, unless it's already at the top.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to be moved in the Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child]
   (phaser->clj
    (.moveUp container
             (clj->phaser child)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([container event]
   (phaser->clj
    (.off container
          (clj->phaser event))))
  ([container event fn]
   (phaser->clj
    (.off container
          (clj->phaser event)
          (clj->phaser fn))))
  ([container event fn context]
   (phaser->clj
    (.off container
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([container event fn context once]
   (phaser->clj
    (.off container
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([container event fn]
   (phaser->clj
    (.on container
         (clj->phaser event)
         (clj->phaser fn))))
  ([container event fn context]
   (phaser->clj
    (.on container
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([container event fn]
   (phaser->clj
    (.once container
           (clj->phaser event)
           (clj->phaser fn))))
  ([container event fn context]
   (phaser->clj
    (.once container
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn point-to-container
  "Takes a Point-like object, such as a Vector2, Geom.Point or object with public x and y properties,
  and transforms it into the space of this Container, then returns it in the output object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * source (object | Phaser.Geom.Point | Phaser.Math.Vector2) - The Source Point to be transformed.
    * output (object | Phaser.Geom.Point | Phaser.Math.Vector2) {optional} - A destination object to store the transformed point in. If none given a Vector2 will be created and returned.

  Returns:  object | Phaser.Geom.Point | Phaser.Math.Vector2 - The transformed point."
  ([container source]
   (phaser->clj
    (.pointToContainer container
                       (clj->phaser source))))
  ([container source output]
   (phaser->clj
    (.pointToContainer container
                       (clj->phaser source)
                       (clj->phaser output)))))

(defn remove
  "Removes the given Game Object, or array of Game Objects, from this Container.

  The Game Objects must already be children of this Container.

  You can also optionally call `destroy` on each Game Object that is removed from the Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) - The Game Object, or array of Game Objects, to be removed from the Container.
    * destroy-child (boolean) {optional} - Optionally call `destroy` on each child successfully removed from this Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child]
   (phaser->clj
    (.remove container
             (clj->phaser child))))
  ([container child destroy-child]
   (phaser->clj
    (.remove container
             (clj->phaser child)
             (clj->phaser destroy-child)))))

(defn remove-all
  "Removes all Game Objects from this Container.

  You can also optionally call `destroy` on each Game Object that is removed from the Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * destroy-child (boolean) {optional} - Optionally call `destroy` on each Game Object successfully removed from this Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container]
   (phaser->clj
    (.removeAll container)))
  ([container destroy-child]
   (phaser->clj
    (.removeAll container
                (clj->phaser destroy-child)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([container]
   (phaser->clj
    (.removeAllListeners container)))
  ([container event]
   (phaser->clj
    (.removeAllListeners container
                         (clj->phaser event)))))

(defn remove-at
  "Removes the Game Object at the given position in this Container.

  You can also optionally call `destroy` on the Game Object, if one is found.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * index (integer) - The index of the Game Object to be removed.
    * destroy-child (boolean) {optional} - Optionally call `destroy` on the Game Object if successfully removed from this Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container index]
   (phaser->clj
    (.removeAt container
               (clj->phaser index))))
  ([container index destroy-child]
   (phaser->clj
    (.removeAt container
               (clj->phaser index)
               (clj->phaser destroy-child)))))

(defn remove-between
  "Removes the Game Objects between the given positions in this Container.

  You can also optionally call `destroy` on each Game Object that is removed from the Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * start-index (integer) {optional} - An optional start index to search from.
    * end-index (integer) {optional} - An optional end index to search up to (but not included)
    * destroy-child (boolean) {optional} - Optionally call `destroy` on each Game Object successfully removed from this Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container]
   (phaser->clj
    (.removeBetween container)))
  ([container start-index]
   (phaser->clj
    (.removeBetween container
                    (clj->phaser start-index))))
  ([container start-index end-index]
   (phaser->clj
    (.removeBetween container
                    (clj->phaser start-index)
                    (clj->phaser end-index))))
  ([container start-index end-index destroy-child]
   (phaser->clj
    (.removeBetween container
                    (clj->phaser start-index)
                    (clj->phaser end-index)
                    (clj->phaser destroy-child)))))

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
  ([container]
   (phaser->clj
    (.removeInteractive container))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([container event]
   (phaser->clj
    (.removeListener container
                     (clj->phaser event))))
  ([container event fn]
   (phaser->clj
    (.removeListener container
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([container event fn context]
   (phaser->clj
    (.removeListener container
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([container event fn context once]
   (phaser->clj
    (.removeListener container
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn replace
  "Replaces a Game Object in this Container with the new Game Object.
  The new Game Object cannot already be a child of this Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * old-child (Phaser.GameObjects.GameObject) - The Game Object in this Container that will be replaced.
    * new-child (Phaser.GameObjects.GameObject) - The Game Object to be added to this Container.
    * destroy-child (boolean) {optional} - Optionally call `destroy` on the Game Object if successfully removed from this Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container old-child new-child]
   (phaser->clj
    (.replace container
              (clj->phaser old-child)
              (clj->phaser new-child))))
  ([container old-child new-child destroy-child]
   (phaser->clj
    (.replace container
              (clj->phaser old-child)
              (clj->phaser new-child)
              (clj->phaser destroy-child)))))

(defn reverse
  "Reverses the order of all Game Objects in this Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container]
   (phaser->clj
    (.reverse container))))

(defn send-to-back
  "Sends the given Game Object to the bottom of this Container.
  This will cause it to render below any other objects in the Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to send to the bottom of the Container.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child]
   (phaser->clj
    (.sendToBack container
                 (clj->phaser child)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([container value]
   (phaser->clj
    (.setActive container
                (clj->phaser value)))))

(defn set-all
  "Sets the property to the given value on all Game Objects in this Container.

  Optionally you can specify a start and end index. For example if this Container had 100 Game Objects,
  and you set `startIndex` to 0 and `endIndex` to 50, it would return matches from only
  the first 50 Game Objects.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * property (string) - The property that must exist on the Game Object.
    * value (any) - The value to get the property to.
    * start-index (integer) {optional} - An optional start index to search from.
    * end-index (integer) {optional} - An optional end index to search up to (but not included)

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container property value]
   (phaser->clj
    (.setAll container
             (clj->phaser property)
             (clj->phaser value))))
  ([container property value start-index]
   (phaser->clj
    (.setAll container
             (clj->phaser property)
             (clj->phaser value)
             (clj->phaser start-index))))
  ([container property value start-index end-index]
   (phaser->clj
    (.setAll container
             (clj->phaser property)
             (clj->phaser value)
             (clj->phaser start-index)
             (clj->phaser end-index)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setAlpha container)))
  ([container top-left]
   (phaser->clj
    (.setAlpha container
               (clj->phaser top-left))))
  ([container top-left top-right]
   (phaser->clj
    (.setAlpha container
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([container top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha container
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([container top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha container
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setAngle container)))
  ([container degrees]
   (phaser->clj
    (.setAngle container
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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([container value]
   (phaser->clj
    (.setBlendMode container
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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([container key]
   (phaser->clj
    (.setData container
              (clj->phaser key))))
  ([container key data]
   (phaser->clj
    (.setData container
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([container]
   (phaser->clj
    (.setDataEnabled container))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([container value]
   (phaser->clj
    (.setDepth container
               (clj->phaser value)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([container width height]
   (phaser->clj
    (.setDisplaySize container
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-exclusive
  "Does this Container exclusively manage its children?

  The default is `true` which means a child added to this Container cannot
  belong in another Container, which includes the Scene display list.

  If you disable this then this Container will no longer exclusively manage its children.
  This allows you to create all kinds of interesting graphical effects, such as replicating
  Game Objects without reparenting them all over the Scene.
  However, doing so will prevent children from receiving any kind of input event or have
  their physics bodies work by default, as they're no longer a single entity on the
  display list, but are being replicated where-ever this Container is.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (boolean) {optional} - The exclusive state of this Container.

  Returns:  Phaser.GameObjects.Container - This Container."
  ([container]
   (phaser->clj
    (.setExclusive container)))
  ([container value]
   (phaser->clj
    (.setExclusive container
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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([container]
   (phaser->clj
    (.setInteractive container)))
  ([container shape]
   (phaser->clj
    (.setInteractive container
                     (clj->phaser shape))))
  ([container shape callback]
   (phaser->clj
    (.setInteractive container
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([container shape callback drop-zone]
   (phaser->clj
    (.setInteractive container
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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([container mask]
   (phaser->clj
    (.setMask container
              (clj->phaser mask)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([container value]
   (phaser->clj
    (.setName container
              (clj->phaser value)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setPosition container)))
  ([container x]
   (phaser->clj
    (.setPosition container
                  (clj->phaser x))))
  ([container x y]
   (phaser->clj
    (.setPosition container
                  (clj->phaser x)
                  (clj->phaser y))))
  ([container x y z]
   (phaser->clj
    (.setPosition container
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([container x y z w]
   (phaser->clj
    (.setPosition container
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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setRandomPosition container)))
  ([container x]
   (phaser->clj
    (.setRandomPosition container
                        (clj->phaser x))))
  ([container x y]
   (phaser->clj
    (.setRandomPosition container
                        (clj->phaser x)
                        (clj->phaser y))))
  ([container x y width]
   (phaser->clj
    (.setRandomPosition container
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([container x y width height]
   (phaser->clj
    (.setRandomPosition container
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setRotation container)))
  ([container radians]
   (phaser->clj
    (.setRotation container
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([container x]
   (phaser->clj
    (.setScale container
               (clj->phaser x))))
  ([container x y]
   (phaser->clj
    (.setScale container
               (clj->phaser x)
               (clj->phaser y)))))

(defn set-scroll-factor
  "Sets the scroll factor of this Container and optionally all of its children.

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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.
    * update-children (boolean) {optional} - Apply this scrollFactor to all Container children as well?

  Returns:  this - This Game Object instance."
  ([container x]
   (phaser->clj
    (.setScrollFactor container
                      (clj->phaser x))))
  ([container x y]
   (phaser->clj
    (.setScrollFactor container
                      (clj->phaser x)
                      (clj->phaser y))))
  ([container x y update-children]
   (phaser->clj
    (.setScrollFactor container
                      (clj->phaser x)
                      (clj->phaser y)
                      (clj->phaser update-children)))))

(defn set-size
  "Sets the internal size of this Game Object, as used for frame or physics body creation.

  This will not change the size that the Game Object is rendered in-game.
  For that you need to either set the scale of the Game Object (`setScale`) or call the
  `setDisplaySize` method, which is the same thing as changing the scale but allows you
  to do so by giving pixel values.

  If you have enabled this Game Object for input, changing the size will _not_ change the
  size of the hit area. To do this you should adjust the `input.hitArea` object directly.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([container width height]
   (phaser->clj
    (.setSize container
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
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([container value]
   (phaser->clj
    (.setState container
               (clj->phaser value)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([container value]
   (phaser->clj
    (.setVisible container
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setW container)))
  ([container value]
   (phaser->clj
    (.setW container
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setX container)))
  ([container value]
   (phaser->clj
    (.setX container
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setY container)))
  ([container value]
   (phaser->clj
    (.setY container
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([container]
   (phaser->clj
    (.setZ container)))
  ([container value]
   (phaser->clj
    (.setZ container
           (clj->phaser value)))))

(defn shuffle
  "Shuffles the all Game Objects in this Container using the Fisher-Yates implementation.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container]
   (phaser->clj
    (.shuffle container))))

(defn shutdown
  "Removes all listeners."
  ([container]
   (phaser->clj
    (.shutdown container))))

(defn sort
  "Sort the contents of this Container so the items are in order based on the given property.
  For example: `sort('alpha')` would sort the elements based on the value of their `alpha` property.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * property (string) - The property to lexically sort by.
    * handler (function) {optional} - Provide your own custom handler function. Will receive 2 children which it should compare and return a boolean.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container property]
   (phaser->clj
    (.sort container
           (clj->phaser property))))
  ([container property handler]
   (phaser->clj
    (.sort container
           (clj->phaser property)
           (clj->phaser handler)))))

(defn swap
  "Swaps the position of two Game Objects in this Container.
  Both Game Objects must belong to this Container.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * child-1 (Phaser.GameObjects.GameObject) - The first Game Object to swap.
    * child-2 (Phaser.GameObjects.GameObject) - The second Game Object to swap.

  Returns:  Phaser.GameObjects.Container - This Container instance."
  ([container child-1 child-2]
   (phaser->clj
    (.swap container
           (clj->phaser child-1)
           (clj->phaser child-2)))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([container]
   (phaser->clj
    (.toJSON container))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * args (*) {optional} - args"
  ([container]
   (phaser->clj
    (.update container)))
  ([container args]
   (phaser->clj
    (.update container
             (clj->phaser args)))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * container (Phaser.GameObjects.Container) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([container camera]
   (phaser->clj
    (.willRender container
                 (clj->phaser camera)))))