(ns phzr.renderer.webgl.webgl-renderer
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [flush]))

(defn ->WebGLRenderer
  "  Parameters:
    * game (Phaser.Game) - The Game instance which owns this WebGL Renderer."
  ([game]
   (js/Phaser.Renderer.WebGL.WebGLRenderer. (clj->phaser game))))

(defn add-blend-mode
  "Creates a new custom blend mode for the renderer.

  See https://developer.mozilla.org/en-US/docs/Web/API/WebGL_API/Constants#Blending_modes

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * func (Array.<GLenum>) - An array containing the WebGL functions to use for the source and the destination blending factors, respectively. See the possible constants for {@link WebGLRenderingContext#blendFunc()}.
    * equation (GLenum) - The equation to use for combining the RGB and alpha components of a new pixel with a rendered one. See the possible constants for {@link WebGLRenderingContext#blendEquation()}.

  Returns:  integer - The index of the new blend mode, used for referencing it in the future."
  ([webgl-renderer func equation]
   (phaser->clj
    (.addBlendMode webgl-renderer
                   (clj->phaser func)
                   (clj->phaser equation)))))

(defn add-pipeline
  "Adds a pipeline instance into the collection of pipelines

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * pipeline-name (string) - A unique string-based key for the pipeline.
    * pipeline-instance (Phaser.Renderer.WebGL.WebGLPipeline) - A pipeline instance which must extend WebGLPipeline.

  Returns:  Phaser.Renderer.WebGL.WebGLPipeline - The pipeline instance that was passed."
  ([webgl-renderer pipeline-name pipeline-instance]
   (phaser->clj
    (.addPipeline webgl-renderer
                  (clj->phaser pipeline-name)
                  (clj->phaser pipeline-instance)))))

(defn canvas-to-texture
  "Creates a new WebGL Texture based on the given Canvas Element.

  If the `dstTexture` parameter is given, the WebGL Texture is updated, rather than created fresh.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * src-canvas (HTMLCanvasElement) - The Canvas to create the WebGL Texture from
    * dst-texture (WebGLTexture) {optional} - The destination WebGL Texture to set.
    * no-repeat (boolean) {optional} - Should this canvas be allowed to set `REPEAT` (such as for Text objects?)
    * flip-y (boolean) {optional} - Should the WebGL Texture set `UNPACK_MULTIPLY_FLIP_Y`?

  Returns:  WebGLTexture - The newly created, or updated, WebGL Texture."
  ([webgl-renderer src-canvas]
   (phaser->clj
    (.canvasToTexture webgl-renderer
                      (clj->phaser src-canvas))))
  ([webgl-renderer src-canvas dst-texture]
   (phaser->clj
    (.canvasToTexture webgl-renderer
                      (clj->phaser src-canvas)
                      (clj->phaser dst-texture))))
  ([webgl-renderer src-canvas dst-texture no-repeat]
   (phaser->clj
    (.canvasToTexture webgl-renderer
                      (clj->phaser src-canvas)
                      (clj->phaser dst-texture)
                      (clj->phaser no-repeat))))
  ([webgl-renderer src-canvas dst-texture no-repeat flip-y]
   (phaser->clj
    (.canvasToTexture webgl-renderer
                      (clj->phaser src-canvas)
                      (clj->phaser dst-texture)
                      (clj->phaser no-repeat)
                      (clj->phaser flip-y)))))

(defn clear-pipeline
  "Flushes the current WebGLPipeline being used and then clears it, along with the
  the current shader program and vertex buffer. Then resets the blend mode to NORMAL.
  Call this before jumping to your own gl context handler, and then call `rebindPipeline` when
  you wish to return control to Phaser again."
  ([webgl-renderer]
   (phaser->clj
    (.clearPipeline webgl-renderer))))

(defn create-canvas-texture
  "Creates a new WebGL Texture based on the given Canvas Element.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * src-canvas (HTMLCanvasElement) - The Canvas to create the WebGL Texture from
    * no-repeat (boolean) {optional} - Should this canvas be allowed to set `REPEAT` (such as for Text objects?)
    * flip-y (boolean) {optional} - Should the WebGL Texture set `UNPACK_MULTIPLY_FLIP_Y`?

  Returns:  WebGLTexture - The newly created WebGL Texture."
  ([webgl-renderer src-canvas]
   (phaser->clj
    (.createCanvasTexture webgl-renderer
                          (clj->phaser src-canvas))))
  ([webgl-renderer src-canvas no-repeat]
   (phaser->clj
    (.createCanvasTexture webgl-renderer
                          (clj->phaser src-canvas)
                          (clj->phaser no-repeat))))
  ([webgl-renderer src-canvas no-repeat flip-y]
   (phaser->clj
    (.createCanvasTexture webgl-renderer
                          (clj->phaser src-canvas)
                          (clj->phaser no-repeat)
                          (clj->phaser flip-y)))))

(defn create-framebuffer
  "Wrapper for creating WebGLFramebuffer.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * width (integer) - Width in pixels of the framebuffer
    * height (integer) - Height in pixels of the framebuffer
    * render-texture (WebGLTexture) - The color texture to where the color pixels are written
    * add-depth-stencil-buffer (boolean) - Indicates if the current framebuffer support depth and stencil buffers

  Returns:  WebGLFramebuffer - Raw WebGLFramebuffer"
  ([webgl-renderer width height render-texture add-depth-stencil-buffer]
   (phaser->clj
    (.createFramebuffer webgl-renderer
                        (clj->phaser width)
                        (clj->phaser height)
                        (clj->phaser render-texture)
                        (clj->phaser add-depth-stencil-buffer)))))

(defn create-index-buffer
  "Wrapper for creating a vertex buffer.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * initial-data-or-size (ArrayBuffer) - Either ArrayBuffer or an integer indicating the size of the vbo.
    * buffer-usage (integer) - How the buffer is used. gl.DYNAMIC_DRAW, gl.STATIC_DRAW or gl.STREAM_DRAW.

  Returns:  WebGLBuffer - Raw index buffer"
  ([webgl-renderer initial-data-or-size buffer-usage]
   (phaser->clj
    (.createIndexBuffer webgl-renderer
                        (clj->phaser initial-data-or-size)
                        (clj->phaser buffer-usage)))))

(defn create-program
  "Wrapper for creating a WebGLProgram

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * vertex-shader (string) - Source to the vertex shader
    * fragment-shader (string) - Source to the fragment shader

  Returns:  WebGLProgram - Raw WebGLProgram"
  ([webgl-renderer vertex-shader fragment-shader]
   (phaser->clj
    (.createProgram webgl-renderer
                    (clj->phaser vertex-shader)
                    (clj->phaser fragment-shader)))))

(defn create-texture-2-d
  "A wrapper for creating a WebGLTexture. If no pixel data is passed it will create an empty texture.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * mip-level (integer) - Mip level of the texture.
    * min-filter (integer) - Filtering of the texture.
    * mag-filter (integer) - Filtering of the texture.
    * wrap-t (integer) - Wrapping mode of the texture.
    * wrap-s (integer) - Wrapping mode of the texture.
    * format (integer) - Which format does the texture use.
    * pixels (object) - pixel data.
    * width (integer) - Width of the texture in pixels.
    * height (integer) - Height of the texture in pixels.
    * pma (boolean) {optional} - Does the texture have premultiplied alpha?
    * force-size (boolean) {optional} - If `true` it will use the width and height passed to this method, regardless of the pixels dimension.
    * flip-y (boolean) {optional} - Sets the `UNPACK_FLIP_Y_WEBGL` flag the WebGL Texture uses during upload.

  Returns:  WebGLTexture - The WebGLTexture that was created."
  ([webgl-renderer mip-level min-filter mag-filter wrap-t wrap-s format pixels width height]
   (phaser->clj
    (.createTexture2D webgl-renderer
                      (clj->phaser mip-level)
                      (clj->phaser min-filter)
                      (clj->phaser mag-filter)
                      (clj->phaser wrap-t)
                      (clj->phaser wrap-s)
                      (clj->phaser format)
                      (clj->phaser pixels)
                      (clj->phaser width)
                      (clj->phaser height))))
  ([webgl-renderer mip-level min-filter mag-filter wrap-t wrap-s format pixels width height pma]
   (phaser->clj
    (.createTexture2D webgl-renderer
                      (clj->phaser mip-level)
                      (clj->phaser min-filter)
                      (clj->phaser mag-filter)
                      (clj->phaser wrap-t)
                      (clj->phaser wrap-s)
                      (clj->phaser format)
                      (clj->phaser pixels)
                      (clj->phaser width)
                      (clj->phaser height)
                      (clj->phaser pma))))
  ([webgl-renderer mip-level min-filter mag-filter wrap-t wrap-s format pixels width height pma force-size]
   (phaser->clj
    (.createTexture2D webgl-renderer
                      (clj->phaser mip-level)
                      (clj->phaser min-filter)
                      (clj->phaser mag-filter)
                      (clj->phaser wrap-t)
                      (clj->phaser wrap-s)
                      (clj->phaser format)
                      (clj->phaser pixels)
                      (clj->phaser width)
                      (clj->phaser height)
                      (clj->phaser pma)
                      (clj->phaser force-size))))
  ([webgl-renderer mip-level min-filter mag-filter wrap-t wrap-s format pixels width height pma force-size flip-y]
   (phaser->clj
    (.createTexture2D webgl-renderer
                      (clj->phaser mip-level)
                      (clj->phaser min-filter)
                      (clj->phaser mag-filter)
                      (clj->phaser wrap-t)
                      (clj->phaser wrap-s)
                      (clj->phaser format)
                      (clj->phaser pixels)
                      (clj->phaser width)
                      (clj->phaser height)
                      (clj->phaser pma)
                      (clj->phaser force-size)
                      (clj->phaser flip-y)))))

(defn create-texture-from-source
  "Creates a texture from an image source. If the source is not valid it creates an empty texture.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * source (object) - The source of the texture.
    * width (integer) - The width of the texture.
    * height (integer) - The height of the texture.
    * scale-mode (integer) - The scale mode to be used by the texture.

  Returns:  WebGLTexture - The WebGL Texture that was created, or `null` if it couldn't be created."
  ([webgl-renderer source width height scale-mode]
   (phaser->clj
    (.createTextureFromSource webgl-renderer
                              (clj->phaser source)
                              (clj->phaser width)
                              (clj->phaser height)
                              (clj->phaser scale-mode)))))

(defn create-vertex-buffer
  "Wrapper for creating a vertex buffer.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * initial-data-or-size (ArrayBuffer) - It's either ArrayBuffer or an integer indicating the size of the vbo
    * buffer-usage (integer) - How the buffer is used. gl.DYNAMIC_DRAW, gl.STATIC_DRAW or gl.STREAM_DRAW

  Returns:  WebGLBuffer - Raw vertex buffer"
  ([webgl-renderer initial-data-or-size buffer-usage]
   (phaser->clj
    (.createVertexBuffer webgl-renderer
                         (clj->phaser initial-data-or-size)
                         (clj->phaser buffer-usage)))))

(defn create-video-texture
  "Creates a new WebGL Texture based on the given HTML Video Element.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * src-video (HTMLVideoElement) - The Video to create the WebGL Texture from
    * no-repeat (boolean) {optional} - Should this canvas be allowed to set `REPEAT`?
    * flip-y (boolean) {optional} - Should the WebGL Texture set `UNPACK_MULTIPLY_FLIP_Y`?

  Returns:  WebGLTexture - The newly created WebGL Texture."
  ([webgl-renderer src-video]
   (phaser->clj
    (.createVideoTexture webgl-renderer
                         (clj->phaser src-video))))
  ([webgl-renderer src-video no-repeat]
   (phaser->clj
    (.createVideoTexture webgl-renderer
                         (clj->phaser src-video)
                         (clj->phaser no-repeat))))
  ([webgl-renderer src-video no-repeat flip-y]
   (phaser->clj
    (.createVideoTexture webgl-renderer
                         (clj->phaser src-video)
                         (clj->phaser no-repeat)
                         (clj->phaser flip-y)))))

(defn delete-buffer
  "Deletes a WebGLBuffer from the GL instance.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * vertex-buffer (WebGLBuffer) - The WebGLBuffer to be deleted.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer vertex-buffer]
   (phaser->clj
    (.deleteBuffer webgl-renderer
                   (clj->phaser vertex-buffer)))))

(defn delete-framebuffer
  "Deletes a WebGLFramebuffer from the GL instance.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * framebuffer (WebGLFramebuffer) - The Framebuffer to be deleted.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer framebuffer]
   (phaser->clj
    (.deleteFramebuffer webgl-renderer
                        (clj->phaser framebuffer)))))

