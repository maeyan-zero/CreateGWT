/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class SoundJs {
	public interface SoundJsResources extends ClientBundle {
		SoundJsResources INSTANCE = GWT.create(SoundJsResources.class);

		@Source("soundjs-0.6.0.combined.js")
		TextResource soundJsScript();

		@Source("flashaudioplugin-0.6.0.combined.js")
		TextResource flashPluginScript();
	}

	/**
	 * Ensures the EaselJs javascript libraries have been injected into the DOM.
	 * This must be called once before invoking any library methods to avoid a undefined type exception.
	 * The DOM will only be manipulated if the library has not been injected yet.
	 *
	 * @return True if this method manipulated the DOM
	 */
	public static boolean ensureInjected() {
		if (!isInjected()) {
			String soundJsScript = SoundJsResources.INSTANCE.soundJsScript().getText();
			ScriptInjector.fromString( soundJsScript )
			              .setWindow( ScriptInjector.TOP_WINDOW )
			              .inject();

//			String flashJsScript = SoundJsResources.INSTANCE.flashPluginScript().getText();
//			ScriptInjector.fromString( flashJsScript )
//			              .setWindow( ScriptInjector.TOP_WINDOW )
//			              .inject();
			return true;
		}
		return false;
	}

	/**
	 * Checks if the EaselJs type definitions are defined, determining if the
	 * javascript library has been injected yet.
	 *
	 * @return True if EaselJs has been injected
	 */
	private static native boolean isInjected() /*-{
	  // check namespace first
	  if ((typeof $wnd.createjs === "undefined") || (null === $wnd.createjs)) return false;
	  // namespace exists, assume if DisplayObject is defined then the entire easeljs lib is injected
	  return (!(typeof $wnd.createjs.SoundJS === "undefined") && !(null === $wnd.createjs.SoundJS));
  }-*/;
}
