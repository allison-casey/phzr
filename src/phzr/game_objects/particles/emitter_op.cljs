(ns phzr.game-objects.particles.emitter-op
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->EmitterOp
  "  Parameters:
    * config (Phaser.Types.GameObjects.Particles.ParticleEmitterConfig) - Settings for the Particle Emitter that owns this property.
    * key (string) - The name of the property.
    * default-value (number) - The default value of the property.
    * emit-only (boolean) {optional} - Whether the property can only be modified when a Particle is emitted."
  ([config key default-value]
   (js/Phaser.GameObjects.Particles.EmitterOp. (clj->phaser config)
                                               (clj->phaser key)
                                               (clj->phaser default-value)))
  ([config key default-value emit-only]
   (js/Phaser.GameObjects.Particles.EmitterOp. (clj->phaser config)
                                               (clj->phaser key)
                                               (clj->phaser default-value)
                                               (clj->phaser emit-only))))

(defn default-emit
  "The returned value sets what the property will be at the START of the particles life, on emit.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The particle.
    * key (string) - The name of the property.
    * value (number) {optional} - The current value of the property.

  Returns:  number - The new value of the property."
  ([emitter-op particle key]
   (phaser->clj
    (.defaultEmit emitter-op
                  (clj->phaser particle)
                  (clj->phaser key))))
  ([emitter-op particle key value]
   (phaser->clj
    (.defaultEmit emitter-op
                  (clj->phaser particle)
                  (clj->phaser key)
                  (clj->phaser value)))))

(defn default-update
  "The returned value updates the property for the duration of the particles life.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The particle.
    * key (string) - The name of the property.
    * t (number) - The T value (between 0 and 1)
    * value (number) - The current value of the property.

  Returns:  number - The new value of the property."
  ([emitter-op particle key t value]
   (phaser->clj
    (.defaultUpdate emitter-op
                    (clj->phaser particle)
                    (clj->phaser key)
                    (clj->phaser t)
                    (clj->phaser value)))))

