(ns phzr.curves.ellipse
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Ellipse
  "  Parameters:
    * x (number | Phaser.Types.Curves.EllipseCurveConfig) {optional} - The x coordinate of the ellipse, or an Ellipse Curve configuration object.
    * y (number) {optional} - The y coordinate of the ellipse.
    * x-radius (number) {optional} - The horizontal radius of ellipse.
    * y-radius (number) {optional} - The vertical radius of ellipse.
    * start-angle (integer) {optional} - The start angle of the ellipse, in degrees.
    * end-angle (integer) {optional} - The end angle of the ellipse, in degrees.
    * clockwise (boolean) {optional} - Whether the ellipse angles are given as clockwise (`true`) or counter-clockwise (`false`).
    * rotation (integer) {optional} - The rotation of the ellipse, in degrees."
  ([]
   (js/Phaser.Curves.Ellipse.))
  ([x]
   (js/Phaser.Curves.Ellipse. (clj->phaser x)))
  ([x y]
   (js/Phaser.Curves.Ellipse. (clj->phaser x)
                              (clj->phaser y)))
  ([x y x-radius]
   (js/Phaser.Curves.Ellipse. (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser x-radius)))
  ([x y x-radius y-radius]
   (js/Phaser.Curves.Ellipse. (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser x-radius)
                              (clj->phaser y-radius)))
  ([x y x-radius y-radius start-angle]
   (js/Phaser.Curves.Ellipse. (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser x-radius)
                              (clj->phaser y-radius)
                              (clj->phaser start-angle)))
  ([x y x-radius y-radius start-angle end-angle]
   (js/Phaser.Curves.Ellipse. (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser x-radius)
                              (clj->phaser y-radius)
                              (clj->phaser start-angle)
                              (clj->phaser end-angle)))
  ([x y x-radius y-radius start-angle end-angle clockwise]
   (js/Phaser.Curves.Ellipse. (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser x-radius)
                              (clj->phaser y-radius)
                              (clj->phaser start-angle)
                              (clj->phaser end-angle)
                              (clj->phaser clockwise)))
  ([x y x-radius y-radius start-angle end-angle clockwise rotation]
   (js/Phaser.Curves.Ellipse. (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser x-radius)
                              (clj->phaser y-radius)
                              (clj->phaser start-angle)
                              (clj->phaser end-angle)
                              (clj->phaser clockwise)
                              (clj->phaser rotation))))

(defn draw
  "Draws this curve on the given Graphics object.

  The curve is drawn using `Graphics.strokePoints` so will be drawn at whatever the present Graphics stroke color is.
  The Graphics object is not cleared before the draw, so the curve will appear on-top of anything else already rendered to it.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The Graphics instance onto which this curve will be drawn.
    * points-total (integer) {optional} - The resolution of the curve. The higher the value the smoother it will render, at the cost of rendering performance.

  Returns:  Phaser.GameObjects.Graphics - The Graphics object to which the curve was drawn."
  ([ellipse graphics]
   (phaser->clj
    (.draw ellipse
           (clj->phaser graphics))))
  ([ellipse graphics points-total]
   (phaser->clj
    (.draw ellipse
           (clj->phaser graphics)
           (clj->phaser points-total)))))

(defn from-json
  "Creates a curve from the provided Ellipse Curve Configuration object.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * data (Phaser.Types.Curves.JSONEllipseCurve) - The JSON object containing this curve data.

  Returns:  Phaser.Curves.Ellipse - The ellipse curve constructed from the configuration object."
  ([ellipse data]
   (phaser->clj
    (.fromJSON ellipse
               (clj->phaser data)))))

