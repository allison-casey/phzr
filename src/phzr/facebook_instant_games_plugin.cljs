(ns phzr.facebook-instant-games-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->FacebookInstantGamesPlugin
  "  Parameters:
    * game (Phaser.Game) - A reference to the Phaser.Game instance."
  ([game]
   (js/Phaser.FacebookInstantGamesPlugin. (clj->phaser game))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-plugin event fn]
   (phaser->clj
    (.addListener facebook-instant-games-plugin
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([facebook-instant-games-plugin event fn context]
   (phaser->clj
    (.addListener facebook-instant-games-plugin
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn can-subscribe-bot
  "Checks if the current player can subscribe to the game bot.

  It makes an async call to the API, so the result isn't available immediately.

  If they can subscribe, the `playerCanSubscribeBot` property is set to `true`
  and this plugin will emit the `cansubscribebot` event.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `cansubscribebotfail` event instead.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.canSubscribeBot facebook-instant-games-plugin))))

(defn check-api
  "Checks to see if a given Facebook Instant Games API is available or not.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * api (string) - The API to check for, i.e. `player.getID`.

  Returns:  boolean - `true` if the API is supported, otherwise `false`."
  ([facebook-instant-games-plugin api]
   (phaser->clj
    (.checkAPI facebook-instant-games-plugin
               (clj->phaser api)))))

(defn choose-context
  "Opens a context selection dialog for the player. If the player selects an available context,
  the client will attempt to switch into that context, and emit the `choose` event if successful.
  Otherwise, if the player exits the menu or the client fails to switch into the new context, the `choosefail` event will be emitted.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * options (ChooseContextConfig) {optional} - An object specifying conditions on the contexts that should be offered.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.chooseContext facebook-instant-games-plugin)))
  ([facebook-instant-games-plugin options]
   (phaser->clj
    (.chooseContext facebook-instant-games-plugin
                    (clj->phaser options)))))

(defn consume-purchase
  "Consumes a specific purchase belonging to the current player. Before provisioning a product's effects to the player,
  the game should request the consumption of the purchased product. Once the purchase is successfully consumed,
  the game should immediately provide the player with the effects of their purchase.

  It makes an async call to the API, so the result isn't available immediately.

  If they are successfully subscribed this plugin will emit the `consumepurchase` event along
  with the purchase data.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `consumepurchasefail` event instead.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * purchase-token (string) - The purchase token of the purchase that should be consumed.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin purchase-token]
   (phaser->clj
    (.consumePurchase facebook-instant-games-plugin
                      (clj->phaser purchase-token)))))

(defn create-context
  "Attempts to create or switch into a context between a specified player and the current player.
  This plugin will emit the `create` event once the context switch is completed.
  If the API call fails, such as if the player listed is not a Connected Player of the current player or if the
  player does not provide permission to enter the new context, then the plugin will emit a 'createfail' event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * player-id (string) - ID of the player.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin player-id]
   (phaser->clj
    (.createContext facebook-instant-games-plugin
                    (clj->phaser player-id)))))

(defn create-shortcut
  "Prompts the user to create a shortcut to the game if they are eligible to.
  Can only be called once per session.

  It makes an async call to the API, so the result isn't available immediately.

  If the user choose to create a shortcut this plugin will emit the `shortcutcreated` event.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `shortcutcreatedfail` event instead.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.createShortcut facebook-instant-games-plugin))))

(defn destroy
  "Quits the Facebook API and then destroys this plugin."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.destroy facebook-instant-games-plugin))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([facebook-instant-games-plugin event]
   (phaser->clj
    (.emit facebook-instant-games-plugin
           (clj->phaser event))))
  ([facebook-instant-games-plugin event args]
   (phaser->clj
    (.emit facebook-instant-games-plugin
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.eventNames facebook-instant-games-plugin))))

(defn flush-data
  "Immediately flushes any changes to the player data to the designated cloud storage.
  This function is expensive, and should primarily be used for critical changes where persistence needs to be immediate
  and known by the game. Non-critical changes should rely on the platform to persist them in the background.
  NOTE: Calls to player.setDataAsync will be rejected while this function's result is pending.

  Data managed via this plugins Data Manager instance is automatically synced with Facebook. However, you can call this
  method directly if you need to flush the data directly.

  When the APIs `flushDataAsync` call resolves it will emit the `flushdata` event from this plugin. If the call fails for some
  reason it will emit `flushdatafail` instead.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.flushData facebook-instant-games-plugin))))

