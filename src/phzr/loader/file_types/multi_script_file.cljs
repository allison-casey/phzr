(ns phzr.loader.file-types.multi-script-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->MultiScriptFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.MultiScriptFileConfig) - The key to use for this file, or a file configuration object.
    * url (Array.<string>) {optional} - An array of absolute or relative URLs to load the script files from. They are processed in the order given in the array.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the script files. Used in replacement of the Loaders default XHR Settings."
  ([loader key]
   (js/Phaser.Loader.FileTypes.MultiScriptFile. (clj->phaser loader)
                                                (clj->phaser key)))
  ([loader key url]
   (js/Phaser.Loader.FileTypes.MultiScriptFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser url)))
  ([loader key url xhr-settings]
   (js/Phaser.Loader.FileTypes.MultiScriptFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser url)
                                                (clj->phaser xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([multi-script-file]
   (phaser->clj
    (.addToCache multi-script-file))))

(defn add-to-multi-file
  "Adds another child to this MultiFile, increases the pending count and resets the completion status.

  Parameters:
    * multi-script-file (Phaser.Loader.FileTypes.MultiScriptFile) - Targeted instance for method
    * files (Phaser.Loader.File) - The File to add to this MultiFile.

  Returns:  Phaser.Loader.MultiFile - This MultiFile instance."
  ([multi-script-file files]
   (phaser->clj
    (.addToMultiFile multi-script-file
                     (clj->phaser files)))))

(defn is-ready-to-process
  "Checks if this MultiFile is ready to process its children or not.

  Returns:  boolean - `true` if all children of this MultiFile have loaded, otherwise `false`."
  ([multi-script-file]
   (phaser->clj
    (.isReadyToProcess multi-script-file))))

(defn on-file-complete
  "Called by each File when it finishes loading.

  Parameters:
    * multi-script-file (Phaser.Loader.FileTypes.MultiScriptFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has completed processing."
  ([multi-script-file file]
   (phaser->clj
    (.onFileComplete multi-script-file
                     (clj->phaser file)))))

(defn on-file-failed
  "Called by each File that fails to load.

  Parameters:
    * multi-script-file (Phaser.Loader.FileTypes.MultiScriptFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has failed to load."
  ([multi-script-file file]
   (phaser->clj
    (.onFileFailed multi-script-file
                   (clj->phaser file)))))