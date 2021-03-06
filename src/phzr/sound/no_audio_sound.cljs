(ns phzr.sound.no-audio-sound
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->NoAudioSound
  "  Parameters:
    * manager (Phaser.Sound.NoAudioSoundManager) - Reference to the current sound manager instance.
    * key (string) - Asset key for the sound.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings."
  ([manager key]
   (js/Phaser.Sound.NoAudioSound. (clj->phaser manager)
                                  (clj->phaser key)))
  ([manager key config]
   (js/Phaser.Sound.NoAudioSound. (clj->phaser manager)
                                  (clj->phaser key)
                                  (clj->phaser config))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([no-audio-sound event fn]
   (phaser->clj
    (.addListener no-audio-sound
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([no-audio-sound event fn context]
   (phaser->clj
    (.addListener no-audio-sound
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn add-marker
  "Adds a marker into the current sound. A marker is represented by name, start time, duration, and optionally config object.
  This allows you to bundle multiple sounds together into a single audio file and use markers to jump between them for playback.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * marker (Phaser.Types.Sound.SoundMarker) - Marker object.

  Returns:  boolean - Whether the marker was added successfully."
  ([no-audio-sound marker]
   (phaser->clj
    (.addMarker no-audio-sound
                (clj->phaser marker)))))

(defn destroy
  "Destroys this sound and all associated events and marks it for removal from the sound manager."
  ([no-audio-sound]
   (phaser->clj
    (.destroy no-audio-sound))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([no-audio-sound event]
   (phaser->clj
    (.emit no-audio-sound
           (clj->phaser event))))
  ([no-audio-sound event args]
   (phaser->clj
    (.emit no-audio-sound
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([no-audio-sound]
   (phaser->clj
    (.eventNames no-audio-sound))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([no-audio-sound event]
   (phaser->clj
    (.listenerCount no-audio-sound
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([no-audio-sound event]
   (phaser->clj
    (.listeners no-audio-sound
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([no-audio-sound event]
   (phaser->clj
    (.off no-audio-sound
          (clj->phaser event))))
  ([no-audio-sound event fn]
   (phaser->clj
    (.off no-audio-sound
          (clj->phaser event)
          (clj->phaser fn))))
  ([no-audio-sound event fn context]
   (phaser->clj
    (.off no-audio-sound
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([no-audio-sound event fn context once]
   (phaser->clj
    (.off no-audio-sound
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([no-audio-sound event fn]
   (phaser->clj
    (.on no-audio-sound
         (clj->phaser event)
         (clj->phaser fn))))
  ([no-audio-sound event fn context]
   (phaser->clj
    (.on no-audio-sound
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([no-audio-sound event fn]
   (phaser->clj
    (.once no-audio-sound
           (clj->phaser event)
           (clj->phaser fn))))
  ([no-audio-sound event fn context]
   (phaser->clj
    (.once no-audio-sound
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "Pauses the sound.

  Returns:  boolean - Whether the sound was paused successfully."
  ([no-audio-sound]
   (phaser->clj
    (.pause no-audio-sound))))

(defn play
  "Play this sound, or a marked section of it.
  It always plays the sound from the start. If you want to start playback from a specific time
  you can set 'seek' setting of the config object, provided to this call, to that value.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * marker-name (string | Phaser.Types.Sound.SoundConfig) {optional} - If you want to play a marker then provide the marker name here. Alternatively, this parameter can be a SoundConfig object.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - Optional sound config object to be applied to this marker or entire sound if no marker name is provided. It gets memorized for future plays of current section of the sound.

  Returns:  boolean - Whether the sound started playing successfully."
  ([no-audio-sound]
   (phaser->clj
    (.play no-audio-sound)))
  ([no-audio-sound marker-name]
   (phaser->clj
    (.play no-audio-sound
           (clj->phaser marker-name))))
  ([no-audio-sound marker-name config]
   (phaser->clj
    (.play no-audio-sound
           (clj->phaser marker-name)
           (clj->phaser config)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([no-audio-sound]
   (phaser->clj
    (.removeAllListeners no-audio-sound)))
  ([no-audio-sound event]
   (phaser->clj
    (.removeAllListeners no-audio-sound
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([no-audio-sound event]
   (phaser->clj
    (.removeListener no-audio-sound
                     (clj->phaser event))))
  ([no-audio-sound event fn]
   (phaser->clj
    (.removeListener no-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([no-audio-sound event fn context]
   (phaser->clj
    (.removeListener no-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([no-audio-sound event fn context once]
   (phaser->clj
    (.removeListener no-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn remove-marker
  "Removes a marker from the sound.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * marker-name (string) - The name of the marker to remove.

  Returns:  Phaser.Types.Sound.SoundMarker - Removed marker object or 'null' if there was no marker with provided name."
  ([no-audio-sound marker-name]
   (phaser->clj
    (.removeMarker no-audio-sound
                   (clj->phaser marker-name)))))

(defn resume
  "Resumes the sound.

  Returns:  boolean - Whether the sound was resumed successfully."
  ([no-audio-sound]
   (phaser->clj
    (.resume no-audio-sound))))

(defn shutdown
  "Removes all listeners."
  ([no-audio-sound]
   (phaser->clj
    (.shutdown no-audio-sound))))

(defn stop
  "Stop playing this sound.

  Returns:  boolean - Whether the sound was stopped successfully."
  ([no-audio-sound]
   (phaser->clj
    (.stop no-audio-sound))))

(defn update-marker
  "Updates previously added marker.

  Parameters:
    * no-audio-sound (Phaser.Sound.NoAudioSound) - Targeted instance for method
    * marker (Phaser.Types.Sound.SoundMarker) - Marker object with updated values.

  Returns:  boolean - Whether the marker was updated successfully."
  ([no-audio-sound marker]
   (phaser->clj
    (.updateMarker no-audio-sound
                   (clj->phaser marker)))))