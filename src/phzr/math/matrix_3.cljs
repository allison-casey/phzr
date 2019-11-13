(ns phzr.math.matrix-3
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone set identity]))

(defn ->Matrix3
  "  Parameters:
    * m (Phaser.Math.Matrix3) {optional} - Optional Matrix3 to copy values from."
  ([]
   (js/Phaser.Math.Matrix3.))
  ([m]
   (js/Phaser.Math.Matrix3. (clj->phaser m))))

(defn adjoint
  "Calculate the adjoint, or adjugate, of this Matrix.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3]
   (phaser->clj
    (.adjoint matrix-3))))

(defn clone
  "Make a clone of this Matrix3.

  Returns:  Phaser.Math.Matrix3 - A clone of this Matrix3."
  ([matrix-3]
   (phaser->clj
    (.clone matrix-3))))

(defn copy
  "Copy the values of a given Matrix into this Matrix.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * src (Phaser.Math.Matrix3) - The Matrix to copy the values from.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 src]
   (phaser->clj
    (.copy matrix-3
           (clj->phaser src)))))

(defn determinant
  "Calculate the determinant of this Matrix.

  Returns:  number - The determinant of this Matrix."
  ([matrix-3]
   (phaser->clj
    (.determinant matrix-3))))

(defn from-array
  "Set the values of this Matrix from the given array.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * a (array) - The array to copy the values from.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 a]
   (phaser->clj
    (.fromArray matrix-3
                (clj->phaser a)))))

(defn from-mat-4
  "Copy the values of a given Matrix4 into this Matrix3.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * m (Phaser.Math.Matrix4) - The Matrix4 to copy the values from.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 m]
   (phaser->clj
    (.fromMat4 matrix-3
               (clj->phaser m)))))

(defn from-quat
  "Set the values of this Matrix from the given Quaternion.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * q (Phaser.Math.Quaternion) - The Quaternion to set the values of this Matrix from.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 q]
   (phaser->clj
    (.fromQuat matrix-3
               (clj->phaser q)))))

(defn identity
  "Reset this Matrix to an identity (default) matrix.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3]
   (phaser->clj
    (.identity matrix-3))))

(defn invert
  "Invert this Matrix.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3]
   (phaser->clj
    (.invert matrix-3))))

(defn multiply
  "Multiply this Matrix by the given Matrix.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * src (Phaser.Math.Matrix3) - The Matrix to multiply this Matrix by.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 src]
   (phaser->clj
    (.multiply matrix-3
               (clj->phaser src)))))

(defn normal-from-mat-4
  "[description]

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * m (Phaser.Math.Matrix4) - [description]

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 m]
   (phaser->clj
    (.normalFromMat4 matrix-3
                     (clj->phaser m)))))

(defn rotate
  "Apply a rotation transformation to this Matrix.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * rad (number) - The angle in radians to rotate by.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 rad]
   (phaser->clj
    (.rotate matrix-3
             (clj->phaser rad)))))

(defn scale
  "Apply a scale transformation to this Matrix.

  Uses the `x` and `y` components of the given Vector to scale the Matrix.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to scale this Matrix with.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 v]
   (phaser->clj
    (.scale matrix-3
            (clj->phaser v)))))

(defn set
  "This method is an alias for `Matrix3.copy`.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * src (Phaser.Math.Matrix3) - The Matrix to set the values of this Matrix's from.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 src]
   (phaser->clj
    (.set matrix-3
          (clj->phaser src)))))

(defn translate
  "Translate this Matrix using the given Vector.

  Parameters:
    * matrix-3 (Phaser.Math.Matrix3) - Targeted instance for method
    * v (Phaser.Math.Vector2 | Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to translate this Matrix with.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3 v]
   (phaser->clj
    (.translate matrix-3
                (clj->phaser v)))))

(defn transpose
  "Transpose this Matrix.

  Returns:  Phaser.Math.Matrix3 - This Matrix3."
  ([matrix-3]
   (phaser->clj
    (.transpose matrix-3))))