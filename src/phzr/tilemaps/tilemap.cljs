(ns phzr.tilemaps.tilemap
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [shuffle]))

(defn ->Tilemap
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Tilemap belongs.
    * map-data (Phaser.Tilemaps.MapData) - A MapData instance containing Tilemap data."
  ([scene map-data]
   (js/Phaser.Tilemaps.Tilemap. (clj->phaser scene)
                                (clj->phaser map-data))))

(defn add-tileset-image
  "Adds an image to the map to be used as a tileset. A single map may use multiple tilesets.
  Note that the tileset name can be found in the JSON file exported from Tiled, or in the Tiled
  editor.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tileset-name (string) - The name of the tileset as specified in the map data.
    * key (string) {optional} - The key of the Phaser.Cache image used for this tileset. If
`undefined` or `null` it will look for an image with a key matching the tilesetName parameter.
    * tile-width (integer) {optional} - The width of the tile (in pixels) in the Tileset Image. If not
given it will default to the map's tileWidth value, or the tileWidth specified in the Tiled
JSON file.
    * tile-height (integer) {optional} - The height of the tiles (in pixels) in the Tileset Image. If
not given it will default to the map's tileHeight value, or the tileHeight specified in the
Tiled JSON file.
    * tile-margin (integer) {optional} - The margin around the tiles in the sheet (in pixels). If not
specified, it will default to 0 or the value specified in the Tiled JSON file.
    * tile-spacing (integer) {optional} - The spacing between each the tile in the sheet (in pixels).
If not specified, it will default to 0 or the value specified in the Tiled JSON file.
    * gid (integer) {optional} - If adding multiple tilesets to a blank map, specify the starting
GID this set will use here.

  Returns:  Phaser.Tilemaps.Tileset - Returns the Tileset object that was created or updated, or null if it
failed."
  ([tilemap tileset-name]
   (phaser->clj
    (.addTilesetImage tilemap
                      (clj->phaser tileset-name))))
  ([tilemap tileset-name key]
   (phaser->clj
    (.addTilesetImage tilemap
                      (clj->phaser tileset-name)
                      (clj->phaser key))))
  ([tilemap tileset-name key tile-width]
   (phaser->clj
    (.addTilesetImage tilemap
                      (clj->phaser tileset-name)
                      (clj->phaser key)
                      (clj->phaser tile-width))))
  ([tilemap tileset-name key tile-width tile-height]
   (phaser->clj
    (.addTilesetImage tilemap
                      (clj->phaser tileset-name)
                      (clj->phaser key)
                      (clj->phaser tile-width)
                      (clj->phaser tile-height))))
  ([tilemap tileset-name key tile-width tile-height tile-margin]
   (phaser->clj
    (.addTilesetImage tilemap
                      (clj->phaser tileset-name)
                      (clj->phaser key)
                      (clj->phaser tile-width)
                      (clj->phaser tile-height)
                      (clj->phaser tile-margin))))
  ([tilemap tileset-name key tile-width tile-height tile-margin tile-spacing]
   (phaser->clj
    (.addTilesetImage tilemap
                      (clj->phaser tileset-name)
                      (clj->phaser key)
                      (clj->phaser tile-width)
                      (clj->phaser tile-height)
                      (clj->phaser tile-margin)
                      (clj->phaser tile-spacing))))
  ([tilemap tileset-name key tile-width tile-height tile-margin tile-spacing gid]
   (phaser->clj
    (.addTilesetImage tilemap
                      (clj->phaser tileset-name)
                      (clj->phaser key)
                      (clj->phaser tile-width)
                      (clj->phaser tile-height)
                      (clj->phaser tile-margin)
                      (clj->phaser tile-spacing)
                      (clj->phaser gid)))))

(defn calculate-faces-at
  "Calculates interesting faces at the given tile coordinates of the specified layer. Interesting
  faces are used internally for optimizing collisions against tiles. This method is mostly used
  internally to optimize recalculating faces when only one tile has been changed.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) - The x coordinate, in tiles, not pixels.
    * tile-y (integer) - The y coordinate, in tiles, not pixels.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.calculateFacesAt tilemap
                       (clj->phaser tile-x)
                       (clj->phaser tile-y))))
  ([tilemap tile-x tile-y layer]
   (phaser->clj
    (.calculateFacesAt tilemap
                       (clj->phaser tile-x)
                       (clj->phaser tile-y)
                       (clj->phaser layer)))))

(defn calculate-faces-within
  "Calculates interesting faces within the rectangular area specified (in tile coordinates) of the
  layer. Interesting faces are used internally for optimizing collisions against tiles. This method
  is mostly used internally.

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap]
   (phaser->clj
    (.calculateFacesWithin tilemap)))
  ([tilemap tile-x]
   (phaser->clj
    (.calculateFacesWithin tilemap
                           (clj->phaser tile-x))))
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.calculateFacesWithin tilemap
                           (clj->phaser tile-x)
                           (clj->phaser tile-y))))
  ([tilemap tile-x tile-y width]
   (phaser->clj
    (.calculateFacesWithin tilemap
                           (clj->phaser tile-x)
                           (clj->phaser tile-y)
                           (clj->phaser width))))
  ([tilemap tile-x tile-y width height]
   (phaser->clj
    (.calculateFacesWithin tilemap
                           (clj->phaser tile-x)
                           (clj->phaser tile-y)
                           (clj->phaser width)
                           (clj->phaser height))))
  ([tilemap tile-x tile-y width height layer]
   (phaser->clj
    (.calculateFacesWithin tilemap
                           (clj->phaser tile-x)
                           (clj->phaser tile-y)
                           (clj->phaser width)
                           (clj->phaser height)
                           (clj->phaser layer)))))

(defn convert-layer-to-static
  "Turns the DynamicTilemapLayer associated with the given layer into a StaticTilemapLayer. If
  no layer specified, the map's current layer is used. This is useful if you want to manipulate
  a map at the start of a scene, but then make it non-manipulable and optimize it for speed.
  Note: the DynamicTilemapLayer passed in is destroyed, so make sure to store the value
  returned from this method if you want to manipulate the new StaticTilemapLayer.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer) {optional} - The name of the layer from Tiled, the
index of the layer in the map, or a DynamicTilemapLayer.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - Returns the new layer that was created, or null if it
failed."
  ([tilemap]
   (phaser->clj
    (.convertLayerToStatic tilemap)))
  ([tilemap layer]
   (phaser->clj
    (.convertLayerToStatic tilemap
                           (clj->phaser layer)))))

(defn copy
  "Copies the tiles in the source rectangular area to a new destination (all specified in tile
  coordinates) within the layer. This copies all tile properties & recalculates collision
  information in the destination region.

  If no layer specified, the map's current layer is used. This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * src-tile-x (integer) - The x coordinate of the area to copy from, in tiles, not pixels.
    * src-tile-y (integer) - The y coordinate of the area to copy from, in tiles, not pixels.
    * width (integer) - The width of the area to copy, in tiles, not pixels.
    * height (integer) - The height of the area to copy, in tiles, not pixels.
    * dest-tile-x (integer) - The x coordinate of the area to copy to, in tiles, not pixels.
    * dest-tile-y (integer) - The y coordinate of the area to copy to, in tiles, not pixels.
    * recalculate-faces (boolean) {optional} - `true` if the faces data should be recalculated.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap src-tile-x src-tile-y width height dest-tile-x dest-tile-y]
   (phaser->clj
    (.copy tilemap
           (clj->phaser src-tile-x)
           (clj->phaser src-tile-y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser dest-tile-x)
           (clj->phaser dest-tile-y))))
  ([tilemap src-tile-x src-tile-y width height dest-tile-x dest-tile-y recalculate-faces]
   (phaser->clj
    (.copy tilemap
           (clj->phaser src-tile-x)
           (clj->phaser src-tile-y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser dest-tile-x)
           (clj->phaser dest-tile-y)
           (clj->phaser recalculate-faces))))
  ([tilemap src-tile-x src-tile-y width height dest-tile-x dest-tile-y recalculate-faces layer]
   (phaser->clj
    (.copy tilemap
           (clj->phaser src-tile-x)
           (clj->phaser src-tile-y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser dest-tile-x)
           (clj->phaser dest-tile-y)
           (clj->phaser recalculate-faces)
           (clj->phaser layer)))))

(defn create-blank-dynamic-layer
  "Creates a new and empty DynamicTilemapLayer. The currently selected layer in the map is set to this new layer.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * name (string) - The name of this layer. Must be unique within the map.
    * tileset (string | Array.<string> | Phaser.Tilemaps.Tileset | Array.<Phaser.Tilemaps.Tileset>) - The tileset, or an array of tilesets, used to render this layer. Can be a string or a Tileset object.
    * x (number) {optional} - The world x position where the top left of this layer will be placed.
    * y (number) {optional} - The world y position where the top left of this layer will be placed.
    * width (integer) {optional} - The width of the layer in tiles. If not specified, it will default to the map's width.
    * height (integer) {optional} - The height of the layer in tiles. If not specified, it will default to the map's height.
    * tile-width (integer) {optional} - The width of the tiles the layer uses for calculations. If not specified, it will default to the map's tileWidth.
    * tile-height (integer) {optional} - The height of the tiles the layer uses for calculations. If not specified, it will default to the map's tileHeight.

  Returns:  Phaser.Tilemaps.DynamicTilemapLayer - Returns the new layer that was created, or `null` if it failed."
  ([tilemap name tileset]
   (phaser->clj
    (.createBlankDynamicLayer tilemap
                              (clj->phaser name)
                              (clj->phaser tileset))))
  ([tilemap name tileset x]
   (phaser->clj
    (.createBlankDynamicLayer tilemap
                              (clj->phaser name)
                              (clj->phaser tileset)
                              (clj->phaser x))))
  ([tilemap name tileset x y]
   (phaser->clj
    (.createBlankDynamicLayer tilemap
                              (clj->phaser name)
                              (clj->phaser tileset)
                              (clj->phaser x)
                              (clj->phaser y))))
  ([tilemap name tileset x y width]
   (phaser->clj
    (.createBlankDynamicLayer tilemap
                              (clj->phaser name)
                              (clj->phaser tileset)
                              (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser width))))
  ([tilemap name tileset x y width height]
   (phaser->clj
    (.createBlankDynamicLayer tilemap
                              (clj->phaser name)
                              (clj->phaser tileset)
                              (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser width)
                              (clj->phaser height))))
  ([tilemap name tileset x y width height tile-width]
   (phaser->clj
    (.createBlankDynamicLayer tilemap
                              (clj->phaser name)
                              (clj->phaser tileset)
                              (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser width)
                              (clj->phaser height)
                              (clj->phaser tile-width))))
  ([tilemap name tileset x y width height tile-width tile-height]
   (phaser->clj
    (.createBlankDynamicLayer tilemap
                              (clj->phaser name)
                              (clj->phaser tileset)
                              (clj->phaser x)
                              (clj->phaser y)
                              (clj->phaser width)
                              (clj->phaser height)
                              (clj->phaser tile-width)
                              (clj->phaser tile-height)))))

