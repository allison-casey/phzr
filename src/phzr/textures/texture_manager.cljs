(ns phzr.textures.texture-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove get]))

(defn ->TextureManager
  "  Parameters:
    * game (Phaser.Game) - The Phaser.Game instance this Texture Manager belongs to."
  ([game]
   (js/Phaser.Textures.TextureManager. (clj->phaser game))))

(defn add-atlas
  "Adds a new Texture Atlas to this Texture Manager.
  It can accept either JSON Array or JSON Hash formats, as exported by Texture Packer and similar software.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLImageElement) - The source Image element.
    * data (object) - The Texture Atlas data.
    * data-source (HTMLImageElement | HTMLCanvasElement | Array.<HTMLImageElement> | Array.<HTMLCanvasElement>) {optional} - An optional data Image element.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source data]
   (phaser->clj
    (.addAtlas texture-manager
               (clj->phaser key)
               (clj->phaser source)
               (clj->phaser data))))
  ([texture-manager key source data data-source]
   (phaser->clj
    (.addAtlas texture-manager
               (clj->phaser key)
               (clj->phaser source)
               (clj->phaser data)
               (clj->phaser data-source)))))

(defn add-atlas-json-array
  "Adds a Texture Atlas to this Texture Manager.
  The frame data of the atlas must be stored in an Array within the JSON.
  This is known as a JSON Array in software such as Texture Packer.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLImageElement | Array.<HTMLImageElement>) - The source Image element/s.
    * data (object | Array.<object>) - The Texture Atlas data/s.
    * data-source (HTMLImageElement | HTMLCanvasElement | Array.<HTMLImageElement> | Array.<HTMLCanvasElement>) {optional} - An optional data Image element.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source data]
   (phaser->clj
    (.addAtlasJSONArray texture-manager
                        (clj->phaser key)
                        (clj->phaser source)
                        (clj->phaser data))))
  ([texture-manager key source data data-source]
   (phaser->clj
    (.addAtlasJSONArray texture-manager
                        (clj->phaser key)
                        (clj->phaser source)
                        (clj->phaser data)
                        (clj->phaser data-source)))))

(defn add-atlas-json-hash
  "Adds a Texture Atlas to this Texture Manager.
  The frame data of the atlas must be stored in an Object within the JSON.
  This is known as a JSON Hash in software such as Texture Packer.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLImageElement) - The source Image element.
    * data (object) - The Texture Atlas data.
    * data-source (HTMLImageElement | HTMLCanvasElement | Array.<HTMLImageElement> | Array.<HTMLCanvasElement>) {optional} - An optional data Image element.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source data]
   (phaser->clj
    (.addAtlasJSONHash texture-manager
                       (clj->phaser key)
                       (clj->phaser source)
                       (clj->phaser data))))
  ([texture-manager key source data data-source]
   (phaser->clj
    (.addAtlasJSONHash texture-manager
                       (clj->phaser key)
                       (clj->phaser source)
                       (clj->phaser data)
                       (clj->phaser data-source)))))

(defn add-atlas-xml
  "Adds a Texture Atlas to this Texture Manager, where the atlas data is given
  in the XML format.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLImageElement) - The source Image element.
    * data (object) - The Texture Atlas XML data.
    * data-source (HTMLImageElement | HTMLCanvasElement | Array.<HTMLImageElement> | Array.<HTMLCanvasElement>) {optional} - An optional data Image element.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source data]
   (phaser->clj
    (.addAtlasXML texture-manager
                  (clj->phaser key)
                  (clj->phaser source)
                  (clj->phaser data))))
  ([texture-manager key source data data-source]
   (phaser->clj
    (.addAtlasXML texture-manager
                  (clj->phaser key)
                  (clj->phaser source)
                  (clj->phaser data)
                  (clj->phaser data-source)))))

(defn add-base-64
  "Adds a new Texture to the Texture Manager created from the given Base64 encoded data.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * data (*) - The Base64 encoded data.

  Returns:  this - This Texture Manager instance."
  ([texture-manager key data]
   (phaser->clj
    (.addBase64 texture-manager
                (clj->phaser key)
                (clj->phaser data)))))

