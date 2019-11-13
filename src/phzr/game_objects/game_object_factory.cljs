(ns phzr.game-objects.game-object-factory
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->GameObjectFactory
  "  Parameters:
    * scene (Phaser.Scene) - The Scene to which this Game Object Factory belongs."
  ([scene]
   (js/Phaser.GameObjects.GameObjectFactory. (clj->phaser scene))))

(defn arc
  "Creates a new Arc Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Arc Game Object has been built into Phaser.

  The Arc Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports both fill and stroke colors.

  When it renders it displays an arc shape. You can control the start and end angles of the arc,
  as well as if the angles are winding clockwise or anti-clockwise. With the default settings
  it renders as a complete circle. By changing the angles you can create other arc shapes,
  such as half-circles.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * radius (number) {optional} - The radius of the arc.
    * start-angle (integer) {optional} - The start angle of the arc, in degrees.
    * end-angle (integer) {optional} - The end angle of the arc, in degrees.
    * anticlockwise (boolean) {optional} - The winding order of the start and end angles.
    * fill-color (number) {optional} - The color the arc will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the arc will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Arc - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.arc game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.arc game-object-factory
          (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.arc game-object-factory
          (clj->phaser x)
          (clj->phaser y))))
  ([game-object-factory x y radius]
   (phaser->clj
    (.arc game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius))))
  ([game-object-factory x y radius start-angle]
   (phaser->clj
    (.arc game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser start-angle))))
  ([game-object-factory x y radius start-angle end-angle]
   (phaser->clj
    (.arc game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser start-angle)
          (clj->phaser end-angle))))
  ([game-object-factory x y radius start-angle end-angle anticlockwise]
   (phaser->clj
    (.arc game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser start-angle)
          (clj->phaser end-angle)
          (clj->phaser anticlockwise))))
  ([game-object-factory x y radius start-angle end-angle anticlockwise fill-color]
   (phaser->clj
    (.arc game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser start-angle)
          (clj->phaser end-angle)
          (clj->phaser anticlockwise)
          (clj->phaser fill-color))))
  ([game-object-factory x y radius start-angle end-angle anticlockwise fill-color fill-alpha]
   (phaser->clj
    (.arc game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser radius)
          (clj->phaser start-angle)
          (clj->phaser end-angle)
          (clj->phaser anticlockwise)
          (clj->phaser fill-color)
          (clj->phaser fill-alpha)))))

(defn bitmap-text
  "Creates a new Bitmap Text Game Object and adds it to the Scene.

  BitmapText objects work by taking a texture file and an XML or JSON file that describes the font structure.

  During rendering for each letter of the text is rendered to the display, proportionally spaced out and aligned to
  match the font structure.

  BitmapText objects are less flexible than Text objects, in that they have less features such as shadows, fills and the ability
  to use Web Fonts, however you trade this flexibility for rendering speed. You can also create visually compelling BitmapTexts by
  processing the font texture in an image editor, applying fills and any other effects required.

  To create multi-line text insert \\r, \\n or \\r\\n escape codes into the text string.

  To create a BitmapText data files you need a 3rd party app such as:

  BMFont (Windows, free): http://www.angelcode.com/products/bmfont/
  Glyph Designer (OS X, commercial): http://www.71squared.com/en/glyphdesigner
  Littera (Web-based, free): http://kvazars.com/littera/

  For most use cases it is recommended to use XML. If you wish to use JSON, the formatting should be equal to the result of
  converting a valid XML file through the popular X2JS library. An online tool for conversion can be found here: http://codebeautify.org/xmltojson

  Note: This method will only be available if the Bitmap Text Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The x position of the Game Object.
    * y (number) - The y position of the Game Object.
    * font (string) - The key of the font to use from the BitmapFont cache.
    * text (string | Array.<string>) {optional} - The string, or array of strings, to be set as the content of this Bitmap Text.
    * size (number) {optional} - The font size to set.
    * align (integer) {optional} - The alignment of the text in a multi-line BitmapText object.

  Returns:  Phaser.GameObjects.BitmapText - The Game Object that was created."
  ([game-object-factory x y font]
   (phaser->clj
    (.bitmapText game-object-factory
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser font))))
  ([game-object-factory x y font text]
   (phaser->clj
    (.bitmapText game-object-factory
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser font)
                 (clj->phaser text))))
  ([game-object-factory x y font text size]
   (phaser->clj
    (.bitmapText game-object-factory
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser font)
                 (clj->phaser text)
                 (clj->phaser size))))
  ([game-object-factory x y font text size align]
   (phaser->clj
    (.bitmapText game-object-factory
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser font)
                 (clj->phaser text)
                 (clj->phaser size)
                 (clj->phaser align)))))

(defn blitter
  "Creates a new Blitter Game Object and adds it to the Scene.

  Note: This method will only be available if the Blitter Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The x position of the Game Object.
    * y (number) - The y position of the Game Object.
    * key (string) - The key of the Texture the Blitter object will use.
    * frame (string | integer) {optional} - The default Frame children of the Blitter will use.

  Returns:  Phaser.GameObjects.Blitter - The Game Object that was created."
  ([game-object-factory x y key]
   (phaser->clj
    (.blitter game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser key))))
  ([game-object-factory x y key frame]
   (phaser->clj
    (.blitter game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser key)
              (clj->phaser frame)))))

(defn circle
  "Creates a new Circle Shape Game Object and adds it to the Scene.

  A Circle is an Arc with no defined start and end angle, making it render as a complete circle.

  Note: This method will only be available if the Arc Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * radius (number) {optional} - The radius of the circle.
    * fill-color (number) {optional} - The color the circle will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the circle will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Arc - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.circle game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.circle game-object-factory
             (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.circle game-object-factory
             (clj->phaser x)
             (clj->phaser y))))
  ([game-object-factory x y radius]
   (phaser->clj
    (.circle game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser radius))))
  ([game-object-factory x y radius fill-color]
   (phaser->clj
    (.circle game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser radius)
             (clj->phaser fill-color))))
  ([game-object-factory x y radius fill-color fill-alpha]
   (phaser->clj
    (.circle game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser radius)
             (clj->phaser fill-color)
             (clj->phaser fill-alpha)))))

