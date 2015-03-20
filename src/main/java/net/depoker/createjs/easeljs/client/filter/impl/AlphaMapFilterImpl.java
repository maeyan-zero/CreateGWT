package net.depoker.createjs.easeljs.client.filter.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class AlphaMapFilterImpl extends JavaScriptObject
{
	protected AlphaMapFilterImpl() { }

	public static native AlphaMapFilterImpl create(JavaScriptObject alphaMap) /*-{
		return new $wnd.createjs.AlphaMapFilter(alphaMap);
	}-*/;

	public final native boolean applyFilter(JavaScriptObject ctx, float x, float y, float width, float height) /*-{
		return this.applyFilter(ctx, x, y, width, height);
	}-*/;
}
