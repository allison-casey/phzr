(ns phzr.display.masks.geometry-mask
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->GeometryMask
  "  Parameters:
    * scene (Phaser.Scene) - This parameter is not used.
    * graphics-geometry (Phaser.GameObjects.Graphics) - The Graphics Game Object to use for the Geometry Mask. Doesn't have to be in the Display List."
  ([scene graphics-geometry]
   (js/Phaser.Display.Masks.GeometryMask. (clj->phaser scene)
                                          (clj->phaser graphics-geometry))))

(defn apply-stencil
  "Applies the current stencil mask to the renderer.

  Parameters:
    * geometry-mask (Phaser.Display.Masks.GeometryMask) - Targeted instance for method
    * renderer (Phaser.Renderer.WebGL.WebGLRenderer) - The WebGL Renderer instance to draw to.
    * camera (Phaser.Cameras.Scene2D.Camera) - The camera the Game Object is being rendered through.
    * inc (boolean) - Is this an INCR stencil or a DECR stencil?"
  ([geometry-mask renderer camera inc]
   (phaser->clj
    (.applyStencil geometry-mask
                   (clj->phaser renderer)
                   (clj->phaser camera)
                   (clj->phaser inc)))))

(defn destroy
  "Destroys this GeometryMask and nulls any references it holds.

  Note that if a Game Object is currently using this mask it will _not_ automatically detect you have destroyed it,
  so be sure to call `clearMask` on any Game Object using it, before destroying it."
  ([geometry-mask]
   (phaser->clj
    (.destroy geometry-mask))))

(defn post-render-canvas
  "Restore the canvas context's previous clipping path, thus turning off the mask for it.

  Parameters:
    * geometry-mask (Phaser.Display.Masks.GeometryMask) - Targeted instance for method
    * renderer (Phaser.Renderer.Canvas.CanvasRenderer) - The Canvas Renderer instance being restored."
  ([geometry-mask renderer]
   (phaser->clj
    (.postRenderCanvas geometry-mask
                       (clj->phaser renderer)))))

(defn post-render-webgl
  "Flushes all rendered pixels and disables the stencil test of a WebGL context, thus disabling the mask for it.

  Parameters:
    * geometry-mask (Phaser.Display.Masks.GeometryMask) - Targeted instance for method
    * renderer (Phaser.Renderer.WebGL.WebGLRenderer) - The WebGL Renderer instance to draw flush."
  ([geometry-mask renderer]
   (phaser->clj
    (.postRenderWebGL geometry-mask
                      (clj->phaser renderer)))))

(defn pre-render-canvas
  "Sets the clipping path of a 2D canvas context to the Geometry Mask's underlying Graphics object.

  Parameters:
    * geometry-mask (Phaser.Display.Masks.GeometryMask) - Targeted instance for method
    * renderer (Phaser.Renderer.Canvas.CanvasRenderer) - The Canvas Renderer instance to set the clipping path on.
    * mask (Phaser.GameObjects.GameObject) - The Game Object being rendered.
    * camera (Phaser.Cameras.Scene2D.Camera) - The camera the Game Object is being rendered through."
  ([geometry-mask renderer mask camera]
   (phaser->clj
    (.preRenderCanvas geometry-mask
                      (clj->phaser renderer)
                      (clj->phaser mask)
                      (clj->phaser camera)))))

(defn pre-render-webgl
  "Renders the Geometry Mask's underlying Graphics object to the OpenGL stencil buffer and enables the stencil test, which clips rendered pixels according to the mask.

  Parameters:
    * geometry-mask (Phaser.Display.Masks.GeometryMask) - Targeted instance for method
    * renderer (Phaser.Renderer.WebGL.WebGLRenderer) - The WebGL Renderer instance to draw to.
    * child (Phaser.GameObjects.GameObject) - The Game Object being rendered.
    * camera (Phaser.Cameras.Scene2D.Camera) - The camera the Game Object is being rendered through."
  ([geometry-mask renderer child camera]
   (phaser->clj
    (.preRenderWebGL geometry-mask
                     (clj->phaser renderer)
                     (clj->phaser child)
                     (clj->phaser camera)))))

(defn set-invert-alpha
  "Sets the `invertAlpha` property of this Geometry Mask.
  Inverting the alpha essentially flips the way the mask works.

  Parameters:
    * geometry-mask (Phaser.Display.Masks.GeometryMask) - Targeted instance for method
    * value (boolean) {optional} - Invert the alpha of this mask?

  Returns:  this - This Geometry Mask"
  ([geometry-mask]
   (phaser->clj
    (.setInvertAlpha geometry-mask)))
  ([geometry-mask value]
   (phaser->clj
    (.setInvertAlpha geometry-mask
                     (clj->phaser value)))))

(defn set-shape
  "Sets a new Graphics object for the Geometry Mask.

  Parameters:
    * geometry-mask (Phaser.Display.Masks.GeometryMask) - Targeted instance for method
    * graphics-geometry (Phaser.GameObjects.Graphics) - The Graphics object which will be used for the Geometry Mask.

  Returns:  this - This Geometry Mask"
  ([geometry-mask graphics-geometry]
   (phaser->clj
    (.setShape geometry-mask
               (clj->phaser graphics-geometry)))))