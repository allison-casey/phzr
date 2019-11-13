(ns phzr.physics.arcade.body
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Body
  "  Parameters:
    * world (Phaser.Physics.Arcade.World) - The Arcade Physics simulation this Body belongs to.
    * game-object (Phaser.GameObjects.GameObject) - The Game Object this Body belongs to."
  ([world game-object]
   (js/Phaser.Physics.Arcade.Body. (clj->phaser world)
                                   (clj->phaser game-object))))

(defn check-world-bounds
  "Checks for collisions between this Body and the world boundary and separates them.

  Returns:  boolean - True if this Body is colliding with the world boundary."
  ([body]
   (phaser->clj
    (.checkWorldBounds body))))

(defn delta-abs-x
  "The absolute (non-negative) change in this Body's horizontal position from the previous step.

  Returns:  number - The delta value."
  ([body]
   (phaser->clj
    (.deltaAbsX body))))

(defn delta-abs-y
  "The absolute (non-negative) change in this Body's vertical position from the previous step.

  Returns:  number - The delta value."
  ([body]
   (phaser->clj
    (.deltaAbsY body))))

(defn delta-x
  "The change in this Body's horizontal position from the previous step.
  This value is set during the Body's update phase.

  Returns:  number - The delta value."
  ([body]
   (phaser->clj
    (.deltaX body))))

(defn delta-y
  "The change in this Body's vertical position from the previous step.
  This value is set during the Body's update phase.

  Returns:  number - The delta value."
  ([body]
   (phaser->clj
    (.deltaY body))))

(defn delta-z
  "The change in this Body's rotation from the previous step, in degrees.

  Returns:  number - The delta value."
  ([body]
   (phaser->clj
    (.deltaZ body))))

(defn destroy
  "Disables this Body and marks it for deletion by the simulation."
  ([body]
   (phaser->clj
    (.destroy body))))

(defn draw-debug
  "Draws this Body's boundary and velocity, if enabled.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * graphic (Phaser.GameObjects.Graphics) - The Graphics object to draw on."
  ([body graphic]
   (phaser->clj
    (.drawDebug body
                (clj->phaser graphic)))))

(defn get-bounds
  "Copies the coordinates of this Body's edges into an object.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * obj (Phaser.Types.Physics.Arcade.ArcadeBodyBounds) - An object to copy the values into.

  Returns:  Phaser.Types.Physics.Arcade.ArcadeBodyBounds - - An object with {x, y, right, bottom}."
  ([body obj]
   (phaser->clj
    (.getBounds body
                (clj->phaser obj)))))

(defn hit-test
  "Tests if the coordinates are within this Body's boundary.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal coordinate.
    * y (number) - The vertical coordinate.

  Returns:  boolean - True if (x, y) is within this Body."
  ([body x y]
   (phaser->clj
    (.hitTest body
              (clj->phaser x)
              (clj->phaser y)))))

(defn on-ceiling
  "Whether this Body is touching a tile or the world boundary while moving up.

  Returns:  boolean - True if touching."
  ([body]
   (phaser->clj
    (.onCeiling body))))

(defn on-floor
  "Whether this Body is touching a tile or the world boundary while moving down.

  Returns:  boolean - True if touching."
  ([body]
   (phaser->clj
    (.onFloor body))))

(defn on-wall
  "Whether this Body is touching a tile or the world boundary while moving left or right.

  Returns:  boolean - True if touching."
  ([body]
   (phaser->clj
    (.onWall body))))

(defn post-update
  "Feeds the Body results back into the parent Game Object.

  This method is called every game frame, regardless if the world steps or not."
  ([body]
   (phaser->clj
    (.postUpdate body))))

(defn pre-update
  "Syncs the position body position with the parent Game Object.

  This method is called every game frame, regardless if the world steps or not.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * will-step (boolean) - Will this Body run an update as well?
    * delta (number) - The delta time, in seconds, elapsed since the last frame."
  ([body will-step delta]
   (phaser->clj
    (.preUpdate body
                (clj->phaser will-step)
                (clj->phaser delta)))))

