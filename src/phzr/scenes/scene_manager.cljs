(ns phzr.scenes.scene-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove update]))

(defn ->SceneManager
  "  Parameters:
    * game (Phaser.Game) - The Phaser.Game instance this Scene Manager belongs to.
    * scene-config (object) - Scene specific configuration settings."
  ([game scene-config]
   (js/Phaser.Scenes.SceneManager. (clj->phaser game)
                                   (clj->phaser scene-config))))

(defn add
  "Adds a new Scene into the SceneManager.
  You must give each Scene a unique key by which you'll identify it.

  The `sceneConfig` can be:

  * A `Phaser.Scene` object, or an object that extends it.
  * A plain JavaScript object
  * A JavaScript ES6 Class that extends `Phaser.Scene`
  * A JavaScript ES5 prototype based Class
  * A JavaScript function

  If a function is given then a new Scene will be created by calling it.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - A unique key used to reference the Scene, i.e. `MainMenu` or `Level1`.
    * scene-config (Phaser.Scene | Phaser.Types.Scenes.SettingsConfig | Phaser.Types.Scenes.CreateSceneFromObjectConfig | function) - The config for the Scene
    * auto-start (boolean) {optional} - If `true` the Scene will be started immediately after being added.
    * data (object) {optional} - Optional data object. This will be set as Scene.settings.data and passed to `Scene.init`.

  Returns:  Phaser.Scene - The added Scene, if it was added immediately, otherwise `null`."
  ([scene-manager key scene-config]
   (phaser->clj
    (.add scene-manager
          (clj->phaser key)
          (clj->phaser scene-config))))
  ([scene-manager key scene-config auto-start]
   (phaser->clj
    (.add scene-manager
          (clj->phaser key)
          (clj->phaser scene-config)
          (clj->phaser auto-start))))
  ([scene-manager key scene-config auto-start data]
   (phaser->clj
    (.add scene-manager
          (clj->phaser key)
          (clj->phaser scene-config)
          (clj->phaser auto-start)
          (clj->phaser data)))))

(defn bring-to-top
  "Brings a Scene to the top of the Scenes list.

  This means it will render above all other Scenes.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string | Phaser.Scene) - The Scene to move.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.bringToTop scene-manager
                 (clj->phaser key)))))

(defn destroy
  "Destroy the SceneManager and all of its Scene's systems."
  ([scene-manager]
   (phaser->clj
    (.destroy scene-manager))))

(defn dump
  "Dumps debug information about each Scene to the developer console."
  ([scene-manager]
   (phaser->clj
    (.dump scene-manager))))

(defn get-at
  "Retrieves a Scene by numeric index.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * index (integer) - The index of the Scene to retrieve.

  Returns:  Phaser.Scene | undefined - The Scene."
  ([scene-manager index]
   (phaser->clj
    (.getAt scene-manager
            (clj->phaser index)))))

(defn get-index
  "Retrieves the numeric index of a Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string | Phaser.Scene) - The key of the Scene.

  Returns:  integer - The index of the Scene."
  ([scene-manager key]
   (phaser->clj
    (.getIndex scene-manager
               (clj->phaser key)))))

(defn get-scene
  "Retrieves a Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string | Phaser.Scene) - The Scene to retrieve.

  Returns:  Phaser.Scene - The Scene."
  ([scene-manager key]
   (phaser->clj
    (.getScene scene-manager
               (clj->phaser key)))))

(defn get-scenes
  "Returns an array of all the current Scenes being managed by this Scene Manager.

  You can filter the output by the active state of the Scene and choose to have
  the array returned in normal or reversed order.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * is-active (boolean) {optional} - Only include Scene's that are currently active?
    * in-reverse (boolean) {optional} - Return the array of Scenes in reverse?

  Returns:  Array.<Phaser.Scene> - An array containing all of the Scenes in the Scene Manager."
  ([scene-manager]
   (phaser->clj
    (.getScenes scene-manager)))
  ([scene-manager is-active]
   (phaser->clj
    (.getScenes scene-manager
                (clj->phaser is-active))))
  ([scene-manager is-active in-reverse]
   (phaser->clj
    (.getScenes scene-manager
                (clj->phaser is-active)
                (clj->phaser in-reverse)))))

(defn is-active
  "Determines whether a Scene is running.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to check.

  Returns:  boolean - Whether the Scene is running."
  ([scene-manager key]
   (phaser->clj
    (.isActive scene-manager
               (clj->phaser key)))))

(defn is-paused
  "Determines whether a Scene is paused.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to check.

  Returns:  boolean - Whether the Scene is paused."
  ([scene-manager key]
   (phaser->clj
    (.isPaused scene-manager
               (clj->phaser key)))))

(defn is-sleeping
  "Determines whether a Scene is sleeping.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to check.

  Returns:  boolean - Whether the Scene is sleeping."
  ([scene-manager key]
   (phaser->clj
    (.isSleeping scene-manager
                 (clj->phaser key)))))

(defn is-visible
  "Determines whether a Scene is visible.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to check.

  Returns:  boolean - Whether the Scene is visible."
  ([scene-manager key]
   (phaser->clj
    (.isVisible scene-manager
                (clj->phaser key)))))

(defn move-above
  "Moves a Scene so it is immediately above another Scene in the Scenes list.

  This means it will render over the top of the other Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key-a (string | Phaser.Scene) - The Scene that Scene B will be moved above.
    * key-b (string | Phaser.Scene) - The Scene to be moved.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key-a key-b]
   (phaser->clj
    (.moveAbove scene-manager
                (clj->phaser key-a)
                (clj->phaser key-b)))))

