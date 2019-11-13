(ns phzr.game-objects.particles.zones.edge-zone
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->EdgeZone
  "  Parameters:
    * source (Phaser.Types.GameObjects.Particles.EdgeZoneSource) - An object instance with a `getPoints(quantity, stepRate)` method returning an array of points.
    * quantity (integer) - The number of particles to place on the source edge. Set to 0 to use `stepRate` instead.
    * step-rate (number) - The distance between each particle. When set, `quantity` is implied and should be set to 0.
    * yoyo (boolean) {optional} - Whether particles are placed from start to end and then end to start.
    * seamless (boolean) {optional} - Whether one endpoint will be removed if it's identical to the other."
  ([source quantity step-rate]
   (js/Phaser.GameObjects.Particles.Zones.EdgeZone. (clj->phaser source)
                                                    (clj->phaser quantity)
                                                    (clj->phaser step-rate)))
  ([source quantity step-rate yoyo]
   (js/Phaser.GameObjects.Particles.Zones.EdgeZone. (clj->phaser source)
                                                    (clj->phaser quantity)
                                                    (clj->phaser step-rate)
                                                    (clj->phaser yoyo)))
  ([source quantity step-rate yoyo seamless]
   (js/Phaser.GameObjects.Particles.Zones.EdgeZone. (clj->phaser source)
                                                    (clj->phaser quantity)
                                                    (clj->phaser step-rate)
                                                    (clj->phaser yoyo)
                                                    (clj->phaser seamless))))

(defn change-source
  "Change the source of the EdgeZone.

  Parameters:
    * edge-zone (Phaser.GameObjects.Particles.Zones.EdgeZone) - Targeted instance for method
    * source (Phaser.Types.GameObjects.Particles.EdgeZoneSource) - An object instance with a `getPoints(quantity, stepRate)` method returning an array of points.

  Returns:  Phaser.GameObjects.Particles.Zones.EdgeZone - This Edge Zone."
  ([edge-zone source]
   (phaser->clj
    (.changeSource edge-zone
                   (clj->phaser source)))))

(defn get-point
  "Get the next point in the Zone and set its coordinates on the given Particle.

  Parameters:
    * edge-zone (Phaser.GameObjects.Particles.Zones.EdgeZone) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The Particle."
  ([edge-zone particle]
   (phaser->clj
    (.getPoint edge-zone
               (clj->phaser particle)))))

(defn update-source
  "Update the {@link Phaser.GameObjects.Particles.Zones.EdgeZone#points} from the EdgeZone's
  {@link Phaser.GameObjects.Particles.Zones.EdgeZone#source}.

  Also updates internal properties.

  Returns:  Phaser.GameObjects.Particles.Zones.EdgeZone - This Edge Zone."
  ([edge-zone]
   (phaser->clj
    (.updateSource edge-zone))))