(defn reset
  "Resets this Body to the given coordinates. Also positions its parent Game Object to the same coordinates.
  If the Body had any velocity or acceleration it is lost as a result of calling this.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal position to place the Game Object and Body.
    * y (number) - The vertical position to place the Game Object and Body."
  ([body x y]
   (phaser->clj
    (.reset body
            (clj->phaser x)
            (clj->phaser y)))))

(defn reset-flags
  "Prepares the Body for a physics step by resetting the `wasTouching`, `touching` and `blocked` states.

  This method is only called if the physics world is going to run a step this frame."
  ([body]
   (phaser->clj
    (.resetFlags body))))

(defn set-acceleration
  "Sets the Body's acceleration.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal component, in pixels per second squared.
    * y (number) - The vertical component, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body x y]
   (phaser->clj
    (.setAcceleration body
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-acceleration-x
  "Sets the Body's horizontal acceleration.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The acceleration, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setAccelerationX body
                       (clj->phaser value)))))

(defn set-acceleration-y
  "Sets the Body's vertical acceleration.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The acceleration, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setAccelerationY body
                       (clj->phaser value)))))

(defn set-allow-drag
  "Enables or disables drag.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (boolean) {optional} - `true` to allow drag on this body, or `false` to disable it.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body]
   (phaser->clj
    (.setAllowDrag body)))
  ([body value]
   (phaser->clj
    (.setAllowDrag body
                   (clj->phaser value)))))

(defn set-allow-gravity
  "Enables or disables gravity's effect on this Body.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (boolean) {optional} - `true` to allow gravity on this body, or `false` to disable it.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body]
   (phaser->clj
    (.setAllowGravity body)))
  ([body value]
   (phaser->clj
    (.setAllowGravity body
                      (clj->phaser value)))))

(defn set-allow-rotation
  "Enables or disables rotation.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (boolean) {optional} - `true` to allow rotation on this body, or `false` to disable it.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body]
   (phaser->clj
    (.setAllowRotation body)))
  ([body value]
   (phaser->clj
    (.setAllowRotation body
                       (clj->phaser value)))))

(defn set-angular-acceleration
  "Sets the Body's angular acceleration.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The acceleration, in degrees per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setAngularAcceleration body
                             (clj->phaser value)))))

(defn set-angular-drag
  "Sets the Body's angular drag.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The drag, in degrees per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setAngularDrag body
                     (clj->phaser value)))))

(defn set-angular-velocity
  "Sets the Body's angular velocity.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The velocity, in degrees per second.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setAngularVelocity body
                         (clj->phaser value)))))

(defn set-bounce
  "Sets the Body's bounce.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal bounce, relative to 1.
    * y (number) - The vertical bounce, relative to 1.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body x y]
   (phaser->clj
    (.setBounce body
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-bounce-x
  "Sets the Body's horizontal bounce.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The bounce, relative to 1.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setBounceX body
                 (clj->phaser value)))))

(defn set-bounce-y
  "Sets the Body's vertical bounce.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The bounce, relative to 1.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setBounceY body
                 (clj->phaser value)))))

(defn set-bounds-rectangle
  "Sets a custom collision boundary rectangle. Use if you want to have a custom
  boundary instead of the world boundaries.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * bounds (Phaser.Geom.Rectangle) {optional} - The new boundary rectangle. Pass `null` to use the World bounds.

  Returns:  this - This Body object."
  ([body]
   (phaser->clj
    (.setBoundsRectangle body)))
  ([body bounds]
   (phaser->clj
    (.setBoundsRectangle body
                         (clj->phaser bounds)))))

