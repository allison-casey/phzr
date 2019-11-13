(ns phzr.renderer.canvas.canvas-renderer
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->CanvasRenderer
  "  Parameters:
    * game (Phaser.Game) - The Phaser Game instance that owns this renderer."
  ([game]
   (js/Phaser.Renderer.Canvas.CanvasRenderer. (clj->phaser game))))

(defn batch-sprite
  "Takes a Sprite Game Object, or any object that extends it, and draws it to the current context.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * sprite (Phaser.GameObjects.GameObject) - The texture based Game Object to draw.
    * frame (Phaser.Textures.Frame) - The frame to draw, doesn't have to be that owned by the Game Object.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to use for the rendering transform.
    * parent-transform-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The transform matrix of the parent container, if set."
  ([canvas-renderer sprite frame camera]
   (phaser->clj
    (.batchSprite canvas-renderer
                  (clj->phaser sprite)
                  (clj->phaser frame)
                  (clj->phaser camera))))
  ([canvas-renderer sprite frame camera parent-transform-matrix]
   (phaser->clj
    (.batchSprite canvas-renderer
                  (clj->phaser sprite)
                  (clj->phaser frame)
                  (clj->phaser camera)
                  (clj->phaser parent-transform-matrix)))))

(defn destroy
  "Destroys all object references in the Canvas Renderer."
  ([canvas-renderer]
   (phaser->clj
    (.destroy canvas-renderer))))

(defn init
  "Prepares the game canvas for rendering."
  ([canvas-renderer]
   (phaser->clj
    (.init canvas-renderer))))

(defn on-resize
  "The event handler that manages the `resize` event dispatched by the Scale Manager.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * game-size (Phaser.Structs.Size) - The default Game Size object. This is the un-modified game dimensions.
    * base-size (Phaser.Structs.Size) - The base Size object. The game dimensions multiplied by the resolution. The canvas width / height values match this.
    * display-size (Phaser.Structs.Size) - The display Size object. The size of the canvas style width / height attributes.
    * resolution (number) {optional} - The Scale Manager resolution setting."
  ([canvas-renderer game-size base-size display-size]
   (phaser->clj
    (.onResize canvas-renderer
               (clj->phaser game-size)
               (clj->phaser base-size)
               (clj->phaser display-size))))
  ([canvas-renderer game-size base-size display-size resolution]
   (phaser->clj
    (.onResize canvas-renderer
               (clj->phaser game-size)
               (clj->phaser base-size)
               (clj->phaser display-size)
               (clj->phaser resolution)))))

(defn post-render
  "Restores the game context's global settings and takes a snapshot if one is scheduled.

  The post-render step happens after all Cameras in all Scenes have been rendered."
  ([canvas-renderer]
   (phaser->clj
    (.postRender canvas-renderer))))

(defn pre-render
  "Called at the start of the render loop."
  ([canvas-renderer]
   (phaser->clj
    (.preRender canvas-renderer))))

(defn render
  "Renders the Scene to the given Camera.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene to render.
    * children (Phaser.GameObjects.DisplayList) - The Game Objects within the Scene to be rendered.
    * interpolation-percentage (number) - The interpolation percentage to apply. Currently unused.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Scene Camera to render with."
  ([canvas-renderer scene children interpolation-percentage camera]
   (phaser->clj
    (.render canvas-renderer
             (clj->phaser scene)
             (clj->phaser children)
             (clj->phaser interpolation-percentage)
             (clj->phaser camera)))))

(defn reset-transform
  "Resets the transformation matrix of the current context to the identity matrix, thus resetting any transformation."
  ([canvas-renderer]
   (phaser->clj
    (.resetTransform canvas-renderer))))

(defn resize
  "Resize the main game canvas.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * width (number) {optional} - The new width of the renderer.
    * height (number) {optional} - The new height of the renderer."
  ([canvas-renderer]
   (phaser->clj
    (.resize canvas-renderer)))
  ([canvas-renderer width]
   (phaser->clj
    (.resize canvas-renderer
             (clj->phaser width))))
  ([canvas-renderer width height]
   (phaser->clj
    (.resize canvas-renderer
             (clj->phaser width)
             (clj->phaser height)))))