(defn get-bounds
  "Returns a Rectangle where the position and dimensions match the bounds of this Curve.

  You can control the accuracy of the bounds. The value given is used to work out how many points
  to plot across the curve. Higher values are more accurate at the cost of calculation speed.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - The Rectangle to store the bounds in. If falsey a new object will be created.
    * accuracy (integer) {optional} - The accuracy of the bounds calculations.

  Returns:  Phaser.Geom.Rectangle - A Rectangle object holding the bounds of this curve. If `out` was given it will be this object."
  ([ellipse]
   (phaser->clj
    (.getBounds ellipse)))
  ([ellipse out]
   (phaser->clj
    (.getBounds ellipse
                (clj->phaser out))))
  ([ellipse out accuracy]
   (phaser->clj
    (.getBounds ellipse
                (clj->phaser out)
                (clj->phaser accuracy)))))

(defn get-distance-points
  "Returns an array of points, spaced out X distance pixels apart.
  The smaller the distance, the larger the array will be.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * distance (integer) - The distance, in pixels, between each point along the curve.

  Returns:  Array.<Phaser.Geom.Point> - An Array of Point objects."
  ([ellipse distance]
   (phaser->clj
    (.getDistancePoints ellipse
                        (clj->phaser distance)))))

(defn get-end-point
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - Optional Vector object to store the result in.

  Returns:  Phaser.Math.Vector2 - Vector2 containing the coordinates of the curves end point."
  ([ellipse]
   (phaser->clj
    (.getEndPoint ellipse)))
  ([ellipse out]
   (phaser->clj
    (.getEndPoint ellipse
                  (clj->phaser out)))))

(defn get-length
  "Get total curve arc length

  Returns:  number - [description]"
  ([ellipse]
   (phaser->clj
    (.getLength ellipse))))

(defn get-lengths
  "Get list of cumulative segment lengths

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<number> - [description]"
  ([ellipse]
   (phaser->clj
    (.getLengths ellipse)))
  ([ellipse divisions]
   (phaser->clj
    (.getLengths ellipse
                 (clj->phaser divisions)))))

(defn get-point
  "Get point at relative position in curve according to length.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * t (number) - The position along the curve to return. Where 0 is the start and 1 is the end.
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([ellipse t]
   (phaser->clj
    (.getPoint ellipse
               (clj->phaser t))))
  ([ellipse t out]
   (phaser->clj
    (.getPoint ellipse
               (clj->phaser t)
               (clj->phaser out)))))

(defn get-point-at
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([ellipse u]
   (phaser->clj
    (.getPointAt ellipse
                 (clj->phaser u))))
  ([ellipse u out]
   (phaser->clj
    (.getPointAt ellipse
                 (clj->phaser u)
                 (clj->phaser out)))))

(defn get-points
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([ellipse]
   (phaser->clj
    (.getPoints ellipse)))
  ([ellipse divisions]
   (phaser->clj
    (.getPoints ellipse
                (clj->phaser divisions)))))

(defn get-random-point
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([ellipse]
   (phaser->clj
    (.getRandomPoint ellipse)))
  ([ellipse out]
   (phaser->clj
    (.getRandomPoint ellipse
                     (clj->phaser out)))))

(defn get-resolution
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * divisions (number) - [description]

  Returns:  number - [description]"
  ([ellipse divisions]
   (phaser->clj
    (.getResolution ellipse
                    (clj->phaser divisions)))))

(defn get-spaced-points
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([ellipse]
   (phaser->clj
    (.getSpacedPoints ellipse)))
  ([ellipse divisions]
   (phaser->clj
    (.getSpacedPoints ellipse
                      (clj->phaser divisions)))))

(defn get-start-point
  "Gets the starting point on the curve.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([ellipse]
   (phaser->clj
    (.getStartPoint ellipse)))
  ([ellipse out]
   (phaser->clj
    (.getStartPoint ellipse
                    (clj->phaser out)))))

(defn get-t-from-distance
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([ellipse distance]
   (phaser->clj
    (.getTFromDistance ellipse
                       (clj->phaser distance))))
  ([ellipse distance divisions]
   (phaser->clj
    (.getTFromDistance ellipse
                       (clj->phaser distance)
                       (clj->phaser divisions)))))

