/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.preloadjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.preloadjs.client.impl.LoadItemImpl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class LoadItem {
  private final LoadItemImpl impl;

  public LoadItem(@NotNull JavaScriptObject impl) {
    this.impl = impl.cast();
  }

  public LoadItem(@NotNull String src) {
    impl = LoadItemImpl.create( src );
  }

  public @NotNull String getId() {
    return impl.getId();
  }

  public @NotNull LoadItemImpl getImpl() {
    return impl;
  }

  public @NotNull String getSource() {
    return impl.getSrc();
  }

  public void setSource(@NotNull String source) {
    impl.setSrc( source );
  }

	public @Nullable String getType() {
		return impl.getType();
	}

  public boolean isOrderMaintained() {
    return impl.isOrderMaintained();
  }

	public @Nullable JavaScriptObject getData() {
		return impl.getData();
	}
}
