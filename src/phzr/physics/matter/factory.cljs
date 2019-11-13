(ns phzr.physics.matter.factory
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [force]))

(defn ->Factory
  "  Parameters:
    * world (Phaser.Physics.Matter.World) - The Matter World which this Factory adds to."
  ([world]
   (js/Phaser.Physics.Matter.Factory. (clj->phaser world))))

(defn angular-velocity
  "Instantly sets the angular velocity of the given body. Position, angle, force etc. are unchanged.

  See also `force`.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * body (MatterJS.Body) - The Matter Body to set the velocity on.
    * velocity (number) - The angular velocity to set.

  Returns:  MatterJS.Body - The Matter body."
  ([factory body velocity]
   (phaser->clj
    (.angularVelocity factory
                      (clj->phaser body)
                      (clj->phaser velocity)))))

(defn car
  "Creates a composite with simple car setup of bodies and constraints.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]
    * width (number) - [description]
    * height (number) - [description]
    * wheel-size (number) - [description]

  Returns:  MatterJS.Composite - A new composite car body."
  ([factory x y width height wheel-size]
   (phaser->clj
    (.car factory
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser width)
          (clj->phaser height)
          (clj->phaser wheel-size)))))

(defn chain
  "Chains all bodies in the given composite together using constraints.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * composite (MatterJS.Composite) - [description]
    * x-offset-a (number) - [description]
    * y-offset-a (number) - [description]
    * x-offset-b (number) - [description]
    * y-offset-b (number) - [description]
    * options (object) - [description]

  Returns:  MatterJS.Composite - A new composite containing objects chained together with constraints."
  ([factory composite x-offset-a y-offset-a x-offset-b y-offset-b options]
   (phaser->clj
    (.chain factory
            (clj->phaser composite)
            (clj->phaser x-offset-a)
            (clj->phaser y-offset-a)
            (clj->phaser x-offset-b)
            (clj->phaser y-offset-b)
            (clj->phaser options)))))

(defn circle
  "Creates a new rigid circular Body and adds it to the World.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The X coordinate of the center of the Body.
    * y (number) - The Y coordinate of the center of the Body.
    * radius (number) - The radius of the circle.
    * options (object) {optional} - An object of properties to set on the Body. You can also specify a `chamfer` property to automatically adjust the body.
    * max-sides (number) {optional} - The maximum amount of sides to use for the polygon which will approximate this circle.

  Returns:  MatterJS.Body - A Matter JS Body."
  ([factory x y radius]
   (phaser->clj
    (.circle factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser radius))))
  ([factory x y radius options]
   (phaser->clj
    (.circle factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser radius)
             (clj->phaser options))))
  ([factory x y radius options max-sides]
   (phaser->clj
    (.circle factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser radius)
             (clj->phaser options)
             (clj->phaser max-sides)))))

(defn constraint
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * body-a (MatterJS.Body) - The first possible `Body` that this constraint is attached to.
    * body-b (MatterJS.Body) - The second possible `Body` that this constraint is attached to.
    * length (number) {optional} - A Number that specifies the target resting length of the constraint. If not given it is calculated automatically in `Constraint.create` from initial positions of the `constraint.bodyA` and `constraint.bodyB`.
    * stiffness (number) {optional} - A Number that specifies the stiffness of the constraint, i.e. the rate at which it returns to its resting `constraint.length`. A value of `1` means the constraint should be very stiff. A value of `0.2` means the constraint acts as a soft spring.
    * options (object) {optional} - [description]

  Returns:  MatterJS.Constraint - A Matter JS Constraint."
  ([factory body-a body-b]
   (phaser->clj
    (.constraint factory
                 (clj->phaser body-a)
                 (clj->phaser body-b))))
  ([factory body-a body-b length]
   (phaser->clj
    (.constraint factory
                 (clj->phaser body-a)
                 (clj->phaser body-b)
                 (clj->phaser length))))
  ([factory body-a body-b length stiffness]
   (phaser->clj
    (.constraint factory
                 (clj->phaser body-a)
                 (clj->phaser body-b)
                 (clj->phaser length)
                 (clj->phaser stiffness))))
  ([factory body-a body-b length stiffness options]
   (phaser->clj
    (.constraint factory
                 (clj->phaser body-a)
                 (clj->phaser body-b)
                 (clj->phaser length)
                 (clj->phaser stiffness)
                 (clj->phaser options)))))

