(ns phzr.input.keyboard.keyboard-plugin
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->KeyboardPlugin
  "  Parameters:
    * scene-input-plugin (Phaser.Input.InputPlugin) - A reference to the Scene Input Plugin that the KeyboardPlugin belongs to."
  ([scene-input-plugin]
   (js/Phaser.Input.Keyboard.KeyboardPlugin. (clj->phaser scene-input-plugin))))

(defn add-capture
  "By default when a key is pressed Phaser will not stop the event from propagating up to the browser.
  There are some keys this can be annoying for, like the arrow keys or space bar, which make the browser window scroll.

  This `addCapture` method enables consuming keyboard events for specific keys, so they don't bubble up the browser
  and cause the default behaviors.

  Please note that keyboard captures are global. This means that if you call this method from within a Scene, to say prevent
  the SPACE BAR from triggering a page scroll, then it will prevent it for any Scene in your game, not just the calling one.

  You can pass a single key code value:

  ```javascript
  this.input.keyboard.addCapture(62);
  ```

  An array of key codes:

  ```javascript
  this.input.keyboard.addCapture([ 62, 63, 64 ]);
  ```

  Or, a comma-delimited string:

  ```javascript
  this.input.keyboard.addCapture('W,S,A,D');
  ```

  To use non-alpha numeric keys, use a string, such as 'UP', 'SPACE' or 'LEFT'.

  You can also provide an array mixing both strings and key code integers.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * keycode (string | integer | Array.<integer> | Array.<any>) - The Key Codes to enable event capture for.

  Returns:  Phaser.Input.Keyboard.KeyboardPlugin - This KeyboardPlugin object."
  ([keyboard-plugin keycode]
   (phaser->clj
    (.addCapture keyboard-plugin
                 (clj->phaser keycode)))))

(defn add-key
  "Adds a Key object to this Keyboard Plugin.

  The given argument can be either an existing Key object, a string, such as `A` or `SPACE`, or a key code value.

  If a Key object is given, and one already exists matching the same key code, the existing one is replaced with the new one.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * key (Phaser.Input.Keyboard.Key | string | integer) - Either a Key object, a string, such as `A` or `SPACE`, or a key code value.
    * enable-capture (boolean) {optional} - Automatically call `preventDefault` on the native DOM browser event for the key codes being added.
    * emit-on-repeat (boolean) {optional} - Controls if the Key will continuously emit a 'down' event while being held down (true), or emit the event just once (false, the default).

  Returns:  Phaser.Input.Keyboard.Key - The newly created Key object, or a reference to it if it already existed in the keys array."
  ([keyboard-plugin key]
   (phaser->clj
    (.addKey keyboard-plugin
             (clj->phaser key))))
  ([keyboard-plugin key enable-capture]
   (phaser->clj
    (.addKey keyboard-plugin
             (clj->phaser key)
             (clj->phaser enable-capture))))
  ([keyboard-plugin key enable-capture emit-on-repeat]
   (phaser->clj
    (.addKey keyboard-plugin
             (clj->phaser key)
             (clj->phaser enable-capture)
             (clj->phaser emit-on-repeat)))))