(defn delete-program
  "Deletes a WebGLProgram from the GL instance.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The shader program to be deleted.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer program]
   (phaser->clj
    (.deleteProgram webgl-renderer
                    (clj->phaser program)))))

(defn delete-texture
  "Removes the given texture from the nativeTextures array and then deletes it from the GPU.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * texture (WebGLTexture) - The WebGL Texture to be deleted.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer texture]
   (phaser->clj
    (.deleteTexture webgl-renderer
                    (clj->phaser texture)))))

(defn destroy
  "Destroy this WebGLRenderer, cleaning up all related resources such as pipelines, native textures, etc."
  ([webgl-renderer]
   (phaser->clj
    (.destroy webgl-renderer))))

(defn flush
  "Flushes the current pipeline if the pipeline is bound"
  ([webgl-renderer]
   (phaser->clj
    (.flush webgl-renderer))))

(defn get-extension
  "Loads a WebGL extension

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * extension-name (string) - The name of the extension to load.

  Returns:  object - WebGL extension if the extension is supported"
  ([webgl-renderer extension-name]
   (phaser->clj
    (.getExtension webgl-renderer
                   (clj->phaser extension-name)))))

(defn get-max-texture-size
  "Returns the largest texture size (either width or height) that can be created.
  Note that VRAM may not allow a texture of any given size, it just expresses
  hardware / driver support for a given size.

  Returns:  integer - The maximum supported texture size."
  ([webgl-renderer]
   (phaser->clj
    (.getMaxTextureSize webgl-renderer))))

