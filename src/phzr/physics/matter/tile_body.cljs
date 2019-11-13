(ns phzr.physics.matter.tile-body
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->TileBody
  "  Parameters:
    * world (Phaser.Physics.Matter.World) - [description]
    * tile (Phaser.Tilemaps.Tile) - The target tile that should have a Matter body.
    * options (Phaser.Types.Physics.Matter.MatterTileOptions) {optional} - Options to be used when creating the Matter body."
  ([world tile]
   (js/Phaser.Physics.Matter.TileBody. (clj->phaser world)
                                       (clj->phaser tile)))
  ([world tile options]
   (js/Phaser.Physics.Matter.TileBody. (clj->phaser world)
                                       (clj->phaser tile)
                                       (clj->phaser options))))

(defn destroy
  "Removes the current body from the tile and the world.

  Returns:  Phaser.Physics.Matter.TileBody - This TileBody object."
  ([tile-body]
   (phaser->clj
    (.destroy tile-body))))

(defn is-sensor
  "[description]

  Returns:  boolean - [description]"
  ([tile-body]
   (phaser->clj
    (.isSensor tile-body))))

(defn is-static
  "[description]

  Returns:  boolean - [description]"
  ([tile-body]
   (phaser->clj
    (.isStatic tile-body))))

(defn remove-body
  "Removes the current body from the TileBody and from the Matter world

  Returns:  Phaser.Physics.Matter.TileBody - This TileBody object."
  ([tile-body]
   (phaser->clj
    (.removeBody tile-body))))

(defn set-body
  "Sets the current body to the given body. This will remove the previous body, if one already
  exists.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * body (MatterJS.Body) - The new Matter body to use.
    * add-to-world (boolean) {optional} - Whether or not to add the body to the Matter world.

  Returns:  Phaser.Physics.Matter.TileBody - This TileBody object."
  ([tile-body body]
   (phaser->clj
    (.setBody tile-body
              (clj->phaser body))))
  ([tile-body body add-to-world]
   (phaser->clj
    (.setBody tile-body
              (clj->phaser body)
              (clj->phaser add-to-world)))))

(defn set-bounce
  "Sets the restitution on the physics object.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) - A Number that defines the restitution (elasticity) of the body. The value is always positive and is in the range (0, 1). A value of 0 means collisions may be perfectly inelastic and no bouncing may occur. A value of 0.8 means the body may bounce back with approximately 80% of its kinetic energy. Note that collision response is based on pairs of bodies, and that restitution values are combined with the following formula: `Math.max(bodyA.restitution, bodyB.restitution)`

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setBounce tile-body
                (clj->phaser value)))))

(defn set-collides-with
  "Sets the collision mask for this Game Object's Matter Body. Two Matter Bodies with different collision groups will only collide if each one includes the other's category in its mask based on a bitwise AND, i.e. `(categoryA & maskB) !== 0` and `(categoryB & maskA) !== 0` are both true.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * categories (number | Array.<number>) - A unique category bitfield, or an array of them.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body categories]
   (phaser->clj
    (.setCollidesWith tile-body
                      (clj->phaser categories)))))

(defn set-collision-category
  "Sets the collision category of this Game Object's Matter Body. This number must be a power of two between 2^0 (= 1) and 2^31. Two bodies with different collision groups (see {@link #setCollisionGroup}) will only collide if their collision categories are included in their collision masks (see {@link #setCollidesWith}).

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) - Unique category bitfield.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setCollisionCategory tile-body
                           (clj->phaser value)))))

(defn set-collision-group
  "Sets the collision group of this Game Object's Matter Body. If this is zero or two Matter Bodies have different values, they will collide according to the usual rules (see {@link #setCollisionCategory} and {@link #setCollisionGroup}). If two Matter Bodies have the same positive value, they will always collide; if they have the same negative value, they will never collide.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) - Unique group index.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setCollisionGroup tile-body
                        (clj->phaser value)))))

(defn set-density
  "Sets density of the body.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) - The new density of the body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setDensity tile-body
                 (clj->phaser value)))))

