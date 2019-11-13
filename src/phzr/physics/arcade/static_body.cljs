(ns phzr.physics.arcade.static-body
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->StaticBody
  "  Parameters:
    * world (Phaser.Physics.Arcade.World) - The Arcade Physics simulation this Static Body belongs to.
    * game-object (Phaser.GameObjects.GameObject) - The Game Object this Static Body belongs to."
  ([world game-object]
   (js/Phaser.Physics.Arcade.StaticBody. (clj->phaser world)
                                         (clj->phaser game-object))))

(defn delta-abs-x
  "The absolute (non-negative) change in this StaticBody's horizontal position from the previous step. Always zero.

  Returns:  number - Always zero for a Static Body."
  ([static-body]
   (phaser->clj
    (.deltaAbsX static-body))))

(defn delta-abs-y
  "The absolute (non-negative) change in this StaticBody's vertical position from the previous step. Always zero.

  Returns:  number - Always zero for a Static Body."
  ([static-body]
   (phaser->clj
    (.deltaAbsY static-body))))

(defn delta-x
  "The change in this StaticBody's horizontal position from the previous step. Always zero.

  Returns:  number - The change in this StaticBody's velocity from the previous step. Always zero."
  ([static-body]
   (phaser->clj
    (.deltaX static-body))))

(defn delta-y
  "The change in this StaticBody's vertical position from the previous step. Always zero.

  Returns:  number - The change in this StaticBody's velocity from the previous step. Always zero."
  ([static-body]
   (phaser->clj
    (.deltaY static-body))))

(defn delta-z
  "The change in this StaticBody's rotation from the previous step. Always zero.

  Returns:  number - The change in this StaticBody's rotation from the previous step. Always zero."
  ([static-body]
   (phaser->clj
    (.deltaZ static-body))))

(defn destroy
  "Disables this Body and marks it for destruction during the next step."
  ([static-body]
   (phaser->clj
    (.destroy static-body))))

(defn draw-debug
  "Draws a graphical representation of the StaticBody for visual debugging purposes.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * graphic (Phaser.GameObjects.Graphics) - The Graphics object to use for the debug drawing of the StaticBody."
  ([static-body graphic]
   (phaser->clj
    (.drawDebug static-body
                (clj->phaser graphic)))))

(defn get-bounds
  "Returns the x and y coordinates of the top left and bottom right points of the StaticBody.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * obj (Phaser.Types.Physics.Arcade.ArcadeBodyBounds) - The object which will hold the coordinates of the bounds.

  Returns:  Phaser.Types.Physics.Arcade.ArcadeBodyBounds - The same object that was passed with `x`, `y`, `right` and `bottom` values matching the respective values of the StaticBody."
  ([static-body obj]
   (phaser->clj
    (.getBounds static-body
                (clj->phaser obj)))))

(defn hit-test
  "Checks to see if a given x,y coordinate is colliding with this Static Body.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * x (number) - The x coordinate to check against this body.
    * y (number) - The y coordinate to check against this body.

  Returns:  boolean - `true` if the given coordinate lies within this body, otherwise `false`."
  ([static-body x y]
   (phaser->clj
    (.hitTest static-body
              (clj->phaser x)
              (clj->phaser y)))))

(defn post-update
  "NOOP"
  ([static-body]
   (phaser->clj
    (.postUpdate static-body))))

(defn reset
  "Resets this Body to the given coordinates. Also positions its parent Game Object to the same coordinates.
  Similar to `updateFromGameObject`, but doesn't modify the Body's dimensions.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * x (number) {optional} - The x coordinate to reset the body to. If not given will use the parent Game Object's coordinate.
    * y (number) {optional} - The y coordinate to reset the body to. If not given will use the parent Game Object's coordinate."
  ([static-body]
   (phaser->clj
    (.reset static-body)))
  ([static-body x]
   (phaser->clj
    (.reset static-body
            (clj->phaser x))))
  ([static-body x y]
   (phaser->clj
    (.reset static-body
            (clj->phaser x)
            (clj->phaser y)))))

