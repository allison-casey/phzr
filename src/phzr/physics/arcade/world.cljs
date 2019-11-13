(ns phzr.physics.arcade.world
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove]))

(defn ->World
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this World instance belongs.
    * config (Phaser.Types.Physics.Arcade.ArcadeWorldConfig) - An Arcade Physics Configuration object."
  ([scene config]
   (js/Phaser.Physics.Arcade.World. (clj->phaser scene)
                                    (clj->phaser config))))

(defn add
  "Adds an existing Arcade Physics Body or StaticBody to the simulation.

  The body is enabled and added to the local search trees.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body (Phaser.Physics.Arcade.Body | Phaser.Physics.Arcade.StaticBody) - The Body to be added to the simulation.

  Returns:  Phaser.Physics.Arcade.Body | Phaser.Physics.Arcade.StaticBody - The Body that was added to the simulation."
  ([world body]
   (phaser->clj
    (.add world
          (clj->phaser body)))))

(defn add-collider
  "Creates a new Collider object and adds it to the simulation.

  A Collider is a way to automatically perform collision checks between two objects,
  calling the collide and process callbacks if they occur.

  Colliders are run as part of the World update, after all of the Bodies have updated.

  By creating a Collider you don't need then call `World.collide` in your `update` loop,
  as it will be handled for you automatically.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object-1 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The first object to check for collision.
    * object-2 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The second object to check for collision.
    * collide-callback (ArcadePhysicsCallback) {optional} - The callback to invoke when the two objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - The callback to invoke when the two objects collide. Must return a boolean.
    * callback-context (*) {optional} - The scope in which to call the callbacks.

  Returns:  Phaser.Physics.Arcade.Collider - The Collider that was created."
  ([world object-1 object-2]
   (phaser->clj
    (.addCollider world
                  (clj->phaser object-1)
                  (clj->phaser object-2))))
  ([world object-1 object-2 collide-callback]
   (phaser->clj
    (.addCollider world
                  (clj->phaser object-1)
                  (clj->phaser object-2)
                  (clj->phaser collide-callback))))
  ([world object-1 object-2 collide-callback process-callback]
   (phaser->clj
    (.addCollider world
                  (clj->phaser object-1)
                  (clj->phaser object-2)
                  (clj->phaser collide-callback)
                  (clj->phaser process-callback))))
  ([world object-1 object-2 collide-callback process-callback callback-context]
   (phaser->clj
    (.addCollider world
                  (clj->phaser object-1)
                  (clj->phaser object-2)
                  (clj->phaser collide-callback)
                  (clj->phaser process-callback)
                  (clj->phaser callback-context)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
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

(defn add-overlap
  "Creates a new Overlap Collider object and adds it to the simulation.

  A Collider is a way to automatically perform overlap checks between two objects,
  calling the collide and process callbacks if they occur.

  Colliders are run as part of the World update, after all of the Bodies have updated.

  By creating a Collider you don't need then call `World.overlap` in your `update` loop,
  as it will be handled for you automatically.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object-1 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The first object to check for overlap.
    * object-2 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The second object to check for overlap.
    * collide-callback (ArcadePhysicsCallback) {optional} - The callback to invoke when the two objects overlap.
    * process-callback (ArcadePhysicsCallback) {optional} - The callback to invoke when the two objects overlap. Must return a boolean.
    * callback-context (*) {optional} - The scope in which to call the callbacks.

  Returns:  Phaser.Physics.Arcade.Collider - The Collider that was created."
  ([world object-1 object-2]
   (phaser->clj
    (.addOverlap world
                 (clj->phaser object-1)
                 (clj->phaser object-2))))
  ([world object-1 object-2 collide-callback]
   (phaser->clj
    (.addOverlap world
                 (clj->phaser object-1)
                 (clj->phaser object-2)
                 (clj->phaser collide-callback))))
  ([world object-1 object-2 collide-callback process-callback]
   (phaser->clj
    (.addOverlap world
                 (clj->phaser object-1)
                 (clj->phaser object-2)
                 (clj->phaser collide-callback)
                 (clj->phaser process-callback))))
  ([world object-1 object-2 collide-callback process-callback callback-context]
   (phaser->clj
    (.addOverlap world
                 (clj->phaser object-1)
                 (clj->phaser object-2)
                 (clj->phaser collide-callback)
                 (clj->phaser process-callback)
                 (clj->phaser callback-context)))))

(defn circle-body-intersects
  "Tests if a circular Body intersects with another Body.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * circle (Phaser.Physics.Arcade.Body) - The circular body to test.
    * body (Phaser.Physics.Arcade.Body) - The rectangular body to test.

  Returns:  boolean - True if the two bodies intersect, otherwise false."
  ([world circle body]
   (phaser->clj
    (.circleBodyIntersects world
                           (clj->phaser circle)
                           (clj->phaser body)))))

(defn collide
  "Performs a collision check and separation between the two physics enabled objects given, which can be single
  Game Objects, arrays of Game Objects, Physics Groups, arrays of Physics Groups or normal Groups.

  If you don't require separation then use {@link #overlap} instead.

  If two Groups or arrays are passed, each member of one will be tested against each member of the other.

  If **only** one Group is passed (as `object1`), each member of the Group will be collided against the other members.

  If **only** one Array is passed, the array is iterated and every element in it is tested against the others.

  Two callbacks can be provided. The `collideCallback` is invoked if a collision occurs and the two colliding
  objects are passed to it.

  Arcade Physics uses the Projection Method of collision resolution and separation. While it's fast and suitable
  for 'arcade' style games it lacks stability when multiple objects are in close proximity or resting upon each other.
  The separation that stops two objects penetrating may create a new penetration against a different object. If you
  require a high level of stability please consider using an alternative physics system, such as Matter.js.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object-1 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The first object or array of objects to check.
    * object-2 (Phaser.Types.Physics.Arcade.ArcadeColliderType) {optional} - The second object or array of objects to check, or `undefined`.
    * collide-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they collide. If this is set then `collideCallback` will only be called if this callback returns `true`.
    * callback-context (any) {optional} - The context in which to run the callbacks.

  Returns:  boolean - `true` if any overlapping Game Objects were separated, otherwise `false`."
  ([world object-1]
   (phaser->clj
    (.collide world
              (clj->phaser object-1))))
  ([world object-1 object-2]
   (phaser->clj
    (.collide world
              (clj->phaser object-1)
              (clj->phaser object-2))))
  ([world object-1 object-2 collide-callback]
   (phaser->clj
    (.collide world
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback))))
  ([world object-1 object-2 collide-callback process-callback]
   (phaser->clj
    (.collide world
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback)
              (clj->phaser process-callback))))
  ([world object-1 object-2 collide-callback process-callback callback-context]
   (phaser->clj
    (.collide world
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback)
              (clj->phaser process-callback)
              (clj->phaser callback-context)))))

(defn collide-sprite-vs-tilemap-layer
  "Internal handler for Sprite vs. Tilemap collisions.
  Please use Phaser.Physics.Arcade.World#collide instead.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * sprite (Phaser.GameObjects.GameObject) - The first object to check for collision.
    * tilemap-layer (Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) - The second object to check for collision.
    * collide-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they collide. If this is set then `collideCallback` will only be called if this callback returns `true`.
    * callback-context (any) {optional} - The context in which to run the callbacks.
    * overlap-only (boolean) {optional} - Whether this is a collision or overlap check.

  Returns:  boolean - True if any objects overlap (with `overlapOnly`); or true if any overlapping objects were separated."
  ([world sprite tilemap-layer]
   (phaser->clj
    (.collideSpriteVsTilemapLayer world
                                  (clj->phaser sprite)
                                  (clj->phaser tilemap-layer))))
  ([world sprite tilemap-layer collide-callback]
   (phaser->clj
    (.collideSpriteVsTilemapLayer world
                                  (clj->phaser sprite)
                                  (clj->phaser tilemap-layer)
                                  (clj->phaser collide-callback))))
  ([world sprite tilemap-layer collide-callback process-callback]
   (phaser->clj
    (.collideSpriteVsTilemapLayer world
                                  (clj->phaser sprite)
                                  (clj->phaser tilemap-layer)
                                  (clj->phaser collide-callback)
                                  (clj->phaser process-callback))))
  ([world sprite tilemap-layer collide-callback process-callback callback-context]
   (phaser->clj
    (.collideSpriteVsTilemapLayer world
                                  (clj->phaser sprite)
                                  (clj->phaser tilemap-layer)
                                  (clj->phaser collide-callback)
                                  (clj->phaser process-callback)
                                  (clj->phaser callback-context))))
  ([world sprite tilemap-layer collide-callback process-callback callback-context overlap-only]
   (phaser->clj
    (.collideSpriteVsTilemapLayer world
                                  (clj->phaser sprite)
                                  (clj->phaser tilemap-layer)
                                  (clj->phaser collide-callback)
                                  (clj->phaser process-callback)
                                  (clj->phaser callback-context)
                                  (clj->phaser overlap-only)))))

(defn collide-tiles
  "This advanced method is specifically for testing for collision between a single Sprite and an array of Tile objects.

  You should generally use the `collide` method instead, with a Sprite vs. a Tilemap Layer, as that will perform
  tile filtering and culling for you, as well as handle the interesting face collision automatically.

  This method is offered for those who would like to check for collision with specific Tiles in a layer, without
  having to set any collision attributes on the tiles in question. This allows you to perform quick dynamic collisions
  on small sets of Tiles. As such, no culling or checks are made to the array of Tiles given to this method,
  you should filter them before passing them to this method.

  Important: Use of this method skips the `interesting faces` system that Tilemap Layers use. This means if you have
  say a row or column of tiles, and you jump into, or walk over them, it's possible to get stuck on the edges of the
  tiles as the interesting face calculations are skipped. However, for quick-fire small collision set tests on
  dynamic maps, this method can prove very useful.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * sprite (Phaser.GameObjects.GameObject) - The first object to check for collision.
    * tiles (Array.<Phaser.Tilemaps.Tile>) - An array of Tiles to check for collision against.
    * collide-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they collide. If this is set then `collideCallback` will only be called if this callback returns `true`.
    * callback-context (any) {optional} - The context in which to run the callbacks.

  Returns:  boolean - True if any objects overlap (with `overlapOnly`); or true if any overlapping objects were separated."
  ([world sprite tiles]
   (phaser->clj
    (.collideTiles world
                   (clj->phaser sprite)
                   (clj->phaser tiles))))
  ([world sprite tiles collide-callback]
   (phaser->clj
    (.collideTiles world
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback))))
  ([world sprite tiles collide-callback process-callback]
   (phaser->clj
    (.collideTiles world
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback)
                   (clj->phaser process-callback))))
  ([world sprite tiles collide-callback process-callback callback-context]
   (phaser->clj
    (.collideTiles world
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback)
                   (clj->phaser process-callback)
                   (clj->phaser callback-context)))))

