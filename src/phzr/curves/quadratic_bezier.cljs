(ns phzr.curves.quadratic-bezier
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->QuadraticBezier
  "  Parameters:
    * p-0 (Phaser.Math.Vector2 | Array.<number>) - Start point, or an array of point pairs.
    * p-1 (Phaser.Math.Vector2) - Control Point 1.
    * p2 (Phaser.Math.Vector2) - Control Point 2."
  ([p-0 p-1 p2]
   (js/Phaser.Curves.QuadraticBezier. (clj->phaser p-0)
                                      (clj->phaser p-1)
                                      (clj->phaser p2))))

(defn draw
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - `Graphics` object to draw onto.
    * points-total (integer) {optional} - Number of points to be used for drawing the curve. Higher numbers result in smoother curve but require more processing.

  Returns:  Phaser.GameObjects.Graphics - `Graphics` object that was drawn to."
  ([quadratic-bezier graphics]
   (phaser->clj
    (.draw quadratic-bezier
           (clj->phaser graphics))))
  ([quadratic-bezier graphics points-total]
   (phaser->clj
    (.draw quadratic-bezier
           (clj->phaser graphics)
           (clj->phaser points-total)))))

(defn from-json
  "Creates a curve from a JSON object, e. g. created by `toJSON`.

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * data (Phaser.Types.Curves.JSONCurve) - The JSON object containing this curve data.

  Returns:  Phaser.Curves.QuadraticBezier - The created curve instance."
  ([quadratic-bezier data]
   (phaser->clj
    (.fromJSON quadratic-bezier
               (clj->phaser data)))))

(defn get-bounds
  "Returns a Rectangle where the position and dimensions match the bounds of this Curve.

  You can control the accuracy of the bounds. The value given is used to work out how many points
  to plot across the curve. Higher values are more accurate at the cost of calculation speed.

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - The Rectangle to store the bounds in. If falsey a new object will be created.
    * accuracy (integer) {optional} - The accuracy of the bounds calculations.

  Returns:  Phaser.Geom.Rectangle - A Rectangle object holding the bounds of this curve. If `out` was given it will be this object."
  ([quadratic-bezier]
   (phaser->clj
    (.getBounds quadratic-bezier)))
  ([quadratic-bezier out]
   (phaser->clj
    (.getBounds quadratic-bezier
                (clj->phaser out))))
  ([quadratic-bezier out accuracy]
   (phaser->clj
    (.getBounds quadratic-bezier
                (clj->phaser out)
                (clj->phaser accuracy)))))

(defn get-distance-points
  "Returns an array of points, spaced out X distance pixels apart.
  The smaller the distance, the larger the array will be.

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * distance (integer) - The distance, in pixels, between each point along the curve.

  Returns:  Array.<Phaser.Geom.Point> - An Array of Point objects."
  ([quadratic-bezier distance]
   (phaser->clj
    (.getDistancePoints quadratic-bezier
                        (clj->phaser distance)))))

(defn get-end-point
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - Optional Vector object to store the result in.

  Returns:  Phaser.Math.Vector2 - Vector2 containing the coordinates of the curves end point."
  ([quadratic-bezier]
   (phaser->clj
    (.getEndPoint quadratic-bezier)))
  ([quadratic-bezier out]
   (phaser->clj
    (.getEndPoint quadratic-bezier
                  (clj->phaser out)))))

(defn get-length
  "Get total curve arc length

  Returns:  number - [description]"
  ([quadratic-bezier]
   (phaser->clj
    (.getLength quadratic-bezier))))

(defn get-lengths
  "Get list of cumulative segment lengths

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<number> - [description]"
  ([quadratic-bezier]
   (phaser->clj
    (.getLengths quadratic-bezier)))
  ([quadratic-bezier divisions]
   (phaser->clj
    (.getLengths quadratic-bezier
                 (clj->phaser divisions)))))

(defn get-point
  "Get point at relative position in curve according to length.

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * t (number) - The position along the curve to return. Where 0 is the start and 1 is the end.
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([quadratic-bezier t]
   (phaser->clj
    (.getPoint quadratic-bezier
               (clj->phaser t))))
  ([quadratic-bezier t out]
   (phaser->clj
    (.getPoint quadratic-bezier
               (clj->phaser t)
               (clj->phaser out)))))

