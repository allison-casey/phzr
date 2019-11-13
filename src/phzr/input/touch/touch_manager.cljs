(ns phzr.input.touch.touch-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->TouchManager
  "  Parameters:
    * input-manager (Phaser.Input.InputManager) - A reference to the Input Manager."
  ([input-manager]
   (js/Phaser.Input.Touch.TouchManager. (clj->phaser input-manager))))

(defn destroy
  "Destroys this Touch Manager instance."
  ([touch-manager]
   (phaser->clj
    (.destroy touch-manager))))

(defn disable-context-menu
  "Attempts to disable the context menu from appearing if you touch-hold on the browser.

  Works by listening for the `contextmenu` event and prevent defaulting it.

  Use this if you need to disable the OS context menu on mobile.

  Returns:  Phaser.Input.Touch.TouchManager - This Touch Manager instance."
  ([touch-manager]
   (phaser->clj
    (.disableContextMenu touch-manager))))

(defn start-listeners
  "Starts the Touch Event listeners running as long as an input target is set.

  This method is called automatically if Touch Input is enabled in the game config,
  which it is by default. However, you can call it manually should you need to
  delay input capturing until later in the game."
  ([touch-manager]
   (phaser->clj
    (.startListeners touch-manager))))

(defn stop-listeners
  "Stops the Touch Event listeners.
  This is called automatically and does not need to be manually invoked."
  ([touch-manager]
   (phaser->clj
    (.stopListeners touch-manager))))