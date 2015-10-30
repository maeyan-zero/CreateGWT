package net.depoker.createjs.preloadjs.client.impl;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.impl.EventImpl;

public class FileLoadEventImpl extends EventImpl {
  protected FileLoadEventImpl() {
  }

  public final native LoadItemImpl getItem() /*-{
    return this.item;
  }-*/;

  public final native JavaScriptObject getResult() /*-{
    return this.result;
  }-*/;
}
