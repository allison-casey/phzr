(ns phzr.game-objects.components.animation
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [reverse remove update]))

(defn ->Animation
  "  Parameters:
    * parent (Phaser.GameObjects.GameObject) - The Game Object to which this animation controller belongs."
  ([parent]
   (js/Phaser.GameObjects.Components.Animation. (clj->phaser parent))))

(defn chain
  "Sets an animation to be played immediately after the current one completes.

  The current animation must enter a 'completed' state for this to happen, i.e. finish all of its repeats, delays, etc, or have the `stop` method called directly on it.

  An animation set to repeat forever will never enter a completed state.

  You can chain a new animation at any point, including before the current one starts playing, during it, or when it ends (via its `animationcomplete` callback).
  Chained animations are specific to a Game Object, meaning different Game Objects can have different chained animations without impacting the global animation they're playing.

  Call this method with no arguments to reset the chained animation.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * key (string | Phaser.Animations.Animation) {optional} - The string-based key of the animation to play next, as defined previously in the Animation Manager. Or an Animation instance.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.chain animation)))
  ([animation key]
   (phaser->clj
    (.chain animation
            (clj->phaser key)))))

(defn delayed-play
  "Waits for the specified delay, in milliseconds, then starts playback of the requested animation.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * delay (integer) - The delay, in milliseconds, to wait before starting the animation playing.
    * key (string) - The key of the animation to play.
    * start-frame (integer) {optional} - The frame of the animation to start from.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation delay key]
   (phaser->clj
    (.delayedPlay animation
                  (clj->phaser delay)
                  (clj->phaser key))))
  ([animation delay key start-frame]
   (phaser->clj
    (.delayedPlay animation
                  (clj->phaser delay)
                  (clj->phaser key)
                  (clj->phaser start-frame)))))

(defn destroy
  "Destroy this Animation component.

  Unregisters event listeners and cleans up its references."
  ([animation]
   (phaser->clj
    (.destroy animation))))

(defn get-current-key
  "Returns the key of the animation currently loaded into this component.

  Returns:  string - The key of the Animation loaded into this component."
  ([animation]
   (phaser->clj
    (.getCurrentKey animation))))

(defn get-delay
  "Gets the amount of time, in milliseconds that the animation will be delayed before starting playback.

  Returns:  integer - The amount of time, in milliseconds, the Animation will wait before starting playback."
  ([animation]
   (phaser->clj
    (.getDelay animation))))

(defn get-progress
  "Returns a value between 0 and 1 indicating how far this animation is through, ignoring repeats and yoyos.
  If the animation has a non-zero repeat defined, `getProgress` and `getTotalProgress` will be different
  because `getProgress` doesn't include any repeats or repeat delays, whereas `getTotalProgress` does.

  Returns:  number - The progress of the current animation, between 0 and 1."
  ([animation]
   (phaser->clj
    (.getProgress animation))))

(defn get-repeat
  "Gets the number of times that the animation will repeat
  after its first iteration. For example, if returns 1, the animation will
  play a total of twice (the initial play plus 1 repeat).
  A value of -1 means the animation will repeat indefinitely.

  Returns:  integer - The number of times that the animation will repeat."
  ([animation]
   (phaser->clj
    (.getRepeat animation))))

(defn get-repeat-delay
  "Gets the amount of delay between repeats, if any.

  Returns:  number - The delay between repeats."
  ([animation]
   (phaser->clj
    (.getRepeatDelay animation))))

(defn get-time-scale
  "Gets the Time Scale factor.

  Returns:  number - The Time Scale value."
  ([animation]
   (phaser->clj
    (.getTimeScale animation))))

(defn get-total-frames
  "Returns the total number of frames in this animation.

  Returns:  integer - The total number of frames in this animation."
  ([animation]
   (phaser->clj
    (.getTotalFrames animation))))

(defn get-yoyo
  "Gets if the current Animation will yoyo when it reaches the end.
  A yoyo'ing animation will play through consecutively, and then reverse-play back to the start again.

  Returns:  boolean - `true` if the animation is set to yoyo, `false` if not."
  ([animation]
   (phaser->clj
    (.getYoyo animation))))

(defn next-frame
  "Advances the animation to the next frame, regardless of the time or animation state.
  If the animation is set to repeat, or yoyo, this will still take effect.

  Calling this does not change the direction of the animation. I.e. if it was currently
  playing in reverse, calling this method doesn't then change the direction to forwards.

  Returns:  Phaser.GameObjects.GameObject - The Game Object this Animation Component belongs to."
  ([animation]
   (phaser->clj
    (.nextFrame animation))))

