/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.common.client;

public enum EventType {
	TICK("tick");

	final private String string;

	EventType(String string) {
		this.string = string;
	}

	@Override
	public String toString() {
		return string;
	}
}
