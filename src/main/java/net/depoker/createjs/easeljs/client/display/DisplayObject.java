/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.easeljs.client.display;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsonUtils;
import com.google.gwt.dom.client.CanvasElement;
import net.depoker.createjs.common.client.EventDispatcher;
import net.depoker.createjs.easeljs.client.display.impl.DisplayObjectImpl;
import net.depoker.createjs.easeljs.client.display.impl.ShapeImpl;
import net.depoker.createjs.easeljs.client.event.MouseEvent;
import net.depoker.createjs.easeljs.client.event.impl.MouseEventImpl;
import net.depoker.createjs.easeljs.client.filter.Filter;
import net.depoker.createjs.easeljs.client.geom.Matrix2D;
import net.depoker.createjs.easeljs.client.geom.Point;
import net.depoker.createjs.easeljs.client.geom.Rectangle;
import net.depoker.createjs.easeljs.client.helper.CompositeOperation;
import net.depoker.createjs.easeljs.client.helper.MouseCallback;

/**
 * DisplayObject is an abstract class that should not be constructed directly. Instead construct subclasses such as
 * {@link Container}, {@link Bitmap}, and {@link Shape}. DisplayObject is the base class for all display classes in the
 * EaselJS library. It defines the core properties and methods that are shared between all display objects, such as
 * transformation properties (x, y, scaleX, scaleY, etc), caching, and mouse handlers.
 *
 * @version 0.6.0
 */
public class DisplayObject extends EventDispatcher {

	public final static String CLICK = "click";
	public final static String DOUBLE_CLICK = "dblclick";
	public final static String MOUSE_DOWN = "mousedown";
	public final static String MOUSE_OUT = "mouseout";
	public final static String MOUSE_OVER = "mouseover";
	public final static String TICK = "tick";

	private final DisplayObjectImpl overlay;

	public DisplayObject(DisplayObjectImpl impl) {
		super( impl );
		overlay = impl;
	}

	/**
	 * Returns the jso implementation.
	 *
	 * @return The jso implementation
	 */
	public DisplayObjectImpl getOverlay() { return overlay; }

    /**
     * The alpha (transparency) for this display object. 0 is fully transparent, 1 is fully opaque.
     * <p>The default value is 1.</p>
     *
     * @return The display objects alpha value
     */
	public double getAlpha() { return overlay.getAlpha(); }

    /**
     * The alpha (transparency) for this display object. 0 is fully transparent, 1 is fully opaque.
     * <p>The default value is 1.</p>
     *
     * @param alpha The alpha value between 0 and 1
     */
    public void setAlpha(double alpha) { overlay.setAlpha(alpha); }

    /**
     * If a cache is active, this returns the canvas that holds the cached version of this display object. See cache()
     * for more information. <i>READ-ONLY</i>.
     *
     * @return The cache canvas element
     */
    public CanvasElement getCacheCanvas() { return overlay.getCacheCanvas(); }

    /**
     * Returns an ID number that uniquely identifies the current cache for this display object. This can be used to
     * determine if the cache has changed since a previous check.
     * <p>The default value is 0.</p>
     *
     * @return The display objects cache id
     */
    public int getCacheId() { return overlay.getCacheId(); }

    /**
     * The composite operation indicates how the pixels of this display object will be composited with the elements
     * behind it. If null, this property is inherited from the parent container. For more information, read the
     * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#compositing">
     *     whatwg spec on compositing</a>.
     *
     * @return The composite operation
     */
    public String getCompositeOperation() { return overlay.getCompositeOperation(); }

    /**
     * The composite operation indicates how the pixels of this display object will be composited with the elements
     * behind it. If null, this property is inherited from the parent container. For more information, read the
     * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#compositing">
     *     whatwg spec on compositing</a>.
     *
     * @param operation The composite operation
     */
    public void setCompositeOperation(CompositeOperation operation) { overlay.setCompositeOperation(operation.toString()); }

