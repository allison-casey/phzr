(ns phzr.scenes.scene-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove get]))

(defn ->ScenePlugin
  "  Parameters:
    * scene (Phaser.Scene) - The Scene that this ScenePlugin belongs to."
  ([scene]
   (js/Phaser.Scenes.ScenePlugin. (clj->phaser scene))))

(defn add
  "Add the Scene into the Scene Manager and start it if 'autoStart' is true or the Scene config 'active' property is set.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) - The Scene key.
    * scene-config (Phaser.Scene | Phaser.Types.Scenes.SettingsConfig | Phaser.Types.Scenes.CreateSceneFromObjectConfig | function) - The config for the Scene.
    * auto-start (boolean) - Whether to start the Scene after it's added.
    * data (object) {optional} - Optional data object. This will be set as Scene.settings.data and passed to `Scene.init`.

  Returns:  Phaser.Scene - An instance of the Scene that was added to the Scene Manager."
  ([scene-plugin key scene-config auto-start]
   (phaser->clj
    (.add scene-plugin
          (clj->phaser key)
          (clj->phaser scene-config)
          (clj->phaser auto-start))))
  ([scene-plugin key scene-config auto-start data]
   (phaser->clj
    (.add scene-plugin
          (clj->phaser key)
          (clj->phaser scene-config)
          (clj->phaser auto-start)
          (clj->phaser data)))))

(defn bring-to-top
  "Brings a Scene to the top of the Scenes list.

  This means it will render above all other Scenes.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to move.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.bringToTop scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.bringToTop scene-plugin
                 (clj->phaser key)))))

(defn get
  "Retrieve a Scene.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) - The Scene to retrieve.

  Returns:  Phaser.Scene - The Scene."
  ([scene-plugin key]
   (phaser->clj
    (.get scene-plugin
          (clj->phaser key)))))

(defn get-index
  "Retrieves the numeric index of a Scene in the Scenes list.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string | Phaser.Scene) {optional} - The Scene to get the index of.

  Returns:  integer - The index of the Scene."
  ([scene-plugin]
   (phaser->clj
    (.getIndex scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.getIndex scene-plugin
               (clj->phaser key)))))

(defn is-active
  "Checks if the given Scene is running or not?

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to check.

  Returns:  boolean - Whether the Scene is running."
  ([scene-plugin]
   (phaser->clj
    (.isActive scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.isActive scene-plugin
               (clj->phaser key)))))

(defn is-paused
  "Checks if the given Scene is paused or not?

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to check.

  Returns:  boolean - Whether the Scene is paused."
  ([scene-plugin]
   (phaser->clj
    (.isPaused scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.isPaused scene-plugin
               (clj->phaser key)))))

(defn is-sleeping
  "Checks if the given Scene is sleeping or not?

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to check.

  Returns:  boolean - Whether the Scene is sleeping."
  ([scene-plugin]
   (phaser->clj
    (.isSleeping scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.isSleeping scene-plugin
                 (clj->phaser key)))))

(defn is-visible
  "Checks if the given Scene is visible or not?

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to check.

  Returns:  boolean - Whether the Scene is visible."
  ([scene-plugin]
   (phaser->clj
    (.isVisible scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.isVisible scene-plugin
                (clj->phaser key)))))

(defn launch
  "Launch the given Scene and run it in parallel with this one.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) - The Scene to launch.
    * data (object) {optional} - The Scene data.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin key]
   (phaser->clj
    (.launch scene-plugin
             (clj->phaser key))))
  ([scene-plugin key data]
   (phaser->clj
    (.launch scene-plugin
             (clj->phaser key)
             (clj->phaser data)))))

(defn move-above
  "Swaps the position of two scenes in the Scenes list, so that Scene B is directly above Scene A.

  This controls the order in which they are rendered and updated.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key-a (string) - The Scene that Scene B will be moved to be above.
    * key-b (string) {optional} - The Scene to be moved. If none is given it defaults to this Scene.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin key-a]
   (phaser->clj
    (.moveAbove scene-plugin
                (clj->phaser key-a))))
  ([scene-plugin key-a key-b]
   (phaser->clj
    (.moveAbove scene-plugin
                (clj->phaser key-a)
                (clj->phaser key-b)))))

