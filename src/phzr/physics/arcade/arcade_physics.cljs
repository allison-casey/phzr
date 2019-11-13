(ns phzr.physics.arcade.arcade-physics
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->ArcadePhysics
  "  Parameters:
    * scene (Phaser.Scene) - The Scene that this Plugin belongs to."
  ([scene]
   (js/Phaser.Physics.Arcade.ArcadePhysics. (clj->phaser scene))))

(defn accelerate-to
  "Sets the acceleration.x/y property on the game object so it will move towards the x/y coordinates at the given rate (in pixels per second squared)

  You must give a maximum speed value, beyond which the game object won't go any faster.

  Note: The game object does not continuously track the target. If the target changes location during transit the game object will not modify its course.
  Note: The game object doesn't stop moving once it reaches the destination coordinates.

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - Any Game Object with an Arcade Physics body.
    * x (number) - The x coordinate to accelerate towards.
    * y (number) - The y coordinate to accelerate towards.
    * speed (number) {optional} - The acceleration (change in speed) in pixels per second squared.
    * x-speed-max (number) {optional} - The maximum x velocity the game object can reach.
    * y-speed-max (number) {optional} - The maximum y velocity the game object can reach.

  Returns:  number - The angle (in radians) that the object should be visually set to in order to match its new velocity."
  ([arcade-physics game-object x y]
   (phaser->clj
    (.accelerateTo arcade-physics
                   (clj->phaser game-object)
                   (clj->phaser x)
                   (clj->phaser y))))
  ([arcade-physics game-object x y speed]
   (phaser->clj
    (.accelerateTo arcade-physics
                   (clj->phaser game-object)
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser speed))))
  ([arcade-physics game-object x y speed x-speed-max]
   (phaser->clj
    (.accelerateTo arcade-physics
                   (clj->phaser game-object)
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser speed)
                   (clj->phaser x-speed-max))))
  ([arcade-physics game-object x y speed x-speed-max y-speed-max]
   (phaser->clj
    (.accelerateTo arcade-physics
                   (clj->phaser game-object)
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser speed)
                   (clj->phaser x-speed-max)
                   (clj->phaser y-speed-max)))))

(defn accelerate-to-object
  "Sets the acceleration.x/y property on the game object so it will move towards the x/y coordinates at the given rate (in pixels per second squared)

  You must give a maximum speed value, beyond which the game object won't go any faster.

  Note: The game object does not continuously track the target. If the target changes location during transit the game object will not modify its course.
  Note: The game object doesn't stop moving once it reaches the destination coordinates.

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - Any Game Object with an Arcade Physics body.
    * destination (Phaser.GameObjects.GameObject) - The Game Object to move towards. Can be any object but must have visible x/y properties.
    * speed (number) {optional} - The acceleration (change in speed) in pixels per second squared.
    * x-speed-max (number) {optional} - The maximum x velocity the game object can reach.
    * y-speed-max (number) {optional} - The maximum y velocity the game object can reach.

  Returns:  number - The angle (in radians) that the object should be visually set to in order to match its new velocity."
  ([arcade-physics game-object destination]
   (phaser->clj
    (.accelerateToObject arcade-physics
                         (clj->phaser game-object)
                         (clj->phaser destination))))
  ([arcade-physics game-object destination speed]
   (phaser->clj
    (.accelerateToObject arcade-physics
                         (clj->phaser game-object)
                         (clj->phaser destination)
                         (clj->phaser speed))))
  ([arcade-physics game-object destination speed x-speed-max]
   (phaser->clj
    (.accelerateToObject arcade-physics
                         (clj->phaser game-object)
                         (clj->phaser destination)
                         (clj->phaser speed)
                         (clj->phaser x-speed-max))))
  ([arcade-physics game-object destination speed x-speed-max y-speed-max]
   (phaser->clj
    (.accelerateToObject arcade-physics
                         (clj->phaser game-object)
                         (clj->phaser destination)
                         (clj->phaser speed)
                         (clj->phaser x-speed-max)
                         (clj->phaser y-speed-max)))))