	/**
	 * The composite operation indicates how the pixels of this display object will be composited with the elements
	 * behind it. If null, this property is inherited from the parent container. For more information, read the
	 * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#compositing">
	 *     whatwg spec on compositing</a>.
	 *
	 * @param operation The composite operation
	 */
	public void setCompositeOperation(String operation) { overlay.setCompositeOperation(operation); }

	/**
	 * A CSS cursor (ex. "pointer", "help", "text", etc) that will be displayed when the user hovers over this display
	 * object. You must enable mouseover events using the stage.enableMouseOver() method to use this property. If null
	 * it will use the default cursor.
	 *
	 * @return The display object css cursor
	 */
	public String getCursor() { return overlay.getCursor(); }

	/**
	 * A CSS cursor (ex. "pointer", "help", "text", etc) that will be displayed when the user hovers over this display
	 * object. You must enable mouseover events using the stage.enableMouseOver() method to use this property. If null
	 * it will use the default cursor.
	 *
	 * @param cursor The display object css cursor
	 */
	public void setCursor(String cursor) { overlay.setCursor(cursor); }

	/**
	 * An array of Filter objects to apply to this display object. Filters are only applied / updated when cache() or
	 * updateCache() is called on the display object, and only apply to the area that is cached.
	 *
	 * @param filter The filter to add to the display object
	 */
    public void addFilter(Filter filter) {
	    JsArray<JavaScriptObject> jsArray = overlay.getFilters();
	    if (jsArray == null) jsArray = JavaScriptObject.createArray().cast();
	    jsArray.push(filter.getOverlay());
	    overlay.setFilters(jsArray);
    }

	/**
	 * Clear all filters.
	 */
	public void clearFilters() { overlay.setFilters(null); }

	/**
	 * A display object that will be tested when checking mouse interactions or testing getObjectsUnderPoint. The hit
	 * area will have its transformation applied relative to this display object's coordinate space (as though the hit
	 * test object were a child of this display object and relative to its regX/Y). The hitArea will be tested using
	 * only its own alpha value regardless of the alpha value on the target display object, or the target's ancestors
	 * (parents). hitArea is NOT currently used by the hitTest() method.
	 * <p>Note that hitArea is not supported for Stage.</p>
	 *
	 * @param hitArea The display object to apply to the display objects hit area
	 */
	public void setHitArea(DisplayObject hitArea) { overlay.setHitArea(hitArea != null ? hitArea.getOverlay() : null); }

	/**
	 * A display object that will be tested when checking mouse interactions or testing getObjectsUnderPoint. The hit
	 * area will have its transformation applied relative to this display object's coordinate space (as though the hit
	 * test object were a child of this display object and relative to its regX/Y). The hitArea will be tested using
	 * only its own alpha value regardless of the alpha value on the target display object, or the target's ancestors
	 * (parents). hitArea is NOT currently used by the hitTest() method.
	 * <p>Note that hitArea is not supported for Stage.</p>
	 *
	 * @return The display object applied to the display objects hit area
	 */
	public DisplayObject getHitArea() { return overlay.getHitArea() != null ? new DisplayObject(overlay.getHitArea()) : null; }

    /**
     * Unique ID for this display object. Makes display objects easier for some uses.
     *
     * @return The display objects unique id
     */
    public int getId() { return overlay.getId();  }

    /**
     * Unique ID for this display object. Makes display objects easier for some uses.
     *
     * @param id The id to assign this object
     */
    public void setId(int id) { overlay.setId(id); }

	/**
	 * A Shape instance that defines a vector mask (clipping path) for this display object.  The shape's transformation
	 * will be applied relative to the display object's parent coordinates (as if it were a child of the parent)
	 *
	 * @param mask The display object mask
	 */
	public void setMask(Shape mask) { overlay.setMask(mask != null ? (ShapeImpl)mask.getOverlay() : null); }