(defn create-dynamic-layer
  "Creates a new DynamicTilemapLayer that renders the LayerData associated with the given
  `layerID`. The currently selected layer in the map is set to this new layer.

  The `layerID` is important. If you've created your map in Tiled then you can get this by
  looking in Tiled and looking at the layer name. Or you can open the JSON file it exports and
  look at the layers[].name value. Either way it must match.

  Unlike a static layer, a dynamic layer can be modified. See DynamicTilemapLayer for more
  information.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * layer-id (integer | string) - The layer array index value, or if a string is given, the layer name from Tiled.
    * tileset (string | Array.<string> | Phaser.Tilemaps.Tileset | Array.<Phaser.Tilemaps.Tileset>) - The tileset, or an array of tilesets, used to render this layer. Can be a string or a Tileset object.
    * x (number) {optional} - The x position to place the layer in the world. If not specified, it will default to the layer offset from Tiled or 0.
    * y (number) {optional} - The y position to place the layer in the world. If not specified, it will default to the layer offset from Tiled or 0.

  Returns:  Phaser.Tilemaps.DynamicTilemapLayer - Returns the new layer was created, or null if it failed."
  ([tilemap layer-id tileset]
   (phaser->clj
    (.createDynamicLayer tilemap
                         (clj->phaser layer-id)
                         (clj->phaser tileset))))
  ([tilemap layer-id tileset x]
   (phaser->clj
    (.createDynamicLayer tilemap
                         (clj->phaser layer-id)
                         (clj->phaser tileset)
                         (clj->phaser x))))
  ([tilemap layer-id tileset x y]
   (phaser->clj
    (.createDynamicLayer tilemap
                         (clj->phaser layer-id)
                         (clj->phaser tileset)
                         (clj->phaser x)
                         (clj->phaser y)))))

(defn create-from-objects
  "Creates a Sprite for every object matching the given gid in the map data. All properties from
  the map data objectgroup are copied into the `spriteConfig`, so you can use this as an easy
  way to configure Sprite properties from within the map editor. For example giving an object a
  property of alpha: 0.5 in the map editor will duplicate that when the Sprite is created.

  Custom object properties not sharing names with the Sprite's own properties are copied to the
  Sprite's {@link Phaser.GameObjects.Sprite#data data store}.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * name (string) - The name of the object layer (from Tiled) to create Sprites from.
    * id (integer | string) - Either the id (object), gid (tile object) or name (object or
tile object) from Tiled. Ids are unique in Tiled, but a gid is shared by all tile objects
with the same graphic. The same name can be used on multiple objects.
    * sprite-config (Phaser.Types.GameObjects.Sprite.SpriteConfig) - The config object to pass into the Sprite creator (i.e.
scene.make.sprite).
    * scene (Phaser.Scene) {optional} - The Scene to create the Sprites within.

  Returns:  Array.<Phaser.GameObjects.Sprite> - An array of the Sprites that were created."
  ([tilemap name id sprite-config]
   (phaser->clj
    (.createFromObjects tilemap
                        (clj->phaser name)
                        (clj->phaser id)
                        (clj->phaser sprite-config))))
  ([tilemap name id sprite-config scene]
   (phaser->clj
    (.createFromObjects tilemap
                        (clj->phaser name)
                        (clj->phaser id)
                        (clj->phaser sprite-config)
                        (clj->phaser scene)))))

(defn create-from-tiles
  "Creates a Sprite for every object matching the given tile indexes in the layer. You can
  optionally specify if each tile will be replaced with a new tile after the Sprite has been
  created. This is useful if you want to lay down special tiles in a level that are converted to
  Sprites, but want to replace the tile itself with a floor tile or similar once converted.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * indexes (integer | array) - The tile index, or array of indexes, to create Sprites from.
    * replacements (integer | array) - The tile index, or array of indexes, to change a converted
tile to. Set to `null` to leave the tiles unchanged. If an array is given, it is assumed to be a
one-to-one mapping with the indexes array.
    * sprite-config (Phaser.Types.GameObjects.Sprite.SpriteConfig) - The config object to pass into the Sprite creator (i.e. scene.make.sprite).
    * scene (Phaser.Scene) {optional} - The Scene to create the Sprites within.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Array.<Phaser.GameObjects.Sprite> - Returns an array of Tiles, or null if the layer given was invalid."
  ([tilemap indexes replacements sprite-config]
   (phaser->clj
    (.createFromTiles tilemap
                      (clj->phaser indexes)
                      (clj->phaser replacements)
                      (clj->phaser sprite-config))))
  ([tilemap indexes replacements sprite-config scene]
   (phaser->clj
    (.createFromTiles tilemap
                      (clj->phaser indexes)
                      (clj->phaser replacements)
                      (clj->phaser sprite-config)
                      (clj->phaser scene))))
  ([tilemap indexes replacements sprite-config scene camera]
   (phaser->clj
    (.createFromTiles tilemap
                      (clj->phaser indexes)
                      (clj->phaser replacements)
                      (clj->phaser sprite-config)
                      (clj->phaser scene)
                      (clj->phaser camera))))
  ([tilemap indexes replacements sprite-config scene camera layer]
   (phaser->clj
    (.createFromTiles tilemap
                      (clj->phaser indexes)
                      (clj->phaser replacements)
                      (clj->phaser sprite-config)
                      (clj->phaser scene)
                      (clj->phaser camera)
                      (clj->phaser layer)))))

(defn create-static-layer
  "Creates a new StaticTilemapLayer that renders the LayerData associated with the given
  `layerID`. The currently selected layer in the map is set to this new layer.

  The `layerID` is important. If you've created your map in Tiled then you can get this by
  looking in Tiled and looking at the layer name. Or you can open the JSON file it exports and
  look at the layers[].name value. Either way it must match.

  It's important to remember that a static layer cannot be modified. See StaticTilemapLayer for
  more information.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * layer-id (integer | string) - The layer array index value, or if a string is given, the layer name from Tiled.
    * tileset (string | Array.<string> | Phaser.Tilemaps.Tileset | Array.<Phaser.Tilemaps.Tileset>) - The tileset, or an array of tilesets, used to render this layer. Can be a string or a Tileset object.
    * x (number) {optional} - The x position to place the layer in the world. If not specified, it will default to the layer offset from Tiled or 0.
    * y (number) {optional} - The y position to place the layer in the world. If not specified, it will default to the layer offset from Tiled or 0.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - Returns the new layer was created, or null if it failed."
  ([tilemap layer-id tileset]
   (phaser->clj
    (.createStaticLayer tilemap
                        (clj->phaser layer-id)
                        (clj->phaser tileset))))
  ([tilemap layer-id tileset x]
   (phaser->clj
    (.createStaticLayer tilemap
                        (clj->phaser layer-id)
                        (clj->phaser tileset)
                        (clj->phaser x))))
  ([tilemap layer-id tileset x y]
   (phaser->clj
    (.createStaticLayer tilemap
                        (clj->phaser layer-id)
                        (clj->phaser tileset)
                        (clj->phaser x)
                        (clj->phaser y)))))

(defn destroy
  "Removes all layer data from this Tilemap and nulls the scene reference. This will destroy any
  StaticTilemapLayers or DynamicTilemapLayers that have been linked to LayerData."
  ([tilemap]
   (phaser->clj
    (.destroy tilemap))))

(defn destroy-layer
  "Destroys the given TilemapLayer and removes it from this Tilemap.

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to be destroyed.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap]
   (phaser->clj
    (.destroyLayer tilemap)))
  ([tilemap layer]
   (phaser->clj
    (.destroyLayer tilemap
                   (clj->phaser layer)))))

(defn fill
  "Sets the tiles in the given rectangular area (in tile coordinates) of the layer with the
  specified index. Tiles will be set to collide if the given index is a colliding index.
  Collision information in the region will be recalculated.

  If no layer specified, the map's current layer is used.
  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * index (integer) - The tile index to fill the area with.
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * recalculate-faces (boolean) {optional} - `true` if the faces data should be recalculated.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap index]
   (phaser->clj
    (.fill tilemap
           (clj->phaser index))))
  ([tilemap index tile-x]
   (phaser->clj
    (.fill tilemap
           (clj->phaser index)
           (clj->phaser tile-x))))
  ([tilemap index tile-x tile-y]
   (phaser->clj
    (.fill tilemap
           (clj->phaser index)
           (clj->phaser tile-x)
           (clj->phaser tile-y))))
  ([tilemap index tile-x tile-y width]
   (phaser->clj
    (.fill tilemap
           (clj->phaser index)
           (clj->phaser tile-x)
           (clj->phaser tile-y)
           (clj->phaser width))))
  ([tilemap index tile-x tile-y width height]
   (phaser->clj
    (.fill tilemap
           (clj->phaser index)
           (clj->phaser tile-x)
           (clj->phaser tile-y)
           (clj->phaser width)
           (clj->phaser height))))
  ([tilemap index tile-x tile-y width height recalculate-faces]
   (phaser->clj
    (.fill tilemap
           (clj->phaser index)
           (clj->phaser tile-x)
           (clj->phaser tile-y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser recalculate-faces))))
  ([tilemap index tile-x tile-y width height recalculate-faces layer]
   (phaser->clj
    (.fill tilemap
           (clj->phaser index)
           (clj->phaser tile-x)
           (clj->phaser tile-y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser recalculate-faces)
           (clj->phaser layer)))))

