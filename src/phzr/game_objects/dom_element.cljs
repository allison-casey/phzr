(ns phzr.game-objects.dom-element
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [update]))

(defn ->DOMElement
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object belongs. A Game Object can only belong to one Scene at a time.
    * x (number) {optional} - The horizontal position of this DOM Element in the world.
    * y (number) {optional} - The vertical position of this DOM Element in the world.
    * element (Element | string) {optional} - An existing DOM element, or a string. If a string starting with a # it will do a `getElementById` look-up on the string (minus the hash). Without a hash, it represents the type of element to create, i.e. 'div'.
    * style (string | any) {optional} - If a string, will be set directly as the elements `style` property value. If a plain object, will be iterated and the values transferred. In both cases the values replacing whatever CSS styles may have been previously set.
    * inner-text (string) {optional} - If given, will be set directly as the elements `innerText` property value, replacing whatever was there before."
  ([scene]
   (js/Phaser.GameObjects.DOMElement. (clj->phaser scene)))
  ([scene x]
   (js/Phaser.GameObjects.DOMElement. (clj->phaser scene)
                                      (clj->phaser x)))
  ([scene x y]
   (js/Phaser.GameObjects.DOMElement. (clj->phaser scene)
                                      (clj->phaser x)
                                      (clj->phaser y)))
  ([scene x y element]
   (js/Phaser.GameObjects.DOMElement. (clj->phaser scene)
                                      (clj->phaser x)
                                      (clj->phaser y)
                                      (clj->phaser element)))
  ([scene x y element style]
   (js/Phaser.GameObjects.DOMElement. (clj->phaser scene)
                                      (clj->phaser x)
                                      (clj->phaser y)
                                      (clj->phaser element)
                                      (clj->phaser style)))
  ([scene x y element style inner-text]
   (js/Phaser.GameObjects.DOMElement. (clj->phaser scene)
                                      (clj->phaser x)
                                      (clj->phaser y)
                                      (clj->phaser element)
                                      (clj->phaser style)
                                      (clj->phaser inner-text))))

(defn add-listener
  "Adds one or more native DOM event listeners onto the underlying Element of this Game Object.
  The event is then dispatched via this Game Objects standard event emitter.

  For example:

  ```javascript
  var div = this.add.dom(x, y, element);

  div.addListener('click');

  div.on('click', handler);
  ```

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * events (string) - The DOM event/s to listen for. You can specify multiple events by separating them with spaces.

  Returns:  this - This DOM Element instance."
  ([dom-element events]
   (phaser->clj
    (.addListener dom-element
                  (clj->phaser events)))))

(defn clear-alpha
  "Clears all alpha values associated with this Game Object.

  Immediately sets the alpha levels back to 1 (fully opaque).

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.clearAlpha dom-element))))

(defn create-element
  "Creates a native DOM Element, adds it to the parent DOM Container and then binds it to this Game Object,
  so you can control it. The `tagName` should be a string and is passed to `document.createElement`:

  ```javascript
  this.add.dom().createElement('div');
  ```

  For more details on acceptable tag names see: https://developer.mozilla.org/en-US/docs/Web/API/Document/createElement

  You can also pass in a DOMString or style object to set the CSS on the created element, and an optional `innerText`
  value as well. Here is an example of a DOMString:

  ```javascript
  this.add.dom().createElement('div', 'background-color: lime; width: 220px; height: 100px; font: 48px Arial', 'Phaser');
  ```

  And using a style object:

  ```javascript
  var style = {
    'background-color': 'lime';
    'width': '200px';
    'height': '100px';
    'font': '48px Arial';
  };

  this.add.dom().createElement('div', style, 'Phaser');
  ```

  If this Game Object already has an Element, it is removed from the DOM entirely first.
  Any event listeners you may have previously created will need to be re-created after this call.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * tag-name (string) - A string that specifies the type of element to be created. The nodeName of the created element is initialized with the value of tagName. Don't use qualified names (like 'html:a') with this method.
    * style (string | any) {optional} - Either a DOMString that holds the CSS styles to be applied to the created element, or an object the styles will be ready from.
    * inner-text (string) {optional} - A DOMString that holds the text that will be set as the innerText of the created element.

  Returns:  this - This DOM Element instance."
  ([dom-element tag-name]
   (phaser->clj
    (.createElement dom-element
                    (clj->phaser tag-name))))
  ([dom-element tag-name style]
   (phaser->clj
    (.createElement dom-element
                    (clj->phaser tag-name)
                    (clj->phaser style))))
  ([dom-element tag-name style inner-text]
   (phaser->clj
    (.createElement dom-element
                    (clj->phaser tag-name)
                    (clj->phaser style)
                    (clj->phaser inner-text)))))

