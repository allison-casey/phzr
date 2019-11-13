(ns phzr.game-objects.lights-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->LightsPlugin
  "  Parameters:
    * scene (Phaser.Scene) - The Scene that this Lights Plugin belongs to."
  ([scene]
   (js/Phaser.GameObjects.LightsPlugin. (clj->phaser scene))))

(defn add-light
  "Add a Light.

  Parameters:
    * lights-plugin (Phaser.GameObjects.LightsPlugin) - Targeted instance for method
    * x (number) {optional} - The horizontal position of the Light.
    * y (number) {optional} - The vertical position of the Light.
    * radius (number) {optional} - The radius of the Light.
    * rgb (number) {optional} - The integer RGB color of the light.
    * intensity (number) {optional} - The intensity of the Light.

  Returns:  Phaser.GameObjects.Light - The Light that was added."
  ([lights-plugin]
   (phaser->clj
    (.addLight lights-plugin)))
  ([lights-plugin x]
   (phaser->clj
    (.addLight lights-plugin
               (clj->phaser x))))
  ([lights-plugin x y]
   (phaser->clj
    (.addLight lights-plugin
               (clj->phaser x)
               (clj->phaser y))))
  ([lights-plugin x y radius]
   (phaser->clj
    (.addLight lights-plugin
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser radius))))
  ([lights-plugin x y radius rgb]
   (phaser->clj
    (.addLight lights-plugin
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser radius)
               (clj->phaser rgb))))
  ([lights-plugin x y radius rgb intensity]
   (phaser->clj
    (.addLight lights-plugin
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser radius)
               (clj->phaser rgb)
               (clj->phaser intensity)))))

(defn boot
  "Boot the Lights Plugin."
  ([lights-plugin]
   (phaser->clj
    (.boot lights-plugin))))

(defn cull
  "Cull any Lights that aren't visible to the given Camera.

  Culling Lights improves performance by ensuring that only Lights within a Camera's viewport are rendered.

  Parameters:
    * lights-plugin (Phaser.GameObjects.LightsPlugin) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to cull Lights for.

  Returns:  Array.<Phaser.GameObjects.Light> - The culled Lights."
  ([lights-plugin camera]
   (phaser->clj
    (.cull lights-plugin
           (clj->phaser camera)))))

(defn destroy
  "Destroy the Lights Plugin.

  Cleans up all references."
  ([lights-plugin]
   (phaser->clj
    (.destroy lights-plugin))))

(defn disable
  "Disable the Lights Manager.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-plugin]
   (phaser->clj
    (.disable lights-plugin))))

(defn enable
  "Enable the Lights Manager.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-plugin]
   (phaser->clj
    (.enable lights-plugin))))

(defn for-each-light
  "Iterate over each Light with a callback.

  Parameters:
    * lights-plugin (Phaser.GameObjects.LightsPlugin) - Targeted instance for method
    * callback (LightForEach) - The callback that is called with each Light.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-plugin callback]
   (phaser->clj
    (.forEachLight lights-plugin
                   (clj->phaser callback)))))

(defn get-light-count
  "Get the number of Lights managed by this Lights Manager.

  Returns:  integer - The number of Lights managed by this Lights Manager."
  ([lights-plugin]
   (phaser->clj
    (.getLightCount lights-plugin))))

(defn get-max-visible-lights
  "Returns the maximum number of Lights allowed to appear at once.

  Returns:  integer - The maximum number of Lights allowed to appear at once."
  ([lights-plugin]
   (phaser->clj
    (.getMaxVisibleLights lights-plugin))))

(defn remove-light
  "Remove a Light.

  Parameters:
    * lights-plugin (Phaser.GameObjects.LightsPlugin) - Targeted instance for method
    * light (Phaser.GameObjects.Light) - The Light to remove.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-plugin light]
   (phaser->clj
    (.removeLight lights-plugin
                  (clj->phaser light)))))

(defn set-ambient-color
  "Set the ambient light color.

  Parameters:
    * lights-plugin (Phaser.GameObjects.LightsPlugin) - Targeted instance for method
    * rgb (number) - The integer RGB color of the ambient light.

  Returns:  Phaser.GameObjects.LightsManager - This Lights Manager object."
  ([lights-plugin rgb]
   (phaser->clj
    (.setAmbientColor lights-plugin
                      (clj->phaser rgb)))))

(defn shutdown
  "Shut down the Lights Manager.

  Recycles all active Lights into the Light pool, resets ambient light color and clears the lists of Lights and
  culled Lights."
  ([lights-plugin]
   (phaser->clj
    (.shutdown lights-plugin))))