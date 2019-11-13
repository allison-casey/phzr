(ns phzr.math.vector-3
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone set divide]))

(defn ->Vector3
  "  Parameters:
    * x (number) {optional} - The x component.
    * y (number) {optional} - The y component.
    * z (number) {optional} - The z component."
  ([]
   (js/Phaser.Math.Vector3.))
  ([x]
   (js/Phaser.Math.Vector3. (clj->phaser x)))
  ([x y]
   (js/Phaser.Math.Vector3. (clj->phaser x)
                            (clj->phaser y)))
  ([x y z]
   (js/Phaser.Math.Vector3. (clj->phaser x)
                            (clj->phaser y)
                            (clj->phaser z))))

(defn add
  "Add a given Vector to this Vector. Addition is component-wise.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3) - The Vector to add to this Vector.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 v]
   (phaser->clj
    (.add vector-3
          (clj->phaser v)))))

(defn clone
  "Make a clone of this Vector3.

  Returns:  Phaser.Math.Vector3 - A new Vector3 object containing this Vectors values."
  ([vector-3]
   (phaser->clj
    (.clone vector-3))))

(defn copy
  "Copy the components of a given Vector into this Vector.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * src (Phaser.Math.Vector2 | Phaser.Math.Vector3) - The Vector to copy the components from.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 src]
   (phaser->clj
    (.copy vector-3
           (clj->phaser src)))))

(defn cross
  "Calculate the cross (vector) product of this Vector (which will be modified) and the given Vector.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector3) - The Vector to cross product with.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 v]
   (phaser->clj
    (.cross vector-3
            (clj->phaser v)))))

(defn cross-vectors
  "Calculate the cross (vector) product of two given Vectors.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * a (Phaser.Math.Vector3) - The first Vector to multiply.
    * b (Phaser.Math.Vector3) - The second Vector to multiply.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 a b]
   (phaser->clj
    (.crossVectors vector-3
                   (clj->phaser a)
                   (clj->phaser b)))))

(defn distance
  "Calculate the distance between this Vector and the given Vector.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3) - The Vector to calculate the distance to.

  Returns:  number - The distance from this Vector to the given Vector."
  ([vector-3 v]
   (phaser->clj
    (.distance vector-3
               (clj->phaser v)))))

(defn distance-sq
  "Calculate the distance between this Vector and the given Vector, squared.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3) - The Vector to calculate the distance to.

  Returns:  number - The distance from this Vector to the given Vector, squared."
  ([vector-3 v]
   (phaser->clj
    (.distanceSq vector-3
                 (clj->phaser v)))))

(defn divide
  "Perform a component-wise division between this Vector and the given Vector.

  Divides this Vector by the given Vector.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3) - The Vector to divide this Vector by.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 v]
   (phaser->clj
    (.divide vector-3
             (clj->phaser v)))))

(defn dot
  "Calculate the dot product of this Vector and the given Vector.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector3) - The Vector3 to dot product with this Vector3.

  Returns:  number - The dot product of this Vector and `v`."
  ([vector-3 v]
   (phaser->clj
    (.dot vector-3
          (clj->phaser v)))))

(defn equals
  "Check whether this Vector is equal to a given Vector.

  Performs a strict equality check against each Vector's components.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector3) - The Vector3 to compare against.

  Returns:  boolean - True if the two vectors strictly match, otherwise false."
  ([vector-3 v]
   (phaser->clj
    (.equals vector-3
             (clj->phaser v)))))

(defn length
  "Calculate the length (or magnitude) of this Vector.

  Returns:  number - The length of this Vector."
  ([vector-3]
   (phaser->clj
    (.length vector-3))))

(defn length-sq
  "Calculate the length of this Vector squared.

  Returns:  number - The length of this Vector, squared."
  ([vector-3]
   (phaser->clj
    (.lengthSq vector-3))))

(defn lerp
  "Linearly interpolate between this Vector and the given Vector.

  Interpolates this Vector towards the given Vector.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector3) - The Vector3 to interpolate towards.
    * t (number) {optional} - The interpolation percentage, between 0 and 1.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 v]
   (phaser->clj
    (.lerp vector-3
           (clj->phaser v))))
  ([vector-3 v t]
   (phaser->clj
    (.lerp vector-3
           (clj->phaser v)
           (clj->phaser t)))))

