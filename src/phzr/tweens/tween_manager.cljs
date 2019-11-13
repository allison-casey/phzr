(ns phzr.tweens.tween-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update remove]))

(defn ->TweenManager
  "  Parameters:
    * scene (Phaser.Scene) - The Scene which owns this Tween Manager."
  ([scene]
   (js/Phaser.Tweens.TweenManager. (clj->phaser scene))))

(defn add
  "Create a Tween and add it to the active Tween list.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * config (Phaser.Types.Tweens.TweenBuilderConfig | object) - The configuration object for the Tween.

  Returns:  Phaser.Tweens.Tween - The created Tween."
  ([tween-manager config]
   (phaser->clj
    (.add tween-manager
          (clj->phaser config)))))

(defn add-counter
  "Create a Number Tween and add it to the active Tween list.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * config (Phaser.Types.Tweens.NumberTweenBuilderConfig) - The configuration object for the Number Tween.

  Returns:  Phaser.Tweens.Tween - The created Number Tween."
  ([tween-manager config]
   (phaser->clj
    (.addCounter tween-manager
                 (clj->phaser config)))))

(defn create
  "Create a Tween and return it, but do NOT add it to the active or pending Tween lists.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * config (Phaser.Types.Tweens.TweenBuilderConfig | object) - The configuration object for the Tween.

  Returns:  Phaser.Tweens.Tween - The created Tween object."
  ([tween-manager config]
   (phaser->clj
    (.create tween-manager
             (clj->phaser config)))))

(defn create-timeline
  "Create a Tween Timeline and return it, but do NOT add it to the active or pending Tween lists.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * config (Phaser.Types.Tweens.TimelineBuilderConfig) - The configuration object for the Timeline and its Tweens.

  Returns:  Phaser.Tweens.Timeline - The created Timeline object."
  ([tween-manager config]
   (phaser->clj
    (.createTimeline tween-manager
                     (clj->phaser config)))))

(defn destroy
  "The Scene that owns this plugin is being destroyed.
  We need to shutdown and then kill off all external references."
  ([tween-manager]
   (phaser->clj
    (.destroy tween-manager))))

(defn each
  "Passes all Tweens to the given callback.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * callback (function) - The function to call.
    * scope (object) {optional} - The scope (`this` object) to call the function with.
    * args (*) {optional} - The arguments to pass into the function. Its first argument will always be the Tween currently being iterated."
  ([tween-manager callback]
   (phaser->clj
    (.each tween-manager
           (clj->phaser callback))))
  ([tween-manager callback scope]
   (phaser->clj
    (.each tween-manager
           (clj->phaser callback)
           (clj->phaser scope))))
  ([tween-manager callback scope args]
   (phaser->clj
    (.each tween-manager
           (clj->phaser callback)
           (clj->phaser scope)
           (clj->phaser args)))))

(defn existing
  "Add an existing tween into the active Tween list.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The Tween to add.

  Returns:  Phaser.Tweens.TweenManager - This Tween Manager object."
  ([tween-manager tween]
   (phaser->clj
    (.existing tween-manager
               (clj->phaser tween)))))

(defn get-all-tweens
  "Returns an array of all active Tweens and Timelines in the Tween Manager.

  Returns:  Array.<Phaser.Tweens.Tween> - A new array containing references to all active Tweens and Timelines."
  ([tween-manager]
   (phaser->clj
    (.getAllTweens tween-manager))))

(defn get-global-time-scale
  "Returns the scale of the time delta for all Tweens and Timelines owned by this Tween Manager.

  Returns:  number - The scale of the time delta, usually 1."
  ([tween-manager]
   (phaser->clj
    (.getGlobalTimeScale tween-manager))))

(defn get-tweens-of
  "Returns an array of all Tweens or Timelines in the Tween Manager which affect the given target or array of targets.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * target (object | array) - The target to look for. Provide an array to look for multiple targets.

  Returns:  Array.<Phaser.Tweens.Tween> - A new array containing all Tweens and Timelines which affect the given target(s)."
  ([tween-manager target]
   (phaser->clj
    (.getTweensOf tween-manager
                  (clj->phaser target)))))

(defn is-tweening
  "Checks if the given object is being affected by a playing Tween.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * target (object) - target Phaser.Tweens.Tween object

  Returns:  boolean - returns if target tween object is active or not"
  ([tween-manager target]
   (phaser->clj
    (.isTweening tween-manager
                 (clj->phaser target)))))

(defn kill-all
  "Stops all Tweens in this Tween Manager. They will be removed at the start of the frame.

  Returns:  Phaser.Tweens.TweenManager - This Tween Manager."
  ([tween-manager]
   (phaser->clj
    (.killAll tween-manager))))

