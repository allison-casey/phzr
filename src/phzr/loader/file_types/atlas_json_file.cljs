(ns phzr.loader.file-types.atlas-json-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->AtlasJSONFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.AtlasJSONFileConfig) - The key to use for this file, or a file configuration object.
    * texture-url (string | Array.<string>) {optional} - The absolute or relative URL to load the texture image file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * atlas-url (string) {optional} - The absolute or relative URL to load the texture atlas json data file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * texture-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas image file. Used in replacement of the Loaders default XHR Settings.
    * atlas-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas json file. Used in replacement of the Loaders default XHR Settings."
  ([loader key]
   (js/Phaser.Loader.FileTypes.AtlasJSONFile. (clj->phaser loader)
                                              (clj->phaser key)))
  ([loader key texture-url]
   (js/Phaser.Loader.FileTypes.AtlasJSONFile. (clj->phaser loader)
                                              (clj->phaser key)
                                              (clj->phaser texture-url)))
  ([loader key texture-url atlas-url]
   (js/Phaser.Loader.FileTypes.AtlasJSONFile. (clj->phaser loader)
                                              (clj->phaser key)
                                              (clj->phaser texture-url)
                                              (clj->phaser atlas-url)))
  ([loader key texture-url atlas-url texture-xhr-settings]
   (js/Phaser.Loader.FileTypes.AtlasJSONFile. (clj->phaser loader)
                                              (clj->phaser key)
                                              (clj->phaser texture-url)
                                              (clj->phaser atlas-url)
                                              (clj->phaser texture-xhr-settings)))
  ([loader key texture-url atlas-url texture-xhr-settings atlas-xhr-settings]
   (js/Phaser.Loader.FileTypes.AtlasJSONFile. (clj->phaser loader)
                                              (clj->phaser key)
                                              (clj->phaser texture-url)
                                              (clj->phaser atlas-url)
                                              (clj->phaser texture-xhr-settings)
                                              (clj->phaser atlas-xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([atlas-json-file]
   (phaser->clj
    (.addToCache atlas-json-file))))

(defn add-to-multi-file
  "Adds another child to this MultiFile, increases the pending count and resets the completion status.

  Parameters:
    * atlas-json-file (Phaser.Loader.FileTypes.AtlasJSONFile) - Targeted instance for method
    * files (Phaser.Loader.File) - The File to add to this MultiFile.

  Returns:  Phaser.Loader.MultiFile - This MultiFile instance."
  ([atlas-json-file files]
   (phaser->clj
    (.addToMultiFile atlas-json-file
                     (clj->phaser files)))))

(defn is-ready-to-process
  "Checks if this MultiFile is ready to process its children or not.

  Returns:  boolean - `true` if all children of this MultiFile have loaded, otherwise `false`."
  ([atlas-json-file]
   (phaser->clj
    (.isReadyToProcess atlas-json-file))))

(defn on-file-complete
  "Called by each File when it finishes loading.

  Parameters:
    * atlas-json-file (Phaser.Loader.FileTypes.AtlasJSONFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has completed processing."
  ([atlas-json-file file]
   (phaser->clj
    (.onFileComplete atlas-json-file
                     (clj->phaser file)))))

(defn on-file-failed
  "Called by each File that fails to load.

  Parameters:
    * atlas-json-file (Phaser.Loader.FileTypes.AtlasJSONFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has failed to load."
  ([atlas-json-file file]
   (phaser->clj
    (.onFileFailed atlas-json-file
                   (clj->phaser file)))))