/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.preloadjs.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.Event;

public class FileStartEvent extends Event {
	private final FileStartEventImpl impl;

  public FileStartEvent(Event event) {
    super(event.getImpl());
	  this.impl = getImpl().cast();
  }

	public JavaScriptObject getItem() {
		return impl.item();
	}
}
