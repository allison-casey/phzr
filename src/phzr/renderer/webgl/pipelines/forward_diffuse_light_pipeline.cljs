(ns phzr.renderer.webgl.pipelines.forward-diffuse-light-pipeline
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [flush]))

(defn ->ForwardDiffuseLightPipeline
  "  Parameters:
    * config (object) - The configuration of the pipeline, same as the {@link Phaser.Renderer.WebGL.Pipelines.TextureTintPipeline}. The fragment shader will be replaced with the lighting shader."
  ([config]
   (js/Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline. (clj->phaser config))))

(defn add-attribute
  "Adds a description of vertex attribute to the pipeline

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - Name of the vertex attribute
    * size (integer) - Vertex component size
    * type (integer) - Type of the attribute
    * normalized (boolean) - Is the value normalized to a range
    * offset (integer) - Byte offset to the beginning of the first element in the vertex

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name size type normalized offset]
   (phaser->clj
    (.addAttribute forward-diffuse-light-pipeline
                   (clj->phaser name)
                   (clj->phaser size)
                   (clj->phaser type)
                   (clj->phaser normalized)
                   (clj->phaser offset)))))

(defn batch-fill-path
  "Adds the given path to the vertex batch for rendering.

  It works by taking the array of path data and then passing it through Earcut, which
  creates a list of polygons. Each polygon is then added to the batch.

  The path is always automatically closed because it's filled.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * path (array) - Collection of points that represent the path.
    * current-matrix (Phaser.GameObjects.Components.TransformMatrix) - The current transform.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) - The parent transform."
  ([forward-diffuse-light-pipeline path current-matrix parent-matrix]
   (phaser->clj
    (.batchFillPath forward-diffuse-light-pipeline
                    (clj->phaser path)
                    (clj->phaser current-matrix)
                    (clj->phaser parent-matrix)))))

(defn batch-fill-rect
  "Pushes a filled rectangle into the vertex batch.
  Rectangle factors in the given transform matrices before adding to the batch.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * x (number) - Horizontal top left coordinate of the rectangle.
    * y (number) - Vertical top left coordinate of the rectangle.
    * width (number) - Width of the rectangle.
    * height (number) - Height of the rectangle.
    * current-matrix (Phaser.GameObjects.Components.TransformMatrix) - The current transform.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) - The parent transform."
  ([forward-diffuse-light-pipeline x y width height current-matrix parent-matrix]
   (phaser->clj
    (.batchFillRect forward-diffuse-light-pipeline
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser width)
                    (clj->phaser height)
                    (clj->phaser current-matrix)
                    (clj->phaser parent-matrix)))))

(defn batch-fill-triangle
  "Pushes a filled triangle into the vertex batch.
  Triangle factors in the given transform matrices before adding to the batch.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * x-0 (number) - Point 0 x coordinate.
    * y-0 (number) - Point 0 y coordinate.
    * x-1 (number) - Point 1 x coordinate.
    * y-1 (number) - Point 1 y coordinate.
    * x-2 (number) - Point 2 x coordinate.
    * y-2 (number) - Point 2 y coordinate.
    * current-matrix (Phaser.GameObjects.Components.TransformMatrix) - The current transform.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) - The parent transform."
  ([forward-diffuse-light-pipeline x-0 y-0 x-1 y-1 x-2 y-2 current-matrix parent-matrix]
   (phaser->clj
    (.batchFillTriangle forward-diffuse-light-pipeline
                        (clj->phaser x-0)
                        (clj->phaser y-0)
                        (clj->phaser x-1)
                        (clj->phaser y-1)
                        (clj->phaser x-2)
                        (clj->phaser y-2)
                        (clj->phaser current-matrix)
                        (clj->phaser parent-matrix)))))

