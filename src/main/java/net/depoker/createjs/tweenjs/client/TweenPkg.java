package net.depoker.createjs.tweenjs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class TweenPkg
{
	/**
	 * Ensures the EaselJs javascript libraries have been injected into the DOM.
	 * This must be called once before invoking any library methods to avoid a undefined type exception.
	 * The DOM will only be manipulated if the library has not been injected yet.
	 *
	 * @return True if this method manipulated the DOM
	 */
	public static boolean ensureInjected() {
	    if (!isInjected()) {
	        ScriptInjector.fromString(TweenResources.INSTANCE.tweenJsScript().getText())
	                      .setWindow(ScriptInjector.TOP_WINDOW)
	                      .inject();
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
		return (!(typeof $wnd.createjs.Tween === "undefined") && !(null === $wnd.createjs.Tween));
	}-*/;

	public interface TweenResources extends ClientBundle
	{
		TweenResources INSTANCE = GWT.create(TweenResources.class);

		@Source("resources/scripts/tweenjs-0.5.1.min.js") TextResource tweenJsScript();
	}
}
