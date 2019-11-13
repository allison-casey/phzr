(ns phzr.structs.list
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [sort count remove reverse shuffle replace]))

(defn ->List
  "  Parameters:
    * parent (*) - The parent of this list."
  ([parent]
   (js/Phaser.Structs.List. (clj->phaser parent))))

(defn add
  "Adds the given item to the end of the list. Each item must be unique.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (* | Array.<*>) - The item, or array of items, to add to the list.
    * skip-callback (boolean) {optional} - Skip calling the List.addCallback if this child is added successfully.

  Returns:  * - The list's underlying array."
  ([list child]
   (phaser->clj
    (.add list
          (clj->phaser child))))
  ([list child skip-callback]
   (phaser->clj
    (.add list
          (clj->phaser child)
          (clj->phaser skip-callback)))))

(defn add-at
  "Adds an item to list, starting at a specified index. Each item must be unique within the list.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item, or array of items, to add to the list.
    * index (integer) {optional} - The index in the list at which the element(s) will be inserted.
    * skip-callback (boolean) {optional} - Skip calling the List.addCallback if this child is added successfully.

  Returns:  * - The List's underlying array."
  ([list child]
   (phaser->clj
    (.addAt list
            (clj->phaser child))))
  ([list child index]
   (phaser->clj
    (.addAt list
            (clj->phaser child)
            (clj->phaser index))))
  ([list child index skip-callback]
   (phaser->clj
    (.addAt list
            (clj->phaser child)
            (clj->phaser index)
            (clj->phaser skip-callback)))))

(defn bring-to-top
  "Brings the given child to the top of this List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item to bring to the top of the List.

  Returns:  * - The item which was moved."
  ([list child]
   (phaser->clj
    (.bringToTop list
                 (clj->phaser child)))))

(defn count
  "Returns the total number of items in the List which have a property matching the given value.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * property (string) - The property to test on each item.
    * value (*) - The value to test the property against.

  Returns:  integer - The total number of matching elements."
  ([list property value]
   (phaser->clj
    (.count list
            (clj->phaser property)
            (clj->phaser value)))))

(defn destroy
  "Destroys this List."
  ([list]
   (phaser->clj
    (.destroy list))))

(defn each
  "Passes all children to the given callback.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * callback (EachListCallback) - The function to call.
    * context (*) {optional} - Value to use as `this` when executing callback.
    * args (*) {optional} - Additional arguments that will be passed to the callback, after the child."
  ([list callback]
   (phaser->clj
    (.each list
           (clj->phaser callback))))
  ([list callback context]
   (phaser->clj
    (.each list
           (clj->phaser callback)
           (clj->phaser context))))
  ([list callback context args]
   (phaser->clj
    (.each list
           (clj->phaser callback)
           (clj->phaser context)
           (clj->phaser args)))))

(defn exists
  "Checks if an item exists within the List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item to check for the existence of.

  Returns:  boolean - `true` if the item is found in the list, otherwise `false`."
  ([list child]
   (phaser->clj
    (.exists list
             (clj->phaser child)))))

(defn get-all
  "Returns all children in this List.

  You can optionally specify a matching criteria using the `property` and `value` arguments.

  For example: `getAll('parent')` would return only children that have a property called `parent`.

  You can also specify a value to compare the property to:

  `getAll('visible', true)` would return only children that have their visible property set to `true`.

  Optionally you can specify a start and end index. For example if this List had 100 children,
  and you set `startIndex` to 0 and `endIndex` to 50, it would return matches from only
  the first 50 children in the List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * property (string) {optional} - An optional property to test against the value argument.
    * value (*) {optional} - If property is set then Child.property must strictly equal this value to be included in the results.
    * start-index (integer) {optional} - The first child index to start the search from.
    * end-index (integer) {optional} - The last child index to search up until.

  Returns:  Array.<*> - All items of the List which match the given criterion, if any."
  ([list]
   (phaser->clj
    (.getAll list)))
  ([list property]
   (phaser->clj
    (.getAll list
             (clj->phaser property))))
  ([list property value]
   (phaser->clj
    (.getAll list
             (clj->phaser property)
             (clj->phaser value))))
  ([list property value start-index]
   (phaser->clj
    (.getAll list
             (clj->phaser property)
             (clj->phaser value)
             (clj->phaser start-index))))
  ([list property value start-index end-index]
   (phaser->clj
    (.getAll list
             (clj->phaser property)
             (clj->phaser value)
             (clj->phaser start-index)
             (clj->phaser end-index)))))

