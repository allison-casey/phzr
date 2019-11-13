(ns phzr.structs.r-tree
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->RTree
  ""
  ([]
   (js/Phaser.Structs.RTree.)))

