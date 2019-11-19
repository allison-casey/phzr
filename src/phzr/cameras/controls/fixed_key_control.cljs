(ns phzr.cameras.controls.fixed-key-control
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->FixedKeyControl
  "  Parameters:
    * config (Phaser.Types.Cameras.Controls.FixedKeyControlConfig) - The Fixed Key Control configuration object."
  ([config]
   (js/Phaser.Cameras.Controls.FixedKeyControl. (clj->phaser config))))

(defn destroy
  "Destroys this Key Control."
  ([fixed-key-control]
   (phaser->clj
    (.destroy fixed-key-control))))

(defn set-camera
  "Binds this Key Control to a camera.

  Parameters:
    * fixed-key-control (Phaser.Cameras.Controls.FixedKeyControl) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The camera to bind this Key Control to.

  Returns:  Phaser.Cameras.Controls.FixedKeyControl - This Key Control instance."
  ([fixed-key-control camera]
   (phaser->clj
    (.setCamera fixed-key-control
                (clj->phaser camera)))))

(defn start
  "Starts the Key Control running, providing it has been linked to a camera.

  Returns:  Phaser.Cameras.Controls.FixedKeyControl - This Key Control instance."
  ([fixed-key-control]
   (phaser->clj
    (.start fixed-key-control))))

(defn stop
  "Stops this Key Control from running. Call `start` to start it again.

  Returns:  Phaser.Cameras.Controls.FixedKeyControl - This Key Control instance."
  ([fixed-key-control]
   (phaser->clj
    (.stop fixed-key-control))))

(defn update
  "Applies the results of pressing the control keys to the Camera.

  You must call this every step, it is not called automatically.

  Parameters:
    * fixed-key-control (Phaser.Cameras.Controls.FixedKeyControl) - Targeted instance for method
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([fixed-key-control delta]
   (phaser->clj
    (.update fixed-key-control
             (clj->phaser delta)))))
