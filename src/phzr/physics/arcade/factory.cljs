(ns phzr.physics.arcade.factory
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Factory
  "  Parameters:
    * world (Phaser.Physics.Arcade.World) - The Arcade Physics World instance."
  ([world]
   (js/Phaser.Physics.Arcade.Factory. (clj->phaser world))))

(defn collider
  "Creates a new Arcade Physics Collider object.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * object-1 (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject> | Phaser.GameObjects.Group | Array.<Phaser.GameObjects.Group>) - The first object to check for collision.
    * object-2 (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject> | Phaser.GameObjects.Group | Array.<Phaser.GameObjects.Group>) - The second object to check for collision.
    * collide-callback (ArcadePhysicsCallback) {optional} - The callback to invoke when the two objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - The callback to invoke when the two objects collide. Must return a boolean.
    * callback-context (*) {optional} - The scope in which to call the callbacks.

  Returns:  Phaser.Physics.Arcade.Collider - The Collider that was created."
  ([factory object-1 object-2]
   (phaser->clj
    (.collider factory
               (clj->phaser object-1)
               (clj->phaser object-2))))
  ([factory object-1 object-2 collide-callback]
   (phaser->clj
    (.collider factory
               (clj->phaser object-1)
               (clj->phaser object-2)
               (clj->phaser collide-callback))))
  ([factory object-1 object-2 collide-callback process-callback]
   (phaser->clj
    (.collider factory
               (clj->phaser object-1)
               (clj->phaser object-2)
               (clj->phaser collide-callback)
               (clj->phaser process-callback))))
  ([factory object-1 object-2 collide-callback process-callback callback-context]
   (phaser->clj
    (.collider factory
               (clj->phaser object-1)
               (clj->phaser object-2)
               (clj->phaser collide-callback)
               (clj->phaser process-callback)
               (clj->phaser callback-context)))))

(defn destroy
  "Destroys this Factory."
  ([factory]
   (phaser->clj
    (.destroy factory))))

(defn existing
  "Adds an Arcade Physics Body to the given Game Object.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - A Game Object.
    * is-static (boolean) {optional} - Create a Static body (true) or Dynamic body (false).

  Returns:  Phaser.GameObjects.GameObject - The Game Object."
  ([factory game-object]
   (phaser->clj
    (.existing factory
               (clj->phaser game-object))))
  ([factory game-object is-static]
   (phaser->clj
    (.existing factory
               (clj->phaser game-object)
               (clj->phaser is-static)))))

(defn group
  "Creates a Physics Group object.
  All Game Objects created by this Group will automatically be dynamic Arcade Physics objects.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * children (Array.<Phaser.GameObjects.GameObject> | Phaser.Types.Physics.Arcade.PhysicsGroupConfig | Phaser.Types.GameObjects.Group.GroupCreateConfig) {optional} - Game Objects to add to this group; or the `config` argument.
    * config (Phaser.Types.Physics.Arcade.PhysicsGroupConfig | Phaser.Types.GameObjects.Group.GroupCreateConfig) {optional} - Settings for this group.

  Returns:  Phaser.Physics.Arcade.Group - The Group object that was created."
  ([factory]
   (phaser->clj
    (.group factory)))
  ([factory children]
   (phaser->clj
    (.group factory
            (clj->phaser children))))
  ([factory children config]
   (phaser->clj
    (.group factory
            (clj->phaser children)
            (clj->phaser config)))))

(defn image
  "Creates a new Arcade Image object with a Dynamic body.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.Physics.Arcade.Image - The Image object that was created."
  ([factory x y texture]
   (phaser->clj
    (.image factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser texture))))
  ([factory x y texture frame]
   (phaser->clj
    (.image factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser texture)
            (clj->phaser frame)))))

(defn overlap
  "Creates a new Arcade Physics Collider Overlap object.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * object-1 (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject> | Phaser.GameObjects.Group | Array.<Phaser.GameObjects.Group>) - The first object to check for overlap.
    * object-2 (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject> | Phaser.GameObjects.Group | Array.<Phaser.GameObjects.Group>) - The second object to check for overlap.
    * collide-callback (ArcadePhysicsCallback) {optional} - The callback to invoke when the two objects collide.
    * process-callback (ArcadePhysicsCallback) {optional} - The callback to invoke when the two objects collide. Must return a boolean.
    * callback-context (*) {optional} - The scope in which to call the callbacks.

  Returns:  Phaser.Physics.Arcade.Collider - The Collider that was created."
  ([factory object-1 object-2]
   (phaser->clj
    (.overlap factory
              (clj->phaser object-1)
              (clj->phaser object-2))))
  ([factory object-1 object-2 collide-callback]
   (phaser->clj
    (.overlap factory
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback))))
  ([factory object-1 object-2 collide-callback process-callback]
   (phaser->clj
    (.overlap factory
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback)
              (clj->phaser process-callback))))
  ([factory object-1 object-2 collide-callback process-callback callback-context]
   (phaser->clj
    (.overlap factory
              (clj->phaser object-1)
              (clj->phaser object-2)
              (clj->phaser collide-callback)
              (clj->phaser process-callback)
              (clj->phaser callback-context)))))

(defn sprite
  "Creates a new Arcade Sprite object with a Dynamic body.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * key (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.Physics.Arcade.Sprite - The Sprite object that was created."
  ([factory x y key]
   (phaser->clj
    (.sprite factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key))))
  ([factory x y key frame]
   (phaser->clj
    (.sprite factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key)
             (clj->phaser frame)))))

(defn static-group
  "Creates a Static Physics Group object.
  All Game Objects created by this Group will automatically be static Arcade Physics objects.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * children (Array.<Phaser.GameObjects.GameObject> | Phaser.Types.GameObjects.Group.GroupConfig | Phaser.Types.GameObjects.Group.GroupCreateConfig) {optional} - Game Objects to add to this group; or the `config` argument.
    * config (Phaser.Types.GameObjects.Group.GroupConfig | Phaser.Types.GameObjects.Group.GroupCreateConfig) {optional} - Settings for this group.

  Returns:  Phaser.Physics.Arcade.StaticGroup - The Static Group object that was created."
  ([factory]
   (phaser->clj
    (.staticGroup factory)))
  ([factory children]
   (phaser->clj
    (.staticGroup factory
                  (clj->phaser children))))
  ([factory children config]
   (phaser->clj
    (.staticGroup factory
                  (clj->phaser children)
                  (clj->phaser config)))))

(defn static-image
  "Creates a new Arcade Image object with a Static body.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.Physics.Arcade.Image - The Image object that was created."
  ([factory x y texture]
   (phaser->clj
    (.staticImage factory
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser texture))))
  ([factory x y texture frame]
   (phaser->clj
    (.staticImage factory
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser texture)
                  (clj->phaser frame)))))

(defn static-sprite
  "Creates a new Arcade Sprite object with a Static body.

  Parameters:
    * factory (Phaser.Physics.Arcade.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.Physics.Arcade.Sprite - The Sprite object that was created."
  ([factory x y texture]
   (phaser->clj
    (.staticSprite factory
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser texture))))
  ([factory x y texture frame]
   (phaser->clj
    (.staticSprite factory
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser texture)
                   (clj->phaser frame)))))