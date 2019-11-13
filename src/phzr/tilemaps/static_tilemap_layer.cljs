(ns phzr.tilemaps.static-tilemap-layer
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->StaticTilemapLayer
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs.
    * tilemap (Phaser.Tilemaps.Tilemap) - The Tilemap this layer is a part of.
    * layer-index (integer) - The index of the LayerData associated with this layer.
    * tileset (string | Array.<string> | Phaser.Tilemaps.Tileset | Array.<Phaser.Tilemaps.Tileset>) - The tileset, or an array of tilesets, used to render this layer. Can be a string or a Tileset object.
    * x (number) {optional} - The world x position where the top left of this layer will be placed.
    * y (number) {optional} - The world y position where the top left of this layer will be placed."
  ([scene tilemap layer-index tileset]
   (js/Phaser.Tilemaps.StaticTilemapLayer. (clj->phaser scene)
                                           (clj->phaser tilemap)
                                           (clj->phaser layer-index)
                                           (clj->phaser tileset)))
  ([scene tilemap layer-index tileset x]
   (js/Phaser.Tilemaps.StaticTilemapLayer. (clj->phaser scene)
                                           (clj->phaser tilemap)
                                           (clj->phaser layer-index)
                                           (clj->phaser tileset)
                                           (clj->phaser x)))
  ([scene tilemap layer-index tileset x y]
   (js/Phaser.Tilemaps.StaticTilemapLayer. (clj->phaser scene)
                                           (clj->phaser tilemap)
                                           (clj->phaser layer-index)
                                           (clj->phaser tileset)
                                           (clj->phaser x)
                                           (clj->phaser y))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([static-tilemap-layer event fn]
   (phaser->clj
    (.addListener static-tilemap-layer
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([static-tilemap-layer event fn context]
   (phaser->clj
    (.addListener static-tilemap-layer
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn calculate-faces-at
  "Calculates interesting faces at the given tile coordinates of the specified layer. Interesting
  faces are used internally for optimizing collisions against tiles. This method is mostly used
  internally to optimize recalculating faces when only one tile has been changed.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-x (integer) - The x coordinate.
    * tile-y (integer) - The y coordinate.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer tile-x tile-y]
   (phaser->clj
    (.calculateFacesAt static-tilemap-layer
                       (clj->phaser tile-x)
                       (clj->phaser tile-y)))))

(defn calculate-faces-within
  "Calculates interesting faces within the rectangular area specified (in tile coordinates) of the
  layer. Interesting faces are used internally for optimizing collisions against tiles. This method
  is mostly used internally.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The top most tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer]
   (phaser->clj
    (.calculateFacesWithin static-tilemap-layer)))
  ([static-tilemap-layer tile-x]
   (phaser->clj
    (.calculateFacesWithin static-tilemap-layer
                           (clj->phaser tile-x))))
  ([static-tilemap-layer tile-x tile-y]
   (phaser->clj
    (.calculateFacesWithin static-tilemap-layer
                           (clj->phaser tile-x)
                           (clj->phaser tile-y))))
  ([static-tilemap-layer tile-x tile-y width]
   (phaser->clj
    (.calculateFacesWithin static-tilemap-layer
                           (clj->phaser tile-x)
                           (clj->phaser tile-y)
                           (clj->phaser width))))
  ([static-tilemap-layer tile-x tile-y width height]
   (phaser->clj
    (.calculateFacesWithin static-tilemap-layer
                           (clj->phaser tile-x)
                           (clj->phaser tile-y)
                           (clj->phaser width)
                           (clj->phaser height)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.clearAlpha static-tilemap-layer))))

(defn create-from-tiles
  "Creates a Sprite for every object matching the given tile indexes in the layer. You can
  optionally specify if each tile will be replaced with a new tile after the Sprite has been
  created. This is useful if you want to lay down special tiles in a level that are converted to
  Sprites, but want to replace the tile itself with a floor tile or similar once converted.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * indexes (integer | array) - The tile index, or array of indexes, to create Sprites from.
    * replacements (integer | array) - The tile index, or array of indexes, to change a converted
tile to. Set to `null` to leave the tiles unchanged. If an array is given, it is assumed to be a
one-to-one mapping with the indexes array.
    * sprite-config (Phaser.Types.GameObjects.Sprite.SpriteConfig) - The config object to pass into the Sprite creator (i.e.
scene.make.sprite).
    * scene (Phaser.Scene) {optional} - The Scene to create the Sprites within.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when determining the world XY

  Returns:  Array.<Phaser.GameObjects.Sprite> - An array of the Sprites that were created."
  ([static-tilemap-layer indexes replacements sprite-config]
   (phaser->clj
    (.createFromTiles static-tilemap-layer
                      (clj->phaser indexes)
                      (clj->phaser replacements)
                      (clj->phaser sprite-config))))
  ([static-tilemap-layer indexes replacements sprite-config scene]
   (phaser->clj
    (.createFromTiles static-tilemap-layer
                      (clj->phaser indexes)
                      (clj->phaser replacements)
                      (clj->phaser sprite-config)
                      (clj->phaser scene))))
  ([static-tilemap-layer indexes replacements sprite-config scene camera]
   (phaser->clj
    (.createFromTiles static-tilemap-layer
                      (clj->phaser indexes)
                      (clj->phaser replacements)
                      (clj->phaser sprite-config)
                      (clj->phaser scene)
                      (clj->phaser camera)))))

(defn cull
  "Returns the tiles in the given layer that are within the cameras viewport.
  This is used internally.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to run the cull check against.

  Returns:  Array.<Phaser.Tilemaps.Tile> - An array of Tile objects."
  ([static-tilemap-layer]
   (phaser->clj
    (.cull static-tilemap-layer)))
  ([static-tilemap-layer camera]
   (phaser->clj
    (.cull static-tilemap-layer
           (clj->phaser camera)))))

(defn destroy
  "Destroys this StaticTilemapLayer and removes its link to the associated LayerData.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * remove-from-tilemap (boolean) {optional} - Remove this layer from the parent Tilemap?"
  ([static-tilemap-layer]
   (phaser->clj
    (.destroy static-tilemap-layer)))
  ([static-tilemap-layer remove-from-tilemap]
   (phaser->clj
    (.destroy static-tilemap-layer
              (clj->phaser remove-from-tilemap)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([static-tilemap-layer]
   (phaser->clj
    (.disableInteractive static-tilemap-layer))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([static-tilemap-layer event]
   (phaser->clj
    (.emit static-tilemap-layer
           (clj->phaser event))))
  ([static-tilemap-layer event args]
   (phaser->clj
    (.emit static-tilemap-layer
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([static-tilemap-layer]
   (phaser->clj
    (.eventNames static-tilemap-layer))))

(defn filter-tiles
  "For each tile in the given rectangular area (in tile coordinates) of the layer, run the given
  filter callback function. Any tiles that pass the filter test (i.e. where the callback returns
  true) will returned as a new array. Similar to Array.prototype.Filter in vanilla JS.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * callback (function) - The callback. Each tile in the given area will be passed to this
callback as the first and only parameter. The callback should return true for tiles that pass the
filter.
    * context (object) {optional} - The context under which the callback should be run.
    * tile-x (integer) {optional} - The leftmost tile index (in tile coordinates) to use as the origin of the area to filter.
    * tile-y (integer) {optional} - The topmost tile index (in tile coordinates) to use as the origin of the area to filter.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.

  Returns:  Array.<Phaser.Tilemaps.Tile> - An array of Tile objects."
  ([static-tilemap-layer callback]
   (phaser->clj
    (.filterTiles static-tilemap-layer
                  (clj->phaser callback))))
  ([static-tilemap-layer callback context]
   (phaser->clj
    (.filterTiles static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context))))
  ([static-tilemap-layer callback context tile-x]
   (phaser->clj
    (.filterTiles static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x))))
  ([static-tilemap-layer callback context tile-x tile-y]
   (phaser->clj
    (.filterTiles static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y))))
  ([static-tilemap-layer callback context tile-x tile-y width]
   (phaser->clj
    (.filterTiles static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width))))
  ([static-tilemap-layer callback context tile-x tile-y width height]
   (phaser->clj
    (.filterTiles static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([static-tilemap-layer callback context tile-x tile-y width height filtering-options]
   (phaser->clj
    (.filterTiles static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser filtering-options)))))

(defn find-by-index
  "Searches the entire map layer for the first tile matching the given index, then returns that Tile
  object. If no match is found, it returns null. The search starts from the top-left tile and
  continues horizontally until it hits the end of the row, then it drops down to the next column.
  If the reverse boolean is true, it scans starting from the bottom-right corner traveling up to
  the top-left.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * index (integer) - The tile index value to search for.
    * skip (integer) {optional} - The number of times to skip a matching tile before returning.
    * reverse (boolean) {optional} - If true it will scan the layer in reverse, starting at the
bottom-right. Otherwise it scans from the top-left.

  Returns:  Phaser.Tilemaps.Tile - A Tile object."
  ([static-tilemap-layer index]
   (phaser->clj
    (.findByIndex static-tilemap-layer
                  (clj->phaser index))))
  ([static-tilemap-layer index skip]
   (phaser->clj
    (.findByIndex static-tilemap-layer
                  (clj->phaser index)
                  (clj->phaser skip))))
  ([static-tilemap-layer index skip reverse]
   (phaser->clj
    (.findByIndex static-tilemap-layer
                  (clj->phaser index)
                  (clj->phaser skip)
                  (clj->phaser reverse)))))

(defn find-tile
  "Find the first tile in the given rectangular area (in tile coordinates) of the layer that
  satisfies the provided testing function. I.e. finds the first tile for which `callback` returns
  true. Similar to Array.prototype.find in vanilla JS.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * callback (function) - The callback. Each tile in the given area will be passed to this
callback as the first and only parameter.
    * context (object) {optional} - The context under which the callback should be run.
    * tile-x (integer) {optional} - The left most tile index (in tile coordinates) to use as the origin of the area to filter.
    * tile-y (integer) {optional} - The topmost tile index (in tile coordinates) to use as the origin of the area to filter.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.

  Returns:  Phaser.Tilemaps.Tile - "
  ([static-tilemap-layer callback]
   (phaser->clj
    (.findTile static-tilemap-layer
               (clj->phaser callback))))
  ([static-tilemap-layer callback context]
   (phaser->clj
    (.findTile static-tilemap-layer
               (clj->phaser callback)
               (clj->phaser context))))
  ([static-tilemap-layer callback context tile-x]
   (phaser->clj
    (.findTile static-tilemap-layer
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x))))
  ([static-tilemap-layer callback context tile-x tile-y]
   (phaser->clj
    (.findTile static-tilemap-layer
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y))))
  ([static-tilemap-layer callback context tile-x tile-y width]
   (phaser->clj
    (.findTile static-tilemap-layer
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y)
               (clj->phaser width))))
  ([static-tilemap-layer callback context tile-x tile-y width height]
   (phaser->clj
    (.findTile static-tilemap-layer
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y)
               (clj->phaser width)
               (clj->phaser height))))
  ([static-tilemap-layer callback context tile-x tile-y width height filtering-options]
   (phaser->clj
    (.findTile static-tilemap-layer
               (clj->phaser callback)
               (clj->phaser context)
               (clj->phaser tile-x)
               (clj->phaser tile-y)
               (clj->phaser width)
               (clj->phaser height)
               (clj->phaser filtering-options)))))

(defn for-each-tile
  "For each tile in the given rectangular area (in tile coordinates) of the layer, run the given
  callback. Similar to Array.prototype.forEach in vanilla JS.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * callback (function) - The callback. Each tile in the given area will be passed to this
callback as the first and only parameter.
    * context (object) {optional} - The context under which the callback should be run.
    * tile-x (integer) {optional} - The leftmost tile index (in tile coordinates) to use as the origin of the area to filter.
    * tile-y (integer) {optional} - The topmost tile index (in tile coordinates) to use as the origin of the area to filter.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer callback]
   (phaser->clj
    (.forEachTile static-tilemap-layer
                  (clj->phaser callback))))
  ([static-tilemap-layer callback context]
   (phaser->clj
    (.forEachTile static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context))))
  ([static-tilemap-layer callback context tile-x]
   (phaser->clj
    (.forEachTile static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x))))
  ([static-tilemap-layer callback context tile-x tile-y]
   (phaser->clj
    (.forEachTile static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y))))
  ([static-tilemap-layer callback context tile-x tile-y width]
   (phaser->clj
    (.forEachTile static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width))))
  ([static-tilemap-layer callback context tile-x tile-y width height]
   (phaser->clj
    (.forEachTile static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([static-tilemap-layer callback context tile-x tile-y width height filtering-options]
   (phaser->clj
    (.forEachTile static-tilemap-layer
                  (clj->phaser callback)
                  (clj->phaser context)
                  (clj->phaser tile-x)
                  (clj->phaser tile-y)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser filtering-options)))))

(defn get-bottom-center
  "Gets the bottom-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getBottomCenter static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getBottomCenter static-tilemap-layer
                      (clj->phaser output))))
  ([static-tilemap-layer output include-parent]
   (phaser->clj
    (.getBottomCenter static-tilemap-layer
                      (clj->phaser output)
                      (clj->phaser include-parent)))))