(defn add-keys
  "A practical way to create an object containing user selected hotkeys.

  For example:

  ```javascript
  this.input.keyboard.addKeys({ 'up': Phaser.Input.Keyboard.KeyCodes.W, 'down': Phaser.Input.Keyboard.KeyCodes.S });
  ```

  would return an object containing the properties (`up` and `down`) mapped to W and S {@link Phaser.Input.Keyboard.Key} objects.

  You can also pass in a comma-separated string:

  ```javascript
  this.input.keyboard.addKeys('W,S,A,D');
  ```

  Which will return an object with the properties W, S, A and D mapped to the relevant Key objects.

  To use non-alpha numeric keys, use a string, such as 'UP', 'SPACE' or 'LEFT'.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * keys (object | string) - An object containing Key Codes, or a comma-separated string.
    * enable-capture (boolean) {optional} - Automatically call `preventDefault` on the native DOM browser event for the key codes being added.
    * emit-on-repeat (boolean) {optional} - Controls if the Key will continuously emit a 'down' event while being held down (true), or emit the event just once (false, the default).

  Returns:  object - An object containing Key objects mapped to the input properties."
  ([keyboard-plugin keys]
   (phaser->clj
    (.addKeys keyboard-plugin
              (clj->phaser keys))))
  ([keyboard-plugin keys enable-capture]
   (phaser->clj
    (.addKeys keyboard-plugin
              (clj->phaser keys)
              (clj->phaser enable-capture))))
  ([keyboard-plugin keys enable-capture emit-on-repeat]
   (phaser->clj
    (.addKeys keyboard-plugin
              (clj->phaser keys)
              (clj->phaser enable-capture)
              (clj->phaser emit-on-repeat)))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([keyboard-plugin event fn]
   (phaser->clj
    (.addListener keyboard-plugin
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([keyboard-plugin event fn context]
   (phaser->clj
    (.addListener keyboard-plugin
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn check-down
  "Checks if the given Key object is currently being held down.

  The difference between this method and checking the `Key.isDown` property directly is that you can provide
  a duration to this method. For example, if you wanted a key press to fire a bullet, but you only wanted
  it to be able to fire every 100ms, then you can call this method with a `duration` of 100 and it
  will only return `true` every 100ms.

  If the Keyboard Plugin has been disabled, this method will always return `false`.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * key (Phaser.Input.Keyboard.Key) - A Key object.
    * duration (number) {optional} - The duration which must have elapsed before this Key is considered as being down.

  Returns:  boolean - `true` if the Key is down within the duration specified, otherwise `false`."
  ([keyboard-plugin key]
   (phaser->clj
    (.checkDown keyboard-plugin
                (clj->phaser key))))
  ([keyboard-plugin key duration]
   (phaser->clj
    (.checkDown keyboard-plugin
                (clj->phaser key)
                (clj->phaser duration)))))

(defn clear-captures
  "Removes all keyboard captures.

  Note that this is a global change. It will clear all event captures across your game, not just for this specific Scene.

  Returns:  Phaser.Input.Keyboard.KeyboardPlugin - This KeyboardPlugin object."
  ([keyboard-plugin]
   (phaser->clj
    (.clearCaptures keyboard-plugin))))

(defn create-combo
  "Creates a new KeyCombo.

  A KeyCombo will listen for a specific string of keys from the Keyboard, and when it receives them
  it will emit a `keycombomatch` event from this Keyboard Plugin.

  The keys to be listened for can be defined as:

  A string (i.e. 'ATARI')
  An array of either integers (key codes) or strings, or a mixture of both
  An array of objects (such as Key objects) with a public 'keyCode' property

  For example, to listen for the Konami code (up, up, down, down, left, right, left, right, b, a, enter)
  you could pass the following array of key codes:

  ```javascript
  this.input.keyboard.createCombo([ 38, 38, 40, 40, 37, 39, 37, 39, 66, 65, 13 ], { resetOnMatch: true });

  this.input.keyboard.on('keycombomatch', function (event) {
      console.log('Konami Code entered!');
  });
  ```

  Or, to listen for the user entering the word PHASER:

  ```javascript
  this.input.keyboard.createCombo('PHASER');
  ```

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * keys (string | Array.<integer> | Array.<object>) - The keys that comprise this combo.
    * config (Phaser.Types.Input.Keyboard.KeyComboConfig) {optional} - A Key Combo configuration object.

  Returns:  Phaser.Input.Keyboard.KeyCombo - The new KeyCombo object."
  ([keyboard-plugin keys]
   (phaser->clj
    (.createCombo keyboard-plugin
                  (clj->phaser keys))))
  ([keyboard-plugin keys config]
   (phaser->clj
    (.createCombo keyboard-plugin
                  (clj->phaser keys)
                  (clj->phaser config)))))

(defn create-cursor-keys
  "Creates and returns an object containing 4 hotkeys for Up, Down, Left and Right, and also Space Bar and shift.

  Returns:  Phaser.Types.Input.Keyboard.CursorKeys - An object containing the properties: `up`, `down`, `left`, `right`, `space` and `shift`."
  ([keyboard-plugin]
    ;; (.createCursorKeys keyboard-plugin)
   (phaser->clj
    (.createCursorKeys keyboard-plugin))
   ))

(defn disable-global-capture
  "Disables Phaser from preventing any key captures you may have defined, without actually removing them.
  You can use this to temporarily disable event capturing if, for example, you swap to a DOM element.

  Returns:  Phaser.Input.Keyboard.KeyboardPlugin - This KeyboardPlugin object."
  ([keyboard-plugin]
   (phaser->clj
    (.disableGlobalCapture keyboard-plugin))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([keyboard-plugin event]
   (phaser->clj
    (.emit keyboard-plugin
           (clj->phaser event))))
  ([keyboard-plugin event args]
   (phaser->clj
    (.emit keyboard-plugin
           (clj->phaser event)
           (clj->phaser args)))))

(defn enable-global-capture
  "Allows Phaser to prevent any key captures you may have defined from bubbling up the browser.
  You can use this to re-enable event capturing if you had paused it via `disableGlobalCapture`.

  Returns:  Phaser.Input.Keyboard.KeyboardPlugin - This KeyboardPlugin object."
  ([keyboard-plugin]
   (phaser->clj
    (.enableGlobalCapture keyboard-plugin))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([keyboard-plugin]
   (phaser->clj
    (.eventNames keyboard-plugin))))

(defn get-captures
  "Returns an array that contains all of the keyboard captures currently enabled.

  Returns:  Array.<integer> - An array of all the currently capturing key codes."
  ([keyboard-plugin]
   (phaser->clj
    (.getCaptures keyboard-plugin))))

(defn is-active
  "Checks to see if both this plugin and the Scene to which it belongs is active.

  Returns:  boolean - `true` if the plugin and the Scene it belongs to is active."
  ([keyboard-plugin]
   (phaser->clj
    (.isActive keyboard-plugin))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([keyboard-plugin event]
   (phaser->clj
    (.listenerCount keyboard-plugin
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([keyboard-plugin event]
   (phaser->clj
    (.listeners keyboard-plugin
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([keyboard-plugin event]
   (phaser->clj
    (.off keyboard-plugin
          (clj->phaser event))))
  ([keyboard-plugin event fn]
   (phaser->clj
    (.off keyboard-plugin
          (clj->phaser event)
          (clj->phaser fn))))
  ([keyboard-plugin event fn context]
   (phaser->clj
    (.off keyboard-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([keyboard-plugin event fn context once]
   (phaser->clj
    (.off keyboard-plugin
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([keyboard-plugin event fn]
   (phaser->clj
    (.on keyboard-plugin
         (clj->phaser event)
         (clj->phaser fn))))
  ([keyboard-plugin event fn context]
   (phaser->clj
    (.on keyboard-plugin
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([keyboard-plugin event fn]
   (phaser->clj
    (.once keyboard-plugin
           (clj->phaser event)
           (clj->phaser fn))))
  ([keyboard-plugin event fn context]
   (phaser->clj
    (.once keyboard-plugin
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([keyboard-plugin]
   (phaser->clj
    (.removeAllListeners keyboard-plugin)))
  ([keyboard-plugin event]
   (phaser->clj
    (.removeAllListeners keyboard-plugin
                         (clj->phaser event)))))

(defn remove-capture
  "Removes an existing key capture.

  Please note that keyboard captures are global. This means that if you call this method from within a Scene, to remove
  the capture of a key, then it will remove it for any Scene in your game, not just the calling one.

  You can pass a single key code value:

  ```javascript
  this.input.keyboard.removeCapture(62);
  ```

  An array of key codes:

  ```javascript
  this.input.keyboard.removeCapture([ 62, 63, 64 ]);
  ```

  Or, a comma-delimited string:

  ```javascript
  this.input.keyboard.removeCapture('W,S,A,D');
  ```

  To use non-alpha numeric keys, use a string, such as 'UP', 'SPACE' or 'LEFT'.

  You can also provide an array mixing both strings and key code integers.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * keycode (string | integer | Array.<integer> | Array.<any>) - The Key Codes to disable event capture for.

  Returns:  Phaser.Input.Keyboard.KeyboardPlugin - This KeyboardPlugin object."
  ([keyboard-plugin keycode]
   (phaser->clj
    (.removeCapture keyboard-plugin
                    (clj->phaser keycode)))))

(defn remove-key
  "Removes a Key object from this Keyboard Plugin.

  The given argument can be either a Key object, a string, such as `A` or `SPACE`, or a key code value.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * key (Phaser.Input.Keyboard.Key | string | integer) - Either a Key object, a string, such as `A` or `SPACE`, or a key code value.
    * destroy (boolean) {optional} - Call `Key.destroy` on the removed Key object?

  Returns:  Phaser.Input.Keyboard.KeyboardPlugin - This KeyboardPlugin object."
  ([keyboard-plugin key]
   (phaser->clj
    (.removeKey keyboard-plugin
                (clj->phaser key))))
  ([keyboard-plugin key destroy]
   (phaser->clj
    (.removeKey keyboard-plugin
                (clj->phaser key)
                (clj->phaser destroy)))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * keyboard-plugin (Phaser.Input.Keyboard.KeyboardPlugin) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([keyboard-plugin event]
   (phaser->clj
    (.removeListener keyboard-plugin
                     (clj->phaser event))))
  ([keyboard-plugin event fn]
   (phaser->clj
    (.removeListener keyboard-plugin
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([keyboard-plugin event fn context]
   (phaser->clj
    (.removeListener keyboard-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([keyboard-plugin event fn context once]
   (phaser->clj
    (.removeListener keyboard-plugin
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn reset-keys
  "Resets all Key objects created by _this_ Keyboard Plugin back to their default un-pressed states.
  This can only reset keys created via the `addKey`, `addKeys` or `createCursorKeys` methods.
  If you have created a Key object directly you'll need to reset it yourself.

  This method is called automatically when the Keyboard Plugin shuts down, but can be
  invoked directly at any time you require.

  Returns:  Phaser.Input.Keyboard.KeyboardPlugin - This KeyboardPlugin object."
  ([keyboard-plugin]
   (phaser->clj
    (.resetKeys keyboard-plugin))))
