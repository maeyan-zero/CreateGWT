package net.depoker.createjs.easeljs.client.util.impl;

import net.depoker.createjs.easeljs.client.helper.Handler;
import net.depoker.createjs.easeljs.client.helper.HasTick;
import com.google.gwt.core.client.JavaScriptObject;

public class TickerImpl extends JavaScriptObject {

	protected TickerImpl() { } // for GWT sake
	
	public static native boolean useRAF() /*-{
		return $wnd.createjs.Ticker.useRAF();
	}-*/;
	
	public static native void addListener(JavaScriptObject listener, boolean pauseable) /*-{
		$wnd.createjs.Ticker.addListener(listener, pauseable);
	}-*/;
	
	public static native float getFPS() /*-{
		return $wnd.createjs.Ticker.getFPS();
	}-*/;
	
	public static native int getInterval() /*-{
		return $wnd.createjs.Ticker.getInterval();
	}-*/;

	public static native float getMeasuredFPS() /*-{
		return $wnd.createjs.Ticker.getMeasuredFPS();
	}-*/;

	public static native float getMeasuredFPS(int ticks) /*-{
		return $wnd.createjs.Ticker.getMeasuredFPS(ticks);
	}-*/;
	
	public static native boolean getPaused() /*-{
		return $wnd.createjs.Ticker.getPaused();
	}-*/;
	
	public static native int getTicks(boolean pauseable) /*-{
		return $wnd.createjs.Ticker.getTicks(pauseable);
	}-*/;
	
	public static native int getTime(boolean pauseable) /*-{
		return $wnd.createjs.Ticker.getPaused(pauseable);
	}-*/;
	
	public static native void init() /*-{
		return $wnd.createjs.Ticker.init();
	}-*/;
	
	public static native void removeAllListeners() /*-{
		return $wnd.createjs.Ticker.removeAllListeners();
	}-*/;
	
	public static native void removeListener(HasTick listener) /*-{
		return $wnd.createjs.Ticker.removeListener(listener);
	}-*/;
	
	public static native void setFPS(int fps) /*-{
		return $wnd.createjs.Ticker.setFPS(fps);
	}-*/;
	
	public static native void setInterval(int interval) /*-{
		return $wnd.createjs.Ticker.setInterval(interval);
	}-*/;
	
	public static native void setPaused(boolean paused) /*-{
		return $wnd.createjs.Ticker.setPaused(paused);
	}-*/;
	
	public static native void setTick(HasTick ticker) /*-{
		$wnd.createjs.Ticker.tick = function(timeElapsed) {
			ticker.@net.depoker.createjs.easeljs.client.helper.HasTick::tick(I)(timeElapsed);
		}
	}-*/;

	public static native void setTimingMode(String mode) /*-{
		$wnd.createjs.Ticker.timingMode = mode;
	}-*/;

	public static native void addEventListener(String eventName, Handler handler) /*-{
		$wnd.createjs.Ticker.addEventListener(eventName, function(params) {
			handler.@net.depoker.createjs.easeljs.client.helper.Handler::handle(Lcom/google/gwt/core/client/JavaScriptObject;)(params);
		});
	}-*/;
}
