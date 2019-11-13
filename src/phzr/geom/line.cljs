(ns phzr.geom.line
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone extend]))

(defn ->Line
  "  Parameters:
    * x-1 (number) {optional} - The x coordinate of the lines starting point.
    * y-1 (number) {optional} - The y coordinate of the lines starting point.
    * x-2 (number) {optional} - The x coordinate of the lines ending point.
    * y-2 (number) {optional} - The y coordinate of the lines ending point."
  ([]
   (js/Phaser.Geom.Line.))
  ([x-1]
   (js/Phaser.Geom.Line. (clj->phaser x-1)))
  ([x-1 y-1]
   (js/Phaser.Geom.Line. (clj->phaser x-1)
                         (clj->phaser y-1)))
  ([x-1 y-1 x-2]
   (js/Phaser.Geom.Line. (clj->phaser x-1)
                         (clj->phaser y-1)
                         (clj->phaser x-2)))
  ([x-1 y-1 x-2 y-2]
   (js/Phaser.Geom.Line. (clj->phaser x-1)
                         (clj->phaser y-1)
                         (clj->phaser x-2)
                         (clj->phaser y-2))))

(defn angle
  "Calculate the angle of the line in radians.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the angle of.

  Returns:  number - The angle of the line, in radians."
  ([line line]
   (phaser->clj
    (.Angle line
            (clj->phaser line)))))

(defn bresenham-points
  "Using Bresenham's line algorithm this will return an array of all coordinates on this line.

  The `start` and `end` points are rounded before this runs as the algorithm works on integers.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line.
    * step-rate (integer) {optional} - The optional step rate for the points on the line.
    * results (array) {optional} - An optional array to push the resulting coordinates into.

  Returns:  Array.<object> - The array of coordinates on the line."
  ([line line]
   (phaser->clj
    (.BresenhamPoints line
                      (clj->phaser line))))
  ([line line step-rate]
   (phaser->clj
    (.BresenhamPoints line
                      (clj->phaser line)
                      (clj->phaser step-rate))))
  ([line line step-rate results]
   (phaser->clj
    (.BresenhamPoints line
                      (clj->phaser line)
                      (clj->phaser step-rate)
                      (clj->phaser results)))))

(defn center-on
  "Center a line on the given coordinates.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to center.
    * x (number) - The horizontal coordinate to center the line on.
    * y (number) - The vertical coordinate to center the line on.

  Returns:  Phaser.Geom.Line - The centered line."
  ([line line x y]
   (phaser->clj
    (.CenterOn line
               (clj->phaser line)
               (clj->phaser x)
               (clj->phaser y)))))

(defn clone
  "Clone the given line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * source (Phaser.Geom.Line) - The source line to clone.

  Returns:  Phaser.Geom.Line - The cloned line."
  ([line source]
   (phaser->clj
    (.Clone line
            (clj->phaser source)))))

(defn copy-from
  "Copy the values of one line to a destination line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * source (Phaser.Geom.Line) - The source line to copy the values from.
    * dest (Phaser.Geom.Line) - The destination line to copy the values to.

  Returns:  Phaser.Geom.Line - The destination line."
  ([line source dest]
   (phaser->clj
    (.CopyFrom line
               (clj->phaser source)
               (clj->phaser dest)))))

(defn equals
  "Compare two lines for strict equality.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The first line to compare.
    * to-compare (Phaser.Geom.Line) - The second line to compare.

  Returns:  boolean - Whether the two lines are equal."
  ([line line to-compare]
   (phaser->clj
    (.Equals line
             (clj->phaser line)
             (clj->phaser to-compare)))))

(defn extend
  "Extends the start and end points of a Line by the given amounts.

  The amounts can be positive or negative. Positive points will increase the length of the line,
  while negative ones will decrease it.

  If no `right` value is provided it will extend the length of the line equally in both directions.

  Pass a value of zero to leave the start or end point unchanged.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line instance to extend.
    * left (number) - The amount to extend the start of the line by.
    * right (number) {optional} - The amount to extend the end of the line by. If not given it will be set to the `left` value.

  Returns:  Phaser.Geom.Line - The modified Line instance."
  ([line line left]
   (phaser->clj
    (.Extend line
             (clj->phaser line)
             (clj->phaser left))))
  ([line line left right]
   (phaser->clj
    (.Extend line
             (clj->phaser line)
             (clj->phaser left)
             (clj->phaser right)))))