(defn add-canvas
  "Creates a new Canvas Texture object from an existing Canvas element
  and adds it to this Texture Manager, unless `skipCache` is true.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLCanvasElement) - The Canvas element to form the base of the new Texture.
    * skip-cache (boolean) {optional} - Skip adding this Texture into the Cache?

  Returns:  Phaser.Textures.CanvasTexture - The Canvas Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source]
   (phaser->clj
    (.addCanvas texture-manager
                (clj->phaser key)
                (clj->phaser source))))
  ([texture-manager key source skip-cache]
   (phaser->clj
    (.addCanvas texture-manager
                (clj->phaser key)
                (clj->phaser source)
                (clj->phaser skip-cache)))))

(defn add-gl-texture
  "Takes a WebGL Texture and creates a Phaser Texture from it, which is added to the Texture Manager using the given key.

  This allows you to then use the Texture as a normal texture for texture based Game Objects like Sprites.

  This is a WebGL only feature.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * gl-texture (WebGLTexture) - The source Render Texture.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key gl-texture]
   (phaser->clj
    (.addGLTexture texture-manager
                   (clj->phaser key)
                   (clj->phaser gl-texture)))))

(defn add-image
  "Adds a new Texture to the Texture Manager created from the given Image element.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLImageElement) - The source Image element.
    * data-source (HTMLImageElement | HTMLCanvasElement) {optional} - An optional data Image element.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source]
   (phaser->clj
    (.addImage texture-manager
               (clj->phaser key)
               (clj->phaser source))))
  ([texture-manager key source data-source]
   (phaser->clj
    (.addImage texture-manager
               (clj->phaser key)
               (clj->phaser source)
               (clj->phaser data-source)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([texture-manager event fn]
   (phaser->clj
    (.addListener texture-manager
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([texture-manager event fn context]
   (phaser->clj
    (.addListener texture-manager
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn add-render-texture
  "Adds a Render Texture to the Texture Manager using the given key.
  This allows you to then use the Render Texture as a normal texture for texture based Game Objects like Sprites.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * render-texture (Phaser.GameObjects.RenderTexture) - The source Render Texture.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key render-texture]
   (phaser->clj
    (.addRenderTexture texture-manager
                       (clj->phaser key)
                       (clj->phaser render-texture)))))

(defn add-sprite-sheet
  "Adds a Sprite Sheet to this Texture Manager.

  In Phaser terminology a Sprite Sheet is a texture containing different frames, but each frame is the exact
  same size and cannot be trimmed or rotated.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLImageElement) - The source Image element.
    * config (Phaser.Types.Textures.SpriteSheetConfig) - The configuration object for this Sprite Sheet.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source config]
   (phaser->clj
    (.addSpriteSheet texture-manager
                     (clj->phaser key)
                     (clj->phaser source)
                     (clj->phaser config)))))

(defn add-sprite-sheet-from-atlas
  "Adds a Sprite Sheet to this Texture Manager, where the Sprite Sheet exists as a Frame within a Texture Atlas.

  In Phaser terminology a Sprite Sheet is a texture containing different frames, but each frame is the exact
  same size and cannot be trimmed or rotated.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * config (Phaser.Types.Textures.SpriteSheetFromAtlasConfig) - The configuration object for this Sprite Sheet.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key config]
   (phaser->clj
    (.addSpriteSheetFromAtlas texture-manager
                              (clj->phaser key)
                              (clj->phaser config)))))

(defn add-unity-atlas
  "Adds a Unity Texture Atlas to this Texture Manager.
  The data must be in the form of a Unity YAML file.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLImageElement) - The source Image element.
    * data (object) - The Texture Atlas data.
    * data-source (HTMLImageElement | HTMLCanvasElement | Array.<HTMLImageElement> | Array.<HTMLCanvasElement>) {optional} - An optional data Image element.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source data]
   (phaser->clj
    (.addUnityAtlas texture-manager
                    (clj->phaser key)
                    (clj->phaser source)
                    (clj->phaser data))))
  ([texture-manager key source data data-source]
   (phaser->clj
    (.addUnityAtlas texture-manager
                    (clj->phaser key)
                    (clj->phaser source)
                    (clj->phaser data)
                    (clj->phaser data-source)))))

