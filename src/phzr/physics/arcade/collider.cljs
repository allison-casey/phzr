(ns phzr.physics.arcade.collider
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Collider
  "  Parameters:
    * world (Phaser.Physics.Arcade.World) - The Arcade physics World that will manage the collisions.
    * overlap-only (boolean) - Whether to check for collisions or overlap.
    * object-1 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The first object to check for collision.
    * object-2 (Phaser.Types.Physics.Arcade.ArcadeColliderType) - The second object to check for collision.
    * collide-callback (ArcadePhysicsCallback) - The callback to invoke when the two objects collide.
    * process-callback (ArcadePhysicsCallback) - The callback to invoke when the two objects collide. Must return a boolean.
    * callback-context (any) - The scope in which to call the callbacks."
  ([world overlap-only object-1 object-2 collide-callback process-callback callback-context]
   (js/Phaser.Physics.Arcade.Collider. (clj->phaser world)
                                       (clj->phaser overlap-only)
                                       (clj->phaser object-1)
                                       (clj->phaser object-2)
                                       (clj->phaser collide-callback)
                                       (clj->phaser process-callback)
                                       (clj->phaser callback-context))))

(defn destroy
  "Removes Collider from World and disposes of its resources."
  ([collider]
   (phaser->clj
    (.destroy collider))))

(defn set-name
  "A name for the Collider.

  Phaser does not use this value, it's for your own reference.

  Parameters:
    * collider (Phaser.Physics.Arcade.Collider) - Targeted instance for method
    * name (string) - The name to assign to the Collider.

  Returns:  Phaser.Physics.Arcade.Collider - This Collider instance."
  ([collider name]
   (phaser->clj
    (.setName collider
              (clj->phaser name)))))

(defn update
  "Called by World as part of its step processing, initial operation of collision checking."
  ([collider]
   (phaser->clj
    (.update collider))))