(defn ease-value-update
  "An `onUpdate` callback that returns an eased value between the
  {@link Phaser.GameObjects.Particles.EmitterOp#start} and {@link Phaser.GameObjects.Particles.EmitterOp#end}
  range.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The particle.
    * key (string) - The name of the property.
    * t (number) - The T value (between 0 and 1)

  Returns:  number - The new value of the property."
  ([emitter-op particle key t]
   (phaser->clj
    (.easeValueUpdate emitter-op
                      (clj->phaser particle)
                      (clj->phaser key)
                      (clj->phaser t)))))

(defn eased-value-emit
  "An `onEmit` callback for an eased property.

  It prepares the particle for easing by {@link Phaser.GameObjects.Particles.EmitterOp#easeValueUpdate}.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The particle.
    * key (string) - The name of the property.

  Returns:  number - {@link Phaser.GameObjects.Particles.EmitterOp#start}, as the new value of the property."
  ([emitter-op particle key]
   (phaser->clj
    (.easedValueEmit emitter-op
                     (clj->phaser particle)
                     (clj->phaser key)))))

(defn has
  "Check whether an object has the given property.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * object (object) - The object to check.
    * key (string) - The key of the property to look for in the object.

  Returns:  boolean - `true` if the property exists in the object, `false` otherwise."
  ([emitter-op object key]
   (phaser->clj
    (.has emitter-op
          (clj->phaser object)
          (clj->phaser key)))))

(defn has-both
  "Check whether an object has both of the given properties.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * object (object) - The object to check.
    * key-1 (string) - The key of the first property to check the object for.
    * key-2 (string) - The key of the second property to check the object for.

  Returns:  boolean - `true` if both properties exist in the object, `false` otherwise."
  ([emitter-op object key-1 key-2]
   (phaser->clj
    (.hasBoth emitter-op
              (clj->phaser object)
              (clj->phaser key-1)
              (clj->phaser key-2)))))

(defn has-either
  "Check whether an object has at least one of the given properties.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * object (object) - The object to check.
    * key-1 (string) - The key of the first property to check the object for.
    * key-2 (string) - The key of the second property to check the object for.

  Returns:  boolean - `true` if at least one of the properties exists in the object, `false` if neither exist."
  ([emitter-op object key-1 key-2]
   (phaser->clj
    (.hasEither emitter-op
                (clj->phaser object)
                (clj->phaser key-1)
                (clj->phaser key-2)))))

(defn load-config
  "Load the property from a Particle Emitter configuration object.

  Optionally accepts a new property key to use, replacing the current one.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * config (Phaser.Types.GameObjects.Particles.ParticleEmitterConfig) {optional} - Settings for the Particle Emitter that owns this property.
    * new-key (string) {optional} - The new key to use for this property, if any."
  ([emitter-op]
   (phaser->clj
    (.loadConfig emitter-op)))
  ([emitter-op config]
   (phaser->clj
    (.loadConfig emitter-op
                 (clj->phaser config))))
  ([emitter-op config new-key]
   (phaser->clj
    (.loadConfig emitter-op
                 (clj->phaser config)
                 (clj->phaser new-key)))))

(defn on-change
  "Change the current value of the property and update its callback methods.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * value (number) - The value of the property.

  Returns:  Phaser.GameObjects.Particles.EmitterOp - This Emitter Op object."
  ([emitter-op value]
   (phaser->clj
    (.onChange emitter-op
               (clj->phaser value)))))

(defn random-ranged-value-emit
  "An `onEmit` callback that returns a value between the {@link Phaser.GameObjects.Particles.EmitterOp#start} and
  {@link Phaser.GameObjects.Particles.EmitterOp#end} range.

  Parameters:
    * emitter-op (Phaser.GameObjects.Particles.EmitterOp) - Targeted instance for method
    * particle (Phaser.GameObjects.Particles.Particle) - The particle.
    * key (string) - The key of the property.

  Returns:  number - The new value of the property."
  ([emitter-op particle key]
   (phaser->clj
    (.randomRangedValueEmit emitter-op
                            (clj->phaser particle)
                            (clj->phaser key)))))

(defn random-static-value-emit
  "An `onEmit` callback that returns a random value from the current value array.

  Returns:  number - The new value of the property."
  ([emitter-op]
   (phaser->clj
    (.randomStaticValueEmit emitter-op))))

(defn set-methods
  "Update the {@link Phaser.GameObjects.Particles.EmitterOp#onEmit} and
  {@link Phaser.GameObjects.Particles.EmitterOp#onUpdate} callbacks based on the type of the current
  {@link Phaser.GameObjects.Particles.EmitterOp#propertyValue}.

  Returns:  Phaser.GameObjects.Particles.EmitterOp - This Emitter Op object."
  ([emitter-op]
   (phaser->clj
    (.setMethods emitter-op))))

(defn static-value-emit
  "An `onEmit` callback that returns the current value of the property.

  Returns:  number - The current value of the property."
  ([emitter-op]
   (phaser->clj
    (.staticValueEmit emitter-op))))

(defn static-value-update
  "An `onUpdate` callback that returns the current value of the property.

  Returns:  number - The current value of the property."
  ([emitter-op]
   (phaser->clj
    (.staticValueUpdate emitter-op))))

(defn stepped-emit
  "An `onEmit` callback that returns a stepped value between the
  {@link Phaser.GameObjects.Particles.EmitterOp#start} and {@link Phaser.GameObjects.Particles.EmitterOp#end}
  range.

  Returns:  number - The new value of the property."
  ([emitter-op]
   (phaser->clj
    (.steppedEmit emitter-op))))

(defn to-json
  "Build a JSON representation of this Particle Emitter property.

  Returns:  object - A JSON representation of this Particle Emitter property."
  ([emitter-op]
   (phaser->clj
    (.toJSON emitter-op))))