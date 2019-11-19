(ns phzr.impl.extend
  (:require [cljsjs.phaser]
            [phzr.impl.extend.core :as ex]
            [phzr.impl.accessors.animations.animation-frame]
            [phzr.impl.accessors.animations.animation-manager]
            [phzr.impl.accessors.animations.animation]
            [phzr.impl.accessors.cache.base-cache]
            [phzr.impl.accessors.cache.cache-manager]
            [phzr.impl.accessors.cameras.controls.fixed-key-control]
            [phzr.impl.accessors.cameras.controls.smoothed-key-control]
            [phzr.impl.accessors.cameras.scene-2-d.base-camera]
            [phzr.impl.accessors.cameras.scene-2-d.camera-manager]
            [phzr.impl.accessors.cameras.scene-2-d.camera]
            [phzr.impl.accessors.cameras.scene-2-d.effects.fade]
            [phzr.impl.accessors.cameras.scene-2-d.effects.flash]
            [phzr.impl.accessors.cameras.scene-2-d.effects.pan]
            [phzr.impl.accessors.cameras.scene-2-d.effects.shake]
            [phzr.impl.accessors.cameras.scene-2-d.effects.zoom]
            [phzr.impl.accessors.core.time-step]
            [phzr.impl.accessors.curves.cubic-bezier]
            [phzr.impl.accessors.curves.curve]
            [phzr.impl.accessors.curves.ellipse]
            [phzr.impl.accessors.curves.line]
            [phzr.impl.accessors.curves.move-to]
            [phzr.impl.accessors.curves.path]
            [phzr.impl.accessors.curves.quadratic-bezier]
            [phzr.impl.accessors.curves.spline]
            [phzr.impl.accessors.data.data-manager-plugin]
            [phzr.impl.accessors.data.data-manager]
            [phzr.impl.accessors.display.base-shader]
            [phzr.impl.accessors.display.color]
            [phzr.impl.accessors.display.masks.bitmap-mask]
            [phzr.impl.accessors.display.masks.geometry-mask]
            [phzr.impl.accessors.dom.request-animation-frame]
            [phzr.impl.accessors.facebook-instant-games-leaderboard]
            [phzr.impl.accessors.facebook-instant-games-plugin]
            [phzr.impl.accessors.game-objects.arc]
            [phzr.impl.accessors.game-objects.bitmap-text]
            [phzr.impl.accessors.game-objects.blitter]
            [phzr.impl.accessors.game-objects.bob]
            [phzr.impl.accessors.game-objects.components.animation]
            [phzr.impl.accessors.game-objects.components.transform-matrix]
            [phzr.impl.accessors.game-objects.container]
            [phzr.impl.accessors.game-objects.curve]
            [phzr.impl.accessors.game-objects.display-list]
            [phzr.impl.accessors.game-objects.dom-element]
            [phzr.impl.accessors.game-objects.dynamic-bitmap-text]
            [phzr.impl.accessors.game-objects.ellipse]
            [phzr.impl.accessors.game-objects.extern]
            [phzr.impl.accessors.game-objects.game-object]
            [phzr.impl.accessors.game-objects.graphics]
            [phzr.impl.accessors.game-objects.grid]
            [phzr.impl.accessors.game-objects.group]
            [phzr.impl.accessors.game-objects.image]
            [phzr.impl.accessors.game-objects.iso-box]
            [phzr.impl.accessors.game-objects.iso-triangle]
            [phzr.impl.accessors.game-objects.light]
            [phzr.impl.accessors.game-objects.lights-manager]
            [phzr.impl.accessors.game-objects.lights-plugin]
            [phzr.impl.accessors.game-objects.line]
            [phzr.impl.accessors.game-objects.mesh]
            [phzr.impl.accessors.game-objects.particles.emitter-op]
            [phzr.impl.accessors.game-objects.particles.gravity-well]
            [phzr.impl.accessors.game-objects.particles.particle-emitter-manager]
            [phzr.impl.accessors.game-objects.particles.particle-emitter]
            [phzr.impl.accessors.game-objects.particles.particle]
            [phzr.impl.accessors.game-objects.particles.zones.death-zone]
            [phzr.impl.accessors.game-objects.particles.zones.edge-zone]
            [phzr.impl.accessors.game-objects.particles.zones.random-zone]
            [phzr.impl.accessors.game-objects.path-follower]
            [phzr.impl.accessors.game-objects.polygon]
            [phzr.impl.accessors.game-objects.quad]
            [phzr.impl.accessors.game-objects.rectangle]
            [phzr.impl.accessors.game-objects.render-texture]
            [phzr.impl.accessors.game-objects.shader]
            [phzr.impl.accessors.game-objects.shape]
            [phzr.impl.accessors.game-objects.sprite]
            [phzr.impl.accessors.game-objects.star]
            [phzr.impl.accessors.game-objects.text-style]
            [phzr.impl.accessors.game-objects.text]
            [phzr.impl.accessors.game-objects.tile-sprite]
            [phzr.impl.accessors.game-objects.triangle]
            [phzr.impl.accessors.game-objects.update-list]
            [phzr.impl.accessors.game-objects.video]
            [phzr.impl.accessors.game-objects.zone]
            [phzr.impl.accessors.game]
            [phzr.impl.accessors.geom.circle]
            [phzr.impl.accessors.geom.ellipse]
            [phzr.impl.accessors.geom.line]
            [phzr.impl.accessors.geom.point]
            [phzr.impl.accessors.geom.polygon]
            [phzr.impl.accessors.geom.rectangle]
            [phzr.impl.accessors.geom.triangle]
            [phzr.impl.accessors.input.gamepad.axis]
            [phzr.impl.accessors.input.gamepad.button]
            [phzr.impl.accessors.input.gamepad.gamepad-plugin]
            [phzr.impl.accessors.input.gamepad.gamepad]
            [phzr.impl.accessors.input.input-manager]
            [phzr.impl.accessors.input.input-plugin]
            [phzr.impl.accessors.input.keyboard.key-combo]
            [phzr.impl.accessors.input.keyboard.key]
            [phzr.impl.accessors.input.keyboard.keyboard-manager]
            [phzr.impl.accessors.input.keyboard.keyboard-plugin]
            [phzr.impl.accessors.input.mouse.mouse-manager]
            [phzr.impl.accessors.input.pointer]
            [phzr.impl.accessors.input.touch.touch-manager]
            [phzr.impl.accessors.loader.file-types.animation-json-file]
            [phzr.impl.accessors.loader.file-types.atlas-json-file]
            [phzr.impl.accessors.loader.file-types.atlas-xml-file]
            [phzr.impl.accessors.loader.file-types.audio-file]
            [phzr.impl.accessors.loader.file-types.audio-sprite-file]
            [phzr.impl.accessors.loader.file-types.binary-file]
            [phzr.impl.accessors.loader.file-types.bitmap-font-file]
            [phzr.impl.accessors.loader.file-types.css-file]
            [phzr.impl.accessors.loader.file-types.glsl-file]
            [phzr.impl.accessors.loader.file-types.html-5-audio-file]
            [phzr.impl.accessors.loader.file-types.html-file]
            [phzr.impl.accessors.loader.file-types.html-texture-file]
            [phzr.impl.accessors.loader.file-types.image-file]
            [phzr.impl.accessors.loader.file-types.json-file]
            [phzr.impl.accessors.loader.file-types.multi-atlas-file]
            [phzr.impl.accessors.loader.file-types.multi-script-file]
            [phzr.impl.accessors.loader.file-types.pack-file]
            [phzr.impl.accessors.loader.file-types.plugin-file]
            [phzr.impl.accessors.loader.file-types.scene-file]
            [phzr.impl.accessors.loader.file-types.scene-plugin-file]
            [phzr.impl.accessors.loader.file-types.script-file]
            [phzr.impl.accessors.loader.file-types.sprite-sheet-file]
            [phzr.impl.accessors.loader.file-types.svg-file]
            [phzr.impl.accessors.loader.file-types.text-file]
            [phzr.impl.accessors.loader.file-types.tilemap-csv-file]
            [phzr.impl.accessors.loader.file-types.tilemap-impact-file]
            [phzr.impl.accessors.loader.file-types.tilemap-json-file]
            [phzr.impl.accessors.loader.file-types.unity-atlas-file]
            [phzr.impl.accessors.loader.file-types.video-file]
            [phzr.impl.accessors.loader.file-types.xml-file]
            [phzr.impl.accessors.loader.file]
            [phzr.impl.accessors.loader.loader-plugin]
            [phzr.impl.accessors.loader.multi-file]
            [phzr.impl.accessors.math.matrix-3]
            [phzr.impl.accessors.math.matrix-4]
            [phzr.impl.accessors.math.quaternion]
            [phzr.impl.accessors.math.random-data-generator]
            [phzr.impl.accessors.math.vector-2]
            [phzr.impl.accessors.math.vector-3]
            [phzr.impl.accessors.math.vector-4]
            [phzr.impl.accessors.physics.arcade.arcade-physics]
            [phzr.impl.accessors.physics.arcade.body]
            [phzr.impl.accessors.physics.arcade.collider]
            [phzr.impl.accessors.physics.arcade.factory]
            [phzr.impl.accessors.physics.arcade.group]
            [phzr.impl.accessors.physics.arcade.image]
            [phzr.impl.accessors.physics.arcade.sprite]
            [phzr.impl.accessors.physics.arcade.static-body]
            [phzr.impl.accessors.physics.arcade.static-group]
            [phzr.impl.accessors.physics.arcade.world]
            [phzr.impl.accessors.physics.impact.body]
            [phzr.impl.accessors.physics.impact.collision-map]
            [phzr.impl.accessors.physics.impact.factory]
            [phzr.impl.accessors.physics.impact.impact-body]
            [phzr.impl.accessors.physics.impact.impact-image]
            [phzr.impl.accessors.physics.impact.impact-physics]
            [phzr.impl.accessors.physics.impact.impact-sprite]
            [phzr.impl.accessors.physics.impact.world]
            [phzr.impl.accessors.physics.matter.factory]
            [phzr.impl.accessors.physics.matter.image]
            [phzr.impl.accessors.physics.matter.matter-physics]
            [phzr.impl.accessors.physics.matter.pointer-constraint]
            [phzr.impl.accessors.physics.matter.sprite]
            [phzr.impl.accessors.physics.matter.tile-body]
            [phzr.impl.accessors.physics.matter.world]
            [phzr.impl.accessors.plugins.plugin-manager]
            [phzr.impl.accessors.renderer.canvas.canvas-renderer]
            [phzr.impl.accessors.renderer.webgl.pipelines.bitmap-mask-pipeline]
            [phzr.impl.accessors.renderer.webgl.pipelines.forward-diffuse-light-pipeline]
            [phzr.impl.accessors.renderer.webgl.pipelines.texture-tint-pipeline]
            [phzr.impl.accessors.renderer.webgl.webgl-pipeline]
            [phzr.impl.accessors.renderer.webgl.webgl-renderer]
            [phzr.impl.accessors.scale.scale-manager]
            [phzr.impl.accessors.scene]
            [phzr.impl.accessors.scenes.scene-manager]
            [phzr.impl.accessors.scenes.scene-plugin]
            [phzr.impl.accessors.scenes.systems]
            [phzr.impl.accessors.sound.base-sound-manager]
            [phzr.impl.accessors.sound.base-sound]
            [phzr.impl.accessors.sound.html-5-audio-sound-manager]
            [phzr.impl.accessors.sound.html-5-audio-sound]
            [phzr.impl.accessors.sound.no-audio-sound-manager]
            [phzr.impl.accessors.sound.no-audio-sound]
            [phzr.impl.accessors.sound.web-audio-sound-manager]
            [phzr.impl.accessors.sound.web-audio-sound]
            [phzr.impl.accessors.structs.list]
            [phzr.impl.accessors.structs.map]
            [phzr.impl.accessors.structs.process-queue]
            [phzr.impl.accessors.structs.set]
            [phzr.impl.accessors.structs.size]
            [phzr.impl.accessors.textures.canvas-texture]
            [phzr.impl.accessors.textures.frame]
            [phzr.impl.accessors.textures.texture-manager]
            [phzr.impl.accessors.textures.texture-source]
            [phzr.impl.accessors.textures.texture]
            [phzr.impl.accessors.tilemaps.dynamic-tilemap-layer]
            [phzr.impl.accessors.tilemaps.image-collection]
            [phzr.impl.accessors.tilemaps.layer-data]
            [phzr.impl.accessors.tilemaps.map-data]
            [phzr.impl.accessors.tilemaps.object-layer]
            [phzr.impl.accessors.tilemaps.static-tilemap-layer]
            [phzr.impl.accessors.tilemaps.tile]
            [phzr.impl.accessors.tilemaps.tilemap]
            [phzr.impl.accessors.tilemaps.tileset]
            [phzr.impl.accessors.time.clock]
            [phzr.impl.accessors.time.timer-event]
            [phzr.impl.accessors.tweens.timeline]
            [phzr.impl.accessors.tweens.tween-manager]
            [phzr.impl.accessors.tweens.tween]))

