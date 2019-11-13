(ns phzr.math.random-data-generator
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [uuid shuffle]))

(defn ->RandomDataGenerator
  "  Parameters:
    * seeds (string | Array.<string>) {optional} - The seeds to use for the random number generator."
  ([]
   (js/Phaser.Math.RandomDataGenerator.))
  ([seeds]
   (js/Phaser.Math.RandomDataGenerator. (clj->phaser seeds))))

(defn angle
  "Returns a random angle between -180 and 180.

  Returns:  number - A random number between -180 and 180."
  ([random-data-generator]
   (phaser->clj
    (.angle random-data-generator))))

(defn between
  "Returns a random integer between and including min and max.
  This method is an alias for RandomDataGenerator.integerInRange.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * min (number) - The minimum value in the range.
    * max (number) - The maximum value in the range.

  Returns:  number - A random number between min and max."
  ([random-data-generator min max]
   (phaser->clj
    (.between random-data-generator
              (clj->phaser min)
              (clj->phaser max)))))

(defn frac
  "Returns a random real number between 0 and 1.

  Returns:  number - A random real number between 0 and 1."
  ([random-data-generator]
   (phaser->clj
    (.frac random-data-generator))))

(defn init
  "Initialize the state of the random data generator.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * seeds (string | Array.<string>) - The seeds to initialize the random data generator with."
  ([random-data-generator seeds]
   (phaser->clj
    (.init random-data-generator
           (clj->phaser seeds)))))

(defn integer
  "Returns a random integer between 0 and 2^32.

  Returns:  number - A random integer between 0 and 2^32."
  ([random-data-generator]
   (phaser->clj
    (.integer random-data-generator))))

(defn integer-in-range
  "Returns a random integer between and including min and max.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * min (number) - The minimum value in the range.
    * max (number) - The maximum value in the range.

  Returns:  number - A random number between min and max."
  ([random-data-generator min max]
   (phaser->clj
    (.integerInRange random-data-generator
                     (clj->phaser min)
                     (clj->phaser max)))))

(defn normal
  "Returns a random real number between -1 and 1.

  Returns:  number - A random real number between -1 and 1."
  ([random-data-generator]
   (phaser->clj
    (.normal random-data-generator))))

(defn pick
  "Returns a random element from within the given array.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * array (array) - The array to pick a random element from.

  Returns:  * - A random member of the array."
  ([random-data-generator array]
   (phaser->clj
    (.pick random-data-generator
           (clj->phaser array)))))

(defn real
  "Returns a random real number between 0 and 2^32.

  Returns:  number - A random real number between 0 and 2^32."
  ([random-data-generator]
   (phaser->clj
    (.real random-data-generator))))

(defn real-in-range
  "Returns a random real number between min and max.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * min (number) - The minimum value in the range.
    * max (number) - The maximum value in the range.

  Returns:  number - A random number between min and max."
  ([random-data-generator min max]
   (phaser->clj
    (.realInRange random-data-generator
                  (clj->phaser min)
                  (clj->phaser max)))))

(defn rotation
  "Returns a random rotation in radians, between -3.141 and 3.141

  Returns:  number - A random number between -3.141 and 3.141"
  ([random-data-generator]
   (phaser->clj
    (.rotation random-data-generator))))

(defn shuffle
  "Shuffles the given array, using the current seed.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * array (array) {optional} - The array to be shuffled.

  Returns:  array - The shuffled array."
  ([random-data-generator]
   (phaser->clj
    (.shuffle random-data-generator)))
  ([random-data-generator array]
   (phaser->clj
    (.shuffle random-data-generator
              (clj->phaser array)))))

(defn sign
  "Returns a sign to be used with multiplication operator.

  Returns:  number - -1 or +1."
  ([random-data-generator]
   (phaser->clj
    (.sign random-data-generator))))

(defn sow
  "Reset the seed of the random data generator.

  _Note_: the seed array is only processed up to the first `undefined` (or `null`) value, should such be present.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * seeds (Array.<string>) - The array of seeds: the `toString()` of each value is used."
  ([random-data-generator seeds]
   (phaser->clj
    (.sow random-data-generator
          (clj->phaser seeds)))))

(defn state
  "Gets or Sets the state of the generator. This allows you to retain the values
  that the generator is using between games, i.e. in a game save file.

  To seed this generator with a previously saved state you can pass it as the
  `seed` value in your game config, or call this method directly after Phaser has booted.

  Call this method with no parameters to return the current state.

  If providing a state it should match the same format that this method
  returns, which is a string with a header `!rnd` followed by the `c`,
  `s0`, `s1` and `s2` values respectively, each comma-delimited.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * state (string) {optional} - Generator state to be set.

  Returns:  string - The current state of the generator."
  ([random-data-generator]
   (phaser->clj
    (.state random-data-generator)))
  ([random-data-generator state]
   (phaser->clj
    (.state random-data-generator
            (clj->phaser state)))))

(defn timestamp
  "Returns a random timestamp between min and max, or between the beginning of 2000 and the end of 2020 if min and max aren't specified.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * min (number) - The minimum value in the range.
    * max (number) - The maximum value in the range.

  Returns:  number - A random timestamp between min and max."
  ([random-data-generator min max]
   (phaser->clj
    (.timestamp random-data-generator
                (clj->phaser min)
                (clj->phaser max)))))

(defn uuid
  "Returns a valid RFC4122 version4 ID hex string from https://gist.github.com/1308368

  Returns:  string - A valid RFC4122 version4 ID hex string"
  ([random-data-generator]
   (phaser->clj
    (.uuid random-data-generator))))

(defn weighted-pick
  "Returns a random element from within the given array, favoring the earlier entries.

  Parameters:
    * random-data-generator (Phaser.Math.RandomDataGenerator) - Targeted instance for method
    * array (array) - The array to pick a random element from.

  Returns:  * - A random member of the array."
  ([random-data-generator array]
   (phaser->clj
    (.weightedPick random-data-generator
                   (clj->phaser array)))))