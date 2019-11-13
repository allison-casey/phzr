(ns phzr.input.mouse.mouse-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->MouseManager
  "  Parameters:
    * input-manager (Phaser.Input.InputManager) - A reference to the Input Manager."
  ([input-manager]
   (js/Phaser.Input.Mouse.MouseManager. (clj->phaser input-manager))))

(defn destroy
  "Destroys this Mouse Manager instance."
  ([mouse-manager]
   (phaser->clj
    (.destroy mouse-manager))))

(defn disable-context-menu
  "Attempts to disable the context menu from appearing if you right-click on the browser.

  Works by listening for the `contextmenu` event and prevent defaulting it.

  Use this if you need to enable right-button mouse support in your game, and the browser
  menu keeps getting in the way.

  Returns:  Phaser.Input.Mouse.MouseManager - This Mouse Manager instance."
  ([mouse-manager]
   (phaser->clj
    (.disableContextMenu mouse-manager))))

(defn release-pointer-lock
  "If the browser supports pointer lock, this will request that the pointer lock is released. If
  the browser successfully enters a locked state, a 'POINTER_LOCK_CHANGE_EVENT' will be
  dispatched - from the game's input manager - with an `isPointerLocked` property."
  ([mouse-manager]
   (phaser->clj
    (.releasePointerLock mouse-manager))))

(defn request-pointer-lock
  "If the browser supports it, you can request that the pointer be locked to the browser window.

  This is classically known as 'FPS controls', where the pointer can't leave the browser until
  the user presses an exit key.

  If the browser successfully enters a locked state, a `POINTER_LOCK_CHANGE_EVENT` will be dispatched,
  from the games Input Manager, with an `isPointerLocked` property.

  It is important to note that pointer lock can only be enabled after an 'engagement gesture',
  see: https://w3c.github.io/pointerlock/#dfn-engagement-gesture."
  ([mouse-manager]
   (phaser->clj
    (.requestPointerLock mouse-manager))))

(defn start-listeners
  "Starts the Mouse Event listeners running.
  This is called automatically and does not need to be manually invoked."
  ([mouse-manager]
   (phaser->clj
    (.startListeners mouse-manager))))

(defn stop-listeners
  "Stops the Mouse Event listeners.
  This is called automatically and does not need to be manually invoked."
  ([mouse-manager]
   (phaser->clj
    (.stopListeners mouse-manager))))