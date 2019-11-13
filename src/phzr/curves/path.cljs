(ns phzr.curves.path
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Path
  "  Parameters:
    * x (number) {optional} - The X coordinate of the Path's starting point or a {@link Phaser.Types.Curves.JSONPath}.
    * y (number) {optional} - The Y coordinate of the Path's starting point."
  ([]
   (js/Phaser.Curves.Path.))
  ([x]
   (js/Phaser.Curves.Path. (clj->phaser x)))
  ([x y]
   (js/Phaser.Curves.Path. (clj->phaser x)
                           (clj->phaser y))))

(defn add
  "Appends a Curve to the end of the Path.

  The Curve does not have to start where the Path ends or, for an empty Path, at its defined starting point.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * curve (Phaser.Curves.Curve) - The Curve to append.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path curve]
   (phaser->clj
    (.add path
          (clj->phaser curve)))))

(defn circle-to
  "Creates a circular Ellipse Curve positioned at the end of the Path.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * radius (number) - The radius of the circle.
    * clockwise (boolean) {optional} - `true` to create a clockwise circle as opposed to a counter-clockwise circle.
    * rotation (number) {optional} - The rotation of the circle in degrees.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path radius]
   (phaser->clj
    (.circleTo path
               (clj->phaser radius))))
  ([path radius clockwise]
   (phaser->clj
    (.circleTo path
               (clj->phaser radius)
               (clj->phaser clockwise))))
  ([path radius clockwise rotation]
   (phaser->clj
    (.circleTo path
               (clj->phaser radius)
               (clj->phaser clockwise)
               (clj->phaser rotation)))))

(defn close-path
  "Ensures that the Path is closed.

  A closed Path starts and ends at the same point. If the Path is not closed, a straight Line Curve will be created from the ending point directly to the starting point. During the check, the actual starting point of the Path, i.e. the starting point of the first Curve, will be used as opposed to the Path's defined {@link startPoint}, which could differ.

  Calling this method on an empty Path will result in an error.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path]
   (phaser->clj
    (.closePath path))))

(defn cubic-bezier-to
  "Creates a cubic bezier curve starting at the previous end point and ending at p3, using p1 and p2 as control points.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * x (number | Phaser.Math.Vector2) - The x coordinate of the end point. Or, if a Vec2, the p1 value.
    * y (number | Phaser.Math.Vector2) - The y coordinate of the end point. Or, if a Vec2, the p2 value.
    * control-1-x (number | Phaser.Math.Vector2) - The x coordinate of the first control point. Or, if a Vec2, the p3 value.
    * control-1-y (number) {optional} - The y coordinate of the first control point. Not used if vec2s are provided as the first 3 arguments.
    * control-2-x (number) {optional} - The x coordinate of the second control point. Not used if vec2s are provided as the first 3 arguments.
    * control-2-y (number) {optional} - The y coordinate of the second control point. Not used if vec2s are provided as the first 3 arguments.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path x y control-1-x]
   (phaser->clj
    (.cubicBezierTo path
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser control-1-x))))
  ([path x y control-1-x control-1-y]
   (phaser->clj
    (.cubicBezierTo path
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser control-1-x)
                    (clj->phaser control-1-y))))
  ([path x y control-1-x control-1-y control-2-x]
   (phaser->clj
    (.cubicBezierTo path
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser control-1-x)
                    (clj->phaser control-1-y)
                    (clj->phaser control-2-x))))
  ([path x y control-1-x control-1-y control-2-x control-2-y]
   (phaser->clj
    (.cubicBezierTo path
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser control-1-x)
                    (clj->phaser control-1-y)
                    (clj->phaser control-2-x)
                    (clj->phaser control-2-y)))))

(defn destroy
  "Disposes of this Path, clearing its internal references to objects so they can be garbage-collected."
  ([path]
   (phaser->clj
    (.destroy path))))

(defn draw
  "Draws all Curves in the Path to a Graphics Game Object.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The Graphics Game Object to draw to.
    * points-total (integer) {optional} - The number of points to draw for each Curve. Higher numbers result in a smoother curve but require more processing.

  Returns:  Phaser.GameObjects.Graphics - The Graphics object which was drawn to."
  ([path graphics]
   (phaser->clj
    (.draw path
           (clj->phaser graphics))))
  ([path graphics points-total]
   (phaser->clj
    (.draw path
           (clj->phaser graphics)
           (clj->phaser points-total)))))

