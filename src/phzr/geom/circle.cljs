(ns phzr.geom.circle
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone]))

(defn ->Circle
  "  Parameters:
    * x (number) {optional} - The x position of the center of the circle.
    * y (number) {optional} - The y position of the center of the circle.
    * radius (number) {optional} - The radius of the circle."
  ([]
   (js/Phaser.Geom.Circle.))
  ([x]
   (js/Phaser.Geom.Circle. (clj->phaser x)))
  ([x y]
   (js/Phaser.Geom.Circle. (clj->phaser x)
                           (clj->phaser y)))
  ([x y radius]
   (js/Phaser.Geom.Circle. (clj->phaser x)
                           (clj->phaser y)
                           (clj->phaser radius))))

(defn area
  "Calculates the area of the circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to get the area of.

  Returns:  number - The area of the Circle."
  ([circle circle]
   (phaser->clj
    (.Area circle
           (clj->phaser circle)))))

(defn circumference
  "Returns the circumference of the given Circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to get the circumference of.

  Returns:  number - The circumference of the Circle."
  ([circle circle]
   (phaser->clj
    (.Circumference circle
                    (clj->phaser circle)))))

(defn circumference-point
  "Returns a Point object containing the coordinates of a point on the circumference of the Circle based on the given angle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to get the circumference point on.
    * angle (number) - The angle from the center of the Circle to the circumference to return the point from. Given in radians.
    * out (Phaser.Geom.Point | object) {optional} - A Point, or point-like object, to store the results in. If not given a Point will be created.

  Returns:  Phaser.Geom.Point | object - A Point object where the `x` and `y` properties are the point on the circumference."
  ([circle circle angle]
   (phaser->clj
    (.CircumferencePoint circle
                         (clj->phaser circle)
                         (clj->phaser angle))))
  ([circle circle angle out]
   (phaser->clj
    (.CircumferencePoint circle
                         (clj->phaser circle)
                         (clj->phaser angle)
                         (clj->phaser out)))))

(defn clone
  "Creates a new Circle instance based on the values contained in the given source.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * source (Phaser.Geom.Circle | object) - The Circle to be cloned. Can be an instance of a Circle or a circle-like object, with x, y and radius properties.

  Returns:  Phaser.Geom.Circle - A clone of the source Circle."
  ([circle source]
   (phaser->clj
    (.Clone circle
            (clj->phaser source)))))

