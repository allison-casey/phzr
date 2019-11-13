(ns phzr.textures.canvas-texture
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update remove get]))

(defn ->CanvasTexture
  "  Parameters:
    * manager (Phaser.Textures.TextureManager) - A reference to the Texture Manager this Texture belongs to.
    * key (string) - The unique string-based key of this Texture.
    * source (HTMLCanvasElement) - The canvas element that is used as the base of this texture.
    * width (integer) - The width of the canvas.
    * height (integer) - The height of the canvas."
  ([manager key source width height]
   (js/Phaser.Textures.CanvasTexture. (clj->phaser manager)
                                      (clj->phaser key)
                                      (clj->phaser source)
                                      (clj->phaser width)
                                      (clj->phaser height))))

(defn add
  "Adds a new Frame to this Texture.

  A Frame is a rectangular region of a TextureSource with a unique index or string-based key.

  The name given must be unique within this Texture. If it already exists, this method will return `null`.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * name (integer | string) - The name of this Frame. The name is unique within the Texture.
    * source-index (integer) - The index of the TextureSource that this Frame is a part of.
    * x (number) - The x coordinate of the top-left of this Frame.
    * y (number) - The y coordinate of the top-left of this Frame.
    * width (number) - The width of this Frame.
    * height (number) - The height of this Frame.

  Returns:  Phaser.Textures.Frame - The Frame that was added to this Texture, or `null` if the given name already exists."
  ([canvas-texture name source-index x y width height]
   (phaser->clj
    (.add canvas-texture
          (clj->phaser name)
          (clj->phaser source-index)
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser width)
          (clj->phaser height)))))

(defn clear
  "Clears the given region of this Canvas Texture, resetting it back to transparent.
  If no region is given, the whole Canvas Texture is cleared.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * x (integer) {optional} - The x coordinate of the top-left of the region to clear.
    * y (integer) {optional} - The y coordinate of the top-left of the region to clear.
    * width (integer) {optional} - The width of the region.
    * height (integer) {optional} - The height of the region.

  Returns:  Phaser.Textures.CanvasTexture - The Canvas Texture."
  ([canvas-texture]
   (phaser->clj
    (.clear canvas-texture)))
  ([canvas-texture x]
   (phaser->clj
    (.clear canvas-texture
            (clj->phaser x))))
  ([canvas-texture x y]
   (phaser->clj
    (.clear canvas-texture
            (clj->phaser x)
            (clj->phaser y))))
  ([canvas-texture x y width]
   (phaser->clj
    (.clear canvas-texture
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser width))))
  ([canvas-texture x y width height]
   (phaser->clj
    (.clear canvas-texture
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser width)
            (clj->phaser height)))))

(defn destroy
  "Destroys this Texture and releases references to its sources and frames."
  ([canvas-texture]
   (phaser->clj
    (.destroy canvas-texture))))

(defn draw
  "Draws the given Image or Canvas element to this CanvasTexture, then updates the internal
  ImageData buffer and arrays.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * x (integer) - The x coordinate to draw the source at.
    * y (integer) - The y coordinate to draw the source at.
    * source (HTMLImageElement | HTMLCanvasElement) - The element to draw to this canvas.

  Returns:  Phaser.Textures.CanvasTexture - This CanvasTexture."
  ([canvas-texture x y source]
   (phaser->clj
    (.draw canvas-texture
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser source)))))

(defn draw-frame
  "Draws the given texture frame to this CanvasTexture, then updates the internal
  ImageData buffer and arrays.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * key (string) - The unique string-based key of the Texture.
    * frame (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from the Texture.
    * x (integer) {optional} - The x coordinate to draw the source at.
    * y (integer) {optional} - The y coordinate to draw the source at.

  Returns:  Phaser.Textures.CanvasTexture - This CanvasTexture."
  ([canvas-texture key]
   (phaser->clj
    (.drawFrame canvas-texture
                (clj->phaser key))))
  ([canvas-texture key frame]
   (phaser->clj
    (.drawFrame canvas-texture
                (clj->phaser key)
                (clj->phaser frame))))
  ([canvas-texture key frame x]
   (phaser->clj
    (.drawFrame canvas-texture
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser x))))
  ([canvas-texture key frame x y]
   (phaser->clj
    (.drawFrame canvas-texture
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser x)
                (clj->phaser y)))))