(defn destroy
  "Destroys this Factory."
  ([factory]
   (phaser->clj
    (.destroy factory))))

(defn force
  "Applies a force to a body from a given world-space position, including resulting torque.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * body (MatterJS.Body) - The Matter Body to set the force on.
    * position (Phaser.Types.Math.Vector2Like) - The world position to apply the force from. An object with public `x` and `y` components.
    * force (Phaser.Types.Math.Vector2Like) - The force to set. An object with public `x` and `y` components.

  Returns:  MatterJS.Body - The Matter body."
  ([factory body position force]
   (phaser->clj
    (.force factory
            (clj->phaser body)
            (clj->phaser position)
            (clj->phaser force)))))

(defn from-vertices
  "Creates a body using the supplied vertices (or an array containing multiple sets of vertices) and adds it to the World.
  If the vertices are convex, they will pass through as supplied. Otherwise, if the vertices are concave, they will be decomposed. Note that this process is not guaranteed to support complex sets of vertices, e.g. ones with holes.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The X coordinate of the center of the Body.
    * y (number) - The Y coordinate of the center of the Body.
    * vertex-sets (string | array) - [description]
    * options (object) {optional} - [description]
    * flag-internal (boolean) {optional} - Flag internal edges (coincident part edges)
    * remove-collinear (number) {optional} - Whether Matter.js will discard collinear edges (to improve performance).
    * minimum-area (number) {optional} - During decomposition discard parts that have an area less than this.

  Returns:  MatterJS.Body - A Matter JS Body."
  ([factory x y vertex-sets]
   (phaser->clj
    (.fromVertices factory
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser vertex-sets))))
  ([factory x y vertex-sets options]
   (phaser->clj
    (.fromVertices factory
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser vertex-sets)
                   (clj->phaser options))))
  ([factory x y vertex-sets options flag-internal]
   (phaser->clj
    (.fromVertices factory
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser vertex-sets)
                   (clj->phaser options)
                   (clj->phaser flag-internal))))
  ([factory x y vertex-sets options flag-internal remove-collinear]
   (phaser->clj
    (.fromVertices factory
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser vertex-sets)
                   (clj->phaser options)
                   (clj->phaser flag-internal)
                   (clj->phaser remove-collinear))))
  ([factory x y vertex-sets options flag-internal remove-collinear minimum-area]
   (phaser->clj
    (.fromVertices factory
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser vertex-sets)
                   (clj->phaser options)
                   (clj->phaser flag-internal)
                   (clj->phaser remove-collinear)
                   (clj->phaser minimum-area)))))

(defn game-object
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - The Game Object to inject the Matter Body in to.
    * options (object | MatterJS.Body) - A Matter Body configuration object, or an instance of a Matter Body.

  Returns:  Phaser.GameObjects.GameObject - The Game Object that had the Matter Body injected into it."
  ([factory game-object options]
   (phaser->clj
    (.gameObject factory
                 (clj->phaser game-object)
                 (clj->phaser options)))))

(defn image
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * key (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with. Set to `null` to skip this value.
    * options (object) {optional} - [description]

  Returns:  Phaser.Physics.Matter.Image - [description]"
  ([factory x y key]
   (phaser->clj
    (.image factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser key))))
  ([factory x y key frame]
   (phaser->clj
    (.image factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser key)
            (clj->phaser frame))))
  ([factory x y key frame options]
   (phaser->clj
    (.image factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser key)
            (clj->phaser frame)
            (clj->phaser options)))))

(defn image-stack
  "Create a new composite containing Matter Image objects created in a grid arrangement.
  This function uses the body bounds to prevent overlaps.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * key (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) - An optional frame from the Texture this Game Object is rendering with. Set to `null` to skip this value.
    * x (number) - The horizontal position of this composite in the world.
    * y (number) - The vertical position of this composite in the world.
    * columns (number) - The number of columns in the grid.
    * rows (number) - The number of rows in the grid.
    * column-gap (number) {optional} - The distance between each column.
    * row-gap (number) {optional} - The distance between each row.
    * options (object) {optional} - [description]

  Returns:  MatterJS.Composite - A Matter JS Composite Stack."
  ([factory key frame x y columns rows]
   (phaser->clj
    (.imageStack factory
                 (clj->phaser key)
                 (clj->phaser frame)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser columns)
                 (clj->phaser rows))))
  ([factory key frame x y columns rows column-gap]
   (phaser->clj
    (.imageStack factory
                 (clj->phaser key)
                 (clj->phaser frame)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser columns)
                 (clj->phaser rows)
                 (clj->phaser column-gap))))
  ([factory key frame x y columns rows column-gap row-gap]
   (phaser->clj
    (.imageStack factory
                 (clj->phaser key)
                 (clj->phaser frame)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser columns)
                 (clj->phaser rows)
                 (clj->phaser column-gap)
                 (clj->phaser row-gap))))
  ([factory key frame x y columns rows column-gap row-gap options]
   (phaser->clj
    (.imageStack factory
                 (clj->phaser key)
                 (clj->phaser frame)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser columns)
                 (clj->phaser rows)
                 (clj->phaser column-gap)
                 (clj->phaser row-gap)
                 (clj->phaser options)))))

