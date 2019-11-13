(ns phzr.input.pointer
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Pointer
  "  Parameters:
    * manager (Phaser.Input.InputManager) - A reference to the Input Manager.
    * id (integer) - The internal ID of this Pointer."
  ([manager id]
   (js/Phaser.Input.Pointer. (clj->phaser manager)
                             (clj->phaser id))))

(defn back-button-down
  "Checks to see if the back button is being held down on this Pointer.

  Returns:  boolean - `true` if the back button is being held down."
  ([pointer]
   (phaser->clj
    (.backButtonDown pointer))))

(defn back-button-released
  "Checks to see if the back button was just released on this Pointer.

  Returns:  boolean - `true` if the back button was just released."
  ([pointer]
   (phaser->clj
    (.backButtonReleased pointer))))

(defn destroy
  "Destroys this Pointer instance and resets its external references."
  ([pointer]
   (phaser->clj
    (.destroy pointer))))

(defn forward-button-down
  "Checks to see if the forward button is being held down on this Pointer.

  Returns:  boolean - `true` if the forward button is being held down."
  ([pointer]
   (phaser->clj
    (.forwardButtonDown pointer))))

(defn forward-button-released
  "Checks to see if the forward button was just released on this Pointer.

  Returns:  boolean - `true` if the forward button was just released."
  ([pointer]
   (phaser->clj
    (.forwardButtonReleased pointer))))

(defn get-angle
  "If the Pointer has a button pressed down at the time this method is called, it will return the
  angle between the Pointer's `downX` and `downY` values and the current position.

  If no button is held down, it will return the last recorded angle, based on where
  the Pointer was when the button was released.

  The angle is based on the old position facing to the current position.

  If you wish to get the current angle, based on the velocity of the Pointer, then
  see the `Pointer.angle` property.

  Returns:  number - The angle between the Pointer's coordinates in radians."
  ([pointer]
   (phaser->clj
    (.getAngle pointer))))

(defn get-distance
  "If the Pointer has a button pressed down at the time this method is called, it will return the
  distance between the Pointer's `downX` and `downY` values and the current position.

  If no button is held down, it will return the last recorded distance, based on where
  the Pointer was when the button was released.

  If you wish to get the distance being travelled currently, based on the velocity of the Pointer,
  then see the `Pointer.distance` property.

  Returns:  number - The distance the Pointer moved."
  ([pointer]
   (phaser->clj
    (.getDistance pointer))))

(defn get-distance-x
  "If the Pointer has a button pressed down at the time this method is called, it will return the
  horizontal distance between the Pointer's `downX` and `downY` values and the current position.

  If no button is held down, it will return the last recorded horizontal distance, based on where
  the Pointer was when the button was released.

  Returns:  number - The horizontal distance the Pointer moved."
  ([pointer]
   (phaser->clj
    (.getDistanceX pointer))))

(defn get-distance-y
  "If the Pointer has a button pressed down at the time this method is called, it will return the
  vertical distance between the Pointer's `downX` and `downY` values and the current position.

  If no button is held down, it will return the last recorded vertical distance, based on where
  the Pointer was when the button was released.

  Returns:  number - The vertical distance the Pointer moved."
  ([pointer]
   (phaser->clj
    (.getDistanceY pointer))))

(defn get-duration
  "If the Pointer has a button pressed down at the time this method is called, it will return the
  duration since the button was pressed down.

  If no button is held down, it will return the last recorded duration, based on the time
  the Pointer button was released.

  Returns:  number - The duration the Pointer was held down for in milliseconds."
  ([pointer]
   (phaser->clj
    (.getDuration pointer))))

