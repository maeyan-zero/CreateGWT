package net.depoker.createjs.easeljs.client.display;

import net.depoker.createjs.easeljs.client.display.impl.ShapeImpl;

/**
 * A Shape allows you to display vector art in the display list. It composites a Graphics instance which exposes all
 * of the vector drawing methods. The Graphics instance can be shared between multiple Shape instances to display the
 * same vector graphics with different positions or transforms. If the vector art will not change between draws, you
 * may want to use the cache() method to reduce the rendering cost.
 */
public class Shape extends DisplayObject {

	private final ShapeImpl overlay;
	private final Graphics graphics;

	public Shape() {
		this(ShapeImpl.create());
	}
	
	public Shape(ShapeImpl impl) {
		super(impl);
		overlay = impl;
		graphics = new Graphics(overlay.getGraphics());
	}

    /**
     * Returns the graphics object for this class.
     */
	public Graphics getGraphics() {
		return graphics;
	}

    /**
     * Returns a clone of this Shape. Some properties that are specific to this instance's current context are reverted
     * to their defaults (for example .parent).
     *
     * @param recursive If true, this Shape's Graphics instance will also be cloned. If false, the Graphics instance
     *                  will be shared with the new Shape.
     * @return A clone of this Shape.
     */
	public Shape clone(boolean recursive) {
		return new Shape(overlay.clone(recursive));
	}

}
