package net.depoker.createjs.common.client.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class EventDispatcherImpl extends JavaScriptObject {
  protected EventDispatcherImpl() {
  }

  public final native JavaScriptObject addEventListener(String type, JavaScriptObject listener) /*-{
      return this.addEventListener(type, listener);
  }-*/;

  public final native JavaScriptObject addEventListener(String type, JavaScriptObject listener, boolean useCapture) /*-{
      return this.addEventListener(type, listener, useCapture);
  }-*/;

  public final native boolean dispatchEvent(String type) /*-{
      return this.dispatchEvent(type);
  }-*/;

  public final native boolean dispatchEvent(EventImpl event) /*-{
      return this.dispatchEvent(event);
  }-*/;

  public final native boolean hasEventListener(String type) /*-{
    return this.hasEventListener(type);
  }-*/;

  public final native void off(String type, JavaScriptObject listener) /*-{
    this.off(type, listener);
  }-*/;

  public final native void off(String type, JavaScriptObject listener, boolean useCapture) /*-{
    this.off(type, listener, useCapture);
  }-*/;

  public final native JavaScriptObject on(String type, JavaScriptObject listener) /*-{
    return this.on(type, listener);
  }-*/;

  public final native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope) /*-{
    return this.on(type, listener, scope);
  }-*/;

  public final native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once) /*-{
    return this.on(type, listener, scope, once);
  }-*/;

  public final native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once, JavaScriptObject data) /*-{
    return this.on(type, listener, scope, once, data);
  }-*/;

  public final native JavaScriptObject on(String type, JavaScriptObject listener, JavaScriptObject scope, boolean once, JavaScriptObject data, boolean useCapture) /*-{
    return this.on(type, listener, scope, once, data, useCapture);
  }-*/;

  public final native void removeAllEventListeners() /*-{
    this.removeAllEventListeners();
  }-*/;

  public final native void removeAllEventListeners(String type) /*-{
    this.removeAllEventListeners(type);
  }-*/;

  public final native void removeEventListener(String type, JavaScriptObject listener) /*-{
    this.removeEventListener(type, listener);
  }-*/;

  public final native void removeEventListener(String type, JavaScriptObject listener, boolean useCapture) /*-{
    this.removeEventListener(type, listener, useCapture);
  }-*/;

  public final native boolean willTrigger(String type) /*-{
    return this.willTrigger(type);
  }-*/;
}