(defn set-circle
  "Sets this Static Body to have a circular body and sets its sizes and position.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * radius (number) - The radius of the StaticBody, in pixels.
    * offset-x (number) {optional} - The horizontal offset of the StaticBody from its Game Object, in pixels.
    * offset-y (number) {optional} - The vertical offset of the StaticBody from its Game Object, in pixels.

  Returns:  Phaser.Physics.Arcade.StaticBody - This Static Body object."
  ([static-body radius]
   (phaser->clj
    (.setCircle static-body
                (clj->phaser radius))))
  ([static-body radius offset-x]
   (phaser->clj
    (.setCircle static-body
                (clj->phaser radius)
                (clj->phaser offset-x))))
  ([static-body radius offset-x offset-y]
   (phaser->clj
    (.setCircle static-body
                (clj->phaser radius)
                (clj->phaser offset-x)
                (clj->phaser offset-y)))))

(defn set-game-object
  "Changes the Game Object this Body is bound to.
  First it removes its reference from the old Game Object, then sets the new one.
  You can optionally update the position and dimensions of this Body to reflect that of the new Game Object.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The new Game Object that will own this Body.
    * update (boolean) {optional} - Reposition and resize this Body to match the new Game Object?

  Returns:  Phaser.Physics.Arcade.StaticBody - This Static Body object."
  ([static-body game-object]
   (phaser->clj
    (.setGameObject static-body
                    (clj->phaser game-object))))
  ([static-body game-object update]
   (phaser->clj
    (.setGameObject static-body
                    (clj->phaser game-object)
                    (clj->phaser update)))))

(defn set-mass
  "Sets the Mass of the StaticBody. Will set the Mass to 0.1 if the value passed is less than or equal to zero.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * value (number) - The value to set the Mass to. Values of zero or less are changed to 0.1.

  Returns:  Phaser.Physics.Arcade.StaticBody - This Static Body object."
  ([static-body value]
   (phaser->clj
    (.setMass static-body
              (clj->phaser value)))))

(defn set-offset
  "Sets the offset of the body.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * x (number) - The horizontal offset of the Body from the Game Object's center.
    * y (number) - The vertical offset of the Body from the Game Object's center.

  Returns:  Phaser.Physics.Arcade.StaticBody - This Static Body object."
  ([static-body x y]
   (phaser->clj
    (.setOffset static-body
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-size
  "Sets the size of the body.
  Resets the width and height to match current frame, if no width and height provided and a frame is found.

  Parameters:
    * static-body (Phaser.Physics.Arcade.StaticBody) - Targeted instance for method
    * width (integer) {optional} - The width of the Body in pixels. Cannot be zero. If not given, and the parent Game Object has a frame, it will use the frame width.
    * height (integer) {optional} - The height of the Body in pixels. Cannot be zero. If not given, and the parent Game Object has a frame, it will use the frame height.
    * center (boolean) {optional} - Modify the Body's `offset`, placing the Body's center on its Game Object's center. Only works if the Game Object has the `getCenter` method.

  Returns:  Phaser.Physics.Arcade.StaticBody - This Static Body object."
  ([static-body]
   (phaser->clj
    (.setSize static-body)))
  ([static-body width]
   (phaser->clj
    (.setSize static-body
              (clj->phaser width))))
  ([static-body width height]
   (phaser->clj
    (.setSize static-body
              (clj->phaser width)
              (clj->phaser height))))
  ([static-body width height center]
   (phaser->clj
    (.setSize static-body
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser center)))))

(defn stop
  "NOOP function. A Static Body cannot be stopped.

  Returns:  Phaser.Physics.Arcade.StaticBody - This Static Body object."
  ([static-body]
   (phaser->clj
    (.stop static-body))))

(defn update-center
  "Updates the StaticBody's `center` from its `position` and dimensions."
  ([static-body]
   (phaser->clj
    (.updateCenter static-body))))

(defn update-from-game-object
  "Updates this Static Body so that its position and dimensions are updated
  based on the current Game Object it is bound to.

  Returns:  Phaser.Physics.Arcade.StaticBody - This Static Body object."
  ([static-body]
   (phaser->clj
    (.updateFromGameObject static-body))))

(defn will-draw-debug
  "Indicates whether the StaticBody is going to be showing a debug visualization during postUpdate.

  Returns:  boolean - Whether or not the StaticBody is going to show the debug visualization during postUpdate."
  ([static-body]
   (phaser->clj
    (.willDrawDebug static-body))))