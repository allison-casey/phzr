(ns phzr.input.keyboard.keyboard-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->KeyboardManager
  "  Parameters:
    * input-manager (Phaser.Input.InputManager) - A reference to the Input Manager."
  ([input-manager]
   (js/Phaser.Input.Keyboard.KeyboardManager. (clj->phaser input-manager))))

(defn add-capture
  "By default when a key is pressed Phaser will not stop the event from propagating up to the browser.
  There are some keys this can be annoying for, like the arrow keys or space bar, which make the browser window scroll.

  This `addCapture` method enables consuming keyboard event for specific keys so it doesn't bubble up to the the browser
  and cause the default browser behavior.

  Please note that keyboard captures are global. This means that if you call this method from within a Scene, to say prevent
  the SPACE BAR from triggering a page scroll, then it will prevent it for any Scene in your game, not just the calling one.

  You can pass in a single key code value, or an array of key codes, or a string:

  ```javascript
  this.input.keyboard.addCapture(62);
  ```

  An array of key codes:

  ```javascript
  this.input.keyboard.addCapture([ 62, 63, 64 ]);
  ```

  Or a string:

  ```javascript
  this.input.keyboard.addCapture('W,S,A,D');
  ```

  To use non-alpha numeric keys, use a string, such as 'UP', 'SPACE' or 'LEFT'.

  You can also provide an array mixing both strings and key code integers.

  If there are active captures after calling this method, the `preventDefault` property is set to `true`.

  Parameters:
    * keyboard-manager (Phaser.Input.Keyboard.KeyboardManager) - Targeted instance for method
    * keycode (string | integer | Array.<integer> | Array.<any>) - The Key Codes to enable capture for, preventing them reaching the browser."
  ([keyboard-manager keycode]
   (phaser->clj
    (.addCapture keyboard-manager
                 (clj->phaser keycode)))))

(defn clear-captures
  "Removes all keyboard captures and sets the `preventDefault` property to `false`."
  ([keyboard-manager]
   (phaser->clj
    (.clearCaptures keyboard-manager))))

(defn destroy
  "Destroys this Keyboard Manager instance."
  ([keyboard-manager]
   (phaser->clj
    (.destroy keyboard-manager))))

(defn remove-capture
  "Removes an existing key capture.

  Please note that keyboard captures are global. This means that if you call this method from within a Scene, to remove
  the capture of a key, then it will remove it for any Scene in your game, not just the calling one.

  You can pass in a single key code value, or an array of key codes, or a string:

  ```javascript
  this.input.keyboard.removeCapture(62);
  ```

  An array of key codes:

  ```javascript
  this.input.keyboard.removeCapture([ 62, 63, 64 ]);
  ```

  Or a string:

  ```javascript
  this.input.keyboard.removeCapture('W,S,A,D');
  ```

  To use non-alpha numeric keys, use a string, such as 'UP', 'SPACE' or 'LEFT'.

  You can also provide an array mixing both strings and key code integers.

  If there are no captures left after calling this method, the `preventDefault` property is set to `false`.

  Parameters:
    * keyboard-manager (Phaser.Input.Keyboard.KeyboardManager) - Targeted instance for method
    * keycode (string | integer | Array.<integer> | Array.<any>) - The Key Codes to disable capture for, allowing them reaching the browser again."
  ([keyboard-manager keycode]
   (phaser->clj
    (.removeCapture keyboard-manager
                    (clj->phaser keycode)))))

(defn start-listeners
  "Starts the Keyboard Event listeners running.
  This is called automatically and does not need to be manually invoked."
  ([keyboard-manager]
   (phaser->clj
    (.startListeners keyboard-manager))))

(defn stop-listeners
  "Stops the Key Event listeners.
  This is called automatically and does not need to be manually invoked."
  ([keyboard-manager]
   (phaser->clj
    (.stopListeners keyboard-manager))))