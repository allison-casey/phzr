(ns phzr.structs.size
  (:require [phzr.impl.utils.core :refer [clj->phaser phaser->clj]]
            [phzr.impl.extend :as ex]
            [cljsjs.phaser]))

(defn ->Size
  "  Parameters:
    * width (number) {optional} - The width of the Size component.
    * height (number) {optional} - The height of the Size component. If not given, it will use the `width`.
    * aspect-mode (integer) {optional} - The aspect mode of the Size component. Defaults to 0, no mode.
    * parent (any) {optional} - The parent of this Size component. Can be any object with public `width` and `height` properties. Dimensions are clamped to keep them within the parent bounds where possible."
  ([]
   (js/Phaser.Structs.Size.))
  ([width]
   (js/Phaser.Structs.Size. (clj->phaser width)))
  ([width height]
   (js/Phaser.Structs.Size. (clj->phaser width)
                            (clj->phaser height)))
  ([width height aspect-mode]
   (js/Phaser.Structs.Size. (clj->phaser width)
                            (clj->phaser height)
                            (clj->phaser aspect-mode)))
  ([width height aspect-mode parent]
   (js/Phaser.Structs.Size. (clj->phaser width)
                            (clj->phaser height)
                            (clj->phaser aspect-mode)
                            (clj->phaser parent))))

(defn constrain
  "The current `width` and `height` are adjusted to fit inside the given dimensions, while keeping the aspect ratio.

  If `fit` is true there may be some space inside the target area which is not covered if its aspect ratio differs.
  If `fit` is false the size may extend further out than the target area if the aspect ratios differ.

  If this Size component has a parent set, then the width and height passed to this method will be clamped so
  it cannot exceed that of the parent.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * width (number) {optional} - The new width of the Size component.
    * height (number) {optional} - The new height of the Size component. If not given, it will use the width value.
    * fit (boolean) {optional} - Perform a `fit` (true) constraint, or an `envelop` (false) constraint.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.constrain size)))
  ([size width]
   (phaser->clj
    (.constrain size
                (clj->phaser width))))
  ([size width height]
   (phaser->clj
    (.constrain size
                (clj->phaser width)
                (clj->phaser height))))
  ([size width height fit]
   (phaser->clj
    (.constrain size
                (clj->phaser width)
                (clj->phaser height)
                (clj->phaser fit)))))

(defn copy
  "Copies the aspect mode, aspect ratio, width and height from this Size component
  to the given Size component. Note that the parent, if set, is not copied across.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * destination (Phaser.Structs.Size) - The Size component to copy the values to.

  Returns:  Phaser.Structs.Size - The updated destination Size component."
  ([size destination]
   (phaser->clj
    (.copy size
           (clj->phaser destination)))))

(defn destroy
  "Destroys this Size component.

  This clears the local properties and any parent object, if set.

  A destroyed Size component cannot be re-used."
  ([size]
   (phaser->clj
    (.destroy size))))

(defn envelop
  "The current `width` and `height` are adjusted so that they fully envlop the given dimensions, while keeping the aspect ratio.

  The size may extend further out than the target area if the aspect ratios differ.

  If this Size component has a parent set, then the values are clamped so that it never exceeds the parent
  on the longest axis.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * width (number) {optional} - The new width of the Size component.
    * height (number) {optional} - The new height of the Size component. If not given, it will use the width value.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.envelop size)))
  ([size width]
   (phaser->clj
    (.envelop size
              (clj->phaser width))))
  ([size width height]
   (phaser->clj
    (.envelop size
              (clj->phaser width)
              (clj->phaser height)))))

(defn fit-to
  "The current `width` and `height` are adjusted to fit inside the given dimensions, while keeping the aspect ratio.

  There may be some space inside the target area which is not covered if its aspect ratio differs.

  If this Size component has a parent set, then the width and height passed to this method will be clamped so
  it cannot exceed that of the parent.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * width (number) {optional} - The new width of the Size component.
    * height (number) {optional} - The new height of the Size component. If not given, it will use the width value.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.fitTo size)))
  ([size width]
   (phaser->clj
    (.fitTo size
            (clj->phaser width))))
  ([size width height]
   (phaser->clj
    (.fitTo size
            (clj->phaser width)
            (clj->phaser height)))))

