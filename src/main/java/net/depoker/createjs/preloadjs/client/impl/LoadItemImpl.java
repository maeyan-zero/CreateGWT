package net.depoker.createjs.preloadjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class LoadItemImpl extends JavaScriptObject {
  public static native LoadItemImpl create(String src) /*-{
    return $wnd.createjs.LoadItem.create(src);
  }-*/;

  protected LoadItemImpl() {
  }

  public final native String getSrc() /*-{
    return this.src;
  }-*/;

  public final native String getType() /*-{
    return this.type;
  }-*/;

  public final native String getId() /*-{
    return this.id;
  }-*/;

  public final native boolean isOrderMaintained() /*-{
    return this.maintainOrder;
  }-*/;

  public final native String getCallback() /*-{
    return this.callback;
  }-*/;

  public final native JavaScriptObject getData() /*-{
    return this.data;
  }-*/;

  public final native String getMethod() /*-{
    return this.method;
  }-*/;

  public final native JavaScriptObject getValues() /*-{
    return this.values;
  }-*/;

  public final native JavaScriptObject getHeaders() /*-{
    return this.headers;
  }-*/;

  public final native boolean isWithCredentials() /*-{
    return this.withCredentials;
  }-*/;

  public final native String getMimeType() /*-{
    return this.mimeType;
  }-*/;

  public final native boolean isCrossOrigin() /*-{
    return this.crossOrigin = crossOrigin;
  }-*/;

  public final native int getLoadTimeout() /*-{
    return this.loadTimeout;
  }-*/;

  public final native void setSrc(String src) /*-{
    this.src = src;
  }-*/;

  public final native void setType(String type) /*-{
    this.type = type;
  }-*/;

  public final native void setId(String id) /*-{
    this.id = id;
  }-*/;

  public final native void setMaintainOrder(boolean maintainOrder) /*-{
    this.maintainOrder = maintainOrder;
  }-*/;

  public final native void setCallback(String callback) /*-{
    this.callback = callback;
  }-*/;

  public final native void setData(JavaScriptObject data) /*-{
    this.data = data;
  }-*/;

  public final native void setMethod(String method) /*-{
    this.method = method;
  }-*/;

  public final native void setValues(JavaScriptObject values) /*-{
    this.values = values;
  }-*/;

  public final native void setHeaders(JavaScriptObject headers) /*-{
    this.headers = headers;
  }-*/;

  public final native void setWithCredentials(boolean withCredentials) /*-{
    this.withCredentials = withCredentials;
  }-*/;

  public final native void setMimeType(String mimeType) /*-{
    this.mimeType = mimeType;
  }-*/;

  public final native void setCrossOrigin(boolean crossOrigin) /*-{
    this.crossOrigin = crossOrigin;
  }-*/;

  public final native void setLoadTimeout(String loadTimeout) /*-{
    this.loadTimeout = loadTimeout;
  }-*/;
}