(defn batch-line
  "Creates a quad and adds it to the vertex batch based on the given line values.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * ax (number) - X coordinate to the start of the line
    * ay (number) - Y coordinate to the start of the line
    * bx (number) - X coordinate to the end of the line
    * by (number) - Y coordinate to the end of the line
    * a-line-width (number) - Width of the start of the line
    * b-line-width (number) - Width of the end of the line
    * current-matrix (Float32Array) - Parent matrix, generally used by containers"
  ([forward-diffuse-light-pipeline ax ay bx by a-line-width b-line-width current-matrix]
   (phaser->clj
    (.batchLine forward-diffuse-light-pipeline
                (clj->phaser ax)
                (clj->phaser ay)
                (clj->phaser bx)
                (clj->phaser by)
                (clj->phaser a-line-width)
                (clj->phaser b-line-width)
                (clj->phaser current-matrix)))))

(defn batch-quad
  "Adds the vertices data into the batch and flushes if full.

  Assumes 6 vertices in the following arrangement:

  ```
  0----3
  |\\  B|
  | \\  |
  |  \\ |
  | A \\|
  |    \\
  1----2
  ```

  Where tx0/ty0 = 0, tx1/ty1 = 1, tx2/ty2 = 2 and tx3/ty3 = 3

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * x-0 (number) - The top-left x position.
    * y-0 (number) - The top-left y position.
    * x-1 (number) - The bottom-left x position.
    * y-1 (number) - The bottom-left y position.
    * x-2 (number) - The bottom-right x position.
    * y-2 (number) - The bottom-right y position.
    * x-3 (number) - The top-right x position.
    * y-3 (number) - The top-right y position.
    * u-0 (number) - UV u0 value.
    * v-0 (number) - UV v0 value.
    * u-1 (number) - UV u1 value.
    * v-1 (number) - UV v1 value.
    * tint-tl (number) - The top-left tint color value.
    * tint-tr (number) - The top-right tint color value.
    * tint-bl (number) - The bottom-left tint color value.
    * tint-br (number) - The bottom-right tint color value.
    * tint-effect (number | boolean) - The tint effect for the shader to use.
    * texture (WebGLTexture) {optional} - WebGLTexture that will be assigned to the current batch if a flush occurs.
    * unit (integer) {optional} - Texture unit to which the texture needs to be bound.

  Returns:  boolean - `true` if this method caused the batch to flush, otherwise `false`."
  ([forward-diffuse-light-pipeline x-0 y-0 x-1 y-1 x-2 y-2 x-3 y-3 u-0 v-0 u-1 v-1 tint-tl tint-tr tint-bl tint-br tint-effect]
   (phaser->clj
    (.batchQuad forward-diffuse-light-pipeline
                (clj->phaser x-0)
                (clj->phaser y-0)
                (clj->phaser x-1)
                (clj->phaser y-1)
                (clj->phaser x-2)
                (clj->phaser y-2)
                (clj->phaser x-3)
                (clj->phaser y-3)
                (clj->phaser u-0)
                (clj->phaser v-0)
                (clj->phaser u-1)
                (clj->phaser v-1)
                (clj->phaser tint-tl)
                (clj->phaser tint-tr)
                (clj->phaser tint-bl)
                (clj->phaser tint-br)
                (clj->phaser tint-effect))))
  ([forward-diffuse-light-pipeline x-0 y-0 x-1 y-1 x-2 y-2 x-3 y-3 u-0 v-0 u-1 v-1 tint-tl tint-tr tint-bl tint-br tint-effect texture]
   (phaser->clj
    (.batchQuad forward-diffuse-light-pipeline
                (clj->phaser x-0)
                (clj->phaser y-0)
                (clj->phaser x-1)
                (clj->phaser y-1)
                (clj->phaser x-2)
                (clj->phaser y-2)
                (clj->phaser x-3)
                (clj->phaser y-3)
                (clj->phaser u-0)
                (clj->phaser v-0)
                (clj->phaser u-1)
                (clj->phaser v-1)
                (clj->phaser tint-tl)
                (clj->phaser tint-tr)
                (clj->phaser tint-bl)
                (clj->phaser tint-br)
                (clj->phaser tint-effect)
                (clj->phaser texture))))
  ([forward-diffuse-light-pipeline x-0 y-0 x-1 y-1 x-2 y-2 x-3 y-3 u-0 v-0 u-1 v-1 tint-tl tint-tr tint-bl tint-br tint-effect texture unit]
   (phaser->clj
    (.batchQuad forward-diffuse-light-pipeline
                (clj->phaser x-0)
                (clj->phaser y-0)
                (clj->phaser x-1)
                (clj->phaser y-1)
                (clj->phaser x-2)
                (clj->phaser y-2)
                (clj->phaser x-3)
                (clj->phaser y-3)
                (clj->phaser u-0)
                (clj->phaser v-0)
                (clj->phaser u-1)
                (clj->phaser v-1)
                (clj->phaser tint-tl)
                (clj->phaser tint-tr)
                (clj->phaser tint-bl)
                (clj->phaser tint-br)
                (clj->phaser tint-effect)
                (clj->phaser texture)
                (clj->phaser unit)))))

