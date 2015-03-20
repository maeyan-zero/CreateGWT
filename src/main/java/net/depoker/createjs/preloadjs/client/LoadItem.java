package net.depoker.createjs.preloadjs.client;

import net.depoker.createjs.preloadjs.client.impl.LoadItemImpl;
import com.google.gwt.core.client.JavaScriptObject;
import org.jetbrains.annotations.Nullable;

import javax.validation.constraints.NotNull;

public class LoadItem {
  private final LoadItemImpl impl;

  public LoadItem(@NotNull JavaScriptObject impl) {
    this.impl = impl.cast();
  }

  public LoadItem(@NotNull String src) {
    impl = LoadItemImpl.create(src);
  }

  @Nullable
  public String getId() {
    return impl.getId();
  }

  @NotNull
  public LoadItemImpl getImpl() {
    return impl;
  }

  @NotNull
  public String getSource() {
    return impl.getSrc();
  }

	public String getType() {
		return impl.getType();
	}

  public boolean isOrderMaintained() {
    return impl.isOrderMaintained();
  }
}
