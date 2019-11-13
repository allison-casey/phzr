(ns phzr.display.base-shader
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->BaseShader
  "  Parameters:
    * key (string) - The key of this shader. Must be unique within the shader cache.
    * fragment-src (string) {optional} - The fragment source for the shader.
    * vertex-src (string) {optional} - The vertex source for the shader.
    * uniforms (any) {optional} - Optional object defining the uniforms the shader uses."
  ([key]
   (js/Phaser.Display.BaseShader. (clj->phaser key)))
  ([key fragment-src]
   (js/Phaser.Display.BaseShader. (clj->phaser key)
                                  (clj->phaser fragment-src)))
  ([key fragment-src vertex-src]
   (js/Phaser.Display.BaseShader. (clj->phaser key)
                                  (clj->phaser fragment-src)
                                  (clj->phaser vertex-src)))
  ([key fragment-src vertex-src uniforms]
   (js/Phaser.Display.BaseShader. (clj->phaser key)
                                  (clj->phaser fragment-src)
                                  (clj->phaser vertex-src)
                                  (clj->phaser uniforms))))

