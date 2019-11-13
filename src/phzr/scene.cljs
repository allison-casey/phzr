(ns phzr.scene
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Scene
  "  Parameters:
    * config (string | Phaser.Types.Scenes.SettingsConfig) - Scene specific configuration settings."
  ([config]
   (js/Phaser.Scene. (clj->phaser config))))

(defn update
  "Should be overridden by your own Scenes.
  This method is called once per game step while the scene is running.

  Parameters:
    * scene (Phaser.Scene) - Targeted instance for method
    * time (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([scene time delta]
   (phaser->clj
    (.update scene
             (clj->phaser time)
             (clj->phaser delta)))))