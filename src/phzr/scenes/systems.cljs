(ns phzr.scenes.systems
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Systems
  "  Parameters:
    * scene (Phaser.Scene) - The Scene that owns this Systems instance.
    * config (string | Phaser.Types.Scenes.SettingsConfig) - Scene specific configuration settings."
  ([scene config]
   (js/Phaser.Scenes.Systems. (clj->phaser scene)
                              (clj->phaser config))))

(defn depth-sort
  "Immediately sorts the display list if the flag is set."
  ([systems]
   (phaser->clj
    (.depthSort systems))))

(defn is-active
  "Is this Scene running?

  Returns:  boolean - `true` if this Scene is running, otherwise `false`."
  ([systems]
   (phaser->clj
    (.isActive systems))))

(defn is-paused
  "Is this Scene paused?

  Returns:  boolean - `true` if this Scene is paused, otherwise `false`."
  ([systems]
   (phaser->clj
    (.isPaused systems))))

(defn is-sleeping
  "Is this Scene sleeping?

  Returns:  boolean - `true` if this Scene is asleep, otherwise `false`."
  ([systems]
   (phaser->clj
    (.isSleeping systems))))

(defn is-transition-in
  "Is this Scene currently transitioning in from another Scene?

  Returns:  boolean - `true` if this Scene is transitioning in from another Scene, otherwise `false`."
  ([systems]
   (phaser->clj
    (.isTransitionIn systems))))

(defn is-transition-out
  "Is this Scene currently transitioning out from itself to another Scene?

  Returns:  boolean - `true` if this Scene is in transition to another Scene, otherwise `false`."
  ([systems]
   (phaser->clj
    (.isTransitionOut systems))))

(defn is-transitioning
  "Is this Scene currently transitioning out to, or in from another Scene?

  Returns:  boolean - `true` if this Scene is currently transitioning, otherwise `false`."
  ([systems]
   (phaser->clj
    (.isTransitioning systems))))

(defn is-visible
  "Is this Scene visible and rendering?

  Returns:  boolean - `true` if this Scene is visible, otherwise `false`."
  ([systems]
   (phaser->clj
    (.isVisible systems))))

(defn pause
  "Pause this Scene.
  A paused Scene still renders, it just doesn't run ANY of its update handlers or systems.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * data (object) {optional} - A data object that will be passed in the 'pause' event.

  Returns:  Phaser.Scenes.Systems - This Systems object."
  ([systems]
   (phaser->clj
    (.pause systems)))
  ([systems data]
   (phaser->clj
    (.pause systems
            (clj->phaser data)))))

(defn queue-depth-sort
  "Force a sort of the display list on the next render."
  ([systems]
   (phaser->clj
    (.queueDepthSort systems))))

(defn render
  "Called automatically by the Scene Manager.
  Instructs the Scene to render itself via its Camera Manager to the renderer given.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * renderer (Phaser.Renderer.Canvas.CanvasRenderer | Phaser.Renderer.WebGL.WebGLRenderer) - The renderer that invoked the render call."
  ([systems renderer]
   (phaser->clj
    (.render systems
             (clj->phaser renderer)))))

(defn resume
  "Resume this Scene from a paused state.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * data (object) {optional} - A data object that will be passed in the 'resume' event.

  Returns:  Phaser.Scenes.Systems - This Systems object."
  ([systems]
   (phaser->clj
    (.resume systems)))
  ([systems data]
   (phaser->clj
    (.resume systems
             (clj->phaser data)))))

(defn set-active
  "Set the active state of this Scene.

  An active Scene will run its core update loop.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * value (boolean) - If `true` the Scene will be resumed, if previously paused. If `false` it will be paused.
    * data (object) {optional} - A data object that will be passed in the 'resume' or 'pause' events.

  Returns:  Phaser.Scenes.Systems - This Systems object."
  ([systems value]
   (phaser->clj
    (.setActive systems
                (clj->phaser value))))
  ([systems value data]
   (phaser->clj
    (.setActive systems
                (clj->phaser value)
                (clj->phaser data)))))

(defn set-visible
  "Sets the visible state of this Scene.
  An invisible Scene will not render, but will still process updates.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * value (boolean) - `true` to render this Scene, otherwise `false`.

  Returns:  Phaser.Scenes.Systems - This Systems object."
  ([systems value]
   (phaser->clj
    (.setVisible systems
                 (clj->phaser value)))))

(defn shutdown
  "Shutdown this Scene and send a shutdown event to all of its systems.
  A Scene that has been shutdown will not run its update loop or render, but it does
  not destroy any of its plugins or references. It is put into hibernation for later use.
  If you don't ever plan to use this Scene again, then it should be destroyed instead
  to free-up resources.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * data (object) {optional} - A data object that will be passed in the 'shutdown' event."
  ([systems]
   (phaser->clj
    (.shutdown systems)))
  ([systems data]
   (phaser->clj
    (.shutdown systems
               (clj->phaser data)))))

(defn sleep
  "Send this Scene to sleep.

  A sleeping Scene doesn't run it's update step or render anything, but it also isn't shut down
  or have any of its systems or children removed, meaning it can be re-activated at any point and
  will carry on from where it left off. It also keeps everything in memory and events and callbacks
  from other Scenes may still invoke changes within it, so be careful what is left active.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * data (object) {optional} - A data object that will be passed in the 'sleep' event.

  Returns:  Phaser.Scenes.Systems - This Systems object."
  ([systems]
   (phaser->clj
    (.sleep systems)))
  ([systems data]
   (phaser->clj
    (.sleep systems
            (clj->phaser data)))))

(defn start
  "Start this Scene running and rendering.
  Called automatically by the SceneManager.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * data (object) - Optional data object that may have been passed to this Scene from another."
  ([systems data]
   (phaser->clj
    (.start systems
            (clj->phaser data)))))

(defn step
  "A single game step. Called automatically by the Scene Manager as a result of a Request Animation
  Frame or Set Timeout call to the main Game instance.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * time (number) - The time value from the most recent Game step. Typically a high-resolution timer value, or Date.now().
    * delta (number) - The delta value since the last frame. This is smoothed to avoid delta spikes by the TimeStep class."
  ([systems time delta]
   (phaser->clj
    (.step systems
           (clj->phaser time)
           (clj->phaser delta)))))

(defn wake
  "Wake-up this Scene if it was previously asleep.

  Parameters:
    * systems (Phaser.Scenes.Systems) - Targeted instance for method
    * data (object) {optional} - A data object that will be passed in the 'wake' event.

  Returns:  Phaser.Scenes.Systems - This Systems object."
  ([systems]
   (phaser->clj
    (.wake systems)))
  ([systems data]
   (phaser->clj
    (.wake systems
           (clj->phaser data)))))