(defn container
  "Creates a new Container Game Object and adds it to the Scene.

  Note: This method will only be available if the Container Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * children (Phaser.GameObjects.GameObject | Array.<Phaser.GameObjects.GameObject>) {optional} - An optional array of Game Objects to add to this Container.

  Returns:  Phaser.GameObjects.Container - The Game Object that was created."
  ([game-object-factory x y]
   (phaser->clj
    (.container game-object-factory
                (clj->phaser x)
                (clj->phaser y))))
  ([game-object-factory x y children]
   (phaser->clj
    (.container game-object-factory
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser children)))))

(defn curve
  "Creates a new Curve Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Curve Game Object has been built into Phaser.

  The Curve Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports both fill and stroke colors.

  To render a Curve Shape you must first create a `Phaser.Curves.Curve` object, then pass it to
  the Curve Shape in the constructor.

  The Curve shape also has a `smoothness` property and corresponding `setSmoothness` method.
  This allows you to control how smooth the shape renders in WebGL, by controlling the number of iterations
  that take place during construction. Increase and decrease the default value for smoother, or more
  jagged, shapes.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * curve (Phaser.Curves.Curve) {optional} - The Curve object to use to create the Shape.
    * fill-color (number) {optional} - The color the curve will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the curve will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Curve - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.curve game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.curve game-object-factory
            (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.curve game-object-factory
            (clj->phaser x)
            (clj->phaser y))))
  ([game-object-factory x y curve]
   (phaser->clj
    (.curve game-object-factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser curve))))
  ([game-object-factory x y curve fill-color]
   (phaser->clj
    (.curve game-object-factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser curve)
            (clj->phaser fill-color))))
  ([game-object-factory x y curve fill-color fill-alpha]
   (phaser->clj
    (.curve game-object-factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser curve)
            (clj->phaser fill-color)
            (clj->phaser fill-alpha)))))

(defn dom
  "DOM Element Game Objects are a way to control and manipulate HTML Elements over the top of your game.

  In order for DOM Elements to display you have to enable them by adding the following to your game
  configuration object:

  ```javascript
  dom {
    createContainer: true
  }
  ```

  When this is added, Phaser will automatically create a DOM Container div that is positioned over the top
  of the game canvas. This div is sized to match the canvas, and if the canvas size changes, as a result of
  settings within the Scale Manager, the dom container is resized accordingly.

  You can create a DOM Element by either passing in DOMStrings, or by passing in a reference to an existing
  Element that you wish to be placed under the control of Phaser. For example:

  ```javascript
  this.add.dom(x, y, 'div', 'background-color: lime; width: 220px; height: 100px; font: 48px Arial', 'Phaser');
  ```

  The above code will insert a div element into the DOM Container at the given x/y coordinate. The DOMString in
  the 4th argument sets the initial CSS style of the div and the final argument is the inner text. In this case,
  it will create a lime colored div that is 220px by 100px in size with the text Phaser in it, in an Arial font.

  You should nearly always, without exception, use explicitly sized HTML Elements, in order to fully control
  alignment and positioning of the elements next to regular game content.

  Rather than specify the CSS and HTML directly you can use the `load.html` File Loader to load it into the
  cache and then use the `createFromCache` method instead. You can also use `createFromHTML` and various other
  methods available in this class to help construct your elements.

  Once the element has been created you can then control it like you would any other Game Object. You can set its
  position, scale, rotation, alpha and other properties. It will move as the main Scene Camera moves and be clipped
  at the edge of the canvas. It's important to remember some limitations of DOM Elements: The obvious one is that
  they appear above or below your game canvas. You cannot blend them into the display list, meaning you cannot have
  a DOM Element, then a Sprite, then another DOM Element behind it.

  They also cannot be enabled for input. To do that, you have to use the `addListener` method to add native event
  listeners directly. The final limitation is to do with cameras. The DOM Container is sized to match the game canvas
  entirely and clipped accordingly. DOM Elements respect camera scrolling and scrollFactor settings, but if you
  change the size of the camera so it no longer matches the size of the canvas, they won't be clipped accordingly.

  Also, all DOM Elements are inserted into the same DOM Container, regardless of which Scene they are created in.

  DOM Elements are a powerful way to align native HTML with your Phaser Game Objects. For example, you can insert
  a login form for a multiplayer game directly into your title screen. Or a text input box for a highscore table.
  Or a banner ad from a 3rd party service. Or perhaps you'd like to use them for high resolution text display and
  UI. The choice is up to you, just remember that you're dealing with standard HTML and CSS floating over the top
  of your game, and should treat it accordingly.

  Note: This method will only be available if the DOM Element Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this DOM Element in the world.
    * y (number) - The vertical position of this DOM Element in the world.
    * element (HTMLElement | string) {optional} - An existing DOM element, or a string. If a string starting with a # it will do a `getElementById` look-up on the string (minus the hash). Without a hash, it represents the type of element to create, i.e. 'div'.
    * style (string | any) {optional} - If a string, will be set directly as the elements `style` property value. If a plain object, will be iterated and the values transferred. In both cases the values replacing whatever CSS styles may have been previously set.
    * inner-text (string) {optional} - If given, will be set directly as the elements `innerText` property value, replacing whatever was there before.

  Returns:  Phaser.GameObjects.DOMElement - The Game Object that was created."
  ([game-object-factory x y]
   (phaser->clj
    (.dom game-object-factory
          (clj->phaser x)
          (clj->phaser y))))
  ([game-object-factory x y element]
   (phaser->clj
    (.dom game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser element))))
  ([game-object-factory x y element style]
   (phaser->clj
    (.dom game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser element)
          (clj->phaser style))))
  ([game-object-factory x y element style inner-text]
   (phaser->clj
    (.dom game-object-factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser element)
          (clj->phaser style)
          (clj->phaser inner-text)))))

