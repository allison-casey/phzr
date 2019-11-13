(ns phzr.physics.impact.impact-physics
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->ImpactPhysics
  "  Parameters:
    * scene (Phaser.Scene) - [description]"
  ([scene]
   (js/Phaser.Physics.Impact.ImpactPhysics. (clj->phaser scene))))

(defn get-config
  "[description]

  Returns:  object - [description]"
  ([impact-physics]
   (phaser->clj
    (.getConfig impact-physics))))

(defn pause
  "[description]

  Returns:  Phaser.Physics.Impact.World - The Impact World object."
  ([impact-physics]
   (phaser->clj
    (.pause impact-physics))))

(defn resume
  "[description]

  Returns:  Phaser.Physics.Impact.World - The Impact World object."
  ([impact-physics]
   (phaser->clj
    (.resume impact-physics))))