(defn set-alpha
  "Sets the global alpha of the current context.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * alpha (number) - The new alpha to use, where 0 is fully transparent and 1 is fully opaque.

  Returns:  this - This CanvasRenderer object."
  ([canvas-renderer alpha]
   (phaser->clj
    (.setAlpha canvas-renderer
               (clj->phaser alpha)))))

(defn set-blend-mode
  "Sets the blend mode (compositing operation) of the current context.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * blend-mode (string) - The new blend mode which should be used.

  Returns:  this - This CanvasRenderer object."
  ([canvas-renderer blend-mode]
   (phaser->clj
    (.setBlendMode canvas-renderer
                   (clj->phaser blend-mode)))))

(defn set-context
  "Changes the Canvas Rendering Context that all draw operations are performed against.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * ctx (CanvasRenderingContext2D) {optional} - The new Canvas Rendering Context to draw everything to. Leave empty to reset to the Game Canvas.

  Returns:  this - The Canvas Renderer instance."
  ([canvas-renderer]
   (phaser->clj
    (.setContext canvas-renderer)))
  ([canvas-renderer ctx]
   (phaser->clj
    (.setContext canvas-renderer
                 (clj->phaser ctx)))))

(defn snapshot
  "Schedules a snapshot of the entire game viewport to be taken after the current frame is rendered.

  To capture a specific area see the `snapshotArea` method. To capture a specific pixel, see `snapshotPixel`.

  Only one snapshot can be active _per frame_. If you have already called `snapshotPixel`, for example, then
  calling this method will override it.

  Snapshots work by creating an Image object from the canvas data, this is a blocking process, which gets
  more expensive the larger the canvas size gets, so please be careful how you employ this in your game.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot image is created.
    * type (string) {optional} - The format of the image to create, usually `image/png` or `image/jpeg`.
    * encoder-options (number) {optional} - The image quality, between 0 and 1. Used for image formats with lossy compression, such as `image/jpeg`.

  Returns:  this - This WebGL Renderer."
  ([canvas-renderer callback]
   (phaser->clj
    (.snapshot canvas-renderer
               (clj->phaser callback))))
  ([canvas-renderer callback type]
   (phaser->clj
    (.snapshot canvas-renderer
               (clj->phaser callback)
               (clj->phaser type))))
  ([canvas-renderer callback type encoder-options]
   (phaser->clj
    (.snapshot canvas-renderer
               (clj->phaser callback)
               (clj->phaser type)
               (clj->phaser encoder-options)))))

(defn snapshot-area
  "Schedules a snapshot of the given area of the game viewport to be taken after the current frame is rendered.

  To capture the whole game viewport see the `snapshot` method. To capture a specific pixel, see `snapshotPixel`.

  Only one snapshot can be active _per frame_. If you have already called `snapshotPixel`, for example, then
  calling this method will override it.

  Snapshots work by creating an Image object from the canvas data, this is a blocking process, which gets
  more expensive the larger the canvas size gets, so please be careful how you employ this in your game.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * x (integer) - The x coordinate to grab from.
    * y (integer) - The y coordinate to grab from.
    * width (integer) - The width of the area to grab.
    * height (integer) - The height of the area to grab.
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot image is created.
    * type (string) {optional} - The format of the image to create, usually `image/png` or `image/jpeg`.
    * encoder-options (number) {optional} - The image quality, between 0 and 1. Used for image formats with lossy compression, such as `image/jpeg`.

  Returns:  this - This WebGL Renderer."
  ([canvas-renderer x y width height callback]
   (phaser->clj
    (.snapshotArea canvas-renderer
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback))))
  ([canvas-renderer x y width height callback type]
   (phaser->clj
    (.snapshotArea canvas-renderer
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback)
                   (clj->phaser type))))
  ([canvas-renderer x y width height callback type encoder-options]
   (phaser->clj
    (.snapshotArea canvas-renderer
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback)
                   (clj->phaser type)
                   (clj->phaser encoder-options)))))

