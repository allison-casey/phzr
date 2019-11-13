(ns phzr.core.config
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Config
  "  Parameters:
    * game-config (Phaser.Types.Core.GameConfig) {optional} - The configuration object for your Phaser Game instance."
  ([]
   (js/Phaser.Core.Config.))
  ([game-config]
   (js/Phaser.Core.Config. (clj->phaser game-config))))

