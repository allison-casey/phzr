(ns phzr.structs.set
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [set get iterate]))

(defn ->Set
  "  Parameters:
    * elements (Array.<*>) {optional} - An optional array of elements to insert into this Set."
  ([]
   (js/Phaser.Structs.Set.))
  ([elements]
   (js/Phaser.Structs.Set. (clj->phaser elements))))

(defn clear
  "Clears this Set so that it no longer contains any values.

  Returns:  Phaser.Structs.Set - This Set object."
  ([set]
   (phaser->clj
    (.clear set))))

(defn contains
  "Returns `true` if this Set contains the given value, otherwise returns `false`.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * value (*) - The value to check for in this Set.

  Returns:  boolean - `true` if the given value was found in this Set, otherwise `false`."
  ([set value]
   (phaser->clj
    (.contains set
               (clj->phaser value)))))

(defn delete
  "Removes the given value from this Set if this Set contains that value.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * value (*) - The value to remove from the Set.

  Returns:  Phaser.Structs.Set - This Set object."
  ([set value]
   (phaser->clj
    (.delete set
             (clj->phaser value)))))

(defn difference
  "Returns a new Set containing all the values in this Set which are *not* also in the given Set.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * set (Phaser.Structs.Set) - The Set to perform the difference with.

  Returns:  Phaser.Structs.Set - A new Set containing all the values in this Set that are not also in the Set provided as an argument to this method."
  ([set set]
   (phaser->clj
    (.difference set
                 (clj->phaser set)))))

(defn dump
  "Dumps the contents of this Set to the console via `console.group`."
  ([set]
   (phaser->clj
    (.dump set))))

(defn each
  "Passes each value in this Set to the given callback.
  Use this function when you know this Set will be modified during the iteration, otherwise use `iterate`.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * callback (EachSetCallback) - The callback to be invoked and passed each value this Set contains.
    * callback-scope (*) {optional} - The scope of the callback.

  Returns:  Phaser.Structs.Set - This Set object."
  ([set callback]
   (phaser->clj
    (.each set
           (clj->phaser callback))))
  ([set callback callback-scope]
   (phaser->clj
    (.each set
           (clj->phaser callback)
           (clj->phaser callback-scope)))))

(defn get
  "Get an element of this Set which has a property of the specified name, if that property is equal to the specified value.
  If no elements of this Set satisfy the condition then this method will return `null`.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * property (string) - The property name to check on the elements of this Set.
    * value (*) - The value to check for.

  Returns:  * - The first element of this Set that meets the required condition, or `null` if this Set contains no elements that meet the condition."
  ([set property value]
   (phaser->clj
    (.get set
          (clj->phaser property)
          (clj->phaser value)))))

(defn get-array
  "Returns an array containing all the values in this Set.

  Returns:  Array.<*> - An array containing all the values in this Set."
  ([set]
   (phaser->clj
    (.getArray set))))

(defn intersect
  "Returns a new Set that contains only the values which are in this Set and that are also in the given Set.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * set (Phaser.Structs.Set) - The Set to intersect this set with.

  Returns:  Phaser.Structs.Set - The result of the intersection, as a new Set."
  ([set set]
   (phaser->clj
    (.intersect set
                (clj->phaser set)))))

(defn iterate
  "Passes each value in this Set to the given callback.
  For when you absolutely know this Set won't be modified during the iteration.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * callback (EachSetCallback) - The callback to be invoked and passed each value this Set contains.
    * callback-scope (*) {optional} - The scope of the callback.

  Returns:  Phaser.Structs.Set - This Set object."
  ([set callback]
   (phaser->clj
    (.iterate set
              (clj->phaser callback))))
  ([set callback callback-scope]
   (phaser->clj
    (.iterate set
              (clj->phaser callback)
              (clj->phaser callback-scope)))))

(defn iterate-local
  "Goes through each entry in this Set and invokes the given function on them, passing in the arguments.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * callback-key (string) - The key of the function to be invoked on each Set entry.
    * args (*) {optional} - Additional arguments that will be passed to the callback, after the child.

  Returns:  Phaser.Structs.Set - This Set object."
  ([set callback-key]
   (phaser->clj
    (.iterateLocal set
                   (clj->phaser callback-key))))
  ([set callback-key args]
   (phaser->clj
    (.iterateLocal set
                   (clj->phaser callback-key)
                   (clj->phaser args)))))

(defn set
  "Inserts the provided value into this Set. If the value is already contained in this Set this method will have no effect.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * value (*) - The value to insert into this Set.

  Returns:  Phaser.Structs.Set - This Set object."
  ([set value]
   (phaser->clj
    (.set set
          (clj->phaser value)))))

(defn union
  "Returns a new Set containing all values that are either in this Set or in the Set provided as an argument.

  Parameters:
    * set (Phaser.Structs.Set) - Targeted instance for method
    * set (Phaser.Structs.Set) - The Set to perform the union with.

  Returns:  Phaser.Structs.Set - A new Set containing all the values in this Set and the Set provided as an argument."
  ([set set]
   (phaser->clj
    (.union set
            (clj->phaser set)))))