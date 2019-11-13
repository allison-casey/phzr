(ns phzr.cameras.scene-2-d.camera-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove]))

(defn ->CameraManager
  "  Parameters:
    * scene (Phaser.Scene) - The Scene that owns the Camera Manager plugin."
  ([scene]
   (js/Phaser.Cameras.Scene2D.CameraManager. (clj->phaser scene))))

(defn add
  "Adds a new Camera into the Camera Manager. The Camera Manager can support up to 31 different Cameras.

  Each Camera has its own viewport, which controls the size of the Camera and its position within the canvas.

  Use the `Camera.scrollX` and `Camera.scrollY` properties to change where the Camera is looking, or the
  Camera methods such as `centerOn`. Cameras also have built in special effects, such as fade, flash, shake,
  pan and zoom.

  By default Cameras are transparent and will render anything that they can see based on their `scrollX`
  and `scrollY` values. Game Objects can be set to be ignored by a Camera by using the `Camera.ignore` method.

  The Camera will have its `roundPixels` property set to whatever `CameraManager.roundPixels` is. You can change
  it after creation if required.

  See the Camera class documentation for more details.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * x (integer) {optional} - The horizontal position of the Camera viewport.
    * y (integer) {optional} - The vertical position of the Camera viewport.
    * width (integer) {optional} - The width of the Camera viewport. If not given it'll be the game config size.
    * height (integer) {optional} - The height of the Camera viewport. If not given it'll be the game config size.
    * make-main (boolean) {optional} - Set this Camera as being the 'main' camera. This just makes the property `main` a reference to it.
    * name (string) {optional} - The name of the Camera.

  Returns:  Phaser.Cameras.Scene2D.Camera - The newly created Camera."
  ([camera-manager]
   (phaser->clj
    (.add camera-manager)))
  ([camera-manager x]
   (phaser->clj
    (.add camera-manager
          (clj->phaser x))))
  ([camera-manager x y]
   (phaser->clj
    (.add camera-manager
          (clj->phaser x)
          (clj->phaser y))))
  ([camera-manager x y width]
   (phaser->clj
    (.add camera-manager
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser width))))
  ([camera-manager x y width height]
   (phaser->clj
    (.add camera-manager
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser width)
          (clj->phaser height))))
  ([camera-manager x y width height make-main]
   (phaser->clj
    (.add camera-manager
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser width)
          (clj->phaser height)
          (clj->phaser make-main))))
  ([camera-manager x y width height make-main name]
   (phaser->clj
    (.add camera-manager
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser width)
          (clj->phaser height)
          (clj->phaser make-main)
          (clj->phaser name)))))

(defn add-existing
  "Adds an existing Camera into the Camera Manager.

  The Camera should either be a `Phaser.Cameras.Scene2D.Camera` instance, or a class that extends from it.

  The Camera will have its `roundPixels` property set to whatever `CameraManager.roundPixels` is. You can change
  it after addition if required.

  The Camera will be assigned an ID, which is used for Game Object exclusion and then added to the
  manager. As long as it doesn't already exist in the manager it will be added then returned.

  If this method returns `null` then the Camera already exists in this Camera Manager.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to be added to the Camera Manager.
    * make-main (boolean) {optional} - Set this Camera as being the 'main' camera. This just makes the property `main` a reference to it.

  Returns:  Phaser.Cameras.Scene2D.Camera - The Camera that was added to the Camera Manager, or `null` if it couldn't be added."
  ([camera-manager camera]
   (phaser->clj
    (.addExisting camera-manager
                  (clj->phaser camera))))
  ([camera-manager camera make-main]
   (phaser->clj
    (.addExisting camera-manager
                  (clj->phaser camera)
                  (clj->phaser make-main)))))

(defn from-json
  "Populates this Camera Manager based on the given configuration object, or an array of config objects.

  See the `Phaser.Types.Cameras.Scene2D.CameraConfig` documentation for details of the object structure.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * config (Phaser.Types.Cameras.Scene2D.CameraConfig | Array.<Phaser.Types.Cameras.Scene2D.CameraConfig>) - A Camera configuration object, or an array of them, to be added to this Camera Manager.

  Returns:  Phaser.Cameras.Scene2D.CameraManager - This Camera Manager instance."
  ([camera-manager config]
   (phaser->clj
    (.fromJSON camera-manager
               (clj->phaser config)))))