(ex/extend-phaser-class
 js/Phaser.Animations.Animation
 phzr.impl.accessors.animations.animation/animation-get-properties
 phzr.impl.accessors.animations.animation/animation-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Animations.AnimationFrame
 phzr.impl.accessors.animations.animation-frame/animation-frame-get-properties
 phzr.impl.accessors.animations.animation-frame/animation-frame-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Animations.AnimationManager
 phzr.impl.accessors.animations.animation-manager/animation-manager-get-properties
 phzr.impl.accessors.animations.animation-manager/animation-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cache.BaseCache
 phzr.impl.accessors.cache.base-cache/base-cache-get-properties
 phzr.impl.accessors.cache.base-cache/base-cache-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cache.CacheManager
 phzr.impl.accessors.cache.cache-manager/cache-manager-get-properties
 phzr.impl.accessors.cache.cache-manager/cache-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Controls.FixedKeyControl
 phzr.impl.accessors.cameras.controls.fixed-key-control/fixed-key-control-get-properties
 phzr.impl.accessors.cameras.controls.fixed-key-control/fixed-key-control-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Controls.SmoothedKeyControl
 phzr.impl.accessors.cameras.controls.smoothed-key-control/smoothed-key-control-get-properties
 phzr.impl.accessors.cameras.controls.smoothed-key-control/smoothed-key-control-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Scene2D.BaseCamera
 phzr.impl.accessors.cameras.scene-2-d.base-camera/base-camera-get-properties
 phzr.impl.accessors.cameras.scene-2-d.base-camera/base-camera-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Scene2D.Camera
 phzr.impl.accessors.cameras.scene-2-d.camera/camera-get-properties
 phzr.impl.accessors.cameras.scene-2-d.camera/camera-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Scene2D.CameraManager
 phzr.impl.accessors.cameras.scene-2-d.camera-manager/camera-manager-get-properties
 phzr.impl.accessors.cameras.scene-2-d.camera-manager/camera-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Scene2D.Effects.Fade
 phzr.impl.accessors.cameras.scene-2-d.effects.fade/fade-get-properties
 phzr.impl.accessors.cameras.scene-2-d.effects.fade/fade-set-properties
 nil)