(defn game-started
  "This method is called automatically when the game has finished loading,
  if you used the `showLoadProgress` method. If your game doesn't need to
  load any assets, or you're managing the load yourself, then call this
  method directly to start the API running.

  When the API has finished starting this plugin will emit a `startgame` event
  which you should listen for."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.gameStarted facebook-instant-games-plugin))))

(defn get-catalog
  "Fetches the game's product catalog.

  It makes an async call to the API, so the result isn't available immediately.

  If they are successfully subscribed this plugin will emit the `getcatalog` event along
  with the catalog data.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `getcatalogfail` event instead.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getCatalog facebook-instant-games-plugin))))

(defn get-data
  "Gets the associated data from the player based on the given key, or array of keys.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes the data is set into this plugins Data Manager and the
  `getdata` event will be emitted.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * keys (string | Array.<string>) - The key/s of the data to retrieve.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin keys]
   (phaser->clj
    (.getData facebook-instant-games-plugin
              (clj->phaser keys)))))

(defn get-id
  "Returns the unique identifier for the current game context. This represents a specific context
  that the game is being played in (for example, a particular messenger conversation or facebook post).
  The identifier will be null if game is being played in a solo context.

  It is only populated if `contextGetID` is in the list of supported APIs.

  Returns:  string - The context ID."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getID facebook-instant-games-plugin))))

(defn get-leaderboard
  "Fetch a specific leaderboard belonging to this Instant Game.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes the `getleaderboard` event will be emitted along with a Leaderboard object instance.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * name (string) - The name of the leaderboard. Each leaderboard for an Instant Game must have its own distinct name.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin name]
   (phaser->clj
    (.getLeaderboard facebook-instant-games-plugin
                     (clj->phaser name)))))

(defn get-locale
  "Returns the current locale.
  See https://origincache.facebook.com/developers/resources/?id=FacebookLocales.xml for a complete list of supported locale values.
  Use this to determine what languages the current game should be localized with.
  It is only populated if `getLocale` is in the list of supported APIs.

  Returns:  string - The current locale."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getLocale facebook-instant-games-plugin))))

(defn get-platform
  "Returns the platform on which the game is currently running, i.e. `IOS`.
  It is only populated if `getPlatform` is in the list of supported APIs.

  Returns:  string - The current platform."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getPlatform facebook-instant-games-plugin))))

(defn get-player-id
  "Returns the id of the player. This is a string based ID, the same as `FBInstant.player.getID()`.
  It is only populated if `playerGetID` is in the list of supported APIs.

  Returns:  string - The player ID."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getPlayerID facebook-instant-games-plugin))))

(defn get-player-name
  "Returns the player's localized display name.
  It is only populated if `playerGetName` is in the list of supported APIs.

  Returns:  string - The player's localized display name."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getPlayerName facebook-instant-games-plugin))))

(defn get-player-photo-url
  "Returns the url to the player's public profile photo. The photo will always be a square, and with dimensions
  of at least 200x200. When rendering it in the game, the exact dimensions should never be assumed to be constant.
  It's recommended to always scale the image to a desired size before rendering.
  It is only populated if `playerGetPhoto` is in the list of supported APIs.

  Returns:  string - The player's photo url."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getPlayerPhotoURL facebook-instant-games-plugin))))

(defn get-players
  "Fetches an array of ConnectedPlayer objects containing information about active players
  (people who played the game in the last 90 days) that are connected to the current player.

  It makes an async call to the API, so the result isn't available immediately.

  If they are successfully subscribed this plugin will emit the `players` event along
  with the player data.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `playersfail` event instead.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getPlayers facebook-instant-games-plugin))))

(defn get-product
  "Fetches a single Product from the game's product catalog.

  The product catalog must have been populated using `getCatalog` prior to calling this method.

  Use this to look-up product details based on a purchase list.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * product-id (string) - The Product ID of the item to get from the catalog.

  Returns:  Product - The Product from the catalog, or `null` if it couldn't be found or the catalog isn't populated."
  ([facebook-instant-games-plugin product-id]
   (phaser->clj
    (.getProduct facebook-instant-games-plugin
                 (clj->phaser product-id)))))

(defn get-purchases
  "Fetches all of the player's unconsumed purchases. The game must fetch the current player's purchases
  as soon as the client indicates that it is ready to perform payments-related operations,
  i.e. at game start. The game can then process and consume any purchases that are waiting to be consumed.

  It makes an async call to the API, so the result isn't available immediately.

  If they are successfully subscribed this plugin will emit the `getpurchases` event along
  with the purchase data.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `getpurchasesfail` event instead.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getPurchases facebook-instant-games-plugin))))

