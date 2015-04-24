/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.soundjs.client.impl.AbstractPluginImpl;

public class AbstractPlugin {
	final AbstractPluginImpl impl;

	public AbstractPlugin(JavaScriptObject impl) {
		this.impl = impl.cast();
	}

	public String toString() {
		return impl.toString();
	}
}
