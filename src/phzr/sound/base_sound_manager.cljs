(ns phzr.sound.base-sound-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove]))

(defn ->BaseSoundManager
  "  Parameters:
    * game (Phaser.Game) - Reference to the current game instance."
  ([game]
   (js/Phaser.Sound.BaseSoundManager. (clj->phaser game))))

(defn add
  "Adds a new sound into the sound manager.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * key (string) - Asset key for the sound.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings.

  Returns:  Phaser.Sound.BaseSound - The new sound instance."
  ([base-sound-manager key]
   (phaser->clj
    (.add base-sound-manager
          (clj->phaser key))))
  ([base-sound-manager key config]
   (phaser->clj
    (.add base-sound-manager
          (clj->phaser key)
          (clj->phaser config)))))

(defn add-audio-sprite
  "Adds a new audio sprite sound into the sound manager.
  Audio Sprites are a combination of audio files and a JSON configuration.
  The JSON follows the format of that created by https://github.com/tonistiigi/audiosprite

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * key (string) - Asset key for the sound.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings.

  Returns:  Phaser.Sound.HTML5AudioSound | Phaser.Sound.WebAudioSound - The new audio sprite sound instance."
  ([base-sound-manager key]
   (phaser->clj
    (.addAudioSprite base-sound-manager
                     (clj->phaser key))))
  ([base-sound-manager key config]
   (phaser->clj
    (.addAudioSprite base-sound-manager
                     (clj->phaser key)
                     (clj->phaser config)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound-manager event fn]
   (phaser->clj
    (.addListener base-sound-manager
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([base-sound-manager event fn context]
   (phaser->clj
    (.addListener base-sound-manager
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn destroy
  "Destroys all the sounds in the game and all associated events."
  ([base-sound-manager]
   (phaser->clj
    (.destroy base-sound-manager))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([base-sound-manager event]
   (phaser->clj
    (.emit base-sound-manager
           (clj->phaser event))))
  ([base-sound-manager event args]
   (phaser->clj
    (.emit base-sound-manager
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([base-sound-manager]
   (phaser->clj
    (.eventNames base-sound-manager))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([base-sound-manager event]
   (phaser->clj
    (.listenerCount base-sound-manager
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([base-sound-manager event]
   (phaser->clj
    (.listeners base-sound-manager
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound-manager event]
   (phaser->clj
    (.off base-sound-manager
          (clj->phaser event))))
  ([base-sound-manager event fn]
   (phaser->clj
    (.off base-sound-manager
          (clj->phaser event)
          (clj->phaser fn))))
  ([base-sound-manager event fn context]
   (phaser->clj
    (.off base-sound-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([base-sound-manager event fn context once]
   (phaser->clj
    (.off base-sound-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound-manager event fn]
   (phaser->clj
    (.on base-sound-manager
         (clj->phaser event)
         (clj->phaser fn))))
  ([base-sound-manager event fn context]
   (phaser->clj
    (.on base-sound-manager
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound-manager event fn]
   (phaser->clj
    (.once base-sound-manager
           (clj->phaser event)
           (clj->phaser fn))))
  ([base-sound-manager event fn context]
   (phaser->clj
    (.once base-sound-manager
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pause-all
  "Pauses all the sounds in the game."
  ([base-sound-manager]
   (phaser->clj
    (.pauseAll base-sound-manager))))

(defn play
  "Enables playing sound on the fly without the need to keep a reference to it.
  Sound will auto destroy once its playback ends.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * key (string) - Asset key for the sound.
    * extra (Phaser.Types.Sound.SoundConfig | Phaser.Types.Sound.SoundMarker) {optional} - An optional additional object containing settings to be applied to the sound. It could be either config or marker object.

  Returns:  boolean - Whether the sound started playing successfully."
  ([base-sound-manager key]
   (phaser->clj
    (.play base-sound-manager
           (clj->phaser key))))
  ([base-sound-manager key extra]
   (phaser->clj
    (.play base-sound-manager
           (clj->phaser key)
           (clj->phaser extra)))))

(defn play-audio-sprite
  "Enables playing audio sprite sound on the fly without the need to keep a reference to it.
  Sound will auto destroy once its playback ends.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * key (string) - Asset key for the sound.
    * sprite-name (string) - The name of the sound sprite to play.
    * config (Phaser.Types.Sound.SoundConfig) {optional} - An optional config object containing default sound settings.

  Returns:  boolean - Whether the audio sprite sound started playing successfully."
  ([base-sound-manager key sprite-name]
   (phaser->clj
    (.playAudioSprite base-sound-manager
                      (clj->phaser key)
                      (clj->phaser sprite-name))))
  ([base-sound-manager key sprite-name config]
   (phaser->clj
    (.playAudioSprite base-sound-manager
                      (clj->phaser key)
                      (clj->phaser sprite-name)
                      (clj->phaser config)))))

(defn remove
  "Removes a sound from the sound manager.
  The removed sound is destroyed before removal.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * sound (Phaser.Sound.BaseSound) - The sound object to remove.

  Returns:  boolean - True if the sound was removed successfully, otherwise false."
  ([base-sound-manager sound]
   (phaser->clj
    (.remove base-sound-manager
             (clj->phaser sound)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound-manager]
   (phaser->clj
    (.removeAllListeners base-sound-manager)))
  ([base-sound-manager event]
   (phaser->clj
    (.removeAllListeners base-sound-manager
                         (clj->phaser event)))))

(defn remove-by-key
  "Removes all sounds from the sound manager that have an asset key matching the given value.
  The removed sounds are destroyed before removal.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * key (string) - The key to match when removing sound objects.

  Returns:  number - The number of matching sound objects that were removed."
  ([base-sound-manager key]
   (phaser->clj
    (.removeByKey base-sound-manager
                  (clj->phaser key)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([base-sound-manager event]
   (phaser->clj
    (.removeListener base-sound-manager
                     (clj->phaser event))))
  ([base-sound-manager event fn]
   (phaser->clj
    (.removeListener base-sound-manager
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([base-sound-manager event fn context]
   (phaser->clj
    (.removeListener base-sound-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([base-sound-manager event fn context once]
   (phaser->clj
    (.removeListener base-sound-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn resume-all
  "Resumes all the sounds in the game."
  ([base-sound-manager]
   (phaser->clj
    (.resumeAll base-sound-manager))))

(defn set-detune
  "Sets the global detuning of all sounds in [cents](https://en.wikipedia.org/wiki/Cent_%28music%29).
  The range of the value is -1200 to 1200, but we recommend setting it to [50](https://en.wikipedia.org/wiki/50_Cent).

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * value (number) - The range of the value is -1200 to 1200, but we recommend setting it to [50](https://en.wikipedia.org/wiki/50_Cent).

  Returns:  Phaser.Sound.BaseSoundManager - This Sound Manager."
  ([base-sound-manager value]
   (phaser->clj
    (.setDetune base-sound-manager
                (clj->phaser value)))))

(defn set-rate
  "Sets the global playback rate at which all the sounds will be played.

  For example, a value of 1.0 plays the audio at full speed, 0.5 plays the audio at half speed
  and 2.0 doubles the audios playback speed.

  Parameters:
    * base-sound-manager (Phaser.Sound.BaseSoundManager) - Targeted instance for method
    * value (number) - Global playback rate at which all the sounds will be played.

  Returns:  Phaser.Sound.BaseSoundManager - This Sound Manager."
  ([base-sound-manager value]
   (phaser->clj
    (.setRate base-sound-manager
              (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([base-sound-manager]
   (phaser->clj
    (.shutdown base-sound-manager))))

(defn stop-all
  "Stops all the sounds in the game."
  ([base-sound-manager]
   (phaser->clj
    (.stopAll base-sound-manager))))