(defn create-from-cache
  "Takes a block of html from the HTML Cache, that has previously been preloaded into the game, and then
  creates a DOM Element from it. The loaded HTML is set as the `innerHTML` property of the created
  element.

  Assume the following html is stored in a file called `loginform.html`:

  ```html
  <input type='text' name='nameField' placeholder='Enter your name' style='font-size: 32px'>
  <input type='button' name='playButton' value='Let's Play' style='font-size: 32px'>
  ```

  Which is loaded into your game using the cache key 'login':

  ```javascript
  this.load.html('login', 'assets/loginform.html');
  ```

  You can create a DOM Element from it using the cache key:

  ```javascript
  this.add.dom().createFromCache('login');
  ```

  The optional `elementType` argument controls the container that is created, into which the loaded html is inserted.
  The default is a plain `div` object, but any valid tagName can be given.

  If this Game Object already has an Element, it is removed from the DOM entirely first.
  Any event listeners you may have previously created will need to be re-created after this call.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * the (string) - key of the html cache entry to use for this DOM Element.
    * tag-name (string) {optional} - The tag name of the element into which all of the loaded html will be inserted. Defaults to a plain div tag.

  Returns:  this - This DOM Element instance."
  ([dom-element the]
   (phaser->clj
    (.createFromCache dom-element
                      (clj->phaser the))))
  ([dom-element the tag-name]
   (phaser->clj
    (.createFromCache dom-element
                      (clj->phaser the)
                      (clj->phaser tag-name)))))

(defn create-from-html
  "Takes a string of html and then creates a DOM Element from it. The HTML is set as the `innerHTML`
  property of the created element.

  ```javascript
  let form = `
  <input type='text' name='nameField' placeholder='Enter your name' style='font-size: 32px'>
  <input type='button' name='playButton' value='Let's Play' style='font-size: 32px'>
  `;
  ```

  You can create a DOM Element from it using the string:

  ```javascript
  this.add.dom().createFromHTML(form);
  ```

  The optional `elementType` argument controls the type of container that is created, into which the html is inserted.
  The default is a plain `div` object, but any valid tagName can be given.

  If this Game Object already has an Element, it is removed from the DOM entirely first.
  Any event listeners you may have previously created will need to be re-created after this call.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * a (string) - string of html to be set as the `innerHTML` property of the created element.
    * tag-name (string) {optional} - The tag name of the element into which all of the html will be inserted. Defaults to a plain div tag.

  Returns:  this - This DOM Element instance."
  ([dom-element a]
   (phaser->clj
    (.createFromHTML dom-element
                     (clj->phaser a))))
  ([dom-element a tag-name]
   (phaser->clj
    (.createFromHTML dom-element
                     (clj->phaser a)
                     (clj->phaser tag-name)))))

(defn destroy
  "Destroys this Game Object removing it from the Display List and Update List and
  severing all ties to parent resources.

  Also removes itself from the Input Manager and Physics Manager if previously enabled.

  Use this to remove a Game Object from your game if you don't ever plan to use it again.
  As long as no reference to it exists within your own code it should become free for
  garbage collection by the browser.

  If you just want to temporarily disable an object then look at using the
  Game Object Pool instead of destroying it, as destroyed objects cannot be resurrected.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * from-scene (boolean) {optional} - Is this Game Object being destroyed as the result of a Scene shutdown?"
  ([dom-element]
   (phaser->clj
    (.destroy dom-element)))
  ([dom-element from-scene]
   (phaser->clj
    (.destroy dom-element
              (clj->phaser from-scene)))))