	/**
	 * A Shape instance that defines a vector mask (clipping path) for this display object.  The shape's transformation
	 * will be applied relative to the display object's parent coordinates (as if it were a child of the parent)
	 *
	 * @return The display object mask
	 */
	public Shape getMask() { return (overlay.getMask() != null) ? new Shape(overlay.getMask()) : null; }

	/**
     * Indicates whether to include this object when running Stage.getObjectsUnderPoint(). Setting this to true for
     * Sprites will cause the Sprite to be returned (not its children) regardless of whether it's mouseChildren property
     * is true.
     *
     * @return True if mouse enabled
     */
    public boolean getMouseEnabled() { return overlay.getMouseEnabled(); }

	/**
	 * Indicates whether to include this object when running Stage.getObjectsUnderPoint(). Setting this to true for
	 * Sprites will cause the Sprite to be returned (not its children) regardless of whether it's mouseChildren property
	 * is true.
	 *
	 * @param enabled True to enable mouse
	 */
    public void setMouseEnabled(boolean enabled) { overlay.setMouseEnabled(enabled); }

    /**
     * An optional name for this display object. Included in toString(). Useful for debugging.
     *
     * @return The display objects assigned name
     */
    public String getName() { return overlay.getName(); }

    /**
     * An optional name for this display object. Included in toString(). Useful for debugging.
     *
     * @param name The name to assign
     */
    public void setName(String name) { overlay.setName(name); }

    /**
     * A reference to the Sprite or Stage object that contains this display object, or null if it has not been added to
     * one. <i>READ-ONLY</i>.
     *
     * @return The objects parents if it has one (otherwise null)
     */
    public DisplayObject getParent() { return new DisplayObject(overlay.getParent()); }

    /**
     * The x offset for this display object's registration point. For example, to make a 100x100px Bitmap rotate around
     * it's center, you would set regX and regY to 50.
     *
     * @return The x axis registration point
     */
    public double getRegX() { return overlay.getRegX(); }

    /**
     * The x offset for this display object's registration point. For example, to make a 100x100px Bitmap rotate around
     * it's center, you would set regX and regY to 50.
     *
     * @param x The x axis registration point
     */
    public void setRegX(double x) { overlay.setRegX(x); }

    /**
     * The y offset for this display object's registration point. For example, to make a 100x100px Bitmap rotate around
     * it's center, you would set regX and regY to 50.
     *
     * @return The y axis registration point
     */
    public double getRegY() { return overlay.getRegY(); }

    /**
     * The y offset for this display object's registration point. For example, to make a 100x100px Bitmap rotate around
     * it's center, you would set regX and regY to 50.
     *
     * @param y The y axis registration point
     */
    public void setRegY(double y) { overlay.setRegY(y); }

    /**
     * The rotation in degrees for this display object.
     *
     * @return The degrees of rotation
     */
    public double getRotation() { return overlay.getRotation(); }

    /**
     * The rotation in degrees for this display object.
     *
     * @param degrees The degrees of rotation
     */
    public void setRotation(double degrees) { overlay.setRotation(degrees); }

    /**
     * The factor to stretch this display object horizontally. For example, setting scaleX to 2 will stretch the display
     * object to twice it's nominal width.
     *
     * @return The x axis scale factor
     */
    public double getScaleX() { return overlay.getScaleX(); }

    /**
     * The factor to stretch this display object horizontally. For example, setting scaleX to 2 will stretch the display
     * object to twice it's nominal width.
     *
     * @param x The x axis scale factor
     */
    public void setScaleX(double x) {  overlay.setScaleX(x); }

    /**
     * The factor to stretch this display object vertically. For example, setting scaleY to 0.5 will stretch the display
     * object to half it's nominal height.
     *
     * @return The y axis scale factor
     */
    public double getScaleY() { return overlay.getScaleY(); }

    /**
     * The factor to stretch this display object vertically. For example, setting scaleY to 0.5 will stretch the display
     * object to half it's nominal height.
     *
     * @param y The y axis scale factor
     */
    public void setScaleY(double y) { overlay.setScaleY(y); }

