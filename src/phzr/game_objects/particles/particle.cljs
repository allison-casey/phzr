(ns phzr.game-objects.particles.particle
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Particle
  "  Parameters:
    * emitter (Phaser.GameObjects.Particles.ParticleEmitter) - The Emitter to which this Particle belongs."
  ([emitter]
   (js/Phaser.GameObjects.Particles.Particle. (clj->phaser emitter))))

(defn check-bounds
  "Checks if this Particle is still within the bounds defined by the given Emitter.

  If not, and depending on the Emitter collision flags, the Particle may either stop or rebound.

  Parameters:
    * particle (Phaser.GameObjects.Particles.Particle) - Targeted instance for method
    * emitter (Phaser.GameObjects.Particles.ParticleEmitter) - The Emitter to check the bounds against."
  ([particle emitter]
   (phaser->clj
    (.checkBounds particle
                  (clj->phaser emitter)))))

(defn compute-velocity
  "An internal method that calculates the velocity of the Particle.

  Parameters:
    * particle (Phaser.GameObjects.Particles.Particle) - Targeted instance for method
    * emitter (Phaser.GameObjects.Particles.ParticleEmitter) - The Emitter that is updating this Particle.
    * delta (number) - The delta time in ms.
    * step (number) - The delta value divided by 1000.
    * processors (array) - Particle processors (gravity wells)."
  ([particle emitter delta step processors]
   (phaser->clj
    (.computeVelocity particle
                      (clj->phaser emitter)
                      (clj->phaser delta)
                      (clj->phaser step)
                      (clj->phaser processors)))))

(defn fire
  "Starts this Particle from the given coordinates.

  Parameters:
    * particle (Phaser.GameObjects.Particles.Particle) - Targeted instance for method
    * x (number) - The x coordinate to launch this Particle from.
    * y (number) - The y coordinate to launch this Particle from."
  ([particle x y]
   (phaser->clj
    (.fire particle
           (clj->phaser x)
           (clj->phaser y)))))

(defn is-alive
  "Checks to see if this Particle is alive and updating.

  Returns:  boolean - `true` if this Particle is alive and updating, otherwise `false`."
  ([particle]
   (phaser->clj
    (.isAlive particle))))

(defn reset-position
  "Resets the position of this particle back to zero."
  ([particle]
   (phaser->clj
    (.resetPosition particle))))

(defn update
  "The main update method for this Particle.

  Updates its life values, computes the velocity and repositions the Particle.

  Parameters:
    * particle (Phaser.GameObjects.Particles.Particle) - Targeted instance for method
    * delta (number) - The delta time in ms.
    * step (number) - The delta value divided by 1000.
    * processors (array) - An optional array of update processors.

  Returns:  boolean - Returns `true` if this Particle has now expired and should be removed, otherwise `false` if still active."
  ([particle delta step processors]
   (phaser->clj
    (.update particle
             (clj->phaser delta)
             (clj->phaser step)
             (clj->phaser processors)))))