(defn get-mid-point
  "Get the midpoint of the given line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to get the midpoint of.
    * out (Phaser.Geom.Point | object) {optional} - An optional point object to store the midpoint in.

  Returns:  Phaser.Geom.Point | object - The midpoint of the Line."
  ([line line]
   (phaser->clj
    (.GetMidPoint line
                  (clj->phaser line))))
  ([line line out]
   (phaser->clj
    (.GetMidPoint line
                  (clj->phaser line)
                  (clj->phaser out)))))

(defn get-nearest-point
  "Get the nearest point on a line perpendicular to the given point.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to get the nearest point on.
    * point (Phaser.Geom.Point | object) - The point to get the nearest point to.
    * out (Phaser.Geom.Point | object) {optional} - An optional point, or point-like object, to store the coordinates of the nearest point on the line.

  Returns:  Phaser.Geom.Point | object - The nearest point on the line."
  ([line line point]
   (phaser->clj
    (.GetNearestPoint line
                      (clj->phaser line)
                      (clj->phaser point))))
  ([line line point out]
   (phaser->clj
    (.GetNearestPoint line
                      (clj->phaser line)
                      (clj->phaser point)
                      (clj->phaser out)))))

(defn get-normal
  "Calculate the normal of the given line.

  The normal of a line is a vector that points perpendicular from it.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the normal of.
    * out (Phaser.Geom.Point | object) {optional} - An optional point object to store the normal in.

  Returns:  Phaser.Geom.Point | object - The normal of the Line."
  ([line line]
   (phaser->clj
    (.GetNormal line
                (clj->phaser line))))
  ([line line out]
   (phaser->clj
    (.GetNormal line
                (clj->phaser line)
                (clj->phaser out)))))

(defn get-point
  "Get a point on a line that's a given percentage along its length.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line.
    * position (number) - A value between 0 and 1, where 0 is the start, 0.5 is the middle and 1 is the end of the line.
    * out (Phaser.Geom.Point | object) {optional} - An optional point, or point-like object, to store the coordinates of the point on the line.

  Returns:  Phaser.Geom.Point | object - The point on the line."
  ([line line position]
   (phaser->clj
    (.GetPoint line
               (clj->phaser line)
               (clj->phaser position))))
  ([line line position out]
   (phaser->clj
    (.GetPoint line
               (clj->phaser line)
               (clj->phaser position)
               (clj->phaser out)))))

(defn get-point
  "Get a point on a line that's a given percentage along its length.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * position (number) - A value between 0 and 1, where 0 is the start, 0.5 is the middle and 1 is the end of the line.
    * output (Phaser.Geom.Point | object) {optional} - An optional point, or point-like object, to store the coordinates of the point on the line.

  Returns:  Phaser.Geom.Point | object - A Point, or point-like object, containing the coordinates of the point on the line."
  ([line position]
   (phaser->clj
    (.getPoint line
               (clj->phaser position))))
  ([line position output]
   (phaser->clj
    (.getPoint line
               (clj->phaser position)
               (clj->phaser output)))))

(defn get-point-a
  "Returns a Vector2 object that corresponds to the start of this Line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * vec-2 (Phaser.Math.Vector2) {optional} - A Vector2 object to set the results in. If `undefined` a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 - A Vector2 object that corresponds to the start of this Line."
  ([line]
   (phaser->clj
    (.getPointA line)))
  ([line vec-2]
   (phaser->clj
    (.getPointA line
                (clj->phaser vec-2)))))

(defn get-point-b
  "Returns a Vector2 object that corresponds to the end of this Line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * vec-2 (Phaser.Math.Vector2) {optional} - A Vector2 object to set the results in. If `undefined` a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 - A Vector2 object that corresponds to the end of this Line."
  ([line]
   (phaser->clj
    (.getPointB line)))
  ([line vec-2]
   (phaser->clj
    (.getPointB line
                (clj->phaser vec-2)))))

