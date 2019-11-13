(ns phzr.curves.cubic-bezier
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->CubicBezier
  "  Parameters:
    * p-0 (Phaser.Math.Vector2 | Array.<Phaser.Math.Vector2>) - Start point, or an array of point pairs.
    * p-1 (Phaser.Math.Vector2) - Control Point 1.
    * p2 (Phaser.Math.Vector2) - Control Point 2.
    * p-3 (Phaser.Math.Vector2) - End Point."
  ([p-0 p-1 p2 p-3]
   (js/Phaser.Curves.CubicBezier. (clj->phaser p-0)
                                  (clj->phaser p-1)
                                  (clj->phaser p2)
                                  (clj->phaser p-3))))

(defn draw
  "Draws this curve to the specified graphics object.

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The graphics object this curve should be drawn to.
    * points-total (integer) {optional} - The number of intermediary points that make up this curve. A higher number of points will result in a smoother curve.

  Returns:  Phaser.GameObjects.Graphics - The graphics object this curve was drawn to. Useful for method chaining."
  ([cubic-bezier graphics]
   (phaser->clj
    (.draw cubic-bezier
           (clj->phaser graphics))))
  ([cubic-bezier graphics points-total]
   (phaser->clj
    (.draw cubic-bezier
           (clj->phaser graphics)
           (clj->phaser points-total)))))

(defn from-json
  "Generates a curve from a JSON object.

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * data (Phaser.Types.Curves.JSONCurve) - The JSON object containing this curve data.

  Returns:  Phaser.Curves.CubicBezier - The curve generated from the JSON object."
  ([cubic-bezier data]
   (phaser->clj
    (.fromJSON cubic-bezier
               (clj->phaser data)))))

(defn get-bounds
  "Returns a Rectangle where the position and dimensions match the bounds of this Curve.

  You can control the accuracy of the bounds. The value given is used to work out how many points
  to plot across the curve. Higher values are more accurate at the cost of calculation speed.

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - The Rectangle to store the bounds in. If falsey a new object will be created.
    * accuracy (integer) {optional} - The accuracy of the bounds calculations.

  Returns:  Phaser.Geom.Rectangle - A Rectangle object holding the bounds of this curve. If `out` was given it will be this object."
  ([cubic-bezier]
   (phaser->clj
    (.getBounds cubic-bezier)))
  ([cubic-bezier out]
   (phaser->clj
    (.getBounds cubic-bezier
                (clj->phaser out))))
  ([cubic-bezier out accuracy]
   (phaser->clj
    (.getBounds cubic-bezier
                (clj->phaser out)
                (clj->phaser accuracy)))))

(defn get-distance-points
  "Returns an array of points, spaced out X distance pixels apart.
  The smaller the distance, the larger the array will be.

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * distance (integer) - The distance, in pixels, between each point along the curve.

  Returns:  Array.<Phaser.Geom.Point> - An Array of Point objects."
  ([cubic-bezier distance]
   (phaser->clj
    (.getDistancePoints cubic-bezier
                        (clj->phaser distance)))))

(defn get-end-point
  "[description]

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - Optional Vector object to store the result in.

  Returns:  Phaser.Math.Vector2 - Vector2 containing the coordinates of the curves end point."
  ([cubic-bezier]
   (phaser->clj
    (.getEndPoint cubic-bezier)))
  ([cubic-bezier out]
   (phaser->clj
    (.getEndPoint cubic-bezier
                  (clj->phaser out)))))

(defn get-length
  "Get total curve arc length

  Returns:  number - [description]"
  ([cubic-bezier]
   (phaser->clj
    (.getLength cubic-bezier))))

(defn get-lengths
  "Get list of cumulative segment lengths

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<number> - [description]"
  ([cubic-bezier]
   (phaser->clj
    (.getLengths cubic-bezier)))
  ([cubic-bezier divisions]
   (phaser->clj
    (.getLengths cubic-bezier
                 (clj->phaser divisions)))))

(defn get-point
  "Get point at relative position in curve according to length.

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * t (number) - The position along the curve to return. Where 0 is the start and 1 is the end.
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([cubic-bezier t]
   (phaser->clj
    (.getPoint cubic-bezier
               (clj->phaser t))))
  ([cubic-bezier t out]
   (phaser->clj
    (.getPoint cubic-bezier
               (clj->phaser t)
               (clj->phaser out)))))

