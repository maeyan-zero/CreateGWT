package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;

public class FileErrorEvent extends Event {
  public FileErrorEvent(Event event) {
    super(event.getImpl());
  }
}