(defn dynamic-bitmap-text
  "Creates a new Dynamic Bitmap Text Game Object and adds it to the Scene.

  BitmapText objects work by taking a texture file and an XML or JSON file that describes the font structure.

  During rendering for each letter of the text is rendered to the display, proportionally spaced out and aligned to
  match the font structure.

  Dynamic Bitmap Text objects are different from Static Bitmap Text in that they invoke a callback for each
  letter being rendered during the render pass. This callback allows you to manipulate the properties of
  each letter being rendered, such as its position, scale or tint, allowing you to create interesting effects
  like jiggling text, which can't be done with Static text. This means that Dynamic Text takes more processing
  time, so only use them if you require the callback ability they have.

  BitmapText objects are less flexible than Text objects, in that they have less features such as shadows, fills and the ability
  to use Web Fonts, however you trade this flexibility for rendering speed. You can also create visually compelling BitmapTexts by
  processing the font texture in an image editor, applying fills and any other effects required.

  To create multi-line text insert \\r, \\n or \\r\\n escape codes into the text string.

  To create a BitmapText data files you need a 3rd party app such as:

  BMFont (Windows, free): http://www.angelcode.com/products/bmfont/
  Glyph Designer (OS X, commercial): http://www.71squared.com/en/glyphdesigner
  Littera (Web-based, free): http://kvazars.com/littera/

  For most use cases it is recommended to use XML. If you wish to use JSON, the formatting should be equal to the result of
  converting a valid XML file through the popular X2JS library. An online tool for conversion can be found here: http://codebeautify.org/xmltojson

  Note: This method will only be available if the Dynamic Bitmap Text Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The x position of the Game Object.
    * y (number) - The y position of the Game Object.
    * font (string) - The key of the font to use from the BitmapFont cache.
    * text (string | Array.<string>) {optional} - The string, or array of strings, to be set as the content of this Bitmap Text.
    * size (number) {optional} - The font size to set.

  Returns:  Phaser.GameObjects.DynamicBitmapText - The Game Object that was created."
  ([game-object-factory x y font]
   (phaser->clj
    (.dynamicBitmapText game-object-factory
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser font))))
  ([game-object-factory x y font text]
   (phaser->clj
    (.dynamicBitmapText game-object-factory
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser font)
                        (clj->phaser text))))
  ([game-object-factory x y font text size]
   (phaser->clj
    (.dynamicBitmapText game-object-factory
                        (clj->phaser x)
                        (clj->phaser y)
                        (clj->phaser font)
                        (clj->phaser text)
                        (clj->phaser size)))))

(defn ellipse
  "Creates a new Ellipse Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Ellipse Game Object has been built into Phaser.

  The Ellipse Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports both fill and stroke colors.

  When it renders it displays an ellipse shape. You can control the width and height of the ellipse.
  If the width and height match it will render as a circle. If the width is less than the height,
  it will look more like an egg shape.

  The Ellipse shape also has a `smoothness` property and corresponding `setSmoothness` method.
  This allows you to control how smooth the shape renders in WebGL, by controlling the number of iterations
  that take place during construction. Increase and decrease the default value for smoother, or more
  jagged, shapes.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * width (number) {optional} - The width of the ellipse. An ellipse with equal width and height renders as a circle.
    * height (number) {optional} - The height of the ellipse. An ellipse with equal width and height renders as a circle.
    * fill-color (number) {optional} - The color the ellipse will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the ellipse will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Ellipse - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.ellipse game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.ellipse game-object-factory
              (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.ellipse game-object-factory
              (clj->phaser x)
              (clj->phaser y))))
  ([game-object-factory x y width]
   (phaser->clj
    (.ellipse game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width))))
  ([game-object-factory x y width height]
   (phaser->clj
    (.ellipse game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width)
              (clj->phaser height))))
  ([game-object-factory x y width height fill-color]
   (phaser->clj
    (.ellipse game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser fill-color))))
  ([game-object-factory x y width height fill-color fill-alpha]
   (phaser->clj
    (.ellipse game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser fill-color)
              (clj->phaser fill-alpha)))))

(defn existing
  "Adds an existing Game Object to this Scene.

  If the Game Object renders, it will be added to the Display List.
  If it has a `preUpdate` method, it will be added to the Update List.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The child to be added to this Scene.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that was added."
  ([game-object-factory child]
   (phaser->clj
    (.existing game-object-factory
               (clj->phaser child)))))

(defn extern
  "Creates a new Extern Game Object and adds it to the Scene.

  Note: This method will only be available if the Extern Game Object has been built into Phaser.

  Returns:  Phaser.GameObjects.Extern - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.extern game-object-factory))))

(defn follower
  "Creates a new PathFollower Game Object and adds it to the Scene.

  Note: This method will only be available if the PathFollower Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * path (Phaser.Curves.Path) - The Path this PathFollower is connected to.
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.GameObjects.PathFollower - The Game Object that was created."
  ([game-object-factory path x y texture]
   (phaser->clj
    (.follower game-object-factory
               (clj->phaser path)
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser texture))))
  ([game-object-factory path x y texture frame]
   (phaser->clj
    (.follower game-object-factory
               (clj->phaser path)
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser texture)
               (clj->phaser frame)))))

(defn graphics
  "Creates a new Graphics Game Object and adds it to the Scene.

  Note: This method will only be available if the Graphics Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * config (Phaser.Types.GameObjects.Graphics.Options) {optional} - The Graphics configuration.

  Returns:  Phaser.GameObjects.Graphics - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.graphics game-object-factory)))
  ([game-object-factory config]
   (phaser->clj
    (.graphics game-object-factory
               (clj->phaser config)))))