(defn contains
  "Check to see if the Circle contains the given x / y coordinates.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * x (number) - The x coordinate to check within the circle.
    * y (number) - The y coordinate to check within the circle.

  Returns:  boolean - True if the coordinates are within the circle, otherwise false."
  ([circle x y]
   (phaser->clj
    (.contains circle
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains
  "Check to see if the Circle contains the given x / y coordinates.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to check.
    * x (number) - The x coordinate to check within the circle.
    * y (number) - The y coordinate to check within the circle.

  Returns:  boolean - True if the coordinates are within the circle, otherwise false."
  ([circle circle x y]
   (phaser->clj
    (.Contains circle
               (clj->phaser circle)
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains-point
  "Check to see if the Circle contains the given Point object.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to check.
    * point (Phaser.Geom.Point | object) - The Point object to check if it's within the Circle or not.

  Returns:  boolean - True if the Point coordinates are within the circle, otherwise false."
  ([circle circle point]
   (phaser->clj
    (.ContainsPoint circle
                    (clj->phaser circle)
                    (clj->phaser point)))))

(defn contains-rect
  "Check to see if the Circle contains all four points of the given Rectangle object.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to check.
    * rect (Phaser.Geom.Rectangle | object) - The Rectangle object to check if it's within the Circle or not.

  Returns:  boolean - True if all of the Rectangle coordinates are within the circle, otherwise false."
  ([circle circle rect]
   (phaser->clj
    (.ContainsRect circle
                   (clj->phaser circle)
                   (clj->phaser rect)))))

(defn copy-from
  "Copies the `x`, `y` and `radius` properties from the `source` Circle
  into the given `dest` Circle, then returns the `dest` Circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * source (Phaser.Geom.Circle) - The source Circle to copy the values from.
    * dest (Phaser.Geom.Circle) - The destination Circle to copy the values to.

  Returns:  Phaser.Geom.Circle - The destination Circle."
  ([circle source dest]
   (phaser->clj
    (.CopyFrom circle
               (clj->phaser source)
               (clj->phaser dest)))))

(defn equals
  "Compares the `x`, `y` and `radius` properties of the two given Circles.
  Returns `true` if they all match, otherwise returns `false`.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The first Circle to compare.
    * to-compare (Phaser.Geom.Circle) - The second Circle to compare.

  Returns:  boolean - `true` if the two Circles equal each other, otherwise `false`."
  ([circle circle to-compare]
   (phaser->clj
    (.Equals circle
             (clj->phaser circle)
             (clj->phaser to-compare)))))

(defn get-bounds
  "Returns the bounds of the Circle object.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to get the bounds from.
    * out (Phaser.Geom.Rectangle | object) {optional} - A Rectangle, or rectangle-like object, to store the circle bounds in. If not given a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The Rectangle object containing the Circles bounds."
  ([circle circle]
   (phaser->clj
    (.GetBounds circle
                (clj->phaser circle))))
  ([circle circle out]
   (phaser->clj
    (.GetBounds circle
                (clj->phaser circle)
                (clj->phaser out)))))

(defn get-point
  "Returns a Point object containing the coordinates of a point on the circumference of the Circle
  based on the given angle normalized to the range 0 to 1. I.e. a value of 0.5 will give the point
  at 180 degrees around the circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * position (number) - A value between 0 and 1, where 0 equals 0 degrees, 0.5 equals 180 degrees and 1 equals 360 around the circle.
    * out (Phaser.Geom.Point | object) {optional} - An object to store the return values in. If not given a Point object will be created.

  Returns:  Phaser.Geom.Point | object - A Point, or point-like object, containing the coordinates of the point around the circle."
  ([circle position]
   (phaser->clj
    (.getPoint circle
               (clj->phaser position))))
  ([circle position out]
   (phaser->clj
    (.getPoint circle
               (clj->phaser position)
               (clj->phaser out)))))

(defn get-point
  "Returns a Point object containing the coordinates of a point on the circumference of the Circle
  based on the given angle normalized to the range 0 to 1. I.e. a value of 0.5 will give the point
  at 180 degrees around the circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to get the circumference point on.
    * position (number) - A value between 0 and 1, where 0 equals 0 degrees, 0.5 equals 180 degrees and 1 equals 360 around the circle.
    * out (Phaser.Geom.Point | object) {optional} - An object to store the return values in. If not given a Point object will be created.

  Returns:  Phaser.Geom.Point | object - A Point, or point-like object, containing the coordinates of the point around the circle."
  ([circle circle position]
   (phaser->clj
    (.GetPoint circle
               (clj->phaser circle)
               (clj->phaser position))))
  ([circle circle position out]
   (phaser->clj
    (.GetPoint circle
               (clj->phaser circle)
               (clj->phaser position)
               (clj->phaser out)))))

(defn get-points
  "Returns an array of Point objects containing the coordinates of the points around the circumference of the Circle,
  based on the given quantity or stepRate values.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * quantity (integer) - The amount of points to return. If a falsey value the quantity will be derived from the `stepRate` instead.
    * step-rate (number) {optional} - Sets the quantity by getting the circumference of the circle and dividing it by the stepRate.
    * output (array | Array.<Phaser.Geom.Point>) {optional} - An array to insert the points in to. If not provided a new array will be created.

  Returns:  array | Array.<Phaser.Geom.Point> - An array of Point objects pertaining to the points around the circumference of the circle."
  ([circle quantity]
   (phaser->clj
    (.getPoints circle
                (clj->phaser quantity))))
  ([circle quantity step-rate]
   (phaser->clj
    (.getPoints circle
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([circle quantity step-rate output]
   (phaser->clj
    (.getPoints circle
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser output)))))

(defn get-points
  "Returns an array of Point objects containing the coordinates of the points around the circumference of the Circle,
  based on the given quantity or stepRate values.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to get the points from.
    * quantity (integer) - The amount of points to return. If a falsey value the quantity will be derived from the `stepRate` instead.
    * step-rate (number) {optional} - Sets the quantity by getting the circumference of the circle and dividing it by the stepRate.
    * output (array) {optional} - An array to insert the points in to. If not provided a new array will be created.

  Returns:  Array.<Phaser.Geom.Point> - An array of Point objects pertaining to the points around the circumference of the circle."
  ([circle circle quantity]
   (phaser->clj
    (.GetPoints circle
                (clj->phaser circle)
                (clj->phaser quantity))))
  ([circle circle quantity step-rate]
   (phaser->clj
    (.GetPoints circle
                (clj->phaser circle)
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([circle circle quantity step-rate output]
   (phaser->clj
    (.GetPoints circle
                (clj->phaser circle)
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser output)))))

(defn get-random-point
  "Returns a uniformly distributed random point from anywhere within the Circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * point (Phaser.Geom.Point | object) {optional} - A Point or point-like object to set the random `x` and `y` values in.

  Returns:  Phaser.Geom.Point | object - A Point object with the random values set in the `x` and `y` properties."
  ([circle]
   (phaser->clj
    (.getRandomPoint circle)))
  ([circle point]
   (phaser->clj
    (.getRandomPoint circle
                     (clj->phaser point)))))

(defn is-empty
  "Checks to see if the Circle is empty: has a radius of zero.

  Returns:  boolean - True if the Circle is empty, otherwise false."
  ([circle]
   (phaser->clj
    (.isEmpty circle))))

(defn offset
  "Offsets the Circle by the values given.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to be offset (translated.)
    * x (number) - The amount to horizontally offset the Circle by.
    * y (number) - The amount to vertically offset the Circle by.

  Returns:  Phaser.Geom.Circle - The Circle that was offset."
  ([circle circle x y]
   (phaser->clj
    (.Offset circle
             (clj->phaser circle)
             (clj->phaser x)
             (clj->phaser y)))))

(defn offset-point
  "Offsets the Circle by the values given in the `x` and `y` properties of the Point object.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to be offset (translated.)
    * point (Phaser.Geom.Point | object) - The Point object containing the values to offset the Circle by.

  Returns:  Phaser.Geom.Circle - The Circle that was offset."
  ([circle circle point]
   (phaser->clj
    (.OffsetPoint circle
                  (clj->phaser circle)
                  (clj->phaser point)))))

(defn random
  "Returns a uniformly distributed random point from anywhere within the given Circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * circle (Phaser.Geom.Circle) - The Circle to get a random point from.
    * out (Phaser.Geom.Point | object) {optional} - A Point or point-like object to set the random `x` and `y` values in.

  Returns:  Phaser.Geom.Point | object - A Point object with the random values set in the `x` and `y` properties."
  ([circle circle]
   (phaser->clj
    (.Random circle
             (clj->phaser circle))))
  ([circle circle out]
   (phaser->clj
    (.Random circle
             (clj->phaser circle)
             (clj->phaser out)))))

(defn set-empty
  "Sets this Circle to be empty with a radius of zero.
  Does not change its position.

  Returns:  Phaser.Geom.Circle - This Circle object."
  ([circle]
   (phaser->clj
    (.setEmpty circle))))

(defn set-position
  "Sets the position of this Circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * x (number) {optional} - The x position of the center of the circle.
    * y (number) {optional} - The y position of the center of the circle.

  Returns:  Phaser.Geom.Circle - This Circle object."
  ([circle]
   (phaser->clj
    (.setPosition circle)))
  ([circle x]
   (phaser->clj
    (.setPosition circle
                  (clj->phaser x))))
  ([circle x y]
   (phaser->clj
    (.setPosition circle
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-to
  "Sets the x, y and radius of this circle.

  Parameters:
    * circle (Phaser.Geom.Circle) - Targeted instance for method
    * x (number) {optional} - The x position of the center of the circle.
    * y (number) {optional} - The y position of the center of the circle.
    * radius (number) {optional} - The radius of the circle.

  Returns:  Phaser.Geom.Circle - This Circle object."
  ([circle]
   (phaser->clj
    (.setTo circle)))
  ([circle x]
   (phaser->clj
    (.setTo circle
            (clj->phaser x))))
  ([circle x y]
   (phaser->clj
    (.setTo circle
            (clj->phaser x)
            (clj->phaser y))))
  ([circle x y radius]
   (phaser->clj
    (.setTo circle
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser radius)))))