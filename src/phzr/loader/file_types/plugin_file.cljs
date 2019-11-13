(ns phzr.loader.file-types.plugin-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->PluginFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.PluginFileConfig) - The key to use for this file, or a file configuration object.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.js`, i.e. if `key` was 'alien' then the URL will be 'alien.js'.
    * start (boolean) {optional} - Automatically start the plugin after loading?
    * mapping (string) {optional} - If this plugin is to be injected into the Scene, this is the property key used.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file."
  ([loader key]
   (js/Phaser.Loader.FileTypes.PluginFile. (clj->phaser loader)
                                           (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.PluginFile. (clj->phaser loader)
                                           (clj->phaser key)
                                           (clj->phaser url)))
  ([loader key url start]
   (js/Phaser.Loader.FileTypes.PluginFile. (clj->phaser loader)
                                           (clj->phaser key)
                                           (clj->phaser url)
                                           (clj->phaser start)))
  ([loader key url start mapping]
   (js/Phaser.Loader.FileTypes.PluginFile. (clj->phaser loader)
                                           (clj->phaser key)
                                           (clj->phaser url)
                                           (clj->phaser start)
                                           (clj->phaser mapping)))
  ([loader key url start mapping xhr-settings]
   (js/Phaser.Loader.FileTypes.PluginFile. (clj->phaser loader)
                                           (clj->phaser key)
                                           (clj->phaser url)
                                           (clj->phaser start)
                                           (clj->phaser mapping)
                                           (clj->phaser xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([plugin-file]
   (phaser->clj
    (.addToCache plugin-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([plugin-file]
   (phaser->clj
    (.destroy plugin-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([plugin-file]
   (phaser->clj
    (.hasCacheConflict plugin-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([plugin-file]
   (phaser->clj
    (.load plugin-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * plugin-file (Phaser.Loader.FileTypes.PluginFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([plugin-file xhr event]
   (phaser->clj
    (.onError plugin-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * plugin-file (Phaser.Loader.FileTypes.PluginFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([plugin-file xhr event]
   (phaser->clj
    (.onLoad plugin-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([plugin-file]
   (phaser->clj
    (.onProcess plugin-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([plugin-file]
   (phaser->clj
    (.onProcessComplete plugin-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([plugin-file]
   (phaser->clj
    (.onProcessError plugin-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * plugin-file (Phaser.Loader.FileTypes.PluginFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([plugin-file event]
   (phaser->clj
    (.onProgress plugin-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([plugin-file]
   (phaser->clj
    (.pendingDestroy plugin-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([plugin-file]
   (phaser->clj
    (.resetXHR plugin-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * plugin-file (Phaser.Loader.FileTypes.PluginFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([plugin-file file-b]
   (phaser->clj
    (.setLink plugin-file
              (clj->phaser file-b)))))