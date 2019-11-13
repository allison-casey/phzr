(ns phzr.cameras.controls.smoothed-key-control
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->SmoothedKeyControl
  "  Parameters:
    * config (Phaser.Types.Cameras.Controls.SmoothedKeyControlConfig) - The Smoothed Key Control configuration object."
  ([config]
   (js/Phaser.Cameras.Controls.SmoothedKeyControl. (clj->phaser config))))

(defn destroy
  "Destroys this Key Control."
  ([smoothed-key-control]
   (phaser->clj
    (.destroy smoothed-key-control))))

(defn set-camera
  "Binds this Key Control to a camera.

  Parameters:
    * smoothed-key-control (Phaser.Cameras.Controls.SmoothedKeyControl) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The camera to bind this Key Control to.

  Returns:  Phaser.Cameras.Controls.SmoothedKeyControl - This Key Control instance."
  ([smoothed-key-control camera]
   (phaser->clj
    (.setCamera smoothed-key-control
                (clj->phaser camera)))))

(defn start
  "Starts the Key Control running, providing it has been linked to a camera.

  Returns:  Phaser.Cameras.Controls.SmoothedKeyControl - This Key Control instance."
  ([smoothed-key-control]
   (phaser->clj
    (.start smoothed-key-control))))

(defn stop
  "Stops this Key Control from running. Call `start` to start it again.

  Returns:  Phaser.Cameras.Controls.SmoothedKeyControl - This Key Control instance."
  ([smoothed-key-control]
   (phaser->clj
    (.stop smoothed-key-control))))

(defn update
  "Applies the results of pressing the control keys to the Camera.

  You must call this every step, it is not called automatically.

  Parameters:
    * smoothed-key-control (Phaser.Cameras.Controls.SmoothedKeyControl) - Targeted instance for method
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([smoothed-key-control delta]
   (phaser->clj
    (.update smoothed-key-control
             (clj->phaser delta)))))