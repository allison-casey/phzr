(ns phzr.geom.ellipse
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone]))

(defn ->Ellipse
  "  Parameters:
    * x (number) {optional} - The x position of the center of the ellipse.
    * y (number) {optional} - The y position of the center of the ellipse.
    * width (number) {optional} - The width of the ellipse.
    * height (number) {optional} - The height of the ellipse."
  ([]
   (js/Phaser.Geom.Ellipse.))
  ([x]
   (js/Phaser.Geom.Ellipse. (clj->phaser x)))
  ([x y]
   (js/Phaser.Geom.Ellipse. (clj->phaser x)
                            (clj->phaser y)))
  ([x y width]
   (js/Phaser.Geom.Ellipse. (clj->phaser x)
                            (clj->phaser y)
                            (clj->phaser width)))
  ([x y width height]
   (js/Phaser.Geom.Ellipse. (clj->phaser x)
                            (clj->phaser y)
                            (clj->phaser width)
                            (clj->phaser height))))

(defn area
  "Calculates the area of the Ellipse.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to get the area of.

  Returns:  number - The area of the Ellipse."
  ([ellipse ellipse]
   (phaser->clj
    (.Area ellipse
           (clj->phaser ellipse)))))

(defn circumference
  "Returns the circumference of the given Ellipse.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to get the circumference of.

  Returns:  number - The circumference of th Ellipse."
  ([ellipse ellipse]
   (phaser->clj
    (.Circumference ellipse
                    (clj->phaser ellipse)))))

(defn circumference-point
  "Returns a Point object containing the coordinates of a point on the circumference of the Ellipse based on the given angle.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to get the circumference point on.
    * angle (number) - The angle from the center of the Ellipse to the circumference to return the point from. Given in radians.
    * out (Phaser.Geom.Point | object) {optional} - A Point, or point-like object, to store the results in. If not given a Point will be created.

  Returns:  Phaser.Geom.Point | object - A Point object where the `x` and `y` properties are the point on the circumference."
  ([ellipse ellipse angle]
   (phaser->clj
    (.CircumferencePoint ellipse
                         (clj->phaser ellipse)
                         (clj->phaser angle))))
  ([ellipse ellipse angle out]
   (phaser->clj
    (.CircumferencePoint ellipse
                         (clj->phaser ellipse)
                         (clj->phaser angle)
                         (clj->phaser out)))))

(defn clone
  "Creates a new Ellipse instance based on the values contained in the given source.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * source (Phaser.Geom.Ellipse) - The Ellipse to be cloned. Can be an instance of an Ellipse or a ellipse-like object, with x, y, width and height properties.

  Returns:  Phaser.Geom.Ellipse - A clone of the source Ellipse."
  ([ellipse source]
   (phaser->clj
    (.Clone ellipse
            (clj->phaser source)))))

