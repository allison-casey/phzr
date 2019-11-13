(ns phzr.physics.matter.matter-physics
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->MatterPhysics
  "  Parameters:
    * scene (Phaser.Scene) - [description]"
  ([scene]
   (js/Phaser.Physics.Matter.MatterPhysics. (clj->phaser scene))))

(defn enable-attractor-plugin
  "[description]

  Returns:  Phaser.Physics.Matter.MatterPhysics - This Matter Physics instance."
  ([matter-physics]
   (phaser->clj
    (.enableAttractorPlugin matter-physics))))

(defn enable-wrap-plugin
  "[description]

  Returns:  Phaser.Physics.Matter.MatterPhysics - This Matter Physics instance."
  ([matter-physics]
   (phaser->clj
    (.enableWrapPlugin matter-physics))))

(defn get-config
  "[description]

  Returns:  object - [description]"
  ([matter-physics]
   (phaser->clj
    (.getConfig matter-physics))))

(defn pause
  "[description]

  Returns:  Phaser.Physics.Matter.World - The Matter World object."
  ([matter-physics]
   (phaser->clj
    (.pause matter-physics))))

(defn resume
  "[description]

  Returns:  Phaser.Physics.Matter.World - The Matter World object."
  ([matter-physics]
   (phaser->clj
    (.resume matter-physics))))

(defn set-30-hz
  "Sets the Matter Engine to run at fixed timestep of 30Hz and enables `autoUpdate`.
  If you have set a custom `getDelta` function then this will override it.

  Returns:  Phaser.Physics.Matter.MatterPhysics - This Matter Physics instance."
  ([matter-physics]
   (phaser->clj
    (.set30Hz matter-physics))))

(defn set-60-hz
  "Sets the Matter Engine to run at fixed timestep of 60Hz and enables `autoUpdate`.
  If you have set a custom `getDelta` function then this will override it.

  Returns:  Phaser.Physics.Matter.MatterPhysics - This Matter Physics instance."
  ([matter-physics]
   (phaser->clj
    (.set60Hz matter-physics))))

(defn step
  "Manually advances the physics simulation by one iteration.

  You can optionally pass in the `delta` and `correction` values to be used by Engine.update.
  If undefined they use the Matter defaults of 60Hz and no correction.

  Calling `step` directly bypasses any checks of `enabled` or `autoUpdate`.

  It also ignores any custom `getDelta` functions, as you should be passing the delta
  value in to this call.

  You can adjust the number of iterations that Engine.update performs internally.
  Use the Scene Matter Physics config object to set the following properties:

  positionIterations (defaults to 6)
  velocityIterations (defaults to 4)
  constraintIterations (defaults to 2)

  Adjusting these values can help performance in certain situations, depending on the physics requirements
  of your game.

  Parameters:
    * matter-physics (Phaser.Physics.Matter.MatterPhysics) - Targeted instance for method
    * delta (number) {optional} - [description]
    * correction (number) {optional} - [description]"
  ([matter-physics]
   (phaser->clj
    (.step matter-physics)))
  ([matter-physics delta]
   (phaser->clj
    (.step matter-physics
           (clj->phaser delta))))
  ([matter-physics delta correction]
   (phaser->clj
    (.step matter-physics
           (clj->phaser delta)
           (clj->phaser correction)))))