(defn get-max-textures
  "Returns the maximum number of texture units that can be used in a fragment shader.

  Returns:  integer - The maximum number of textures WebGL supports."
  ([webgl-renderer]
   (phaser->clj
    (.getMaxTextures webgl-renderer))))

(defn get-pipeline
  "Returns the pipeline by name if the pipeline exists

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline.

  Returns:  Phaser.Renderer.WebGL.WebGLPipeline - The pipeline instance, or `null` if not found."
  ([webgl-renderer pipeline-name]
   (phaser->clj
    (.getPipeline webgl-renderer
                  (clj->phaser pipeline-name)))))

(defn has-active-stencil-mask
  "Is there an active stencil mask?

  Returns:  boolean - `true` if there is an active stencil mask, otherwise `false`."
  ([webgl-renderer]
   (phaser->clj
    (.hasActiveStencilMask webgl-renderer))))

(defn has-extension
  "Checks if a WebGL extension is supported

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * extension-name (string) - Name of the WebGL extension

  Returns:  boolean - `true` if the extension is supported, otherwise `false`."
  ([webgl-renderer extension-name]
   (phaser->clj
    (.hasExtension webgl-renderer
                   (clj->phaser extension-name)))))

(defn has-pipeline
  "Checks if a pipeline is present in the current WebGLRenderer

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline.

  Returns:  boolean - `true` if the given pipeline is loaded, otherwise `false`."
  ([webgl-renderer pipeline-name]
   (phaser->clj
    (.hasPipeline webgl-renderer
                  (clj->phaser pipeline-name)))))

