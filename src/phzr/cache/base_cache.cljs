(ns phzr.cache.base-cache
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [get remove]))

(defn ->BaseCache
  ""
  ([]
   (js/Phaser.Cache.BaseCache.)))

(defn add
  "Adds an item to this cache. The item is referenced by a unique string, which you are responsible
  for setting and keeping track of. The item can only be retrieved by using this string.

  Parameters:
    * base-cache (Phaser.Cache.BaseCache) - Targeted instance for method
    * key (string) - The unique key by which the data added to the cache will be referenced.
    * data (*) - The data to be stored in the cache.

  Returns:  Phaser.Cache.BaseCache - This BaseCache object."
  ([base-cache key data]
   (phaser->clj
    (.add base-cache
          (clj->phaser key)
          (clj->phaser data)))))

(defn destroy
  "Destroys this cache and all items within it."
  ([base-cache]
   (phaser->clj
    (.destroy base-cache))))

(defn exists
  "Checks if this cache contains an item matching the given key.
  This performs the same action as `BaseCache.has` and is called directly by the Loader.

  Parameters:
    * base-cache (Phaser.Cache.BaseCache) - Targeted instance for method
    * key (string) - The unique key of the item to be checked in this cache.

  Returns:  boolean - Returns `true` if the cache contains an item matching the given key, otherwise `false`."
  ([base-cache key]
   (phaser->clj
    (.exists base-cache
             (clj->phaser key)))))

(defn get
  "Gets an item from this cache based on the given key.

  Parameters:
    * base-cache (Phaser.Cache.BaseCache) - Targeted instance for method
    * key (string) - The unique key of the item to be retrieved from this cache.

  Returns:  * - The item in the cache, or `null` if no item matching the given key was found."
  ([base-cache key]
   (phaser->clj
    (.get base-cache
          (clj->phaser key)))))

(defn get-keys
  "Returns all keys in use in this cache.

  Returns:  Array.<string> - Array containing all the keys."
  ([base-cache]
   (phaser->clj
    (.getKeys base-cache))))

(defn has
  "Checks if this cache contains an item matching the given key.
  This performs the same action as `BaseCache.exists`.

  Parameters:
    * base-cache (Phaser.Cache.BaseCache) - Targeted instance for method
    * key (string) - The unique key of the item to be checked in this cache.

  Returns:  boolean - Returns `true` if the cache contains an item matching the given key, otherwise `false`."
  ([base-cache key]
   (phaser->clj
    (.has base-cache
          (clj->phaser key)))))

(defn remove
  "Removes and item from this cache based on the given key.

  If an entry matching the key is found it is removed from the cache and a `remove` event emitted.
  No additional checks are done on the item removed. If other systems or parts of your game code
  are relying on this item, it is up to you to sever those relationships prior to removing the item.

  Parameters:
    * base-cache (Phaser.Cache.BaseCache) - Targeted instance for method
    * key (string) - The unique key of the item to remove from the cache.

  Returns:  Phaser.Cache.BaseCache - This BaseCache object."
  ([base-cache key]
   (phaser->clj
    (.remove base-cache
             (clj->phaser key)))))