(defn grid
  "Creates a new Grid Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Grid Game Object has been built into Phaser.

  The Grid Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports only fill colors and cannot be stroked.

  A Grid Shape allows you to display a grid in your game, where you can control the size of the
  grid as well as the width and height of the grid cells. You can set a fill color for each grid
  cell as well as an alternate fill color. When the alternate fill color is set then the grid
  cells will alternate the fill colors as they render, creating a chess-board effect. You can
  also optionally have an outline fill color. If set, this draws lines between the grid cells
  in the given color. If you specify an outline color with an alpha of zero, then it will draw
  the cells spaced out, but without the lines between them.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * width (number) {optional} - The width of the grid.
    * height (number) {optional} - The height of the grid.
    * cell-width (number) {optional} - The width of one cell in the grid.
    * cell-height (number) {optional} - The height of one cell in the grid.
    * fill-color (number) {optional} - The color the grid cells will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the grid cells will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.
    * outline-fill-color (number) {optional} - The color of the lines between the grid cells.
    * outline-fill-alpha (number) {optional} - The alpha of the lines between the grid cells.

  Returns:  Phaser.GameObjects.Grid - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.grid game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y))))
  ([game-object-factory x y width]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width))))
  ([game-object-factory x y width height]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height))))
  ([game-object-factory x y width height cell-width]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser cell-width))))
  ([game-object-factory x y width height cell-width cell-height]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser cell-width)
           (clj->phaser cell-height))))
  ([game-object-factory x y width height cell-width cell-height fill-color]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser cell-width)
           (clj->phaser cell-height)
           (clj->phaser fill-color))))
  ([game-object-factory x y width height cell-width cell-height fill-color fill-alpha]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser cell-width)
           (clj->phaser cell-height)
           (clj->phaser fill-color)
           (clj->phaser fill-alpha))))
  ([game-object-factory x y width height cell-width cell-height fill-color fill-alpha outline-fill-color]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser cell-width)
           (clj->phaser cell-height)
           (clj->phaser fill-color)
           (clj->phaser fill-alpha)
           (clj->phaser outline-fill-color))))
  ([game-object-factory x y width height cell-width cell-height fill-color fill-alpha outline-fill-color outline-fill-alpha]
   (phaser->clj
    (.grid game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)
           (clj->phaser cell-width)
           (clj->phaser cell-height)
           (clj->phaser fill-color)
           (clj->phaser fill-alpha)
           (clj->phaser outline-fill-color)
           (clj->phaser outline-fill-alpha)))))

(defn group
  "Creates a new Group Game Object and adds it to the Scene.

  Note: This method will only be available if the Group Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * children (Array.<Phaser.GameObjects.GameObject> | Phaser.Types.GameObjects.Group.GroupConfig | Array.<Phaser.Types.GameObjects.Group.GroupConfig>) {optional} - Game Objects to add to this Group; or the `config` argument.
    * config (Phaser.Types.GameObjects.Group.GroupConfig | Phaser.Types.GameObjects.Group.GroupCreateConfig) {optional} - A Group Configuration object.

  Returns:  Phaser.GameObjects.Group - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.group game-object-factory)))
  ([game-object-factory children]
   (phaser->clj
    (.group game-object-factory
            (clj->phaser children))))
  ([game-object-factory children config]
   (phaser->clj
    (.group game-object-factory
            (clj->phaser children)
            (clj->phaser config)))))

(defn image
  "Creates a new Image Game Object and adds it to the Scene.

  Note: This method will only be available if the Image Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.GameObjects.Image - The Game Object that was created."
  ([game-object-factory x y texture]
   (phaser->clj
    (.image game-object-factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser texture))))
  ([game-object-factory x y texture frame]
   (phaser->clj
    (.image game-object-factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser texture)
            (clj->phaser frame)))))

(defn isobox
  "Creates a new IsoBox Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the IsoBox Game Object has been built into Phaser.

  The IsoBox Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports only fill colors and cannot be stroked.

  An IsoBox is an 'isometric' rectangle. Each face of it has a different fill color. You can set
  the color of the top, left and right faces of the rectangle respectively. You can also choose
  which of the faces are rendered via the `showTop`, `showLeft` and `showRight` properties.

  You cannot view an IsoBox from under-neath, however you can change the 'angle' by setting
  the `projection` property.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * size (number) {optional} - The width of the iso box in pixels. The left and right faces will be exactly half this value.
    * height (number) {optional} - The height of the iso box. The left and right faces will be this tall. The overall height of the isobox will be this value plus half the `size` value.
    * fill-top (number) {optional} - The fill color of the top face of the iso box.
    * fill-left (number) {optional} - The fill color of the left face of the iso box.
    * fill-right (number) {optional} - The fill color of the right face of the iso box.

  Returns:  Phaser.GameObjects.IsoBox - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.isobox game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.isobox game-object-factory
             (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.isobox game-object-factory
             (clj->phaser x)
             (clj->phaser y))))
  ([game-object-factory x y size]
   (phaser->clj
    (.isobox game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser size))))
  ([game-object-factory x y size height]
   (phaser->clj
    (.isobox game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser size)
             (clj->phaser height))))
  ([game-object-factory x y size height fill-top]
   (phaser->clj
    (.isobox game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser size)
             (clj->phaser height)
             (clj->phaser fill-top))))
  ([game-object-factory x y size height fill-top fill-left]
   (phaser->clj
    (.isobox game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser size)
             (clj->phaser height)
             (clj->phaser fill-top)
             (clj->phaser fill-left))))
  ([game-object-factory x y size height fill-top fill-left fill-right]
   (phaser->clj
    (.isobox game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser size)
             (clj->phaser height)
             (clj->phaser fill-top)
             (clj->phaser fill-left)
             (clj->phaser fill-right)))))

