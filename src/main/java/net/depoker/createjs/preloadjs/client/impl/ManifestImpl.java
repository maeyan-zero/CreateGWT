package net.depoker.createjs.preloadjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class ManifestImpl extends JavaScriptObject {
  protected ManifestImpl() {
  }

  public final native JsArray<LoadItemImpl> getManifest() /*-{
    return this.manifest;
  }-*/;

  public final native String getPath() /*-{
    return this.path;
  }-*/;

  public final native void setManifest(JsArray<LoadItemImpl> manifest) /*-{
    this.manifest = manifest;
  }-*/;

  public final native void setPath(String path) /*-{
    this.path = path;
  }-*/;
}
