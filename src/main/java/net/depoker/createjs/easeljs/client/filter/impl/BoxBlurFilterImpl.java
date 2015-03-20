package net.depoker.createjs.easeljs.client.filter.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class BoxBlurFilterImpl extends JavaScriptObject
{
	protected BoxBlurFilterImpl() { }

	public static native BoxBlurFilterImpl create(float blurX, float blurY, float quality) /*-{
		return new $wnd.createjs.BoxBlurFilter(blurX, blurY, quality);
	}-*/;

	public final native boolean applyFilter(JavaScriptObject ctx, float x, float y, float width, float height) /*-{
	    return this.applyFilter(ctx, x, y, width, height);
	}-*/;
}
