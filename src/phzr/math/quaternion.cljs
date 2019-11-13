(ns phzr.math.quaternion
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [set identity]))

(defn ->Quaternion
  "  Parameters:
    * x (number) {optional} - The x component.
    * y (number) {optional} - The y component.
    * z (number) {optional} - The z component.
    * w (number) {optional} - The w component."
  ([]
   (js/Phaser.Math.Quaternion.))
  ([x]
   (js/Phaser.Math.Quaternion. (clj->phaser x)))
  ([x y]
   (js/Phaser.Math.Quaternion. (clj->phaser x)
                               (clj->phaser y)))
  ([x y z]
   (js/Phaser.Math.Quaternion. (clj->phaser x)
                               (clj->phaser y)
                               (clj->phaser z)))
  ([x y z w]
   (js/Phaser.Math.Quaternion. (clj->phaser x)
                               (clj->phaser y)
                               (clj->phaser z)
                               (clj->phaser w))))

(defn add
  "Add a given Quaternion or Vector to this Quaternion. Addition is component-wise.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * v (Phaser.Math.Quaternion | Phaser.Math.Vector4) - The Quaternion or Vector to add to this Quaternion.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion v]
   (phaser->clj
    (.add quaternion
          (clj->phaser v)))))

(defn calculate-w
  "Create a unit (or rotation) Quaternion from its x, y, and z components.

  Sets the w component.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion]
   (phaser->clj
    (.calculateW quaternion))))

(defn conjugate
  "Convert this Quaternion into its conjugate.

  Sets the x, y and z components.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion]
   (phaser->clj
    (.conjugate quaternion))))

(defn copy
  "Copy the components of a given Quaternion or Vector into this Quaternion.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * src (Phaser.Math.Quaternion | Phaser.Math.Vector4) - The Quaternion or Vector to copy the components from.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion src]
   (phaser->clj
    (.copy quaternion
           (clj->phaser src)))))

(defn dot
  "Calculate the dot product of this Quaternion and the given Quaternion or Vector.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * v (Phaser.Math.Quaternion | Phaser.Math.Vector4) - The Quaternion or Vector to dot product with this Quaternion.

  Returns:  number - The dot product of this Quaternion and the given Quaternion or Vector."
  ([quaternion v]
   (phaser->clj
    (.dot quaternion
          (clj->phaser v)))))

(defn from-mat-3
  "Convert the given Matrix into this Quaternion.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * mat (Phaser.Math.Matrix3) - The Matrix to convert from.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion mat]
   (phaser->clj
    (.fromMat3 quaternion
               (clj->phaser mat)))))

(defn identity
  "Reset this Matrix to an identity (default) Quaternion.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion]
   (phaser->clj
    (.identity quaternion))))

(defn invert
  "Invert this Quaternion.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion]
   (phaser->clj
    (.invert quaternion))))

(defn length
  "Calculate the length of this Quaternion.

  Returns:  number - The length of this Quaternion."
  ([quaternion]
   (phaser->clj
    (.length quaternion))))

(defn length-sq
  "Calculate the length of this Quaternion squared.

  Returns:  number - The length of this Quaternion, squared."
  ([quaternion]
   (phaser->clj
    (.lengthSq quaternion))))

(defn lerp
  "Linearly interpolate this Quaternion towards the given Quaternion or Vector.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * v (Phaser.Math.Quaternion | Phaser.Math.Vector4) - The Quaternion or Vector to interpolate towards.
    * t (number) {optional} - The percentage of interpolation.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion v]
   (phaser->clj
    (.lerp quaternion
           (clj->phaser v))))
  ([quaternion v t]
   (phaser->clj
    (.lerp quaternion
           (clj->phaser v)
           (clj->phaser t)))))

(defn multiply
  "Multiply this Quaternion by the given Quaternion or Vector.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * b (Phaser.Math.Quaternion | Phaser.Math.Vector4) - The Quaternion or Vector to multiply this Quaternion by.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion b]
   (phaser->clj
    (.multiply quaternion
               (clj->phaser b)))))

(defn normalize
  "Normalize this Quaternion.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion]
   (phaser->clj
    (.normalize quaternion))))

(defn rotate-x
  "Rotate this Quaternion on the X axis.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * rad (number) - The rotation angle in radians.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion rad]
   (phaser->clj
    (.rotateX quaternion
              (clj->phaser rad)))))

(defn rotate-y
  "Rotate this Quaternion on the Y axis.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * rad (number) - The rotation angle in radians.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion rad]
   (phaser->clj
    (.rotateY quaternion
              (clj->phaser rad)))))

(defn rotate-z
  "Rotate this Quaternion on the Z axis.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * rad (number) - The rotation angle in radians.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion rad]
   (phaser->clj
    (.rotateZ quaternion
              (clj->phaser rad)))))

(defn rotation-to
  "[description]

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * a (Phaser.Math.Vector3) - [description]
    * b (Phaser.Math.Vector3) - [description]

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion a b]
   (phaser->clj
    (.rotationTo quaternion
                 (clj->phaser a)
                 (clj->phaser b)))))

(defn scale
  "Scale this Quaternion by the given value.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * scale (number) - The value to scale this Quaternion by.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion scale]
   (phaser->clj
    (.scale quaternion
            (clj->phaser scale)))))

(defn set
  "Set the components of this Quaternion.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * x (number | object) {optional} - The x component, or an object containing x, y, z, and w components.
    * y (number) {optional} - The y component.
    * z (number) {optional} - The z component.
    * w (number) {optional} - The w component.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion]
   (phaser->clj
    (.set quaternion)))
  ([quaternion x]
   (phaser->clj
    (.set quaternion
          (clj->phaser x))))
  ([quaternion x y]
   (phaser->clj
    (.set quaternion
          (clj->phaser x)
          (clj->phaser y))))
  ([quaternion x y z]
   (phaser->clj
    (.set quaternion
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser z))))
  ([quaternion x y z w]
   (phaser->clj
    (.set quaternion
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser z)
          (clj->phaser w)))))

(defn set-axes
  "Set the axes of this Quaternion.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * view (Phaser.Math.Vector3) - The view axis.
    * right (Phaser.Math.Vector3) - The right axis.
    * up (Phaser.Math.Vector3) - The upwards axis.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion view right up]
   (phaser->clj
    (.setAxes quaternion
              (clj->phaser view)
              (clj->phaser right)
              (clj->phaser up)))))

(defn set-axis-angle
  "Set the axis angle of this Quaternion.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * axis (Phaser.Math.Vector3) - The axis.
    * rad (number) - The angle in radians.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion axis rad]
   (phaser->clj
    (.setAxisAngle quaternion
                   (clj->phaser axis)
                   (clj->phaser rad)))))

(defn slerp
  "Smoothly linearly interpolate this Quaternion towards the given Quaternion or Vector.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * b (Phaser.Math.Quaternion | Phaser.Math.Vector4) - The Quaternion or Vector to interpolate towards.
    * t (number) - The percentage of interpolation.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion b t]
   (phaser->clj
    (.slerp quaternion
            (clj->phaser b)
            (clj->phaser t)))))

(defn subtract
  "Subtract a given Quaternion or Vector from this Quaternion. Subtraction is component-wise.

  Parameters:
    * quaternion (Phaser.Math.Quaternion) - Targeted instance for method
    * v (Phaser.Math.Quaternion | Phaser.Math.Vector4) - The Quaternion or Vector to subtract from this Quaternion.

  Returns:  Phaser.Math.Quaternion - This Quaternion."
  ([quaternion v]
   (phaser->clj
    (.subtract quaternion
               (clj->phaser v)))))