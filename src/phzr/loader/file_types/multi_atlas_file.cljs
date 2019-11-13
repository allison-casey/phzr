(ns phzr.loader.file-types.multi-atlas-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->MultiAtlasFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string) - The key of the file. Must be unique within both the Loader and the Texture Manager.
    * atlas-url (string) {optional} - The absolute or relative URL to load the multi atlas json file from.
    * path (string) {optional} - Optional path to use when loading the textures defined in the atlas data.
    * base-url (string) {optional} - Optional Base URL to use when loading the textures defined in the atlas data.
    * atlas-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for the atlas json file.
    * texture-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for the texture files."
  ([loader key]
   (js/Phaser.Loader.FileTypes.MultiAtlasFile. (clj->phaser loader)
                                               (clj->phaser key)))
  ([loader key atlas-url]
   (js/Phaser.Loader.FileTypes.MultiAtlasFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser atlas-url)))
  ([loader key atlas-url path]
   (js/Phaser.Loader.FileTypes.MultiAtlasFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser atlas-url)
                                               (clj->phaser path)))
  ([loader key atlas-url path base-url]
   (js/Phaser.Loader.FileTypes.MultiAtlasFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser atlas-url)
                                               (clj->phaser path)
                                               (clj->phaser base-url)))
  ([loader key atlas-url path base-url atlas-xhr-settings]
   (js/Phaser.Loader.FileTypes.MultiAtlasFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser atlas-url)
                                               (clj->phaser path)
                                               (clj->phaser base-url)
                                               (clj->phaser atlas-xhr-settings)))
  ([loader key atlas-url path base-url atlas-xhr-settings texture-xhr-settings]
   (js/Phaser.Loader.FileTypes.MultiAtlasFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser atlas-url)
                                               (clj->phaser path)
                                               (clj->phaser base-url)
                                               (clj->phaser atlas-xhr-settings)
                                               (clj->phaser texture-xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([multi-atlas-file]
   (phaser->clj
    (.addToCache multi-atlas-file))))

(defn add-to-multi-file
  "Adds another child to this MultiFile, increases the pending count and resets the completion status.

  Parameters:
    * multi-atlas-file (Phaser.Loader.FileTypes.MultiAtlasFile) - Targeted instance for method
    * files (Phaser.Loader.File) - The File to add to this MultiFile.

  Returns:  Phaser.Loader.MultiFile - This MultiFile instance."
  ([multi-atlas-file files]
   (phaser->clj
    (.addToMultiFile multi-atlas-file
                     (clj->phaser files)))))

(defn is-ready-to-process
  "Checks if this MultiFile is ready to process its children or not.

  Returns:  boolean - `true` if all children of this MultiFile have loaded, otherwise `false`."
  ([multi-atlas-file]
   (phaser->clj
    (.isReadyToProcess multi-atlas-file))))

(defn on-file-complete
  "Called by each File when it finishes loading.

  Parameters:
    * multi-atlas-file (Phaser.Loader.FileTypes.MultiAtlasFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has completed processing."
  ([multi-atlas-file file]
   (phaser->clj
    (.onFileComplete multi-atlas-file
                     (clj->phaser file)))))

(defn on-file-failed
  "Called by each File that fails to load.

  Parameters:
    * multi-atlas-file (Phaser.Loader.FileTypes.MultiAtlasFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has failed to load."
  ([multi-atlas-file file]
   (phaser->clj
    (.onFileFailed multi-atlas-file
                   (clj->phaser file)))))