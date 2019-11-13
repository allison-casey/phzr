(ns phzr.loader.file-types.video-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->VideoFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.VideoFileConfig) - The key to use for this file, or a file configuration object.
    * url-config (any) {optional} - The absolute or relative URL to load this file from in a config object.
    * load-event (string) {optional} - The load event to listen for when _not_ loading as a blob. Either 'loadeddata', 'canplay' or 'canplaythrough'.
    * as-blob (boolean) {optional} - Load the video as a data blob, or via the Video element?
    * no-audio (boolean) {optional} - Does the video have an audio track? If not you can enable auto-playing on it.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file."
  ([loader key]
   (js/Phaser.Loader.FileTypes.VideoFile. (clj->phaser loader)
                                          (clj->phaser key)))
  ([loader key url-config]
   (js/Phaser.Loader.FileTypes.VideoFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url-config)))
  ([loader key url-config load-event]
   (js/Phaser.Loader.FileTypes.VideoFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url-config)
                                          (clj->phaser load-event)))
  ([loader key url-config load-event as-blob]
   (js/Phaser.Loader.FileTypes.VideoFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url-config)
                                          (clj->phaser load-event)
                                          (clj->phaser as-blob)))
  ([loader key url-config load-event as-blob no-audio]
   (js/Phaser.Loader.FileTypes.VideoFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url-config)
                                          (clj->phaser load-event)
                                          (clj->phaser as-blob)
                                          (clj->phaser no-audio)))
  ([loader key url-config load-event as-blob no-audio xhr-settings]
   (js/Phaser.Loader.FileTypes.VideoFile. (clj->phaser loader)
                                          (clj->phaser key)
                                          (clj->phaser url-config)
                                          (clj->phaser load-event)
                                          (clj->phaser as-blob)
                                          (clj->phaser no-audio)
                                          (clj->phaser xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([video-file]
   (phaser->clj
    (.addToCache video-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([video-file]
   (phaser->clj
    (.destroy video-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([video-file]
   (phaser->clj
    (.hasCacheConflict video-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([video-file]
   (phaser->clj
    (.load video-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * video-file (Phaser.Loader.FileTypes.VideoFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([video-file xhr event]
   (phaser->clj
    (.onError video-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * video-file (Phaser.Loader.FileTypes.VideoFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([video-file xhr event]
   (phaser->clj
    (.onLoad video-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([video-file]
   (phaser->clj
    (.onProcess video-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([video-file]
   (phaser->clj
    (.onProcessComplete video-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([video-file]
   (phaser->clj
    (.onProcessError video-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * video-file (Phaser.Loader.FileTypes.VideoFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([video-file event]
   (phaser->clj
    (.onProgress video-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([video-file]
   (phaser->clj
    (.pendingDestroy video-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([video-file]
   (phaser->clj
    (.resetXHR video-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * video-file (Phaser.Loader.FileTypes.VideoFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([video-file file-b]
   (phaser->clj
    (.setLink video-file
              (clj->phaser file-b)))))