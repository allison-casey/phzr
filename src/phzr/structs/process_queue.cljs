(ns phzr.structs.process-queue
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove update]))

(defn ->ProcessQueue
  ""
  ([]
   (js/Phaser.Structs.ProcessQueue.)))

(defn add
  "Adds a new item to the Process Queue.

  The item is added to the pending list and made active in the next update.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * item (*) - The item to add to the queue.

  Returns:  * - The item that was added."
  ([process-queue item]
   (phaser->clj
    (.add process-queue
          (clj->phaser item)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([process-queue event fn]
   (phaser->clj
    (.addListener process-queue
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([process-queue event fn context]
   (phaser->clj
    (.addListener process-queue
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn destroy
  "Immediately destroys this process queue, clearing all of its internal arrays and resetting the process totals."
  ([process-queue]
   (phaser->clj
    (.destroy process-queue))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([process-queue event]
   (phaser->clj
    (.emit process-queue
           (clj->phaser event))))
  ([process-queue event args]
   (phaser->clj
    (.emit process-queue
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([process-queue]
   (phaser->clj
    (.eventNames process-queue))))

(defn get-active
  "Returns the current list of active items.

  This method returns a reference to the active list array, not a copy of it.
  Therefore, be careful to not modify this array outside of the ProcessQueue.

  Returns:  Array.<*> - A list of active items."
  ([process-queue]
   (phaser->clj
    (.getActive process-queue))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([process-queue event]
   (phaser->clj
    (.listenerCount process-queue
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([process-queue event]
   (phaser->clj
    (.listeners process-queue
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([process-queue event]
   (phaser->clj
    (.off process-queue
          (clj->phaser event))))
  ([process-queue event fn]
   (phaser->clj
    (.off process-queue
          (clj->phaser event)
          (clj->phaser fn))))
  ([process-queue event fn context]
   (phaser->clj
    (.off process-queue
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([process-queue event fn context once]
   (phaser->clj
    (.off process-queue
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([process-queue event fn]
   (phaser->clj
    (.on process-queue
         (clj->phaser event)
         (clj->phaser fn))))
  ([process-queue event fn context]
   (phaser->clj
    (.on process-queue
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([process-queue event fn]
   (phaser->clj
    (.once process-queue
           (clj->phaser event)
           (clj->phaser fn))))
  ([process-queue event fn context]
   (phaser->clj
    (.once process-queue
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove
  "Removes an item from the Process Queue.

  The item is added to the pending destroy and fully removed in the next update.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * item (*) - The item to be removed from the queue.

  Returns:  * - The item that was removed."
  ([process-queue item]
   (phaser->clj
    (.remove process-queue
             (clj->phaser item)))))

(defn remove-all
  "Removes all active items from this Process Queue.

  All the items are marked as 'pending destroy' and fully removed in the next update.

  Returns:  this - This Process Queue object."
  ([process-queue]
   (phaser->clj
    (.removeAll process-queue))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([process-queue]
   (phaser->clj
    (.removeAllListeners process-queue)))
  ([process-queue event]
   (phaser->clj
    (.removeAllListeners process-queue
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * process-queue (Phaser.Structs.ProcessQueue) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([process-queue event]
   (phaser->clj
    (.removeListener process-queue
                     (clj->phaser event))))
  ([process-queue event fn]
   (phaser->clj
    (.removeListener process-queue
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([process-queue event fn context]
   (phaser->clj
    (.removeListener process-queue
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([process-queue event fn context once]
   (phaser->clj
    (.removeListener process-queue
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn shutdown
  "Removes all listeners."
  ([process-queue]
   (phaser->clj
    (.shutdown process-queue))))

(defn update
  "Update this queue. First it will process any items awaiting destruction, and remove them.

  Then it will check to see if there are any items pending insertion, and move them to an
  active state. Finally, it will return a list of active items for further processing.

  Returns:  Array.<*> - A list of active items."
  ([process-queue]
   (phaser->clj
    (.update process-queue))))