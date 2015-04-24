/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class PlayOptionsImpl extends JavaScriptObject {
	protected PlayOptionsImpl() {
	}

	public final native void setInterrupt(String value) /*-{
		this.interrupt = value;
  }-*/;

	public final native void setDelay(int value) /*-{
		this.delay = value;
  }-*/;

	public final native void setOffset(int value) /*-{
		this.offset = value;
	}-*/;

	public final native void setLoop(int value) /*-{
		this.loop = value;
	}-*/;

	public final native void setVolume(double value) /*-{
		this.volume = value;
	}-*/;

	public final native void setPan(double value) /*-{
		this.pan = value;
	}-*/;
}
