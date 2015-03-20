package net.depoker.createjs.easeljs.client.display.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.Element;

public class StageImpl extends ContainerImpl {

	protected StageImpl() {}
	
	public static native StageImpl create(Element canvas) /*-{
		return new $wnd.createjs.Stage(canvas);
	}-*/;

    //
    // Properties:
    //

    public final native boolean getAutoClear() /*-{
        return this.autoClear;
    }-*/;

    public final native void setAutoClear(boolean autoClear) /*-{
        this.autoClear = autoClear;
    }-*/;

    public final native Element getCanvas() /*-{
        return this.canvas;
    }-*/;

    public final native boolean getMouseInBounds() /*-{
        return this.mouseBounds;
    }-*/;

    public final native void setMouseInBounds(boolean mouseInBounds) /*-{
        this.mouseInBounds = mouseInBounds;
    }-*/;

    public final native int getMouseX() /*-{
        return this.x;
    }-*/;

    public final native int getMouseY() /*-{
        return this.y;
    }-*/;

    public final native int getSnapToPixelEnabled() /*-{
        return this.snapToPixelEnabled;
    }-*/;

    public final native void setSnapToPixelEnabled(boolean enabled) /*-{
        this.snapToPixelEnabled = enabled;
    }-*/;

    public final native boolean getTickOnUpdate () /*-{
        return this.tickOnUpdate;
    }-*/;

    public final native void setTickOnUpdate (boolean tickOnUpdate) /*-{
        this.tickOnUpdate = tickOnUpdate;
    }-*/;

    //
    // Methods:
    //

    public final native void clear() /*-{
		this.clear();
	}-*/;

    public final native void enableMouseOver(Integer frequency) /*-{
        this.enableMouseOver(frequency);
    }-*/;

    public final native String toDataUrl(String backgroundColor, String mimeType) /*-{
        return this.toDataURL(backgroundColor, mimeType);
    }-*/;

    public final native void update(JavaScriptObject params) /*-{
        this.update(params);
    }-*/;

    public final native void tick() /*-{
        this.tick();
    }-*/;

	public final native void setMozImageSmoothing(Element canvas, boolean enabled) /*-{
		canvas.getContext('2d').mozImageSmoothingEnabled = enabled;
	}-*/;

}
