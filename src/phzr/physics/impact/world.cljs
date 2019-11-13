(ns phzr.physics.impact.world
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove update]))

(defn ->World
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Impact World instance belongs.
    * config (Phaser.Types.Physics.Impact.WorldConfig) - [description]"
  ([scene config]
   (js/Phaser.Physics.Impact.World. (clj->phaser scene)
                                    (clj->phaser config))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([world event fn]
   (phaser->clj
    (.addListener world
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([world event fn context]
   (phaser->clj
    (.addListener world
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn check-bodies
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * body-a (Phaser.Physics.Impact.Body) - [description]
    * body-b (Phaser.Physics.Impact.Body) - [description]"
  ([world body-a body-b]
   (phaser->clj
    (.checkBodies world
                  (clj->phaser body-a)
                  (clj->phaser body-b)))))

(defn check-hash
  "Check the body against the spatial hash.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * body (Phaser.Physics.Impact.Body) - [description]
    * hash (object) - [description]
    * size (number) - [description]"
  ([world body hash size]
   (phaser->clj
    (.checkHash world
                (clj->phaser body)
                (clj->phaser hash)
                (clj->phaser size)))))

(defn create
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]
    * size-x (number) - [description]
    * size-y (number) - [description]

  Returns:  Phaser.Physics.Impact.Body - The Body that was added to this World."
  ([world x y size-x size-y]
   (phaser->clj
    (.create world
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser size-x)
             (clj->phaser size-y)))))

(defn create-debug-graphic
  "Creates a Graphics Game Object used for debug display and enables the world for debug drawing.

  Returns:  Phaser.GameObjects.Graphics - The Graphics object created that will have the debug visuals drawn to it."
  ([world]
   (phaser->clj
    (.createDebugGraphic world))))

(defn destroy
  "[description]"
  ([world]
   (phaser->clj
    (.destroy world))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([world event]
   (phaser->clj
    (.emit world
           (clj->phaser event))))
  ([world event args]
   (phaser->clj
    (.emit world
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([world]
   (phaser->clj
    (.eventNames world))))

(defn get-next-id
  "[description]

  Returns:  integer - [description]"
  ([world]
   (phaser->clj
    (.getNextID world))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([world event]
   (phaser->clj
    (.listenerCount world
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([world event]
   (phaser->clj
    (.listeners world
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([world event]
   (phaser->clj
    (.off world
          (clj->phaser event))))
  ([world event fn]
   (phaser->clj
    (.off world
          (clj->phaser event)
          (clj->phaser fn))))
  ([world event fn context]
   (phaser->clj
    (.off world
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([world event fn context once]
   (phaser->clj
    (.off world
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([world event fn]
   (phaser->clj
    (.on world
         (clj->phaser event)
         (clj->phaser fn))))
  ([world event fn context]
   (phaser->clj
    (.on world
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([world event fn]
   (phaser->clj
    (.once world
           (clj->phaser event)
           (clj->phaser fn))))
  ([world event fn context]
   (phaser->clj
    (.once world
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "[description]

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world]
   (phaser->clj
    (.pause world))))

(defn remove
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * object (Phaser.Physics.Impact.Body) - The Body to remove from this World."
  ([world object]
   (phaser->clj
    (.remove world
             (clj->phaser object)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([world]
   (phaser->clj
    (.removeAllListeners world)))
  ([world event]
   (phaser->clj
    (.removeAllListeners world
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([world event]
   (phaser->clj
    (.removeListener world
                     (clj->phaser event))))
  ([world event fn]
   (phaser->clj
    (.removeListener world
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([world event fn context]
   (phaser->clj
    (.removeListener world
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([world event fn context once]
   (phaser->clj
    (.removeListener world
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn resume
  "[description]

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world]
   (phaser->clj
    (.resume world))))

(defn set-active
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the collides value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setActive world
                (clj->phaser bodies)))))

(defn set-avs-b
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the type value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setAvsB world
              (clj->phaser bodies)))))

(defn set-bounds
  "Sets the bounds of the Physics world to match the given world pixel dimensions.
  You can optionally set which 'walls' to create: left, right, top or bottom.
  If none of the walls are given it will default to use the walls settings it had previously.
  I.e. if you previously told it to not have the left or right walls, and you then adjust the world size
  the newly created bounds will also not have the left and right walls.
  Explicitly state them in the parameters to override this.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * x (number) {optional} - The x coordinate of the top-left corner of the bounds.
    * y (number) {optional} - The y coordinate of the top-left corner of the bounds.
    * width (number) {optional} - The width of the bounds.
    * height (number) {optional} - The height of the bounds.
    * thickness (number) {optional} - [description]
    * left (boolean) {optional} - If true will create the left bounds wall.
    * right (boolean) {optional} - If true will create the right bounds wall.
    * top (boolean) {optional} - If true will create the top bounds wall.
    * bottom (boolean) {optional} - If true will create the bottom bounds wall.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world]
   (phaser->clj
    (.setBounds world)))
  ([world x]
   (phaser->clj
    (.setBounds world
                (clj->phaser x))))
  ([world x y]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y))))
  ([world x y width]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width))))
  ([world x y width height]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height))))
  ([world x y width height thickness]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser thickness))))
  ([world x y width height thickness left]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser thickness)
                (clj->phaser left))))
  ([world x y width height thickness left right]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser thickness)
                (clj->phaser left)
                (clj->phaser right))))
  ([world x y width height thickness left right top]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser thickness)
                (clj->phaser left)
                (clj->phaser right)
                (clj->phaser top))))
  ([world x y width height thickness left right top bottom]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser thickness)
                (clj->phaser left)
                (clj->phaser right)
                (clj->phaser top)
                (clj->phaser bottom)))))

(defn set-bvs-a
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the type value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setBvsA world
              (clj->phaser bodies)))))

(defn set-check-against-a
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the type value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setCheckAgainstA world
                       (clj->phaser bodies)))))

(defn set-check-against-b
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the type value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setCheckAgainstB world
                       (clj->phaser bodies)))))

