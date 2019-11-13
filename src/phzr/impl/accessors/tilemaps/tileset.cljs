(ns phzr.impl.accessors.tilemaps.tileset)

(def tileset-get-properties
  {:columns "columns"
   :firstgid "firstgid"
   :gl-texture "glTexture"
   :image "image"
   :name "name"
   :rows "rows"
   :tex-coordinates "texCoordinates"
   :tile-data "tileData"
   :tile-height "tileHeight"
   :tile-margin "tileMargin"
   :tile-properties "tileProperties"
   :tile-spacing "tileSpacing"
   :tile-width "tileWidth"
   :total "total"})

(def tileset-set-properties
  {:firstgid "firstgid"
   :name "name"
   :tile-data "tileData"
   :tile-properties "tileProperties"})