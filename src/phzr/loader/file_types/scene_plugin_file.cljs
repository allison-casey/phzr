(ns phzr.loader.file-types.scene-plugin-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->ScenePluginFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.ScenePluginFileConfig) - The key to use for this file, or a file configuration object.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.js`, i.e. if `key` was 'alien' then the URL will be 'alien.js'.
    * system-key (string) {optional} - If this plugin is to be added to Scene.Systems, this is the property key for it.
    * scene-key (string) {optional} - If this plugin is to be added to the Scene, this is the property key for it.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file."
  ([loader key]
   (js/Phaser.Loader.FileTypes.ScenePluginFile. (clj->phaser loader)
                                                (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.ScenePluginFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser url)))
  ([loader key url system-key]
   (js/Phaser.Loader.FileTypes.ScenePluginFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser url)
                                                (clj->phaser system-key)))
  ([loader key url system-key scene-key]
   (js/Phaser.Loader.FileTypes.ScenePluginFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser url)
                                                (clj->phaser system-key)
                                                (clj->phaser scene-key)))
  ([loader key url system-key scene-key xhr-settings]
   (js/Phaser.Loader.FileTypes.ScenePluginFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser url)
                                                (clj->phaser system-key)
                                                (clj->phaser scene-key)
                                                (clj->phaser xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([scene-plugin-file]
   (phaser->clj
    (.addToCache scene-plugin-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([scene-plugin-file]
   (phaser->clj
    (.destroy scene-plugin-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([scene-plugin-file]
   (phaser->clj
    (.hasCacheConflict scene-plugin-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([scene-plugin-file]
   (phaser->clj
    (.load scene-plugin-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * scene-plugin-file (Phaser.Loader.FileTypes.ScenePluginFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([scene-plugin-file xhr event]
   (phaser->clj
    (.onError scene-plugin-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * scene-plugin-file (Phaser.Loader.FileTypes.ScenePluginFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([scene-plugin-file xhr event]
   (phaser->clj
    (.onLoad scene-plugin-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([scene-plugin-file]
   (phaser->clj
    (.onProcess scene-plugin-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([scene-plugin-file]
   (phaser->clj
    (.onProcessComplete scene-plugin-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([scene-plugin-file]
   (phaser->clj
    (.onProcessError scene-plugin-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * scene-plugin-file (Phaser.Loader.FileTypes.ScenePluginFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([scene-plugin-file event]
   (phaser->clj
    (.onProgress scene-plugin-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([scene-plugin-file]
   (phaser->clj
    (.pendingDestroy scene-plugin-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([scene-plugin-file]
   (phaser->clj
    (.resetXHR scene-plugin-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * scene-plugin-file (Phaser.Loader.FileTypes.ScenePluginFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([scene-plugin-file file-b]
   (phaser->clj
    (.setLink scene-plugin-file
              (clj->phaser file-b)))))