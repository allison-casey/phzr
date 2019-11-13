(ns phzr.tilemaps.object-layer
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->ObjectLayer
  "  Parameters:
    * config (Phaser.Types.Tilemaps.ObjectLayerConfig) {optional} - The data for the layer from the Tiled JSON object."
  ([]
   (js/Phaser.Tilemaps.ObjectLayer.))
  ([config]
   (js/Phaser.Tilemaps.ObjectLayer. (clj->phaser config))))

