package net.depoker.createjs.soundjs.client.impl;

import net.depoker.createjs.soundjs.client.Callback;
import com.google.gwt.core.client.JavaScriptObject;

public class SoundInstanceImpl extends JavaScriptObject {

    protected SoundInstanceImpl() { }

    public final native HTMLAudioPluginImpl getOwner() /*-{
        return this.owner;
    }-*/;

    public final native String getPlayState() /*-{
        return this.playState;
    }-*/;

    public final native String getSrc() /*-{
        return this.src;
    }-*/;

    public final native String getUniqueId() /*-{
        return this.uniqueId;
    }-*/;

    public final native int getDuration() /*-{
        return this.getDuration();
    }-*/;

    public final native int getPan() /*-{
        return this.getPan();
    }-*/;

    public final native int getPosition() /*-{
        return this.getPosition();
    }-*/;

    public final native int getVolume() /*-{
        return this.getVolume();
    }-*/;

    public final native boolean mute(boolean isMuted) /*-{
        return this.mute(isMuted);
    }-*/;

    public final native boolean pause() /*-{
        return this.pause();
    }-*/;

    public final native void play(String interrupt, int delay, int offset, int loop, int volume, int pan) /*-{
        this.play(interrupt, delay, offset, loop, volume, pan);
    }-*/;

    public final native boolean resume() /*-{
        return this.resume();
    }-*/;

    public final native int setPan(int value) /*-{
        return this.setPan(value);
    }-*/;

    public final native void setPosition(int value) /*-{
        return this.setPosition(value);
    }-*/;

    public final native boolean setVolume(int value) /*-{
        return this.setVolume(value);
    }-*/;

    public final native boolean stop() /*-{
        return this.stop();
    }-*/;

    public final native void setOnCompleteCallback(Callback callback) /*-{
        this.onComplete = function() {
            callback.@net.depoker.createjs.soundjs.client.Callback::run();
        }
    }-*/;

    public final native void setOnLoopCallback(Callback callback) /*-{
        this.onLoop = function() {
            callback.@net.depoker.createjs.soundjs.client.Callback::run();
        }
    }-*/;

    public final native void setOnReadyCallback(Callback callback) /*-{
        this.onReady = function() {
            callback.@net.depoker.createjs.soundjs.client.Callback::run();
        }
    }-*/;

    public final native void setOnPlayFailedCallback(Callback callback) /*-{
        this.onPlayFailed = function() {
            callback.@net.depoker.createjs.soundjs.client.Callback::run();
        }
    }-*/;

    public final native void setOnPlayInterruptedCallback(Callback callback) /*-{
        this.onPlayInterrupted = function() {
            callback.@net.depoker.createjs.soundjs.client.Callback::run();
        }
    }-*/;

}
