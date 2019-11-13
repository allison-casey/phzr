(ns phzr.input.input-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->InputManager
  "  Parameters:
    * game (Phaser.Game) - The Game instance that owns the Input Manager.
    * config (object) - The Input Configuration object, as set in the Game Config."
  ([game config]
   (js/Phaser.Input.InputManager. (clj->phaser game)
                                  (clj->phaser config))))

(defn add-pointer
  "Adds new Pointer objects to the Input Manager.

  By default Phaser creates 2 pointer objects: `mousePointer` and `pointer1`.

  You can create more either by calling this method, or by setting the `input.activePointers` property
  in the Game Config, up to a maximum of 10 pointers.

  The first 10 pointers are available via the `InputPlugin.pointerX` properties, once they have been added
  via this method.

  Parameters:
    * input-manager (Phaser.Input.InputManager) - Targeted instance for method
    * quantity (integer) {optional} - The number of new Pointers to create. A maximum of 10 is allowed in total.

  Returns:  Array.<Phaser.Input.Pointer> - An array containing all of the new Pointer objects that were created."
  ([input-manager]
   (phaser->clj
    (.addPointer input-manager)))
  ([input-manager quantity]
   (phaser->clj
    (.addPointer input-manager
                 (clj->phaser quantity)))))

(defn destroy
  "Destroys the Input Manager and all of its systems.

  There is no way to recover from doing this."
  ([input-manager]
   (phaser->clj
    (.destroy input-manager))))

(defn hit-test
  "Performs a hit test using the given Pointer and camera, against an array of interactive Game Objects.

  The Game Objects are culled against the camera, and then the coordinates are translated into the local camera space
  and used to determine if they fall within the remaining Game Objects hit areas or not.

  If nothing is matched an empty array is returned.

  This method is called automatically by InputPlugin.hitTestPointer and doesn't usually need to be invoked directly.

  Parameters:
    * input-manager (Phaser.Input.InputManager) - Targeted instance for method
    * pointer (Phaser.Input.Pointer) - The Pointer to test against.
    * game-objects (array) - An array of interactive Game Objects to check.
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera which is being tested against.
    * output (array) {optional} - An array to store the results in. If not given, a new empty array is created.

  Returns:  array - An array of the Game Objects that were hit during this hit test."
  ([input-manager pointer game-objects camera]
   (phaser->clj
    (.hitTest input-manager
              (clj->phaser pointer)
              (clj->phaser game-objects)
              (clj->phaser camera))))
  ([input-manager pointer game-objects camera output]
   (phaser->clj
    (.hitTest input-manager
              (clj->phaser pointer)
              (clj->phaser game-objects)
              (clj->phaser camera)
              (clj->phaser output)))))

(defn point-within-hit-area
  "Checks if the given x and y coordinate are within the hit area of the Game Object.

  This method assumes that the coordinate values have already been translated into the space of the Game Object.

  If the coordinates are within the hit area they are set into the Game Objects Input `localX` and `localY` properties.

  Parameters:
    * input-manager (Phaser.Input.InputManager) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The interactive Game Object to check against.
    * x (number) - The translated x coordinate for the hit test.
    * y (number) - The translated y coordinate for the hit test.

  Returns:  boolean - `true` if the coordinates were inside the Game Objects hit area, otherwise `false`."
  ([input-manager game-object x y]
   (phaser->clj
    (.pointWithinHitArea input-manager
                         (clj->phaser game-object)
                         (clj->phaser x)
                         (clj->phaser y)))))

(defn point-within-interactive-object
  "Checks if the given x and y coordinate are within the hit area of the Interactive Object.

  This method assumes that the coordinate values have already been translated into the space of the Interactive Object.

  If the coordinates are within the hit area they are set into the Interactive Objects Input `localX` and `localY` properties.

  Parameters:
    * input-manager (Phaser.Input.InputManager) - Targeted instance for method
    * object (Phaser.Types.Input.InteractiveObject) - The Interactive Object to check against.
    * x (number) - The translated x coordinate for the hit test.
    * y (number) - The translated y coordinate for the hit test.

  Returns:  boolean - `true` if the coordinates were inside the Game Objects hit area, otherwise `false`."
  ([input-manager object x y]
   (phaser->clj
    (.pointWithinInteractiveObject input-manager
                                   (clj->phaser object)
                                   (clj->phaser x)
                                   (clj->phaser y)))))

(defn set-default-cursor
  "Tells the Input system to set a custom cursor.

  This cursor will be the default cursor used when interacting with the game canvas.

  If an Interactive Object also sets a custom cursor, this is the cursor that is reset after its use.

  Any valid CSS cursor value is allowed, including paths to image files, i.e.:

  ```javascript
  this.input.setDefaultCursor('url(assets/cursors/sword.cur), pointer');
  ```

  Please read about the differences between browsers when it comes to the file formats and sizes they support:

  https://developer.mozilla.org/en-US/docs/Web/CSS/cursor
  https://developer.mozilla.org/en-US/docs/Web/CSS/CSS_User_Interface/Using_URL_values_for_the_cursor_property

  It's up to you to pick a suitable cursor format that works across the range of browsers you need to support.

  Parameters:
    * input-manager (Phaser.Input.InputManager) - Targeted instance for method
    * cursor (string) - The CSS to be used when setting the default cursor."
  ([input-manager cursor]
   (phaser->clj
    (.setDefaultCursor input-manager
                       (clj->phaser cursor)))))

(defn transform-pointer
  "Transforms the pageX and pageY values of a Pointer into the scaled coordinate space of the Input Manager.

  Parameters:
    * input-manager (Phaser.Input.InputManager) - Targeted instance for method
    * pointer (Phaser.Input.Pointer) - The Pointer to transform the values for.
    * page-x (number) - The Page X value.
    * page-y (number) - The Page Y value.
    * was-move (boolean) - Are we transforming the Pointer from a move event, or an up / down event?"
  ([input-manager pointer page-x page-y was-move]
   (phaser->clj
    (.transformPointer input-manager
                       (clj->phaser pointer)
                       (clj->phaser page-x)
                       (clj->phaser page-y)
                       (clj->phaser was-move)))))

(defn update-input-plugins
  "Internal method that gets a list of all the active Input Plugins in the game
  and updates each of them in turn, in reverse order (top to bottom), to allow
  for DOM top-level event handling simulation.

  Parameters:
    * input-manager (Phaser.Input.InputManager) - Targeted instance for method
    * type (integer) - The type of event to process.
    * pointers (Array.<Phaser.Input.Pointer>) - An array of Pointers on which the event occurred."
  ([input-manager type pointers]
   (phaser->clj
    (.updateInputPlugins input-manager
                         (clj->phaser type)
                         (clj->phaser pointers)))))