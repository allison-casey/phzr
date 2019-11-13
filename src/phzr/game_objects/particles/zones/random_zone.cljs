(ns phzr.game-objects.particles.zones.random-zone
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->RandomZone
  "  Parameters:
    * source (Phaser.Types.GameObjects.Particles.RandomZoneSource) - An object instance with a `getRandomPoint(point)` method."
  ([source]
   (js/Phaser.GameObjects.Particles.Zones.RandomZone. (clj->phaser source))))

(defn get-point
  "Get the next point in the Zone and set its coordinates on the given Particle.

  Parameters:
    * random-zone (Phaser.GameObjects.Particles.Zones.RandomZone) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The Particle."
  ([random-zone particle]
   (phaser->clj
    (.getPoint random-zone
               (clj->phaser particle)))))