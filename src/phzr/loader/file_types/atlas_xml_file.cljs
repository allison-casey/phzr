(ns phzr.loader.file-types.atlas-xml-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->AtlasXMLFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.AtlasXMLFileConfig) - The key to use for this file, or a file configuration object.
    * texture-url (string | Array.<string>) {optional} - The absolute or relative URL to load the texture image file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * atlas-url (string) {optional} - The absolute or relative URL to load the texture atlas xml data file from. If undefined or `null` it will be set to `<key>.xml`, i.e. if `key` was 'alien' then the URL will be 'alien.xml'.
    * texture-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas image file. Used in replacement of the Loaders default XHR Settings.
    * atlas-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas xml file. Used in replacement of the Loaders default XHR Settings."
  ([loader key]
   (js/Phaser.Loader.FileTypes.AtlasXMLFile. (clj->phaser loader)
                                             (clj->phaser key)))
  ([loader key texture-url]
   (js/Phaser.Loader.FileTypes.AtlasXMLFile. (clj->phaser loader)
                                             (clj->phaser key)
                                             (clj->phaser texture-url)))
  ([loader key texture-url atlas-url]
   (js/Phaser.Loader.FileTypes.AtlasXMLFile. (clj->phaser loader)
                                             (clj->phaser key)
                                             (clj->phaser texture-url)
                                             (clj->phaser atlas-url)))
  ([loader key texture-url atlas-url texture-xhr-settings]
   (js/Phaser.Loader.FileTypes.AtlasXMLFile. (clj->phaser loader)
                                             (clj->phaser key)
                                             (clj->phaser texture-url)
                                             (clj->phaser atlas-url)
                                             (clj->phaser texture-xhr-settings)))
  ([loader key texture-url atlas-url texture-xhr-settings atlas-xhr-settings]
   (js/Phaser.Loader.FileTypes.AtlasXMLFile. (clj->phaser loader)
                                             (clj->phaser key)
                                             (clj->phaser texture-url)
                                             (clj->phaser atlas-url)
                                             (clj->phaser texture-xhr-settings)
                                             (clj->phaser atlas-xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([atlas-xml-file]
   (phaser->clj
    (.addToCache atlas-xml-file))))

(defn add-to-multi-file
  "Adds another child to this MultiFile, increases the pending count and resets the completion status.

  Parameters:
    * atlas-xml-file (Phaser.Loader.FileTypes.AtlasXMLFile) - Targeted instance for method
    * files (Phaser.Loader.File) - The File to add to this MultiFile.

  Returns:  Phaser.Loader.MultiFile - This MultiFile instance."
  ([atlas-xml-file files]
   (phaser->clj
    (.addToMultiFile atlas-xml-file
                     (clj->phaser files)))))

(defn is-ready-to-process
  "Checks if this MultiFile is ready to process its children or not.

  Returns:  boolean - `true` if all children of this MultiFile have loaded, otherwise `false`."
  ([atlas-xml-file]
   (phaser->clj
    (.isReadyToProcess atlas-xml-file))))

(defn on-file-complete
  "Called by each File when it finishes loading.

  Parameters:
    * atlas-xml-file (Phaser.Loader.FileTypes.AtlasXMLFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has completed processing."
  ([atlas-xml-file file]
   (phaser->clj
    (.onFileComplete atlas-xml-file
                     (clj->phaser file)))))

(defn on-file-failed
  "Called by each File that fails to load.

  Parameters:
    * atlas-xml-file (Phaser.Loader.FileTypes.AtlasXMLFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has failed to load."
  ([atlas-xml-file file]
   (phaser->clj
    (.onFileFailed atlas-xml-file
                   (clj->phaser file)))))