(defn get-bottom-left
  "Gets the bottom-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getBottomLeft static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getBottomLeft static-tilemap-layer
                    (clj->phaser output))))
  ([static-tilemap-layer output include-parent]
   (phaser->clj
    (.getBottomLeft static-tilemap-layer
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-bottom-right
  "Gets the bottom-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getBottomRight static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getBottomRight static-tilemap-layer
                     (clj->phaser output))))
  ([static-tilemap-layer output include-parent]
   (phaser->clj
    (.getBottomRight static-tilemap-layer
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-bounds
  "Gets the bounds of this Game Object, regardless of origin.
  The values are stored and returned in a Rectangle, or Rectangle-like, object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Geom.Rectangle | object) {optional} - An object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getBounds static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getBounds static-tilemap-layer
                (clj->phaser output)))))

(defn get-center
  "Gets the center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getCenter static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getCenter static-tilemap-layer
                (clj->phaser output)))))

(defn get-data
  "Retrieves the value for the given key in this Game Objects Data Manager, or undefined if it doesn't exist.

  You can also access values via the `values` object. For example, if you had a key called `gold` you can do either:

  ```javascript
  sprite.getData('gold');
  ```

  Or access the value directly:

  ```javascript
  sprite.data.values.gold;
  ```

  You can also pass in an array of keys, in which case an array of values will be returned:

  ```javascript
  sprite.getData([ 'gold', 'armor', 'health' ]);
  ```

  This approach is useful for destructuring arrays in ES6.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([static-tilemap-layer key]
   (phaser->clj
    (.getData static-tilemap-layer
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([static-tilemap-layer]
   (phaser->clj
    (.getIndexList static-tilemap-layer))))

(defn get-left-center
  "Gets the left-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getLeftCenter static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getLeftCenter static-tilemap-layer
                    (clj->phaser output))))
  ([static-tilemap-layer output include-parent]
   (phaser->clj
    (.getLeftCenter static-tilemap-layer
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([static-tilemap-layer]
   (phaser->clj
    (.getLocalTransformMatrix static-tilemap-layer)))
  ([static-tilemap-layer temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix static-tilemap-layer
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getParentRotation static-tilemap-layer))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getPipelineName static-tilemap-layer))))