(defn get-new-height
  "Takes a new height and passes it through the min/max clamp and then checks it doesn't exceed the parent height.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * value (number) - The value to clamp and check.
    * check-parent (boolean) {optional} - Check the given value against the parent, if set.

  Returns:  number - The modified height value."
  ([size value]
   (phaser->clj
    (.getNewHeight size
                   (clj->phaser value))))
  ([size value check-parent]
   (phaser->clj
    (.getNewHeight size
                   (clj->phaser value)
                   (clj->phaser check-parent)))))

(defn get-new-width
  "Takes a new width and passes it through the min/max clamp and then checks it doesn't exceed the parent width.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * value (number) - The value to clamp and check.
    * check-parent (boolean) {optional} - Check the given value against the parent, if set.

  Returns:  number - The modified width value."
  ([size value]
   (phaser->clj
    (.getNewWidth size
                  (clj->phaser value))))
  ([size value check-parent]
   (phaser->clj
    (.getNewWidth size
                  (clj->phaser value)
                  (clj->phaser check-parent)))))

(defn resize
  "Sets a new width and height for this Size component and updates the aspect ratio based on them.

  It _doesn't_ change the `aspectMode` and still factors in size limits such as the min max and parent bounds.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * width (number) - The new width of the Size component.
    * height (number) {optional} - The new height of the Size component. If not given, it will use the `width`.

  Returns:  this - This Size component instance."
  ([size width]
   (phaser->clj
    (.resize size
             (clj->phaser width))))
  ([size width height]
   (phaser->clj
    (.resize size
             (clj->phaser width)
             (clj->phaser height)))))

(defn set-aspect-mode
  "Sets the aspect mode of this Size component.

  The aspect mode controls what happens when you modify the `width` or `height` properties, or call `setSize`.

  It can be a number from 0 to 4, or a Size constant:

  0. NONE = Do not make the size fit the aspect ratio. Change the ratio when the size changes.
  1. WIDTH_CONTROLS_HEIGHT = The height is automatically adjusted based on the width.
  2. HEIGHT_CONTROLS_WIDTH = The width is automatically adjusted based on the height.
  3. FIT = The width and height are automatically adjusted to fit inside the given target area, while keeping the aspect ratio. Depending on the aspect ratio there may be some space inside the area which is not covered.
  4. ENVELOP = The width and height are automatically adjusted to make the size cover the entire target area while keeping the aspect ratio. This may extend further out than the target size.

  Calling this method automatically recalculates the `width` and the `height`, if required.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * value (integer) {optional} - The aspect mode value.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.setAspectMode size)))
  ([size value]
   (phaser->clj
    (.setAspectMode size
                    (clj->phaser value)))))

(defn set-aspect-ratio
  "Sets a new aspect ratio, overriding what was there previously.

  It then calls `setSize` immediately using the current dimensions.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * ratio (number) - The new aspect ratio.

  Returns:  this - This Size component instance."
  ([size ratio]
   (phaser->clj
    (.setAspectRatio size
                     (clj->phaser ratio)))))

(defn set-css
  "Sets the values of this Size component to the `element.style.width` and `height`
  properties of the given DOM Element. The properties are set as `px` values.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * element (HTMLElement) - The DOM Element to set the CSS style on."
  ([size element]
   (phaser->clj
    (.setCSS size
             (clj->phaser element)))))

(defn set-height
  "Sets the height of this Size component.

  Depending on the aspect mode, changing the height may also update the width and aspect ratio.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * height (number) - The new height of the Size component.

  Returns:  this - This Size component instance."
  ([size height]
   (phaser->clj
    (.setHeight size
                (clj->phaser height)))))

(defn set-max
  "Set the maximum width and height values this Size component will allow.

  Setting this will automatically adjust both the `width` and `height` properties to ensure they are within range.

  Note that based on the aspect mode, and if this Size component has a parent set or not, the maximums set here
  _can_ be exceed in some situations.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * width (number) {optional} - The maximum allowed width of the Size component.
    * height (number) {optional} - The maximum allowed height of the Size component. If not given, it will use the `width`.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.setMax size)))
  ([size width]
   (phaser->clj
    (.setMax size
             (clj->phaser width))))
  ([size width height]
   (phaser->clj
    (.setMax size
             (clj->phaser width)
             (clj->phaser height)))))