(defn move-below
  "Swaps the position of two scenes in the Scenes list, so that Scene B is directly below Scene A.

  This controls the order in which they are rendered and updated.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key-a (string) - The Scene that Scene B will be moved to be below.
    * key-b (string) {optional} - The Scene to be moved. If none is given it defaults to this Scene.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin key-a]
   (phaser->clj
    (.moveBelow scene-plugin
                (clj->phaser key-a))))
  ([scene-plugin key-a key-b]
   (phaser->clj
    (.moveBelow scene-plugin
                (clj->phaser key-a)
                (clj->phaser key-b)))))

(defn move-down
  "Moves a Scene down one position in the Scenes list.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to move.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.moveDown scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.moveDown scene-plugin
               (clj->phaser key)))))

(defn move-up
  "Moves a Scene up one position in the Scenes list.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to move.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.moveUp scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.moveUp scene-plugin
             (clj->phaser key)))))

(defn pause
  "Pause the Scene - this stops the update step from happening but it still renders.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to pause.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted in its pause event.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.pause scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.pause scene-plugin
            (clj->phaser key))))
  ([scene-plugin key data]
   (phaser->clj
    (.pause scene-plugin
            (clj->phaser key)
            (clj->phaser data)))))

(defn remove
  "Removes a Scene from the SceneManager.

  The Scene is removed from the local scenes array, it's key is cleared from the keys
  cache and Scene.Systems.destroy is then called on it.

  If the SceneManager is processing the Scenes when this method is called it wil
  queue the operation for the next update sequence.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string | Phaser.Scene) {optional} - The Scene to be removed.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-plugin]
   (phaser->clj
    (.remove scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.remove scene-plugin
             (clj->phaser key)))))

(defn restart
  "Restarts this Scene.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * data (object) {optional} - The Scene data.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.restart scene-plugin)))
  ([scene-plugin data]
   (phaser->clj
    (.restart scene-plugin
              (clj->phaser data)))))

(defn resume
  "Resume the Scene - starts the update loop again.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to resume.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted in its resume event.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.resume scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.resume scene-plugin
             (clj->phaser key))))
  ([scene-plugin key data]
   (phaser->clj
    (.resume scene-plugin
             (clj->phaser key)
             (clj->phaser data)))))

(defn run
  "Runs the given Scene, but does not change the state of this Scene.

  If the given Scene is paused, it will resume it. If sleeping, it will wake it.
  If not running at all, it will be started.

  Use this if you wish to open a modal Scene by calling `pause` on the current
  Scene, then `run` on the modal Scene.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) - The Scene to run.
    * data (object) {optional} - A data object that will be passed to the Scene and emitted in its ready, wake, or resume events.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin key]
   (phaser->clj
    (.run scene-plugin
          (clj->phaser key))))
  ([scene-plugin key data]
   (phaser->clj
    (.run scene-plugin
          (clj->phaser key)
          (clj->phaser data)))))

(defn send-to-back
  "Sends a Scene to the back of the Scenes list.

  This means it will render below all other Scenes.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to move.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.sendToBack scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.sendToBack scene-plugin
                 (clj->phaser key)))))

(defn set-active
  "Sets the active state of the given Scene.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * value (boolean) - If `true` the Scene will be resumed. If `false` it will be paused.
    * key (string) {optional} - The Scene to set the active state of.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted with its events.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin value]
   (phaser->clj
    (.setActive scene-plugin
                (clj->phaser value))))
  ([scene-plugin value key]
   (phaser->clj
    (.setActive scene-plugin
                (clj->phaser value)
                (clj->phaser key))))
  ([scene-plugin value key data]
   (phaser->clj
    (.setActive scene-plugin
                (clj->phaser value)
                (clj->phaser key)
                (clj->phaser data)))))

(defn set-visible
  "Sets the visible state of the given Scene.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * value (boolean) - The visible value.
    * key (string) {optional} - The Scene to set the visible state for.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin value]
   (phaser->clj
    (.setVisible scene-plugin
                 (clj->phaser value))))
  ([scene-plugin value key]
   (phaser->clj
    (.setVisible scene-plugin
                 (clj->phaser value)
                 (clj->phaser key)))))