(defn filter-objects
  "For each object in the given object layer, run the given filter callback function. Any
  objects that pass the filter test (i.e. where the callback returns true) will returned as a
  new array. Similar to Array.prototype.Filter in vanilla JS.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * object-layer (Phaser.Tilemaps.ObjectLayer | string) - The name of an object layer (from Tiled) or an ObjectLayer instance.
    * callback (TilemapFilterCallback) - The callback. Each object in the given area will be passed to this callback as the first and only parameter.
    * context (object) {optional} - The context under which the callback should be run.

  Returns:  Array.<Phaser.GameObjects.GameObject> - An array of object that match the search, or null if the objectLayer given was invalid."
  ([tilemap object-layer callback]
   (phaser->clj
    (.filterObjects tilemap
                    (clj->phaser object-layer)
                    (clj->phaser callback))))
  ([tilemap object-layer callback context]
   (phaser->clj
    (.filterObjects tilemap
                    (clj->phaser object-layer)
                    (clj->phaser callback)
                    (clj->phaser context)))))

(defn filter-tiles
  "For each tile in the given rectangular area (in tile coordinates) of the layer, run the given
  filter callback function. Any tiles that pass the filter test (i.e. where the callback returns
  true) will returned as a new array. Similar to Array.prototype.Filter in vanilla JS.
  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * callback (function) - The callback. Each tile in the given area will be passed to this
callback as the first and only parameter. The callback should return true for tiles that pass the
filter.
    * context (object) {optional} - The context under which the callback should be run.
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area to filter.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area to filter.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Array.<Phaser.Tilemaps.Tile> - Returns an array of Tiles, or null if the layer given was invalid."
  ([tilemap callback]
   (phaser->clj
    (.filterTiles tilemap
                  (clj->phaser callback))))
  ([tilemap callback context]
   (phaser->clj
    (.filterTiles tilemap
                  (clj->phaser callback)
                  (clj->phaser context))))
  ([tilemap callback context tile-x]
   (phaser->clj
    (.filterTiles tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x))))
  ([tilemap callback context tile-x tile-y]
   (phaser->clj
    (.filterTiles tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y))))
  ([tilemap callback context tile-x tile-y width]
   (phaser->clj
    (.filterTiles tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width))))
  ([tilemap callback context tile-x tile-y width height]
   (phaser->clj
    (.filterTiles tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([tilemap callback context tile-x tile-y width height filtering-options]
   (phaser->clj
    (.filterTiles tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser filtering-options))))
  ([tilemap callback context tile-x tile-y width height filtering-options layer]
   (phaser->clj
    (.filterTiles tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser filtering-options)
                  (clj->phaser layer)))))

(defn find-by-index
  "Searches the entire map layer for the first tile matching the given index, then returns that Tile
  object. If no match is found, it returns null. The search starts from the top-left tile and
  continues horizontally until it hits the end of the row, then it drops down to the next column.
  If the reverse boolean is true, it scans starting from the bottom-right corner traveling up to
  the top-left.
  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * index (integer) - The tile index value to search for.
    * skip (integer) {optional} - The number of times to skip a matching tile before returning.
    * reverse (boolean) {optional} - If true it will scan the layer in reverse, starting at the bottom-right. Otherwise it scans from the top-left.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tile - Returns a Tiles, or null if the layer given was invalid."
  ([tilemap index]
   (phaser->clj
    (.findByIndex tilemap
                  (clj->phaser index))))
  ([tilemap index skip]
   (phaser->clj
    (.findByIndex tilemap
                  (clj->phaser index)
                  (clj->phaser skip))))
  ([tilemap index skip reverse]
   (phaser->clj
    (.findByIndex tilemap
                  (clj->phaser index)
                  (clj->phaser skip)
                  (clj->phaser reverse))))
  ([tilemap index skip reverse layer]
   (phaser->clj
    (.findByIndex tilemap
                  (clj->phaser index)
                  (clj->phaser skip)
                  (clj->phaser reverse)
                  (clj->phaser layer)))))

(defn find-object
  "Find the first object in the given object layer that satisfies the provided testing function.
  I.e. finds the first object for which `callback` returns true. Similar to
  Array.prototype.find in vanilla JS.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * object-layer (Phaser.Tilemaps.ObjectLayer | string) - The name of an object layer (from Tiled) or an ObjectLayer instance.
    * callback (TilemapFindCallback) - The callback. Each object in the given area will be passed to this callback as the first and only parameter.
    * context (object) {optional} - The context under which the callback should be run.

  Returns:  Phaser.GameObjects.GameObject - An object that matches the search, or null if no object found."
  ([tilemap object-layer callback]
   (phaser->clj
    (.findObject tilemap
                 (clj->phaser object-layer)
                 (clj->phaser callback))))
  ([tilemap object-layer callback context]
   (phaser->clj
    (.findObject tilemap
                 (clj->phaser object-layer)
                 (clj->phaser callback)
                 (clj->phaser context)))))

(defn find-tile
  "Find the first tile in the given rectangular area (in tile coordinates) of the layer that
  satisfies the provided testing function. I.e. finds the first tile for which `callback` returns
  true. Similar to Array.prototype.find in vanilla JS.
  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * callback (FindTileCallback) - The callback. Each tile in the given area will be passed to this callback as the first and only parameter.
    * context (object) {optional} - The context under which the callback should be run.
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area to search.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area to search.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The Tile layer to run the search on. If not provided will use the current layer.

  Returns:  Phaser.Tilemaps.Tile - Returns a Tiles, or null if the layer given was invalid."
  ([tilemap callback]
   (phaser->clj
    (.findTile tilemap
               (clj->phaser callback))))
  ([tilemap callback context]
   (phaser->clj
    (.findTile tilemap
               (clj->phaser callback)
               (clj->phaser context))))
  ([tilemap callback context tile-x]
   (phaser->clj
    (.findTile tilemap
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x))))
  ([tilemap callback context tile-x tile-y]
   (phaser->clj
    (.findTile tilemap
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y))))
  ([tilemap callback context tile-x tile-y width]
   (phaser->clj
    (.findTile tilemap
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y)
               (clj->phaser width))))
  ([tilemap callback context tile-x tile-y width height]
   (phaser->clj
    (.findTile tilemap
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y)
               (clj->phaser width)
               (clj->phaser height))))
  ([tilemap callback context tile-x tile-y width height filtering-options]
   (phaser->clj
    (.findTile tilemap
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y)
               (clj->phaser width)
               (clj->phaser height)
               (clj->phaser filtering-options))))
  ([tilemap callback context tile-x tile-y width height filtering-options layer]
   (phaser->clj
    (.findTile tilemap
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y)
               (clj->phaser width)
               (clj->phaser height)
               (clj->phaser filtering-options)
               (clj->phaser layer)))))

(defn for-each-tile
  "For each tile in the given rectangular area (in tile coordinates) of the layer, run the given
  callback. Similar to Array.prototype.forEach in vanilla JS.

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * callback (EachTileCallback) - The callback. Each tile in the given area will be passed to this callback as the first and only parameter.
    * context (object) {optional} - The context under which the callback should be run.
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area to search.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area to search.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The Tile layer to run the search on. If not provided will use the current layer.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap callback]
   (phaser->clj
    (.forEachTile tilemap
                  (clj->phaser callback))))
  ([tilemap callback context]
   (phaser->clj
    (.forEachTile tilemap
                  (clj->phaser callback)
                  (clj->phaser context))))
  ([tilemap callback context tile-x]
   (phaser->clj
    (.forEachTile tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x))))
  ([tilemap callback context tile-x tile-y]
   (phaser->clj
    (.forEachTile tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y))))
  ([tilemap callback context tile-x tile-y width]
   (phaser->clj
    (.forEachTile tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width))))
  ([tilemap callback context tile-x tile-y width height]
   (phaser->clj
    (.forEachTile tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([tilemap callback context tile-x tile-y width height filtering-options]
   (phaser->clj
    (.forEachTile tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser filtering-options))))
  ([tilemap callback context tile-x tile-y width height filtering-options layer]
   (phaser->clj
    (.forEachTile tilemap
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser filtering-options)
                  (clj->phaser layer)))))

(defn get-image-index
  "Gets the image layer index based on its name.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * name (string) - The name of the image to get.

  Returns:  integer - The index of the image in this tilemap, or null if not found."
  ([tilemap name]
   (phaser->clj
    (.getImageIndex tilemap
                    (clj->phaser name)))))

(defn get-index
  "Internally used. Returns the index of the object in one of the Tilemaps arrays whose name
  property matches the given `name`.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * location (array) - The Tilemap array to search.
    * name (string) - The name of the array element to get.

  Returns:  number - The index of the element in the array, or null if not found."
  ([tilemap location name]
   (phaser->clj
    (.getIndex tilemap
               (clj->phaser location)
               (clj->phaser name)))))

(defn get-layer
  "Gets the LayerData from this.layers that is associated with `layer`, or null if an invalid
  `layer` is given.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The name of the
layer from Tiled, the index of the layer in the map, a DynamicTilemapLayer or a
StaticTilemapLayer. If not given will default to the maps current layer index.

  Returns:  Phaser.Tilemaps.LayerData - The corresponding LayerData within this.layers."
  ([tilemap]
   (phaser->clj
    (.getLayer tilemap)))
  ([tilemap layer]
   (phaser->clj
    (.getLayer tilemap
               (clj->phaser layer)))))