(defn check-key
  "Checks the given texture key and throws a console.warn if the key is already in use, then returns false.
  If you wish to avoid the console.warn then use `TextureManager.exists` instead.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The texture key to check.

  Returns:  boolean - `true` if it's safe to use the texture key, otherwise `false`."
  ([texture-manager key]
   (phaser->clj
    (.checkKey texture-manager
               (clj->phaser key)))))

(defn clone-frame
  "Takes a Texture key and Frame name and returns a clone of that Frame if found.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * frame (string | integer) - The string or index of the Frame to be cloned.

  Returns:  Phaser.Textures.Frame - A Clone of the given Frame."
  ([texture-manager key frame]
   (phaser->clj
    (.cloneFrame texture-manager
                 (clj->phaser key)
                 (clj->phaser frame)))))

(defn create
  "Creates a new Texture using the given source and dimensions.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * source (HTMLImageElement) - The source Image element.
    * width (integer) - The width of the Texture.
    * height (integer) - The height of the Texture.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key source width height]
   (phaser->clj
    (.create texture-manager
             (clj->phaser key)
             (clj->phaser source)
             (clj->phaser width)
             (clj->phaser height)))))

(defn create-canvas
  "Creates a new Texture using a blank Canvas element of the size given.

  Canvas elements are automatically pooled and calling this method will
  extract a free canvas from the CanvasPool, or create one if none are available.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * width (integer) {optional} - The width of the Canvas element.
    * height (integer) {optional} - The height of the Canvas element.

  Returns:  Phaser.Textures.CanvasTexture - The Canvas Texture that was created, or `null` if the key is already in use."
  ([texture-manager key]
   (phaser->clj
    (.createCanvas texture-manager
                   (clj->phaser key))))
  ([texture-manager key width]
   (phaser->clj
    (.createCanvas texture-manager
                   (clj->phaser key)
                   (clj->phaser width))))
  ([texture-manager key width height]
   (phaser->clj
    (.createCanvas texture-manager
                   (clj->phaser key)
                   (clj->phaser width)
                   (clj->phaser height)))))

(defn destroy
  "Destroys the Texture Manager and all Textures stored within it."
  ([texture-manager]
   (phaser->clj
    (.destroy texture-manager))))

