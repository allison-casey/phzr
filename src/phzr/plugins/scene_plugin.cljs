(ns phzr.plugins.scene-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->ScenePlugin
  "  Parameters:
    * scene (Phaser.Scene) - A reference to the Scene that has installed this plugin.
    * plugin-manager (Phaser.Plugins.PluginManager) - A reference to the Plugin Manager."
  ([scene plugin-manager]
   (js/Phaser.Plugins.ScenePlugin. (clj->phaser scene)
                                   (clj->phaser plugin-manager))))

(defn boot
  "This method is called when the Scene boots. It is only ever called once.

  By this point the plugin properties `scene` and `systems` will have already been set.

  In here you can listen for {@link Phaser.Scenes.Events Scene events} and set-up whatever you need for this plugin to run.
  Here are the Scene events you can listen to:

  - start
  - ready
  - preupdate
  - update
  - postupdate
  - resize
  - pause
  - resume
  - sleep
  - wake
  - transitioninit
  - transitionstart
  - transitioncomplete
  - transitionout
  - shutdown
  - destroy

  At the very least you should offer a destroy handler for when the Scene closes down, i.e:

  ```javascript
  var eventEmitter = this.systems.events;
  eventEmitter.once('destroy', this.sceneDestroy, this);
  ```"
  ([scene-plugin]
   (phaser->clj
    (.boot scene-plugin))))

(defn destroy
  "Game instance has been destroyed.

  You must release everything in here, all references, all objects, free it all up."
  ([scene-plugin]
   (phaser->clj
    (.destroy scene-plugin))))

(defn init
  "The PluginManager calls this method on a Global Plugin when the plugin is first instantiated.
  It will never be called again on this instance.
  In here you can set-up whatever you need for this plugin to run.
  If a plugin is set to automatically start then `BasePlugin.start` will be called immediately after this.
  On a Scene Plugin, this method is never called. Use {@link Phaser.Plugins.ScenePlugin#boot} instead.

  Parameters:
    * scene-plugin (Phaser.Plugins.ScenePlugin) - Targeted instance for method
    * data (any) {optional} - A value specified by the user, if any, from the `data` property of the plugin's configuration object (if started at game boot) or passed in the PluginManager's `install` method (if started manually)."
  ([scene-plugin]
   (phaser->clj
    (.init scene-plugin)))
  ([scene-plugin data]
   (phaser->clj
    (.init scene-plugin
           (clj->phaser data)))))

(defn start
  "The PluginManager calls this method on a Global Plugin when the plugin is started.
  If a plugin is stopped, and then started again, this will get called again.
  Typically called immediately after `BasePlugin.init`.
  On a Scene Plugin, this method is never called."
  ([scene-plugin]
   (phaser->clj
    (.start scene-plugin))))

(defn stop
  "The PluginManager calls this method on a Global Plugin when the plugin is stopped.
  The game code has requested that your plugin stop doing whatever it does.
  It is now considered as 'inactive' by the PluginManager.
  Handle that process here (i.e. stop listening for events, etc)
  If the plugin is started again then `BasePlugin.start` will be called again.
  On a Scene Plugin, this method is never called."
  ([scene-plugin]
   (phaser->clj
    (.stop scene-plugin))))