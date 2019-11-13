(ns phzr.game-objects.particles.particle-emitter
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->ParticleEmitter
  "  Parameters:
    * manager (Phaser.GameObjects.Particles.ParticleEmitterManager) - The Emitter Manager this Emitter belongs to.
    * config (Phaser.Types.GameObjects.Particles.ParticleEmitterConfig) - Settings for this emitter."
  ([manager config]
   (js/Phaser.GameObjects.Particles.ParticleEmitter. (clj->phaser manager)
                                                     (clj->phaser config))))

(defn at-limit
  "Whether this emitter is at its limit (if set).

  Returns:  boolean - Returns `true` if this Emitter is at its limit, or `false` if no limit, or below the `maxParticles` level."
  ([particle-emitter]
   (phaser->clj
    (.atLimit particle-emitter))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([particle-emitter]
   (phaser->clj
    (.clearMask particle-emitter)))
  ([particle-emitter destroy-mask]
   (phaser->clj
    (.clearMask particle-emitter
                (clj->phaser destroy-mask)))))

(defn create-bitmap-mask
  "Creates and returns a Bitmap Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a renderable Game Object.
  A renderable Game Object is one that uses a texture to render with, such as an
  Image, Sprite, Render Texture or BitmapText.

  If you do not provide a renderable object, and this Game Object has a texture,
  it will use itself as the object. This means you can call this method to create
  a Bitmap Mask from any renderable Game Object.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([particle-emitter]
   (phaser->clj
    (.createBitmapMask particle-emitter)))
  ([particle-emitter renderable]
   (phaser->clj
    (.createBitmapMask particle-emitter
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([particle-emitter]
   (phaser->clj
    (.createGeometryMask particle-emitter)))
  ([particle-emitter graphics]
   (phaser->clj
    (.createGeometryMask particle-emitter
                         (clj->phaser graphics)))))

(defn depth-sort
  "Sorts active particles with {@link Phaser.GameObjects.Particles.ParticleEmitter#depthSortCallback}.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.depthSort particle-emitter))))

(defn depth-sort-callback
  "Calculates the difference of two particles, for sorting them by depth.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * a (object) - The first particle.
    * b (object) - The second particle.

  Returns:  integer - The difference of a and b's y coordinates."
  ([particle-emitter a b]
   (phaser->clj
    (.depthSortCallback particle-emitter
                        (clj->phaser a)
                        (clj->phaser b)))))

(defn emit-particle
  "Emits particles at a given position (or the emitter's current position).

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * count (integer) {optional} - The number of Particles to emit.
    * x (number) {optional} - The x coordinate to emit the Particles from.
    * y (number) {optional} - The y coordinate to emit the Particles from.

  Returns:  Phaser.GameObjects.Particles.Particle - The most recently emitted Particle."
  ([particle-emitter]
   (phaser->clj
    (.emitParticle particle-emitter)))
  ([particle-emitter count]
   (phaser->clj
    (.emitParticle particle-emitter
                   (clj->phaser count))))
  ([particle-emitter count x]
   (phaser->clj
    (.emitParticle particle-emitter
                   (clj->phaser count)
                   (clj->phaser x))))
  ([particle-emitter count x y]
   (phaser->clj
    (.emitParticle particle-emitter
                   (clj->phaser count)
                   (clj->phaser x)
                   (clj->phaser y)))))

(defn emit-particle-at
  "Emits particles at a given position (or the emitter's current position).

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * x (number) {optional} - The x coordinate to emit the Particles from.
    * y (number) {optional} - The y coordinate to emit the Particles from.
    * count (integer) {optional} - The number of Particles to emit.

  Returns:  Phaser.GameObjects.Particles.Particle - The most recently emitted Particle."
  ([particle-emitter]
   (phaser->clj
    (.emitParticleAt particle-emitter)))
  ([particle-emitter x]
   (phaser->clj
    (.emitParticleAt particle-emitter
                     (clj->phaser x))))
  ([particle-emitter x y]
   (phaser->clj
    (.emitParticleAt particle-emitter
                     (clj->phaser x)
                     (clj->phaser y))))
  ([particle-emitter x y count]
   (phaser->clj
    (.emitParticleAt particle-emitter
                     (clj->phaser x)
                     (clj->phaser y)
                     (clj->phaser count)))))

(defn explode
  "Puts the emitter in explode mode (frequency = -1), stopping any current particle flow, and emits several particles all at once.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * count (integer) - The amount of Particles to emit.
    * x (number) - The x coordinate to emit the Particles from.
    * y (number) - The y coordinate to emit the Particles from.

  Returns:  Phaser.GameObjects.Particles.Particle - The most recently emitted Particle."
  ([particle-emitter count x y]
   (phaser->clj
    (.explode particle-emitter
              (clj->phaser count)
              (clj->phaser x)
              (clj->phaser y)))))

(defn flow
  "Puts the emitter in flow mode (frequency >= 0) and starts (or restarts) a particle flow.

  To resume a flow at the current frequency and quantity, use {@link Phaser.GameObjects.Particles.ParticleEmitter#start} instead.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * frequency (number) - The time interval (>= 0) of each flow cycle, in ms.
    * count (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) {optional} - The number of particles to emit at each flow cycle.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter frequency]
   (phaser->clj
    (.flow particle-emitter
           (clj->phaser frequency))))
  ([particle-emitter frequency count]
   (phaser->clj
    (.flow particle-emitter
           (clj->phaser frequency)
           (clj->phaser count)))))

(defn for-each-alive
  "Calls a function for each active particle in this emitter.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * callback (Phaser.Types.GameObjects.Particles.ParticleEmitterCallback) - The function.
    * context (*) - The function's calling context.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter callback context]
   (phaser->clj
    (.forEachAlive particle-emitter
                   (clj->phaser callback)
                   (clj->phaser context)))))

(defn for-each-dead
  "Calls a function for each inactive particle in this emitter.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * callback (Phaser.Types.GameObjects.Particles.ParticleEmitterCallback) - The function.
    * context (*) - The function's calling context.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter callback context]
   (phaser->clj
    (.forEachDead particle-emitter
                  (clj->phaser callback)
                  (clj->phaser context)))))

(defn from-json
  "Merges configuration settings into the emitter's current settings.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * config (Phaser.Types.GameObjects.Particles.ParticleEmitterConfig) - Settings for this emitter.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter config]
   (phaser->clj
    (.fromJSON particle-emitter
               (clj->phaser config)))))

(defn get-alive-particle-count
  "Gets the number of active (in-use) particles in this emitter.

  Returns:  integer - The number of particles with `active=true`."
  ([particle-emitter]
   (phaser->clj
    (.getAliveParticleCount particle-emitter))))

(defn get-dead-particle-count
  "Gets the number of inactive (available) particles in this emitter.

  Returns:  integer - The number of particles with `active=false`."
  ([particle-emitter]
   (phaser->clj
    (.getDeadParticleCount particle-emitter))))

(defn get-frame
  "Chooses a texture frame from {@link Phaser.GameObjects.Particles.ParticleEmitter#frames}.

  Returns:  Phaser.Textures.Frame - The texture frame."
  ([particle-emitter]
   (phaser->clj
    (.getFrame particle-emitter))))

(defn get-particle-count
  "Gets the total number of particles in this emitter.

  Returns:  integer - The number of particles, including both alive and dead."
  ([particle-emitter]
   (phaser->clj
    (.getParticleCount particle-emitter))))

(defn kill-all
  "Deactivates every particle in this emitter.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.killAll particle-emitter))))

(defn on-particle-death
  "Sets a function to call for each particle death.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * callback (Phaser.Types.GameObjects.Particles.ParticleDeathCallback) - The function.
    * context (*) {optional} - The function's calling context.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter callback]
   (phaser->clj
    (.onParticleDeath particle-emitter
                      (clj->phaser callback))))
  ([particle-emitter callback context]
   (phaser->clj
    (.onParticleDeath particle-emitter
                      (clj->phaser callback)
                      (clj->phaser context)))))

(defn on-particle-emit
  "Sets a function to call for each newly emitted particle.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * callback (Phaser.Types.GameObjects.Particles.ParticleEmitterCallback) - The function.
    * context (*) {optional} - The calling context.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter callback]
   (phaser->clj
    (.onParticleEmit particle-emitter
                     (clj->phaser callback))))
  ([particle-emitter callback context]
   (phaser->clj
    (.onParticleEmit particle-emitter
                     (clj->phaser callback)
                     (clj->phaser context)))))

