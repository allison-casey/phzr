(ns phzr.sound.web-audio-sound-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove]))

(defn ->WebAudioSoundManager
  "  Parameters:
    * game (Phaser.Game) - Reference to the current game instance."
  ([game]
   (js/Phaser.Sound.WebAudioSoundManager. (clj->phaser game))))

(defn add
  "Adds a new sound into the sound manager.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * key (string) - Asset key for the sound.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings.

  Returns:  Phaser.Sound.WebAudioSound - The new sound instance."
  ([web-audio-sound-manager key]
   (phaser->clj
    (.add web-audio-sound-manager
          (clj->phaser key))))
  ([web-audio-sound-manager key config]
   (phaser->clj
    (.add web-audio-sound-manager
          (clj->phaser key)
          (clj->phaser config)))))

(defn add-audio-sprite
  "Adds a new audio sprite sound into the sound manager.
  Audio Sprites are a combination of audio files and a JSON configuration.
  The JSON follows the format of that created by https://github.com/tonistiigi/audiosprite

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * key (string) - Asset key for the sound.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings.

  Returns:  Phaser.Sound.HTML5AudioSound | Phaser.Sound.WebAudioSound - The new audio sprite sound instance."
  ([web-audio-sound-manager key]
   (phaser->clj
    (.addAudioSprite web-audio-sound-manager
                     (clj->phaser key))))
  ([web-audio-sound-manager key config]
   (phaser->clj
    (.addAudioSprite web-audio-sound-manager
                     (clj->phaser key)
                     (clj->phaser config)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound-manager event fn]
   (phaser->clj
    (.addListener web-audio-sound-manager
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([web-audio-sound-manager event fn context]
   (phaser->clj
    (.addListener web-audio-sound-manager
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn decode-audio
  "Decode audio data into a format ready for playback via Web Audio.

  The audio data can be a base64 encoded string, an audio media-type data uri, or an ArrayBuffer instance.

  The `audioKey` is the key that will be used to save the decoded audio to the audio cache.

  Instead of passing a single entry you can instead pass an array of `Phaser.Types.Sound.DecodeAudioConfig`
  objects as the first and only argument.

  Decoding is an async process, so be sure to listen for the events to know when decoding has completed.

  Once the audio has decoded it can be added to the Sound Manager or played via its key.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * audio-key (Array.<Phaser.Types.Sound.DecodeAudioConfig> | string) {optional} - The string-based key to be used to reference the decoded audio in the audio cache, or an array of audio config objects.
    * audio-data (ArrayBuffer | string) {optional} - The audio data, either a base64 encoded string, an audio media-type data uri, or an ArrayBuffer instance."
  ([web-audio-sound-manager]
   (phaser->clj
    (.decodeAudio web-audio-sound-manager)))
  ([web-audio-sound-manager audio-key]
   (phaser->clj
    (.decodeAudio web-audio-sound-manager
                  (clj->phaser audio-key))))
  ([web-audio-sound-manager audio-key audio-data]
   (phaser->clj
    (.decodeAudio web-audio-sound-manager
                  (clj->phaser audio-key)
                  (clj->phaser audio-data)))))

(defn destroy
  "Calls Phaser.Sound.BaseSoundManager#destroy method
  and cleans up all Web Audio API related stuff."
  ([web-audio-sound-manager]
   (phaser->clj
    (.destroy web-audio-sound-manager))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([web-audio-sound-manager event]
   (phaser->clj
    (.emit web-audio-sound-manager
           (clj->phaser event))))
  ([web-audio-sound-manager event args]
   (phaser->clj
    (.emit web-audio-sound-manager
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([web-audio-sound-manager]
   (phaser->clj
    (.eventNames web-audio-sound-manager))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([web-audio-sound-manager event]
   (phaser->clj
    (.listenerCount web-audio-sound-manager
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([web-audio-sound-manager event]
   (phaser->clj
    (.listeners web-audio-sound-manager
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound-manager event]
   (phaser->clj
    (.off web-audio-sound-manager
          (clj->phaser event))))
  ([web-audio-sound-manager event fn]
   (phaser->clj
    (.off web-audio-sound-manager
          (clj->phaser event)
          (clj->phaser fn))))
  ([web-audio-sound-manager event fn context]
   (phaser->clj
    (.off web-audio-sound-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([web-audio-sound-manager event fn context once]
   (phaser->clj
    (.off web-audio-sound-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound-manager event fn]
   (phaser->clj
    (.on web-audio-sound-manager
         (clj->phaser event)
         (clj->phaser fn))))
  ([web-audio-sound-manager event fn context]
   (phaser->clj
    (.on web-audio-sound-manager
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound-manager event fn]
   (phaser->clj
    (.once web-audio-sound-manager
           (clj->phaser event)
           (clj->phaser fn))))
  ([web-audio-sound-manager event fn context]
   (phaser->clj
    (.once web-audio-sound-manager
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause-all
  "Pauses all the sounds in the game."
  ([web-audio-sound-manager]
   (phaser->clj
    (.pauseAll web-audio-sound-manager))))

(defn play
  "Enables playing sound on the fly without the need to keep a reference to it.
  Sound will auto destroy once its playback ends.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * key (string) - Asset key for the sound.
    * extra (Phaser.Types.Sound.SoundConfig | Phaser.Types.Sound.SoundMarker) {optional} - An optional additional object containing settings to be applied to the sound. It could be either config or marker object.

  Returns:  boolean - Whether the sound started playing successfully."
  ([web-audio-sound-manager key]
   (phaser->clj
    (.play web-audio-sound-manager
           (clj->phaser key))))
  ([web-audio-sound-manager key extra]
   (phaser->clj
    (.play web-audio-sound-manager
           (clj->phaser key)
           (clj->phaser extra)))))

(defn play-audio-sprite
  "Enables playing audio sprite sound on the fly without the need to keep a reference to it.
  Sound will auto destroy once its playback ends.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * key (string) - Asset key for the sound.
    * sprite-name (string) - The name of the sound sprite to play.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings.

  Returns:  boolean - Whether the audio sprite sound started playing successfully."
  ([web-audio-sound-manager key sprite-name]
   (phaser->clj
    (.playAudioSprite web-audio-sound-manager
                      (clj->phaser key)
                      (clj->phaser sprite-name))))
  ([web-audio-sound-manager key sprite-name config]
   (phaser->clj
    (.playAudioSprite web-audio-sound-manager
                      (clj->phaser key)
                      (clj->phaser sprite-name)
                      (clj->phaser config)))))

(defn remove
  "Removes a sound from the sound manager.
  The removed sound is destroyed before removal.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * sound (Phaser.Sound.BaseSound) - The sound object to remove.

  Returns:  boolean - True if the sound was removed successfully, otherwise false."
  ([web-audio-sound-manager sound]
   (phaser->clj
    (.remove web-audio-sound-manager
             (clj->phaser sound)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound-manager]
   (phaser->clj
    (.removeAllListeners web-audio-sound-manager)))
  ([web-audio-sound-manager event]
   (phaser->clj
    (.removeAllListeners web-audio-sound-manager
                         (clj->phaser event)))))

(defn remove-by-key
  "Removes all sounds from the sound manager that have an asset key matching the given value.
  The removed sounds are destroyed before removal.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * key (string) - The key to match when removing sound objects.

  Returns:  number - The number of matching sound objects that were removed."
  ([web-audio-sound-manager key]
   (phaser->clj
    (.removeByKey web-audio-sound-manager
                  (clj->phaser key)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([web-audio-sound-manager event]
   (phaser->clj
    (.removeListener web-audio-sound-manager
                     (clj->phaser event))))
  ([web-audio-sound-manager event fn]
   (phaser->clj
    (.removeListener web-audio-sound-manager
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([web-audio-sound-manager event fn context]
   (phaser->clj
    (.removeListener web-audio-sound-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([web-audio-sound-manager event fn context once]
   (phaser->clj
    (.removeListener web-audio-sound-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn resume-all
  "Resumes all the sounds in the game."
  ([web-audio-sound-manager]
   (phaser->clj
    (.resumeAll web-audio-sound-manager))))

(defn set-detune
  "Sets the global detuning of all sounds in [cents](https://en.wikipedia.org/wiki/Cent_%28music%29).
  The range of the value is -1200 to 1200, but we recommend setting it to [50](https://en.wikipedia.org/wiki/50_Cent).

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * value (number) - The range of the value is -1200 to 1200, but we recommend setting it to [50](https://en.wikipedia.org/wiki/50_Cent).

  Returns:  Phaser.Sound.BaseSoundManager - This Sound Manager."
  ([web-audio-sound-manager value]
   (phaser->clj
    (.setDetune web-audio-sound-manager
                (clj->phaser value)))))

(defn set-mute
  "Sets the muted state of all this Sound Manager.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * value (boolean) - `true` to mute all sounds, `false` to unmute them.

  Returns:  Phaser.Sound.WebAudioSoundManager - This Sound Manager."
  ([web-audio-sound-manager value]
   (phaser->clj
    (.setMute web-audio-sound-manager
              (clj->phaser value)))))

(defn set-rate
  "Sets the global playback rate at which all the sounds will be played.

  For example, a value of 1.0 plays the audio at full speed, 0.5 plays the audio at half speed
  and 2.0 doubles the audios playback speed.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * value (number) - Global playback rate at which all the sounds will be played.

  Returns:  Phaser.Sound.BaseSoundManager - This Sound Manager."
  ([web-audio-sound-manager value]
   (phaser->clj
    (.setRate web-audio-sound-manager
              (clj->phaser value)))))

(defn set-volume
  "Sets the volume of this Sound Manager.

  Parameters:
    * web-audio-sound-manager (Phaser.Sound.WebAudioSoundManager) - Targeted instance for method
    * value (number) - The global volume of this Sound Manager.

  Returns:  Phaser.Sound.WebAudioSoundManager - This Sound Manager."
  ([web-audio-sound-manager value]
   (phaser->clj
    (.setVolume web-audio-sound-manager
                (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([web-audio-sound-manager]
   (phaser->clj
    (.shutdown web-audio-sound-manager))))

(defn stop-all
  "Stops all the sounds in the game."
  ([web-audio-sound-manager]
   (phaser->clj
    (.stopAll web-audio-sound-manager))))

(defn unlock
  "Unlocks Web Audio API on the initial input event.

  Read more about how this issue is handled here in [this article](https://medium.com/@pgoloskokovic/unlocking-web-audio-the-smarter-way-8858218c0e09)."
  ([web-audio-sound-manager]
   (phaser->clj
    (.unlock web-audio-sound-manager))))