(defn disable-interactive
  "If this Game Object has previously been enabled for input, this will disable it.

  An object that is disabled for input stops processing or being considered for
  input events, but can be turned back on again at any time by simply calling
  `setInteractive()` with no arguments provided.

  If want to completely remove interaction from this Game Object then use `removeInteractive` instead.

  Returns:  this - This GameObject."
  ([dom-element]
   (phaser->clj
    (.disableInteractive dom-element))))

(defn emit
  "Calls each of the listeners registered for a given event.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * event (string | symbol) - The event name.
    * args (*) {optional} - Additional arguments that will be passed to the event handler.

  Returns:  boolean - `true` if the event had listeners, else `false`."
  ([dom-element event]
   (phaser->clj
    (.emit dom-element
           (clj->phaser event))))
  ([dom-element event args]
   (phaser->clj
    (.emit dom-element
           (clj->phaser event)
           (clj->phaser args)))))

(defn event-names
  "Return an array listing the events for which the emitter has registered listeners.

  Returns:  array - "
  ([dom-element]
   (phaser->clj
    (.eventNames dom-element))))

(defn get-child-by-id
  "Gets all children from this DOM Elements node, using `querySelectorAll('*')` and then iterates through
  them, looking for the first one that has a matching id. It then returns this child if found, or `null` if not.

  Be aware that class and id names are case-sensitive.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * id (string) - The id to search the children for.

  Returns:  Element - The first matching child DOM Element, or `null` if not found."
  ([dom-element id]
   (phaser->clj
    (.getChildByID dom-element
                   (clj->phaser id)))))

(defn get-child-by-name
  "Gets all children from this DOM Elements node, using `querySelectorAll('*')` and then iterates through
  them, looking for the first one that has a matching name. It then returns this child if found, or `null` if not.

  Be aware that class and id names are case-sensitive.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * name (string) - The name to search the children for.

  Returns:  Element - The first matching child DOM Element, or `null` if not found."
  ([dom-element name]
   (phaser->clj
    (.getChildByName dom-element
                     (clj->phaser name)))))

(defn get-child-by-property
  "Gets all children from this DOM Elements node, using `querySelectorAll('*')` and then iterates through
  them, looking for the first one that has a property matching the given key and value. It then returns this child
  if found, or `null` if not.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * property (string) - The property to search the children for.
    * value (string) - The value the property must strictly equal.

  Returns:  Element - The first matching child DOM Element, or `null` if not found."
  ([dom-element property value]
   (phaser->clj
    (.getChildByProperty dom-element
                         (clj->phaser property)
                         (clj->phaser value)))))

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
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * key (string | Array.<string>) - The key of the value to retrieve, or an array of keys.

  Returns:  * - The value belonging to the given key, or an array of values, the order of which will match the input array."
  ([dom-element key]
   (phaser->clj
    (.getData dom-element
              (clj->phaser key)))))

(defn get-index-list
  "Returns an array containing the display list index of either this Game Object, or if it has one,
  its parent Container. It then iterates up through all of the parent containers until it hits the
  root of the display list (which is index 0 in the returned array).

  Used internally by the InputPlugin but also useful if you wish to find out the display depth of
  this Game Object and all of its ancestors.

  Returns:  Array.<integer> - An array of display list position indexes."
  ([dom-element]
   (phaser->clj
    (.getIndexList dom-element))))

(defn get-local-transform-matrix
  "Gets the local transform matrix for this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([dom-element]
   (phaser->clj
    (.getLocalTransformMatrix dom-element)))
  ([dom-element temp-matrix]
   (phaser->clj
    (.getLocalTransformMatrix dom-element
                              (clj->phaser temp-matrix)))))

(defn get-parent-rotation
  "Gets the sum total rotation of all of this Game Objects parent Containers.

  The returned value is in radians and will be zero if this Game Object has no parent container.

  Returns:  number - The sum total rotation, in radians, of all parent containers of this Game Object."
  ([dom-element]
   (phaser->clj
    (.getParentRotation dom-element))))

