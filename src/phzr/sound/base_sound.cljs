(ns phzr.sound.base-sound
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->BaseSound
  "  Parameters:
    * manager (Phaser.Sound.BaseSoundManager) - Reference to the current sound manager instance.
    * key (string) - Asset key for the sound.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings."
  ([manager key]
   (js/Phaser.Sound.BaseSound. (clj->phaser manager)
                               (clj->phaser key)))
  ([manager key config]
   (js/Phaser.Sound.BaseSound. (clj->phaser manager)
                               (clj->phaser key)
                               (clj->phaser config))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound event fn]
   (phaser->clj
    (.addListener base-sound
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([base-sound event fn context]
   (phaser->clj
    (.addListener base-sound
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn add-marker
  "Adds a marker into the current sound. A marker is represented by name, start time, duration, and optionally config object.
  This allows you to bundle multiple sounds together into a single audio file and use markers to jump between them for playback.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * marker (Phaser.Types.Sound.SoundMarker) - Marker object.

  Returns:  boolean - Whether the marker was added successfully."
  ([base-sound marker]
   (phaser->clj
    (.addMarker base-sound
                (clj->phaser marker)))))

(defn destroy
  "Destroys this sound and all associated events and marks it for removal from the sound manager."
  ([base-sound]
   (phaser->clj
    (.destroy base-sound))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([base-sound event]
   (phaser->clj
    (.emit base-sound
           (clj->phaser event))))
  ([base-sound event args]
   (phaser->clj
    (.emit base-sound
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([base-sound]
   (phaser->clj
    (.eventNames base-sound))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([base-sound event]
   (phaser->clj
    (.listenerCount base-sound
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([base-sound event]
   (phaser->clj
    (.listeners base-sound
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound event]
   (phaser->clj
    (.off base-sound
          (clj->phaser event))))
  ([base-sound event fn]
   (phaser->clj
    (.off base-sound
          (clj->phaser event)
          (clj->phaser fn))))
  ([base-sound event fn context]
   (phaser->clj
    (.off base-sound
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([base-sound event fn context once]
   (phaser->clj
    (.off base-sound
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound event fn]
   (phaser->clj
    (.on base-sound
         (clj->phaser event)
         (clj->phaser fn))))
  ([base-sound event fn context]
   (phaser->clj
    (.on base-sound
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound event fn]
   (phaser->clj
    (.once base-sound
           (clj->phaser event)
           (clj->phaser fn))))
  ([base-sound event fn context]
   (phaser->clj
    (.once base-sound
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "Pauses the sound.

  Returns:  boolean - Whether the sound was paused successfully."
  ([base-sound]
   (phaser->clj
    (.pause base-sound))))

(defn play
  "Play this sound, or a marked section of it.
  It always plays the sound from the start. If you want to start playback from a specific time
  you can set 'seek' setting of the config object, provided to this call, to that value.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * marker-name (string | Phaser.Types.Sound.SoundConfig) {optional} - If you want to play a marker then provide the marker name here. Alternatively, this parameter can be a SoundConfig object.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - Optional sound config object to be applied to this marker or entire sound if no marker name is provided. It gets memorized for future plays of current section of the sound.

  Returns:  boolean - Whether the sound started playing successfully."
  ([base-sound]
   (phaser->clj
    (.play base-sound)))
  ([base-sound marker-name]
   (phaser->clj
    (.play base-sound
           (clj->phaser marker-name))))
  ([base-sound marker-name config]
   (phaser->clj
    (.play base-sound
           (clj->phaser marker-name)
           (clj->phaser config)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound]
   (phaser->clj
    (.removeAllListeners base-sound)))
  ([base-sound event]
   (phaser->clj
    (.removeAllListeners base-sound
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound event]
   (phaser->clj
    (.removeListener base-sound
                     (clj->phaser event))))
  ([base-sound event fn]
   (phaser->clj
    (.removeListener base-sound
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([base-sound event fn context]
   (phaser->clj
    (.removeListener base-sound
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([base-sound event fn context once]
   (phaser->clj
    (.removeListener base-sound
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn remove-marker
  "Removes a marker from the sound.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * marker-name (string) - The name of the marker to remove.

  Returns:  Phaser.Types.Sound.SoundMarker - Removed marker object or 'null' if there was no marker with provided name."
  ([base-sound marker-name]
   (phaser->clj
    (.removeMarker base-sound
                   (clj->phaser marker-name)))))

(defn resume
  "Resumes the sound.

  Returns:  boolean - Whether the sound was resumed successfully."
  ([base-sound]
   (phaser->clj
    (.resume base-sound))))

(defn shutdown
  "Removes all listeners."
  ([base-sound]
   (phaser->clj
    (.shutdown base-sound))))

(defn stop
  "Stop playing this sound.

  Returns:  boolean - Whether the sound was stopped successfully."
  ([base-sound]
   (phaser->clj
    (.stop base-sound))))

(defn update-marker
  "Updates previously added marker.

  Parameters:
    * base-sound (Phaser.Sound.BaseSound) - Targeted instance for method
    * marker (Phaser.Types.Sound.SoundMarker) - Marker object with updated values.

  Returns:  boolean - Whether the marker was updated successfully."
  ([base-sound marker]
   (phaser->clj
    (.updateMarker base-sound
                   (clj->phaser marker)))))