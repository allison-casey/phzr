(ns phzr.loader.file-types.html-5-audio-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->HTML5AudioFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.AudioFileConfig) - The key to use for this file, or a file configuration object.
    * url-config (string) {optional} - The absolute or relative URL to load this file from.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file."
  ([loader key]
   (js/Phaser.Loader.FileTypes.HTML5AudioFile. (clj->phaser loader)
                                               (clj->phaser key)))
  ([loader key url-config]
   (js/Phaser.Loader.FileTypes.HTML5AudioFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser url-config)))
  ([loader key url-config xhr-settings]
   (js/Phaser.Loader.FileTypes.HTML5AudioFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser url-config)
                                               (clj->phaser xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([html-5-audio-file]
   (phaser->clj
    (.addToCache html-5-audio-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([html-5-audio-file]
   (phaser->clj
    (.destroy html-5-audio-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([html-5-audio-file]
   (phaser->clj
    (.hasCacheConflict html-5-audio-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([html-5-audio-file]
   (phaser->clj
    (.load html-5-audio-file))))

(defn on-error
  "Called if the file errors while loading."
  ([html-5-audio-file]
   (phaser->clj
    (.onError html-5-audio-file))))

(defn on-load
  "Called when the file finishes loading."
  ([html-5-audio-file]
   (phaser->clj
    (.onLoad html-5-audio-file))))

(defn on-process
  "Usually overridden by the FileTypes and is called by Loader.nextFile.
  This method controls what extra work this File does with its loaded data, for example a JSON file will parse itself during this stage."
  ([html-5-audio-file]
   (phaser->clj
    (.onProcess html-5-audio-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([html-5-audio-file]
   (phaser->clj
    (.onProcessComplete html-5-audio-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([html-5-audio-file]
   (phaser->clj
    (.onProcessError html-5-audio-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent."
  ([html-5-audio-file]
   (phaser->clj
    (.onProgress html-5-audio-file))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([html-5-audio-file]
   (phaser->clj
    (.pendingDestroy html-5-audio-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([html-5-audio-file]
   (phaser->clj
    (.resetXHR html-5-audio-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * html-5-audio-file (Phaser.Loader.FileTypes.HTML5AudioFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([html-5-audio-file file-b]
   (phaser->clj
    (.setLink html-5-audio-file
              (clj->phaser file-b)))))