(defn isotriangle
  "Creates a new IsoTriangle Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the IsoTriangle Game Object has been built into Phaser.

  The IsoTriangle Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports only fill colors and cannot be stroked.

  An IsoTriangle is an 'isometric' triangle. Think of it like a pyramid. Each face has a different
  fill color. You can set the color of the top, left and right faces of the triangle respectively
  You can also choose which of the faces are rendered via the `showTop`, `showLeft` and `showRight` properties.

  You cannot view an IsoTriangle from under-neath, however you can change the 'angle' by setting
  the `projection` property. The `reversed` property controls if the IsoTriangle is rendered upside
  down or not.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * size (number) {optional} - The width of the iso triangle in pixels. The left and right faces will be exactly half this value.
    * height (number) {optional} - The height of the iso triangle. The left and right faces will be this tall. The overall height of the iso triangle will be this value plus half the `size` value.
    * reversed (boolean) {optional} - Is the iso triangle upside down?
    * fill-top (number) {optional} - The fill color of the top face of the iso triangle.
    * fill-left (number) {optional} - The fill color of the left face of the iso triangle.
    * fill-right (number) {optional} - The fill color of the right face of the iso triangle.

  Returns:  Phaser.GameObjects.IsoTriangle - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.isotriangle game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.isotriangle game-object-factory
                  (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.isotriangle game-object-factory
                  (clj->phaser x)
                  (clj->phaser y))))
  ([game-object-factory x y size]
   (phaser->clj
    (.isotriangle game-object-factory
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser size))))
  ([game-object-factory x y size height]
   (phaser->clj
    (.isotriangle game-object-factory
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser size)
                  (clj->phaser height))))
  ([game-object-factory x y size height reversed]
   (phaser->clj
    (.isotriangle game-object-factory
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser size)
                  (clj->phaser height)
                  (clj->phaser reversed))))
  ([game-object-factory x y size height reversed fill-top]
   (phaser->clj
    (.isotriangle game-object-factory
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser size)
                  (clj->phaser height)
                  (clj->phaser reversed)
                  (clj->phaser fill-top))))
  ([game-object-factory x y size height reversed fill-top fill-left]
   (phaser->clj
    (.isotriangle game-object-factory
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser size)
                  (clj->phaser height)
                  (clj->phaser reversed)
                  (clj->phaser fill-top)
                  (clj->phaser fill-left))))
  ([game-object-factory x y size height reversed fill-top fill-left fill-right]
   (phaser->clj
    (.isotriangle game-object-factory
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser size)
                  (clj->phaser height)
                  (clj->phaser reversed)
                  (clj->phaser fill-top)
                  (clj->phaser fill-left)
                  (clj->phaser fill-right)))))

(defn line
  "Creates a new Line Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Line Game Object has been built into Phaser.

  The Line Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports only stroke colors and cannot be filled.

  A Line Shape allows you to draw a line between two points in your game. You can control the
  stroke color and thickness of the line. In WebGL only you can also specify a different
  thickness for the start and end of the line, allowing you to render lines that taper-off.

  If you need to draw multiple lines in a sequence you may wish to use the Polygon Shape instead.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * x-1 (number) {optional} - The horizontal position of the start of the line.
    * y-1 (number) {optional} - The vertical position of the start of the line.
    * x-2 (number) {optional} - The horizontal position of the end of the line.
    * y-2 (number) {optional} - The vertical position of the end of the line.
    * stroke-color (number) {optional} - The color the line will be drawn in, i.e. 0xff0000 for red.
    * stroke-alpha (number) {optional} - The alpha the line will be drawn in. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Line - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.line game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.line game-object-factory
           (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.line game-object-factory
           (clj->phaser x)
           (clj->phaser y))))
  ([game-object-factory x y x-1]
   (phaser->clj
    (.line game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser x-1))))
  ([game-object-factory x y x-1 y-1]
   (phaser->clj
    (.line game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser x-1)
           (clj->phaser y-1))))
  ([game-object-factory x y x-1 y-1 x-2]
   (phaser->clj
    (.line game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser x-1)
           (clj->phaser y-1)
           (clj->phaser x-2))))
  ([game-object-factory x y x-1 y-1 x-2 y-2]
   (phaser->clj
    (.line game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser x-1)
           (clj->phaser y-1)
           (clj->phaser x-2)
           (clj->phaser y-2))))
  ([game-object-factory x y x-1 y-1 x-2 y-2 stroke-color]
   (phaser->clj
    (.line game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser x-1)
           (clj->phaser y-1)
           (clj->phaser x-2)
           (clj->phaser y-2)
           (clj->phaser stroke-color))))
  ([game-object-factory x y x-1 y-1 x-2 y-2 stroke-color stroke-alpha]
   (phaser->clj
    (.line game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser x-1)
           (clj->phaser y-1)
           (clj->phaser x-2)
           (clj->phaser y-2)
           (clj->phaser stroke-color)
           (clj->phaser stroke-alpha)))))

(defn mesh
  "Creates a new Mesh Game Object and adds it to the Scene.

  Note: This method will only be available if the Mesh Game Object and WebGL support have been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * vertices (Array.<number>) - An array containing the vertices data for this Mesh.
    * uv (Array.<number>) - An array containing the uv data for this Mesh.
    * colors (Array.<number>) - An array containing the color data for this Mesh.
    * alphas (Array.<number>) - An array containing the alpha data for this Mesh.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.GameObjects.Mesh - The Game Object that was created."
  ([game-object-factory x y vertices uv colors alphas texture]
   (phaser->clj
    (.mesh game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser vertices)
           (clj->phaser uv)
           (clj->phaser colors)
           (clj->phaser alphas)
           (clj->phaser texture))))
  ([game-object-factory x y vertices uv colors alphas texture frame]
   (phaser->clj
    (.mesh game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser vertices)
           (clj->phaser uv)
           (clj->phaser colors)
           (clj->phaser alphas)
           (clj->phaser texture)
           (clj->phaser frame)))))

(defn particles
  "Creates a new Particle Emitter Manager Game Object and adds it to the Scene.

  Note: This method will only be available if the Particles Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer | object) {optional} - An optional frame from the Texture this Game Object is rendering with.
    * emitters (Phaser.Types.GameObjects.Particles.ParticleEmitterConfig | Array.<Phaser.Types.GameObjects.Particles.ParticleEmitterConfig>) {optional} - Configuration settings for one or more emitters to create.

  Returns:  Phaser.GameObjects.Particles.ParticleEmitterManager - The Game Object that was created."
  ([game-object-factory texture]
   (phaser->clj
    (.particles game-object-factory
                (clj->phaser texture))))
  ([game-object-factory texture frame]
   (phaser->clj
    (.particles game-object-factory
                (clj->phaser texture)
                (clj->phaser frame))))
  ([game-object-factory texture frame emitters]
   (phaser->clj
    (.particles game-object-factory
                (clj->phaser texture)
                (clj->phaser frame)
                (clj->phaser emitters)))))

(defn path
  "Creates a new Path Object.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Path.
    * y (number) - The vertical position of this Path.

  Returns:  Phaser.Curves.Path - The Path Object that was created."
  ([game-object-factory x y]
   (phaser->clj
    (.path game-object-factory
           (clj->phaser x)
           (clj->phaser y)))))

