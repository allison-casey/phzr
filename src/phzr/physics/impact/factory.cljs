(ns phzr.physics.impact.factory
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Factory
  "  Parameters:
    * world (Phaser.Physics.Impact.World) - A reference to the Impact Physics world."
  ([world]
   (js/Phaser.Physics.Impact.Factory. (clj->phaser world))))

(defn body
  "Creates a new ImpactBody object and adds it to the physics simulation.

  Parameters:
    * factory (Phaser.Physics.Impact.Factory) - Targeted instance for method
    * x (number) - The horizontal position of the body in the physics world.
    * y (number) - The vertical position of the body in the physics world.
    * width (number) - The width of the body.
    * height (number) - The height of the body.

  Returns:  Phaser.Physics.Impact.ImpactBody - The ImpactBody object that was created."
  ([factory x y width height]
   (phaser->clj
    (.body factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)))))

(defn destroy
  "Destroys this Factory."
  ([factory]
   (phaser->clj
    (.destroy factory))))

(defn existing
  "Adds an Impact Physics Body to the given Game Object.

  Parameters:
    * factory (Phaser.Physics.Impact.Factory) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object to receive the physics body.

  Returns:  Phaser.GameObjects.GameObject - The Game Object."
  ([factory game-object]
   (phaser->clj
    (.existing factory
               (clj->phaser game-object)))))

(defn image
  "Creates a new ImpactImage object and adds it to the physics world.

  Parameters:
    * factory (Phaser.Physics.Impact.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * key (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.Physics.Impact.ImpactImage - The ImpactImage object that was created."
  ([factory x y key]
   (phaser->clj
    (.image factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser key))))
  ([factory x y key frame]
   (phaser->clj
    (.image factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser key)
            (clj->phaser frame)))))

(defn sprite
  "Creates a new ImpactSprite object and adds it to the physics world.

  Parameters:
    * factory (Phaser.Physics.Impact.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * key (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.Physics.Impact.ImpactSprite - The ImpactSprite object that was created."
  ([factory x y key]
   (phaser->clj
    (.sprite factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key))))
  ([factory x y key frame]
   (phaser->clj
    (.sprite factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key)
             (clj->phaser frame)))))