(defn get-interpolated-position
  "Takes the previous and current Pointer positions and then generates an array of interpolated values between
  the two. The array will be populated up to the size of the `steps` argument.

  ```javaScript
  var points = pointer.getInterpolatedPosition(4);

  // points[0] = { x: 0, y: 0 }
  // points[1] = { x: 2, y: 1 }
  // points[2] = { x: 3, y: 2 }
  // points[3] = { x: 6, y: 3 }
  ```

  Use this if you need to get smoothed values between the previous and current pointer positions. DOM pointer
  events can often fire faster than the main browser loop, and this will help you avoid janky movement
  especially if you have an object following a Pointer.

  Note that if you provide an output array it will only be populated up to the number of steps provided.
  It will not clear any previous data that may have existed beyond the range of the steps count.

  Internally it uses the Smooth Step interpolation calculation.

  Parameters:
    * pointer (Phaser.Input.Pointer) - Targeted instance for method
    * steps (integer) {optional} - The number of interpolation steps to use.
    * out (array) {optional} - An array to store the results in. If not provided a new one will be created.

  Returns:  array - An array of interpolated values."
  ([pointer]
   (phaser->clj
    (.getInterpolatedPosition pointer)))
  ([pointer steps]
   (phaser->clj
    (.getInterpolatedPosition pointer
                              (clj->phaser steps))))
  ([pointer steps out]
   (phaser->clj
    (.getInterpolatedPosition pointer
                              (clj->phaser steps)
                              (clj->phaser out)))))

(defn left-button-down
  "Checks to see if the left button is being held down on this Pointer.

  Returns:  boolean - `true` if the left button is being held down."
  ([pointer]
   (phaser->clj
    (.leftButtonDown pointer))))

(defn left-button-released
  "Checks to see if the left button was just released on this Pointer.

  Returns:  boolean - `true` if the left button was just released."
  ([pointer]
   (phaser->clj
    (.leftButtonReleased pointer))))

(defn middle-button-down
  "Checks to see if the middle button is being held down on this Pointer.

  Returns:  boolean - `true` if the middle button is being held down."
  ([pointer]
   (phaser->clj
    (.middleButtonDown pointer))))

(defn middle-button-released
  "Checks to see if the middle button was just released on this Pointer.

  Returns:  boolean - `true` if the middle button was just released."
  ([pointer]
   (phaser->clj
    (.middleButtonReleased pointer))))

(defn no-button-down
  "Checks to see if any buttons are being held down on this Pointer.

  Returns:  boolean - `true` if no buttons are being held down."
  ([pointer]
   (phaser->clj
    (.noButtonDown pointer))))

(defn position-to-camera
  "Takes a Camera and returns a Vector2 containing the translated position of this Pointer
  within that Camera. This can be used to convert this Pointers position into camera space.

  Parameters:
    * pointer (Phaser.Input.Pointer) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to use for the translation.
    * output (Phaser.Math.Vector2 | object) {optional} - A Vector2-like object in which to store the translated position.

  Returns:  Phaser.Math.Vector2 | object - A Vector2 containing the translated coordinates of this Pointer, based on the given camera."
  ([pointer camera]
   (phaser->clj
    (.positionToCamera pointer
                       (clj->phaser camera))))
  ([pointer camera output]
   (phaser->clj
    (.positionToCamera pointer
                       (clj->phaser camera)
                       (clj->phaser output)))))

(defn right-button-down
  "Checks to see if the right button is being held down on this Pointer.

  Returns:  boolean - `true` if the right button is being held down."
  ([pointer]
   (phaser->clj
    (.rightButtonDown pointer))))

(defn right-button-released
  "Checks to see if the right button was just released on this Pointer.

  Returns:  boolean - `true` if the right button was just released."
  ([pointer]
   (phaser->clj
    (.rightButtonReleased pointer))))

(defn update-world-point
  "Takes a Camera and updates this Pointer's `worldX` and `worldY` values so they are
  the result of a translation through the given Camera.

  Note that the values will be automatically replaced the moment the Pointer is
  updated by an input event, such as a mouse move, so should be used immediately.

  Parameters:
    * pointer (Phaser.Input.Pointer) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera which is being tested against.

  Returns:  this - This Pointer object."
  ([pointer camera]
   (phaser->clj
    (.updateWorldPoint pointer
                       (clj->phaser camera)))))