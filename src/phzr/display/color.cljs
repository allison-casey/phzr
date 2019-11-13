(ns phzr.display.color
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone]))

(defn ->Color
  "  Parameters:
    * red (integer) {optional} - The red color value. A number between 0 and 255.
    * green (integer) {optional} - The green color value. A number between 0 and 255.
    * blue (integer) {optional} - The blue color value. A number between 0 and 255.
    * alpha (integer) {optional} - The alpha value. A number between 0 and 255."
  ([]
   (js/Phaser.Display.Color.))
  ([red]
   (js/Phaser.Display.Color. (clj->phaser red)))
  ([red green]
   (js/Phaser.Display.Color. (clj->phaser red)
                             (clj->phaser green)))
  ([red green blue]
   (js/Phaser.Display.Color. (clj->phaser red)
                             (clj->phaser green)
                             (clj->phaser blue)))
  ([red green blue alpha]
   (js/Phaser.Display.Color. (clj->phaser red)
                             (clj->phaser green)
                             (clj->phaser blue)
                             (clj->phaser alpha))))

(defn brighten
  "Brighten this Color by the percentage amount given.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * amount (integer) - The percentage amount to change this color by. A value between 0 and 100.

  Returns:  Phaser.Display.Color - This Color object."
  ([color amount]
   (phaser->clj
    (.brighten color
               (clj->phaser amount)))))

(defn clone
  "Returns a new Color component using the values from this one.

  Returns:  Phaser.Display.Color - A new Color object."
  ([color]
   (phaser->clj
    (.clone color))))

(defn color-to-rgba
  "Converts the given color value into an Object containing r,g,b and a properties.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * color (number) - A color value, optionally including the alpha value.

  Returns:  Phaser.Types.Display.ColorObject - An object containing the parsed color values."
  ([color color]
   (phaser->clj
    (.ColorToRGBA color
                  (clj->phaser color)))))

(defn component-to-hex
  "Returns a string containing a hex representation of the given color component.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * color (integer) - The color channel to get the hex value for, must be a value between 0 and 255.

  Returns:  string - A string of length 2 characters, i.e. 255 = ff, 100 = 64."
  ([color color]
   (phaser->clj
    (.ComponentToHex color
                     (clj->phaser color)))))

(defn darken
  "Decrease the lightness of this Color by the percentage amount given.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * amount (integer) - The percentage amount to change this color by. A value between 0 and 100.

  Returns:  Phaser.Display.Color - This Color object."
  ([color amount]
   (phaser->clj
    (.darken color
             (clj->phaser amount)))))

(defn desaturate
  "Decrease the saturation of this Color by the percentage amount given.
  The saturation is the amount of the base color in the hue.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * amount (integer) - The percentage amount to change this color by. A value between 0 and 100.

  Returns:  Phaser.Display.Color - This Color object."
  ([color amount]
   (phaser->clj
    (.desaturate color
                 (clj->phaser amount)))))

(defn get-color
  "Given 3 separate color values this will return an integer representation of it.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * red (integer) - The red color value. A number between 0 and 255.
    * green (integer) - The green color value. A number between 0 and 255.
    * blue (integer) - The blue color value. A number between 0 and 255.

  Returns:  number - The combined color value."
  ([color red green blue]
   (phaser->clj
    (.GetColor color
               (clj->phaser red)
               (clj->phaser green)
               (clj->phaser blue)))))

(defn get-color-32
  "Given an alpha and 3 color values this will return an integer representation of it.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * red (integer) - The red color value. A number between 0 and 255.
    * green (integer) - The green color value. A number between 0 and 255.
    * blue (integer) - The blue color value. A number between 0 and 255.
    * alpha (integer) - The alpha color value. A number between 0 and 255.

  Returns:  number - The combined color value."
  ([color red green blue alpha]
   (phaser->clj
    (.GetColor32 color
                 (clj->phaser red)
                 (clj->phaser green)
                 (clj->phaser blue)
                 (clj->phaser alpha)))))

(defn gray
  "Sets this Color object to be grayscaled based on the shade value given.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * shade (integer) - A value between 0 and 255.

  Returns:  Phaser.Display.Color - This Color object."
  ([color shade]
   (phaser->clj
    (.gray color
           (clj->phaser shade)))))