(defn get
  "Gets a Frame from this Texture based on either the key or the index of the Frame.

  In a Texture Atlas Frames are typically referenced by a key.
  In a Sprite Sheet Frames are referenced by an index.
  Passing no value for the name returns the base texture.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * name (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from this Texture.

  Returns:  Phaser.Textures.Frame - The Texture Frame."
  ([canvas-texture]
   (phaser->clj
    (.get canvas-texture)))
  ([canvas-texture name]
   (phaser->clj
    (.get canvas-texture
          (clj->phaser name)))))

(defn get-canvas
  "Gets the Canvas Element.

  Returns:  HTMLCanvasElement - The Canvas DOM element this texture is using."
  ([canvas-texture]
   (phaser->clj
    (.getCanvas canvas-texture))))

(defn get-context
  "Gets the 2D Canvas Rendering Context.

  Returns:  CanvasRenderingContext2D - The Canvas Rendering Context this texture is using."
  ([canvas-texture]
   (phaser->clj
    (.getContext canvas-texture))))

(defn get-data
  "Gets an ImageData region from this CanvasTexture from the position and size specified.
  You can write this back using `CanvasTexture.putData`, or manipulate it.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * x (integer) - The x coordinate of the top-left of the area to get the ImageData from. Must lay within the dimensions of this CanvasTexture and be an integer.
    * y (integer) - The y coordinate of the top-left of the area to get the ImageData from. Must lay within the dimensions of this CanvasTexture and be an integer.
    * width (integer) - The width of the rectangle from which the ImageData will be extracted. Positive values are to the right, and negative to the left.
    * height (integer) - The height of the rectangle from which the ImageData will be extracted. Positive values are down, and negative are up.

  Returns:  ImageData - The ImageData extracted from this CanvasTexture."
  ([canvas-texture x y width height]
   (phaser->clj
    (.getData canvas-texture
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width)
              (clj->phaser height)))))

(defn get-data-source-image
  "Given a Frame name, return the data source image it uses to render with.
  You can use this to get the normal map for an image for example.

  This will return the actual DOM Image.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * name (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from this Texture.

  Returns:  HTMLImageElement | HTMLCanvasElement - The DOM Image or Canvas Element."
  ([canvas-texture]
   (phaser->clj
    (.getDataSourceImage canvas-texture)))
  ([canvas-texture name]
   (phaser->clj
    (.getDataSourceImage canvas-texture
                         (clj->phaser name)))))

(defn get-frame-names
  "Returns an array with all of the names of the Frames in this Texture.

  Useful if you want to randomly assign a Frame to a Game Object, as you can
  pick a random element from the returned array.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * include-base (boolean) {optional} - Include the `__BASE` Frame in the output array?

  Returns:  Array.<string> - An array of all Frame names in this Texture."
  ([canvas-texture]
   (phaser->clj
    (.getFrameNames canvas-texture)))
  ([canvas-texture include-base]
   (phaser->clj
    (.getFrameNames canvas-texture
                    (clj->phaser include-base)))))

(defn get-frames-from-texture-source
  "Returns an array of all the Frames in the given TextureSource.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * source-index (integer) - The index of the TextureSource to get the Frames from.
    * include-base (boolean) {optional} - Include the `__BASE` Frame in the output array?

  Returns:  Array.<Phaser.Textures.Frame> - An array of Texture Frames."
  ([canvas-texture source-index]
   (phaser->clj
    (.getFramesFromTextureSource canvas-texture
                                 (clj->phaser source-index))))
  ([canvas-texture source-index include-base]
   (phaser->clj
    (.getFramesFromTextureSource canvas-texture
                                 (clj->phaser source-index)
                                 (clj->phaser include-base)))))

(defn get-index
  "Returns the Image Data index for the given pixel in this CanvasTexture.

  The index can be used to read directly from the `this.data` array.

  The index points to the red value in the array. The subsequent 3 indexes
  point to green, blue and alpha respectively.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * x (integer) - The x coordinate of the pixel to get. Must lay within the dimensions of this CanvasTexture and be an integer.
    * y (integer) - The y coordinate of the pixel to get. Must lay within the dimensions of this CanvasTexture and be an integer.

  Returns:  integer - "
  ([canvas-texture x y]
   (phaser->clj
    (.getIndex canvas-texture
               (clj->phaser x)
               (clj->phaser y)))))

(defn get-pixel
  "Get the color of a specific pixel from this texture and store it in a Color object.

  If you have drawn anything to this CanvasTexture since it was created you must call `CanvasTexture.update` to refresh the array buffer,
  otherwise this may return out of date color values, or worse - throw a run-time error as it tries to access an array element that doesn't exist.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * x (integer) - The x coordinate of the pixel to get. Must lay within the dimensions of this CanvasTexture and be an integer.
    * y (integer) - The y coordinate of the pixel to get. Must lay within the dimensions of this CanvasTexture and be an integer.
    * out (Phaser.Display.Color) {optional} - A Color object to store the pixel values in. If not provided a new Color object will be created.

  Returns:  Phaser.Display.Color - An object with the red, green, blue and alpha values set in the r, g, b and a properties."
  ([canvas-texture x y]
   (phaser->clj
    (.getPixel canvas-texture
               (clj->phaser x)
               (clj->phaser y))))
  ([canvas-texture x y out]
   (phaser->clj
    (.getPixel canvas-texture
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser out)))))

