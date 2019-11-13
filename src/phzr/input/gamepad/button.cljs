(ns phzr.input.gamepad.button
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Button
  "  Parameters:
    * pad (Phaser.Input.Gamepad.Gamepad) - A reference to the Gamepad that this Button belongs to.
    * index (integer) - The index of this Button."
  ([pad index]
   (js/Phaser.Input.Gamepad.Button. (clj->phaser pad)
                                    (clj->phaser index))))

(defn destroy
  "Destroys this Button instance and releases external references it holds."
  ([button]
   (phaser->clj
    (.destroy button))))