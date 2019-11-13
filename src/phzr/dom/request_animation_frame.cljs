(ns phzr.dom.request-animation-frame
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->RequestAnimationFrame
  ""
  ([]
   (js/Phaser.DOM.RequestAnimationFrame.)))

(defn destroy
  "Stops the step from running and clears the callback reference."
  ([request-animation-frame]
   (phaser->clj
    (.destroy request-animation-frame))))

(defn start
  "Starts the requestAnimationFrame or setTimeout process running.

  Parameters:
    * request-animation-frame (Phaser.DOM.RequestAnimationFrame) - Targeted instance for method
    * callback (FrameRequestCallback) - The callback to invoke each step.
    * force-set-time-out (boolean) - Should it use SetTimeout, even if RAF is available?"
  ([request-animation-frame callback force-set-time-out]
   (phaser->clj
    (.start request-animation-frame
            (clj->phaser callback)
            (clj->phaser force-set-time-out)))))

(defn stop
  "Stops the requestAnimationFrame or setTimeout from running."
  ([request-animation-frame]
   (phaser->clj
    (.stop request-animation-frame))))