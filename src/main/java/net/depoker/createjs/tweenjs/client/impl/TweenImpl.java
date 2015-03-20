package net.depoker.createjs.tweenjs.client.impl;

import net.depoker.createjs.tweenjs.client.callbacks.TweenCallback;
import com.google.gwt.core.client.JavaScriptObject;

public class TweenImpl extends JavaScriptObject {

    protected TweenImpl() {}

    //
    // Static properties:
    //

    public static native int getLoopConst() /*-{
        return $wnd.createjs.Tween.LOOP;
    }-*/;

    public static native int getNoneConst() /*-{
        return $wnd.createjs.Tween.NONE;
    }-*/;

    public static native int getReverseConst() /*-{
        return $wnd.createjs.Tween.REVERSE;
    }-*/;

    public static native JavaScriptObject getIgnoreConst() /*-{
        return $wnd.createjs.Tween.IGNORE;
    }-*/;

    //
    // Static methods:
    //

    public static native TweenImpl get(JavaScriptObject target) /*-{
        return $wnd.createjs.Tween.get(target);
    }-*/;

    public static native TweenImpl get(JavaScriptObject target, JavaScriptObject props) /*-{
        return $wnd.createjs.Tween.get(target, props);
    }-*/;

    public static native void removeTweens(TweenImpl target) /*-{
        $wnd.createjs.Tween.removeTweens(target);
    }-*/;

    public static native void tick(int delta, boolean paused) /*-{
        $wnd.createjs.Tween.tick(delta, paused);
    }-*/;

    public static native void installPlugin(JavaScriptObject plugin, JavaScriptObject properties) /*-{
        $wnd.createjs.Tween.installPlugin(plugin, properties);
    }-*/;

    //
    // Object properties:
    //

    public final native boolean getIgnoreGlobalPause() /*-{
        return this.ignoreGlobalPause;
    }-*/;

    public final native JavaScriptObject getPluginData() /*-{
        return this.pluginData;
    }-*/;

    public final native int getDuration() /*-{
        return this.duration;
    }-*/;

    public final native boolean getLoop() /*-{
        return this.loop;
    }-*/;

    //
    // Object methods:
    //

    public final native TweenImpl call(TweenCallback callback) /*-{
	    var func = function() {
		    $entry(callback.@net.depoker.createjs.tweenjs.client.callbacks.TweenCallback::run(Lnet/depoker/createjs/tweenjs/client/impl/TweenImpl;)(this));
	    }
	    return this.call(func);
    }-*/;

    public final native TweenImpl call(TweenCallback callback, JavaScriptObject params) /*-{
        return this.call($entry(callback.@net.depoker.createjs.tweenjs.client.callbacks.TweenCallback::run(Lnet/depoker/createjs/tweenjs/client/impl/TweenImpl;)(this)), params);
    }-*/;

    public final native TweenImpl call(TweenCallback callback, JavaScriptObject params, JavaScriptObject scope) /*-{
        return this.call($entry(callback.@net.depoker.createjs.tweenjs.client.callbacks.TweenCallback::run(Lnet/depoker/createjs/tweenjs/client/impl/TweenImpl;)(this)), params, scope);
    }-*/;

    public final native TweenImpl pause(TweenImpl tween) /*-{
        return this.pause(tween);
    }-*/;

    public final native TweenImpl play(TweenImpl tween) /*-{
        return this.play(tween);
    }-*/;

    public final native TweenImpl set(JavaScriptObject props) /*-{
        return this.set(props);
    }-*/;

    public final native TweenImpl set(JavaScriptObject props, JavaScriptObject target) /*-{
        return this.set(props, target);
    }-*/;

    public final native void setPaused(boolean value) /*-{
        return this.setPaused(value);
    }-*/;

    public final native TweenImpl setPosition(int value, int actionsMode) /*-{
        return this.setPosition(value, actionsMode);
    }-*/;

    public final native TweenImpl to(JavaScriptObject props, int duration) /*-{
        return this.to(props, duration);
    }-*/;

//    public final native TweenImpl to(JavaScriptObject props, int duration, int ease) /*-{
//        return this.@net.depoker.createjs.tweenjs.client.impl.TweenImpl::to(Lcom/google/gwt/core/client/JavaScriptObject;IIFF)(props, duration, ease, 0, 0);
//    }-*/;
//
//    public final native TweenImpl to(JavaScriptObject props, int duration, int ease, float param1) /*-{
//        return this.@net.depoker.createjs.tweenjs.client.impl.TweenImpl::to(Lcom/google/gwt/core/client/JavaScriptObject;IIFF)(props, duration, ease, param1, 0);
//    }-*/;