(defn get-at
  "Retrieves the item at a given position inside the List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * index (integer) - The index of the item.

  Returns:  * - The retrieved item, or `undefined` if it's outside the List's bounds."
  ([list index]
   (phaser->clj
    (.getAt list
            (clj->phaser index)))))

(defn get-by-name
  "Searches for the first instance of a child with its `name`
  property matching the given argument. Should more than one child have
  the same name only the first is returned.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * name (string) - The name to search for.

  Returns:  * - The first child with a matching name, or null if none were found."
  ([list name]
   (phaser->clj
    (.getByName list
                (clj->phaser name)))))

(defn get-first
  "Returns the first element in a given part of the List which matches a specific criterion.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * property (string) - The name of the property to test or a falsey value to have no criterion.
    * value (*) - The value to test the `property` against, or `undefined` to allow any value and only check for existence.
    * start-index (number) {optional} - The position in the List to start the search at.
    * end-index (number) {optional} - The position in the List to optionally stop the search at. It won't be checked.

  Returns:  * - The first item which matches the given criterion, or `null` if no such item exists."
  ([list property value]
   (phaser->clj
    (.getFirst list
               (clj->phaser property)
               (clj->phaser value))))
  ([list property value start-index]
   (phaser->clj
    (.getFirst list
               (clj->phaser property)
               (clj->phaser value)
               (clj->phaser start-index))))
  ([list property value start-index end-index]
   (phaser->clj
    (.getFirst list
               (clj->phaser property)
               (clj->phaser value)
               (clj->phaser start-index)
               (clj->phaser end-index)))))

(defn get-index
  "Locates an item within the List and returns its index.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item to locate.

  Returns:  integer - The index of the item within the List, or -1 if it's not in the List."
  ([list child]
   (phaser->clj
    (.getIndex list
               (clj->phaser child)))))

(defn get-random
  "Returns a random child from the group.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * start-index (integer) {optional} - Offset from the front of the group (lowest child).
    * length (integer) {optional} - Restriction on the number of values you want to randomly select from.

  Returns:  * - A random child of this Group."
  ([list]
   (phaser->clj
    (.getRandom list)))
  ([list start-index]
   (phaser->clj
    (.getRandom list
                (clj->phaser start-index))))
  ([list start-index length]
   (phaser->clj
    (.getRandom list
                (clj->phaser start-index)
                (clj->phaser length)))))

(defn move-down
  "Moves the given child down one place in this group unless it's already at the bottom.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item to move down.

  Returns:  * - The item which was moved."
  ([list child]
   (phaser->clj
    (.moveDown list
               (clj->phaser child)))))

(defn move-to
  "Moves an item in the List to a new position.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item to move.
    * index (integer) - Moves an item in the List to a new position.

  Returns:  * - The item that was moved."
  ([list child index]
   (phaser->clj
    (.moveTo list
             (clj->phaser child)
             (clj->phaser index)))))

(defn move-up
  "Moves the given child up one place in this group unless it's already at the top.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item to move up.

  Returns:  * - The item which was moved."
  ([list child]
   (phaser->clj
    (.moveUp list
             (clj->phaser child)))))

(defn remove
  "Removes one or many items from the List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item, or array of items, to remove.
    * skip-callback (boolean) {optional} - Skip calling the List.removeCallback.

  Returns:  * - The item, or array of items, which were successfully removed from the List."
  ([list child]
   (phaser->clj
    (.remove list
             (clj->phaser child))))
  ([list child skip-callback]
   (phaser->clj
    (.remove list
             (clj->phaser child)
             (clj->phaser skip-callback)))))

(defn remove-all
  "Removes all the items.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * skip-callback (boolean) {optional} - Skip calling the List.removeCallback.

  Returns:  Phaser.Structs.List - This List object."
  ([list]
   (phaser->clj
    (.removeAll list)))
  ([list skip-callback]
   (phaser->clj
    (.removeAll list
                (clj->phaser skip-callback)))))

