/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.easeljs.client.helper.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class FrameDataImpl extends JavaScriptObject {
	protected FrameDataImpl() {
	}

	public final native double getWidth() /*-{
	  return this.width;
  }-*/;

	public final native double getHeight() /*-{
	  return this.height;
  }-*/;

	public final native int getCount() /*-{
	  return this.count;
  }-*/;

	public final native double getRegX() /*-{
	  return this.regX;
  }-*/;

	public final native double getRegY() /*-{
	  return this.regY;
  }-*/;

	public final native void setWidth(double width) /*-{
	  this.width = width;
  }-*/;

	public final native void setHeight(double height) /*-{
	  this.height = height;
  }-*/;

	public final native void setCount(int count) /*-{
	  this.count = count;
  }-*/;

	public final native void setRegX(double regX) /*-{
	  this.regX = regX;
  }-*/;

	public final native void setRegY(double regY) /*-{
	  this.regY = regY;
  }-*/;
}