    /**
     * A shadow object that defines the shadow to render on this display object. Set to null to remove a shadow. If null,
     * this property is inherited from the parent container.
     *
     * @return The display objects shadow
     */
    public Shadow getShadow() { return overlay.getShadow() != null ? new Shadow(overlay.getShadow()) : null; }

    /**
     * A shadow object that defines the shadow to render on this display object. Set to null to remove a shadow. If null,
     * this property is inherited from the parent container.
     *
     * @param shadow The display objects shadow
     */
    public void setShadow(Shadow shadow) { overlay.setShadow(shadow != null ? shadow.getOverlay() : null); }

    /**
     * The factor to skew this display object horizontally.
     *
     * @return The horizontal skew factor
     */
    public double getSkewX() { return overlay.getSkewX(); }

    /**
     * The factor to skew this display object horizontally.
     *
     * @param x The horizontal skew factor
     */
    public void setSkewX(double x) { overlay.setSkewX(x); }

    /**
     * The factor to skew this display object vertically.
     *
     * @return The vertical skew factor
     */
    public double getSkewY() { return overlay.getSkewY(); }

    /**
     * The factor to skew this display object vertically.
     *
     * @param y The vertical skew factor
     */
    public void setSkewY(double y) { overlay.setSkewY(y); }

    /**
     * Indicates whether the display object should have it's x & y position rounded prior to drawing it to stage. This
     * only applies if the enclosing stage has snapPixelsEnabled set to true, and the display object's composite
     * transform does not include any scaling, rotation, or skewing. The snapToPixel property is true by default for
     * Bitmap and BitmapAnimation instances, and false for all other display objects.
     *
     * @return True if snapToPixel is enabled
     * @deprecated Hardware acceleration in modern browsers makes this unnecessary
     */
    public boolean getSnapToPixel() { return overlay.getSnapToPixel(); }

    /**
     * Indicates whether the display object should have it's x & y position rounded prior to drawing it to stage. This
     * only applies if the enclosing stage has snapPixelsEnabled set to true, and the display object's composite
     * transform does not include any scaling, rotation, or skewing. The snapToPixel property is true by default for
     * Bitmap and BitmapAnimation instances, and false for all other display objects.
     *
     * @param snapToPixel True to enable snapToPixel
     * @deprecated Hardware acceleration in modern browsers makes this unnecessary
     */
    public void setSnapToPixel(boolean snapToPixel) { overlay.setSnapToPixel(snapToPixel); }

    /**
     * Suppresses errors generated when using features like hitTest, onPress/onClick, and getObjectsUnderPoint with
     * cross domain content.
     * <p>The default value is false.</p>
     *
     * @return True if cross domain errors are suppressed
     */
    public static boolean getSuppressCrossDomainErrors() { return DisplayObjectImpl.getSuppressCrossDomainErrors(); }

    /**
     * Suppresses errors generated when using features like hitTest, onPress/onClick, and getObjectsUnderPoint with
     * cross domain content.
     * <p>The default value is false.</p>
     *
     * @param value True if cross domain errors are suppressed
     */
    public static void setSuppressCrossDomainErrors(boolean value) { DisplayObjectImpl.setSuppressCrossDomainErrors(value); }

	/**
	 * Indicates whether this display object should be rendered to the canvas and included when running
	 * Stage.getObjectsUnderPoint().
	 *
	 * @return True if the display object is set visible.
	 */
	public boolean getVisible() { return overlay.getVisible(); }

	/**
	 * Indicates whether this display object should be rendered to the canvas and included when running
	 * Stage.getObjectsUnderPoint().
	 *
	 * @param visible True to enable display object visibility
	 */
	public void setVisible(boolean visible) { overlay.setVisible(visible); }

    /**
     * The x (horizontal) position of the display object, relative to its parent.
     *
     * @return The display object x coordinate
     */
    public double getX() { return overlay.getX(); }

