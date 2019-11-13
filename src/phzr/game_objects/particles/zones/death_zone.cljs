(ns phzr.game-objects.particles.zones.death-zone
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->DeathZone
  "  Parameters:
    * source (Phaser.Types.GameObjects.Particles.DeathZoneSource) - An object instance that has a `contains` method that returns a boolean when given `x` and `y` arguments.
    * kill-on-enter (boolean) - Should the Particle be killed when it enters the zone? `true` or leaves it? `false`"
  ([source kill-on-enter]
   (js/Phaser.GameObjects.Particles.Zones.DeathZone. (clj->phaser source)
                                                     (clj->phaser kill-on-enter))))

(defn will-kill
  "Checks if the given Particle will be killed or not by this zone.

  Parameters:
    * death-zone (Phaser.GameObjects.Particles.Zones.DeathZone) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The Particle to be checked against this zone.

  Returns:  boolean - Return `true` if the Particle is to be killed, otherwise return `false`."
  ([death-zone particle]
   (phaser->clj
    (.willKill death-zone
               (clj->phaser particle)))))