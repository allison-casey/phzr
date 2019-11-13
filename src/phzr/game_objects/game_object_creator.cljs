(ns phzr.game-objects.game-object-creator
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->GameObjectCreator
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object Factory belongs."
  ([scene]
   (js/Phaser.GameObjects.GameObjectCreator. (clj->phaser scene))))

(defn bitmap-text
  "Creates a new Bitmap Text Game Object and returns it.

  Note: This method will only be available if the Bitmap Text Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (Phaser.Types.GameObjects.BitmapText.BitmapTextConfig) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.BitmapText - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.bitmapText game-object-creator
                 (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.bitmapText game-object-creator
                 (clj->phaser config)
                 (clj->phaser add-to-scene)))))

(defn blitter
  "Creates a new Blitter Game Object and returns it.

  Note: This method will only be available if the Blitter Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Blitter - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.blitter game-object-creator
              (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.blitter game-object-creator
              (clj->phaser config)
              (clj->phaser add-to-scene)))))

(defn container
  "Creates a new Container Game Object and returns it.

  Note: This method will only be available if the Container Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Container - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.container game-object-creator
                (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.container game-object-creator
                (clj->phaser config)
                (clj->phaser add-to-scene)))))

(defn dynamic-bitmap-text
  "Creates a new Dynamic Bitmap Text Game Object and returns it.

  Note: This method will only be available if the Dynamic Bitmap Text Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (Phaser.Types.GameObjects.BitmapText.BitmapTextConfig) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.DynamicBitmapText - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.dynamicBitmapText game-object-creator
                        (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.dynamicBitmapText game-object-creator
                        (clj->phaser config)
                        (clj->phaser add-to-scene)))))

(defn graphics
  "Creates a new Graphics Game Object and returns it.

  Note: This method will only be available if the Graphics Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Graphics - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.graphics game-object-creator
               (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.graphics game-object-creator
               (clj->phaser config)
               (clj->phaser add-to-scene)))))

(defn group
  "Creates a new Group Game Object and returns it.

  Note: This method will only be available if the Group Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (Phaser.Types.GameObjects.Group.GroupConfig | Phaser.Types.GameObjects.Group.GroupCreateConfig) - The configuration object this Game Object will use to create itself.

  Returns:  Phaser.GameObjects.Group - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.group game-object-creator
            (clj->phaser config)))))

(defn image
  "Creates a new Image Game Object and returns it.

  Note: This method will only be available if the Image Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Image - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.image game-object-creator
            (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.image game-object-creator
            (clj->phaser config)
            (clj->phaser add-to-scene)))))

(defn mesh
  "Creates a new Mesh Game Object and returns it.

  Note: This method will only be available if the Mesh Game Object and WebGL support have been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Mesh - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.mesh game-object-creator
           (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.mesh game-object-creator
           (clj->phaser config)
           (clj->phaser add-to-scene)))))

(defn particles
  "Creates a new Particle Emitter Manager Game Object and returns it.

  Note: This method will only be available if the Particles Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.particles game-object-creator
                (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.particles game-object-creator
                (clj->phaser config)
                (clj->phaser add-to-scene)))))

(defn quad
  "Creates a new Quad Game Object and returns it.

  Note: This method will only be available if the Quad Game Object and WebGL support have been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Quad - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.quad game-object-creator
           (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.quad game-object-creator
           (clj->phaser config)
           (clj->phaser add-to-scene)))))

(defn render-texture
  "Creates a new Render Texture Game Object and returns it.

  Note: This method will only be available if the Render Texture Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (Phaser.Types.GameObjects.RenderTexture.RenderTextureConfig) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.RenderTexture - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.renderTexture game-object-creator
                    (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.renderTexture game-object-creator
                    (clj->phaser config)
                    (clj->phaser add-to-scene)))))

(defn shader
  "Creates a new Shader Game Object and returns it.

  Note: This method will only be available if the Shader Game Object and WebGL support have been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Shader - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.shader game-object-creator
             (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.shader game-object-creator
             (clj->phaser config)
             (clj->phaser add-to-scene)))))

(defn sprite
  "Creates a new Sprite Game Object and returns it.

  Note: This method will only be available if the Sprite Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (Phaser.Types.GameObjects.Sprite.SpriteConfig) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Sprite - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.sprite game-object-creator
             (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.sprite game-object-creator
             (clj->phaser config)
             (clj->phaser add-to-scene)))))

(defn text
  "Creates a new Text Game Object and returns it.

  Note: This method will only be available if the Text Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Text - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.text game-object-creator
           (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.text game-object-creator
           (clj->phaser config)
           (clj->phaser add-to-scene)))))

(defn tile-sprite
  "Creates a new TileSprite Game Object and returns it.

  Note: This method will only be available if the TileSprite Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (Phaser.Types.GameObjects.TileSprite.TileSpriteConfig) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.TileSprite - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.tileSprite game-object-creator
                 (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.tileSprite game-object-creator
                 (clj->phaser config)
                 (clj->phaser add-to-scene)))))

(defn tilemap
  "Creates a Tilemap from the given key or data, or creates a blank Tilemap if no key/data provided.
  When loading from CSV or a 2D array, you should specify the tileWidth & tileHeight. When parsing
  from a map from Tiled, the tileWidth, tileHeight, width & height will be pulled from the map
  data. For an empty map, you should specify tileWidth, tileHeight, width & height.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (Phaser.Types.Tilemaps.TilemapConfig) {optional} - The config options for the Tilemap.

  Returns:  Phaser.Tilemaps.Tilemap - "
  ([game-object-creator]
   (phaser->clj
    (.tilemap game-object-creator)))
  ([game-object-creator config]
   (phaser->clj
    (.tilemap game-object-creator
              (clj->phaser config)))))

(defn tween
  "Creates a new Tween object and returns it.

  Note: This method will only be available if Tweens have been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (Phaser.Types.Tweens.TweenBuilderConfig | object) - The Tween configuration.

  Returns:  Phaser.Tweens.Tween - The Tween that was created."
  ([game-object-creator config]
   (phaser->clj
    (.tween game-object-creator
            (clj->phaser config)))))

(defn video
  "Creates a new Video Game Object and returns it.

  Note: This method will only be available if the Video Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.
    * add-to-scene (boolean) {optional} - Add this Game Object to the Scene after creating it? If set this argument overrides the `add` property in the config object.

  Returns:  Phaser.GameObjects.Video - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.video game-object-creator
            (clj->phaser config))))
  ([game-object-creator config add-to-scene]
   (phaser->clj
    (.video game-object-creator
            (clj->phaser config)
            (clj->phaser add-to-scene)))))

(defn zone
  "Creates a new Zone Game Object and returns it.

  Note: This method will only be available if the Zone Game Object has been built into Phaser.

  Parameters:
    * game-object-creator (Phaser.GameObjects.GameObjectCreator) - Targeted instance for method
    * config (object) - The configuration object this Game Object will use to create itself.

  Returns:  Phaser.GameObjects.Zone - The Game Object that was created."
  ([game-object-creator config]
   (phaser->clj
    (.zone game-object-creator
           (clj->phaser config)))))