(defn hex-string-to-color
  "Converts a hex string into a Phaser Color object.

  The hex string can supplied as `'#0033ff'` or the short-hand format of `'#03f'`; it can begin with an optional '#' or '0x', or be unprefixed.

  An alpha channel is _not_ supported.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * hex (string) - The hex color value to convert, such as `#0033ff` or the short-hand format: `#03f`.

  Returns:  Phaser.Display.Color - A Color object populated by the values of the given string."
  ([color hex]
   (phaser->clj
    (.HexStringToColor color
                       (clj->phaser hex)))))

(defn hsl-to-color
  "Converts HSL (hue, saturation and lightness) values to a Phaser Color object.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * h (number) - The hue value in the range 0 to 1.
    * s (number) - The saturation value in the range 0 to 1.
    * l (number) - The lightness value in the range 0 to 1.

  Returns:  Phaser.Display.Color - A Color object created from the results of the h, s and l values."
  ([color h s l]
   (phaser->clj
    (.HSLToColor color
                 (clj->phaser h)
                 (clj->phaser s)
                 (clj->phaser l)))))

(defn hsv-color-wheel
  "Get HSV color wheel values in an array which will be 360 elements in size.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * s (number) {optional} - The saturation, in the range 0 - 1.
    * v (number) {optional} - The value, in the range 0 - 1.

  Returns:  Array.<Phaser.Types.Display.ColorObject> - An array containing 360 elements, where each contains a single numeric value corresponding to the color at that point in the HSV color wheel."
  ([color]
   (phaser->clj
    (.HSVColorWheel color)))
  ([color s]
   (phaser->clj
    (.HSVColorWheel color
                    (clj->phaser s))))
  ([color s v]
   (phaser->clj
    (.HSVColorWheel color
                    (clj->phaser s)
                    (clj->phaser v)))))

