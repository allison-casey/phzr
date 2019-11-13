(ns phzr.game-objects.text-style
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->TextStyle
  "  Parameters:
    * text (Phaser.GameObjects.Text) - The Text object that this TextStyle is styling.
    * style (Phaser.Types.GameObjects.Text.TextStyle) - The style settings to set."
  ([text style]
   (js/Phaser.GameObjects.TextStyle. (clj->phaser text)
                                     (clj->phaser style))))

(defn destroy
  "Destroy this Text Style."
  ([text-style]
   (phaser->clj
    (.destroy text-style))))

(defn get-text-metrics
  "Get the current text metrics.

  Returns:  Phaser.Types.GameObjects.Text.TextMetrics - The text metrics."
  ([text-style]
   (phaser->clj
    (.getTextMetrics text-style))))

(defn set-align
  "Set the alignment of the text in this Text object.

  The argument can be one of: `left`, `right`, `center` or `justify`.

  Alignment only works if the Text object has more than one line of text.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * align (string) {optional} - The text alignment for multi-line text.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style]
   (phaser->clj
    (.setAlign text-style)))
  ([text-style align]
   (phaser->clj
    (.setAlign text-style
               (clj->phaser align)))))

(defn set-background-color
  "Set the background color.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * color (string) - The background color.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style color]
   (phaser->clj
    (.setBackgroundColor text-style
                         (clj->phaser color)))))

(defn set-color
  "Set the text fill color.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * color (string) - The text fill color.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style color]
   (phaser->clj
    (.setColor text-style
               (clj->phaser color)))))

(defn set-fill
  "Set the text fill color.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * color (string) - The text fill color.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style color]
   (phaser->clj
    (.setFill text-style
              (clj->phaser color)))))

(defn set-fixed-size
  "Set a fixed width and height for the text.

  Pass in `0` for either of these parameters to disable fixed width or height respectively.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * width (number) - The fixed width to set.
    * height (number) - The fixed height to set.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style width height]
   (phaser->clj
    (.setFixedSize text-style
                   (clj->phaser width)
                   (clj->phaser height)))))

(defn set-font
  "Set the font.

  If a string is given, the font family is set.

  If an object is given, the `fontFamily`, `fontSize` and `fontStyle`
  properties of that object are set.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * font (string | object) - The font family or font settings to set.
    * update-text (boolean) {optional} - Whether to update the text immediately.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style font]
   (phaser->clj
    (.setFont text-style
              (clj->phaser font))))
  ([text-style font update-text]
   (phaser->clj
    (.setFont text-style
              (clj->phaser font)
              (clj->phaser update-text)))))

(defn set-font-family
  "Set the font family.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * family (string) - The font family.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style family]
   (phaser->clj
    (.setFontFamily text-style
                    (clj->phaser family)))))

(defn set-font-size
  "Set the font size.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * size (number | string) - The font size.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style size]
   (phaser->clj
    (.setFontSize text-style
                  (clj->phaser size)))))

(defn set-font-style
  "Set the font style.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * style (string) - The font style.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style style]
   (phaser->clj
    (.setFontStyle text-style
                   (clj->phaser style)))))

(defn set-max-lines
  "Set the maximum number of lines to draw.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * max (integer) {optional} - The maximum number of lines to draw.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style]
   (phaser->clj
    (.setMaxLines text-style)))
  ([text-style max]
   (phaser->clj
    (.setMaxLines text-style
                  (clj->phaser max)))))

(defn set-resolution
  "Set the resolution used by the Text object.

  By default it will be set to match the resolution set in the Game Config,
  but you can override it via this method. It allows for much clearer text on High DPI devices,
  at the cost of memory because it uses larger internal Canvas textures for the Text.

  Please use with caution, as the more high res Text you have, the more memory it uses up.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * value (number) - The resolution for this Text object to use.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style value]
   (phaser->clj
    (.setResolution text-style
                    (clj->phaser value)))))

(defn set-shadow
  "Set the shadow settings.

  Calling this method always re-measures the parent Text object,
  so only call it when you actually change the shadow settings.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * x (number) {optional} - The horizontal shadow offset.
    * y (number) {optional} - The vertical shadow offset.
    * color (string) {optional} - The shadow color.
    * blur (number) {optional} - The shadow blur radius.
    * shadow-stroke (boolean) {optional} - Whether to stroke the shadow.
    * shadow-fill (boolean) {optional} - Whether to fill the shadow.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style]
   (phaser->clj
    (.setShadow text-style)))
  ([text-style x]
   (phaser->clj
    (.setShadow text-style
                (clj->phaser x))))
  ([text-style x y]
   (phaser->clj
    (.setShadow text-style
                (clj->phaser x)
                (clj->phaser y))))
  ([text-style x y color]
   (phaser->clj
    (.setShadow text-style
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser color))))
  ([text-style x y color blur]
   (phaser->clj
    (.setShadow text-style
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser color)
                (clj->phaser blur))))
  ([text-style x y color blur shadow-stroke]
   (phaser->clj
    (.setShadow text-style
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser color)
                (clj->phaser blur)
                (clj->phaser shadow-stroke))))
  ([text-style x y color blur shadow-stroke shadow-fill]
   (phaser->clj
    (.setShadow text-style
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser color)
                (clj->phaser blur)
                (clj->phaser shadow-stroke)
                (clj->phaser shadow-fill)))))

(defn set-shadow-blur
  "Set the shadow blur radius.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * blur (number) {optional} - The shadow blur radius.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style]
   (phaser->clj
    (.setShadowBlur text-style)))
  ([text-style blur]
   (phaser->clj
    (.setShadowBlur text-style
                    (clj->phaser blur)))))

