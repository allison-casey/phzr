(ns phzr.game-objects.components.transform-matrix
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->TransformMatrix
  "  Parameters:
    * a (number) {optional} - The Scale X value.
    * b (number) {optional} - The Skew Y value.
    * c (number) {optional} - The Skew X value.
    * d (number) {optional} - The Scale Y value.
    * tx (number) {optional} - The Translate X value.
    * ty (number) {optional} - The Translate Y value."
  ([]
   (js/Phaser.GameObjects.Components.TransformMatrix.))
  ([a]
   (js/Phaser.GameObjects.Components.TransformMatrix. (clj->phaser a)))
  ([a b]
   (js/Phaser.GameObjects.Components.TransformMatrix. (clj->phaser a)
                                                      (clj->phaser b)))
  ([a b c]
   (js/Phaser.GameObjects.Components.TransformMatrix. (clj->phaser a)
                                                      (clj->phaser b)
                                                      (clj->phaser c)))
  ([a b c d]
   (js/Phaser.GameObjects.Components.TransformMatrix. (clj->phaser a)
                                                      (clj->phaser b)
                                                      (clj->phaser c)
                                                      (clj->phaser d)))
  ([a b c d tx]
   (js/Phaser.GameObjects.Components.TransformMatrix. (clj->phaser a)
                                                      (clj->phaser b)
                                                      (clj->phaser c)
                                                      (clj->phaser d)
                                                      (clj->phaser tx)))
  ([a b c d tx ty]
   (js/Phaser.GameObjects.Components.TransformMatrix. (clj->phaser a)
                                                      (clj->phaser b)
                                                      (clj->phaser c)
                                                      (clj->phaser d)
                                                      (clj->phaser tx)
                                                      (clj->phaser ty))))

(defn apply-inverse
  "Takes the `x` and `y` values and returns a new position in the `output` vector that is the inverse of
  the current matrix with its transformation applied.

  Can be used to translate points from world to local space.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * x (number) - The x position to translate.
    * y (number) - The y position to translate.
    * output (Phaser.Math.Vector2) {optional} - A Vector2, or point-like object, to store the results in.

  Returns:  Phaser.Math.Vector2 - The coordinates, inverse-transformed through this matrix."
  ([transform-matrix x y]
   (phaser->clj
    (.applyInverse transform-matrix
                   (clj->phaser x)
                   (clj->phaser y))))
  ([transform-matrix x y output]
   (phaser->clj
    (.applyInverse transform-matrix
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser output)))))

(defn apply-itrs
  "Apply the identity, translate, rotate and scale operations on the Matrix.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * x (number) - The horizontal translation.
    * y (number) - The vertical translation.
    * rotation (number) - The angle of rotation in radians.
    * scale-x (number) - The horizontal scale.
    * scale-y (number) - The vertical scale.

  Returns:  this - This TransformMatrix."
  ([transform-matrix x y rotation scale-x scale-y]
   (phaser->clj
    (.applyITRS transform-matrix
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser rotation)
                (clj->phaser scale-x)
                (clj->phaser scale-y)))))

(defn copy-from
  "Set the values of this Matrix to copy those of the matrix given.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * src (Phaser.GameObjects.Components.TransformMatrix) - The source Matrix to copy from.

  Returns:  this - This TransformMatrix."
  ([transform-matrix src]
   (phaser->clj
    (.copyFrom transform-matrix
               (clj->phaser src)))))

(defn copy-from-array
  "Set the values of this Matrix to copy those of the array given.
  Where array indexes 0, 1, 2, 3, 4 and 5 are mapped to a, b, c, d, e and f.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * src (array) - The array of values to set into this matrix.

  Returns:  this - This TransformMatrix."
  ([transform-matrix src]
   (phaser->clj
    (.copyFromArray transform-matrix
                    (clj->phaser src)))))

(defn copy-to-array
  "Copy the values in this Matrix to the array given.

  Where array indexes 0, 1, 2, 3, 4 and 5 are mapped to a, b, c, d, e and f.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * out (array) {optional} - The array to copy the matrix values in to.

  Returns:  array - An array where elements 0 to 5 contain the values from this matrix."
  ([transform-matrix]
   (phaser->clj
    (.copyToArray transform-matrix)))
  ([transform-matrix out]
   (phaser->clj
    (.copyToArray transform-matrix
                  (clj->phaser out)))))

(defn copy-to-context
  "Copy the values from this Matrix to the given Canvas Rendering Context.
  This will use the Context.transform method.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * ctx (CanvasRenderingContext2D) - The Canvas Rendering Context to copy the matrix values to.

  Returns:  CanvasRenderingContext2D - The Canvas Rendering Context."
  ([transform-matrix ctx]
   (phaser->clj
    (.copyToContext transform-matrix
                    (clj->phaser ctx)))))

(defn decompose-matrix
  "Decompose this Matrix into its translation, scale and rotation values using QR decomposition.

  The result must be applied in the following order to reproduce the current matrix:

  translate -> rotate -> scale

  Returns:  object - The decomposed Matrix."
  ([transform-matrix]
   (phaser->clj
    (.decomposeMatrix transform-matrix))))

(defn destroy
  "Destroys this Transform Matrix."
  ([transform-matrix]
   (phaser->clj
    (.destroy transform-matrix))))

(defn get-css-matrix
  "Returns a string that can be used in a CSS Transform call as a `matrix` property.

  Returns:  string - A string containing the CSS Transform matrix values."
  ([transform-matrix]
   (phaser->clj
    (.getCSSMatrix transform-matrix))))

(defn get-x
  "Returns the X component of this matrix multiplied by the given values.
  This is the same as `x * a + y * c + e`.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * x (number) - The x value.
    * y (number) - The y value.

  Returns:  number - The calculated x value."
  ([transform-matrix x y]
   (phaser->clj
    (.getX transform-matrix
           (clj->phaser x)
           (clj->phaser y)))))