(js/console.log "Extending Flash")

(ex/extend-phaser-class
 js/Phaser.Cameras.Scene2D.Effects.Flash
 phzr.impl.accessors.cameras.scene-2-d.effects.flash/flash-get-properties
 phzr.impl.accessors.cameras.scene-2-d.effects.flash/flash-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Scene2D.Effects.Pan
 phzr.impl.accessors.cameras.scene-2-d.effects.pan/pan-get-properties
 phzr.impl.accessors.cameras.scene-2-d.effects.pan/pan-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Scene2D.Effects.Shake
 phzr.impl.accessors.cameras.scene-2-d.effects.shake/shake-get-properties
 phzr.impl.accessors.cameras.scene-2-d.effects.shake/shake-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Cameras.Scene2D.Effects.Zoom
 phzr.impl.accessors.cameras.scene-2-d.effects.zoom/zoom-get-properties
 phzr.impl.accessors.cameras.scene-2-d.effects.zoom/zoom-set-properties
 nil)


(ex/extend-phaser-class
 js/Phaser.Core.Config
 nil
 nil
 nil)

(ex/extend-phaser-class
 js/Phaser.Core.TimeStep
 phzr.impl.accessors.core.time-step/time-step-get-properties
 phzr.impl.accessors.core.time-step/time-step-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Curves.CubicBezier
 phzr.impl.accessors.curves.cubic-bezier/cubic-bezier-get-properties
 phzr.impl.accessors.curves.cubic-bezier/cubic-bezier-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Curves.Curve
 phzr.impl.accessors.curves.curve/curve-get-properties
 phzr.impl.accessors.curves.curve/curve-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Curves.Ellipse
 phzr.impl.accessors.curves.ellipse/ellipse-get-properties
 phzr.impl.accessors.curves.ellipse/ellipse-set-properties
 nil)


(ex/extend-phaser-class
 js/Phaser.Curves.Line
 phzr.impl.accessors.curves.line/line-get-properties
 phzr.impl.accessors.curves.line/line-set-properties
 nil)

(js/console.log "Extending MoveTo")

(ex/extend-phaser-class
 js/Phaser.Curves.MoveTo
 phzr.impl.accessors.curves.move-to/move-to-get-properties
 phzr.impl.accessors.curves.move-to/move-to-set-properties
 nil)


(ex/extend-phaser-class
 js/Phaser.Curves.Path
 phzr.impl.accessors.curves.path/path-get-properties
 phzr.impl.accessors.curves.path/path-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Curves.QuadraticBezier
 phzr.impl.accessors.curves.quadratic-bezier/quadratic-bezier-get-properties
 phzr.impl.accessors.curves.quadratic-bezier/quadratic-bezier-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Curves.Spline
 phzr.impl.accessors.curves.spline/spline-get-properties
 phzr.impl.accessors.curves.spline/spline-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.DOM.RequestAnimationFrame
 phzr.impl.accessors.dom.request-animation-frame/request-animation-frame-get-properties
 phzr.impl.accessors.dom.request-animation-frame/request-animation-frame-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Data.DataManager
 phzr.impl.accessors.data.data-manager/data-manager-get-properties
 phzr.impl.accessors.data.data-manager/data-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Data.DataManagerPlugin
 phzr.impl.accessors.data.data-manager-plugin/data-manager-plugin-get-properties
 phzr.impl.accessors.data.data-manager-plugin/data-manager-plugin-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Display.BaseShader
 phzr.impl.accessors.display.base-shader/base-shader-get-properties
 phzr.impl.accessors.display.base-shader/base-shader-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Display.Color
 phzr.impl.accessors.display.color/color-get-properties
 phzr.impl.accessors.display.color/color-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Display.Masks.BitmapMask
 phzr.impl.accessors.display.masks.bitmap-mask/bitmap-mask-get-properties
 phzr.impl.accessors.display.masks.bitmap-mask/bitmap-mask-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Display.Masks.GeometryMask
 phzr.impl.accessors.display.masks.geometry-mask/geometry-mask-get-properties
 phzr.impl.accessors.display.masks.geometry-mask/geometry-mask-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Events.EventEmitter
 nil
 nil
 nil)