(defn get-pixels
  "Returns an array containing all of the pixels in the given region.

  If the requested region extends outside the bounds of this CanvasTexture,
  the region is truncated to fit.

  If you have drawn anything to this CanvasTexture since it was created you must call `CanvasTexture.update` to refresh the array buffer,
  otherwise this may return out of date color values, or worse - throw a run-time error as it tries to access an array element that doesn't exist.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * x (integer) {optional} - The x coordinate of the top-left of the region. Must lay within the dimensions of this CanvasTexture and be an integer.
    * y (integer) {optional} - The y coordinate of the top-left of the region. Must lay within the dimensions of this CanvasTexture and be an integer.
    * width (integer) {optional} - The width of the region to get. Must be an integer. Defaults to the canvas width if not given.
    * height (integer) {optional} - The height of the region to get. Must be an integer. If not given will be set to the `width`.

  Returns:  Array.<Phaser.Types.Textures.PixelConfig> - An array of Pixel objects."
  ([canvas-texture]
   (phaser->clj
    (.getPixels canvas-texture)))
  ([canvas-texture x]
   (phaser->clj
    (.getPixels canvas-texture
                (clj->phaser x))))
  ([canvas-texture x y]
   (phaser->clj
    (.getPixels canvas-texture
                (clj->phaser x)
                (clj->phaser y))))
  ([canvas-texture x y width]
   (phaser->clj
    (.getPixels canvas-texture
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width))))
  ([canvas-texture x y width height]
   (phaser->clj
    (.getPixels canvas-texture
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)))))

(defn get-source-image
  "Given a Frame name, return the source image it uses to render with.

  This will return the actual DOM Image or Canvas element.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * name (string | integer) {optional} - The string-based name, or integer based index, of the Frame to get from this Texture.

  Returns:  HTMLImageElement | HTMLCanvasElement | Phaser.GameObjects.RenderTexture - The DOM Image, Canvas Element or Render Texture."
  ([canvas-texture]
   (phaser->clj
    (.getSourceImage canvas-texture)))
  ([canvas-texture name]
   (phaser->clj
    (.getSourceImage canvas-texture
                     (clj->phaser name)))))

(defn get-texture-source-index
  "Takes the given TextureSource and returns the index of it within this Texture.
  If it's not in this Texture, it returns -1.
  Unless this Texture has multiple TextureSources, such as with a multi-atlas, this
  method will always return zero or -1.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * source (Phaser.Textures.TextureSource) - The TextureSource to check.

  Returns:  integer - The index of the TextureSource within this Texture, or -1 if not in this Texture."
  ([canvas-texture source]
   (phaser->clj
    (.getTextureSourceIndex canvas-texture
                            (clj->phaser source)))))

(defn has
  "Checks to see if a Frame matching the given key exists within this Texture.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * name (string) - The key of the Frame to check for.

  Returns:  boolean - True if a Frame with the matching key exists in this Texture."
  ([canvas-texture name]
   (phaser->clj
    (.has canvas-texture
          (clj->phaser name)))))

(defn put-data
  "Puts the ImageData into the context of this CanvasTexture at the given coordinates.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * image-data (ImageData) - The ImageData to put at the given location.
    * x (integer) - The x coordinate to put the imageData. Must lay within the dimensions of this CanvasTexture and be an integer.
    * y (integer) - The y coordinate to put the imageData. Must lay within the dimensions of this CanvasTexture and be an integer.
    * dirty-x (integer) {optional} - Horizontal position (x coordinate) of the top-left corner from which the image data will be extracted.
    * dirty-y (integer) {optional} - Vertical position (x coordinate) of the top-left corner from which the image data will be extracted.
    * dirty-width (integer) {optional} - Width of the rectangle to be painted. Defaults to the width of the image data.
    * dirty-height (integer) {optional} - Height of the rectangle to be painted. Defaults to the height of the image data.

  Returns:  this - This CanvasTexture."
  ([canvas-texture image-data x y]
   (phaser->clj
    (.putData canvas-texture
              (clj->phaser image-data)
              (clj->phaser x)
              (clj->phaser y))))
  ([canvas-texture image-data x y dirty-x]
   (phaser->clj
    (.putData canvas-texture
              (clj->phaser image-data)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser dirty-x))))
  ([canvas-texture image-data x y dirty-x dirty-y]
   (phaser->clj
    (.putData canvas-texture
              (clj->phaser image-data)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser dirty-x)
              (clj->phaser dirty-y))))
  ([canvas-texture image-data x y dirty-x dirty-y dirty-width]
   (phaser->clj
    (.putData canvas-texture
              (clj->phaser image-data)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser dirty-x)
              (clj->phaser dirty-y)
              (clj->phaser dirty-width))))
  ([canvas-texture image-data x y dirty-x dirty-y dirty-width dirty-height]
   (phaser->clj
    (.putData canvas-texture
              (clj->phaser image-data)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser dirty-x)
              (clj->phaser dirty-y)
              (clj->phaser dirty-width)
              (clj->phaser dirty-height)))))