(defn get-sdk-version
  "Returns the string representation of the Facebook Instant Games SDK version being used.
  It is only populated if `getSDKVersion` is in the list of supported APIs.

  Returns:  string - The sdk version."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getSDKVersion facebook-instant-games-plugin))))

(defn get-stats
  "Retrieve stats from the designated cloud storage of the current player.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes the `getstats` event will be emitted along with the data object returned.

  If the call fails, i.e. it's not in the list of supported APIs, or the request was rejected,
  it will emit a `getstatsfail` event instead.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * keys (Array.<string>) {optional} - An optional array of unique keys to retrieve stats for. If the function is called without it, it will fetch all stats.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getStats facebook-instant-games-plugin)))
  ([facebook-instant-games-plugin keys]
   (phaser->clj
    (.getStats facebook-instant-games-plugin
               (clj->phaser keys)))))

(defn get-type
  "Returns the current context in which your game is running. This can be either `null` or one of:

  `POST` - The game is running inside of a Facebook post.
  `THREAD` - The game is running inside a Facebook Messenger thread.
  `GROUP` - The game is running inside a Facebook Group.
  `SOLO` - This is the default context, the player is the only participant.

  It is only populated if `contextGetType` is in the list of supported APIs.

  Returns:  string - The context type."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.getType facebook-instant-games-plugin))))

(defn inc-stats
  "Increment the stats of the current player and save them to the designated cloud storage.

  Stats in the Facebook Instant Games API are purely numerical values paired with a string-based key. Only numbers can be saved as stats,
  all other data types will be ignored.

  The data object provided for this call should contain offsets for how much to modify the stats by:

  ```javascript
  this.facebook.incStats({
      level: 1,
      zombiesSlain: 17,
      rank: -1
  });
  ```

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes the `incstats` event will be emitted along with the data object returned.

  If the call fails, i.e. it's not in the list of supported APIs, or the request was rejected,
  it will emit a `incstatsfail` event instead.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * data (object) - An object containing a set of key-value pairs indicating how much to increment each stat in cloud storage. Note that only numerical values are processed.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin data]
   (phaser->clj
    (.incStats facebook-instant-games-plugin
               (clj->phaser data)))))

