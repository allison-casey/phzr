(ns phzr.data.data-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [get set merge remove pop]))

(defn ->DataManager
  "  Parameters:
    * parent (object) - The object that this DataManager belongs to.
    * event-emitter (Phaser.Events.EventEmitter) - The DataManager's event emitter."
  ([parent event-emitter]
   (js/Phaser.Data.DataManager. (clj->phaser parent)
                                (clj->phaser event-emitter))))

(defn destroy
  "Destroy this data manager."
  ([data-manager]
   (phaser->clj
    (.destroy data-manager))))

(defn each
  "Passes all data entries to the given callback.

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * callback (DataEachCallback) - The function to call.
    * context (*) {optional} - Value to use as `this` when executing callback.
    * args (*) {optional} - Additional arguments that will be passed to the callback, after the game object, key, and data.

  Returns:  Phaser.Data.DataManager - This DataManager object."
  ([data-manager callback]
   (phaser->clj
    (.each data-manager
           (clj->phaser callback))))
  ([data-manager callback context]
   (phaser->clj
    (.each data-manager
           (clj->phaser callback)
           (clj->phaser context))))
  ([data-manager callback context args]
   (phaser->clj
    (.each data-manager
           (clj->phaser callback)
           (clj->phaser context)
           (clj->phaser args)))))

(defn get
  "Retrieves the value for the given key, or undefined if it doesn't exist.

  You can also access values via the `values` object. For example, if you had a key called `gold` you can do either:

  ```javascript
  this.data.get('gold');
  ```

  Or access the value directly:

  ```javascript
  this.data.values.gold;
  ```

  You can also pass in an array of keys, in which case an array of values will be returned:

  ```javascript
  this.data.get([ 'gold', 'armor', 'health' ]);
  ```

  This approach is useful for destructuring arrays in ES6.

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([data-manager key]
   (phaser->clj
    (.get data-manager
          (clj->phaser key)))))

(defn get-all
  "Retrieves all data values in a new object.

  Returns:  Object.<string, *> - All data values."
  ([data-manager]
   (phaser->clj
    (.getAll data-manager))))

(defn has
  "Determines whether the given key is set in this Data Manager.

  Please note that the keys are case-sensitive and must be valid JavaScript Object property strings.
  This means the keys `gold` and `Gold` are treated as two unique values within the Data Manager.

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * key (string) - The key to check.

  Returns:  boolean - Returns `true` if the key exists, otherwise `false`."
  ([data-manager key]
   (phaser->clj
    (.has data-manager
          (clj->phaser key)))))

(defn merge
  "Merge the given object of key value pairs into this DataManager.

  Any newly created values will emit a `setdata` event. Any updated values (see the `overwrite` argument)
  will emit a `changedata` event.

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * data (Object.<string, *>) - The data to merge.
    * overwrite (boolean) {optional} - Whether to overwrite existing data. Defaults to true.

  Returns:  Phaser.Data.DataManager - This DataManager object."
  ([data-manager data]
   (phaser->clj
    (.merge data-manager
            (clj->phaser data))))
  ([data-manager data overwrite]
   (phaser->clj
    (.merge data-manager
            (clj->phaser data)
            (clj->phaser overwrite)))))

(defn pop
  "Retrieves the data associated with the given 'key', deletes it from this Data Manager, then returns it.

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * key (string) - The key of the value to retrieve and delete.

  Returns:  * - The value of the given key."
  ([data-manager key]
   (phaser->clj
    (.pop data-manager
          (clj->phaser key)))))

(defn query
  "Queries the DataManager for the values of keys matching the given regular expression.

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * search (RegExp) - A regular expression object. If a non-RegExp object obj is passed, it is implicitly converted to a RegExp by using new RegExp(obj).

  Returns:  Object.<string, *> - The values of the keys matching the search string."
  ([data-manager search]
   (phaser->clj
    (.query data-manager
            (clj->phaser search)))))

(defn remove
  "Remove the value for the given key.

  If the key is found in this Data Manager it is removed from the internal lists and a
  `removedata` event is emitted.

  You can also pass in an array of keys, in which case all keys in the array will be removed:

  ```javascript
  this.data.remove([ 'gold', 'armor', 'health' ]);
  ```

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * key (string | Array.<string>) - The key to remove, or an array of keys to remove.

  Returns:  Phaser.Data.DataManager - This DataManager object."
  ([data-manager key]
   (phaser->clj
    (.remove data-manager
             (clj->phaser key)))))

(defn reset
  "Delete all data in this Data Manager and unfreeze it.

  Returns:  Phaser.Data.DataManager - This DataManager object."
  ([data-manager]
   (phaser->clj
    (.reset data-manager))))

(defn set
  "Sets a value for the given key. If the key doesn't already exist in the Data Manager then it is created.

  ```javascript
  data.set('name', 'Red Gem Stone');
  ```

  You can also pass in an object of key value pairs as the first argument:

  ```javascript
  data.set({ name: 'Red Gem Stone', level: 2, owner: 'Link', gold: 50 });
  ```

  To get a value back again you can call `get`:

  ```javascript
  data.get('gold');
  ```

  Or you can access the value directly via the `values` property, where it works like any other variable:

  ```javascript
  data.values.gold += 50;
  ```

  When the value is first set, a `setdata` event is emitted.

  If the key already exists, a `changedata` event is emitted instead, along an event named after the key.
  For example, if you updated an existing key called `PlayerLives` then it would emit the event `changedata-PlayerLives`.
  These events will be emitted regardless if you use this method to set the value, or the direct `values` setter.

  Please note that the data keys are case-sensitive and must be valid JavaScript Object property strings.
  This means the keys `gold` and `Gold` are treated as two unique values within the Data Manager.

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object or key value pairs. If an object the `data` argument is ignored.
    * data (*) - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  Phaser.Data.DataManager - This DataManager object."
  ([data-manager key data]
   (phaser->clj
    (.set data-manager
          (clj->phaser key)
          (clj->phaser data)))))

(defn set-freeze
  "Freeze or unfreeze this Data Manager. A frozen Data Manager will block all attempts
  to create new values or update existing ones.

  Parameters:
    * data-manager (Phaser.Data.DataManager) - Targeted instance for method
    * value (boolean) - Whether to freeze or unfreeze the Data Manager.

  Returns:  Phaser.Data.DataManager - This DataManager object."
  ([data-manager value]
   (phaser->clj
    (.setFreeze data-manager
                (clj->phaser value)))))