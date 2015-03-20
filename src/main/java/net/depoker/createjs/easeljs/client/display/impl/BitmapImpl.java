package net.depoker.createjs.easeljs.client.display.impl;

import net.depoker.createjs.easeljs.client.geom.impl.RectangleImpl;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class BitmapImpl extends DisplayObjectImpl {

	protected BitmapImpl() {}
	
	public static native BitmapImpl create() /*-{
		return new $wnd.createjs.Bitmap();
	}-*/;
	
	public static native BitmapImpl create(JavaScriptObject element) /*-{
		return new $wnd.createjs.Bitmap(element);
	}-*/;

	public static native BitmapImpl create(String uri) /*-{
		return new $wnd.createjs.Bitmap(uri);
	}-*/;

	public final native Element getImage() /*-{
		return this.image;
	}-*/;

	public final native void setSourceRect(RectangleImpl rectangle) /*-{
	    this.sourceRect = rectangle;
	}-*/;

	public final native RectangleImpl getSourceRect() /*-{
	    return this.sourceRect;
	}-*/;
}