(defn get-layer-index
  "Gets the LayerData index of the given `layer` within this.layers, or null if an invalid
  `layer` is given.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The name of the
layer from Tiled, the index of the layer in the map, a DynamicTilemapLayer or a
StaticTilemapLayer. If not given will default to the map's current layer index.

  Returns:  integer - The LayerData index within this.layers."
  ([tilemap]
   (phaser->clj
    (.getLayerIndex tilemap)))
  ([tilemap layer]
   (phaser->clj
    (.getLayerIndex tilemap
                    (clj->phaser layer)))))

(defn get-layer-index-by-name
  "Gets the index of the LayerData within this.layers that has the given `name`, or null if an
  invalid `name` is given.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * name (string) - The name of the layer to get.

  Returns:  integer - The LayerData index within this.layers."
  ([tilemap name]
   (phaser->clj
    (.getLayerIndexByName tilemap
                          (clj->phaser name)))))

(defn get-object-layer
  "Gets the ObjectLayer from this.objects that has the given `name`, or null if no ObjectLayer
  is found with that name.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * name (string) {optional} - The name of the object layer from Tiled.

  Returns:  Phaser.Tilemaps.ObjectLayer - The corresponding ObjectLayer within this.objects or null."
  ([tilemap]
   (phaser->clj
    (.getObjectLayer tilemap)))
  ([tilemap name]
   (phaser->clj
    (.getObjectLayer tilemap
                     (clj->phaser name)))))

(defn get-tile-at
  "Gets a tile at the given tile coordinates from the given layer.
  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) - X position to get the tile from (given in tile units, not pixels).
    * tile-y (integer) - Y position to get the tile from (given in tile units, not pixels).
    * non-null (boolean) {optional} - If true getTile won't return null for empty tiles, but a Tile object with an index of -1.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tile - Returns a Tile, or null if the layer given was invalid."
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.getTileAt tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y))))
  ([tilemap tile-x tile-y non-null]
   (phaser->clj
    (.getTileAt tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser non-null))))
  ([tilemap tile-x tile-y non-null layer]
   (phaser->clj
    (.getTileAt tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser non-null)
                (clj->phaser layer)))))

(defn get-tile-at-world-xy
  "Gets a tile at the given world coordinates from the given layer.
  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * world-x (number) - X position to get the tile from (given in pixels)
    * world-y (number) - Y position to get the tile from (given in pixels)
    * non-null (boolean) {optional} - If true, function won't return null for empty tiles, but a Tile object with an index of -1.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tile - Returns a Tile, or null if the layer given was invalid."
  ([tilemap world-x world-y]
   (phaser->clj
    (.getTileAtWorldXY tilemap
                       (clj->phaser world-x)
                       (clj->phaser world-y))))
  ([tilemap world-x world-y non-null]
   (phaser->clj
    (.getTileAtWorldXY tilemap
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser non-null))))
  ([tilemap world-x world-y non-null camera]
   (phaser->clj
    (.getTileAtWorldXY tilemap
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser non-null)
                       (clj->phaser camera))))
  ([tilemap world-x world-y non-null camera layer]
   (phaser->clj
    (.getTileAtWorldXY tilemap
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser non-null)
                       (clj->phaser camera)
                       (clj->phaser layer)))))

(defn get-tiles-within
  "Gets the tiles in the given rectangular area (in tile coordinates) of the layer.
  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Array.<Phaser.Tilemaps.Tile> - Returns an array of Tiles, or null if the layer given was invalid."
  ([tilemap]
   (phaser->clj
    (.getTilesWithin tilemap)))
  ([tilemap tile-x]
   (phaser->clj
    (.getTilesWithin tilemap
                     (clj->phaser tile-x))))
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.getTilesWithin tilemap
                     (clj->phaser tile-x)
                     (clj->phaser tile-y))))
  ([tilemap tile-x tile-y width]
   (phaser->clj
    (.getTilesWithin tilemap
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width))))
  ([tilemap tile-x tile-y width height]
   (phaser->clj
    (.getTilesWithin tilemap
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width)
                     (clj->phaser height))))
  ([tilemap tile-x tile-y width height filtering-options]
   (phaser->clj
    (.getTilesWithin tilemap
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width)
                     (clj->phaser height)
                     (clj->phaser filtering-options))))
  ([tilemap tile-x tile-y width height filtering-options layer]
   (phaser->clj
    (.getTilesWithin tilemap
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width)
                     (clj->phaser height)
                     (clj->phaser filtering-options)
                     (clj->phaser layer)))))

(defn get-tiles-within-shape
  "Gets the tiles that overlap with the given shape in the given layer. The shape must be a Circle,
  Line, Rectangle or Triangle. The shape should be in world coordinates.
  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * shape (Phaser.Geom.Circle | Phaser.Geom.Line | Phaser.Geom.Rectangle | Phaser.Geom.Triangle) - A shape in world (pixel) coordinates
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when factoring in which tiles to return.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Array.<Phaser.Tilemaps.Tile> - Returns an array of Tiles, or null if the layer given was invalid."
  ([tilemap shape]
   (phaser->clj
    (.getTilesWithinShape tilemap
                          (clj->phaser shape))))
  ([tilemap shape filtering-options]
   (phaser->clj
    (.getTilesWithinShape tilemap
                          (clj->phaser shape)
                          (clj->phaser filtering-options))))
  ([tilemap shape filtering-options camera]
   (phaser->clj
    (.getTilesWithinShape tilemap
                          (clj->phaser shape)
                          (clj->phaser filtering-options)
                          (clj->phaser camera))))
  ([tilemap shape filtering-options camera layer]
   (phaser->clj
    (.getTilesWithinShape tilemap
                          (clj->phaser shape)
                          (clj->phaser filtering-options)
                          (clj->phaser camera)
                          (clj->phaser layer)))))

(defn get-tiles-within-world-xy
  "Gets the tiles in the given rectangular area (in world coordinates) of the layer.
  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * world-x (number) - The world x coordinate for the top-left of the area.
    * world-y (number) - The world y coordinate for the top-left of the area.
    * width (number) - The width of the area.
    * height (number) - The height of the area.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when factoring in which tiles to return.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Array.<Phaser.Tilemaps.Tile> - Returns an array of Tiles, or null if the layer given was invalid."
  ([tilemap world-x world-y width height]
   (phaser->clj
    (.getTilesWithinWorldXY tilemap
                            (clj->phaser world-x)
                            (clj->phaser world-y)
                            (clj->phaser width)
                            (clj->phaser height))))
  ([tilemap world-x world-y width height filtering-options]
   (phaser->clj
    (.getTilesWithinWorldXY tilemap
                            (clj->phaser world-x)
                            (clj->phaser world-y)
                            (clj->phaser width)
                            (clj->phaser height)
                            (clj->phaser filtering-options))))
  ([tilemap world-x world-y width height filtering-options camera]
   (phaser->clj
    (.getTilesWithinWorldXY tilemap
                            (clj->phaser world-x)
                            (clj->phaser world-y)
                            (clj->phaser width)
                            (clj->phaser height)
                            (clj->phaser filtering-options)
                            (clj->phaser camera))))
  ([tilemap world-x world-y width height filtering-options camera layer]
   (phaser->clj
    (.getTilesWithinWorldXY tilemap
                            (clj->phaser world-x)
                            (clj->phaser world-y)
                            (clj->phaser width)
                            (clj->phaser height)
                            (clj->phaser filtering-options)
                            (clj->phaser camera)
                            (clj->phaser layer)))))

(defn get-tileset
  "Gets the Tileset that has the given `name`, or null if an invalid `name` is given.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * name (string) - The name of the Tileset to get.

  Returns:  Phaser.Tilemaps.Tileset - The Tileset, or `null` if no matching named tileset was found."
  ([tilemap name]
   (phaser->clj
    (.getTileset tilemap
                 (clj->phaser name)))))

(defn get-tileset-index
  "Gets the index of the Tileset within this.tilesets that has the given `name`, or null if an
  invalid `name` is given.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * name (string) - The name of the Tileset to get.

  Returns:  integer - The Tileset index within this.tilesets."
  ([tilemap name]
   (phaser->clj
    (.getTilesetIndex tilemap
                      (clj->phaser name)))))

(defn has-tile-at
  "Checks if there is a tile at the given location (in tile coordinates) in the given layer. Returns
  false if there is no tile or if the tile at that location has an index of -1.

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) - The x coordinate, in tiles, not pixels.
    * tile-y (integer) - The y coordinate, in tiles, not pixels.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  boolean - Returns a boolean, or null if the layer given was invalid."
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.hasTileAt tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y))))
  ([tilemap tile-x tile-y layer]
   (phaser->clj
    (.hasTileAt tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser layer)))))

(defn has-tile-at-world-xy
  "Checks if there is a tile at the given location (in world coordinates) in the given layer. Returns
  false if there is no tile or if the tile at that location has an index of -1.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * world-x (number) - The x coordinate, in pixels.
    * world-y (number) - The y coordinate, in pixels.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when factoring in which tiles to return.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  boolean - Returns a boolean, or null if the layer given was invalid."
  ([tilemap world-x world-y]
   (phaser->clj
    (.hasTileAtWorldXY tilemap
                       (clj->phaser world-x)
                       (clj->phaser world-y))))
  ([tilemap world-x world-y camera]
   (phaser->clj
    (.hasTileAtWorldXY tilemap
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser camera))))
  ([tilemap world-x world-y camera layer]
   (phaser->clj
    (.hasTileAtWorldXY tilemap
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser camera)
                       (clj->phaser layer)))))