(defn batch-sprite
  "Takes a Sprite Game Object, or any object that extends it, which has a normal texture and adds it to the batch.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * sprite (Phaser.GameObjects.Sprite) - The texture-based Game Object to add to the batch.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to use for the rendering transform.
    * parent-transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - The transform matrix of the parent container, if set."
  ([forward-diffuse-light-pipeline sprite camera parent-transform-matrix]
   (phaser->clj
    (.batchSprite forward-diffuse-light-pipeline
                  (clj->phaser sprite)
                  (clj->phaser camera)
                  (clj->phaser parent-transform-matrix)))))

(defn batch-stroke-path
  "Adds the given path to the vertex batch for rendering.

  It works by taking the array of path data and calling `batchLine` for each section
  of the path.

  The path is optionally closed at the end.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * path (array) - Collection of points that represent the path.
    * line-width (number) - The width of the line segments in pixels.
    * path-open (boolean) - Indicates if the path should be closed or left open.
    * current-matrix (Phaser.GameObjects.Components.TransformMatrix) - The current transform.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) - The parent transform."
  ([forward-diffuse-light-pipeline path line-width path-open current-matrix parent-matrix]
   (phaser->clj
    (.batchStrokePath forward-diffuse-light-pipeline
                      (clj->phaser path)
                      (clj->phaser line-width)
                      (clj->phaser path-open)
                      (clj->phaser current-matrix)
                      (clj->phaser parent-matrix)))))

(defn batch-stroke-triangle
  "Pushes a stroked triangle into the vertex batch.
  Triangle factors in the given transform matrices before adding to the batch.
  The triangle is created from 3 lines and drawn using the `batchStrokePath` method.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * x-0 (number) - Point 0 x coordinate.
    * y-0 (number) - Point 0 y coordinate.
    * x-1 (number) - Point 1 x coordinate.
    * y-1 (number) - Point 1 y coordinate.
    * x-2 (number) - Point 2 x coordinate.
    * y-2 (number) - Point 2 y coordinate.
    * line-width (number) - The width of the line in pixels.
    * current-matrix (Phaser.GameObjects.Components.TransformMatrix) - The current transform.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) - The parent transform."
  ([forward-diffuse-light-pipeline x-0 y-0 x-1 y-1 x-2 y-2 line-width current-matrix parent-matrix]
   (phaser->clj
    (.batchStrokeTriangle forward-diffuse-light-pipeline
                          (clj->phaser x-0)
                          (clj->phaser y-0)
                          (clj->phaser x-1)
                          (clj->phaser y-1)
                          (clj->phaser x-2)
                          (clj->phaser y-2)
                          (clj->phaser line-width)
                          (clj->phaser current-matrix)
                          (clj->phaser parent-matrix)))))

