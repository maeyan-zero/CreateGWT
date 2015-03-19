package net.depoker.createjs.common.client.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class EventImpl extends JavaScriptObject {
  public static native EventImpl create(String type, boolean bubbles, boolean cancelable) /*-{
    return new $wnd.createjs.Event(type, bubbles, cancelable);
  }-*/;

  protected EventImpl() {
  }

  public final native EventImpl clone() /*-{
    return new $wnd.createjs.Event(this.type, this.bubbles, this.cancelable);
  }-*/;

  public final native void preventDefault() /*-{
    this.preventDefault();
  }-*/;

  public final native void remove() /*-{
    this.remove();
  }-*/;

  public final native EventImpl set(JavaScriptObject props) /*-{
    this.set(props);
  }-*/;

  public final native void stopImmediatePropagation() /*-{
    this.stopImmediatePropagation();
  }-*/;

  public final native void stopPropagation() /*-{
    this.stopPropagation();
  }-*/;

  public final native boolean bubbles() /*-{
    return this.bubbles;
  }-*/;

  public final native boolean cancelable() /*-{
    return this.cancelable;
  }-*/;

  public final native JavaScriptObject currentTarget() /*-{
    return this.currentTarget;
  }-*/;

  public final native boolean defaultPrevented() /*-{
    return this.defaultPrevented;
  }-*/;

  public final native int eventPhase() /*-{
    return this.eventPhase;
  }-*/;

  public final native boolean immediatePropagationStopped() /*-{
    return this.immediatePropagationStopped;
  }-*/;

  public final native boolean propagationStopped() /*-{
    return this.propagationStopped;
  }-*/;

  public final native boolean removed() /*-{
    return this.removed;
  }-*/;

  public final native JavaScriptObject target() /*-{
    return this.target;
  }-*/;

  public final native double timeStamp() /*-{
    return this.timeStamp;
  }-*/;

  public final native String type() /*-{
    return this.type;
  }-*/;
}