(defn put-tile-at
  "Puts a tile at the given tile coordinates in the specified layer. You can pass in either an index
  or a Tile object. If you pass in a Tile, all attributes will be copied over to the specified
  location. If you pass in an index, only the index at the specified location will be changed.
  Collision information will be recalculated at the specified location.

  If no layer specified, the maps current layer is used.

  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile (integer | Phaser.Tilemaps.Tile) - The index of this tile to set or a Tile object.
    * tile-x (integer) - The x coordinate, in tiles, not pixels.
    * tile-y (integer) - The y coordinate, in tiles, not pixels.
    * recalculate-faces (boolean) {optional} - `true` if the faces data should be recalculated.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tile - Returns a Tile, or null if the layer given was invalid or the coordinates were out of bounds."
  ([tilemap tile tile-x tile-y]
   (phaser->clj
    (.putTileAt tilemap
                (clj->phaser tile)
                (clj->phaser tile-x)
                (clj->phaser tile-y))))
  ([tilemap tile tile-x tile-y recalculate-faces]
   (phaser->clj
    (.putTileAt tilemap
                (clj->phaser tile)
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser recalculate-faces))))
  ([tilemap tile tile-x tile-y recalculate-faces layer]
   (phaser->clj
    (.putTileAt tilemap
                (clj->phaser tile)
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser recalculate-faces)
                (clj->phaser layer)))))

(defn put-tile-at-world-xy
  "Puts a tile at the given world coordinates (pixels) in the specified layer. You can pass in either
  an index or a Tile object. If you pass in a Tile, all attributes will be copied over to the
  specified location. If you pass in an index, only the index at the specified location will be
  changed. Collision information will be recalculated at the specified location.

  If no layer specified, the maps current layer is used. This
  cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile (integer | Phaser.Tilemaps.Tile) - The index of this tile to set or a Tile object.
    * world-x (number) - The x coordinate, in pixels.
    * world-y (number) - The y coordinate, in pixels.
    * recalculate-faces (boolean) {optional} - `true` if the faces data should be recalculated.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tile - Returns a Tile, or null if the layer given was invalid."
  ([tilemap tile world-x world-y]
   (phaser->clj
    (.putTileAtWorldXY tilemap
                       (clj->phaser tile)
                       (clj->phaser world-x)
                       (clj->phaser world-y))))
  ([tilemap tile world-x world-y recalculate-faces]
   (phaser->clj
    (.putTileAtWorldXY tilemap
                       (clj->phaser tile)
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser recalculate-faces))))
  ([tilemap tile world-x world-y recalculate-faces camera]
   (phaser->clj
    (.putTileAtWorldXY tilemap
                       (clj->phaser tile)
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser recalculate-faces)
                       (clj->phaser camera))))
  ([tilemap tile world-x world-y recalculate-faces camera layer]
   (phaser->clj
    (.putTileAtWorldXY tilemap
                       (clj->phaser tile)
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser recalculate-faces)
                       (clj->phaser camera)
                       (clj->phaser layer)))))

(defn put-tiles-at
  "Puts an array of tiles or a 2D array of tiles at the given tile coordinates in the specified
  layer. The array can be composed of either tile indexes or Tile objects. If you pass in a Tile,
  all attributes will be copied over to the specified location. If you pass in an index, only the
  index at the specified location will be changed. Collision information will be recalculated
  within the region tiles were changed.

  If no layer specified, the maps current layer is used.
  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile (Array.<integer> | Array.<Array.<integer>> | Array.<Phaser.Tilemaps.Tile> | Array.<Array.<Phaser.Tilemaps.Tile>>) - A row (array) or grid (2D array) of Tiles or tile indexes to place.
    * tile-x (integer) - The x coordinate, in tiles, not pixels.
    * tile-y (integer) - The y coordinate, in tiles, not pixels.
    * recalculate-faces (boolean) {optional} - `true` if the faces data should be recalculated.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap tile tile-x tile-y]
   (phaser->clj
    (.putTilesAt tilemap
                 (clj->phaser tile)
                 (clj->phaser tile-x)
                 (clj->phaser tile-y))))
  ([tilemap tile tile-x tile-y recalculate-faces]
   (phaser->clj
    (.putTilesAt tilemap
                 (clj->phaser tile)
                 (clj->phaser tile-x)
                 (clj->phaser tile-y)
                 (clj->phaser recalculate-faces))))
  ([tilemap tile tile-x tile-y recalculate-faces layer]
   (phaser->clj
    (.putTilesAt tilemap
                 (clj->phaser tile)
                 (clj->phaser tile-x)
                 (clj->phaser tile-y)
                 (clj->phaser recalculate-faces)
                 (clj->phaser layer)))))

(defn randomize
  "Randomizes the indexes of a rectangular region of tiles (in tile coordinates) within the
  specified layer. Each tile will receive a new index. If an array of indexes is passed in, then
  those will be used for randomly assigning new tile indexes. If an array is not provided, the
  indexes found within the region (excluding -1) will be used for randomly assigning new tile
  indexes. This method only modifies tile indexes and does not change collision information.

  If no layer specified, the maps current layer is used.
  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * indexes (Array.<integer>) {optional} - An array of indexes to randomly draw from during randomization.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap]
   (phaser->clj
    (.randomize tilemap)))
  ([tilemap tile-x]
   (phaser->clj
    (.randomize tilemap
                (clj->phaser tile-x))))
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.randomize tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y))))
  ([tilemap tile-x tile-y width]
   (phaser->clj
    (.randomize tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser width))))
  ([tilemap tile-x tile-y width height]
   (phaser->clj
    (.randomize tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser width)
                (clj->phaser height))))
  ([tilemap tile-x tile-y width height indexes]
   (phaser->clj
    (.randomize tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser indexes))))
  ([tilemap tile-x tile-y width height indexes layer]
   (phaser->clj
    (.randomize tilemap
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser indexes)
                (clj->phaser layer)))))

(defn remove-all-layers
  "Removes all layers from this Tilemap and destroys any associated StaticTilemapLayers or
  DynamicTilemapLayers.

  Returns:  Phaser.Tilemaps.Tilemap - This Tilemap object."
  ([tilemap]
   (phaser->clj
    (.removeAllLayers tilemap))))

(defn remove-layer
  "Removes the given TilemapLayer from this Tilemap without destroying it.

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to be removed.

  Returns:  Phaser.Tilemaps.Tilemap - Returns this, or null if the layer given was invalid."
  ([tilemap]
   (phaser->clj
    (.removeLayer tilemap)))
  ([tilemap layer]
   (phaser->clj
    (.removeLayer tilemap
                  (clj->phaser layer)))))

(defn remove-tile
  "Removes the given Tile, or an array of Tiles, from the layer to which they belong,
  and optionally recalculates the collision information.

  This cannot be applied to Tiles that belong to Static Tilemap Layers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tiles (Phaser.Tilemaps.Tile | Array.<Phaser.Tilemaps.Tile>) - The Tile to remove, or an array of Tiles.
    * replace-index (integer) {optional} - After removing the Tile, insert a brand new Tile into its location with the given index. Leave as -1 to just remove the tile.
    * recalculate-faces (boolean) {optional} - `true` if the faces data should be recalculated.

  Returns:  Array.<Phaser.Tilemaps.Tile> - Returns an array of Tiles that were removed."
  ([tilemap tiles]
   (phaser->clj
    (.removeTile tilemap
                 (clj->phaser tiles))))
  ([tilemap tiles replace-index]
   (phaser->clj
    (.removeTile tilemap
                 (clj->phaser tiles)
                 (clj->phaser replace-index))))
  ([tilemap tiles replace-index recalculate-faces]
   (phaser->clj
    (.removeTile tilemap
                 (clj->phaser tiles)
                 (clj->phaser replace-index)
                 (clj->phaser recalculate-faces)))))

(defn remove-tile-at
  "Removes the tile at the given tile coordinates in the specified layer and updates the layer's
  collision information.

  If no layer specified, the maps current layer is used.
  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) - The x coordinate, in tiles, not pixels.
    * tile-y (integer) - The y coordinate, in tiles, not pixels.
    * replace-with-null (boolean) {optional} - If true, this will replace the tile at the specified location with null instead of a Tile with an index of -1.
    * recalculate-faces (boolean) {optional} - `true` if the faces data should be recalculated.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tile - Returns the Tile that was removed, or null if the layer given was invalid."
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.removeTileAt tilemap
                   (clj->phaser tile-x)
                   (clj->phaser tile-y))))
  ([tilemap tile-x tile-y replace-with-null]
   (phaser->clj
    (.removeTileAt tilemap
                   (clj->phaser tile-x)
                   (clj->phaser tile-y)
                   (clj->phaser replace-with-null))))
  ([tilemap tile-x tile-y replace-with-null recalculate-faces]
   (phaser->clj
    (.removeTileAt tilemap
                   (clj->phaser tile-x)
                   (clj->phaser tile-y)
                   (clj->phaser replace-with-null)
                   (clj->phaser recalculate-faces))))
  ([tilemap tile-x tile-y replace-with-null recalculate-faces layer]
   (phaser->clj
    (.removeTileAt tilemap
                   (clj->phaser tile-x)
                   (clj->phaser tile-y)
                   (clj->phaser replace-with-null)
                   (clj->phaser recalculate-faces)
                   (clj->phaser layer)))))

