(ns phzr.game-objects.update-list
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->UpdateList
  "  Parameters:
    * scene (Phaser.Scene) - The Scene that the Update List belongs to."
  ([scene]
   (js/Phaser.GameObjects.UpdateList. (clj->phaser scene))))

(defn destroy
  "The Scene that owns this plugin is being destroyed.

  We need to shutdown and then kill off all external references."
  ([update-list]
   (phaser->clj
    (.destroy update-list))))

(defn scene-update
  "The update step.

  Pre-updates every active Game Object in the list.

  Parameters:
    * update-list (Phaser.GameObjects.UpdateList) - Targeted instance for method
    * time (number) - The current timestamp.
    * delta (number) - The delta time elapsed since the last frame."
  ([update-list time delta]
   (phaser->clj
    (.sceneUpdate update-list
                  (clj->phaser time)
                  (clj->phaser delta)))))

(defn shutdown
  "The Scene that owns this plugin is shutting down.

  We need to kill and reset all internal properties as well as stop listening to Scene events."
  ([update-list]
   (phaser->clj
    (.shutdown update-list))))