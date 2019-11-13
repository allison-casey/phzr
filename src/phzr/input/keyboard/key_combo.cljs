(ns phzr.input.keyboard.key-combo
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->KeyCombo
  "  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - A reference to the Keyboard Plugin.
    * keys (string | Array.<integer> | Array.<object>) - The keys that comprise this combo.
    * config (Phaser.Types.Input.Keyboard.KeyComboConfig) {optional} - A Key Combo configuration object."
  ([keyboard-plugin keys]
   (js/Phaser.Input.Keyboard.KeyCombo. (clj->phaser keyboard-plugin)
                                       (clj->phaser keys)))
  ([keyboard-plugin keys config]
   (js/Phaser.Input.Keyboard.KeyCombo. (clj->phaser keyboard-plugin)
                                       (clj->phaser keys)
                                       (clj->phaser config))))

(defn destroy
  "Destroys this Key Combo and all of its references."
  ([key-combo]
   (phaser->clj
    (.destroy key-combo))))