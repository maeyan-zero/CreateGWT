/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.common.client.impl;

public class TickEventImpl extends EventImpl {
	protected TickEventImpl() {
	}

	public final native boolean paused() /*-{
	  return this.paused;
  }-*/;

	public final native int delta() /*-{
	  return this.delta;
  }-*/;

	public final native int time() /*-{
	  return this.time;
  }-*/;

	public final native int runTime() /*-{
	  return this.runTime;
  }-*/;
}