(defn get-right-center
  "Gets the right-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getRightCenter static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getRightCenter static-tilemap-layer
                     (clj->phaser output))))
  ([static-tilemap-layer output include-parent]
   (phaser->clj
    (.getRightCenter static-tilemap-layer
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-tile-at
  "Gets a tile at the given tile coordinates from the given layer.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-x (integer) - X position to get the tile from (given in tile units, not pixels).
    * tile-y (integer) - Y position to get the tile from (given in tile units, not pixels).
    * non-null (boolean) {optional} - If true getTile won't return null for empty tiles, but a Tile
object with an index of -1.

  Returns:  Phaser.Tilemaps.Tile - The tile at the given coordinates or null if no tile was found or the coordinates were invalid."
  ([static-tilemap-layer tile-x tile-y]
   (phaser->clj
    (.getTileAt static-tilemap-layer
                (clj->phaser tile-x)
                (clj->phaser tile-y))))
  ([static-tilemap-layer tile-x tile-y non-null]
   (phaser->clj
    (.getTileAt static-tilemap-layer
                (clj->phaser tile-x)
                (clj->phaser tile-y)
                (clj->phaser non-null)))))

(defn get-tile-at-world-xy
  "Gets a tile at the given world coordinates from the given layer.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * world-x (number) - X position to get the tile from (given in pixels)
    * world-y (number) - Y position to get the tile from (given in pixels)
    * non-null (boolean) {optional} - If true, function won't return null for empty tiles, but a Tile
object with an index of -1.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.

  Returns:  Phaser.Tilemaps.Tile - The tile at the given coordinates or null if no tile was found or the coordinates
were invalid."
  ([static-tilemap-layer world-x world-y]
   (phaser->clj
    (.getTileAtWorldXY static-tilemap-layer
                       (clj->phaser world-x)
                       (clj->phaser world-y))))
  ([static-tilemap-layer world-x world-y non-null]
   (phaser->clj
    (.getTileAtWorldXY static-tilemap-layer
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser non-null))))
  ([static-tilemap-layer world-x world-y non-null camera]
   (phaser->clj
    (.getTileAtWorldXY static-tilemap-layer
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser non-null)
                       (clj->phaser camera)))))

(defn get-tiles-within
  "Gets the tiles in the given rectangular area (in tile coordinates) of the layer.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-x (integer) {optional} - The leftmost tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) {optional} - The topmost tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) {optional} - How many tiles wide from the `tileX` index the area will be.
    * height (integer) {optional} - How many tiles tall from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.

  Returns:  Array.<Phaser.Tilemaps.Tile> - An array of Tile objects."
  ([static-tilemap-layer]
   (phaser->clj
    (.getTilesWithin static-tilemap-layer)))
  ([static-tilemap-layer tile-x]
   (phaser->clj
    (.getTilesWithin static-tilemap-layer
                     (clj->phaser tile-x))))
  ([static-tilemap-layer tile-x tile-y]
   (phaser->clj
    (.getTilesWithin static-tilemap-layer
                     (clj->phaser tile-x)
                     (clj->phaser tile-y))))
  ([static-tilemap-layer tile-x tile-y width]
   (phaser->clj
    (.getTilesWithin static-tilemap-layer
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width))))
  ([static-tilemap-layer tile-x tile-y width height]
   (phaser->clj
    (.getTilesWithin static-tilemap-layer
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width)
                     (clj->phaser height))))
  ([static-tilemap-layer tile-x tile-y width height filtering-options]
   (phaser->clj
    (.getTilesWithin static-tilemap-layer
                     (clj->phaser tile-x)
                     (clj->phaser tile-y)
                     (clj->phaser width)
                     (clj->phaser height)
                     (clj->phaser filtering-options)))))

(defn get-tiles-within-shape
  "Gets the tiles that overlap with the given shape in the given layer. The shape must be a Circle,
  Line, Rectangle or Triangle. The shape should be in world coordinates.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * shape (Phaser.Geom.Circle | Phaser.Geom.Line | Phaser.Geom.Rectangle | Phaser.Geom.Triangle) - A shape in world (pixel) coordinates
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.

  Returns:  Array.<Phaser.Tilemaps.Tile> - An array of Tile objects."
  ([static-tilemap-layer shape]
   (phaser->clj
    (.getTilesWithinShape static-tilemap-layer
                          (clj->phaser shape))))
  ([static-tilemap-layer shape filtering-options]
   (phaser->clj
    (.getTilesWithinShape static-tilemap-layer
                          (clj->phaser shape)
                          (clj->phaser filtering-options))))
  ([static-tilemap-layer shape filtering-options camera]
   (phaser->clj
    (.getTilesWithinShape static-tilemap-layer
                          (clj->phaser shape)
                          (clj->phaser filtering-options)
                          (clj->phaser camera)))))

