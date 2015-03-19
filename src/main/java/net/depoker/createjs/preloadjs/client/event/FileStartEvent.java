package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;

public class FileStartEvent extends Event {
  public FileStartEvent(Event event) {
    super(event.getImpl());
  }
}
