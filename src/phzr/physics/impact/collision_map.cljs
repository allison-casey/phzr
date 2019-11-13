(ns phzr.physics.impact.collision-map
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->CollisionMap
  "  Parameters:
    * tilesize (integer) {optional} - [description]
    * data (array) {optional} - [description]"
  ([]
   (js/Phaser.Physics.Impact.CollisionMap.))
  ([tilesize]
   (js/Phaser.Physics.Impact.CollisionMap. (clj->phaser tilesize)))
  ([tilesize data]
   (js/Phaser.Physics.Impact.CollisionMap. (clj->phaser tilesize)
                                           (clj->phaser data))))

(defn check-def
  "[description]

  Parameters:
    * collision-map (Phaser.Physics.Impact.CollisionMap) - Targeted instance for method
    * res (object) - [description]
    * t (number) - [description]
    * x (number) - [description]
    * y (number) - [description]
    * vx (number) - [description]
    * vy (number) - [description]
    * width (number) - [description]
    * height (number) - [description]
    * tile-x (number) - [description]
    * tile-y (number) - [description]

  Returns:  boolean - [description]"
  ([collision-map res t x y vx vy width height tile-x tile-y]
   (phaser->clj
    (.checkDef collision-map
               (clj->phaser res)
               (clj->phaser t)
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser vx)
               (clj->phaser vy)
               (clj->phaser width)
               (clj->phaser height)
               (clj->phaser tile-x)
               (clj->phaser tile-y)))))

(defn step
  "[description]

  Parameters:
    * collision-map (Phaser.Physics.Impact.CollisionMap) - Targeted instance for method
    * res (object) - [description]
    * x (number) - [description]
    * y (number) - [description]
    * vx (number) - [description]
    * vy (number) - [description]
    * width (number) - [description]
    * height (number) - [description]
    * rvx (number) - [description]
    * rvy (number) - [description]
    * step (number) - [description]"
  ([collision-map res x y vx vy width height rvx rvy step]
   (phaser->clj
    (.step collision-map
           (clj->phaser res)
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser vx)
           (clj->phaser vy)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser rvx)
           (clj->phaser rvy)
           (clj->phaser step)))))

(defn trace
  "[description]

  Parameters:
    * collision-map (Phaser.Physics.Impact.CollisionMap) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]
    * vx (number) - [description]
    * vy (number) - [description]
    * object-width (number) - [description]
    * object-height (number) - [description]

  Returns:  boolean - [description]"
  ([collision-map x y vx vy object-width object-height]
   (phaser->clj
    (.trace collision-map
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser vx)
            (clj->phaser vy)
            (clj->phaser object-width)
            (clj->phaser object-height)))))