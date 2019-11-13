(ns phzr.geom.triangle
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone]))

(defn ->Triangle
  "  Parameters:
    * x-1 (number) {optional} - `x` coordinate of the first point.
    * y-1 (number) {optional} - `y` coordinate of the first point.
    * x-2 (number) {optional} - `x` coordinate of the second point.
    * y-2 (number) {optional} - `y` coordinate of the second point.
    * x-3 (number) {optional} - `x` coordinate of the third point.
    * y-3 (number) {optional} - `y` coordinate of the third point."
  ([]
   (js/Phaser.Geom.Triangle.))
  ([x-1]
   (js/Phaser.Geom.Triangle. (clj->phaser x-1)))
  ([x-1 y-1]
   (js/Phaser.Geom.Triangle. (clj->phaser x-1)
                             (clj->phaser y-1)))
  ([x-1 y-1 x-2]
   (js/Phaser.Geom.Triangle. (clj->phaser x-1)
                             (clj->phaser y-1)
                             (clj->phaser x-2)))
  ([x-1 y-1 x-2 y-2]
   (js/Phaser.Geom.Triangle. (clj->phaser x-1)
                             (clj->phaser y-1)
                             (clj->phaser x-2)
                             (clj->phaser y-2)))
  ([x-1 y-1 x-2 y-2 x-3]
   (js/Phaser.Geom.Triangle. (clj->phaser x-1)
                             (clj->phaser y-1)
                             (clj->phaser x-2)
                             (clj->phaser y-2)
                             (clj->phaser x-3)))
  ([x-1 y-1 x-2 y-2 x-3 y-3]
   (js/Phaser.Geom.Triangle. (clj->phaser x-1)
                             (clj->phaser y-1)
                             (clj->phaser x-2)
                             (clj->phaser y-2)
                             (clj->phaser x-3)
                             (clj->phaser y-3))))

(defn area
  "Returns the area of a Triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to use.

  Returns:  number - The area of the Triangle, always non-negative."
  ([triangle triangle]
   (phaser->clj
    (.Area triangle
           (clj->phaser triangle)))))

(defn build-equilateral
  "Builds an equilateral triangle. In the equilateral triangle, all the sides are the same length (congruent) and all the angles are the same size (congruent).
  The x/y specifies the top-middle of the triangle (x1/y1) and length is the length of each side.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * x (number) - x coordinate of the top point of the triangle.
    * y (number) - y coordinate of the top point of the triangle.
    * length (number) - Length of each side of the triangle.

  Returns:  Phaser.Geom.Triangle - The Triangle object of the given size."
  ([triangle x y length]
   (phaser->clj
    (.BuildEquilateral triangle
                       (clj->phaser x)
                       (clj->phaser y)
                       (clj->phaser length)))))

(defn build-from-polygon
  "[description]

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * data (array) - A flat array of vertice coordinates like [x0,y0, x1,y1, x2,y2, ...]
    * holes (array) {optional} - An array of hole indices if any (e.g. [5, 8] for a 12-vertice input would mean one hole with vertices 5–7 and another with 8–11).
    * scale-x (number) {optional} - [description]
    * scale-y (number) {optional} - [description]
    * out (array | Array.<Phaser.Geom.Triangle>) {optional} - [description]

  Returns:  array | Array.<Phaser.Geom.Triangle> - [description]"
  ([triangle data]
   (phaser->clj
    (.BuildFromPolygon triangle
                       (clj->phaser data))))
  ([triangle data holes]
   (phaser->clj
    (.BuildFromPolygon triangle
                       (clj->phaser data)
                       (clj->phaser holes))))
  ([triangle data holes scale-x]
   (phaser->clj
    (.BuildFromPolygon triangle
                       (clj->phaser data)
                       (clj->phaser holes)
                       (clj->phaser scale-x))))
  ([triangle data holes scale-x scale-y]
   (phaser->clj
    (.BuildFromPolygon triangle
                       (clj->phaser data)
                       (clj->phaser holes)
                       (clj->phaser scale-x)
                       (clj->phaser scale-y))))
  ([triangle data holes scale-x scale-y out]
   (phaser->clj
    (.BuildFromPolygon triangle
                       (clj->phaser data)
                       (clj->phaser holes)
                       (clj->phaser scale-x)
                       (clj->phaser scale-y)
                       (clj->phaser out)))))