(defn snapshot-canvas
  "Takes a snapshot of the given area of the given canvas.

  Unlike the other snapshot methods, this one is processed immediately and doesn't wait for the next render.

  Snapshots work by creating an Image object from the canvas data, this is a blocking process, which gets
  more expensive the larger the canvas size gets, so please be careful how you employ this in your game.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * canvas (HTMLCanvasElement) - The canvas to grab from.
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot image is created.
    * get-pixel (boolean) {optional} - Grab a single pixel as a Color object, or an area as an Image object?
    * x (integer) {optional} - The x coordinate to grab from.
    * y (integer) {optional} - The y coordinate to grab from.
    * width (integer) {optional} - The width of the area to grab.
    * height (integer) {optional} - The height of the area to grab.
    * type (string) {optional} - The format of the image to create, usually `image/png` or `image/jpeg`.
    * encoder-options (number) {optional} - The image quality, between 0 and 1. Used for image formats with lossy compression, such as `image/jpeg`.

  Returns:  this - This Canvas Renderer."
  ([canvas-renderer canvas callback]
   (phaser->clj
    (.snapshotCanvas canvas-renderer
                     (clj->phaser canvas)
                     (clj->phaser callback))))
  ([canvas-renderer canvas callback get-pixel]
   (phaser->clj
    (.snapshotCanvas canvas-renderer
                     (clj->phaser canvas)
                     (clj->phaser callback)
                     (clj->phaser get-pixel))))
  ([canvas-renderer canvas callback get-pixel x]
   (phaser->clj
    (.snapshotCanvas canvas-renderer
                     (clj->phaser canvas)
                     (clj->phaser callback)
                     (clj->phaser get-pixel)
                     (clj->phaser x))))
  ([canvas-renderer canvas callback get-pixel x y]
   (phaser->clj
    (.snapshotCanvas canvas-renderer
                     (clj->phaser canvas)
                     (clj->phaser callback)
                     (clj->phaser get-pixel)
                     (clj->phaser x)
                     (clj->phaser y))))
  ([canvas-renderer canvas callback get-pixel x y width]
   (phaser->clj
    (.snapshotCanvas canvas-renderer
                     (clj->phaser canvas)
                     (clj->phaser callback)
                     (clj->phaser get-pixel)
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser width))))
  ([canvas-renderer canvas callback get-pixel x y width height]
   (phaser->clj
    (.snapshotCanvas canvas-renderer
                     (clj->phaser canvas)
                     (clj->phaser callback)
                     (clj->phaser get-pixel)
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser width)
                     (clj->phaser height))))
  ([canvas-renderer canvas callback get-pixel x y width height type]
   (phaser->clj
    (.snapshotCanvas canvas-renderer
                     (clj->phaser canvas)
                     (clj->phaser callback)
                     (clj->phaser get-pixel)
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser width)
                     (clj->phaser height)
                     (clj->phaser type))))
  ([canvas-renderer canvas callback get-pixel x y width height type encoder-options]
   (phaser->clj
    (.snapshotCanvas canvas-renderer
                     (clj->phaser canvas)
                     (clj->phaser callback)
                     (clj->phaser get-pixel)
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser width)
                     (clj->phaser height)
                     (clj->phaser type)
                     (clj->phaser encoder-options)))))

(defn snapshot-pixel
  "Schedules a snapshot of the given pixel from the game viewport to be taken after the current frame is rendered.

  To capture the whole game viewport see the `snapshot` method. To capture a specific area, see `snapshotArea`.

  Only one snapshot can be active _per frame_. If you have already called `snapshotArea`, for example, then
  calling this method will override it.

  Unlike the other two snapshot methods, this one will return a `Color` object containing the color data for
  the requested pixel. It doesn't need to create an internal Canvas or Image object, so is a lot faster to execute,
  using less memory.

  Parameters:
    * canvas-renderer (Phaser.Renderer.Canvas.CanvasRenderer) - Targeted instance for method
    * x (integer) - The x coordinate of the pixel to get.
    * y (integer) - The y coordinate of the pixel to get.
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot pixel data is extracted.

  Returns:  this - This WebGL Renderer."
  ([canvas-renderer x y callback]
   (phaser->clj
    (.snapshotPixel canvas-renderer
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser callback)))))