(ns phzr.geom.rectangle
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone]))

(defn ->Rectangle
  "  Parameters:
    * x (number) {optional} - The X coordinate of the top left corner of the Rectangle.
    * y (number) {optional} - The Y coordinate of the top left corner of the Rectangle.
    * width (number) {optional} - The width of the Rectangle.
    * height (number) {optional} - The height of the Rectangle."
  ([]
   (js/Phaser.Geom.Rectangle.))
  ([x]
   (js/Phaser.Geom.Rectangle. (clj->phaser x)))
  ([x y]
   (js/Phaser.Geom.Rectangle. (clj->phaser x)
                              (clj->phaser y)))
  ([x y width]
   (js/Phaser.Geom.Rectangle. (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser width)))
  ([x y width height]
   (js/Phaser.Geom.Rectangle. (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser width)
                              (clj->phaser height))))

(defn area
  "Calculates the area of the given Rectangle object.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The rectangle to calculate the area of.

  Returns:  number - The area of the Rectangle object."
  ([rectangle rect]
   (phaser->clj
    (.Area rectangle
           (clj->phaser rect)))))

(defn ceil
  "Rounds a Rectangle's position up to the smallest integer greater than or equal to each current coordinate.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to adjust.

  Returns:  Phaser.Geom.Rectangle - The adjusted Rectangle."
  ([rectangle rect]
   (phaser->clj
    (.Ceil rectangle
           (clj->phaser rect)))))

(defn ceil-all
  "Rounds a Rectangle's position and size up to the smallest integer greater than or equal to each respective value.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to modify.

  Returns:  Phaser.Geom.Rectangle - The modified Rectangle."
  ([rectangle rect]
   (phaser->clj
    (.CeilAll rectangle
              (clj->phaser rect)))))

(defn center-on
  "Moves the top-left corner of a Rectangle so that its center is at the given coordinates.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to be centered.
    * x (number) - The X coordinate of the Rectangle's center.
    * y (number) - The Y coordinate of the Rectangle's center.

  Returns:  Phaser.Geom.Rectangle - The centered rectangle."
  ([rectangle rect x y]
   (phaser->clj
    (.CenterOn rectangle
               (clj->phaser rect)
               (clj->phaser x)
               (clj->phaser y)))))

(defn clone
  "Creates a new Rectangle which is identical to the given one.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * source (Phaser.Geom.Rectangle) - The Rectangle to clone.

  Returns:  Phaser.Geom.Rectangle - The newly created Rectangle, which is separate from the given one."
  ([rectangle source]
   (phaser->clj
    (.Clone rectangle
            (clj->phaser source)))))

