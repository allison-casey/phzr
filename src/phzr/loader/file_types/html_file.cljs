(ns phzr.loader.file-types.html-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [load]))

(defn ->HTMLFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.HTMLFileConfig) - The key to use for this file, or a file configuration object.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.txt`, i.e. if `key` was 'alien' then the URL will be 'alien.html'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for this file."
  ([loader key]
   (js/Phaser.Loader.FileTypes.HTMLFile. (clj->phaser loader)
                                         (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.HTMLFile. (clj->phaser loader)
                                         (clj->phaser key)
                                         (clj->phaser url)))
  ([loader key url xhr-settings]
   (js/Phaser.Loader.FileTypes.HTMLFile. (clj->phaser loader)
                                         (clj->phaser key)
                                         (clj->phaser url)
                                         (clj->phaser xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing.
  This method is often overridden by specific file types."
  ([html-file]
   (phaser->clj
    (.addToCache html-file))))

(defn destroy
  "Destroy this File and any references it holds."
  ([html-file]
   (phaser->clj
    (.destroy html-file))))

(defn has-cache-conflict
  "Checks if a key matching the one used by this file exists in the target Cache or not.
  This is called automatically by the LoaderPlugin to decide if the file can be safely
  loaded or will conflict.

  Returns:  boolean - `true` if adding this file will cause a conflict, otherwise `false`."
  ([html-file]
   (phaser->clj
    (.hasCacheConflict html-file))))

(defn load
  "Called by the Loader, starts the actual file downloading.
  During the load the methods onLoad, onError and onProgress are called, based on the XHR events.
  You shouldn't normally call this method directly, it's meant to be invoked by the Loader."
  ([html-file]
   (phaser->clj
    (.load html-file))))

(defn on-error
  "Called if the file errors while loading, is sent a DOM ProgressEvent.

  Parameters:
    * html-file (Phaser.Loader.FileTypes.HTMLFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this error."
  ([html-file xhr event]
   (phaser->clj
    (.onError html-file
              (clj->phaser xhr)
              (clj->phaser event)))))

(defn on-load
  "Called when the file finishes loading, is sent a DOM ProgressEvent.

  Parameters:
    * html-file (Phaser.Loader.FileTypes.HTMLFile) - Targeted instance for method
    * xhr (XMLHttpRequest) - The XMLHttpRequest that caused this onload event.
    * event (ProgressEvent) - The DOM ProgressEvent that resulted from this load."
  ([html-file xhr event]
   (phaser->clj
    (.onLoad html-file
             (clj->phaser xhr)
             (clj->phaser event)))))

(defn on-process
  "Called automatically by Loader.nextFile.
  This method controls what extra work this File does with its loaded data."
  ([html-file]
   (phaser->clj
    (.onProcess html-file))))

(defn on-process-complete
  "Called when the File has completed processing.
  Checks on the state of its multifile, if set."
  ([html-file]
   (phaser->clj
    (.onProcessComplete html-file))))

(defn on-process-error
  "Called when the File has completed processing but it generated an error.
  Checks on the state of its multifile, if set."
  ([html-file]
   (phaser->clj
    (.onProcessError html-file))))

(defn on-progress
  "Called during the file load progress. Is sent a DOM ProgressEvent.

  Parameters:
    * html-file (Phaser.Loader.FileTypes.HTMLFile) - Targeted instance for method
    * event (ProgressEvent) - The DOM ProgressEvent."
  ([html-file event]
   (phaser->clj
    (.onProgress html-file
                 (clj->phaser event)))))

(defn pending-destroy
  "Called once the file has been added to its cache and is now ready for deletion from the Loader.
  It will emit a `filecomplete` event from the LoaderPlugin."
  ([html-file]
   (phaser->clj
    (.pendingDestroy html-file))))

(defn reset-xhr
  "Resets the XHRLoader instance this file is using."
  ([html-file]
   (phaser->clj
    (.resetXHR html-file))))

(defn set-link
  "Links this File with another, so they depend upon each other for loading and processing.

  Parameters:
    * html-file (Phaser.Loader.FileTypes.HTMLFile) - Targeted instance for method
    * file-b (Phaser.Loader.File) - The file to link to this one."
  ([html-file file-b]
   (phaser->clj
    (.setLink html-file
              (clj->phaser file-b)))))