(ex/extend-phaser-class
 js/Phaser.FacebookInstantGamesLeaderboard
 phzr.impl.accessors.facebook-instant-games-leaderboard/facebook-instant-games-leaderboard-get-properties
 phzr.impl.accessors.facebook-instant-games-leaderboard/facebook-instant-games-leaderboard-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.FacebookInstantGamesPlugin
 phzr.impl.accessors.facebook-instant-games-plugin/facebook-instant-games-plugin-get-properties
 phzr.impl.accessors.facebook-instant-games-plugin/facebook-instant-games-plugin-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Game
 phzr.impl.accessors.game/game-get-properties
 phzr.impl.accessors.game/game-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Arc
 phzr.impl.accessors.game-objects.arc/arc-get-properties
 phzr.impl.accessors.game-objects.arc/arc-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.BitmapText
 phzr.impl.accessors.game-objects.bitmap-text/bitmap-text-get-properties
 phzr.impl.accessors.game-objects.bitmap-text/bitmap-text-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Blitter
 phzr.impl.accessors.game-objects.blitter/blitter-get-properties
 phzr.impl.accessors.game-objects.blitter/blitter-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Bob
 phzr.impl.accessors.game-objects.bob/bob-get-properties
 phzr.impl.accessors.game-objects.bob/bob-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Components.Animation
 phzr.impl.accessors.game-objects.components.animation/animation-get-properties
 phzr.impl.accessors.game-objects.components.animation/animation-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Components.TransformMatrix
 phzr.impl.accessors.game-objects.components.transform-matrix/transform-matrix-get-properties
 phzr.impl.accessors.game-objects.components.transform-matrix/transform-matrix-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Container
 phzr.impl.accessors.game-objects.container/container-get-properties
 phzr.impl.accessors.game-objects.container/container-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Curve
 phzr.impl.accessors.game-objects.curve/curve-get-properties
 phzr.impl.accessors.game-objects.curve/curve-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.DOMElement
 phzr.impl.accessors.game-objects.dom-element/dom-element-get-properties
 phzr.impl.accessors.game-objects.dom-element/dom-element-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.DisplayList
 phzr.impl.accessors.game-objects.display-list/display-list-get-properties
 phzr.impl.accessors.game-objects.display-list/display-list-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.DynamicBitmapText
 phzr.impl.accessors.game-objects.dynamic-bitmap-text/dynamic-bitmap-text-get-properties
 phzr.impl.accessors.game-objects.dynamic-bitmap-text/dynamic-bitmap-text-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Ellipse
 phzr.impl.accessors.game-objects.ellipse/ellipse-get-properties
 phzr.impl.accessors.game-objects.ellipse/ellipse-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Extern
 phzr.impl.accessors.game-objects.extern/extern-get-properties
 phzr.impl.accessors.game-objects.extern/extern-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.GameObject
 phzr.impl.accessors.game-objects.game-object/game-object-get-properties
 phzr.impl.accessors.game-objects.game-object/game-object-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.GameObjectCreator
 nil
 nil
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.GameObjectFactory
 nil
 nil
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Graphics
 phzr.impl.accessors.game-objects.graphics/graphics-get-properties
 phzr.impl.accessors.game-objects.graphics/graphics-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Grid
 phzr.impl.accessors.game-objects.grid/grid-get-properties
 phzr.impl.accessors.game-objects.grid/grid-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Group
 phzr.impl.accessors.game-objects.group/group-get-properties
 phzr.impl.accessors.game-objects.group/group-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Image
 phzr.impl.accessors.game-objects.image/image-get-properties
 phzr.impl.accessors.game-objects.image/image-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.IsoBox
 phzr.impl.accessors.game-objects.iso-box/iso-box-get-properties
 phzr.impl.accessors.game-objects.iso-box/iso-box-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.IsoTriangle
 phzr.impl.accessors.game-objects.iso-triangle/iso-triangle-get-properties
 phzr.impl.accessors.game-objects.iso-triangle/iso-triangle-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Light
 phzr.impl.accessors.game-objects.light/light-get-properties
 phzr.impl.accessors.game-objects.light/light-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.LightsManager
 phzr.impl.accessors.game-objects.lights-manager/lights-manager-get-properties
 phzr.impl.accessors.game-objects.lights-manager/lights-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.LightsPlugin
 phzr.impl.accessors.game-objects.lights-plugin/lights-plugin-get-properties
 phzr.impl.accessors.game-objects.lights-plugin/lights-plugin-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Line
 phzr.impl.accessors.game-objects.line/line-get-properties
 phzr.impl.accessors.game-objects.line/line-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Mesh
 phzr.impl.accessors.game-objects.mesh/mesh-get-properties
 phzr.impl.accessors.game-objects.mesh/mesh-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Particles.EmitterOp
 phzr.impl.accessors.game-objects.particles.emitter-op/emitter-op-get-properties
 phzr.impl.accessors.game-objects.particles.emitter-op/emitter-op-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Particles.GravityWell
 phzr.impl.accessors.game-objects.particles.gravity-well/gravity-well-get-properties
 phzr.impl.accessors.game-objects.particles.gravity-well/gravity-well-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Particles.Particle
 phzr.impl.accessors.game-objects.particles.particle/particle-get-properties
 phzr.impl.accessors.game-objects.particles.particle/particle-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Particles.ParticleEmitter
 phzr.impl.accessors.game-objects.particles.particle-emitter/particle-emitter-get-properties
 phzr.impl.accessors.game-objects.particles.particle-emitter/particle-emitter-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Particles.ParticleEmitterManager
 phzr.impl.accessors.game-objects.particles.particle-emitter-manager/particle-emitter-manager-get-properties
 phzr.impl.accessors.game-objects.particles.particle-emitter-manager/particle-emitter-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Particles.Zones.DeathZone
 phzr.impl.accessors.game-objects.particles.zones.death-zone/death-zone-get-properties
 phzr.impl.accessors.game-objects.particles.zones.death-zone/death-zone-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Particles.Zones.EdgeZone
 phzr.impl.accessors.game-objects.particles.zones.edge-zone/edge-zone-get-properties
 phzr.impl.accessors.game-objects.particles.zones.edge-zone/edge-zone-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Particles.Zones.RandomZone
 phzr.impl.accessors.game-objects.particles.zones.random-zone/random-zone-get-properties
 phzr.impl.accessors.game-objects.particles.zones.random-zone/random-zone-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.PathFollower
 phzr.impl.accessors.game-objects.path-follower/path-follower-get-properties
 phzr.impl.accessors.game-objects.path-follower/path-follower-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Polygon
 phzr.impl.accessors.game-objects.polygon/polygon-get-properties
 phzr.impl.accessors.game-objects.polygon/polygon-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Quad
 phzr.impl.accessors.game-objects.quad/quad-get-properties
 phzr.impl.accessors.game-objects.quad/quad-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Rectangle
 phzr.impl.accessors.game-objects.rectangle/rectangle-get-properties
 phzr.impl.accessors.game-objects.rectangle/rectangle-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.RenderTexture
 phzr.impl.accessors.game-objects.render-texture/render-texture-get-properties
 phzr.impl.accessors.game-objects.render-texture/render-texture-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Shader
 phzr.impl.accessors.game-objects.shader/shader-get-properties
 phzr.impl.accessors.game-objects.shader/shader-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Shape
 phzr.impl.accessors.game-objects.shape/shape-get-properties
 phzr.impl.accessors.game-objects.shape/shape-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Sprite
 phzr.impl.accessors.game-objects.sprite/sprite-get-properties
 phzr.impl.accessors.game-objects.sprite/sprite-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Star
 phzr.impl.accessors.game-objects.star/star-get-properties
 phzr.impl.accessors.game-objects.star/star-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Text
 phzr.impl.accessors.game-objects.text/text-get-properties
 phzr.impl.accessors.game-objects.text/text-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.TextStyle
 phzr.impl.accessors.game-objects.text-style/text-style-get-properties
 phzr.impl.accessors.game-objects.text-style/text-style-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.TileSprite
 phzr.impl.accessors.game-objects.tile-sprite/tile-sprite-get-properties
 phzr.impl.accessors.game-objects.tile-sprite/tile-sprite-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Triangle
 phzr.impl.accessors.game-objects.triangle/triangle-get-properties
 phzr.impl.accessors.game-objects.triangle/triangle-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.UpdateList
 phzr.impl.accessors.game-objects.update-list/update-list-get-properties
 phzr.impl.accessors.game-objects.update-list/update-list-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Video
 phzr.impl.accessors.game-objects.video/video-get-properties
 phzr.impl.accessors.game-objects.video/video-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.GameObjects.Zone
 phzr.impl.accessors.game-objects.zone/zone-get-properties
 phzr.impl.accessors.game-objects.zone/zone-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Geom.Circle
 phzr.impl.accessors.geom.circle/circle-get-properties
 phzr.impl.accessors.geom.circle/circle-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Geom.Ellipse
 phzr.impl.accessors.geom.ellipse/ellipse-get-properties
 phzr.impl.accessors.geom.ellipse/ellipse-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Geom.Line
 phzr.impl.accessors.geom.line/line-get-properties
 phzr.impl.accessors.geom.line/line-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Geom.Point
 phzr.impl.accessors.geom.point/point-get-properties
 phzr.impl.accessors.geom.point/point-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Geom.Polygon
 phzr.impl.accessors.geom.polygon/polygon-get-properties
 phzr.impl.accessors.geom.polygon/polygon-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Geom.Rectangle
 phzr.impl.accessors.geom.rectangle/rectangle-get-properties
 phzr.impl.accessors.geom.rectangle/rectangle-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Geom.Triangle
 phzr.impl.accessors.geom.triangle/triangle-get-properties
 phzr.impl.accessors.geom.triangle/triangle-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Gamepad.Axis
 phzr.impl.accessors.input.gamepad.axis/axis-get-properties
 phzr.impl.accessors.input.gamepad.axis/axis-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Gamepad.Button
 phzr.impl.accessors.input.gamepad.button/button-get-properties
 phzr.impl.accessors.input.gamepad.button/button-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Gamepad.Gamepad
 phzr.impl.accessors.input.gamepad.gamepad/gamepad-get-properties
 phzr.impl.accessors.input.gamepad.gamepad/gamepad-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Gamepad.GamepadPlugin
 phzr.impl.accessors.input.gamepad.gamepad-plugin/gamepad-plugin-get-properties
 phzr.impl.accessors.input.gamepad.gamepad-plugin/gamepad-plugin-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.InputManager
 phzr.impl.accessors.input.input-manager/input-manager-get-properties
 phzr.impl.accessors.input.input-manager/input-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.InputPlugin
 phzr.impl.accessors.input.input-plugin/input-plugin-get-properties
 phzr.impl.accessors.input.input-plugin/input-plugin-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Keyboard.Key
 phzr.impl.accessors.input.keyboard.key/key-get-properties
 phzr.impl.accessors.input.keyboard.key/key-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Keyboard.KeyCombo
 phzr.impl.accessors.input.keyboard.key-combo/key-combo-get-properties
 phzr.impl.accessors.input.keyboard.key-combo/key-combo-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Keyboard.KeyboardManager
 phzr.impl.accessors.input.keyboard.keyboard-manager/keyboard-manager-get-properties
 phzr.impl.accessors.input.keyboard.keyboard-manager/keyboard-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Keyboard.KeyboardPlugin
 phzr.impl.accessors.input.keyboard.keyboard-plugin/keyboard-plugin-get-properties
 phzr.impl.accessors.input.keyboard.keyboard-plugin/keyboard-plugin-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Mouse.MouseManager
 phzr.impl.accessors.input.mouse.mouse-manager/mouse-manager-get-properties
 phzr.impl.accessors.input.mouse.mouse-manager/mouse-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Pointer
 phzr.impl.accessors.input.pointer/pointer-get-properties
 phzr.impl.accessors.input.pointer/pointer-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Input.Touch.TouchManager
 phzr.impl.accessors.input.touch.touch-manager/touch-manager-get-properties
 phzr.impl.accessors.input.touch.touch-manager/touch-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.File
 phzr.impl.accessors.loader.file/file-get-properties
 phzr.impl.accessors.loader.file/file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.AnimationJSONFile
 phzr.impl.accessors.loader.file-types.animation-json-file/animation-json-file-get-properties
 phzr.impl.accessors.loader.file-types.animation-json-file/animation-json-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.AtlasJSONFile
 phzr.impl.accessors.loader.file-types.atlas-json-file/atlas-json-file-get-properties
 phzr.impl.accessors.loader.file-types.atlas-json-file/atlas-json-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.AtlasXMLFile
 phzr.impl.accessors.loader.file-types.atlas-xml-file/atlas-xml-file-get-properties
 phzr.impl.accessors.loader.file-types.atlas-xml-file/atlas-xml-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.AudioFile
 phzr.impl.accessors.loader.file-types.audio-file/audio-file-get-properties
 phzr.impl.accessors.loader.file-types.audio-file/audio-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.AudioSpriteFile
 phzr.impl.accessors.loader.file-types.audio-sprite-file/audio-sprite-file-get-properties
 phzr.impl.accessors.loader.file-types.audio-sprite-file/audio-sprite-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.BinaryFile
 phzr.impl.accessors.loader.file-types.binary-file/binary-file-get-properties
 phzr.impl.accessors.loader.file-types.binary-file/binary-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.BitmapFontFile
 phzr.impl.accessors.loader.file-types.bitmap-font-file/bitmap-font-file-get-properties
 phzr.impl.accessors.loader.file-types.bitmap-font-file/bitmap-font-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.CSSFile
 phzr.impl.accessors.loader.file-types.css-file/css-file-get-properties
 phzr.impl.accessors.loader.file-types.css-file/css-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.GLSLFile
 phzr.impl.accessors.loader.file-types.glsl-file/glsl-file-get-properties
 phzr.impl.accessors.loader.file-types.glsl-file/glsl-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.HTML5AudioFile
 phzr.impl.accessors.loader.file-types.html-5-audio-file/html-5-audio-file-get-properties
 phzr.impl.accessors.loader.file-types.html-5-audio-file/html-5-audio-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.HTMLFile
 phzr.impl.accessors.loader.file-types.html-file/html-file-get-properties
 phzr.impl.accessors.loader.file-types.html-file/html-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.HTMLTextureFile
 phzr.impl.accessors.loader.file-types.html-texture-file/html-texture-file-get-properties
 phzr.impl.accessors.loader.file-types.html-texture-file/html-texture-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.ImageFile
 phzr.impl.accessors.loader.file-types.image-file/image-file-get-properties
 phzr.impl.accessors.loader.file-types.image-file/image-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.JSONFile
 phzr.impl.accessors.loader.file-types.json-file/json-file-get-properties
 phzr.impl.accessors.loader.file-types.json-file/json-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.MultiAtlasFile
 phzr.impl.accessors.loader.file-types.multi-atlas-file/multi-atlas-file-get-properties
 phzr.impl.accessors.loader.file-types.multi-atlas-file/multi-atlas-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.MultiScriptFile
 phzr.impl.accessors.loader.file-types.multi-script-file/multi-script-file-get-properties
 phzr.impl.accessors.loader.file-types.multi-script-file/multi-script-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.PackFile
 phzr.impl.accessors.loader.file-types.pack-file/pack-file-get-properties
 phzr.impl.accessors.loader.file-types.pack-file/pack-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.PluginFile
 phzr.impl.accessors.loader.file-types.plugin-file/plugin-file-get-properties
 phzr.impl.accessors.loader.file-types.plugin-file/plugin-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.SVGFile
 phzr.impl.accessors.loader.file-types.svg-file/svg-file-get-properties
 phzr.impl.accessors.loader.file-types.svg-file/svg-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.SceneFile
 phzr.impl.accessors.loader.file-types.scene-file/scene-file-get-properties
 phzr.impl.accessors.loader.file-types.scene-file/scene-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.ScenePluginFile
 phzr.impl.accessors.loader.file-types.scene-plugin-file/scene-plugin-file-get-properties
 phzr.impl.accessors.loader.file-types.scene-plugin-file/scene-plugin-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.ScriptFile
 phzr.impl.accessors.loader.file-types.script-file/script-file-get-properties
 phzr.impl.accessors.loader.file-types.script-file/script-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.SpriteSheetFile
 phzr.impl.accessors.loader.file-types.sprite-sheet-file/sprite-sheet-file-get-properties
 phzr.impl.accessors.loader.file-types.sprite-sheet-file/sprite-sheet-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.TextFile
 phzr.impl.accessors.loader.file-types.text-file/text-file-get-properties
 phzr.impl.accessors.loader.file-types.text-file/text-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.TilemapCSVFile
 phzr.impl.accessors.loader.file-types.tilemap-csv-file/tilemap-csv-file-get-properties
 phzr.impl.accessors.loader.file-types.tilemap-csv-file/tilemap-csv-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.TilemapImpactFile
 phzr.impl.accessors.loader.file-types.tilemap-impact-file/tilemap-impact-file-get-properties
 phzr.impl.accessors.loader.file-types.tilemap-impact-file/tilemap-impact-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.TilemapJSONFile
 phzr.impl.accessors.loader.file-types.tilemap-json-file/tilemap-json-file-get-properties
 phzr.impl.accessors.loader.file-types.tilemap-json-file/tilemap-json-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.UnityAtlasFile
 phzr.impl.accessors.loader.file-types.unity-atlas-file/unity-atlas-file-get-properties
 phzr.impl.accessors.loader.file-types.unity-atlas-file/unity-atlas-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.VideoFile
 phzr.impl.accessors.loader.file-types.video-file/video-file-get-properties
 phzr.impl.accessors.loader.file-types.video-file/video-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.FileTypes.XMLFile
 phzr.impl.accessors.loader.file-types.xml-file/xml-file-get-properties
 phzr.impl.accessors.loader.file-types.xml-file/xml-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.LoaderPlugin
 phzr.impl.accessors.loader.loader-plugin/loader-plugin-get-properties
 phzr.impl.accessors.loader.loader-plugin/loader-plugin-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Loader.MultiFile
 phzr.impl.accessors.loader.multi-file/multi-file-get-properties
 phzr.impl.accessors.loader.multi-file/multi-file-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Math.Matrix3
 phzr.impl.accessors.math.matrix-3/matrix-3-get-properties
 phzr.impl.accessors.math.matrix-3/matrix-3-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Math.Matrix4
 phzr.impl.accessors.math.matrix-4/matrix-4-get-properties
 phzr.impl.accessors.math.matrix-4/matrix-4-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Math.Quaternion
 phzr.impl.accessors.math.quaternion/quaternion-get-properties
 phzr.impl.accessors.math.quaternion/quaternion-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Math.RandomDataGenerator
 phzr.impl.accessors.math.random-data-generator/random-data-generator-get-properties
 phzr.impl.accessors.math.random-data-generator/random-data-generator-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Math.Vector2
 phzr.impl.accessors.math.vector-2/vector-2-get-properties
 phzr.impl.accessors.math.vector-2/vector-2-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Math.Vector3
 phzr.impl.accessors.math.vector-3/vector-3-get-properties
 phzr.impl.accessors.math.vector-3/vector-3-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Math.Vector4
 phzr.impl.accessors.math.vector-4/vector-4-get-properties
 phzr.impl.accessors.math.vector-4/vector-4-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.ArcadePhysics
 phzr.impl.accessors.physics.arcade.arcade-physics/arcade-physics-get-properties
 phzr.impl.accessors.physics.arcade.arcade-physics/arcade-physics-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.Body
 phzr.impl.accessors.physics.arcade.body/body-get-properties
 phzr.impl.accessors.physics.arcade.body/body-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.Collider
 phzr.impl.accessors.physics.arcade.collider/collider-get-properties
 phzr.impl.accessors.physics.arcade.collider/collider-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.Factory
 phzr.impl.accessors.physics.arcade.factory/factory-get-properties
 phzr.impl.accessors.physics.arcade.factory/factory-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.Group
 phzr.impl.accessors.physics.arcade.group/group-get-properties
 phzr.impl.accessors.physics.arcade.group/group-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.Image
 phzr.impl.accessors.physics.arcade.image/image-get-properties
 phzr.impl.accessors.physics.arcade.image/image-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.Sprite
 phzr.impl.accessors.physics.arcade.sprite/sprite-get-properties
 phzr.impl.accessors.physics.arcade.sprite/sprite-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.StaticBody
 phzr.impl.accessors.physics.arcade.static-body/static-body-get-properties
 phzr.impl.accessors.physics.arcade.static-body/static-body-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.StaticGroup
 phzr.impl.accessors.physics.arcade.static-group/static-group-get-properties
 phzr.impl.accessors.physics.arcade.static-group/static-group-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Arcade.World
 phzr.impl.accessors.physics.arcade.world/world-get-properties
 phzr.impl.accessors.physics.arcade.world/world-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Impact.Body
 phzr.impl.accessors.physics.impact.body/body-get-properties
 phzr.impl.accessors.physics.impact.body/body-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Impact.CollisionMap
 phzr.impl.accessors.physics.impact.collision-map/collision-map-get-properties
 phzr.impl.accessors.physics.impact.collision-map/collision-map-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Impact.Factory
 phzr.impl.accessors.physics.impact.factory/factory-get-properties
 phzr.impl.accessors.physics.impact.factory/factory-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Impact.ImpactBody
 phzr.impl.accessors.physics.impact.impact-body/impact-body-get-properties
 phzr.impl.accessors.physics.impact.impact-body/impact-body-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Impact.ImpactImage
 phzr.impl.accessors.physics.impact.impact-image/impact-image-get-properties
 phzr.impl.accessors.physics.impact.impact-image/impact-image-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Impact.ImpactPhysics
 phzr.impl.accessors.physics.impact.impact-physics/impact-physics-get-properties
 phzr.impl.accessors.physics.impact.impact-physics/impact-physics-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Impact.ImpactSprite
 phzr.impl.accessors.physics.impact.impact-sprite/impact-sprite-get-properties
 phzr.impl.accessors.physics.impact.impact-sprite/impact-sprite-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Impact.World
 phzr.impl.accessors.physics.impact.world/world-get-properties
 phzr.impl.accessors.physics.impact.world/world-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Matter.Factory
 phzr.impl.accessors.physics.matter.factory/factory-get-properties
 phzr.impl.accessors.physics.matter.factory/factory-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Matter.Image
 phzr.impl.accessors.physics.matter.image/image-get-properties
 phzr.impl.accessors.physics.matter.image/image-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Matter.MatterPhysics
 phzr.impl.accessors.physics.matter.matter-physics/matter-physics-get-properties
 phzr.impl.accessors.physics.matter.matter-physics/matter-physics-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Matter.PointerConstraint
 phzr.impl.accessors.physics.matter.pointer-constraint/pointer-constraint-get-properties
 phzr.impl.accessors.physics.matter.pointer-constraint/pointer-constraint-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Matter.Sprite
 phzr.impl.accessors.physics.matter.sprite/sprite-get-properties
 phzr.impl.accessors.physics.matter.sprite/sprite-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Matter.TileBody
 phzr.impl.accessors.physics.matter.tile-body/tile-body-get-properties
 phzr.impl.accessors.physics.matter.tile-body/tile-body-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Physics.Matter.World
 phzr.impl.accessors.physics.matter.world/world-get-properties
 phzr.impl.accessors.physics.matter.world/world-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Plugins.BasePlugin
 nil
 nil
 nil)

