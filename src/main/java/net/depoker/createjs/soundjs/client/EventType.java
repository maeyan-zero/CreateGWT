/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client;

public enum EventType {
	COMPLETE("complete"),
	FAILED("failed"),
	INTERRUPTED("interrupted"),
	LOOP("loop"),
	SUCCEEDED("succeeded");

	private final String string;

	EventType(String string) {
		this.string = string;
	}

	@Override public String toString() {
		return string;
	}
}
