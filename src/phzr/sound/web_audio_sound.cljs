(ns phzr.sound.web-audio-sound
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->WebAudioSound
  "  Parameters:
    * manager (Phaser.Sound.WebAudioSoundManager) - Reference to the current sound manager instance.
    * key (string) - Asset key for the sound.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings."
  ([manager key]
   (js/Phaser.Sound.WebAudioSound. (clj->phaser manager)
                                   (clj->phaser key)))
  ([manager key config]
   (js/Phaser.Sound.WebAudioSound. (clj->phaser manager)
                                   (clj->phaser key)
                                   (clj->phaser config))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound event fn]
   (phaser->clj
    (.addListener web-audio-sound
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([web-audio-sound event fn context]
   (phaser->clj
    (.addListener web-audio-sound
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn add-marker
  "Adds a marker into the current sound. A marker is represented by name, start time, duration, and optionally config object.
  This allows you to bundle multiple sounds together into a single audio file and use markers to jump between them for playback.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * marker (Phaser.Types.Sound.SoundMarker) - Marker object.

  Returns:  boolean - Whether the marker was added successfully."
  ([web-audio-sound marker]
   (phaser->clj
    (.addMarker web-audio-sound
                (clj->phaser marker)))))

(defn destroy
  "Calls Phaser.Sound.BaseSound#destroy method
  and cleans up all Web Audio API related stuff."
  ([web-audio-sound]
   (phaser->clj
    (.destroy web-audio-sound))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([web-audio-sound event]
   (phaser->clj
    (.emit web-audio-sound
           (clj->phaser event))))
  ([web-audio-sound event args]
   (phaser->clj
    (.emit web-audio-sound
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([web-audio-sound]
   (phaser->clj
    (.eventNames web-audio-sound))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([web-audio-sound event]
   (phaser->clj
    (.listenerCount web-audio-sound
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([web-audio-sound event]
   (phaser->clj
    (.listeners web-audio-sound
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound event]
   (phaser->clj
    (.off web-audio-sound
          (clj->phaser event))))
  ([web-audio-sound event fn]
   (phaser->clj
    (.off web-audio-sound
          (clj->phaser event)
          (clj->phaser fn))))
  ([web-audio-sound event fn context]
   (phaser->clj
    (.off web-audio-sound
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([web-audio-sound event fn context once]
   (phaser->clj
    (.off web-audio-sound
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound event fn]
   (phaser->clj
    (.on web-audio-sound
         (clj->phaser event)
         (clj->phaser fn))))
  ([web-audio-sound event fn context]
   (phaser->clj
    (.on web-audio-sound
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound event fn]
   (phaser->clj
    (.once web-audio-sound
           (clj->phaser event)
           (clj->phaser fn))))
  ([web-audio-sound event fn context]
   (phaser->clj
    (.once web-audio-sound
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause
  "Pauses the sound.

  Returns:  boolean - Whether the sound was paused successfully."
  ([web-audio-sound]
   (phaser->clj
    (.pause web-audio-sound))))

(defn play
  "Play this sound, or a marked section of it.

  It always plays the sound from the start. If you want to start playback from a specific time
  you can set 'seek' setting of the config object, provided to this call, to that value.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * marker-name (string | Phaser.Types.Sound.SoundConfig) {optional} - If you want to play a marker then provide the marker name here. Alternatively, this parameter can be a SoundConfig object.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - Optional sound config object to be applied to this marker or entire sound if no marker name is provided. It gets memorized for future plays of current section of the sound.

  Returns:  boolean - Whether the sound started playing successfully."
  ([web-audio-sound]
   (phaser->clj
    (.play web-audio-sound)))
  ([web-audio-sound marker-name]
   (phaser->clj
    (.play web-audio-sound
           (clj->phaser marker-name))))
  ([web-audio-sound marker-name config]
   (phaser->clj
    (.play web-audio-sound
           (clj->phaser marker-name)
           (clj->phaser config)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound]
   (phaser->clj
    (.removeAllListeners web-audio-sound)))
  ([web-audio-sound event]
   (phaser->clj
    (.removeAllListeners web-audio-sound
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound event]
   (phaser->clj
    (.removeListener web-audio-sound
                     (clj->phaser event))))
  ([web-audio-sound event fn]
   (phaser->clj
    (.removeListener web-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([web-audio-sound event fn context]
   (phaser->clj
    (.removeListener web-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([web-audio-sound event fn context once]
   (phaser->clj
    (.removeListener web-audio-sound
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn remove-marker
  "Removes a marker from the sound.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * marker-name (string) - The name of the marker to remove.

  Returns:  Phaser.Types.Sound.SoundMarker - Removed marker object or 'null' if there was no marker with provided name."
  ([web-audio-sound marker-name]
   (phaser->clj
    (.removeMarker web-audio-sound
                   (clj->phaser marker-name)))))

(defn resume
  "Resumes the sound.

  Returns:  boolean - Whether the sound was resumed successfully."
  ([web-audio-sound]
   (phaser->clj
    (.resume web-audio-sound))))

(defn set-detune
  "Sets the detune value of this Sound, given in [cents](https://en.wikipedia.org/wiki/Cent_%28music%29).
  The range of the value is -1200 to 1200, but we recommend setting it to [50](https://en.wikipedia.org/wiki/50_Cent).

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * value (number) - The range of the value is -1200 to 1200, but we recommend setting it to [50](https://en.wikipedia.org/wiki/50_Cent).

  Returns:  Phaser.Sound.WebAudioSound - This Sound."
  ([web-audio-sound value]
   (phaser->clj
    (.setDetune web-audio-sound
                (clj->phaser value)))))

(defn set-loop
  "Sets the loop state of this Sound.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * value (boolean) - `true` to loop this sound, `false` to not loop it.

  Returns:  Phaser.Sound.WebAudioSound - This Sound instance."
  ([web-audio-sound value]
   (phaser->clj
    (.setLoop web-audio-sound
              (clj->phaser value)))))

(defn set-mute
  "Sets the muted state of this Sound.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * value (boolean) - `true` to mute this sound, `false` to unmute it.

  Returns:  Phaser.Sound.WebAudioSound - This Sound instance."
  ([web-audio-sound value]
   (phaser->clj
    (.setMute web-audio-sound
              (clj->phaser value)))))

(defn set-rate
  "Sets the playback rate of this Sound.

  For example, a value of 1.0 plays the audio at full speed, 0.5 plays the audio at half speed
  and 2.0 doubles the audios playback speed.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * value (number) - The playback rate at of this Sound.

  Returns:  Phaser.Sound.WebAudioSound - This Sound."
  ([web-audio-sound value]
   (phaser->clj
    (.setRate web-audio-sound
              (clj->phaser value)))))

(defn set-seek
  "Seeks to a specific point in this sound.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * value (number) - The point in the sound to seek to.

  Returns:  Phaser.Sound.WebAudioSound - This Sound instance."
  ([web-audio-sound value]
   (phaser->clj
    (.setSeek web-audio-sound
              (clj->phaser value)))))

(defn set-volume
  "Sets the volume of this Sound.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * value (number) - The volume of the sound.

  Returns:  Phaser.Sound.WebAudioSound - This Sound instance."
  ([web-audio-sound value]
   (phaser->clj
    (.setVolume web-audio-sound
                (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([web-audio-sound]
   (phaser->clj
    (.shutdown web-audio-sound))))

(defn stop
  "Stop playing this sound.

  Returns:  boolean - Whether the sound was stopped successfully."
  ([web-audio-sound]
   (phaser->clj
    (.stop web-audio-sound))))

(defn update-marker
  "Updates previously added marker.

  Parameters:
    * web-audio-sound (Phaser.Sound.WebAudioSound) - Targeted instance for method
    * marker (Phaser.Types.Sound.SoundMarker) - Marker object with updated values.

  Returns:  boolean - Whether the marker was updated successfully."
  ([web-audio-sound marker]
   (phaser->clj
    (.updateMarker web-audio-sound
                   (clj->phaser marker)))))