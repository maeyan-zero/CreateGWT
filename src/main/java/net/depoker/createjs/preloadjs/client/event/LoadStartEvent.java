package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;

public class LoadStartEvent extends Event {
  public LoadStartEvent(Event event) {
    super(event.getImpl());
  }
}