(defn batch-texture
  "Generic function for batching a textured quad

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - Source GameObject
    * texture (WebGLTexture) - Raw WebGLTexture associated with the quad
    * texture-width (integer) - Real texture width
    * texture-height (integer) - Real texture height
    * src-x (number) - X coordinate of the quad
    * src-y (number) - Y coordinate of the quad
    * src-width (number) - Width of the quad
    * src-height (number) - Height of the quad
    * scale-x (number) - X component of scale
    * scale-y (number) - Y component of scale
    * rotation (number) - Rotation of the quad
    * flip-x (boolean) - Indicates if the quad is horizontally flipped
    * flip-y (boolean) - Indicates if the quad is vertically flipped
    * scroll-factor-x (number) - By which factor is the quad affected by the camera horizontal scroll
    * scroll-factor-y (number) - By which factor is the quad effected by the camera vertical scroll
    * display-origin-x (number) - Horizontal origin in pixels
    * display-origin-y (number) - Vertical origin in pixels
    * frame-x (number) - X coordinate of the texture frame
    * frame-y (number) - Y coordinate of the texture frame
    * frame-width (number) - Width of the texture frame
    * frame-height (number) - Height of the texture frame
    * tint-tl (integer) - Tint for top left
    * tint-tr (integer) - Tint for top right
    * tint-bl (integer) - Tint for bottom left
    * tint-br (integer) - Tint for bottom right
    * tint-effect (number) - The tint effect (0 for additive, 1 for replacement)
    * u-offset (number) - Horizontal offset on texture coordinate
    * v-offset (number) - Vertical offset on texture coordinate
    * camera (Phaser.Cameras.Scene2D.Camera) - Current used camera
    * parent-transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Parent container"
  ([forward-diffuse-light-pipeline game-object texture texture-width texture-height src-x src-y src-width src-height scale-x scale-y rotation flip-x flip-y scroll-factor-x scroll-factor-y display-origin-x display-origin-y frame-x frame-y frame-width frame-height tint-tl tint-tr tint-bl tint-br tint-effect u-offset v-offset camera parent-transform-matrix]
   (phaser->clj
    (.batchTexture forward-diffuse-light-pipeline
                   (clj->phaser game-object)
                   (clj->phaser texture)
                   (clj->phaser texture-width)
                   (clj->phaser texture-height)
                   (clj->phaser src-x)
                   (clj->phaser src-y)
                   (clj->phaser src-width)
                   (clj->phaser src-height)
                   (clj->phaser scale-x)
                   (clj->phaser scale-y)
                   (clj->phaser rotation)
                   (clj->phaser flip-x)
                   (clj->phaser flip-y)
                   (clj->phaser scroll-factor-x)
                   (clj->phaser scroll-factor-y)
                   (clj->phaser display-origin-x)
                   (clj->phaser display-origin-y)
                   (clj->phaser frame-x)
                   (clj->phaser frame-y)
                   (clj->phaser frame-width)
                   (clj->phaser frame-height)
                   (clj->phaser tint-tl)
                   (clj->phaser tint-tr)
                   (clj->phaser tint-bl)
                   (clj->phaser tint-br)
                   (clj->phaser tint-effect)
                   (clj->phaser u-offset)
                   (clj->phaser v-offset)
                   (clj->phaser camera)
                   (clj->phaser parent-transform-matrix)))))

(defn batch-texture-frame
  "Adds a Texture Frame into the batch for rendering.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * frame (Phaser.Textures.Frame) - The Texture Frame to be rendered.
    * x (number) - The horizontal position to render the texture at.
    * y (number) - The vertical position to render the texture at.
    * tint (number) - The tint color.
    * alpha (number) - The alpha value.
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - The Transform Matrix to use for the texture.
    * parent-transform-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A parent Transform Matrix."
  ([forward-diffuse-light-pipeline frame x y tint alpha transform-matrix]
   (phaser->clj
    (.batchTextureFrame forward-diffuse-light-pipeline
                        (clj->phaser frame)
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser tint)
                        (clj->phaser alpha)
                        (clj->phaser transform-matrix))))
  ([forward-diffuse-light-pipeline frame x y tint alpha transform-matrix parent-transform-matrix]
   (phaser->clj
    (.batchTextureFrame forward-diffuse-light-pipeline
                        (clj->phaser frame)
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser tint)
                        (clj->phaser alpha)
                        (clj->phaser transform-matrix)
                        (clj->phaser parent-transform-matrix)))))

