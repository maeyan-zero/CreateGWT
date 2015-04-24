/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client.event;

import net.depoker.createjs.common.client.impl.EventImpl;

public class FileErrorEventImpl extends EventImpl {
	protected FileErrorEventImpl() {
	}

	public final native String getId() /*-{
	  return this.id;
  }-*/;
}
