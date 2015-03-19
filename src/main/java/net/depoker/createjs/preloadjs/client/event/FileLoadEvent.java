package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;
import net.depoker.createjs.preloadjs.client.LoadItem;
import net.depoker.createjs.preloadjs.client.impl.FileLoadEventImpl;

public class FileLoadEvent extends Event {
  final private FileLoadEventImpl impl;

  public FileLoadEvent(Event event) {
    super(event.getImpl());
    impl = getImpl().cast();
  }

  public LoadItem getItem() {
    return new LoadItem(impl.getItem());
  }
}
