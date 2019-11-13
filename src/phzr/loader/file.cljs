(ns phzr.loader.file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->File
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - The Loader that is going to load this File.
    * file-config (Phaser.Types.Loader.FileConfig) - The file configuration object, as created by the file type."
  ([loader file-config]
   (js/Phaser.Loader.File. (clj->phaser loader)
                           (clj->phaser file-config))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([file]
   (phaser->clj
    (.addToCache file))))

(defn create-object-url
  "Static method for creating object URL using URL API and setting it as image 'src' attribute.
  If URL API is not supported (usually on old browsers) it falls back to creating Base64 encoded url using FileReader.

  Parameters:
    * file (Phaser.Loader.File) - Targeted instance for method
    * image (HTMLImageElement) - Image object which 'src' attribute should be set to object URL.
    * blob (Blob) - A Blob object to create an object URL for.
    * default-type (string) - Default mime type used if blob type is not available."
  ([file image blob default-type]
   (phaser->clj
    (.createObjectURL file
                      (clj->phaser image)
                      (clj->phaser blob)
                      (clj->phaser default-type)))))

(defn destroy
  "Destroy this File and any references it holds."
  ([file]
   (phaser->clj
    (.destroy file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([file]
   (phaser->clj
    (.hasCacheConflict file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([file]
   (phaser->clj
    (.load file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * file (Phaser.Loader.File) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([file xhr event]
   (phaser->clj
    (.onError file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * file (Phaser.Loader.File) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([file xhr event]
   (phaser->clj
    (.onLoad file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Usually overridden by the FileTypes and is called by Loader.nextFile.
  This method controls what extra work this File does with its loaded data, for example a JSON file will parse itself during this stage."
  ([file]
   (phaser->clj
    (.onProcess file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([file]
   (phaser->clj
    (.onProcessComplete file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([file]
   (phaser->clj
    (.onProcessError file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * file (Phaser.Loader.File) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([file event]
   (phaser->clj
    (.onProgress file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([file]
   (phaser->clj
    (.pendingDestroy file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([file]
   (phaser->clj
    (.resetXHR file))))

(defn revoke-object-url
  "Static method for releasing an existing object URL which was previously created
  by calling {@link File#createObjectURL} method.

  Parameters:
    * file (Phaser.Loader.File) - Targeted instance for method
    * image (HTMLImageElement) - Image object which 'src' attribute should be revoked."
  ([file image]
   (phaser->clj
    (.revokeObjectURL file
                      (clj->phaser image)))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * file (Phaser.Loader.File) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([file file-b]
   (phaser->clj
    (.setLink file
              (clj->phaser file-b)))))