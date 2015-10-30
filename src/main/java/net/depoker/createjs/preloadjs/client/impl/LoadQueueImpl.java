package net.depoker.createjs.preloadjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import javax.validation.constraints.NotNull;

public class LoadQueueImpl extends AbstractLoaderImpl {
  public static native LoadQueueImpl create() /*-{
    return new $wnd.createjs.LoadQueue();
  }-*/;

  public static native LoadQueueImpl create(boolean preferXhr) /*-{
    return new $wnd.createjs.LoadQueue(preferXhr);
  }-*/;

  public static native LoadQueueImpl create(boolean preferXhr, @NotNull String basePath) /*-{
    return new $wnd.createjs.LoadQueue(preferXhr, basePath);
  }-*/;

  protected LoadQueueImpl() {
  }

  public final native void close() /*-{
    this.close();
  }-*/;

  public final native JsArray getItems(boolean loaded) /*-{
    return this.getItems(loaded);
  }-*/;

  public final native void installPlugin(JavaScriptObject plugin) /*-{
    this.installPlugin(plugin);
  }-*/;

  public final native void loadFile(JavaScriptObject file) /*-{
    this.loadFile(file);
  }-*/;

  public final native void loadFile(JavaScriptObject file, boolean loadNow) /*-{
    this.loadFile(file, loadNow);
  }-*/;

  public final native void loadFile(String file) /*-{
    this.loadFile(file);
  }-*/;

  public final native void loadFile(String file, boolean loadNow) /*-{
    this.loadFile(file, loadNow);
  }-*/;

  public final native void loadManifest(String manifest) /*-{
    this.loadManifest(manifest);
  }-*/;

  public final native void loadManifest(String manifest, boolean loadNow) /*-{
    this.loadManifest(manifest, loadNow);
  }-*/;

  public final native void loadManifest(JavaScriptObject manifest) /*-{
    this.loadManifest(manifest);
  }-*/;

  public final native void loadManifest(JavaScriptObject manifest, boolean loadNow) /*-{
    this.loadManifest(manifest, loadNow);
  }-*/;

  public final native void registerLoader(JavaScriptObject loader) /*-{
    this.registerLoader(loader);
  }-*/;

  public final native void remove(String... idsOrUrls) /*-{
    this.remove(idsOrUrls);
  }-*/;

  public final native void removeAll() /*-{
    this.removeAll();
  }-*/;

  public final native void reset() /*-{
    this.reset();
  }-*/;

  public final native void setMaxConnections(int value) /*-{
    this.setMaxConnections(value);
  }-*/;

  public final native void setPaused(boolean value) /*-{
    this.setPaused(value);
  }-*/;

  public final native void setPreferXHR(boolean value) /*-{
    this.setPreferXHR(value);
  }-*/;

  public final native void unregisterLoader(JavaScriptObject loader) /*-{
    this.unregisterLoader(loader);
  }-*/;

  public final native void maintainScriptOrder(boolean value) /*-{
	return this.maintainScriptOrder = value;
  }-*/;

  public final native boolean maintainScriptOrder() /*-{
    return this.maintainScriptOrder;
  }-*/;

  public final native JavaScriptObject next() /*-{
    return this.next;
  }-*/;

  public final native boolean stopOnError() /*-{
    return this.stopOnError;
  }-*/;
}
