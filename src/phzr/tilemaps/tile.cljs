(ns phzr.tilemaps.tile
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Tile
  "  Parameters:
    * layer (Phaser.Tilemaps.LayerData) - The LayerData object in the Tilemap that this tile belongs to.
    * index (integer) - The unique index of this tile within the map.
    * x (integer) - The x coordinate of this tile in tile coordinates.
    * y (integer) - The y coordinate of this tile in tile coordinates.
    * width (integer) - Width of the tile in pixels.
    * height (integer) - Height of the tile in pixels.
    * base-width (integer) - The base width a tile in the map (in pixels). Tiled maps support
multiple tileset sizes within one map, but they are still placed at intervals of the base
tile width.
    * base-height (integer) - The base height of the tile in pixels (in pixels). Tiled maps
support multiple tileset sizes within one map, but they are still placed at intervals of the
base tile height."
  ([layer index x y width height base-width base-height]
   (js/Phaser.Tilemaps.Tile. (clj->phaser layer)
                             (clj->phaser index)
                             (clj->phaser x)
                             (clj->phaser y)
                             (clj->phaser width)
                             (clj->phaser height)
                             (clj->phaser base-width)
                             (clj->phaser base-height))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([tile]
   (phaser->clj
    (.clearAlpha tile))))

(defn contains-point
  "Check if the given x and y world coordinates are within this Tile. This does not factor in
  camera scroll, layer scale or layer position.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * x (number) - The x coordinate to test.
    * y (number) - The y coordinate to test.

  Returns:  boolean - True if the coordinates are within this Tile, otherwise false."
  ([tile x y]
   (phaser->clj
    (.containsPoint tile
                    (clj->phaser x)
                    (clj->phaser y)))))

(defn copy
  "Copies the tile data & properties from the given tile to this tile. This copies everything
  except for position and interesting faces.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * tile (Phaser.Tilemaps.Tile) - The tile to copy from.

  Returns:  Phaser.Tilemaps.Tile - This Tile object."
  ([tile tile]
   (phaser->clj
    (.copy tile
           (clj->phaser tile)))))

(defn destroy
  "Clean up memory."
  ([tile]
   (phaser->clj
    (.destroy tile))))

(defn get-bottom
  "Gets the world Y position of the bottom side of the tile, factoring in the layer's position,
  scale and scroll.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use to perform the check.

  Returns:  number - "
  ([tile]
   (phaser->clj
    (.getBottom tile)))
  ([tile camera]
   (phaser->clj
    (.getBottom tile
                (clj->phaser camera)))))

(defn get-bounds
  "Gets the world rectangle bounding box for the tile, factoring in the layers position,
  scale and scroll.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use to perform the check.
    * output (object) {optional} - [description]

  Returns:  Phaser.Geom.Rectangle | object - "
  ([tile]
   (phaser->clj
    (.getBounds tile)))
  ([tile camera]
   (phaser->clj
    (.getBounds tile
                (clj->phaser camera))))
  ([tile camera output]
   (phaser->clj
    (.getBounds tile
                (clj->phaser camera)
                (clj->phaser output)))))

(defn get-center-x
  "Gets the world X position of the center of the tile, factoring in the layer's position,
  scale and scroll.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use to perform the check.

  Returns:  number - "
  ([tile]
   (phaser->clj
    (.getCenterX tile)))
  ([tile camera]
   (phaser->clj
    (.getCenterX tile
                 (clj->phaser camera)))))

(defn get-center-y
  "Gets the world Y position of the center of the tile, factoring in the layer's position,
  scale and scroll.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use to perform the check.

  Returns:  number - "
  ([tile]
   (phaser->clj
    (.getCenterY tile)))
  ([tile camera]
   (phaser->clj
    (.getCenterY tile
                 (clj->phaser camera)))))

(defn get-collision-group
  "The collision group for this Tile, defined within the Tileset. This returns a reference to
  the collision group stored within the Tileset, so any modification of the returned object
  will impact all tiles that have the same index as this tile.

  Returns:  object - tileset"
  ([tile]
   (phaser->clj
    (.getCollisionGroup tile))))

(defn get-left
  "Gets the world X position of the left side of the tile, factoring in the layers position,
  scale and scroll.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use to perform the check.

  Returns:  number - "
  ([tile]
   (phaser->clj
    (.getLeft tile)))
  ([tile camera]
   (phaser->clj
    (.getLeft tile
              (clj->phaser camera)))))

(defn get-right
  "Gets the world X position of the right side of the tile, factoring in the layer's position,
  scale and scroll.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use to perform the check.

  Returns:  number - "
  ([tile]
   (phaser->clj
    (.getRight tile)))
  ([tile camera]
   (phaser->clj
    (.getRight tile
               (clj->phaser camera)))))

(defn get-tile-data
  "The tile data for this Tile, defined within the Tileset. This typically contains Tiled
  collision data, tile animations and terrain information. This returns a reference to the tile
  data stored within the Tileset, so any modification of the returned object will impact all
  tiles that have the same index as this tile.

  Returns:  object - tileset"
  ([tile]
   (phaser->clj
    (.getTileData tile))))

(defn get-top
  "Gets the world Y position of the top side of the tile, factoring in the layer's position,
  scale and scroll.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use to perform the check.

  Returns:  number - "
  ([tile]
   (phaser->clj
    (.getTop tile)))
  ([tile camera]
   (phaser->clj
    (.getTop tile
             (clj->phaser camera)))))

(defn intersects
  "Check for intersection with this tile. This does not factor in camera scroll, layer scale or
  layer position.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * x (number) - The x axis in pixels.
    * y (number) - The y axis in pixels.
    * right (number) - The right point.
    * bottom (number) - The bottom point.

  Returns:  boolean - "
  ([tile x y right bottom]
   (phaser->clj
    (.intersects tile
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser right)
                 (clj->phaser bottom)))))