(defn init
  "Creates a new WebGLRenderingContext and initializes all internal state.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * config (object) - The configuration object for the renderer.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer config]
   (phaser->clj
    (.init webgl-renderer
           (clj->phaser config)))))

(defn on-resize
  "The event handler that manages the `resize` event dispatched by the Scale Manager.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * game-size (Phaser.Structs.Size) - The default Game Size object. This is the un-modified game dimensions.
    * base-size (Phaser.Structs.Size) - The base Size object. The game dimensions multiplied by the resolution. The canvas width / height values match this.
    * display-size (Phaser.Structs.Size) - The display Size object. The size of the canvas style width / height attributes.
    * resolution (number) {optional} - The Scale Manager resolution setting."
  ([webgl-renderer game-size base-size display-size]
   (phaser->clj
    (.onResize webgl-renderer
               (clj->phaser game-size)
               (clj->phaser base-size)
               (clj->phaser display-size))))
  ([webgl-renderer game-size base-size display-size resolution]
   (phaser->clj
    (.onResize webgl-renderer
               (clj->phaser game-size)
               (clj->phaser base-size)
               (clj->phaser display-size)
               (clj->phaser resolution)))))

(defn pop-scissor
  "Pops the last scissor state and sets it."
  ([webgl-renderer]
   (phaser->clj
    (.popScissor webgl-renderer))))

(defn post-render
  "The post-render step happens after all Cameras in all Scenes have been rendered."
  ([webgl-renderer]
   (phaser->clj
    (.postRender webgl-renderer))))

(defn post-render-camera
  "Controls the post-render operations for the given camera.
  Renders the foreground camera effects like flash and fading. It resets the current scissor state.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to post-render."
  ([webgl-renderer camera]
   (phaser->clj
    (.postRenderCamera webgl-renderer
                       (clj->phaser camera)))))

(defn pre-render
  "Clears the current vertex buffer and updates pipelines."
  ([webgl-renderer]
   (phaser->clj
    (.preRender webgl-renderer))))

(defn pre-render-camera
  "Controls the pre-render operations for the given camera.
  Handles any clipping needed by the camera and renders the background color if a color is visible.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to pre-render."
  ([webgl-renderer camera]
   (phaser->clj
    (.preRenderCamera webgl-renderer
                      (clj->phaser camera)))))

(defn push-scissor
  "Pushes a new scissor state. This is used to set nested scissor states.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * x (integer) - The x position of the scissor.
    * y (integer) - The y position of the scissor.
    * width (integer) - The width of the scissor.
    * height (integer) - The height of the scissor.
    * drawing-buffer-height (integer) {optional} - Optional drawingBufferHeight override value.

  Returns:  Array.<integer> - An array containing the scissor values."
  ([webgl-renderer x y width height]
   (phaser->clj
    (.pushScissor webgl-renderer
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([webgl-renderer x y width height drawing-buffer-height]
   (phaser->clj
    (.pushScissor webgl-renderer
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser drawing-buffer-height)))))

(defn rebind-pipeline
  "Use this to reset the gl context to the state that Phaser requires to continue rendering.
  Calling this will:

  * Disable `DEPTH_TEST`, `CULL_FACE` and `STENCIL_TEST`.
  * Clear the depth buffer and stencil buffers.
  * Reset the viewport size.
  * Reset the blend mode.
  * Bind a blank texture as the active texture on texture unit zero.
  * Rebinds the given pipeline instance.

  You should call this having previously called `clearPipeline` and then wishing to return
  control to Phaser again.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * pipeline-instance (Phaser.Renderer.WebGL.WebGLPipeline) - The pipeline instance to be activated."
  ([webgl-renderer pipeline-instance]
   (phaser->clj
    (.rebindPipeline webgl-renderer
                     (clj->phaser pipeline-instance)))))

(defn remove-blend-mode
  "Removes a custom blend mode from the renderer.
  Any Game Objects still using this blend mode will error, so be sure to clear them first.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * index (integer) - The index of the custom blend mode to be removed.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer index]
   (phaser->clj
    (.removeBlendMode webgl-renderer
                      (clj->phaser index)))))

(defn remove-pipeline
  "Removes a pipeline by name.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to be removed.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer pipeline-name]
   (phaser->clj
    (.removePipeline webgl-renderer
                     (clj->phaser pipeline-name)))))