(defn get-tangent
  "Returns a unit vector tangent at t
  In case any sub curve does not implement its tangent derivation,
  2 points a small delta apart will be used to find its gradient
  which seems to give a reasonable approximation

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * t (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - Vector approximating the tangent line at the point t (delta +/- 0.0001)"
  ([ellipse t]
   (phaser->clj
    (.getTangent ellipse
                 (clj->phaser t))))
  ([ellipse t out]
   (phaser->clj
    (.getTangent ellipse
                 (clj->phaser t)
                 (clj->phaser out)))))

(defn get-tangent-at
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([ellipse u]
   (phaser->clj
    (.getTangentAt ellipse
                   (clj->phaser u))))
  ([ellipse u out]
   (phaser->clj
    (.getTangentAt ellipse
                   (clj->phaser u)
                   (clj->phaser out)))))

(defn get-uto-tmapping
  "[description]

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * u (number) - [description]
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([ellipse u distance]
   (phaser->clj
    (.getUtoTmapping ellipse
                     (clj->phaser u)
                     (clj->phaser distance))))
  ([ellipse u distance divisions]
   (phaser->clj
    (.getUtoTmapping ellipse
                     (clj->phaser u)
                     (clj->phaser distance)
                     (clj->phaser divisions)))))

(defn set-clockwise
  "Sets if this curve extends clockwise or anti-clockwise.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * value (boolean) - The clockwise state of this curve.

  Returns:  Phaser.Curves.Ellipse - This curve object."
  ([ellipse value]
   (phaser->clj
    (.setClockwise ellipse
                   (clj->phaser value)))))

(defn set-end-angle
  "Sets the end angle of this curve.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * value (number) - The end angle of this curve, in radians.

  Returns:  Phaser.Curves.Ellipse - This curve object."
  ([ellipse value]
   (phaser->clj
    (.setEndAngle ellipse
                  (clj->phaser value)))))

(defn set-height
  "Sets the height of this curve.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * value (number) - The height of this curve.

  Returns:  Phaser.Curves.Ellipse - This curve object."
  ([ellipse value]
   (phaser->clj
    (.setHeight ellipse
                (clj->phaser value)))))

(defn set-rotation
  "Sets the rotation of this curve.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * value (number) - The rotation of this curve, in radians.

  Returns:  Phaser.Curves.Ellipse - This curve object."
  ([ellipse value]
   (phaser->clj
    (.setRotation ellipse
                  (clj->phaser value)))))

(defn set-start-angle
  "Sets the start angle of this curve.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * value (number) - The start angle of this curve, in radians.

  Returns:  Phaser.Curves.Ellipse - This curve object."
  ([ellipse value]
   (phaser->clj
    (.setStartAngle ellipse
                    (clj->phaser value)))))

(defn set-width
  "Sets the width of this curve.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * value (number) - The width of this curve.

  Returns:  Phaser.Curves.Ellipse - This curve object."
  ([ellipse value]
   (phaser->clj
    (.setWidth ellipse
               (clj->phaser value)))))

(defn set-x-radius
  "Sets the horizontal radius of this curve.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * value (number) - The horizontal radius of this curve.

  Returns:  Phaser.Curves.Ellipse - This curve object."
  ([ellipse value]
   (phaser->clj
    (.setXRadius ellipse
                 (clj->phaser value)))))

(defn set-y-radius
  "Sets the vertical radius of this curve.

  Parameters:
    * ellipse (Phaser.Curves.Ellipse) - Targeted instance for method
    * value (number) - The vertical radius of this curve.

  Returns:  Phaser.Curves.Ellipse - This curve object."
  ([ellipse value]
   (phaser->clj
    (.setYRadius ellipse
                 (clj->phaser value)))))

(defn to-json
  "JSON serialization of the curve.

  Returns:  Phaser.Types.Curves.JSONEllipseCurve - The JSON object containing this curve data."
  ([ellipse]
   (phaser->clj
    (.toJSON ellipse))))

(defn update-arc-lengths
  "[description]"
  ([ellipse]
   (phaser->clj
    (.updateArcLengths ellipse))))