(defn get-world-transform-matrix
  "Gets the world transform matrix for this Game Object, factoring in any parent Containers.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * temp-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - The matrix to populate with the values from this Game Object.
    * parent-matrix (Phaser.GameObjects.Components.TransformMatrix) {optional} - A temporary matrix to hold parent values during the calculations.

  Returns:  Phaser.GameObjects.Components.TransformMatrix - The populated Transform Matrix."
  ([dom-element]
   (phaser->clj
    (.getWorldTransformMatrix dom-element)))
  ([dom-element temp-matrix]
   (phaser->clj
    (.getWorldTransformMatrix dom-element
                              (clj->phaser temp-matrix))))
  ([dom-element temp-matrix parent-matrix]
   (phaser->clj
    (.getWorldTransformMatrix dom-element
                              (clj->phaser temp-matrix)
                              (clj->phaser parent-matrix)))))

(defn listener-count
  "Return the number of listeners listening to a given event.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  number - The number of listeners."
  ([dom-element event]
   (phaser->clj
    (.listenerCount dom-element
                    (clj->phaser event)))))

(defn listeners
  "Return the listeners registered for a given event.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * event (string | symbol) - The event name.

  Returns:  array - The registered listeners."
  ([dom-element event]
   (phaser->clj
    (.listeners dom-element
                (clj->phaser event)))))

(defn off
  "Remove the listeners of a given event.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) {optional} - Only remove the listeners that match this function.
    * context (*) {optional} - Only remove the listeners that have this context.
    * once (boolean) {optional} - Only remove one-time listeners.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dom-element event]
   (phaser->clj
    (.off dom-element
          (clj->phaser event))))
  ([dom-element event fn]
   (phaser->clj
    (.off dom-element
          (clj->phaser event)
          (clj->phaser fn))))
  ([dom-element event fn context]
   (phaser->clj
    (.off dom-element
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context))))
  ([dom-element event fn context once]
   (phaser->clj
    (.off dom-element
          (clj->phaser event)
          (clj->phaser fn)
          (clj->phaser context)
          (clj->phaser once)))))

(defn on
  "Add a listener for a given event.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dom-element event fn]
   (phaser->clj
    (.on dom-element
         (clj->phaser event)
         (clj->phaser fn))))
  ([dom-element event fn context]
   (phaser->clj
    (.on dom-element
         (clj->phaser event)
         (clj->phaser fn)
         (clj->phaser context)))))

(defn once
  "Add a one-time listener for a given event.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * event (string | symbol) - The event name.
    * fn (function) - The listener function.
    * context (*) {optional} - The context to invoke the listener with.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dom-element event fn]
   (phaser->clj
    (.once dom-element
           (clj->phaser event)
           (clj->phaser fn))))
  ([dom-element event fn context]
   (phaser->clj
    (.once dom-element
           (clj->phaser event)
           (clj->phaser fn)
           (clj->phaser context)))))

(defn remove-all-listeners
  "Remove all listeners, or those of the specified event.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * event (string | symbol) {optional} - The event name.

  Returns:  Phaser.Events.EventEmitter - `this`."
  ([dom-element]
   (phaser->clj
    (.removeAllListeners dom-element)))
  ([dom-element event]
   (phaser->clj
    (.removeAllListeners dom-element
                         (clj->phaser event)))))

(defn remove-element
  "Removes the current DOM Element bound to this Game Object from the DOM entirely and resets the
  `node` property of this Game Object to be `null`.

  Returns:  this - This DOM Element instance."
  ([dom-element]
   (phaser->clj
    (.removeElement dom-element))))

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
  ([dom-element]
   (phaser->clj
    (.removeInteractive dom-element))))

(defn remove-listener
  "Removes one or more native DOM event listeners from the underlying Element of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * events (string) - The DOM event/s to stop listening for. You can specify multiple events by separating them with spaces.

  Returns:  this - This DOM Element instance."
  ([dom-element events]
   (phaser->clj
    (.removeListener dom-element
                     (clj->phaser events)))))

(defn set-active
  "Sets the `active` property of this Game Object and returns this Game Object for further chaining.
  A Game Object with its `active` property set to `true` will be updated by the Scenes UpdateList.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (boolean) - True if this Game Object should be set as active, false if not.

  Returns:  this - This GameObject."
  ([dom-element value]
   (phaser->clj
    (.setActive dom-element
                (clj->phaser value)))))

