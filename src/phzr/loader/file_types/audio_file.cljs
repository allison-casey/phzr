(ns phzr.loader.file-types.audio-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->AudioFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.AudioFileConfig) - The key to use for this file, or a file configuration object.
    * url-config (any) {optional} - The absolute or relative URL to load this file from in a config object.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file.
    * audio-context (AudioContext) {optional} - The AudioContext this file will use to process itself."
  ([loader key]
   (js/Phaser.Loader.FileTypes.AudioFile. (clj->phaser loader)
                                          (clj->phaser key)))
  ([loader key url-config]
   (js/Phaser.Loader.FileTypes.AudioFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url-config)))
  ([loader key url-config xhr-settings]
   (js/Phaser.Loader.FileTypes.AudioFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url-config)
                                          (clj->phaser xhr-settings)))
  ([loader key url-config xhr-settings audio-context]
   (js/Phaser.Loader.FileTypes.AudioFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url-config)
                                          (clj->phaser xhr-settings)
                                          (clj->phaser audio-context))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([audio-file]
   (phaser->clj
    (.addToCache audio-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([audio-file]
   (phaser->clj
    (.destroy audio-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([audio-file]
   (phaser->clj
    (.hasCacheConflict audio-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([audio-file]
   (phaser->clj
    (.load audio-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * audio-file (Phaser.Loader.FileTypes.AudioFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([audio-file xhr event]
   (phaser->clj
    (.onError audio-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * audio-file (Phaser.Loader.FileTypes.AudioFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([audio-file xhr event]
   (phaser->clj
    (.onLoad audio-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([audio-file]
   (phaser->clj
    (.onProcess audio-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([audio-file]
   (phaser->clj
    (.onProcessComplete audio-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([audio-file]
   (phaser->clj
    (.onProcessError audio-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * audio-file (Phaser.Loader.FileTypes.AudioFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([audio-file event]
   (phaser->clj
    (.onProgress audio-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([audio-file]
   (phaser->clj
    (.pendingDestroy audio-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([audio-file]
   (phaser->clj
    (.resetXHR audio-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * audio-file (Phaser.Loader.FileTypes.AudioFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([audio-file file-b]
   (phaser->clj
    (.setLink audio-file
              (clj->phaser file-b)))))