(defn get-y
  "Returns the Y component of this matrix multiplied by the given values.
  This is the same as `x * b + y * d + f`.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * x (number) - The x value.
    * y (number) - The y value.

  Returns:  number - The calculated y value."
  ([transform-matrix x y]
   (phaser->clj
    (.getY transform-matrix
           (clj->phaser x)
           (clj->phaser y)))))

(defn invert
  "Invert the Matrix.

  Returns:  this - This TransformMatrix."
  ([transform-matrix]
   (phaser->clj
    (.invert transform-matrix))))

(defn load-identity
  "Reset the Matrix to an identity matrix.

  Returns:  this - This TransformMatrix."
  ([transform-matrix]
   (phaser->clj
    (.loadIdentity transform-matrix))))

(defn multiply
  "Multiply this Matrix by the given Matrix.

  If an `out` Matrix is given then the results will be stored in it.
  If it is not given, this matrix will be updated in place instead.
  Use an `out` Matrix if you do not wish to mutate this matrix.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * rhs (Phaser.GameObjects.Components.TransformMatrix) - The Matrix to multiply by.
    * out (Phaser.GameObjects.Components.TransformMatrix) {optional} - An optional Matrix to store the results in.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - Either this TransformMatrix, or the `out` Matrix, if given in the arguments."
  ([transform-matrix rhs]
   (phaser->clj
    (.multiply transform-matrix
               (clj->phaser rhs))))
  ([transform-matrix rhs out]
   (phaser->clj
    (.multiply transform-matrix
               (clj->phaser rhs)
               (clj->phaser out)))))

(defn multiply-with-offset
  "Multiply this Matrix by the matrix given, including the offset.

  The offsetX is added to the tx value: `offsetX * a + offsetY * c + tx`.
  The offsetY is added to the ty value: `offsetY * b + offsetY * d + ty`.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * src (Phaser.GameObjects.Components.TransformMatrix) - The source Matrix to copy from.
    * offset-x (number) - Horizontal offset to factor in to the multiplication.
    * offset-y (number) - Vertical offset to factor in to the multiplication.

  Returns:  this - This TransformMatrix."
  ([transform-matrix src offset-x offset-y]
   (phaser->clj
    (.multiplyWithOffset transform-matrix
                         (clj->phaser src)
                         (clj->phaser offset-x)
                         (clj->phaser offset-y)))))

(defn rotate
  "Rotate the Matrix.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * angle (number) - The angle of rotation in radians.

  Returns:  this - This TransformMatrix."
  ([transform-matrix angle]
   (phaser->clj
    (.rotate transform-matrix
             (clj->phaser angle)))))

(defn scale
  "Scale the Matrix.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * x (number) - The horizontal scale value.
    * y (number) - The vertical scale value.

  Returns:  this - This TransformMatrix."
  ([transform-matrix x y]
   (phaser->clj
    (.scale transform-matrix
            (clj->phaser x)
            (clj->phaser y)))))

(defn set-to-context
  "Copy the values from this Matrix to the given Canvas Rendering Context.
  This will use the Context.setTransform method.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * ctx (CanvasRenderingContext2D) - The Canvas Rendering Context to copy the matrix values to.

  Returns:  CanvasRenderingContext2D - The Canvas Rendering Context."
  ([transform-matrix ctx]
   (phaser->clj
    (.setToContext transform-matrix
                   (clj->phaser ctx)))))

(defn set-transform
  "Set the values of this Matrix.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * a (number) - The Scale X value.
    * b (number) - The Shear Y value.
    * c (number) - The Shear X value.
    * d (number) - The Scale Y value.
    * tx (number) - The Translate X value.
    * ty (number) - The Translate Y value.

  Returns:  this - This TransformMatrix."
  ([transform-matrix a b c d tx ty]
   (phaser->clj
    (.setTransform transform-matrix
                   (clj->phaser a)
                   (clj->phaser b)
                   (clj->phaser c)
                   (clj->phaser d)
                   (clj->phaser tx)
                   (clj->phaser ty)))))

(defn transform
  "Transform the Matrix.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * a (number) - The Scale X value.
    * b (number) - The Shear Y value.
    * c (number) - The Shear X value.
    * d (number) - The Scale Y value.
    * tx (number) - The Translate X value.
    * ty (number) - The Translate Y value.

  Returns:  this - This TransformMatrix."
  ([transform-matrix a b c d tx ty]
   (phaser->clj
    (.transform transform-matrix
                (clj->phaser a)
                (clj->phaser b)
                (clj->phaser c)
                (clj->phaser d)
                (clj->phaser tx)
                (clj->phaser ty)))))

(defn transform-point
  "Transform a point using this Matrix.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * x (number) - The x coordinate of the point to transform.
    * y (number) - The y coordinate of the point to transform.
    * point (Phaser.Geom.Point | Phaser.Math.Vector2 | object) - The Point object to store the transformed coordinates.

  Returns:  Phaser.Geom.Point | Phaser.Math.Vector2 | object - The Point containing the transformed coordinates."
  ([transform-matrix x y point]
   (phaser->clj
    (.transformPoint transform-matrix
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser point)))))

(defn translate
  "Translate the Matrix.

  Parameters:
    * transform-matrix (Phaser.GameObjects.Components.TransformMatrix) - Targeted instance for method
    * x (number) - The horizontal translation value.
    * y (number) - The vertical translation value.

  Returns:  this - This TransformMatrix."
  ([transform-matrix x y]
   (phaser->clj
    (.translate transform-matrix
                (clj->phaser x)
                (clj->phaser y)))))