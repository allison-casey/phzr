(ns phzr.tilemaps.tileset
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Tileset
  "  Parameters:
    * name (string) - The name of the tileset in the map data.
    * firstgid (integer) - The first tile index this tileset contains.
    * tile-width (integer) {optional} - Width of each tile (in pixels).
    * tile-height (integer) {optional} - Height of each tile (in pixels).
    * tile-margin (integer) {optional} - The margin around all tiles in the sheet (in pixels).
    * tile-spacing (integer) {optional} - The spacing between each tile in the sheet (in pixels).
    * tile-properties (object) {optional} - Custom properties defined per tile in the Tileset.
These typically are custom properties created in Tiled when editing a tileset.
    * tile-data (object) {optional} - Data stored per tile. These typically are created in Tiled
when editing a tileset, e.g. from Tiled's tile collision editor or terrain editor."
  ([name firstgid]
   (js/Phaser.Tilemaps.Tileset. (clj->phaser name)
                                (clj->phaser firstgid)))
  ([name firstgid tile-width]
   (js/Phaser.Tilemaps.Tileset. (clj->phaser name)
                                (clj->phaser firstgid)
                                (clj->phaser tile-width)))
  ([name firstgid tile-width tile-height]
   (js/Phaser.Tilemaps.Tileset. (clj->phaser name)
                                (clj->phaser firstgid)
                                (clj->phaser tile-width)
                                (clj->phaser tile-height)))
  ([name firstgid tile-width tile-height tile-margin]
   (js/Phaser.Tilemaps.Tileset. (clj->phaser name)
                                (clj->phaser firstgid)
                                (clj->phaser tile-width)
                                (clj->phaser tile-height)
                                (clj->phaser tile-margin)))
  ([name firstgid tile-width tile-height tile-margin tile-spacing]
   (js/Phaser.Tilemaps.Tileset. (clj->phaser name)
                                (clj->phaser firstgid)
                                (clj->phaser tile-width)
                                (clj->phaser tile-height)
                                (clj->phaser tile-margin)
                                (clj->phaser tile-spacing)))
  ([name firstgid tile-width tile-height tile-margin tile-spacing tile-properties]
   (js/Phaser.Tilemaps.Tileset. (clj->phaser name)
                                (clj->phaser firstgid)
                                (clj->phaser tile-width)
                                (clj->phaser tile-height)
                                (clj->phaser tile-margin)
                                (clj->phaser tile-spacing)
                                (clj->phaser tile-properties)))
  ([name firstgid tile-width tile-height tile-margin tile-spacing tile-properties tile-data]
   (js/Phaser.Tilemaps.Tileset. (clj->phaser name)
                                (clj->phaser firstgid)
                                (clj->phaser tile-width)
                                (clj->phaser tile-height)
                                (clj->phaser tile-margin)
                                (clj->phaser tile-spacing)
                                (clj->phaser tile-properties)
                                (clj->phaser tile-data))))

(defn contains-tile-index
  "Returns true if and only if this Tileset contains the given tile index.

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * tile-index (integer) - The unique id of the tile across all tilesets in the map.

  Returns:  boolean - "
  ([tileset tile-index]
   (phaser->clj
    (.containsTileIndex tileset
                        (clj->phaser tile-index)))))

(defn get-tile-collision-group
  "Get a tile's collision group that is stored in the Tileset. Returns null if tile index is not
  contained in this Tileset. This is typically defined within Tiled's tileset collision editor.

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * tile-index (integer) - The unique id of the tile across all tilesets in the map.

  Returns:  object - "
  ([tileset tile-index]
   (phaser->clj
    (.getTileCollisionGroup tileset
                            (clj->phaser tile-index)))))

(defn get-tile-data
  "Get a tile's data that is stored in the Tileset. Returns null if tile index is not contained
  in this Tileset. This is typically defined in Tiled and will contain both Tileset collision
  info and terrain mapping.

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * tile-index (integer) - The unique id of the tile across all tilesets in the map.

  Returns:  object | undefined - "
  ([tileset tile-index]
   (phaser->clj
    (.getTileData tileset
                  (clj->phaser tile-index)))))

(defn get-tile-properties
  "Get a tiles properties that are stored in the Tileset. Returns null if tile index is not
  contained in this Tileset. This is typically defined in Tiled under the Tileset editor.

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * tile-index (integer) - The unique id of the tile across all tilesets in the map.

  Returns:  object | undefined - "
  ([tileset tile-index]
   (phaser->clj
    (.getTileProperties tileset
                        (clj->phaser tile-index)))))

(defn get-tile-texture-coordinates
  "Returns the texture coordinates (UV in pixels) in the Tileset image for the given tile index.
  Returns null if tile index is not contained in this Tileset.

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * tile-index (integer) - The unique id of the tile across all tilesets in the map.

  Returns:  object - Object in the form { x, y } representing the top-left UV coordinate
within the Tileset image."
  ([tileset tile-index]
   (phaser->clj
    (.getTileTextureCoordinates tileset
                                (clj->phaser tile-index)))))

(defn set-image
  "Sets the image associated with this Tileset and updates the tile data (rows, columns, etc.).

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * texture (Phaser.Textures.Texture) - The image that contains the tiles.

  Returns:  Phaser.Tilemaps.Tileset - This Tileset object."
  ([tileset texture]
   (phaser->clj
    (.setImage tileset
               (clj->phaser texture)))))

(defn set-spacing
  "Sets the tile margin & spacing and updates the tile data (rows, columns, etc.).

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * margin (integer) {optional} - The margin around the tiles in the sheet (in pixels).
    * spacing (integer) {optional} - The spacing between the tiles in the sheet (in pixels).

  Returns:  Phaser.Tilemaps.Tileset - This Tileset object."
  ([tileset]
   (phaser->clj
    (.setSpacing tileset)))
  ([tileset margin]
   (phaser->clj
    (.setSpacing tileset
                 (clj->phaser margin))))
  ([tileset margin spacing]
   (phaser->clj
    (.setSpacing tileset
                 (clj->phaser margin)
                 (clj->phaser spacing)))))

(defn set-tile-size
  "Sets the tile width & height and updates the tile data (rows, columns, etc.).

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * tile-width (integer) {optional} - The width of a tile in pixels.
    * tile-height (integer) {optional} - The height of a tile in pixels.

  Returns:  Phaser.Tilemaps.Tileset - This Tileset object."
  ([tileset]
   (phaser->clj
    (.setTileSize tileset)))
  ([tileset tile-width]
   (phaser->clj
    (.setTileSize tileset
                  (clj->phaser tile-width))))
  ([tileset tile-width tile-height]
   (phaser->clj
    (.setTileSize tileset
                  (clj->phaser tile-width)
                  (clj->phaser tile-height)))))

(defn update-tile-data
  "Updates tile texture coordinates and tileset data.

  Parameters:
    * tileset (Phaser.Tilemaps.Tileset) - Targeted instance for method
    * image-width (integer) - The (expected) width of the image to slice.
    * image-height (integer) - The (expected) height of the image to slice.

  Returns:  Phaser.Tilemaps.Tileset - This Tileset object."
  ([tileset image-width image-height]
   (phaser->clj
    (.updateTileData tileset
                     (clj->phaser image-width)
                     (clj->phaser image-height)))))