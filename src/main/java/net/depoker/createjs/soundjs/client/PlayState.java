/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client;

import org.jetbrains.annotations.NotNull;

public enum PlayState {
	FAILED("playFailed"),
	FINISHED("playFinished"),
	INITED("playInited"),
	INTERRUPTED("playInterrupted"),
	SUCCEEDED("playSucceeded");

	private final String string;

	PlayState(String string) {
		this.string = string;
	}

	@Override public String toString(){
		return string;
	}

	public static @NotNull PlayState fromJavascript(@NotNull String string) {
		for (PlayState playState : values()) {
			if (playState.string.equals( string )) {
				return playState;
			}
		}
		throw new IllegalArgumentException( string + " is not a PlayState." );
	}
}
