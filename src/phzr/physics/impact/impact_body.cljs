(ns phzr.physics.impact.impact-body
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->ImpactBody
  "  Parameters:
    * world (Phaser.Physics.Impact.World) - [description]
    * x (number) - x - The horizontal position of this physics body in the world.
    * y (number) - y - The vertical position of this physics body in the world.
    * width (number) - The width of the physics body in the world.
    * height (number) - [description]"
  ([world x y width height]
   (js/Phaser.Physics.Impact.ImpactBody. (clj->phaser world)
                                         (clj->phaser x)
                                         (clj->phaser y)
                                         (clj->phaser width)
                                         (clj->phaser height))))

(defn get-body-type
  "[description]

  Returns:  number - [description]"
  ([impact-body]
   (phaser->clj
    (.getBodyType impact-body))))

(defn set-acceleration
  "Sets the horizontal and vertical acceleration of this body.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * x (number) - The amount of horizontal acceleration to apply.
    * y (number) - The amount of vertical acceleration to apply.

  Returns:  this - This Game Object."
  ([impact-body x y]
   (phaser->clj
    (.setAcceleration impact-body
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-acceleration-x
  "Sets the horizontal acceleration of this body.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * x (number) - The amount of acceleration to apply.

  Returns:  this - This Game Object."
  ([impact-body x]
   (phaser->clj
    (.setAccelerationX impact-body
                       (clj->phaser x)))))

(defn set-acceleration-y
  "Sets the vertical acceleration of this body.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * y (number) - The amount of acceleration to apply.

  Returns:  this - This Game Object."
  ([impact-body y]
   (phaser->clj
    (.setAccelerationY impact-body
                       (clj->phaser y)))))

(defn set-active-collision
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setActiveCollision impact-body))))

(defn set-avs-b
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setAvsB impact-body))))

(defn set-body-scale
  "Sets the scale of the physics body.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * scale-x (number) - The horizontal scale of the body.
    * scale-y (number) {optional} - The vertical scale of the body. If not given, will use the horizontal scale value.

  Returns:  this - This Game Object."
  ([impact-body scale-x]
   (phaser->clj
    (.setBodyScale impact-body
                   (clj->phaser scale-x))))
  ([impact-body scale-x scale-y]
   (phaser->clj
    (.setBodyScale impact-body
                   (clj->phaser scale-x)
                   (clj->phaser scale-y)))))

(defn set-body-size
  "Sets the size of the physics body.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * width (number) - The width of the body in pixels.
    * height (number) {optional} - The height of the body in pixels.

  Returns:  this - This Game Object."
  ([impact-body width]
   (phaser->clj
    (.setBodySize impact-body
                  (clj->phaser width))))
  ([impact-body width height]
   (phaser->clj
    (.setBodySize impact-body
                  (clj->phaser width)
                  (clj->phaser height)))))

(defn set-bounce
  "Sets the impact physics bounce, or restitution, value.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * value (number) - A value between 0 (no rebound) and 1 (full rebound)

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body value]
   (phaser->clj
    (.setBounce impact-body
                (clj->phaser value)))))

(defn set-bvs-a
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setBvsA impact-body))))

(defn set-check-against-a
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setCheckAgainstA impact-body))))

(defn set-check-against-b
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setCheckAgainstB impact-body))))

(defn set-check-against-none
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setCheckAgainstNone impact-body))))

(defn set-collide-callback
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * callback (CollideCallback) - [description]
    * scope (*) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body callback scope]
   (phaser->clj
    (.setCollideCallback impact-body
                         (clj->phaser callback)
                         (clj->phaser scope)))))

(defn set-collides-never
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setCollidesNever impact-body))))

(defn set-debug
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * show-body (boolean) - [description]
    * show-velocity (boolean) - [description]
    * body-color (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body show-body show-velocity body-color]
   (phaser->clj
    (.setDebug impact-body
               (clj->phaser show-body)
               (clj->phaser show-velocity)
               (clj->phaser body-color)))))