(defn pause
  "{@link Phaser.GameObjects.Particles.ParticleEmitter#active Deactivates} the emitter.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.pause particle-emitter))))

(defn pre-update
  "Updates this emitter and its particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * time (integer) - The current timestamp as generated by the Request Animation Frame or SetTimeout.
    * delta (number) - The delta time, in ms, elapsed since the last frame."
  ([particle-emitter time delta]
   (phaser->clj
    (.preUpdate particle-emitter
                (clj->phaser time)
                (clj->phaser delta)))))

(defn reserve
  "Creates inactive particles and adds them to this emitter's pool.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * particle-count (integer) - The number of particles to create.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter particle-count]
   (phaser->clj
    (.reserve particle-emitter
              (clj->phaser particle-count)))))

(defn resume
  "{@link Phaser.GameObjects.Particles.ParticleEmitter#active Activates} the emitter.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.resume particle-emitter))))

(defn set-alpha
  "Sets the opacity of emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType | Phaser.Types.GameObjects.Particles.EmitterOpOnUpdateType) - A value between 0 (transparent) and 1 (opaque).

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setAlpha particle-emitter
               (clj->phaser value)))))

(defn set-angle
  "Sets the angle of a {@link Phaser.GameObjects.Particles.ParticleEmitter#radial} particle stream.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The angle of the initial velocity of emitted particles.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setAngle particle-emitter
               (clj->phaser value)))))

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
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([particle-emitter value]
   (phaser->clj
    (.setBlendMode particle-emitter
                   (clj->phaser value)))))

