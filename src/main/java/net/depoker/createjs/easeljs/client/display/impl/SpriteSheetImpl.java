package net.depoker.createjs.easeljs.client.display.impl;

import net.depoker.createjs.easeljs.client.display.SpriteSheet;
import net.depoker.createjs.easeljs.client.geom.impl.RectangleImpl;
import net.depoker.createjs.easeljs.client.helper.Handler;
import net.depoker.createjs.easeljs.client.helper.impl.FrameImpl;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;

public class SpriteSheetImpl extends JavaScriptObject {

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
    
    public final native void setCompleteHandler(SpriteSheet pojo) /*-{
    	this.onComplete = function() {
		    pojo.@net.depoker.createjs.easeljs.client.display.SpriteSheet::onComplete()();
    	}
    }-*/;

	public final native void addEventListener(String type, Handler handler) /*-{
		this.addEventListener(type, function(params) {
			$entry(handler.@net.depoker.createjs.easeljs.client.helper.Handler::handle(Lcom/google/gwt/core/client/JavaScriptObject;)(params));
		});
	}-*/;

	public final native void dispatchEvent(String type) /*-{
		this.dispatchEvent(type);
	}-*/;

	public final native void dispatchEvent(String type, JavaScriptObject target) /*-{
		this.dispatchEvent(type, target);
	}-*/;

	public final native boolean hasEventListener(String type) /*-{
		return this.hasEventListener(type);
	}-*/;

	public final native void removeAllEventListeners() /*-{
		this.removeAllEventListeners();
	}-*/;

	public final native void removeAllEventListeners(String type) /*-{
		this.removeAllEventListeners(type);
	}-*/;


}
