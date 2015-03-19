package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;

public class FileProgressEvent extends Event {
  public FileProgressEvent(Event event) {
    super(event.getImpl());
  }
}