(defn each
  "Passes all Textures to the given callback.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * callback (EachTextureCallback) - The callback function to be sent the Textures.
    * scope (object) - The value to use as `this` when executing the callback.
    * args (*) {optional} - Additional arguments that will be passed to the callback, after the child."
  ([texture-manager callback scope]
   (phaser->clj
    (.each texture-manager
           (clj->phaser callback)
           (clj->phaser scope))))
  ([texture-manager callback scope args]
   (phaser->clj
    (.each texture-manager
           (clj->phaser callback)
           (clj->phaser scope)
           (clj->phaser args)))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([texture-manager event]
   (phaser->clj
    (.emit texture-manager
           (clj->phaser event))))
  ([texture-manager event args]
   (phaser->clj
    (.emit texture-manager
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([texture-manager]
   (phaser->clj
    (.eventNames texture-manager))))

(defn exists
  "Checks the given key to see if a Texture using it exists within this Texture Manager.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.

  Returns:  boolean - Returns `true` if a Texture matching the given key exists in this Texture Manager."
  ([texture-manager key]
   (phaser->clj
    (.exists texture-manager
             (clj->phaser key)))))

(defn generate
  "Creates a new Texture using the given config values.
  Generated textures consist of a Canvas element to which the texture data is drawn.
  See the Phaser.Create function for the more direct way to create textures.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * config (object) - The configuration object needed to generate the texture.

  Returns:  Phaser.Textures.Texture - The Texture that was created, or `null` if the key is already in use."
  ([texture-manager key config]
   (phaser->clj
    (.generate texture-manager
               (clj->phaser key)
               (clj->phaser config)))))

(defn get
  "Returns a Texture from the Texture Manager that matches the given key.

  If the key is `undefined` it will return the `__DEFAULT` Texture.

  If the key is an instance of a Texture, it will return the key directly.

  Finally. if the key is given, but not found and not a Texture instance, it will return the `__MISSING` Texture.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string | Phaser.Textures.Texture) - The unique string-based key of the Texture, or a Texture instance.

  Returns:  Phaser.Textures.Texture - The Texture that was created."
  ([texture-manager key]
   (phaser->clj
    (.get texture-manager
          (clj->phaser key)))))

(defn get-base-64
  "Gets an existing texture frame and converts it into a base64 encoded image and returns the base64 data.

  You can also provide the image type and encoder options.

  This will only work with bitmap based texture frames, such as those created from Texture Atlases.
  It will not work with GL Texture objects, such as Shaders, or Render Textures. For those please
  see the WebGL Snapshot function instead.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * frame (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from the Texture.
    * type (string) {optional} - [description]
    * encoder-options (number) {optional} - [description]

  Returns:  string - The base64 encoded data, or an empty string if the texture frame could not be found."
  ([texture-manager key]
   (phaser->clj
    (.getBase64 texture-manager
                (clj->phaser key))))
  ([texture-manager key frame]
   (phaser->clj
    (.getBase64 texture-manager
                (clj->phaser key)
                (clj->phaser frame))))
  ([texture-manager key frame type]
   (phaser->clj
    (.getBase64 texture-manager
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser type))))
  ([texture-manager key frame type encoder-options]
   (phaser->clj
    (.getBase64 texture-manager
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser type)
                (clj->phaser encoder-options)))))

(defn get-frame
  "Takes a Texture key and Frame name and returns a reference to that Frame, if found.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * frame (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from the Texture.

  Returns:  Phaser.Textures.Frame - A Texture Frame object."
  ([texture-manager key]
   (phaser->clj
    (.getFrame texture-manager
               (clj->phaser key))))
  ([texture-manager key frame]
   (phaser->clj
    (.getFrame texture-manager
               (clj->phaser key)
               (clj->phaser frame)))))

(defn get-pixel
  "Given a Texture and an `x` and `y` coordinate this method will return a new
  Color object that has been populated with the color and alpha values of the pixel
  at that location in the Texture.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * x (integer) - The x coordinate of the pixel within the Texture.
    * y (integer) - The y coordinate of the pixel within the Texture.
    * key (string) - The unique string-based key of the Texture.
    * frame (string | integer) {optional} - The string or index of the Frame.

  Returns:  Phaser.Display.Color - A Color object populated with the color values of the requested pixel,
or `null` if the coordinates were out of bounds."
  ([texture-manager x y key]
   (phaser->clj
    (.getPixel texture-manager
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser key))))
  ([texture-manager x y key frame]
   (phaser->clj
    (.getPixel texture-manager
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser key)
               (clj->phaser frame)))))

(defn get-pixel-alpha
  "Given a Texture and an `x` and `y` coordinate this method will return a value between 0 and 255
  corresponding to the alpha value of the pixel at that location in the Texture. If the coordinate
  is out of bounds it will return null.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * x (integer) - The x coordinate of the pixel within the Texture.
    * y (integer) - The y coordinate of the pixel within the Texture.
    * key (string) - The unique string-based key of the Texture.
    * frame (string | integer) {optional} - The string or index of the Frame.

  Returns:  integer - A value between 0 and 255, or `null` if the coordinates were out of bounds."
  ([texture-manager x y key]
   (phaser->clj
    (.getPixelAlpha texture-manager
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser key))))
  ([texture-manager x y key frame]
   (phaser->clj
    (.getPixelAlpha texture-manager
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser key)
                    (clj->phaser frame)))))