(defn batch-tri
  "Adds the vertices data into the batch and flushes if full.

  Assumes 3 vertices in the following arrangement:

  ```
  0
  |\\
  | \\
  |  \\
  |   \\
  |    \\
  1-----2
  ```

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * x-1 (number) - The bottom-left x position.
    * y-1 (number) - The bottom-left y position.
    * x-2 (number) - The bottom-right x position.
    * y-2 (number) - The bottom-right y position.
    * x-3 (number) - The top-right x position.
    * y-3 (number) - The top-right y position.
    * u-0 (number) - UV u0 value.
    * v-0 (number) - UV v0 value.
    * u-1 (number) - UV u1 value.
    * v-1 (number) - UV v1 value.
    * tint-tl (number) - The top-left tint color value.
    * tint-tr (number) - The top-right tint color value.
    * tint-bl (number) - The bottom-left tint color value.
    * tint-effect (number | boolean) - The tint effect for the shader to use.
    * texture (WebGLTexture) {optional} - WebGLTexture that will be assigned to the current batch if a flush occurs.
    * unit (integer) {optional} - Texture unit to which the texture needs to be bound.

  Returns:  boolean - `true` if this method caused the batch to flush, otherwise `false`."
  ([forward-diffuse-light-pipeline x-1 y-1 x-2 y-2 x-3 y-3 u-0 v-0 u-1 v-1 tint-tl tint-tr tint-bl tint-effect]
   (phaser->clj
    (.batchTri forward-diffuse-light-pipeline
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2)
               (clj->phaser y-2)
               (clj->phaser x-3)
               (clj->phaser y-3)
               (clj->phaser u-0)
               (clj->phaser v-0)
               (clj->phaser u-1)
               (clj->phaser v-1)
               (clj->phaser tint-tl)
               (clj->phaser tint-tr)
               (clj->phaser tint-bl)
               (clj->phaser tint-effect))))
  ([forward-diffuse-light-pipeline x-1 y-1 x-2 y-2 x-3 y-3 u-0 v-0 u-1 v-1 tint-tl tint-tr tint-bl tint-effect texture]
   (phaser->clj
    (.batchTri forward-diffuse-light-pipeline
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2)
               (clj->phaser y-2)
               (clj->phaser x-3)
               (clj->phaser y-3)
               (clj->phaser u-0)
               (clj->phaser v-0)
               (clj->phaser u-1)
               (clj->phaser v-1)
               (clj->phaser tint-tl)
               (clj->phaser tint-tr)
               (clj->phaser tint-bl)
               (clj->phaser tint-effect)
               (clj->phaser texture))))
  ([forward-diffuse-light-pipeline x-1 y-1 x-2 y-2 x-3 y-3 u-0 v-0 u-1 v-1 tint-tl tint-tr tint-bl tint-effect texture unit]
   (phaser->clj
    (.batchTri forward-diffuse-light-pipeline
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2)
               (clj->phaser y-2)
               (clj->phaser x-3)
               (clj->phaser y-3)
               (clj->phaser u-0)
               (clj->phaser v-0)
               (clj->phaser u-1)
               (clj->phaser v-1)
               (clj->phaser tint-tl)
               (clj->phaser tint-tr)
               (clj->phaser tint-bl)
               (clj->phaser tint-effect)
               (clj->phaser texture)
               (clj->phaser unit)))))

(defn bind
  "Binds the pipeline resources, including programs, vertex buffers and binds attributes

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.bind forward-diffuse-light-pipeline))))

