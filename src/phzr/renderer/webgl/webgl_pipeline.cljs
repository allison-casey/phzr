(ns phzr.renderer.webgl.webgl-pipeline
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [flush]))

(defn ->WebGLPipeline
  "  Parameters:
    * config (object) - The configuration object for this WebGL Pipeline, as described above."
  ([config]
   (js/Phaser.Renderer.WebGL.WebGLPipeline. (clj->phaser config))))

(defn add-attribute
  "Adds a description of vertex attribute to the pipeline

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - Name of the vertex attribute
    * size (integer) - Vertex component size
    * type (integer) - Type of the attribute
    * normalized (boolean) - Is the value normalized to a range
    * offset (integer) - Byte offset to the beginning of the first element in the vertex

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name size type normalized offset]
   (phaser->clj
    (.addAttribute webgl-pipeline
                   (clj->phaser name)
                   (clj->phaser size)
                   (clj->phaser type)
                   (clj->phaser normalized)
                   (clj->phaser offset)))))

(defn bind
  "Binds the pipeline resources, including programs, vertex buffers and binds attributes

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline]
   (phaser->clj
    (.bind webgl-pipeline))))

(defn boot
  "Called when the Game has fully booted and the Renderer has finished setting up.

  By this stage all Game level systems are now in place and you can perform any final
  tasks that the pipeline may need that relied on game systems such as the Texture Manager."
  ([webgl-pipeline]
   (phaser->clj
    (.boot webgl-pipeline))))

(defn destroy
  "Removes all object references in this WebGL Pipeline and removes its program from the WebGL context.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline]
   (phaser->clj
    (.destroy webgl-pipeline))))

(defn flush
  "Uploads the vertex data and emits a draw call
  for the current batch of vertices.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline]
   (phaser->clj
    (.flush webgl-pipeline))))

(defn on-bind
  "Set whenever this WebGL Pipeline is bound to a WebGL Renderer.

  This method is called every time the WebGL Pipeline is attempted to be bound, even if it already is the current pipeline.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline]
   (phaser->clj
    (.onBind webgl-pipeline))))

(defn on-post-render
  "Called after each frame has been completely rendered and snapshots have been taken.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline]
   (phaser->clj
    (.onPostRender webgl-pipeline))))

(defn on-pre-render
  "Called before each frame is rendered, but after the canvas has been cleared.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline]
   (phaser->clj
    (.onPreRender webgl-pipeline))))

(defn on-render
  "Called before a Scene's Camera is rendered.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene being rendered.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Scene Camera being rendered with.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline scene camera]
   (phaser->clj
    (.onRender webgl-pipeline
               (clj->phaser scene)
               (clj->phaser camera)))))

(defn resize
  "Resizes the properties used to describe the viewport

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * width (number) - The new width of this WebGL Pipeline.
    * height (number) - The new height of this WebGL Pipeline.
    * resolution (number) - The resolution this WebGL Pipeline should be resized to.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline width height resolution]
   (phaser->clj
    (.resize webgl-pipeline
             (clj->phaser width)
             (clj->phaser height)
             (clj->phaser resolution)))))

(defn set-float-1
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new value of the `float` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name x]
   (phaser->clj
    (.setFloat1 webgl-pipeline
                (clj->phaser name)
                (clj->phaser x)))))

(defn set-float-1v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name arr]
   (phaser->clj
    (.setFloat1v webgl-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new X component of the `vec2` uniform.
    * y (number) - The new Y component of the `vec2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name x y]
   (phaser->clj
    (.setFloat2 webgl-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-float-2v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name arr]
   (phaser->clj
    (.setFloat2v webgl-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - The new X component of the `vec3` uniform.
    * y (number) - The new Y component of the `vec3` uniform.
    * z (number) - The new Z component of the `vec3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name x y z]
   (phaser->clj
    (.setFloat3 webgl-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser z)))))

(defn set-float-3v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name arr]
   (phaser->clj
    (.setFloat3v webgl-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-float-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (number) - X component of the uniform
    * y (number) - Y component of the uniform
    * z (number) - Z component of the uniform
    * w (number) - W component of the uniform

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name x y z w]
   (phaser->clj
    (.setFloat4 webgl-pipeline
                (clj->phaser name)
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser z)
                (clj->phaser w)))))

(defn set-float-4v
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * arr (Float32Array) - The new value to be used for the uniform variable.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name arr]
   (phaser->clj
    (.setFloat4v webgl-pipeline
                 (clj->phaser name)
                 (clj->phaser arr)))))

(defn set-int-1
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new value of the `int` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name x]
   (phaser->clj
    (.setInt1 webgl-pipeline
              (clj->phaser name)
              (clj->phaser x)))))

(defn set-int-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new X component of the `ivec2` uniform.
    * y (integer) - The new Y component of the `ivec2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name x y]
   (phaser->clj
    (.setInt2 webgl-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-int-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - The new X component of the `ivec3` uniform.
    * y (integer) - The new Y component of the `ivec3` uniform.
    * z (integer) - The new Z component of the `ivec3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name x y z]
   (phaser->clj
    (.setInt3 webgl-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)))))

(defn set-int-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * x (integer) - X component of the uniform
    * y (integer) - Y component of the uniform
    * z (integer) - Z component of the uniform
    * w (integer) - W component of the uniform

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name x y z w]
   (phaser->clj
    (.setInt4 webgl-pipeline
              (clj->phaser name)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)
              (clj->phaser w)))))

(defn set-matrix-2
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Whether to transpose the matrix. Should be `false`.
    * matrix (Float32Array) - The new values for the `mat2` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix2 webgl-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-matrix-3
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Whether to transpose the matrix. Should be `false`.
    * matrix (Float32Array) - The new values for the `mat3` uniform.

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix3 webgl-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn set-matrix-4
  "Set a uniform value of the current pipeline program.

  Parameters:
    * webgl-pipeline (Phaser.Renderer.WebGL.WebGLPipeline) - Targeted instance for method
    * name (string) - The name of the uniform to look-up and modify.
    * transpose (boolean) - Should the matrix be transpose
    * matrix (Float32Array) - Matrix data

  Returns:  this - This WebGLPipeline instance."
  ([webgl-pipeline name transpose matrix]
   (phaser->clj
    (.setMatrix4 webgl-pipeline
                 (clj->phaser name)
                 (clj->phaser transpose)
                 (clj->phaser matrix)))))

(defn should-flush
  "Check if the current batch of vertices is full.

  Returns:  boolean - `true` if the current batch should be flushed, otherwise `false`."
  ([webgl-pipeline]
   (phaser->clj
    (.shouldFlush webgl-pipeline))))