(defn polygon
  "Creates a new Polygon Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Polygon Game Object has been built into Phaser.

  The Polygon Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports both fill and stroke colors.

  The Polygon Shape is created by providing a list of points, which are then used to create an
  internal Polygon geometry object. The points can be set from a variety of formats:

  - An array of Point or Vector2 objects: `[new Phaser.Math.Vec2(x1, y1), ...]`
  - An array of objects with public x/y properties: `[obj1, obj2, ...]`
  - An array of paired numbers that represent point coordinates: `[x1,y1, x2,y2, ...]`
  - An array of arrays with two elements representing x/y coordinates: `[[x1, y1], [x2, y2], ...]`

  By default the `x` and `y` coordinates of this Shape refer to the center of it. However, depending
  on the coordinates of the points provided, the final shape may be rendered offset from its origin.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * points (any) {optional} - The points that make up the polygon.
    * fill-color (number) {optional} - The color the polygon will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the polygon will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Polygon - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.polygon game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.polygon game-object-factory
              (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.polygon game-object-factory
              (clj->phaser x)
              (clj->phaser y))))
  ([game-object-factory x y points]
   (phaser->clj
    (.polygon game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser points))))
  ([game-object-factory x y points fill-color]
   (phaser->clj
    (.polygon game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser points)
              (clj->phaser fill-color))))
  ([game-object-factory x y points fill-color fill-alpha]
   (phaser->clj
    (.polygon game-object-factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser points)
              (clj->phaser fill-color)
              (clj->phaser fill-alpha)))))

(defn quad
  "Creates a new Quad Game Object and adds it to the Scene.

  Note: This method will only be available if the Quad Game Object and WebGL support have been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.GameObjects.Quad - The Game Object that was created."
  ([game-object-factory x y texture]
   (phaser->clj
    (.quad game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser texture))))
  ([game-object-factory x y texture frame]
   (phaser->clj
    (.quad game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser texture)
           (clj->phaser frame)))))

(defn rectangle
  "Creates a new Rectangle Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Rectangle Game Object has been built into Phaser.

  The Rectangle Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports both fill and stroke colors.

  You can change the size of the rectangle by changing the `width` and `height` properties.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * width (number) {optional} - The width of the rectangle.
    * height (number) {optional} - The height of the rectangle.
    * fill-color (number) {optional} - The color the rectangle will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the rectangle will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Rectangle - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.rectangle game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.rectangle game-object-factory
                (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.rectangle game-object-factory
                (clj->phaser x)
                (clj->phaser y))))
  ([game-object-factory x y width]
   (phaser->clj
    (.rectangle game-object-factory
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width))))
  ([game-object-factory x y width height]
   (phaser->clj
    (.rectangle game-object-factory
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height))))
  ([game-object-factory x y width height fill-color]
   (phaser->clj
    (.rectangle game-object-factory
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser fill-color))))
  ([game-object-factory x y width height fill-color fill-alpha]
   (phaser->clj
    (.rectangle game-object-factory
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser fill-color)
                (clj->phaser fill-alpha)))))

(defn render-texture
  "Creates a new Render Texture Game Object and adds it to the Scene.

  Note: This method will only be available if the Render Texture Game Object has been built into Phaser.

  A Render Texture is a special texture that allows any number of Game Objects to be drawn to it. You can take many complex objects and
  draw them all to this one texture, which can they be used as the texture for other Game Object's. It's a way to generate dynamic
  textures at run-time that are WebGL friendly and don't invoke expensive GPU uploads.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * width (integer) {optional} - The width of the Render Texture.
    * height (integer) {optional} - The height of the Render Texture.

  Returns:  Phaser.GameObjects.RenderTexture - The Game Object that was created."
  ([game-object-factory x y]
   (phaser->clj
    (.renderTexture game-object-factory
                    (clj->phaser x)
                    (clj->phaser y))))
  ([game-object-factory x y width]
   (phaser->clj
    (.renderTexture game-object-factory
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser width))))
  ([game-object-factory x y width height]
   (phaser->clj
    (.renderTexture game-object-factory
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser width)
                    (clj->phaser height)))))

(defn shader
  "Creates a new Shader Game Object and adds it to the Scene.

  Note: This method will only be available if the Shader Game Object and WebGL support have been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * key (string | Phaser.Display.BaseShader) - The key of the shader to use from the shader cache, or a BaseShader instance.
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * width (number) {optional} - The width of the Game Object.
    * height (number) {optional} - The height of the Game Object.
    * textures (Array.<string>) {optional} - Optional array of texture keys to bind to the iChannel0...3 uniforms. The textures must already exist in the Texture Manager.
    * texture-data (object) {optional} - Optional additional texture data.

  Returns:  Phaser.GameObjects.Shader - The Game Object that was created."
  ([game-object-factory key]
   (phaser->clj
    (.shader game-object-factory
             (clj->phaser key))))
  ([game-object-factory key x]
   (phaser->clj
    (.shader game-object-factory
             (clj->phaser key)
             (clj->phaser x))))
  ([game-object-factory key x y]
   (phaser->clj
    (.shader game-object-factory
             (clj->phaser key)
             (clj->phaser x)
             (clj->phaser y))))
  ([game-object-factory key x y width]
   (phaser->clj
    (.shader game-object-factory
             (clj->phaser key)
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser width))))
  ([game-object-factory key x y width height]
   (phaser->clj
    (.shader game-object-factory
             (clj->phaser key)
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser width)
             (clj->phaser height))))
  ([game-object-factory key x y width height textures]
   (phaser->clj
    (.shader game-object-factory
             (clj->phaser key)
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser width)
             (clj->phaser height)
             (clj->phaser textures))))
  ([game-object-factory key x y width height textures texture-data]
   (phaser->clj
    (.shader game-object-factory
             (clj->phaser key)
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser width)
             (clj->phaser height)
             (clj->phaser textures)
             (clj->phaser texture-data)))))

