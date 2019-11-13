(ns phzr.textures.texture
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove get]))

(defn ->Texture
  "  Parameters:
    * manager (Phaser.Textures.TextureManager) - A reference to the Texture Manager this Texture belongs to.
    * key (string) - The unique string-based key of this Texture.
    * source (HTMLImageElement | HTMLCanvasElement | Array.<HTMLImageElement> | Array.<HTMLCanvasElement>) - An array of sources that are used to create the texture. Usually Images, but can also be a Canvas.
    * width (number) {optional} - The width of the Texture. This is optional and automatically derived from the source images.
    * height (number) {optional} - The height of the Texture. This is optional and automatically derived from the source images."
  ([manager key source]
   (js/Phaser.Textures.Texture. (clj->phaser manager)
                                (clj->phaser key)
                                (clj->phaser source)))
  ([manager key source width]
   (js/Phaser.Textures.Texture. (clj->phaser manager)
                                (clj->phaser key)
                                (clj->phaser source)
                                (clj->phaser width)))
  ([manager key source width height]
   (js/Phaser.Textures.Texture. (clj->phaser manager)
                                (clj->phaser key)
                                (clj->phaser source)
                                (clj->phaser width)
                                (clj->phaser height))))

(defn add
  "Adds a new Frame to this Texture.

  A Frame is a rectangular region of a TextureSource with a unique index or string-based key.

  The name given must be unique within this Texture. If it already exists, this method will return `null`.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * name (integer | string) - The name of this Frame. The name is unique within the Texture.
    * source-index (integer) - The index of the TextureSource that this Frame is a part of.
    * x (number) - The x coordinate of the top-left of this Frame.
    * y (number) - The y coordinate of the top-left of this Frame.
    * width (number) - The width of this Frame.
    * height (number) - The height of this Frame.

  Returns:  Phaser.Textures.Frame - The Frame that was added to this Texture, or `null` if the given name already exists."
  ([texture name source-index x y width height]
   (phaser->clj
    (.add texture
          (clj->phaser name)
          (clj->phaser source-index)
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser width)
          (clj->phaser height)))))

(defn destroy
  "Destroys this Texture and releases references to its sources and frames."
  ([texture]
   (phaser->clj
    (.destroy texture))))

(defn get
  "Gets a Frame from this Texture based on either the key or the index of the Frame.

  In a Texture Atlas Frames are typically referenced by a key.
  In a Sprite Sheet Frames are referenced by an index.
  Passing no value for the name returns the base texture.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * name (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from this Texture.

  Returns:  Phaser.Textures.Frame - The Texture Frame."
  ([texture]
   (phaser->clj
    (.get texture)))
  ([texture name]
   (phaser->clj
    (.get texture
          (clj->phaser name)))))

(defn get-data-source-image
  "Given a Frame name, return the data source image it uses to render with.
  You can use this to get the normal map for an image for example.

  This will return the actual DOM Image.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * name (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from this Texture.

  Returns:  HTMLImageElement | HTMLCanvasElement - The DOM Image or Canvas Element."
  ([texture]
   (phaser->clj
    (.getDataSourceImage texture)))
  ([texture name]
   (phaser->clj
    (.getDataSourceImage texture
                         (clj->phaser name)))))

(defn get-frame-names
  "Returns an array with all of the names of the Frames in this Texture.

  Useful if you want to randomly assign a Frame to a Game Object, as you can
  pick a random element from the returned array.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * include-base (boolean) {optional} - Include the `__BASE` Frame in the output array?

  Returns:  Array.<string> - An array of all Frame names in this Texture."
  ([texture]
   (phaser->clj
    (.getFrameNames texture)))
  ([texture include-base]
   (phaser->clj
    (.getFrameNames texture
                    (clj->phaser include-base)))))

(defn get-frames-from-texture-source
  "Returns an array of all the Frames in the given TextureSource.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * source-index (integer) - The index of the TextureSource to get the Frames from.
    * include-base (boolean) {optional} - Include the `__BASE` Frame in the output array?

  Returns:  Array.<Phaser.Textures.Frame> - An array of Texture Frames."
  ([texture source-index]
   (phaser->clj
    (.getFramesFromTextureSource texture
                                 (clj->phaser source-index))))
  ([texture source-index include-base]
   (phaser->clj
    (.getFramesFromTextureSource texture
                                 (clj->phaser source-index)
                                 (clj->phaser include-base)))))

(defn get-source-image
  "Given a Frame name, return the source image it uses to render with.

  This will return the actual DOM Image or Canvas element.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * name (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from this Texture.

  Returns:  HTMLImageElement | HTMLCanvasElement | Phaser.GameObjects.RenderTexture - The DOM Image, Canvas Element or Render Texture."
  ([texture]
   (phaser->clj
    (.getSourceImage texture)))
  ([texture name]
   (phaser->clj
    (.getSourceImage texture
                     (clj->phaser name)))))

(defn get-texture-source-index
  "Takes the given TextureSource and returns the index of it within this Texture.
  If it's not in this Texture, it returns -1.
  Unless this Texture has multiple TextureSources, such as with a multi-atlas, this
  method will always return zero or -1.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * source (Phaser.Textures.TextureSource) - The TextureSource to check.

  Returns:  integer - The index of the TextureSource within this Texture, or -1 if not in this Texture."
  ([texture source]
   (phaser->clj
    (.getTextureSourceIndex texture
                            (clj->phaser source)))))

(defn has
  "Checks to see if a Frame matching the given key exists within this Texture.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * name (string) - The key of the Frame to check for.

  Returns:  boolean - True if a Frame with the matching key exists in this Texture."
  ([texture name]
   (phaser->clj
    (.has texture
          (clj->phaser name)))))

(defn remove
  "Removes the given Frame from this Texture. The Frame is destroyed immediately.

  Any Game Objects using this Frame should stop using it _before_ you remove it,
  as it does not happen automatically.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * name (string) - The key of the Frame to remove.

  Returns:  boolean - True if a Frame with the matching key was removed from this Texture."
  ([texture name]
   (phaser->clj
    (.remove texture
             (clj->phaser name)))))

(defn set-data-source
  "Adds a data source image to this Texture.

  An example of a data source image would be a normal map, where all of the Frames for this Texture
  equally apply to the normal map.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * data (HTMLImageElement | HTMLCanvasElement | Array.<HTMLImageElement> | Array.<HTMLCanvasElement>) - The source image."
  ([texture data]
   (phaser->clj
    (.setDataSource texture
                    (clj->phaser data)))))

(defn set-filter
  "Sets the Filter Mode for this Texture.

  The mode can be either Linear, the default, or Nearest.

  For pixel-art you should use Nearest.

  The mode applies to the entire Texture, not just a specific Frame of it.

  Parameters:
    * texture (Phaser.Textures.Texture) - Targeted instance for method
    * filter-mode (Phaser.Textures.FilterMode) - The Filter Mode."
  ([texture filter-mode]
   (phaser->clj
    (.setFilter texture
                (clj->phaser filter-mode)))))