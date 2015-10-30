/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.impl.EventImpl;

public class FileErrorEventImpl extends EventImpl {
	protected FileErrorEventImpl() {
	}

	public final native String getId() /*-{
	  return this.id;
  }-*/;

	public final native String getTitle() /*-{
	  return this.title;
  }-*/;

	public final native String getMessage() /*-{
	  return this.message;
  }-*/;

	public final native JavaScriptObject getData() /*-{
	  return this.data;
  }-*/;
}