(defn joint
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * body-a (MatterJS.Body) - The first possible `Body` that this constraint is attached to.
    * body-b (MatterJS.Body) - The second possible `Body` that this constraint is attached to.
    * length (number) {optional} - A Number that specifies the target resting length of the constraint. If not given it is calculated automatically in `Constraint.create` from initial positions of the `constraint.bodyA` and `constraint.bodyB`.
    * stiffness (number) {optional} - A Number that specifies the stiffness of the constraint, i.e. the rate at which it returns to its resting `constraint.length`. A value of `1` means the constraint should be very stiff. A value of `0.2` means the constraint acts as a soft spring.
    * options (object) {optional} - [description]

  Returns:  MatterJS.Constraint - A Matter JS Constraint."
  ([factory body-a body-b]
   (phaser->clj
    (.joint factory
            (clj->phaser body-a)
            (clj->phaser body-b))))
  ([factory body-a body-b length]
   (phaser->clj
    (.joint factory
            (clj->phaser body-a)
            (clj->phaser body-b)
            (clj->phaser length))))
  ([factory body-a body-b length stiffness]
   (phaser->clj
    (.joint factory
            (clj->phaser body-a)
            (clj->phaser body-b)
            (clj->phaser length)
            (clj->phaser stiffness))))
  ([factory body-a body-b length stiffness options]
   (phaser->clj
    (.joint factory
            (clj->phaser body-a)
            (clj->phaser body-b)
            (clj->phaser length)
            (clj->phaser stiffness)
            (clj->phaser options)))))

(defn mesh
  "Connects bodies in the composite with constraints in a grid pattern, with optional cross braces.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * composite (MatterJS.Composite) - [description]
    * columns (number) - [description]
    * rows (number) - [description]
    * cross-brace (boolean) - [description]
    * options (object) - [description]

  Returns:  MatterJS.Composite - The composite containing objects meshed together with constraints."
  ([factory composite columns rows cross-brace options]
   (phaser->clj
    (.mesh factory
           (clj->phaser composite)
           (clj->phaser columns)
           (clj->phaser rows)
           (clj->phaser cross-brace)
           (clj->phaser options)))))

(defn mouse-spring
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * options (object) - [description]

  Returns:  MatterJS.Constraint - A Matter JS Constraint."
  ([factory options]
   (phaser->clj
    (.mouseSpring factory
                  (clj->phaser options)))))

(defn newtons-cradle
  "Creates a composite with a Newton's Cradle setup of bodies and constraints.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - [description]
    * y (number) - [description]
    * number (number) - [description]
    * size (number) - [description]
    * length (number) - [description]

  Returns:  MatterJS.Composite - A new composite newtonsCradle body."
  ([factory x y number size length]
   (phaser->clj
    (.newtonsCradle factory
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser number)
                    (clj->phaser size)
                    (clj->phaser length)))))

(defn pointer-constraint
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * options (object) - [description]

  Returns:  MatterJS.Constraint - A Matter JS Constraint."
  ([factory options]
   (phaser->clj
    (.pointerConstraint factory
                        (clj->phaser options)))))

(defn polygon
  "Creates a new rigid polygonal Body and adds it to the World.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The X coordinate of the center of the Body.
    * y (number) - The Y coordinate of the center of the Body.
    * sides (number) - The number of sides the polygon will have.
    * radius (number) - The 'radius' of the polygon, i.e. the distance from its center to any vertex. This is also the radius of its circumcircle.
    * options (object) - An object of properties to set on the Body. You can also specify a `chamfer` property to automatically adjust the body.

  Returns:  MatterJS.Body - A Matter JS Body."
  ([factory x y sides radius options]
   (phaser->clj
    (.polygon factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser sides)
              (clj->phaser radius)
              (clj->phaser options)))))

