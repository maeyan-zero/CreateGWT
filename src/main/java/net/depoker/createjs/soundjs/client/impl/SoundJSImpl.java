package net.depoker.createjs.soundjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class SoundJSImpl extends JavaScriptObject {

    protected SoundJSImpl() {}

    public static native HTMLAudioPluginImpl getActivePlugin() /*-{
        return $wnd.createjs.SoundJS.activePlugin;
    }-*/;

    public static native void setActivePlugin(JavaScriptObject activePlugin) /*-{
	    $wnd.createjs.SoundJS.activePlugin = activePlugin;
    }-*/;

    public static native int getAudioTimeout() /*-{
        return $wnd.createjs.SoundJS.AUDIO_TIMEOUT;
    }-*/;

    public static native void setAudioTimeout(int value) /*-{
	    $wnd.createjs.SoundJS.AUDIO_TIMEOUT = value;
    }-*/;

    public static native String getDelimiter() /*-{
        return $wnd.createjs.SoundJS.DELIMITER;
    }-*/;

    public static native void setDelimiter(String value) /*-{
	    $wnd.createjs.SoundJS.DELIMITER = value;
    }-*/;

    public static native String getInterruptAny() /*-{
        return $wnd.createjs.SoundJS.INTERRUPT_ANY;
    }-*/;

    public static native String getInterruptEarly() /*-{
        return $wnd.createjs.SoundJS.INTERRUPT_EARLY;
    }-*/;

    public static native String getInterruptLate() /*-{
        return $wnd.createjs.SoundJS.INTERRUPT_LATE;
    }-*/;

    public static native String getInterruptNone() /*-{
        return $wnd.createjs.SoundJS.INTERRUPT_NONE;
    }-*/;

    public static native String getPlayFailed() /*-{
        return $wnd.createjs.SoundJS.PLAY_FAILED;
    }-*/;

    public static native String getPlayFinished() /*-{
        return $wnd.createjs.SoundJS.PLAY_FINISHED;
    }-*/;

    public static native String getPlayInited() /*-{
        return $wnd.createjs.SoundJS.PLAY_INITED;
    }-*/;

    public static native String getPlayInterrupted() /*-{
        return $wnd.createjs.SoundJS.PLAY_INTERUPTED;
    }-*/;

    public static native String getPlaySucceeded() /*-{
        return $wnd.createjs.SoundJS.PLAY_SUCCEEDED;
    }-*/;

    public static native SoundInstanceImpl play(String src, String interrupt, int delay, int offset, int loop, int volume, int pan) /*-{
        return $wnd.createjs.SoundJS.play(src, interrupt, delay, offset, loop, volume, pan);
    }-*/;

    public static native boolean setVolume(int value, String id) /*-{
        return $wnd.createjs.SoundJS.setVolume(value, id);
    }-*/;

    public static native int getMasterVolume() /*-{
        return $wnd.createjs.SoundJS.getMasterVolume();
    }-*/;

    public static native boolean setMuted(boolean isMuted, String id) /*-{
        return $wnd.createjs.SoundJS.setMute(isMuted, id);
    }-*/;

	public static native boolean isMuted() /*-{
		return $wnd.createjs.SoundJS.muted;
	}-*/;

    public static native boolean pause(String id) /*-{
        return $wnd.createjs.SoundJS.pause(id);
    }-*/;

    public static native boolean resume(String id) /*-{
        return $wnd.createjs.SoundJS.resume(id);
    }-*/;

    public static native boolean stop(String id) /*-{
        return $wnd.createjs.SoundJS.stop(id);
    }-*/;

    public static native SoundInstanceImpl getInstanceById(String id) /*-{
        return $wnd.createjs.SoundJS.getInstanceById(id);
    }-*/;

    public static native boolean isReady() /*-{
        return $wnd.createjs.SoundJS.isReady();
    }-*/;

	public static native void installFlashPlugin() /*-{
	    $wnd.createjs.SoundJS.registerPlugins([$wnd.createjs.HTMLAudioPlugin, $wnd.createjs.FlashPlugin]);
	}-*/;

    // TODO missing methods: registerPlugins, registerPlugin, getCapabilities, getCapability

}