(ex/extend-phaser-class
 js/Phaser.Plugins.PluginManager
 phzr.impl.accessors.plugins.plugin-manager/plugin-manager-get-properties
 phzr.impl.accessors.plugins.plugin-manager/plugin-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Plugins.ScenePlugin
 nil
 nil
 nil)

(ex/extend-phaser-class
 js/Phaser.Renderer.Canvas.CanvasRenderer
 phzr.impl.accessors.renderer.canvas.canvas-renderer/canvas-renderer-get-properties
 phzr.impl.accessors.renderer.canvas.canvas-renderer/canvas-renderer-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Renderer.WebGL.Pipelines.BitmapMaskPipeline
 phzr.impl.accessors.renderer.webgl.pipelines.bitmap-mask-pipeline/bitmap-mask-pipeline-get-properties
 phzr.impl.accessors.renderer.webgl.pipelines.bitmap-mask-pipeline/bitmap-mask-pipeline-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Renderer.WebGL.Pipelines.ForwardDiffuseLightPipeline
 phzr.impl.accessors.renderer.webgl.pipelines.forward-diffuse-light-pipeline/forward-diffuse-light-pipeline-get-properties
 phzr.impl.accessors.renderer.webgl.pipelines.forward-diffuse-light-pipeline/forward-diffuse-light-pipeline-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Renderer.WebGL.Pipelines.TextureTintPipeline
 phzr.impl.accessors.renderer.webgl.pipelines.texture-tint-pipeline/texture-tint-pipeline-get-properties
 phzr.impl.accessors.renderer.webgl.pipelines.texture-tint-pipeline/texture-tint-pipeline-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Renderer.WebGL.WebGLPipeline
 phzr.impl.accessors.renderer.webgl.webgl-pipeline/webgl-pipeline-get-properties
 phzr.impl.accessors.renderer.webgl.webgl-pipeline/webgl-pipeline-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Renderer.WebGL.WebGLRenderer
 phzr.impl.accessors.renderer.webgl.webgl-renderer/webgl-renderer-get-properties
 phzr.impl.accessors.renderer.webgl.webgl-renderer/webgl-renderer-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Scale.ScaleManager
 phzr.impl.accessors.scale.scale-manager/scale-manager-get-properties
 phzr.impl.accessors.scale.scale-manager/scale-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Scene
 phzr.impl.accessors.scene/scene-get-properties
 phzr.impl.accessors.scene/scene-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Scenes.SceneManager
 phzr.impl.accessors.scenes.scene-manager/scene-manager-get-properties
 phzr.impl.accessors.scenes.scene-manager/scene-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Scenes.ScenePlugin
 phzr.impl.accessors.scenes.scene-plugin/scene-plugin-get-properties
 phzr.impl.accessors.scenes.scene-plugin/scene-plugin-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Scenes.Systems
 phzr.impl.accessors.scenes.systems/systems-get-properties
 phzr.impl.accessors.scenes.systems/systems-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Sound.BaseSound
 phzr.impl.accessors.sound.base-sound/base-sound-get-properties
 phzr.impl.accessors.sound.base-sound/base-sound-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Sound.BaseSoundManager
 phzr.impl.accessors.sound.base-sound-manager/base-sound-manager-get-properties
 phzr.impl.accessors.sound.base-sound-manager/base-sound-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Sound.HTML5AudioSound
 phzr.impl.accessors.sound.html-5-audio-sound/html-5-audio-sound-get-properties
 phzr.impl.accessors.sound.html-5-audio-sound/html-5-audio-sound-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Sound.HTML5AudioSoundManager
 phzr.impl.accessors.sound.html-5-audio-sound-manager/html-5-audio-sound-manager-get-properties
 phzr.impl.accessors.sound.html-5-audio-sound-manager/html-5-audio-sound-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Sound.NoAudioSound
 phzr.impl.accessors.sound.no-audio-sound/no-audio-sound-get-properties
 phzr.impl.accessors.sound.no-audio-sound/no-audio-sound-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Sound.NoAudioSoundManager
 phzr.impl.accessors.sound.no-audio-sound-manager/no-audio-sound-manager-get-properties
 phzr.impl.accessors.sound.no-audio-sound-manager/no-audio-sound-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Sound.WebAudioSound
 phzr.impl.accessors.sound.web-audio-sound/web-audio-sound-get-properties
 phzr.impl.accessors.sound.web-audio-sound/web-audio-sound-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Sound.WebAudioSoundManager
 phzr.impl.accessors.sound.web-audio-sound-manager/web-audio-sound-manager-get-properties
 phzr.impl.accessors.sound.web-audio-sound-manager/web-audio-sound-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Structs.List
 phzr.impl.accessors.structs.list/list-get-properties
 phzr.impl.accessors.structs.list/list-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Structs.Map
 phzr.impl.accessors.structs.map/map-get-properties
 phzr.impl.accessors.structs.map/map-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Structs.ProcessQueue
 phzr.impl.accessors.structs.process-queue/process-queue-get-properties
 phzr.impl.accessors.structs.process-queue/process-queue-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Structs.RTree
 nil
 nil
 nil)

