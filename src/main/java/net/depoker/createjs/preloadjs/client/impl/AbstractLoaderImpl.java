package net.depoker.createjs.preloadjs.client.impl;

import net.depoker.createjs.common.client.impl.EventDispatcherImpl;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.jetbrains.annotations.NotNull;

public class AbstractLoaderImpl extends EventDispatcherImpl {
  protected AbstractLoaderImpl() {
  }

  public final native void cancel() /*-{
    this.cancel();
  }-*/;

  public final native void destroy() /*-{
    this.destroy();
  }-*/;

  public final native LoadItemImpl getItem(@NotNull String value) /*-{
    return this.getItem(value);
  }-*/;

  public final native JsArray getLoadedItems() /*-{
    return this.getLoadedItems();
  }-*/;

  public final native JavaScriptObject getResult() /*-{
    return this.getResult();
  }-*/;

  public final native JavaScriptObject getResult(boolean raw) /*-{
    return this.getResult(raw);
  }-*/;

  public final native JavaScriptObject getTag() /*-{
    return this.getTag();
  }-*/;

  public final native void load() /*-{
    this.load();
  }-*/;

  public final native void setTag(JavaScriptObject tag) /*-{
    this.setTag(tag);
  }-*/;

  public final native boolean canceled() /*-{
    return this.canceled;
  }-*/;

  public final native boolean loaded() /*-{
    return this.loaded;
  }-*/;

  public final native double progress() /*-{
    return this.progress;
  }-*/;

  // TODO: Implement result formatter - docs lack definition details


}
