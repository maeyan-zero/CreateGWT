/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;
import net.depoker.createjs.preloadjs.client.LoadItem;

public class FileStartEvent extends Event {
	private final FileStartEventImpl impl;

  public FileStartEvent(Event event) {
    super(event.getImpl());
	  this.impl = getImpl().cast();
  }

	public LoadItem getItem() {
		return new LoadItem( impl.item() );
	}
}
