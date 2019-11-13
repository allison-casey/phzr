(ns phzr.plugins.base-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->BasePlugin
  "  Parameters:
    * plugin-manager (Phaser.Plugins.PluginManager) - A reference to the Plugin Manager."
  ([plugin-manager]
   (js/Phaser.Plugins.BasePlugin. (clj->phaser plugin-manager))))

(defn destroy
  "Game instance has been destroyed.
  You must release everything in here, all references, all objects, free it all up."
  ([base-plugin]
   (phaser->clj
    (.destroy base-plugin))))

(defn init
  "The PluginManager calls this method on a Global Plugin when the plugin is first instantiated.
  It will never be called again on this instance.
  In here you can set-up whatever you need for this plugin to run.
  If a plugin is set to automatically start then `BasePlugin.start` will be called immediately after this.
  On a Scene Plugin, this method is never called. Use {@link Phaser.Plugins.ScenePlugin#boot} instead.

  Parameters:
    * base-plugin (Phaser.Plugins.BasePlugin) - Targeted instance for method
    * data (any) {optional} - A value specified by the user, if any, from the `data` property of the plugin's configuration object (if started at game boot) or passed in the PluginManager's `install` method (if started manually)."
  ([base-plugin]
   (phaser->clj
    (.init base-plugin)))
  ([base-plugin data]
   (phaser->clj
    (.init base-plugin
           (clj->phaser data)))))

(defn start
  "The PluginManager calls this method on a Global Plugin when the plugin is started.
  If a plugin is stopped, and then started again, this will get called again.
  Typically called immediately after `BasePlugin.init`.
  On a Scene Plugin, this method is never called."
  ([base-plugin]
   (phaser->clj
    (.start base-plugin))))

(defn stop
  "The PluginManager calls this method on a Global Plugin when the plugin is stopped.
  The game code has requested that your plugin stop doing whatever it does.
  It is now considered as 'inactive' by the PluginManager.
  Handle that process here (i.e. stop listening for events, etc)
  If the plugin is started again then `BasePlugin.start` will be called again.
  On a Scene Plugin, this method is never called."
  ([base-plugin]
   (phaser->clj
    (.stop base-plugin))))