(defn contains
  "Check to see if the Ellipse contains the given x / y coordinates.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to check.
    * x (number) - The x coordinate to check within the ellipse.
    * y (number) - The y coordinate to check within the ellipse.

  Returns:  boolean - True if the coordinates are within the ellipse, otherwise false."
  ([ellipse ellipse x y]
   (phaser->clj
    (.Contains ellipse
               (clj->phaser ellipse)
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains
  "Check to see if the Ellipse contains the given x / y coordinates.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * x (number) - The x coordinate to check within the ellipse.
    * y (number) - The y coordinate to check within the ellipse.

  Returns:  boolean - True if the coordinates are within the ellipse, otherwise false."
  ([ellipse x y]
   (phaser->clj
    (.contains ellipse
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains-point
  "Check to see if the Ellipse contains the given Point object.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to check.
    * point (Phaser.Geom.Point | object) - The Point object to check if it's within the Circle or not.

  Returns:  boolean - True if the Point coordinates are within the circle, otherwise false."
  ([ellipse ellipse point]
   (phaser->clj
    (.ContainsPoint ellipse
                    (clj->phaser ellipse)
                    (clj->phaser point)))))

(defn contains-rect
  "Check to see if the Ellipse contains all four points of the given Rectangle object.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to check.
    * rect (Phaser.Geom.Rectangle | object) - The Rectangle object to check if it's within the Ellipse or not.

  Returns:  boolean - True if all of the Rectangle coordinates are within the ellipse, otherwise false."
  ([ellipse ellipse rect]
   (phaser->clj
    (.ContainsRect ellipse
                   (clj->phaser ellipse)
                   (clj->phaser rect)))))

(defn copy-from
  "Copies the `x`, `y`, `width` and `height` properties from the `source` Ellipse
  into the given `dest` Ellipse, then returns the `dest` Ellipse.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * source (Phaser.Geom.Ellipse) - The source Ellipse to copy the values from.
    * dest (Phaser.Geom.Ellipse) - The destination Ellipse to copy the values to.

  Returns:  Phaser.Geom.Ellipse - The destination Ellipse."
  ([ellipse source dest]
   (phaser->clj
    (.CopyFrom ellipse
               (clj->phaser source)
               (clj->phaser dest)))))

(defn equals
  "Compares the `x`, `y`, `width` and `height` properties of the two given Ellipses.
  Returns `true` if they all match, otherwise returns `false`.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The first Ellipse to compare.
    * to-compare (Phaser.Geom.Ellipse) - The second Ellipse to compare.

  Returns:  boolean - `true` if the two Ellipse equal each other, otherwise `false`."
  ([ellipse ellipse to-compare]
   (phaser->clj
    (.Equals ellipse
             (clj->phaser ellipse)
             (clj->phaser to-compare)))))

(defn get-bounds
  "Returns the bounds of the Ellipse object.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to get the bounds from.
    * out (Phaser.Geom.Rectangle | object) {optional} - A Rectangle, or rectangle-like object, to store the ellipse bounds in. If not given a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The Rectangle object containing the Ellipse bounds."
  ([ellipse ellipse]
   (phaser->clj
    (.GetBounds ellipse
                (clj->phaser ellipse))))
  ([ellipse ellipse out]
   (phaser->clj
    (.GetBounds ellipse
                (clj->phaser ellipse)
                (clj->phaser out)))))

(defn get-major-radius
  "Returns the major radius of the ellipse. Also known as the Semi Major Axis.

  Returns:  number - The major radius."
  ([ellipse]
   (phaser->clj
    (.getMajorRadius ellipse))))

(defn get-minor-radius
  "Returns the minor radius of the ellipse. Also known as the Semi Minor Axis.

  Returns:  number - The minor radius."
  ([ellipse]
   (phaser->clj
    (.getMinorRadius ellipse))))

(defn get-point
  "Returns a Point object containing the coordinates of a point on the circumference of the Ellipse
  based on the given angle normalized to the range 0 to 1. I.e. a value of 0.5 will give the point
  at 180 degrees around the circle.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * position (number) - A value between 0 and 1, where 0 equals 0 degrees, 0.5 equals 180 degrees and 1 equals 360 around the ellipse.
    * out (Phaser.Geom.Point | object) {optional} - An object to store the return values in. If not given a Point object will be created.

  Returns:  Phaser.Geom.Point | object - A Point, or point-like object, containing the coordinates of the point around the ellipse."
  ([ellipse position]
   (phaser->clj
    (.getPoint ellipse
               (clj->phaser position))))
  ([ellipse position out]
   (phaser->clj
    (.getPoint ellipse
               (clj->phaser position)
               (clj->phaser out)))))

(defn get-point
  "Returns a Point object containing the coordinates of a point on the circumference of the Ellipse
  based on the given angle normalized to the range 0 to 1. I.e. a value of 0.5 will give the point
  at 180 degrees around the circle.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to get the circumference point on.
    * position (number) - A value between 0 and 1, where 0 equals 0 degrees, 0.5 equals 180 degrees and 1 equals 360 around the ellipse.
    * out (Phaser.Geom.Point | object) {optional} - An object to store the return values in. If not given a Point object will be created.

  Returns:  Phaser.Geom.Point | object - A Point, or point-like object, containing the coordinates of the point around the ellipse."
  ([ellipse ellipse position]
   (phaser->clj
    (.GetPoint ellipse
               (clj->phaser ellipse)
               (clj->phaser position))))
  ([ellipse ellipse position out]
   (phaser->clj
    (.GetPoint ellipse
               (clj->phaser ellipse)
               (clj->phaser position)
               (clj->phaser out)))))

(defn get-points
  "Returns an array of Point objects containing the coordinates of the points around the circumference of the Ellipse,
  based on the given quantity or stepRate values.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * quantity (integer) - The amount of points to return. If a falsey value the quantity will be derived from the `stepRate` instead.
    * step-rate (number) {optional} - Sets the quantity by getting the circumference of the ellipse and dividing it by the stepRate.
    * output (array) {optional} - An array to insert the points in to. If not provided a new array will be created.

  Returns:  Array.<Phaser.Geom.Point> - An array of Point objects pertaining to the points around the circumference of the ellipse."
  ([ellipse quantity]
   (phaser->clj
    (.getPoints ellipse
                (clj->phaser quantity))))
  ([ellipse quantity step-rate]
   (phaser->clj
    (.getPoints ellipse
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([ellipse quantity step-rate output]
   (phaser->clj
    (.getPoints ellipse
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser output)))))

(defn get-points
  "Returns an array of Point objects containing the coordinates of the points around the circumference of the Ellipse,
  based on the given quantity or stepRate values.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to get the points from.
    * quantity (integer) - The amount of points to return. If a falsey value the quantity will be derived from the `stepRate` instead.
    * step-rate (number) {optional} - Sets the quantity by getting the circumference of the ellipse and dividing it by the stepRate.
    * out (array | Array.<Phaser.Geom.Point>) {optional} - An array to insert the points in to. If not provided a new array will be created.

  Returns:  array | Array.<Phaser.Geom.Point> - An array of Point objects pertaining to the points around the circumference of the ellipse."
  ([ellipse ellipse quantity]
   (phaser->clj
    (.GetPoints ellipse
                (clj->phaser ellipse)
                (clj->phaser quantity))))
  ([ellipse ellipse quantity step-rate]
   (phaser->clj
    (.GetPoints ellipse
                (clj->phaser ellipse)
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([ellipse ellipse quantity step-rate out]
   (phaser->clj
    (.GetPoints ellipse
                (clj->phaser ellipse)
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser out)))))

(defn get-random-point
  "Returns a uniformly distributed random point from anywhere within the given Ellipse.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * point (Phaser.Geom.Point | object) {optional} - A Point or point-like object to set the random `x` and `y` values in.

  Returns:  Phaser.Geom.Point | object - A Point object with the random values set in the `x` and `y` properties."
  ([ellipse]
   (phaser->clj
    (.getRandomPoint ellipse)))
  ([ellipse point]
   (phaser->clj
    (.getRandomPoint ellipse
                     (clj->phaser point)))))

(defn is-empty
  "Checks to see if the Ellipse is empty: has a width or height equal to zero.

  Returns:  boolean - True if the Ellipse is empty, otherwise false."
  ([ellipse]
   (phaser->clj
    (.isEmpty ellipse))))

(defn offset
  "Offsets the Ellipse by the values given.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to be offset (translated.)
    * x (number) - The amount to horizontally offset the Ellipse by.
    * y (number) - The amount to vertically offset the Ellipse by.

  Returns:  Phaser.Geom.Ellipse - The Ellipse that was offset."
  ([ellipse ellipse x y]
   (phaser->clj
    (.Offset ellipse
             (clj->phaser ellipse)
             (clj->phaser x)
             (clj->phaser y)))))

(defn offset-point
  "Offsets the Ellipse by the values given in the `x` and `y` properties of the Point object.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to be offset (translated.)
    * point (Phaser.Geom.Point | object) - The Point object containing the values to offset the Ellipse by.

  Returns:  Phaser.Geom.Ellipse - The Ellipse that was offset."
  ([ellipse ellipse point]
   (phaser->clj
    (.OffsetPoint ellipse
                  (clj->phaser ellipse)
                  (clj->phaser point)))))

(defn random
  "Returns a uniformly distributed random point from anywhere within the given Ellipse.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * ellipse (Phaser.Geom.Ellipse) - The Ellipse to get a random point from.
    * out (Phaser.Geom.Point | object) {optional} - A Point or point-like object to set the random `x` and `y` values in.

  Returns:  Phaser.Geom.Point | object - A Point object with the random values set in the `x` and `y` properties."
  ([ellipse ellipse]
   (phaser->clj
    (.Random ellipse
             (clj->phaser ellipse))))
  ([ellipse ellipse out]
   (phaser->clj
    (.Random ellipse
             (clj->phaser ellipse)
             (clj->phaser out)))))

(defn set-empty
  "Sets this Ellipse to be empty with a width and height of zero.
  Does not change its position.

  Returns:  Phaser.Geom.Ellipse - This Ellipse object."
  ([ellipse]
   (phaser->clj
    (.setEmpty ellipse))))

(defn set-position
  "Sets the position of this Ellipse.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * x (number) - The x position of the center of the ellipse.
    * y (number) - The y position of the center of the ellipse.

  Returns:  Phaser.Geom.Ellipse - This Ellipse object."
  ([ellipse x y]
   (phaser->clj
    (.setPosition ellipse
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-size
  "Sets the size of this Ellipse.
  Does not change its position.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * width (number) - The width of the ellipse.
    * height (number) {optional} - The height of the ellipse.

  Returns:  Phaser.Geom.Ellipse - This Ellipse object."
  ([ellipse width]
   (phaser->clj
    (.setSize ellipse
              (clj->phaser width))))
  ([ellipse width height]
   (phaser->clj
    (.setSize ellipse
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-to
  "Sets the x, y, width and height of this ellipse.

  Parameters:
    * ellipse (Phaser.Geom.Ellipse) - Targeted instance for method
    * x (number) - The x position of the center of the ellipse.
    * y (number) - The y position of the center of the ellipse.
    * width (number) - The width of the ellipse.
    * height (number) - The height of the ellipse.

  Returns:  Phaser.Geom.Ellipse - This Ellipse object."
  ([ellipse x y width height]
   (phaser->clj
    (.setTo ellipse
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser width)
            (clj->phaser height)))))