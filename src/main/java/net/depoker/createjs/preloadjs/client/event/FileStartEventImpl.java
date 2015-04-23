/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.preloadjs.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.impl.EventImpl;

public class FileStartEventImpl extends EventImpl {
  protected FileStartEventImpl() {
  }

  public final native JavaScriptObject item() /*-{
    return this.item;
  }-*/;
}