    /**
     * The x (horizontal) position of the display object, relative to its parent.
     *
     * @param x The display object x coordinate
     */
    public void setX(double x) { overlay.setX(x); }

    /**
     * The y (vertical) position of the display object, relative to its parent.
     *
     * @return The display object y coordinate
     */
    public double getY() { return overlay.getY(); }

    /**
     * The y (vertical) position of the display object, relative to its parent.
     *
     * @param y The display object y coordinate
     */
    public void setY(double y) { overlay.setY(y); }

    //
    // Methods:
    //

    /**
     * Draws the display object into a new canvas, which is then used for subsequent draws. For complex content that
     * does not change frequently (ex. a Sprite with many children that do not move, or a complex vector Shape), this
     * can provide for much faster rendering because the content does not need to be re-rendered each tick. The cached
     * display object can be moved, rotated, faded, etc freely, however if it's content changes, you must manually
     * update the cache by calling updateCache() or cache() again. You must specify the cache area via the x, y, w, and
     * h parameters. This defines the rectangle that will be rendered and cached using this display object's
     * coordinates. For example if you defined a Shape that drew a circle at 0, 0 with a radius of 25, you could call
     * myShape.cache(-25, -25, 50, 50) to cache the full shape.
     *
     * @param x The x coordinate origin for the cache region
     * @param y The y coordinate origin for the cache region
     * @param w The width of the cache region
     * @param h The height of the cache region
     */
    public void cache(double x, double y, double w, double h) { overlay.cache(x, y, w, h); }

	/**
	 * Draws the display object into a new canvas, which is then used for subsequent draws. For complex content that
	 * does not change frequently (ex. a Sprite with many children that do not move, or a complex vector Shape), this
	 * can provide for much faster rendering because the content does not need to be re-rendered each tick. The cached
	 * display object can be moved, rotated, faded, etc freely, however if it's content changes, you must manually
	 * update the cache by calling updateCache() or cache() again. You must specify the cache area via the x, y, w, and
	 * h parameters. This defines the rectangle that will be rendered and cached using this display object's
	 * coordinates. For example if you defined a Shape that drew a circle at 0, 0 with a radius of 25, you could call
	 * myShape.cache(-25, -25, 50, 50) to cache the full shape.
	 *
	 * @param x     The x coordinate origin for the cache region
	 * @param y     The y coordinate origin for the cache region
	 * @param w     The width of the cache region
	 * @param h     The height of the cache region
	 * @param scale The scale at which the cache will be created. For example, if you cache a vector shape using
	 *              myShape.cache(0,0,100,100,2) then the resulting cacheCanvas will be 200x200 px. This lets you scale
	 *              and rotate cached elements with greater fidelity. Default is 1
	 */
	public void cache(double x, double y, double w, double h, double scale) { overlay.cache(x, y, w, h, scale); }

    /**
     * Returns a clone of this DisplayObject. Some properties that are specific to this instance's current context are
     * reverted to their defaults (for example .parent).
     *
     * @return A clone of the current DisplayObject instance
     */
    public DisplayObject clone() { return new DisplayObject(overlay.clone()); }

    /**
     * Draws the display object into the specified context ignoring it's visible, alpha, shadow, and transform. Returns
     * true if the draw was handled (useful for overriding functionality). NOTE: This method is mainly for internal use,
     * though it may be useful for advanced uses.
     *
     * @param ctx The canvas 2D context object to draw into
     * @param ignoreCache Indicates whether the draw operation should ignore any current cache. For example, used for
     *                    drawing the cache (to prevent it from simply drawing an existing cache back into itself)
     */
    public void draw(Canvas ctx, boolean ignoreCache) { overlay.draw(ctx.getContext2d(), ignoreCache); }