(defn set-min
  "Set the minimum width and height values this Size component will allow.

  The minimum values can never be below zero, or greater than the maximum values.

  Setting this will automatically adjust both the `width` and `height` properties to ensure they are within range.

  Note that based on the aspect mode, and if this Size component has a parent set or not, the minimums set here
  _can_ be exceed in some situations.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * width (number) {optional} - The minimum allowed width of the Size component.
    * height (number) {optional} - The minimum allowed height of the Size component. If not given, it will use the `width`.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.setMin size)))
  ([size width]
   (phaser->clj
    (.setMin size
             (clj->phaser width))))
  ([size width height]
   (phaser->clj
    (.setMin size
             (clj->phaser width)
             (clj->phaser height)))))

(defn set-parent
  "Sets, or clears, the parent of this Size component.

  To clear the parent call this method with no arguments.

  The parent influences the maximum extents to which this Size compoent can expand,
  based on the aspect mode:

  NONE - The parent clamps both the width and height.
  WIDTH_CONTROLS_HEIGHT - The parent clamps just the width.
  HEIGHT_CONTROLS_WIDTH - The parent clamps just the height.
  FIT - The parent clamps whichever axis is required to ensure the size fits within it.
  ENVELOP - The parent is used to ensure the size fully envelops the parent.

  Calling this method automatically calls `setSize`.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * parent (any) {optional} - Sets the parent of this Size component. Don't provide a value to clear an existing parent.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.setParent size)))
  ([size parent]
   (phaser->clj
    (.setParent size
                (clj->phaser parent)))))

(defn set-size
  "Sets the width and height of this Size component based on the aspect mode.

  If the aspect mode is 'none' then calling this method will change the aspect ratio, otherwise the current
  aspect ratio is honored across all other modes.

  If snapTo values have been set then the given width and height are snapped first, prior to any further
  adjustment via min/max values, or a parent.

  If minimum and/or maximum dimensions have been specified, the values given to this method will be clamped into
  that range prior to adjustment, but may still exceed them depending on the aspect mode.

  If this Size component has a parent set, and the aspect mode is `fit` or `envelop`, then the given sizes will
  be clamped to the range specified by the parent.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * width (number) {optional} - The new width of the Size component.
    * height (number) {optional} - The new height of the Size component. If not given, it will use the `width`.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.setSize size)))
  ([size width]
   (phaser->clj
    (.setSize size
              (clj->phaser width))))
  ([size width height]
   (phaser->clj
    (.setSize size
              (clj->phaser width)
              (clj->phaser height)))))

(defn set-snap
  "By setting a Snap To value when this Size component is modified its dimensions will automatically
  by snapped to the nearest grid slice, using floor. For example, if you have snap value of 16,
  and the width changes to 68, then it will snap down to 64 (the closest multiple of 16 when floored)

  Note that snapping takes place before adjustments by the parent, or the min / max settings. If these
  values are not multiples of the given snap values, then this can result in un-snapped dimensions.

  Call this method with no arguments to reset the snap values.

  Calling this method automatically recalculates the `width` and the `height`, if required.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * snap-width (number) {optional} - The amount to snap the width to. If you don't want to snap the width, pass a value of zero.
    * snap-height (number) {optional} - The amount to snap the height to. If not provided it will use the `snapWidth` value. If you don't want to snap the height, pass a value of zero.

  Returns:  this - This Size component instance."
  ([size]
   (phaser->clj
    (.setSnap size)))
  ([size snap-width]
   (phaser->clj
    (.setSnap size
              (clj->phaser snap-width))))
  ([size snap-width snap-height]
   (phaser->clj
    (.setSnap size
              (clj->phaser snap-width)
              (clj->phaser snap-height)))))

(defn set-width
  "Sets the width of this Size component.

  Depending on the aspect mode, changing the width may also update the height and aspect ratio.

  Parameters:
    * size (Phaser.Structs.Size) - Targeted instance for method
    * width (number) - The new width of the Size component.

  Returns:  this - This Size component instance."
  ([size width]
   (phaser->clj
    (.setWidth size
               (clj->phaser width)))))

(defn to-string
  "Returns a string representation of this Size component.

  Returns:  string - A string representation of this Size component."
  ([size]
   (phaser->clj
    (.toString size))))