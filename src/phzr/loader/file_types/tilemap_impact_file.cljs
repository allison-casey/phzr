(ns phzr.loader.file-types.tilemap-impact-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->TilemapImpactFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.TilemapImpactFileConfig) - The key to use for this file, or a file configuration object.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file."
  ([loader key]
   (js/Phaser.Loader.FileTypes.TilemapImpactFile. (clj->phaser loader)
                                                  (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.TilemapImpactFile. (clj->phaser loader)
                                                  (clj->phaser key)
                                                  (clj->phaser url)))
  ([loader key url xhr-settings]
   (js/Phaser.Loader.FileTypes.TilemapImpactFile. (clj->phaser loader)
                                                  (clj->phaser key)
                                                  (clj->phaser url)
                                                  (clj->phaser xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([tilemap-impact-file]
   (phaser->clj
    (.addToCache tilemap-impact-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([tilemap-impact-file]
   (phaser->clj
    (.destroy tilemap-impact-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([tilemap-impact-file]
   (phaser->clj
    (.hasCacheConflict tilemap-impact-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([tilemap-impact-file]
   (phaser->clj
    (.load tilemap-impact-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * tilemap-impact-file (Phaser.Loader.FileTypes.TilemapImpactFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([tilemap-impact-file xhr event]
   (phaser->clj
    (.onError tilemap-impact-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * tilemap-impact-file (Phaser.Loader.FileTypes.TilemapImpactFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([tilemap-impact-file xhr event]
   (phaser->clj
    (.onLoad tilemap-impact-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Usually overridden by the FileTypes and is called by Loader.nextFile.
  This method controls what extra work this File does with its loaded data, for example a JSON file will parse itself during this stage."
  ([tilemap-impact-file]
   (phaser->clj
    (.onProcess tilemap-impact-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([tilemap-impact-file]
   (phaser->clj
    (.onProcessComplete tilemap-impact-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([tilemap-impact-file]
   (phaser->clj
    (.onProcessError tilemap-impact-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * tilemap-impact-file (Phaser.Loader.FileTypes.TilemapImpactFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([tilemap-impact-file event]
   (phaser->clj
    (.onProgress tilemap-impact-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([tilemap-impact-file]
   (phaser->clj
    (.pendingDestroy tilemap-impact-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([tilemap-impact-file]
   (phaser->clj
    (.resetXHR tilemap-impact-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * tilemap-impact-file (Phaser.Loader.FileTypes.TilemapImpactFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([tilemap-impact-file file-b]
   (phaser->clj
    (.setLink tilemap-impact-file
              (clj->phaser file-b)))))