(defn get-camera
  "Gets a Camera based on its name.

  Camera names are optional and don't have to be set, so this method is only of any use if you
  have given your Cameras unique names.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * name (string) - The name of the Camera.

  Returns:  Phaser.Cameras.Scene2D.Camera - The first Camera with a name matching the given string, otherwise `null`."
  ([camera-manager name]
   (phaser->clj
    (.getCamera camera-manager
                (clj->phaser name)))))

(defn get-cameras-below-pointer
  "Returns an array of all cameras below the given Pointer.

  The first camera in the array is the top-most camera in the camera list.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * pointer (Phaser.Input.Pointer) - The Pointer to check against.

  Returns:  Array.<Phaser.Cameras.Scene2D.Camera> - An array of cameras below the Pointer."
  ([camera-manager pointer]
   (phaser->clj
    (.getCamerasBelowPointer camera-manager
                             (clj->phaser pointer)))))

(defn get-total
  "Gets the total number of Cameras in this Camera Manager.

  If the optional `isVisible` argument is set it will only count Cameras that are currently visible.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * is-visible (boolean) {optional} - Set the `true` to only include visible Cameras in the total.

  Returns:  integer - The total number of Cameras in this Camera Manager."
  ([camera-manager]
   (phaser->clj
    (.getTotal camera-manager)))
  ([camera-manager is-visible]
   (phaser->clj
    (.getTotal camera-manager
               (clj->phaser is-visible)))))

(defn on-resize
  "The event handler that manages the `resize` event dispatched by the Scale Manager.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * game-size (Phaser.Structs.Size) - The default Game Size object. This is the un-modified game dimensions.
    * base-size (Phaser.Structs.Size) - The base Size object. The game dimensions multiplied by the resolution. The canvas width / height values match this."
  ([camera-manager game-size base-size]
   (phaser->clj
    (.onResize camera-manager
               (clj->phaser game-size)
               (clj->phaser base-size)))))

(defn remove
  "Removes the given Camera, or an array of Cameras, from this Camera Manager.

  If found in the Camera Manager it will be immediately removed from the local cameras array.
  If also currently the 'main' camera, 'main' will be reset to be camera 0.

  The removed Cameras are automatically destroyed if the `runDestroy` argument is `true`, which is the default.
  If you wish to re-use the cameras then set this to `false`, but know that they will retain their references
  and internal data until destroyed or re-added to a Camera Manager.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera | Array.<Phaser.Cameras.Scene2D.Camera>) - The Camera, or an array of Cameras, to be removed from this Camera Manager.
    * run-destroy (boolean) {optional} - Automatically call `Camera.destroy` on each Camera removed from this Camera Manager.

  Returns:  integer - The total number of Cameras removed."
  ([camera-manager camera]
   (phaser->clj
    (.remove camera-manager
             (clj->phaser camera))))
  ([camera-manager camera run-destroy]
   (phaser->clj
    (.remove camera-manager
             (clj->phaser camera)
             (clj->phaser run-destroy)))))

(defn reset-all
  "Resets this Camera Manager.

  This will iterate through all current Cameras, destroying them all, then it will reset the
  cameras array, reset the ID counter and create 1 new single camera using the default values.

  Returns:  Phaser.Cameras.Scene2D.Camera - The freshly created main Camera."
  ([camera-manager]
   (phaser->clj
    (.resetAll camera-manager))))

(defn resize
  "Resizes all cameras to the given dimensions.

  Parameters:
    * camera-manager (Phaser.Cameras.Scene2D.CameraManager) - Targeted instance for method
    * width (number) - The new width of the camera.
    * height (number) - The new height of the camera."
  ([camera-manager width height]
   (phaser->clj
    (.resize camera-manager
             (clj->phaser width)
             (clj->phaser height)))))