(defn set-alpha
  "Set the Alpha level of this Game Object. The alpha controls the opacity of the Game Object as it renders.
  Alpha values are provided as a float between 0, fully transparent, and 1, fully opaque.

  If your game is running under WebGL you can optionally specify four different alpha values, each of which
  correspond to the four corners of the Game Object. Under Canvas only the `topLeft` value given is used.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * top-left (number) {optional} - The alpha value used for the top-left of the Game Object. If this is the only value given it's applied across the whole Game Object.
    * top-right (number) {optional} - The alpha value used for the top-right of the Game Object. WebGL only.
    * bottom-left (number) {optional} - The alpha value used for the bottom-left of the Game Object. WebGL only.
    * bottom-right (number) {optional} - The alpha value used for the bottom-right of the Game Object. WebGL only.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setAlpha dom-element)))
  ([dom-element top-left]
   (phaser->clj
    (.setAlpha dom-element
               (clj->phaser top-left))))
  ([dom-element top-left top-right]
   (phaser->clj
    (.setAlpha dom-element
               (clj->phaser top-left)
               (clj->phaser top-right))))
  ([dom-element top-left top-right bottom-left]
   (phaser->clj
    (.setAlpha dom-element
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left))))
  ([dom-element top-left top-right bottom-left bottom-right]
   (phaser->clj
    (.setAlpha dom-element
               (clj->phaser top-left)
               (clj->phaser top-right)
               (clj->phaser bottom-left)
               (clj->phaser bottom-right)))))

(defn set-angle
  "Sets the angle of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * degrees (number) {optional} - The rotation of this Game Object, in degrees.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setAngle dom-element)))
  ([dom-element degrees]
   (phaser->clj
    (.setAngle dom-element
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
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (string | Phaser.BlendModes) - The BlendMode value. Either a string or a CONST.

  Returns:  this - This Game Object instance."
  ([dom-element value]
   (phaser->clj
    (.setBlendMode dom-element
                   (clj->phaser value)))))

(defn set-class-name
  "Sets the `className` property of the DOM Element node and updates the internal sizes.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * class-name (string) - A string representing the class or space-separated classes of the element.

  Returns:  this - This DOM Element instance."
  ([dom-element class-name]
   (phaser->clj
    (.setClassName dom-element
                   (clj->phaser class-name)))))

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
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * key (string | object) - The key to set the value for. Or an object of key value pairs. If an object the `data` argument is ignored.
    * data (*) {optional} - The value to set for the given key. If an object is provided as the key this argument is ignored.

  Returns:  this - This GameObject."
  ([dom-element key]
   (phaser->clj
    (.setData dom-element
              (clj->phaser key))))
  ([dom-element key data]
   (phaser->clj
    (.setData dom-element
              (clj->phaser key)
              (clj->phaser data)))))

(defn set-data-enabled
  "Adds a Data Manager component to this Game Object.

  Returns:  this - This GameObject."
  ([dom-element]
   (phaser->clj
    (.setDataEnabled dom-element))))

(defn set-depth
  "The depth of this Game Object within the Scene.

  The depth is also known as the 'z-index' in some environments, and allows you to change the rendering order
  of Game Objects, without actually moving their position in the display list.

  The depth starts from zero (the default value) and increases from that point. A Game Object with a higher depth
  value will always render in front of one with a lower value.

  Setting the depth will queue a depth sort event within the Scene.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (integer) - The depth of this Game Object.

  Returns:  this - This Game Object instance."
  ([dom-element value]
   (phaser->clj
    (.setDepth dom-element
               (clj->phaser value)))))

(defn set-display-origin
  "Sets the display origin of this Game Object.
  The difference between this and setting the origin is that you can use pixel values for setting the display origin.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * x (number) {optional} - The horizontal display origin value.
    * y (number) {optional} - The vertical display origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setDisplayOrigin dom-element)))
  ([dom-element x]
   (phaser->clj
    (.setDisplayOrigin dom-element
                       (clj->phaser x))))
  ([dom-element x y]
   (phaser->clj
    (.setDisplayOrigin dom-element
                       (clj->phaser x)
                       (clj->phaser y)))))

