(ns phzr.cameras.scene-2-d.effects.shake
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Shake
  "  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - The camera this effect is acting upon."
  ([camera]
   (js/Phaser.Cameras.Scene2D.Effects.Shake. (clj->phaser camera))))

(defn destroy
  "Destroys this effect, releasing it from the Camera."
  ([shake]
   (phaser->clj
    (.destroy shake))))

(defn effect-complete
  "Called internally when the effect completes."
  ([shake]
   (phaser->clj
    (.effectComplete shake))))

(defn pre-render
  "The pre-render step for this effect. Called automatically by the Camera."
  ([shake]
   (phaser->clj
    (.preRender shake))))

(defn reset
  "Resets this camera effect.
  If it was previously running, it stops instantly without calling its onComplete callback or emitting an event."
  ([shake]
   (phaser->clj
    (.reset shake))))

(defn start
  "Shakes the Camera by the given intensity over the duration specified.

  Parameters:
    * shake (Phaser.Cameras.Scene2D.Effects.Shake) - Targeted instance for method
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * intensity (number | Phaser.Math.Vector2) {optional} - The intensity of the shake.
    * force (boolean) {optional} - Force the shake effect to start immediately, even if already running.
    * callback (Phaser.Types.Cameras.Scene2D.CameraShakeCallback) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent two arguments: A reference to the camera and a progress amount between 0 and 1 indicating how complete the effect is.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - The Camera on which the effect was started."
  ([shake]
   (phaser->clj
    (.start shake)))
  ([shake duration]
   (phaser->clj
    (.start shake
            (clj->phaser duration))))
  ([shake duration intensity]
   (phaser->clj
    (.start shake
            (clj->phaser duration)
            (clj->phaser intensity))))
  ([shake duration intensity force]
   (phaser->clj
    (.start shake
            (clj->phaser duration)
            (clj->phaser intensity)
            (clj->phaser force))))
  ([shake duration intensity force callback]
   (phaser->clj
    (.start shake
            (clj->phaser duration)
            (clj->phaser intensity)
            (clj->phaser force)
            (clj->phaser callback))))
  ([shake duration intensity force callback context]
   (phaser->clj
    (.start shake
            (clj->phaser duration)
            (clj->phaser intensity)
            (clj->phaser force)
            (clj->phaser callback)
            (clj->phaser context)))))

(defn update
  "The main update loop for this effect. Called automatically by the Camera.

  Parameters:
    * shake (Phaser.Cameras.Scene2D.Effects.Shake) - Targeted instance for method
    * time (integer) - The current timestamp as generated by the Request Animation Frame or SetTimeout.
    * delta (number) - The delta time, in ms, elapsed since the last frame."
  ([shake time delta]
   (phaser->clj
    (.update shake
             (clj->phaser time)
             (clj->phaser delta)))))