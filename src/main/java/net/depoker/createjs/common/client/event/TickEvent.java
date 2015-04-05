/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.common.client.event;

import net.depoker.createjs.common.client.Event;
import net.depoker.createjs.common.client.impl.TickEventImpl;

public class TickEvent extends Event {
	private final TickEventImpl impl;

	public TickEvent(Event event) {
		super(event.getImpl());
		impl = getImpl().cast();
	}

	public boolean isPaused() {
		return impl.paused();
	}

	public int getDelta() {
		return impl.delta();
	}

	public int getTime() {
		return impl.time();
	}

	public int getRunTime() {
		return impl.runTime();
	}
}
