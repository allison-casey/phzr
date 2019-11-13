(ns phzr.curves.line
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Line
  "  Parameters:
    * p-0 (Phaser.Math.Vector2 | Array.<number>) - The first endpoint.
    * p-1 (Phaser.Math.Vector2) {optional} - The second endpoint."
  ([p-0]
   (js/Phaser.Curves.Line. (clj->phaser p-0)))
  ([p-0 p-1]
   (js/Phaser.Curves.Line. (clj->phaser p-0)
                           (clj->phaser p-1))))

(defn draw
  "Draws this curve on the given Graphics object.

  The curve is drawn using `Graphics.lineBetween` so will be drawn at whatever the present Graphics line color is.
  The Graphics object is not cleared before the draw, so the curve will appear on-top of anything else already rendered to it.

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The Graphics instance onto which this curve will be drawn.

  Returns:  Phaser.GameObjects.Graphics - The Graphics object to which the curve was drawn."
  ([line graphics]
   (phaser->clj
    (.draw line
           (clj->phaser graphics)))))

(defn from-json
  "Configures this line from a JSON representation.

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * data (Phaser.Types.Curves.JSONCurve) - The JSON object containing this curve data.

  Returns:  Phaser.Curves.Line - A new LineCurve object."
  ([line data]
   (phaser->clj
    (.fromJSON line
               (clj->phaser data)))))

(defn get-bounds
  "Returns a Rectangle where the position and dimensions match the bounds of this Curve.

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - A Rectangle object to store the bounds in. If not given a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle - A Rectangle object holding the bounds of this curve. If `out` was given it will be this object."
  ([line]
   (phaser->clj
    (.getBounds line)))
  ([line out]
   (phaser->clj
    (.getBounds line
                (clj->phaser out)))))

(defn get-distance-points
  "Returns an array of points, spaced out X distance pixels apart.
  The smaller the distance, the larger the array will be.

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * distance (integer) - The distance, in pixels, between each point along the curve.

  Returns:  Array.<Phaser.Geom.Point> - An Array of Point objects."
  ([line distance]
   (phaser->clj
    (.getDistancePoints line
                        (clj->phaser distance)))))

(defn get-end-point
  "[description]

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - Optional Vector object to store the result in.

  Returns:  Phaser.Math.Vector2 - Vector2 containing the coordinates of the curves end point."
  ([line]
   (phaser->clj
    (.getEndPoint line)))
  ([line out]
   (phaser->clj
    (.getEndPoint line
                  (clj->phaser out)))))

(defn get-length
  "Get total curve arc length

  Returns:  number - [description]"
  ([line]
   (phaser->clj
    (.getLength line))))

(defn get-lengths
  "Get list of cumulative segment lengths

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<number> - [description]"
  ([line]
   (phaser->clj
    (.getLengths line)))
  ([line divisions]
   (phaser->clj
    (.getLengths line
                 (clj->phaser divisions)))))

(defn get-point
  "Get point at relative position in curve according to length.

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * t (number) - The position along the curve to return. Where 0 is the start and 1 is the end.
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([line t]
   (phaser->clj
    (.getPoint line
               (clj->phaser t))))
  ([line t out]
   (phaser->clj
    (.getPoint line
               (clj->phaser t)
               (clj->phaser out)))))

(defn get-point-at
  "Gets a point at a given position on the line.

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * u (number) - The position along the curve to return. Where 0 is the start and 1 is the end.
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([line u]
   (phaser->clj
    (.getPointAt line
                 (clj->phaser u))))
  ([line u out]
   (phaser->clj
    (.getPointAt line
                 (clj->phaser u)
                 (clj->phaser out)))))

(defn get-points
  "[description]

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([line]
   (phaser->clj
    (.getPoints line)))
  ([line divisions]
   (phaser->clj
    (.getPoints line
                (clj->phaser divisions)))))

(defn get-random-point
  "[description]

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([line]
   (phaser->clj
    (.getRandomPoint line)))
  ([line out]
   (phaser->clj
    (.getRandomPoint line
                     (clj->phaser out)))))

(defn get-resolution
  "Gets the resolution of the line.

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * divisions (number) {optional} - The number of divisions to consider.

  Returns:  number - The resolution. Equal to the number of divisions."
  ([line]
   (phaser->clj
    (.getResolution line)))
  ([line divisions]
   (phaser->clj
    (.getResolution line
                    (clj->phaser divisions)))))

(defn get-spaced-points
  "[description]

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([line]
   (phaser->clj
    (.getSpacedPoints line)))
  ([line divisions]
   (phaser->clj
    (.getSpacedPoints line
                      (clj->phaser divisions)))))

(defn get-start-point
  "Gets the starting point on the curve.

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([line]
   (phaser->clj
    (.getStartPoint line)))
  ([line out]
   (phaser->clj
    (.getStartPoint line
                    (clj->phaser out)))))

(defn get-t-from-distance
  "[description]

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([line distance]
   (phaser->clj
    (.getTFromDistance line
                       (clj->phaser distance))))
  ([line distance divisions]
   (phaser->clj
    (.getTFromDistance line
                       (clj->phaser distance)
                       (clj->phaser divisions)))))

(defn get-tangent
  "Gets the slope of the line as a unit vector.

  Returns:  Phaser.Math.Vector2 - The tangent vector."
  ([line]
   (phaser->clj
    (.getTangent line))))

(defn get-tangent-at
  "[description]

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([line u]
   (phaser->clj
    (.getTangentAt line
                   (clj->phaser u))))
  ([line u out]
   (phaser->clj
    (.getTangentAt line
                   (clj->phaser u)
                   (clj->phaser out)))))

(defn get-uto-tmapping
  "[description]

  Parameters:
    * line (Phaser.Curves.Line) - Targeted instance for method
    * u (number) - [description]
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([line u distance]
   (phaser->clj
    (.getUtoTmapping line
                     (clj->phaser u)
                     (clj->phaser distance))))
  ([line u distance divisions]
   (phaser->clj
    (.getUtoTmapping line
                     (clj->phaser u)
                     (clj->phaser distance)
                     (clj->phaser divisions)))))

(defn to-json
  "Gets a JSON representation of the line.

  Returns:  Phaser.Types.Curves.JSONCurve - The JSON object containing this curve data."
  ([line]
   (phaser->clj
    (.toJSON line))))

(defn update-arc-lengths
  "[description]"
  ([line]
   (phaser->clj
    (.updateArcLengths line))))