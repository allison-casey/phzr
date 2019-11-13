(ns phzr.physics.matter.world
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove update]))

(defn ->World
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Matter World instance belongs.
    * config (Phaser.Types.Physics.Matter.MatterWorldConfig) - The Matter World configuration object."
  ([scene config]
   (js/Phaser.Physics.Matter.World. (clj->phaser scene)
                                    (clj->phaser config))))

(defn add
  "Adds an object to the world.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * object (object | Array.<object>) - Can be single or an array, and can be a body, composite or constraint

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world object]
   (phaser->clj
    (.add world
          (clj->phaser object)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
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

(defn convert-tilemap-layer
  "Adds MatterTileBody instances for all the colliding tiles within the given tilemap layer. Set
  the appropriate tiles in your layer to collide before calling this method!

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * tilemap-layer (Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) - An array of tiles.
    * options (object) {optional} - Options to be passed to the MatterTileBody constructor. {@ee Phaser.Physics.Matter.TileBody}

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world tilemap-layer]
   (phaser->clj
    (.convertTilemapLayer world
                          (clj->phaser tilemap-layer))))
  ([world tilemap-layer options]
   (phaser->clj
    (.convertTilemapLayer world
                          (clj->phaser tilemap-layer)
                          (clj->phaser options)))))

(defn convert-tiles
  "Adds MatterTileBody instances for the given tiles. This adds bodies regardless of whether the
  tiles are set to collide or not.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * tiles (Array.<Phaser.Tilemaps.Tile>) - An array of tiles.
    * options (object) {optional} - Options to be passed to the MatterTileBody constructor. {@see Phaser.Physics.Matter.TileBody}

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world tiles]
   (phaser->clj
    (.convertTiles world
                   (clj->phaser tiles))))
  ([world tiles options]
   (phaser->clj
    (.convertTiles world
                   (clj->phaser tiles)
                   (clj->phaser options)))))

(defn create
  "Creates a rectangle Matter body and adds it to the world.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * x (number) - The horizontal position of the body in the world.
    * y (number) - The vertical position of the body in the world.
    * width (number) - The width of the body.
    * height (number) - The height of the body.
    * options (object) - Optional Matter configuration object.

  Returns:  MatterJS.Body - The Matter.js body that was created."
  ([world x y width height options]
   (phaser->clj
    (.create world
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser width)
             (clj->phaser height)
             (clj->phaser options)))))

(defn create-debug-graphic
  "[description]

  Returns:  Phaser.GameObjects.Graphics - [description]"
  ([world]
   (phaser->clj
    (.createDebugGraphic world))))

(defn destroy
  "Will remove all Matter physics event listeners and clear the matter physics world,
  engine and any debug graphics, if any.

  After destroying the world it cannot be re-used again."
  ([world]
   (phaser->clj
    (.destroy world))))

(defn disable-gravity
  "Sets the world's gravity and gravity scale to 0.

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world]
   (phaser->clj
    (.disableGravity world))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
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