(defn set-shadow-color
  "Set the shadow color.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * color (string) {optional} - The shadow color.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style]
   (phaser->clj
    (.setShadowColor text-style)))
  ([text-style color]
   (phaser->clj
    (.setShadowColor text-style
                     (clj->phaser color)))))

(defn set-shadow-fill
  "Enable or disable shadow fill.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * enabled (boolean) - Whether shadow fill is enabled or not.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style enabled]
   (phaser->clj
    (.setShadowFill text-style
                    (clj->phaser enabled)))))

(defn set-shadow-offset
  "Set the shadow offset.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * x (number) {optional} - The horizontal shadow offset.
    * y (number) {optional} - The vertical shadow offset.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style]
   (phaser->clj
    (.setShadowOffset text-style)))
  ([text-style x]
   (phaser->clj
    (.setShadowOffset text-style
                      (clj->phaser x))))
  ([text-style x y]
   (phaser->clj
    (.setShadowOffset text-style
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-shadow-stroke
  "Enable or disable shadow stroke.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * enabled (boolean) - Whether shadow stroke is enabled or not.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style enabled]
   (phaser->clj
    (.setShadowStroke text-style
                      (clj->phaser enabled)))))

(defn set-stroke
  "Set the stroke settings.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * color (string) - The stroke color.
    * thickness (number) - The stroke thickness.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style color thickness]
   (phaser->clj
    (.setStroke text-style
                (clj->phaser color)
                (clj->phaser thickness)))))

(defn set-style
  "Set the text style.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * style (Phaser.Types.GameObjects.Text.TextStyle) - The style settings to set.
    * update-text (boolean) {optional} - Whether to update the text immediately.
    * set-defaults (boolean) {optional} - Use the default values is not set, or the local values.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style style]
   (phaser->clj
    (.setStyle text-style
               (clj->phaser style))))
  ([text-style style update-text]
   (phaser->clj
    (.setStyle text-style
               (clj->phaser style)
               (clj->phaser update-text))))
  ([text-style style update-text set-defaults]
   (phaser->clj
    (.setStyle text-style
               (clj->phaser style)
               (clj->phaser update-text)
               (clj->phaser set-defaults)))))

(defn set-test-string
  "Set the test string to use when measuring the font.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * string (string) - The test string to use when measuring the font.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style string]
   (phaser->clj
    (.setTestString text-style
                    (clj->phaser string)))))

(defn set-word-wrap-callback
  "Set a custom callback for wrapping lines.

  Pass in null to remove wrapping by callback.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * callback (TextStyleWordWrapCallback) - A custom function that will be responsible for wrapping the
text. It will receive two arguments: text (the string to wrap), textObject (this Text
instance). It should return the wrapped lines either as an array of lines or as a string with
newline characters in place to indicate where breaks should happen.
    * scope (object) {optional} - The scope that will be applied when the callback is invoked.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style callback]
   (phaser->clj
    (.setWordWrapCallback text-style
                          (clj->phaser callback))))
  ([text-style callback scope]
   (phaser->clj
    (.setWordWrapCallback text-style
                          (clj->phaser callback)
                          (clj->phaser scope)))))

(defn set-word-wrap-width
  "Set the width (in pixels) to use for wrapping lines.

  Pass in null to remove wrapping by width.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * width (number) - The maximum width of a line in pixels. Set to null to remove wrapping.
    * use-advanced-wrap (boolean) {optional} - Whether or not to use the advanced wrapping
algorithm. If true, spaces are collapsed and whitespace is trimmed from lines. If false,
spaces and whitespace are left as is.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style width]
   (phaser->clj
    (.setWordWrapWidth text-style
                       (clj->phaser width))))
  ([text-style width use-advanced-wrap]
   (phaser->clj
    (.setWordWrapWidth text-style
                       (clj->phaser width)
                       (clj->phaser use-advanced-wrap)))))

(defn sync-font
  "Synchronize the font settings to the given Canvas Rendering Context.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * canvas (HTMLCanvasElement) - The Canvas Element.
    * context (CanvasRenderingContext2D) - The Canvas Rendering Context."
  ([text-style canvas context]
   (phaser->clj
    (.syncFont text-style
               (clj->phaser canvas)
               (clj->phaser context)))))

(defn sync-shadow
  "Synchronize the shadow settings to the given Canvas Rendering Context.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * context (CanvasRenderingContext2D) - The Canvas Rendering Context.
    * enabled (boolean) - Whether shadows are enabled or not."
  ([text-style context enabled]
   (phaser->clj
    (.syncShadow text-style
                 (clj->phaser context)
                 (clj->phaser enabled)))))

(defn sync-style
  "Synchronize the text style settings to the given Canvas Rendering Context.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * canvas (HTMLCanvasElement) - The Canvas Element.
    * context (CanvasRenderingContext2D) - The Canvas Rendering Context."
  ([text-style canvas context]
   (phaser->clj
    (.syncStyle text-style
                (clj->phaser canvas)
                (clj->phaser context)))))

(defn to-json
  "Build a JSON representation of this Text Style.

  Returns:  object - A JSON representation of this Text Style."
  ([text-style]
   (phaser->clj
    (.toJSON text-style))))

(defn update
  "Update the style settings for the parent Text object.

  Parameters:
    * text-style (Phaser.GameObjects.TextStyle) - Targeted instance for method
    * recalculate-metrics (boolean) - Whether to recalculate font and text metrics.

  Returns:  Phaser.GameObjects.Text - The parent Text object."
  ([text-style recalculate-metrics]
   (phaser->clj
    (.update text-style
             (clj->phaser recalculate-metrics)))))