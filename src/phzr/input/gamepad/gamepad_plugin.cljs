(ns phzr.input.gamepad.gamepad-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->GamepadPlugin
  "  Parameters:
    * scene-input-plugin (Phaser.Input.InputPlugin) - A reference to the Scene Input Plugin that the KeyboardPlugin belongs to."
  ([scene-input-plugin]
   (js/Phaser.Input.Gamepad.GamepadPlugin. (clj->phaser scene-input-plugin))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad-plugin event fn]
   (phaser->clj
    (.addListener gamepad-plugin
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([gamepad-plugin event fn context]
   (phaser->clj
    (.addListener gamepad-plugin
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn disconnect-all
  "Disconnects all current Gamepads."
  ([gamepad-plugin]
   (phaser->clj
    (.disconnectAll gamepad-plugin))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([gamepad-plugin event]
   (phaser->clj
    (.emit gamepad-plugin
           (clj->phaser event))))
  ([gamepad-plugin event args]
   (phaser->clj
    (.emit gamepad-plugin
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([gamepad-plugin]
   (phaser->clj
    (.eventNames gamepad-plugin))))

(defn get-all
  "Returns an array of all currently connected Gamepads.

  Returns:  Array.<Phaser.Input.Gamepad.Gamepad> - An array of all currently connected Gamepads."
  ([gamepad-plugin]
   (phaser->clj
    (.getAll gamepad-plugin))))

(defn get-pad
  "Looks-up a single Gamepad based on the given index value.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * index (number) - The index of the Gamepad to get.

  Returns:  Phaser.Input.Gamepad.Gamepad - The Gamepad matching the given index, or undefined if none were found."
  ([gamepad-plugin index]
   (phaser->clj
    (.getPad gamepad-plugin
             (clj->phaser index)))))

(defn is-active
  "Checks to see if both this plugin and the Scene to which it belongs is active.

  Returns:  boolean - `true` if the plugin and the Scene it belongs to is active."
  ([gamepad-plugin]
   (phaser->clj
    (.isActive gamepad-plugin))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([gamepad-plugin event]
   (phaser->clj
    (.listenerCount gamepad-plugin
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([gamepad-plugin event]
   (phaser->clj
    (.listeners gamepad-plugin
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad-plugin event]
   (phaser->clj
    (.off gamepad-plugin
          (clj->phaser event))))
  ([gamepad-plugin event fn]
   (phaser->clj
    (.off gamepad-plugin
          (clj->phaser event)
          (clj->phaser fn))))
  ([gamepad-plugin event fn context]
   (phaser->clj
    (.off gamepad-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([gamepad-plugin event fn context once]
   (phaser->clj
    (.off gamepad-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad-plugin event fn]
   (phaser->clj
    (.on gamepad-plugin
         (clj->phaser event)
         (clj->phaser fn))))
  ([gamepad-plugin event fn context]
   (phaser->clj
    (.on gamepad-plugin
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad-plugin event fn]
   (phaser->clj
    (.once gamepad-plugin
           (clj->phaser event)
           (clj->phaser fn))))
  ([gamepad-plugin event fn context]
   (phaser->clj
    (.once gamepad-plugin
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad-plugin]
   (phaser->clj
    (.removeAllListeners gamepad-plugin)))
  ([gamepad-plugin event]
   (phaser->clj
    (.removeAllListeners gamepad-plugin
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * gamepad-plugin (Phaser.Input.Gamepad.GamepadPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad-plugin event]
   (phaser->clj
    (.removeListener gamepad-plugin
                     (clj->phaser event))))
  ([gamepad-plugin event fn]
   (phaser->clj
    (.removeListener gamepad-plugin
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([gamepad-plugin event fn context]
   (phaser->clj
    (.removeListener gamepad-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([gamepad-plugin event fn context once]
   (phaser->clj
    (.removeListener gamepad-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))