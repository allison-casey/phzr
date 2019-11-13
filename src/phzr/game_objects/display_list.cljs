(ns phzr.game-objects.display-list
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->DisplayList
  "  Parameters:
    * scene (Phaser.Scene) - The Scene that this Display List belongs to."
  ([scene]
   (js/Phaser.GameObjects.DisplayList. (clj->phaser scene))))

(defn depth-sort
  "Immediately sorts the display list if the flag is set."
  ([display-list]
   (phaser->clj
    (.depthSort display-list))))

(defn get-children
  "Returns an array which contains all objects currently on the Display List.
  This is a reference to the main list array, not a copy of it, so be careful not to modify it.

  Returns:  Array.<Phaser.GameObjects.GameObject> - The group members."
  ([display-list]
   (phaser->clj
    (.getChildren display-list))))

(defn queue-depth-sort
  "Force a sort of the display list on the next call to depthSort."
  ([display-list]
   (phaser->clj
    (.queueDepthSort display-list))))

(defn sort-by-depth
  "Compare the depth of two Game Objects.

  Parameters:
    * display-list (Phaser.GameObjects.DisplayList) - Targeted instance for method
    * child-a (Phaser.GameObjects.GameObject) - The first Game Object.
    * child-b (Phaser.GameObjects.GameObject) - The second Game Object.

  Returns:  integer - The difference between the depths of each Game Object."
  ([display-list child-a child-b]
   (phaser->clj
    (.sortByDepth display-list
                  (clj->phaser child-a)
                  (clj->phaser child-b)))))