(defn pyramid
  "Create a new composite containing bodies created in the callback in a pyramid arrangement.
  This function uses the body bounds to prevent overlaps.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this composite in the world.
    * y (number) - The vertical position of this composite in the world.
    * columns (number) - The number of columns in the pyramid.
    * rows (number) - The number of rows in the pyramid.
    * column-gap (number) - The distance between each column.
    * row-gap (number) - The distance between each row.
    * callback (function) - The callback function to be invoked.

  Returns:  MatterJS.Composite - A Matter JS Composite pyramid."
  ([factory x y columns rows column-gap row-gap callback]
   (phaser->clj
    (.pyramid factory
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser columns)
              (clj->phaser rows)
              (clj->phaser column-gap)
              (clj->phaser row-gap)
              (clj->phaser callback)))))

(defn rectangle
  "Creates a new rigid rectangular Body and adds it to the World.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The X coordinate of the center of the Body.
    * y (number) - The Y coordinate of the center of the Body.
    * width (number) - The width of the Body.
    * height (number) - The height of the Body.
    * options (object) - An object of properties to set on the Body. You can also specify a `chamfer` property to automatically adjust the body.

  Returns:  MatterJS.Body - A Matter JS Body."
  ([factory x y width height options]
   (phaser->clj
    (.rectangle factory
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser options)))))

(defn soft-body
  "Creates a simple soft body like object.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this composite in the world.
    * y (number) - The vertical position of this composite in the world.
    * columns (number) - The number of columns in the Composite.
    * rows (number) - The number of rows in the Composite.
    * column-gap (number) - The distance between each column.
    * row-gap (number) - The distance between each row.
    * cross-brace (boolean) - [description]
    * particle-radius (number) - The radius of this circlular composite.
    * particle-options (object) - [description]
    * constraint-options (object) - [description]

  Returns:  MatterJS.Composite - A new composite simple soft body."
  ([factory x y columns rows column-gap row-gap cross-brace particle-radius particle-options constraint-options]
   (phaser->clj
    (.softBody factory
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser columns)
               (clj->phaser rows)
               (clj->phaser column-gap)
               (clj->phaser row-gap)
               (clj->phaser cross-brace)
               (clj->phaser particle-radius)
               (clj->phaser particle-options)
               (clj->phaser constraint-options)))))

(defn spring
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * body-a (MatterJS.Body) - The first possible `Body` that this constraint is attached to.
    * body-b (MatterJS.Body) - The second possible `Body` that this constraint is attached to.
    * length (number) {optional} - A Number that specifies the target resting length of the constraint. If not given it is calculated automatically in `Constraint.create` from initial positions of the `constraint.bodyA` and `constraint.bodyB`.
    * stiffness (number) {optional} - A Number that specifies the stiffness of the constraint, i.e. the rate at which it returns to its resting `constraint.length`. A value of `1` means the constraint should be very stiff. A value of `0.2` means the constraint acts as a soft spring.
    * options (object) {optional} - [description]

  Returns:  MatterJS.Constraint - A Matter JS Constraint."
  ([factory body-a body-b]
   (phaser->clj
    (.spring factory
             (clj->phaser body-a)
             (clj->phaser body-b))))
  ([factory body-a body-b length]
   (phaser->clj
    (.spring factory
             (clj->phaser body-a)
             (clj->phaser body-b)
             (clj->phaser length))))
  ([factory body-a body-b length stiffness]
   (phaser->clj
    (.spring factory
             (clj->phaser body-a)
             (clj->phaser body-b)
             (clj->phaser length)
             (clj->phaser stiffness))))
  ([factory body-a body-b length stiffness options]
   (phaser->clj
    (.spring factory
             (clj->phaser body-a)
             (clj->phaser body-b)
             (clj->phaser length)
             (clj->phaser stiffness)
             (clj->phaser options)))))

