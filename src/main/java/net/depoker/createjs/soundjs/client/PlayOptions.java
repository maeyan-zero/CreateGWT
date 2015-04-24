/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.soundjs.client.impl.PlayOptionsImpl;

public class PlayOptions {
	final PlayOptionsImpl impl;

	public PlayOptions(JavaScriptObject impl) {
		this.impl = impl.cast();
	}

	public void setInterrupt(String value) {
		impl.setInterrupt( value );
	}

	public void setDelay(int value) {
		impl.setDelay( value );
	}

	public void setOffset(int value) {
		impl.setOffset( value );
	}

	public void setLoop(int value) {
		impl.setLoop( value );
	}

	public void setVolume(double value) {
		impl.setVolume( value );
	}

	public void setPan(double value) {
		impl.setVolume( value );
	}
}
