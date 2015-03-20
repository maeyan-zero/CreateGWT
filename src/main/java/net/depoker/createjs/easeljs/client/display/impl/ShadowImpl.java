package net.depoker.createjs.easeljs.client.display.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class ShadowImpl extends JavaScriptObject {

	protected ShadowImpl() {}
	
	public static native ShadowImpl create() /*-{
		return new $wnd.createjs.Shadow("#000000", 0, 0, 0);
	}-*/;
	
	public static native ShadowImpl create(String color, double offsetX, double offsetY, double blur) /*-{
		return new $wnd.createjs.Shadow(color, offsetX, offsetY, blur);
	}-*/;
	
	public static native ShadowImpl getIdentity() /*-{
		return $wnd.createjs.Shadow.identity;
	}-*/;
	
	public final native ShadowImpl clone() /*-{
		return this.clone();
	}-*/;
	
	public final native String getColor() /*-{
		return this.color;
	}-*/;

	public final native void setColor(String color) /*-{
		this.color = color;
	}-*/;
	
	public final native double getOffsetX() /*-{
		return this.offsetX;
	}-*/;

	public final native void setOffsetX(double offsetX) /*-{
		this.offsetX = offsetX;
	}-*/;
	
	public final native double getOffsetY() /*-{
		return this.offsetY;
	}-*/;

	public final native void setOffsetY(double offsetY) /*-{
		this.offsetY = offsetY;
	}-*/;
	
	public final native double getBlur() /*-{
		return this.blur;
	}-*/;

	public final native void setBlur(double blur) /*-{
		this.blur = blur;
	}-*/;

}