(defn is-size-between
  "This function determines whether the number of participants in the current game context is between a given minimum and maximum, inclusive.
  If one of the bounds is null only the other bound will be checked against.
  It will always return the original result for the first call made in a context in a given game play session.
  Subsequent calls, regardless of arguments, will return the answer to the original query until a context change occurs and the query result is reset.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * min (integer) {optional} - The minimum bound of the context size query.
    * max (integer) {optional} - The maximum bound of the context size query.

  Returns:  object - The Context Size Response object in the format: `{answer: boolean, minSize: number?, maxSize: number?}`."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.isSizeBetween facebook-instant-games-plugin)))
  ([facebook-instant-games-plugin min]
   (phaser->clj
    (.isSizeBetween facebook-instant-games-plugin
                    (clj->phaser min))))
  ([facebook-instant-games-plugin min max]
   (phaser->clj
    (.isSizeBetween facebook-instant-games-plugin
                    (clj->phaser min)
                    (clj->phaser max)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([facebook-instant-games-plugin event]
   (phaser->clj
    (.listenerCount facebook-instant-games-plugin
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([facebook-instant-games-plugin event]
   (phaser->clj
    (.listeners facebook-instant-games-plugin
                (clj->phaser event)))))

(defn load-player-photo
  "Load the player's photo and store it in the Texture Manager, ready for use in-game.

  This method works by using a Scene Loader instance and then asking the Loader to
  retrieve the image.

  When complete the plugin will emit a `photocomplete` event, along with the key of the photo.

  ```javascript
  this.facebook.loadPlayerPhoto(this, 'player').once('photocomplete', function (key) {
    this.add.image(x, y, 'player');
  }, this);
  ```

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene that will be responsible for loading this photo.
    * key (string) - The key to use when storing the photo in the Texture Manager.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin scene key]
   (phaser->clj
    (.loadPlayerPhoto facebook-instant-games-plugin
                      (clj->phaser scene)
                      (clj->phaser key)))))

(defn log
  "Log an app event with FB Analytics.

  See https://developers.facebook.com/docs/javascript/reference/v2.8#app_events for more details about FB Analytics.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * name (string) - Name of the event. Must be 2 to 40 characters, and can only contain '_', '-', ' ', and alphanumeric characters.
    * value (number) {optional} - An optional numeric value that FB Analytics can calculate a sum with.
    * params (object) {optional} - An optional object that can contain up to 25 key-value pairs to be logged with the event. Keys must be 2 to 40 characters, and can only contain '_', '-', ' ', and alphanumeric characters. Values must be less than 100 characters in length.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin name]
   (phaser->clj
    (.log facebook-instant-games-plugin
          (clj->phaser name))))
  ([facebook-instant-games-plugin name value]
   (phaser->clj
    (.log facebook-instant-games-plugin
          (clj->phaser name)
          (clj->phaser value))))
  ([facebook-instant-games-plugin name value params]
   (phaser->clj
    (.log facebook-instant-games-plugin
          (clj->phaser name)
          (clj->phaser value)
          (clj->phaser params)))))

(defn match-player
  "Attempts to match the current player with other users looking for people to play with.
  If successful, a new Messenger group thread will be created containing the matched players and the player will
  be context switched to that thread. This plugin will also dispatch the `matchplayer` event, containing the new context ID and Type.

  The default minimum and maximum number of players in one matched thread are 2 and 20 respectively,
  depending on how many players are trying to get matched around the same time.

  The values can be changed in `fbapp-config.json`. See the Bundle Config documentation for documentation about `fbapp-config.json`.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * match-tag (string) {optional} - Optional extra information about the player used to group them with similar players. Players will only be grouped with other players with exactly the same tag. The tag must only include letters, numbers, and underscores and be 100 characters or less in length.
    * switch-immediately (boolean) {optional} - Optional extra parameter that specifies whether the player should be immediately switched to the new context when a match is found. By default this will be false which will mean the player needs explicitly press play after being matched to switch to the new context.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.matchPlayer facebook-instant-games-plugin)))
  ([facebook-instant-games-plugin match-tag]
   (phaser->clj
    (.matchPlayer facebook-instant-games-plugin
                  (clj->phaser match-tag))))
  ([facebook-instant-games-plugin match-tag switch-immediately]
   (phaser->clj
    (.matchPlayer facebook-instant-games-plugin
                  (clj->phaser match-tag)
                  (clj->phaser switch-immediately)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-plugin event]
   (phaser->clj
    (.off facebook-instant-games-plugin
          (clj->phaser event))))
  ([facebook-instant-games-plugin event fn]
   (phaser->clj
    (.off facebook-instant-games-plugin
          (clj->phaser event)
          (clj->phaser fn))))
  ([facebook-instant-games-plugin event fn context]
   (phaser->clj
    (.off facebook-instant-games-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([facebook-instant-games-plugin event fn context once]
   (phaser->clj
    (.off facebook-instant-games-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-plugin event fn]
   (phaser->clj
    (.on facebook-instant-games-plugin
         (clj->phaser event)
         (clj->phaser fn))))
  ([facebook-instant-games-plugin event fn context]
   (phaser->clj
    (.on facebook-instant-games-plugin
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-plugin event fn]
   (phaser->clj
    (.once facebook-instant-games-plugin
           (clj->phaser event)
           (clj->phaser fn))))
  ([facebook-instant-games-plugin event fn context]
   (phaser->clj
    (.once facebook-instant-games-plugin
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn open-challenge
  "This invokes a dialog to let the user share specified content, either as a message in Messenger or as a post on the user's timeline.

  A blob of data can be attached to the share which every game session launched from the share will be able to access via the `this.entryPointData` property.

  This data must be less than or equal to 1000 characters when stringified.

  When this method is called you should consider your game paused. Listen out for the `resume` event from this plugin to know when the dialog has been closed.

  The user may choose to cancel the share action and close the dialog. The resulting `resume` event will be dispatched regardless if the user actually shared the content or not.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * text (string) - A text message to be shared.
    * key (string) - The key of the texture to use as the share image.
    * frame (string) {optional} - The frame of the texture to use as the share image. Set to `null` if you don't require a frame, but do need to set session data.
    * session-data (object) {optional} - A blob of data to attach to the share.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin text key]
   (phaser->clj
    (.openChallenge facebook-instant-games-plugin
                    (clj->phaser text)
                    (clj->phaser key))))
  ([facebook-instant-games-plugin text key frame]
   (phaser->clj
    (.openChallenge facebook-instant-games-plugin
                    (clj->phaser text)
                    (clj->phaser key)
                    (clj->phaser frame))))
  ([facebook-instant-games-plugin text key frame session-data]
   (phaser->clj
    (.openChallenge facebook-instant-games-plugin
                    (clj->phaser text)
                    (clj->phaser key)
                    (clj->phaser frame)
                    (clj->phaser session-data)))))

(defn open-invite
  "This invokes a dialog to let the user invite a friend to play this game, either as a message in Messenger or as a post on the user's timeline.

  A blob of data can be attached to the share which every game session launched from the share will be able to access via the `this.entryPointData` property.

  This data must be less than or equal to 1000 characters when stringified.

  When this method is called you should consider your game paused. Listen out for the `resume` event from this plugin to know when the dialog has been closed.

  The user may choose to cancel the share action and close the dialog. The resulting `resume` event will be dispatched regardless if the user actually shared the content or not.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * text (string) - A text message to be shared.
    * key (string) - The key of the texture to use as the share image.
    * frame (string) {optional} - The frame of the texture to use as the share image. Set to `null` if you don't require a frame, but do need to set session data.
    * session-data (object) {optional} - A blob of data to attach to the share.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin text key]
   (phaser->clj
    (.openInvite facebook-instant-games-plugin
                 (clj->phaser text)
                 (clj->phaser key))))
  ([facebook-instant-games-plugin text key frame]
   (phaser->clj
    (.openInvite facebook-instant-games-plugin
                 (clj->phaser text)
                 (clj->phaser key)
                 (clj->phaser frame))))
  ([facebook-instant-games-plugin text key frame session-data]
   (phaser->clj
    (.openInvite facebook-instant-games-plugin
                 (clj->phaser text)
                 (clj->phaser key)
                 (clj->phaser frame)
                 (clj->phaser session-data)))))

(defn open-request
  "This invokes a dialog to let the user share specified content, either as a message in Messenger or as a post on the user's timeline.

  A blob of data can be attached to the share which every game session launched from the share will be able to access via the `this.entryPointData` property.

  This data must be less than or equal to 1000 characters when stringified.

  When this method is called you should consider your game paused. Listen out for the `resume` event from this plugin to know when the dialog has been closed.

  The user may choose to cancel the share action and close the dialog. The resulting `resume` event will be dispatched regardless if the user actually shared the content or not.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * text (string) - A text message to be shared.
    * key (string) - The key of the texture to use as the share image.
    * frame (string) {optional} - The frame of the texture to use as the share image. Set to `null` if you don't require a frame, but do need to set session data.
    * session-data (object) {optional} - A blob of data to attach to the share.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin text key]
   (phaser->clj
    (.openRequest facebook-instant-games-plugin
                  (clj->phaser text)
                  (clj->phaser key))))
  ([facebook-instant-games-plugin text key frame]
   (phaser->clj
    (.openRequest facebook-instant-games-plugin
                  (clj->phaser text)
                  (clj->phaser key)
                  (clj->phaser frame))))
  ([facebook-instant-games-plugin text key frame session-data]
   (phaser->clj
    (.openRequest facebook-instant-games-plugin
                  (clj->phaser text)
                  (clj->phaser key)
                  (clj->phaser frame)
                  (clj->phaser session-data)))))

(defn open-share
  "This invokes a dialog to let the user share specified content, either as a message in Messenger or as a post on the user's timeline.

  A blob of data can be attached to the share which every game session launched from the share will be able to access via the `this.entryPointData` property.

  This data must be less than or equal to 1000 characters when stringified.

  When this method is called you should consider your game paused. Listen out for the `resume` event from this plugin to know when the dialog has been closed.

  The user may choose to cancel the share action and close the dialog. The resulting `resume` event will be dispatched regardless if the user actually shared the content or not.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * text (string) - A text message to be shared.
    * key (string) - The key of the texture to use as the share image.
    * frame (string) {optional} - The frame of the texture to use as the share image. Set to `null` if you don't require a frame, but do need to set session data.
    * session-data (object) {optional} - A blob of data to attach to the share.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin text key]
   (phaser->clj
    (.openShare facebook-instant-games-plugin
                (clj->phaser text)
                (clj->phaser key))))
  ([facebook-instant-games-plugin text key frame]
   (phaser->clj
    (.openShare facebook-instant-games-plugin
                (clj->phaser text)
                (clj->phaser key)
                (clj->phaser frame))))
  ([facebook-instant-games-plugin text key frame session-data]
   (phaser->clj
    (.openShare facebook-instant-games-plugin
                (clj->phaser text)
                (clj->phaser key)
                (clj->phaser frame)
                (clj->phaser session-data)))))