(defn build-right
  "Builds a right triangle, i.e. one which has a 90-degree angle and two acute angles.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * x (number) - The X coordinate of the right angle, which will also be the first X coordinate of the constructed Triangle.
    * y (number) - The Y coordinate of the right angle, which will also be the first Y coordinate of the constructed Triangle.
    * width (number) - The length of the side which is to the left or to the right of the right angle.
    * height (number) - The length of the side which is above or below the right angle.

  Returns:  Phaser.Geom.Triangle - The constructed right Triangle."
  ([triangle x y width height]
   (phaser->clj
    (.BuildRight triangle
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser width)
                 (clj->phaser height)))))

(defn center-on
  "Positions the Triangle so that it is centered on the given coordinates.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The triangle to be positioned.
    * x (number) - The horizontal coordinate to center on.
    * y (number) - The vertical coordinate to center on.
    * center-func (CenterFunction) {optional} - The function used to center the triangle. Defaults to Centroid centering.

  Returns:  Phaser.Geom.Triangle - The Triangle that was centered."
  ([triangle triangle x y]
   (phaser->clj
    (.CenterOn triangle
               (clj->phaser triangle)
               (clj->phaser x)
               (clj->phaser y))))
  ([triangle triangle x y center-func]
   (phaser->clj
    (.CenterOn triangle
               (clj->phaser triangle)
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser center-func)))))

(defn centroid
  "Calculates the position of a Triangle's centroid, which is also its center of mass (center of gravity).

  The centroid is the point in a Triangle at which its three medians (the lines drawn from the vertices to the bisectors of the opposite sides) meet. It divides each one in a 2:1 ratio.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to use.
    * out (Phaser.Geom.Point | object) {optional} - An object to store the coordinates in.

  Returns:  Phaser.Geom.Point | object - The `out` object with modified `x` and `y` properties, or a new Point if none was provided."
  ([triangle triangle]
   (phaser->clj
    (.Centroid triangle
               (clj->phaser triangle))))
  ([triangle triangle out]
   (phaser->clj
    (.Centroid triangle
               (clj->phaser triangle)
               (clj->phaser out)))))

(defn circum-center
  "Computes the circumcentre of a triangle. The circumcentre is the centre of
  the circumcircle, the smallest circle which encloses the triangle. It is also
  the common intersection point of the perpendicular bisectors of the sides of
  the triangle, and is the only point which has equal distance to all three
  vertices of the triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([triangle triangle]
   (phaser->clj
    (.CircumCenter triangle
                   (clj->phaser triangle))))
  ([triangle triangle out]
   (phaser->clj
    (.CircumCenter triangle
                   (clj->phaser triangle)
                   (clj->phaser out)))))

(defn circum-circle
  "Finds the circumscribed circle (circumcircle) of a Triangle object. The circumcircle is the circle which touches all of the triangle's vertices.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to use as input.
    * out (Phaser.Geom.Circle) {optional} - An optional Circle to store the result in.

  Returns:  Phaser.Geom.Circle - The updated `out` Circle, or a new Circle if none was provided."
  ([triangle triangle]
   (phaser->clj
    (.CircumCircle triangle
                   (clj->phaser triangle))))
  ([triangle triangle out]
   (phaser->clj
    (.CircumCircle triangle
                   (clj->phaser triangle)
                   (clj->phaser out)))))

(defn clone
  "Clones a Triangle object.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * source (Phaser.Geom.Triangle) - The Triangle to clone.

  Returns:  Phaser.Geom.Triangle - A new Triangle identical to the given one but separate from it."
  ([triangle source]
   (phaser->clj
    (.Clone triangle
            (clj->phaser source)))))