(defn set-check-against-none
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the type value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setCheckAgainstNone world
                          (clj->phaser bodies)))))

(defn set-collides-never
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the collides value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setCollidesNever world
                       (clj->phaser bodies)))))

(defn set-collision-map
  "Sets the collision map for the world either from a Weltmeister JSON level in the cache or from
  a 2D array. If loading from a Weltmeister level, the map must have a layer called 'collision'.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * key (string | Array.<Array.<integer>>) - Either a string key that corresponds to a Weltmeister level
in the cache, or a 2D array of collision IDs.
    * tile-size (integer) - The size of a tile. This is optional if loading from a Weltmeister
level in the cache.

  Returns:  Phaser.Physics.Impact.CollisionMap - The newly created CollisionMap, or null if the method failed to
create the CollisionMap."
  ([world key tile-size]
   (phaser->clj
    (.setCollisionMap world
                      (clj->phaser key)
                      (clj->phaser tile-size)))))

(defn set-collision-map-from-tilemap-layer
  "Sets the collision map for the world from a tilemap layer. Only tiles that are marked as
  colliding will be used. You can specify the mapping from tiles to slope IDs in a couple of
  ways. The easiest is to use Tiled and the slopeTileProperty option. Alternatively, you can
  manually create a slopeMap that stores the mapping between tile indices and slope IDs.

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * tilemap-layer (Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) - The tilemap layer to use.
    * options (Phaser.Types.Physics.Impact.CollisionOptions) {optional} - Options for controlling the mapping from tiles to slope IDs.

  Returns:  Phaser.Physics.Impact.CollisionMap - The newly created CollisionMap."
  ([world tilemap-layer]
   (phaser->clj
    (.setCollisionMapFromTilemapLayer world
                                      (clj->phaser tilemap-layer))))
  ([world tilemap-layer options]
   (phaser->clj
    (.setCollisionMapFromTilemapLayer world
                                      (clj->phaser tilemap-layer)
                                      (clj->phaser options)))))

(defn set-fixed
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the collides value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setFixed world
               (clj->phaser bodies)))))

(defn set-lite
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the collides value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setLite world
              (clj->phaser bodies)))))

(defn set-passive
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the collides value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setPassive world
                 (clj->phaser bodies)))))

(defn set-type-a
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the type value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setTypeA world
               (clj->phaser bodies)))))

(defn set-type-b
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the type value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setTypeB world
               (clj->phaser bodies)))))

(defn set-type-none
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * bodies (Array.<Phaser.Physics.Impact.Body>) - An Array of Impact Bodies to set the type value on.

  Returns:  Phaser.Physics.Impact.World - This World object."
  ([world bodies]
   (phaser->clj
    (.setTypeNone world
                  (clj->phaser bodies)))))

(defn shutdown
  "[description]"
  ([world]
   (phaser->clj
    (.shutdown world))))

(defn update
  "[description]

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * time (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([world time delta]
   (phaser->clj
    (.update world
             (clj->phaser time)
             (clj->phaser delta)))))

(defn update-wall
  "position = 'left', 'right', 'top' or 'bottom'

  Parameters:
    * world (Phaser.Physics.Impact.World) - Targeted instance for method
    * add (boolean) - [description]
    * position (string) - [description]
    * x (number) - [description]
    * y (number) - [description]
    * width (number) - [description]
    * height (number) - [description]"
  ([world add position x y width height]
   (phaser->clj
    (.updateWall world
                 (clj->phaser add)
                 (clj->phaser position)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser width)
                 (clj->phaser height)))))