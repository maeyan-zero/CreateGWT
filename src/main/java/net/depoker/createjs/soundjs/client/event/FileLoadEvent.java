/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client.event;

import net.depoker.createjs.common.client.Event;
import org.jetbrains.annotations.NotNull;

public class FileLoadEvent extends Event {
	final FileLoadEventImpl impl;

	public FileLoadEvent(@NotNull Event event) {
		super( event.getImpl() );
		this.impl = event.getImpl().cast();
	}

	public String getId() {
		return impl.getId();
	}
}
