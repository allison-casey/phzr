(ns phzr.game-objects.group
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser])
  (:refer-clojure :exclude [remove get]))

(defn ->Group
  "  Parameters:
    * scene (Phaser.Scene) - The scene this group belongs to.
    * children (Array.<Phaser.GameObjects.GameObject> | Phaser.Types.GameObjects.Group.GroupConfig | Phaser.Types.GameObjects.Group.GroupCreateConfig) {optional} - Game Objects to add to this group; or the `config` argument.
    * config (Phaser.Types.GameObjects.Group.GroupConfig | Phaser.Types.GameObjects.Group.GroupCreateConfig) {optional} - Settings for this group. If `key` is set, Phaser.GameObjects.Group#createMultiple is also called with these settings."
  ([scene]
   (js/Phaser.GameObjects.Group. (clj->phaser scene)))
  ([scene children]
   (js/Phaser.GameObjects.Group. (clj->phaser scene)
                                 (clj->phaser children)))
  ([scene children config]
   (js/Phaser.GameObjects.Group. (clj->phaser scene)
                                 (clj->phaser children)
                                 (clj->phaser config))))

(defn add
  "Adds a Game Object to this group.

  Calls {@link Phaser.GameObjects.Group#createCallback}.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to add.
    * add-to-scene (boolean) {optional} - Also add the Game Object to the scene.

  Returns:  Phaser.GameObjects.Group - This Group object."
  ([group child]
   (phaser->clj
    (.add group
          (clj->phaser child))))
  ([group child add-to-scene]
   (phaser->clj
    (.add group
          (clj->phaser child)
          (clj->phaser add-to-scene)))))

(defn add-multiple
  "Adds several Game Objects to this group.

  Calls {@link Phaser.GameObjects.Group#createCallback}.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * children (Array.<Phaser.GameObjects.GameObject>) - The Game Objects to add.
    * add-to-scene (boolean) {optional} - Also add the Game Objects to the scene.

  Returns:  Phaser.GameObjects.Group - This group."
  ([group children]
   (phaser->clj
    (.addMultiple group
                  (clj->phaser children))))
  ([group children add-to-scene]
   (phaser->clj
    (.addMultiple group
                  (clj->phaser children)
                  (clj->phaser add-to-scene)))))

(defn clear
  "Removes all members of this Group and optionally removes them from the Scene and / or destroys them.

  Does not call {@link Phaser.GameObjects.Group#removeCallback}.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * remove-from-scene (boolean) {optional} - Optionally remove each Group member from the Scene.
    * destroy-child (boolean) {optional} - Optionally call destroy on the removed Group members.

  Returns:  Phaser.GameObjects.Group - This group."
  ([group]
   (phaser->clj
    (.clear group)))
  ([group remove-from-scene]
   (phaser->clj
    (.clear group
            (clj->phaser remove-from-scene))))
  ([group remove-from-scene destroy-child]
   (phaser->clj
    (.clear group
            (clj->phaser remove-from-scene)
            (clj->phaser destroy-child)))))

(defn contains
  "Tests if a Game Object is a member of this group.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - A Game Object.

  Returns:  boolean - True if the Game Object is a member of this group."
  ([group child]
   (phaser->clj
    (.contains group
               (clj->phaser child)))))

(defn count-active
  "Counts the number of active (or inactive) group members.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * value (boolean) {optional} - Count active (true) or inactive (false) group members.

  Returns:  integer - The number of group members with an active state matching the `active` argument."
  ([group]
   (phaser->clj
    (.countActive group)))
  ([group value]
   (phaser->clj
    (.countActive group
                  (clj->phaser value)))))

(defn create
  "Creates a new Game Object and adds it to this group, unless the group {@link Phaser.GameObjects.Group#isFull is full}.

  Calls {@link Phaser.GameObjects.Group#createCallback}.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * x (number) {optional} - The horizontal position of the new Game Object in the world.
    * y (number) {optional} - The vertical position of the new Game Object in the world.
    * key (string) {optional} - The texture key of the new Game Object.
    * frame (string | integer) {optional} - The texture frame of the new Game Object.
    * visible (boolean) {optional} - The {@link Phaser.GameObjects.Components.Visible#visible} state of the new Game Object.
    * active (boolean) {optional} - The {@link Phaser.GameObjects.GameObject#active} state of the new Game Object.

  Returns:  any - The new Game Object (usually a Sprite, etc.)."
  ([group]
   (phaser->clj
    (.create group)))
  ([group x]
   (phaser->clj
    (.create group
             (clj->phaser x))))
  ([group x y]
   (phaser->clj
    (.create group
             (clj->phaser x)
             (clj->phaser y))))
  ([group x y key]
   (phaser->clj
    (.create group
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key))))
  ([group x y key frame]
   (phaser->clj
    (.create group
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key)
             (clj->phaser frame))))
  ([group x y key frame visible]
   (phaser->clj
    (.create group
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key)
             (clj->phaser frame)
             (clj->phaser visible))))
  ([group x y key frame visible active]
   (phaser->clj
    (.create group
             (clj->phaser x)
             (clj->phaser y)
             (clj->phaser key)
             (clj->phaser frame)
             (clj->phaser visible)
             (clj->phaser active)))))

(defn create-from-config
  "A helper for {@link Phaser.GameObjects.Group#createMultiple}.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * options (Phaser.Types.GameObjects.Group.GroupCreateConfig) - Creation settings.

  Returns:  Array.<any> - The newly created Game Objects."
  ([group options]
   (phaser->clj
    (.createFromConfig group
                       (clj->phaser options)))))

(defn create-multiple
  "Creates several Game Objects and adds them to this group.

  If the group becomes {@link Phaser.GameObjects.Group#isFull}, no further Game Objects are created.

  Calls {@link Phaser.GameObjects.Group#createMultipleCallback} and {@link Phaser.GameObjects.Group#createCallback}.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * config (Phaser.Types.GameObjects.Group.GroupCreateConfig | Array.<Phaser.Types.GameObjects.Group.GroupCreateConfig>) - Creation settings. This can be a single configuration object or an array of such objects, which will be applied in turn.

  Returns:  Array.<any> - The newly created Game Objects."
  ([group config]
   (phaser->clj
    (.createMultiple group
                     (clj->phaser config)))))

(defn destroy
  "Empties this group and removes it from the Scene.

  Does not call {@link Phaser.GameObjects.Group#removeCallback}.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * destroy-children (boolean) {optional} - Also {@link Phaser.GameObjects.GameObject#destroy} each group member."
  ([group]
   (phaser->clj
    (.destroy group)))
  ([group destroy-children]
   (phaser->clj
    (.destroy group
              (clj->phaser destroy-children)))))

(defn get
  "Scans the group for the first member that has an {@link Phaser.GameObjects.GameObject#active} state set to `false`,
  assigns `x` and `y`, and returns the member.

  If no inactive member is found and the group isn't full then it will create a new Game Object using `x`, `y`, `key`, `frame`, and `visible`.
  The new Game Object will have its active state set to `true`.
  Unless a new member is created, `key`, `frame`, and `visible` are ignored.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * x (number) {optional} - The horizontal position of the Game Object in the world.
    * y (number) {optional} - The vertical position of the Game Object in the world.
    * key (string) {optional} - The texture key assigned to a new Game Object (if one is created).
    * frame (string | integer) {optional} - A texture frame assigned to a new Game Object (if one is created).
    * visible (boolean) {optional} - The {@link Phaser.GameObjects.Components.Visible#visible} state of a new Game Object (if one is created).

  Returns:  any - The first inactive group member, or a newly created member, or null."
  ([group]
   (phaser->clj
    (.get group)))
  ([group x]
   (phaser->clj
    (.get group
          (clj->phaser x))))
  ([group x y]
   (phaser->clj
    (.get group
          (clj->phaser x)
          (clj->phaser y))))
  ([group x y key]
   (phaser->clj
    (.get group
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser key))))
  ([group x y key frame]
   (phaser->clj
    (.get group
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser key)
          (clj->phaser frame))))
  ([group x y key frame visible]
   (phaser->clj
    (.get group
          (clj->phaser x)
          (clj->phaser y)
          (clj->phaser key)
          (clj->phaser frame)
          (clj->phaser visible)))))

(defn get-children
  "All members of the group.

  Returns:  Array.<Phaser.GameObjects.GameObject> - The group members."
  ([group]
   (phaser->clj
    (.getChildren group))))

(defn get-first
  "Scans the Group, from top to bottom, for the first member that has an {@link Phaser.GameObjects.GameObject#active} state matching the argument,
  assigns `x` and `y`, and returns the member.

  If no matching member is found and `createIfNull` is true and the group isn't full then it will create a new Game Object using `x`, `y`, `key`, `frame`, and `visible`.
  Unless a new member is created, `key`, `frame`, and `visible` are ignored.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * state (boolean) {optional} - The {@link Phaser.GameObjects.GameObject#active} value to match.
    * create-if-null (boolean) {optional} - Create a new Game Object if no matching members are found, using the following arguments.
    * x (number) {optional} - The horizontal position of the Game Object in the world.
    * y (number) {optional} - The vertical position of the Game Object in the world.
    * key (string) {optional} - The texture key assigned to a new Game Object (if one is created).
    * frame (string | integer) {optional} - A texture frame assigned to a new Game Object (if one is created).
    * visible (boolean) {optional} - The {@link Phaser.GameObjects.Components.Visible#visible} state of a new Game Object (if one is created).

  Returns:  any - The first matching group member, or a newly created member, or null."
  ([group]
   (phaser->clj
    (.getFirst group)))
  ([group state]
   (phaser->clj
    (.getFirst group
               (clj->phaser state))))
  ([group state create-if-null]
   (phaser->clj
    (.getFirst group
               (clj->phaser state)
               (clj->phaser create-if-null))))
  ([group state create-if-null x]
   (phaser->clj
    (.getFirst group
               (clj->phaser state)
               (clj->phaser create-if-null)
               (clj->phaser x))))
  ([group state create-if-null x y]
   (phaser->clj
    (.getFirst group
               (clj->phaser state)
               (clj->phaser create-if-null)
               (clj->phaser x)
               (clj->phaser y))))
  ([group state create-if-null x y key]
   (phaser->clj
    (.getFirst group
               (clj->phaser state)
               (clj->phaser create-if-null)
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser key))))
  ([group state create-if-null x y key frame]
   (phaser->clj
    (.getFirst group
               (clj->phaser state)
               (clj->phaser create-if-null)
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser key)
               (clj->phaser frame))))
  ([group state create-if-null x y key frame visible]
   (phaser->clj
    (.getFirst group
               (clj->phaser state)
               (clj->phaser create-if-null)
               (clj->phaser x)
               (clj->phaser y)
               (clj->phaser key)
               (clj->phaser frame)
               (clj->phaser visible)))))

(defn get-first-alive
  "Scans the group for the first member that has an {@link Phaser.GameObjects.GameObject#active} state set to `true`,
  assigns `x` and `y`, and returns the member.

  If no active member is found and `createIfNull` is `true` and the group isn't full then it will create a new one using `x`, `y`, `key`, `frame`, and `visible`.
  Unless a new member is created, `key`, `frame`, and `visible` are ignored.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * create-if-null (boolean) {optional} - Create a new Game Object if no matching members are found, using the following arguments.
    * x (number) {optional} - The horizontal position of the Game Object in the world.
    * y (number) {optional} - The vertical position of the Game Object in the world.
    * key (string) {optional} - The texture key assigned to a new Game Object (if one is created).
    * frame (string | integer) {optional} - A texture frame assigned to a new Game Object (if one is created).
    * visible (boolean) {optional} - The {@link Phaser.GameObjects.Components.Visible#visible} state of a new Game Object (if one is created).

  Returns:  any - The first active group member, or a newly created member, or null."
  ([group]
   (phaser->clj
    (.getFirstAlive group)))
  ([group create-if-null]
   (phaser->clj
    (.getFirstAlive group
                    (clj->phaser create-if-null))))
  ([group create-if-null x]
   (phaser->clj
    (.getFirstAlive group
                    (clj->phaser create-if-null)
                    (clj->phaser x))))
  ([group create-if-null x y]
   (phaser->clj
    (.getFirstAlive group
                    (clj->phaser create-if-null)
                    (clj->phaser x)
                    (clj->phaser y))))
  ([group create-if-null x y key]
   (phaser->clj
    (.getFirstAlive group
                    (clj->phaser create-if-null)
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser key))))
  ([group create-if-null x y key frame]
   (phaser->clj
    (.getFirstAlive group
                    (clj->phaser create-if-null)
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser key)
                    (clj->phaser frame))))
  ([group create-if-null x y key frame visible]
   (phaser->clj
    (.getFirstAlive group
                    (clj->phaser create-if-null)
                    (clj->phaser x)
                    (clj->phaser y)
                    (clj->phaser key)
                    (clj->phaser frame)
                    (clj->phaser visible)))))

(defn get-first-dead
  "Scans the group for the first member that has an {@link Phaser.GameObjects.GameObject#active} state set to `false`,
  assigns `x` and `y`, and returns the member.

  If no inactive member is found and `createIfNull` is `true` and the group isn't full then it will create a new one using `x`, `y`, `key`, `frame`, and `visible`.
  The new Game Object will have an active state set to `true`.
  Unless a new member is created, `key`, `frame`, and `visible` are ignored.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * create-if-null (boolean) {optional} - Create a new Game Object if no matching members are found, using the following arguments.
    * x (number) {optional} - The horizontal position of the Game Object in the world.
    * y (number) {optional} - The vertical position of the Game Object in the world.
    * key (string) {optional} - The texture key assigned to a new Game Object (if one is created).
    * frame (string | integer) {optional} - A texture frame assigned to a new Game Object (if one is created).
    * visible (boolean) {optional} - The {@link Phaser.GameObjects.Components.Visible#visible} state of a new Game Object (if one is created).

  Returns:  any - The first inactive group member, or a newly created member, or null."
  ([group]
   (phaser->clj
    (.getFirstDead group)))
  ([group create-if-null]
   (phaser->clj
    (.getFirstDead group
                   (clj->phaser create-if-null))))
  ([group create-if-null x]
   (phaser->clj
    (.getFirstDead group
                   (clj->phaser create-if-null)
                   (clj->phaser x))))
  ([group create-if-null x y]
   (phaser->clj
    (.getFirstDead group
                   (clj->phaser create-if-null)
                   (clj->phaser x)
                   (clj->phaser y))))
  ([group create-if-null x y key]
   (phaser->clj
    (.getFirstDead group
                   (clj->phaser create-if-null)
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser key))))
  ([group create-if-null x y key frame]
   (phaser->clj
    (.getFirstDead group
                   (clj->phaser create-if-null)
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser key)
                   (clj->phaser frame))))
  ([group create-if-null x y key frame visible]
   (phaser->clj
    (.getFirstDead group
                   (clj->phaser create-if-null)
                   (clj->phaser x)
                   (clj->phaser y)
                   (clj->phaser key)
                   (clj->phaser frame)
                   (clj->phaser visible)))))

(defn get-first-nth
  "Scans the Group, from top to bottom, for the nth member that has an {@link Phaser.GameObjects.GameObject#active} state matching the argument,
  assigns `x` and `y`, and returns the member.

  If no matching member is found and `createIfNull` is true and the group isn't full then it will create a new Game Object using `x`, `y`, `key`, `frame`, and `visible`.
  Unless a new member is created, `key`, `frame`, and `visible` are ignored.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * nth (integer) - The nth matching Group member to search for.
    * state (boolean) {optional} - The {@link Phaser.GameObjects.GameObject#active} value to match.
    * create-if-null (boolean) {optional} - Create a new Game Object if no matching members are found, using the following arguments.
    * x (number) {optional} - The horizontal position of the Game Object in the world.
    * y (number) {optional} - The vertical position of the Game Object in the world.
    * key (string) {optional} - The texture key assigned to a new Game Object (if one is created).
    * frame (string | integer) {optional} - A texture frame assigned to a new Game Object (if one is created).
    * visible (boolean) {optional} - The {@link Phaser.GameObjects.Components.Visible#visible} state of a new Game Object (if one is created).

  Returns:  any - The first matching group member, or a newly created member, or null."
  ([group nth]
   (phaser->clj
    (.getFirstNth group
                  (clj->phaser nth))))
  ([group nth state]
   (phaser->clj
    (.getFirstNth group
                  (clj->phaser nth)
                  (clj->phaser state))))
  ([group nth state create-if-null]
   (phaser->clj
    (.getFirstNth group
                  (clj->phaser nth)
                  (clj->phaser state)
                  (clj->phaser create-if-null))))
  ([group nth state create-if-null x]
   (phaser->clj
    (.getFirstNth group
                  (clj->phaser nth)
                  (clj->phaser state)
                  (clj->phaser create-if-null)
                  (clj->phaser x))))
  ([group nth state create-if-null x y]
   (phaser->clj
    (.getFirstNth group
                  (clj->phaser nth)
                  (clj->phaser state)
                  (clj->phaser create-if-null)
                  (clj->phaser x)
                  (clj->phaser y))))
  ([group nth state create-if-null x y key]
   (phaser->clj
    (.getFirstNth group
                  (clj->phaser nth)
                  (clj->phaser state)
                  (clj->phaser create-if-null)
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser key))))
  ([group nth state create-if-null x y key frame]
   (phaser->clj
    (.getFirstNth group
                  (clj->phaser nth)
                  (clj->phaser state)
                  (clj->phaser create-if-null)
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser key)
                  (clj->phaser frame))))
  ([group nth state create-if-null x y key frame visible]
   (phaser->clj
    (.getFirstNth group
                  (clj->phaser nth)
                  (clj->phaser state)
                  (clj->phaser create-if-null)
                  (clj->phaser x)
                  (clj->phaser y)
                  (clj->phaser key)
                  (clj->phaser frame)
                  (clj->phaser visible)))))

(defn get-last
  "Scans the Group for the last member that has an {@link Phaser.GameObjects.GameObject#active} state matching the argument,
  assigns `x` and `y`, and returns the member.

  If no matching member is found and `createIfNull` is true and the group isn't full then it will create a new Game Object using `x`, `y`, `key`, `frame`, and `visible`.
  Unless a new member is created, `key`, `frame`, and `visible` are ignored.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * state (boolean) {optional} - The {@link Phaser.GameObjects.GameObject#active} value to match.
    * create-if-null (boolean) {optional} - Create a new Game Object if no matching members are found, using the following arguments.
    * x (number) {optional} - The horizontal position of the Game Object in the world.
    * y (number) {optional} - The vertical position of the Game Object in the world.
    * key (string) {optional} - The texture key assigned to a new Game Object (if one is created).
    * frame (string | integer) {optional} - A texture frame assigned to a new Game Object (if one is created).
    * visible (boolean) {optional} - The {@link Phaser.GameObjects.Components.Visible#visible} state of a new Game Object (if one is created).

  Returns:  any - The first matching group member, or a newly created member, or null."
  ([group]
   (phaser->clj
    (.getLast group)))
  ([group state]
   (phaser->clj
    (.getLast group
              (clj->phaser state))))
  ([group state create-if-null]
   (phaser->clj
    (.getLast group
              (clj->phaser state)
              (clj->phaser create-if-null))))
  ([group state create-if-null x]
   (phaser->clj
    (.getLast group
              (clj->phaser state)
              (clj->phaser create-if-null)
              (clj->phaser x))))
  ([group state create-if-null x y]
   (phaser->clj
    (.getLast group
              (clj->phaser state)
              (clj->phaser create-if-null)
              (clj->phaser x)
              (clj->phaser y))))
  ([group state create-if-null x y key]
   (phaser->clj
    (.getLast group
              (clj->phaser state)
              (clj->phaser create-if-null)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser key))))
  ([group state create-if-null x y key frame]
   (phaser->clj
    (.getLast group
              (clj->phaser state)
              (clj->phaser create-if-null)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser key)
              (clj->phaser frame))))
  ([group state create-if-null x y key frame visible]
   (phaser->clj
    (.getLast group
              (clj->phaser state)
              (clj->phaser create-if-null)
              (clj->phaser x)
              (clj->phaser y)
              (clj->phaser key)
              (clj->phaser frame)
              (clj->phaser visible)))))

(defn get-last-nth
  "Scans the Group for the last nth member that has an {@link Phaser.GameObjects.GameObject#active} state matching the argument,
  assigns `x` and `y`, and returns the member.

  If no matching member is found and `createIfNull` is true and the group isn't full then it will create a new Game Object using `x`, `y`, `key`, `frame`, and `visible`.
  Unless a new member is created, `key`, `frame`, and `visible` are ignored.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * nth (integer) - The nth matching Group member to search for.
    * state (boolean) {optional} - The {@link Phaser.GameObjects.GameObject#active} value to match.
    * create-if-null (boolean) {optional} - Create a new Game Object if no matching members are found, using the following arguments.
    * x (number) {optional} - The horizontal position of the Game Object in the world.
    * y (number) {optional} - The vertical position of the Game Object in the world.
    * key (string) {optional} - The texture key assigned to a new Game Object (if one is created).
    * frame (string | integer) {optional} - A texture frame assigned to a new Game Object (if one is created).
    * visible (boolean) {optional} - The {@link Phaser.GameObjects.Components.Visible#visible} state of a new Game Object (if one is created).

  Returns:  any - The first matching group member, or a newly created member, or null."
  ([group nth]
   (phaser->clj
    (.getLastNth group
                 (clj->phaser nth))))
  ([group nth state]
   (phaser->clj
    (.getLastNth group
                 (clj->phaser nth)
                 (clj->phaser state))))
  ([group nth state create-if-null]
   (phaser->clj
    (.getLastNth group
                 (clj->phaser nth)
                 (clj->phaser state)
                 (clj->phaser create-if-null))))
  ([group nth state create-if-null x]
   (phaser->clj
    (.getLastNth group
                 (clj->phaser nth)
                 (clj->phaser state)
                 (clj->phaser create-if-null)
                 (clj->phaser x))))
  ([group nth state create-if-null x y]
   (phaser->clj
    (.getLastNth group
                 (clj->phaser nth)
                 (clj->phaser state)
                 (clj->phaser create-if-null)
                 (clj->phaser x)
                 (clj->phaser y))))
  ([group nth state create-if-null x y key]
   (phaser->clj
    (.getLastNth group
                 (clj->phaser nth)
                 (clj->phaser state)
                 (clj->phaser create-if-null)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser key))))
  ([group nth state create-if-null x y key frame]
   (phaser->clj
    (.getLastNth group
                 (clj->phaser nth)
                 (clj->phaser state)
                 (clj->phaser create-if-null)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser key)
                 (clj->phaser frame))))
  ([group nth state create-if-null x y key frame visible]
   (phaser->clj
    (.getLastNth group
                 (clj->phaser nth)
                 (clj->phaser state)
                 (clj->phaser create-if-null)
                 (clj->phaser x)
                 (clj->phaser y)
                 (clj->phaser key)
                 (clj->phaser frame)
                 (clj->phaser visible)))))

(defn get-length
  "The number of members of the group.

  Returns:  integer - "
  ([group]
   (phaser->clj
    (.getLength group))))

(defn get-total-free
  "The difference of {@link Phaser.GameObjects.Group#maxSize} and the number of active group members.

  This represents the number of group members that could be created or reactivated before reaching the size limit.

  Returns:  integer - maxSize minus the number of active group numbers; or a large number (if maxSize is -1)."
  ([group]
   (phaser->clj
    (.getTotalFree group))))

(defn get-total-used
  "Counts the number of in-use (active) group members.

  Returns:  integer - The number of group members with an active state of true."
  ([group]
   (phaser->clj
    (.getTotalUsed group))))

(defn is-full
  "Whether this group's size at its {@link Phaser.GameObjects.Group#maxSize maximum}.

  Returns:  boolean - True if the number of members equals {@link Phaser.GameObjects.Group#maxSize}."
  ([group]
   (phaser->clj
    (.isFull group))))

(defn kill
  "Deactivates a member of this group.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - A member of this group."
  ([group game-object]
   (phaser->clj
    (.kill group
           (clj->phaser game-object)))))

(defn kill-and-hide
  "Deactivates and hides a member of this group.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * game-object (Phaser.GameObjects.GameObject) - A member of this group."
  ([group game-object]
   (phaser->clj
    (.killAndHide group
                  (clj->phaser game-object)))))

(defn play-animation
  "{@link Phaser.GameObjects.Components.Animation#play Plays} an animation for all members of this group.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * key (string) - The string-based key of the animation to play.
    * start-frame (string) {optional} - Optionally start the animation playing from this frame index.

  Returns:  Phaser.GameObjects.Group - This Group object."
  ([group key]
   (phaser->clj
    (.playAnimation group
                    (clj->phaser key))))
  ([group key start-frame]
   (phaser->clj
    (.playAnimation group
                    (clj->phaser key)
                    (clj->phaser start-frame)))))

(defn pre-update
  "Updates any group members, if {@link Phaser.GameObjects.Group#runChildUpdate} is enabled.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * time (number) - The current timestamp.
    * delta (number) - The delta time elapsed since the last frame."
  ([group time delta]
   (phaser->clj
    (.preUpdate group
                (clj->phaser time)
                (clj->phaser delta)))))

(defn remove
  "Removes a member of this Group and optionally removes it from the Scene and / or destroys it.

  Calls {@link Phaser.GameObjects.Group#removeCallback}.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * child (Phaser.GameObjects.GameObject) - The Game Object to remove.
    * remove-from-scene (boolean) {optional} - Optionally remove the Group member from the Scene it belongs to.
    * destroy-child (boolean) {optional} - Optionally call destroy on the removed Group member.

  Returns:  Phaser.GameObjects.Group - This Group object."
  ([group child]
   (phaser->clj
    (.remove group
             (clj->phaser child))))
  ([group child remove-from-scene]
   (phaser->clj
    (.remove group
             (clj->phaser child)
             (clj->phaser remove-from-scene))))
  ([group child remove-from-scene destroy-child]
   (phaser->clj
    (.remove group
             (clj->phaser child)
             (clj->phaser remove-from-scene)
             (clj->phaser destroy-child)))))

(defn set-depth
  "Sets the depth of each group member.

  Parameters:
    * group (Phaser.GameObjects.Group) - Targeted instance for method
    * value (number) - The amount to set the property to.
    * step (number) - This is added to the `value` amount, multiplied by the iteration counter.

  Returns:  Phaser.GameObjects.Group - This Group object."
  ([group value step]
   (phaser->clj
    (.setDepth group
               (clj->phaser value)
               (clj->phaser step)))))

(defn toggle-visible
  "Toggles (flips) the visible state of each member of this group.

  Returns:  Phaser.GameObjects.Group - This Group object."
  ([group]
   (phaser->clj
    (.toggleVisible group))))