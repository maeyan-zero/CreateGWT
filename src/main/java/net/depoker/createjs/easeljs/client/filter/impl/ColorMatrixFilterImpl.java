package net.depoker.createjs.easeljs.client.filter.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class ColorMatrixFilterImpl extends JavaScriptObject
{
	protected ColorMatrixFilterImpl() { }

	public static native ColorMatrixFilterImpl create() /*-{
		return new $wnd.createjs.ColorMatrixFilter();
	}-*/;

	public static native ColorMatrixFilterImpl create(JavaScriptObject matrix) /*-{
	    return new $wnd.createjs.ColorMatrixFilter(matrix);
	}-*/;

	public final native boolean applyFilter(JavaScriptObject ctx, float x, float y, float width, float height) /*-{
		return this.applyFilter(ctx, x, y, width, height);
	}-*/;
}
