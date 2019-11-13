(ns phzr.plugins.plugin-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [get]))

(defn ->PluginManager
  "  Parameters:
    * game (Phaser.Game) - The game instance that owns this Plugin Manager."
  ([game]
   (js/Phaser.Plugins.PluginManager. (clj->phaser game))))

(defn destroy
  "Destroys this Plugin Manager and all associated plugins.
  It will iterate all plugins found and call their `destroy` methods.

  The PluginCache will remove all custom plugins."
  ([plugin-manager]
   (phaser->clj
    (.destroy plugin-manager))))

(defn get
  "Gets a global plugin from the Plugin Manager based on the given key and returns it.

  If it cannot find an active plugin based on the key, but there is one in the Plugin Cache with the same key,
  then it will create a new instance of the cached plugin and return that.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the plugin to get.
    * auto-start (boolean) {optional} - Automatically start a new instance of the plugin if found in the cache, but not actively running.

  Returns:  Phaser.Plugins.BasePlugin | function - The plugin, or `null` if no plugin was found matching the key."
  ([plugin-manager key]
   (phaser->clj
    (.get plugin-manager
          (clj->phaser key))))
  ([plugin-manager key auto-start]
   (phaser->clj
    (.get plugin-manager
          (clj->phaser key)
          (clj->phaser auto-start)))))

(defn get-class
  "Returns the plugin class from the cache.
  Used internally by the Plugin Manager.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the plugin to get.

  Returns:  Phaser.Plugins.BasePlugin - A Plugin object"
  ([plugin-manager key]
   (phaser->clj
    (.getClass plugin-manager
               (clj->phaser key)))))

(defn install
  "Installs a new Global Plugin into the Plugin Manager and optionally starts it running.
  A global plugin belongs to the Plugin Manager, rather than a specific Scene, and can be accessed
  and used by all Scenes in your game.

  The `key` property is what you use to access this plugin from the Plugin Manager.

  ```javascript
  this.plugins.install('powerupsPlugin', pluginCode);

  // and from within the scene:
  this.plugins.get('powerupsPlugin');
  ```

  This method is called automatically by Phaser if you install your plugins using either the
  Game Configuration object, or by preloading them via the Loader.

  The same plugin can be installed multiple times into the Plugin Manager by simply giving each
  instance its own unique key.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The unique handle given to this plugin within the Plugin Manager.
    * plugin (function) - The plugin code. This should be the non-instantiated version.
    * start (boolean) {optional} - Automatically start the plugin running? This is always `true` if you provide a mapping value.
    * mapping (string) {optional} - If this plugin is injected into the Phaser.Scene class, this is the property key to use.
    * data (any) {optional} - A value passed to the plugin's `init` method.

  Returns:  Phaser.Plugins.BasePlugin - The plugin that was started, or `null` if `start` was false, or game isn't yet booted."
  ([plugin-manager key plugin]
   (phaser->clj
    (.install plugin-manager
              (clj->phaser key)
              (clj->phaser plugin))))
  ([plugin-manager key plugin start]
   (phaser->clj
    (.install plugin-manager
              (clj->phaser key)
              (clj->phaser plugin)
              (clj->phaser start))))
  ([plugin-manager key plugin start mapping]
   (phaser->clj
    (.install plugin-manager
              (clj->phaser key)
              (clj->phaser plugin)
              (clj->phaser start)
              (clj->phaser mapping))))
  ([plugin-manager key plugin start mapping data]
   (phaser->clj
    (.install plugin-manager
              (clj->phaser key)
              (clj->phaser plugin)
              (clj->phaser start)
              (clj->phaser mapping)
              (clj->phaser data)))))

