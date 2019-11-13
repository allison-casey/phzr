(ns phzr.game-objects.bob
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Bob
  "  Parameters:
    * blitter (Phaser.GameObjects.Blitter) - The parent Blitter object is responsible for updating this Bob.
    * x (number) - The horizontal position of this Game Object in the world, relative to the parent Blitter position.
    * y (number) - The vertical position of this Game Object in the world, relative to the parent Blitter position.
    * frame (string | integer) - The Frame this Bob will render with, as defined in the Texture the parent Blitter is using.
    * visible (boolean) - Should the Bob render visible or not to start with?"
  ([blitter x y frame visible]
   (js/Phaser.GameObjects.Bob. (clj->phaser blitter)
                               (clj->phaser x)
                               (clj->phaser y)
                               (clj->phaser frame)
                               (clj->phaser visible))))

(defn destroy
  "Destroys this Bob instance.
  Removes itself from the Blitter and clears the parent, frame and data properties."
  ([bob]
   (phaser->clj
    (.destroy bob))))

(defn reset
  "Resets this Bob.

  Changes the position to the values given, and optionally changes the frame.

  Also resets the flipX and flipY values, sets alpha back to 1 and visible to true.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * x (number) - The x position of the Bob. Bob coordinate are relative to the position of the Blitter object.
    * y (number) - The y position of the Bob. Bob coordinate are relative to the position of the Blitter object.
    * frame (string | integer | Phaser.Textures.Frame) {optional} - The Frame the Bob will use. It _must_ be part of the Texture the parent Blitter object is using.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob x y]
   (phaser->clj
    (.reset bob
            (clj->phaser x)
            (clj->phaser y))))
  ([bob x y frame]
   (phaser->clj
    (.reset bob
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser frame)))))

(defn reset-flip
  "Resets the horizontal and vertical flipped state of this Bob back to their default un-flipped state.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob]
   (phaser->clj
    (.resetFlip bob))))

(defn set-alpha
  "Set the Alpha level of this Bob. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  A Bob with alpha 0 will skip rendering.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * value (number) - The alpha value used for this Bob. Between 0 and 1.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob value]
   (phaser->clj
    (.setAlpha bob
               (clj->phaser value)))))

(defn set-flip
  "Sets the horizontal and vertical flipped state of this Bob.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * x (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.
    * y (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob x y]
   (phaser->clj
    (.setFlip bob
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-flip-x
  "Sets the horizontal flipped state of this Bob.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob value]
   (phaser->clj
    (.setFlipX bob
               (clj->phaser value)))))

(defn set-flip-y
  "Sets the vertical flipped state of this Bob.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob value]
   (phaser->clj
    (.setFlipY bob
               (clj->phaser value)))))

(defn set-frame
  "Changes the Texture Frame being used by this Bob.
  The frame must be part of the Texture the parent Blitter is using.
  If no value is given it will use the default frame of the Blitter parent.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * frame (string | integer | Phaser.Textures.Frame) {optional} - The frame to be used during rendering.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob]
   (phaser->clj
    (.setFrame bob)))
  ([bob frame]
   (phaser->clj
    (.setFrame bob
               (clj->phaser frame)))))

(defn set-position
  "Changes the position of this Bob to the values given.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * x (number) - The x position of the Bob. Bob coordinate are relative to the position of the Blitter object.
    * y (number) - The y position of the Bob. Bob coordinate are relative to the position of the Blitter object.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob x y]
   (phaser->clj
    (.setPosition bob
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-tint
  "Sets the tint of this Bob.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * value (number) - The tint value used for this Bob. Between 0 and 0xffffff.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob value]
   (phaser->clj
    (.setTint bob
              (clj->phaser value)))))

(defn set-visible
  "Sets the visibility of this Bob.

  An invisible Bob will skip rendering.

  Parameters:
    * bob (Phaser.GameObjects.Bob) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  Phaser.GameObjects.Bob - This Bob Game Object."
  ([bob value]
   (phaser->clj
    (.setVisible bob
                 (clj->phaser value)))))