(defn set-friction
  "Sets new friction values for this Game Object's Matter Body.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) - The new friction of the body, between 0 and 1, where 0 allows the Body to slide indefinitely, while 1 allows it to stop almost immediately after a force is applied.
    * air (number) {optional} - If provided, the new air resistance of the Body. The higher the value, the faster the Body will slow as it moves through space. 0 means the body has no air resistance.
    * fstatic (number) {optional} - If provided, the new static friction of the Body. The higher the value (e.g. 10), the more force it will take to initially get the Body moving when it is nearly stationary. 0 means the body will never 'stick' when it is nearly stationary.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setFriction tile-body
                  (clj->phaser value))))
  ([tile-body value air]
   (phaser->clj
    (.setFriction tile-body
                  (clj->phaser value)
                  (clj->phaser air))))
  ([tile-body value air fstatic]
   (phaser->clj
    (.setFriction tile-body
                  (clj->phaser value)
                  (clj->phaser air)
                  (clj->phaser fstatic)))))

(defn set-friction-air
  "Sets a new air resistance for this Game Object's Matter Body. A value of 0 means the Body will never slow as it moves through space. The higher the value, the faster a Body slows when moving through space.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) - The new air resistance for the Body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setFrictionAir tile-body
                     (clj->phaser value)))))

(defn set-friction-static
  "Sets a new static friction for this Game Object's Matter Body. A value of 0 means the Body will never 'stick' when it is nearly stationary. The higher the value (e.g. 10), the more force it will take to initially get the Body moving when it is nearly stationary.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) - The new static friction for the Body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setFrictionStatic tile-body
                        (clj->phaser value)))))

(defn set-from-tile-collision
  "Sets the current body from the collision group associated with the Tile. This is typically
  set up in Tiled's collision editor.

  Note: Matter doesn't support all shapes from Tiled. Rectangles and polygons are directly
  supported. Ellipses are converted into circle bodies. Polylines are treated as if they are
  closed polygons. If a tile has multiple shapes, a multi-part body will be created. Concave
  shapes are supported if poly-decomp library is included. Decomposition is not guaranteed to
  work for complex shapes (e.g. holes), so it's often best to manually decompose a concave
  polygon into multiple convex polygons yourself.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * options (Phaser.Types.Physics.Matter.MatterBodyTileOptions) {optional} - Options to be used when creating the Matter body. See MatterJS.Body for a list of what Matter accepts.

  Returns:  Phaser.Physics.Matter.TileBody - This TileBody object."
  ([tile-body]
   (phaser->clj
    (.setFromTileCollision tile-body)))
  ([tile-body options]
   (phaser->clj
    (.setFromTileCollision tile-body
                           (clj->phaser options)))))

(defn set-from-tile-rectangle
  "Sets the current body to a rectangle that matches the bounds of the tile.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * options (Phaser.Types.Physics.Matter.MatterBodyTileOptions) {optional} - Options to be used when creating the Matter body. See MatterJS.Body for a list of what Matter accepts.

  Returns:  Phaser.Physics.Matter.TileBody - This TileBody object."
  ([tile-body]
   (phaser->clj
    (.setFromTileRectangle tile-body)))
  ([tile-body options]
   (phaser->clj
    (.setFromTileRectangle tile-body
                           (clj->phaser options)))))

(defn set-ignore-gravity
  "A togglable function for ignoring world gravity in real-time on the current body.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (boolean) - Set to true to ignore the effect of world gravity, or false to not ignore it.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setIgnoreGravity tile-body
                       (clj->phaser value)))))

(defn set-mass
  "Sets the mass of the Game Object's Matter Body.

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) - The new mass of the body.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setMass tile-body
              (clj->phaser value)))))

(defn set-sensor
  "[description]

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setSensor tile-body
                (clj->phaser value)))))

(defn set-sleep-end-event
  "[description]

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setSleepEndEvent tile-body
                       (clj->phaser value)))))

(defn set-sleep-events
  "[description]

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * start (boolean) - [description]
    * end (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body start end]
   (phaser->clj
    (.setSleepEvents tile-body
                     (clj->phaser start)
                     (clj->phaser end)))))

(defn set-sleep-start-event
  "[description]

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setSleepStartEvent tile-body
                         (clj->phaser value)))))

(defn set-sleep-threshold
  "[description]

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (number) {optional} - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body]
   (phaser->clj
    (.setSleepThreshold tile-body)))
  ([tile-body value]
   (phaser->clj
    (.setSleepThreshold tile-body
                        (clj->phaser value)))))

(defn set-static
  "[description]

  Parameters:
    * tile-body (Phaser.Physics.Matter.TileBody) - Targeted instance for method
    * value (boolean) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([tile-body value]
   (phaser->clj
    (.setStatic tile-body
                (clj->phaser value)))))