(defn sleep
  "Makes the Scene sleep (no update, no render) but doesn't shutdown.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to put to sleep.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted in its sleep event.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.sleep scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.sleep scene-plugin
            (clj->phaser key))))
  ([scene-plugin key data]
   (phaser->clj
    (.sleep scene-plugin
            (clj->phaser key)
            (clj->phaser data)))))

(defn start
  "Shutdown this Scene and run the given one.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to start.
    * data (object) {optional} - The Scene data.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.start scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.start scene-plugin
            (clj->phaser key))))
  ([scene-plugin key data]
   (phaser->clj
    (.start scene-plugin
            (clj->phaser key)
            (clj->phaser data)))))

(defn stop
  "Shutdown the Scene, clearing display list, timers, etc.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to stop.
    * data (any) {optional} - Optional data object to pass to Scene.Systems.shutdown.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.stop scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.stop scene-plugin
           (clj->phaser key))))
  ([scene-plugin key data]
   (phaser->clj
    (.stop scene-plugin
           (clj->phaser key)
           (clj->phaser data)))))

(defn swap-position
  "Swaps the position of two scenes in the Scenes list.

  This controls the order in which they are rendered and updated.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key-a (string) - The first Scene to swap.
    * key-b (string) {optional} - The second Scene to swap. If none is given it defaults to this Scene.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin key-a]
   (phaser->clj
    (.swapPosition scene-plugin
                   (clj->phaser key-a))))
  ([scene-plugin key-a key-b]
   (phaser->clj
    (.swapPosition scene-plugin
                   (clj->phaser key-a)
                   (clj->phaser key-b)))))

(defn switch
  "Makes this Scene sleep then starts the Scene given.

  No checks are made to see if an instance of the given Scene is already running.
  Because Scenes in Phaser are non-exclusive, you are allowed to run multiple
  instances of them _at the same time_. This means, calling this function
  may launch another instance of the requested Scene if it's already running.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) - The Scene to start.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin key]
   (phaser->clj
    (.switch scene-plugin
             (clj->phaser key)))))

(defn transition
  "This will start a transition from the current Scene to the target Scene given.

  The transition will last for the duration specified in milliseconds.

  You can have the target Scene moved above or below this one in the display list.

  You can specify an update callback. This callback will be invoked _every frame_ for the duration
  of the transition.

  This Scene can either be sent to sleep at the end of the transition, or stopped. The default is to stop.

  There are also 5 transition related events: This scene will emit the event `transitionout` when
  the transition begins, which is typically the frame after calling this method.

  The target Scene will emit the event `transitioninit` when that Scene's `init` method is called.
  It will then emit the event `transitionstart` when its `create` method is called.
  If the Scene was sleeping and has been woken up, it will emit the event `transitionwake` instead of these two,
  as the Scenes `init` and `create` methods are not invoked when a Scene wakes up.

  When the duration of the transition has elapsed it will emit the event `transitioncomplete`.
  These events are cleared of all listeners when the Scene shuts down, but not if it is sent to sleep.

  It's important to understand that the duration of the transition begins the moment you call this method.
  If the Scene you are transitioning to includes delayed processes, such as waiting for files to load, the
  time still counts down even while that is happening. If the game itself pauses, or something else causes
  this Scenes update loop to stop, then the transition will also pause for that duration. There are
  checks in place to prevent you accidentally stopping a transitioning Scene but if you've got code to
  override this understand that until the target Scene completes it might never be unlocked for input events.

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * config (Phaser.Types.Scenes.SceneTransitionConfig) - The transition configuration object.

  Returns:  boolean - `true` is the transition was started, otherwise `false`."
  ([scene-plugin config]
   (phaser->clj
    (.transition scene-plugin
                 (clj->phaser config)))))

(defn wake
  "Makes the Scene wake-up (starts update and render)

  Parameters:
    * scene-plugin (Phaser.Scenes.ScenePlugin) - Targeted instance for method
    * key (string) {optional} - The Scene to wake up.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted in its wake event.

  Returns:  Phaser.Scenes.ScenePlugin - This ScenePlugin object."
  ([scene-plugin]
   (phaser->clj
    (.wake scene-plugin)))
  ([scene-plugin key]
   (phaser->clj
    (.wake scene-plugin
           (clj->phaser key))))
  ([scene-plugin key data]
   (phaser->clj
    (.wake scene-plugin
           (clj->phaser key)
           (clj->phaser data)))))