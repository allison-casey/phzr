(ns phzr.display.masks.bitmap-mask
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->BitmapMask
  "  Parameters:
    * scene (Phaser.Scene) - The Scene which this Bitmap Mask will be used in.
    * renderable (Phaser.GameObjects.GameObject) - A renderable Game Object that uses a texture, such as a Sprite."
  ([scene renderable]
   (js/Phaser.Display.Masks.BitmapMask. (clj->phaser scene)
                                        (clj->phaser renderable))))

(defn destroy
  "Destroys this BitmapMask and nulls any references it holds.

  Note that if a Game Object is currently using this mask it will _not_ automatically detect you have destroyed it,
  so be sure to call `clearMask` on any Game Object using it, before destroying it."
  ([bitmap-mask]
   (phaser->clj
    (.destroy bitmap-mask))))

(defn post-render-canvas
  "This is a NOOP method. Bitmap Masks are not supported by the Canvas Renderer.

  Parameters:
    * bitmap-mask (Phaser.Display.Masks.BitmapMask) - Targeted instance for method
    * renderer (Phaser.Renderer.Canvas.CanvasRenderer | Phaser.Renderer.WebGL.WebGLRenderer) - The Canvas Renderer which would be rendered to."
  ([bitmap-mask renderer]
   (phaser->clj
    (.postRenderCanvas bitmap-mask
                       (clj->phaser renderer)))))

(defn post-render-webgl
  "Finalizes rendering of a masked Game Object.

  This resets the previously bound framebuffer and switches the WebGL Renderer to the Bitmap Mask Pipeline, which uses a special fragment shader to apply the masking effect.

  Parameters:
    * bitmap-mask (Phaser.Display.Masks.BitmapMask) - Targeted instance for method
    * renderer (Phaser.Renderer.Canvas.CanvasRenderer | Phaser.Renderer.WebGL.WebGLRenderer) - The WebGL Renderer to clean up."
  ([bitmap-mask renderer]
   (phaser->clj
    (.postRenderWebGL bitmap-mask
                      (clj->phaser renderer)))))

(defn pre-render-canvas
  "This is a NOOP method. Bitmap Masks are not supported by the Canvas Renderer.

  Parameters:
    * bitmap-mask (Phaser.Display.Masks.BitmapMask) - Targeted instance for method
    * renderer (Phaser.Renderer.Canvas.CanvasRenderer | Phaser.Renderer.WebGL.WebGLRenderer) - The Canvas Renderer which would be rendered to.
    * mask (Phaser.GameObjects.GameObject) - The masked Game Object which would be rendered.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to render to."
  ([bitmap-mask renderer mask camera]
   (phaser->clj
    (.preRenderCanvas bitmap-mask
                      (clj->phaser renderer)
                      (clj->phaser mask)
                      (clj->phaser camera)))))

(defn pre-render-webgl
  "Prepares the WebGL Renderer to render a Game Object with this mask applied.

  This renders the masking Game Object to the mask framebuffer and switches to the main framebuffer so that the masked Game Object will be rendered to it instead of being rendered directly to the frame.

  Parameters:
    * bitmap-mask (Phaser.Display.Masks.BitmapMask) - Targeted instance for method
    * renderer (Phaser.Renderer.Canvas.CanvasRenderer | Phaser.Renderer.WebGL.WebGLRenderer) - The WebGL Renderer to prepare.
    * masked-object (Phaser.GameObjects.GameObject) - The masked Game Object which will be drawn.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to render to."
  ([bitmap-mask renderer masked-object camera]
   (phaser->clj
    (.preRenderWebGL bitmap-mask
                     (clj->phaser renderer)
                     (clj->phaser masked-object)
                     (clj->phaser camera)))))

(defn set-bitmap
  "Sets a new masking Game Object for the Bitmap Mask.

  Parameters:
    * bitmap-mask (Phaser.Display.Masks.BitmapMask) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) - A renderable Game Object that uses a texture, such as a Sprite."
  ([bitmap-mask renderable]
   (phaser->clj
    (.setBitmap bitmap-mask
                (clj->phaser renderable)))))