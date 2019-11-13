(ns phzr.curves.curve
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Curve
  "  Parameters:
    * type (string) - [description]"
  ([type]
   (js/Phaser.Curves.Curve. (clj->phaser type))))

(defn draw
  "Draws this curve on the given Graphics object.

  The curve is drawn using `Graphics.strokePoints` so will be drawn at whatever the present Graphics stroke color is.
  The Graphics object is not cleared before the draw, so the curve will appear on-top of anything else already rendered to it.

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The Graphics instance onto which this curve will be drawn.
    * points-total (integer) {optional} - The resolution of the curve. The higher the value the smoother it will render, at the cost of rendering performance.

  Returns:  Phaser.GameObjects.Graphics - The Graphics object to which the curve was drawn."
  ([curve graphics]
   (phaser->clj
    (.draw curve
           (clj->phaser graphics))))
  ([curve graphics points-total]
   (phaser->clj
    (.draw curve
           (clj->phaser graphics)
           (clj->phaser points-total)))))

(defn get-bounds
  "Returns a Rectangle where the position and dimensions match the bounds of this Curve.

  You can control the accuracy of the bounds. The value given is used to work out how many points
  to plot across the curve. Higher values are more accurate at the cost of calculation speed.

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * out (Phaser.Geom.Rectangle) {optional} - The Rectangle to store the bounds in. If falsey a new object will be created.
    * accuracy (integer) {optional} - The accuracy of the bounds calculations.

  Returns:  Phaser.Geom.Rectangle - A Rectangle object holding the bounds of this curve. If `out` was given it will be this object."
  ([curve]
   (phaser->clj
    (.getBounds curve)))
  ([curve out]
   (phaser->clj
    (.getBounds curve
                (clj->phaser out))))
  ([curve out accuracy]
   (phaser->clj
    (.getBounds curve
                (clj->phaser out)
                (clj->phaser accuracy)))))

(defn get-distance-points
  "Returns an array of points, spaced out X distance pixels apart.
  The smaller the distance, the larger the array will be.

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * distance (integer) - The distance, in pixels, between each point along the curve.

  Returns:  Array.<Phaser.Geom.Point> - An Array of Point objects."
  ([curve distance]
   (phaser->clj
    (.getDistancePoints curve
                        (clj->phaser distance)))))

(defn get-end-point
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - Optional Vector object to store the result in.

  Returns:  Phaser.Math.Vector2 - Vector2 containing the coordinates of the curves end point."
  ([curve]
   (phaser->clj
    (.getEndPoint curve)))
  ([curve out]
   (phaser->clj
    (.getEndPoint curve
                  (clj->phaser out)))))

(defn get-length
  "Get total curve arc length

  Returns:  number - [description]"
  ([curve]
   (phaser->clj
    (.getLength curve))))

(defn get-lengths
  "Get list of cumulative segment lengths

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<number> - [description]"
  ([curve]
   (phaser->clj
    (.getLengths curve)))
  ([curve divisions]
   (phaser->clj
    (.getLengths curve
                 (clj->phaser divisions)))))

(defn get-point-at
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([curve u]
   (phaser->clj
    (.getPointAt curve
                 (clj->phaser u))))
  ([curve u out]
   (phaser->clj
    (.getPointAt curve
                 (clj->phaser u)
                 (clj->phaser out)))))

(defn get-points
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([curve]
   (phaser->clj
    (.getPoints curve)))
  ([curve divisions]
   (phaser->clj
    (.getPoints curve
                (clj->phaser divisions)))))

(defn get-random-point
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([curve]
   (phaser->clj
    (.getRandomPoint curve)))
  ([curve out]
   (phaser->clj
    (.getRandomPoint curve
                     (clj->phaser out)))))

(defn get-spaced-points
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * divisions (integer) {optional} - [description]

  Returns:  Array.<Phaser.Math.Vector2> - [description]"
  ([curve]
   (phaser->clj
    (.getSpacedPoints curve)))
  ([curve divisions]
   (phaser->clj
    (.getSpacedPoints curve
                      (clj->phaser divisions)))))

(defn get-start-point
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([curve]
   (phaser->clj
    (.getStartPoint curve)))
  ([curve out]
   (phaser->clj
    (.getStartPoint curve
                    (clj->phaser out)))))

(defn get-t-from-distance
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([curve distance]
   (phaser->clj
    (.getTFromDistance curve
                       (clj->phaser distance))))
  ([curve distance divisions]
   (phaser->clj
    (.getTFromDistance curve
                       (clj->phaser distance)
                       (clj->phaser divisions)))))

(defn get-tangent
  "Returns a unit vector tangent at t
  In case any sub curve does not implement its tangent derivation,
  2 points a small delta apart will be used to find its gradient
  which seems to give a reasonable approximation

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * t (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - Vector approximating the tangent line at the point t (delta +/- 0.0001)"
  ([curve t]
   (phaser->clj
    (.getTangent curve
                 (clj->phaser t))))
  ([curve t out]
   (phaser->clj
    (.getTangent curve
                 (clj->phaser t)
                 (clj->phaser out)))))

(defn get-tangent-at
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * u (number) - [description]
    * out (Phaser.Math.Vector2) {optional} - [description]

  Returns:  Phaser.Math.Vector2 - [description]"
  ([curve u]
   (phaser->clj
    (.getTangentAt curve
                   (clj->phaser u))))
  ([curve u out]
   (phaser->clj
    (.getTangentAt curve
                   (clj->phaser u)
                   (clj->phaser out)))))

(defn get-uto-tmapping
  "[description]

  Parameters:
    * curve (Phaser.Curves.Curve) - Targeted instance for method
    * u (number) - [description]
    * distance (integer) - [description]
    * divisions (integer) {optional} - [description]

  Returns:  number - [description]"
  ([curve u distance]
   (phaser->clj
    (.getUtoTmapping curve
                     (clj->phaser u)
                     (clj->phaser distance))))
  ([curve u distance divisions]
   (phaser->clj
    (.getUtoTmapping curve
                     (clj->phaser u)
                     (clj->phaser distance)
                     (clj->phaser divisions)))))

(defn update-arc-lengths
  "[description]"
  ([curve]
   (phaser->clj
    (.updateArcLengths curve))))