(defn render
  "The core render step for a Scene Camera.

  Iterates through the given Game Object's array and renders them with the given Camera.

  This is called by the `CameraManager.render` method. The Camera Manager instance belongs to a Scene, and is invoked
  by the Scene Systems.render method.

  This method is not called if `Camera.visible` is `false`, or `Camera.alpha` is zero.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene to render.
    * children (Phaser.GameObjects.GameObject) - The Game Object's within the Scene to be rendered.
    * interpolation-percentage (number) - The interpolation percentage to apply. Currently un-used.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Scene Camera to render with."
  ([webgl-renderer scene children interpolation-percentage camera]
   (phaser->clj
    (.render webgl-renderer
             (clj->phaser scene)
             (clj->phaser children)
             (clj->phaser interpolation-percentage)
             (clj->phaser camera)))))

(defn resize
  "Resizes the drawing buffer to match that required by the Scale Manager.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * width (number) {optional} - The new width of the renderer.
    * height (number) {optional} - The new height of the renderer.
    * resolution (number) {optional} - The new resolution of the renderer.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer]
   (phaser->clj
    (.resize webgl-renderer)))
  ([webgl-renderer width]
   (phaser->clj
    (.resize webgl-renderer
             (clj->phaser width))))
  ([webgl-renderer width height]
   (phaser->clj
    (.resize webgl-renderer
             (clj->phaser width)
             (clj->phaser height))))
  ([webgl-renderer width height resolution]
   (phaser->clj
    (.resize webgl-renderer
             (clj->phaser width)
             (clj->phaser height)
             (clj->phaser resolution)))))

(defn set-blend-mode
  "Sets the blend mode to the value given.

  If the current blend mode is different from the one given, the pipeline is flushed and the new
  blend mode is enabled.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * blend-mode-id (integer) - The blend mode to be set. Can be a `BlendModes` const or an integer value.
    * force (boolean) {optional} - Force the blend mode to be set, regardless of the currently set blend mode.

  Returns:  boolean - `true` if the blend mode was changed as a result of this call, forcing a flush, otherwise `false`."
  ([webgl-renderer blend-mode-id]
   (phaser->clj
    (.setBlendMode webgl-renderer
                   (clj->phaser blend-mode-id))))
  ([webgl-renderer blend-mode-id force]
   (phaser->clj
    (.setBlendMode webgl-renderer
                   (clj->phaser blend-mode-id)
                   (clj->phaser force)))))

(defn set-float-1
  "[description]

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - [description]

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name x]
   (phaser->clj
    (.setFloat1 webgl-renderer
                (clj->phaser program)
                (clj->phaser name)
                (clj->phaser x)))))

(defn set-float-1v
  "Sets the value of a uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name arr]
   (phaser->clj
    (.setFloat1v webgl-renderer
                 (clj->phaser program)
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-2
  "[description]

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - [description]
    * y (number) - [description]

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name x y]
   (phaser->clj
    (.setFloat2 webgl-renderer
                (clj->phaser program)
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-float-2v
  "Sets the value of a uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name arr]
   (phaser->clj
    (.setFloat2v webgl-renderer
                 (clj->phaser program)
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-3
  "[description]

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - [description]
    * y (number) - [description]
    * z (number) - [description]

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name x y z]
   (phaser->clj
    (.setFloat3 webgl-renderer
                (clj->phaser program)
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser z)))))

(defn set-float-3v
  "Sets the value of a uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name arr]
   (phaser->clj
    (.setFloat3v webgl-renderer
                 (clj->phaser program)
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-4
  "Sets uniform of a WebGLProgram

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - X component
    * y (number) - Y component
    * z (number) - Z component
    * w (number) - W component

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name x y z w]
   (phaser->clj
    (.setFloat4 webgl-renderer
                (clj->phaser program)
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser z)
                (clj->phaser w)))))

(defn set-float-4v
  "Sets the value of a uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name arr]
   (phaser->clj
    (.setFloat4v webgl-renderer
                 (clj->phaser program)
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-framebuffer
  "Binds a framebuffer. If there was another framebuffer already bound it will force a pipeline flush.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * framebuffer (WebGLFramebuffer) - The framebuffer that needs to be bound.
    * update-scissor (boolean) {optional} - If a framebuffer is given, set the gl scissor to match the frame buffer size? Or, if `null` given, pop the scissor from the stack.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer framebuffer]
   (phaser->clj
    (.setFramebuffer webgl-renderer
                     (clj->phaser framebuffer))))
  ([webgl-renderer framebuffer update-scissor]
   (phaser->clj
    (.setFramebuffer webgl-renderer
                     (clj->phaser framebuffer)
                     (clj->phaser update-scissor)))))

(defn set-index-buffer
  "Bounds a index buffer. If there is a index buffer already bound it'll force a pipeline flush.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * index-buffer (WebGLBuffer) - The buffer the needs to be bound.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer index-buffer]
   (phaser->clj
    (.setIndexBuffer webgl-renderer
                     (clj->phaser index-buffer)))))

(defn set-int-1
  "Sets the value of a uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - [description]

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name x]
   (phaser->clj
    (.setInt1 webgl-renderer
              (clj->phaser program)
              (clj->phaser name)
              (clj->phaser x)))))

(defn set-int-2
  "Sets the value of a uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new X component
    * y (integer) - The new Y component

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name x y]
   (phaser->clj
    (.setInt2 webgl-renderer
              (clj->phaser program)
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-int-3
  "Sets the value of a uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new X component
    * y (integer) - The new Y component
    * z (integer) - The new Z component

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name x y z]
   (phaser->clj
    (.setInt3 webgl-renderer
              (clj->phaser program)
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)))))

