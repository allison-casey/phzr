(ns phzr.curves.spline
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Spline
  "  Parameters:
    * points (Array.<Phaser.Math.Vector2>) {optional} - [description]"
  ([]
   (js/Phaser.Curves.Spline.))
  ([points]
   (js/Phaser.Curves.Spline. (clj->phaser points))))

(defn add-point
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([spline x y]
   (phaser->clj
    (.addPoint spline
               (clj->phaser x)
               (clj->phaser y)))))

(defn add-points
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * points (Array.<Phaser.Math.Vector2> | Array.<number> | Array.<Array.<number>>) - [description]

  Returns:  Phaser.Curves.Spline - This curve object."
  ([spline points]
   (phaser->clj
    (.addPoints spline
                (clj->phaser points)))))

(defn draw
  "Draws this curve on the given Graphics object.

  The curve is drawn using `Graphics.strokePoints` so will be drawn at whatever the present Graphics stroke color is.
  The Graphics object is not cleared before the draw, so the curve will appear on-top of anything else already rendered to it.

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The Graphics instance onto which this curve will be drawn.
    * points-total (integer) {optional} - The resolution of the curve. The higher the value the smoother it will render, at the cost of rendering performance.

  Returns:  Phaser.GameObjects.Graphics - The Graphics object to which the curve was drawn."
  ([spline graphics]
   (phaser->clj
    (.draw spline
           (clj->phaser graphics))))
  ([spline graphics points-total]
   (phaser->clj
    (.draw spline
           (clj->phaser graphics)
           (clj->phaser points-total)))))

(defn from-json
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * data (Phaser.Types.Curves.JSONCurve) - The JSON object containing this curve data.

  Returns:  Phaser.Curves.Spline - [description]"
  ([spline data]
   (phaser->clj
    (.fromJSON spline
               (clj->phaser data)))))

(defn get-bounds
  "Returns a Rectangle where the position and dimensions match the bounds of this Curve.

  You can control the accuracy of the bounds. The value given is used to work out how many points
  to plot across the curve. Higher values are more accurate at the cost of calculation speed.

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - The Rectangle to store the bounds in. If falsey a new object will be created.
    * accuracy (integer) {optional} - The accuracy of the bounds calculations.

  Returns:  Phaser.Geom.Rectangle - A Rectangle object holding the bounds of this curve. If `out` was given it will be this object."
  ([spline]
   (phaser->clj
    (.getBounds spline)))
  ([spline out]
   (phaser->clj
    (.getBounds spline
                (clj->phaser out))))
  ([spline out accuracy]
   (phaser->clj
    (.getBounds spline
                (clj->phaser out)
                (clj->phaser accuracy)))))

(defn get-distance-points
  "Returns an array of points, spaced out X distance pixels apart.
  The smaller the distance, the larger the array will be.

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * distance (integer) - The distance, in pixels, between each point along the curve.

  Returns:  Array.<Phaser.Geom.Point> - An Array of Point objects."
  ([spline distance]
   (phaser->clj
    (.getDistancePoints spline
                        (clj->phaser distance)))))

(defn get-end-point
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - Optional Vector object to store the result in.

  Returns:  Phaser.Math.Vector2 - Vector2 containing the coordinates of the curves end point."
  ([spline]
   (phaser->clj
    (.getEndPoint spline)))
  ([spline out]
   (phaser->clj
    (.getEndPoint spline
                  (clj->phaser out)))))

(defn get-length
  "Get total curve arc length

  Returns:  number - [description]"
  ([spline]
   (phaser->clj
    (.getLength spline))))

(defn get-lengths
  "Get list of cumulative segment lengths

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<number> - [description]"
  ([spline]
   (phaser->clj
    (.getLengths spline)))
  ([spline divisions]
   (phaser->clj
    (.getLengths spline
                 (clj->phaser divisions)))))

(defn get-point
  "Get point at relative position in curve according to length.

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * t (number) - The position along the curve to return. Where 0 is the start and 1 is the end.
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([spline t]
   (phaser->clj
    (.getPoint spline
               (clj->phaser t))))
  ([spline t out]
   (phaser->clj
    (.getPoint spline
               (clj->phaser t)
               (clj->phaser out)))))

(defn get-point-at
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([spline u]
   (phaser->clj
    (.getPointAt spline
                 (clj->phaser u))))
  ([spline u out]
   (phaser->clj
    (.getPointAt spline
                 (clj->phaser u)
                 (clj->phaser out)))))

(defn get-points
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([spline]
   (phaser->clj
    (.getPoints spline)))
  ([spline divisions]
   (phaser->clj
    (.getPoints spline
                (clj->phaser divisions)))))

(defn get-random-point
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([spline]
   (phaser->clj
    (.getRandomPoint spline)))
  ([spline out]
   (phaser->clj
    (.getRandomPoint spline
                     (clj->phaser out)))))

(defn get-resolution
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * divisions (number) - [description]

  Returns:  number - [description]"
  ([spline divisions]
   (phaser->clj
    (.getResolution spline
                    (clj->phaser divisions)))))

(defn get-spaced-points
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([spline]
   (phaser->clj
    (.getSpacedPoints spline)))
  ([spline divisions]
   (phaser->clj
    (.getSpacedPoints spline
                      (clj->phaser divisions)))))

(defn get-start-point
  "Gets the starting point on the curve.

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([spline]
   (phaser->clj
    (.getStartPoint spline)))
  ([spline out]
   (phaser->clj
    (.getStartPoint spline
                    (clj->phaser out)))))

(defn get-t-from-distance
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([spline distance]
   (phaser->clj
    (.getTFromDistance spline
                       (clj->phaser distance))))
  ([spline distance divisions]
   (phaser->clj
    (.getTFromDistance spline
                       (clj->phaser distance)
                       (clj->phaser divisions)))))

(defn get-tangent
  "Returns a unit vector tangent at t
  In case any sub curve does not implement its tangent derivation,
  2 points a small delta apart will be used to find its gradient
  which seems to give a reasonable approximation

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * t (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - Vector approximating the tangent line at the point t (delta +/- 0.0001)"
  ([spline t]
   (phaser->clj
    (.getTangent spline
                 (clj->phaser t))))
  ([spline t out]
   (phaser->clj
    (.getTangent spline
                 (clj->phaser t)
                 (clj->phaser out)))))

(defn get-tangent-at
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([spline u]
   (phaser->clj
    (.getTangentAt spline
                   (clj->phaser u))))
  ([spline u out]
   (phaser->clj
    (.getTangentAt spline
                   (clj->phaser u)
                   (clj->phaser out)))))

(defn get-uto-tmapping
  "[description]

  Parameters:
    * spline (Phaser.Curves.Spline) - Targeted instance for method
    * u (number) - [description]
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([spline u distance]
   (phaser->clj
    (.getUtoTmapping spline
                     (clj->phaser u)
                     (clj->phaser distance))))
  ([spline u distance divisions]
   (phaser->clj
    (.getUtoTmapping spline
                     (clj->phaser u)
                     (clj->phaser distance)
                     (clj->phaser divisions)))))

(defn to-json
  "[description]

  Returns:  Phaser.Types.Curves.JSONCurve - The JSON object containing this curve data."
  ([spline]
   (phaser->clj
    (.toJSON spline))))

(defn update-arc-lengths
  "[description]"
  ([spline]
   (phaser->clj
    (.updateArcLengths spline))))