(defn preload-ads
  "Attempt to create an instance of an interstitial ad.

  If the instance is created successfully then the ad is preloaded ready for display in-game via the method `showAd()`.

  If the ad loads it will emit the `adloaded` event, passing the AdInstance as the only parameter.

  If the ad cannot be displayed because there was no inventory to fill it, it will emit the `adsnofill` event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * placement-id (string | Array.<string>) - The ad placement ID, or an array of IDs, as created in your Audience Network settings within Facebook.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin placement-id]
   (phaser->clj
    (.preloadAds facebook-instant-games-plugin
                 (clj->phaser placement-id)))))

(defn preload-video-ads
  "Attempt to create an instance of an rewarded video ad.

  If the instance is created successfully then the ad is preloaded ready for display in-game via the method `showVideo()`.

  If the ad loads it will emit the `adloaded` event, passing the AdInstance as the only parameter.

  If the ad cannot be displayed because there was no inventory to fill it, it will emit the `adsnofill` event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * placement-id (string | Array.<string>) - The ad placement ID, or an array of IDs, as created in your Audience Network settings within Facebook.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin placement-id]
   (phaser->clj
    (.preloadVideoAds facebook-instant-games-plugin
                      (clj->phaser placement-id)))))

(defn purchase
  "Begins the purchase flow for a specific product.

  It makes an async call to the API, so the result isn't available immediately.

  If they are successfully subscribed this plugin will emit the `purchase` event along
  with the purchase data.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `purchasefail` event instead.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * product-id (string) - The identifier of the product to purchase.
    * developer-payload (string) {optional} - An optional developer-specified payload, to be included in the returned purchase's signed request.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin product-id]
   (phaser->clj
    (.purchase facebook-instant-games-plugin
               (clj->phaser product-id))))
  ([facebook-instant-games-plugin product-id developer-payload]
   (phaser->clj
    (.purchase facebook-instant-games-plugin
               (clj->phaser product-id)
               (clj->phaser developer-payload)))))

