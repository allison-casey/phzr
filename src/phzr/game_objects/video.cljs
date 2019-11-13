(ns phzr.game-objects.video
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->Video
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs. A Game Object can only belong to one Scene at a time.
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * key (string) {optional} - Optional key of the Video this Game Object will play, as stored in the Video Cache."
  ([scene x y]
   (js/Phaser.GameObjects.Video. (clj->phaser scene)
                                 (clj->phaser x)
                                 (clj->phaser y)))
  ([scene x y key]
   (js/Phaser.GameObjects.Video. (clj->phaser scene)
                                 (clj->phaser x)
                                 (clj->phaser y)
                                 (clj->phaser key))))

(defn add-listener
  "Add a listener for a given event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([video event fn]
   (phaser->clj
    (.addListener video
                  (clj->phaser event)
                  (clj->phaser fn))))
  ([video event fn context]
   (phaser->clj
    (.addListener video
                  (clj->phaser event)
                  (clj->phaser fn)
                  (clj->phaser context)))))

(defn add-marker
  "Adds a sequence marker to this video.

  Markers allow you to split a video up into sequences, delineated by a start and end time, given in seconds.

  You can then play back specific markers via the `playMarker` method.

  Note that marker timing is _not_ frame-perfect. You should construct your videos in such a way that you allow for
  plenty of extra padding before and after each sequence to allow for discrepencies in browser seek and currentTime accuracy.

  See https://github.com/w3c/media-and-entertainment/issues/4 for more details about this issue.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string) - A unique name to give this marker.
    * marker-in (integer) - The time, in seconds, representing the start of this marker.
    * marker-out (integer) - The time, in seconds, representing the end of this marker.

  Returns:  this - This Video Game Object for method chaining."
  ([video key marker-in marker-out]
   (phaser->clj
    (.addMarker video
                (clj->phaser key)
                (clj->phaser marker-in)
                (clj->phaser marker-out)))))

(defn change-source
  "This method allows you to change the source of the current video element. It works by first stopping the
  current video, if playing. Then deleting the video texture, if one has been created. Finally, it makes a
  new video texture and starts playback of the new source through the existing video element.

  The reason you may wish to do this is because videos that require interaction to unlock, remain in an unlocked
  state, even if you change the source of the video. By changing the source to a new video you avoid having to
  go through the unlock process again.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string) - The key of the Video this Game Object will swap to playing, as stored in the Video Cache.
    * autoplay (boolean) {optional} - Should the video start playing immediately, once the swap is complete?
    * loop (boolean) {optional} - Should the video loop automatically when it reaches the end? Please note that not all browsers support _seamless_ video looping for all encoding formats.
    * marker-in (integer) {optional} - Optional in marker time, in seconds, for playback of a sequence of the video.
    * marker-out (integer) {optional} - Optional out marker time, in seconds, for playback of a sequence of the video.

  Returns:  this - This Video Game Object for method chaining."
  ([video key]
   (phaser->clj
    (.changeSource video
                   (clj->phaser key))))
  ([video key autoplay]
   (phaser->clj
    (.changeSource video
                   (clj->phaser key)
                   (clj->phaser autoplay))))
  ([video key autoplay loop]
   (phaser->clj
    (.changeSource video
                   (clj->phaser key)
                   (clj->phaser autoplay)
                   (clj->phaser loop))))
  ([video key autoplay loop marker-in]
   (phaser->clj
    (.changeSource video
                   (clj->phaser key)
                   (clj->phaser autoplay)
                   (clj->phaser loop)
                   (clj->phaser marker-in))))
  ([video key autoplay loop marker-in marker-out]
   (phaser->clj
    (.changeSource video
                   (clj->phaser key)
                   (clj->phaser autoplay)
                   (clj->phaser loop)
                   (clj->phaser marker-in)
                   (clj->phaser marker-out)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.clearAlpha video))))

(defn clear-mask
  "Clears the mask that this Game Object was using.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * destroy-mask (boolean) {optional} - Destroy the mask before clearing it?

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.clearMask video)))
  ([video destroy-mask]
   (phaser->clj
    (.clearMask video
                (clj->phaser destroy-mask)))))

(defn clear-tint
  "Clears all tint values associated with this Game Object.

  Immediately sets the color values back to 0xffffff and the tint type to 'additive',
  which results in no visible change to the texture.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.clearTint video))))

(defn complete-handler
  "Called when the video completes playback, i.e. reaches an `ended` state.

  This will never happen if the video is coming from a live stream, where the duration is `Infinity`."
  ([video]
   (phaser->clj
    (.completeHandler video))))

(defn create-bitmap-mask
  "Creates and returns a Bitmap Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a renderable Game Object.
  A renderable Game Object is one that uses a texture to render with, such as an
  Image, Sprite, Render Texture or BitmapText.

  If you do not provide a renderable object, and this Game Object has a texture,
  it will use itself as the object. This means you can call this method to create
  a Bitmap Mask from any renderable Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * renderable (Phaser.GameObjects.GameObject) {optional} - A renderable Game Object that uses a texture, such as a Sprite.

  Returns:  Phaser.Display.Masks.BitmapMask - This Bitmap Mask that was created."
  ([video]
   (phaser->clj
    (.createBitmapMask video)))
  ([video renderable]
   (phaser->clj
    (.createBitmapMask video
                       (clj->phaser renderable)))))

(defn create-geometry-mask
  "Creates and returns a Geometry Mask. This mask can be used by any Game Object,
  including this one.

  To create the mask you need to pass in a reference to a Graphics Game Object.

  If you do not provide a graphics object, and this Game Object is an instance
  of a Graphics object, then it will use itself to create the mask.

  This means you can call this method to create a Geometry Mask from any Graphics Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * graphics (Phaser.GameObjects.Graphics) {optional} - A Graphics Game Object. The geometry within it will be used as the mask.

  Returns:  Phaser.Display.Masks.GeometryMask - This Geometry Mask that was created."
  ([video]
   (phaser->clj
    (.createGeometryMask video)))
  ([video graphics]
   (phaser->clj
    (.createGeometryMask video
                         (clj->phaser graphics)))))

