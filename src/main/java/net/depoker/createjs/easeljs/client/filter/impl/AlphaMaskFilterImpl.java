package net.depoker.createjs.easeljs.client.filter.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class AlphaMaskFilterImpl extends JavaScriptObject
{
	protected AlphaMaskFilterImpl() { }

	public static native AlphaMaskFilterImpl create(JavaScriptObject mask) /*-{
		return new $wnd.createjs.AlphaMaskFilter(mask);
	}-*/;

	public final native boolean applyFilter(JavaScriptObject ctx, float x, float y, float width, float height) /*-{
		return this.applyFilter(ctx, x, y, width, height);
	}-*/;
}
