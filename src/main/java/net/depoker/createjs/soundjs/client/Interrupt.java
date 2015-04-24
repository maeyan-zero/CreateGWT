/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client;

public enum  Interrupt {
	ANY("any"),
	EARLY("early"),
	LATE("late"),
	NONE("none");

	private final String string;

	Interrupt(String string) {
		this.string = string;
	}

	@Override public String toString(){
		return string;
	}
}