(defn remove-tile-at-world-xy
  "Removes the tile at the given world coordinates in the specified layer and updates the layer's
  collision information.

  If no layer specified, the maps current layer is used.
  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * world-x (number) - The x coordinate, in pixels.
    * world-y (number) - The y coordinate, in pixels.
    * replace-with-null (boolean) {optional} - If true, this will replace the tile at the specified location with null instead of a Tile with an index of -1.
    * recalculate-faces (boolean) {optional} - `true` if the faces data should be recalculated.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tile - Returns a Tile, or null if the layer given was invalid."
  ([tilemap world-x world-y]
   (phaser->clj
    (.removeTileAtWorldXY tilemap
                          (clj->phaser world-x)
                          (clj->phaser world-y))))
  ([tilemap world-x world-y replace-with-null]
   (phaser->clj
    (.removeTileAtWorldXY tilemap
                          (clj->phaser world-x)
                          (clj->phaser world-y)
                          (clj->phaser replace-with-null))))
  ([tilemap world-x world-y replace-with-null recalculate-faces]
   (phaser->clj
    (.removeTileAtWorldXY tilemap
                          (clj->phaser world-x)
                          (clj->phaser world-y)
                          (clj->phaser replace-with-null)
                          (clj->phaser recalculate-faces))))
  ([tilemap world-x world-y replace-with-null recalculate-faces camera]
   (phaser->clj
    (.removeTileAtWorldXY tilemap
                          (clj->phaser world-x)
                          (clj->phaser world-y)
                          (clj->phaser replace-with-null)
                          (clj->phaser recalculate-faces)
                          (clj->phaser camera))))
  ([tilemap world-x world-y replace-with-null recalculate-faces camera layer]
   (phaser->clj
    (.removeTileAtWorldXY tilemap
                          (clj->phaser world-x)
                          (clj->phaser world-y)
                          (clj->phaser replace-with-null)
                          (clj->phaser recalculate-faces)
                          (clj->phaser camera)
                          (clj->phaser layer)))))

(defn render-debug
  "Draws a debug representation of the layer to the given Graphics. This is helpful when you want to
  get a quick idea of which of your tiles are colliding and which have interesting faces. The tiles
  are drawn starting at (0, 0) in the Graphics, allowing you to place the debug representation
  wherever you want on the screen.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The target Graphics object to draw upon.
    * style-config (Phaser.Types.Tilemaps.StyleConfig) - An object specifying the colors to use for the debug drawing.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap graphics style-config]
   (phaser->clj
    (.renderDebug tilemap
                  (clj->phaser graphics)
                  (clj->phaser style-config))))
  ([tilemap graphics style-config layer]
   (phaser->clj
    (.renderDebug tilemap
                  (clj->phaser graphics)
                  (clj->phaser style-config)
                  (clj->phaser layer)))))

(defn render-debug-full
  "Draws a debug representation of all layers within this Tilemap to the given Graphics object.

  This is helpful when you want to get a quick idea of which of your tiles are colliding and which
  have interesting faces. The tiles are drawn starting at (0, 0) in the Graphics, allowing you to
  place the debug representation wherever you want on the screen.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The target Graphics object to draw upon.
    * style-config (Phaser.Types.Tilemaps.StyleConfig) - An object specifying the colors to use for the debug drawing.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap graphics style-config]
   (phaser->clj
    (.renderDebugFull tilemap
                      (clj->phaser graphics)
                      (clj->phaser style-config))))
  ([tilemap graphics style-config layer]
   (phaser->clj
    (.renderDebugFull tilemap
                      (clj->phaser graphics)
                      (clj->phaser style-config)
                      (clj->phaser layer)))))

(defn replace-by-index
  "Scans the given rectangular area (given in tile coordinates) for tiles with an index matching
  `findIndex` and updates their index to match `newIndex`. This only modifies the index and does
  not change collision information.

  If no layer specified, the maps current layer is used.
  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * find-index (integer) - The index of the tile to search for.
    * new-index (integer) - The index of the tile to replace it with.
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap find-index new-index]
   (phaser->clj
    (.replaceByIndex tilemap
                     (clj->phaser find-index)
                     (clj->phaser new-index))))
  ([tilemap find-index new-index tile-x]
   (phaser->clj
    (.replaceByIndex tilemap
                     (clj->phaser find-index)
                     (clj->phaser new-index)
                     (clj->phaser tile-x))))
  ([tilemap find-index new-index tile-x tile-y]
   (phaser->clj
    (.replaceByIndex tilemap
                     (clj->phaser find-index)
                     (clj->phaser new-index)
                     (clj->phaser tile-x)
                     (clj->phaser tile-y))))
  ([tilemap find-index new-index tile-x tile-y width]
   (phaser->clj
    (.replaceByIndex tilemap
                     (clj->phaser find-index)
                     (clj->phaser new-index)
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width))))
  ([tilemap find-index new-index tile-x tile-y width height]
   (phaser->clj
    (.replaceByIndex tilemap
                     (clj->phaser find-index)
                     (clj->phaser new-index)
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width)
                     (clj->phaser height))))
  ([tilemap find-index new-index tile-x tile-y width height layer]
   (phaser->clj
    (.replaceByIndex tilemap
                     (clj->phaser find-index)
                     (clj->phaser new-index)
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width)
                     (clj->phaser height)
                     (clj->phaser layer)))))

(defn set-base-tile-size
  "Sets the base tile size for the map. Note: this does not necessarily match the tileWidth and
  tileHeight for all layers. This also updates the base size on all tiles across all layers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-width (integer) - The width of the tiles the map uses for calculations.
    * tile-height (integer) - The height of the tiles the map uses for calculations.

  Returns:  Phaser.Tilemaps.Tilemap - This Tilemap object."
  ([tilemap tile-width tile-height]
   (phaser->clj
    (.setBaseTileSize tilemap
                      (clj->phaser tile-width)
                      (clj->phaser tile-height)))))

(defn set-collision
  "Sets collision on the given tile or tiles within a layer by index. You can pass in either a
  single numeric index or an array of indexes: [2, 3, 15, 20]. The `collides` parameter controls if
  collision will be enabled (true) or disabled (false).

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * indexes (integer | array) - Either a single tile index, or an array of tile indexes.
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the update.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.
    * update-layer (boolean) {optional} - If true, updates the current tiles on the layer. Set to false if no tiles have been placed for significant performance boost.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap indexes]
   (phaser->clj
    (.setCollision tilemap
                   (clj->phaser indexes))))
  ([tilemap indexes collides]
   (phaser->clj
    (.setCollision tilemap
                   (clj->phaser indexes)
                   (clj->phaser collides))))
  ([tilemap indexes collides recalculate-faces]
   (phaser->clj
    (.setCollision tilemap
                   (clj->phaser indexes)
                   (clj->phaser collides)
                   (clj->phaser recalculate-faces))))
  ([tilemap indexes collides recalculate-faces layer]
   (phaser->clj
    (.setCollision tilemap
                   (clj->phaser indexes)
                   (clj->phaser collides)
                   (clj->phaser recalculate-faces)
                   (clj->phaser layer))))
  ([tilemap indexes collides recalculate-faces layer update-layer]
   (phaser->clj
    (.setCollision tilemap
                   (clj->phaser indexes)
                   (clj->phaser collides)
                   (clj->phaser recalculate-faces)
                   (clj->phaser layer)
                   (clj->phaser update-layer)))))

(defn set-collision-between
  "Sets collision on a range of tiles in a layer whose index is between the specified `start` and
  `stop` (inclusive). Calling this with a start value of 10 and a stop value of 14 would set
  collision for tiles 10, 11, 12, 13 and 14. The `collides` parameter controls if collision will be
  enabled (true) or disabled (false).

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * start (integer) - The first index of the tile to be set for collision.
    * stop (integer) - The last index of the tile to be set for collision.
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the update.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap start stop]
   (phaser->clj
    (.setCollisionBetween tilemap
                          (clj->phaser start)
                          (clj->phaser stop))))
  ([tilemap start stop collides]
   (phaser->clj
    (.setCollisionBetween tilemap
                          (clj->phaser start)
                          (clj->phaser stop)
                          (clj->phaser collides))))
  ([tilemap start stop collides recalculate-faces]
   (phaser->clj
    (.setCollisionBetween tilemap
                          (clj->phaser start)
                          (clj->phaser stop)
                          (clj->phaser collides)
                          (clj->phaser recalculate-faces))))
  ([tilemap start stop collides recalculate-faces layer]
   (phaser->clj
    (.setCollisionBetween tilemap
                          (clj->phaser start)
                          (clj->phaser stop)
                          (clj->phaser collides)
                          (clj->phaser recalculate-faces)
                          (clj->phaser layer)))))

(defn set-collision-by-exclusion
  "Sets collision on all tiles in the given layer, except for tiles that have an index specified in
  the given array. The `collides` parameter controls if collision will be enabled (true) or
  disabled (false).

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * indexes (Array.<integer>) - An array of the tile indexes to not be counted for collision.
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the update.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap indexes]
   (phaser->clj
    (.setCollisionByExclusion tilemap
                              (clj->phaser indexes))))
  ([tilemap indexes collides]
   (phaser->clj
    (.setCollisionByExclusion tilemap
                              (clj->phaser indexes)
                              (clj->phaser collides))))
  ([tilemap indexes collides recalculate-faces]
   (phaser->clj
    (.setCollisionByExclusion tilemap
                              (clj->phaser indexes)
                              (clj->phaser collides)
                              (clj->phaser recalculate-faces))))
  ([tilemap indexes collides recalculate-faces layer]
   (phaser->clj
    (.setCollisionByExclusion tilemap
                              (clj->phaser indexes)
                              (clj->phaser collides)
                              (clj->phaser recalculate-faces)
                              (clj->phaser layer)))))

(defn set-collision-by-property
  "Sets collision on the tiles within a layer by checking tile properties. If a tile has a property
  that matches the given properties object, its collision flag will be set. The `collides`
  parameter controls if collision will be enabled (true) or disabled (false). Passing in
  `{ collides: true }` would update the collision flag on any tiles with a 'collides' property that
  has a value of true. Any tile that doesn't have 'collides' set to true will be ignored. You can
  also use an array of values, e.g. `{ types: ['stone', 'lava', 'sand' ] }`. If a tile has a
  'types' property that matches any of those values, its collision flag will be updated.

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * properties (object) - An object with tile properties and corresponding values that should be checked.
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the update.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap properties]
   (phaser->clj
    (.setCollisionByProperty tilemap
                             (clj->phaser properties))))
  ([tilemap properties collides]
   (phaser->clj
    (.setCollisionByProperty tilemap
                             (clj->phaser properties)
                             (clj->phaser collides))))
  ([tilemap properties collides recalculate-faces]
   (phaser->clj
    (.setCollisionByProperty tilemap
                             (clj->phaser properties)
                             (clj->phaser collides)
                             (clj->phaser recalculate-faces))))
  ([tilemap properties collides recalculate-faces layer]
   (phaser->clj
    (.setCollisionByProperty tilemap
                             (clj->phaser properties)
                             (clj->phaser collides)
                             (clj->phaser recalculate-faces)
                             (clj->phaser layer)))))