(defn set-bounds
  "Sets or modifies a rectangular boundary constraining the particles.

  To remove the boundary, set {@link Phaser.GameObjects.Particles.ParticleEmitter#bounds} to null.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * x (number | Phaser.Types.GameObjects.Particles.ParticleEmitterBounds | Phaser.Types.GameObjects.Particles.ParticleEmitterBoundsAlt) - The x-coordinate of the left edge of the boundary, or an object representing a rectangle.
    * y (number) - The y-coordinate of the top edge of the boundary.
    * width (number) - The width of the boundary.
    * height (number) - The height of the boundary.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter x y width height]
   (phaser->clj
    (.setBounds particle-emitter
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)))))

(defn set-death-zone
  "Sets or removes the {@link Phaser.GameObjects.Particles.ParticleEmitter#deathZone}.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * zone-config (Phaser.Types.GameObjects.Particles.ParticleEmitterDeathZoneConfig) {optional} - An object describing the zone, or `undefined` to remove any current death zone.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.setDeathZone particle-emitter)))
  ([particle-emitter zone-config]
   (phaser->clj
    (.setDeathZone particle-emitter
                   (clj->phaser zone-config)))))

(defn set-emit-zone
  "Sets or removes the {@link Phaser.GameObjects.Particles.ParticleEmitter#emitZone}.

  An {@link Phaser.Types.GameObjects.Particles.ParticleEmitterEdgeZoneConfig EdgeZone} places particles on its edges. Its {@link Phaser.Types.GameObjects.Particles.EdgeZoneSource source} can be a Curve, Path, Circle, Ellipse, Line, Polygon, Rectangle, or Triangle; or any object with a suitable {@link Phaser.Types.GameObjects.Particles.EdgeZoneSourceCallback getPoints} method.

  A {@link Phaser.Types.GameObjects.Particles.ParticleEmitterRandomZoneConfig RandomZone} places randomly within its interior. Its {@link RandomZoneSource source} can be a Circle, Ellipse, Line, Polygon, Rectangle, or Triangle; or any object with a suitable {@link Phaser.Types.GameObjects.Particles.RandomZoneSourceCallback getRandomPoint} method.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * zone-config (Phaser.Types.GameObjects.Particles.ParticleEmitterEdgeZoneConfig | Phaser.Types.GameObjects.Particles.ParticleEmitterRandomZoneConfig) {optional} - An object describing the zone, or `undefined` to remove any current emit zone.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.setEmitZone particle-emitter)))
  ([particle-emitter zone-config]
   (phaser->clj
    (.setEmitZone particle-emitter
                  (clj->phaser zone-config)))))