(defn ellipse-to
  "Creates an ellipse curve positioned at the previous end point, using the given parameters.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * x-radius (number) {optional} - The horizontal radius of ellipse.
    * y-radius (number) {optional} - The vertical radius of ellipse.
    * start-angle (integer) {optional} - The start angle of the ellipse, in degrees.
    * end-angle (integer) {optional} - The end angle of the ellipse, in degrees.
    * clockwise (boolean) {optional} - Whether the ellipse angles are given as clockwise (`true`) or counter-clockwise (`false`).
    * rotation (number) {optional} - The rotation of the ellipse, in degrees.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path]
   (phaser->clj
    (.ellipseTo path)))
  ([path x-radius]
   (phaser->clj
    (.ellipseTo path
                (clj->phaser x-radius))))
  ([path x-radius y-radius]
   (phaser->clj
    (.ellipseTo path
                (clj->phaser x-radius)
                (clj->phaser y-radius))))
  ([path x-radius y-radius start-angle]
   (phaser->clj
    (.ellipseTo path
                (clj->phaser x-radius)
                (clj->phaser y-radius)
                (clj->phaser start-angle))))
  ([path x-radius y-radius start-angle end-angle]
   (phaser->clj
    (.ellipseTo path
                (clj->phaser x-radius)
                (clj->phaser y-radius)
                (clj->phaser start-angle)
                (clj->phaser end-angle))))
  ([path x-radius y-radius start-angle end-angle clockwise]
   (phaser->clj
    (.ellipseTo path
                (clj->phaser x-radius)
                (clj->phaser y-radius)
                (clj->phaser start-angle)
                (clj->phaser end-angle)
                (clj->phaser clockwise))))
  ([path x-radius y-radius start-angle end-angle clockwise rotation]
   (phaser->clj
    (.ellipseTo path
                (clj->phaser x-radius)
                (clj->phaser y-radius)
                (clj->phaser start-angle)
                (clj->phaser end-angle)
                (clj->phaser clockwise)
                (clj->phaser rotation)))))

(defn from-json
  "Creates a Path from a Path Configuration object.

  The provided object should be a {@link Phaser.Types.Curves.JSONPath}, as returned by {@link #toJSON}. Providing a malformed object may cause errors.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * data (Phaser.Types.Curves.JSONPath) - The JSON object containing the Path data.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path data]
   (phaser->clj
    (.fromJSON path
               (clj->phaser data)))))

(defn get-bounds
  "Returns a Rectangle with a position and size matching the bounds of this Path.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - The Rectangle to store the bounds in.
    * accuracy (integer) {optional} - The accuracy of the bounds calculations. Higher values are more accurate at the cost of calculation speed.

  Returns:  Phaser.Geom.Rectangle - The modified `out` Rectangle, or a new Rectangle if none was provided."
  ([path]
   (phaser->clj
    (.getBounds path)))
  ([path out]
   (phaser->clj
    (.getBounds path
                (clj->phaser out))))
  ([path out accuracy]
   (phaser->clj
    (.getBounds path
                (clj->phaser out)
                (clj->phaser accuracy)))))

