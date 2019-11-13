(ns phzr.events.event-emitter
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->EventEmitter
  ""
  ([]
   (js/Phaser.Events.EventEmitter.)))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([event-emitter event fn]
   (phaser->clj
    (.addListener event-emitter
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([event-emitter event fn context]
   (phaser->clj
    (.addListener event-emitter
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn destroy
  "Removes all listeners."
  ([event-emitter]
   (phaser->clj
    (.destroy event-emitter))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([event-emitter event]
   (phaser->clj
    (.emit event-emitter
           (clj->phaser event))))
  ([event-emitter event args]
   (phaser->clj
    (.emit event-emitter
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([event-emitter]
   (phaser->clj
    (.eventNames event-emitter))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([event-emitter event]
   (phaser->clj
    (.listenerCount event-emitter
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([event-emitter event]
   (phaser->clj
    (.listeners event-emitter
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([event-emitter event]
   (phaser->clj
    (.off event-emitter
          (clj->phaser event))))
  ([event-emitter event fn]
   (phaser->clj
    (.off event-emitter
          (clj->phaser event)
          (clj->phaser fn))))
  ([event-emitter event fn context]
   (phaser->clj
    (.off event-emitter
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([event-emitter event fn context once]
   (phaser->clj
    (.off event-emitter
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([event-emitter event fn]
   (phaser->clj
    (.on event-emitter
         (clj->phaser event)
         (clj->phaser fn))))
  ([event-emitter event fn context]
   (phaser->clj
    (.on event-emitter
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([event-emitter event fn]
   (phaser->clj
    (.once event-emitter
           (clj->phaser event)
           (clj->phaser fn))))
  ([event-emitter event fn context]
   (phaser->clj
    (.once event-emitter
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([event-emitter]
   (phaser->clj
    (.removeAllListeners event-emitter)))
  ([event-emitter event]
   (phaser->clj
    (.removeAllListeners event-emitter
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * event-emitter (Phaser.Events.EventEmitter) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([event-emitter event]
   (phaser->clj
    (.removeListener event-emitter
                     (clj->phaser event))))
  ([event-emitter event fn]
   (phaser->clj
    (.removeListener event-emitter
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([event-emitter event fn context]
   (phaser->clj
    (.removeListener event-emitter
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([event-emitter event fn context once]
   (phaser->clj
    (.removeListener event-emitter
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn shutdown
  "Removes all listeners."
  ([event-emitter]
   (phaser->clj
    (.shutdown event-emitter))))