(defn compute-angular-velocity
  "Calculates a Body's angular velocity.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body (Phaser.Physics.Arcade.Body) - The Body to compute the velocity for.
    * delta (number) - The delta value to be used in the calculation, in seconds."
  ([world body delta]
   (phaser->clj
    (.computeAngularVelocity world
                             (clj->phaser body)
                             (clj->phaser delta)))))

(defn compute-velocity
  "Calculates a Body's per-axis velocity.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body (Phaser.Physics.Arcade.Body) - The Body to compute the velocity for.
    * delta (number) - The delta value to be used in the calculation, in seconds."
  ([world body delta]
   (phaser->clj
    (.computeVelocity world
                      (clj->phaser body)
                      (clj->phaser delta)))))

(defn create-debug-graphic
  "Creates a Graphics Game Object that the world will use to render the debug display to.

  This is called automatically when the World is instantiated if the `debug` config property
  was set to `true`. However, you can call it at any point should you need to display the
  debug Graphic from a fixed point.

  You can control which objects are drawn to the Graphics object, and the colors they use,
  by setting the debug properties in the physics config.

  You should not typically use this in a production game. Use it to aid during debugging.

  Returns:  Phaser.GameObjects.Graphics - The Graphics object that was created for use by the World."
  ([world]
   (phaser->clj
    (.createDebugGraphic world))))

