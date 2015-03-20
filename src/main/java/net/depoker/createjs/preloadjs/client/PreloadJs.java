package net.depoker.createjs.preloadjs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public class PreloadJs {

  /**
   * Ensures the PreloadJs javascript libraries have been injected into the DOM.
   * This must be called once before invoking any library methods to avoid a undefined type exception.
   * The DOM will only be manipulated if the library has not been injected yet.
   *
   * @return True if this method manipulated the DOM
   */
  public static boolean ensureInjected() {
    if (!isInjected()) {
      ScriptInjector.fromString(PreloadJsResources.INSTANCE.preloadJsScript().getText())
          .setWindow(ScriptInjector.TOP_WINDOW)
          .inject();
      return true;
    }
    return false;
  }

  /**
   * Checks if the PreloadJs type definitions are defined, determining if the
   * javascript library has been injected yet.
   *
   * @return True if PreloadJs has been injected
   */
  private static native boolean isInjected() /*-{
    // check namespace first
    if ((typeof $wnd.createjs === "undefined") || (null === $wnd.createjs)) return false;
    // namespace exists, now check for preloadjs definition
    return (!(typeof $wnd.createjs.PreloadJS === "undefined") && !(null === $wnd.createjs.PreloadJS));
  }-*/;

  public interface PreloadJsResources extends ClientBundle {
    PreloadJsResources INSTANCE = GWT.create(PreloadJsResources.class);

    @Source("preloadjs-0.6.0.combined.js")
    TextResource preloadJsScript();
  }

}