(defn get-point-at
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([quadratic-bezier u]
   (phaser->clj
    (.getPointAt quadratic-bezier
                 (clj->phaser u))))
  ([quadratic-bezier u out]
   (phaser->clj
    (.getPointAt quadratic-bezier
                 (clj->phaser u)
                 (clj->phaser out)))))

(defn get-points
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([quadratic-bezier]
   (phaser->clj
    (.getPoints quadratic-bezier)))
  ([quadratic-bezier divisions]
   (phaser->clj
    (.getPoints quadratic-bezier
                (clj->phaser divisions)))))

(defn get-random-point
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([quadratic-bezier]
   (phaser->clj
    (.getRandomPoint quadratic-bezier)))
  ([quadratic-bezier out]
   (phaser->clj
    (.getRandomPoint quadratic-bezier
                     (clj->phaser out)))))

(defn get-resolution
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * divisions (number) - [description]

  Returns:  number - [description]"
  ([quadratic-bezier divisions]
   (phaser->clj
    (.getResolution quadratic-bezier
                    (clj->phaser divisions)))))

(defn get-spaced-points
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([quadratic-bezier]
   (phaser->clj
    (.getSpacedPoints quadratic-bezier)))
  ([quadratic-bezier divisions]
   (phaser->clj
    (.getSpacedPoints quadratic-bezier
                      (clj->phaser divisions)))))

(defn get-start-point
  "Gets the starting point on the curve.

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([quadratic-bezier]
   (phaser->clj
    (.getStartPoint quadratic-bezier)))
  ([quadratic-bezier out]
   (phaser->clj
    (.getStartPoint quadratic-bezier
                    (clj->phaser out)))))

(defn get-t-from-distance
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([quadratic-bezier distance]
   (phaser->clj
    (.getTFromDistance quadratic-bezier
                       (clj->phaser distance))))
  ([quadratic-bezier distance divisions]
   (phaser->clj
    (.getTFromDistance quadratic-bezier
                       (clj->phaser distance)
                       (clj->phaser divisions)))))

(defn get-tangent
  "Returns a unit vector tangent at t
  In case any sub curve does not implement its tangent derivation,
  2 points a small delta apart will be used to find its gradient
  which seems to give a reasonable approximation

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * t (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - Vector approximating the tangent line at the point t (delta +/- 0.0001)"
  ([quadratic-bezier t]
   (phaser->clj
    (.getTangent quadratic-bezier
                 (clj->phaser t))))
  ([quadratic-bezier t out]
   (phaser->clj
    (.getTangent quadratic-bezier
                 (clj->phaser t)
                 (clj->phaser out)))))

(defn get-tangent-at
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([quadratic-bezier u]
   (phaser->clj
    (.getTangentAt quadratic-bezier
                   (clj->phaser u))))
  ([quadratic-bezier u out]
   (phaser->clj
    (.getTangentAt quadratic-bezier
                   (clj->phaser u)
                   (clj->phaser out)))))

(defn get-uto-tmapping
  "[description]

  Parameters:
    * quadratic-bezier (Phaser.Curves.QuadraticBezier) - Targeted instance for method
    * u (number) - [description]
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([quadratic-bezier u distance]
   (phaser->clj
    (.getUtoTmapping quadratic-bezier
                     (clj->phaser u)
                     (clj->phaser distance))))
  ([quadratic-bezier u distance divisions]
   (phaser->clj
    (.getUtoTmapping quadratic-bezier
                     (clj->phaser u)
                     (clj->phaser distance)
                     (clj->phaser divisions)))))

(defn to-json
  "Converts the curve into a JSON compatible object.

  Returns:  Phaser.Types.Curves.JSONCurve - The JSON object containing this curve data."
  ([quadratic-bezier]
   (phaser->clj
    (.toJSON quadratic-bezier))))

(defn update-arc-lengths
  "[description]"
  ([quadratic-bezier]
   (phaser->clj
    (.updateArcLengths quadratic-bezier))))