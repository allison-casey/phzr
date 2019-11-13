(ns phzr.game-objects.particles.gravity-well
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->GravityWell
  "  Parameters:
    * x (number | Phaser.Types.GameObjects.Particles.GravityWellConfig) {optional} - The x coordinate of the Gravity Well, in world space.
    * y (number) {optional} - The y coordinate of the Gravity Well, in world space.
    * power (number) {optional} - The strength of the gravity force - larger numbers produce a stronger force.
    * epsilon (number) {optional} - The minimum distance for which the gravity force is calculated.
    * gravity (number) {optional} - The gravitational force of this Gravity Well."
  ([]
   (js/Phaser.GameObjects.Particles.GravityWell.))
  ([x]
   (js/Phaser.GameObjects.Particles.GravityWell. (clj->phaser x)))
  ([x y]
   (js/Phaser.GameObjects.Particles.GravityWell. (clj->phaser x)
                                                 (clj->phaser y)))
  ([x y power]
   (js/Phaser.GameObjects.Particles.GravityWell. (clj->phaser x)
                                                 (clj->phaser y)
                                                 (clj->phaser power)))
  ([x y power epsilon]
   (js/Phaser.GameObjects.Particles.GravityWell. (clj->phaser x)
                                                 (clj->phaser y)
                                                 (clj->phaser power)
                                                 (clj->phaser epsilon)))
  ([x y power epsilon gravity]
   (js/Phaser.GameObjects.Particles.GravityWell. (clj->phaser x)
                                                 (clj->phaser y)
                                                 (clj->phaser power)
                                                 (clj->phaser epsilon)
                                                 (clj->phaser gravity))))

(defn update
  "Takes a Particle and updates it based on the properties of this Gravity Well.

  Parameters:
    * gravity-well (Phaser.GameObjects.Particles.GravityWell) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The Particle to update.
    * delta (number) - The delta time in ms.
    * step (number) - The delta value divided by 1000."
  ([gravity-well particle delta step]
   (phaser->clj
    (.update gravity-well
             (clj->phaser particle)
             (clj->phaser delta)
             (clj->phaser step)))))