    public final native TweenImpl to(JavaScriptObject props, int duration, int ease, float param1, float param2) /*-{
        switch(ease) {
            case 0:
                return this.to(props, duration, $wnd.createjs.Ease.backIn);
            case 1:
                return this.to(props, duration, $wnd.createjs.Ease.backInOut);
            case 2:
                return this.to(props, duration, $wnd.createjs.Ease.backOut);
            case 3:
                return this.to(props, duration, $wnd.createjs.Ease.bounceIn);
            case 4:
                return this.to(props, duration, $wnd.createjs.Ease.bounceInOut);
            case 5:
                return this.to(props, duration, $wnd.createjs.Ease.bounceOut);
            case 6:
                return this.to(props, duration, $wnd.createjs.Ease.circIn);
            case 7:
                return this.to(props, duration, $wnd.createjs.Ease.circInOut);
            case 8:
                return this.to(props, duration, $wnd.createjs.Ease.circOut);
            case 9:
                return this.to(props, duration, $wnd.createjs.Ease.cubicIn);
            case 10:
                return this.to(props, duration, $wnd.createjs.Ease.cubicInOut);
            case 11:
                return this.to(props, duration, $wnd.createjs.Ease.cubicOut);
            case 12:
                return this.to(props, duration, $wnd.createjs.Ease.elasticIn);
            case 13:
                return this.to(props, duration, $wnd.createjs.Ease.elasticInOut);
            case 14:
                return this.to(props, duration, $wnd.createjs.Ease.elasticOut);
            case 15:
                return this.to(props, duration, $wnd.createjs.Ease.get(param1));
            case 16:
                return this.to(props, duration, $wnd.createjs.Ease.getBackIn(param1));
            case 17:
                return this.to(props, duration, $wnd.createjs.Ease.getBackInOut(param1));
            case 18:
                return this.to(props, duration, $wnd.createjs.Ease.getBackOut(param1));
            case 19:
                return this.to(props, duration, $wnd.createjs.Ease.getElasticIn(param1, param2));
            case 20:
                return this.to(props, duration, $wnd.createjs.Ease.getElasticInOut(param1, param2));
            case 21:
                return this.to(props, duration, $wnd.createjs.Ease.getElasticOut(param1, param2));
            case 22:
                return this.to(props, duration, $wnd.createjs.Ease.getPowIn(param1));
            case 23:
                return this.to(props, duration, $wnd.createjs.Ease.getPowInOut(param1));
            case 24:
                return this.to(props, duration, $wnd.createjs.Ease.getPowOut(param1));
            case 25:
                return this.to(props, duration, $wnd.createjs.Ease.Linear);
            case 26:
                return this.to(props, duration, $wnd.createjs.Ease.None);
            case 27:
                return this.to(props, duration, $wnd.createjs.Ease.QuadIn);
            case 28:
                return this.to(props, duration, $wnd.createjs.Ease.QuadInOut);
            case 29:
                return this.to(props, duration, $wnd.createjs.Ease.QuadOut);
            case 30:
                return this.to(props, duration, $wnd.createjs.Ease.QuartIn);
            case 31:
                return this.to(props, duration, $wnd.createjs.Ease.QuartInOut);
            case 32:
                return this.to(props, duration, $wnd.createjs.Ease.QuartOut);
            case 33:
                return this.to(props, duration, $wnd.createjs.Ease.QuintIn);
            case 34:
                return this.to(props, duration, $wnd.createjs.Ease.QuintInOut);
            case 35:
                return this.to(props, duration, $wnd.createjs.Ease.QuintOut);
            case 36:
                return this.to(props, duration, $wnd.createjs.Ease.SineIn);
            case 37:
                return this.to(props, duration, $wnd.createjs.Ease.SineInOut);
            case 38:
                return this.to(props, duration, $wnd.createjs.Ease.SineOut);
            default:
                return null;
        }
    }-*/;

    public final native TweenImpl wait(int duration) /*-{
        return this.wait(duration);
    }-*/;

}
