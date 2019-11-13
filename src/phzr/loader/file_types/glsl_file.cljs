(ns phzr.loader.file-types.glsl-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->GLSLFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.GLSLFileConfig) - The key to use for this file, or a file configuration object.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.txt`, i.e. if `key` was 'alien' then the URL will be 'alien.txt'.
    * shader-type (string) {optional} - The type of shader. Either `fragment` for a fragment shader, or `vertex` for a vertex shader. This is ignored if you load a shader bundle.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file."
  ([loader key]
   (js/Phaser.Loader.FileTypes.GLSLFile. (clj->phaser loader)
                                         (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.GLSLFile. (clj->phaser loader)
                                         (clj->phaser key)
                                         (clj->phaser url)))
  ([loader key url shader-type]
   (js/Phaser.Loader.FileTypes.GLSLFile. (clj->phaser loader)
                                         (clj->phaser key)
                                         (clj->phaser url)
                                         (clj->phaser shader-type)))
  ([loader key url shader-type xhr-settings]
   (js/Phaser.Loader.FileTypes.GLSLFile. (clj->phaser loader)
                                         (clj->phaser key)
                                         (clj->phaser url)
                                         (clj->phaser shader-type)
                                         (clj->phaser xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([glsl-file]
   (phaser->clj
    (.addToCache glsl-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([glsl-file]
   (phaser->clj
    (.destroy glsl-file))))

(defn get-shader-name
  "Returns the name of the shader from the header block.

  Parameters:
    * glsl-file (Phaser.Loader.FileTypes.GLSLFile) - Targeted instance for method
    * header-source (Array.<string>) - The header data.

  Returns:  string - The shader name."
  ([glsl-file header-source]
   (phaser->clj
    (.getShaderName glsl-file
                    (clj->phaser header-source)))))

(defn get-shader-type
  "Returns the type of the shader from the header block.

  Parameters:
    * glsl-file (Phaser.Loader.FileTypes.GLSLFile) - Targeted instance for method
    * header-source (Array.<string>) - The header data.

  Returns:  string - The shader type. Either 'fragment' or 'vertex'."
  ([glsl-file header-source]
   (phaser->clj
    (.getShaderType glsl-file
                    (clj->phaser header-source)))))

(defn get-shader-uniforms
  "Returns the shader uniforms from the header block.

  Parameters:
    * glsl-file (Phaser.Loader.FileTypes.GLSLFile) - Targeted instance for method
    * header-source (Array.<string>) - The header data.

  Returns:  any - The shader uniforms object."
  ([glsl-file header-source]
   (phaser->clj
    (.getShaderUniforms glsl-file
                        (clj->phaser header-source)))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([glsl-file]
   (phaser->clj
    (.hasCacheConflict glsl-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([glsl-file]
   (phaser->clj
    (.load glsl-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * glsl-file (Phaser.Loader.FileTypes.GLSLFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([glsl-file xhr event]
   (phaser->clj
    (.onError glsl-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * glsl-file (Phaser.Loader.FileTypes.GLSLFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([glsl-file xhr event]
   (phaser->clj
    (.onLoad glsl-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([glsl-file]
   (phaser->clj
    (.onProcess glsl-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([glsl-file]
   (phaser->clj
    (.onProcessComplete glsl-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([glsl-file]
   (phaser->clj
    (.onProcessError glsl-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * glsl-file (Phaser.Loader.FileTypes.GLSLFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([glsl-file event]
   (phaser->clj
    (.onProgress glsl-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([glsl-file]
   (phaser->clj
    (.pendingDestroy glsl-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([glsl-file]
   (phaser->clj
    (.resetXHR glsl-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * glsl-file (Phaser.Loader.FileTypes.GLSLFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([glsl-file file-b]
   (phaser->clj
    (.setLink glsl-file
              (clj->phaser file-b)))))