package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;

public class ProgressEvent extends Event {
  private final ProgressEventImpl impl;

  public ProgressEvent(Event event) {
    super(event.getImpl());
    impl = getImpl().cast();
  }

  public int getLoaded() {
    return impl.loaded();
  }

  public double getProgress() {
    return impl.progress();
  }

  public int getTotal() {
    return impl.total();
  }
}