(defn install-scene-plugin
  "Installs a new Scene Plugin into the Plugin Manager and optionally adds it
  to the given Scene as well. A Scene Plugin added to the manager in this way
  will be automatically installed into all new Scenes using the key and mapping given.

  The `key` property is what the plugin is injected into Scene.Systems as.
  The `mapping` property is optional, and if specified is what the plugin is installed into
  the Scene as. For example:

  ```javascript
  this.plugins.installScenePlugin('powerupsPlugin', pluginCode, 'powerups');

  // and from within the scene:
  this.sys.powerupsPlugin; // key value
  this.powerups; // mapping value
  ```

  This method is called automatically by Phaser if you install your plugins using either the
  Game Configuration object, or by preloading them via the Loader.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The property key that will be used to add this plugin to Scene.Systems.
    * plugin (function) - The plugin code. This should be the non-instantiated version.
    * mapping (string) {optional} - If this plugin is injected into the Phaser.Scene class, this is the property key to use.
    * add-to-scene (Phaser.Scene) {optional} - Optionally automatically add this plugin to the given Scene.
    * from-loader (boolean) {optional} - Is this being called by the Loader?"
  ([plugin-manager key plugin]
   (phaser->clj
    (.installScenePlugin plugin-manager
                         (clj->phaser key)
                         (clj->phaser plugin))))
  ([plugin-manager key plugin mapping]
   (phaser->clj
    (.installScenePlugin plugin-manager
                         (clj->phaser key)
                         (clj->phaser plugin)
                         (clj->phaser mapping))))
  ([plugin-manager key plugin mapping add-to-scene]
   (phaser->clj
    (.installScenePlugin plugin-manager
                         (clj->phaser key)
                         (clj->phaser plugin)
                         (clj->phaser mapping)
                         (clj->phaser add-to-scene))))
  ([plugin-manager key plugin mapping add-to-scene from-loader]
   (phaser->clj
    (.installScenePlugin plugin-manager
                         (clj->phaser key)
                         (clj->phaser plugin)
                         (clj->phaser mapping)
                         (clj->phaser add-to-scene)
                         (clj->phaser from-loader)))))

(defn is-active
  "Checks if the given global plugin, based on its key, is active or not.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The unique plugin key.

  Returns:  boolean - `true` if the plugin is active, otherwise `false`."
  ([plugin-manager key]
   (phaser->clj
    (.isActive plugin-manager
               (clj->phaser key)))))

(defn register-file-type
  "Registers a new file type with the global File Types Manager, making it available to all Loader
  Plugins created after this.

  This is usually called from within your Plugin code and is a helpful short-cut for creating
  new loader file types.

  The key is the property that will be injected into the Loader Plugin and used to load the
  files. For example:

  ```javascript
  this.plugins.registerFileType('wad', doomWadLoaderCallback);
  // later in your preload code:
  this.load.wad();
  ```

  The callback is what is called when the loader tries to load a file  matching the given key.
  It's important to understand that the callback is invoked within
  the context of the LoaderPlugin. In this context there are several properties / methods available
  to use:

  this.addFile - A method to add the new file to the load queue.
  this.scene - The Scene that owns the Loader Plugin instance.

  See the LoaderPlugin class for more details. Any public property or method listed is available from
  your callback under `this`.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the Game Object that the given callbacks will create, i.e. `image`, `sprite`.
    * callback (function) - The callback to invoke when the Game Object Factory is called.
    * add-to-scene (Phaser.Scene) {optional} - Optionally add this file type into the Loader Plugin owned by the given Scene."
  ([plugin-manager key callback]
   (phaser->clj
    (.registerFileType plugin-manager
                       (clj->phaser key)
                       (clj->phaser callback))))
  ([plugin-manager key callback add-to-scene]
   (phaser->clj
    (.registerFileType plugin-manager
                       (clj->phaser key)
                       (clj->phaser callback)
                       (clj->phaser add-to-scene)))))