(defn sprite
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this Game Object in the world.
    * y (number) - The vertical position of this Game Object in the world.
    * key (string) - The key of the Texture this Game Object will use to render with, as stored in the Texture Manager.
    * frame (string | integer) {optional} - An optional frame from the Texture this Game Object is rendering with. Set to `null` to skip this value.
    * options (object) {optional} - [description]

  Returns:  Phaser.Physics.Matter.Sprite - [description]"
  ([factory x y key]
   (phaser->clj
    (.sprite factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key))))
  ([factory x y key frame]
   (phaser->clj
    (.sprite factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key)
             (clj->phaser frame))))
  ([factory x y key frame options]
   (phaser->clj
    (.sprite factory
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key)
             (clj->phaser frame)
             (clj->phaser options)))))

(defn stack
  "Create a new composite containing bodies created in the callback in a grid arrangement.
  This function uses the body bounds to prevent overlaps.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The horizontal position of this composite in the world.
    * y (number) - The vertical position of this composite in the world.
    * columns (number) - The number of columns in the grid.
    * rows (number) - The number of rows in the grid.
    * column-gap (number) - The distance between each column.
    * row-gap (number) - The distance between each row.
    * callback (function) - The callback that creates the stack.

  Returns:  MatterJS.Composite - A new composite containing objects created in the callback."
  ([factory x y columns rows column-gap row-gap callback]
   (phaser->clj
    (.stack factory
            (clj->phaser x)
            (clj->phaser y)
            (clj->phaser columns)
            (clj->phaser rows)
            (clj->phaser column-gap)
            (clj->phaser row-gap)
            (clj->phaser callback)))))

(defn tile-body
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * tile (Phaser.Tilemaps.Tile) - [description]
    * options (object) - [description]

  Returns:  Phaser.Physics.Matter.TileBody - [description]"
  ([factory tile options]
   (phaser->clj
    (.tileBody factory
               (clj->phaser tile)
               (clj->phaser options)))))

(defn trapezoid
  "Creates a new rigid trapezoidal Body and adds it to the World.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * x (number) - The X coordinate of the center of the Body.
    * y (number) - The Y coordinate of the center of the Body.
    * width (number) - The width of the trapezoid of the Body.
    * height (number) - The height of the trapezoid of the Body.
    * slope (number) - The slope of the trapezoid. 0 creates a rectangle, while 1 creates a triangle. Positive values make the top side shorter, while negative values make the bottom side shorter.
    * options (object) - An object of properties to set on the Body. You can also specify a `chamfer` property to automatically adjust the body.

  Returns:  MatterJS.Body - A Matter JS Body."
  ([factory x y width height slope options]
   (phaser->clj
    (.trapezoid factory
                (clj->phaser x)
                (clj->phaser y)
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser slope)
                (clj->phaser options)))))

(defn velocity
  "Instantly sets the linear velocity of the given body. Position, angle, force etc. are unchanged.

  See also `force`.

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * body (MatterJS.Body) - The Matter Body to set the velocity on.
    * velocity (Phaser.Types.Math.Vector2Like) - The velocity to set. An object with public `x` and `y` components.

  Returns:  MatterJS.Body - The Matter body."
  ([factory body velocity]
   (phaser->clj
    (.velocity factory
               (clj->phaser body)
               (clj->phaser velocity)))))

(defn world-constraint
  "[description]

  Parameters:
    * factory (Phaser.Physics.Matter.Factory) - Targeted instance for method
    * body-b (MatterJS.Body) - The second possible `Body` that this constraint is attached to.
    * length (number) {optional} - A Number that specifies the target resting length of the constraint. If not given it is calculated automatically in `Constraint.create` from initial positions of the `constraint.bodyA` and `constraint.bodyB`.
    * stiffness (number) {optional} - A Number that specifies the stiffness of the constraint, i.e. the rate at which it returns to its resting `constraint.length`. A value of `1` means the constraint should be very stiff. A value of `0.2` means the constraint acts as a soft spring.
    * options (object) {optional} - [description]

  Returns:  MatterJS.Constraint - A Matter JS Constraint."
  ([factory body-b]
   (phaser->clj
    (.worldConstraint factory
                      (clj->phaser body-b))))
  ([factory body-b length]
   (phaser->clj
    (.worldConstraint factory
                      (clj->phaser body-b)
                      (clj->phaser length))))
  ([factory body-b length stiffness]
   (phaser->clj
    (.worldConstraint factory
                      (clj->phaser body-b)
                      (clj->phaser length)
                      (clj->phaser stiffness))))
  ([factory body-b length stiffness options]
   (phaser->clj
    (.worldConstraint factory
                      (clj->phaser body-b)
                      (clj->phaser length)
                      (clj->phaser stiffness)
                      (clj->phaser options)))))