(defn get-points
  "Get a number of points along a line's length.

  Provide a `quantity` to get an exact number of points along the line.

  Provide a `stepRate` to ensure a specific distance between each point on the line. Set `quantity` to `0` when
  providing a `stepRate`.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line.
    * quantity (integer) - The number of points to place on the line. Set to `0` to use `stepRate` instead.
    * step-rate (number) {optional} - The distance between each point on the line. When set, `quantity` is implied and should be set to `0`.
    * out (array | Array.<Phaser.Geom.Point>) {optional} - An optional array of Points, or point-like objects, to store the coordinates of the points on the line.

  Returns:  array | Array.<Phaser.Geom.Point> - An array of Points, or point-like objects, containing the coordinates of the points on the line."
  ([line line quantity]
   (phaser->clj
    (.GetPoints line
                (clj->phaser line)
                (clj->phaser quantity))))
  ([line line quantity step-rate]
   (phaser->clj
    (.GetPoints line
                (clj->phaser line)
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([line line quantity step-rate out]
   (phaser->clj
    (.GetPoints line
                (clj->phaser line)
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser out)))))

(defn get-points
  "Get a number of points along a line's length.

  Provide a `quantity` to get an exact number of points along the line.

  Provide a `stepRate` to ensure a specific distance between each point on the line. Set `quantity` to `0` when
  providing a `stepRate`.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * quantity (integer) - The number of points to place on the line. Set to `0` to use `stepRate` instead.
    * step-rate (integer) {optional} - The distance between each point on the line. When set, `quantity` is implied and should be set to `0`.
    * output (array | Array.<Phaser.Geom.Point>) {optional} - An optional array of Points, or point-like objects, to store the coordinates of the points on the line.

  Returns:  array | Array.<Phaser.Geom.Point> - An array of Points, or point-like objects, containing the coordinates of the points on the line."
  ([line quantity]
   (phaser->clj
    (.getPoints line
                (clj->phaser quantity))))
  ([line quantity step-rate]
   (phaser->clj
    (.getPoints line
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([line quantity step-rate output]
   (phaser->clj
    (.getPoints line
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser output)))))

(defn get-random-point
  "Get a random Point on the Line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * point (Phaser.Geom.Point | object) {optional} - An instance of a Point to be modified.

  Returns:  Phaser.Geom.Point - A random Point on the Line."
  ([line]
   (phaser->clj
    (.getRandomPoint line)))
  ([line point]
   (phaser->clj
    (.getRandomPoint line
                     (clj->phaser point)))))

(defn get-shortest-distance
  "Get the shortest distance from a Line to the given Point.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to get the distance from.
    * point (Phaser.Geom.Point | object) - The point to get the shortest distance to.

  Returns:  number - The shortest distance from the line to the point."
  ([line line point]
   (phaser->clj
    (.GetShortestDistance line
                          (clj->phaser line)
                          (clj->phaser point)))))

(defn height
  "Calculate the height of the given line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the height of.

  Returns:  number - The height of the line."
  ([line line]
   (phaser->clj
    (.Height line
             (clj->phaser line)))))

(defn length
  "Calculate the length of the given line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the length of.

  Returns:  number - The length of the line."
  ([line line]
   (phaser->clj
    (.Length line
             (clj->phaser line)))))

(defn normal-angle
  "Get the angle of the normal of the given line in radians.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the angle of the normal of.

  Returns:  number - The angle of the normal of the line in radians."
  ([line line]
   (phaser->clj
    (.NormalAngle line
                  (clj->phaser line)))))

(defn normal-x
  "[description]

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The Line object to get the normal value from.

  Returns:  number - [description]"
  ([line line]
   (phaser->clj
    (.NormalX line
              (clj->phaser line)))))

(defn normal-y
  "The Y value of the normal of the given line.
  The normal of a line is a vector that points perpendicular from it.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the normal of.

  Returns:  number - The Y value of the normal of the Line."
  ([line line]
   (phaser->clj
    (.NormalY line
              (clj->phaser line)))))

(defn offset
  "Offset a line by the given amount.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to offset.
    * x (number) - The horizontal offset to add to the line.
    * y (number) - The vertical offset to add to the line.

  Returns:  Phaser.Geom.Line - The offset line."
  ([line line x y]
   (phaser->clj
    (.Offset line
             (clj->phaser line)
             (clj->phaser x)
             (clj->phaser y)))))

(defn perp-slope
  "Calculate the perpendicular slope of the given line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the perpendicular slope of.

  Returns:  number - The perpendicular slope of the line."
  ([line line]
   (phaser->clj
    (.PerpSlope line
                (clj->phaser line)))))

(defn random
  "Returns a random point on a given Line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The Line to calculate the random Point on.
    * out (Phaser.Geom.Point | object) {optional} - An instance of a Point to be modified.

  Returns:  Phaser.Geom.Point | object - A random Point on the Line."
  ([line line]
   (phaser->clj
    (.Random line
             (clj->phaser line))))
  ([line line out]
   (phaser->clj
    (.Random line
             (clj->phaser line)
             (clj->phaser out)))))

(defn reflect-angle
  "Calculate the reflected angle between two lines.

  This is the outgoing angle based on the angle of Line 1 and the normalAngle of Line 2.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line-a (Phaser.Geom.Line) - The first line.
    * line-b (Phaser.Geom.Line) - The second line.

  Returns:  number - The reflected angle between each line."
  ([line line-a line-b]
   (phaser->clj
    (.ReflectAngle line
                   (clj->phaser line-a)
                   (clj->phaser line-b)))))

(defn rotate
  "Rotate a line around its midpoint by the given angle in radians.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to rotate.
    * angle (number) - The angle of rotation in radians.

  Returns:  Phaser.Geom.Line - The rotated line."
  ([line line angle]
   (phaser->clj
    (.Rotate line
             (clj->phaser line)
             (clj->phaser angle)))))

(defn rotate-around-point
  "Rotate a line around a point by the given angle in radians.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to rotate.
    * point (Phaser.Geom.Point | object) - The point to rotate the line around.
    * angle (number) - The angle of rotation in radians.

  Returns:  Phaser.Geom.Line - The rotated line."
  ([line line point angle]
   (phaser->clj
    (.RotateAroundPoint line
                        (clj->phaser line)
                        (clj->phaser point)
                        (clj->phaser angle)))))

(defn rotate-around-xy
  "Rotate a line around the given coordinates by the given angle in radians.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to rotate.
    * x (number) - The horizontal coordinate to rotate the line around.
    * y (number) - The vertical coordinate to rotate the line around.
    * angle (number) - The angle of rotation in radians.

  Returns:  Phaser.Geom.Line - The rotated line."
  ([line line x y angle]
   (phaser->clj
    (.RotateAroundXY line
                     (clj->phaser line)
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser angle)))))

(defn set-to
  "Set new coordinates for the line endpoints.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * x-1 (number) {optional} - The x coordinate of the lines starting point.
    * y-1 (number) {optional} - The y coordinate of the lines starting point.
    * x-2 (number) {optional} - The x coordinate of the lines ending point.
    * y-2 (number) {optional} - The y coordinate of the lines ending point.

  Returns:  Phaser.Geom.Line - This Line object."
  ([line]
   (phaser->clj
    (.setTo line)))
  ([line x-1]
   (phaser->clj
    (.setTo line
            (clj->phaser x-1))))
  ([line x-1 y-1]
   (phaser->clj
    (.setTo line
            (clj->phaser x-1)
            (clj->phaser y-1))))
  ([line x-1 y-1 x-2]
   (phaser->clj
    (.setTo line
            (clj->phaser x-1)
            (clj->phaser y-1)
            (clj->phaser x-2))))
  ([line x-1 y-1 x-2 y-2]
   (phaser->clj
    (.setTo line
            (clj->phaser x-1)
            (clj->phaser y-1)
            (clj->phaser x-2)
            (clj->phaser y-2)))))

(defn set-to-angle
  "Set a line to a given position, angle and length.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to set.
    * x (number) - The horizontal start position of the line.
    * y (number) - The vertical start position of the line.
    * angle (number) - The angle of the line in radians.
    * length (number) - The length of the line.

  Returns:  Phaser.Geom.Line - The updated line."
  ([line line x y angle length]
   (phaser->clj
    (.SetToAngle line
                 (clj->phaser line)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser angle)
                 (clj->phaser length)))))

(defn slope
  "Calculate the slope of the given line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the slope of.

  Returns:  number - The slope of the line."
  ([line line]
   (phaser->clj
    (.Slope line
            (clj->phaser line)))))

(defn width
  "Calculate the width of the given line.

  Parameters:
    * line (Phaser.Geom.Line) - Targeted instance for method
    * line (Phaser.Geom.Line) - The line to calculate the width of.

  Returns:  number - The width of the line."
  ([line line]
   (phaser->clj
    (.Width line
            (clj->phaser line)))))