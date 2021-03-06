(ns phzr.cameras.scene-2-d.effects.fade
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Fade
  "  Parameters:
    * camera (Phaser.Cameras.Scene2D.Camera) - The camera this effect is acting upon."
  ([camera]
   (js/Phaser.Cameras.Scene2D.Effects.Fade. (clj->phaser camera))))

(defn destroy
  "Destroys this effect, releasing it from the Camera."
  ([fade]
   (phaser->clj
    (.destroy fade))))

(defn effect-complete
  "Called internally when the effect completes."
  ([fade]
   (phaser->clj
    (.effectComplete fade))))

(defn post-render-canvas
  "Called internally by the Canvas Renderer.

  Parameters:
    * fade (Phaser.Cameras.Scene2D.Effects.Fade) - Targeted instance for method
    * ctx (CanvasRenderingContext2D) - The Canvas context to render to.

  Returns:  boolean - `true` if the effect drew to the renderer, otherwise `false`."
  ([fade ctx]
   (phaser->clj
    (.postRenderCanvas fade
                       (clj->phaser ctx)))))

(defn post-render-webgl
  "Called internally by the WebGL Renderer.

  Parameters:
    * fade (Phaser.Cameras.Scene2D.Effects.Fade) - Targeted instance for method
    * pipeline (Phaser.Renderer.WebGL.Pipelines.TextureTintPipeline) - The WebGL Pipeline to render to.
    * get-tint-function (function) - A function that will return the gl safe tint colors.

  Returns:  boolean - `true` if the effect drew to the renderer, otherwise `false`."
  ([fade pipeline get-tint-function]
   (phaser->clj
    (.postRenderWebGL fade
                      (clj->phaser pipeline)
                      (clj->phaser get-tint-function)))))

(defn reset
  "Resets this camera effect.
  If it was previously running, it stops instantly without calling its onComplete callback or emitting an event."
  ([fade]
   (phaser->clj
    (.reset fade))))

(defn start
  "Fades the Camera to or from the given color over the duration specified.

  Parameters:
    * fade (Phaser.Cameras.Scene2D.Effects.Fade) - Targeted instance for method
    * direction (boolean) {optional} - The direction of the fade. `true` = fade out (transparent to color), `false` = fade in (color to transparent)
    * duration (integer) {optional} - The duration of the effect in milliseconds.
    * red (integer) {optional} - The amount to fade the red channel towards. A value between 0 and 255.
    * green (integer) {optional} - The amount to fade the green channel towards. A value between 0 and 255.
    * blue (integer) {optional} - The amount to fade the blue channel towards. A value between 0 and 255.
    * force (boolean) {optional} - Force the effect to start immediately, even if already running.
    * callback (Phaser.Types.Cameras.Scene2D.CameraFadeCallback) {optional} - This callback will be invoked every frame for the duration of the effect.
It is sent two arguments: A reference to the camera and a progress amount between 0 and 1 indicating how complete the effect is.
    * context (any) {optional} - The context in which the callback is invoked. Defaults to the Scene to which the Camera belongs.

  Returns:  Phaser.Cameras.Scene2D.Camera - The Camera on which the effect was started."
  ([fade]
   (phaser->clj
    (.start fade)))
  ([fade direction]
   (phaser->clj
    (.start fade
            (clj->phaser direction))))
  ([fade direction duration]
   (phaser->clj
    (.start fade
            (clj->phaser direction)
            (clj->phaser duration))))
  ([fade direction duration red]
   (phaser->clj
    (.start fade
            (clj->phaser direction)
            (clj->phaser duration)
            (clj->phaser red))))
  ([fade direction duration red green]
   (phaser->clj
    (.start fade
            (clj->phaser direction)
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green))))
  ([fade direction duration red green blue]
   (phaser->clj
    (.start fade
            (clj->phaser direction)
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue))))
  ([fade direction duration red green blue force]
   (phaser->clj
    (.start fade
            (clj->phaser direction)
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue)
            (clj->phaser force))))
  ([fade direction duration red green blue force callback]
   (phaser->clj
    (.start fade
            (clj->phaser direction)
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue)
            (clj->phaser force)
            (clj->phaser callback))))
  ([fade direction duration red green blue force callback context]
   (phaser->clj
    (.start fade
            (clj->phaser direction)
            (clj->phaser duration)
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue)
            (clj->phaser force)
            (clj->phaser callback)
            (clj->phaser context)))))

(defn update
  "The main update loop for this effect. Called automatically by the Camera.

  Parameters:
    * fade (Phaser.Cameras.Scene2D.Effects.Fade) - Targeted instance for method
    * time (integer) - The current timestamp as generated by the Request Animation Frame or SetTimeout.
    * delta (number) - The delta time, in ms, elapsed since the last frame."
  ([fade time delta]
   (phaser->clj
    (.update fade
             (clj->phaser time)
             (clj->phaser delta)))))