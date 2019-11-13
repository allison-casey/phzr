(ns phzr.sound.html-5-audio-sound
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->HTML5AudioSound
  "  Parameters:
    * manager (Phaser.Sound.HTML5AudioSoundManager) - Reference to the current sound manager instance.
    * key (string) - Asset key for the sound.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings."
  ([manager key]
   (js/Phaser.Sound.HTML5AudioSound. (clj->phaser manager)
                                     (clj->phaser key)))
  ([manager key config]
   (js/Phaser.Sound.HTML5AudioSound. (clj->phaser manager)
                                     (clj->phaser key)
                                     (clj->phaser config))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([html-5-audio-sound event fn]
   (phaser->clj
    (.addListener html-5-audio-sound
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([html-5-audio-sound event fn context]
   (phaser->clj
    (.addListener html-5-audio-sound
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn add-marker
  "Adds a marker into the current sound. A marker is represented by name, start time, duration, and optionally config object.
  This allows you to bundle multiple sounds together into a single audio file and use markers to jump between them for playback.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * marker (Phaser.Types.Sound.SoundMarker) - Marker object.

  Returns:  boolean - Whether the marker was added successfully."
  ([html-5-audio-sound marker]
   (phaser->clj
    (.addMarker html-5-audio-sound
                (clj->phaser marker)))))

(defn destroy
  "Calls Phaser.Sound.BaseSound#destroy method
  and cleans up all HTML5 Audio related stuff."
  ([html-5-audio-sound]
   (phaser->clj
    (.destroy html-5-audio-sound))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([html-5-audio-sound event]
   (phaser->clj
    (.emit html-5-audio-sound
           (clj->phaser event))))
  ([html-5-audio-sound event args]
   (phaser->clj
    (.emit html-5-audio-sound
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([html-5-audio-sound]
   (phaser->clj
    (.eventNames html-5-audio-sound))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([html-5-audio-sound event]
   (phaser->clj
    (.listenerCount html-5-audio-sound
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([html-5-audio-sound event]
   (phaser->clj
    (.listeners html-5-audio-sound
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([html-5-audio-sound event]
   (phaser->clj
    (.off html-5-audio-sound
          (clj->phaser event))))
  ([html-5-audio-sound event fn]
   (phaser->clj
    (.off html-5-audio-sound
          (clj->phaser event)
          (clj->phaser fn))))
  ([html-5-audio-sound event fn context]
   (phaser->clj
    (.off html-5-audio-sound
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([html-5-audio-sound event fn context once]
   (phaser->clj
    (.off html-5-audio-sound
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([html-5-audio-sound event fn]
   (phaser->clj
    (.on html-5-audio-sound
         (clj->phaser event)
         (clj->phaser fn))))
  ([html-5-audio-sound event fn context]
   (phaser->clj
    (.on html-5-audio-sound
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([html-5-audio-sound event fn]
   (phaser->clj
    (.once html-5-audio-sound
           (clj->phaser event)
           (clj->phaser fn))))
  ([html-5-audio-sound event fn context]
   (phaser->clj
    (.once html-5-audio-sound
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "Pauses the sound.

  Returns:  boolean - Whether the sound was paused successfully."
  ([html-5-audio-sound]
   (phaser->clj
    (.pause html-5-audio-sound))))

(defn play
  "Play this sound, or a marked section of it.
  It always plays the sound from the start. If you want to start playback from a specific time
  you can set 'seek' setting of the config object, provided to this call, to that value.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * marker-name (string | Phaser.Types.Sound.SoundConfig) {optional} - If you want to play a marker then provide the marker name here. Alternatively, this parameter can be a SoundConfig object.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - Optional sound config object to be applied to this marker or entire sound if no marker name is provided. It gets memorized for future plays of current section of the sound.

  Returns:  boolean - Whether the sound started playing successfully."
  ([html-5-audio-sound]
   (phaser->clj
    (.play html-5-audio-sound)))
  ([html-5-audio-sound marker-name]
   (phaser->clj
    (.play html-5-audio-sound
           (clj->phaser marker-name))))
  ([html-5-audio-sound marker-name config]
   (phaser->clj
    (.play html-5-audio-sound
           (clj->phaser marker-name)
           (clj->phaser config)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([html-5-audio-sound]
   (phaser->clj
    (.removeAllListeners html-5-audio-sound)))
  ([html-5-audio-sound event]
   (phaser->clj
    (.removeAllListeners html-5-audio-sound
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([html-5-audio-sound event]
   (phaser->clj
    (.removeListener html-5-audio-sound
                     (clj->phaser event))))
  ([html-5-audio-sound event fn]
   (phaser->clj
    (.removeListener html-5-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([html-5-audio-sound event fn context]
   (phaser->clj
    (.removeListener html-5-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([html-5-audio-sound event fn context once]
   (phaser->clj
    (.removeListener html-5-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn remove-marker
  "Removes a marker from the sound.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * marker-name (string) - The name of the marker to remove.

  Returns:  Phaser.Types.Sound.SoundMarker - Removed marker object or 'null' if there was no marker with provided name."
  ([html-5-audio-sound marker-name]
   (phaser->clj
    (.removeMarker html-5-audio-sound
                   (clj->phaser marker-name)))))

(defn resume
  "Resumes the sound.

  Returns:  boolean - Whether the sound was resumed successfully."
  ([html-5-audio-sound]
   (phaser->clj
    (.resume html-5-audio-sound))))

(defn set-detune
  "Sets the detune value of this Sound, given in [cents](https://en.wikipedia.org/wiki/Cent_%28music%29).
  The range of the value is -1200 to 1200, but we recommend setting it to [50](https://en.wikipedia.org/wiki/50_Cent).

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * value (number) - The range of the value is -1200 to 1200, but we recommend setting it to [50](https://en.wikipedia.org/wiki/50_Cent).

  Returns:  Phaser.Sound.HTML5AudioSound - This Sound."
  ([html-5-audio-sound value]
   (phaser->clj
    (.setDetune html-5-audio-sound
                (clj->phaser value)))))

(defn set-loop
  "Sets the loop state of this Sound.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * value (boolean) - `true` to loop this sound, `false` to not loop it.

  Returns:  Phaser.Sound.HTML5AudioSound - This Sound instance."
  ([html-5-audio-sound value]
   (phaser->clj
    (.setLoop html-5-audio-sound
              (clj->phaser value)))))

(defn set-mute
  "Sets the muted state of this Sound.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * value (boolean) - `true` to mute this sound, `false` to unmute it.

  Returns:  Phaser.Sound.HTML5AudioSound - This Sound instance."
  ([html-5-audio-sound value]
   (phaser->clj
    (.setMute html-5-audio-sound
              (clj->phaser value)))))

(defn set-rate
  "Sets the playback rate of this Sound.

  For example, a value of 1.0 plays the audio at full speed, 0.5 plays the audio at half speed
  and 2.0 doubles the audios playback speed.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * value (number) - The playback rate at of this Sound.

  Returns:  Phaser.Sound.HTML5AudioSound - This Sound."
  ([html-5-audio-sound value]
   (phaser->clj
    (.setRate html-5-audio-sound
              (clj->phaser value)))))

(defn set-seek
  "Seeks to a specific point in this sound.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * value (number) - The point in the sound to seek to.

  Returns:  Phaser.Sound.HTML5AudioSound - This Sound instance."
  ([html-5-audio-sound value]
   (phaser->clj
    (.setSeek html-5-audio-sound
              (clj->phaser value)))))

(defn set-volume
  "Sets the volume of this Sound.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * value (number) - The volume of the sound.

  Returns:  Phaser.Sound.HTML5AudioSound - This Sound instance."
  ([html-5-audio-sound value]
   (phaser->clj
    (.setVolume html-5-audio-sound
                (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([html-5-audio-sound]
   (phaser->clj
    (.shutdown html-5-audio-sound))))

(defn stop
  "Stop playing this sound.

  Returns:  boolean - Whether the sound was stopped successfully."
  ([html-5-audio-sound]
   (phaser->clj
    (.stop html-5-audio-sound))))

(defn update-marker
  "Updates previously added marker.

  Parameters:
    * html-5-audio-sound (Phaser.Sound.HTML5AudioSound) - Targeted instance for method
    * marker (Phaser.Types.Sound.SoundMarker) - Marker object with updated values.

  Returns:  boolean - Whether the marker was updated successfully."
  ([html-5-audio-sound marker]
   (phaser->clj
    (.updateMarker html-5-audio-sound
                   (clj->phaser marker)))))