(defn set-collision-from-collision-group
  "Sets collision on the tiles within a layer by checking each tile's collision group data
  (typically defined in Tiled within the tileset collision editor). If any objects are found within
  a tile's collision group, the tile's colliding information will be set. The `collides` parameter
  controls if collision will be enabled (true) or disabled (false).

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the update.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap]
   (phaser->clj
    (.setCollisionFromCollisionGroup tilemap)))
  ([tilemap collides]
   (phaser->clj
    (.setCollisionFromCollisionGroup tilemap
                                     (clj->phaser collides))))
  ([tilemap collides recalculate-faces]
   (phaser->clj
    (.setCollisionFromCollisionGroup tilemap
                                     (clj->phaser collides)
                                     (clj->phaser recalculate-faces))))
  ([tilemap collides recalculate-faces layer]
   (phaser->clj
    (.setCollisionFromCollisionGroup tilemap
                                     (clj->phaser collides)
                                     (clj->phaser recalculate-faces)
                                     (clj->phaser layer)))))

(defn set-layer
  "Sets the current layer to the LayerData associated with `layer`.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The name of the
layer from Tiled, the index of the layer in the map, a DynamicTilemapLayer or a
StaticTilemapLayer. If not given will default to the map's current layer index.

  Returns:  Phaser.Tilemaps.Tilemap - This Tilemap object."
  ([tilemap]
   (phaser->clj
    (.setLayer tilemap)))
  ([tilemap layer]
   (phaser->clj
    (.setLayer tilemap
               (clj->phaser layer)))))

(defn set-layer-tile-size
  "Sets the tile size for a specific `layer`. Note: this does not necessarily match the map's
  tileWidth and tileHeight for all layers. This will set the tile size for the layer and any
  tiles the layer has.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-width (integer) - The width of the tiles (in pixels) in the layer.
    * tile-height (integer) - The height of the tiles (in pixels) in the layer.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The name of the
layer from Tiled, the index of the layer in the map, a DynamicTilemapLayer or a
StaticTilemapLayer. If not given will default to the map's current layer index.

  Returns:  Phaser.Tilemaps.Tilemap - This Tilemap object."
  ([tilemap tile-width tile-height]
   (phaser->clj
    (.setLayerTileSize tilemap
                       (clj->phaser tile-width)
                       (clj->phaser tile-height))))
  ([tilemap tile-width tile-height layer]
   (phaser->clj
    (.setLayerTileSize tilemap
                       (clj->phaser tile-width)
                       (clj->phaser tile-height)
                       (clj->phaser layer)))))

(defn set-render-order
  "Sets the rendering (draw) order of the tiles in this map.

  The default is 'right-down', meaning it will order the tiles starting from the top-left,
  drawing to the right and then moving down to the next row.

  The draw orders are:

  0 = right-down
  1 = left-down
  2 = right-up
  3 = left-up

  Setting the render order does not change the tiles or how they are stored in the layer,
  it purely impacts the order in which they are rendered.

  You can provide either an integer (0 to 3), or the string version of the order.

  Calling this method _after_ creating Static or Dynamic Tilemap Layers will **not** automatically
  update them to use the new render order. If you call this method after creating layers, use their
  own `setRenderOrder` methods to change them as needed.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * render-order (integer | string) - The render (draw) order value. Either an integer between 0 and 3, or a string: 'right-down', 'left-down', 'right-up' or 'left-up'.

  Returns:  this - This Tilemap object."
  ([tilemap render-order]
   (phaser->clj
    (.setRenderOrder tilemap
                     (clj->phaser render-order)))))

(defn set-tile-index-callback
  "Sets a global collision callback for the given tile index within the layer. This will affect all
  tiles on this layer that have the same index. If a callback is already set for the tile index it
  will be replaced. Set the callback to null to remove it. If you want to set a callback for a tile
  at a specific location on the map then see setTileLocationCallback.

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * indexes (integer | array) - Either a single tile index, or an array of tile indexes to have a collision callback set for.
    * callback (function) - The callback that will be invoked when the tile is collided with.
    * callback-context (object) - The context under which the callback is called.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap indexes callback callback-context]
   (phaser->clj
    (.setTileIndexCallback tilemap
                           (clj->phaser indexes)
                           (clj->phaser callback)
                           (clj->phaser callback-context))))
  ([tilemap indexes callback callback-context layer]
   (phaser->clj
    (.setTileIndexCallback tilemap
                           (clj->phaser indexes)
                           (clj->phaser callback)
                           (clj->phaser callback-context)
                           (clj->phaser layer)))))

(defn set-tile-location-callback
  "Sets a collision callback for the given rectangular area (in tile coordindates) within the layer.
  If a callback is already set for the tile index it will be replaced. Set the callback to null to
  remove it.

  If no layer specified, the map's current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) - How many tiles wide from the `tileX` index the area will be.
    * height (integer) - How many tiles tall from the `tileY` index the area will be.
    * callback (function) - The callback that will be invoked when the tile is collided with.
    * callback-context (object) {optional} - The context under which the callback is called.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap tile-x tile-y width height callback]
   (phaser->clj
    (.setTileLocationCallback tilemap
                              (clj->phaser tile-x)
                              (clj->phaser tile-y)
                              (clj->phaser width)
                              (clj->phaser height)
                              (clj->phaser callback))))
  ([tilemap tile-x tile-y width height callback callback-context]
   (phaser->clj
    (.setTileLocationCallback tilemap
                              (clj->phaser tile-x)
                              (clj->phaser tile-y)
                              (clj->phaser width)
                              (clj->phaser height)
                              (clj->phaser callback)
                              (clj->phaser callback-context))))
  ([tilemap tile-x tile-y width height callback callback-context layer]
   (phaser->clj
    (.setTileLocationCallback tilemap
                              (clj->phaser tile-x)
                              (clj->phaser tile-y)
                              (clj->phaser width)
                              (clj->phaser height)
                              (clj->phaser callback)
                              (clj->phaser callback-context)
                              (clj->phaser layer)))))

(defn shuffle
  "Shuffles the tiles in a rectangular region (specified in tile coordinates) within the given
  layer. It will only randomize the tiles in that area, so if they're all the same nothing will
  appear to have changed! This method only modifies tile indexes and does not change collision
  information.

  If no layer specified, the maps current layer is used.
  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap]
   (phaser->clj
    (.shuffle tilemap)))
  ([tilemap tile-x]
   (phaser->clj
    (.shuffle tilemap
              (clj->phaser tile-x))))
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.shuffle tilemap
              (clj->phaser tile-x)
              (clj->phaser tile-y))))
  ([tilemap tile-x tile-y width]
   (phaser->clj
    (.shuffle tilemap
              (clj->phaser tile-x)
              (clj->phaser tile-y)
              (clj->phaser width))))
  ([tilemap tile-x tile-y width height]
   (phaser->clj
    (.shuffle tilemap
              (clj->phaser tile-x)
              (clj->phaser tile-y)
              (clj->phaser width)
              (clj->phaser height))))
  ([tilemap tile-x tile-y width height layer]
   (phaser->clj
    (.shuffle tilemap
              (clj->phaser tile-x)
              (clj->phaser tile-y)
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser layer)))))

(defn swap-by-index
  "Scans the given rectangular area (given in tile coordinates) for tiles with an index matching
  `indexA` and swaps then with `indexB`. This only modifies the index and does not change collision
  information.

  If no layer specified, the maps current layer is used.
  This cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-a (integer) - First tile index.
    * tile-b (integer) - Second tile index.
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap tile-a tile-b]
   (phaser->clj
    (.swapByIndex tilemap
                  (clj->phaser tile-a)
                  (clj->phaser tile-b))))
  ([tilemap tile-a tile-b tile-x]
   (phaser->clj
    (.swapByIndex tilemap
                  (clj->phaser tile-a)
                  (clj->phaser tile-b)
                  (clj->phaser tile-x))))
  ([tilemap tile-a tile-b tile-x tile-y]
   (phaser->clj
    (.swapByIndex tilemap
                  (clj->phaser tile-a)
                  (clj->phaser tile-b)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y))))
  ([tilemap tile-a tile-b tile-x tile-y width]
   (phaser->clj
    (.swapByIndex tilemap
                  (clj->phaser tile-a)
                  (clj->phaser tile-b)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width))))
  ([tilemap tile-a tile-b tile-x tile-y width height]
   (phaser->clj
    (.swapByIndex tilemap
                  (clj->phaser tile-a)
                  (clj->phaser tile-b)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([tilemap tile-a tile-b tile-x tile-y width height layer]
   (phaser->clj
    (.swapByIndex tilemap
                  (clj->phaser tile-a)
                  (clj->phaser tile-b)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser layer)))))

(defn tile-to-world-x
  "Converts from tile X coordinates (tile units) to world X coordinates (pixels), factoring in the
  layers position, scale and scroll.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) - The x coordinate, in tiles, not pixels.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  number - Returns a number, or null if the layer given was invalid."
  ([tilemap tile-x]
   (phaser->clj
    (.tileToWorldX tilemap
                   (clj->phaser tile-x))))
  ([tilemap tile-x camera]
   (phaser->clj
    (.tileToWorldX tilemap
                   (clj->phaser tile-x)
                   (clj->phaser camera))))
  ([tilemap tile-x camera layer]
   (phaser->clj
    (.tileToWorldX tilemap
                   (clj->phaser tile-x)
                   (clj->phaser camera)
                   (clj->phaser layer)))))

