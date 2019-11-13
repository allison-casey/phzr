(ns phzr.geom.polygon
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone reverse]))

(defn ->Polygon
  "  Parameters:
    * points (Array.<Phaser.Geom.Point>) {optional} - List of points defining the perimeter of this Polygon. Several formats are supported: 
- A string containing paired x y values separated by a single space: `'40 0 40 20 100 20 100 80 40 80 40 100 0 50'`
- An array of Point objects: `[new Phaser.Point(x1, y1), ...]`
- An array of objects with public x y properties: `[obj1, obj2, ...]`
- An array of paired numbers that represent point coordinates: `[x1,y1, x2,y2, ...]`
- An array of arrays with two elements representing x/y coordinates: `[[x1, y1], [x2, y2], ...]`"
  ([]
   (js/Phaser.Geom.Polygon.))
  ([points]
   (js/Phaser.Geom.Polygon. (clj->phaser points))))

(defn calculate-area
  "Calculates the area of the Polygon. This is available in the property Polygon.area

  Returns:  number - The area of the polygon."
  ([polygon]
   (phaser->clj
    (.calculateArea polygon))))

(defn clone
  "Create a new polygon which is a copy of the specified polygon

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - The polygon to create a clone of

  Returns:  Phaser.Geom.Polygon - A new separate Polygon cloned from the specified polygon, based on the same points."
  ([polygon polygon]
   (phaser->clj
    (.Clone polygon
            (clj->phaser polygon)))))