(defn set-element
  "Binds a new DOM Element to this Game Object. If this Game Object already has an Element it is removed from the DOM
  entirely first. Any event listeners you may have previously created will need to be re-created on the new element.

  The `element` argument you pass to this method can be either a string tagName:

  ```javascript
  <h1 id='heading'>Phaser</h1>

  this.add.dom().setElement('heading');
  ```

  Or a reference to an Element instance:

  ```javascript
  <h1 id='heading'>Phaser</h1>

  var h1 = document.getElementById('heading');

  this.add.dom().setElement(h1);
  ```

  You can also pass in a DOMString or style object to set the CSS on the created element, and an optional `innerText`
  value as well. Here is an example of a DOMString:

  ```javascript
  this.add.dom().setElement(h1, 'background-color: lime; width: 220px; height: 100px; font: 48px Arial', 'Phaser');
  ```

  And using a style object:

  ```javascript
  var style = {
    'background-color': 'lime';
    'width': '200px';
    'height': '100px';
    'font': '48px Arial';
  };

  this.add.dom().setElement(h1, style, 'Phaser');
  ```

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * element (string | Element) - If a string it is passed to `getElementById()`, or it should be a reference to an existing Element.
    * style (string | any) {optional} - Either a DOMString that holds the CSS styles to be applied to the created element, or an object the styles will be ready from.
    * inner-text (string) {optional} - A DOMString that holds the text that will be set as the innerText of the created element.

  Returns:  this - This DOM Element instance."
  ([dom-element element]
   (phaser->clj
    (.setElement dom-element
                 (clj->phaser element))))
  ([dom-element element style]
   (phaser->clj
    (.setElement dom-element
                 (clj->phaser element)
                 (clj->phaser style))))
  ([dom-element element style inner-text]
   (phaser->clj
    (.setElement dom-element
                 (clj->phaser element)
                 (clj->phaser style)
                 (clj->phaser inner-text)))))

(defn set-html
  "Sets the `innerHTML` property of the DOM Element node and updates the internal sizes.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * html (string) - A DOMString of html to be set as the `innerHTML` property of the element.

  Returns:  this - This DOM Element instance."
  ([dom-element html]
   (phaser->clj
    (.setHTML dom-element
              (clj->phaser html)))))

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
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * shape (Phaser.Types.Input.InputConfiguration | any) {optional} - Either an input configuration object, or a geometric shape that defines the hit area for the Game Object. If not specified a Rectangle will be used.
    * callback (Phaser.Types.Input.HitAreaCallback) {optional} - A callback to be invoked when the Game Object is interacted with. If you provide a shape you must also provide a callback.
    * drop-zone (boolean) {optional} - Should this Game Object be treated as a drop zone target?

  Returns:  this - This GameObject."
  ([dom-element]
   (phaser->clj
    (.setInteractive dom-element)))
  ([dom-element shape]
   (phaser->clj
    (.setInteractive dom-element
                     (clj->phaser shape))))
  ([dom-element shape callback]
   (phaser->clj
    (.setInteractive dom-element
                     (clj->phaser shape)
                     (clj->phaser callback))))
  ([dom-element shape callback drop-zone]
   (phaser->clj
    (.setInteractive dom-element
                     (clj->phaser shape)
                     (clj->phaser callback)
                     (clj->phaser drop-zone)))))

(defn set-name
  "Sets the `name` property of this Game Object and returns this Game Object for further chaining.
  The `name` property is not populated by Phaser and is presented for your own use.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (string) - The name to be given to this Game Object.

  Returns:  this - This GameObject."
  ([dom-element value]
   (phaser->clj
    (.setName dom-element
              (clj->phaser value)))))

(defn set-origin
  "Sets the origin of this Game Object.

  The values are given in the range 0 to 1.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * x (number) {optional} - The horizontal origin value.
    * y (number) {optional} - The vertical origin value. If not defined it will be set to the value of `x`.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setOrigin dom-element)))
  ([dom-element x]
   (phaser->clj
    (.setOrigin dom-element
                (clj->phaser x))))
  ([dom-element x y]
   (phaser->clj
    (.setOrigin dom-element
                (clj->phaser x)
                (clj->phaser y)))))