(defn pause
  "Pause the current animation and set the `isPlaying` property to `false`.
  You can optionally pause it at a specific frame.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * at-frame (Phaser.Animations.AnimationFrame) {optional} - An optional frame to set after pausing the animation.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.pause animation)))
  ([animation at-frame]
   (phaser->clj
    (.pause animation
            (clj->phaser at-frame)))))

(defn play
  "Plays an Animation on a Game Object that has the Animation component, such as a Sprite.

  Animations are stored in the global Animation Manager and are referenced by a unique string-based key.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * key (string | Phaser.Animations.Animation) - The string-based key of the animation to play, as defined previously in the Animation Manager. Or an Animation instance.
    * ignore-if-playing (boolean) {optional} - If this animation is already playing then ignore this call.
    * start-frame (integer) {optional} - Optionally start the animation playing from this frame index.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation key]
   (phaser->clj
    (.play animation
           (clj->phaser key))))
  ([animation key ignore-if-playing]
   (phaser->clj
    (.play animation
           (clj->phaser key)
           (clj->phaser ignore-if-playing))))
  ([animation key ignore-if-playing start-frame]
   (phaser->clj
    (.play animation
           (clj->phaser key)
           (clj->phaser ignore-if-playing)
           (clj->phaser start-frame)))))

(defn play-reverse
  "Plays an Animation (in reverse mode) on the Game Object that owns this Animation Component.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * key (string | Phaser.Animations.Animation) - The string-based key of the animation to play, as defined previously in the Animation Manager. Or an Animation instance.
    * ignore-if-playing (boolean) {optional} - If an animation is already playing then ignore this call.
    * start-frame (integer) {optional} - Optionally start the animation playing from this frame index.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation key]
   (phaser->clj
    (.playReverse animation
                  (clj->phaser key))))
  ([animation key ignore-if-playing]
   (phaser->clj
    (.playReverse animation
                  (clj->phaser key)
                  (clj->phaser ignore-if-playing))))
  ([animation key ignore-if-playing start-frame]
   (phaser->clj
    (.playReverse animation
                  (clj->phaser key)
                  (clj->phaser ignore-if-playing)
                  (clj->phaser start-frame)))))

(defn previous-frame
  "Advances the animation to the previous frame, regardless of the time or animation state.
  If the animation is set to repeat, or yoyo, this will still take effect.

  Calling this does not change the direction of the animation. I.e. if it was currently
  playing in forwards, calling this method doesn't then change the direction to backwards.

  Returns:  Phaser.GameObjects.GameObject - The Game Object this Animation Component belongs to."
  ([animation]
   (phaser->clj
    (.previousFrame animation))))

(defn remove
  "Handle the removal of an animation from the Animation Manager.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * key (string) {optional} - The key of the removed Animation.
    * animation (Phaser.Animations.Animation) {optional} - The removed Animation."
  ([animation]
   (phaser->clj
    (.remove animation)))
  ([animation key]
   (phaser->clj
    (.remove animation
             (clj->phaser key))))
  ([animation key animation]
   (phaser->clj
    (.remove animation
             (clj->phaser key)
             (clj->phaser animation)))))

(defn restart
  "Restarts the current animation from its beginning, optionally including its delay value.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * include-delay (boolean) {optional} - Whether to include the delay value of the animation when restarting.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.restart animation)))
  ([animation include-delay]
   (phaser->clj
    (.restart animation
              (clj->phaser include-delay)))))

(defn resume
  "Resumes playback of a paused animation and sets the `isPlaying` property to `true`.
  You can optionally tell it to start playback from a specific frame.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * from-frame (Phaser.Animations.AnimationFrame) {optional} - An optional frame to set before restarting playback.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.resume animation)))
  ([animation from-frame]
   (phaser->clj
    (.resume animation
             (clj->phaser from-frame)))))