(defn remove-at
  "Removes the item at the given position in the List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * index (integer) - The position to remove the item from.
    * skip-callback (boolean) {optional} - Skip calling the List.removeCallback.

  Returns:  * - The item that was removed."
  ([list index]
   (phaser->clj
    (.removeAt list
               (clj->phaser index))))
  ([list index skip-callback]
   (phaser->clj
    (.removeAt list
               (clj->phaser index)
               (clj->phaser skip-callback)))))

(defn remove-between
  "Removes the items within the given range in the List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * start-index (integer) {optional} - The index to start removing from.
    * end-index (integer) {optional} - The position to stop removing at. The item at this position won't be removed.
    * skip-callback (boolean) {optional} - Skip calling the List.removeCallback.

  Returns:  Array.<*> - An array of the items which were removed."
  ([list]
   (phaser->clj
    (.removeBetween list)))
  ([list start-index]
   (phaser->clj
    (.removeBetween list
                    (clj->phaser start-index))))
  ([list start-index end-index]
   (phaser->clj
    (.removeBetween list
                    (clj->phaser start-index)
                    (clj->phaser end-index))))
  ([list start-index end-index skip-callback]
   (phaser->clj
    (.removeBetween list
                    (clj->phaser start-index)
                    (clj->phaser end-index)
                    (clj->phaser skip-callback)))))

(defn replace
  "Replaces a child of this List with the given newChild. The newChild cannot be a member of this List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * old-child (*) - The child in this List that will be replaced.
    * new-child (*) - The child to be inserted into this List.

  Returns:  * - Returns the oldChild that was replaced within this group."
  ([list old-child new-child]
   (phaser->clj
    (.replace list
              (clj->phaser old-child)
              (clj->phaser new-child)))))

(defn reverse
  "Reverses the order of all children in this List.

  Returns:  Phaser.Structs.List - This List object."
  ([list]
   (phaser->clj
    (.reverse list))))

(defn send-to-back
  "Sends the given child to the bottom of this List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child (*) - The item to send to the back of the list.

  Returns:  * - The item which was moved."
  ([list child]
   (phaser->clj
    (.sendToBack list
                 (clj->phaser child)))))

(defn set-all
  "Sets the property `key` to the given value on all members of this List.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * property (string) - The name of the property to set.
    * value (*) - The value to set the property to.
    * start-index (integer) {optional} - The first child index to start the search from.
    * end-index (integer) {optional} - The last child index to search up until."
  ([list property value]
   (phaser->clj
    (.setAll list
             (clj->phaser property)
             (clj->phaser value))))
  ([list property value start-index]
   (phaser->clj
    (.setAll list
             (clj->phaser property)
             (clj->phaser value)
             (clj->phaser start-index))))
  ([list property value start-index end-index]
   (phaser->clj
    (.setAll list
             (clj->phaser property)
             (clj->phaser value)
             (clj->phaser start-index)
             (clj->phaser end-index)))))

(defn shuffle
  "Shuffles the items in the list.

  Returns:  Phaser.Structs.List - This List object."
  ([list]
   (phaser->clj
    (.shuffle list))))

(defn shutdown
  "Clears the List and recreates its internal array."
  ([list]
   (phaser->clj
    (.shutdown list))))

(defn sort
  "Sort the contents of this List so the items are in order based on the given property.
  For example, `sort('alpha')` would sort the List contents based on the value of their `alpha` property.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * property (string) - The property to lexically sort by.
    * handler (function) {optional} - Provide your own custom handler function. Will receive 2 children which it should compare and return a boolean.

  Returns:  Phaser.Structs.List - This List object."
  ([list property]
   (phaser->clj
    (.sort list
           (clj->phaser property))))
  ([list property handler]
   (phaser->clj
    (.sort list
           (clj->phaser property)
           (clj->phaser handler)))))

(defn swap
  "Swaps the positions of two items in the list.

  Parameters:
    * list (Phaser.Structs.List) - Targeted instance for method
    * child-1 (*) - The first item to swap.
    * child-2 (*) - The second item to swap."
  ([list child-1 child-2]
   (phaser->clj
    (.swap list
           (clj->phaser child-1)
           (clj->phaser child-2)))))