(defn set-emitter-angle
  "Sets the angle of a {@link Phaser.GameObjects.Particles.ParticleEmitter#radial} particle stream.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The angle of the initial velocity of emitted particles.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setEmitterAngle particle-emitter
                      (clj->phaser value)))))

(defn set-frame
  "Sets a pattern for assigning texture frames to emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * frames (array | string | integer | Phaser.Types.GameObjects.Particles.ParticleEmitterFrameConfig) - One or more texture frames, or a configuration object.
    * pick-random (boolean) {optional} - Whether frames should be assigned at random from `frames`.
    * quantity (integer) {optional} - The number of consecutive particles that will receive each frame.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter frames]
   (phaser->clj
    (.setFrame particle-emitter
               (clj->phaser frames))))
  ([particle-emitter frames pick-random]
   (phaser->clj
    (.setFrame particle-emitter
               (clj->phaser frames)
               (clj->phaser pick-random))))
  ([particle-emitter frames pick-random quantity]
   (phaser->clj
    (.setFrame particle-emitter
               (clj->phaser frames)
               (clj->phaser pick-random)
               (clj->phaser quantity)))))

(defn set-frequency
  "Sets the emitter's {@link Phaser.GameObjects.Particles.ParticleEmitter#frequency}
  and {@link Phaser.GameObjects.Particles.ParticleEmitter#quantity}.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * frequency (number) - The time interval (>= 0) of each flow cycle, in ms; or -1 to put the emitter in explosion mode.
    * quantity (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) {optional} - The number of particles to release at each flow cycle or explosion.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter frequency]
   (phaser->clj
    (.setFrequency particle-emitter
                   (clj->phaser frequency))))
  ([particle-emitter frequency quantity]
   (phaser->clj
    (.setFrequency particle-emitter
                   (clj->phaser frequency)
                   (clj->phaser quantity)))))

(defn set-gravity
  "Sets the gravity applied to emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * x (number) - Horizontal acceleration due to gravity, in pixels per second squared.
    * y (number) - Vertical acceleration due to gravity, in pixels per second squared.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter x y]
   (phaser->clj
    (.setGravity particle-emitter
                 (clj->phaser x)
                 (clj->phaser y)))))

(defn set-gravity-x
  "Sets the horizontal gravity applied to emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (number) - Acceleration due to gravity, in pixels per second squared.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setGravityX particle-emitter
                  (clj->phaser value)))))

(defn set-gravity-y
  "Sets the vertical gravity applied to emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (number) - Acceleration due to gravity, in pixels per second squared.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setGravityY particle-emitter
                  (clj->phaser value)))))

(defn set-lifespan
  "Sets the lifespan of newly emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The particle lifespan, in ms.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setLifespan particle-emitter
                  (clj->phaser value)))))

(defn set-mask
  "Sets the mask that this Game Object will use to render with.

  The mask must have been previously created and can be either a GeometryMask or a BitmapMask.
  Note: Bitmap Masks only work on WebGL. Geometry Masks work on both WebGL and Canvas.

  If a mask is already set on this Game Object it will be immediately replaced.

  Masks are positioned in global space and are not relative to the Game Object to which they
  are applied. The reason for this is that multiple Game Objects can all share the same mask.

  Masks have no impact on physics or input detection. They are purely a rendering component
  that allows you to limit what is visible during the render pass.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([particle-emitter mask]
   (phaser->clj
    (.setMask particle-emitter
              (clj->phaser mask)))))

(defn set-position
  "Sets the position of the emitter's particle origin.
  New particles will be emitted here.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * x (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The x-coordinate of the particle origin.
    * y (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The y-coordinate of the particle origin.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter x y]
   (phaser->clj
    (.setPosition particle-emitter
                  (clj->phaser x)
                  (clj->phaser y)))))

(defn set-quantity
  "Sets the number of particles released at each flow cycle or explosion.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * quantity (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The number of particles to release at each flow cycle or explosion.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter quantity]
   (phaser->clj
    (.setQuantity particle-emitter
                  (clj->phaser quantity)))))

(defn set-radial
  "Turns {@link Phaser.GameObjects.Particles.ParticleEmitter#radial} particle movement on or off.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (boolean) {optional} - Radial mode (true) or point mode (true).

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.setRadial particle-emitter)))
  ([particle-emitter value]
   (phaser->clj
    (.setRadial particle-emitter
                (clj->phaser value)))))

