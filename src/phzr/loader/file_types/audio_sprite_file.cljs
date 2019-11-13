(ns phzr.loader.file-types.audio-sprite-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->AudioSpriteFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - A reference to the Loader that is responsible for this file.
    * key (string | Phaser.Types.Loader.FileTypes.AudioSpriteFileConfig) - The key to use for this file, or a file configuration object.
    * json-url (string) - The absolute or relative URL to load the json file from. Or a well formed JSON object to use instead.
    * audio-url (Object) {optional} - The absolute or relative URL to load the audio file from. If empty it will be obtained by parsing the JSON file.
    * audio-config (any) {optional} - The audio configuration options.
    * audio-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the audio file. Used in replacement of the Loaders default XHR Settings.
    * json-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the json file. Used in replacement of the Loaders default XHR Settings."
  ([loader key json-url]
   (js/Phaser.Loader.FileTypes.AudioSpriteFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser json-url)))
  ([loader key json-url audio-url]
   (js/Phaser.Loader.FileTypes.AudioSpriteFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser json-url)
                                                (clj->phaser audio-url)))
  ([loader key json-url audio-url audio-config]
   (js/Phaser.Loader.FileTypes.AudioSpriteFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser json-url)
                                                (clj->phaser audio-url)
                                                (clj->phaser audio-config)))
  ([loader key json-url audio-url audio-config audio-xhr-settings]
   (js/Phaser.Loader.FileTypes.AudioSpriteFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser json-url)
                                                (clj->phaser audio-url)
                                                (clj->phaser audio-config)
                                                (clj->phaser audio-xhr-settings)))
  ([loader key json-url audio-url audio-config audio-xhr-settings json-xhr-settings]
   (js/Phaser.Loader.FileTypes.AudioSpriteFile. (clj->phaser loader)
                                                (clj->phaser key)
                                                (clj->phaser json-url)
                                                (clj->phaser audio-url)
                                                (clj->phaser audio-config)
                                                (clj->phaser audio-xhr-settings)
                                                (clj->phaser json-xhr-settings))))

(defn add-to-cache
  "Adds this file to its target cache upon successful loading and processing."
  ([audio-sprite-file]
   (phaser->clj
    (.addToCache audio-sprite-file))))

(defn add-to-multi-file
  "Adds another child to this MultiFile, increases the pending count and resets the completion status.

  Parameters:
    * audio-sprite-file (Phaser.Loader.FileTypes.AudioSpriteFile) - Targeted instance for method
    * files (Phaser.Loader.File) - The File to add to this MultiFile.

  Returns:  Phaser.Loader.MultiFile - This MultiFile instance."
  ([audio-sprite-file files]
   (phaser->clj
    (.addToMultiFile audio-sprite-file
                     (clj->phaser files)))))

(defn is-ready-to-process
  "Checks if this MultiFile is ready to process its children or not.

  Returns:  boolean - `true` if all children of this MultiFile have loaded, otherwise `false`."
  ([audio-sprite-file]
   (phaser->clj
    (.isReadyToProcess audio-sprite-file))))

(defn on-file-complete
  "Called by each File when it finishes loading.

  Parameters:
    * audio-sprite-file (Phaser.Loader.FileTypes.AudioSpriteFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has completed processing."
  ([audio-sprite-file file]
   (phaser->clj
    (.onFileComplete audio-sprite-file
                     (clj->phaser file)))))

(defn on-file-failed
  "Called by each File that fails to load.

  Parameters:
    * audio-sprite-file (Phaser.Loader.FileTypes.AudioSpriteFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has failed to load."
  ([audio-sprite-file file]
   (phaser->clj
    (.onFileFailed audio-sprite-file
                   (clj->phaser file)))))