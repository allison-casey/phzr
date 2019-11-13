(ns phzr.tilemaps.map-data
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->MapData
  "  Parameters:
    * config (Phaser.Types.Tilemaps.MapDataConfig) {optional} - The Map configuration object."
  ([]
   (js/Phaser.Tilemaps.MapData.))
  ([config]
   (js/Phaser.Tilemaps.MapData. (clj->phaser config))))