(defn boot
  "Called when the Game has fully booted and the Renderer has finished setting up.

  By this stage all Game level systems are now in place and you can perform any final
  tasks that the pipeline may need that relied on game systems such as the Texture Manager."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.boot forward-diffuse-light-pipeline))))

(defn boot
  "Called when the Game has fully booted and the Renderer has finished setting up.

  By this stage all Game level systems are now in place and you can perform any final
  tasks that the pipeline may need that relied on game systems such as the Texture Manager."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.boot forward-diffuse-light-pipeline))))

(defn destroy
  "Removes all object references in this WebGL Pipeline and removes its program from the WebGL context.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.destroy forward-diffuse-light-pipeline))))

(defn draw-fill-rect
  "Pushes a filled rectangle into the vertex batch.
  Rectangle has no transform values and isn't transformed into the local space.
  Used for directly batching untransformed rectangles, such as Camera background colors.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * x (number) - Horizontal top left coordinate of the rectangle.
    * y (number) - Vertical top left coordinate of the rectangle.
    * width (number) - Width of the rectangle.
    * height (number) - Height of the rectangle.
    * color (number) - Color of the rectangle to draw.
    * alpha (number) - Alpha value of the rectangle to draw."
  ([forward-diffuse-light-pipeline x y width height color alpha]
   (phaser->clj
    (.drawFillRect forward-diffuse-light-pipeline
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser color)
                   (clj->phaser alpha)))))

(defn flush
  "Uploads the vertex data and emits a draw call for the current batch of vertices.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.flush forward-diffuse-light-pipeline))))

(defn on-bind
  "This function binds its base class resources and this lights 2D resources.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) {optional} - The Game Object that invoked this pipeline, if any.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.onBind forward-diffuse-light-pipeline)))
  ([forward-diffuse-light-pipeline game-object]
   (phaser->clj
    (.onBind forward-diffuse-light-pipeline
             (clj->phaser game-object)))))

(defn on-bind
  "This function binds its base class resources and this lights 2D resources.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) {optional} - The Game Object that invoked this pipeline, if any.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.onBind forward-diffuse-light-pipeline)))
  ([forward-diffuse-light-pipeline game-object]
   (phaser->clj
    (.onBind forward-diffuse-light-pipeline
             (clj->phaser game-object)))))

(defn on-post-render
  "Called after each frame has been completely rendered and snapshots have been taken.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.onPostRender forward-diffuse-light-pipeline))))

(defn on-pre-render
  "Called before each frame is rendered, but after the canvas has been cleared.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.onPreRender forward-diffuse-light-pipeline))))

(defn on-render
  "This function sets all the needed resources for each camera pass.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene being rendered.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Scene Camera being rendered with.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline scene camera]
   (phaser->clj
    (.onRender forward-diffuse-light-pipeline
               (clj->phaser scene)
               (clj->phaser camera)))))

(defn push-batch
  "Creates a new batch object and pushes it to a batch array.
  The batch object contains information relevant to the current 
  vertex batch like the offset in the vertex buffer, vertex count and 
  the textures used by that batch.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * texture (WebGLTexture) - Optional WebGLTexture that will be assigned to the created batch.
    * unit (integer) - Texture unit to which the texture needs to be bound."
  ([forward-diffuse-light-pipeline texture unit]
   (phaser->clj
    (.pushBatch forward-diffuse-light-pipeline
                (clj->phaser texture)
                (clj->phaser unit)))))

(defn require-texture-batch
  "Checks if the current batch has the same texture and texture unit, or if we need to create a new batch.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * texture (WebGLTexture) - WebGLTexture that will be assigned to the current batch. If not given uses blankTexture.
    * unit (integer) - Texture unit to which the texture needs to be bound.

  Returns:  boolean - `true` if the pipeline needs to create a new batch, otherwise `false`."
  ([forward-diffuse-light-pipeline texture unit]
   (phaser->clj
    (.requireTextureBatch forward-diffuse-light-pipeline
                          (clj->phaser texture)
                          (clj->phaser unit)))))

(defn resize
  "Resizes this pipeline and updates the projection.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * width (number) - The new width.
    * height (number) - The new height.
    * resolution (number) - The resolution.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline width height resolution]
   (phaser->clj
    (.resize forward-diffuse-light-pipeline
             (clj->phaser width)
             (clj->phaser height)
             (clj->phaser resolution)))))

(defn set-float-1
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new value of the `float` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name x]
   (phaser->clj
    (.setFloat1 forward-diffuse-light-pipeline
                (clj->phaser name)
                (clj->phaser x)))))

(defn set-float-1v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name arr]
   (phaser->clj
    (.setFloat1v forward-diffuse-light-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new X component of the `vec2` uniform.
    * y (number) - The new Y component of the `vec2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name x y]
   (phaser->clj
    (.setFloat2 forward-diffuse-light-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-float-2v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name arr]
   (phaser->clj
    (.setFloat2v forward-diffuse-light-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new X component of the `vec3` uniform.
    * y (number) - The new Y component of the `vec3` uniform.
    * z (number) - The new Z component of the `vec3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name x y z]
   (phaser->clj
    (.setFloat3 forward-diffuse-light-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser z)))))

