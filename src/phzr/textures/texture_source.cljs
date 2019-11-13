(ns phzr.textures.texture-source
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->TextureSource
  "  Parameters:
    * texture (Phaser.Textures.Texture) - The Texture this TextureSource belongs to.
    * source (HTMLImageElement | HTMLCanvasElement | HTMLVideoElement | Phaser.GameObjects.RenderTexture | WebGLTexture) - The source image data.
    * width (integer) {optional} - Optional width of the source image. If not given it's derived from the source itself.
    * height (integer) {optional} - Optional height of the source image. If not given it's derived from the source itself.
    * flip-y (boolean) {optional} - Sets the `UNPACK_FLIP_Y_WEBGL` flag the WebGL Texture uses during upload."
  ([texture source]
   (js/Phaser.Textures.TextureSource. (clj->phaser texture)
                                      (clj->phaser source)))
  ([texture source width]
   (js/Phaser.Textures.TextureSource. (clj->phaser texture)
                                      (clj->phaser source)
                                      (clj->phaser width)))
  ([texture source width height]
   (js/Phaser.Textures.TextureSource. (clj->phaser texture)
                                      (clj->phaser source)
                                      (clj->phaser width)
                                      (clj->phaser height)))
  ([texture source width height flip-y]
   (js/Phaser.Textures.TextureSource. (clj->phaser texture)
                                      (clj->phaser source)
                                      (clj->phaser width)
                                      (clj->phaser height)
                                      (clj->phaser flip-y))))

(defn destroy
  "Destroys this Texture Source and nulls the references."
  ([texture-source]
   (phaser->clj
    (.destroy texture-source))))

(defn init
  "Creates a WebGL Texture, if required, and sets the Texture filter mode.

  Parameters:
    * texture-source (Phaser.Textures.TextureSource) - Targeted instance for method
    * game (Phaser.Game) - A reference to the Phaser Game instance."
  ([texture-source game]
   (phaser->clj
    (.init texture-source
           (clj->phaser game)))))

(defn set-filter
  "Sets the Filter Mode for this Texture.

  The mode can be either Linear, the default, or Nearest.

  For pixel-art you should use Nearest.

  Parameters:
    * texture-source (Phaser.Textures.TextureSource) - Targeted instance for method
    * filter-mode (Phaser.Textures.FilterMode) - The Filter Mode."
  ([texture-source filter-mode]
   (phaser->clj
    (.setFilter texture-source
                (clj->phaser filter-mode)))))

(defn set-flip-y
  "Sets the `UNPACK_FLIP_Y_WEBGL` flag for the WebGL Texture during texture upload.

  Parameters:
    * texture-source (Phaser.Textures.TextureSource) - Targeted instance for method
    * value (boolean) {optional} - Should the WebGL Texture be flipped on the Y axis on texture upload or not?"
  ([texture-source]
   (phaser->clj
    (.setFlipY texture-source)))
  ([texture-source value]
   (phaser->clj
    (.setFlipY texture-source
               (clj->phaser value)))))

(defn update
  "If this TextureSource is backed by a Canvas and is running under WebGL,
  it updates the WebGLTexture using the canvas data."
  ([texture-source]
   (phaser->clj
    (.update texture-source))))