(defn tile-to-world-xy
  "Converts from tile XY coordinates (tile units) to world XY coordinates (pixels), factoring in the
  layers position, scale and scroll. This will return a new Vector2 object or update the given
  `point` object.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) - The x coordinate, in tiles, not pixels.
    * tile-y (integer) - The y coordinate, in tiles, not pixels.
    * point (Phaser.Math.Vector2) {optional} - A Vector2 to store the coordinates in. If not given a new Vector2 is created.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Math.Vector2 - Returns a point, or null if the layer given was invalid."
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.tileToWorldXY tilemap
                    (clj->phaser tile-x)
                    (clj->phaser tile-y))))
  ([tilemap tile-x tile-y point]
   (phaser->clj
    (.tileToWorldXY tilemap
                    (clj->phaser tile-x)
                    (clj->phaser tile-y)
                    (clj->phaser point))))
  ([tilemap tile-x tile-y point camera]
   (phaser->clj
    (.tileToWorldXY tilemap
                    (clj->phaser tile-x)
                    (clj->phaser tile-y)
                    (clj->phaser point)
                    (clj->phaser camera))))
  ([tilemap tile-x tile-y point camera layer]
   (phaser->clj
    (.tileToWorldXY tilemap
                    (clj->phaser tile-x)
                    (clj->phaser tile-y)
                    (clj->phaser point)
                    (clj->phaser camera)
                    (clj->phaser layer)))))

(defn tile-to-world-y
  "Converts from tile Y coordinates (tile units) to world Y coordinates (pixels), factoring in the
  layers position, scale and scroll.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-y (integer) - The y coordinate, in tiles, not pixels.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer
to use. If not given the current layer is used.

  Returns:  number - Returns a number, or null if the layer given was invalid."
  ([tilemap tile-y]
   (phaser->clj
    (.tileToWorldY tilemap
                   (clj->phaser tile-y))))
  ([tilemap tile-y camera]
   (phaser->clj
    (.tileToWorldY tilemap
                   (clj->phaser tile-y)
                   (clj->phaser camera))))
  ([tilemap tile-y camera layer]
   (phaser->clj
    (.tileToWorldY tilemap
                   (clj->phaser tile-y)
                   (clj->phaser camera)
                   (clj->phaser layer)))))

(defn weighted-randomize
  "Randomizes the indexes of a rectangular region of tiles (in tile coordinates) within the
  specified layer. Each tile will receive a new index. New indexes are drawn from the given
  weightedIndexes array. An example weighted array:

  [
   { index: 6, weight: 4 },    // Probability of index 6 is 4 / 8
   { index: 7, weight: 2 },    // Probability of index 7 would be 2 / 8
   { index: 8, weight: 1.5 },  // Probability of index 8 would be 1.5 / 8
   { index: 26, weight: 0.5 }  // Probability of index 27 would be 0.5 / 8
  ]

  The probability of any index being choose is (the index's weight) / (sum of all weights). This
  method only modifies tile indexes and does not change collision information.

  If no layer specified, the map's current layer is used. This
  cannot be applied to StaticTilemapLayers.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * weighted-indexes (Array.<object>) {optional} - An array of objects to randomly draw from during
randomization. They should be in the form: { index: 0, weight: 4 } or
{ index: [0, 1], weight: 4 } if you wish to draw from multiple tile indexes.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Tilemaps.Tilemap - Return this Tilemap object, or null if the layer given was invalid."
  ([tilemap]
   (phaser->clj
    (.weightedRandomize tilemap)))
  ([tilemap tile-x]
   (phaser->clj
    (.weightedRandomize tilemap
                        (clj->phaser tile-x))))
  ([tilemap tile-x tile-y]
   (phaser->clj
    (.weightedRandomize tilemap
                        (clj->phaser tile-x)
                        (clj->phaser tile-y))))
  ([tilemap tile-x tile-y width]
   (phaser->clj
    (.weightedRandomize tilemap
                        (clj->phaser tile-x)
                        (clj->phaser tile-y)
                        (clj->phaser width))))
  ([tilemap tile-x tile-y width height]
   (phaser->clj
    (.weightedRandomize tilemap
                        (clj->phaser tile-x)
                        (clj->phaser tile-y)
                        (clj->phaser width)
                        (clj->phaser height))))
  ([tilemap tile-x tile-y width height weighted-indexes]
   (phaser->clj
    (.weightedRandomize tilemap
                        (clj->phaser tile-x)
                        (clj->phaser tile-y)
                        (clj->phaser width)
                        (clj->phaser height)
                        (clj->phaser weighted-indexes))))
  ([tilemap tile-x tile-y width height weighted-indexes layer]
   (phaser->clj
    (.weightedRandomize tilemap
                        (clj->phaser tile-x)
                        (clj->phaser tile-y)
                        (clj->phaser width)
                        (clj->phaser height)
                        (clj->phaser weighted-indexes)
                        (clj->phaser layer)))))

(defn world-to-tile-x
  "Converts from world X coordinates (pixels) to tile X coordinates (tile units), factoring in the
  layers position, scale and scroll.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * world-x (number) - The x coordinate to be converted, in pixels, not tiles.
    * snap-to-floor (boolean) {optional} - Whether or not to round the tile coordinate down to the nearest integer.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer
to use. If not given the current layer is used.

  Returns:  number - Returns a number, or null if the layer given was invalid."
  ([tilemap world-x]
   (phaser->clj
    (.worldToTileX tilemap
                   (clj->phaser world-x))))
  ([tilemap world-x snap-to-floor]
   (phaser->clj
    (.worldToTileX tilemap
                   (clj->phaser world-x)
                   (clj->phaser snap-to-floor))))
  ([tilemap world-x snap-to-floor camera]
   (phaser->clj
    (.worldToTileX tilemap
                   (clj->phaser world-x)
                   (clj->phaser snap-to-floor)
                   (clj->phaser camera))))
  ([tilemap world-x snap-to-floor camera layer]
   (phaser->clj
    (.worldToTileX tilemap
                   (clj->phaser world-x)
                   (clj->phaser snap-to-floor)
                   (clj->phaser camera)
                   (clj->phaser layer)))))

(defn world-to-tile-xy
  "Converts from world XY coordinates (pixels) to tile XY coordinates (tile units), factoring in the
  layers position, scale and scroll. This will return a new Vector2 object or update the given
  `point` object.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * world-x (number) - The x coordinate to be converted, in pixels, not tiles.
    * world-y (number) - The y coordinate to be converted, in pixels, not tiles.
    * snap-to-floor (boolean) {optional} - Whether or not to round the tile coordinate down to the nearest integer.
    * point (Phaser.Math.Vector2) {optional} - A Vector2 to store the coordinates in. If not given a new Vector2 is created.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  Phaser.Math.Vector2 - Returns a point, or null if the layer given was invalid."
  ([tilemap world-x world-y]
   (phaser->clj
    (.worldToTileXY tilemap
                    (clj->phaser world-x)
                    (clj->phaser world-y))))
  ([tilemap world-x world-y snap-to-floor]
   (phaser->clj
    (.worldToTileXY tilemap
                    (clj->phaser world-x)
                    (clj->phaser world-y)
                    (clj->phaser snap-to-floor))))
  ([tilemap world-x world-y snap-to-floor point]
   (phaser->clj
    (.worldToTileXY tilemap
                    (clj->phaser world-x)
                    (clj->phaser world-y)
                    (clj->phaser snap-to-floor)
                    (clj->phaser point))))
  ([tilemap world-x world-y snap-to-floor point camera]
   (phaser->clj
    (.worldToTileXY tilemap
                    (clj->phaser world-x)
                    (clj->phaser world-y)
                    (clj->phaser snap-to-floor)
                    (clj->phaser point)
                    (clj->phaser camera))))
  ([tilemap world-x world-y snap-to-floor point camera layer]
   (phaser->clj
    (.worldToTileXY tilemap
                    (clj->phaser world-x)
                    (clj->phaser world-y)
                    (clj->phaser snap-to-floor)
                    (clj->phaser point)
                    (clj->phaser camera)
                    (clj->phaser layer)))))

(defn world-to-tile-y
  "Converts from world Y coordinates (pixels) to tile Y coordinates (tile units), factoring in the
  layers position, scale and scroll.

  If no layer specified, the maps current layer is used.

  Parameters:
    * tilemap (Phaser.Tilemaps.Tilemap) - Targeted instance for method
    * world-y (number) - The y coordinate to be converted, in pixels, not tiles.
    * snap-to-floor (boolean) {optional} - Whether or not to round the tile coordinate down to the nearest integer.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.
    * layer (string | integer | Phaser.Tilemaps.DynamicTilemapLayer | Phaser.Tilemaps.StaticTilemapLayer) {optional} - The tile layer to use. If not given the current layer is used.

  Returns:  number - Returns a number, or null if the layer given was invalid."
  ([tilemap world-y]
   (phaser->clj
    (.worldToTileY tilemap
                   (clj->phaser world-y))))
  ([tilemap world-y snap-to-floor]
   (phaser->clj
    (.worldToTileY tilemap
                   (clj->phaser world-y)
                   (clj->phaser snap-to-floor))))
  ([tilemap world-y snap-to-floor camera]
   (phaser->clj
    (.worldToTileY tilemap
                   (clj->phaser world-y)
                   (clj->phaser snap-to-floor)
                   (clj->phaser camera))))
  ([tilemap world-y snap-to-floor camera layer]
   (phaser->clj
    (.worldToTileY tilemap
                   (clj->phaser world-y)
                   (clj->phaser snap-to-floor)
                   (clj->phaser camera)
                   (clj->phaser layer)))))