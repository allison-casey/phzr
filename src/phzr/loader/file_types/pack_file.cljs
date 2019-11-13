(ns phzr.loader.file-types.pack-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->PackFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.PackFileConfig) - The key to use for this file, or a file configuration object.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file.
    * data-key (string) {optional} - When the JSON file loads only this property will be stored in the Cache."
  ([loader key]
   (js/Phaser.Loader.FileTypes.PackFile. (clj->phaser loader)
                                         (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.PackFile. (clj->phaser loader)
                                         (clj->phaser key)
                                         (clj->phaser url)))
  ([loader key url xhr-settings]
   (js/Phaser.Loader.FileTypes.PackFile. (clj->phaser loader)
                                         (clj->phaser key)
                                         (clj->phaser url)
                                         (clj->phaser xhr-settings)))
  ([loader key url xhr-settings data-key]
   (js/Phaser.Loader.FileTypes.PackFile. (clj->phaser loader)
                                         (clj->phaser key)
                                         (clj->phaser url)
                                         (clj->phaser xhr-settings)
                                         (clj->phaser data-key))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([pack-file]
   (phaser->clj
    (.addToCache pack-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([pack-file]
   (phaser->clj
    (.destroy pack-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([pack-file]
   (phaser->clj
    (.hasCacheConflict pack-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([pack-file]
   (phaser->clj
    (.load pack-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * pack-file (Phaser.Loader.FileTypes.PackFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([pack-file xhr event]
   (phaser->clj
    (.onError pack-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * pack-file (Phaser.Loader.FileTypes.PackFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([pack-file xhr event]
   (phaser->clj
    (.onLoad pack-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([pack-file]
   (phaser->clj
    (.onProcess pack-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([pack-file]
   (phaser->clj
    (.onProcessComplete pack-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([pack-file]
   (phaser->clj
    (.onProcessError pack-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * pack-file (Phaser.Loader.FileTypes.PackFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([pack-file event]
   (phaser->clj
    (.onProgress pack-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([pack-file]
   (phaser->clj
    (.pendingDestroy pack-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([pack-file]
   (phaser->clj
    (.resetXHR pack-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * pack-file (Phaser.Loader.FileTypes.PackFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([pack-file file-b]
   (phaser->clj
    (.setLink pack-file
              (clj->phaser file-b)))))