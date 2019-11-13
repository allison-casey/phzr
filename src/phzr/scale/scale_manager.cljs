(ns phzr.scale.scale-manager
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->ScaleManager
  "  Parameters:
    * game (Phaser.Game) - A reference to the Phaser.Game instance."
  ([game]
   (js/Phaser.Scale.ScaleManager. (clj->phaser game))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([scale-manager event fn]
   (phaser->clj
    (.addListener scale-manager
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([scale-manager event fn context]
   (phaser->clj
    (.addListener scale-manager
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn destroy
  "Destroys this Scale Manager, releasing all references to external resources.
  Once destroyed, the Scale Manager cannot be used again."
  ([scale-manager]
   (phaser->clj
    (.destroy scale-manager))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([scale-manager event]
   (phaser->clj
    (.emit scale-manager
           (clj->phaser event))))
  ([scale-manager event args]
   (phaser->clj
    (.emit scale-manager
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([scale-manager]
   (phaser->clj
    (.eventNames scale-manager))))

(defn get-fullscreen-target
  "An internal method that gets the target element that is used when entering fullscreen mode.

  Returns:  object - The fullscreen target element."
  ([scale-manager]
   (phaser->clj
    (.getFullscreenTarget scale-manager))))

(defn get-max-zoom
  "Calculates and returns the largest possible zoom factor, based on the current
  parent and game sizes. If the parent has no dimensions (i.e. an unstyled div),
  or is smaller than the un-zoomed game, then this will return a value of 1 (no zoom)

  Returns:  integer - The maximum possible zoom factor. At a minimum this value is always at least 1."
  ([scale-manager]
   (phaser->clj
    (.getMaxZoom scale-manager))))

(defn get-parent
  "Determines the parent element of the game canvas, if any, based on the game configuration.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * config (Phaser.Types.Core.GameConfig) - The Game configuration object."
  ([scale-manager config]
   (phaser->clj
    (.getParent scale-manager
                (clj->phaser config)))))

(defn get-parent-bounds
  "Calculates the size of the parent bounds and updates the `parentSize` component, if the canvas has a dom parent.

  Returns:  boolean - `true` if the parent bounds have changed size, otherwise `false`."
  ([scale-manager]
   (phaser->clj
    (.getParentBounds scale-manager))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([scale-manager event]
   (phaser->clj
    (.listenerCount scale-manager
                    (clj->phaser event)))))

(defn lock-orientation
  "Attempts to lock the orientation of the web browser using the Screen Orientation API.

  This API is only available on modern mobile browsers.
  See https://developer.mozilla.org/en-US/docs/Web/API/Screen/lockOrientation for details.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * orientation (string) - The orientation you'd like to lock the browser in. Should be an API string such as 'landscape', 'landscape-primary', 'portrait', etc.

  Returns:  boolean - `true` if the orientation was successfully locked, otherwise `false`."
  ([scale-manager orientation]
   (phaser->clj
    (.lockOrientation scale-manager
                      (clj->phaser orientation)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([scale-manager event]
   (phaser->clj
    (.off scale-manager
          (clj->phaser event))))
  ([scale-manager event fn]
   (phaser->clj
    (.off scale-manager
          (clj->phaser event)
          (clj->phaser fn))))
  ([scale-manager event fn context]
   (phaser->clj
    (.off scale-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([scale-manager event fn context once]
   (phaser->clj
    (.off scale-manager
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([scale-manager event fn]
   (phaser->clj
    (.on scale-manager
         (clj->phaser event)
         (clj->phaser fn))))
  ([scale-manager event fn context]
   (phaser->clj
    (.on scale-manager
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn on-full-screen-change
  "Triggered when a fullscreenchange event is dispatched by the DOM."
  ([scale-manager]
   (phaser->clj
    (.onFullScreenChange scale-manager))))

(defn on-full-screen-error
  "Triggered when a fullscreenerror event is dispatched by the DOM."
  ([scale-manager]
   (phaser->clj
    (.onFullScreenError scale-manager))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([scale-manager event fn]
   (phaser->clj
    (.once scale-manager
           (clj->phaser event)
           (clj->phaser fn))))
  ([scale-manager event fn context]
   (phaser->clj
    (.once scale-manager
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn refresh
  "Refreshes the internal scale values, bounds sizes and orientation checks.

  Once finished, dispatches the resize event.

  This is called automatically by the Scale Manager when the browser window size changes,
  as long as it is using a Scale Mode other than 'NONE'.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * previous-width (number) {optional} - The previous width of the game. Only set if the gameSize has changed.
    * previous-height (number) {optional} - The previous height of the game. Only set if the gameSize has changed.

  Returns:  this - The Scale Manager instance."
  ([scale-manager]
   (phaser->clj
    (.refresh scale-manager)))
  ([scale-manager previous-width]
   (phaser->clj
    (.refresh scale-manager
              (clj->phaser previous-width))))
  ([scale-manager previous-width previous-height]
   (phaser->clj
    (.refresh scale-manager
              (clj->phaser previous-width)
              (clj->phaser previous-height)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([scale-manager]
   (phaser->clj
    (.removeAllListeners scale-manager)))
  ([scale-manager event]
   (phaser->clj
    (.removeAllListeners scale-manager
                         (clj->phaser event)))))

(defn remove-fullscreen-target
  "Removes the fullscreen target that was added to the DOM."
  ([scale-manager]
   (phaser->clj
    (.removeFullscreenTarget scale-manager))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([scale-manager event]
   (phaser->clj
    (.removeListener scale-manager
                     (clj->phaser event))))
  ([scale-manager event fn]
   (phaser->clj
    (.removeListener scale-manager
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([scale-manager event fn context]
   (phaser->clj
    (.removeListener scale-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([scale-manager event fn context once]
   (phaser->clj
    (.removeListener scale-manager
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn resize
  "Call this to modify the size of the Phaser canvas element directly.
  You should only use this if you are using the `NONE` scale mode,
  it will update all internal components completely.

  If all you want to do is change the size of the parent, see the `setParentSize` method.

  If all you want is to change the base size of the game, but still have the Scale Manager
  manage all the scaling (i.e. you're **not** using `NONE`), then see the `setGameSize` method.

  This method will set the `gameSize`, `baseSize` and `displaySize` components to the given
  dimensions. It will then resize the canvas width and height to the values given, by
  directly setting the properties. Finally, if you have set the Scale Manager zoom value
  to anything other than 1 (the default), it will set the canvas CSS width and height to
  be the given size multiplied by the zoom factor (the canvas pixel size remains untouched).

  If you have enabled `autoCenter`, it is then passed to the `updateCenter` method and
  the margins are set, allowing the canvas to be centered based on its parent element
  alone. Finally, the `displayScale` is adjusted and the RESIZE event dispatched.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * width (number) - The new width of the game.
    * height (number) - The new height of the game.

  Returns:  this - The Scale Manager instance."
  ([scale-manager width height]
   (phaser->clj
    (.resize scale-manager
             (clj->phaser width)
             (clj->phaser height)))))

(defn set-game-size
  "This method will set a new size for your game.

  It should only be used if you're looking to change the base size of your game and are using
  one of the Scale Manager scaling modes, i.e. `FIT`. If you're using `NONE` and wish to
  change the game and canvas size directly, then please use the `resize` method instead.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * width (number) - The new width of the game.
    * height (number) - The new height of the game.

  Returns:  this - The Scale Manager instance."
  ([scale-manager width height]
   (phaser->clj
    (.setGameSize scale-manager
                  (clj->phaser width)
                  (clj->phaser height)))))

(defn set-max-zoom
  "Sets the zoom to be the maximum possible based on the _current_ parent size.

  Returns:  this - The Scale Manager instance."
  ([scale-manager]
   (phaser->clj
    (.setMaxZoom scale-manager))))

(defn set-parent-size
  "This method will set the size of the Parent Size component, which is used in scaling
  and centering calculations. You only need to call this method if you have explicitly
  disabled the use of a parent in your game config, but still wish to take advantage of
  other Scale Manager features.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * width (number) - The new width of the parent.
    * height (number) - The new height of the parent.

  Returns:  this - The Scale Manager instance."
  ([scale-manager width height]
   (phaser->clj
    (.setParentSize scale-manager
                    (clj->phaser width)
                    (clj->phaser height)))))

(defn set-zoom
  "Sets the zoom value of the Scale Manager.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * value (integer) - The new zoom value of the game.

  Returns:  this - The Scale Manager instance."
  ([scale-manager value]
   (phaser->clj
    (.setZoom scale-manager
              (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([scale-manager]
   (phaser->clj
    (.shutdown scale-manager))))

(defn start-fullscreen
  "Sends a request to the browser to ask it to go in to full screen mode, using the {@link https://developer.mozilla.org/en-US/docs/Web/API/Fullscreen_API Fullscreen API}.

  If the browser does not support this, a `FULLSCREEN_UNSUPPORTED` event will be emitted.

  This method _must_ be called from a user-input gesture, such as `pointerup`. You cannot launch
  games fullscreen without this, as most browsers block it. Games within an iframe will also be blocked
  from fullscreen unless the iframe has the `allowfullscreen` attribute.

  On touch devices, such as Android and iOS Safari, you should always use `pointerup` and NOT `pointerdown`,
  otherwise the request will fail unless the document in which your game is embedded has already received
  some form of touch input, which you cannot guarantee. Activating fullscreen via `pointerup` circumvents
  this issue.

  Performing an action that navigates to another page, or opens another tab, will automatically cancel
  fullscreen mode, as will the user pressing the ESC key. To cancel fullscreen mode directly from your game,
  i.e. by clicking an icon, call the `stopFullscreen` method.

  A browser can only send one DOM element into fullscreen. You can control which element this is by
  setting the `fullscreenTarget` property in your game config, or changing the property in the Scale Manager.
  Note that the game canvas _must_ be a child of the target. If you do not give a target, Phaser will
  automatically create a blank `<div>` element and move the canvas into it, before going fullscreen.
  When it leaves fullscreen, the div will be removed.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * fullscreen-options (object) {optional} - The FullscreenOptions dictionary is used to provide configuration options when entering full screen."
  ([scale-manager]
   (phaser->clj
    (.startFullscreen scale-manager)))
  ([scale-manager fullscreen-options]
   (phaser->clj
    (.startFullscreen scale-manager
                      (clj->phaser fullscreen-options)))))

(defn start-listeners
  "An internal method that starts the different DOM event listeners running."
  ([scale-manager]
   (phaser->clj
    (.startListeners scale-manager))))

(defn step
  "Internal method, called automatically by the game step.
  Monitors the elapsed time and resize interval to see if a parent bounds check needs to take place.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * time (number) - The time value from the most recent Game step. Typically a high-resolution timer value, or Date.now().
    * delta (number) - The delta value since the last frame. This is smoothed to avoid delta spikes by the TimeStep class."
  ([scale-manager time delta]
   (phaser->clj
    (.step scale-manager
           (clj->phaser time)
           (clj->phaser delta)))))

(defn stop-fullscreen
  "Calling this method will cancel fullscreen mode, if the browser has entered it."
  ([scale-manager]
   (phaser->clj
    (.stopFullscreen scale-manager))))

(defn stop-listeners
  "Stops all DOM event listeners."
  ([scale-manager]
   (phaser->clj
    (.stopListeners scale-manager))))

(defn toggle-fullscreen
  "Toggles the fullscreen mode. If already in fullscreen, calling this will cancel it.
  If not in fullscreen, this will request the browser to enter fullscreen mode.

  If the browser does not support this, a `FULLSCREEN_UNSUPPORTED` event will be emitted.

  This method _must_ be called from a user-input gesture, such as `pointerdown`. You cannot launch
  games fullscreen without this, as most browsers block it. Games within an iframe will also be blocked
  from fullscreen unless the iframe has the `allowfullscreen` attribute.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * fullscreen-options (object) {optional} - The FullscreenOptions dictionary is used to provide configuration options when entering full screen."
  ([scale-manager]
   (phaser->clj
    (.toggleFullscreen scale-manager)))
  ([scale-manager fullscreen-options]
   (phaser->clj
    (.toggleFullscreen scale-manager
                       (clj->phaser fullscreen-options)))))

(defn transform-x
  "Transforms the pageX value into the scaled coordinate space of the Scale Manager.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * page-x (number) - The DOM pageX value.

  Returns:  number - The translated value."
  ([scale-manager page-x]
   (phaser->clj
    (.transformX scale-manager
                 (clj->phaser page-x)))))

(defn transform-y
  "Transforms the pageY value into the scaled coordinate space of the Scale Manager.

  Parameters:
    * scale-manager (Phaser.Scale.ScaleManager) - Targeted instance for method
    * page-y (number) - The DOM pageY value.

  Returns:  number - The translated value."
  ([scale-manager page-y]
   (phaser->clj
    (.transformY scale-manager
                 (clj->phaser page-y)))))

(defn update-bounds
  "Updates the `canvasBounds` rectangle to match the bounding client rectangle of the
  canvas element being used to track input events."
  ([scale-manager]
   (phaser->clj
    (.updateBounds scale-manager))))

(defn update-center
  "Calculates and updates the canvas CSS style in order to center it within the
  bounds of its parent. If you have explicitly set parent to be `null` in your
  game config then this method will likely give incorrect results unless you have called the
  `setParentSize` method first.

  It works by modifying the canvas CSS `marginLeft` and `marginTop` properties.

  If they have already been set by your own style sheet, or code, this will overwrite them.

  To prevent the Scale Manager from centering the canvas, either do not set the
  `autoCenter` property in your game config, or make sure it is set to `NO_CENTER`."
  ([scale-manager]
   (phaser->clj
    (.updateCenter scale-manager))))

(defn update-orientation
  "Internal method that checks the current screen orientation, only if the internal check flag is set.

  If the orientation has changed it updates the orientation property and then dispatches the orientation change event."
  ([scale-manager]
   (phaser->clj
    (.updateOrientation scale-manager))))

(defn update-scale
  "Internal method that manages updating the size components based on the scale mode."
  ([scale-manager]
   (phaser->clj
    (.updateScale scale-manager))))