(defn contains
  "Checks if a given point is inside a Rectangle's bounds.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to check.
    * x (number) - The X coordinate of the point to check.
    * y (number) - The Y coordinate of the point to check.

  Returns:  boolean - `true` if the point is within the Rectangle's bounds, otherwise `false`."
  ([rectangle rect x y]
   (phaser->clj
    (.Contains rectangle
               (clj->phaser rect)
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains
  "Checks if the given point is inside the Rectangle's bounds.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * x (number) - The X coordinate of the point to check.
    * y (number) - The Y coordinate of the point to check.

  Returns:  boolean - `true` if the point is within the Rectangle's bounds, otherwise `false`."
  ([rectangle x y]
   (phaser->clj
    (.contains rectangle
               (clj->phaser x)
               (clj->phaser y)))))

(defn contains-point
  "Determines whether the specified point is contained within the rectangular region defined by this Rectangle object.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle object.
    * point (Phaser.Geom.Point) - The point object to be checked. Can be a Phaser Point object or any object with x and y values.

  Returns:  boolean - A value of true if the Rectangle object contains the specified point, otherwise false."
  ([rectangle rect point]
   (phaser->clj
    (.ContainsPoint rectangle
                    (clj->phaser rect)
                    (clj->phaser point)))))

(defn contains-rect
  "Tests if one rectangle fully contains another.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect-a (Phaser.Geom.Rectangle) - The first rectangle.
    * rect-b (Phaser.Geom.Rectangle) - The second rectangle.

  Returns:  boolean - True only if rectA fully contains rectB."
  ([rectangle rect-a rect-b]
   (phaser->clj
    (.ContainsRect rectangle
                   (clj->phaser rect-a)
                   (clj->phaser rect-b)))))

(defn copy-from
  "Copy the values of one Rectangle to a destination Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * source (Phaser.Geom.Rectangle) - The source Rectangle to copy the values from.
    * dest (Phaser.Geom.Rectangle) - The destination Rectangle to copy the values to.

  Returns:  Phaser.Geom.Rectangle - The destination Rectangle."
  ([rectangle source dest]
   (phaser->clj
    (.CopyFrom rectangle
               (clj->phaser source)
               (clj->phaser dest)))))

(defn decompose
  "Create an array of points for each corner of a Rectangle
  If an array is specified, each point object will be added to the end of the array, otherwise a new array will be created.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle object to be decomposed.
    * out (array) {optional} - If provided, each point will be added to this array.

  Returns:  array - Will return the array you specified or a new array containing the points of the Rectangle."
  ([rectangle rect]
   (phaser->clj
    (.Decompose rectangle
                (clj->phaser rect))))
  ([rectangle rect out]
   (phaser->clj
    (.Decompose rectangle
                (clj->phaser rect)
                (clj->phaser out)))))

(defn equals
  "Compares the `x`, `y`, `width` and `height` properties of two rectangles.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - Rectangle A
    * to-compare (Phaser.Geom.Rectangle) - Rectangle B

  Returns:  boolean - `true` if the rectangles' properties are an exact match, otherwise `false`."
  ([rectangle rect to-compare]
   (phaser->clj
    (.Equals rectangle
             (clj->phaser rect)
             (clj->phaser to-compare)))))

(defn fit-inside
  "Adjusts the target rectangle, changing its width, height and position,
  so that it fits inside the area of the source rectangle, while maintaining its original
  aspect ratio.

  Unlike the `FitOutside` function, there may be some space inside the source area not covered.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * target (Phaser.Geom.Rectangle) - The target rectangle to adjust.
    * source (Phaser.Geom.Rectangle) - The source rectangle to envelop the target in.

  Returns:  Phaser.Geom.Rectangle - The modified target rectangle instance."
  ([rectangle target source]
   (phaser->clj
    (.FitInside rectangle
                (clj->phaser target)
                (clj->phaser source)))))

(defn fit-outside
  "Adjusts the target rectangle, changing its width, height and position,
  so that it fully covers the area of the source rectangle, while maintaining its original
  aspect ratio.

  Unlike the `FitInside` function, the target rectangle may extend further out than the source.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * target (Phaser.Geom.Rectangle) - The target rectangle to adjust.
    * source (Phaser.Geom.Rectangle) - The source rectangle to envlope the target in.

  Returns:  Phaser.Geom.Rectangle - The modified target rectangle instance."
  ([rectangle target source]
   (phaser->clj
    (.FitOutside rectangle
                 (clj->phaser target)
                 (clj->phaser source)))))

(defn floor
  "Rounds down (floors) the top left X and Y co-ordinates of the given Rectangle to the largest integer less than or equal to them

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The rectangle to floor the top left X and Y co-ordinates of

  Returns:  Phaser.Geom.Rectangle - The rectangle that was passed to this function with its co-ordinates floored."
  ([rectangle rect]
   (phaser->clj
    (.Floor rectangle
            (clj->phaser rect)))))

(defn floor-all
  "Rounds a Rectangle's position and size down to the largest integer less than or equal to each current coordinate or dimension.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to adjust.

  Returns:  Phaser.Geom.Rectangle - The adjusted Rectangle."
  ([rectangle rect]
   (phaser->clj
    (.FloorAll rectangle
               (clj->phaser rect)))))

(defn from-points
  "Constructs new Rectangle or repositions and resizes an existing Rectangle so that all of the given points are on or within its bounds.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * points (array) - An array of points (either arrays with two elements corresponding to the X and Y coordinate or an object with public `x` and `y` properties) which should be surrounded by the Rectangle.
    * out (Phaser.Geom.Rectangle) {optional} - Optional Rectangle to adjust.

  Returns:  Phaser.Geom.Rectangle - The adjusted `out` Rectangle, or a new Rectangle if none was provided."
  ([rectangle points]
   (phaser->clj
    (.FromPoints rectangle
                 (clj->phaser points))))
  ([rectangle points out]
   (phaser->clj
    (.FromPoints rectangle
                 (clj->phaser points)
                 (clj->phaser out)))))

(defn get-aspect-ratio
  "Calculates the width/height ratio of a rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The rectangle.

  Returns:  number - The width/height ratio of the rectangle."
  ([rectangle rect]
   (phaser->clj
    (.GetAspectRatio rectangle
                     (clj->phaser rect)))))

(defn get-center
  "Returns the center of a Rectangle as a Point.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to get the center of.
    * out (Phaser.Geom.Point | object) {optional} - Optional point-like object to update with the center coordinates.

  Returns:  Phaser.Geom.Point | object - The modified `out` object, or a new Point if none was provided."
  ([rectangle rect]
   (phaser->clj
    (.GetCenter rectangle
                (clj->phaser rect))))
  ([rectangle rect out]
   (phaser->clj
    (.GetCenter rectangle
                (clj->phaser rect)
                (clj->phaser out)))))

(defn get-line-a
  "Returns a Line object that corresponds to the top of this Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * line (Phaser.Geom.Line) {optional} - A Line object to set the results in. If `undefined` a new Line will be created.

  Returns:  Phaser.Geom.Line - A Line object that corresponds to the top of this Rectangle."
  ([rectangle]
   (phaser->clj
    (.getLineA rectangle)))
  ([rectangle line]
   (phaser->clj
    (.getLineA rectangle
               (clj->phaser line)))))

(defn get-line-b
  "Returns a Line object that corresponds to the right of this Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * line (Phaser.Geom.Line) {optional} - A Line object to set the results in. If `undefined` a new Line will be created.

  Returns:  Phaser.Geom.Line - A Line object that corresponds to the right of this Rectangle."
  ([rectangle]
   (phaser->clj
    (.getLineB rectangle)))
  ([rectangle line]
   (phaser->clj
    (.getLineB rectangle
               (clj->phaser line)))))

(defn get-line-c
  "Returns a Line object that corresponds to the bottom of this Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * line (Phaser.Geom.Line) {optional} - A Line object to set the results in. If `undefined` a new Line will be created.

  Returns:  Phaser.Geom.Line - A Line object that corresponds to the bottom of this Rectangle."
  ([rectangle]
   (phaser->clj
    (.getLineC rectangle)))
  ([rectangle line]
   (phaser->clj
    (.getLineC rectangle
               (clj->phaser line)))))

(defn get-line-d
  "Returns a Line object that corresponds to the left of this Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * line (Phaser.Geom.Line) {optional} - A Line object to set the results in. If `undefined` a new Line will be created.

  Returns:  Phaser.Geom.Line - A Line object that corresponds to the left of this Rectangle."
  ([rectangle]
   (phaser->clj
    (.getLineD rectangle)))
  ([rectangle line]
   (phaser->clj
    (.getLineD rectangle
               (clj->phaser line)))))

(defn get-point
  "Position is a value between 0 and 1 where 0 = the top-left of the rectangle and 0.5 = the bottom right.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rectangle (Phaser.Geom.Rectangle) - [description]
    * position (number) - [description]
    * out (Phaser.Geom.Point | object) {optional} - [description]

  Returns:  Phaser.Geom.Point - [description]"
  ([rectangle rectangle position]
   (phaser->clj
    (.GetPoint rectangle
               (clj->phaser rectangle)
               (clj->phaser position))))
  ([rectangle rectangle position out]
   (phaser->clj
    (.GetPoint rectangle
               (clj->phaser rectangle)
               (clj->phaser position)
               (clj->phaser out)))))

(defn get-point
  "Calculates the coordinates of a point at a certain `position` on the Rectangle's perimeter.

  The `position` is a fraction between 0 and 1 which defines how far into the perimeter the point is.

  A value of 0 or 1 returns the point at the top left corner of the rectangle, while a value of 0.5 returns the point at the bottom right corner of the rectangle. Values between 0 and 0.5 are on the top or the right side and values between 0.5 and 1 are on the bottom or the left side.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * position (number) - The normalized distance into the Rectangle's perimeter to return.
    * output (Phaser.Geom.Point | object) {optional} - An object to update with the `x` and `y` coordinates of the point.

  Returns:  Phaser.Geom.Point | object - The updated `output` object, or a new Point if no `output` object was given."
  ([rectangle position]
   (phaser->clj
    (.getPoint rectangle
               (clj->phaser position))))
  ([rectangle position output]
   (phaser->clj
    (.getPoint rectangle
               (clj->phaser position)
               (clj->phaser output)))))

(defn get-points
  "Return an array of points from the perimeter of the rectangle, each spaced out based on the quantity or step required.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rectangle (Phaser.Geom.Rectangle) - The Rectangle object to get the points from.
    * step (number) - Step between points. Used to calculate the number of points to return when quantity is falsy. Ignored if quantity is positive.
    * quantity (integer) - The number of evenly spaced points from the rectangles perimeter to return. If falsy, step param will be used to calculate the number of points.
    * out (array | Array.<Phaser.Geom.Point>) {optional} - An optional array to store the points in.

  Returns:  array | Array.<Phaser.Geom.Point> - An array of Points from the perimeter of the rectangle."
  ([rectangle rectangle step quantity]
   (phaser->clj
    (.GetPoints rectangle
                (clj->phaser rectangle)
                (clj->phaser step)
                (clj->phaser quantity))))
  ([rectangle rectangle step quantity out]
   (phaser->clj
    (.GetPoints rectangle
                (clj->phaser rectangle)
                (clj->phaser step)
                (clj->phaser quantity)
                (clj->phaser out)))))

(defn get-points
  "Returns an array of points from the perimeter of the Rectangle, each spaced out based on the quantity or step required.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * quantity (integer) - The number of points to return. Set to `false` or 0 to return an arbitrary number of points (`perimeter / stepRate`) evenly spaced around the Rectangle based on the `stepRate`.
    * step-rate (number) {optional} - If `quantity` is 0, determines the normalized distance between each returned point.
    * output (array | Array.<Phaser.Geom.Point>) {optional} - An array to which to append the points.

  Returns:  array | Array.<Phaser.Geom.Point> - The modified `output` array, or a new array if none was provided."
  ([rectangle quantity]
   (phaser->clj
    (.getPoints rectangle
                (clj->phaser quantity))))
  ([rectangle quantity step-rate]
   (phaser->clj
    (.getPoints rectangle
                (clj->phaser quantity)
                (clj->phaser step-rate))))
  ([rectangle quantity step-rate output]
   (phaser->clj
    (.getPoints rectangle
                (clj->phaser quantity)
                (clj->phaser step-rate)
                (clj->phaser output)))))

(defn get-random-point
  "Returns a random point within the Rectangle's bounds.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * point (Phaser.Geom.Point) {optional} - The object in which to store the `x` and `y` coordinates of the point.

  Returns:  Phaser.Geom.Point - The updated `point`, or a new Point if none was provided."
  ([rectangle]
   (phaser->clj
    (.getRandomPoint rectangle)))
  ([rectangle point]
   (phaser->clj
    (.getRandomPoint rectangle
                     (clj->phaser point)))))

(defn get-size
  "The size of the Rectangle object, expressed as a Point object
   with the values of the width and height properties.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - [description]
    * out (Phaser.Geom.Point | object) {optional} - [description]

  Returns:  Phaser.Geom.Point | object - [description]"
  ([rectangle rect]
   (phaser->clj
    (.GetSize rectangle
              (clj->phaser rect))))
  ([rectangle rect out]
   (phaser->clj
    (.GetSize rectangle
              (clj->phaser rect)
              (clj->phaser out)))))

(defn inflate
  "Increases the size of a Rectangle by a specified amount.

  The center of the Rectangle stays the same. The amounts are added to each side, so the actual increase in width or height is two times bigger than the respective argument.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to inflate.
    * x (number) - How many pixels the left and the right side should be moved by horizontally.
    * y (number) - How many pixels the top and the bottom side should be moved by vertically.

  Returns:  Phaser.Geom.Rectangle - The inflated Rectangle."
  ([rectangle rect x y]
   (phaser->clj
    (.Inflate rectangle
              (clj->phaser rect)
              (clj->phaser x)
              (clj->phaser y)))))

(defn intersection
  "Takes two Rectangles and first checks to see if they intersect.
  If they intersect it will return the area of intersection in the `out` Rectangle.
  If they do not intersect, the `out` Rectangle will have a width and height of zero.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect-a (Phaser.Geom.Rectangle) - The first Rectangle to get the intersection from.
    * rect-b (Phaser.Geom.Rectangle) - The second Rectangle to get the intersection from.
    * out (Phaser.Geom.Rectangle) {optional} - A Rectangle to store the intersection results in.

  Returns:  Phaser.Geom.Rectangle - The intersection result. If the width and height are zero, no intersection occurred."
  ([rectangle rect-a rect-b]
   (phaser->clj
    (.Intersection rectangle
                   (clj->phaser rect-a)
                   (clj->phaser rect-b))))
  ([rectangle rect-a rect-b out]
   (phaser->clj
    (.Intersection rectangle
                   (clj->phaser rect-a)
                   (clj->phaser rect-b)
                   (clj->phaser out)))))

(defn is-empty
  "Determines if the Rectangle is empty. A Rectangle is empty if its width or height is less than or equal to 0.

  Returns:  boolean - `true` if the Rectangle is empty. A Rectangle object is empty if its width or height is less than or equal to 0."
  ([rectangle]
   (phaser->clj
    (.isEmpty rectangle))))

(defn marching-ants
  "Return an array of points from the perimeter of the rectangle
   each spaced out based on the quantity or step required

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - [description]
    * step (number) - [description]
    * quantity (integer) - [description]
    * out (array | Array.<Phaser.Geom.Point>) {optional} - [description]

  Returns:  array | Array.<Phaser.Geom.Point> - [description]"
  ([rectangle rect step quantity]
   (phaser->clj
    (.MarchingAnts rectangle
                   (clj->phaser rect)
                   (clj->phaser step)
                   (clj->phaser quantity))))
  ([rectangle rect step quantity out]
   (phaser->clj
    (.MarchingAnts rectangle
                   (clj->phaser rect)
                   (clj->phaser step)
                   (clj->phaser quantity)
                   (clj->phaser out)))))

(defn merge-points
  "Merges a Rectangle with a list of points by repositioning and/or resizing it such that all points are located on or within its bounds.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * target (Phaser.Geom.Rectangle) - The Rectangle which should be merged.
    * points (Array.<Phaser.Geom.Point>) - An array of Points (or any object with public `x` and `y` properties) which should be merged with the Rectangle.

  Returns:  Phaser.Geom.Rectangle - The modified Rectangle."
  ([rectangle target points]
   (phaser->clj
    (.MergePoints rectangle
                  (clj->phaser target)
                  (clj->phaser points)))))

(defn merge-rect
  "Merges the source rectangle into the target rectangle and returns the target.
  Neither rectangle should have a negative width or height.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * target (Phaser.Geom.Rectangle) - Target rectangle. Will be modified to include source rectangle.
    * source (Phaser.Geom.Rectangle) - Rectangle that will be merged into target rectangle.

  Returns:  Phaser.Geom.Rectangle - Modified target rectangle that contains source rectangle."
  ([rectangle target source]
   (phaser->clj
    (.MergeRect rectangle
                (clj->phaser target)
                (clj->phaser source)))))

(defn merge-xy
  "Merges a Rectangle with a point by repositioning and/or resizing it so that the point is on or within its bounds.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * target (Phaser.Geom.Rectangle) - The Rectangle which should be merged and modified.
    * x (number) - The X coordinate of the point which should be merged.
    * y (number) - The Y coordinate of the point which should be merged.

  Returns:  Phaser.Geom.Rectangle - The modified `target` Rectangle."
  ([rectangle target x y]
   (phaser->clj
    (.MergeXY rectangle
              (clj->phaser target)
              (clj->phaser x)
              (clj->phaser y)))))

(defn offset
  "Nudges (translates) the top left corner of a Rectangle by a given offset.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to adjust.
    * x (number) - The distance to move the Rectangle horizontally.
    * y (number) - The distance to move the Rectangle vertically.

  Returns:  Phaser.Geom.Rectangle - The adjusted Rectangle."
  ([rectangle rect x y]
   (phaser->clj
    (.Offset rectangle
             (clj->phaser rect)
             (clj->phaser x)
             (clj->phaser y)))))

(defn offset-point
  "Nudges (translates) the top-left corner of a Rectangle by the coordinates of a point (translation vector).

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to adjust.
    * point (Phaser.Geom.Point | Phaser.Math.Vector2) - The point whose coordinates should be used as an offset.

  Returns:  Phaser.Geom.Rectangle - The adjusted Rectangle."
  ([rectangle rect point]
   (phaser->clj
    (.OffsetPoint rectangle
                  (clj->phaser rect)
                  (clj->phaser point)))))

(defn overlaps
  "Checks if two Rectangles overlap. If a Rectangle is within another Rectangle, the two will be considered overlapping. Thus, the Rectangles are treated as 'solid'.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect-a (Phaser.Geom.Rectangle) - The first Rectangle to check.
    * rect-b (Phaser.Geom.Rectangle) - The second Rectangle to check.

  Returns:  boolean - `true` if the two Rectangles overlap, `false` otherwise."
  ([rectangle rect-a rect-b]
   (phaser->clj
    (.Overlaps rectangle
               (clj->phaser rect-a)
               (clj->phaser rect-b)))))

(defn perimeter
  "Calculates the perimeter of a Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to use.

  Returns:  number - The perimeter of the Rectangle, equal to `(width * 2) + (height * 2)`."
  ([rectangle rect]
   (phaser->clj
    (.Perimeter rectangle
                (clj->phaser rect)))))

(defn perimeter-point
  "[description]

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rectangle (Phaser.Geom.Rectangle) - [description]
    * angle (integer) - [description]
    * out (Phaser.Geom.Point) {optional} - [description]

  Returns:  Phaser.Geom.Point - [description]"
  ([rectangle rectangle angle]
   (phaser->clj
    (.PerimeterPoint rectangle
                     (clj->phaser rectangle)
                     (clj->phaser angle))))
  ([rectangle rectangle angle out]
   (phaser->clj
    (.PerimeterPoint rectangle
                     (clj->phaser rectangle)
                     (clj->phaser angle)
                     (clj->phaser out)))))

(defn random
  "Returns a random point within a Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The Rectangle to return a point from.
    * out (Phaser.Geom.Point) - The object to update with the point's coordinates.

  Returns:  Phaser.Geom.Point - The modified `out` object, or a new Point if none was provided."
  ([rectangle rect out]
   (phaser->clj
    (.Random rectangle
             (clj->phaser rect)
             (clj->phaser out)))))

(defn random-outside
  "Calculates a random point that lies within the `outer` Rectangle, but outside of the `inner` Rectangle.
  The inner Rectangle must be fully contained within the outer rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * outer (Phaser.Geom.Rectangle) - The outer Rectangle to get the random point within.
    * inner (Phaser.Geom.Rectangle) - The inner Rectangle to exclude from the returned point.
    * out (Phaser.Geom.Point) {optional} - A Point, or Point-like object to store the result in. If not specified, a new Point will be created.

  Returns:  Phaser.Geom.Point - A Point object containing the random values in its `x` and `y` properties."
  ([rectangle outer inner]
   (phaser->clj
    (.RandomOutside rectangle
                    (clj->phaser outer)
                    (clj->phaser inner))))
  ([rectangle outer inner out]
   (phaser->clj
    (.RandomOutside rectangle
                    (clj->phaser outer)
                    (clj->phaser inner)
                    (clj->phaser out)))))

(defn same-dimensions
  "Determines if the two objects (either Rectangles or Rectangle-like) have the same width and height values under strict equality.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The first Rectangle object.
    * to-compare (Phaser.Geom.Rectangle) - The second Rectangle object.

  Returns:  boolean - `true` if the objects have equivalent values for the `width` and `height` properties, otherwise `false`."
  ([rectangle rect to-compare]
   (phaser->clj
    (.SameDimensions rectangle
                     (clj->phaser rect)
                     (clj->phaser to-compare)))))

(defn scale
  "Scales the width and height of this Rectangle by the given amounts.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect (Phaser.Geom.Rectangle) - The `Rectangle` object that will be scaled by the specified amount(s).
    * x (number) - The factor by which to scale the rectangle horizontally.
    * y (number) - The amount by which to scale the rectangle vertically. If this is not specified, the rectangle will be scaled by the factor `x` in both directions.

  Returns:  Phaser.Geom.Rectangle - The rectangle object with updated `width` and `height` properties as calculated from the scaling factor(s)."
  ([rectangle rect x y]
   (phaser->clj
    (.Scale rectangle
            (clj->phaser rect)
            (clj->phaser x)
            (clj->phaser y)))))

(defn set-empty
  "Resets the position, width, and height of the Rectangle to 0.

  Returns:  Phaser.Geom.Rectangle - This Rectangle object."
  ([rectangle]
   (phaser->clj
    (.setEmpty rectangle))))

(defn set-position
  "Sets the position of the Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * x (number) - The X coordinate of the top left corner of the Rectangle.
    * y (number) {optional} - The Y coordinate of the top left corner of the Rectangle.

  Returns:  Phaser.Geom.Rectangle - This Rectangle object."
  ([rectangle x]
   (phaser->clj
    (.setPosition rectangle
                  (clj->phaser x))))
  ([rectangle x y]
   (phaser->clj
    (.setPosition rectangle
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-size
  "Sets the width and height of the Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * width (number) - The width to set the Rectangle to.
    * height (number) {optional} - The height to set the Rectangle to.

  Returns:  Phaser.Geom.Rectangle - This Rectangle object."
  ([rectangle width]
   (phaser->clj
    (.setSize rectangle
              (clj->phaser width))))
  ([rectangle width height]
   (phaser->clj
    (.setSize rectangle
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-to
  "Sets the position, width, and height of the Rectangle.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * x (number) - The X coordinate of the top left corner of the Rectangle.
    * y (number) - The Y coordinate of the top left corner of the Rectangle.
    * width (number) - The width of the Rectangle.
    * height (number) - The height of the Rectangle.

  Returns:  Phaser.Geom.Rectangle - This Rectangle object."
  ([rectangle x y width height]
   (phaser->clj
    (.setTo rectangle
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser width)
            (clj->phaser height)))))

(defn union
  "Creates a new Rectangle or repositions and/or resizes an existing Rectangle so that it encompasses the two given Rectangles, i.e. calculates their union.

  Parameters:
    * rectangle (Phaser.Geom.Rectangle) - Targeted instance for method
    * rect-a (Phaser.Geom.Rectangle) - The first Rectangle to use.
    * rect-b (Phaser.Geom.Rectangle) - The second Rectangle to use.
    * out (Phaser.Geom.Rectangle) {optional} - The Rectangle to store the union in.

  Returns:  Phaser.Geom.Rectangle - The modified `out` Rectangle, or a new Rectangle if none was provided."
  ([rectangle rect-a rect-b]
   (phaser->clj
    (.Union rectangle
            (clj->phaser rect-a)
            (clj->phaser rect-b))))
  ([rectangle rect-a rect-b out]
   (phaser->clj
    (.Union rectangle
            (clj->phaser rect-a)
            (clj->phaser rect-b)
            (clj->phaser out)))))