(defn refresh
  "This should be called manually if you are running under WebGL.
  It will refresh the WebGLTexture from the Canvas source. Only call this if you know that the
  canvas has changed, as there is a significant GPU texture allocation cost involved in doing so.

  Returns:  Phaser.Textures.CanvasTexture - This CanvasTexture."
  ([canvas-texture]
   (phaser->clj
    (.refresh canvas-texture))))

(defn remove
  "Removes the given Frame from this Texture. The Frame is destroyed immediately.

  Any Game Objects using this Frame should stop using it _before_ you remove it,
  as it does not happen automatically.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * name (string) - The key of the Frame to remove.

  Returns:  boolean - True if a Frame with the matching key was removed from this Texture."
  ([canvas-texture name]
   (phaser->clj
    (.remove canvas-texture
             (clj->phaser name)))))

(defn set-data-source
  "Adds a data source image to this Texture.

  An example of a data source image would be a normal map, where all of the Frames for this Texture
  equally apply to the normal map.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * data (HTMLImageElement | HTMLCanvasElement | Array.<HTMLImageElement> | Array.<HTMLCanvasElement>) - The source image."
  ([canvas-texture data]
   (phaser->clj
    (.setDataSource canvas-texture
                    (clj->phaser data)))))

(defn set-filter
  "Sets the Filter Mode for this Texture.

  The mode can be either Linear, the default, or Nearest.

  For pixel-art you should use Nearest.

  The mode applies to the entire Texture, not just a specific Frame of it.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * filter-mode (Phaser.Textures.FilterMode) - The Filter Mode."
  ([canvas-texture filter-mode]
   (phaser->clj
    (.setFilter canvas-texture
                (clj->phaser filter-mode)))))

(defn set-pixel
  "Sets a pixel in the CanvasTexture to the given color and alpha values.

  This is an expensive operation to run in large quantities, so use sparingly.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * x (integer) - The x coordinate of the pixel to get. Must lay within the dimensions of this CanvasTexture and be an integer.
    * y (integer) - The y coordinate of the pixel to get. Must lay within the dimensions of this CanvasTexture and be an integer.
    * red (integer) - The red color value. A number between 0 and 255.
    * green (integer) - The green color value. A number between 0 and 255.
    * blue (integer) - The blue color value. A number between 0 and 255.
    * alpha (integer) {optional} - The alpha value. A number between 0 and 255.

  Returns:  this - This CanvasTexture."
  ([canvas-texture x y red green blue]
   (phaser->clj
    (.setPixel canvas-texture
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser red)
               (clj->phaser green)
               (clj->phaser blue))))
  ([canvas-texture x y red green blue alpha]
   (phaser->clj
    (.setPixel canvas-texture
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser red)
               (clj->phaser green)
               (clj->phaser blue)
               (clj->phaser alpha)))))

(defn set-size
  "Changes the size of this Canvas Texture.

  Parameters:
    * canvas-texture (Phaser.Textures.CanvasTexture) - Targeted instance for method
    * width (integer) - The new width of the Canvas.
    * height (integer) {optional} - The new height of the Canvas. If not given it will use the width as the height.

  Returns:  Phaser.Textures.CanvasTexture - The Canvas Texture."
  ([canvas-texture width]
   (phaser->clj
    (.setSize canvas-texture
              (clj->phaser width))))
  ([canvas-texture width height]
   (phaser->clj
    (.setSize canvas-texture
              (clj->phaser width)
              (clj->phaser height)))))

(defn update
  "This re-creates the `imageData` from the current context.
  It then re-builds the ArrayBuffer, the `data` Uint8ClampedArray reference and the `pixels` Int32Array.

  Warning: This is a very expensive operation, so use it sparingly.

  Returns:  Phaser.Textures.CanvasTexture - This CanvasTexture."
  ([canvas-texture]
   (phaser->clj
    (.update canvas-texture))))