(defn quit
  "Quits the game."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.quit facebook-instant-games-plugin))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.removeAllListeners facebook-instant-games-plugin)))
  ([facebook-instant-games-plugin event]
   (phaser->clj
    (.removeAllListeners facebook-instant-games-plugin
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([facebook-instant-games-plugin event]
   (phaser->clj
    (.removeListener facebook-instant-games-plugin
                     (clj->phaser event))))
  ([facebook-instant-games-plugin event fn]
   (phaser->clj
    (.removeListener facebook-instant-games-plugin
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([facebook-instant-games-plugin event fn context]
   (phaser->clj
    (.removeListener facebook-instant-games-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([facebook-instant-games-plugin event fn context once]
   (phaser->clj
    (.removeListener facebook-instant-games-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn save-data
  "Set data to be saved to the designated cloud storage of the current player. The game can store up to 1MB of data for each unique player.

  The data save is requested in an async call, so the result isn't available immediately.

  Data managed via this plugins Data Manager instance is automatically synced with Facebook. However, you can call this
  method directly if you need to replace the data object directly.

  When the APIs `setDataAsync` call resolves it will emit the `savedata` event from this plugin. If the call fails for some
  reason it will emit `savedatafail` instead.

  The call resolving does not necessarily mean that the input has already been persisted. Rather, it means that the data was valid and
  has been scheduled to be saved. It also guarantees that all values that were set are now available in `getData`.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * data (object) - An object containing a set of key-value pairs that should be persisted to cloud storage.
The object must contain only serializable values - any non-serializable values will cause the entire modification to be rejected.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin data]
   (phaser->clj
    (.saveData facebook-instant-games-plugin
               (clj->phaser data)))))

(defn save-session
  "Sets the data associated with the individual gameplay session for the current context.

  This function should be called whenever the game would like to update the current session data.

  This session data may be used to populate a variety of payloads, such as game play webhooks.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * data (object) - An arbitrary data object, which must be less than or equal to 1000 characters when stringified.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin data]
   (phaser->clj
    (.saveSession facebook-instant-games-plugin
                  (clj->phaser data)))))

(defn save-stats
  "Save the stats of the current player to the designated cloud storage.

  Stats in the Facebook Instant Games API are purely numerical values paired with a string-based key. Only numbers can be saved as stats,
  all other data types will be ignored.

  The data is requested in an async call, so the result isn't available immediately.

  When the call completes the `savestats` event will be emitted along with the data object returned.

  If the call fails, i.e. it's not in the list of supported APIs, or the request was rejected,
  it will emit a `savestatsfail` event instead.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * data (object) - An object containing a set of key-value pairs that should be persisted to cloud storage as stats. Note that only numerical values are stored.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin data]
   (phaser->clj
    (.saveStats facebook-instant-games-plugin
                (clj->phaser data)))))

(defn show-ad
  "Displays a previously loaded interstitial ad.

  If the ad is successfully displayed this plugin will emit the `adfinished` event, with the AdInstance object as its parameter.

  If the ad cannot be displayed, it will emit the `adsnotloaded` event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * placement-id (string) - The ad placement ID to display.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin placement-id]
   (phaser->clj
    (.showAd facebook-instant-games-plugin
             (clj->phaser placement-id)))))

(defn show-load-progress
  "Call this method from your `Scene.preload` in order to sync the load progress
  of the Phaser Loader with the Facebook Instant Games loader display, i.e.:

  ```javascript
  this.facebook.showLoadProgress(this);
  this.facebook.once('startgame', this.startGame, this);
  ```

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * scene (Phaser.Scene) - The Scene for which you want to show loader progress for.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin scene]
   (phaser->clj
    (.showLoadProgress facebook-instant-games-plugin
                       (clj->phaser scene)))))

(defn show-video
  "Displays a previously loaded interstitial video ad.

  If the ad is successfully displayed this plugin will emit the `adfinished` event, with the AdInstance object as its parameter.

  If the ad cannot be displayed, it will emit the `adsnotloaded` event.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * placement-id (string) - The ad placement ID to display.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin placement-id]
   (phaser->clj
    (.showVideo facebook-instant-games-plugin
                (clj->phaser placement-id)))))

