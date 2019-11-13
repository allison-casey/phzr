(ns phzr.curves.move-to
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->MoveTo
  "  Parameters:
    * x (number) {optional} - `x` pixel coordinate.
    * y (number) {optional} - `y` pixel coordinate."
  ([]
   (js/Phaser.Curves.MoveTo.))
  ([x]
   (js/Phaser.Curves.MoveTo. (clj->phaser x)))
  ([x y]
   (js/Phaser.Curves.MoveTo. (clj->phaser x)
                             (clj->phaser y))))

(defn get-length
  "Gets the length of this curve.

  Returns:  number - The length of this curve. For a MoveTo the value is always 0."
  ([move-to]
   (phaser->clj
    (.getLength move-to))))

(defn get-point
  "Get point at relative position in curve according to length.

  Parameters:
    * move-to (Phaser.Curves.MoveTo) - Targeted instance for method
    * t (number) - The position along the curve to return. Where 0 is the start and 1 is the end.
    * out (Phaser.Math.Vector2) {optional} - A Vector2 object to store the result in. If not given will be created.

  Returns:  Phaser.Math.Vector2 - The coordinates of the point on the curve. If an `out` object was given this will be returned."
  ([move-to t]
   (phaser->clj
    (.getPoint move-to
               (clj->phaser t))))
  ([move-to t out]
   (phaser->clj
    (.getPoint move-to
               (clj->phaser t)
               (clj->phaser out)))))

(defn get-point-at
  "Retrieves the point at given position in the curve. This will always return this curve's only point.

  Parameters:
    * move-to (Phaser.Curves.MoveTo) - Targeted instance for method
    * u (number) - The position in the path to retrieve, between 0 and 1. Not used.
    * out (Phaser.Math.Vector2) {optional} - An optional vector in which to store the point.

  Returns:  Phaser.Math.Vector2 - The modified `out` vector, or a new `Vector2` if none was provided."
  ([move-to u]
   (phaser->clj
    (.getPointAt move-to
                 (clj->phaser u))))
  ([move-to u out]
   (phaser->clj
    (.getPointAt move-to
                 (clj->phaser u)
                 (clj->phaser out)))))

(defn get-resolution
  "Gets the resolution of this curve.

  Returns:  number - The resolution of this curve. For a MoveTo the value is always 1."
  ([move-to]
   (phaser->clj
    (.getResolution move-to))))

(defn to-json
  "Converts this curve into a JSON-serializable object.

  Returns:  Phaser.Types.Curves.JSONCurve - A primitive object with the curve's type and only point."
  ([move-to]
   (phaser->clj
    (.toJSON move-to))))