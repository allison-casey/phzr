(ns phzr.loader.file-types.image-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->ImageFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.ImageFileConfig) - The key to use for this file, or a file configuration object.
    * url (string | Array.<string>) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file.
    * frame-config (Phaser.Types.Loader.FileTypes.ImageFrameConfig) {optional} - The frame configuration object. Only provided for, and used by, Sprite Sheets."
  ([loader key]
   (js/Phaser.Loader.FileTypes.ImageFile. (clj->phaser loader)
                                          (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.ImageFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url)))
  ([loader key url xhr-settings]
   (js/Phaser.Loader.FileTypes.ImageFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url)
                                          (clj->phaser xhr-settings)))
  ([loader key url xhr-settings frame-config]
   (js/Phaser.Loader.FileTypes.ImageFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url)
                                          (clj->phaser xhr-settings)
                                          (clj->phaser frame-config))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([image-file]
   (phaser->clj
    (.addToCache image-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([image-file]
   (phaser->clj
    (.destroy image-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([image-file]
   (phaser->clj
    (.hasCacheConflict image-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([image-file]
   (phaser->clj
    (.load image-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * image-file (Phaser.Loader.FileTypes.ImageFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([image-file xhr event]
   (phaser->clj
    (.onError image-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * image-file (Phaser.Loader.FileTypes.ImageFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([image-file xhr event]
   (phaser->clj
    (.onLoad image-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([image-file]
   (phaser->clj
    (.onProcess image-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([image-file]
   (phaser->clj
    (.onProcessComplete image-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([image-file]
   (phaser->clj
    (.onProcessError image-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * image-file (Phaser.Loader.FileTypes.ImageFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([image-file event]
   (phaser->clj
    (.onProgress image-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([image-file]
   (phaser->clj
    (.pendingDestroy image-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([image-file]
   (phaser->clj
    (.resetXHR image-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * image-file (Phaser.Loader.FileTypes.ImageFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([image-file file-b]
   (phaser->clj
    (.setLink image-file
              (clj->phaser file-b)))))