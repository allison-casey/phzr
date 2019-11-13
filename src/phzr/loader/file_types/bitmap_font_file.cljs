(ns phzr.loader.file-types.bitmap-font-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->BitmapFontFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.BitmapFontFileConfig) - The key to use for this file, or a file configuration object.
    * texture-url (string | Array.<string>) {optional} - The absolute or relative URL to load the font image file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * font-data-url (string) {optional} - The absolute or relative URL to load the font xml data file from. If undefined or `null` it will be set to `<key>.xml`, i.e. if `key` was 'alien' then the URL will be 'alien.xml'.
    * texture-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the font image file. Used in replacement of the Loaders default XHR Settings.
    * font-data-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the font data xml file. Used in replacement of the Loaders default XHR Settings."
  ([loader key]
   (js/Phaser.Loader.FileTypes.BitmapFontFile. (clj->phaser loader)
                                               (clj->phaser key)))
  ([loader key texture-url]
   (js/Phaser.Loader.FileTypes.BitmapFontFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser texture-url)))
  ([loader key texture-url font-data-url]
   (js/Phaser.Loader.FileTypes.BitmapFontFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser texture-url)
                                               (clj->phaser font-data-url)))
  ([loader key texture-url font-data-url texture-xhr-settings]
   (js/Phaser.Loader.FileTypes.BitmapFontFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser texture-url)
                                               (clj->phaser font-data-url)
                                               (clj->phaser texture-xhr-settings)))
  ([loader key texture-url font-data-url texture-xhr-settings font-data-xhr-settings]
   (js/Phaser.Loader.FileTypes.BitmapFontFile. (clj->phaser loader)
                                               (clj->phaser key)
                                               (clj->phaser texture-url)
                                               (clj->phaser font-data-url)
                                               (clj->phaser texture-xhr-settings)
                                               (clj->phaser font-data-xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([bitmap-font-file]
   (phaser->clj
    (.addToCache bitmap-font-file))))

(defn add-to-multi-file
  "Adds another child to this MultiFile, increases the pending count and resets the completion status.

  Parameters:
    * bitmap-font-file (Phaser.Loader.FileTypes.BitmapFontFile) - Targeted instance for method
    * files (Phaser.Loader.File) - The File to add to this MultiFile.

  Returns:  Phaser.Loader.MultiFile - This MultiFile instance."
  ([bitmap-font-file files]
   (phaser->clj
    (.addToMultiFile bitmap-font-file
                     (clj->phaser files)))))

(defn is-ready-to-process
  "Checks if this MultiFile is ready to process its children or not.

  Returns:  boolean - `true` if all children of this MultiFile have loaded, otherwise `false`."
  ([bitmap-font-file]
   (phaser->clj
    (.isReadyToProcess bitmap-font-file))))

(defn on-file-complete
  "Called by each File when it finishes loading.

  Parameters:
    * bitmap-font-file (Phaser.Loader.FileTypes.BitmapFontFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has completed processing."
  ([bitmap-font-file file]
   (phaser->clj
    (.onFileComplete bitmap-font-file
                     (clj->phaser file)))))

(defn on-file-failed
  "Called by each File that fails to load.

  Parameters:
    * bitmap-font-file (Phaser.Loader.FileTypes.BitmapFontFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has failed to load."
  ([bitmap-font-file file]
   (phaser->clj
    (.onFileFailed bitmap-font-file
                   (clj->phaser file)))))