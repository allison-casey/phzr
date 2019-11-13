(ns phzr.loader.loader-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->LoaderPlugin
  "  Parameters:
    * scene (Phaser.Scene) - The Scene which owns this Loader instance."
  ([scene]
   (js/Phaser.Loader.LoaderPlugin. (clj->phaser scene))))

(defn add-file
  "Adds a file, or array of files, into the load queue.

  The file must be an instance of `Phaser.Loader.File`, or a class that extends it. The Loader will check that the key
  used by the file won't conflict with any other key either in the loader, the inflight queue or the target cache.
  If allowed it will then add the file into the pending list, read for the load to start. Or, if the load has already
  started, ready for the next batch of files to be pulled from the list to the inflight queue.

  You should not normally call this method directly, but rather use one of the Loader methods like `image` or `atlas`,
  however you can call this as long as the file given to it is well formed.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * file (Phaser.Loader.File | Array.<Phaser.Loader.File>) - The file, or array of files, to be added to the load queue."
  ([loader-plugin file]
   (phaser->clj
    (.addFile loader-plugin
              (clj->phaser file)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([loader-plugin event fn]
   (phaser->clj
    (.addListener loader-plugin
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([loader-plugin event fn context]
   (phaser->clj
    (.addListener loader-plugin
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn add-pack
  "Takes a well formed, fully parsed pack file object and adds its entries into the load queue. Usually you do not call
  this method directly, but instead use `Loader.pack` and supply a path to a JSON file that holds the
  pack data. However, if you've got the data prepared you can pass it to this method.

  You can also provide an optional key. If you do then it will only add the entries from that part of the pack into
  to the load queue. If not specified it will add all entries it finds. For more details about the pack file format
  see the `LoaderPlugin.pack` method.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * data (any) - The Pack File data to be parsed and each entry of it to added to the load queue.
    * pack-key (string) {optional} - An optional key to use from the pack file data.

  Returns:  boolean - `true` if any files were added to the queue, otherwise `false`."
  ([loader-plugin data]
   (phaser->clj
    (.addPack loader-plugin
              (clj->phaser data))))
  ([loader-plugin data pack-key]
   (phaser->clj
    (.addPack loader-plugin
              (clj->phaser data)
              (clj->phaser pack-key)))))

(defn animation
  "Adds an Animation JSON Data file, or array of Animation JSON files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.animation('baddieAnims', 'files/BaddieAnims.json');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  If you call this from outside of `preload` then you are responsible for starting the Loader afterwards and monitoring
  its events to know when it's safe to use the asset. Please see the Phaser.Loader.LoaderPlugin class for more details.

  The key must be a unique String. It is used to add the file to the global JSON Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the JSON Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the JSON Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.animation({
      key: 'baddieAnims',
      url: 'files/BaddieAnims.json'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.JSONFileConfig` for more details.

  Once the file has finished loading it will automatically be passed to the global Animation Managers `fromJSON` method.
  This will parse all of the JSON data and create animation data from it. This process happens at the very end
  of the Loader, once every other file in the load queue has finished. The reason for this is to allow you to load
  both animation data and the images it relies upon in the same load call.

  Once the animation data has been parsed you will be able to play animations using that data.
  Please see the Animation Manager `fromJSON` method for more details about the format and playback.

  You can also access the raw animation data from its Cache using its key:

  ```javascript
  this.load.animation('baddieAnims', 'files/BaddieAnims.json');
  // and later in your game ...
  var data = this.cache.json.get('baddieAnims');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Waves` the final key will be `LEVEL1.Waves` and
  this is what you would use to retrieve the text from the JSON Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'data'
  and no URL is given then the Loader will set the URL to be 'data.json'. It will always add `.json` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  You can also optionally provide a `dataKey` to use. This allows you to extract only a part of the JSON and store it in the Cache,
  rather than the whole file. For example, if your JSON data had a structure like this:

  ```json
  {
      'level1': {
          'baddies': {
              'aliens': {},
              'boss': {}
          }
      },
      'level2': {},
      'level3': {}
  }
  ```

  And if you only wanted to create animations from the `boss` data, then you could pass `level1.baddies.boss`as the `dataKey`.

  Note: The ability to load this type of file will only be available if the JSON File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.JSONFileConfig | Array.<Phaser.Types.Loader.FileTypes.JSONFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * data-key (string) {optional} - When the Animation JSON file loads only this property will be stored in the Cache and used to create animation data.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.animation loader-plugin
                (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.animation loader-plugin
                (clj->phaser key)
                (clj->phaser url))))
  ([loader-plugin key url data-key]
   (phaser->clj
    (.animation loader-plugin
                (clj->phaser key)
                (clj->phaser url)
                (clj->phaser data-key))))
  ([loader-plugin key url data-key xhr-settings]
   (phaser->clj
    (.animation loader-plugin
                (clj->phaser key)
                (clj->phaser url)
                (clj->phaser data-key)
                (clj->phaser xhr-settings)))))

(defn atlas
  "Adds a JSON based Texture Atlas, or array of atlases, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.atlas('mainmenu', 'images/MainMenu.png', 'images/MainMenu.json');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  If you call this from outside of `preload` then you are responsible for starting the Loader afterwards and monitoring
  its events to know when it's safe to use the asset. Please see the Phaser.Loader.LoaderPlugin class for more details.

  Phaser expects the atlas data to be provided in a JSON file, using either the JSON Hash or JSON Array format.
  These files are created by software such as Texture Packer, Shoebox and Adobe Flash / Animate.
  If you are using Texture Packer and have enabled multi-atlas support, then please use the Phaser Multi Atlas loader
  instead of this one.

  Phaser can load all common image types: png, jpg, gif and any other format the browser can natively handle.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.atlas({
      key: 'mainmenu',
      textureURL: 'images/MainMenu.png',
      atlasURL: 'images/MainMenu.json'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.AtlasJSONFileConfig` for more details.

  Instead of passing a URL for the atlas JSON data you can also pass in a well formed JSON object instead.

  Once the atlas has finished loading you can use frames from it as textures for a Game Object by referencing its key:

  ```javascript
  this.load.atlas('mainmenu', 'images/MainMenu.png', 'images/MainMenu.json');
  // and later in your game ...
  this.add.image(x, y, 'mainmenu', 'background');
  ```

  To get a list of all available frames within an atlas please consult your Texture Atlas software.

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.png'. It will always add `.png` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Phaser also supports the automatic loading of associated normal maps. If you have a normal map to go with this image,
  then you can specify it by providing an array as the `url` where the second element is the normal map:

  ```javascript
  this.load.atlas('mainmenu', [ 'images/MainMenu.png', 'images/MainMenu-n.png' ], 'images/MainMenu.json');
  ```

  Or, if you are using a config object use the `normalMap` property:

  ```javascript
  this.load.atlas({
      key: 'mainmenu',
      textureURL: 'images/MainMenu.png',
      normalMap: 'images/MainMenu-n.png',
      atlasURL: 'images/MainMenu.json'
  });
  ```

  The normal map file is subject to the same conditions as the image file with regard to the path, baseURL, CORs and XHR Settings.
  Normal maps are a WebGL only feature.

  Note: The ability to load this type of file will only be available if the Atlas JSON File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.AtlasJSONFileConfig | Array.<Phaser.Types.Loader.FileTypes.AtlasJSONFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * texture-url (string | Array.<string>) {optional} - The absolute or relative URL to load the texture image file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * atlas-url (string) {optional} - The absolute or relative URL to load the texture atlas json data file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * texture-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas image file. Used in replacement of the Loaders default XHR Settings.
    * atlas-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas json file. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.atlas loader-plugin
            (clj->phaser key))))
  ([loader-plugin key texture-url]
   (phaser->clj
    (.atlas loader-plugin
            (clj->phaser key)
            (clj->phaser texture-url))))
  ([loader-plugin key texture-url atlas-url]
   (phaser->clj
    (.atlas loader-plugin
            (clj->phaser key)
            (clj->phaser texture-url)
            (clj->phaser atlas-url))))
  ([loader-plugin key texture-url atlas-url texture-xhr-settings]
   (phaser->clj
    (.atlas loader-plugin
            (clj->phaser key)
            (clj->phaser texture-url)
            (clj->phaser atlas-url)
            (clj->phaser texture-xhr-settings))))
  ([loader-plugin key texture-url atlas-url texture-xhr-settings atlas-xhr-settings]
   (phaser->clj
    (.atlas loader-plugin
            (clj->phaser key)
            (clj->phaser texture-url)
            (clj->phaser atlas-url)
            (clj->phaser texture-xhr-settings)
            (clj->phaser atlas-xhr-settings)))))

(defn atlas-xml
  "Adds an XML based Texture Atlas, or array of atlases, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.atlasXML('mainmenu', 'images/MainMenu.png', 'images/MainMenu.xml');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  If you call this from outside of `preload` then you are responsible for starting the Loader afterwards and monitoring
  its events to know when it's safe to use the asset. Please see the Phaser.Loader.LoaderPlugin class for more details.

  Phaser expects the atlas data to be provided in an XML file format.
  These files are created by software such as Shoebox and Adobe Flash / Animate.

  Phaser can load all common image types: png, jpg, gif and any other format the browser can natively handle.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.atlasXML({
      key: 'mainmenu',
      textureURL: 'images/MainMenu.png',
      atlasURL: 'images/MainMenu.xml'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.AtlasXMLFileConfig` for more details.

  Once the atlas has finished loading you can use frames from it as textures for a Game Object by referencing its key:

  ```javascript
  this.load.atlasXML('mainmenu', 'images/MainMenu.png', 'images/MainMenu.xml');
  // and later in your game ...
  this.add.image(x, y, 'mainmenu', 'background');
  ```

  To get a list of all available frames within an atlas please consult your Texture Atlas software.

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.png'. It will always add `.png` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Phaser also supports the automatic loading of associated normal maps. If you have a normal map to go with this image,
  then you can specify it by providing an array as the `url` where the second element is the normal map:

  ```javascript
  this.load.atlasXML('mainmenu', [ 'images/MainMenu.png', 'images/MainMenu-n.png' ], 'images/MainMenu.xml');
  ```

  Or, if you are using a config object use the `normalMap` property:

  ```javascript
  this.load.atlasXML({
      key: 'mainmenu',
      textureURL: 'images/MainMenu.png',
      normalMap: 'images/MainMenu-n.png',
      atlasURL: 'images/MainMenu.xml'
  });
  ```

  The normal map file is subject to the same conditions as the image file with regard to the path, baseURL, CORs and XHR Settings.
  Normal maps are a WebGL only feature.

  Note: The ability to load this type of file will only be available if the Atlas XML File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.AtlasXMLFileConfig | Array.<Phaser.Types.Loader.FileTypes.AtlasXMLFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * texture-url (string | Array.<string>) {optional} - The absolute or relative URL to load the texture image file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * atlas-url (string) {optional} - The absolute or relative URL to load the texture atlas xml data file from. If undefined or `null` it will be set to `<key>.xml`, i.e. if `key` was 'alien' then the URL will be 'alien.xml'.
    * texture-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas image file. Used in replacement of the Loaders default XHR Settings.
    * atlas-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas xml file. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.atlasXML loader-plugin
               (clj->phaser key))))
  ([loader-plugin key texture-url]
   (phaser->clj
    (.atlasXML loader-plugin
               (clj->phaser key)
               (clj->phaser texture-url))))
  ([loader-plugin key texture-url atlas-url]
   (phaser->clj
    (.atlasXML loader-plugin
               (clj->phaser key)
               (clj->phaser texture-url)
               (clj->phaser atlas-url))))
  ([loader-plugin key texture-url atlas-url texture-xhr-settings]
   (phaser->clj
    (.atlasXML loader-plugin
               (clj->phaser key)
               (clj->phaser texture-url)
               (clj->phaser atlas-url)
               (clj->phaser texture-xhr-settings))))
  ([loader-plugin key texture-url atlas-url texture-xhr-settings atlas-xhr-settings]
   (phaser->clj
    (.atlasXML loader-plugin
               (clj->phaser key)
               (clj->phaser texture-url)
               (clj->phaser atlas-url)
               (clj->phaser texture-xhr-settings)
               (clj->phaser atlas-xhr-settings)))))

(defn audio
  "Adds an Audio or HTML5Audio file, or array of audio files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.audio('title', [ 'music/Title.ogg', 'music/Title.mp3', 'music/Title.m4a' ]);
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Audio Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Audio Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Audio Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.audio({
      key: 'title',
      url: [ 'music/Title.ogg', 'music/Title.mp3', 'music/Title.m4a' ]
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.AudioFileConfig` for more details.

  The URLs can be relative or absolute. If the URLs are relative the `Loader.baseURL` and `Loader.path` values will be prepended to them.

  Due to different browsers supporting different audio file types you should usually provide your audio files in a variety of formats.
  ogg, mp3 and m4a are the most common. If you provide an array of URLs then the Loader will determine which _one_ file to load based on
  browser support.

  If audio has been disabled in your game, either via the game config, or lack of support from the device, then no audio will be loaded.

  Note: The ability to load this type of file will only be available if the Audio File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.AudioFileConfig | Array.<Phaser.Types.Loader.FileTypes.AudioFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * urls (string | Array.<string>) {optional} - The absolute or relative URL to load the audio files from.
    * config (any) {optional} - An object containing an `instances` property for HTML5Audio. Defaults to 1.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.audio loader-plugin
            (clj->phaser key))))
  ([loader-plugin key urls]
   (phaser->clj
    (.audio loader-plugin
            (clj->phaser key)
            (clj->phaser urls))))
  ([loader-plugin key urls config]
   (phaser->clj
    (.audio loader-plugin
            (clj->phaser key)
            (clj->phaser urls)
            (clj->phaser config))))
  ([loader-plugin key urls config xhr-settings]
   (phaser->clj
    (.audio loader-plugin
            (clj->phaser key)
            (clj->phaser urls)
            (clj->phaser config)
            (clj->phaser xhr-settings)))))

(defn audio-sprite
  "Adds a JSON based Audio Sprite, or array of audio sprites, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.audioSprite('kyobi', 'kyobi.json', [
          'kyobi.ogg',
          'kyobi.mp3',
          'kyobi.m4a'
      ]);
  }
  ```

  Audio Sprites are a combination of audio files and a JSON configuration.
  The JSON follows the format of that created by https://github.com/tonistiigi/audiosprite

  If the JSON file includes a 'resource' object then you can let Phaser parse it and load the audio
  files automatically based on its content. To do this exclude the audio URLs from the load:

  ```javascript
  function preload ()
  {
      this.load.audioSprite('kyobi', 'kyobi.json');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  If you call this from outside of `preload` then you are responsible for starting the Loader afterwards and monitoring
  its events to know when it's safe to use the asset. Please see the Phaser.Loader.LoaderPlugin class for more details.

  The key must be a unique String. It is used to add the file to the global Audio Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Audio Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Audio Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.audioSprite({
      key: 'kyobi',
      jsonURL: 'audio/Kyobi.json',
      audioURL: [
          'audio/Kyobi.ogg',
          'audio/Kyobi.mp3',
          'audio/Kyobi.m4a'
      ]
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.AudioSpriteFileConfig` for more details.

  Instead of passing a URL for the audio JSON data you can also pass in a well formed JSON object instead.

  Once the audio has finished loading you can use it create an Audio Sprite by referencing its key:

  ```javascript
  this.load.audioSprite('kyobi', 'kyobi.json');
  // and later in your game ...
  var music = this.sound.addAudioSprite('kyobi');
  music.play('title');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  Due to different browsers supporting different audio file types you should usually provide your audio files in a variety of formats.
  ogg, mp3 and m4a are the most common. If you provide an array of URLs then the Loader will determine which _one_ file to load based on
  browser support.

  If audio has been disabled in your game, either via the game config, or lack of support from the device, then no audio will be loaded.

  Note: The ability to load this type of file will only be available if the Audio Sprite File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.AudioSpriteFileConfig | Array.<Phaser.Types.Loader.FileTypes.AudioSpriteFileConfig>) - The key to use for this file, or a file configuration object, or an array of objects.
    * json-url (string) - The absolute or relative URL to load the json file from. Or a well formed JSON object to use instead.
    * audio-url (string | Array.<string>) {optional} - The absolute or relative URL to load the audio file from. If empty it will be obtained by parsing the JSON file.
    * audio-config (any) {optional} - The audio configuration options.
    * audio-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the audio file. Used in replacement of the Loaders default XHR Settings.
    * json-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the json file. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader."
  ([loader-plugin key json-url]
   (phaser->clj
    (.audioSprite loader-plugin
                  (clj->phaser key)
                  (clj->phaser json-url))))
  ([loader-plugin key json-url audio-url]
   (phaser->clj
    (.audioSprite loader-plugin
                  (clj->phaser key)
                  (clj->phaser json-url)
                  (clj->phaser audio-url))))
  ([loader-plugin key json-url audio-url audio-config]
   (phaser->clj
    (.audioSprite loader-plugin
                  (clj->phaser key)
                  (clj->phaser json-url)
                  (clj->phaser audio-url)
                  (clj->phaser audio-config))))
  ([loader-plugin key json-url audio-url audio-config audio-xhr-settings]
   (phaser->clj
    (.audioSprite loader-plugin
                  (clj->phaser key)
                  (clj->phaser json-url)
                  (clj->phaser audio-url)
                  (clj->phaser audio-config)
                  (clj->phaser audio-xhr-settings))))
  ([loader-plugin key json-url audio-url audio-config audio-xhr-settings json-xhr-settings]
   (phaser->clj
    (.audioSprite loader-plugin
                  (clj->phaser key)
                  (clj->phaser json-url)
                  (clj->phaser audio-url)
                  (clj->phaser audio-config)
                  (clj->phaser audio-xhr-settings)
                  (clj->phaser json-xhr-settings)))))

(defn binary
  "Adds a Binary file, or array of Binary files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.binary('doom', 'files/Doom.wad');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Binary Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Binary Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Binary Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.binary({
      key: 'doom',
      url: 'files/Doom.wad',
      dataType: Uint8Array
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.BinaryFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.binary('doom', 'files/Doom.wad');
  // and later in your game ...
  var data = this.cache.binary.get('doom');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Data` the final key will be `LEVEL1.Data` and
  this is what you would use to retrieve the text from the Binary Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'doom'
  and no URL is given then the Loader will set the URL to be 'doom.bin'. It will always add `.bin` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Binary File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.BinaryFileConfig | Array.<Phaser.Types.Loader.FileTypes.BinaryFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.bin`, i.e. if `key` was 'alien' then the URL will be 'alien.bin'.
    * data-type (any) {optional} - Optional type to cast the binary file to once loaded. For example, `Uint8Array`.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.binary loader-plugin
             (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.binary loader-plugin
             (clj->phaser key)
             (clj->phaser url))))
  ([loader-plugin key url data-type]
   (phaser->clj
    (.binary loader-plugin
             (clj->phaser key)
             (clj->phaser url)
             (clj->phaser data-type))))
  ([loader-plugin key url data-type xhr-settings]
   (phaser->clj
    (.binary loader-plugin
             (clj->phaser key)
             (clj->phaser url)
             (clj->phaser data-type)
             (clj->phaser xhr-settings)))))

(defn bitmap-font
  "Adds an XML based Bitmap Font, or array of fonts, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:
  ```javascript
  function preload ()
  {
      this.load.bitmapFont('goldenFont', 'images/GoldFont.png', 'images/GoldFont.xml');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  If you call this from outside of `preload` then you are responsible for starting the Loader afterwards and monitoring
  its events to know when it's safe to use the asset. Please see the Phaser.Loader.LoaderPlugin class for more details.

  Phaser expects the font data to be provided in an XML file format.
  These files are created by software such as the [Angelcode Bitmap Font Generator](http://www.angelcode.com/products/bmfont/),
  [Littera](http://kvazars.com/littera/) or [Glyph Designer](https://71squared.com/glyphdesigner)

  Phaser can load all common image types: png, jpg, gif and any other format the browser can natively handle.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.bitmapFont({
      key: 'goldenFont',
      textureURL: 'images/GoldFont.png',
      fontDataURL: 'images/GoldFont.xml'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.BitmapFontFileConfig` for more details.

  Once the atlas has finished loading you can use key of it when creating a Bitmap Text Game Object:

  ```javascript
  this.load.bitmapFont('goldenFont', 'images/GoldFont.png', 'images/GoldFont.xml');
  // and later in your game ...
  this.add.bitmapText(x, y, 'goldenFont', 'Hello World');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use when creating a Bitmap Text object.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.png'. It will always add `.png` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Phaser also supports the automatic loading of associated normal maps. If you have a normal map to go with this image,
  then you can specify it by providing an array as the `url` where the second element is the normal map:

  ```javascript
  this.load.bitmapFont('goldenFont', [ 'images/GoldFont.png', 'images/GoldFont-n.png' ], 'images/GoldFont.xml');
  ```

  Or, if you are using a config object use the `normalMap` property:

  ```javascript
  this.load.bitmapFont({
      key: 'goldenFont',
      textureURL: 'images/GoldFont.png',
      normalMap: 'images/GoldFont-n.png',
      fontDataURL: 'images/GoldFont.xml'
  });
  ```

  The normal map file is subject to the same conditions as the image file with regard to the path, baseURL, CORs and XHR Settings.
  Normal maps are a WebGL only feature.

  Note: The ability to load this type of file will only be available if the Bitmap Font File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.BitmapFontFileConfig | Array.<Phaser.Types.Loader.FileTypes.BitmapFontFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * texture-url (string | Array.<string>) {optional} - The absolute or relative URL to load the font image file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * font-data-url (string) {optional} - The absolute or relative URL to load the font xml data file from. If undefined or `null` it will be set to `<key>.xml`, i.e. if `key` was 'alien' then the URL will be 'alien.xml'.
    * texture-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the font image file. Used in replacement of the Loaders default XHR Settings.
    * font-data-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the font data xml file. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.bitmapFont loader-plugin
                 (clj->phaser key))))
  ([loader-plugin key texture-url]
   (phaser->clj
    (.bitmapFont loader-plugin
                 (clj->phaser key)
                 (clj->phaser texture-url))))
  ([loader-plugin key texture-url font-data-url]
   (phaser->clj
    (.bitmapFont loader-plugin
                 (clj->phaser key)
                 (clj->phaser texture-url)
                 (clj->phaser font-data-url))))
  ([loader-plugin key texture-url font-data-url texture-xhr-settings]
   (phaser->clj
    (.bitmapFont loader-plugin
                 (clj->phaser key)
                 (clj->phaser texture-url)
                 (clj->phaser font-data-url)
                 (clj->phaser texture-xhr-settings))))
  ([loader-plugin key texture-url font-data-url texture-xhr-settings font-data-xhr-settings]
   (phaser->clj
    (.bitmapFont loader-plugin
                 (clj->phaser key)
                 (clj->phaser texture-url)
                 (clj->phaser font-data-url)
                 (clj->phaser texture-xhr-settings)
                 (clj->phaser font-data-xhr-settings)))))

(defn css
  "Adds a CSS file, or array of CSS files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.css('headers', 'styles/headers.css');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String and not already in-use by another file in the Loader.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.css({
      key: 'headers',
      url: 'styles/headers.css'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.CSSFileConfig` for more details.

  Once the file has finished loading it will automatically be converted into a style DOM element
  via `document.createElement('style')`. It will have its `defer` property set to false and then the
  resulting element will be appended to `document.head`. The CSS styles are then applied to the current document.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.css'. It will always add `.css` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the CSS File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.CSSFileConfig | Array.<Phaser.Types.Loader.FileTypes.CSSFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.css`, i.e. if `key` was 'alien' then the URL will be 'alien.css'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.css loader-plugin
          (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.css loader-plugin
          (clj->phaser key)
          (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.css loader-plugin
          (clj->phaser key)
          (clj->phaser url)
          (clj->phaser xhr-settings)))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([loader-plugin event]
   (phaser->clj
    (.emit loader-plugin
           (clj->phaser event))))
  ([loader-plugin event args]
   (phaser->clj
    (.emit loader-plugin
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([loader-plugin]
   (phaser->clj
    (.eventNames loader-plugin))))

(defn file-process-complete
  "An internal method that is called automatically by the File when it has finished processing.

  If the process was successful, and the File isn't part of a MultiFile, its `addToCache` method is called.

  It this then removed from the queue. If there are no more files to load `loadComplete` is called.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * file (Phaser.Loader.File) - The file that has finished processing."
  ([loader-plugin file]
   (phaser->clj
    (.fileProcessComplete loader-plugin
                          (clj->phaser file)))))

(defn flag-for-removal
  "Adds a File into the pending-deletion queue.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * file (Phaser.Loader.File) - The File to be queued for deletion when the Loader completes."
  ([loader-plugin file]
   (phaser->clj
    (.flagForRemoval loader-plugin
                     (clj->phaser file)))))

(defn glsl
  "Adds a GLSL file, or array of GLSL files, to the current load queue.
  In Phaser 3 GLSL files are just plain Text files at the current moment in time.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.glsl('plasma', 'shaders/Plasma.glsl');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Shader Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Shader Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Shader Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.glsl({
      key: 'plasma',
      shaderType: 'fragment',
      url: 'shaders/Plasma.glsl'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.GLSLFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.glsl('plasma', 'shaders/Plasma.glsl');
  // and later in your game ...
  var data = this.cache.shader.get('plasma');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `FX.` and the key was `Plasma` the final key will be `FX.Plasma` and
  this is what you would use to retrieve the text from the Shader Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'plasma'
  and no URL is given then the Loader will set the URL to be 'plasma.glsl'. It will always add `.glsl` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the GLSL File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.GLSLFileConfig | Array.<Phaser.Types.Loader.FileTypes.GLSLFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.glsl`, i.e. if `key` was 'alien' then the URL will be 'alien.glsl'.
    * shader-type (string) {optional} - The type of shader. Either `fragment` for a fragment shader, or `vertex` for a vertex shader. This is ignored if you load a shader bundle.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.glsl loader-plugin
           (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.glsl loader-plugin
           (clj->phaser key)
           (clj->phaser url))))
  ([loader-plugin key url shader-type]
   (phaser->clj
    (.glsl loader-plugin
           (clj->phaser key)
           (clj->phaser url)
           (clj->phaser shader-type))))
  ([loader-plugin key url shader-type xhr-settings]
   (phaser->clj
    (.glsl loader-plugin
           (clj->phaser key)
           (clj->phaser url)
           (clj->phaser shader-type)
           (clj->phaser xhr-settings)))))

(defn html
  "Adds an HTML file, or array of HTML files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.html('story', 'files/LoginForm.html');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global HTML Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the HTML Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the HTML Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.html({
      key: 'login',
      url: 'files/LoginForm.html'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.HTMLFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.html('login', 'files/LoginForm.html');
  // and later in your game ...
  var data = this.cache.html.get('login');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Story` the final key will be `LEVEL1.Story` and
  this is what you would use to retrieve the html from the HTML Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'story'
  and no URL is given then the Loader will set the URL to be 'story.html'. It will always add `.html` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the HTML File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.HTMLFileConfig | Array.<Phaser.Types.Loader.FileTypes.HTMLFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.html`, i.e. if `key` was 'alien' then the URL will be 'alien.html'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.html loader-plugin
           (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.html loader-plugin
           (clj->phaser key)
           (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.html loader-plugin
           (clj->phaser key)
           (clj->phaser url)
           (clj->phaser xhr-settings)))))

(defn html-texture
  "Adds an HTML File, or array of HTML Files, to the current load queue. When the files are loaded they
  will be rendered to textures and stored in the Texture Manager.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.htmlTexture('instructions', 'content/intro.html', 256, 512);
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.htmlTexture({
      key: 'instructions',
      url: 'content/intro.html',
      width: 256,
      height: 512
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.HTMLTextureFileConfig` for more details.

  Once the file has finished loading you can use it as a texture for a Game Object by referencing its key:

  ```javascript
  this.load.htmlTexture('instructions', 'content/intro.html', 256, 512);
  // and later in your game ...
  this.add.image(x, y, 'instructions');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.html'. It will always add `.html` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  The width and height are the size of the texture to which the HTML will be rendered. It's not possible to determine these
  automatically, so you will need to provide them, either as arguments or in the file config object.
  When the HTML file has loaded a new SVG element is created with a size and viewbox set to the width and height given.
  The SVG file has a body tag added to it, with the HTML file contents included. It then calls `window.Blob` on the SVG,
  and if successful is added to the Texture Manager, otherwise it fails processing. The overall quality of the rendered
  HTML depends on your browser, and some of them may not even support the svg / blob process used. Be aware that there are
  limitations on what HTML can be inside an SVG. You can find out more details in this
  [Mozilla MDN entry](https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API/Drawing_DOM_objects_into_a_canvas).

  Note: The ability to load this type of file will only be available if the HTMLTextureFile File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.HTMLTextureFileConfig | Array.<Phaser.Types.Loader.FileTypes.HTMLTextureFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.html`, i.e. if `key` was 'alien' then the URL will be 'alien.html'.
    * width (integer) {optional} - The width of the texture the HTML will be rendered to.
    * height (integer) {optional} - The height of the texture the HTML will be rendered to.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.htmlTexture loader-plugin
                  (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.htmlTexture loader-plugin
                  (clj->phaser key)
                  (clj->phaser url))))
  ([loader-plugin key url width]
   (phaser->clj
    (.htmlTexture loader-plugin
                  (clj->phaser key)
                  (clj->phaser url)
                  (clj->phaser width))))
  ([loader-plugin key url width height]
   (phaser->clj
    (.htmlTexture loader-plugin
                  (clj->phaser key)
                  (clj->phaser url)
                  (clj->phaser width)
                  (clj->phaser height))))
  ([loader-plugin key url width height xhr-settings]
   (phaser->clj
    (.htmlTexture loader-plugin
                  (clj->phaser key)
                  (clj->phaser url)
                  (clj->phaser width)
                  (clj->phaser height)
                  (clj->phaser xhr-settings)))))

(defn image
  "Adds an Image, or array of Images, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.image('logo', 'images/phaserLogo.png');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  Phaser can load all common image types: png, jpg, gif and any other format the browser can natively handle.
  If you try to load an animated gif only the first frame will be rendered. Browsers do not natively support playback
  of animated gifs to Canvas elements.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.image({
      key: 'logo',
      url: 'images/AtariLogo.png'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.ImageFileConfig` for more details.

  Once the file has finished loading you can use it as a texture for a Game Object by referencing its key:

  ```javascript
  this.load.image('logo', 'images/AtariLogo.png');
  // and later in your game ...
  this.add.image(x, y, 'logo');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.png'. It will always add `.png` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Phaser also supports the automatic loading of associated normal maps. If you have a normal map to go with this image,
  then you can specify it by providing an array as the `url` where the second element is the normal map:

  ```javascript
  this.load.image('logo', [ 'images/AtariLogo.png', 'images/AtariLogo-n.png' ]);
  ```

  Or, if you are using a config object use the `normalMap` property:

  ```javascript
  this.load.image({
      key: 'logo',
      url: 'images/AtariLogo.png',
      normalMap: 'images/AtariLogo-n.png'
  });
  ```

  The normal map file is subject to the same conditions as the image file with regard to the path, baseURL, CORs and XHR Settings.
  Normal maps are a WebGL only feature.

  Note: The ability to load this type of file will only be available if the Image File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.ImageFileConfig | Array.<Phaser.Types.Loader.FileTypes.ImageFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string | Array.<string>) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.image loader-plugin
            (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.image loader-plugin
            (clj->phaser key)
            (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.image loader-plugin
            (clj->phaser key)
            (clj->phaser url)
            (clj->phaser xhr-settings)))))

(defn is-loading
  "Is the Loader actively loading, or processing loaded files?

  Returns:  boolean - `true` if the Loader is busy loading or processing, otherwise `false`."
  ([loader-plugin]
   (phaser->clj
    (.isLoading loader-plugin))))

(defn is-ready
  "Is the Loader ready to start a new load?

  Returns:  boolean - `true` if the Loader is ready to start a new load, otherwise `false`."
  ([loader-plugin]
   (phaser->clj
    (.isReady loader-plugin))))

(defn json
  "Adds a JSON file, or array of JSON files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.json('wavedata', 'files/AlienWaveData.json');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global JSON Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the JSON Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the JSON Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.json({
      key: 'wavedata',
      url: 'files/AlienWaveData.json'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.JSONFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.json('wavedata', 'files/AlienWaveData.json');
  // and later in your game ...
  var data = this.cache.json.get('wavedata');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Waves` the final key will be `LEVEL1.Waves` and
  this is what you would use to retrieve the text from the JSON Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'data'
  and no URL is given then the Loader will set the URL to be 'data.json'. It will always add `.json` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  You can also optionally provide a `dataKey` to use. This allows you to extract only a part of the JSON and store it in the Cache,
  rather than the whole file. For example, if your JSON data had a structure like this:

  ```json
  {
      'level1': {
          'baddies': {
              'aliens': {},
              'boss': {}
          }
      },
      'level2': {},
      'level3': {}
  }
  ```

  And you only wanted to store the `boss` data in the Cache, then you could pass `level1.baddies.boss`as the `dataKey`.

  Note: The ability to load this type of file will only be available if the JSON File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.JSONFileConfig | Array.<Phaser.Types.Loader.FileTypes.JSONFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * data-key (string) {optional} - When the JSON file loads only this property will be stored in the Cache.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.json loader-plugin
           (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.json loader-plugin
           (clj->phaser key)
           (clj->phaser url))))
  ([loader-plugin key url data-key]
   (phaser->clj
    (.json loader-plugin
           (clj->phaser key)
           (clj->phaser url)
           (clj->phaser data-key))))
  ([loader-plugin key url data-key xhr-settings]
   (phaser->clj
    (.json loader-plugin
           (clj->phaser key)
           (clj->phaser url)
           (clj->phaser data-key)
           (clj->phaser xhr-settings)))))

(defn key-exists
  "Checks the key and type of the given file to see if it will conflict with anything already
  in a Cache, the Texture Manager, or the list or inflight queues.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * file (Phaser.Loader.File) - The file to check the key of.

  Returns:  boolean - `true` if adding this file will cause a cache or queue conflict, otherwise `false`."
  ([loader-plugin file]
   (phaser->clj
    (.keyExists loader-plugin
                (clj->phaser file)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([loader-plugin event]
   (phaser->clj
    (.listenerCount loader-plugin
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([loader-plugin event]
   (phaser->clj
    (.listeners loader-plugin
                (clj->phaser event)))))

(defn load-complete
  "Called at the end when the load queue is exhausted and all files have either loaded or errored.
  By this point every loaded file will now be in its associated cache and ready for use.

  Also clears down the Sets, puts progress to 1 and clears the deletion queue."
  ([loader-plugin]
   (phaser->clj
    (.loadComplete loader-plugin))))

(defn multiatlas
  "Adds a Multi Texture Atlas, or array of multi atlases, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.multiatlas('level1', 'images/Level1.json');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  If you call this from outside of `preload` then you are responsible for starting the Loader afterwards and monitoring
  its events to know when it's safe to use the asset. Please see the Phaser.Loader.LoaderPlugin class for more details.

  Phaser expects the atlas data to be provided in a JSON file as exported from the application Texture Packer,
  version 4.6.3 or above, where you have made sure to use the Phaser 3 Export option.

  The way it works internally is that you provide a URL to the JSON file. Phaser then loads this JSON, parses it and
  extracts which texture files it also needs to load to complete the process. If the JSON also defines normal maps,
  Phaser will load those as well.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.multiatlas({
      key: 'level1',
      atlasURL: 'images/Level1.json'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.MultiAtlasFileConfig` for more details.

  Instead of passing a URL for the atlas JSON data you can also pass in a well formed JSON object instead.

  Once the atlas has finished loading you can use frames from it as textures for a Game Object by referencing its key:

  ```javascript
  this.load.multiatlas('level1', 'images/Level1.json');
  // and later in your game ...
  this.add.image(x, y, 'level1', 'background');
  ```

  To get a list of all available frames within an atlas please consult your Texture Atlas software.

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.png'. It will always add `.png` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Multi Atlas File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.MultiAtlasFileConfig | Array.<Phaser.Types.Loader.FileTypes.MultiAtlasFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * atlas-url (string) {optional} - The absolute or relative URL to load the texture atlas json data file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * path (string) {optional} - Optional path to use when loading the textures defined in the atlas data.
    * base-url (string) {optional} - Optional Base URL to use when loading the textures defined in the atlas data.
    * atlas-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas json file. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.multiatlas loader-plugin
                 (clj->phaser key))))
  ([loader-plugin key atlas-url]
   (phaser->clj
    (.multiatlas loader-plugin
                 (clj->phaser key)
                 (clj->phaser atlas-url))))
  ([loader-plugin key atlas-url path]
   (phaser->clj
    (.multiatlas loader-plugin
                 (clj->phaser key)
                 (clj->phaser atlas-url)
                 (clj->phaser path))))
  ([loader-plugin key atlas-url path base-url]
   (phaser->clj
    (.multiatlas loader-plugin
                 (clj->phaser key)
                 (clj->phaser atlas-url)
                 (clj->phaser path)
                 (clj->phaser base-url))))
  ([loader-plugin key atlas-url path base-url atlas-xhr-settings]
   (phaser->clj
    (.multiatlas loader-plugin
                 (clj->phaser key)
                 (clj->phaser atlas-url)
                 (clj->phaser path)
                 (clj->phaser base-url)
                 (clj->phaser atlas-xhr-settings)))))

(defn next-file
  "An internal method called automatically by the XHRLoader belong to a File.

  This method will remove the given file from the inflight Set and update the load progress.
  If the file was successful its `onProcess` method is called, otherwise it is added to the delete queue.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * file (Phaser.Loader.File) - The File that just finished loading, or errored during load.
    * success (boolean) - `true` if the file loaded successfully, otherwise `false`."
  ([loader-plugin file success]
   (phaser->clj
    (.nextFile loader-plugin
               (clj->phaser file)
               (clj->phaser success)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([loader-plugin event]
   (phaser->clj
    (.off loader-plugin
          (clj->phaser event))))
  ([loader-plugin event fn]
   (phaser->clj
    (.off loader-plugin
          (clj->phaser event)
          (clj->phaser fn))))
  ([loader-plugin event fn context]
   (phaser->clj
    (.off loader-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([loader-plugin event fn context once]
   (phaser->clj
    (.off loader-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([loader-plugin event fn]
   (phaser->clj
    (.on loader-plugin
         (clj->phaser event)
         (clj->phaser fn))))
  ([loader-plugin event fn context]
   (phaser->clj
    (.on loader-plugin
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([loader-plugin event fn]
   (phaser->clj
    (.once loader-plugin
           (clj->phaser event)
           (clj->phaser fn))))
  ([loader-plugin event fn context]
   (phaser->clj
    (.once loader-plugin
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn pack
  "Adds a JSON File Pack, or array of packs, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.pack('level1', 'data/Level1Files.json');
  }
  ```

  A File Pack is a JSON file (or object) that contains details about other files that should be added into the Loader.
  Here is a small example:

  ```json
  { 
     'test1': {
         'files': [
             {
                 'type': 'image',
                 'key': 'taikodrummaster',
                 'url': 'assets/pics/taikodrummaster.jpg'
             },
             {
                 'type': 'image',
                 'key': 'sukasuka-chtholly',
                 'url': 'assets/pics/sukasuka-chtholly.png'
             }
         ]
     },
     'meta': {
         'generated': '1401380327373',
         'app': 'Phaser 3 Asset Packer',
         'url': 'https://phaser.io',
         'version': '1.0',
         'copyright': 'Photon Storm Ltd. 2018'
     }
  }
  ```

  The pack can be split into sections. In the example above you'll see a section called `test1. You can tell
  the `load.pack` method to parse only a particular section of a pack. The pack is stored in the JSON Cache,
  so you can pass it to the Loader to process additional sections as needed in your game, or you can just load
  them all at once without specifying anything.

  The pack file can contain an entry for any type of file that Phaser can load. The object structures exactly
  match that of the file type configs, and all properties available within the file type configs can be used
  in the pack file too.

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  If you call this from outside of `preload` then you are responsible for starting the Loader afterwards and monitoring
  its events to know when it's safe to use the asset. Please see the Phaser.Loader.LoaderPlugin class for more details.

  The key must be a unique String. It is used to add the file to the global JSON Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the JSON Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the JSON Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.pack({
      key: 'level1',
      url: 'data/Level1Files.json'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.PackFileConfig` for more details.

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Waves` the final key will be `LEVEL1.Waves` and
  this is what you would use to retrieve the text from the JSON Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'data'
  and no URL is given then the Loader will set the URL to be 'data.json'. It will always add `.json` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  You can also optionally provide a `dataKey` to use. This allows you to extract only a part of the JSON and store it in the Cache,
  rather than the whole file. For example, if your JSON data had a structure like this:

  ```json
  {
      'level1': {
          'baddies': {
              'aliens': {},
              'boss': {}
          }
      },
      'level2': {},
      'level3': {}
  }
  ```

  And you only wanted to store the `boss` data in the Cache, then you could pass `level1.baddies.boss`as the `dataKey`.

  Note: The ability to load this type of file will only be available if the Pack File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.PackFileConfig | Array.<Phaser.Types.Loader.FileTypes.PackFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * data-key (string) {optional} - When the JSON file loads only this property will be stored in the Cache.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.pack loader-plugin
           (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.pack loader-plugin
           (clj->phaser key)
           (clj->phaser url))))
  ([loader-plugin key url data-key]
   (phaser->clj
    (.pack loader-plugin
           (clj->phaser key)
           (clj->phaser url)
           (clj->phaser data-key))))
  ([loader-plugin key url data-key xhr-settings]
   (phaser->clj
    (.pack loader-plugin
           (clj->phaser key)
           (clj->phaser url)
           (clj->phaser data-key)
           (clj->phaser xhr-settings)))))

(defn plugin
  "Adds a Plugin Script file, or array of plugin files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.plugin('modplayer', 'plugins/ModPlayer.js');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String and not already in-use by another file in the Loader.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.plugin({
      key: 'modplayer',
      url: 'plugins/ModPlayer.js'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.PluginFileConfig` for more details.

  Once the file has finished loading it will automatically be converted into a script element
  via `document.createElement('script')`. It will have its language set to JavaScript, `defer` set to
  false and then the resulting element will be appended to `document.head`. Any code then in the
  script will be executed. It will then be passed to the Phaser PluginCache.register method.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.js'. It will always add `.js` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Plugin File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.PluginFileConfig | Array.<Phaser.Types.Loader.FileTypes.PluginFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string | function) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.js`, i.e. if `key` was 'alien' then the URL will be 'alien.js'. Or, a plugin function.
    * start (boolean) {optional} - Automatically start the plugin after loading?
    * mapping (string) {optional} - If this plugin is to be injected into the Scene, this is the property key used.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.plugin loader-plugin
             (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.plugin loader-plugin
             (clj->phaser key)
             (clj->phaser url))))
  ([loader-plugin key url start]
   (phaser->clj
    (.plugin loader-plugin
             (clj->phaser key)
             (clj->phaser url)
             (clj->phaser start))))
  ([loader-plugin key url start mapping]
   (phaser->clj
    (.plugin loader-plugin
             (clj->phaser key)
             (clj->phaser url)
             (clj->phaser start)
             (clj->phaser mapping))))
  ([loader-plugin key url start mapping xhr-settings]
   (phaser->clj
    (.plugin loader-plugin
             (clj->phaser key)
             (clj->phaser url)
             (clj->phaser start)
             (clj->phaser mapping)
             (clj->phaser xhr-settings)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([loader-plugin]
   (phaser->clj
    (.removeAllListeners loader-plugin)))
  ([loader-plugin event]
   (phaser->clj
    (.removeAllListeners loader-plugin
                         (clj->phaser event)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([loader-plugin event]
   (phaser->clj
    (.removeListener loader-plugin
                     (clj->phaser event))))
  ([loader-plugin event fn]
   (phaser->clj
    (.removeListener loader-plugin
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([loader-plugin event fn context]
   (phaser->clj
    (.removeListener loader-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([loader-plugin event fn context once]
   (phaser->clj
    (.removeListener loader-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset
  "Resets the Loader.

  This will clear all lists and reset the base URL, path and prefix.

  Warning: If the Loader is currently downloading files, or has files in its queue, they will be aborted."
  ([loader-plugin]
   (phaser->clj
    (.reset loader-plugin))))

(defn save
  "Causes the browser to save the given data as a file to its default Downloads folder.

  Creates a DOM level anchor link, assigns it as being a `download` anchor, sets the href
  to be an ObjectURL based on the given data, and then invokes a click event.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * data (*) - The data to be saved. Will be passed through URL.createObjectURL.
    * filename (string) {optional} - The filename to save the file as.
    * filetype (string) {optional} - The file type to use when saving the file. Defaults to JSON.

  Returns:  Phaser.Loader.LoaderPlugin - This Loader plugin."
  ([loader-plugin data]
   (phaser->clj
    (.save loader-plugin
           (clj->phaser data))))
  ([loader-plugin data filename]
   (phaser->clj
    (.save loader-plugin
           (clj->phaser data)
           (clj->phaser filename))))
  ([loader-plugin data filename filetype]
   (phaser->clj
    (.save loader-plugin
           (clj->phaser data)
           (clj->phaser filename)
           (clj->phaser filetype)))))

(defn save-json
  "Converts the given JSON data into a file that the browser then prompts you to download so you can save it locally.

  The data must be well formed JSON and ready-parsed, not a JavaScript object.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * data (*) - The JSON data, ready parsed.
    * filename (string) {optional} - The name to save the JSON file as.

  Returns:  Phaser.Loader.LoaderPlugin - This Loader plugin."
  ([loader-plugin data]
   (phaser->clj
    (.saveJSON loader-plugin
               (clj->phaser data))))
  ([loader-plugin data filename]
   (phaser->clj
    (.saveJSON loader-plugin
               (clj->phaser data)
               (clj->phaser filename)))))

(defn scene-file
  "Adds an external Scene file, or array of Scene files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.sceneFile('Level1', 'src/Level1.js');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Scene Manager upon a successful load.

  For a Scene File it's vitally important that the key matches the class name in the JavaScript file.

  For example here is the source file:

  ```javascript
  class ExternalScene extends Phaser.Scene {

      constructor ()
      {
          super('myScene');
      }

  }
  ```

  Because the class is called `ExternalScene` that is the exact same key you must use when loading it:

  ```javascript
  function preload ()
  {
      this.load.sceneFile('ExternalScene', 'src/yourScene.js');
  }
  ```

  The key that is used within the Scene Manager can either be set to the same, or you can override it in the Scene
  constructor, as we've done in the example above, where the Scene key was changed to `myScene`.

  The key should be unique both in terms of files being loaded and Scenes already present in the Scene Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Scene Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.sceneFile({
      key: 'Level1',
      url: 'src/Level1.js'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.SceneFileConfig` for more details.

  Once the file has finished loading it will be added to the Scene Manager.

  ```javascript
  this.load.sceneFile('Level1', 'src/Level1.js');
  // and later in your game ...
  this.scene.start('Level1');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `WORLD1.` and the key was `Story` the final key will be `WORLD1.Story` and
  this is what you would use to retrieve the text from the Scene Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'story'
  and no URL is given then the Loader will set the URL to be 'story.js'. It will always add `.js` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Scene File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.SceneFileConfig | Array.<Phaser.Types.Loader.FileTypes.SceneFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.js`, i.e. if `key` was 'alien' then the URL will be 'alien.js'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.sceneFile loader-plugin
                (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.sceneFile loader-plugin
                (clj->phaser key)
                (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.sceneFile loader-plugin
                (clj->phaser key)
                (clj->phaser url)
                (clj->phaser xhr-settings)))))

(defn scene-plugin
  "Adds a Scene Plugin Script file, or array of plugin files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.scenePlugin('ModPlayer', 'plugins/ModPlayer.js', 'modPlayer', 'mods');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String and not already in-use by another file in the Loader.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.scenePlugin({
      key: 'modplayer',
      url: 'plugins/ModPlayer.js'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.ScenePluginFileConfig` for more details.

  Once the file has finished loading it will automatically be converted into a script element
  via `document.createElement('script')`. It will have its language set to JavaScript, `defer` set to
  false and then the resulting element will be appended to `document.head`. Any code then in the
  script will be executed. It will then be passed to the Phaser PluginCache.register method.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.js'. It will always add `.js` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Script File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.ScenePluginFileConfig | Array.<Phaser.Types.Loader.FileTypes.ScenePluginFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string | function) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.js`, i.e. if `key` was 'alien' then the URL will be 'alien.js'. Or, set to a plugin function.
    * system-key (string) {optional} - If this plugin is to be added to Scene.Systems, this is the property key for it.
    * scene-key (string) {optional} - If this plugin is to be added to the Scene, this is the property key for it.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.scenePlugin loader-plugin
                  (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.scenePlugin loader-plugin
                  (clj->phaser key)
                  (clj->phaser url))))
  ([loader-plugin key url system-key]
   (phaser->clj
    (.scenePlugin loader-plugin
                  (clj->phaser key)
                  (clj->phaser url)
                  (clj->phaser system-key))))
  ([loader-plugin key url system-key scene-key]
   (phaser->clj
    (.scenePlugin loader-plugin
                  (clj->phaser key)
                  (clj->phaser url)
                  (clj->phaser system-key)
                  (clj->phaser scene-key))))
  ([loader-plugin key url system-key scene-key xhr-settings]
   (phaser->clj
    (.scenePlugin loader-plugin
                  (clj->phaser key)
                  (clj->phaser url)
                  (clj->phaser system-key)
                  (clj->phaser scene-key)
                  (clj->phaser xhr-settings)))))

(defn script
  "Adds a Script file, or array of Script files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.script('aliens', 'lib/aliens.js');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String and not already in-use by another file in the Loader.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.script({
      key: 'aliens',
      url: 'lib/aliens.js'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.ScriptFileConfig` for more details.

  Once the file has finished loading it will automatically be converted into a script element
  via `document.createElement('script')`. It will have its language set to JavaScript, `defer` set to
  false and then the resulting element will be appended to `document.head`. Any code then in the
  script will be executed.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.js'. It will always add `.js` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Script File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.ScriptFileConfig | Array.<Phaser.Types.Loader.FileTypes.ScriptFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.js`, i.e. if `key` was 'alien' then the URL will be 'alien.js'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.script loader-plugin
             (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.script loader-plugin
             (clj->phaser key)
             (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.script loader-plugin
             (clj->phaser key)
             (clj->phaser url)
             (clj->phaser xhr-settings)))))

(defn scripts
  "Adds an array of Script files to the current load queue.

  The difference between this and the `ScriptFile` file type is that you give an array of scripts to this method,
  and the scripts are then processed _exactly_ in that order. This allows you to load a bunch of scripts that
  may have dependancies on each other without worrying about the async nature of traditional script loading.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.scripts('PostProcess', [
          'libs/shaders/CopyShader.js',
          'libs/postprocessing/EffectComposer.js',
          'libs/postprocessing/RenderPass.js',
          'libs/postprocessing/MaskPass.js',
          'libs/postprocessing/ShaderPass.js',
          'libs/postprocessing/AfterimagePass.js'
     ]);
  }
  ```

  In the code above the script files will all be loaded in parallel but only processed (i.e. invoked) in the exact
  order given in the array.

  The files are **not** loaded right away. They are added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the files are queued
  it means you cannot use the files immediately after calling this method, but must wait for the files to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String and not already in-use by another file in the Loader.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.scripts({
      key: 'PostProcess',
      url: [
          'libs/shaders/CopyShader.js',
          'libs/postprocessing/EffectComposer.js',
          'libs/postprocessing/RenderPass.js',
          'libs/postprocessing/MaskPass.js',
          'libs/postprocessing/ShaderPass.js',
          'libs/postprocessing/AfterimagePass.js'
         ]
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.MultiScriptFileConfig` for more details.

  Once all the files have finished loading they will automatically be converted into a script element
  via `document.createElement('script')`. They will have their language set to JavaScript, `defer` set to
  false and then the resulting element will be appended to `document.head`. Any code then in the
  script will be executed. This is done in the exact order the files are specified in the url array.

  The URLs can be relative or absolute. If the URLs are relative the `Loader.baseURL` and `Loader.path` values will be prepended to them.

  Note: The ability to load this type of file will only be available if the MultiScript File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.MultiScriptFileConfig | Array.<Phaser.Types.Loader.FileTypes.MultiScriptFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (Array.<string>) {optional} - An array of absolute or relative URLs to load the script files from. They are processed in the order given in the array.
    * extension (string) {optional} - The default file extension to use if no url is provided.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - Extra XHR Settings specifically for these files.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.scripts loader-plugin
              (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.scripts loader-plugin
              (clj->phaser key)
              (clj->phaser url))))
  ([loader-plugin key url extension]
   (phaser->clj
    (.scripts loader-plugin
              (clj->phaser key)
              (clj->phaser url)
              (clj->phaser extension))))
  ([loader-plugin key url extension xhr-settings]
   (phaser->clj
    (.scripts loader-plugin
              (clj->phaser key)
              (clj->phaser url)
              (clj->phaser extension)
              (clj->phaser xhr-settings)))))

(defn set-base-url
  "If you want to append a URL before the path of any asset you can set this here.

  Useful if allowing the asset base url to be configured outside of the game code.

  Once a base URL is set it will affect every file loaded by the Loader from that point on. It does _not_ change any
  file _already_ being loaded. To reset it, call this method with no arguments.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * url (string) {optional} - The URL to use. Leave empty to reset.

  Returns:  Phaser.Loader.LoaderPlugin - This Loader object."
  ([loader-plugin]
   (phaser->clj
    (.setBaseURL loader-plugin)))
  ([loader-plugin url]
   (phaser->clj
    (.setBaseURL loader-plugin
                 (clj->phaser url)))))

(defn set-cors
  "Sets the Cross Origin Resource Sharing value used when loading files.

  Files can override this value on a per-file basis by specifying an alternative `crossOrigin` value in their file config.

  Once CORs is set it will then affect every file loaded by the Loader from that point on, as long as they don't have
  their own CORs setting. To reset it, call this method with no arguments.

  For more details about CORs see https://developer.mozilla.org/en-US/docs/Web/HTTP/CORS

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * cross-origin (string) {optional} - The value to use for the `crossOrigin` property in the load request.

  Returns:  Phaser.Loader.LoaderPlugin - This Loader object."
  ([loader-plugin]
   (phaser->clj
    (.setCORS loader-plugin)))
  ([loader-plugin cross-origin]
   (phaser->clj
    (.setCORS loader-plugin
              (clj->phaser cross-origin)))))

(defn set-path
  "The value of `path`, if set, is placed before any _relative_ file path given. For example:

  ```javascript
  this.load.setPath('images/sprites/');
  this.load.image('ball', 'ball.png');
  this.load.image('tree', 'level1/oaktree.png');
  this.load.image('boom', 'http://server.com/explode.png');
  ```

  Would load the `ball` file from `images/sprites/ball.png` and the tree from
  `images/sprites/level1/oaktree.png` but the file `boom` would load from the URL
  given as it's an absolute URL.

  Please note that the path is added before the filename but *after* the baseURL (if set.)

  Once a path is set it will then affect every file added to the Loader from that point on. It does _not_ change any
  file _already_ in the load queue. To reset it, call this method with no arguments.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * path (string) {optional} - The path to use. Leave empty to reset.

  Returns:  Phaser.Loader.LoaderPlugin - This Loader object."
  ([loader-plugin]
   (phaser->clj
    (.setPath loader-plugin)))
  ([loader-plugin path]
   (phaser->clj
    (.setPath loader-plugin
              (clj->phaser path)))))

(defn set-prefix
  "An optional prefix that is automatically prepended to the start of every file key.

  If prefix was `MENU.` and you load an image with the key 'Background' the resulting key would be `MENU.Background`.

  Once a prefix is set it will then affect every file added to the Loader from that point on. It does _not_ change any
  file _already_ in the load queue. To reset it, call this method with no arguments.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * prefix (string) {optional} - The prefix to use. Leave empty to reset.

  Returns:  Phaser.Loader.LoaderPlugin - This Loader object."
  ([loader-plugin]
   (phaser->clj
    (.setPrefix loader-plugin)))
  ([loader-plugin prefix]
   (phaser->clj
    (.setPrefix loader-plugin
                (clj->phaser prefix)))))

(defn spritesheet
  "Adds a Sprite Sheet Image, or array of Sprite Sheet Images, to the current load queue.

  The term 'Sprite Sheet' in Phaser means a fixed-size sheet. Where every frame in the sheet is the exact same size,
  and you reference those frames using numbers, not frame names. This is not the same thing as a Texture Atlas, where
  the frames are packed in a way where they take up the least amount of space, and are referenced by their names,
  not numbers. Some articles and software use the term 'Sprite Sheet' to mean Texture Atlas, so please be aware of
  what sort of file you're actually trying to load.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.spritesheet('bot', 'images/robot.png', { frameWidth: 32, frameHeight: 38 });
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  Phaser can load all common image types: png, jpg, gif and any other format the browser can natively handle.
  If you try to load an animated gif only the first frame will be rendered. Browsers do not natively support playback
  of animated gifs to Canvas elements.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.spritesheet({
      key: 'bot',
      url: 'images/robot.png',
      frameConfig: {
          frameWidth: 32,
          frameHeight: 38,
          startFrame: 0,
          endFrame: 8
      }
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.SpriteSheetFileConfig` for more details.

  Once the file has finished loading you can use it as a texture for a Game Object by referencing its key:

  ```javascript
  this.load.spritesheet('bot', 'images/robot.png', { frameWidth: 32, frameHeight: 38 });
  // and later in your game ...
  this.add.image(x, y, 'bot', 0);
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `PLAYER.` and the key was `Running` the final key will be `PLAYER.Running` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.png'. It will always add `.png` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Phaser also supports the automatic loading of associated normal maps. If you have a normal map to go with this image,
  then you can specify it by providing an array as the `url` where the second element is the normal map:

  ```javascript
  this.load.spritesheet('logo', [ 'images/AtariLogo.png', 'images/AtariLogo-n.png' ], { frameWidth: 256, frameHeight: 80 });
  ```

  Or, if you are using a config object use the `normalMap` property:

  ```javascript
  this.load.spritesheet({
      key: 'logo',
      url: 'images/AtariLogo.png',
      normalMap: 'images/AtariLogo-n.png',
      frameConfig: {
          frameWidth: 256,
          frameHeight: 80
      }
  });
  ```

  The normal map file is subject to the same conditions as the image file with regard to the path, baseURL, CORs and XHR Settings.
  Normal maps are a WebGL only feature.

  Note: The ability to load this type of file will only be available if the Sprite Sheet File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.SpriteSheetFileConfig | Array.<Phaser.Types.Loader.FileTypes.SpriteSheetFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * frame-config (Phaser.Types.Loader.FileTypes.ImageFrameConfig) {optional} - The frame configuration object. At a minimum it should have a `frameWidth` property.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.spritesheet loader-plugin
                  (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.spritesheet loader-plugin
                  (clj->phaser key)
                  (clj->phaser url))))
  ([loader-plugin key url frame-config]
   (phaser->clj
    (.spritesheet loader-plugin
                  (clj->phaser key)
                  (clj->phaser url)
                  (clj->phaser frame-config))))
  ([loader-plugin key url frame-config xhr-settings]
   (phaser->clj
    (.spritesheet loader-plugin
                  (clj->phaser key)
                  (clj->phaser url)
                  (clj->phaser frame-config)
                  (clj->phaser xhr-settings)))))

(defn start
  "Starts the Loader running. This will reset the progress and totals and then emit a `start` event.
  If there is nothing in the queue the Loader will immediately complete, otherwise it will start
  loading the first batch of files.

  The Loader is started automatically if the queue is populated within your Scenes `preload` method.

  However, outside of this, you need to call this method to start it.

  If the Loader is already running this method will simply return."
  ([loader-plugin]
   (phaser->clj
    (.start loader-plugin))))

(defn svg
  "Adds an SVG File, or array of SVG Files, to the current load queue. When the files are loaded they
  will be rendered to bitmap textures and stored in the Texture Manager.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.svg('morty', 'images/Morty.svg');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.svg({
      key: 'morty',
      url: 'images/Morty.svg'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.SVGFileConfig` for more details.

  Once the file has finished loading you can use it as a texture for a Game Object by referencing its key:

  ```javascript
  this.load.svg('morty', 'images/Morty.svg');
  // and later in your game ...
  this.add.image(x, y, 'morty');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.html'. It will always add `.html` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  You can optionally pass an SVG Resize Configuration object when you load an SVG file. By default the SVG will be rendered to a texture
  at the same size defined in the SVG file attributes. However, this isn't always desirable. You may wish to resize the SVG (either down
  or up) to improve texture clarity, or reduce texture memory consumption. You can either specify an exact width and height to resize
  the SVG to:

  ```javascript
  function preload ()
  {
      this.load.svg('morty', 'images/Morty.svg', { width: 300, height: 600 });
  }
  ```

  Or when using a configuration object:

  ```javascript
  this.load.svg({
      key: 'morty',
      url: 'images/Morty.svg',
      svgConfig: {
          width: 300,
          height: 600
      }
  });
  ```

  Alternatively, you can just provide a scale factor instead:

  ```javascript
  function preload ()
  {
      this.load.svg('morty', 'images/Morty.svg', { scale: 2.5 });
  }
  ```

  Or when using a configuration object:

  ```javascript
  this.load.svg({
      key: 'morty',
      url: 'images/Morty.svg',
      svgConfig: {
          scale: 2.5
      }
  });
  ```

  If scale, width and height values are all given, the scale has priority and the width and height values are ignored.

  Note: The ability to load this type of file will only be available if the SVG File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.SVGFileConfig | Array.<Phaser.Types.Loader.FileTypes.SVGFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.svg`, i.e. if `key` was 'alien' then the URL will be 'alien.svg'.
    * svg-config (Phaser.Types.Loader.FileTypes.SVGSizeConfig) {optional} - The svg size configuration object.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.svg loader-plugin
          (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.svg loader-plugin
          (clj->phaser key)
          (clj->phaser url))))
  ([loader-plugin key url svg-config]
   (phaser->clj
    (.svg loader-plugin
          (clj->phaser key)
          (clj->phaser url)
          (clj->phaser svg-config))))
  ([loader-plugin key url svg-config xhr-settings]
   (phaser->clj
    (.svg loader-plugin
          (clj->phaser key)
          (clj->phaser url)
          (clj->phaser svg-config)
          (clj->phaser xhr-settings)))))

(defn text
  "Adds a Text file, or array of Text files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.text('story', 'files/IntroStory.txt');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Text Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Text Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Text Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.text({
      key: 'story',
      url: 'files/IntroStory.txt'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.TextFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.text('story', 'files/IntroStory.txt');
  // and later in your game ...
  var data = this.cache.text.get('story');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Story` the final key will be `LEVEL1.Story` and
  this is what you would use to retrieve the text from the Text Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'story'
  and no URL is given then the Loader will set the URL to be 'story.txt'. It will always add `.txt` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Text File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.TextFileConfig | Array.<Phaser.Types.Loader.FileTypes.TextFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.txt`, i.e. if `key` was 'alien' then the URL will be 'alien.txt'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.text loader-plugin
           (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.text loader-plugin
           (clj->phaser key)
           (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.text loader-plugin
           (clj->phaser key)
           (clj->phaser url)
           (clj->phaser xhr-settings)))))

(defn tilemap-csv
  "Adds a CSV Tilemap file, or array of CSV files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.tilemapCSV('level1', 'maps/Level1.csv');
  }
  ```

  Tilemap CSV data can be created in a text editor, or a 3rd party app that exports as CSV.

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Tilemap Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Tilemap Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Text Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.tilemapCSV({
      key: 'level1',
      url: 'maps/Level1.csv'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.TilemapCSVFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.tilemapCSV('level1', 'maps/Level1.csv');
  // and later in your game ...
  var map = this.make.tilemap({ key: 'level1' });
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Story` the final key will be `LEVEL1.Story` and
  this is what you would use to retrieve the text from the Tilemap Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'level'
  and no URL is given then the Loader will set the URL to be 'level.csv'. It will always add `.csv` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Tilemap CSV File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.TilemapCSVFileConfig | Array.<Phaser.Types.Loader.FileTypes.TilemapCSVFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.csv`, i.e. if `key` was 'alien' then the URL will be 'alien.csv'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.tilemapCSV loader-plugin
                 (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.tilemapCSV loader-plugin
                 (clj->phaser key)
                 (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.tilemapCSV loader-plugin
                 (clj->phaser key)
                 (clj->phaser url)
                 (clj->phaser xhr-settings)))))

(defn tilemap-impact
  "Adds an Impact.js Tilemap file, or array of map files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.tilemapImpact('level1', 'maps/Level1.json');
  }
  ```

  Impact Tilemap data is created the Impact.js Map Editor called Weltmeister.

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Tilemap Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Tilemap Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Text Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.tilemapImpact({
      key: 'level1',
      url: 'maps/Level1.json'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.TilemapImpactFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.tilemapImpact('level1', 'maps/Level1.json');
  // and later in your game ...
  var map = this.make.tilemap({ key: 'level1' });
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Story` the final key will be `LEVEL1.Story` and
  this is what you would use to retrieve the text from the Tilemap Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'level'
  and no URL is given then the Loader will set the URL to be 'level.json'. It will always add `.json` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Tilemap Impact File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.TilemapImpactFileConfig | Array.<Phaser.Types.Loader.FileTypes.TilemapImpactFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.tilemapImpact loader-plugin
                    (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.tilemapImpact loader-plugin
                    (clj->phaser key)
                    (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.tilemapImpact loader-plugin
                    (clj->phaser key)
                    (clj->phaser url)
                    (clj->phaser xhr-settings)))))

(defn tilemap-tiled-json
  "Adds a Tiled JSON Tilemap file, or array of map files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.tilemapTiledJSON('level1', 'maps/Level1.json');
  }
  ```

  The Tilemap data is created using the Tiled Map Editor and selecting JSON as the export format.

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Tilemap Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Tilemap Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Text Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.tilemapTiledJSON({
      key: 'level1',
      url: 'maps/Level1.json'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.TilemapJSONFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.tilemapTiledJSON('level1', 'maps/Level1.json');
  // and later in your game ...
  var map = this.make.tilemap({ key: 'level1' });
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Story` the final key will be `LEVEL1.Story` and
  this is what you would use to retrieve the text from the Tilemap Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'level'
  and no URL is given then the Loader will set the URL to be 'level.json'. It will always add `.json` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the Tilemap JSON File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.TilemapJSONFileConfig | Array.<Phaser.Types.Loader.FileTypes.TilemapJSONFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.json`, i.e. if `key` was 'alien' then the URL will be 'alien.json'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.tilemapTiledJSON loader-plugin
                       (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.tilemapTiledJSON loader-plugin
                       (clj->phaser key)
                       (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.tilemapTiledJSON loader-plugin
                       (clj->phaser key)
                       (clj->phaser url)
                       (clj->phaser xhr-settings)))))

(defn unity-atlas
  "Adds a Unity YAML based Texture Atlas, or array of atlases, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.unityAtlas('mainmenu', 'images/MainMenu.png', 'images/MainMenu.txt');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  If you call this from outside of `preload` then you are responsible for starting the Loader afterwards and monitoring
  its events to know when it's safe to use the asset. Please see the Phaser.Loader.LoaderPlugin class for more details.

  Phaser expects the atlas data to be provided in a YAML formatted text file as exported from Unity.

  Phaser can load all common image types: png, jpg, gif and any other format the browser can natively handle.

  The key must be a unique String. It is used to add the file to the global Texture Manager upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Texture Manager.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Texture Manager first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.unityAtlas({
      key: 'mainmenu',
      textureURL: 'images/MainMenu.png',
      atlasURL: 'images/MainMenu.txt'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.UnityAtlasFileConfig` for more details.

  Once the atlas has finished loading you can use frames from it as textures for a Game Object by referencing its key:

  ```javascript
  this.load.unityAtlas('mainmenu', 'images/MainMenu.png', 'images/MainMenu.json');
  // and later in your game ...
  this.add.image(x, y, 'mainmenu', 'background');
  ```

  To get a list of all available frames within an atlas please consult your Texture Atlas software.

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `MENU.` and the key was `Background` the final key will be `MENU.Background` and
  this is what you would use to retrieve the image from the Texture Manager.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'alien'
  and no URL is given then the Loader will set the URL to be 'alien.png'. It will always add `.png` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Phaser also supports the automatic loading of associated normal maps. If you have a normal map to go with this image,
  then you can specify it by providing an array as the `url` where the second element is the normal map:

  ```javascript
  this.load.unityAtlas('mainmenu', [ 'images/MainMenu.png', 'images/MainMenu-n.png' ], 'images/MainMenu.txt');
  ```

  Or, if you are using a config object use the `normalMap` property:

  ```javascript
  this.load.unityAtlas({
      key: 'mainmenu',
      textureURL: 'images/MainMenu.png',
      normalMap: 'images/MainMenu-n.png',
      atlasURL: 'images/MainMenu.txt'
  });
  ```

  The normal map file is subject to the same conditions as the image file with regard to the path, baseURL, CORs and XHR Settings.
  Normal maps are a WebGL only feature.

  Note: The ability to load this type of file will only be available if the Unity Atlas File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.UnityAtlasFileConfig | Array.<Phaser.Types.Loader.FileTypes.UnityAtlasFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * texture-url (string | Array.<string>) {optional} - The absolute or relative URL to load the texture image file from. If undefined or `null` it will be set to `<key>.png`, i.e. if `key` was 'alien' then the URL will be 'alien.png'.
    * atlas-url (string) {optional} - The absolute or relative URL to load the texture atlas data file from. If undefined or `null` it will be set to `<key>.txt`, i.e. if `key` was 'alien' then the URL will be 'alien.txt'.
    * texture-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas image file. Used in replacement of the Loaders default XHR Settings.
    * atlas-xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object for the atlas data file. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.unityAtlas loader-plugin
                 (clj->phaser key))))
  ([loader-plugin key texture-url]
   (phaser->clj
    (.unityAtlas loader-plugin
                 (clj->phaser key)
                 (clj->phaser texture-url))))
  ([loader-plugin key texture-url atlas-url]
   (phaser->clj
    (.unityAtlas loader-plugin
                 (clj->phaser key)
                 (clj->phaser texture-url)
                 (clj->phaser atlas-url))))
  ([loader-plugin key texture-url atlas-url texture-xhr-settings]
   (phaser->clj
    (.unityAtlas loader-plugin
                 (clj->phaser key)
                 (clj->phaser texture-url)
                 (clj->phaser atlas-url)
                 (clj->phaser texture-xhr-settings))))
  ([loader-plugin key texture-url atlas-url texture-xhr-settings atlas-xhr-settings]
   (phaser->clj
    (.unityAtlas loader-plugin
                 (clj->phaser key)
                 (clj->phaser texture-url)
                 (clj->phaser atlas-url)
                 (clj->phaser texture-xhr-settings)
                 (clj->phaser atlas-xhr-settings)))))

(defn update
  "Called automatically during the load process."
  ([loader-plugin]
   (phaser->clj
    (.update loader-plugin))))

(defn update-progress
  "Called automatically during the load process.
  It updates the `progress` value and then emits a progress event, which you can use to
  display a loading bar in your game."
  ([loader-plugin]
   (phaser->clj
    (.updateProgress loader-plugin))))

(defn video
  "Adds a Video file, or array of video files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.video('intro', [ 'video/level1.mp4', 'video/level1.webm', 'video/level1.mov' ]);
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global Video Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the Video Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the Video Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.video({
      key: 'intro',
      url: [ 'video/level1.mp4', 'video/level1.webm', 'video/level1.mov' ],
      asBlob: false,
      noAudio: true
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.VideoFileConfig` for more details.

  The URLs can be relative or absolute. If the URLs are relative the `Loader.baseURL` and `Loader.path` values will be prepended to them.

  Due to different browsers supporting different video file types you should usually provide your video files in a variety of formats.
  mp4, mov and webm are the most common. If you provide an array of URLs then the Loader will determine which _one_ file to load based on
  browser support, starting with the first in the array and progressing to the end.

  Unlike most asset-types, videos do not _need_ to be preloaded. You can create a Video Game Object and then call its `loadURL` method,
  to load a video at run-time, rather than in advance.

  Note: The ability to load this type of file will only be available if the Video File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.VideoFileConfig | Array.<Phaser.Types.Loader.FileTypes.VideoFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * urls (string | Array.<string>) {optional} - The absolute or relative URL to load the video files from.
    * load-event (string) {optional} - The load event to listen for when _not_ loading as a blob. Either `loadeddata`, `canplay` or `canplaythrough`.
    * as-blob (boolean) {optional} - Load the video as a data blob, or stream it via the Video element?
    * no-audio (boolean) {optional} - Does the video have an audio track? If not you can enable auto-playing on it.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.video loader-plugin
            (clj->phaser key))))
  ([loader-plugin key urls]
   (phaser->clj
    (.video loader-plugin
            (clj->phaser key)
            (clj->phaser urls))))
  ([loader-plugin key urls load-event]
   (phaser->clj
    (.video loader-plugin
            (clj->phaser key)
            (clj->phaser urls)
            (clj->phaser load-event))))
  ([loader-plugin key urls load-event as-blob]
   (phaser->clj
    (.video loader-plugin
            (clj->phaser key)
            (clj->phaser urls)
            (clj->phaser load-event)
            (clj->phaser as-blob))))
  ([loader-plugin key urls load-event as-blob no-audio]
   (phaser->clj
    (.video loader-plugin
            (clj->phaser key)
            (clj->phaser urls)
            (clj->phaser load-event)
            (clj->phaser as-blob)
            (clj->phaser no-audio))))
  ([loader-plugin key urls load-event as-blob no-audio xhr-settings]
   (phaser->clj
    (.video loader-plugin
            (clj->phaser key)
            (clj->phaser urls)
            (clj->phaser load-event)
            (clj->phaser as-blob)
            (clj->phaser no-audio)
            (clj->phaser xhr-settings)))))

(defn xml
  "Adds an XML file, or array of XML files, to the current load queue.

  You can call this method from within your Scene's `preload`, along with any other files you wish to load:

  ```javascript
  function preload ()
  {
      this.load.xml('wavedata', 'files/AlienWaveData.xml');
  }
  ```

  The file is **not** loaded right away. It is added to a queue ready to be loaded either when the loader starts,
  or if it's already running, when the next free load slot becomes available. This happens automatically if you
  are calling this from within the Scene's `preload` method, or a related callback. Because the file is queued
  it means you cannot use the file immediately after calling this method, but must wait for the file to complete.
  The typical flow for a Phaser Scene is that you load assets in the Scene's `preload` method and then when the
  Scene's `create` method is called you are guaranteed that all of those assets are ready for use and have been
  loaded.

  The key must be a unique String. It is used to add the file to the global XML Cache upon a successful load.
  The key should be unique both in terms of files being loaded and files already present in the XML Cache.
  Loading a file using a key that is already taken will result in a warning. If you wish to replace an existing file
  then remove it from the XML Cache first, before loading a new one.

  Instead of passing arguments you can pass a configuration object, such as:

  ```javascript
  this.load.xml({
      key: 'wavedata',
      url: 'files/AlienWaveData.xml'
  });
  ```

  See the documentation for `Phaser.Types.Loader.FileTypes.XMLFileConfig` for more details.

  Once the file has finished loading you can access it from its Cache using its key:

  ```javascript
  this.load.xml('wavedata', 'files/AlienWaveData.xml');
  // and later in your game ...
  var data = this.cache.xml.get('wavedata');
  ```

  If you have specified a prefix in the loader, via `Loader.setPrefix` then this value will be prepended to this files
  key. For example, if the prefix was `LEVEL1.` and the key was `Waves` the final key will be `LEVEL1.Waves` and
  this is what you would use to retrieve the text from the XML Cache.

  The URL can be relative or absolute. If the URL is relative the `Loader.baseURL` and `Loader.path` values will be prepended to it.

  If the URL isn't specified the Loader will take the key and create a filename from that. For example if the key is 'data'
  and no URL is given then the Loader will set the URL to be 'data.xml'. It will always add `.xml` as the extension, although
  this can be overridden if using an object instead of method arguments. If you do not desire this action then provide a URL.

  Note: The ability to load this type of file will only be available if the XML File type has been built into Phaser.
  It is available in the default build but can be excluded from custom builds.

  Parameters:
    * loader-plugin (Phaser.Loader.LoaderPlugin) - Targeted instance for method
    * key (string | Phaser.Types.Loader.FileTypes.XMLFileConfig | Array.<Phaser.Types.Loader.FileTypes.XMLFileConfig>) - The key to use for this file, or a file configuration object, or array of them.
    * url (string) {optional} - The absolute or relative URL to load this file from. If undefined or `null` it will be set to `<key>.xml`, i.e. if `key` was 'alien' then the URL will be 'alien.xml'.
    * xhr-settings (Phaser.Types.Loader.XHRSettingsObject) {optional} - An XHR Settings configuration object. Used in replacement of the Loaders default XHR Settings.

  Returns:  Phaser.Loader.LoaderPlugin - The Loader instance."
  ([loader-plugin key]
   (phaser->clj
    (.xml loader-plugin
          (clj->phaser key))))
  ([loader-plugin key url]
   (phaser->clj
    (.xml loader-plugin
          (clj->phaser key)
          (clj->phaser url))))
  ([loader-plugin key url xhr-settings]
   (phaser->clj
    (.xml loader-plugin
          (clj->phaser key)
          (clj->phaser url)
          (clj->phaser xhr-settings)))))