(ns phzr.textures.frame
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone]))

(defn ->Frame
  "  Parameters:
    * texture (Phaser.Textures.Texture) - The Texture this Frame is a part of.
    * name (integer | string) - The name of this Frame. The name is unique within the Texture.
    * source-index (integer) - The index of the TextureSource that this Frame is a part of.
    * x (number) - The x coordinate of the top-left of this Frame.
    * y (number) - The y coordinate of the top-left of this Frame.
    * width (number) - The width of this Frame.
    * height (number) - The height of this Frame."
  ([texture name source-index x y width height]
   (js/Phaser.Textures.Frame. (clj->phaser texture)
                              (clj->phaser name)
                              (clj->phaser source-index)
                              (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser width)
                              (clj->phaser height))))

(defn clone
  "Clones this Frame into a new Frame object.

  Returns:  Phaser.Textures.Frame - A clone of this Frame."
  ([frame]
   (phaser->clj
    (.clone frame))))

(defn destroy
  "Destroys this Frame by nulling its reference to the parent Texture and and data objects."
  ([frame]
   (phaser->clj
    (.destroy frame))))

(defn set-crop-u-vs
  "Takes a crop data object and, based on the rectangular region given, calculates the
  required UV coordinates in order to crop this Frame for WebGL and Canvas rendering.

  This is called directly by the Game Object Texture Components `setCrop` method.
  Please use that method to crop a Game Object.

  Parameters:
    * frame (Phaser.Textures.Frame) - Targeted instance for method
    * crop (object) - The crop data object. This is the `GameObject._crop` property.
    * x (number) - The x coordinate to start the crop from. Cannot be negative or exceed the Frame width.
    * y (number) - The y coordinate to start the crop from. Cannot be negative or exceed the Frame height.
    * width (number) - The width of the crop rectangle. Cannot exceed the Frame width.
    * height (number) - The height of the crop rectangle. Cannot exceed the Frame height.
    * flip-x (boolean) - Does the parent Game Object have flipX set?
    * flip-y (boolean) - Does the parent Game Object have flipY set?

  Returns:  object - The updated crop data object."
  ([frame crop x y width height flip-x flip-y]
   (phaser->clj
    (.setCropUVs frame
                 (clj->phaser crop)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser width)
                 (clj->phaser height)
                 (clj->phaser flip-x)
                 (clj->phaser flip-y)))))

(defn set-size
  "Sets the width, height, x and y of this Frame.

  This is called automatically by the constructor
  and should rarely be changed on-the-fly.

  Parameters:
    * frame (Phaser.Textures.Frame) - Targeted instance for method
    * width (integer) - The width of the frame before being trimmed.
    * height (integer) - The height of the frame before being trimmed.
    * x (integer) {optional} - The x coordinate of the top-left of this Frame.
    * y (integer) {optional} - The y coordinate of the top-left of this Frame.

  Returns:  Phaser.Textures.Frame - This Frame object."
  ([frame width height]
   (phaser->clj
    (.setSize frame
              (clj->phaser width)
              (clj->phaser height))))
  ([frame width height x]
   (phaser->clj
    (.setSize frame
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser x))))
  ([frame width height x y]
   (phaser->clj
    (.setSize frame
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-trim
  "If the frame was trimmed when added to the Texture Atlas, this records the trim and source data.

  Parameters:
    * frame (Phaser.Textures.Frame) - Targeted instance for method
    * actual-width (number) - The width of the frame before being trimmed.
    * actual-height (number) - The height of the frame before being trimmed.
    * dest-x (number) - The destination X position of the trimmed frame for display.
    * dest-y (number) - The destination Y position of the trimmed frame for display.
    * dest-width (number) - The destination width of the trimmed frame for display.
    * dest-height (number) - The destination height of the trimmed frame for display.

  Returns:  Phaser.Textures.Frame - This Frame object."
  ([frame actual-width actual-height dest-x dest-y dest-width dest-height]
   (phaser->clj
    (.setTrim frame
              (clj->phaser actual-width)
              (clj->phaser actual-height)
              (clj->phaser dest-x)
              (clj->phaser dest-y)
              (clj->phaser dest-width)
              (clj->phaser dest-height)))))

(defn update-crop-u-vs
  "Takes a crop data object and recalculates the UVs based on the dimensions inside the crop object.
  Called automatically by `setFrame`.

  Parameters:
    * frame (Phaser.Textures.Frame) - Targeted instance for method
    * crop (object) - The crop data object. This is the `GameObject._crop` property.
    * flip-x (boolean) - Does the parent Game Object have flipX set?
    * flip-y (boolean) - Does the parent Game Object have flipY set?

  Returns:  object - The updated crop data object."
  ([frame crop flip-x flip-y]
   (phaser->clj
    (.updateCropUVs frame
                    (clj->phaser crop)
                    (clj->phaser flip-x)
                    (clj->phaser flip-y)))))

(defn update-u-vs
  "Updates the internal WebGL UV cache and the drawImage cache.

  Returns:  Phaser.Textures.Frame - This Frame object."
  ([frame]
   (phaser->clj
    (.updateUVs frame))))

(defn update-u-vs-inverted
  "Updates the internal WebGL UV cache.

  Returns:  Phaser.Textures.Frame - This Frame object."
  ([frame]
   (phaser->clj
    (.updateUVsInverted frame))))