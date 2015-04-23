/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.easeljs.client.geom.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class RectangleImpl extends JavaScriptObject {
	protected RectangleImpl() {}

	/**
	* Constructs a new Rectangle instance.
	* Represents a rectangle as defined by the points (x,y) and (x+w,y+h).
	*/
	public static native RectangleImpl create() /*-{
		return new $wnd.createjs.Rectangle();
	}-*/;

	/**
	* Constructs a new Rectangle instance.
	* Represents a rectangle as defined by the points (x,y) and (x+w,y+h).
	* @param x X position. Default is 0.
	* @param y Y position. Default is 0.
	* @param w Width. Default is 0.
	* @param h Height. Default is 0.
	*/
	public static native RectangleImpl create(double x, double y, double w, double h) /*-{
		return new $wnd.createjs.Rectangle(x, y, w, h);
	}-*/;

	public final native RectangleImpl clone() /*-{
		return this.clone();
	}-*/;

	public final native double getX() /*-{
		return this.x;
	}-*/;

	public final native void setX(double x) /*-{
		this.x = x;
	}-*/;

	public final native double getY() /*-{
		return this.y;
	}-*/;

	public final native void setY(double y) /*-{
		this.y = y;
	}-*/;

	public final native double getWidth() /*-{
		return this.width;
	}-*/;

	public final native void setWidth(double w) /*-{
		this.width = w;
	}-*/;

	public final native double getHeight() /*-{
		return this.height
	}-*/;

	public final native void setHeight(double h) /*-{
		this.height = h;
	}-*/;
}