(defn sprite
  "Creates a new Sprite Game Object and adds it to the Scene.

  Note: This method will only be available if the Sprite Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.GameObjects.Sprite - The Game Object that was created."
  ([game-object-factory x y texture]
   (phaser->clj
    (.sprite game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser texture))))
  ([game-object-factory x y texture frame]
   (phaser->clj
    (.sprite game-object-factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser texture)
             (clj->phaser frame)))))

(defn star
  "Creates a new Star Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Star Game Object has been built into Phaser.

  The Star Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports both fill and stroke colors.

  As the name implies, the Star shape will display a star in your game. You can control several
  aspects of it including the number of points that constitute the star. The default is 5. If
  you change it to 4 it will render as a diamond. If you increase them, you'll get a more spiky
  star shape.

  You can also control the inner and outer radius, which is how 'long' each point of the star is.
  Modify these values to create more interesting shapes.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * points (number) {optional} - The number of points on the star.
    * inner-radius (number) {optional} - The inner radius of the star.
    * outer-radius (number) {optional} - The outer radius of the star.
    * fill-color (number) {optional} - The color the star will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the star will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Star - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.star game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.star game-object-factory
           (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.star game-object-factory
           (clj->phaser x)
           (clj->phaser y))))
  ([game-object-factory x y points]
   (phaser->clj
    (.star game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser points))))
  ([game-object-factory x y points inner-radius]
   (phaser->clj
    (.star game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser points)
           (clj->phaser inner-radius))))
  ([game-object-factory x y points inner-radius outer-radius]
   (phaser->clj
    (.star game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser points)
           (clj->phaser inner-radius)
           (clj->phaser outer-radius))))
  ([game-object-factory x y points inner-radius outer-radius fill-color]
   (phaser->clj
    (.star game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser points)
           (clj->phaser inner-radius)
           (clj->phaser outer-radius)
           (clj->phaser fill-color))))
  ([game-object-factory x y points inner-radius outer-radius fill-color fill-alpha]
   (phaser->clj
    (.star game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser points)
           (clj->phaser inner-radius)
           (clj->phaser outer-radius)
           (clj->phaser fill-color)
           (clj->phaser fill-alpha)))))

(defn text
  "Creates a new Text Game Object and adds it to the Scene.

  A Text Game Object.

  Text objects work by creating their own internal hidden Canvas and then renders text to it using
  the standard Canvas `fillText` API. It then creates a texture from this canvas which is rendered
  to your game during the render pass.

  Because it uses the Canvas API you can take advantage of all the features this offers, such as
  applying gradient fills to the text, or strokes, shadows and more. You can also use custom fonts
  loaded externally, such as Google or TypeKit Web fonts.

  You can only display fonts that are currently loaded and available to the browser: therefore fonts must
  be pre-loaded. Phaser does not do ths for you, so you will require the use of a 3rd party font loader,
  or have the fonts ready available in the CSS on the page in which your Phaser game resides.

  See {@link http://www.jordanm.co.uk/tinytype this compatibility table} for the available default fonts
  across mobile browsers.

  A note on performance: Every time the contents of a Text object changes, i.e. changing the text being
  displayed, or the style of the text, it needs to remake the Text canvas, and if on WebGL, re-upload the
  new texture to the GPU. This can be an expensive operation if used often, or with large quantities of
  Text objects in your game. If you run into performance issues you would be better off using Bitmap Text
  instead, as it benefits from batching and avoids expensive Canvas API calls.

  Note: This method will only be available if the Text Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * text (string | Array.<string>) - The text this Text object will display.
    * style (object) {optional} - The Text style configuration object.

  Returns:  Phaser.GameObjects.Text - The Game Object that was created."
  ([game-object-factory x y text]
   (phaser->clj
    (.text game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser text))))
  ([game-object-factory x y text style]
   (phaser->clj
    (.text game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser text)
           (clj->phaser style)))))

(defn tile-sprite
  "Creates a new TileSprite Game Object and adds it to the Scene.

  Note: This method will only be available if the TileSprite Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * width (integer) - The width of the Game Object. If zero it will use the size of the texture frame.
    * height (integer) - The height of the Game Object. If zero it will use the size of the texture frame.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.GameObjects.TileSprite - The Game Object that was created."
  ([game-object-factory x y width height texture]
   (phaser->clj
    (.tileSprite game-object-factory
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser width)
                 (clj->phaser height)
                 (clj->phaser texture))))
  ([game-object-factory x y width height texture frame]
   (phaser->clj
    (.tileSprite game-object-factory
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser width)
                 (clj->phaser height)
                 (clj->phaser texture)
                 (clj->phaser frame)))))

(defn tilemap
  "Creates a Tilemap from the given key or data, or creates a blank Tilemap if no key/data provided.
  When loading from CSV or a 2D array, you should specify the tileWidth & tileHeight. When parsing
  from a map from Tiled, the tileWidth, tileHeight, width & height will be pulled from the map
  data. For an empty map, you should specify tileWidth, tileHeight, width & height.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * key (string) {optional} - The key in the Phaser cache that corresponds to the loaded tilemap data.
    * tile-width (integer) {optional} - The width of a tile in pixels. Pass in `null` to leave as the
default.
    * tile-height (integer) {optional} - The height of a tile in pixels. Pass in `null` to leave as the
default.
    * width (integer) {optional} - The width of the map in tiles. Pass in `null` to leave as the
default.
    * height (integer) {optional} - The height of the map in tiles. Pass in `null` to leave as the
default.
    * data (Array.<Array.<integer>>) {optional} - Instead of loading from the cache, you can also load directly from
a 2D array of tile indexes. Pass in `null` for no data.
    * insert-null (boolean) {optional} - Controls how empty tiles, tiles with an index of -1, in the
map data are handled. If `true`, empty locations will get a value of `null`. If `false`, empty
location will get a Tile object with an index of -1. If you've a large sparsely populated map and
the tile data doesn't need to change then setting this value to `true` will help with memory
consumption. However if your map is small or you need to update the tiles dynamically, then leave
the default value set.

  Returns:  Phaser.Tilemaps.Tilemap - "
  ([game-object-factory]
   (phaser->clj
    (.tilemap game-object-factory)))
  ([game-object-factory key]
   (phaser->clj
    (.tilemap game-object-factory
              (clj->phaser key))))
  ([game-object-factory key tile-width]
   (phaser->clj
    (.tilemap game-object-factory
              (clj->phaser key)
              (clj->phaser tile-width))))
  ([game-object-factory key tile-width tile-height]
   (phaser->clj
    (.tilemap game-object-factory
              (clj->phaser key)
              (clj->phaser tile-width)
              (clj->phaser tile-height))))
  ([game-object-factory key tile-width tile-height width]
   (phaser->clj
    (.tilemap game-object-factory
              (clj->phaser key)
              (clj->phaser tile-width)
              (clj->phaser tile-height)
              (clj->phaser width))))
  ([game-object-factory key tile-width tile-height width height]
   (phaser->clj
    (.tilemap game-object-factory
              (clj->phaser key)
              (clj->phaser tile-width)
              (clj->phaser tile-height)
              (clj->phaser width)
              (clj->phaser height))))
  ([game-object-factory key tile-width tile-height width height data]
   (phaser->clj
    (.tilemap game-object-factory
              (clj->phaser key)
              (clj->phaser tile-width)
              (clj->phaser tile-height)
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser data))))
  ([game-object-factory key tile-width tile-height width height data insert-null]
   (phaser->clj
    (.tilemap game-object-factory
              (clj->phaser key)
              (clj->phaser tile-width)
              (clj->phaser tile-height)
              (clj->phaser width)
              (clj->phaser height)
              (clj->phaser data)
              (clj->phaser insert-null)))))

