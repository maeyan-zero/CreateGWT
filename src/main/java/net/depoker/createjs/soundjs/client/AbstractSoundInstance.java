/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.EventDispatcher;
import net.depoker.createjs.soundjs.client.impl.AbstractSoundInstanceImpl;

public class AbstractSoundInstance extends EventDispatcher {
	private final AbstractSoundInstanceImpl impl;

	public AbstractSoundInstance(JavaScriptObject impl) {
		super( impl );
		this.impl = impl.cast();
	}

	public void destroy() {
		impl.destroy();
	}

	public int getDuration() {
		return impl.getDuration();
	}

	public int getLoop() {
		return impl.getLoop();
	}

	public boolean getMute() {
		return impl.getMute();
	}

	public double getPan() {
		return impl.getPan();
	}

	public boolean getPaused() {
		return impl.getPaused();
	}

	public int getPosition() {
		return impl.getPosition();
	}

	public double getVolume() {
		return impl.getVolume();
	}

	public AbstractSoundInstance play(PlayOptions options) {
		impl.setPlayback(options.impl);
		return this;
	}

	public AbstractSoundInstance setDuration(int value) {
		impl.setDuration( value );
		return this;
	}

	public AbstractSoundInstance setLoop(int value) {
		impl.setLoop( value );
		return this;
	}

	public AbstractSoundInstance setMute(boolean value) {
		impl.setMute( value );
		return this;
	}

	public AbstractSoundInstance setPan(int value) {
		impl.setPan( value );
		return this;
	}

	public AbstractSoundInstance setPlayback(JavaScriptObject value) {
		impl.setPlayback( value );
		return this;
	}

	public AbstractSoundInstance setVolume(double value) {
		impl.setVolume( value );
		return this;
	}

	public AbstractSoundInstance stop() {
		impl.stop();
		return this;
	}

	//
	// properties:
	//

	public PlayState getPlayState() {
		String playState = impl.playState();
		if (playState == null) {
			return null;
		}
		return PlayState.fromJavascript( playState );
	}

	public String getSrc() {
		return impl.src();
	}

	public int getUniqueId() {
		return impl.uniqueId();
	}
}
