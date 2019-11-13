(ns phzr.loader.file-types.binary-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->BinaryFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.BinaryFileConfig) - The key to use for this file, or a file configuration object.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.bin`, i.e. if `key` was 'alien' then the URL will be 'alien.bin'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file.
    * data-type (any) {optional} - Optional type to cast the binary file to once loaded. For example, `Uint8Array`."
  ([loader key]
   (js/Phaser.Loader.FileTypes.BinaryFile. (clj->phaser loader)
                                           (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.BinaryFile. (clj->phaser loader)
                                           (clj->phaser key)
                                           (clj->phaser url)))
  ([loader key url xhr-settings]
   (js/Phaser.Loader.FileTypes.BinaryFile. (clj->phaser loader)
                                           (clj->phaser key)
                                           (clj->phaser url)
                                           (clj->phaser xhr-settings)))
  ([loader key url xhr-settings data-type]
   (js/Phaser.Loader.FileTypes.BinaryFile. (clj->phaser loader)
                                           (clj->phaser key)
                                           (clj->phaser url)
                                           (clj->phaser xhr-settings)
                                           (clj->phaser data-type))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([binary-file]
   (phaser->clj
    (.addToCache binary-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([binary-file]
   (phaser->clj
    (.destroy binary-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([binary-file]
   (phaser->clj
    (.hasCacheConflict binary-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([binary-file]
   (phaser->clj
    (.load binary-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * binary-file (Phaser.Loader.FileTypes.BinaryFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([binary-file xhr event]
   (phaser->clj
    (.onError binary-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * binary-file (Phaser.Loader.FileTypes.BinaryFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([binary-file xhr event]
   (phaser->clj
    (.onLoad binary-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([binary-file]
   (phaser->clj
    (.onProcess binary-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([binary-file]
   (phaser->clj
    (.onProcessComplete binary-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([binary-file]
   (phaser->clj
    (.onProcessError binary-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * binary-file (Phaser.Loader.FileTypes.BinaryFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([binary-file event]
   (phaser->clj
    (.onProgress binary-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([binary-file]
   (phaser->clj
    (.pendingDestroy binary-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([binary-file]
   (phaser->clj
    (.resetXHR binary-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * binary-file (Phaser.Loader.FileTypes.BinaryFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([binary-file file-b]
   (phaser->clj
    (.setLink binary-file
              (clj->phaser file-b)))))