(defn destroy
  "Destroys the Video object. This calls `Video.stop` and optionally `Video.removeVideoElement`.

  If any Sprites are using this Video as their texture it is up to you to manage those.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * remove-video-element (boolean) {optional} - Should the video element be removed from the DOM?"
  ([video]
   (phaser->clj
    (.destroy video)))
  ([video remove-video-element]
   (phaser->clj
    (.destroy video
              (clj->phaser remove-video-element)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([video]
   (phaser->clj
    (.disableInteractive video))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([video event]
   (phaser->clj
    (.emit video
           (clj->phaser event))))
  ([video event args]
   (phaser->clj
    (.emit video
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([video]
   (phaser->clj
    (.eventNames video))))

(defn get-bottom-center
  "Gets the bottom-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getBottomCenter video)))
  ([video output]
   (phaser->clj
    (.getBottomCenter video
                      (clj->phaser output))))
  ([video output include-parent]
   (phaser->clj
    (.getBottomCenter video
                      (clj->phaser output)
                      (clj->phaser include-parent)))))

(defn get-bottom-left
  "Gets the bottom-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getBottomLeft video)))
  ([video output]
   (phaser->clj
    (.getBottomLeft video
                    (clj->phaser output))))
  ([video output include-parent]
   (phaser->clj
    (.getBottomLeft video
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-bottom-right
  "Gets the bottom-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getBottomRight video)))
  ([video output]
   (phaser->clj
    (.getBottomRight video
                     (clj->phaser output))))
  ([video output include-parent]
   (phaser->clj
    (.getBottomRight video
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-bounds
  "Gets the bounds of this Game Object, regardless of origin.
  The values are stored and returned in a Rectangle, or Rectangle-like, object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Geom.Rectangle | object) {optional} - An object to store the values in. If not provided a new Rectangle will be created.

  Returns:  Phaser.Geom.Rectangle | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getBounds video)))
  ([video output]
   (phaser->clj
    (.getBounds video
                (clj->phaser output)))))

(defn get-center
  "Gets the center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getCenter video)))
  ([video output]
   (phaser->clj
    (.getCenter video
                (clj->phaser output)))))

(defn get-current-time
  "A double-precision floating-point value indicating the current playback time in seconds.
  If the media has not started to play and has not been seeked, this value is the media's initial playback time.

  Returns:  number - A double-precision floating-point value indicating the current playback time in seconds."
  ([video]
   (phaser->clj
    (.getCurrentTime video))))

(defn get-data
  "Retrieves the value for the given key in this Game Objects Data Manager, or undefined if it doesn't exist.

  You can also access values via the `values` object. For example, if you had a key called `gold` you can do either:

  ```javascript
  sprite.getData('gold');
  ```

  Or access the value directly:

  ```javascript
  sprite.data.values.gold;
  ```

  You can also pass in an array of keys, in which case an array of values will be returned:

  ```javascript
  sprite.getData([ 'gold', 'armor', 'health' ]);
  ```

  This approach is useful for destructuring arrays in ES6.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([video key]
   (phaser->clj
    (.getData video
              (clj->phaser key)))))

(defn get-duration
  "A double-precision floating-point value which indicates the duration (total length) of the media in seconds,
  on the media's timeline. If no media is present on the element, or the media is not valid, the returned value is NaN.

  If the media has no known end (such as for live streams of unknown duration, web radio, media incoming from WebRTC,
  and so forth), this value is +Infinity.

  Returns:  number - A double-precision floating-point value indicating the duration of the media in seconds."
  ([video]
   (phaser->clj
    (.getDuration video))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([video]
   (phaser->clj
    (.getIndexList video))))

(defn get-left-center
  "Gets the left-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getLeftCenter video)))
  ([video output]
   (phaser->clj
    (.getLeftCenter video
                    (clj->phaser output))))
  ([video output include-parent]
   (phaser->clj
    (.getLeftCenter video
                    (clj->phaser output)
                    (clj->phaser include-parent)))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([video]
   (phaser->clj
    (.getLocalTransformMatrix video)))
  ([video temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix video
                              (clj->phaser temp-matrix)))))

(defn get-loop
  "Returns a boolean which indicates whether the media element should start over when it reaches the end.

  Returns:  boolean - A boolean which indicates whether the media element will start over when it reaches the end."
  ([video]
   (phaser->clj
    (.getLoop video))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([video]
   (phaser->clj
    (.getParentRotation video))))

(defn get-pipeline-name
  "Gets the name of the WebGL Pipeline this Game Object is currently using.

  Returns:  string - The string-based name of the pipeline being used by this Game Object."
  ([video]
   (phaser->clj
    (.getPipelineName video))))

(defn get-playback-rate
  "Returns a double that indicates the rate at which the media is being played back.

  Returns:  number - A double that indicates the rate at which the media is being played back."
  ([video]
   (phaser->clj
    (.getPlaybackRate video))))

(defn get-progress
  "Returns the current progress of the video. Progress is defined as a value between 0 (the start)
  and 1 (the end).

  Progress can only be returned if the video has a duration, otherwise it will always return zero.

  Returns:  number - The current progress of playback. If the video has no duration, will always return zero."
  ([video]
   (phaser->clj
    (.getProgress video))))

(defn get-right-center
  "Gets the right-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getRightCenter video)))
  ([video output]
   (phaser->clj
    (.getRightCenter video
                     (clj->phaser output))))
  ([video output include-parent]
   (phaser->clj
    (.getRightCenter video
                     (clj->phaser output)
                     (clj->phaser include-parent)))))

(defn get-top-center
  "Gets the top-center coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getTopCenter video)))
  ([video output]
   (phaser->clj
    (.getTopCenter video
                   (clj->phaser output))))
  ([video output include-parent]
   (phaser->clj
    (.getTopCenter video
                   (clj->phaser output)
                   (clj->phaser include-parent)))))

(defn get-top-left
  "Gets the top-left corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getTopLeft video)))
  ([video output]
   (phaser->clj
    (.getTopLeft video
                 (clj->phaser output))))
  ([video output include-parent]
   (phaser->clj
    (.getTopLeft video
                 (clj->phaser output)
                 (clj->phaser include-parent)))))

(defn get-top-right
  "Gets the top-right corner coordinate of this Game Object, regardless of origin.
  The returned point is calculated in local space and does not factor in any parent containers

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * output (Phaser.Math.Vector2 | object) {optional} - An object to store the values in. If not provided a new Vector2 will be created.
    * include-parent (boolean) {optional} - If this Game Object has a parent Container, include it (and all other ancestors) in the resulting vector?

  Returns:  Phaser.Math.Vector2 | object - The values stored in the output object."
  ([video]
   (phaser->clj
    (.getTopRight video)))
  ([video output]
   (phaser->clj
    (.getTopRight video
                  (clj->phaser output))))
  ([video output include-parent]
   (phaser->clj
    (.getTopRight video
                  (clj->phaser output)
                  (clj->phaser include-parent)))))

(defn get-video-key
  "Returns the key of the currently played video, as stored in the Video Cache.
  If the video did not come from the cache this will return an empty string.

  Returns:  string - The key of the video being played from the Video Cache, if any."
  ([video]
   (phaser->clj
    (.getVideoKey video))))

(defn get-volume
  "Returns a double indicating the audio volume, from 0.0 (silent) to 1.0 (loudest).

  Returns:  number - A double indicating the audio volume, from 0.0 (silent) to 1.0 (loudest)."
  ([video]
   (phaser->clj
    (.getVolume video))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([video]
   (phaser->clj
    (.getWorldTransformMatrix video)))
  ([video temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix video
                              (clj->phaser temp-matrix))))
  ([video temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix video
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn init-pipeline
  "Sets the initial WebGL Pipeline of this Game Object.
  This should only be called during the instantiation of the Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * pipeline-name (string) {optional} - The name of the pipeline to set on this Game Object. Defaults to the Texture Tint Pipeline.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([video]
   (phaser->clj
    (.initPipeline video)))
  ([video pipeline-name]
   (phaser->clj
    (.initPipeline video
                   (clj->phaser pipeline-name)))))

(defn is-muted
  "Returns a boolean indicating if this Video is currently muted.

  Returns:  boolean - A boolean indicating if this Video is currently muted, or not."
  ([video]
   (phaser->clj
    (.isMuted video))))

(defn is-paused
  "Returns a boolean which indicates whether the video is currently paused.

  Returns:  boolean - A boolean which indicates whether the video is paused, or not."
  ([video]
   (phaser->clj
    (.isPaused video))))

(defn is-playing
  "Returns a boolean which indicates whether the video is currently playing.

  Returns:  boolean - A boolean which indicates whether the video is playing, or not."
  ([video]
   (phaser->clj
    (.isPlaying video))))

(defn is-seeking
  "Returns a boolean indicating if this Video is currently seeking, or not.

  Returns:  boolean - A boolean indicating if this Video is currently seeking, or not."
  ([video]
   (phaser->clj
    (.isSeeking video))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([video event]
   (phaser->clj
    (.listenerCount video
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([video event]
   (phaser->clj
    (.listeners video
                (clj->phaser event)))))

(defn load-url
  "Loads a Video from the given URL, ready for playback with the `Video.play` method.

  You can control at what point the browser determines the video as being ready for playback via
  the `loadEvent` parameter. See https://developer.mozilla.org/en-US/docs/Web/API/HTMLVideoElement
  for more details.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * url (string) - The URL of the video to load or be streamed.
    * load-event (string) {optional} - The load event to listen for. Either `loadeddata`, `canplay` or `canplaythrough`.
    * no-audio (boolean) {optional} - Does the video have an audio track? If not you can enable auto-playing on it.

  Returns:  this - This Video Game Object for method chaining."
  ([video url]
   (phaser->clj
    (.loadURL video
              (clj->phaser url))))
  ([video url load-event]
   (phaser->clj
    (.loadURL video
              (clj->phaser url)
              (clj->phaser load-event))))
  ([video url load-event no-audio]
   (phaser->clj
    (.loadURL video
              (clj->phaser url)
              (clj->phaser load-event)
              (clj->phaser no-audio)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([video event]
   (phaser->clj
    (.off video
          (clj->phaser event))))
  ([video event fn]
   (phaser->clj
    (.off video
          (clj->phaser event)
          (clj->phaser fn))))
  ([video event fn context]
   (phaser->clj
    (.off video
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([video event fn context once]
   (phaser->clj
    (.off video
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([video event fn]
   (phaser->clj
    (.on video
         (clj->phaser event)
         (clj->phaser fn))))
  ([video event fn context]
   (phaser->clj
    (.on video
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([video event fn]
   (phaser->clj
    (.once video
           (clj->phaser event)
           (clj->phaser fn))))
  ([video event fn context]
   (phaser->clj
    (.once video
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn play
  "Starts this video playing.

  If the video is already playing, or has been queued to play with `changeSource` then this method just returns.

  Videos can only autoplay if the browser has been unlocked. This happens if you have interacted with the browser, i.e.
  by clicking on it or pressing a key, or due to server settings. The policies that control autoplaying are vast and
  vary between browser. You can read more here: https://developer.mozilla.org/en-US/docs/Web/Media/Autoplay_guide

  If your video doesn't contain any audio, then set the `noAudio` parameter to `true` when the video is loaded,
  and it will often allow the video to play immediately:

  ```javascript
  preload () {
    this.load.video('pixar', 'nemo.mp4', 'loadeddata', false, true);
  }
  ```

  The 5th parameter in the load call tells Phaser that the video doesn't contain any audio tracks. Video without
  audio can autoplay without requiring a user interaction. Video with audio cannot do this unless it satisfies
  the browsers MEI settings. See the MDN Autoplay Guide for details.

  If you need audio in your videos, then you'll have to consider the fact that the video cannot start playing until the
  user has interacted with the browser, into your game flow.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * loop (boolean) {optional} - Should the video loop automatically when it reaches the end? Please note that not all browsers support _seamless_ video looping for all encoding formats.
    * marker-in (integer) {optional} - Optional in marker time, in seconds, for playback of a sequence of the video.
    * marker-out (integer) {optional} - Optional out marker time, in seconds, for playback of a sequence of the video.

  Returns:  this - This Video Game Object for method chaining."
  ([video]
   (phaser->clj
    (.play video)))
  ([video loop]
   (phaser->clj
    (.play video
           (clj->phaser loop))))
  ([video loop marker-in]
   (phaser->clj
    (.play video
           (clj->phaser loop)
           (clj->phaser marker-in))))
  ([video loop marker-in marker-out]
   (phaser->clj
    (.play video
           (clj->phaser loop)
           (clj->phaser marker-in)
           (clj->phaser marker-out)))))

(defn play-handler
  "Called when the video emits a `playing` event during load.

  This is only listened for if the browser doesn't support Promises."
  ([video]
   (phaser->clj
    (.playHandler video))))

(defn play-marker
  "Plays a pre-defined sequence in this video.

  Markers allow you to split a video up into sequences, delineated by a start and end time, given in seconds and
  specified via the `addMarker` method.

  Note that marker timing is _not_ frame-perfect. You should construct your videos in such a way that you allow for
  plenty of extra padding before and after each sequence to allow for discrepencies in browser seek and currentTime accuracy.

  See https://github.com/w3c/media-and-entertainment/issues/4 for more details about this issue.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string) - The name of the marker sequence to play.
    * loop (boolean) {optional} - Should the video loop automatically when it reaches the end? Please note that not all browsers support _seamless_ video looping for all encoding formats.

  Returns:  this - This Video Game Object for method chaining."
  ([video key]
   (phaser->clj
    (.playMarker video
                 (clj->phaser key))))
  ([video key loop]
   (phaser->clj
    (.playMarker video
                 (clj->phaser key)
                 (clj->phaser loop)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([video]
   (phaser->clj
    (.removeAllListeners video)))
  ([video event]
   (phaser->clj
    (.removeAllListeners video
                         (clj->phaser event)))))

(defn remove-interactive
  "If this Game Object has previously been enabled for input, this will queue it
  for removal, causing it to no longer be interactive. The removal happens on
  the next game step, it is not immediate.

  The Interactive Object that was assigned to this Game Object will be destroyed,
  removed from the Input Manager and cleared from this Game Object.

  If you wish to re-enable this Game Object at a later date you will need to
  re-create its InteractiveObject by calling `setInteractive` again.

  If you wish to only temporarily stop an object from receiving input then use
  `disableInteractive` instead, as that toggles the interactive state, where-as
  this erases it completely.

  If you wish to resize a hit area, don't remove and then set it as being
  interactive. Instead, access the hitarea object directly and resize the shape
  being used. I.e.: `sprite.input.hitArea.setSize(width, height)` (assuming the
  shape is a Rectangle, which it is by default.)

  Returns:  this - This GameObject."
  ([video]
   (phaser->clj
    (.removeInteractive video))))

(defn remove-listener
  "Remove the listeners of a given event.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([video event]
   (phaser->clj
    (.removeListener video
                     (clj->phaser event))))
  ([video event fn]
   (phaser->clj
    (.removeListener video
                     (clj->phaser event)
                     (clj->phaser fn))))
  ([video event fn context]
   (phaser->clj
    (.removeListener video
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context))))
  ([video event fn context once]
   (phaser->clj
    (.removeListener video
                     (clj->phaser event)
                     (clj->phaser fn)
                     (clj->phaser context)
                     (clj->phaser once)))))

(defn remove-marker
  "Removes a previously set marker from this video.

  If the marker is currently playing it will _not_ stop playback.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string) - The name of the marker to remove.

  Returns:  this - This Video Game Object for method chaining."
  ([video key]
   (phaser->clj
    (.removeMarker video
                   (clj->phaser key)))))

(defn remove-video-element
  "Removes the Video element from the DOM by calling parentNode.removeChild on itself.

  Also removes the autoplay and src attributes and nulls the Video reference.

  You should not call this method if you were playing a video from the Video Cache that
  you wish to play again in your game, or if another Video object is also using the same
  video.

  If you loaded an external video via `Video.loadURL` then you should call this function
  to clear up once you are done with the instance."
  ([video]
   (phaser->clj
    (.removeVideoElement video))))

(defn reset-flip
  "Resets the horizontal and vertical flipped state of this Game Object back to their default un-flipped state.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.resetFlip video))))

(defn reset-pipeline
  "Resets the WebGL Pipeline of this Game Object back to the default it was created with.

  Returns:  boolean - `true` if the pipeline was set successfully, otherwise `false`."
  ([video]
   (phaser->clj
    (.resetPipeline video))))

(defn save-snapshot-texture
  "Stores a copy of this Videos `snapshotTexture` in the Texture Manager using the given key.

  This texture is created when the `snapshot` or `snapshotArea` methods are called.

  After doing this, any texture based Game Object, such as a Sprite, can use the contents of the
  snapshot by using the texture key:

  ```javascript
  var vid = this.add.video(0, 0, 'intro');

  vid.snapshot();

  vid.saveSnapshotTexture('doodle');

  this.add.image(400, 300, 'doodle');
  ```

  Updating the contents of the `snapshotTexture`, for example by calling `snapshot` again,
  will automatically update _any_ Game Object that is using it as a texture.
  Calling `saveSnapshotTexture` again will not save another copy of the same texture,
  it will just rename the existing one.

  By default it will create a single base texture. You can add frames to the texture
  by using the `Texture.add` method. After doing this, you can then allow Game Objects
  to use a specific frame.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string) - The unique key to store the texture as within the global Texture Manager.

  Returns:  Phaser.Textures.CanvasTexture - The Texture that was saved."
  ([video key]
   (phaser->clj
    (.saveSnapshotTexture video
                          (clj->phaser key)))))

(defn save-texture
  "Stores this Video in the Texture Manager using the given key as a dyanmic texture,
  which any texture-based Game Object, such as a Sprite, can use as its texture:

  ```javascript
  var vid = this.add.video(0, 0, 'intro');

  vid.play();

  vid.saveTexture('doodle');

  this.add.image(400, 300, 'doodle');
  ```

  The saved texture is automatically updated as the video plays. If you pause this video,
  or change its source, then the saved texture updates instantly.

  Calling `saveTexture` again will not save another copy of the same texture, it will just rename the existing one.

  By default it will create a single base texture. You can add frames to the texture
  by using the `Texture.add` method. After doing this, you can then allow Game Objects
  to use a specific frame.

  If you intend to save the texture so you can use it as the input for a Shader, you may need to set the
  `flipY` parameter to `true` if you find the video renders upside down in your shader.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string) - The unique key to store the texture as within the global Texture Manager.
    * flip-y (boolean) {optional} - Should the WebGL Texture set `UNPACK_MULTIPLY_FLIP_Y` during upload?

  Returns:  Phaser.Textures.Texture - The Texture that was saved."
  ([video key]
   (phaser->clj
    (.saveTexture video
                  (clj->phaser key))))
  ([video key flip-y]
   (phaser->clj
    (.saveTexture video
                  (clj->phaser key)
                  (clj->phaser flip-y)))))

(defn seek-to
  "Seeks to a given point in the video. The value is given as a float between 0 and 1,
  where 0 represents the start of the video and 1 represents the end.

  Seeking only works if the video has a duration, so will not work for live streams.

  When seeking begins, this video will emit a `seeking` event. When the video completes
  seeking (i.e. reaches its designated timestamp) it will emit a `seeked` event.

  If you wish to seek based on time instead, use the `Video.setCurrentTime` method.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (number) - The point in the video to seek to. A value between 0 and 1.

  Returns:  this - This Video Game Object for method chaining."
  ([video value]
   (phaser->clj
    (.seekTo video
             (clj->phaser value)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([video value]
   (phaser->clj
    (.setActive video
                (clj->phaser value)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setAlpha video)))
  ([video top-left]
   (phaser->clj
    (.setAlpha video
               (clj->phaser top-left))))
  ([video top-left top-right]
   (phaser->clj
    (.setAlpha video
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([video top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha video
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([video top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha video
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setAngle video)))
  ([video degrees]
   (phaser->clj
    (.setAngle video
               (clj->phaser degrees)))))

(defn set-blend-mode
  "Sets the Blend Mode being used by this Game Object.

  This can be a const, such as `Phaser.BlendModes.SCREEN`, or an integer, such as 4 (for Overlay)

  Under WebGL only the following Blend Modes are available:

  * ADD
  * MULTIPLY
  * SCREEN
  * ERASE (only works when rendering to a framebuffer, like a Render Texture)

  Canvas has more available depending on browser support.

  You can also create your own custom Blend Modes in WebGL.

  Blend modes have different effects under Canvas and WebGL, and from browser to browser, depending
  on support. Blend Modes also cause a WebGL batch flush should it encounter a new blend mode. For these
  reasons try to be careful about the construction of your Scene and the frequency in which blend modes
  are used.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([video value]
   (phaser->clj
    (.setBlendMode video
                   (clj->phaser value)))))

(defn set-crop
  "Applies a crop to a texture based Game Object, such as a Sprite or Image.

  The crop is a rectangle that limits the area of the texture frame that is visible during rendering.

  Cropping a Game Object does not change its size, dimensions, physics body or hit area, it just
  changes what is shown when rendered.

  The crop coordinates are relative to the texture frame, not the Game Object, meaning 0 x 0 is the top-left.

  Therefore, if you had a Game Object that had an 800x600 sized texture, and you wanted to show only the left
  half of it, you could call `setCrop(0, 0, 400, 600)`.

  It is also scaled to match the Game Object scale automatically. Therefore a crop rect of 100x50 would crop
  an area of 200x100 when applied to a Game Object that had a scale factor of 2.

  You can either pass in numeric values directly, or you can provide a single Rectangle object as the first argument.

  Call this method with no arguments at all to reset the crop, or toggle the property `isCropped` to `false`.

  You should do this if the crop rectangle becomes the same size as the frame itself, as it will allow
  the renderer to skip several internal calculations.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (number | Phaser.Geom.Rectangle) {optional} - The x coordinate to start the crop from. Or a Phaser.Geom.Rectangle object, in which case the rest of the arguments are ignored.
    * y (number) {optional} - The y coordinate to start the crop from.
    * width (number) {optional} - The width of the crop rectangle in pixels.
    * height (number) {optional} - The height of the crop rectangle in pixels.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setCrop video)))
  ([video x]
   (phaser->clj
    (.setCrop video
              (clj->phaser x))))
  ([video x y]
   (phaser->clj
    (.setCrop video
              (clj->phaser x)
              (clj->phaser y))))
  ([video x y width]
   (phaser->clj
    (.setCrop video
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width))))
  ([video x y width height]
   (phaser->clj
    (.setCrop video
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-current-time
  "Seeks to a given playback time in the video. The value is given in _seconds_ or as a string.

  Seeking only works if the video has a duration, so will not work for live streams.

  When seeking begins, this video will emit a `seeking` event. When the video completes
  seeking (i.e. reaches its designated timestamp) it will emit a `seeked` event.

  You can provide a string prefixed with either a `+` or a `-`, such as `+2.5` or `-2.5`.
  In this case it will seek to +/- the value given, relative to the _current time_.

  If you wish to seek based on a duration percentage instead, use the `Video.seekTo` method.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (string | number) - The playback time to seek to in seconds. Can be expressed as a string, such as `+2` to seek 2 seconds ahead from the current time.

  Returns:  this - This Video Game Object for method chaining."
  ([video value]
   (phaser->clj
    (.setCurrentTime video
                     (clj->phaser value)))))

(defn set-data
  "Allows you to store a key value pair within this Game Objects Data Manager.

  If the Game Object has not been enabled for data (via `setDataEnabled`) then it will be enabled
  before setting the value.

  If the key doesn't already exist in the Data Manager then it is created.

  ```javascript
  sprite.setData('name', 'Red Gem Stone');
  ```

  You can also pass in an object of key value pairs as the first argument:

  ```javascript
  sprite.setData({ name: 'Red Gem Stone', level: 2, owner: 'Link', gold: 50 });
  ```

  To get a value back again you can call `getData`:

  ```javascript
  sprite.getData('gold');
  ```

  Or you can access the value directly via the `values` property, where it works like any other variable:

  ```javascript
  sprite.data.values.gold += 50;
  ```

  When the value is first set, a `setdata` event is emitted from this Game Object.

  If the key already exists, a `changedata` event is emitted instead, along an event named after the key.
  For example, if you updated an existing key called `PlayerLives` then it would emit the event `changedata-PlayerLives`.
  These events will be emitted regardless if you use this method to set the value, or the direct `values` setter.

  Please note that the data keys are case-sensitive and must be valid JavaScript Object property strings.
  This means the keys `gold` and `Gold` are treated as two unique values within the Data Manager.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([video key]
   (phaser->clj
    (.setData video
              (clj->phaser key))))
  ([video key data]
   (phaser->clj
    (.setData video
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([video]
   (phaser->clj
    (.setDataEnabled video))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([video value]
   (phaser->clj
    (.setDepth video
               (clj->phaser value)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setDisplayOrigin video)))
  ([video x]
   (phaser->clj
    (.setDisplayOrigin video
                       (clj->phaser x))))
  ([video x y]
   (phaser->clj
    (.setDisplayOrigin video
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-display-size
  "Sets the display size of this Game Object.

  Calling this will adjust the scale.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([video width height]
   (phaser->clj
    (.setDisplaySize video
                     (clj->phaser width)
                     (clj->phaser height)))))

(defn set-flip
  "Sets the horizontal and vertical flipped state of this Game Object.

  A Game Object that is flipped will render inversed on the flipped axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.
    * y (boolean) - The horizontal flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([video x y]
   (phaser->clj
    (.setFlip video
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-flip-x
  "Sets the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([video value]
   (phaser->clj
    (.setFlipX video
               (clj->phaser value)))))

(defn set-flip-y
  "Sets the vertical flipped state of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (boolean) - The flipped state. `false` for no flip, or `true` to be flipped.

  Returns:  this - This Game Object instance."
  ([video value]
   (phaser->clj
    (.setFlipY video
               (clj->phaser value)))))

(defn set-frame
  "Sets the frame this Game Object will use to render with.

  The Frame has to belong to the current Texture being used.

  It can be either a string or an index.

  Calling `setFrame` will modify the `width` and `height` properties of your Game Object.
  It will also change the `origin` if the Frame has a custom pivot point, as exported from packages like Texture Packer.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * frame (string | integer) - The name or index of the frame within the Texture.
    * update-size (boolean) {optional} - Should this call adjust the size of the Game Object?
    * update-origin (boolean) {optional} - Should this call adjust the origin of the Game Object?

  Returns:  this - This Game Object instance."
  ([video frame]
   (phaser->clj
    (.setFrame video
               (clj->phaser frame))))
  ([video frame update-size]
   (phaser->clj
    (.setFrame video
               (clj->phaser frame)
               (clj->phaser update-size))))
  ([video frame update-size update-origin]
   (phaser->clj
    (.setFrame video
               (clj->phaser frame)
               (clj->phaser update-size)
               (clj->phaser update-origin)))))

(defn set-interactive
  "Pass this Game Object to the Input Manager to enable it for Input.

  Input works by using hit areas, these are nearly always geometric shapes, such as rectangles or circles, that act as the hit area
  for the Game Object. However, you can provide your own hit area shape and callback, should you wish to handle some more advanced
  input detection.

  If no arguments are provided it will try and create a rectangle hit area based on the texture frame the Game Object is using. If
  this isn't a texture-bound object, such as a Graphics or BitmapText object, this will fail, and you'll need to provide a specific
  shape for it to use.

  You can also provide an Input Configuration Object as the only argument to this method.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([video]
   (phaser->clj
    (.setInteractive video)))
  ([video shape]
   (phaser->clj
    (.setInteractive video
                     (clj->phaser shape))))
  ([video shape callback]
   (phaser->clj
    (.setInteractive video
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([video shape callback drop-zone]
   (phaser->clj
    (.setInteractive video
                     (clj->phaser shape)
                     (clj->phaser callback)
                     (clj->phaser drop-zone)))))

(defn set-loop
  "Sets the loop state of the current video.

  The value given is a boolean which indicates whether the media element will start over when it reaches the end.

  Not all videos can loop, for example live streams.

  Please note that not all browsers support _seamless_ video looping for all encoding formats.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (boolean) {optional} - A boolean which indicates whether the media element will start over when it reaches the end.

  Returns:  this - This Video Game Object for method chaining."
  ([video]
   (phaser->clj
    (.setLoop video)))
  ([video value]
   (phaser->clj
    (.setLoop video
              (clj->phaser value)))))

(defn set-mask
  "Sets the mask that this Game Object will use to render with.

  The mask must have been previously created and can be either a GeometryMask or a BitmapMask.
  Note: Bitmap Masks only work on WebGL. Geometry Masks work on both WebGL and Canvas.

  If a mask is already set on this Game Object it will be immediately replaced.

  Masks are positioned in global space and are not relative to the Game Object to which they
  are applied. The reason for this is that multiple Game Objects can all share the same mask.

  Masks have no impact on physics or input detection. They are purely a rendering component
  that allows you to limit what is visible during the render pass.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * mask (Phaser.Display.Masks.BitmapMask | Phaser.Display.Masks.GeometryMask) - The mask this Game Object will use when rendering.

  Returns:  this - This Game Object instance."
  ([video mask]
   (phaser->clj
    (.setMask video
              (clj->phaser mask)))))

(defn set-mute
  "Sets the muted state of the currently playing video, if one is loaded.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (boolean) {optional} - The mute value. `true` if the video should be muted, otherwise `false`.

  Returns:  this - This Video Game Object for method chaining."
  ([video]
   (phaser->clj
    (.setMute video)))
  ([video value]
   (phaser->clj
    (.setMute video
              (clj->phaser value)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([video value]
   (phaser->clj
    (.setName video
              (clj->phaser value)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setOrigin video)))
  ([video x]
   (phaser->clj
    (.setOrigin video
                (clj->phaser x))))
  ([video x y]
   (phaser->clj
    (.setOrigin video
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setOriginFromFrame video))))

(defn set-paused
  "Sets the paused state of the currently loaded video.

  If the video is playing, calling this method with `true` will pause playback.
  If the video is paused, calling this method with `false` will resume playback.

  If no video is loaded, this method does nothing.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (boolean) {optional} - The paused value. `true` if the video should be paused, `false` to resume it.

  Returns:  this - This Video Game Object for method chaining."
  ([video]
   (phaser->clj
    (.setPaused video)))
  ([video value]
   (phaser->clj
    (.setPaused video
                (clj->phaser value)))))

(defn set-pipeline
  "Sets the active WebGL Pipeline of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * pipeline-name (string) - The name of the pipeline to set on this Game Object.

  Returns:  this - This Game Object instance."
  ([video pipeline-name]
   (phaser->clj
    (.setPipeline video
                  (clj->phaser pipeline-name)))))

(defn set-playback-rate
  "Sets the playback rate of the current video.

  The value given is a double that indicates the rate at which the media is being played back.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * rate (number) {optional} - A double that indicates the rate at which the media is being played back.

  Returns:  this - This Video Game Object for method chaining."
  ([video]
   (phaser->clj
    (.setPlaybackRate video)))
  ([video rate]
   (phaser->clj
    (.setPlaybackRate video
                      (clj->phaser rate)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setPosition video)))
  ([video x]
   (phaser->clj
    (.setPosition video
                  (clj->phaser x))))
  ([video x y]
   (phaser->clj
    (.setPosition video
                  (clj->phaser x)
                  (clj->phaser y))))
  ([video x y z]
   (phaser->clj
    (.setPosition video
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([video x y z w]
   (phaser->clj
    (.setPosition video
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z)
                  (clj->phaser w)))))

(defn set-random-position
  "Sets the position of this Game Object to be a random position within the confines of
  the given area.

  If no area is specified a random position between 0 x 0 and the game width x height is used instead.

  The position does not factor in the size of this Game Object, meaning that only the origin is
  guaranteed to be within the area.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setRandomPosition video)))
  ([video x]
   (phaser->clj
    (.setRandomPosition video
                        (clj->phaser x))))
  ([video x y]
   (phaser->clj
    (.setRandomPosition video
                        (clj->phaser x)
                        (clj->phaser y))))
  ([video x y width]
   (phaser->clj
    (.setRandomPosition video
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([video x y width height]
   (phaser->clj
    (.setRandomPosition video
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setRotation video)))
  ([video radians]
   (phaser->clj
    (.setRotation video
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([video x]
   (phaser->clj
    (.setScale video
               (clj->phaser x))))
  ([video x y]
   (phaser->clj
    (.setScale video
               (clj->phaser x)
               (clj->phaser y)))))

(defn set-scroll-factor
  "Sets the scroll factor of this Game Object.

  The scroll factor controls the influence of the movement of a Camera upon this Game Object.

  When a camera scrolls it will change the location at which this Game Object is rendered on-screen.
  It does not change the Game Objects actual position values.

  A value of 1 means it will move exactly in sync with a camera.
  A value of 0 means it will not move at all, even if the camera moves.
  Other values control the degree to which the camera movement is mapped to this Game Object.

  Please be aware that scroll factor values other than 1 are not taken in to consideration when
  calculating physics collisions. Bodies always collide based on their world position, but changing
  the scroll factor is a visual adjustment to where the textures are rendered, which can offset
  them from physics bodies if not accounted for in your code.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([video x]
   (phaser->clj
    (.setScrollFactor video
                      (clj->phaser x))))
  ([video x y]
   (phaser->clj
    (.setScrollFactor video
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-size
  "Sets the internal size of this Game Object, as used for frame or physics body creation.

  This will not change the size that the Game Object is rendered in-game.
  For that you need to either set the scale of the Game Object (`setScale`) or call the
  `setDisplaySize` method, which is the same thing as changing the scale but allows you
  to do so by giving pixel values.

  If you have enabled this Game Object for input, changing the size will _not_ change the
  size of the hit area. To do this you should adjust the `input.hitArea` object directly.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * width (number) - The width of this Game Object.
    * height (number) - The height of this Game Object.

  Returns:  this - This Game Object instance."
  ([video width height]
   (phaser->clj
    (.setSize video
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-size-to-frame
  "Sets the size of this Game Object to be that of the given Frame.

  This will not change the size that the Game Object is rendered in-game.
  For that you need to either set the scale of the Game Object (`setScale`) or call the
  `setDisplaySize` method, which is the same thing as changing the scale but allows you
  to do so by giving pixel values.

  If you have enabled this Game Object for input, changing the size will _not_ change the
  size of the hit area. To do this you should adjust the `input.hitArea` object directly.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * frame (Phaser.Textures.Frame) - The frame to base the size of this Game Object on.

  Returns:  this - This Game Object instance."
  ([video frame]
   (phaser->clj
    (.setSizeToFrame video
                     (clj->phaser frame)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([video value]
   (phaser->clj
    (.setState video
               (clj->phaser value)))))

(defn set-texture
  "Sets the texture and frame this Game Object will use to render with.

  Textures are referenced by their string-based keys, as stored in the Texture Manager.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * key (string) - The key of the texture to be used, as stored in the Texture Manager.
    * frame (string | integer) {optional} - The name or index of the frame within the Texture.

  Returns:  this - This Game Object instance."
  ([video key]
   (phaser->clj
    (.setTexture video
                 (clj->phaser key))))
  ([video key frame]
   (phaser->clj
    (.setTexture video
                 (clj->phaser key)
                 (clj->phaser frame)))))

(defn set-tint
  "Sets an additive tint on this Game Object.

  The tint works by taking the pixel color values from the Game Objects texture, and then
  multiplying it by the color value of the tint. You can provide either one color value,
  in which case the whole Game Object will be tinted in that color. Or you can provide a color
  per corner. The colors are blended together across the extent of the Game Object.

  To modify the tint color once set, either call this method again with new values or use the
  `tint` property to set all colors at once. Or, use the properties `tintTopLeft`, `tintTopRight,
  `tintBottomLeft` and `tintBottomRight` to set the corner color values independently.

  To remove a tint call `clearTint`.

  To swap this from being an additive tint to a fill based tint set the property `tintFill` to `true`.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If no other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setTint video)))
  ([video top-left]
   (phaser->clj
    (.setTint video
              (clj->phaser top-left))))
  ([video top-left top-right]
   (phaser->clj
    (.setTint video
              (clj->phaser top-left)
              (clj->phaser top-right))))
  ([video top-left top-right bottom-left]
   (phaser->clj
    (.setTint video
              (clj->phaser top-left)
              (clj->phaser top-right)
              (clj->phaser bottom-left))))
  ([video top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTint video
              (clj->phaser top-left)
              (clj->phaser top-right)
              (clj->phaser bottom-left)
              (clj->phaser bottom-right)))))

(defn set-tint-fill
  "Sets a fill-based tint on this Game Object.

  Unlike an additive tint, a fill-tint literally replaces the pixel colors from the texture
  with those in the tint. You can use this for effects such as making a player flash 'white'
  if hit by something. You can provide either one color value, in which case the whole
  Game Object will be rendered in that color. Or you can provide a color per corner. The colors
  are blended together across the extent of the Game Object.

  To modify the tint color once set, either call this method again with new values or use the
  `tint` property to set all colors at once. Or, use the properties `tintTopLeft`, `tintTopRight,
  `tintBottomLeft` and `tintBottomRight` to set the corner color values independently.

  To remove a tint call `clearTint`.

  To swap this from being a fill-tint to an additive tint set the property `tintFill` to `false`.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * top-left (integer) {optional} - The tint being applied to the top-left of the Game Object. If not other values are given this value is applied evenly, tinting the whole Game Object.
    * top-right (integer) {optional} - The tint being applied to the top-right of the Game Object.
    * bottom-left (integer) {optional} - The tint being applied to the bottom-left of the Game Object.
    * bottom-right (integer) {optional} - The tint being applied to the bottom-right of the Game Object.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setTintFill video)))
  ([video top-left]
   (phaser->clj
    (.setTintFill video
                  (clj->phaser top-left))))
  ([video top-left top-right]
   (phaser->clj
    (.setTintFill video
                  (clj->phaser top-left)
                  (clj->phaser top-right))))
  ([video top-left top-right bottom-left]
   (phaser->clj
    (.setTintFill video
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left))))
  ([video top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setTintFill video
                  (clj->phaser top-left)
                  (clj->phaser top-right)
                  (clj->phaser bottom-left)
                  (clj->phaser bottom-right)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([video value]
   (phaser->clj
    (.setVisible video
                 (clj->phaser value)))))

(defn set-volume
  "Sets the volume of the currently playing video.

  The value given is a double indicating the audio volume, from 0.0 (silent) to 1.0 (loudest).

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (number) {optional} - A double indicating the audio volume, from 0.0 (silent) to 1.0 (loudest).

  Returns:  this - This Video Game Object for method chaining."
  ([video]
   (phaser->clj
    (.setVolume video)))
  ([video value]
   (phaser->clj
    (.setVolume video
                (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setW video)))
  ([video value]
   (phaser->clj
    (.setW video
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setX video)))
  ([video value]
   (phaser->clj
    (.setX video
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setY video)))
  ([video value]
   (phaser->clj
    (.setY video
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.setZ video)))
  ([video value]
   (phaser->clj
    (.setZ video
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([video]
   (phaser->clj
    (.shutdown video))))

(defn snapshot
  "Takes a snapshot of the current frame of the video and renders it to a CanvasTexture object,
  which is then returned. You can optionally resize the grab by passing a width and height.

  This method returns a reference to the `Video.snapshotTexture` object. Calling this method
  multiple times will overwrite the previous snapshot with the most recent one.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * width (integer) {optional} - The width of the resulting CanvasTexture.
    * height (integer) {optional} - The height of the resulting CanvasTexture.

  Returns:  Phaser.Textures.CanvasTexture - "
  ([video]
   (phaser->clj
    (.snapshot video)))
  ([video width]
   (phaser->clj
    (.snapshot video
               (clj->phaser width))))
  ([video width height]
   (phaser->clj
    (.snapshot video
               (clj->phaser width)
               (clj->phaser height)))))

(defn snapshot-area
  "Takes a snapshot of the specified area of the current frame of the video and renders it to a CanvasTexture object,
  which is then returned. You can optionally resize the grab by passing a different `destWidth` and `destHeight`.

  This method returns a reference to the `Video.snapshotTexture` object. Calling this method
  multiple times will overwrite the previous snapshot with the most recent one.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * x (integer) {optional} - The horizontal location of the top-left of the area to grab from.
    * y (integer) {optional} - The vertical location of the top-left of the area to grab from.
    * src-width (integer) {optional} - The width of area to grab from the video. If not given it will grab the full video dimensions.
    * src-height (integer) {optional} - The height of area to grab from the video. If not given it will grab the full video dimensions.
    * dest-width (integer) {optional} - The destination width of the grab, allowing you to resize it.
    * dest-height (integer) {optional} - The destination height of the grab, allowing you to resize it.

  Returns:  Phaser.Textures.CanvasTexture - "
  ([video]
   (phaser->clj
    (.snapshotArea video)))
  ([video x]
   (phaser->clj
    (.snapshotArea video
                   (clj->phaser x))))
  ([video x y]
   (phaser->clj
    (.snapshotArea video
                   (clj->phaser x)
                   (clj->phaser y))))
  ([video x y src-width]
   (phaser->clj
    (.snapshotArea video
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser src-width))))
  ([video x y src-width src-height]
   (phaser->clj
    (.snapshotArea video
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser src-width)
                   (clj->phaser src-height))))
  ([video x y src-width src-height dest-width]
   (phaser->clj
    (.snapshotArea video
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser src-width)
                   (clj->phaser src-height)
                   (clj->phaser dest-width))))
  ([video x y src-width src-height dest-width dest-height]
   (phaser->clj
    (.snapshotArea video
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser src-width)
                   (clj->phaser src-height)
                   (clj->phaser dest-width)
                   (clj->phaser dest-height)))))

(defn stop
  "Stops the video playing and clears all internal event listeners.

  If you only wish to pause playback of the video, and resume it a later time, use the `Video.pause` method instead.

  If the video hasn't finished downloading, calling this method will not abort the download. To do that you need to
  call `destroy` instead.

  Returns:  this - This Video Game Object for method chaining."
  ([video]
   (phaser->clj
    (.stop video))))

(defn time-update-handler
  "Called when the video emits a `timeUpdate` event during playback.

  This event is too slow and irregular to be used for actual video timing or texture updating,
  but we can use it to determine if a video has looped."
  ([video]
   (phaser->clj
    (.timeUpdateHandler video))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([video]
   (phaser->clj
    (.toJSON video))))

(defn toggle-flip-x
  "Toggles the horizontal flipped state of this Game Object.

  A Game Object that is flipped horizontally will render inversed on the horizontal axis.
  Flipping always takes place from the middle of the texture and does not impact the scale value.
  If this Game Object has a physics body, it will not change the body. This is a rendering toggle only.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.toggleFlipX video))))

(defn toggle-flip-y
  "Toggles the vertical flipped state of this Game Object.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.toggleFlipY video))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * args (*) {optional} - args"
  ([video]
   (phaser->clj
    (.update video)))
  ([video args]
   (phaser->clj
    (.update video
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([video]
   (phaser->clj
    (.updateDisplayOrigin video))))

(defn update-texture
  "Internal method that is called when enough video data has been received in order to create a texture
  from it. The texture is assigned to the `Video.videoTexture` property and given a base frame that
  encompases the whole video size."
  ([video]
   (phaser->clj
    (.updateTexture video))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.
  Also checks the Game Object against the given Cameras exclusion list.

  Parameters:
    * video (Phaser.GameObjects.Video) - Targeted instance for method
    * camera (Phaser.Cameras.Scene2D.Camera) - The Camera to check against this Game Object.

  Returns:  boolean - True if the Game Object should be rendered, otherwise false."
  ([video camera]
   (phaser->clj
    (.willRender video
                 (clj->phaser camera)))))