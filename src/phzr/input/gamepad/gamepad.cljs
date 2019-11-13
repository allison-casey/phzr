(ns phzr.input.gamepad.gamepad
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Gamepad
  "  Parameters:
    * manager (Phaser.Input.Gamepad.GamepadPlugin) - A reference to the Gamepad Plugin.
    * pad (Phaser.Types.Input.Gamepad.Pad) - The Gamepad object, as extracted from GamepadEvent."
  ([manager pad]
   (js/Phaser.Input.Gamepad.Gamepad. (clj->phaser manager)
                                     (clj->phaser pad))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad event fn]
   (phaser->clj
    (.addListener gamepad
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([gamepad event fn context]
   (phaser->clj
    (.addListener gamepad
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn destroy
  "Destroys this Gamepad instance, its buttons and axes, and releases external references it holds."
  ([gamepad]
   (phaser->clj
    (.destroy gamepad))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([gamepad event]
   (phaser->clj
    (.emit gamepad
           (clj->phaser event))))
  ([gamepad event args]
   (phaser->clj
    (.emit gamepad
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([gamepad]
   (phaser->clj
    (.eventNames gamepad))))

(defn get-axis-total
  "Gets the total number of axis this Gamepad claims to support.

  Returns:  integer - The total number of axes this Gamepad claims to support."
  ([gamepad]
   (phaser->clj
    (.getAxisTotal gamepad))))

(defn get-axis-value
  "Gets the value of an axis based on the given index.
  The index must be valid within the range of axes supported by this Gamepad.
  The return value will be a float between 0 and 1.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * index (integer) - The index of the axes to get the value for.

  Returns:  number - The value of the axis, between 0 and 1."
  ([gamepad index]
   (phaser->clj
    (.getAxisValue gamepad
                   (clj->phaser index)))))

(defn get-button-total
  "Gets the total number of buttons this Gamepad claims to have.

  Returns:  integer - The total number of buttons this Gamepad claims to have."
  ([gamepad]
   (phaser->clj
    (.getButtonTotal gamepad))))

(defn get-button-value
  "Gets the value of a button based on the given index.
  The index must be valid within the range of buttons supported by this Gamepad.

  The return value will be either 0 or 1 for an analogue button, or a float between 0 and 1
  for a pressure-sensitive digital button, such as the shoulder buttons on a Dual Shock.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * index (integer) - The index of the button to get the value for.

  Returns:  number - The value of the button, between 0 and 1."
  ([gamepad index]
   (phaser->clj
    (.getButtonValue gamepad
                     (clj->phaser index)))))

(defn is-button-down
  "Returns if the button is pressed down or not.
  The index must be valid within the range of buttons supported by this Gamepad.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * index (integer) - The index of the button to get the value for.

  Returns:  boolean - `true` if the button is considered as being pressed down, otherwise `false`."
  ([gamepad index]
   (phaser->clj
    (.isButtonDown gamepad
                   (clj->phaser index)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([gamepad event]
   (phaser->clj
    (.listenerCount gamepad
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([gamepad event]
   (phaser->clj
    (.listeners gamepad
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad event]
   (phaser->clj
    (.off gamepad
          (clj->phaser event))))
  ([gamepad event fn]
   (phaser->clj
    (.off gamepad
          (clj->phaser event)
          (clj->phaser fn))))
  ([gamepad event fn context]
   (phaser->clj
    (.off gamepad
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([gamepad event fn context once]
   (phaser->clj
    (.off gamepad
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad event fn]
   (phaser->clj
    (.on gamepad
         (clj->phaser event)
         (clj->phaser fn))))
  ([gamepad event fn context]
   (phaser->clj
    (.on gamepad
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad event fn]
   (phaser->clj
    (.once gamepad
           (clj->phaser event)
           (clj->phaser fn))))
  ([gamepad event fn context]
   (phaser->clj
    (.once gamepad
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad]
   (phaser->clj
    (.removeAllListeners gamepad)))
  ([gamepad event]
   (phaser->clj
    (.removeAllListeners gamepad
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([gamepad event]
   (phaser->clj
    (.removeListener gamepad
                     (clj->phaser event))))
  ([gamepad event fn]
   (phaser->clj
    (.removeListener gamepad
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([gamepad event fn context]
   (phaser->clj
    (.removeListener gamepad
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([gamepad event fn context once]
   (phaser->clj
    (.removeListener gamepad
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn set-axis-threshold
  "Sets the threshold value of all axis on this Gamepad.
  The value is a float between 0 and 1 and is the amount below which the axis is considered as not having been moved.

  Parameters:
    * gamepad (Phaser.Input.Gamepad.Gamepad) - Targeted instance for method
    * value (number) - A value between 0 and 1."
  ([gamepad value]
   (phaser->clj
    (.setAxisThreshold gamepad
                       (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([gamepad]
   (phaser->clj
    (.shutdown gamepad))))