(defn get-tiles-within-world-xy
  "Gets the tiles in the given rectangular area (in world coordinates) of the layer.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * world-x (number) - The leftmost tile index (in tile coordinates) to use as the origin of the area to filter.
    * world-y (number) - The topmost tile index (in tile coordinates) to use as the origin of the area to filter.
    * width (number) - How many tiles wide from the `tileX` index the area will be.
    * height (number) - How many tiles high from the `tileY` index the area will be.
    * filtering-options (Phaser.Types.Tilemaps.FilteringOptions) {optional} - Optional filters to apply when getting the tiles.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when factoring in which tiles to return.

  Returns:  Array.<Phaser.Tilemaps.Tile> - An array of Tile objects."
  ([static-tilemap-layer world-x world-y width height]
   (phaser->clj
    (.getTilesWithinWorldXY static-tilemap-layer
                            (clj->phaser world-x)
                            (clj->phaser world-y)
                            (clj->phaser width)
                            (clj->phaser height))))
  ([static-tilemap-layer world-x world-y width height filtering-options]
   (phaser->clj
    (.getTilesWithinWorldXY static-tilemap-layer
                            (clj->phaser world-x)
                            (clj->phaser world-y)
                            (clj->phaser width)
                            (clj->phaser height)
                            (clj->phaser filtering-options))))
  ([static-tilemap-layer world-x world-y width height filtering-options camera]
   (phaser->clj
    (.getTilesWithinWorldXY static-tilemap-layer
                            (clj->phaser world-x)
                            (clj->phaser world-y)
                            (clj->phaser width)
                            (clj->phaser height)
                            (clj->phaser filtering-options)
                            (clj->phaser camera)))))

(defn get-top-center
  "Gets the top-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getTopCenter static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getTopCenter static-tilemap-layer
                   (clj->phaser output))))
  ([static-tilemap-layer output include-parent]
   (phaser->clj
    (.getTopCenter static-tilemap-layer
                   (clj->phaser output)
                   (clj->phaser include-parent)))))

(defn get-top-left
  "Gets the top-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getTopLeft static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getTopLeft static-tilemap-layer
                 (clj->phaser output))))
  ([static-tilemap-layer output include-parent]
   (phaser->clj
    (.getTopLeft static-tilemap-layer
                 (clj->phaser output)
                 (clj->phaser include-parent)))))

