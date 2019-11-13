(ns phzr.geom.point
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone]))

(defn ->Point
  "  Parameters:
    * x (number) {optional} - The x coordinate of this Point.
    * y (number) {optional} - The y coordinate of this Point."
  ([]
   (js/Phaser.Geom.Point.))
  ([x]
   (js/Phaser.Geom.Point. (clj->phaser x)))
  ([x y]
   (js/Phaser.Geom.Point. (clj->phaser x)
                          (clj->phaser y))))

(defn ceil
  "Apply `Math.ceil()` to each coordinate of the given Point.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point (Phaser.Geom.Point) - The Point to ceil.

  Returns:  Phaser.Geom.Point - The Point with `Math.ceil()` applied to its coordinates."
  ([point point]
   (phaser->clj
    (.Ceil point
           (clj->phaser point)))))

(defn clone
  "Clone the given Point.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * source (Phaser.Geom.Point) - The source Point to clone.

  Returns:  Phaser.Geom.Point - The cloned Point."
  ([point source]
   (phaser->clj
    (.Clone point
            (clj->phaser source)))))

(defn copy-from
  "Copy the values of one Point to a destination Point.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * source (Phaser.Geom.Point) - The source Point to copy the values from.
    * dest (Phaser.Geom.Point) - The destination Point to copy the values to.

  Returns:  Phaser.Geom.Point - The destination Point."
  ([point source dest]
   (phaser->clj
    (.CopyFrom point
               (clj->phaser source)
               (clj->phaser dest)))))

(defn equals
  "A comparison of two `Point` objects to see if they are equal.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point (Phaser.Geom.Point) - The original `Point` to compare against.
    * to-compare (Phaser.Geom.Point) - The second `Point` to compare.

  Returns:  boolean - Returns true if the both `Point` objects are equal."
  ([point point to-compare]
   (phaser->clj
    (.Equals point
             (clj->phaser point)
             (clj->phaser to-compare)))))

(defn floor
  "Apply `Math.ceil()` to each coordinate of the given Point.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point (Phaser.Geom.Point) - The Point to floor.

  Returns:  Phaser.Geom.Point - The Point with `Math.floor()` applied to its coordinates."
  ([point point]
   (phaser->clj
    (.Floor point
            (clj->phaser point)))))

(defn get-centroid
  "Get the centroid or geometric center of a plane figure (the arithmetic mean position of all the points in the figure).
  Informally, it is the point at which a cutout of the shape could be perfectly balanced on the tip of a pin.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * points (Array.<Phaser.Geom.Point>) - [description]
    * out (Phaser.Geom.Point) {optional} - [description]

  Returns:  Phaser.Geom.Point - [description]"
  ([point points]
   (phaser->clj
    (.GetCentroid point
                  (clj->phaser points))))
  ([point points out]
   (phaser->clj
    (.GetCentroid point
                  (clj->phaser points)
                  (clj->phaser out)))))

(defn get-magnitude
  "Calculate the magnitude of the point, which equivalent to the length of the line from the origin to this point.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point (Phaser.Geom.Point) - The point to calculate the magnitude for

  Returns:  number - The resulting magnitude"
  ([point point]
   (phaser->clj
    (.GetMagnitude point
                   (clj->phaser point)))))

(defn get-magnitude-sq
  "Calculates the square of magnitude of given point.(Can be used for fast magnitude calculation of point)

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point (Phaser.Geom.Point) - Returns square of the magnitude/length of given point.

  Returns:  number - Returns square of the magnitude of given point."
  ([point point]
   (phaser->clj
    (.GetMagnitudeSq point
                     (clj->phaser point)))))

(defn get-rectangle-from-points
  "Calculates the Axis Aligned Bounding Box (or aabb) from an array of points.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * points (Array.<Phaser.Geom.Point>) - [description]
    * out (Phaser.Geom.Rectangle) {optional} - [description]

  Returns:  Phaser.Geom.Rectangle - [description]"
  ([point points]
   (phaser->clj
    (.GetRectangleFromPoints point
                             (clj->phaser points))))
  ([point points out]
   (phaser->clj
    (.GetRectangleFromPoints point
                             (clj->phaser points)
                             (clj->phaser out)))))

