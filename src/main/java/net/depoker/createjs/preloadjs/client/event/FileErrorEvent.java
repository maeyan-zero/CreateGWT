package net.depoker.createjs.preloadjs.client.event;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.Event;
import org.jetbrains.annotations.Nullable;

public class FileErrorEvent extends Event {
	private final ErrorEventImpl impl;
  public FileErrorEvent(Event event) {
    super(event.getImpl());
	  impl = getImpl().cast();
  }

	/**
	 * Returns the error title.
	 *
	 * @return The error title.
	 */
	public @Nullable String getTitle() {
		return impl.title();
	}

	/**
	 * Returns the error description.
	 *
	 * @return The error description.
	 */
	public @Nullable String getMessage() {
		return impl.message();
	}

	/**
	 * Returns additional error data.
	 *
	 * @return Additional error data.
	 */
	public @Nullable JavaScriptObject getData() {
		return impl.data();
	}
}
