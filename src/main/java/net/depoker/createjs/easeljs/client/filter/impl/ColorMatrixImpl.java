package net.depoker.createjs.easeljs.client.filter.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class ColorMatrixImpl extends JavaScriptObject
{
	protected ColorMatrixImpl() { }

	public static native ColorMatrixImpl create() /*-{
		return new $wnd.createjs.ColorMatrix();
	}-*/;

	public static native ColorMatrixImpl create(float brightness, float contrast, float saturation, float hue) /*-{
	    return new $wnd.createjs.ColorMatrix(brightness, contrast, saturation, hue);
	}-*/;

	public final native ColorMatrixImpl adjustColor(float brightness, float contrast, float saturation, float hue) /*-{
        return this.adjustColor(brightness, contrast, saturation, hue);
	}-*/;
}