(defn contains
  "Checks if a point is within the bounds of a Polygon.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - The Polygon to check against.
    * x (number) - The X coordinate of the point to check.
    * y (number) - The Y coordinate of the point to check.

  Returns:  boolean - `true` if the point is within the bounds of the Polygon, otherwise `false`."
  ([polygon polygon x y]
   (phaser->clj
    (.Contains polygon
               (clj->phaser polygon)
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains
  "Check to see if the Polygon contains the given x / y coordinates.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * x (number) - The x coordinate to check within the polygon.
    * y (number) - The y coordinate to check within the polygon.

  Returns:  boolean - `true` if the coordinates are within the polygon, otherwise `false`."
  ([polygon x y]
   (phaser->clj
    (.contains polygon
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains-point
  "[description]

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - [description]
    * point (Phaser.Geom.Point) - [description]

  Returns:  boolean - [description]"
  ([polygon polygon point]
   (phaser->clj
    (.ContainsPoint polygon
                    (clj->phaser polygon)
                    (clj->phaser point)))))

(defn get-aabb
  "Calculates the bounding AABB rectangle of a polygon.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - The polygon that should be calculated.
    * out (Phaser.Geom.Rectangle | object) {optional} - The rectangle or object that has x, y, width, and height properties to store the result. Optional.

  Returns:  Phaser.Geom.Rectangle | object - The resulting rectangle or object that is passed in with position and dimensions of the polygon's AABB."
  ([polygon polygon]
   (phaser->clj
    (.GetAABB polygon
              (clj->phaser polygon))))
  ([polygon polygon out]
   (phaser->clj
    (.GetAABB polygon
              (clj->phaser polygon)
              (clj->phaser out)))))

(defn get-number-array
  "Stores all of the points of a Polygon into a flat array of numbers following the sequence [ x,y, x,y, x,y ],
  i.e. each point of the Polygon, in the order it's defined, corresponds to two elements of the resultant
  array for the point's X and Y coordinate.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - The Polygon whose points to export.
    * output (array | Array.<number>) {optional} - An array to which the points' coordinates should be appended.

  Returns:  array | Array.<number> - The modified `output` array, or a new array if none was given."
  ([polygon polygon]
   (phaser->clj
    (.GetNumberArray polygon
                     (clj->phaser polygon))))
  ([polygon polygon output]
   (phaser->clj
    (.GetNumberArray polygon
                     (clj->phaser polygon)
                     (clj->phaser output)))))

(defn get-points
  "Returns an array of Point objects containing the coordinates of the points around the perimeter of the Polygon,
  based on the given quantity or stepRate values.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - The Polygon to get the points from.
    * quantity (integer) - The amount of points to return. If a falsey value the quantity will be derived from the `stepRate` instead.
    * step-rate (number) {optional} - Sets the quantity by getting the perimeter of the Polygon and dividing it by the stepRate.
    * output (array) {optional} - An array to insert the points in to. If not provided a new array will be created.

  Returns:  Array.<Phaser.Geom.Point> - An array of Point objects pertaining to the points around the perimeter of the Polygon."
  ([polygon polygon quantity]
   (phaser->clj
    (.GetPoints polygon
                (clj->phaser polygon)
                (clj->phaser quantity))))
  ([polygon polygon quantity step-rate]
   (phaser->clj
    (.GetPoints polygon
                (clj->phaser polygon)
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([polygon polygon quantity step-rate output]
   (phaser->clj
    (.GetPoints polygon
                (clj->phaser polygon)
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser output)))))

(defn get-points
  "Returns an array of Point objects containing the coordinates of the points around the perimeter of the Polygon,
  based on the given quantity or stepRate values.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * quantity (integer) - The amount of points to return. If a falsey value the quantity will be derived from the `stepRate` instead.
    * step-rate (number) {optional} - Sets the quantity by getting the perimeter of the Polygon and dividing it by the stepRate.
    * output (array) {optional} - An array to insert the points in to. If not provided a new array will be created.

  Returns:  Array.<Phaser.Geom.Point> - An array of Point objects pertaining to the points around the perimeter of the Polygon."
  ([polygon quantity]
   (phaser->clj
    (.getPoints polygon
                (clj->phaser quantity))))
  ([polygon quantity step-rate]
   (phaser->clj
    (.getPoints polygon
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([polygon quantity step-rate output]
   (phaser->clj
    (.getPoints polygon
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser output)))))

(defn perimeter
  "Returns the perimeter of the given Polygon.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - The Polygon to get the perimeter of.

  Returns:  number - The perimeter of the Polygon."
  ([polygon polygon]
   (phaser->clj
    (.Perimeter polygon
                (clj->phaser polygon)))))

(defn reverse
  "Reverses the order of the points of a Polygon.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - The Polygon to modify.

  Returns:  Phaser.Geom.Polygon - The modified Polygon."
  ([polygon polygon]
   (phaser->clj
    (.Reverse polygon
              (clj->phaser polygon)))))

(defn set-to
  "Sets this Polygon to the given points.

  The points can be set from a variety of formats:

  - A string containing paired values separated by a single space: `'40 0 40 20 100 20 100 80 40 80 40 100 0 50'`
  - An array of Point objects: `[new Phaser.Point(x1, y1), ...]`
  - An array of objects with public x/y properties: `[obj1, obj2, ...]`
  - An array of paired numbers that represent point coordinates: `[x1,y1, x2,y2, ...]`
  - An array of arrays with two elements representing x/y coordinates: `[[x1, y1], [x2, y2], ...]`

  `setTo` may also be called without any arguments to remove all points.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * points (array) - Points defining the perimeter of this polygon. Please check function description above for the different supported formats.

  Returns:  Phaser.Geom.Polygon - This Polygon object."
  ([polygon points]
   (phaser->clj
    (.setTo polygon
            (clj->phaser points)))))

(defn smooth
  "Takes a Polygon object and applies Chaikin's smoothing algorithm on its points.

  Parameters:
    * polygon (Phaser.Geom.Polygon) - Targeted instance for method
    * polygon (Phaser.Geom.Polygon) - The polygon to be smoothed. The polygon will be modified in-place and returned.

  Returns:  Phaser.Geom.Polygon - The input polygon."
  ([polygon polygon]
   (phaser->clj
    (.Smooth polygon
             (clj->phaser polygon)))))