(defn closest
  "Finds the Dynamic Body closest to a source point or object.

  If two or more bodies are the exact same distance from the source point, only the first body
  is returned.

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * source (any) - Any object with public `x` and `y` properties, such as a Game Object or Geometry object.

  Returns:  Phaser.Physics.Arcade.Body - The closest Dynamic Body to the given source point."
  ([arcade-physics source]
   (phaser->clj
    (.closest arcade-physics
              (clj->phaser source)))))

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
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * object-1 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The first object or array of objects to check.
    * object-2 (Phaser.Types.Physics.Arcade.ArcadeColliderType) {optional} - The second object or array of objects to check, or `undefined`.
    * collide-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they collide. If this is set then `collideCallback` will only be called if this callback returns `true`.
    * callback-context (*) {optional} - The context in which to run the callbacks.

  Returns:  boolean - True if any overlapping Game Objects were separated, otherwise false."
  ([arcade-physics object-1]
   (phaser->clj
    (.collide arcade-physics
              (clj->phaser object-1))))
  ([arcade-physics object-1 object-2]
   (phaser->clj
    (.collide arcade-physics
              (clj->phaser object-1)
              (clj->phaser object-2))))
  ([arcade-physics object-1 object-2 collide-callback]
   (phaser->clj
    (.collide arcade-physics
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback))))
  ([arcade-physics object-1 object-2 collide-callback process-callback]
   (phaser->clj
    (.collide arcade-physics
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback)
              (clj->phaser process-callback))))
  ([arcade-physics object-1 object-2 collide-callback process-callback callback-context]
   (phaser->clj
    (.collide arcade-physics
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback)
              (clj->phaser process-callback)
              (clj->phaser callback-context)))))

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
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * sprite (Phaser.GameObjects.GameObject) - The first object to check for collision.
    * tiles (Array.<Phaser.Tilemaps.Tile>) - An array of Tiles to check for collision against.
    * collide-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they collide. If this is set then `collideCallback` will only be called if this callback returns `true`.
    * callback-context (any) {optional} - The context in which to run the callbacks.

  Returns:  boolean - True if any objects overlap (with `overlapOnly`); or true if any overlapping objects were separated."
  ([arcade-physics sprite tiles]
   (phaser->clj
    (.collideTiles arcade-physics
                   (clj->phaser sprite)
                   (clj->phaser tiles))))
  ([arcade-physics sprite tiles collide-callback]
   (phaser->clj
    (.collideTiles arcade-physics
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback))))
  ([arcade-physics sprite tiles collide-callback process-callback]
   (phaser->clj
    (.collideTiles arcade-physics
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback)
                   (clj->phaser process-callback))))
  ([arcade-physics sprite tiles collide-callback process-callback callback-context]
   (phaser->clj
    (.collideTiles arcade-physics
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback)
                   (clj->phaser process-callback)
                   (clj->phaser callback-context)))))

(defn destroy
  "The Scene that owns this plugin is being destroyed.
  We need to shutdown and then kill off all external references."
  ([arcade-physics]
   (phaser->clj
    (.destroy arcade-physics))))

(defn furthest
  "Finds the Dynamic Body farthest from a source point or object.

  If two or more bodies are the exact same distance from the source point, only the first body
  is returned.

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * source (any) - Any object with public `x` and `y` properties, such as a Game Object or Geometry object.

  Returns:  Phaser.Physics.Arcade.Body - The Dynamic Body furthest away from the given source point."
  ([arcade-physics source]
   (phaser->clj
    (.furthest arcade-physics
               (clj->phaser source)))))

(defn get-config
  "Creates the physics configuration for the current Scene.

  Returns:  object - The physics configuration."
  ([arcade-physics]
   (phaser->clj
    (.getConfig arcade-physics))))

(defn move-to
  "Move the given display object towards the x/y coordinates at a steady velocity.
  If you specify a maxTime then it will adjust the speed (over-writing what you set) so it arrives at the destination in that number of seconds.
  Timings are approximate due to the way browser timers work. Allow for a variance of +- 50ms.
  Note: The display object does not continuously track the target. If the target changes location during transit the display object will not modify its course.
  Note: The display object doesn't stop moving once it reaches the destination coordinates.
  Note: Doesn't take into account acceleration, maxVelocity or drag (if you've set drag or acceleration too high this object may not move at all)

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - Any Game Object with an Arcade Physics body.
    * x (number) - The x coordinate to move towards.
    * y (number) - The y coordinate to move towards.
    * speed (number) {optional} - The speed it will move, in pixels per second (default is 60 pixels/sec)
    * max-time (number) {optional} - Time given in milliseconds (1000 = 1 sec). If set the speed is adjusted so the object will arrive at destination in the given number of ms.

  Returns:  number - The angle (in radians) that the object should be visually set to in order to match its new velocity."
  ([arcade-physics game-object x y]
   (phaser->clj
    (.moveTo arcade-physics
             (clj->phaser game-object)
             (clj->phaser x)
             (clj->phaser y))))
  ([arcade-physics game-object x y speed]
   (phaser->clj
    (.moveTo arcade-physics
             (clj->phaser game-object)
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser speed))))
  ([arcade-physics game-object x y speed max-time]
   (phaser->clj
    (.moveTo arcade-physics
             (clj->phaser game-object)
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser speed)
             (clj->phaser max-time)))))