(defn shutdown
  "Removes all listeners."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.shutdown facebook-instant-games-plugin))))

(defn subscribe-bot
  "Subscribes the current player to the game bot.

  It makes an async call to the API, so the result isn't available immediately.

  If they are successfully subscribed this plugin will emit the `subscribebot` event.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `subscribebotfail` event instead.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin]
   (phaser->clj
    (.subscribeBot facebook-instant-games-plugin))))

(defn switch-context
  "Request a switch into a specific context. If the player does not have permission to enter that context,
  or if the player does not provide permission for the game to enter that context, this will emit a `switchfail` event.

  Otherwise, the plugin will emit the `switch` event when the game has switched into the specified context.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * context-id (string) - The ID of the desired context.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin context-id]
   (phaser->clj
    (.switchContext facebook-instant-games-plugin
                    (clj->phaser context-id)))))

(defn switch-game
  "Request that the client switch to a different Instant Game.

  It makes an async call to the API, so the result isn't available immediately.

  If the game switches successfully this plugin will emit the `switchgame` event and the client will load the new game.

  If they cannot, i.e. it's not in the list of supported APIs, or the request
  was rejected, it will emit a `switchgamefail` event instead.

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * app-id (string) - The Application ID of the Instant Game to switch to. The application must be an Instant Game, and must belong to the same business as the current game.
    * data (object) {optional} - An optional data payload. This will be set as the entrypoint data for the game being switched to. Must be less than or equal to 1000 characters when stringified.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin app-id]
   (phaser->clj
    (.switchGame facebook-instant-games-plugin
                 (clj->phaser app-id))))
  ([facebook-instant-games-plugin app-id data]
   (phaser->clj
    (.switchGame facebook-instant-games-plugin
                 (clj->phaser app-id)
                 (clj->phaser data)))))