(defn destroy
  "Shuts down the simulation and disconnects it from the current scene."
  ([world]
   (phaser->clj
    (.destroy world))))

(defn disable
  "Disables the Arcade Physics Body of a Game Object, an array of Game Objects, or the children of a Group.

  The difference between this and the `disableBody` method is that you can pass arrays or Groups
  to this method.

  The body itself is not deleted, it just has its `enable` property set to false, which
  means you can re-enable it again at any point by passing it to enable `World.enable` or `World.add`.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject> | Phaser.GameObjects.Group | Array.<Phaser.GameObjects.Group>) - The object, or objects, on which to disable the bodies."
  ([world object]
   (phaser->clj
    (.disable world
              (clj->phaser object)))))

(defn disable-body
  "Disables an existing Arcade Physics Body or StaticBody and removes it from the simulation.

  The body is disabled and removed from the local search trees.

  The body itself is not deleted, it just has its `enable` property set to false, which
  means you can re-enable it again at any point by passing it to enable `World.enable` or `World.add`.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body (Phaser.Physics.Arcade.Body | Phaser.Physics.Arcade.StaticBody) - The Body to be disabled."
  ([world body]
   (phaser->clj
    (.disableBody world
                  (clj->phaser body)))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
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

(defn enable
  "Adds an Arcade Physics Body to a Game Object, an array of Game Objects, or the children of a Group.

  The difference between this and the `enableBody` method is that you can pass arrays or Groups
  to this method.

  You can specify if the bodies are to be Dynamic or Static. A dynamic body can move via velocity and
  acceleration. A static body remains fixed in place and as such is able to use an optimized search
  tree, making it ideal for static elements such as level objects. You can still collide and overlap
  with static bodies.

  Normally, rather than calling this method directly, you'd use the helper methods available in the
  Arcade Physics Factory, such as:

  ```javascript
  this.physics.add.image(x, y, textureKey);
  this.physics.add.sprite(x, y, textureKey);
  ```

  Calling factory methods encapsulates the creation of a Game Object and the creation of its
  body at the same time. If you are creating custom classes then you can pass them to this
  method to have their bodies created.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject> | Phaser.GameObjects.Group | Array.<Phaser.GameObjects.Group>) - The object, or objects, on which to create the bodies.
    * body-type (integer) {optional} - The type of Body to create. Either `DYNAMIC_BODY` or `STATIC_BODY`."
  ([world object]
   (phaser->clj
    (.enable world
             (clj->phaser object))))
  ([world object body-type]
   (phaser->clj
    (.enable world
             (clj->phaser object)
             (clj->phaser body-type)))))

(defn enable-body
  "Creates an Arcade Physics Body on a single Game Object.

  If the Game Object already has a body, this method will simply add it back into the simulation.

  You can specify if the body is Dynamic or Static. A dynamic body can move via velocity and
  acceleration. A static body remains fixed in place and as such is able to use an optimized search
  tree, making it ideal for static elements such as level objects. You can still collide and overlap
  with static bodies.

  Normally, rather than calling this method directly, you'd use the helper methods available in the
  Arcade Physics Factory, such as:

  ```javascript
  this.physics.add.image(x, y, textureKey);
  this.physics.add.sprite(x, y, textureKey);
  ```

  Calling factory methods encapsulates the creation of a Game Object and the creation of its
  body at the same time. If you are creating custom classes then you can pass them to this
  method to have their bodies created.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object (Phaser.GameObjects.GameObject) - The Game Object on which to create the body.
    * body-type (integer) {optional} - The type of Body to create. Either `DYNAMIC_BODY` or `STATIC_BODY`.

  Returns:  Phaser.GameObjects.GameObject - The Game Object on which the body was created."
  ([world object]
   (phaser->clj
    (.enableBody world
                 (clj->phaser object))))
  ([world object body-type]
   (phaser->clj
    (.enableBody world
                 (clj->phaser object)
                 (clj->phaser body-type)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([world]
   (phaser->clj
    (.eventNames world))))

(defn intersects
  "Checks to see if two Bodies intersect at all.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body-1 (Phaser.Physics.Arcade.Body) - The first body to check.
    * body-2 (Phaser.Physics.Arcade.Body) - The second body to check.

  Returns:  boolean - True if the two bodies intersect, otherwise false."
  ([world body-1 body-2]
   (phaser->clj
    (.intersects world
                 (clj->phaser body-1)
                 (clj->phaser body-2)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([world event]
   (phaser->clj
    (.listenerCount world
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([world event]
   (phaser->clj
    (.listeners world
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
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
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
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
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
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

(defn overlap
  "Tests if Game Objects overlap.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object-1 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The first object or array of objects to check.
    * object-2 (Phaser.Types.Physics.Arcade.ArcadeColliderType) {optional} - The second object or array of objects to check, or `undefined`.
    * overlap-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects overlap.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they overlap. If this is set then `overlapCallback` will only be called if this callback returns `true`.
    * callback-context (*) {optional} - The context in which to run the callbacks.

  Returns:  boolean - True if at least one Game Object overlaps another."
  ([world object-1]
   (phaser->clj
    (.overlap world
              (clj->phaser object-1))))
  ([world object-1 object-2]
   (phaser->clj
    (.overlap world
              (clj->phaser object-1)
              (clj->phaser object-2))))
  ([world object-1 object-2 overlap-callback]
   (phaser->clj
    (.overlap world
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser overlap-callback))))
  ([world object-1 object-2 overlap-callback process-callback]
   (phaser->clj
    (.overlap world
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser overlap-callback)
              (clj->phaser process-callback))))
  ([world object-1 object-2 overlap-callback process-callback callback-context]
   (phaser->clj
    (.overlap world
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser overlap-callback)
              (clj->phaser process-callback)
              (clj->phaser callback-context)))))

(defn overlap-tiles
  "This advanced method is specifically for testing for overlaps between a single Sprite and an array of Tile objects.

  You should generally use the `overlap` method instead, with a Sprite vs. a Tilemap Layer, as that will perform
  tile filtering and culling for you, as well as handle the interesting face collision automatically.

  This method is offered for those who would like to check for overlaps with specific Tiles in a layer, without
  having to set any collision attributes on the tiles in question. This allows you to perform quick dynamic overlap
  tests on small sets of Tiles. As such, no culling or checks are made to the array of Tiles given to this method,
  you should filter them before passing them to this method.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * sprite (Phaser.GameObjects.GameObject) - The first object to check for collision.
    * tiles (Array.<Phaser.Tilemaps.Tile>) - An array of Tiles to check for collision against.
    * collide-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects overlap.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they collide. If this is set then `collideCallback` will only be called if this callback returns `true`.
    * callback-context (any) {optional} - The context in which to run the callbacks.

  Returns:  boolean - True if any objects overlap (with `overlapOnly`); or true if any overlapping objects were separated."
  ([world sprite tiles]
   (phaser->clj
    (.overlapTiles world
                   (clj->phaser sprite)
                   (clj->phaser tiles))))
  ([world sprite tiles collide-callback]
   (phaser->clj
    (.overlapTiles world
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback))))
  ([world sprite tiles collide-callback process-callback]
   (phaser->clj
    (.overlapTiles world
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback)
                   (clj->phaser process-callback))))
  ([world sprite tiles collide-callback process-callback callback-context]
   (phaser->clj
    (.overlapTiles world
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback)
                   (clj->phaser process-callback)
                   (clj->phaser callback-context)))))

(defn pause
  "Pauses the simulation.

  A paused simulation does not update any existing bodies, or run any Colliders.

  However, you can still enable and disable bodies within it, or manually run collide or overlap
  checks.

  Returns:  Phaser.Physics.Arcade.World - This World object."
  ([world]
   (phaser->clj
    (.pause world))))

(defn post-update
  "Updates bodies, draws the debug display, and handles pending queue operations."
  ([world]
   (phaser->clj
    (.postUpdate world))))

(defn remove
  "Removes an existing Arcade Physics Body or StaticBody from the simulation.

  The body is disabled and removed from the local search trees.

  The body itself is not deleted, it just has its `enabled` property set to false, which
  means you can re-enable it again at any point by passing it to enable `enable` or `add`.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body (Phaser.Physics.Arcade.Body | Phaser.Physics.Arcade.StaticBody) - The body to be removed from the simulation."
  ([world body]
   (phaser->clj
    (.remove world
             (clj->phaser body)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([world]
   (phaser->clj
    (.removeAllListeners world)))
  ([world event]
   (phaser->clj
    (.removeAllListeners world
                         (clj->phaser event)))))

(defn remove-collider
  "Removes a Collider from the simulation so it is no longer processed.

  This method does not destroy the Collider. If you wish to add it back at a later stage you can call
  `World.colliders.add(Collider)`.

  If you no longer need the Collider you can call the `Collider.destroy` method instead, which will
  automatically clear all of its references and then remove it from the World. If you call destroy on
  a Collider you _don't_ need to pass it to this method too.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * collider (Phaser.Physics.Arcade.Collider) - The Collider to remove from the simulation.

  Returns:  Phaser.Physics.Arcade.World - This World object."
  ([world collider]
   (phaser->clj
    (.removeCollider world
                     (clj->phaser collider)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
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
  "Resumes the simulation, if paused.

  Returns:  Phaser.Physics.Arcade.World - This World object."
  ([world]
   (phaser->clj
    (.resume world))))

(defn separate
  "Separates two Bodies.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body-1 (Phaser.Physics.Arcade.Body) - The first Body to be separated.
    * body-2 (Phaser.Physics.Arcade.Body) - The second Body to be separated.
    * process-callback (ArcadePhysicsCallback) {optional} - The process callback.
    * callback-context (*) {optional} - The context in which to invoke the callback.
    * overlap-only (boolean) {optional} - If this a collide or overlap check?

  Returns:  boolean - True if separation occurred, otherwise false."
  ([world body-1 body-2]
   (phaser->clj
    (.separate world
               (clj->phaser body-1)
               (clj->phaser body-2))))
  ([world body-1 body-2 process-callback]
   (phaser->clj
    (.separate world
               (clj->phaser body-1)
               (clj->phaser body-2)
               (clj->phaser process-callback))))
  ([world body-1 body-2 process-callback callback-context]
   (phaser->clj
    (.separate world
               (clj->phaser body-1)
               (clj->phaser body-2)
               (clj->phaser process-callback)
               (clj->phaser callback-context))))
  ([world body-1 body-2 process-callback callback-context overlap-only]
   (phaser->clj
    (.separate world
               (clj->phaser body-1)
               (clj->phaser body-2)
               (clj->phaser process-callback)
               (clj->phaser callback-context)
               (clj->phaser overlap-only)))))

(defn separate-circle
  "Separates two Bodies, when both are circular.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body-1 (Phaser.Physics.Arcade.Body) - The first Body to be separated.
    * body-2 (Phaser.Physics.Arcade.Body) - The second Body to be separated.
    * overlap-only (boolean) {optional} - If this a collide or overlap check?
    * bias (number) {optional} - A small value added to the calculations.

  Returns:  boolean - True if separation occurred, otherwise false."
  ([world body-1 body-2]
   (phaser->clj
    (.separateCircle world
                     (clj->phaser body-1)
                     (clj->phaser body-2))))
  ([world body-1 body-2 overlap-only]
   (phaser->clj
    (.separateCircle world
                     (clj->phaser body-1)
                     (clj->phaser body-2)
                     (clj->phaser overlap-only))))
  ([world body-1 body-2 overlap-only bias]
   (phaser->clj
    (.separateCircle world
                     (clj->phaser body-1)
                     (clj->phaser body-2)
                     (clj->phaser overlap-only)
                     (clj->phaser bias)))))

(defn set-bounds
  "Sets the position, size and properties of the World boundary.

  The World boundary is an invisible rectangle that defines the edges of the World.
  If a Body is set to collide with the world bounds then it will automatically stop
  when it reaches any of the edges. You can optionally set which edges of the boundary
  should be checked against.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * x (number) - The top-left x coordinate of the boundary.
    * y (number) - The top-left y coordinate of the boundary.
    * width (number) - The width of the boundary.
    * height (number) - The height of the boundary.
    * check-left (boolean) {optional} - Should bodies check against the left edge of the boundary?
    * check-right (boolean) {optional} - Should bodies check against the right edge of the boundary?
    * check-up (boolean) {optional} - Should bodies check against the top edge of the boundary?
    * check-down (boolean) {optional} - Should bodies check against the bottom edge of the boundary?

  Returns:  Phaser.Physics.Arcade.World - This World object."
  ([world x y width height]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height))))
  ([world x y width height check-left]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser check-left))))
  ([world x y width height check-left check-right]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser check-left)
                (clj->phaser check-right))))
  ([world x y width height check-left check-right check-up]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser check-left)
                (clj->phaser check-right)
                (clj->phaser check-up))))
  ([world x y width height check-left check-right check-up check-down]
   (phaser->clj
    (.setBounds world
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser check-left)
                (clj->phaser check-right)
                (clj->phaser check-up)
                (clj->phaser check-down)))))

(defn set-bounds-collision
  "Enables or disables collisions on each edge of the World boundary.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * left (boolean) {optional} - Should bodies check against the left edge of the boundary?
    * right (boolean) {optional} - Should bodies check against the right edge of the boundary?
    * up (boolean) {optional} - Should bodies check against the top edge of the boundary?
    * down (boolean) {optional} - Should bodies check against the bottom edge of the boundary?

  Returns:  Phaser.Physics.Arcade.World - This World object."
  ([world]
   (phaser->clj
    (.setBoundsCollision world)))
  ([world left]
   (phaser->clj
    (.setBoundsCollision world
                         (clj->phaser left))))
  ([world left right]
   (phaser->clj
    (.setBoundsCollision world
                         (clj->phaser left)
                         (clj->phaser right))))
  ([world left right up]
   (phaser->clj
    (.setBoundsCollision world
                         (clj->phaser left)
                         (clj->phaser right)
                         (clj->phaser up))))
  ([world left right up down]
   (phaser->clj
    (.setBoundsCollision world
                         (clj->phaser left)
                         (clj->phaser right)
                         (clj->phaser up)
                         (clj->phaser down)))))

(defn set-fps
  "Sets the frame rate to run the simulation at.

  The frame rate value is used to simulate a fixed update time step. This fixed
  time step allows for a straightforward implementation of a deterministic game state.

  This frame rate is independent of the frequency at which the game is rendering. The
  higher you set the fps, the more physics simulation steps will occur per game step.
  Conversely, the lower you set it, the less will take place.

  You can optionally advance the simulation directly yourself by calling the `step` method.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * framerate (integer) - The frame rate to advance the simulation at.

  Returns:  this - This World object."
  ([world framerate]
   (phaser->clj
    (.setFPS world
             (clj->phaser framerate)))))

(defn shutdown
  "Shuts down the simulation, clearing physics data and removing listeners."
  ([world]
   (phaser->clj
    (.shutdown world))))

(defn step
  "Advances the simulation by a time increment.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * delta (number) - The delta time amount, in seconds, by which to advance the simulation."
  ([world delta]
   (phaser->clj
    (.step world
           (clj->phaser delta)))))

(defn update-motion
  "Calculates a Body's velocity and updates its position.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * body (Phaser.Physics.Arcade.Body) - The Body to be updated.
    * delta (number) - The delta value to be used in the motion calculations, in seconds."
  ([world body delta]
   (phaser->clj
    (.updateMotion world
                   (clj->phaser body)
                   (clj->phaser delta)))))

(defn wrap
  "Wrap an object's coordinates (or several objects' coordinates) within {@link Phaser.Physics.Arcade.World#bounds}.

  If the object is outside any boundary edge (left, top, right, bottom), it will be moved to the same offset from the opposite edge (the interior).

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object (*) - A Game Object, a Group, an object with `x` and `y` coordinates, or an array of such objects.
    * padding (number) {optional} - An amount added to each boundary edge during the operation."
  ([world object]
   (phaser->clj
    (.wrap world
           (clj->phaser object))))
  ([world object padding]
   (phaser->clj
    (.wrap world
           (clj->phaser object)
           (clj->phaser padding)))))

(defn wrap-array
  "Wrap each object's coordinates within {@link Phaser.Physics.Arcade.World#bounds}.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * objects (Array.<*>) - An array of objects to be wrapped.
    * padding (number) {optional} - An amount added to the boundary."
  ([world objects]
   (phaser->clj
    (.wrapArray world
                (clj->phaser objects))))
  ([world objects padding]
   (phaser->clj
    (.wrapArray world
                (clj->phaser objects)
                (clj->phaser padding)))))

(defn wrap-object
  "Wrap an object's coordinates within {@link Phaser.Physics.Arcade.World#bounds}.

  Parameters:
    * world (Phaser.Physics.Arcade.World) - Targeted instance for method
    * object (*) - A Game Object, a Physics Body, or any object with `x` and `y` coordinates
    * padding (number) {optional} - An amount added to the boundary."
  ([world object]
   (phaser->clj
    (.wrapObject world
                 (clj->phaser object))))
  ([world object padding]
   (phaser->clj
    (.wrapObject world
                 (clj->phaser object)
                 (clj->phaser padding)))))