(defn move-to-object
  "Move the given display object towards the destination object at a steady velocity.
  If you specify a maxTime then it will adjust the speed (overwriting what you set) so it arrives at the destination in that number of seconds.
  Timings are approximate due to the way browser timers work. Allow for a variance of +- 50ms.
  Note: The display object does not continuously track the target. If the target changes location during transit the display object will not modify its course.
  Note: The display object doesn't stop moving once it reaches the destination coordinates.
  Note: Doesn't take into account acceleration, maxVelocity or drag (if you've set drag or acceleration too high this object may not move at all)

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - Any Game Object with an Arcade Physics body.
    * destination (object) - Any object with public `x` and `y` properties, such as a Game Object or Geometry object.
    * speed (number) {optional} - The speed it will move, in pixels per second (default is 60 pixels/sec)
    * max-time (number) {optional} - Time given in milliseconds (1000 = 1 sec). If set the speed is adjusted so the object will arrive at destination in the given number of ms.

  Returns:  number - The angle (in radians) that the object should be visually set to in order to match its new velocity."
  ([arcade-physics game-object destination]
   (phaser->clj
    (.moveToObject arcade-physics
                   (clj->phaser game-object)
                   (clj->phaser destination))))
  ([arcade-physics game-object destination speed]
   (phaser->clj
    (.moveToObject arcade-physics
                   (clj->phaser game-object)
                   (clj->phaser destination)
                   (clj->phaser speed))))
  ([arcade-physics game-object destination speed max-time]
   (phaser->clj
    (.moveToObject arcade-physics
                   (clj->phaser game-object)
                   (clj->phaser destination)
                   (clj->phaser speed)
                   (clj->phaser max-time)))))

(defn overlap
  "Tests if Game Objects overlap. See {@link Phaser.Physics.Arcade.World#overlap}

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * object-1 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The first object or array of objects to check.
    * object-2 (Phaser.Types.Physics.Arcade.ArcadeColliderType) {optional} - The second object or array of objects to check, or `undefined`.
    * collide-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they overlap. If this is set then `collideCallback` will only be called if this callback returns `true`.
    * callback-context (*) {optional} - The context in which to run the callbacks.

  Returns:  boolean - True if at least one Game Object overlaps another."
  ([arcade-physics object-1]
   (phaser->clj
    (.overlap arcade-physics
              (clj->phaser object-1))))
  ([arcade-physics object-1 object-2]
   (phaser->clj
    (.overlap arcade-physics
              (clj->phaser object-1)
              (clj->phaser object-2))))
  ([arcade-physics object-1 object-2 collide-callback]
   (phaser->clj
    (.overlap arcade-physics
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback))))
  ([arcade-physics object-1 object-2 collide-callback process-callback]
   (phaser->clj
    (.overlap arcade-physics
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback)
              (clj->phaser process-callback))))
  ([arcade-physics object-1 object-2 collide-callback process-callback callback-context]
   (phaser->clj
    (.overlap arcade-physics
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback)
              (clj->phaser process-callback)
              (clj->phaser callback-context)))))

(defn overlap-rect
  "This method will search the given rectangular area and return an array of all physics bodies that
  overlap with it. It can return either Dynamic, Static bodies or a mixture of both.

  A body only has to intersect with the search area to be considered, it doesn't have to be fully
  contained within it.

  If Arcade Physics is set to use the RTree (which it is by default) then the search for is extremely fast,
  otherwise the search is O(N) for Dynamic Bodies.

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * x (number) - The top-left x coordinate of the area to search within.
    * y (number) - The top-left y coordinate of the area to search within.
    * width (number) - The width of the area to search within.
    * height (number) - The height of the area to search within.
    * include-dynamic (boolean) {optional} - Should the search include Dynamic Bodies?
    * include-static (boolean) {optional} - Should the search include Static Bodies?

  Returns:  Array.<Phaser.Physics.Arcade.Body> | Array.<Phaser.Physics.Arcade.StaticBody> - An array of bodies that overlap with the given area."
  ([arcade-physics x y width height]
   (phaser->clj
    (.overlapRect arcade-physics
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([arcade-physics x y width height include-dynamic]
   (phaser->clj
    (.overlapRect arcade-physics
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser include-dynamic))))
  ([arcade-physics x y width height include-dynamic include-static]
   (phaser->clj
    (.overlapRect arcade-physics
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser include-dynamic)
                  (clj->phaser include-static)))))

(defn overlap-tiles
  "This advanced method is specifically for testing for overlaps between a single Sprite and an array of Tile objects.

  You should generally use the `overlap` method instead, with a Sprite vs. a Tilemap Layer, as that will perform
  tile filtering and culling for you, as well as handle the interesting face collision automatically.

  This method is offered for those who would like to check for overlaps with specific Tiles in a layer, without
  having to set any collision attributes on the tiles in question. This allows you to perform quick dynamic overlap
  tests on small sets of Tiles. As such, no culling or checks are made to the array of Tiles given to this method,
  you should filter them before passing them to this method.

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * sprite (Phaser.GameObjects.GameObject) - The first object to check for collision.
    * tiles (Array.<Phaser.Tilemaps.Tile>) - An array of Tiles to check for collision against.
    * collide-callback (ArcadePhysicsCallback) {optional} - An optional callback function that is called if the objects overlap.
    * process-callback (ArcadePhysicsCallback) {optional} - An optional callback function that lets you perform additional checks against the two objects if they collide. If this is set then `collideCallback` will only be called if this callback returns `true`.
    * callback-context (any) {optional} - The context in which to run the callbacks.

  Returns:  boolean - True if any objects overlap (with `overlapOnly`); or true if any overlapping objects were separated."
  ([arcade-physics sprite tiles]
   (phaser->clj
    (.overlapTiles arcade-physics
                   (clj->phaser sprite)
                   (clj->phaser tiles))))
  ([arcade-physics sprite tiles collide-callback]
   (phaser->clj
    (.overlapTiles arcade-physics
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback))))
  ([arcade-physics sprite tiles collide-callback process-callback]
   (phaser->clj
    (.overlapTiles arcade-physics
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback)
                   (clj->phaser process-callback))))
  ([arcade-physics sprite tiles collide-callback process-callback callback-context]
   (phaser->clj
    (.overlapTiles arcade-physics
                   (clj->phaser sprite)
                   (clj->phaser tiles)
                   (clj->phaser collide-callback)
                   (clj->phaser process-callback)
                   (clj->phaser callback-context)))))