(defn from-path
  "[description]

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * path (string) - [description]
    * points (array) - [description]

  Returns:  array - [description]"
  ([world path points]
   (phaser->clj
    (.fromPath world
               (clj->phaser path)
               (clj->phaser points)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([world event]
   (phaser->clj
    (.listenerCount world
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([world event]
   (phaser->clj
    (.listeners world
                (clj->phaser event)))))

(defn next-category
  "[description]

  Returns:  number - Returns the next unique category bitfield."
  ([world]
   (phaser->clj
    (.nextCategory world))))

(defn next-group
  "[description]

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * is-non-colliding (boolean) - [description]

  Returns:  number - [description]"
  ([world is-non-colliding]
   (phaser->clj
    (.nextGroup world
                (clj->phaser is-non-colliding)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
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
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
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
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
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

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world]
   (phaser->clj
    (.pause world))))

(defn remove
  "[description]

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * object (object) - The object to be removed from the world.
    * deep (boolean) - [description]

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world object deep]
   (phaser->clj
    (.remove world
             (clj->phaser object)
             (clj->phaser deep)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([world]
   (phaser->clj
    (.removeAllListeners world)))
  ([world event]
   (phaser->clj
    (.removeAllListeners world
                         (clj->phaser event)))))

(defn remove-constraint
  "[description]

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * constraint (MatterJS.Constraint) - [description]
    * deep (boolean) - [description]

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world constraint deep]
   (phaser->clj
    (.removeConstraint world
                       (clj->phaser constraint)
                       (clj->phaser deep)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
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

(defn reset-collision-i-ds
  "Resets the internal collision IDs that Matter.JS uses for Body collision groups.

  You should call this before destroying your game if you need to restart the game
  again on the same page, without first reloading the page. Or, if you wish to
  consistently destroy a Scene that contains Matter.js and then run it again
  later in the same game."
  ([world]
   (phaser->clj
    (.resetCollisionIDs world))))

(defn resume
  "[description]

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world]
   (phaser->clj
    (.resume world))))

(defn set-bounds
  "Sets the bounds of the Physics world to match the given world pixel dimensions.
  You can optionally set which 'walls' to create: left, right, top or bottom.
  If none of the walls are given it will default to use the walls settings it had previously.
  I.e. if you previously told it to not have the left or right walls, and you then adjust the world size
  the newly created bounds will also not have the left and right walls.
  Explicitly state them in the parameters to override this.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * x (number) {optional} - The x coordinate of the top-left corner of the bounds.
    * y (number) {optional} - The y coordinate of the top-left corner of the bounds.
    * width (number) {optional} - The width of the bounds.
    * height (number) {optional} - The height of the bounds.
    * thickness (number) {optional} - The thickness of each wall, in pixels.
    * left (boolean) {optional} - If true will create the left bounds wall.
    * right (boolean) {optional} - If true will create the right bounds wall.
    * top (boolean) {optional} - If true will create the top bounds wall.
    * bottom (boolean) {optional} - If true will create the bottom bounds wall.

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
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

(defn set-events-proxy
  "[description]"
  ([world]
   (phaser->clj
    (.setEventsProxy world))))

(defn set-gravity
  "Sets the world's gravity

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * x (number) {optional} - The world gravity x component.
    * y (number) {optional} - The world gravity y component.
    * scale (number) {optional} - [description]

  Returns:  Phaser.Physics.Matter.World - This Matter World object."
  ([world]
   (phaser->clj
    (.setGravity world)))
  ([world x]
   (phaser->clj
    (.setGravity world
                 (clj->phaser x))))
  ([world x y]
   (phaser->clj
    (.setGravity world
                 (clj->phaser x)
                 (clj->phaser y))))
  ([world x y scale]
   (phaser->clj
    (.setGravity world
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser scale)))))

(defn shutdown
  "Will remove all Matter physics event listeners and clear the matter physics world,
  engine and any debug graphics, if any."
  ([world]
   (phaser->clj
    (.shutdown world))))

(defn step
  "Manually advances the physics simulation by one iteration.

  You can optionally pass in the `delta` and `correction` values to be used by Engine.update.
  If undefined they use the Matter defaults of 60Hz and no correction.

  Calling `step` directly bypasses any checks of `enabled` or `autoUpdate`.

  It also ignores any custom `getDelta` functions, as you should be passing the delta
  value in to this call.

  You can adjust the number of iterations that Engine.update performs internally.
  Use the Scene Matter Physics config object to set the following properties:

  positionIterations (defaults to 6)
  velocityIterations (defaults to 4)
  constraintIterations (defaults to 2)

  Adjusting these values can help performance in certain situations, depending on the physics requirements
  of your game.

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * delta (number) {optional} - [description]
    * correction (number) {optional} - [description]"
  ([world]
   (phaser->clj
    (.step world)))
  ([world delta]
   (phaser->clj
    (.step world
           (clj->phaser delta))))
  ([world delta correction]
   (phaser->clj
    (.step world
           (clj->phaser delta)
           (clj->phaser correction)))))

(defn update
  "[description]

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
    * time (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([world time delta]
   (phaser->clj
    (.update world
             (clj->phaser time)
             (clj->phaser delta)))))

(defn update-30-hz
  "Runs the Matter Engine.update at a fixed timestep of 30Hz.

  Returns:  number - The delta value to be passed to Engine.update."
  ([world]
   (phaser->clj
    (.update30Hz world))))

(defn update-60-hz
  "Runs the Matter Engine.update at a fixed timestep of 60Hz.

  Returns:  number - The delta value to be passed to Engine.update."
  ([world]
   (phaser->clj
    (.update60Hz world))))

(defn update-wall
  "[description]

  Parameters:
    * world (Phaser.Physics.Matter.World) - Targeted instance for method
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