    /**
     * Draws the display object into the specified context ignoring it's visible, alpha, shadow, and transform. Returns
     * true if the draw was handled (useful for overriding functionality). NOTE: This method is mainly for internal use,
     * though it may be useful for advanced uses.
     * @param ctx The canvas 2D context object to draw into.
     * @param ignoreCache Indicates whether the draw operation should ignore any current cache. For example, used for
     *                    drawing the cache (to prevent it from simply drawing an existing cache back into itself).
     */
    public void draw(CanvasElement ctx, boolean ignoreCache) { overlay.draw(ctx.getContext2d(), ignoreCache); }

    /**
     * Returns a data URL for the cache, or null if this display object is not cached. Uses cacheID to ensure a new data
     * URL is not generated if the cache has not changed.
     *
     * @return The data URL for the cache
     */
    public String getCacheDataURL() { return overlay.getCacheDataURL(); }

    /**
     * Generates a concatenated Matrix2D object representing the combined transform of the display object and all of its
     * parent Containers up to the highest level ancestor (usually the stage). This can be used to transform positions
     * between coordinate spaces, such as with localToGlobal and globalToLocal.
     *
     * @return a concatenated Matrix2D object representing the combined transform of the display object and all of its
     *         parent Containers up to the highest level ancestor (usually the stage).
     */
    public Matrix2D getConcatenatedMatrix() { return new Matrix2D(overlay.getConcatenatedMatrix(null)); }

    /**
     * Generates a concatenated Matrix2D object representing the combined transform of the display object and all of its
     * parent Containers up to the highest level ancestor (usually the stage). This can be used to transform positions
     * between coordinate spaces, such as with localToGlobal and globalToLocal.
     *
     * @param mtx A Matrix2D object to populate with the calculated values. If null, a new Matrix object is returned.
     * @return a concatenated Matrix2D object representing the combined transform of the display object and all of its
     *         parent Containers up to the highest level ancestor (usually the stage).
     */
    public Matrix2D getConcatenatedMatrix(Matrix2D mtx) { return new Matrix2D(overlay.getConcatenatedMatrix(mtx.getImpl())); }

    /**
     * Returns the stage that this display object will be rendered on, or null if it has not been added to one.
     *
     * @return The Stage instance that the display object is a descendent of. null if the DisplayObject has not been
     *         added to a Stage.
     */
    public Stage getStage() { return (overlay.getStage() != null) ? new Stage(overlay.getStage()) : null; }

    /**
     * Transforms the specified x and y position from the global (stage) coordinate space to the coordinate space of the
     * display object. For example, this could be used to determine the current mouse position within the display object.
     * Returns a Point instance with x and y properties correlating to the transformed position in the display object's
     * coordinate space.
     *
     * @param x The x position on the stage to transform.
     * @param y The y position on the stage to transform.
     * @return A Point instance with x and y properties correlating to the transformed position in the display object's
     *         coordinate space.
     */
    public Point globalToLocal(int x, int y) { return new Point(overlay.globalToLobal(x, y)); }

    /**
     * Tests whether the display object intersects the specified local point (ie. draws a pixel with alpha > 0 at the
     * specified position). This ignores the alpha, shadow and compositeOperation of the display object, and all
     * transform properties including regX/Y.
     *
     * @param x The x position to check in the display object's local coordinates.
     * @param y The y position to check in the display object's local coordinates.
     * @return A Boolean indicting whether a visible portion of the DisplayObject intersect the specified local Point.
     */
    public boolean hitTest(int x, int y) { return overlay.hitTest(x, y); }

	/**
	 * Returns true or false indicating whether the display object would be visible if drawn to a canvas. This does not
	 * account for whether it would be visible within the boundaries of the stage. NOTE: This method is mainly for
	 * internal use, though it may be useful for advanced uses.
	 *
	 * @return Boolean indicating whether the display object would be visible if drawn to a canvas
	 */
	public boolean isVisible() { return overlay.isVisible(); }

