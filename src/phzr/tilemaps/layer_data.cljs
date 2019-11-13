(ns phzr.tilemaps.layer-data
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->LayerData
  "  Parameters:
    * config (object) {optional} - [description]"
  ([]
   (js/Phaser.Tilemaps.LayerData.))
  ([config]
   (js/Phaser.Tilemaps.LayerData. (clj->phaser config))))

