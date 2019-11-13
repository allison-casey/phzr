(ns phzr.loader.multi-file
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->MultiFile
  "  Parameters:
    * loader (Phaser.Loader.LoaderPlugin) - The Loader that is going to load this File.
    * type (string) - The file type string for sorting within the Loader.
    * key (string) - The key of the file within the loader.
    * files (Array.<Phaser.Loader.File>) - An array of Files that make-up this MultiFile."
  ([loader type key files]
   (js/Phaser.Loader.MultiFile. (clj->phaser loader)
                                (clj->phaser type)
                                (clj->phaser key)
                                (clj->phaser files))))

(defn add-to-multi-file
  "Adds another child to this MultiFile, increases the pending count and resets the completion status.

  Parameters:
    * multi-file (Phaser.Loader.MultiFile) - Targeted instance for method
    * files (Phaser.Loader.File) - The File to add to this MultiFile.

  Returns:  Phaser.Loader.MultiFile - This MultiFile instance."
  ([multi-file files]
   (phaser->clj
    (.addToMultiFile multi-file
                     (clj->phaser files)))))

(defn is-ready-to-process
  "Checks if this MultiFile is ready to process its children or not.

  Returns:  boolean - `true` if all children of this MultiFile have loaded, otherwise `false`."
  ([multi-file]
   (phaser->clj
    (.isReadyToProcess multi-file))))

(defn on-file-complete
  "Called by each File when it finishes loading.

  Parameters:
    * multi-file (Phaser.Loader.MultiFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has completed processing."
  ([multi-file file]
   (phaser->clj
    (.onFileComplete multi-file
                     (clj->phaser file)))))

(defn on-file-failed
  "Called by each File that fails to load.

  Parameters:
    * multi-file (Phaser.Loader.MultiFile) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that has failed to load."
  ([multi-file file]
   (phaser->clj
    (.onFileFailed multi-file
                   (clj->phaser file)))))