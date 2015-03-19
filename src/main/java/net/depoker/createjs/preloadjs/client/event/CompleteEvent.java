package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;

public class CompleteEvent extends Event {
  public CompleteEvent(Event event) {
    super(event.getImpl());
  }
}