(defn get-curve-lengths
  "Returns an array containing the length of the Path at the end of each Curve.

  The result of this method will be cached to avoid recalculating it in subsequent calls. The cache is only invalidated when the {@link #curves} array changes in length, leading to potential inaccuracies if a Curve in the Path is changed, or if a Curve is removed and another is added in its place.

  Returns:  Array.<number> - An array containing the length of the Path at the end of each one of its Curves."
  ([path]
   (phaser->clj
    (.getCurveLengths path))))

(defn get-end-point
  "Returns the ending point of the Path.

  A Path's ending point is equivalent to the ending point of the last Curve in the Path. For an empty Path, the ending point is at the Path's defined {@link #startPoint}.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - The object to store the point in.

  Returns:  Phaser.Math.Vector2 - The modified `out` object, or a new Vector2 if none was provided."
  ([path]
   (phaser->clj
    (.getEndPoint path)))
  ([path out]
   (phaser->clj
    (.getEndPoint path
                  (clj->phaser out)))))

(defn get-length
  "Returns the total length of the Path.

  Returns:  number - The total length of the Path."
  ([path]
   (phaser->clj
    (.getLength path))))

(defn get-point
  "Calculates the coordinates of the point at the given normalized location (between 0 and 1) on the Path.

  The location is relative to the entire Path, not to an individual Curve. A location of 0.5 is always in the middle of the Path and is thus an equal distance away from both its starting and ending points. In a Path with one Curve, it would be in the middle of the Curve; in a Path with two Curves, it could be anywhere on either one of them depending on their lengths.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * t (number) - The location of the point to return, between 0 and 1.
    * out (Phaser.Math.Vector2) {optional} - The object in which to store the calculated point.

  Returns:  Phaser.Math.Vector2 - The modified `out` object, or a new `Vector2` if none was provided."
  ([path t]
   (phaser->clj
    (.getPoint path
               (clj->phaser t))))
  ([path t out]
   (phaser->clj
    (.getPoint path
               (clj->phaser t)
               (clj->phaser out)))))

(defn get-points
  "Returns the defined starting point of the Path.

  This is not necessarily equal to the starting point of the first Curve if it differs from {@link startPoint}.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * divisions (integer) {optional} - The number of points to divide the path in to.

  Returns:  Array.<Phaser.Math.Vector2> - An array of Vector2 objects that containing the points along the Path."
  ([path]
   (phaser->clj
    (.getPoints path)))
  ([path divisions]
   (phaser->clj
    (.getPoints path
                (clj->phaser divisions)))))

(defn get-random-point
  "Returns a randomly chosen point anywhere on the path. This follows the same rules as `getPoint` in that it may return a point on any Curve inside this path.

  When calling this method multiple times, the points are not guaranteed to be equally spaced spatially.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - `Vector2` instance that should be used for storing the result. If `undefined` a new `Vector2` will be created.

  Returns:  Phaser.Math.Vector2 - The modified `out` object, or a new `Vector2` if none was provided."
  ([path]
   (phaser->clj
    (.getRandomPoint path)))
  ([path out]
   (phaser->clj
    (.getRandomPoint path
                     (clj->phaser out)))))

(defn get-spaced-points
  "Divides this Path into a set of equally spaced points,

  The resulting points are equally spaced with respect to the points' position on the path, but not necessarily equally spaced spatially.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * divisions (integer) {optional} - The amount of points to divide this Path into.

  Returns:  Array.<Phaser.Math.Vector2> - A list of the points this path was subdivided into."
  ([path]
   (phaser->clj
    (.getSpacedPoints path)))
  ([path divisions]
   (phaser->clj
    (.getSpacedPoints path
                      (clj->phaser divisions)))))

(defn get-start-point
  "Returns the starting point of the Path.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - `Vector2` instance that should be used for storing the result. If `undefined` a new `Vector2` will be created.

  Returns:  Phaser.Math.Vector2 - The modified `out` object, or a new Vector2 if none was provided."
  ([path]
   (phaser->clj
    (.getStartPoint path)))
  ([path out]
   (phaser->clj
    (.getStartPoint path
                    (clj->phaser out)))))

(defn line-to
  "Creates a line curve from the previous end point to x/y.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * x (number | Phaser.Math.Vector2) - The X coordinate of the line's end point, or a `Vector2` containing the entire end point.
    * y (number) {optional} - The Y coordinate of the line's end point, if a number was passed as the X parameter.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path x]
   (phaser->clj
    (.lineTo path
             (clj->phaser x))))
  ([path x y]
   (phaser->clj
    (.lineTo path
             (clj->phaser x)
             (clj->phaser y)))))

(defn move-to
  "Creates a 'gap' in this path from the path's current end point to the given coordinates.

  After calling this function, this Path's end point will be equal to the given coordinates

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * x (number | Phaser.Math.Vector2) - The X coordinate of the position to move the path's end point to, or a `Vector2` containing the entire new end point.
    * y (number) - The Y coordinate of the position to move the path's end point to, if a number was passed as the X coordinate.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path x y]
   (phaser->clj
    (.moveTo path
             (clj->phaser x)
             (clj->phaser y)))))

(defn quadratic-bezier-to
  "Creates a Quadratic Bezier Curve starting at the ending point of the Path.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * x (number | Array.<Phaser.Math.Vector2>) - The X coordinate of the second control point or, if it's a `Vector2`, the first control point.
    * y (number) {optional} - The Y coordinate of the second control point or, if `x` is a `Vector2`, the second control point.
    * control-x (number) {optional} - If `x` is not a `Vector2`, the X coordinate of the first control point.
    * control-y (number) {optional} - If `x` is not a `Vector2`, the Y coordinate of the first control point.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path x]
   (phaser->clj
    (.quadraticBezierTo path
                        (clj->phaser x))))
  ([path x y]
   (phaser->clj
    (.quadraticBezierTo path
                        (clj->phaser x)
                        (clj->phaser y))))
  ([path x y control-x]
   (phaser->clj
    (.quadraticBezierTo path
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser control-x))))
  ([path x y control-x control-y]
   (phaser->clj
    (.quadraticBezierTo path
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser control-x)
                        (clj->phaser control-y)))))

(defn spline-to
  "Creates a spline curve starting at the previous end point, using the given points on the curve.

  Parameters:
    * path (Phaser.Curves.Path) - Targeted instance for method
    * points (Array.<Phaser.Math.Vector2>) - The points the newly created spline curve should consist of.

  Returns:  Phaser.Curves.Path - This Path object."
  ([path points]
   (phaser->clj
    (.splineTo path
               (clj->phaser points)))))

(defn to-json
  "Converts this Path to a JSON object containing the path information and its consitutent curves.

  Returns:  Phaser.Types.Curves.JSONPath - The JSON object containing this path's data."
  ([path]
   (phaser->clj
    (.toJSON path))))

(defn update-arc-lengths
  "cacheLengths must be recalculated."
  ([path]
   (phaser->clj
    (.updateArcLengths path))))