(defn update
  "Informs Facebook of a custom update that occurred in the game.
  This will temporarily yield control to Facebook and Facebook will decide what to do based on what the update is.
  Once Facebook returns control to the game the plugin will emit an `update` or `upatefail` event.

  It makes an async call to the API, so the result isn't available immediately.

  The `text` parameter is an update payload with the following structure:

  ```
  text: {
      default: 'X just invaded Y\\'s village!',
      localizations: {
          ar_AR: 'X \\u0641\\u0642\\u0637 \\u063A\\u0632\\u062A ' +
          '\\u0642\\u0631\\u064A\\u0629 Y!',
          en_US: 'X just invaded Y\\'s village!',
          es_LA: '\\u00A1X acaba de invadir el pueblo de Y!',
      }
  }
  ```

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * cta (string) - The call to action text.
    * text (object) - The text object.
    * key (string) - The key of the texture to use as the share image.
    * frame (string | integer) - The frame of the texture to use as the share image. Set to `null` if you don't require a frame, but do need to set session data.
    * template (string) - The update template key.
    * update-data (object) - The update data object payload.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin cta text key frame template update-data]
   (phaser->clj
    (.update facebook-instant-games-plugin
             (clj->phaser cta)
             (clj->phaser text)
             (clj->phaser key)
             (clj->phaser frame)
             (clj->phaser template)
             (clj->phaser update-data)))))

(defn update-leaderboard
  "Informs Facebook of a leaderboard update that occurred in the game.
  This will temporarily yield control to Facebook and Facebook will decide what to do based on what the update is.
  Once Facebook returns control to the game the plugin will emit an `update` or `upatefail` event.

  It makes an async call to the API, so the result isn't available immediately.

  The `text` parameter is an update payload with the following structure:

  ```
  text: {
      default: 'X just invaded Y\\'s village!',
      localizations: {
          ar_AR: 'X \\u0641\\u0642\\u0637 \\u063A\\u0632\\u062A ' +
          '\\u0642\\u0631\\u064A\\u0629 Y!',
          en_US: 'X just invaded Y\\'s village!',
          es_LA: '\\u00A1X acaba de invadir el pueblo de Y!',
      }
  }
  ```

  Parameters:
    * facebook-instant-games-plugin (Phaser.FacebookInstantGamesPlugin) - Targeted instance for method
    * cta (string) - The call to action text.
    * text (object) - The text object.
    * key (string) - The key of the texture to use as the share image.
    * frame (string | integer) - The frame of the texture to use as the share image. Set to `null` if you don't require a frame, but do need to set session data.
    * template (string) - The update template key.
    * update-data (object) - The update data object payload.

  Returns:  this - This Facebook Instant Games Plugin instance."
  ([facebook-instant-games-plugin cta text key frame template update-data]
   (phaser->clj
    (.updateLeaderboard facebook-instant-games-plugin
                        (clj->phaser cta)
                        (clj->phaser text)
                        (clj->phaser key)
                        (clj->phaser frame)
                        (clj->phaser template)
                        (clj->phaser update-data)))))