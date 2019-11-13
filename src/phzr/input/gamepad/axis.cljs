(ns phzr.input.gamepad.axis
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Axis
  "  Parameters:
    * pad (Phaser.Input.Gamepad.Gamepad) - A reference to the Gamepad that this Axis belongs to.
    * index (integer) - The index of this Axis."
  ([pad index]
   (js/Phaser.Input.Gamepad.Axis. (clj->phaser pad)
                                  (clj->phaser index))))

(defn destroy
  "Destroys this Axis instance and releases external references it holds."
  ([axis]
   (phaser->clj
    (.destroy axis))))

(defn get-value
  "Applies the `threshold` value to the axis and returns it.

  Returns:  number - The axis value, adjusted for the movement threshold."
  ([axis]
   (phaser->clj
    (.getValue axis))))