(defn hsv-to-rgb
  "Converts an HSV (hue, saturation and value) color value to RGB.
  Conversion formula from http://en.wikipedia.org/wiki/HSL_color_space.
  Assumes HSV values are contained in the set [0, 1].
  Based on code by Michael Jackson (https://github.com/mjijackson)

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * h (number) - The hue, in the range 0 - 1. This is the base color.
    * s (number) - The saturation, in the range 0 - 1. This controls how much of the hue will be in the final color, where 1 is fully saturated and 0 will give you white.
    * v (number) - The value, in the range 0 - 1. This controls how dark the color is. Where 1 is as bright as possible and 0 is black.
    * out (Phaser.Types.Display.ColorObject | Phaser.Display.Color) {optional} - A Color object to store the results in. If not given a new ColorObject will be created.

  Returns:  Phaser.Types.Display.ColorObject | Phaser.Display.Color - An object with the red, green and blue values set in the r, g and b properties."
  ([color h s v]
   (phaser->clj
    (.HSVToRGB color
               (clj->phaser h)
               (clj->phaser s)
               (clj->phaser v))))
  ([color h s v out]
   (phaser->clj
    (.HSVToRGB color
               (clj->phaser h)
               (clj->phaser s)
               (clj->phaser v)
               (clj->phaser out)))))

(defn hue-to-component
  "Converts a hue to an RGB color.
  Based on code by Michael Jackson (https://github.com/mjijackson)

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * p (number) - No description
    * q (number) - No description
    * t (number) - No description

  Returns:  number - The combined color value."
  ([color p q t]
   (phaser->clj
    (.HueToComponent color
                     (clj->phaser p)
                     (clj->phaser q)
                     (clj->phaser t)))))

(defn integer-to-color
  "Converts the given color value into an instance of a Color object.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * input (integer) - The color value to convert into a Color object.

  Returns:  Phaser.Display.Color - A Color object."
  ([color input]
   (phaser->clj
    (.IntegerToColor color
                     (clj->phaser input)))))

(defn integer-to-rgb
  "Return the component parts of a color as an Object with the properties alpha, red, green, blue.

  Alpha will only be set if it exists in the given color (0xAARRGGBB)

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * input (integer) - The color value to convert into a Color object.

  Returns:  Phaser.Types.Display.ColorObject - An object with the red, green and blue values set in the r, g and b properties."
  ([color input]
   (phaser->clj
    (.IntegerToRGB color
                   (clj->phaser input)))))

(defn lighten
  "Increase the lightness of this Color by the percentage amount given.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * amount (integer) - The percentage amount to change this color by. A value between 0 and 100.

  Returns:  Phaser.Display.Color - This Color object."
  ([color amount]
   (phaser->clj
    (.lighten color
              (clj->phaser amount)))))

(defn object-to-color
  "Converts an object containing `r`, `g`, `b` and `a` properties into a Color class instance.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * input (Phaser.Types.Display.InputColorObject) - An object containing `r`, `g`, `b` and `a` properties in the range 0 to 255.

  Returns:  Phaser.Display.Color - A Color object."
  ([color input]
   (phaser->clj
    (.ObjectToColor color
                    (clj->phaser input)))))

(defn random
  "Sets this Color object to be a random color between the `min` and `max` values given.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * min (integer) {optional} - The minimum random color value. Between 0 and 255.
    * max (integer) {optional} - The maximum random color value. Between 0 and 255.

  Returns:  Phaser.Display.Color - This Color object."
  ([color]
   (phaser->clj
    (.random color)))
  ([color min]
   (phaser->clj
    (.random color
             (clj->phaser min))))
  ([color min max]
   (phaser->clj
    (.random color
             (clj->phaser min)
             (clj->phaser max)))))

(defn random-gray
  "Sets this Color object to be a random grayscale color between the `min` and `max` values given.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * min (integer) {optional} - The minimum random color value. Between 0 and 255.
    * max (integer) {optional} - The maximum random color value. Between 0 and 255.

  Returns:  Phaser.Display.Color - This Color object."
  ([color]
   (phaser->clj
    (.randomGray color)))
  ([color min]
   (phaser->clj
    (.randomGray color
                 (clj->phaser min))))
  ([color min max]
   (phaser->clj
    (.randomGray color
                 (clj->phaser min)
                 (clj->phaser max)))))

(defn random-rgb
  "Creates a new Color object where the r, g, and b values have been set to random values
  based on the given min max values.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * min (integer) {optional} - The minimum value to set the random range from (between 0 and 255)
    * max (integer) {optional} - The maximum value to set the random range from (between 0 and 255)

  Returns:  Phaser.Display.Color - A Color object."
  ([color]
   (phaser->clj
    (.RandomRGB color)))
  ([color min]
   (phaser->clj
    (.RandomRGB color
                (clj->phaser min))))
  ([color min max]
   (phaser->clj
    (.RandomRGB color
                (clj->phaser min)
                (clj->phaser max)))))

(defn rgb-string-to-color
  "Converts a CSS 'web' string into a Phaser Color object.

  The web string can be in the format `'rgb(r,g,b)'` or `'rgba(r,g,b,a)'` where r/g/b are in the range [0..255] and a is in the range [0..1].

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * rgb (string) - The CSS format color string, using the `rgb` or `rgba` format.

  Returns:  Phaser.Display.Color - A Color object."
  ([color rgb]
   (phaser->clj
    (.RGBStringToColor color
                       (clj->phaser rgb)))))

(defn rgb-to-hsv
  "Converts an RGB color value to HSV (hue, saturation and value).
  Conversion forumla from http://en.wikipedia.org/wiki/HSL_color_space.
  Assumes RGB values are contained in the set [0, 255] and returns h, s and v in the set [0, 1].
  Based on code by Michael Jackson (https://github.com/mjijackson)

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * r (integer) - The red color value. A number between 0 and 255.
    * g (integer) - The green color value. A number between 0 and 255.
    * b (integer) - The blue color value. A number between 0 and 255.
    * out (Phaser.Types.Display.HSVColorObject | Phaser.Display.Color) {optional} - An object to store the color values in. If not given an HSV Color Object will be created.

  Returns:  Phaser.Types.Display.HSVColorObject | Phaser.Display.Color - An object with the properties `h`, `s` and `v` set."
  ([color r g b]
   (phaser->clj
    (.RGBToHSV color
               (clj->phaser r)
               (clj->phaser g)
               (clj->phaser b))))
  ([color r g b out]
   (phaser->clj
    (.RGBToHSV color
               (clj->phaser r)
               (clj->phaser g)
               (clj->phaser b)
               (clj->phaser out)))))

(defn rgb-to-string
  "Converts the color values into an HTML compatible color string, prefixed with either `#` or `0x`.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * r (integer) - The red color value. A number between 0 and 255.
    * g (integer) - The green color value. A number between 0 and 255.
    * b (integer) - The blue color value. A number between 0 and 255.
    * a (integer) {optional} - The alpha value. A number between 0 and 255.
    * prefix (string) {optional} - The prefix of the string. Either `#` or `0x`.

  Returns:  string - A string-based representation of the color values."
  ([color r g b]
   (phaser->clj
    (.RGBToString color
                  (clj->phaser r)
                  (clj->phaser g)
                  (clj->phaser b))))
  ([color r g b a]
   (phaser->clj
    (.RGBToString color
                  (clj->phaser r)
                  (clj->phaser g)
                  (clj->phaser b)
                  (clj->phaser a))))
  ([color r g b a prefix]
   (phaser->clj
    (.RGBToString color
                  (clj->phaser r)
                  (clj->phaser g)
                  (clj->phaser b)
                  (clj->phaser a)
                  (clj->phaser prefix)))))

(defn saturate
  "Increase the saturation of this Color by the percentage amount given.
  The saturation is the amount of the base color in the hue.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * amount (integer) - The percentage amount to change this color by. A value between 0 and 100.

  Returns:  Phaser.Display.Color - This Color object."
  ([color amount]
   (phaser->clj
    (.saturate color
               (clj->phaser amount)))))

(defn set-from-hsv
  "Sets the color based on the hue, saturation and lightness values given.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * h (number) - The hue, in the range 0 - 1. This is the base color.
    * s (number) - The saturation, in the range 0 - 1. This controls how much of the hue will be in the final color, where 1 is fully saturated and 0 will give you white.
    * v (number) - The value, in the range 0 - 1. This controls how dark the color is. Where 1 is as bright as possible and 0 is black.

  Returns:  Phaser.Display.Color - This Color object."
  ([color h s v]
   (phaser->clj
    (.setFromHSV color
                 (clj->phaser h)
                 (clj->phaser s)
                 (clj->phaser v)))))

(defn set-from-rgb
  "Sets the color based on the color object given.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * color (Phaser.Types.Display.InputColorObject) - An object containing `r`, `g`, `b` and optionally `a` values in the range 0 to 255.

  Returns:  Phaser.Display.Color - This Color object."
  ([color color]
   (phaser->clj
    (.setFromRGB color
                 (clj->phaser color)))))

(defn set-gl-to
  "Sets the red, green, blue and alpha GL values of this Color component.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * red (number) - The red color value. A number between 0 and 1.
    * green (number) - The green color value. A number between 0 and 1.
    * blue (number) - The blue color value. A number between 0 and 1.
    * alpha (number) {optional} - The alpha value. A number between 0 and 1.

  Returns:  Phaser.Display.Color - This Color object."
  ([color red green blue]
   (phaser->clj
    (.setGLTo color
              (clj->phaser red)
              (clj->phaser green)
              (clj->phaser blue))))
  ([color red green blue alpha]
   (phaser->clj
    (.setGLTo color
              (clj->phaser red)
              (clj->phaser green)
              (clj->phaser blue)
              (clj->phaser alpha)))))

(defn set-to
  "Sets the color of this Color component.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * red (integer) - The red color value. A number between 0 and 255.
    * green (integer) - The green color value. A number between 0 and 255.
    * blue (integer) - The blue color value. A number between 0 and 255.
    * alpha (integer) {optional} - The alpha value. A number between 0 and 255.
    * update-hsv (boolean) {optional} - Update the HSV values after setting the RGB values?

  Returns:  Phaser.Display.Color - This Color object."
  ([color red green blue]
   (phaser->clj
    (.setTo color
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue))))
  ([color red green blue alpha]
   (phaser->clj
    (.setTo color
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue)
            (clj->phaser alpha))))
  ([color red green blue alpha update-hsv]
   (phaser->clj
    (.setTo color
            (clj->phaser red)
            (clj->phaser green)
            (clj->phaser blue)
            (clj->phaser alpha)
            (clj->phaser update-hsv)))))

(defn transparent
  "Sets this color to be transparent. Sets all values to zero.

  Returns:  Phaser.Display.Color - This Color object."
  ([color]
   (phaser->clj
    (.transparent color))))

(defn value-to-color
  "Converts the given source color value into an instance of a Color class.
  The value can be either a string, prefixed with `rgb` or a hex string, a number or an Object.

  Parameters:
    * color (Phaser.Display.Color) - Targeted instance for method
    * input (string | number | Phaser.Types.Display.InputColorObject) - The source color value to convert.

  Returns:  Phaser.Display.Color - A Color object."
  ([color input]
   (phaser->clj
    (.ValueToColor color
                   (clj->phaser input)))))