(defn get-top-right
  "Gets the top-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([static-tilemap-layer]
   (phaser->clj
    (.getTopRight static-tilemap-layer)))
  ([static-tilemap-layer output]
   (phaser->clj
    (.getTopRight static-tilemap-layer
                  (clj->phaser output))))
  ([static-tilemap-layer output include-parent]
   (phaser->clj
    (.getTopRight static-tilemap-layer
                  (clj->phaser output)
                  (clj->phaser include-parent)))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([static-tilemap-layer]
   (phaser->clj
    (.getWorldTransformMatrix static-tilemap-layer)))
  ([static-tilemap-layer temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix static-tilemap-layer
                              (clj->phaser temp-matrix))))
  ([static-tilemap-layer temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix static-tilemap-layer
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn has-tile-at
  "Checks if there is a tile at the given location (in tile coordinates) in the given layer. Returns
  false if there is no tile or if the tile at that location has an index of -1.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-x (integer) - X position to get the tile from in tile coordinates.
    * tile-y (integer) - Y position to get the tile from in tile coordinates.

  Returns:  boolean - "
  ([static-tilemap-layer tile-x tile-y]
   (phaser->clj
    (.hasTileAt static-tilemap-layer
                (clj->phaser tile-x)
                (clj->phaser tile-y)))))

(defn has-tile-at-world-xy
  "Checks if there is a tile at the given location (in world coordinates) in the given layer. Returns
  false if there is no tile or if the tile at that location has an index of -1.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * world-x (number) - The X coordinate of the world position.
    * world-y (number) - The Y coordinate of the world position.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.

  Returns:  boolean - "
  ([static-tilemap-layer world-x world-y]
   (phaser->clj
    (.hasTileAtWorldXY static-tilemap-layer
                       (clj->phaser world-x)
                       (clj->phaser world-y))))
  ([static-tilemap-layer world-x world-y camera]
   (phaser->clj
    (.hasTileAtWorldXY static-tilemap-layer
                       (clj->phaser world-x)
                       (clj->phaser world-y)
                       (clj->phaser camera)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([static-tilemap-layer]
   (phaser->clj
    (.initPipeline static-tilemap-layer)))
  ([static-tilemap-layer pipeline-name]
   (phaser->clj
    (.initPipeline static-tilemap-layer
                   (clj->phaser pipeline-name)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([static-tilemap-layer event]
   (phaser->clj
    (.listenerCount static-tilemap-layer
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([static-tilemap-layer event]
   (phaser->clj
    (.listeners static-tilemap-layer
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([static-tilemap-layer event]
   (phaser->clj
    (.off static-tilemap-layer
          (clj->phaser event))))
  ([static-tilemap-layer event fn]
   (phaser->clj
    (.off static-tilemap-layer
          (clj->phaser event)
          (clj->phaser fn))))
  ([static-tilemap-layer event fn context]
   (phaser->clj
    (.off static-tilemap-layer
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([static-tilemap-layer event fn context once]
   (phaser->clj
    (.off static-tilemap-layer
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([static-tilemap-layer event fn]
   (phaser->clj
    (.on static-tilemap-layer
         (clj->phaser event)
         (clj->phaser fn))))
  ([static-tilemap-layer event fn context]
   (phaser->clj
    (.on static-tilemap-layer
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([static-tilemap-layer event fn]
   (phaser->clj
    (.once static-tilemap-layer
           (clj->phaser event)
           (clj->phaser fn))))
  ([static-tilemap-layer event fn context]
   (phaser->clj
    (.once static-tilemap-layer
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([static-tilemap-layer]
   (phaser->clj
    (.removeAllListeners static-tilemap-layer)))
  ([static-tilemap-layer event]
   (phaser->clj
    (.removeAllListeners static-tilemap-layer
                         (clj->phaser event)))))

(defn remove-interactive
  "If this Game Object has previously been enabled for input, this will queue it
  for removal, causing it to no longer be interactive. The removal happens on
  the next game step, it is not immediate.

  The Interactive Object that was assigned to this Game Object will be destroyed,
  removed from the Input Manager and cleared from this Game Object.

  If you wish to re-enable this Game Object at a later date you will need to
  re-create its InteractiveObject by calling `setInteractive` again.

  If you wish to only temporarily stop an object from receiving input then use
  `disableInteractive` instead, as that toggles the interactive state, where-as
  this erases it completely.

  If you wish to resize a hit area, don't remove and then set it as being
  interactive. Instead, access the hitarea object directly and resize the shape
  being used. I.e.: `sprite.input.hitArea.setSize(width, height)` (assuming the
  shape is a Rectangle, which it is by default.)

  Returns:  this - This GameObject."
  ([static-tilemap-layer]
   (phaser->clj
    (.removeInteractive static-tilemap-layer))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([static-tilemap-layer event]
   (phaser->clj
    (.removeListener static-tilemap-layer
                     (clj->phaser event))))
  ([static-tilemap-layer event fn]
   (phaser->clj
    (.removeListener static-tilemap-layer
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([static-tilemap-layer event fn context]
   (phaser->clj
    (.removeListener static-tilemap-layer
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([static-tilemap-layer event fn context once]
   (phaser->clj
    (.removeListener static-tilemap-layer
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn render-debug
  "Draws a debug representation of the layer to the given Graphics. This is helpful when you want to
  get a quick idea of which of your tiles are colliding and which have interesting faces. The tiles
  are drawn starting at (0, 0) in the Graphics, allowing you to place the debug representation
  wherever you want on the screen.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) - The target Graphics object to draw upon.
    * style-config (Phaser.Types.Tilemaps.StyleConfig) - An object specifying the colors to use for the debug drawing.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer graphics style-config]
   (phaser->clj
    (.renderDebug static-tilemap-layer
                  (clj->phaser graphics)
                  (clj->phaser style-config)))))

(defn reset-flip
  "Resets the horizontal and vertical flipped state of this Game Object back to their default un-flipped state.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.resetFlip static-tilemap-layer))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([static-tilemap-layer]
   (phaser->clj
    (.resetPipeline static-tilemap-layer))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([static-tilemap-layer value]
   (phaser->clj
    (.setActive static-tilemap-layer
                (clj->phaser value)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setAlpha static-tilemap-layer)))
  ([static-tilemap-layer top-left]
   (phaser->clj
    (.setAlpha static-tilemap-layer
               (clj->phaser top-left))))
  ([static-tilemap-layer top-left top-right]
   (phaser->clj
    (.setAlpha static-tilemap-layer
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([static-tilemap-layer top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha static-tilemap-layer
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([static-tilemap-layer top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha static-tilemap-layer
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setAngle static-tilemap-layer)))
  ([static-tilemap-layer degrees]
   (phaser->clj
    (.setAngle static-tilemap-layer
               (clj->phaser degrees)))))

(defn set-blend-mode
  "Sets the Blend Mode being used by this Game Object.

  This can be a const, such as `Phaser.BlendModes.SCREEN`, or an integer, such as 4 (for Overlay)

  Under WebGL only the following Blend Modes are available:

  * ADD
  * MULTIPLY
  * SCREEN
  * ERASE (only works when rendering to a framebuffer, like a Render Texture)

  Canvas has more available depending on browser support.

  You can also create your own custom Blend Modes in WebGL.

  Blend modes have different effects under Canvas and WebGL, and from browser to browser, depending
  on support. Blend Modes also cause a WebGL batch flush should it encounter a new blend mode. For these
  reasons try to be careful about the construction of your Scene and the frequency in which blend modes
  are used.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer value]
   (phaser->clj
    (.setBlendMode static-tilemap-layer
                   (clj->phaser value)))))

(defn set-collision
  "Sets collision on the given tile or tiles within a layer by index. You can pass in either a
  single numeric index or an array of indexes: [2, 3, 15, 20]. The `collides` parameter controls if
  collision will be enabled (true) or disabled (false).

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * indexes (integer | array) - Either a single tile index, or an array of tile indexes.
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear
collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the
update.
    * update-layer (boolean) {optional} - If true, updates the current tiles on the layer. Set to
false if no tiles have been placed for significant performance boost.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer indexes]
   (phaser->clj
    (.setCollision static-tilemap-layer
                   (clj->phaser indexes))))
  ([static-tilemap-layer indexes collides]
   (phaser->clj
    (.setCollision static-tilemap-layer
                   (clj->phaser indexes)
                   (clj->phaser collides))))
  ([static-tilemap-layer indexes collides recalculate-faces]
   (phaser->clj
    (.setCollision static-tilemap-layer
                   (clj->phaser indexes)
                   (clj->phaser collides)
                   (clj->phaser recalculate-faces))))
  ([static-tilemap-layer indexes collides recalculate-faces update-layer]
   (phaser->clj
    (.setCollision static-tilemap-layer
                   (clj->phaser indexes)
                   (clj->phaser collides)
                   (clj->phaser recalculate-faces)
                   (clj->phaser update-layer)))))

(defn set-collision-between
  "Sets collision on a range of tiles in a layer whose index is between the specified `start` and
  `stop` (inclusive). Calling this with a start value of 10 and a stop value of 14 would set
  collision for tiles 10, 11, 12, 13 and 14. The `collides` parameter controls if collision will be
  enabled (true) or disabled (false).

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * start (integer) - The first index of the tile to be set for collision.
    * stop (integer) - The last index of the tile to be set for collision.
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear
collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the
update.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer start stop]
   (phaser->clj
    (.setCollisionBetween static-tilemap-layer
                          (clj->phaser start)
                          (clj->phaser stop))))
  ([static-tilemap-layer start stop collides]
   (phaser->clj
    (.setCollisionBetween static-tilemap-layer
                          (clj->phaser start)
                          (clj->phaser stop)
                          (clj->phaser collides))))
  ([static-tilemap-layer start stop collides recalculate-faces]
   (phaser->clj
    (.setCollisionBetween static-tilemap-layer
                          (clj->phaser start)
                          (clj->phaser stop)
                          (clj->phaser collides)
                          (clj->phaser recalculate-faces)))))

(defn set-collision-by-exclusion
  "Sets collision on all tiles in the given layer, except for tiles that have an index specified in
  the given array. The `collides` parameter controls if collision will be enabled (true) or
  disabled (false).

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * indexes (Array.<integer>) - An array of the tile indexes to not be counted for collision.
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear
collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the
update.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer indexes]
   (phaser->clj
    (.setCollisionByExclusion static-tilemap-layer
                              (clj->phaser indexes))))
  ([static-tilemap-layer indexes collides]
   (phaser->clj
    (.setCollisionByExclusion static-tilemap-layer
                              (clj->phaser indexes)
                              (clj->phaser collides))))
  ([static-tilemap-layer indexes collides recalculate-faces]
   (phaser->clj
    (.setCollisionByExclusion static-tilemap-layer
                              (clj->phaser indexes)
                              (clj->phaser collides)
                              (clj->phaser recalculate-faces)))))

(defn set-collision-by-property
  "Sets collision on the tiles within a layer by checking tile properties. If a tile has a property
  that matches the given properties object, its collision flag will be set. The `collides`
  parameter controls if collision will be enabled (true) or disabled (false). Passing in
  `{ collides: true }` would update the collision flag on any tiles with a 'collides' property that
  has a value of true. Any tile that doesn't have 'collides' set to true will be ignored. You can
  also use an array of values, e.g. `{ types: ['stone', 'lava', 'sand' ] }`. If a tile has a
  'types' property that matches any of those values, its collision flag will be updated.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * properties (object) - An object with tile properties and corresponding values that should
be checked.
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear
collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the
update.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer properties]
   (phaser->clj
    (.setCollisionByProperty static-tilemap-layer
                             (clj->phaser properties))))
  ([static-tilemap-layer properties collides]
   (phaser->clj
    (.setCollisionByProperty static-tilemap-layer
                             (clj->phaser properties)
                             (clj->phaser collides))))
  ([static-tilemap-layer properties collides recalculate-faces]
   (phaser->clj
    (.setCollisionByProperty static-tilemap-layer
                             (clj->phaser properties)
                             (clj->phaser collides)
                             (clj->phaser recalculate-faces)))))

(defn set-collision-from-collision-group
  "Sets collision on the tiles within a layer by checking each tiles collision group data
  (typically defined in Tiled within the tileset collision editor). If any objects are found within
  a tiles collision group, the tile's colliding information will be set. The `collides` parameter
  controls if collision will be enabled (true) or disabled (false).

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * collides (boolean) {optional} - If true it will enable collision. If false it will clear
collision.
    * recalculate-faces (boolean) {optional} - Whether or not to recalculate the tile faces after the
update.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer]
   (phaser->clj
    (.setCollisionFromCollisionGroup static-tilemap-layer)))
  ([static-tilemap-layer collides]
   (phaser->clj
    (.setCollisionFromCollisionGroup static-tilemap-layer
                                     (clj->phaser collides))))
  ([static-tilemap-layer collides recalculate-faces]
   (phaser->clj
    (.setCollisionFromCollisionGroup static-tilemap-layer
                                     (clj->phaser collides)
                                     (clj->phaser recalculate-faces)))))

(defn set-cull-padding
  "Canvas only.

  When a Camera culls the tiles in this layer it does so using its view into the world, building up a
  rectangle inside which the tiles must exist or they will be culled. Sometimes you may need to expand the size
  of this 'cull rectangle', especially if you plan on rotating the Camera viewing the layer. Do so
  by providing the padding values. The values given are in tiles, not pixels. So if the tile width was 32px
  and you set `paddingX` to be 4, it would add 32px x 4 to the cull rectangle (adjusted for scale)

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * padding-x (integer) {optional} - The amount of extra horizontal tiles to add to the cull check padding.
    * padding-y (integer) {optional} - The amount of extra vertical tiles to add to the cull check padding.

  Returns:  this - This Tilemap Layer object."
  ([static-tilemap-layer]
   (phaser->clj
    (.setCullPadding static-tilemap-layer)))
  ([static-tilemap-layer padding-x]
   (phaser->clj
    (.setCullPadding static-tilemap-layer
                     (clj->phaser padding-x))))
  ([static-tilemap-layer padding-x padding-y]
   (phaser->clj
    (.setCullPadding static-tilemap-layer
                     (clj->phaser padding-x)
                     (clj->phaser padding-y)))))

(defn set-data
  "Allows you to store a key value pair within this Game Objects Data Manager.

  If the Game Object has not been enabled for data (via `setDataEnabled`) then it will be enabled
  before setting the value.

  If the key doesn't already exist in the Data Manager then it is created.

  ```javascript
  sprite.setData('name', 'Red Gem Stone');
  ```

  You can also pass in an object of key value pairs as the first argument:

  ```javascript
  sprite.setData({ name: 'Red Gem Stone', level: 2, owner: 'Link', gold: 50 });
  ```

  To get a value back again you can call `getData`:

  ```javascript
  sprite.getData('gold');
  ```

  Or you can access the value directly via the `values` property, where it works like any other variable:

  ```javascript
  sprite.data.values.gold += 50;
  ```

  When the value is first set, a `setdata` event is emitted from this Game Object.

  If the key already exists, a `changedata` event is emitted instead, along an event named after the key.
  For example, if you updated an existing key called `PlayerLives` then it would emit the event `changedata-PlayerLives`.
  These events will be emitted regardless if you use this method to set the value, or the direct `values` setter.

  Please note that the data keys are case-sensitive and must be valid JavaScript Object property strings.
  This means the keys `gold` and `Gold` are treated as two unique values within the Data Manager.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([static-tilemap-layer key]
   (phaser->clj
    (.setData static-tilemap-layer
              (clj->phaser key))))
  ([static-tilemap-layer key data]
   (phaser->clj
    (.setData static-tilemap-layer
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([static-tilemap-layer]
   (phaser->clj
    (.setDataEnabled static-tilemap-layer))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer value]
   (phaser->clj
    (.setDepth static-tilemap-layer
               (clj->phaser value)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setDisplayOrigin static-tilemap-layer)))
  ([static-tilemap-layer x]
   (phaser->clj
    (.setDisplayOrigin static-tilemap-layer
                       (clj->phaser x))))
  ([static-tilemap-layer x y]
   (phaser->clj
    (.setDisplayOrigin static-tilemap-layer
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer width height]
   (phaser->clj
    (.setDisplaySize static-tilemap-layer
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-flip
  "Sets the horizontal and vertical flipped state of this Game Object.

  A Game Object that is flipped will render inversed on the flipped axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * x (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.
    * y (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer x y]
   (phaser->clj
    (.setFlip static-tilemap-layer
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-flip-x
  "Sets the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer value]
   (phaser->clj
    (.setFlipX static-tilemap-layer
               (clj->phaser value)))))

(defn set-flip-y
  "Sets the vertical flipped state of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer value]
   (phaser->clj
    (.setFlipY static-tilemap-layer
               (clj->phaser value)))))

(defn set-interactive
  "Pass this Game Object to the Input Manager to enable it for Input.

  Input works by using hit areas, these are nearly always geometric shapes, such as rectangles or circles, that act as the hit area
  for the Game Object. However, you can provide your own hit area shape and callback, should you wish to handle some more advanced
  input detection.

  If no arguments are provided it will try and create a rectangle hit area based on the texture frame the Game Object is using. If
  this isn't a texture-bound object, such as a Graphics or BitmapText object, this will fail, and you'll need to provide a specific
  shape for it to use.

  You can also provide an Input Configuration Object as the only argument to this method.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([static-tilemap-layer]
   (phaser->clj
    (.setInteractive static-tilemap-layer)))
  ([static-tilemap-layer shape]
   (phaser->clj
    (.setInteractive static-tilemap-layer
                     (clj->phaser shape))))
  ([static-tilemap-layer shape callback]
   (phaser->clj
    (.setInteractive static-tilemap-layer
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([static-tilemap-layer shape callback drop-zone]
   (phaser->clj
    (.setInteractive static-tilemap-layer
                     (clj->phaser shape)
                     (clj->phaser callback)
                     (clj->phaser drop-zone)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([static-tilemap-layer value]
   (phaser->clj
    (.setName static-tilemap-layer
              (clj->phaser value)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setOrigin static-tilemap-layer)))
  ([static-tilemap-layer x]
   (phaser->clj
    (.setOrigin static-tilemap-layer
                (clj->phaser x))))
  ([static-tilemap-layer x y]
   (phaser->clj
    (.setOrigin static-tilemap-layer
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setOriginFromFrame static-tilemap-layer))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer pipeline-name]
   (phaser->clj
    (.setPipeline static-tilemap-layer
                  (clj->phaser pipeline-name)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setPosition static-tilemap-layer)))
  ([static-tilemap-layer x]
   (phaser->clj
    (.setPosition static-tilemap-layer
                  (clj->phaser x))))
  ([static-tilemap-layer x y]
   (phaser->clj
    (.setPosition static-tilemap-layer
                  (clj->phaser x)
                  (clj->phaser y))))
  ([static-tilemap-layer x y z]
   (phaser->clj
    (.setPosition static-tilemap-layer
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([static-tilemap-layer x y z w]
   (phaser->clj
    (.setPosition static-tilemap-layer
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z)
                  (clj->phaser w)))))

(defn set-random-position
  "Sets the position of this Game Object to be a random position within the confines of
  the given area.

  If no area is specified a random position between 0 x 0 and the game width x height is used instead.

  The position does not factor in the size of this Game Object, meaning that only the origin is
  guaranteed to be within the area.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setRandomPosition static-tilemap-layer)))
  ([static-tilemap-layer x]
   (phaser->clj
    (.setRandomPosition static-tilemap-layer
                        (clj->phaser x))))
  ([static-tilemap-layer x y]
   (phaser->clj
    (.setRandomPosition static-tilemap-layer
                        (clj->phaser x)
                        (clj->phaser y))))
  ([static-tilemap-layer x y width]
   (phaser->clj
    (.setRandomPosition static-tilemap-layer
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([static-tilemap-layer x y width height]
   (phaser->clj
    (.setRandomPosition static-tilemap-layer
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-render-order
  "Sets the rendering (draw) order of the tiles in this layer.

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

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * render-order (integer | string) - The render (draw) order value. Either an integer between 0 and 3, or a string: 'right-down', 'left-down', 'right-up' or 'left-up'.

  Returns:  this - This Tilemap Layer object."
  ([static-tilemap-layer render-order]
   (phaser->clj
    (.setRenderOrder static-tilemap-layer
                     (clj->phaser render-order)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setRotation static-tilemap-layer)))
  ([static-tilemap-layer radians]
   (phaser->clj
    (.setRotation static-tilemap-layer
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer x]
   (phaser->clj
    (.setScale static-tilemap-layer
               (clj->phaser x))))
  ([static-tilemap-layer x y]
   (phaser->clj
    (.setScale static-tilemap-layer
               (clj->phaser x)
               (clj->phaser y)))))

(defn set-scroll-factor
  "Sets the scroll factor of this Game Object.

  The scroll factor controls the influence of the movement of a Camera upon this Game Object.

  When a camera scrolls it will change the location at which this Game Object is rendered on-screen.
  It does not change the Game Objects actual position values.

  A value of 1 means it will move exactly in sync with a camera.
  A value of 0 means it will not move at all, even if the camera moves.
  Other values control the degree to which the camera movement is mapped to this Game Object.

  Please be aware that scroll factor values other than 1 are not taken in to consideration when
  calculating physics collisions. Bodies always collide based on their world position, but changing
  the scroll factor is a visual adjustment to where the textures are rendered, which can offset
  them from physics bodies if not accounted for in your code.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer x]
   (phaser->clj
    (.setScrollFactor static-tilemap-layer
                      (clj->phaser x))))
  ([static-tilemap-layer x y]
   (phaser->clj
    (.setScrollFactor static-tilemap-layer
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-size
  "Sets the internal size of this Game Object, as used for frame or physics body creation.

  This will not change the size that the Game Object is rendered in-game.
  For that you need to either set the scale of the Game Object (`setScale`) or call the
  `setDisplaySize` method, which is the same thing as changing the scale but allows you
  to do so by giving pixel values.

  If you have enabled this Game Object for input, changing the size will _not_ change the
  size of the hit area. To do this you should adjust the `input.hitArea` object directly.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer width height]
   (phaser->clj
    (.setSize static-tilemap-layer
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-skip-cull
  "Canvas only.

  You can control if the Cameras should cull tiles before rendering them or not.
  By default the camera will try to cull the tiles in this layer, to avoid over-drawing to the renderer.

  However, there are some instances when you may wish to disable this.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (boolean) {optional} - Set to `true` to stop culling tiles. Set to `false` to enable culling again.

  Returns:  this - This Tilemap Layer object."
  ([static-tilemap-layer]
   (phaser->clj
    (.setSkipCull static-tilemap-layer)))
  ([static-tilemap-layer value]
   (phaser->clj
    (.setSkipCull static-tilemap-layer
                  (clj->phaser value)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([static-tilemap-layer value]
   (phaser->clj
    (.setState static-tilemap-layer
               (clj->phaser value)))))

(defn set-tile-index-callback
  "Sets a global collision callback for the given tile index within the layer. This will affect all
  tiles on this layer that have the same index. If a callback is already set for the tile index it
  will be replaced. Set the callback to null to remove it. If you want to set a callback for a tile
  at a specific location on the map then see setTileLocationCallback.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * indexes (integer | array) - Either a single tile index, or an array of tile indexes to have a
collision callback set for.
    * callback (function) - The callback that will be invoked when the tile is collided with.
    * callback-context (object) - The context under which the callback is called.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer indexes callback callback-context]
   (phaser->clj
    (.setTileIndexCallback static-tilemap-layer
                           (clj->phaser indexes)
                           (clj->phaser callback)
                           (clj->phaser callback-context)))))

(defn set-tile-location-callback
  "Sets a collision callback for the given rectangular area (in tile coordinates) within the layer.
  If a callback is already set for the tile index it will be replaced. Set the callback to null to
  remove it.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-x (integer) - The leftmost tile index (in tile coordinates) to use as the origin of the area.
    * tile-y (integer) - The topmost tile index (in tile coordinates) to use as the origin of the area.
    * width (integer) - How many tiles wide from the `tileX` index the area will be.
    * height (integer) - How many tiles tall from the `tileY` index the area will be.
    * callback (function) - The callback that will be invoked when the tile is collided with.
    * callback-context (object) {optional} - The context under which the callback is called.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer tile-x tile-y width height callback]
   (phaser->clj
    (.setTileLocationCallback static-tilemap-layer
                              (clj->phaser tile-x)
                              (clj->phaser tile-y)
                              (clj->phaser width)
                              (clj->phaser height)
                              (clj->phaser callback))))
  ([static-tilemap-layer tile-x tile-y width height callback callback-context]
   (phaser->clj
    (.setTileLocationCallback static-tilemap-layer
                              (clj->phaser tile-x)
                              (clj->phaser tile-y)
                              (clj->phaser width)
                              (clj->phaser height)
                              (clj->phaser callback)
                              (clj->phaser callback-context)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer value]
   (phaser->clj
    (.setVisible static-tilemap-layer
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setW static-tilemap-layer)))
  ([static-tilemap-layer value]
   (phaser->clj
    (.setW static-tilemap-layer
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setX static-tilemap-layer)))
  ([static-tilemap-layer value]
   (phaser->clj
    (.setX static-tilemap-layer
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setY static-tilemap-layer)))
  ([static-tilemap-layer value]
   (phaser->clj
    (.setY static-tilemap-layer
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.setZ static-tilemap-layer)))
  ([static-tilemap-layer value]
   (phaser->clj
    (.setZ static-tilemap-layer
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([static-tilemap-layer]
   (phaser->clj
    (.shutdown static-tilemap-layer))))

(defn tile-to-world-x
  "Converts from tile X coordinates (tile units) to world X coordinates (pixels), factoring in the
  layers position, scale and scroll.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-x (integer) - The X coordinate, in tile coordinates.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the world values from the tile index.

  Returns:  number - "
  ([static-tilemap-layer tile-x]
   (phaser->clj
    (.tileToWorldX static-tilemap-layer
                   (clj->phaser tile-x))))
  ([static-tilemap-layer tile-x camera]
   (phaser->clj
    (.tileToWorldX static-tilemap-layer
                   (clj->phaser tile-x)
                   (clj->phaser camera)))))

(defn tile-to-world-xy
  "Converts from tile XY coordinates (tile units) to world XY coordinates (pixels), factoring in the
  layers position, scale and scroll. This will return a new Vector2 object or update the given
  `point` object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-x (integer) - The X coordinate, in tile coordinates.
    * tile-y (integer) - The Y coordinate, in tile coordinates.
    * point (Phaser.Math.Vector2) {optional} - A Vector2 to store the coordinates in. If not given, a new Vector2 is created.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the world values from the tile index.

  Returns:  Phaser.Math.Vector2 - "
  ([static-tilemap-layer tile-x tile-y]
   (phaser->clj
    (.tileToWorldXY static-tilemap-layer
                    (clj->phaser tile-x)
                    (clj->phaser tile-y))))
  ([static-tilemap-layer tile-x tile-y point]
   (phaser->clj
    (.tileToWorldXY static-tilemap-layer
                    (clj->phaser tile-x)
                    (clj->phaser tile-y)
                    (clj->phaser point))))
  ([static-tilemap-layer tile-x tile-y point camera]
   (phaser->clj
    (.tileToWorldXY static-tilemap-layer
                    (clj->phaser tile-x)
                    (clj->phaser tile-y)
                    (clj->phaser point)
                    (clj->phaser camera)))))

(defn tile-to-world-y
  "Converts from tile Y coordinates (tile units) to world Y coordinates (pixels), factoring in the
  layers position, scale and scroll.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * tile-y (integer) - The Y coordinate, in tile coordinates.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the world values from the tile index.

  Returns:  number - "
  ([static-tilemap-layer tile-y]
   (phaser->clj
    (.tileToWorldY static-tilemap-layer
                   (clj->phaser tile-y))))
  ([static-tilemap-layer tile-y camera]
   (phaser->clj
    (.tileToWorldY static-tilemap-layer
                   (clj->phaser tile-y)
                   (clj->phaser camera)))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([static-tilemap-layer]
   (phaser->clj
    (.toJSON static-tilemap-layer))))

(defn toggle-flip-x
  "Toggles the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.toggleFlipX static-tilemap-layer))))

(defn toggle-flip-y
  "Toggles the vertical flipped state of this Game Object.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.toggleFlipY static-tilemap-layer))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * args (*) {optional} - args"
  ([static-tilemap-layer]
   (phaser->clj
    (.update static-tilemap-layer)))
  ([static-tilemap-layer args]
   (phaser->clj
    (.update static-tilemap-layer
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([static-tilemap-layer]
   (phaser->clj
    (.updateDisplayOrigin static-tilemap-layer))))

(defn upload
  "Upload the tile data to a VBO.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The camera to render to.
    * tileset-index (integer) - The tileset index.

  Returns:  Phaser.Tilemaps.StaticTilemapLayer - This Tilemap Layer object."
  ([static-tilemap-layer camera tileset-index]
   (phaser->clj
    (.upload static-tilemap-layer
             (clj->phaser camera)
             (clj->phaser tileset-index)))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([static-tilemap-layer camera]
   (phaser->clj
    (.willRender static-tilemap-layer
                 (clj->phaser camera)))))

(defn world-to-tile-x
  "Converts from world X coordinates (pixels) to tile X coordinates (tile units), factoring in the
  layers position, scale and scroll.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * world-x (number) - The X coordinate, in world pixels.
    * snap-to-floor (boolean) {optional} - Whether or not to round the tile coordinate down to the
nearest integer.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.]

  Returns:  number - "
  ([static-tilemap-layer world-x]
   (phaser->clj
    (.worldToTileX static-tilemap-layer
                   (clj->phaser world-x))))
  ([static-tilemap-layer world-x snap-to-floor]
   (phaser->clj
    (.worldToTileX static-tilemap-layer
                   (clj->phaser world-x)
                   (clj->phaser snap-to-floor))))
  ([static-tilemap-layer world-x snap-to-floor camera]
   (phaser->clj
    (.worldToTileX static-tilemap-layer
                   (clj->phaser world-x)
                   (clj->phaser snap-to-floor)
                   (clj->phaser camera)))))

(defn world-to-tile-xy
  "Converts from world XY coordinates (pixels) to tile XY coordinates (tile units), factoring in the
  layers position, scale and scroll. This will return a new Vector2 object or update the given
  `point` object.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * world-x (number) - The X coordinate, in world pixels.
    * world-y (number) - The Y coordinate, in world pixels.
    * snap-to-floor (boolean) {optional} - Whether or not to round the tile coordinate down to the
nearest integer.
    * point (Phaser.Math.Vector2) {optional} - A Vector2 to store the coordinates in. If not given, a new Vector2 is created.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.

  Returns:  Phaser.Math.Vector2 - "
  ([static-tilemap-layer world-x world-y]
   (phaser->clj
    (.worldToTileXY static-tilemap-layer
                    (clj->phaser world-x)
                    (clj->phaser world-y))))
  ([static-tilemap-layer world-x world-y snap-to-floor]
   (phaser->clj
    (.worldToTileXY static-tilemap-layer
                    (clj->phaser world-x)
                    (clj->phaser world-y)
                    (clj->phaser snap-to-floor))))
  ([static-tilemap-layer world-x world-y snap-to-floor point]
   (phaser->clj
    (.worldToTileXY static-tilemap-layer
                    (clj->phaser world-x)
                    (clj->phaser world-y)
                    (clj->phaser snap-to-floor)
                    (clj->phaser point))))
  ([static-tilemap-layer world-x world-y snap-to-floor point camera]
   (phaser->clj
    (.worldToTileXY static-tilemap-layer
                    (clj->phaser world-x)
                    (clj->phaser world-y)
                    (clj->phaser snap-to-floor)
                    (clj->phaser point)
                    (clj->phaser camera)))))

(defn world-to-tile-y
  "Converts from world Y coordinates (pixels) to tile Y coordinates (tile units), factoring in the
  layers position, scale and scroll.

  Parameters:
    * static-tilemap-layer (Phaser.Tilemaps.StaticTilemapLayer) - Targeted instance for method
    * world-y (number) - The Y coordinate, in world pixels.
    * snap-to-floor (boolean) {optional} - Whether or not to round the tile coordinate down to the
nearest integer.
    * camera (Phaser.Cameras.Scene2D.Camera) {optional} - The Camera to use when calculating the tile index from the world values.

  Returns:  number - "
  ([static-tilemap-layer world-y]
   (phaser->clj
    (.worldToTileY static-tilemap-layer
                   (clj->phaser world-y))))
  ([static-tilemap-layer world-y snap-to-floor]
   (phaser->clj
    (.worldToTileY static-tilemap-layer
                   (clj->phaser world-y)
                   (clj->phaser snap-to-floor))))
  ([static-tilemap-layer world-y snap-to-floor camera]
   (phaser->clj
    (.worldToTileY static-tilemap-layer
                   (clj->phaser world-y)
                   (clj->phaser snap-to-floor)
                   (clj->phaser camera)))))