(defn set-debug-body-color
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * value (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body value]
   (phaser->clj
    (.setDebugBodyColor impact-body
                        (clj->phaser value)))))

(defn set-fixed-collision
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setFixedCollision impact-body))))

(defn set-friction
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body x y]
   (phaser->clj
    (.setFriction impact-body
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-friction-x
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * x (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body x]
   (phaser->clj
    (.setFrictionX impact-body
                   (clj->phaser x)))))

(defn set-friction-y
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * y (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body y]
   (phaser->clj
    (.setFrictionY impact-body
                   (clj->phaser y)))))

(defn set-game-object
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - [description]
    * sync (boolean) {optional} - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body game-object]
   (phaser->clj
    (.setGameObject impact-body
                    (clj->phaser game-object))))
  ([impact-body game-object sync]
   (phaser->clj
    (.setGameObject impact-body
                    (clj->phaser game-object)
                    (clj->phaser sync)))))

(defn set-gravity
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * value (number) - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body value]
   (phaser->clj
    (.setGravity impact-body
                 (clj->phaser value)))))

(defn set-lite-collision
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setLiteCollision impact-body))))

(defn set-max-velocity
  "Sets the maximum velocity this body can travel at.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * x (number) - The maximum allowed horizontal velocity.
    * y (number) {optional} - The maximum allowed vertical velocity. If not given, defaults to the horizontal value.

  Returns:  this - This Game Object."
  ([impact-body x]
   (phaser->clj
    (.setMaxVelocity impact-body
                     (clj->phaser x))))
  ([impact-body x y]
   (phaser->clj
    (.setMaxVelocity impact-body
                     (clj->phaser x)
                     (clj->phaser y)))))

(defn set-min-bounce-velocity
  "Sets the minimum velocity the body is allowed to be moving to be considered for rebound.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * value (number) - The minimum allowed velocity.

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body value]
   (phaser->clj
    (.setMinBounceVelocity impact-body
                           (clj->phaser value)))))

(defn set-offset
  "[description]

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]
    * width (number) {optional} - [description]
    * height (number) {optional} - [description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body x y]
   (phaser->clj
    (.setOffset impact-body
                (clj->phaser x)
                (clj->phaser y))))
  ([impact-body x y width]
   (phaser->clj
    (.setOffset impact-body
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width))))
  ([impact-body x y width height]
   (phaser->clj
    (.setOffset impact-body
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)))))

(defn set-passive-collision
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setPassiveCollision impact-body))))

(defn set-type-a
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setTypeA impact-body))))

(defn set-type-b
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setTypeB impact-body))))

(defn set-type-none
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.setTypeNone impact-body))))

(defn set-velocity
  "Sets the horizontal and vertical velocities of the physics body.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * x (number) - The horizontal velocity value.
    * y (number) {optional} - The vertical velocity value. If not given, defaults to the horizontal value.

  Returns:  this - This Game Object."
  ([impact-body x]
   (phaser->clj
    (.setVelocity impact-body
                  (clj->phaser x))))
  ([impact-body x y]
   (phaser->clj
    (.setVelocity impact-body
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-velocity-x
  "Sets the horizontal velocity of the physics body.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * x (number) - The horizontal velocity value.

  Returns:  this - This Game Object."
  ([impact-body x]
   (phaser->clj
    (.setVelocityX impact-body
                   (clj->phaser x)))))

(defn set-velocity-y
  "Sets the vertical velocity of the physics body.

  Parameters:
    * impact-body (Phaser.Physics.Impact.ImpactBody) - Targeted instance for method
    * y (number) - The vertical velocity value.

  Returns:  this - This Game Object."
  ([impact-body y]
   (phaser->clj
    (.setVelocityY impact-body
                   (clj->phaser y)))))

(defn sync-game-object
  "[description]

  Returns:  Phaser.GameObjects.GameObject - This Game Object."
  ([impact-body]
   (phaser->clj
    (.syncGameObject impact-body))))