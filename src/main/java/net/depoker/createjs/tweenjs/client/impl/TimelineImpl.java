package net.depoker.createjs.tweenjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;

import java.util.List;
import java.util.Map;

public class TimelineImpl extends JavaScriptObject {

    protected TimelineImpl() { }

    public static native TimelineImpl create(List<TweenImpl> tweens, Map<String, Integer> labels, JavaScriptObject props) /*-{
        return new $wnd.createjs.Timeline(tweens, labels, props);
    }-*/;

    public final native int getDuration() /*-{
        return this.duration;
    }-*/;

    public final native boolean getIgnoreGlobalPause() /*-{
        return this.ignoreGlobalPause;
    }-*/;

    public final native boolean getLoop() /*-{
        return this.loop;
    }-*/;

    public final native void addLabel(String label, int position) /*-{
        this.addLabel(label, position);
    }-*/;

    public final native void addTween(TweenImpl ... tween) /*-{
        this.addTween(tween);
    }-*/;

    /**
     * @param positionOrLabel Only pass a string or a number.
     */
    public final native void gotoAndPlay(Object positionOrLabel) /*-{
        this.gotoAndPlay(positionOrLabel);
    }-*/;

    /**
     * @param positionOrLabel Only pass a string or a integer.
     */
    public final native void gotoAndStop(Object positionOrLabel) /*-{
        this.gotoAndStop(positionOrLabel);
    }-*/;

    public final native void removeTween(TweenImpl ... tween) /*-{
        this.removeTween(tween);
    }-*/;

    public final native void setPaused(boolean value) /*-{
        this.setPaused(value);
    }-*/;

    public final native void setPosition(int value, Integer actionsMode) /*-{
        this.setPosition(value, actionsMode);
    }-*/;

    public final native void tick(int delta) /*-{
        this.tick(delta);
    }-*/;

    public final native void updateDuration() /*-{
        this.updateDuration();
    }-*/;

}