	/**
     * Transforms the specified x and y position from the coordinate space of the display object to the global (stage)
     * coordinate space. For example, this could be used to position an HTML label over a specific point on a nested
     * display object. Returns a Point instance with x and y properties correlating to the transformed coordinates on
     * the stage.
	 *
     * @param x The x position in the source display object to transform.
     * @param y The y position in the source display object to transform.
     * @return A Point instance with x and y properties correlating to the transformed coordinates on the stage.
     */
    public Point localToGlobal(int x, int y) { return new Point(overlay.localToGlobal(x, y)); }

    /**
     * Transforms the specified x and y position from the coordinate space of this display object to the coordinate
     * space of the target display object. Returns a Point instance with x and y properties correlating to the
     * transformed position in the target's coordinate space. Effectively the same as calling
     * <pre>Point pt = this.localToGlobal(x, y);</pre>
     * <pre>pt = target.globalToLocal(pt.x, pt.y);</pre>
     *
     * @param x The x position in the source display object to transform.
     * @param y The y position on the stage to transform.
     * @param target The target display object to which the coordinates will be transformed.
     * @return Returns a Point instance with x and y properties correlating to the transformed position in the target's
     * coordinate space.
     */
    public Point localToLocal(int x, int y, DisplayObject target) { return new Point(overlay.localToLocal(x, y, target.getOverlay())); }
	/**
	 * Provides a chainable shortcut method for setting a number of properties on a DisplayObject instance.
	 * Ex. var shape = stage.addChild( new Shape() ).set({graphics:myGraphics, x:100, y:100, alpha:0.5});
	 *
	 * @param props A generic object containing properties to copy to the DisplayObject instance.
	 */
	public void set(String props) { overlay.set(JsonUtils.unsafeEval(props)); }

	/**
     * Shortcut method to quickly set the transform properties on the display object. All parameters are optional.
     * Omitted parameters will have the default value set (ex. 0 for x/y, 1 for scaleX/Y).
     */
    public void setTransform(double x, double y, double scaleX, double scaleY, double rotation, double skewX, double skewY, double regX, double regY)
    {
        overlay.setTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
    }

	/**
	 * Applies this display object's transformation, alpha, globalCompositeOperation, clipping path (mask), and shadow
	 * to the specified context. This is typically called prior to draw.
	 *
	 * @param ctx The canvas 2D to update
	 */
	public void updateContext(Canvas ctx) { overlay.updateContext(ctx.getContext2d()); }

	/**
	 * Applies this display object's transformation, alpha, globalCompositeOperation, clipping path (mask), and shadow
	 * to the specified context. This is typically called prior to draw.
	 *
	 * @param ctx The canvas 2D to update
	 */
	public void updateContext(CanvasElement ctx) { overlay.updateContext(ctx.getContext2d()); }

	/**
	 * Returns a string representation of this object.
	 *
	 * @return a string representation of the instance.
	 */
	public String toString() { return overlay.toStringDisplayObject(); }

    /**
     * Clears the current cache. See cache() for more information.
     */
    public void uncache() { overlay.uncache(); }

    /**
     * Redraws the display object to its cache. Calling updateCache without an active cache will throw an error. If
     * compositeOperation is null the current cache will be cleared prior to drawing. Otherwise the display object will
     * be drawn over the existing cache using the specified compositeOperation.
     *
     * @param compositeOperation The compositeOperation to use, or null to clear the cache and redraw it.
     */
    public void updateCache(String compositeOperation) { overlay.updateCache(compositeOperation); }

	public Rectangle getBounds() {
		return new Rectangle( overlay.getBounds() );
	}

    //
    // Events:
    //

	//
	// Helper methods:
	//

	/**
	 * Fire a mouse event, wrapping the returned event parameter in a pojo.
	 *
	 * @param callback The callback to fire
	 * @param event    The associated click event object
	 */
	private static void fireMouseEvent(MouseCallback callback, MouseEventImpl event) {
		callback.run(new MouseEvent(event));
	}

}