(defn move-below
  "Moves a Scene so it is immediately below another Scene in the Scenes list.

  This means it will render behind the other Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key-a (string | Phaser.Scene) - The Scene that Scene B will be moved above.
    * key-b (string | Phaser.Scene) - The Scene to be moved.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key-a key-b]
   (phaser->clj
    (.moveBelow scene-manager
                (clj->phaser key-a)
                (clj->phaser key-b)))))

(defn move-down
  "Moves a Scene down one position in the Scenes list.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string | Phaser.Scene) - The Scene to move.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.moveDown scene-manager
               (clj->phaser key)))))

(defn move-up
  "Moves a Scene up one position in the Scenes list.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string | Phaser.Scene) - The Scene to move.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.moveUp scene-manager
             (clj->phaser key)))))

(defn pause
  "Pauses the given Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to pause.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted by its pause event.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.pause scene-manager
            (clj->phaser key))))
  ([scene-manager key data]
   (phaser->clj
    (.pause scene-manager
            (clj->phaser key)
            (clj->phaser data)))))

(defn process-queue
  "Process the Scene operations queue."
  ([scene-manager]
   (phaser->clj
    (.processQueue scene-manager))))

(defn remove
  "Removes a Scene from the SceneManager.

  The Scene is removed from the local scenes array, it's key is cleared from the keys
  cache and Scene.Systems.destroy is then called on it.

  If the SceneManager is processing the Scenes when this method is called it will
  queue the operation for the next update sequence.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - A unique key used to reference the Scene, i.e. `MainMenu` or `Level1`.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.remove scene-manager
             (clj->phaser key)))))

(defn render
  "Renders the Scenes.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * renderer (Phaser.Renderer.Canvas.CanvasRenderer | Phaser.Renderer.WebGL.WebGLRenderer) - The renderer to use."
  ([scene-manager renderer]
   (phaser->clj
    (.render scene-manager
             (clj->phaser renderer)))))

(defn resume
  "Resumes the given Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to resume.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted by its resume event.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.resume scene-manager
             (clj->phaser key))))
  ([scene-manager key data]
   (phaser->clj
    (.resume scene-manager
             (clj->phaser key)
             (clj->phaser data)))))

(defn run
  "Runs the given Scene.

  If the given Scene is paused, it will resume it. If sleeping, it will wake it.
  If not running at all, it will be started.

  Use this if you wish to open a modal Scene by calling `pause` on the current
  Scene, then `run` on the modal Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to run.
    * data (object) {optional} - A data object that will be passed to the Scene on start, wake, or resume.

  Returns:  Phaser.Scenes.SceneManager - This Scene Manager."
  ([scene-manager key]
   (phaser->clj
    (.run scene-manager
          (clj->phaser key))))
  ([scene-manager key data]
   (phaser->clj
    (.run scene-manager
          (clj->phaser key)
          (clj->phaser data)))))

(defn send-to-back
  "Sends a Scene to the back of the Scenes list.

  This means it will render below all other Scenes.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string | Phaser.Scene) - The Scene to move.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.sendToBack scene-manager
                 (clj->phaser key)))))

(defn sleep
  "Puts the given Scene to sleep.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to put to sleep.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted by its sleep event.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.sleep scene-manager
            (clj->phaser key))))
  ([scene-manager key data]
   (phaser->clj
    (.sleep scene-manager
            (clj->phaser key)
            (clj->phaser data)))))

(defn start
  "Starts the given Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to start.
    * data (object) {optional} - Optional data object to pass to Scene.Settings and Scene.init.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.start scene-manager
            (clj->phaser key))))
  ([scene-manager key data]
   (phaser->clj
    (.start scene-manager
            (clj->phaser key)
            (clj->phaser data)))))

(defn stop
  "Stops the given Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to stop.
    * data (object) {optional} - Optional data object to pass to Scene.shutdown.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.stop scene-manager
           (clj->phaser key))))
  ([scene-manager key data]
   (phaser->clj
    (.stop scene-manager
           (clj->phaser key)
           (clj->phaser data)))))

(defn swap-position
  "Swaps the positions of two Scenes in the Scenes list.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key-a (string | Phaser.Scene) - The first Scene to swap.
    * key-b (string | Phaser.Scene) - The second Scene to swap.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key-a key-b]
   (phaser->clj
    (.swapPosition scene-manager
                   (clj->phaser key-a)
                   (clj->phaser key-b)))))

(defn switch
  "Sleeps one one Scene and starts the other.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * from (string) - The Scene to sleep.
    * to (string) - The Scene to start.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager from to]
   (phaser->clj
    (.switch scene-manager
             (clj->phaser from)
             (clj->phaser to)))))

(defn update
  "Updates the Scenes.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * time (number) - Time elapsed.
    * delta (number) - Delta time from the last update."
  ([scene-manager time delta]
   (phaser->clj
    (.update scene-manager
             (clj->phaser time)
             (clj->phaser delta)))))

(defn wake
  "Awakens the given Scene.

  Parameters:
    * scene-manager (Phaser.Scenes.SceneManager) - Targeted instance for method
    * key (string) - The Scene to wake up.
    * data (object) {optional} - An optional data object that will be passed to the Scene and emitted by its wake event.

  Returns:  Phaser.Scenes.SceneManager - This SceneManager."
  ([scene-manager key]
   (phaser->clj
    (.wake scene-manager
           (clj->phaser key))))
  ([scene-manager key data]
   (phaser->clj
    (.wake scene-manager
           (clj->phaser key)
           (clj->phaser data)))))