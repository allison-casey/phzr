(ns phzr.math.vector-4
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone set divide]))

(defn ->Vector4
  "  Parameters:
    * x (number) {optional} - The x component.
    * y (number) {optional} - The y component.
    * z (number) {optional} - The z component.
    * w (number) {optional} - The w component."
  ([]
   (js/Phaser.Math.Vector4.))
  ([x]
   (js/Phaser.Math.Vector4. (clj->phaser x)))
  ([x y]
   (js/Phaser.Math.Vector4. (clj->phaser x)
                            (clj->phaser y)))
  ([x y z]
   (js/Phaser.Math.Vector4. (clj->phaser x)
                            (clj->phaser y)
                            (clj->phaser z)))
  ([x y z w]
   (js/Phaser.Math.Vector4. (clj->phaser x)
                            (clj->phaser y)
                            (clj->phaser z)
                            (clj->phaser w))))

(defn add
  "Add a given Vector to this Vector. Addition is component-wise.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to add to this Vector.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 v]
   (phaser->clj
    (.add vector-4
          (clj->phaser v)))))

(defn clone
  "Make a clone of this Vector4.

  Returns:  Phaser.Math.Vector4 - A clone of this Vector4."
  ([vector-4]
   (phaser->clj
    (.clone vector-4))))

(defn copy
  "Copy the components of a given Vector into this Vector.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * src (Phaser.Math.Vector4) - The Vector to copy the components from.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 src]
   (phaser->clj
    (.copy vector-4
           (clj->phaser src)))))

(defn distance
  "Calculate the distance between this Vector and the given Vector.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to calculate the distance to.

  Returns:  number - The distance from this Vector to the given Vector."
  ([vector-4 v]
   (phaser->clj
    (.distance vector-4
               (clj->phaser v)))))

(defn distance-sq
  "Calculate the distance between this Vector and the given Vector, squared.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to calculate the distance to.

  Returns:  number - The distance from this Vector to the given Vector, squared."
  ([vector-4 v]
   (phaser->clj
    (.distanceSq vector-4
                 (clj->phaser v)))))

(defn divide
  "Perform a component-wise division between this Vector and the given Vector.

  Divides this Vector by the given Vector.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to divide this Vector by.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 v]
   (phaser->clj
    (.divide vector-4
             (clj->phaser v)))))

(defn dot
  "Calculate the dot product of this Vector and the given Vector.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector4) - The Vector4 to dot product with this Vector4.

  Returns:  number - The dot product of this Vector and the given Vector."
  ([vector-4 v]
   (phaser->clj
    (.dot vector-4
          (clj->phaser v)))))

(defn equals
  "Check whether this Vector is equal to a given Vector.

  Performs a strict quality check against each Vector's components.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector4) - The vector to check equality with.

  Returns:  boolean - A boolean indicating whether the two Vectors are equal or not."
  ([vector-4 v]
   (phaser->clj
    (.equals vector-4
             (clj->phaser v)))))

(defn length
  "Calculate the length (or magnitude) of this Vector.

  Returns:  number - The length of this Vector."
  ([vector-4]
   (phaser->clj
    (.length vector-4))))

(defn length-sq
  "Calculate the length of this Vector squared.

  Returns:  number - The length of this Vector, squared."
  ([vector-4]
   (phaser->clj
    (.lengthSq vector-4))))

(defn lerp
  "Linearly interpolate between this Vector and the given Vector.

  Interpolates this Vector towards the given Vector.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector4) - The Vector4 to interpolate towards.
    * t (number) {optional} - The interpolation percentage, between 0 and 1.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 v]
   (phaser->clj
    (.lerp vector-4
           (clj->phaser v))))
  ([vector-4 v t]
   (phaser->clj
    (.lerp vector-4
           (clj->phaser v)
           (clj->phaser t)))))

(defn multiply
  "Perform a component-wise multiplication between this Vector and the given Vector.

  Multiplies this Vector by the given Vector.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to multiply this Vector by.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 v]
   (phaser->clj
    (.multiply vector-4
               (clj->phaser v)))))

(defn negate
  "Negate the `x`, `y`, `z` and `w` components of this Vector.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4]
   (phaser->clj
    (.negate vector-4))))

(defn normalize
  "Normalize this Vector.

  Makes the vector a unit length vector (magnitude of 1) in the same direction.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4]
   (phaser->clj
    (.normalize vector-4))))

(defn reset
  "Make this Vector the zero vector (0, 0, 0, 0).

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4]
   (phaser->clj
    (.reset vector-4))))

(defn scale
  "Scale this Vector by the given value.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * scale (number) - The value to scale this Vector by.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 scale]
   (phaser->clj
    (.scale vector-4
            (clj->phaser scale)))))

(defn set
  "Set the `x`, `y`, `z` and `w` components of the this Vector to the given `x`, `y`, `z` and `w` values.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * x (number | object) - The x value to set for this Vector, or an object containing x, y, z and w components.
    * y (number) - The y value to set for this Vector.
    * z (number) - The z value to set for this Vector.
    * w (number) - The z value to set for this Vector.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 x y z w]
   (phaser->clj
    (.set vector-4
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser z)
          (clj->phaser w)))))

(defn subtract
  "Subtract the given Vector from this Vector. Subtraction is component-wise.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to subtract from this Vector.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 v]
   (phaser->clj
    (.subtract vector-4
               (clj->phaser v)))))

(defn transform-mat-4
  "Transform this Vector with the given Matrix.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * mat (Phaser.Math.Matrix4) - The Matrix4 to transform this Vector4 with.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 mat]
   (phaser->clj
    (.transformMat4 vector-4
                    (clj->phaser mat)))))

(defn transform-quat
  "Transform this Vector with the given Quaternion.

  Parameters:
    * vector-4 (Phaser.Math.Vector4) - Targeted instance for method
    * q (Phaser.Math.Quaternion) - The Quaternion to transform this Vector with.

  Returns:  Phaser.Math.Vector4 - This Vector4."
  ([vector-4 q]
   (phaser->clj
    (.transformQuat vector-4
                    (clj->phaser q)))))