package net.depoker.createjs.easeljs.client.display.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import net.depoker.createjs.common.client.impl.EventDispatcherImpl;
import net.depoker.createjs.easeljs.client.geom.impl.RectangleImpl;
import net.depoker.createjs.easeljs.client.helper.impl.FrameImpl;

public class SpriteSheetImpl extends EventDispatcherImpl {

    protected SpriteSheetImpl() { }
	
	public static native SpriteSheetImpl create(JavaScriptObject meta) /*-{
		return new $wnd.createjs.SpriteSheet(meta);
	}-*/;

    public final native boolean getComplete() /*-{
        return this.complete;
    }-*/;

    public final native SpriteSheetImpl clone() /*-{
        return this.clone();
    }-*/;

	public final native JavaScriptObject getAnimation(String animation) /*-{
		return this.getAnimation(animation);
	}-*/;

    public final native JsArrayString getAnimations() /*-{
        return this.getAnimations();
    }-*/;
	
    public final native FrameImpl getFrame(int frameIndex) /*-{
    	return this.getFrame(frameIndex);
    }-*/;

	public final native RectangleImpl getFrameBounds(int frameIndex) /*-{
		return this.getFrameBounds(frameIndex);
	}-*/;

    public final native int getNumFrames(String animation) /*-{
    	return this.getNumFrames(animation);
    }-*/;

}
