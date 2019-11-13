(ns phzr.physics.matter.pointer-constraint
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->PointerConstraint
  "  Parameters:
    * scene (Phaser.Scene) - A reference to the Scene to which this Pointer Constraint belongs.
    * world (Phaser.Physics.Matter.World) - A reference to the Matter World instance to which this Constraint belongs.
    * options (object) {optional} - A Constraint configuration object."
  ([scene world]
   (js/Phaser.Physics.Matter.PointerConstraint. (clj->phaser scene)
                                                (clj->phaser world)))
  ([scene world options]
   (js/Phaser.Physics.Matter.PointerConstraint. (clj->phaser scene)
                                                (clj->phaser world)
                                                (clj->phaser options))))

(defn destroy
  "Destroys this Pointer Constraint instance and all of its references."
  ([pointer-constraint]
   (phaser->clj
    (.destroy pointer-constraint))))

(defn get-body
  "Scans all active bodies in the current Matter World to see if any of them
  are hit by the Pointer. The _first one_ found to hit is set as the active contraint
  body.

  Returns:  boolean - `true` if a body was found and set, otherwise `false`."
  ([pointer-constraint]
   (phaser->clj
    (.getBody pointer-constraint))))

(defn hit-test-body
  "Scans the current body to determine if a part of it was clicked on.
  If a part is found the body is set as the `constraint.bodyB` property,
  as well as the `body` property of this class. The part is also set.

  Parameters:
    * pointer-constraint (Phaser.Physics.Matter.PointerConstraint) - Targeted instance for method
    * body (MatterJS.Body) - The Matter Body to check.
    * position (Phaser.Math.Vector2) - A translated hit test position.

  Returns:  boolean - `true` if a part of the body was hit, otherwise `false`."
  ([pointer-constraint body position]
   (phaser->clj
    (.hitTestBody pointer-constraint
                  (clj->phaser body)
                  (clj->phaser position)))))

(defn on-down
  "A Pointer has been pressed down onto the Scene.

  If this Constraint doesn't have an active Pointer then a hit test is
  run against all active bodies in the world. If one is found it is bound
  to this constraint and the drag begins.

  Parameters:
    * pointer-constraint (Phaser.Physics.Matter.PointerConstraint) - Targeted instance for method
    * pointer (Phaser.Input.Pointer) - A reference to the Pointer that was pressed."
  ([pointer-constraint pointer]
   (phaser->clj
    (.onDown pointer-constraint
             (clj->phaser pointer)))))

(defn stop-drag
  "Stops the Pointer Constraint from dragging the body any further.

  This is called automatically if the Pointer is released while actively
  dragging a body. Or, you can call it manually to release a body from a
  constraint without having to first release the pointer."
  ([pointer-constraint]
   (phaser->clj
    (.stopDrag pointer-constraint))))

(defn update
  "Internal update handler. Called in the Matter BEFORE_UPDATE step."
  ([pointer-constraint]
   (phaser->clj
    (.update pointer-constraint))))