package net.depoker.createjs.easeljs.client.filter.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class ColorFilterImpl extends JavaScriptObject
{
    protected ColorFilterImpl() { }

    public static native ColorFilterImpl create(double redMultiplier, double greenMultiplier, double blueMultiplier, double alphaMultiplier,
                                                double redOffset, double greenOffset, double blueOffset, double alphaOffset) /*-{
        return new $wnd.createjs.ColorFilter(redMultiplier, greenMultiplier, blueMultiplier, alphaMultiplier, redOffset, greenOffset, blueOffset, alphaOffset);
    }-*/;

	public static native ColorFilterImpl create(double redMultiplier, double greenMultiplier, double blueMultiplier) /*-{
		return new $wnd.createjs.ColorFilter(redMultiplier, greenMultiplier, blueMultiplier);
	}-*/;

	public final native void setRedMultiplier(double value) /*-{
	    this.redMultiplier = value;
	}-*/;

	public final native void setBlueMultiplier(double value) /*-{
		this.blueMultiplier = value;
	}-*/;

	public final native void setGreenMultiplier(double value) /*-{
		this.greenMultiplier = value;
	}-*/;

}
