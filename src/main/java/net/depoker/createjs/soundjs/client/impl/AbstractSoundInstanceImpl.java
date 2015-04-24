/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.impl.EventDispatcherImpl;

public class AbstractSoundInstanceImpl extends EventDispatcherImpl {
	protected AbstractSoundInstanceImpl() {
	}

	//
	// methods:
	//

	public final native void destroy() /*-{
		this.destroy();
  }-*/;

	public final native int getDuration() /*-{
	  return this.getDuration();
  }-*/;

	public final native int getLoop() /*-{
		return this.getLoop();
  }-*/;

	public final native boolean getMute() /*-{
	  return this.getMute();
  }-*/;

	public final native double getPan() /*-{
	  return this.getPan();
  }-*/;

	public final native boolean getPaused() /*-{
	  return this.getPaused();
  }-*/;

	public final native int getPosition() /*-{
	  return this.getPosition();
  }-*/;

	public final native double getVolume() /*-{
	  return this.getVolume();
  }-*/;

	public static native AbstractSoundInstanceImpl play(JavaScriptObject options) /*-{
	  return this.play( options );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String interrupt) /*-{
	  return this.play( interrupt );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String interrupt, int delay) /*-{
	  return this.play( interrupt, delay );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String interrupt, int delay, int offset) /*-{
	  return this.play( interrupt, delay, offset );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String interrupt, int delay, int offset, int loop) /*-{
	  return this.play( interrupt, delay, offset, loop );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String interrupt, int delay, int offset, int loop, double volume) /*-{
	  return this.play( interrupt, delay, offset, loop, volume );
  }-*/;

	public static native AbstractSoundInstanceImpl play(String interrupt, int delay, int offset, int loop, double volume, double pan) /*-{
	  return this.play( interrupt, delay, offset, loop, volume, pan );
  }-*/;

	public final native AbstractSoundInstanceImpl setDuration(int value) /*-{
		return this.setDuration( value );
	}-*/;

	public final native void setLoop(int value) /*-{
	  this.setLoop( value );
  }-*/;

	public final native AbstractSoundInstanceImpl setMute(boolean value) /*-{
	  return this.setMute( value );
  }-*/;

	public final native AbstractSoundInstanceImpl setPan(double value) /*-{
	  return this.setPan( value );
  }-*/;

	public final native AbstractSoundInstanceImpl setPlayback(JavaScriptObject value) /*-{
	  return this.setPlayback( value );
  }-*/;

	public final native AbstractSoundInstanceImpl setPosition(int value) /*-{
	  return this.setPosition( value );
  }-*/;

	public final native AbstractSoundInstanceImpl setVolume(double value) /*-{
	  return this.setVolume( value );
  }-*/;

	public final native AbstractSoundInstanceImpl stop() /*-{
	  return this.stop();
  }-*/;

	//
	// properties:
	//

	public final native JavaScriptObject playbackResource() /*-{
	  return this.playbackResource ;
  }-*/;

	public final native String playState() /*-{
		return this.playState;
	}-*/;

	public final native String src() /*-{
		return this.src;
	}-*/;

	public final native int uniqueId() /*-{
		return this.uniqueId;
	}-*/;
}