(defn set-scale
  "Sets the scale of emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType | Phaser.Types.GameObjects.Particles.EmitterOpOnUpdateType) - The scale, relative to 1.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setScale particle-emitter
               (clj->phaser value)))))

(defn set-scale-x
  "Sets the horizontal scale of emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType | Phaser.Types.GameObjects.Particles.EmitterOpOnUpdateType) - The scale, relative to 1.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setScaleX particle-emitter
                (clj->phaser value)))))

(defn set-scale-y
  "Sets the vertical scale of emitted particles.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType | Phaser.Types.GameObjects.Particles.EmitterOpOnUpdateType) - The scale, relative to 1.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setScaleY particle-emitter
                (clj->phaser value)))))

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
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([particle-emitter x]
   (phaser->clj
    (.setScrollFactor particle-emitter
                      (clj->phaser x))))
  ([particle-emitter x y]
   (phaser->clj
    (.setScrollFactor particle-emitter
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-speed
  "Sets the initial radial speed of emitted particles.
  Changes the emitter to radial mode.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The speed, in pixels per second.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setSpeed particle-emitter
               (clj->phaser value)))))

(defn set-speed-x
  "Sets the initial horizontal speed of emitted particles.
  Changes the emitter to point mode.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The speed, in pixels per second.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setSpeedX particle-emitter
                (clj->phaser value)))))

(defn set-speed-y
  "Sets the initial vertical speed of emitted particles.
  Changes the emitter to point mode.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (Phaser.Types.GameObjects.Particles.EmitterOpOnEmitType) - The speed, in pixels per second.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter value]
   (phaser->clj
    (.setSpeedY particle-emitter
                (clj->phaser value)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([particle-emitter value]
   (phaser->clj
    (.setVisible particle-emitter
                 (clj->phaser value)))))

(defn start
  "Turns {@link Phaser.GameObjects.Particles.ParticleEmitter#on} the emitter and resets the flow counter.

  If this emitter is in flow mode (frequency >= 0; the default), the particle flow will start (or restart).

  If this emitter is in explode mode (frequency = -1), nothing will happen.
  Use {@link Phaser.GameObjects.Particles.ParticleEmitter#explode} or {@link Phaser.GameObjects.Particles.ParticleEmitter#flow} instead.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.start particle-emitter))))

(defn start-follow
  "Continuously moves the particle origin to follow a Game Object's position.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * target (Phaser.GameObjects.GameObject) - The Game Object to follow.
    * offset-x (number) {optional} - Horizontal offset of the particle origin from the Game Object.
    * offset-y (number) {optional} - Vertical offset of the particle origin from the Game Object.
    * track-visible (boolean) {optional} - Whether the emitter's visible state will track the target's visible state.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter target]
   (phaser->clj
    (.startFollow particle-emitter
                  (clj->phaser target))))
  ([particle-emitter target offset-x]
   (phaser->clj
    (.startFollow particle-emitter
                  (clj->phaser target)
                  (clj->phaser offset-x))))
  ([particle-emitter target offset-x offset-y]
   (phaser->clj
    (.startFollow particle-emitter
                  (clj->phaser target)
                  (clj->phaser offset-x)
                  (clj->phaser offset-y))))
  ([particle-emitter target offset-x offset-y track-visible]
   (phaser->clj
    (.startFollow particle-emitter
                  (clj->phaser target)
                  (clj->phaser offset-x)
                  (clj->phaser offset-y)
                  (clj->phaser track-visible)))))

(defn stop
  "Turns {@link Phaser.GameObjects.Particles.ParticleEmitter#on off} the emitter.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.stop particle-emitter))))

(defn stop-follow
  "Stops following a Game Object.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitter - This Particle Emitter."
  ([particle-emitter]
   (phaser->clj
    (.stopFollow particle-emitter))))

(defn to-json
  "Creates a description of this emitter suitable for JSON serialization.

  Parameters:
    * particle-emitter (Phaser.GameObjects.Particles.ParticleEmitter) - Targeted instance for method
    * output (object) {optional} - An object to copy output into.

  Returns:  object - - The output object."
  ([particle-emitter]
   (phaser->clj
    (.toJSON particle-emitter)))
  ([particle-emitter output]
   (phaser->clj
    (.toJSON particle-emitter
             (clj->phaser output)))))