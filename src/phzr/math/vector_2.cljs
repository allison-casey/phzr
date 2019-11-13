(ns phzr.math.vector-2
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone set divide]))

(defn ->Vector2
  "  Parameters:
    * x (number | Phaser.Types.Math.Vector2Like) {optional} - The x component, or an object with `x` and `y` properties.
    * y (number) {optional} - The y component."
  ([]
   (js/Phaser.Math.Vector2.))
  ([x]
   (js/Phaser.Math.Vector2. (clj->phaser x)))
  ([x y]
   (js/Phaser.Math.Vector2. (clj->phaser x)
                            (clj->phaser y))))

(defn add
  "Add a given Vector to this Vector. Addition is component-wise.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector to add to this Vector.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 src]
   (phaser->clj
    (.add vector-2
          (clj->phaser src)))))

(defn angle
  "Calculate the angle between this Vector and the positive x-axis, in radians.

  Returns:  number - The angle between this Vector, and the positive x-axis, given in radians."
  ([vector-2]
   (phaser->clj
    (.angle vector-2))))

(defn clone
  "Make a clone of this Vector2.

  Returns:  Phaser.Math.Vector2 - A clone of this Vector2."
  ([vector-2]
   (phaser->clj
    (.clone vector-2))))

(defn copy
  "Copy the components of a given Vector into this Vector.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector to copy the components from.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 src]
   (phaser->clj
    (.copy vector-2
           (clj->phaser src)))))

(defn cross
  "Calculate the cross product of this Vector and the given Vector.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector2 to cross with this Vector2.

  Returns:  number - The cross product of this Vector and the given Vector."
  ([vector-2 src]
   (phaser->clj
    (.cross vector-2
            (clj->phaser src)))))

(defn distance
  "Calculate the distance between this Vector and the given Vector.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector to calculate the distance to.

  Returns:  number - The distance from this Vector to the given Vector."
  ([vector-2 src]
   (phaser->clj
    (.distance vector-2
               (clj->phaser src)))))

(defn distance-sq
  "Calculate the distance between this Vector and the given Vector, squared.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector to calculate the distance to.

  Returns:  number - The distance from this Vector to the given Vector, squared."
  ([vector-2 src]
   (phaser->clj
    (.distanceSq vector-2
                 (clj->phaser src)))))

(defn divide
  "Perform a component-wise division between this Vector and the given Vector.

  Divides this Vector by the given Vector.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector to divide this Vector by.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 src]
   (phaser->clj
    (.divide vector-2
             (clj->phaser src)))))

(defn dot
  "Calculate the dot product of this Vector and the given Vector.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector2 to dot product with this Vector2.

  Returns:  number - The dot product of this Vector and the given Vector."
  ([vector-2 src]
   (phaser->clj
    (.dot vector-2
          (clj->phaser src)))))

(defn equals
  "Check whether this Vector is equal to a given Vector.

  Performs a strict equality check against each Vector's components.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * v (Phaser.Math.Vector2) - The vector to compare with this Vector.

  Returns:  boolean - Whether the given Vector is equal to this Vector."
  ([vector-2 v]
   (phaser->clj
    (.equals vector-2
             (clj->phaser v)))))

(defn length
  "Calculate the length (or magnitude) of this Vector.

  Returns:  number - The length of this Vector."
  ([vector-2]
   (phaser->clj
    (.length vector-2))))

(defn length-sq
  "Calculate the length of this Vector squared.

  Returns:  number - The length of this Vector, squared."
  ([vector-2]
   (phaser->clj
    (.lengthSq vector-2))))

(defn lerp
  "Linearly interpolate between this Vector and the given Vector.

  Interpolates this Vector towards the given Vector.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector2 to interpolate towards.
    * t (number) {optional} - The interpolation percentage, between 0 and 1.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 src]
   (phaser->clj
    (.lerp vector-2
           (clj->phaser src))))
  ([vector-2 src t]
   (phaser->clj
    (.lerp vector-2
           (clj->phaser src)
           (clj->phaser t)))))

(defn multiply
  "Perform a component-wise multiplication between this Vector and the given Vector.

  Multiplies this Vector by the given Vector.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector to multiply this Vector by.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 src]
   (phaser->clj
    (.multiply vector-2
               (clj->phaser src)))))

(defn negate
  "Negate the `x` and `y` components of this Vector.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2]
   (phaser->clj
    (.negate vector-2))))

(defn normalize
  "Normalize this Vector.

  Makes the vector a unit length vector (magnitude of 1) in the same direction.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2]
   (phaser->clj
    (.normalize vector-2))))

(defn normalize-right-hand
  "Right-hand normalize (make unit length) this Vector.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2]
   (phaser->clj
    (.normalizeRightHand vector-2))))

(defn reset
  "Make this Vector the zero vector (0, 0).

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2]
   (phaser->clj
    (.reset vector-2))))

(defn scale
  "Scale this Vector by the given value.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * value (number) - The value to scale this Vector by.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 value]
   (phaser->clj
    (.scale vector-2
            (clj->phaser value)))))

(defn set
  "Set the `x` and `y` components of the this Vector to the given `x` and `y` values.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * x (number) - The x value to set for this Vector.
    * y (number) {optional} - The y value to set for this Vector.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 x]
   (phaser->clj
    (.set vector-2
          (clj->phaser x))))
  ([vector-2 x y]
   (phaser->clj
    (.set vector-2
          (clj->phaser x)
          (clj->phaser y)))))

(defn set-from-object
  "Set the component values of this Vector from a given Vector2Like object.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * obj (Phaser.Types.Math.Vector2Like) - The object containing the component values to set for this Vector.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 obj]
   (phaser->clj
    (.setFromObject vector-2
                    (clj->phaser obj)))))

(defn set-to
  "This method is an alias for `Vector2.set`.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * x (number) - The x value to set for this Vector.
    * y (number) {optional} - The y value to set for this Vector.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 x]
   (phaser->clj
    (.setTo vector-2
            (clj->phaser x))))
  ([vector-2 x y]
   (phaser->clj
    (.setTo vector-2
            (clj->phaser x)
            (clj->phaser y)))))

(defn set-to-polar
  "Sets the `x` and `y` values of this object from a given polar coordinate.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * azimuth (number) - The angular coordinate, in radians.
    * radius (number) {optional} - The radial coordinate (length).

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 azimuth]
   (phaser->clj
    (.setToPolar vector-2
                 (clj->phaser azimuth))))
  ([vector-2 azimuth radius]
   (phaser->clj
    (.setToPolar vector-2
                 (clj->phaser azimuth)
                 (clj->phaser radius)))))

(defn subtract
  "Subtract the given Vector from this Vector. Subtraction is component-wise.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * src (Phaser.Math.Vector2) - The Vector to subtract from this Vector.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 src]
   (phaser->clj
    (.subtract vector-2
               (clj->phaser src)))))

(defn transform-mat-3
  "Transform this Vector with the given Matrix.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * mat (Phaser.Math.Matrix3) - The Matrix3 to transform this Vector2 with.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 mat]
   (phaser->clj
    (.transformMat3 vector-2
                    (clj->phaser mat)))))

(defn transform-mat-4
  "Transform this Vector with the given Matrix.

  Parameters:
    * vector-2 (Phaser.Math.Vector2) - Targeted instance for method
    * mat (Phaser.Math.Matrix4) - The Matrix4 to transform this Vector2 with.

  Returns:  Phaser.Math.Vector2 - This Vector2."
  ([vector-2 mat]
   (phaser->clj
    (.transformMat4 vector-2
                    (clj->phaser mat)))))