(defn triangle
  "Creates a new Triangle Shape Game Object and adds it to the Scene.

  Note: This method will only be available if the Triangle Game Object has been built into Phaser.

  The Triangle Shape is a Game Object that can be added to a Scene, Group or Container. You can
  treat it like any other Game Object in your game, such as tweening it, scaling it, or enabling
  it for input or physics. It provides a quick and easy way for you to render this shape in your
  game without using a texture, while still taking advantage of being fully batched in WebGL.

  This shape supports both fill and stroke colors.

  The Triangle consists of 3 lines, joining up to form a triangular shape. You can control the
  position of each point of these lines. The triangle is always closed and cannot have an open
  face. If you require that, consider using a Polygon instead.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) {optional} - The horizontal position of this Game Object in the world.
    * y (number) {optional} - The vertical position of this Game Object in the world.
    * x-1 (number) {optional} - The horizontal position of the first point in the triangle.
    * y-1 (number) {optional} - The vertical position of the first point in the triangle.
    * x-2 (number) {optional} - The horizontal position of the second point in the triangle.
    * y-2 (number) {optional} - The vertical position of the second point in the triangle.
    * x-3 (number) {optional} - The horizontal position of the third point in the triangle.
    * y-3 (number) {optional} - The vertical position of the third point in the triangle.
    * fill-color (number) {optional} - The color the triangle will be filled with, i.e. 0xff0000 for red.
    * fill-alpha (number) {optional} - The alpha the triangle will be filled with. You can also set the alpha of the overall Shape using its `alpha` property.

  Returns:  Phaser.GameObjects.Triangle - The Game Object that was created."
  ([game-object-factory]
   (phaser->clj
    (.triangle game-object-factory)))
  ([game-object-factory x]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x))))
  ([game-object-factory x y]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y))))
  ([game-object-factory x y x-1]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser x-1))))
  ([game-object-factory x y x-1 y-1]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser x-1)
               (clj->phaser y-1))))
  ([game-object-factory x y x-1 y-1 x-2]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2))))
  ([game-object-factory x y x-1 y-1 x-2 y-2]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2)
               (clj->phaser y-2))))
  ([game-object-factory x y x-1 y-1 x-2 y-2 x-3]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2)
               (clj->phaser y-2)
               (clj->phaser x-3))))
  ([game-object-factory x y x-1 y-1 x-2 y-2 x-3 y-3]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2)
               (clj->phaser y-2)
               (clj->phaser x-3)
               (clj->phaser y-3))))
  ([game-object-factory x y x-1 y-1 x-2 y-2 x-3 y-3 fill-color]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2)
               (clj->phaser y-2)
               (clj->phaser x-3)
               (clj->phaser y-3)
               (clj->phaser fill-color))))
  ([game-object-factory x y x-1 y-1 x-2 y-2 x-3 y-3 fill-color fill-alpha]
   (phaser->clj
    (.triangle game-object-factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser x-1)
               (clj->phaser y-1)
               (clj->phaser x-2)
               (clj->phaser y-2)
               (clj->phaser x-3)
               (clj->phaser y-3)
               (clj->phaser fill-color)
               (clj->phaser fill-alpha)))))

(defn tween
  "Creates a new Tween object.

  Note: This method will only be available if Tweens have been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * config (Phaser.Types.Tweens.TweenBuilderConfig | object) - The Tween configuration.

  Returns:  Phaser.Tweens.Tween - The Tween that was created."
  ([game-object-factory config]
   (phaser->clj
    (.tween game-object-factory
            (clj->phaser config)))))

(defn video
  "Creates a new Image Game Object and adds it to the Scene.

  Note: This method will only be available if the Image Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * texture (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with.

  Returns:  Phaser.GameObjects.Image - The Game Object that was created."
  ([game-object-factory x y texture]
   (phaser->clj
    (.video game-object-factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser texture))))
  ([game-object-factory x y texture frame]
   (phaser->clj
    (.video game-object-factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser texture)
            (clj->phaser frame)))))

(defn zone
  "Creates a new Zone Game Object and adds it to the Scene.

  Note: This method will only be available if the Zone Game Object has been built into Phaser.

  Parameters:
    * game-object-factory (Phaser.GameObjects.GameObjectFactory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * width (number) - The width of the Game Object.
    * height (number) - The height of the Game Object.

  Returns:  Phaser.GameObjects.Zone - The Game Object that was created."
  ([game-object-factory x y width height]
   (phaser->clj
    (.zone game-object-factory
           (clj->phaser x)
           (clj->phaser y)
           (clj->phaser width)
           (clj->phaser height)))))