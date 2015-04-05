package net.depoker.createjs.common.client.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class TickerImpl extends JavaScriptObject {
	protected TickerImpl() { } // for GWT sake

	public static native TickerImpl get() /*-{
			return $wnd.createjs.Ticker;
  }-*/;

	//
	// Methods
	//

	public static native JavaScriptObject addEventListener(String eventName, JavaScriptObject listener) /*-{
	  return $wnd.createjs.Ticker.addEventListener(eventName, listener);
  }-*/;

	public static native JavaScriptObject addEventListener(String eventName, JavaScriptObject listener, boolean useCapture) /*-{
	  return $wnd.createjs.Ticker.addEventListener(eventName, listener, useCapture);
  }-*/;

	public static native boolean dispatchEvent(String type) /*-{
	  $wnd.createjs.Ticker.dispatchEvent(type);
  }-*/;

	public static native boolean dispatchEvent(JavaScriptObject event) /*-{
	  $wnd.createjs.Ticker.dispatchEvent(event);
  }-*/;

	public static native int getEventTime(boolean runTime) /*-{
		return $wnd.createjs.Ticker.getEventTime(runTime);
  }-*/;

	@Deprecated
	public static native int getFPS() /*-{
	  return $wnd.createjs.Ticker.getFPS();
  }-*/;

	@Deprecated
	public static native int getInterval() /*-{
	  return $wnd.createjs.Ticker.getInterval();
  }-*/;

	public static native int getMeasuredFPS() /*-{
	  return $wnd.createjs.Ticker.getMeasuredFPS();
  }-*/;

	public static native int getMeasuredFPS(int ticks) /*-{
	  return $wnd.createjs.Ticker.getMeasuredFPS(ticks);
  }-*/;

	public static native int getMeasuredTickTime() /*-{
	  return $wnd.createjs.Ticker.getMeasuredTickTime();
  }-*/;

	public static native int getMeasuredTickTime(int ticks) /*-{
	  return $wnd.createjs.Ticker.getMeasuredTickTime(ticks);
  }-*/;

	@Deprecated
	public static native boolean getPaused() /*-{
	  return $wnd.createjs.Ticker.getPaused();
  }-*/;

	public static native int getTicks() /*-{
	  return $wnd.createjs.Ticker.getTicks();
  }-*/;

	public static native int getTicks(boolean pauseable) /*-{
	  return $wnd.createjs.Ticker.getTicks(pauseable);
  }-*/;

	public static native int getTime() /*-{
	  return $wnd.createjs.Ticker.getTime();
  }-*/;

	public static native int getTime(boolean runTime) /*-{
	  return $wnd.createjs.Ticker.getTime(runTime);
  }-*/;

	public static native boolean hasEventListener(String type) /*-{
	  return $wnd.createjs.Ticker.hasEventListener(type);
  }-*/;

	public static native void init() /*-{
	  return $wnd.createjs.Ticker.init();
  }-*/;

	public static native void off(String type, JavaScriptObject listener) /*-{
	  $wnd.createjs.Ticker.off(type, listener);
  }-*/;

	public static native void off(String type, JavaScriptObject listener, boolean useCapture) /*-{
	  $wnd.createjs.Ticker.off(type, listener, useCapture);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener) /*-{
	  return $wnd.createjs.Ticker.on(type, listener);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope) /*-{
	  return $wnd.createjs.Ticker.on(type, listener, scope);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once) /*-{
	  return $wnd.createjs.Ticker.on(type, listener, scope, once);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once, JavaScriptObject data) /*-{
	  return $wnd.createjs.Ticker.on(type, listener, scope, once, data);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once, JavaScriptObject data, boolean useCapture) /*-{
	  return $wnd.createjs.Ticker.on(type, listener, scope, once, data, useCapture);
  }-*/;

	public static native void removeAllEventListeners() /*-{
	  $wnd.createjs.Ticker.removeAllEventListeners();
  }-*/;

	public static native void removeAllEventListeners(String type) /*-{
	  $wnd.createjs.Ticker.removeAllEventListeners(type);
  }-*/;

	public static native void removeEventListener(String type, JavaScriptObject listener) /*-{
	  $wnd.createjs.Ticker.removeEventListener(type, listener);
  }-*/;

	public static native void removeEventListener(String type, JavaScriptObject listener, boolean useCapture) /*-{
	  $wnd.createjs.Ticker.removeEventListener(type, listener, useCapture);
  }-*/;

	public static native void reset() /*-{
	  $wnd.createjs.Ticker.reset();
  }-*/;

	@Deprecated
	public static native void setFPS(int fps) /*-{
	  return $wnd.createjs.Ticker.setFPS(fps);
  }-*/;

	@Deprecated
	public static native void setInterval(int interval) /*-{
	  return $wnd.createjs.Ticker.setInterval(interval);
  }-*/;

	@Deprecated
	public static native void setPaused(boolean paused) /*-{
	  return $wnd.createjs.Ticker.setPaused(paused);
  }-*/;

	public static native boolean willTrigger(String type) /*-{
	  return $wnd.createjs.Ticker.willTrigger(type);
  }-*/;

	//
	// Properties
	//

	public static native int framerate() /*-{
	  return $wnd.createjs.Ticker.framerate;
  }-*/;

	public static native void framerate(int value) /*-{
		$wnd.createjs.Ticker.framerate = value;
  }-*/;

	public static native int interval() /*-{
	  return $wnd.createjs.Ticker.interval;
  }-*/;

	public static native void interval(int value) /*-{
	  $wnd.createjs.Ticker.interval = value;
  }-*/;

	public static native int maxDelta() /*-{
	  return $wnd.createjs.Ticker.maxDelta;
  }-*/;

	public static native void maxDelta(int value) /*-{
	  $wnd.createjs.Ticker.maxDelta = value;
  }-*/;

	public static native boolean paused() /*-{
	  return $wnd.createjs.Ticker.paused;
  }-*/;

	public static native void paused(boolean value) /*-{
	  $wnd.createjs.Ticker.paused = value;
  }-*/;

	public static native String raf() /*-{
	  return $wnd.createjs.Ticker.RAF;
  }-*/;

	public static native String rafSynched() /*-{
	  return $wnd.createjs.Ticker.RAF_SYNCHED;
  }-*/;

	public static native String timeout() /*-{
	  return $wnd.createjs.Ticker.TIMEOUT;
  }-*/;

	public static native String timingMode() /*-{
	  return $wnd.createjs.Ticker.timingMode;
  }-*/;

	public static native void timingMode(String value) /*-{
	  $wnd.createjs.Ticker.timingMode = value;
  }-*/;

	@Deprecated
	public static native boolean useRaf() /*-{
		return $wnd.createjs.Ticker.useRAF;
	}-*/;
}
