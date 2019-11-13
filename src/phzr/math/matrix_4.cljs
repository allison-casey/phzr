(ns phzr.math.matrix-4
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [clone set identity]))

(defn ->Matrix4
  "  Parameters:
    * m (Phaser.Math.Matrix4) {optional} - Optional Matrix4 to copy values from."
  ([]
   (js/Phaser.Math.Matrix4.))
  ([m]
   (js/Phaser.Math.Matrix4. (clj->phaser m))))

(defn adjoint
  "Calculate the adjoint, or adjugate, of this Matrix.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4]
   (phaser->clj
    (.adjoint matrix-4))))

(defn clone
  "Make a clone of this Matrix4.

  Returns:  Phaser.Math.Matrix4 - A clone of this Matrix4."
  ([matrix-4]
   (phaser->clj
    (.clone matrix-4))))

(defn copy
  "Copy the values of a given Matrix into this Matrix.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * src (Phaser.Math.Matrix4) - The Matrix to copy the values from.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 src]
   (phaser->clj
    (.copy matrix-4
           (clj->phaser src)))))

(defn determinant
  "Calculate the determinant of this Matrix.

  Returns:  number - The determinant of this Matrix."
  ([matrix-4]
   (phaser->clj
    (.determinant matrix-4))))

(defn from-array
  "Set the values of this Matrix from the given array.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * a (array) - The array to copy the values from.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 a]
   (phaser->clj
    (.fromArray matrix-4
                (clj->phaser a)))))

(defn from-quat
  "Set the values of this Matrix from the given Quaternion.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * q (Phaser.Math.Quaternion) - The Quaternion to set the values of this Matrix from.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 q]
   (phaser->clj
    (.fromQuat matrix-4
               (clj->phaser q)))))

(defn from-rotation-translation
  "Set the values of this Matrix from the given rotation Quaternion and translation Vector.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * q (Phaser.Math.Quaternion) - The Quaternion to set rotation from.
    * v (Phaser.Math.Vector3) - The Vector to set translation from.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 q v]
   (phaser->clj
    (.fromRotationTranslation matrix-4
                              (clj->phaser q)
                              (clj->phaser v)))))

(defn frustum
  "Generate a frustum matrix with the given bounds.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * left (number) - The left bound of the frustum.
    * right (number) - The right bound of the frustum.
    * bottom (number) - The bottom bound of the frustum.
    * top (number) - The top bound of the frustum.
    * near (number) - The near bound of the frustum.
    * far (number) - The far bound of the frustum.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 left right bottom top near far]
   (phaser->clj
    (.frustum matrix-4
              (clj->phaser left)
              (clj->phaser right)
              (clj->phaser bottom)
              (clj->phaser top)
              (clj->phaser near)
              (clj->phaser far)))))

(defn identity
  "Reset this Matrix to an identity (default) matrix.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4]
   (phaser->clj
    (.identity matrix-4))))

(defn invert
  "Invert this Matrix.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4]
   (phaser->clj
    (.invert matrix-4))))

(defn look-at
  "Generate a look-at matrix with the given eye position, focal point, and up axis.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * eye (Phaser.Math.Vector3) - Position of the viewer
    * center (Phaser.Math.Vector3) - Point the viewer is looking at
    * up (Phaser.Math.Vector3) - vec3 pointing up.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 eye center up]
   (phaser->clj
    (.lookAt matrix-4
             (clj->phaser eye)
             (clj->phaser center)
             (clj->phaser up)))))

(defn make-rotation-axis
  "Derive a rotation matrix around the given axis.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * axis (Phaser.Math.Vector3 | Phaser.Math.Vector4) - The rotation axis.
    * angle (number) - The rotation angle in radians.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 axis angle]
   (phaser->clj
    (.makeRotationAxis matrix-4
                       (clj->phaser axis)
                       (clj->phaser angle)))))

(defn multiply
  "Multiply this Matrix by the given Matrix.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * src (Phaser.Math.Matrix4) - The Matrix to multiply this Matrix by.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 src]
   (phaser->clj
    (.multiply matrix-4
               (clj->phaser src)))))

(defn multiply-local
  "[description]

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * src (Phaser.Math.Matrix4) - [description]

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 src]
   (phaser->clj
    (.multiplyLocal matrix-4
                    (clj->phaser src)))))

(defn ortho
  "Generate an orthogonal projection matrix with the given bounds.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * left (number) - The left bound of the frustum.
    * right (number) - The right bound of the frustum.
    * bottom (number) - The bottom bound of the frustum.
    * top (number) - The top bound of the frustum.
    * near (number) - The near bound of the frustum.
    * far (number) - The far bound of the frustum.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 left right bottom top near far]
   (phaser->clj
    (.ortho matrix-4
            (clj->phaser left)
            (clj->phaser right)
            (clj->phaser bottom)
            (clj->phaser top)
            (clj->phaser near)
            (clj->phaser far)))))

(defn perspective
  "Generate a perspective projection matrix with the given bounds.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * fovy (number) - Vertical field of view in radians
    * aspect (number) - Aspect ratio. Typically viewport width  /height.
    * near (number) - Near bound of the frustum.
    * far (number) - Far bound of the frustum.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 fovy aspect near far]
   (phaser->clj
    (.perspective matrix-4
                  (clj->phaser fovy)
                  (clj->phaser aspect)
                  (clj->phaser near)
                  (clj->phaser far)))))