(defn kill-tweens-of
  "Stops all Tweens which affect the given target or array of targets. The Tweens will be removed from the Tween Manager at the start of the frame.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * target (object | array) - The target to look for. Provide an array to look for multiple targets.

  Returns:  Phaser.Tweens.TweenManager - This Tween Manager."
  ([tween-manager target]
   (phaser->clj
    (.killTweensOf tween-manager
                   (clj->phaser target)))))

(defn make-active
  "Checks if a Tween or Timeline is active and adds it to the Tween Manager at the start of the frame if it isn't.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The Tween to check.

  Returns:  Phaser.Tweens.TweenManager - This Tween Manager object."
  ([tween-manager tween]
   (phaser->clj
    (.makeActive tween-manager
                 (clj->phaser tween)))))

(defn pause-all
  "Pauses all Tweens in this Tween Manager.

  Returns:  Phaser.Tweens.TweenManager - This Tween Manager."
  ([tween-manager]
   (phaser->clj
    (.pauseAll tween-manager))))

(defn pre-update
  "Updates the Tween Manager's internal lists at the start of the frame.

  This method will return immediately if no changes have been indicated."
  ([tween-manager]
   (phaser->clj
    (.preUpdate tween-manager))))

(defn remove
  "Removes the given tween from the Tween Manager, regardless of its state (pending or active).

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * tween (Phaser.Tweens.Tween) - The Tween to be removed.

  Returns:  Phaser.Tweens.TweenManager - This Tween Manager object."
  ([tween-manager tween]
   (phaser->clj
    (.remove tween-manager
             (clj->phaser tween)))))

(defn resume-all
  "Resumes all Tweens in this Tween Manager.

  Returns:  Phaser.Tweens.TweenManager - This Tween Manager."
  ([tween-manager]
   (phaser->clj
    (.resumeAll tween-manager))))

(defn set-global-time-scale
  "Sets a new scale of the time delta for this Tween Manager.

  The time delta is the time elapsed between two consecutive frames and influences the speed of time for this Tween Manager and all Tweens it owns. Values higher than 1 increase the speed of time, while values smaller than 1 decrease it. A value of 0 freezes time and is effectively equivalent to pausing all Tweens.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * value (number) - The new scale of the time delta, where 1 is the normal speed.

  Returns:  Phaser.Tweens.TweenManager - This Tween Manager."
  ([tween-manager value]
   (phaser->clj
    (.setGlobalTimeScale tween-manager
                         (clj->phaser value)))))

(defn shutdown
  "The Scene that owns this plugin is shutting down.
  We need to kill and reset all internal properties as well as stop listening to Scene events."
  ([tween-manager]
   (phaser->clj
    (.shutdown tween-manager))))

(defn stagger
  "Creates a Stagger function to be used by a Tween property.

  The stagger function will allow you to stagger changes to the value of the property across all targets of the tween.

  This is only worth using if the tween has multiple targets.

  The following will stagger the delay by 100ms across all targets of the tween, causing them to scale down to 0.2
  over the duration specified:

  ```javascript
  this.tweens.add({
      targets: [ ... ],
      scale: 0.2,
      ease: 'linear',
      duration: 1000,
      delay: this.tweens.stagger(100)
  });
  ```

  The following will stagger the delay by 500ms across all targets of the tween using a 10 x 6 grid, staggering
  from the center out, using a cubic ease.

  ```javascript
  this.tweens.add({
      targets: [ ... ],
      scale: 0.2,
      ease: 'linear',
      duration: 1000,
      delay: this.tweens.stagger(500, { grid: [ 10, 6 ], from: 'center', ease: 'cubic.out' })
  });
  ```

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * config (Phaser.Types.Tweens.StaggerConfig) - The configuration object for the Stagger function.

  Returns:  function - The stagger function."
  ([tween-manager config]
   (phaser->clj
    (.stagger tween-manager
              (clj->phaser config)))))

(defn timeline
  "Create a Tween Timeline and add it to the active Tween list/

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * config (Phaser.Types.Tweens.TimelineBuilderConfig) - The configuration object for the Timeline and its Tweens.

  Returns:  Phaser.Tweens.Timeline - The created Timeline object."
  ([tween-manager config]
   (phaser->clj
    (.timeline tween-manager
               (clj->phaser config)))))

(defn update
  "Updates all Tweens and Timelines of the Tween Manager.

  Parameters:
    * tween-manager (Phaser.Tweens.TweenManager) - Targeted instance for method
    * timestamp (number) - The current time in milliseconds.
    * delta (number) - The delta time in ms since the last frame. This is a smoothed and capped value based on the FPS rate."
  ([tween-manager timestamp delta]
   (phaser->clj
    (.update tween-manager
             (clj->phaser timestamp)
             (clj->phaser delta)))))