(defn set-float-3v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name arr]
   (phaser->clj
    (.setFloat3v forward-diffuse-light-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - X component of the uniform
    * y (number) - Y component of the uniform
    * z (number) - Z component of the uniform
    * w (number) - W component of the uniform

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name x y z w]
   (phaser->clj
    (.setFloat4 forward-diffuse-light-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser z)
                (clj->phaser w)))))

(defn set-float-4v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name arr]
   (phaser->clj
    (.setFloat4v forward-diffuse-light-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-int-1
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new value of the `int` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name x]
   (phaser->clj
    (.setInt1 forward-diffuse-light-pipeline
              (clj->phaser name)
              (clj->phaser x)))))

(defn set-int-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new X component of the `ivec2` uniform.
    * y (integer) - The new Y component of the `ivec2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name x y]
   (phaser->clj
    (.setInt2 forward-diffuse-light-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-int-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new X component of the `ivec3` uniform.
    * y (integer) - The new Y component of the `ivec3` uniform.
    * z (integer) - The new Z component of the `ivec3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name x y z]
   (phaser->clj
    (.setInt3 forward-diffuse-light-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)))))

(defn set-int-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - X component of the uniform
    * y (integer) - Y component of the uniform
    * z (integer) - Z component of the uniform
    * w (integer) - W component of the uniform

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name x y z w]
   (phaser->clj
    (.setInt4 forward-diffuse-light-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)
              (clj->phaser w)))))

(defn set-matrix-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Whether to transpose the matrix. Should be `false`.
    * matrix (Float32Array) - The new values for the `mat2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix2 forward-diffuse-light-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-matrix-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Whether to transpose the matrix. Should be `false`.
    * matrix (Float32Array) - The new values for the `mat3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix3 forward-diffuse-light-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-matrix-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Should the matrix be transpose
    * matrix (Float32Array) - Matrix data

  Returns:  this - This WebGLPipeline instance."
  ([forward-diffuse-light-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix4 forward-diffuse-light-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-normal-map
  "Sets the Game Objects normal map as the active texture.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object to update."
  ([forward-diffuse-light-pipeline game-object]
   (phaser->clj
    (.setNormalMap forward-diffuse-light-pipeline
                   (clj->phaser game-object)))))

(defn set-normal-map-rotation
  "Rotates the normal map vectors inversely by the given angle.
  Only works in 2D space.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * rotation (number) - The angle of rotation in radians."
  ([forward-diffuse-light-pipeline rotation]
   (phaser->clj
    (.setNormalMapRotation forward-diffuse-light-pipeline
                           (clj->phaser rotation)))))

(defn set-texture-2-d
  "Assigns a texture to the current batch. If a different texture is already set it creates a new batch object.

  Parameters:
    * forward-diffuse-light-pipeline (Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline) - Targeted instance for method
    * texture (WebGLTexture) {optional} - WebGLTexture that will be assigned to the current batch. If not given uses blankTexture.
    * unit (integer) {optional} - Texture unit to which the texture needs to be bound.

  Returns:  Phaser.Renderer.WebGL.Pipelines.TextureTintPipeline - This pipeline instance."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.setTexture2D forward-diffuse-light-pipeline)))
  ([forward-diffuse-light-pipeline texture]
   (phaser->clj
    (.setTexture2D forward-diffuse-light-pipeline
                   (clj->phaser texture))))
  ([forward-diffuse-light-pipeline texture unit]
   (phaser->clj
    (.setTexture2D forward-diffuse-light-pipeline
                   (clj->phaser texture)
                   (clj->phaser unit)))))

(defn should-flush
  "Check if the current batch of vertices is full.

  Returns:  boolean - `true` if the current batch should be flushed, otherwise `false`."
  ([forward-diffuse-light-pipeline]
   (phaser->clj
    (.shouldFlush forward-diffuse-light-pipeline))))