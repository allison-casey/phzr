(ns phzr.game
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Game
  "  Parameters:
    * game-config (Phaser.Types.Core.GameConfig) {optional} - The configuration object for your Phaser Game instance."
  ([]
   (js/Phaser.Game.))
  ([game-config]
   (js/Phaser.Game. (clj->phaser game-config))))

(defn destroy
  "Flags this Game instance as needing to be destroyed on the _next frame_, making this an asynchronous operation.

  It will wait until the current frame has completed and then call `runDestroy` internally.

  If you need to react to the games eventual destruction, listen for the `DESTROY` event.

  If you **do not** need to run Phaser again on the same web page you can set the `noReturn` argument to `true` and it will free-up
  memory being held by the core Phaser plugins. If you do need to create another game instance on the same page, leave this as `false`.

  Parameters:
    * game (Phaser.Game) - Targeted instance for method
    * remove-canvas (boolean) - Set to `true` if you would like the parent canvas element removed from the DOM, or `false` to leave it in place.
    * no-return (boolean) {optional} - If `true` all the core Phaser plugins are destroyed. You cannot create another instance of Phaser on the same web page if you do this."
  ([game remove-canvas]
   (phaser->clj
    (.destroy game
              (clj->phaser remove-canvas))))
  ([game remove-canvas no-return]
   (phaser->clj
    (.destroy game
              (clj->phaser remove-canvas)
              (clj->phaser no-return)))))

(defn get-frame
  "Returns the current game frame.

  When the game starts running, the frame is incremented every time Request Animation Frame, or Set Timeout, fires.

  Returns:  number - The current game frame."
  ([game]
   (phaser->clj
    (.getFrame game))))

(defn get-time
  "Returns the time that the current game step started at, as based on `performance.now`.

  Returns:  number - The current game timestamp."
  ([game]
   (phaser->clj
    (.getTime game))))

(defn headless-step
  "A special version of the Game Step for the HEADLESS renderer only.

  The main Game Step. Called automatically by the Time Step, once per browser frame (typically as a result of
  Request Animation Frame, or Set Timeout on very old browsers.)

  The step will update the global managers first, then proceed to update each Scene in turn, via the Scene Manager.

  This process emits `prerender` and `postrender` events, even though nothing actually displays.

  Parameters:
    * game (Phaser.Game) - Targeted instance for method
    * time (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([game time delta]
   (phaser->clj
    (.headlessStep game
                   (clj->phaser time)
                   (clj->phaser delta)))))

(defn step
  "The main Game Step. Called automatically by the Time Step, once per browser frame (typically as a result of
  Request Animation Frame, or Set Timeout on very old browsers.)

  The step will update the global managers first, then proceed to update each Scene in turn, via the Scene Manager.

  It will then render each Scene in turn, via the Renderer. This process emits `prerender` and `postrender` events.

  Parameters:
    * game (Phaser.Game) - Targeted instance for method
    * time (number) - The current time. Either a High Resolution Timer value if it comes from Request Animation Frame, or Date.now if using SetTimeout.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([game time delta]
   (phaser->clj
    (.step game
           (clj->phaser time)
           (clj->phaser delta)))))