(defn get-texture-keys
  "Returns an array with all of the keys of all Textures in this Texture Manager.
  The output array will exclude the `__DEFAULT` and `__MISSING` keys.

  Returns:  Array.<string> - An array containing all of the Texture keys stored in this Texture Manager."
  ([texture-manager]
   (phaser->clj
    (.getTextureKeys texture-manager))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([texture-manager event]
   (phaser->clj
    (.listenerCount texture-manager
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([texture-manager event]
   (phaser->clj
    (.listeners texture-manager
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([texture-manager event]
   (phaser->clj
    (.off texture-manager
          (clj->phaser event))))
  ([texture-manager event fn]
   (phaser->clj
    (.off texture-manager
          (clj->phaser event)
          (clj->phaser fn))))
  ([texture-manager event fn context]
   (phaser->clj
    (.off texture-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([texture-manager event fn context once]
   (phaser->clj
    (.off texture-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([texture-manager event fn]
   (phaser->clj
    (.on texture-manager
         (clj->phaser event)
         (clj->phaser fn))))
  ([texture-manager event fn context]
   (phaser->clj
    (.on texture-manager
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([texture-manager event fn]
   (phaser->clj
    (.once texture-manager
           (clj->phaser event)
           (clj->phaser fn))))
  ([texture-manager event fn context]
   (phaser->clj
    (.once texture-manager
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove
  "Removes a Texture from the Texture Manager and destroys it. This will immediately
  clear all references to it from the Texture Manager, and if it has one, destroy its
  WebGLTexture. This will emit a `removetexture` event.

  Note: If you have any Game Objects still using this texture they will start throwing
  errors the next time they try to render. Make sure that removing the texture is the final
  step when clearing down to avoid this.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string | Phaser.Textures.Texture) - The key of the Texture to remove, or a reference to it.

  Returns:  Phaser.Textures.TextureManager - The Texture Manager."
  ([texture-manager key]
   (phaser->clj
    (.remove texture-manager
             (clj->phaser key)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([texture-manager]
   (phaser->clj
    (.removeAllListeners texture-manager)))
  ([texture-manager event]
   (phaser->clj
    (.removeAllListeners texture-manager
                         (clj->phaser event)))))

(defn remove-key
  "Removes a key from the Texture Manager but does not destroy the Texture that was using the key.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * key (string) - The key to remove from the texture list.

  Returns:  Phaser.Textures.TextureManager - The Texture Manager."
  ([texture-manager key]
   (phaser->clj
    (.removeKey texture-manager
                (clj->phaser key)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([texture-manager event]
   (phaser->clj
    (.removeListener texture-manager
                     (clj->phaser event))))
  ([texture-manager event fn]
   (phaser->clj
    (.removeListener texture-manager
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([texture-manager event fn context]
   (phaser->clj
    (.removeListener texture-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([texture-manager event fn context once]
   (phaser->clj
    (.removeListener texture-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn rename-texture
  "Changes the key being used by a Texture to the new key provided.

  The old key is removed, allowing it to be re-used.

  Game Objects are linked to Textures by a reference to the Texture object, so
  all existing references will be retained.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * current-key (string) - The current string-based key of the Texture you wish to rename.
    * new-key (string) - The new unique string-based key to use for the Texture.

  Returns:  boolean - `true` if the Texture key was successfully renamed, otherwise `false`."
  ([texture-manager current-key new-key]
   (phaser->clj
    (.renameTexture texture-manager
                    (clj->phaser current-key)
                    (clj->phaser new-key)))))

(defn set-texture
  "Sets the given Game Objects `texture` and `frame` properties so that it uses
  the Texture and Frame specified in the `key` and `frame` arguments to this method.

  Parameters:
    * texture-manager (Phaser.Textures.TextureManager) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object the texture would be set on.
    * key (string) - The unique string-based key of the Texture.
    * frame (string | integer) {optional} - The string or index of the Frame.

  Returns:  Phaser.GameObjects.GameObject - The Game Object the texture was set on."
  ([texture-manager game-object key]
   (phaser->clj
    (.setTexture texture-manager
                 (clj->phaser game-object)
                 (clj->phaser key))))
  ([texture-manager game-object key frame]
   (phaser->clj
    (.setTexture texture-manager
                 (clj->phaser game-object)
                 (clj->phaser key)
                 (clj->phaser frame)))))

(defn shutdown
  "Removes all listeners."
  ([texture-manager]
   (phaser->clj
    (.shutdown texture-manager))))