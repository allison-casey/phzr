(ns phzr.structs.map
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [set get keys merge]))

(defn ->Map
  "  Parameters:
    * elements (Array.<*>) - An optional array of key-value pairs to populate this Map with."
  ([elements]
   (js/Phaser.Structs.Map. (clj->phaser elements))))

(defn clear
  "Delete all entries from this Map.

  Returns:  Phaser.Structs.Map - This Map object."
  ([map]
   (phaser->clj
    (.clear map))))

(defn contains
  "Returns `true` if the value exists within this Map. Otherwise, returns `false`.

  Parameters:
    * map (Phaser.Structs.Map) - Targeted instance for method
    * value (*) - The value to search for.

  Returns:  boolean - `true` if the value is found, otherwise `false`."
  ([map value]
   (phaser->clj
    (.contains map
               (clj->phaser value)))))

(defn delete
  "Delete the specified element from this Map.

  Parameters:
    * map (Phaser.Structs.Map) - Targeted instance for method
    * key (string) - The key of the element to delete from this Map.

  Returns:  Phaser.Structs.Map - This Map object."
  ([map key]
   (phaser->clj
    (.delete map
             (clj->phaser key)))))

(defn dump
  "Dumps the contents of this Map to the console via `console.group`."
  ([map]
   (phaser->clj
    (.dump map))))

(defn each
  "Passes all entries in this Map to the given callback.

  Parameters:
    * map (Phaser.Structs.Map) - Targeted instance for method
    * callback (EachMapCallback) - The callback which will receive the keys and entries held in this Map.

  Returns:  Phaser.Structs.Map - This Map object."
  ([map callback]
   (phaser->clj
    (.each map
           (clj->phaser callback)))))

(defn get
  "Returns the value associated to the `key`, or `undefined` if there is none.

  Parameters:
    * map (Phaser.Structs.Map) - Targeted instance for method
    * key (string) - The key of the element to return from the `Map` object.

  Returns:  * - The element associated with the specified key or `undefined` if the key can't be found in this Map object."
  ([map key]
   (phaser->clj
    (.get map
          (clj->phaser key)))))

(defn get-array
  "Returns an `Array` of all the values stored in this Map.

  Returns:  Array.<*> - An array of the values stored in this Map."
  ([map]
   (phaser->clj
    (.getArray map))))

(defn has
  "Returns a boolean indicating whether an element with the specified key exists or not.

  Parameters:
    * map (Phaser.Structs.Map) - Targeted instance for method
    * key (string) - The key of the element to test for presence of in this Map.

  Returns:  boolean - Returns `true` if an element with the specified key exists in this Map, otherwise `false`."
  ([map key]
   (phaser->clj
    (.has map
          (clj->phaser key)))))

(defn keys
  "Returns all entries keys in this Map.

  Returns:  Array.<string> - Array containing entries' keys."
  ([map]
   (phaser->clj
    (.keys map))))

(defn merge
  "Merges all new keys from the given Map into this one.
  If it encounters a key that already exists it will be skipped unless override is set to `true`.

  Parameters:
    * map (Phaser.Structs.Map) - Targeted instance for method
    * map (Phaser.Structs.Map) - The Map to merge in to this Map.
    * override (boolean) {optional} - Set to `true` to replace values in this Map with those from the source map, or `false` to skip them.

  Returns:  Phaser.Structs.Map - This Map object."
  ([map map]
   (phaser->clj
    (.merge map
            (clj->phaser map))))
  ([map map override]
   (phaser->clj
    (.merge map
            (clj->phaser map)
            (clj->phaser override)))))

(defn set
  "Adds an element with a specified `key` and `value` to this Map.
  If the `key` already exists, the value will be replaced.

  Parameters:
    * map (Phaser.Structs.Map) - Targeted instance for method
    * key (string) - The key of the element to be added to this Map.
    * value (*) - The value of the element to be added to this Map.

  Returns:  Phaser.Structs.Map - This Map object."
  ([map key value]
   (phaser->clj
    (.set map
          (clj->phaser key)
          (clj->phaser value)))))

(defn values
  "Returns an `Array` of all entries.

  Returns:  Array.<*> - An `Array` of entries."
  ([map]
   (phaser->clj
    (.values map))))