(ns phzr.cache.cache-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->CacheManager
  "  Parameters:
    * game (Phaser.Game) - A reference to the Phaser.Game instance that owns this CacheManager."
  ([game]
   (js/Phaser.Cache.CacheManager. (clj->phaser game))))

(defn add-custom
  "Add your own custom Cache for storing your own files.
  The cache will be available under `Cache.custom.key`.
  The cache will only be created if the key is not already in use.

  Parameters:
    * cache-manager (Phaser.Cache.CacheManager) - Targeted instance for method
    * key (string) - The unique key of your custom cache.

  Returns:  Phaser.Cache.BaseCache - A reference to the BaseCache that was created. If the key was already in use, a reference to the existing cache is returned instead."
  ([cache-manager key]
   (phaser->clj
    (.addCustom cache-manager
                (clj->phaser key)))))

(defn destroy
  "Removes all entries from all BaseCaches and destroys all custom caches."
  ([cache-manager]
   (phaser->clj
    (.destroy cache-manager))))