(defn register-game-object
  "Registers a new type of Game Object with the global Game Object Factory and / or Creator.
  This is usually called from within your Plugin code and is a helpful short-cut for creating
  new Game Objects.

  The key is the property that will be injected into the factories and used to create the
  Game Object. For example:

  ```javascript
  this.plugins.registerGameObject('clown', clownFactoryCallback, clownCreatorCallback);
  // later in your game code:
  this.add.clown();
  this.make.clown();
  ```

  The callbacks are what are called when the factories try to create a Game Object
  matching the given key. It's important to understand that the callbacks are invoked within
  the context of the GameObjectFactory. In this context there are several properties available
  to use:

  this.scene - A reference to the Scene that owns the GameObjectFactory.
  this.displayList - A reference to the Display List the Scene owns.
  this.updateList - A reference to the Update List the Scene owns.

  See the GameObjectFactory and GameObjectCreator classes for more details.
  Any public property or method listed is available from your callbacks under `this`.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the Game Object that the given callbacks will create, i.e. `image`, `sprite`.
    * factory-callback (function) {optional} - The callback to invoke when the Game Object Factory is called.
    * creator-callback (function) {optional} - The callback to invoke when the Game Object Creator is called."
  ([plugin-manager key]
   (phaser->clj
    (.registerGameObject plugin-manager
                         (clj->phaser key))))
  ([plugin-manager key factory-callback]
   (phaser->clj
    (.registerGameObject plugin-manager
                         (clj->phaser key)
                         (clj->phaser factory-callback))))
  ([plugin-manager key factory-callback creator-callback]
   (phaser->clj
    (.registerGameObject plugin-manager
                         (clj->phaser key)
                         (clj->phaser factory-callback)
                         (clj->phaser creator-callback)))))

(defn remove-game-object
  "Removes a previously registered Game Object from the global Game Object Factory and / or Creator.
  This is usually called from within your Plugin destruction code to help clean-up after your plugin has been removed.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the Game Object to be removed from the factories.
    * remove-from-factory (boolean) {optional} - Should the Game Object be removed from the Game Object Factory?
    * remove-from-creator (boolean) {optional} - Should the Game Object be removed from the Game Object Creator?"
  ([plugin-manager key]
   (phaser->clj
    (.removeGameObject plugin-manager
                       (clj->phaser key))))
  ([plugin-manager key remove-from-factory]
   (phaser->clj
    (.removeGameObject plugin-manager
                       (clj->phaser key)
                       (clj->phaser remove-from-factory))))
  ([plugin-manager key remove-from-factory remove-from-creator]
   (phaser->clj
    (.removeGameObject plugin-manager
                       (clj->phaser key)
                       (clj->phaser remove-from-factory)
                       (clj->phaser remove-from-creator)))))

(defn remove-global-plugin
  "Removes a global plugin from the Plugin Manager and Plugin Cache.

  It is up to you to remove all references to this plugin that you may hold within your game code.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the plugin to remove."
  ([plugin-manager key]
   (phaser->clj
    (.removeGlobalPlugin plugin-manager
                         (clj->phaser key)))))

(defn remove-scene-plugin
  "Removes a scene plugin from the Plugin Manager and Plugin Cache.

  This will not remove the plugin from any active Scenes that are already using it.

  It is up to you to remove all references to this plugin that you may hold within your game code.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the plugin to remove."
  ([plugin-manager key]
   (phaser->clj
    (.removeScenePlugin plugin-manager
                        (clj->phaser key)))))

(defn start
  "Starts a global plugin running.

  If the plugin was previously active then calling `start` will reset it to an active state and then
  call its `start` method.

  If the plugin has never been run before a new instance of it will be created within the Plugin Manager,
  its active state set and then both of its `init` and `start` methods called, in that order.

  If the plugin is already running under the given key then nothing happens.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the plugin to start.
    * run-as (string) {optional} - Run the plugin under a new key. This allows you to run one plugin multiple times.

  Returns:  Phaser.Plugins.BasePlugin - The plugin that was started, or `null` if invalid key given or plugin is already stopped."
  ([plugin-manager key]
   (phaser->clj
    (.start plugin-manager
            (clj->phaser key))))
  ([plugin-manager key run-as]
   (phaser->clj
    (.start plugin-manager
            (clj->phaser key)
            (clj->phaser run-as)))))

(defn stop
  "Stops a global plugin from running.

  If the plugin is active then its active state will be set to false and the plugins `stop` method
  will be called.

  If the plugin is not already running, nothing will happen.

  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - Targeted instance for method
    * key (string) - The key of the plugin to stop.

  Returns:  Phaser.Plugins.PluginManager - The Plugin Manager."
  ([plugin-manager key]
   (phaser->clj
    (.stop plugin-manager
           (clj->phaser key)))))