(defn reverse
  "Reverse the Animation that is already playing on the Game Object.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.reverse animation))))

(defn set-current-frame
  "Sets the given Animation Frame as being the current frame
  and applies it to the parent Game Object, adjusting its size and origin as needed.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * animation-frame (Phaser.Animations.AnimationFrame) - The Animation Frame to set as being current.

  Returns:  Phaser.GameObjects.GameObject - The Game Object this Animation Component belongs to."
  ([animation animation-frame]
   (phaser->clj
    (.setCurrentFrame animation
                      (clj->phaser animation-frame)))))

(defn set-delay
  "Sets the amount of time, in milliseconds, that the animation will be delayed before starting playback.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * value (integer) {optional} - The amount of time, in milliseconds, to wait before starting playback.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.setDelay animation)))
  ([animation value]
   (phaser->clj
    (.setDelay animation
               (clj->phaser value)))))

(defn set-progress
  "Takes a value between 0 and 1 and uses it to set how far this animation is through playback.
  Does not factor in repeats or yoyos, but does handle playing forwards or backwards.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * value (number) {optional} - The progress value, between 0 and 1.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.setProgress animation)))
  ([animation value]
   (phaser->clj
    (.setProgress animation
                  (clj->phaser value)))))

(defn set-repeat
  "Sets the number of times that the animation should repeat
  after its first iteration. For example, if repeat is 1, the animation will
  play a total of twice (the initial play plus 1 repeat).
  To repeat indefinitely, use -1. repeat should always be an integer.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * value (integer) - The number of times that the animation should repeat.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation value]
   (phaser->clj
    (.setRepeat animation
                (clj->phaser value)))))

(defn set-repeat-delay
  "Sets the amount of time in seconds between repeats.
  For example, if `repeat` is 2 and `repeatDelay` is 10, the animation will play initially,
  then wait for 10 seconds before repeating, then play again, then wait another 10 seconds
  before doing its final repeat.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * value (number) - The delay to wait between repeats, in seconds.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation value]
   (phaser->clj
    (.setRepeatDelay animation
                     (clj->phaser value)))))

(defn set-time-scale
  "Sets the Time Scale factor, allowing you to make the animation go go faster or slower than default.
  Where 1 = normal speed (the default), 0.5 = half speed, 2 = double speed, etc.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * value (number) {optional} - The time scale factor, where 1 is no change, 0.5 is half speed, etc.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.setTimeScale animation)))
  ([animation value]
   (phaser->clj
    (.setTimeScale animation
                   (clj->phaser value)))))

(defn set-yoyo
  "Sets if the current Animation will yoyo when it reaches the end.
  A yoyo'ing animation will play through consecutively, and then reverse-play back to the start again.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * value (boolean) {optional} - `true` if the animation should yoyo, `false` to not.

  Returns:  Phaser.GameObjects.GameObject - The Game Object this Animation Component belongs to."
  ([animation]
   (phaser->clj
    (.setYoyo animation)))
  ([animation value]
   (phaser->clj
    (.setYoyo animation
              (clj->phaser value)))))

(defn start-animation
  "Load an Animation and fires 'onStartEvent' event, extracted from 'play' method.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * key (string) - The string-based key of the animation to play, as defined previously in the Animation Manager.
    * start-frame (integer) {optional} - Optionally start the animation playing from this frame index.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation key]
   (phaser->clj
    (._startAnimation animation
                      (clj->phaser key))))
  ([animation key start-frame]
   (phaser->clj
    (._startAnimation animation
                      (clj->phaser key)
                      (clj->phaser start-frame)))))

(defn stop
  "Immediately stops the current animation from playing and dispatches the `animationcomplete` event.

  If no animation is set, no event will be dispatched.

  If there is another animation queued (via the `chain` method) then it will start playing immediately.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.stop animation))))

(defn stop-after-delay
  "Stops the current animation from playing after the specified time delay, given in milliseconds.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * delay (integer) - The number of milliseconds to wait before stopping this animation.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation delay]
   (phaser->clj
    (.stopAfterDelay animation
                     (clj->phaser delay)))))

(defn stop-on-frame
  "Stops the current animation from playing when it next sets the given frame.
  If this frame doesn't exist within the animation it will not stop it from playing.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * frame (Phaser.Animations.AnimationFrame) - The frame to check before stopping this animation.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation frame]
   (phaser->clj
    (.stopOnFrame animation
                  (clj->phaser frame)))))

(defn stop-on-repeat
  "Stops the current animation from playing when it next repeats.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that owns this Animation Component."
  ([animation]
   (phaser->clj
    (.stopOnRepeat animation))))

(defn update
  "The internal update loop for the Animation Component.

  Parameters:
    * animation (Phaser.GameObjects.Components.Animation) - Targeted instance for method
    * time (number) - The current timestamp.
    * delta (number) - The delta time, in ms, elapsed since the last frame."
  ([animation time delta]
   (phaser->clj
    (.update animation
             (clj->phaser time)
             (clj->phaser delta)))))