(defn get-point-at
  "[description]

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([cubic-bezier u]
   (phaser->clj
    (.getPointAt cubic-bezier
                 (clj->phaser u))))
  ([cubic-bezier u out]
   (phaser->clj
    (.getPointAt cubic-bezier
                 (clj->phaser u)
                 (clj->phaser out)))))

(defn get-points
  "[description]

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([cubic-bezier]
   (phaser->clj
    (.getPoints cubic-bezier)))
  ([cubic-bezier divisions]
   (phaser->clj
    (.getPoints cubic-bezier
                (clj->phaser divisions)))))

(defn get-random-point
  "[description]

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([cubic-bezier]
   (phaser->clj
    (.getRandomPoint cubic-bezier)))
  ([cubic-bezier out]
   (phaser->clj
    (.getRandomPoint cubic-bezier
                     (clj->phaser out)))))

(defn get-resolution
  "Returns the resolution of this curve.

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * divisions (number) - The amount of divisions used by this curve.

  Returns:  number - The resolution of the curve."
  ([cubic-bezier divisions]
   (phaser->clj
    (.getResolution cubic-bezier
                    (clj->phaser divisions)))))

(defn get-spaced-points
  "[description]

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([cubic-bezier]
   (phaser->clj
    (.getSpacedPoints cubic-bezier)))
  ([cubic-bezier divisions]
   (phaser->clj
    (.getSpacedPoints cubic-bezier
                      (clj->phaser divisions)))))

(defn get-start-point
  "Gets the starting point on the curve.

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([cubic-bezier]
   (phaser->clj
    (.getStartPoint cubic-bezier)))
  ([cubic-bezier out]
   (phaser->clj
    (.getStartPoint cubic-bezier
                    (clj->phaser out)))))

(defn get-t-from-distance
  "[description]

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([cubic-bezier distance]
   (phaser->clj
    (.getTFromDistance cubic-bezier
                       (clj->phaser distance))))
  ([cubic-bezier distance divisions]
   (phaser->clj
    (.getTFromDistance cubic-bezier
                       (clj->phaser distance)
                       (clj->phaser divisions)))))

(defn get-tangent
  "Returns a unit vector tangent at t
  In case any sub curve does not implement its tangent derivation,
  2 points a small delta apart will be used to find its gradient
  which seems to give a reasonable approximation

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * t (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - Vector approximating the tangent line at the point t (delta +/- 0.0001)"
  ([cubic-bezier t]
   (phaser->clj
    (.getTangent cubic-bezier
                 (clj->phaser t))))
  ([cubic-bezier t out]
   (phaser->clj
    (.getTangent cubic-bezier
                 (clj->phaser t)
                 (clj->phaser out)))))

(defn get-tangent-at
  "[description]

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([cubic-bezier u]
   (phaser->clj
    (.getTangentAt cubic-bezier
                   (clj->phaser u))))
  ([cubic-bezier u out]
   (phaser->clj
    (.getTangentAt cubic-bezier
                   (clj->phaser u)
                   (clj->phaser out)))))

(defn get-uto-tmapping
  "[description]

  Parameters:
    * cubic-bezier (Phaser.Curves.CubicBezier) - Targeted instance for method
    * u (number) - [description]
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([cubic-bezier u distance]
   (phaser->clj
    (.getUtoTmapping cubic-bezier
                     (clj->phaser u)
                     (clj->phaser distance))))
  ([cubic-bezier u distance divisions]
   (phaser->clj
    (.getUtoTmapping cubic-bezier
                     (clj->phaser u)
                     (clj->phaser distance)
                     (clj->phaser divisions)))))

(defn to-json
  "Returns a JSON object that describes this curve.

  Returns:  Phaser.Types.Curves.JSONCurve - The JSON object containing this curve data."
  ([cubic-bezier]
   (phaser->clj
    (.toJSON cubic-bezier))))

(defn update-arc-lengths
  "[description]"
  ([cubic-bezier]
   (phaser->clj
    (.updateArcLengths cubic-bezier))))