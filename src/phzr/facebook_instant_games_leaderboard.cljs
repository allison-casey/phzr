(ns phzr.facebook-instant-games-leaderboard
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->FacebookInstantGamesLeaderboard
  "  Parameters:
    * plugin (Phaser.FacebookInstantGamesPlugin) - A reference to the Facebook Instant Games Plugin.
    * data (any) - An Instant Game leaderboard instance."
  ([plugin data]
   (js/Phaser.FacebookInstantGamesLeaderboard. (clj->phaser plugin)
                                               (clj->phaser data))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-leaderboard event fn]
   (phaser->clj
    (.addListener facebook-instant-games-leaderboard
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([facebook-instant-games-leaderboard event fn context]
   (phaser->clj
    (.addListener facebook-instant-games-leaderboard
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn destroy
  "Removes all listeners."
  ([facebook-instant-games-leaderboard]
   (phaser->clj
    (.destroy facebook-instant-games-leaderboard))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([facebook-instant-games-leaderboard event]
   (phaser->clj
    (.emit facebook-instant-games-leaderboard
           (clj->phaser event))))
  ([facebook-instant-games-leaderboard event args]
   (phaser->clj
    (.emit facebook-instant-games-leaderboard
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([facebook-instant-games-leaderboard]
   (phaser->clj
    (.eventNames facebook-instant-games-leaderboard))))

(defn get-connected-scores
  "Retrieves a set of leaderboard entries, based on the current player's connected players (including the current player), ordered by local rank within the set of connected players.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes this Leaderboard will emit the `getconnectedscores` event along with an array of LeaderboardScore entries and the name of the Leaderboard.

  Returns:  this - This Leaderboard instance."
  ([facebook-instant-games-leaderboard]
   (phaser->clj
    (.getConnectedScores facebook-instant-games-leaderboard))))

(defn get-entry-count
  "Fetches the total number of player entries in the leaderboard.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes this Leaderboard will emit the `getentrycount` event along with the count and name of the Leaderboard.

  Returns:  this - This Leaderboard instance."
  ([facebook-instant-games-leaderboard]
   (phaser->clj
    (.getEntryCount facebook-instant-games-leaderboard))))

(defn get-player-score
  "Gets the players leaderboard entry and stores it in the `playerScore` property.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes this Leaderboard will emit the `getplayerscore` event along with the score and the name of the Leaderboard.

  If the player has not yet saved a score, the event will send `null` as the score value, and `playerScore` will be set to `null` as well.

  Returns:  this - This Leaderboard instance."
  ([facebook-instant-games-leaderboard]
   (phaser->clj
    (.getPlayerScore facebook-instant-games-leaderboard))))

(defn get-scores
  "Retrieves a set of leaderboard entries, ordered by score ranking in the leaderboard.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes this Leaderboard will emit the `getscores` event along with an array of LeaderboardScore entries and the name of the Leaderboard.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * count (integer) {optional} - The number of entries to attempt to fetch from the leaderboard. Currently, up to a maximum of 100 entries may be fetched per query.
    * offset (integer) {optional} - The offset from the top of the leaderboard that entries will be fetched from.

  Returns:  this - This Leaderboard instance."
  ([facebook-instant-games-leaderboard]
   (phaser->clj
    (.getScores facebook-instant-games-leaderboard)))
  ([facebook-instant-games-leaderboard count]
   (phaser->clj
    (.getScores facebook-instant-games-leaderboard
                (clj->phaser count))))
  ([facebook-instant-games-leaderboard count offset]
   (phaser->clj
    (.getScores facebook-instant-games-leaderboard
                (clj->phaser count)
                (clj->phaser offset)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([facebook-instant-games-leaderboard event]
   (phaser->clj
    (.listenerCount facebook-instant-games-leaderboard
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([facebook-instant-games-leaderboard event]
   (phaser->clj
    (.listeners facebook-instant-games-leaderboard
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-leaderboard event]
   (phaser->clj
    (.off facebook-instant-games-leaderboard
          (clj->phaser event))))
  ([facebook-instant-games-leaderboard event fn]
   (phaser->clj
    (.off facebook-instant-games-leaderboard
          (clj->phaser event)
          (clj->phaser fn))))
  ([facebook-instant-games-leaderboard event fn context]
   (phaser->clj
    (.off facebook-instant-games-leaderboard
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([facebook-instant-games-leaderboard event fn context once]
   (phaser->clj
    (.off facebook-instant-games-leaderboard
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-leaderboard event fn]
   (phaser->clj
    (.on facebook-instant-games-leaderboard
         (clj->phaser event)
         (clj->phaser fn))))
  ([facebook-instant-games-leaderboard event fn context]
   (phaser->clj
    (.on facebook-instant-games-leaderboard
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-leaderboard event fn]
   (phaser->clj
    (.once facebook-instant-games-leaderboard
           (clj->phaser event)
           (clj->phaser fn))))
  ([facebook-instant-games-leaderboard event fn context]
   (phaser->clj
    (.once facebook-instant-games-leaderboard
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-leaderboard]
   (phaser->clj
    (.removeAllListeners facebook-instant-games-leaderboard)))
  ([facebook-instant-games-leaderboard event]
   (phaser->clj
    (.removeAllListeners facebook-instant-games-leaderboard
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-leaderboard event]
   (phaser->clj
    (.removeListener facebook-instant-games-leaderboard
                     (clj->phaser event))))
  ([facebook-instant-games-leaderboard event fn]
   (phaser->clj
    (.removeListener facebook-instant-games-leaderboard
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([facebook-instant-games-leaderboard event fn context]
   (phaser->clj
    (.removeListener facebook-instant-games-leaderboard
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([facebook-instant-games-leaderboard event fn context once]
   (phaser->clj
    (.removeListener facebook-instant-games-leaderboard
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn set-score
  "Updates the player's score. If the player has an existing score, the old score will only be replaced if the new score is better than it.
  NOTE: If the leaderboard is associated with a specific context, the game must be in that context to set a score for the player.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes this Leaderboard will emit the `setscore` event along with the LeaderboardScore object and the name of the Leaderboard.

  If the save fails the event will send `null` as the score value.

  Parameters:
    * facebook-instant-games-leaderboard (Phaser.FacebookInstantGamesLeaderboard) - Targeted instance for method
    * score (integer) - The new score for the player. Must be a 64-bit integer number.
    * data (string | any) {optional} - Metadata to associate with the stored score. Must be less than 2KB in size. If an object is given it will be passed to `JSON.stringify`.

  Returns:  this - This Leaderboard instance."
  ([facebook-instant-games-leaderboard score]
   (phaser->clj
    (.setScore facebook-instant-games-leaderboard
               (clj->phaser score))))
  ([facebook-instant-games-leaderboard score data]
   (phaser->clj
    (.setScore facebook-instant-games-leaderboard
               (clj->phaser score)
               (clj->phaser data)))))

(defn shutdown
  "Removes all listeners."
  ([facebook-instant-games-leaderboard]
   (phaser->clj
    (.shutdown facebook-instant-games-leaderboard))))