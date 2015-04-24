/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;

public class SoundImpl extends JavaScriptObject {
	protected SoundImpl() {
	}

	public static native JavaScriptObject addEventListener(String eventName, JavaScriptObject listener) /*-{
	  return $wnd.createjs.Sound.addEventListener(eventName, listener);
  }-*/;

	public static native JavaScriptObject addEventListener(String eventName, JavaScriptObject listener, boolean useCapture) /*-{
	  return $wnd.createjs.Sound.addEventListener(eventName, listener, useCapture);
  }-*/;

	public static native AbstractSoundInstanceImpl createInstance(String src) /*-{
	  return $wnd.createjs.Sound.createInstance( src );
  }-*/;

	public static native AbstractSoundInstanceImpl createInstance(String src, double startTime) /*-{
	  return $wnd.createjs.Sound.createInstance( src, startTime );
  }-*/;

	public static native AbstractSoundInstanceImpl createInstance(String src, double startTime, double duration) /*-{
	  return $wnd.createjs.Sound.createInstance( src, startTime, duration );
  }-*/;

	public static native boolean dispatchEvent(String type) /*-{
	  return $wnd.createjs.Sound.dispatchEvent(type);
  }-*/;

	public static native boolean dispatchEvent(JavaScriptObject event) /*-{
	  return $wnd.createjs.Sound.dispatchEvent(event);
  }-*/;

	public static native JavaScriptObject getCapabilities() /*-{
	  return $wnd.createjs.Sound.getCapabilities();
  }-*/;

	public static native boolean getCapability(String key) /*-{
	  return $wnd.createjs.Sound.getCapability( key );
  }-*/;

	public static native boolean getMute() /*-{
	  return $wnd.createjs.Sound.getMute();
  }-*/;

	public static native double getVolume() /*-{
	  return $wnd.createjs.Sound.getVolume();
  }-*/;

	public static native boolean hasEventListener(String type) /*-{
	  return $wnd.createjs.Sound.hasEventListener(type);
  }-*/;

	public static native boolean initializeDefaultPlugins() /*-{
	  return $wnd.createjs.Sound.initializeDefaultPlugins();
  }-*/;

	public static native boolean isReady() /*-{
	  return $wnd.createjs.Sound.isReady();
  }-*/;

	public static native boolean loadComplete(String src) /*-{
	  return $wnd.createjs.Sound.loadComplete( src );
  }-*/;

	public static native void off(String type, JavaScriptObject listener) /*-{
	  $wnd.createjs.Sound.off(type, listener);
  }-*/;

	public static native void off(String type, JavaScriptObject listener, boolean useCapture) /*-{
	  $wnd.createjs.Sound.off(type, listener, useCapture);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener) /*-{
	  return $wnd.createjs.Sound.on(type, listener);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope) /*-{
	  return $wnd.createjs.Sound.on(type, listener, scope);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once) /*-{
	  return $wnd.createjs.Sound.on(type, listener, scope, once);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once, JavaScriptObject data) /*-{
	  return $wnd.createjs.Sound.on(type, listener, scope, once, data);
  }-*/;

	public static native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once, JavaScriptObject data, boolean useCapture) /*-{
	  return $wnd.createjs.Sound.on(type, listener, scope, once, data, useCapture);
  }-*/;

	public static native AbstractSoundInstanceImpl play(String src) /*-{
	  return $wnd.createjs.Sound.play( src );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String src, JavaScriptObject options) /*-{
	  return $wnd.createjs.Sound.play( src, options );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String src, String interrupt) /*-{
	  return $wnd.createjs.Sound.play( src, interrupt );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String src, String interrupt, int delay) /*-{
	  return $wnd.createjs.Sound.play( src, interrupt, delay );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String src, String interrupt, int delay, int offset) /*-{
	  return $wnd.createjs.Sound.play( src, interrupt, delay, offset );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String src, String interrupt, int delay, int offset, int loop) /*-{
	  return $wnd.createjs.Sound.play( src, interrupt, delay, offset, loop );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String src, String interrupt, int delay, int offset, int loop, double volume) /*-{
	  return $wnd.createjs.Sound.play( src, interrupt, delay, offset, loop, volume );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String src, String interrupt, int delay, int offset, int loop, double volume, double pan) /*-{
	  return $wnd.createjs.Sound.play( src, interrupt, delay, offset, loop, volume, pan );
  }-*/;

	public static native JavaScriptObject registerManifest(JsArray<JavaScriptObject> sounds, String basePath) /*-{
	  return $wnd.createjs.Sound.registerManifest( sounds, basePath );
  }-*/;

	public static native boolean registerPlugins(JsArray<JavaScriptObject> plugins) /*-{
	  return $wnd.createjs.Sound.registerPlugins( plugins );
  }-*/;

	public static native JavaScriptObject registerSound(String src, String basePath) /*-{
	  return $wnd.createjs.Sound.registerSound( src, basePath );
  }-*/;

	public static native JavaScriptObject registerSound(String src, String id, String basePath) /*-{
	  return $wnd.createjs.Sound.registerSound( src, id, basePath );
  }-*/;

	public static native JavaScriptObject registerSound(String src, String id, JavaScriptObject data, String basePath) /*-{
	  return $wnd.createjs.Sound.registerSound( src, id, data, basePath );
  }-*/;

	public static native JavaScriptObject registerSounds(JsArray<JavaScriptObject> sounds, String basePath) /*-{
	  return $wnd.createjs.Sound.registerSounds( sounds, basePath );
  }-*/;

	public static native void removeAllEventListeners() /*-{
	  $wnd.createjs.Sound.removeAllEventListeners();
  }-*/;

	public static native void removeAllEventListeners(String type) /*-{
	  $wnd.createjs.Sound.removeAllEventListeners(type);
  }-*/;

	public static native void removeAllSounds() /*-{
	  $wnd.createjs.Sound.removeAllSounds();
  }-*/;

	public static native void removeEventListener(String type, JavaScriptObject listener) /*-{
	  $wnd.createjs.Sound.removeEventListener(type, listener);
  }-*/;

	public static native void removeEventListener(String type, JavaScriptObject listener, boolean useCapture) /*-{
	  $wnd.createjs.Sound.removeEventListener(type, listener, useCapture);
  }-*/;

	public static native boolean removeSound(String src, String basePath) /*-{
	  return $wnd.createjs.Sound.removeSound( src, basePath );
  }-*/;

	public static native boolean removeSound(JavaScriptObject src, String basePath) /*-{
	  return $wnd.createjs.Sound.removeSound( src, basePath );
  }-*/;

	public static native boolean removeSounds(JsArray<JavaScriptObject> sounds, String basePath) /*-{
	  return $wnd.createjs.Sound.removeSound( sounds, basePath );
  }-*/;

	public static native boolean setMute(boolean value) /*-{
	  return $wnd.createjs.Sound.setMute( value );
  }-*/;

	public static native void setVolume(double value) /*-{
	  $wnd.createjs.Sound.setVolume( value );
  }-*/;

	public static native void stop() /*-{
	  $wnd.createjs.Sound.stop();
  }-*/;

	public static native boolean willTrigger(String type) /*-{
	  return $wnd.createjs.Sound.willTrigger( type );
  }-*/;

	//
	// properties:
	//

	public static native JavaScriptObject activePlugin() /*-{
		return $wnd.createjs.Sound.activePlugin;
	}-*/;

	public static native JsArrayString supportedExtensions() /*-{
	  return $wnd.createjs.Sound.SUPPORTED_EXTENSIONS;
  }-*/;
}
