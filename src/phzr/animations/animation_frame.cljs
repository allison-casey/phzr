(ns phzr.animations.animation-frame
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->AnimationFrame
  "  Parameters:
    * texture-key (string) - The key of the Texture this AnimationFrame uses.
    * texture-frame (string | integer) - The key of the Frame within the Texture that this AnimationFrame uses.
    * index (integer) - The index of this AnimationFrame within the Animation sequence.
    * frame (Phaser.Textures.Frame) - A reference to the Texture Frame this AnimationFrame uses for rendering."
  ([texture-key texture-frame index frame]
   (js/Phaser.Animations.AnimationFrame. (clj->phaser texture-key)
                                         (clj->phaser texture-frame)
                                         (clj->phaser index)
                                         (clj->phaser frame))))

(defn destroy
  "Destroys this object by removing references to external resources and callbacks."
  ([animation-frame]
   (phaser->clj
    (.destroy animation-frame))))

(defn to-json
  "Generates a JavaScript object suitable for converting to JSON.

  Returns:  Phaser.Types.Animations.JSONAnimationFrame - The AnimationFrame data."
  ([animation-frame]
   (phaser->clj
    (.toJSON animation-frame))))