(defn set-circle
  "Sizes and positions this Body's boundary, as a circle.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * radius (number) - The radius of the Body, in source pixels.
    * offset-x (number) {optional} - The horizontal offset of the Body from its Game Object, in source pixels.
    * offset-y (number) {optional} - The vertical offset of the Body from its Game Object, in source pixels.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body radius]
   (phaser->clj
    (.setCircle body
                (clj->phaser radius))))
  ([body radius offset-x]
   (phaser->clj
    (.setCircle body
                (clj->phaser radius)
                (clj->phaser offset-x))))
  ([body radius offset-x offset-y]
   (phaser->clj
    (.setCircle body
                (clj->phaser radius)
                (clj->phaser offset-x)
                (clj->phaser offset-y)))))

(defn set-collide-world-bounds
  "Sets whether this Body collides with the world boundary.

  Optionally also sets the World Bounce values. If the `Body.worldBounce` is null, it's set to a new Vec2 first.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (boolean) {optional} - `true` if this body should collide with the world bounds, otherwise `false`.
    * bounce-x (number) {optional} - If given this will be replace the `worldBounce.x` value.
    * bounce-y (number) {optional} - If given this will be replace the `worldBounce.y` value.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body]
   (phaser->clj
    (.setCollideWorldBounds body)))
  ([body value]
   (phaser->clj
    (.setCollideWorldBounds body
                            (clj->phaser value))))
  ([body value bounce-x]
   (phaser->clj
    (.setCollideWorldBounds body
                            (clj->phaser value)
                            (clj->phaser bounce-x))))
  ([body value bounce-x bounce-y]
   (phaser->clj
    (.setCollideWorldBounds body
                            (clj->phaser value)
                            (clj->phaser bounce-x)
                            (clj->phaser bounce-y)))))

(defn set-drag
  "Sets the Body's drag.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal component, in pixels per second squared.
    * y (number) - The vertical component, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body x y]
   (phaser->clj
    (.setDrag body
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-drag-x
  "Sets the Body's horizontal drag.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The drag, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setDragX body
               (clj->phaser value)))))

(defn set-drag-y
  "Sets the Body's vertical drag.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The drag, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setDragY body
               (clj->phaser value)))))

(defn set-enable
  "Sets the Body's `enable` property.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (boolean) {optional} - The value to assign to `enable`.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body]
   (phaser->clj
    (.setEnable body)))
  ([body value]
   (phaser->clj
    (.setEnable body
                (clj->phaser value)))))

(defn set-friction
  "Sets the Body's friction.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal component, relative to 1.
    * y (number) - The vertical component, relative to 1.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body x y]
   (phaser->clj
    (.setFriction body
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-friction-x
  "Sets the Body's horizontal friction.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The friction value, relative to 1.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setFrictionX body
                   (clj->phaser value)))))

(defn set-friction-y
  "Sets the Body's vertical friction.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The friction value, relative to 1.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setFrictionY body
                   (clj->phaser value)))))

(defn set-gravity
  "Sets the Body's gravity.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal component, in pixels per second squared.
    * y (number) - The vertical component, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body x y]
   (phaser->clj
    (.setGravity body
                 (clj->phaser x)
                 (clj->phaser y)))))

(defn set-gravity-x
  "Sets the Body's horizontal gravity.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The gravity, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setGravityX body
                  (clj->phaser value)))))

(defn set-gravity-y
  "Sets the Body's vertical gravity.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The gravity, in pixels per second squared.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setGravityY body
                  (clj->phaser value)))))

(defn set-immovable
  "Sets the Body's `immovable` property.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (boolean) {optional} - The value to assign to `immovable`.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body]
   (phaser->clj
    (.setImmovable body)))
  ([body value]
   (phaser->clj
    (.setImmovable body
                   (clj->phaser value)))))

(defn set-mass
  "Sets the Body's mass.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The mass value, relative to 1.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setMass body
              (clj->phaser value)))))