(defn set-origin-from-frame
  "Sets the origin of this Game Object based on the Pivot values in its Frame.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setOriginFromFrame dom-element))))

(defn set-perspective
  "Sets the perspective CSS property of the _parent DOM Container_. This determines the distance between the z=0
  plane and the user in order to give a 3D-positioned element some perspective. Each 3D element with
  z > 0 becomes larger; each 3D-element with z < 0 becomes smaller. The strength of the effect is determined
  by the value of this property.

  For more information see: https://developer.mozilla.org/en-US/docs/Web/CSS/perspective

  **Changing this value changes it globally for all DOM Elements, as they all share the same parent container.**

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (number) - The perspective value, in pixels, that determines the distance between the z plane and the user.

  Returns:  this - This DOM Element instance."
  ([dom-element value]
   (phaser->clj
    (.setPerspective dom-element
                     (clj->phaser value)))))

(defn set-position
  "Sets the position of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * x (number) {optional} - The x position of this Game Object.
    * y (number) {optional} - The y position of this Game Object. If not set it will use the `x` value.
    * z (number) {optional} - The z position of this Game Object.
    * w (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setPosition dom-element)))
  ([dom-element x]
   (phaser->clj
    (.setPosition dom-element
                  (clj->phaser x))))
  ([dom-element x y]
   (phaser->clj
    (.setPosition dom-element
                  (clj->phaser x)
                  (clj->phaser y))))
  ([dom-element x y z]
   (phaser->clj
    (.setPosition dom-element
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser z))))
  ([dom-element x y z w]
   (phaser->clj
    (.setPosition dom-element
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
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * x (number) {optional} - The x position of the top-left of the random area.
    * y (number) {optional} - The y position of the top-left of the random area.
    * width (number) {optional} - The width of the random area.
    * height (number) {optional} - The height of the random area.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setRandomPosition dom-element)))
  ([dom-element x]
   (phaser->clj
    (.setRandomPosition dom-element
                        (clj->phaser x))))
  ([dom-element x y]
   (phaser->clj
    (.setRandomPosition dom-element
                        (clj->phaser x)
                        (clj->phaser y))))
  ([dom-element x y width]
   (phaser->clj
    (.setRandomPosition dom-element
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width))))
  ([dom-element x y width height]
   (phaser->clj
    (.setRandomPosition dom-element
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser width)
                        (clj->phaser height)))))

(defn set-rotation
  "Sets the rotation of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * radians (number) {optional} - The rotation of this Game Object, in radians.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setRotation dom-element)))
  ([dom-element radians]
   (phaser->clj
    (.setRotation dom-element
                  (clj->phaser radians)))))

