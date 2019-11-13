(ns phzr.game-objects.light
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [set]))

(defn ->Light
  "  Parameters:
    * x (number) - The horizontal position of the light.
    * y (number) - The vertical position of the light.
    * radius (number) - The radius of the light.
    * r (number) - The red color of the light. A value between 0 and 1.
    * g (number) - The green color of the light. A value between 0 and 1.
    * b (number) - The blue color of the light. A value between 0 and 1.
    * intensity (number) - The intensity of the light."
  ([x y radius r g b intensity]
   (js/Phaser.GameObjects.Light. (clj->phaser x)
                                 (clj->phaser y)
                                 (clj->phaser radius)
                                 (clj->phaser r)
                                 (clj->phaser g)
                                 (clj->phaser b)
                                 (clj->phaser intensity))))

(defn set
  "Set the properties of the light.

  Sets both horizontal and vertical scroll factor to 1. Use {@link Phaser.GameObjects.Light#setScrollFactor} to set
  the scroll factor.

  Parameters:
    * light (Phaser.GameObjects.Light) - Targeted instance for method
    * x (number) - The horizontal position of the light.
    * y (number) - The vertical position of the light.
    * radius (number) - The radius of the light.
    * r (number) - The red color. A value between 0 and 1.
    * g (number) - The green color. A value between 0 and 1.
    * b (number) - The blue color. A value between 0 and 1.
    * intensity (number) - The intensity of the light.

  Returns:  Phaser.GameObjects.Light - This Light object."
  ([light x y radius r g b intensity]
   (phaser->clj
    (.set light
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser r)
          (clj->phaser g)
          (clj->phaser b)
          (clj->phaser intensity)))))

(defn set-color
  "Set the color of the light from a single integer RGB value.

  Parameters:
    * light (Phaser.GameObjects.Light) - Targeted instance for method
    * rgb (number) - The integer RGB color of the light.

  Returns:  Phaser.GameObjects.Light - This Light object."
  ([light rgb]
   (phaser->clj
    (.setColor light
               (clj->phaser rgb)))))

(defn set-intensity
  "Set the intensity of the light.

  Parameters:
    * light (Phaser.GameObjects.Light) - Targeted instance for method
    * intensity (number) - The intensity of the light.

  Returns:  Phaser.GameObjects.Light - This Light object."
  ([light intensity]
   (phaser->clj
    (.setIntensity light
                   (clj->phaser intensity)))))

(defn set-position
  "Set the position of the light.

  Parameters:
    * light (Phaser.GameObjects.Light) - Targeted instance for method
    * x (number) - The horizontal position of the light.
    * y (number) - The vertical position of the light.

  Returns:  Phaser.GameObjects.Light - This Light object."
  ([light x y]
   (phaser->clj
    (.setPosition light
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-radius
  "Set the radius of the light.

  Parameters:
    * light (Phaser.GameObjects.Light) - Targeted instance for method
    * radius (number) - The radius of the light.

  Returns:  Phaser.GameObjects.Light - This Light object."
  ([light radius]
   (phaser->clj
    (.setRadius light
                (clj->phaser radius)))))

(defn set-scroll-factor
  "Set the scroll factor of the light.

  Parameters:
    * light (Phaser.GameObjects.Light) - Targeted instance for method
    * x (number) - The horizontal scroll factor of the light.
    * y (number) - The vertical scroll factor of the light.

  Returns:  Phaser.GameObjects.Light - This Light object."
  ([light x y]
   (phaser->clj
    (.setScrollFactor light
                      (clj->phaser x)
                      (clj->phaser y)))))