package net.depoker.createjs.common.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.Event;
import net.depoker.createjs.common.client.EventListener;

public class EventListenerImpl extends JavaScriptObject {
  public static native EventListenerImpl create(EventListener listener) /*-{
    return function(event) {
      // pass through to our anonymous function as the java type
      // this is preferable to passing the javascript (EventListenerImpl)
      var javaEvent = @Event::new(Lcom/google/gwt/core/client/JavaScriptObject;)(event);
      listener.@EventListener::handleEvent(*)(javaEvent);
    };
  }-*/;

  protected EventListenerImpl() {
  }

  public final native void handleEvent(Event event) /*-{
    this.handleEvent(event);
  }-*/;
}