(defn set-max-speed
  "Sets the maximum speed the Body can move.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The maximum speed value, in pixels per second. Set to a negative value to disable.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setMaxSpeed body
                  (clj->phaser value)))))

(defn set-max-velocity
  "Sets the Body's maximum velocity.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal velocity, in pixels per second.
    * y (number) {optional} - The vertical velocity, in pixels per second.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body x]
   (phaser->clj
    (.setMaxVelocity body
                     (clj->phaser x))))
  ([body x y]
   (phaser->clj
    (.setMaxVelocity body
                     (clj->phaser x)
                     (clj->phaser y)))))

(defn set-offset
  "Sets the offset of the Body's position from its Game Object's position.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal offset, in source pixels.
    * y (number) {optional} - The vertical offset, in source pixels.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body x]
   (phaser->clj
    (.setOffset body
                (clj->phaser x))))
  ([body x y]
   (phaser->clj
    (.setOffset body
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-size
  "Sizes and positions this Body's boundary, as a rectangle.
  Modifies the Body `offset` if `center` is true (the default).
  Resets the width and height to match current frame, if no width and height provided and a frame is found.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * width (integer) {optional} - The width of the Body in pixels. Cannot be zero. If not given, and the parent Game Object has a frame, it will use the frame width.
    * height (integer) {optional} - The height of the Body in pixels. Cannot be zero. If not given, and the parent Game Object has a frame, it will use the frame height.
    * center (boolean) {optional} - Modify the Body's `offset`, placing the Body's center on its Game Object's center. Only works if the Game Object has the `getCenter` method.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body]
   (phaser->clj
    (.setSize body)))
  ([body width]
   (phaser->clj
    (.setSize body
              (clj->phaser width))))
  ([body width height]
   (phaser->clj
    (.setSize body
              (clj->phaser width)
              (clj->phaser height))))
  ([body width height center]
   (phaser->clj
    (.setSize body
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser center)))))

(defn set-velocity
  "Sets the Body's velocity.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * x (number) - The horizontal velocity, in pixels per second.
    * y (number) {optional} - The vertical velocity, in pixels per second.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body x]
   (phaser->clj
    (.setVelocity body
                  (clj->phaser x))))
  ([body x y]
   (phaser->clj
    (.setVelocity body
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-velocity-x
  "Sets the Body's horizontal velocity.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The velocity, in pixels per second.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setVelocityX body
                   (clj->phaser value)))))

(defn set-velocity-y
  "Sets the Body's vertical velocity.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * value (number) - The velocity, in pixels per second.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body value]
   (phaser->clj
    (.setVelocityY body
                   (clj->phaser value)))))

(defn stop
  "Sets acceleration, velocity, and speed to zero.

  Returns:  Phaser.Physics.Arcade.Body - This Body object."
  ([body]
   (phaser->clj
    (.stop body))))

(defn update
  "Performs a single physics step and updates the body velocity, angle, speed and other properties.

  This method can be called multiple times per game frame, depending on the physics step rate.

  The results are synced back to the Game Object in `postUpdate`.

  Parameters:
    * body (Phaser.Physics.Arcade.Body) - Targeted instance for method
    * delta (number) - The delta time, in seconds, elapsed since the last frame."
  ([body delta]
   (phaser->clj
    (.update body
             (clj->phaser delta)))))

(defn update-bounds
  "Updates the Body's `transform`, `width`, `height`, and `center` from its Game Object.
  The Body's `position` isn't changed."
  ([body]
   (phaser->clj
    (.updateBounds body))))

(defn update-center
  "Updates the Body's `center` from its `position`, `width`, and `height`."
  ([body]
   (phaser->clj
    (.updateCenter body))))

(defn will-draw-debug
  "Whether this Body will be drawn to the debug display.

  Returns:  boolean - True if either `debugShowBody` or `debugShowVelocity` are enabled."
  ([body]
   (phaser->clj
    (.willDrawDebug body))))