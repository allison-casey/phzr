(ns phzr.physics.impact.body
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Body
  "  Parameters:
    * world (Phaser.Physics.Impact.World) - [description]
    * x (number) - [description]
    * y (number) - [description]
    * sx (number) {optional} - [description]
    * sy (number) {optional} - [description]"
  ([world x y]
   (js/Phaser.Physics.Impact.Body. (clj->phaser world)
                                   (clj->phaser x)
                                   (clj->phaser y)))
  ([world x y sx]
   (js/Phaser.Physics.Impact.Body. (clj->phaser world)
                                   (clj->phaser x)
                                   (clj->phaser y)
                                   (clj->phaser sx)))
  ([world x y sx sy]
   (js/Phaser.Physics.Impact.Body. (clj->phaser world)
                                   (clj->phaser x)
                                   (clj->phaser y)
                                   (clj->phaser sx)
                                   (clj->phaser sy))))

(defn check
  "Can be overridden by user code

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * other (Phaser.Physics.Impact.Body) - [description]"
  ([body other]
   (phaser->clj
    (.check body
            (clj->phaser other)))))

(defn collide-with
  "Can be overridden by user code

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * other (Phaser.Physics.Impact.Body) - [description]
    * axis (string) - [description]"
  ([body other axis]
   (phaser->clj
    (.collideWith body
                  (clj->phaser other)
                  (clj->phaser axis)))))

(defn destroy
  "[description]"
  ([body]
   (phaser->clj
    (.destroy body))))

(defn draw-debug
  "[description]

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * graphic (Phaser.GameObjects.Graphics) - [description]"
  ([body graphic]
   (phaser->clj
    (.drawDebug body
                (clj->phaser graphic)))))

(defn from-json
  "[description]

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * config (object) - [description]"
  ([body config]
   (phaser->clj
    (.fromJSON body
               (clj->phaser config)))))

(defn handle-movement-trace
  "Can be overridden by user code but must return a boolean.

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * res (number) - [description]

  Returns:  boolean - [description]"
  ([body res]
   (phaser->clj
    (.handleMovementTrace body
                          (clj->phaser res)))))

(defn reset
  "[description]

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]"
  ([body x y]
   (phaser->clj
    (.reset body
            (clj->phaser x)
            (clj->phaser y)))))

(defn reset-size
  "Reset the size and position of the physics body.

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * x (number) - The x coordinate to position the body.
    * y (number) - The y coordinate to position the body.
    * width (number) - The width of the body.
    * height (number) - The height of the body.

  Returns:  Phaser.Physics.Impact.Body - This Body object."
  ([body x y width height]
   (phaser->clj
    (.resetSize body
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)))))

(defn skip-hash
  "[description]

  Returns:  boolean - [description]"
  ([body]
   (phaser->clj
    (.skipHash body))))

(defn to-json
  "Export this body object to JSON.

  Returns:  Phaser.Types.Physics.Impact.JSONImpactBody - JSON representation of this body object."
  ([body]
   (phaser->clj
    (.toJSON body))))

(defn touches
  "Determines whether the body collides with the `other` one or not.

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * other (Phaser.Physics.Impact.Body) - [description]

  Returns:  boolean - [description]"
  ([body other]
   (phaser->clj
    (.touches body
              (clj->phaser other)))))

(defn update
  "[description]

  Parameters:
    * body (Phaser.Physics.Impact.Body) - Targeted instance for method
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([body delta]
   (phaser->clj
    (.update body
             (clj->phaser delta)))))

(defn will-draw-debug
  "[description]

  Returns:  boolean - [description]"
  ([body]
   (phaser->clj
    (.willDrawDebug body))))