(defn perspective-lh
  "Generate a perspective projection matrix with the given bounds.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * width (number) - The width of the frustum.
    * height (number) - The height of the frustum.
    * near (number) - Near bound of the frustum.
    * far (number) - Far bound of the frustum.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 width height near far]
   (phaser->clj
    (.perspectiveLH matrix-4
                    (clj->phaser width)
                    (clj->phaser height)
                    (clj->phaser near)
                    (clj->phaser far)))))

(defn rotate
  "Apply a rotation transformation to this Matrix.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * rad (number) - The angle in radians to rotate by.
    * axis (Phaser.Math.Vector3) - The axis to rotate upon.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 rad axis]
   (phaser->clj
    (.rotate matrix-4
             (clj->phaser rad)
             (clj->phaser axis)))))

(defn rotate-x
  "Rotate this matrix on its X axis.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * rad (number) - The angle in radians to rotate by.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 rad]
   (phaser->clj
    (.rotateX matrix-4
              (clj->phaser rad)))))

(defn rotate-y
  "Rotate this matrix on its Y axis.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * rad (number) - The angle to rotate by, in radians.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 rad]
   (phaser->clj
    (.rotateY matrix-4
              (clj->phaser rad)))))

(defn rotate-z
  "Rotate this matrix on its Z axis.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * rad (number) - The angle to rotate by, in radians.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 rad]
   (phaser->clj
    (.rotateZ matrix-4
              (clj->phaser rad)))))

(defn scale
  "Apply a scale transformation to this Matrix.

  Uses the `x`, `y` and `z` components of the given Vector to scale the Matrix.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * v (Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to scale this Matrix with.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 v]
   (phaser->clj
    (.scale matrix-4
            (clj->phaser v)))))

(defn scale-xyz
  "Apply a scale transformation to this Matrix.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * x (number) - The x component.
    * y (number) - The y component.
    * z (number) - The z component.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 x y z]
   (phaser->clj
    (.scaleXYZ matrix-4
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser z)))))

(defn scaling
  "Set the scaling values of this Matrix.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * x (number) - The x scaling value.
    * y (number) - The y scaling value.
    * z (number) - The z scaling value.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 x y z]
   (phaser->clj
    (.scaling matrix-4
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser z)))))

(defn set
  "This method is an alias for `Matrix4.copy`.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * src (Phaser.Math.Matrix4) - The Matrix to set the values of this Matrix's from.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 src]
   (phaser->clj
    (.set matrix-4
          (clj->phaser src)))))

(defn set-world-matrix
  "Generate a world matrix from the given rotation, position, scale, view matrix and projection matrix.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * rotation (Phaser.Math.Vector3) - The rotation of the world matrix.
    * position (Phaser.Math.Vector3) - The position of the world matrix.
    * scale (Phaser.Math.Vector3) - The scale of the world matrix.
    * view-matrix (Phaser.Math.Matrix4) {optional} - The view matrix.
    * projection-matrix (Phaser.Math.Matrix4) {optional} - The projection matrix.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 rotation position scale]
   (phaser->clj
    (.setWorldMatrix matrix-4
                     (clj->phaser rotation)
                     (clj->phaser position)
                     (clj->phaser scale))))
  ([matrix-4 rotation position scale view-matrix]
   (phaser->clj
    (.setWorldMatrix matrix-4
                     (clj->phaser rotation)
                     (clj->phaser position)
                     (clj->phaser scale)
                     (clj->phaser view-matrix))))
  ([matrix-4 rotation position scale view-matrix projection-matrix]
   (phaser->clj
    (.setWorldMatrix matrix-4
                     (clj->phaser rotation)
                     (clj->phaser position)
                     (clj->phaser scale)
                     (clj->phaser view-matrix)
                     (clj->phaser projection-matrix)))))

(defn translate
  "Translate this Matrix using the given Vector.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * v (Phaser.Math.Vector3 | Phaser.Math.Vector4) - The Vector to translate this Matrix with.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 v]
   (phaser->clj
    (.translate matrix-4
                (clj->phaser v)))))

(defn translate-xyz
  "Translate this Matrix using the given values.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * x (number) - The x component.
    * y (number) - The y component.
    * z (number) - The z component.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 x y z]
   (phaser->clj
    (.translateXYZ matrix-4
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser z)))))

(defn transpose
  "Transpose this Matrix.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4]
   (phaser->clj
    (.transpose matrix-4))))

(defn xyz
  "Set the `x`, `y` and `z` values of this Matrix.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * x (number) - The x value.
    * y (number) - The y value.
    * z (number) - The z value.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 x y z]
   (phaser->clj
    (.xyz matrix-4
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser z)))))

(defn yaw-pitch-roll
  "Set the values of this matrix from the given `yaw`, `pitch` and `roll` values.

  Parameters:
    * matrix-4 (Phaser.Math.Matrix4) - Targeted instance for method
    * yaw (number) - [description]
    * pitch (number) - [description]
    * roll (number) - [description]

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4 yaw pitch roll]
   (phaser->clj
    (.yawPitchRoll matrix-4
                   (clj->phaser yaw)
                   (clj->phaser pitch)
                   (clj->phaser roll)))))

(defn zero
  "Reset this Matrix.

  Sets all values to `0`.

  Returns:  Phaser.Math.Matrix4 - This Matrix4."
  ([matrix-4]
   (phaser->clj
    (.zero matrix-4))))