(ex/extend-phaser-class
 js/Phaser.Structs.Set
 phzr.impl.accessors.structs.set/set-get-properties
 phzr.impl.accessors.structs.set/set-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Structs.Size
 phzr.impl.accessors.structs.size/size-get-properties
 phzr.impl.accessors.structs.size/size-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Textures.CanvasTexture
 phzr.impl.accessors.textures.canvas-texture/canvas-texture-get-properties
 phzr.impl.accessors.textures.canvas-texture/canvas-texture-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Textures.Frame
 phzr.impl.accessors.textures.frame/frame-get-properties
 phzr.impl.accessors.textures.frame/frame-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Textures.Texture
 phzr.impl.accessors.textures.texture/texture-get-properties
 phzr.impl.accessors.textures.texture/texture-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Textures.TextureManager
 phzr.impl.accessors.textures.texture-manager/texture-manager-get-properties
 phzr.impl.accessors.textures.texture-manager/texture-manager-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Textures.TextureSource
 phzr.impl.accessors.textures.texture-source/texture-source-get-properties
 phzr.impl.accessors.textures.texture-source/texture-source-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.DynamicTilemapLayer
 phzr.impl.accessors.tilemaps.dynamic-tilemap-layer/dynamic-tilemap-layer-get-properties
 phzr.impl.accessors.tilemaps.dynamic-tilemap-layer/dynamic-tilemap-layer-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.ImageCollection
 phzr.impl.accessors.tilemaps.image-collection/image-collection-get-properties
 phzr.impl.accessors.tilemaps.image-collection/image-collection-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.LayerData
 phzr.impl.accessors.tilemaps.layer-data/layer-data-get-properties
 phzr.impl.accessors.tilemaps.layer-data/layer-data-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.MapData
 phzr.impl.accessors.tilemaps.map-data/map-data-get-properties
 phzr.impl.accessors.tilemaps.map-data/map-data-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.ObjectLayer
 phzr.impl.accessors.tilemaps.object-layer/object-layer-get-properties
 phzr.impl.accessors.tilemaps.object-layer/object-layer-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.StaticTilemapLayer
 phzr.impl.accessors.tilemaps.static-tilemap-layer/static-tilemap-layer-get-properties
 phzr.impl.accessors.tilemaps.static-tilemap-layer/static-tilemap-layer-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.Tile
 phzr.impl.accessors.tilemaps.tile/tile-get-properties
 phzr.impl.accessors.tilemaps.tile/tile-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.Tilemap
 phzr.impl.accessors.tilemaps.tilemap/tilemap-get-properties
 phzr.impl.accessors.tilemaps.tilemap/tilemap-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tilemaps.Tileset
 phzr.impl.accessors.tilemaps.tileset/tileset-get-properties
 phzr.impl.accessors.tilemaps.tileset/tileset-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Time.Clock
 phzr.impl.accessors.time.clock/clock-get-properties
 phzr.impl.accessors.time.clock/clock-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Time.TimerEvent
 phzr.impl.accessors.time.timer-event/timer-event-get-properties
 phzr.impl.accessors.time.timer-event/timer-event-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tweens.Timeline
 phzr.impl.accessors.tweens.timeline/timeline-get-properties
 phzr.impl.accessors.tweens.timeline/timeline-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tweens.Tween
 phzr.impl.accessors.tweens.tween/tween-get-properties
 phzr.impl.accessors.tweens.tween/tween-set-properties
 nil)

(ex/extend-phaser-class
 js/Phaser.Tweens.TweenManager
 phzr.impl.accessors.tweens.tween-manager/tween-manager-get-properties
 phzr.impl.accessors.tweens.tween-manager/tween-manager-set-properties
 nil)