(defn set-int-4
  "Sets the value of a uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - X component
    * y (integer) - Y component
    * z (integer) - Z component
    * w (integer) - W component

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name x y z w]
   (phaser->clj
    (.setInt4 webgl-renderer
              (clj->phaser program)
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)
              (clj->phaser w)))))

(defn set-matrix-2
  "Sets the value of a 2x2 matrix uniform variable in the given WebGLProgram.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - The value indicating whether to transpose the matrix. Must be false.
    * matrix (Float32Array) - The new matrix value.

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name transpose matrix]
   (phaser->clj
    (.setMatrix2 webgl-renderer
                 (clj->phaser program)
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-matrix-3
  "[description]

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - [description]
    * matrix (Float32Array) - [description]

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name transpose matrix]
   (phaser->clj
    (.setMatrix3 webgl-renderer
                 (clj->phaser program)
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-matrix-4
  "Sets uniform of a WebGLProgram

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The target WebGLProgram from which the uniform location will be looked-up.
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Is the matrix transposed
    * matrix (Float32Array) - Matrix data

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer program name transpose matrix]
   (phaser->clj
    (.setMatrix4 webgl-renderer
                 (clj->phaser program)
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-pipeline
  "Binds a WebGLPipeline and sets it as the current pipeline to be used.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * pipeline-instance (Phaser.Renderer.WebGL.WebGLPipeline) - The pipeline instance to be activated.
    * game-object (Phaser.GameObjects.GameObject) {optional} - The Game Object that invoked this pipeline, if any.

  Returns:  Phaser.Renderer.WebGL.WebGLPipeline - The pipeline that was activated."
  ([webgl-renderer pipeline-instance]
   (phaser->clj
    (.setPipeline webgl-renderer
                  (clj->phaser pipeline-instance))))
  ([webgl-renderer pipeline-instance game-object]
   (phaser->clj
    (.setPipeline webgl-renderer
                  (clj->phaser pipeline-instance)
                  (clj->phaser game-object)))))

(defn set-program
  "Binds a program. If there was another program already bound it will force a pipeline flush.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * program (WebGLProgram) - The program that needs to be bound.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer program]
   (phaser->clj
    (.setProgram webgl-renderer
                 (clj->phaser program)))))

(defn set-scissor
  "Sets the current scissor state.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * x (integer) - The x position of the scissor.
    * y (integer) - The y position of the scissor.
    * width (integer) - The width of the scissor.
    * height (integer) - The height of the scissor.
    * drawing-buffer-height (integer) {optional} - Optional drawingBufferHeight override value."
  ([webgl-renderer x y width height]
   (phaser->clj
    (.setScissor webgl-renderer
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser width)
                 (clj->phaser height))))
  ([webgl-renderer x y width height drawing-buffer-height]
   (phaser->clj
    (.setScissor webgl-renderer
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser width)
                 (clj->phaser height)
                 (clj->phaser drawing-buffer-height)))))

(defn set-texture-2-d
  "Binds a texture at a texture unit. If a texture is already
  bound to that unit it will force a flush on the current pipeline.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * texture (WebGLTexture) - The WebGL texture that needs to be bound.
    * texture-unit (integer) - The texture unit to which the texture will be bound.
    * flush (boolean) {optional} - Will the current pipeline be flushed if this is a new texture, or not?

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer texture texture-unit]
   (phaser->clj
    (.setTexture2D webgl-renderer
                   (clj->phaser texture)
                   (clj->phaser texture-unit))))
  ([webgl-renderer texture texture-unit flush]
   (phaser->clj
    (.setTexture2D webgl-renderer
                   (clj->phaser texture)
                   (clj->phaser texture-unit)
                   (clj->phaser flush)))))

(defn set-texture-filter
  "Sets the minification and magnification filter for a texture.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * texture (integer) - The texture to set the filter for.
    * filter (integer) - The filter to set. 0 for linear filtering, 1 for nearest neighbor (blocky) filtering.

  Returns:  this - This WebGL Renderer instance."
  ([webgl-renderer texture filter]
   (phaser->clj
    (.setTextureFilter webgl-renderer
                       (clj->phaser texture)
                       (clj->phaser filter)))))

(defn set-vertex-buffer
  "Bounds a vertex buffer. If there is a vertex buffer already bound it'll force a pipeline flush.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * vertex-buffer (WebGLBuffer) - The buffer that needs to be bound.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer vertex-buffer]
   (phaser->clj
    (.setVertexBuffer webgl-renderer
                      (clj->phaser vertex-buffer)))))

