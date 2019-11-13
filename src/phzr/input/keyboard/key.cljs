(ns phzr.input.keyboard.key
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Key
  "  Parameters:
    * plugin (Phaser.Input.Keyboard.KeyboardPlugin) - The Keyboard Plugin instance that owns this Key object.
    * key-code (integer) - The keycode of this key."
  ([plugin key-code]
   (js/Phaser.Input.Keyboard.Key. (clj->phaser plugin)
                                  (clj->phaser key-code))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([key event fn]
   (phaser->clj
    (.addListener key
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([key event fn context]
   (phaser->clj
    (.addListener key
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn destroy
  "Removes any bound event handlers and removes local references."
  ([key]
   (phaser->clj
    (.destroy key))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([key event]
   (phaser->clj
    (.emit key
           (clj->phaser event))))
  ([key event args]
   (phaser->clj
    (.emit key
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([key]
   (phaser->clj
    (.eventNames key))))

(defn get-duration
  "Returns the duration, in ms, that the Key has been held down for.

  If the key is not currently down it will return zero.

  The get the duration the Key was held down for in the previous up-down cycle,
  use the `Key.duration` property value instead.

  Returns:  number - The duration, in ms, that the Key has been held down for if currently down."
  ([key]
   (phaser->clj
    (.getDuration key))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([key event]
   (phaser->clj
    (.listenerCount key
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([key event]
   (phaser->clj
    (.listeners key
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([key event]
   (phaser->clj
    (.off key
          (clj->phaser event))))
  ([key event fn]
   (phaser->clj
    (.off key
          (clj->phaser event)
          (clj->phaser fn))))
  ([key event fn context]
   (phaser->clj
    (.off key
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([key event fn context once]
   (phaser->clj
    (.off key
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([key event fn]
   (phaser->clj
    (.on key
         (clj->phaser event)
         (clj->phaser fn))))
  ([key event fn context]
   (phaser->clj
    (.on key
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn on-down
  "Processes the Key Down action for this Key.
  Called automatically by the Keyboard Plugin.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (KeyboardEvent) - The native DOM Keyboard event."
  ([key event]
   (phaser->clj
    (.onDown key
             (clj->phaser event)))))

(defn on-up
  "Processes the Key Up action for this Key.
  Called automatically by the Keyboard Plugin.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (KeyboardEvent) - The native DOM Keyboard event."
  ([key event]
   (phaser->clj
    (.onUp key
           (clj->phaser event)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([key event fn]
   (phaser->clj
    (.once key
           (clj->phaser event)
           (clj->phaser fn))))
  ([key event fn context]
   (phaser->clj
    (.once key
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([key]
   (phaser->clj
    (.removeAllListeners key)))
  ([key event]
   (phaser->clj
    (.removeAllListeners key
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([key event]
   (phaser->clj
    (.removeListener key
                     (clj->phaser event))))
  ([key event fn]
   (phaser->clj
    (.removeListener key
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([key event fn context]
   (phaser->clj
    (.removeListener key
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([key event fn context once]
   (phaser->clj
    (.removeListener key
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset
  "Resets this Key object back to its default un-pressed state.

  Returns:  Phaser.Input.Keyboard.Key - This Key instance."
  ([key]
   (phaser->clj
    (.reset key))))

(defn set-emit-on-repeat
  "Controls if this Key will continuously emit a `down` event while being held down (true),
  or emit the event just once, on first press, and then skip future events (false).

  Parameters:
    * key (Phaser.Input.Keyboard.Key) - Targeted instance for method
    * value (boolean) - Emit `down` events on repeated key down actions, or just once?

  Returns:  Phaser.Input.Keyboard.Key - This Key instance."
  ([key value]
   (phaser->clj
    (.setEmitOnRepeat key
                      (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([key]
   (phaser->clj
    (.shutdown key))))