(defn is-interesting
  "Checks if the tile is interesting.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * collides (boolean) - If true, will consider the tile interesting if it collides on any side.
    * faces (boolean) - If true, will consider the tile interesting if it has an interesting face.

  Returns:  boolean - True if the Tile is interesting, otherwise false."
  ([tile collides faces]
   (phaser->clj
    (.isInteresting tile
                    (clj->phaser collides)
                    (clj->phaser faces)))))

(defn reset-collision
  "Reset collision status flags.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate interesting faces for this tile and its neighbors.

  Returns:  Phaser.Tilemaps.Tile - This Tile object."
  ([tile]
   (phaser->clj
    (.resetCollision tile)))
  ([tile recalculate-faces]
   (phaser->clj
    (.resetCollision tile
                     (clj->phaser recalculate-faces)))))

(defn reset-faces
  "Reset faces.

  Returns:  Phaser.Tilemaps.Tile - This Tile object."
  ([tile]
   (phaser->clj
    (.resetFaces tile))))

(defn reset-flip
  "Resets the horizontal and vertical flipped state of this Game Object back to their default un-flipped state.

  Returns:  this - This Game Object instance."
  ([tile]
   (phaser->clj
    (.resetFlip tile))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([tile]
   (phaser->clj
    (.setAlpha tile)))
  ([tile top-left]
   (phaser->clj
    (.setAlpha tile
               (clj->phaser top-left))))
  ([tile top-left top-right]
   (phaser->clj
    (.setAlpha tile
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([tile top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha tile
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([tile top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha tile
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-collision
  "Sets the collision flags for each side of this tile and updates the interesting faces list.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * left (boolean) - Indicating collide with any object on the left.
    * right (boolean) {optional} - Indicating collide with any object on the right.
    * up (boolean) {optional} - Indicating collide with any object on the top.
    * down (boolean) {optional} - Indicating collide with any object on the bottom.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate interesting faces
for this tile and its neighbors.

  Returns:  Phaser.Tilemaps.Tile - This Tile object."
  ([tile left]
   (phaser->clj
    (.setCollision tile
                   (clj->phaser left))))
  ([tile left right]
   (phaser->clj
    (.setCollision tile
                   (clj->phaser left)
                   (clj->phaser right))))
  ([tile left right up]
   (phaser->clj
    (.setCollision tile
                   (clj->phaser left)
                   (clj->phaser right)
                   (clj->phaser up))))
  ([tile left right up down]
   (phaser->clj
    (.setCollision tile
                   (clj->phaser left)
                   (clj->phaser right)
                   (clj->phaser up)
                   (clj->phaser down))))
  ([tile left right up down recalculate-faces]
   (phaser->clj
    (.setCollision tile
                   (clj->phaser left)
                   (clj->phaser right)
                   (clj->phaser up)
                   (clj->phaser down)
                   (clj->phaser recalculate-faces)))))

(defn set-collision-callback
  "Set a callback to be called when this tile is hit by an object. The callback must true for
  collision processing to take place.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * callback (function) - Callback function.
    * context (object) - Callback will be called within this context.

  Returns:  Phaser.Tilemaps.Tile - This Tile object."
  ([tile callback context]
   (phaser->clj
    (.setCollisionCallback tile
                           (clj->phaser callback)
                           (clj->phaser context)))))

(defn set-flip
  "Sets the horizontal and vertical flipped state of this Game Object.

  A Game Object that is flipped will render inversed on the flipped axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * x (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.
    * y (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([tile x y]
   (phaser->clj
    (.setFlip tile
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-flip-x
  "Sets the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([tile value]
   (phaser->clj
    (.setFlipX tile
               (clj->phaser value)))))

(defn set-flip-y
  "Sets the vertical flipped state of this Game Object.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([tile value]
   (phaser->clj
    (.setFlipY tile
               (clj->phaser value)))))

(defn set-size
  "Sets the size of the tile and updates its pixelX and pixelY.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * tile-width (integer) - The width of the tile in pixels.
    * tile-height (integer) - The height of the tile in pixels.
    * base-width (integer) - The base width a tile in the map (in pixels).
    * base-height (integer) - The base height of the tile in pixels (in pixels).

  Returns:  Phaser.Tilemaps.Tile - This Tile object."
  ([tile tile-width tile-height base-width base-height]
   (phaser->clj
    (.setSize tile
              (clj->phaser tile-width)
              (clj->phaser tile-height)
              (clj->phaser base-width)
              (clj->phaser base-height)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * tile (Phaser.Tilemaps.Tile) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([tile value]
   (phaser->clj
    (.setVisible tile
                 (clj->phaser value)))))

(defn toggle-flip-x
  "Toggles the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Returns:  this - This Game Object instance."
  ([tile]
   (phaser->clj
    (.toggleFlipX tile))))

(defn toggle-flip-y
  "Toggles the vertical flipped state of this Game Object.

  Returns:  this - This Game Object instance."
  ([tile]
   (phaser->clj
    (.toggleFlipY tile))))

(defn update-pixel-xy
  "Used internally. Updates the tile's world XY position based on the current tile size.

  Returns:  Phaser.Tilemaps.Tile - This Tile object."
  ([tile]
   (phaser->clj
    (.updatePixelXY tile))))