(defn snapshot
  "Schedules a snapshot of the entire game viewport to be taken after the current frame is rendered.

  To capture a specific area see the `snapshotArea` method. To capture a specific pixel, see `snapshotPixel`.

  Only one snapshot can be active _per frame_. If you have already called `snapshotPixel`, for example, then
  calling this method will override it.

  Snapshots work by using the WebGL `readPixels` feature to grab every pixel from the frame buffer into an ArrayBufferView.
  It then parses this, copying the contents to a temporary Canvas and finally creating an Image object from it,
  which is the image returned to the callback provided. All in all, this is a computationally expensive and blocking process,
  which gets more expensive the larger the canvas size gets, so please be careful how you employ this in your game.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot image is created.
    * type (string) {optional} - The format of the image to create, usually `image/png` or `image/jpeg`.
    * encoder-options (number) {optional} - The image quality, between 0 and 1. Used for image formats with lossy compression, such as `image/jpeg`.

  Returns:  this - This WebGL Renderer."
  ([webgl-renderer callback]
   (phaser->clj
    (.snapshot webgl-renderer
               (clj->phaser callback))))
  ([webgl-renderer callback type]
   (phaser->clj
    (.snapshot webgl-renderer
               (clj->phaser callback)
               (clj->phaser type))))
  ([webgl-renderer callback type encoder-options]
   (phaser->clj
    (.snapshot webgl-renderer
               (clj->phaser callback)
               (clj->phaser type)
               (clj->phaser encoder-options)))))

(defn snapshot-area
  "Schedules a snapshot of the given area of the game viewport to be taken after the current frame is rendered.

  To capture the whole game viewport see the `snapshot` method. To capture a specific pixel, see `snapshotPixel`.

  Only one snapshot can be active _per frame_. If you have already called `snapshotPixel`, for example, then
  calling this method will override it.

  Snapshots work by using the WebGL `readPixels` feature to grab every pixel from the frame buffer into an ArrayBufferView.
  It then parses this, copying the contents to a temporary Canvas and finally creating an Image object from it,
  which is the image returned to the callback provided. All in all, this is a computationally expensive and blocking process,
  which gets more expensive the larger the canvas size gets, so please be careful how you employ this in your game.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * x (integer) - The x coordinate to grab from.
    * y (integer) - The y coordinate to grab from.
    * width (integer) - The width of the area to grab.
    * height (integer) - The height of the area to grab.
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot image is created.
    * type (string) {optional} - The format of the image to create, usually `image/png` or `image/jpeg`.
    * encoder-options (number) {optional} - The image quality, between 0 and 1. Used for image formats with lossy compression, such as `image/jpeg`.

  Returns:  this - This WebGL Renderer."
  ([webgl-renderer x y width height callback]
   (phaser->clj
    (.snapshotArea webgl-renderer
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback))))
  ([webgl-renderer x y width height callback type]
   (phaser->clj
    (.snapshotArea webgl-renderer
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback)
                   (clj->phaser type))))
  ([webgl-renderer x y width height callback type encoder-options]
   (phaser->clj
    (.snapshotArea webgl-renderer
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser width)
                   (clj->phaser height)
                   (clj->phaser callback)
                   (clj->phaser type)
                   (clj->phaser encoder-options)))))

