(ns phzr.game-objects.lights-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->LightsManager
  ""
  ([]
   (js/Phaser.GameObjects.LightsManager.)))

(defn add-light
  "Add a Light.

  Parameters:
    * lights-manager (Phaser.GameObjects.LightsManager) - Targeted instance for method
    * x (number) {optional} - The horizontal position of the Light.
    * y (number) {optional} - The vertical position of the Light.
    * radius (number) {optional} - The radius of the Light.
    * rgb (number) {optional} - The integer RGB color of the light.
    * intensity (number) {optional} - The intensity of the Light.

  Returns:  Phaser.GameObjects.Light - The Light that was added."
  ([lights-manager]
   (phaser->clj
    (.addLight lights-manager)))
  ([lights-manager x]
   (phaser->clj
    (.addLight lights-manager
               (clj->phaser x))))
  ([lights-manager x y]
   (phaser->clj
    (.addLight lights-manager
               (clj->phaser x)
               (clj->phaser y))))
  ([lights-manager x y radius]
   (phaser->clj
    (.addLight lights-manager
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser radius))))
  ([lights-manager x y radius rgb]
   (phaser->clj
    (.addLight lights-manager
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser radius)
               (clj->phaser rgb))))
  ([lights-manager x y radius rgb intensity]
   (phaser->clj
    (.addLight lights-manager
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser radius)
               (clj->phaser rgb)
               (clj->phaser intensity)))))

(defn cull
  "Cull any Lights that aren't visible to the given Camera.

  Culling Lights improves performance by ensuring that only Lights within a Camera's viewport are rendered.

  Parameters:
    * lights-manager (Phaser.GameObjects.LightsManager) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to cull Lights for.

  Returns:  Array.<Phaser.GameObjects.Light> - The culled Lights."
  ([lights-manager camera]
   (phaser->clj
    (.cull lights-manager
           (clj->phaser camera)))))

(defn destroy
  "Destroy the Lights Manager.

  Cleans up all references by calling {@link Phaser.GameObjects.LightsManager#shutdown}."
  ([lights-manager]
   (phaser->clj
    (.destroy lights-manager))))

(defn disable
  "Disable the Lights Manager.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-manager]
   (phaser->clj
    (.disable lights-manager))))

(defn enable
  "Enable the Lights Manager.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-manager]
   (phaser->clj
    (.enable lights-manager))))

(defn for-each-light
  "Iterate over each Light with a callback.

  Parameters:
    * lights-manager (Phaser.GameObjects.LightsManager) - Targeted instance for method
    * callback (LightForEach) - The callback that is called with each Light.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-manager callback]
   (phaser->clj
    (.forEachLight lights-manager
                   (clj->phaser callback)))))

(defn get-light-count
  "Get the number of Lights managed by this Lights Manager.

  Returns:  integer - The number of Lights managed by this Lights Manager."
  ([lights-manager]
   (phaser->clj
    (.getLightCount lights-manager))))

(defn get-max-visible-lights
  "Returns the maximum number of Lights allowed to appear at once.

  Returns:  integer - The maximum number of Lights allowed to appear at once."
  ([lights-manager]
   (phaser->clj
    (.getMaxVisibleLights lights-manager))))

(defn remove-light
  "Remove a Light.

  Parameters:
    * lights-manager (Phaser.GameObjects.LightsManager) - Targeted instance for method
    * light (Phaser.GameObjects.Light) - The Light to remove.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-manager light]
   (phaser->clj
    (.removeLight lights-manager
                  (clj->phaser light)))))

(defn set-ambient-color
  "Set the ambient light color.

  Parameters:
    * lights-manager (Phaser.GameObjects.LightsManager) - Targeted instance for method
    * rgb (number) - The integer RGB color of the ambient light.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-manager rgb]
   (phaser->clj
    (.setAmbientColor lights-manager
                      (clj->phaser rgb)))))

(defn shutdown
  "Shut down the Lights Manager.

  Recycles all active Lights into the Light pool, resets ambient light color and clears the lists of Lights and
  culled Lights."
  ([lights-manager]
   (phaser->clj
    (.shutdown lights-manager))))