(defn set-scale
  "Sets the scale of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * x (number) - The horizontal scale of this Game Object.
    * y (number) {optional} - The vertical scale of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([dom-element x]
   (phaser->clj
    (.setScale dom-element
               (clj->phaser x))))
  ([dom-element x y]
   (phaser->clj
    (.setScale dom-element
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
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * x (number) - The horizontal scroll factor of this Game Object.
    * y (number) {optional} - The vertical scroll factor of this Game Object. If not set it will use the `x` value.

  Returns:  this - This Game Object instance."
  ([dom-element x]
   (phaser->clj
    (.setScrollFactor dom-element
                      (clj->phaser x))))
  ([dom-element x y]
   (phaser->clj
    (.setScrollFactor dom-element
                      (clj->phaser x)
                      (clj->phaser y)))))

(defn set-skew
  "Sets the horizontal and vertical skew values of this DOM Element.

  For more information see: https://developer.mozilla.org/en-US/docs/Web/CSS/transform

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * x (number) {optional} - The angle, in radians, by which to skew the DOM Element on the horizontal axis.
    * y (number) {optional} - The angle, in radians, by which to skew the DOM Element on the vertical axis.

  Returns:  this - This DOM Element instance."
  ([dom-element]
   (phaser->clj
    (.setSkew dom-element)))
  ([dom-element x]
   (phaser->clj
    (.setSkew dom-element
              (clj->phaser x))))
  ([dom-element x y]
   (phaser->clj
    (.setSkew dom-element
              (clj->phaser x)
              (clj->phaser y)))))

(defn set-state
  "Sets the current state of this Game Object.

  Phaser itself will never modify the State of a Game Object, although plugins may do so.

  For example, a Game Object could change from a state of 'moving', to 'attacking', to 'dead'.
  The state value should typically be an integer (ideally mapped to a constant
  in your game code), but could also be a string. It is recommended to keep it light and simple.
  If you need to store complex data about your Game Object, look at using the Data Component instead.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (integer | string) - The state of the Game Object.

  Returns:  this - This GameObject."
  ([dom-element value]
   (phaser->clj
    (.setState dom-element
               (clj->phaser value)))))

(defn set-text
  "Sets the `innerText` property of the DOM Element node and updates the internal sizes.

  Note that only certain types of Elements can have `innerText` set on them.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * text (string) - A DOMString representing the rendered text content of the element.

  Returns:  this - This DOM Element instance."
  ([dom-element text]
   (phaser->clj
    (.setText dom-element
              (clj->phaser text)))))

(defn set-visible
  "Sets the visibility of this Game Object.

  An invisible Game Object will skip rendering, but will still process update logic.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (boolean) - The visible state of the Game Object.

  Returns:  this - This Game Object instance."
  ([dom-element value]
   (phaser->clj
    (.setVisible dom-element
                 (clj->phaser value)))))

(defn set-w
  "Sets the w position of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (number) {optional} - The w position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setW dom-element)))
  ([dom-element value]
   (phaser->clj
    (.setW dom-element
           (clj->phaser value)))))

(defn set-x
  "Sets the x position of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (number) {optional} - The x position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setX dom-element)))
  ([dom-element value]
   (phaser->clj
    (.setX dom-element
           (clj->phaser value)))))

(defn set-y
  "Sets the y position of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (number) {optional} - The y position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setY dom-element)))
  ([dom-element value]
   (phaser->clj
    (.setY dom-element
           (clj->phaser value)))))

(defn set-z
  "Sets the z position of this Game Object.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * value (number) {optional} - The z position of this Game Object.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.setZ dom-element)))
  ([dom-element value]
   (phaser->clj
    (.setZ dom-element
           (clj->phaser value)))))

(defn shutdown
  "Removes all listeners."
  ([dom-element]
   (phaser->clj
    (.shutdown dom-element))))

(defn to-json
  "Returns a JSON representation of the Game Object.

  Returns:  Phaser.Types.GameObjects.JSONGameObject - A JSON representation of the Game Object."
  ([dom-element]
   (phaser->clj
    (.toJSON dom-element))))

(defn update
  "To be overridden by custom GameObjects. Allows base objects to be used in a Pool.

  Parameters:
    * dom-element (Phaser.GameObjects.DOMElement) - Targeted instance for method
    * args (*) {optional} - args"
  ([dom-element]
   (phaser->clj
    (.update dom-element)))
  ([dom-element args]
   (phaser->clj
    (.update dom-element
             (clj->phaser args)))))

(defn update-display-origin
  "Updates the Display Origin cached values internally stored on this Game Object.
  You don't usually call this directly, but it is exposed for edge-cases where you may.

  Returns:  this - This Game Object instance."
  ([dom-element]
   (phaser->clj
    (.updateDisplayOrigin dom-element))))

(defn update-size
  "Internal method that calls `getBoundingClientRect` on the `node` and then sets the bounds width
  and height into the `displayWidth` and `displayHeight` properties, and the `clientWidth` and `clientHeight`
  values into the `width` and `height` properties respectively.

  This is called automatically whenever a new element is created or set.

  Returns:  this - This DOM Element instance."
  ([dom-element]
   (phaser->clj
    (.updateSize dom-element))))

(defn will-render
  "Compares the renderMask with the renderFlags to see if this Game Object will render or not.

  DOMElements always return `true` as they need to still set values during the render pass, even if not visible.

  Returns:  boolean - `true` if the Game Object should be rendered, otherwise `false`."
  ([dom-element]
   (phaser->clj
    (.willRender dom-element))))