(defn snapshot-framebuffer
  "Takes a snapshot of the given area of the given frame buffer.

  Unlike the other snapshot methods, this one is processed immediately and doesn't wait for the next render.

  Snapshots work by using the WebGL `readPixels` feature to grab every pixel from the frame buffer into an ArrayBufferView.
  It then parses this, copying the contents to a temporary Canvas and finally creating an Image object from it,
  which is the image returned to the callback provided. All in all, this is a computationally expensive and blocking process,
  which gets more expensive the larger the canvas size gets, so please be careful how you employ this in your game.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * framebuffer (WebGLFramebuffer) - The framebuffer to grab from.
    * buffer-width (integer) - The width of the framebuffer.
    * buffer-height (integer) - The height of the framebuffer.
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot image is created.
    * get-pixel (boolean) {optional} - Grab a single pixel as a Color object, or an area as an Image object?
    * x (integer) {optional} - The x coordinate to grab from.
    * y (integer) {optional} - The y coordinate to grab from.
    * width (integer) {optional} - The width of the area to grab.
    * height (integer) {optional} - The height of the area to grab.
    * type (string) {optional} - The format of the image to create, usually `image/png` or `image/jpeg`.
    * encoder-options (number) {optional} - The image quality, between 0 and 1. Used for image formats with lossy compression, such as `image/jpeg`.

  Returns:  this - This WebGL Renderer."
  ([webgl-renderer framebuffer buffer-width buffer-height callback]
   (phaser->clj
    (.snapshotFramebuffer webgl-renderer
                          (clj->phaser framebuffer)
                          (clj->phaser buffer-width)
                          (clj->phaser buffer-height)
                          (clj->phaser callback))))
  ([webgl-renderer framebuffer buffer-width buffer-height callback get-pixel]
   (phaser->clj
    (.snapshotFramebuffer webgl-renderer
                          (clj->phaser framebuffer)
                          (clj->phaser buffer-width)
                          (clj->phaser buffer-height)
                          (clj->phaser callback)
                          (clj->phaser get-pixel))))
  ([webgl-renderer framebuffer buffer-width buffer-height callback get-pixel x]
   (phaser->clj
    (.snapshotFramebuffer webgl-renderer
                          (clj->phaser framebuffer)
                          (clj->phaser buffer-width)
                          (clj->phaser buffer-height)
                          (clj->phaser callback)
                          (clj->phaser get-pixel)
                          (clj->phaser x))))
  ([webgl-renderer framebuffer buffer-width buffer-height callback get-pixel x y]
   (phaser->clj
    (.snapshotFramebuffer webgl-renderer
                          (clj->phaser framebuffer)
                          (clj->phaser buffer-width)
                          (clj->phaser buffer-height)
                          (clj->phaser callback)
                          (clj->phaser get-pixel)
                          (clj->phaser x)
                          (clj->phaser y))))
  ([webgl-renderer framebuffer buffer-width buffer-height callback get-pixel x y width]
   (phaser->clj
    (.snapshotFramebuffer webgl-renderer
                          (clj->phaser framebuffer)
                          (clj->phaser buffer-width)
                          (clj->phaser buffer-height)
                          (clj->phaser callback)
                          (clj->phaser get-pixel)
                          (clj->phaser x)
                          (clj->phaser y)
                          (clj->phaser width))))
  ([webgl-renderer framebuffer buffer-width buffer-height callback get-pixel x y width height]
   (phaser->clj
    (.snapshotFramebuffer webgl-renderer
                          (clj->phaser framebuffer)
                          (clj->phaser buffer-width)
                          (clj->phaser buffer-height)
                          (clj->phaser callback)
                          (clj->phaser get-pixel)
                          (clj->phaser x)
                          (clj->phaser y)
                          (clj->phaser width)
                          (clj->phaser height))))
  ([webgl-renderer framebuffer buffer-width buffer-height callback get-pixel x y width height type]
   (phaser->clj
    (.snapshotFramebuffer webgl-renderer
                          (clj->phaser framebuffer)
                          (clj->phaser buffer-width)
                          (clj->phaser buffer-height)
                          (clj->phaser callback)
                          (clj->phaser get-pixel)
                          (clj->phaser x)
                          (clj->phaser y)
                          (clj->phaser width)
                          (clj->phaser height)
                          (clj->phaser type))))
  ([webgl-renderer framebuffer buffer-width buffer-height callback get-pixel x y width height type encoder-options]
   (phaser->clj
    (.snapshotFramebuffer webgl-renderer
                          (clj->phaser framebuffer)
                          (clj->phaser buffer-width)
                          (clj->phaser buffer-height)
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
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * x (integer) - The x coordinate of the pixel to get.
    * y (integer) - The y coordinate of the pixel to get.
    * callback (Phaser.Types.Renderer.Snapshot.SnapshotCallback) - The Function to invoke after the snapshot pixel data is extracted.

  Returns:  this - This WebGL Renderer."
  ([webgl-renderer x y callback]
   (phaser->clj
    (.snapshotPixel webgl-renderer
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser callback)))))

(defn update-blend-mode
  "Updates the function bound to a given custom blend mode.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * index (integer) - The index of the custom blend mode.
    * func (function) - The function to use for the blend mode.
    * equation (function) - The equation to use for the blend mode.

  Returns:  this - This WebGLRenderer instance."
  ([webgl-renderer index func equation]
   (phaser->clj
    (.updateBlendMode webgl-renderer
                      (clj->phaser index)
                      (clj->phaser func)
                      (clj->phaser equation)))))

(defn update-canvas-texture
  "Updates a WebGL Texture based on the given Canvas Element.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * src-canvas (HTMLCanvasElement) - The Canvas to update the WebGL Texture from.
    * dst-texture (WebGLTexture) - The destination WebGL Texture to update.
    * flip-y (boolean) {optional} - Should the WebGL Texture set `UNPACK_MULTIPLY_FLIP_Y`?

  Returns:  WebGLTexture - The updated WebGL Texture."
  ([webgl-renderer src-canvas dst-texture]
   (phaser->clj
    (.updateCanvasTexture webgl-renderer
                          (clj->phaser src-canvas)
                          (clj->phaser dst-texture))))
  ([webgl-renderer src-canvas dst-texture flip-y]
   (phaser->clj
    (.updateCanvasTexture webgl-renderer
                          (clj->phaser src-canvas)
                          (clj->phaser dst-texture)
                          (clj->phaser flip-y)))))

(defn update-video-texture
  "Updates a WebGL Texture based on the given HTML Video Element.

  Parameters:
    * webgl-renderer (Phaser.Renderer.WebGL.WebGLRenderer) - Targeted instance for method
    * src-video (HTMLVideoElement) - The Video to update the WebGL Texture with.
    * dst-texture (WebGLTexture) - The destination WebGL Texture to update.
    * flip-y (boolean) {optional} - Should the WebGL Texture set `UNPACK_MULTIPLY_FLIP_Y`?

  Returns:  WebGLTexture - The updated WebGL Texture."
  ([webgl-renderer src-video dst-texture]
   (phaser->clj
    (.updateVideoTexture webgl-renderer
                         (clj->phaser src-video)
                         (clj->phaser dst-texture))))
  ([webgl-renderer src-video dst-texture flip-y]
   (phaser->clj
    (.updateVideoTexture webgl-renderer
                         (clj->phaser src-video)
                         (clj->phaser dst-texture)
                         (clj->phaser flip-y)))))