(defn multiply
  "Perform a component-wise multiplication between this Vector and the given Vector.

  Multiplies this Vector by the given Vector.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3) - The Vector to multiply this Vector by.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 v]
   (phaser->clj
    (.multiply vector-3
               (clj->phaser v)))))

(defn negate
  "Negate the `x`, `y` and `z` components of this Vector.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3]
   (phaser->clj
    (.negate vector-3))))

(defn normalize
  "Normalize this Vector.

  Makes the vector a unit length vector (magnitude of 1) in the same direction.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3]
   (phaser->clj
    (.normalize vector-3))))

(defn project
  "Multiplies this Vector3 by the specified matrix, applying a W divide. This is useful for projection,
  e.g. unprojecting a 2D point into 3D space.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * mat (Phaser.Math.Matrix4) - The Matrix4 to multiply this Vector3 with.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 mat]
   (phaser->clj
    (.project vector-3
              (clj->phaser mat)))))

(defn reset
  "Make this Vector the zero vector (0, 0, 0).

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3]
   (phaser->clj
    (.reset vector-3))))

(defn scale
  "Scale this Vector by the given value.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * scale (number) - The value to scale this Vector by.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 scale]
   (phaser->clj
    (.scale vector-3
            (clj->phaser scale)))))

(defn set
  "Set the `x`, `y`, and `z` components of this Vector to the given `x`, `y`, and `z` values.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * x (number | object) - The x value to set for this Vector, or an object containing x, y and z components.
    * y (number) {optional} - The y value to set for this Vector.
    * z (number) {optional} - The z value to set for this Vector.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 x]
   (phaser->clj
    (.set vector-3
          (clj->phaser x))))
  ([vector-3 x y]
   (phaser->clj
    (.set vector-3
          (clj->phaser x)
          (clj->phaser y))))
  ([vector-3 x y z]
   (phaser->clj
    (.set vector-3
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser z)))))

(defn subtract
  "Subtract the given Vector from this Vector. Subtraction is component-wise.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3) - The Vector to subtract from this Vector.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 v]
   (phaser->clj
    (.subtract vector-3
               (clj->phaser v)))))

(defn transform-coordinates
  "Transforms the coordinates of this Vector3 with the given Matrix4.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * mat (Phaser.Math.Matrix4) - The Matrix4 to transform this Vector3 with.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 mat]
   (phaser->clj
    (.transformCoordinates vector-3
                           (clj->phaser mat)))))

(defn transform-mat-3
  "Transform this Vector with the given Matrix.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * mat (Phaser.Math.Matrix3) - The Matrix3 to transform this Vector3 with.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 mat]
   (phaser->clj
    (.transformMat3 vector-3
                    (clj->phaser mat)))))

(defn transform-mat-4
  "Transform this Vector with the given Matrix.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * mat (Phaser.Math.Matrix4) - The Matrix4 to transform this Vector3 with.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 mat]
   (phaser->clj
    (.transformMat4 vector-3
                    (clj->phaser mat)))))

(defn transform-quat
  "Transform this Vector with the given Quaternion.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * q (Phaser.Math.Quaternion) - The Quaternion to transform this Vector with.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 q]
   (phaser->clj
    (.transformQuat vector-3
                    (clj->phaser q)))))

(defn unproject
  "Unproject this point from 2D space to 3D space.
  The point should have its x and y properties set to
  2D screen space, and the z either at 0 (near plane)
  or 1 (far plane). The provided matrix is assumed to already
  be combined, i.e. projection * view * model.

  After this operation, this vector's (x, y, z) components will
  represent the unprojected 3D coordinate.

  Parameters:
    * vector-3 (Phaser.Math.Vector3) - Targeted instance for method
    * viewport (Phaser.Math.Vector4) - Screen x, y, width and height in pixels.
    * inv-projection-view (Phaser.Math.Matrix4) - Combined projection and view matrix.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3 viewport inv-projection-view]
   (phaser->clj
    (.unproject vector-3
                (clj->phaser viewport)
                (clj->phaser inv-projection-view)))))

(defn up
  "Set this Vector to point up.

  Sets the y component of the vector to 1, and the others to 0.

  Returns:  Phaser.Math.Vector3 - This Vector3."
  ([vector-3]
   (phaser->clj
    (.up vector-3))))