(defn interpolate
  "[description]

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point-a (Phaser.Geom.Point) - The starting `Point` for the interpolation.
    * point-b (Phaser.Geom.Point) - The target `Point` for the interpolation.
    * t (number) {optional} - The amount to interpolate between the two points. Generally, a value between 0 (returns the starting `Point`) and 1 (returns the target `Point`). If omitted, 0 is used.
    * out (Phaser.Geom.Point | object) {optional} - An optional `Point` object whose `x` and `y` values will be set to the result of the interpolation (can also be any object with `x` and `y` properties). If omitted, a new `Point` created and returned.

  Returns:  Phaser.Geom.Point | object - Either the object from the `out` argument with the properties `x` and `y` set to the result of the interpolation or a newly created `Point` object."
  ([point point-a point-b]
   (phaser->clj
    (.Interpolate point
                  (clj->phaser point-a)
                  (clj->phaser point-b))))
  ([point point-a point-b t]
   (phaser->clj
    (.Interpolate point
                  (clj->phaser point-a)
                  (clj->phaser point-b)
                  (clj->phaser t))))
  ([point point-a point-b t out]
   (phaser->clj
    (.Interpolate point
                  (clj->phaser point-a)
                  (clj->phaser point-b)
                  (clj->phaser t)
                  (clj->phaser out)))))

(defn invert
  "Swaps the X and the Y coordinate of a point.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point (Phaser.Geom.Point) - The Point to modify.

  Returns:  Phaser.Geom.Point - The modified `point`."
  ([point point]
   (phaser->clj
    (.Invert point
             (clj->phaser point)))))

(defn negative
  "Inverts a Point's coordinates.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point (Phaser.Geom.Point) - The Point to invert.
    * out (Phaser.Geom.Point) {optional} - The Point to return the inverted coordinates in.

  Returns:  Phaser.Geom.Point - The modified `out` Point, or a new Point if none was provided."
  ([point point]
   (phaser->clj
    (.Negative point
               (clj->phaser point))))
  ([point point out]
   (phaser->clj
    (.Negative point
               (clj->phaser point)
               (clj->phaser out)))))

(defn project
  "[description]

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point-a (Phaser.Geom.Point) - [description]
    * point-b (Phaser.Geom.Point) - [description]
    * out (Phaser.Geom.Point) {optional} - [description]

  Returns:  Phaser.Geom.Point - [description]"
  ([point point-a point-b]
   (phaser->clj
    (.Project point
              (clj->phaser point-a)
              (clj->phaser point-b))))
  ([point point-a point-b out]
   (phaser->clj
    (.Project point
              (clj->phaser point-a)
              (clj->phaser point-b)
              (clj->phaser out)))))

(defn project-unit
  "[description]

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point-a (Phaser.Geom.Point) - [description]
    * point-b (Phaser.Geom.Point) - [description]
    * out (Phaser.Geom.Point) {optional} - [description]

  Returns:  Phaser.Geom.Point - [description]"
  ([point point-a point-b]
   (phaser->clj
    (.ProjectUnit point
                  (clj->phaser point-a)
                  (clj->phaser point-b))))
  ([point point-a point-b out]
   (phaser->clj
    (.ProjectUnit point
                  (clj->phaser point-a)
                  (clj->phaser point-b)
                  (clj->phaser out)))))

(defn set-magnitude
  "Changes the magnitude (length) of a two-dimensional vector without changing its direction.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * point (Phaser.Geom.Point) - The Point to treat as the end point of the vector.
    * magnitude (number) - The new magnitude of the vector.

  Returns:  Phaser.Geom.Point - The modified Point."
  ([point point magnitude]
   (phaser->clj
    (.SetMagnitude point
                   (clj->phaser point)
                   (clj->phaser magnitude)))))

(defn set-to
  "Set the x and y coordinates of the point to the given values.

  Parameters:
    * point (Phaser.Geom.Point) - Targeted instance for method
    * x (number) {optional} - The x coordinate of this Point.
    * y (number) {optional} - The y coordinate of this Point.

  Returns:  Phaser.Geom.Point - This Point object."
  ([point]
   (phaser->clj
    (.setTo point)))
  ([point x]
   (phaser->clj
    (.setTo point
            (clj->phaser x))))
  ([point x y]
   (phaser->clj
    (.setTo point
            (clj->phaser x)
            (clj->phaser y)))))