(defn pause
  "Pauses the simulation.

  Returns:  Phaser.Physics.Arcade.World - The simulation."
  ([arcade-physics]
   (phaser->clj
    (.pause arcade-physics))))

(defn resume
  "Resumes the simulation (if paused).

  Returns:  Phaser.Physics.Arcade.World - The simulation."
  ([arcade-physics]
   (phaser->clj
    (.resume arcade-physics))))

(defn shutdown
  "The Scene that owns this plugin is shutting down.
  We need to kill and reset all internal properties as well as stop listening to Scene events."
  ([arcade-physics]
   (phaser->clj
    (.shutdown arcade-physics))))

(defn velocity-from-angle
  "Given the angle (in degrees) and speed calculate the velocity and return it as a vector, or set it to the given vector object.
  One way to use this is: velocityFromAngle(angle, 200, sprite.body.velocity) which will set the values directly to the sprite's velocity and not create a new vector object.

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * angle (number) - The angle in degrees calculated in clockwise positive direction (down = 90 degrees positive, right = 0 degrees positive, up = 90 degrees negative)
    * speed (number) {optional} - The speed it will move, in pixels per second squared.
    * vec-2 (Phaser.Math.Vector2) {optional} - The Vector2 in which the x and y properties will be set to the calculated velocity.

  Returns:  Phaser.Math.Vector2 - The Vector2 that stores the velocity."
  ([arcade-physics angle]
   (phaser->clj
    (.velocityFromAngle arcade-physics
                        (clj->phaser angle))))
  ([arcade-physics angle speed]
   (phaser->clj
    (.velocityFromAngle arcade-physics
                        (clj->phaser angle)
                        (clj->phaser speed))))
  ([arcade-physics angle speed vec-2]
   (phaser->clj
    (.velocityFromAngle arcade-physics
                        (clj->phaser angle)
                        (clj->phaser speed)
                        (clj->phaser vec-2)))))

(defn velocity-from-rotation
  "Given the rotation (in radians) and speed calculate the velocity and return it as a vector, or set it to the given vector object.
  One way to use this is: velocityFromRotation(rotation, 200, sprite.body.velocity) which will set the values directly to the sprite's velocity and not create a new vector object.

  Parameters:
    * arcade-physics (Phaser.Physics.Arcade.ArcadePhysics) - Targeted instance for method
    * rotation (number) - The angle in radians.
    * speed (number) {optional} - The speed it will move, in pixels per second squared
    * vec-2 (Phaser.Math.Vector2) {optional} - The Vector2 in which the x and y properties will be set to the calculated velocity.

  Returns:  Phaser.Math.Vector2 - The Vector2 that stores the velocity."
  ([arcade-physics rotation]
   (phaser->clj
    (.velocityFromRotation arcade-physics
                           (clj->phaser rotation))))
  ([arcade-physics rotation speed]
   (phaser->clj
    (.velocityFromRotation arcade-physics
                           (clj->phaser rotation)
                           (clj->phaser speed))))
  ([arcade-physics rotation speed vec-2]
   (phaser->clj
    (.velocityFromRotation arcade-physics
                           (clj->phaser rotation)
                           (clj->phaser speed)
                           (clj->phaser vec-2)))))