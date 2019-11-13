(ns phzr.renderer.webgl.pipelines.bitmap-mask-pipeline
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [flush]))

(defn ->BitmapMaskPipeline
  "  Parameters:
    * config (object) - Used for overriding shader an pipeline properties if extending this pipeline."
  ([config]
   (js/Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline. (clj->phaser config))))

(defn add-attribute
  "Adds a description of vertex attribute to the pipeline

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - Name of the vertex attribute
    * size (integer) - Vertex component size
    * type (integer) - Type of the attribute
    * normalized (boolean) - Is the value normalized to a range
    * offset (integer) - Byte offset to the beginning of the first element in the vertex

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name size type normalized offset]
   (phaser->clj
    (.addAttribute bitmap-mask-pipeline
                   (clj->phaser name)
                   (clj->phaser size)
                   (clj->phaser type)
                   (clj->phaser normalized)
                   (clj->phaser offset)))))

(defn begin-mask
  "Binds necessary resources and renders the mask to a separated framebuffer.
  The framebuffer for the masked object is also bound for further use.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * mask (Phaser.GameObjects.GameObject) - GameObject used as mask.
    * masked-object (Phaser.GameObjects.GameObject) - GameObject masked by the mask GameObject.
    * camera (Phaser.Cameras.Scene2D.Camera) - [description]"
  ([bitmap-mask-pipeline mask masked-object camera]
   (phaser->clj
    (.beginMask bitmap-mask-pipeline
                (clj->phaser mask)
                (clj->phaser masked-object)
                (clj->phaser camera)))))

(defn bind
  "Binds the pipeline resources, including programs, vertex buffers and binds attributes

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline]
   (phaser->clj
    (.bind bitmap-mask-pipeline))))

(defn boot
  "Called when the Game has fully booted and the Renderer has finished setting up.

  By this stage all Game level systems are now in place and you can perform any final
  tasks that the pipeline may need that relied on game systems such as the Texture Manager."
  ([bitmap-mask-pipeline]
   (phaser->clj
    (.boot bitmap-mask-pipeline))))

(defn destroy
  "Removes all object references in this WebGL Pipeline and removes its program from the WebGL context.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline]
   (phaser->clj
    (.destroy bitmap-mask-pipeline))))

(defn end-mask
  "The masked game objects framebuffer is unbound and its texture 
  is bound together with the mask texture and the mask shader and 
  a draw call with a single quad is processed. Here is where the
  masking effect is applied.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * mask (Phaser.GameObjects.GameObject) - GameObject used as a mask."
  ([bitmap-mask-pipeline mask]
   (phaser->clj
    (.endMask bitmap-mask-pipeline
              (clj->phaser mask)))))

(defn flush
  "Uploads the vertex data and emits a draw call
  for the current batch of vertices.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline]
   (phaser->clj
    (.flush bitmap-mask-pipeline))))

(defn on-bind
  "Called every time the pipeline needs to be used.
  It binds all necessary resources.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline]
   (phaser->clj
    (.onBind bitmap-mask-pipeline))))

(defn on-post-render
  "Called after each frame has been completely rendered and snapshots have been taken.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline]
   (phaser->clj
    (.onPostRender bitmap-mask-pipeline))))

(defn on-pre-render
  "Called before each frame is rendered, but after the canvas has been cleared.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline]
   (phaser->clj
    (.onPreRender bitmap-mask-pipeline))))

(defn on-render
  "Called before a Scene's Camera is rendered.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene being rendered.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Scene Camera being rendered with.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline scene camera]
   (phaser->clj
    (.onRender bitmap-mask-pipeline
               (clj->phaser scene)
               (clj->phaser camera)))))

(defn resize
  "[description]

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * width (number) - [description]
    * height (number) - [description]
    * resolution (number) - [description]

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline width height resolution]
   (phaser->clj
    (.resize bitmap-mask-pipeline
             (clj->phaser width)
             (clj->phaser height)
             (clj->phaser resolution)))))

(defn set-float-1
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new value of the `float` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name x]
   (phaser->clj
    (.setFloat1 bitmap-mask-pipeline
                (clj->phaser name)
                (clj->phaser x)))))

(defn set-float-1v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name arr]
   (phaser->clj
    (.setFloat1v bitmap-mask-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new X component of the `vec2` uniform.
    * y (number) - The new Y component of the `vec2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name x y]
   (phaser->clj
    (.setFloat2 bitmap-mask-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-float-2v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name arr]
   (phaser->clj
    (.setFloat2v bitmap-mask-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new X component of the `vec3` uniform.
    * y (number) - The new Y component of the `vec3` uniform.
    * z (number) - The new Z component of the `vec3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name x y z]
   (phaser->clj
    (.setFloat3 bitmap-mask-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser z)))))

(defn set-float-3v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name arr]
   (phaser->clj
    (.setFloat3v bitmap-mask-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - X component of the uniform
    * y (number) - Y component of the uniform
    * z (number) - Z component of the uniform
    * w (number) - W component of the uniform

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name x y z w]
   (phaser->clj
    (.setFloat4 bitmap-mask-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser z)
                (clj->phaser w)))))

(defn set-float-4v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name arr]
   (phaser->clj
    (.setFloat4v bitmap-mask-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-int-1
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new value of the `int` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name x]
   (phaser->clj
    (.setInt1 bitmap-mask-pipeline
              (clj->phaser name)
              (clj->phaser x)))))

(defn set-int-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new X component of the `ivec2` uniform.
    * y (integer) - The new Y component of the `ivec2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name x y]
   (phaser->clj
    (.setInt2 bitmap-mask-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-int-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new X component of the `ivec3` uniform.
    * y (integer) - The new Y component of the `ivec3` uniform.
    * z (integer) - The new Z component of the `ivec3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name x y z]
   (phaser->clj
    (.setInt3 bitmap-mask-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)))))

(defn set-int-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - X component of the uniform
    * y (integer) - Y component of the uniform
    * z (integer) - Z component of the uniform
    * w (integer) - W component of the uniform

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name x y z w]
   (phaser->clj
    (.setInt4 bitmap-mask-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)
              (clj->phaser w)))))

(defn set-matrix-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Whether to transpose the matrix. Should be `false`.
    * matrix (Float32Array) - The new values for the `mat2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix2 bitmap-mask-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-matrix-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Whether to transpose the matrix. Should be `false`.
    * matrix (Float32Array) - The new values for the `mat3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix3 bitmap-mask-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-matrix-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * bitmap-mask-pipeline (Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Should the matrix be transpose
    * matrix (Float32Array) - Matrix data

  Returns:  this - This WebGLPipeline instance."
  ([bitmap-mask-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix4 bitmap-mask-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn should-flush
  "Check if the current batch of vertices is full.

  Returns:  boolean - `true` if the current batch should be flushed, otherwise `false`."
  ([bitmap-mask-pipeline]
   (phaser->clj
    (.shouldFlush bitmap-mask-pipeline))))