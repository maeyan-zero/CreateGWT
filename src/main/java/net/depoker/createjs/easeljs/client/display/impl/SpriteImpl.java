package net.depoker.createjs.easeljs.client.display.impl;

import net.depoker.createjs.easeljs.client.geom.impl.RectangleImpl;
import net.depoker.createjs.easeljs.client.helper.AnimationCallback;

public class SpriteImpl extends DisplayObjectImpl {

	protected SpriteImpl() {}
	
	public static native SpriteImpl create(SpriteSheetImpl spriteSheet) /*-{
		return new $wnd.createjs.Sprite(spriteSheet);
    }-*/;

    //
    // Properties:
    //

    public final native String getCurrentAnimation() /*-{
        return this.currentAnimation;
    }-*/;

	public final native String getCurrentAnimationFrame() /*-{
		return this.currentAnimationFrame;
	}-*/;

    public final native int getCurrentFrame() /*-{
        return this.currentFrame;
    }-*/;

    public final native int getOffset() /*-{
        return this.offset;
    }-*/;

    public final native void setOffset(int value) /*-{
        this.offset = value;
    }-*/;

    public final native boolean getPaused() /*-{
        return this.paused;
    }-*/;

    public final native void setPaused(boolean paused) /*-{
        this.paused = paused;
    }-*/;

    public final native SpriteSheetImpl getSpriteSheet() /*-{
        return this.spriteSheet;
    }-*/;

	public final native void setFramerate(int framerate) /*-{
		this.framerate = framerate;
	}-*/;

    public final native void setAnimationEndCallback(AnimationCallback callback) /*-{
        this.onAnimationEnd = function(instance, name) {
            callback.@net.depoker.createjs.easeljs.client.helper.AnimationCallback::onAnimationEnd(Lnet/depoker/createjs/easeljs/client/display/impl/SpriteImpl;Ljava/lang/String;)(instance, name);
        }
    }-*/;

    //
    // Methods:
    //

    public final native void advance() /*-{
        this.advance();
    }-*/;

	public final native RectangleImpl getBounds() /*-{
		return this.getBounds();
	}-*/;

    public final native void gotoAndPlay(int frame) /*-{
		this.gotoAndPlay(frame);
	}-*/;
	
	public final native void gotoAndPlay(String frameOrSequence) /*-{
		this.gotoAndPlay(frameOrSequence);
	}-*/;
	
	public final native void gotoAndStop(int frame) /*-{
		this.gotoAndStop(frame);
	}-*/;
	
	public final native void gotoAndStop(String frameOrSequence) /*-{
		this.gotoAndStop(frameOrSequence);
	}-*/;

    public final native void play() /*-{
        this.play();
    }-*/;

    public final native void stop() /*-{
        this.stop();
    }-*/;

}