(defn contains
  "Checks if a point (as a pair of coordinates) is inside a Triangle's bounds.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to check.
    * x (number) - The X coordinate of the point to check.
    * y (number) - The Y coordinate of the point to check.

  Returns:  boolean - `true` if the point is inside the Triangle, otherwise `false`."
  ([triangle triangle x y]
   (phaser->clj
    (.Contains triangle
               (clj->phaser triangle)
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains
  "Checks whether a given points lies within the triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * x (number) - The x coordinate of the point to check.
    * y (number) - The y coordinate of the point to check.

  Returns:  boolean - `true` if the coordinate pair is within the triangle, otherwise `false`."
  ([triangle x y]
   (phaser->clj
    (.contains triangle
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains-array
  "Filters an array of point-like objects to only those contained within a triangle.
  If `returnFirst` is true, will return an array containing only the first point in the provided array that is within the triangle (or an empty array if there are no such points).

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The triangle that the points are being checked in.
    * points (Array.<Phaser.Geom.Point>) - An array of point-like objects (objects that have an `x` and `y` property)
    * return-first (boolean) {optional} - If `true`, return an array containing only the first point found that is within the triangle.
    * out (array) {optional} - If provided, the points that are within the triangle will be appended to this array instead of being added to a new array. If `returnFirst` is true, only the first point found within the triangle will be appended. This array will also be returned by this function.

  Returns:  Array.<Phaser.Geom.Point> - An array containing all the points from `points` that are within the triangle, if an array was provided as `out`, points will be appended to that array and it will also be returned here."
  ([triangle triangle points]
   (phaser->clj
    (.ContainsArray triangle
                    (clj->phaser triangle)
                    (clj->phaser points))))
  ([triangle triangle points return-first]
   (phaser->clj
    (.ContainsArray triangle
                    (clj->phaser triangle)
                    (clj->phaser points)
                    (clj->phaser return-first))))
  ([triangle triangle points return-first out]
   (phaser->clj
    (.ContainsArray triangle
                    (clj->phaser triangle)
                    (clj->phaser points)
                    (clj->phaser return-first)
                    (clj->phaser out)))))

(defn contains-point
  "Tests if a triangle contains a point.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The triangle.
    * point (Phaser.Geom.Point | Phaser.Math.Vector2 | any) - The point to test, or any point-like object with public `x` and `y` properties.

  Returns:  boolean - `true` if the point is within the triangle, otherwise `false`."
  ([triangle triangle point]
   (phaser->clj
    (.ContainsPoint triangle
                    (clj->phaser triangle)
                    (clj->phaser point)))))

(defn copy-from
  "Copy the values of one Triangle to a destination Triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * source (Phaser.Geom.Triangle) - The source Triangle to copy the values from.
    * dest (Phaser.Geom.Triangle) - The destination Triangle to copy the values to.

  Returns:  Phaser.Geom.Triangle - The destination Triangle."
  ([triangle source dest]
   (phaser->clj
    (.CopyFrom triangle
               (clj->phaser source)
               (clj->phaser dest)))))

(defn decompose
  "Decomposes a Triangle into an array of its points.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to decompose.
    * out (array) {optional} - An array to store the points into.

  Returns:  array - The provided `out` array, or a new array if none was provided, with three objects with `x` and `y` properties representing each point of the Triangle appended to it."
  ([triangle triangle]
   (phaser->clj
    (.Decompose triangle
                (clj->phaser triangle))))
  ([triangle triangle out]
   (phaser->clj
    (.Decompose triangle
                (clj->phaser triangle)
                (clj->phaser out)))))

(defn equals
  "Returns true if two triangles have the same coordinates.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The first triangle to check.
    * to-compare (Phaser.Geom.Triangle) - The second triangle to check.

  Returns:  boolean - `true` if the two given triangles have the exact same coordinates, otherwise `false`."
  ([triangle triangle to-compare]
   (phaser->clj
    (.Equals triangle
             (clj->phaser triangle)
             (clj->phaser to-compare)))))

(defn get-line-a
  "Returns a Line object that corresponds to Line A of this Triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * line (Phaser.Geom.Line) {optional} - A Line object to set the results in. If `undefined` a new Line will be created.

  Returns:  Phaser.Geom.Line - A Line object that corresponds to line A of this Triangle."
  ([triangle]
   (phaser->clj
    (.getLineA triangle)))
  ([triangle line]
   (phaser->clj
    (.getLineA triangle
               (clj->phaser line)))))

(defn get-line-b
  "Returns a Line object that corresponds to Line B of this Triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * line (Phaser.Geom.Line) {optional} - A Line object to set the results in. If `undefined` a new Line will be created.

  Returns:  Phaser.Geom.Line - A Line object that corresponds to line B of this Triangle."
  ([triangle]
   (phaser->clj
    (.getLineB triangle)))
  ([triangle line]
   (phaser->clj
    (.getLineB triangle
               (clj->phaser line)))))

(defn get-line-c
  "Returns a Line object that corresponds to Line C of this Triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * line (Phaser.Geom.Line) {optional} - A Line object to set the results in. If `undefined` a new Line will be created.

  Returns:  Phaser.Geom.Line - A Line object that corresponds to line C of this Triangle."
  ([triangle]
   (phaser->clj
    (.getLineC triangle)))
  ([triangle line]
   (phaser->clj
    (.getLineC triangle
               (clj->phaser line)))))

(defn get-point
  "Returns a Point from around the perimeter of a Triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to get the point on its perimeter from.
    * position (number) - The position along the perimeter of the triangle. A value between 0 and 1.
    * out (Phaser.Geom.Point | object) {optional} - An option Point, or Point-like object to store the value in. If not given a new Point will be created.

  Returns:  Phaser.Geom.Point | object - A Point object containing the given position from the perimeter of the triangle."
  ([triangle triangle position]
   (phaser->clj
    (.GetPoint triangle
               (clj->phaser triangle)
               (clj->phaser position))))
  ([triangle triangle position out]
   (phaser->clj
    (.GetPoint triangle
               (clj->phaser triangle)
               (clj->phaser position)
               (clj->phaser out)))))

(defn get-point
  "Returns a specific point  on the triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * position (number) - Position as float within `0` and `1`. `0` equals the first point.
    * output (Phaser.Geom.Point | object) {optional} - Optional Point, or point-like object, that the calculated point will be written to.

  Returns:  Phaser.Geom.Point | object - Calculated `Point` that represents the requested position. It is the same as `output` when this parameter has been given."
  ([triangle position]
   (phaser->clj
    (.getPoint triangle
               (clj->phaser position))))
  ([triangle position output]
   (phaser->clj
    (.getPoint triangle
               (clj->phaser position)
               (clj->phaser output)))))

(defn get-points
  "Returns an array of evenly spaced points on the perimeter of a Triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to get the points from.
    * quantity (integer) - The number of evenly spaced points to return. Set to 0 to return an arbitrary number of points based on the `stepRate`.
    * step-rate (number) - If `quantity` is 0, the distance between each returned point.
    * out (array | Array.<Phaser.Geom.Point>) {optional} - An array to which the points should be appended.

  Returns:  array | Array.<Phaser.Geom.Point> - The modified `out` array, or a new array if none was provided."
  ([triangle triangle quantity step-rate]
   (phaser->clj
    (.GetPoints triangle
                (clj->phaser triangle)
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([triangle triangle quantity step-rate out]
   (phaser->clj
    (.GetPoints triangle
                (clj->phaser triangle)
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser out)))))

(defn get-points
  "Calculates a list of evenly distributed points on the triangle. It is either possible to pass an amount of points to be generated (`quantity`) or the distance between two points (`stepRate`).

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * quantity (integer) - Number of points to be generated. Can be falsey when `stepRate` should be used. All points have the same distance along the triangle.
    * step-rate (number) {optional} - Distance between two points. Will only be used when `quantity` is falsey.
    * output (array | Array.<Phaser.Geom.Point>) {optional} - Optional Array for writing the calculated points into. Otherwise a new array will be created.

  Returns:  array | Array.<Phaser.Geom.Point> - Returns a list of calculated `Point` instances or the filled array passed as parameter `output`."
  ([triangle quantity]
   (phaser->clj
    (.getPoints triangle
                (clj->phaser quantity))))
  ([triangle quantity step-rate]
   (phaser->clj
    (.getPoints triangle
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([triangle quantity step-rate output]
   (phaser->clj
    (.getPoints triangle
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser output)))))

(defn get-random-point
  "Returns a random point along the triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * point (Phaser.Geom.Point) {optional} - Optional `Point` that should be modified. Otherwise a new one will be created.

  Returns:  Phaser.Geom.Point - Random `Point`. When parameter `point` has been provided it will be returned."
  ([triangle]
   (phaser->clj
    (.getRandomPoint triangle)))
  ([triangle point]
   (phaser->clj
    (.getRandomPoint triangle
                     (clj->phaser point)))))

(defn in-center
  "Calculates the position of the incenter of a Triangle object. This is the point where its three angle bisectors meet and it's also the center of the incircle, which is the circle inscribed in the triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to find the incenter of.
    * out (Phaser.Geom.Point) {optional} - An optional Point in which to store the coordinates.

  Returns:  Phaser.Geom.Point - Point (x, y) of the center pixel of the triangle."
  ([triangle triangle]
   (phaser->clj
    (.InCenter triangle
               (clj->phaser triangle))))
  ([triangle triangle out]
   (phaser->clj
    (.InCenter triangle
               (clj->phaser triangle)
               (clj->phaser out)))))

(defn offset
  "Moves each point (vertex) of a Triangle by a given offset, thus moving the entire Triangle by that offset.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to move.
    * x (number) - The horizontal offset (distance) by which to move each point. Can be positive or negative.
    * y (number) - The vertical offset (distance) by which to move each point. Can be positive or negative.

  Returns:  Phaser.Geom.Triangle - The modified Triangle."
  ([triangle triangle x y]
   (phaser->clj
    (.Offset triangle
             (clj->phaser triangle)
             (clj->phaser x)
             (clj->phaser y)))))

(defn perimeter
  "Gets the length of the perimeter of the given triangle.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - [description]

  Returns:  number - [description]"
  ([triangle triangle]
   (phaser->clj
    (.Perimeter triangle
                (clj->phaser triangle)))))

(defn random
  "[description]

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - [description]
    * out (Phaser.Geom.Point) {optional} - [description]

  Returns:  Phaser.Geom.Point - [description]"
  ([triangle triangle]
   (phaser->clj
    (.Random triangle
             (clj->phaser triangle))))
  ([triangle triangle out]
   (phaser->clj
    (.Random triangle
             (clj->phaser triangle)
             (clj->phaser out)))))

(defn rotate
  "Rotates a Triangle about its incenter, which is the point at which its three angle bisectors meet.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to rotate.
    * angle (number) - The angle by which to rotate the Triangle, in radians.

  Returns:  Phaser.Geom.Triangle - The rotated Triangle."
  ([triangle triangle angle]
   (phaser->clj
    (.Rotate triangle
             (clj->phaser triangle)
             (clj->phaser angle)))))

(defn rotate-around-point
  "Rotates a Triangle at a certain angle about a given Point or object with public `x` and `y` properties.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to rotate.
    * point (Phaser.Geom.Point) - The Point to rotate the Triangle about.
    * angle (number) - The angle by which to rotate the Triangle, in radians.

  Returns:  Phaser.Geom.Triangle - The rotated Triangle."
  ([triangle triangle point angle]
   (phaser->clj
    (.RotateAroundPoint triangle
                        (clj->phaser triangle)
                        (clj->phaser point)
                        (clj->phaser angle)))))

(defn rotate-around-xy
  "Rotates an entire Triangle at a given angle about a specific point.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * triangle (Phaser.Geom.Triangle) - The Triangle to rotate.
    * x (number) - The X coordinate of the point to rotate the Triangle about.
    * y (number) - The Y coordinate of the point to rotate the Triangle about.
    * angle (number) - The angle by which to rotate the Triangle, in radians.

  Returns:  Phaser.Geom.Triangle - The rotated Triangle."
  ([triangle triangle x y angle]
   (phaser->clj
    (.RotateAroundXY triangle
                     (clj->phaser triangle)
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser angle)))))

(defn set-to
  "Sets all three points of the triangle. Leaving out any coordinate sets it to be `0`.

  Parameters:
    * triangle (Phaser.Geom.Triangle) - Targeted instance for method
    * x-1 (number) {optional} - `x` coordinate of the first point.
    * y-1 (number) {optional} - `y` coordinate of the first point.
    * x-2 (number) {optional} - `x` coordinate of the second point.
    * y-2 (number) {optional} - `y` coordinate of the second point.
    * x-3 (number) {optional} - `x` coordinate of the third point.
    * y-3 (number) {optional} - `y` coordinate of the third point.

  Returns:  Phaser.Geom.Triangle - This Triangle object."
  ([triangle]
   (phaser->clj
    (.setTo triangle)))
  ([triangle x-1]
   (phaser->clj
    (.setTo triangle
            (clj->phaser x-1))))
  ([triangle x-1 y-1]
   (phaser->clj
    (.setTo triangle
            (clj->phaser x-1)
            (clj->phaser y-1))))
  ([triangle x-1 y-1 x-2]
   (phaser->clj
    (.setTo triangle
            (clj->phaser x-1)
            (clj->phaser y-1)
            (clj->phaser x-2))))
  ([triangle x-1 y-1 x-2 y-2]
   (phaser->clj
    (.setTo triangle
            (clj->phaser x-1)
            (clj->phaser y-1)
            (clj->phaser x-2)
            (clj->phaser y-2))))
  ([triangle x-1 y-1 x-2 y-2 x-3]
   (phaser->clj
    (.setTo triangle
            (clj->phaser x-1)
            (clj->phaser y-1)
            (clj->phaser x-2)
            (clj->phaser y-2)
            (clj->phaser x-3))))
  ([triangle x-1 y-1 x-2 y-2 x-3 y-3]
   (phaser->clj
    (.setTo triangle
            (clj->phaser x-1)
            (clj->phaser y-1)
            (clj->phaser x-2)
            (clj->phaser y-2)
            (clj->phaser x-3)
            (clj->phaser y-3)))))