package net.depoker.createjs.preloadjs.client.event;

import net.depoker.createjs.common.client.Event;

public class InitializeEvent extends Event {
  public InitializeEvent(Event event) {
    super(event.getImpl());
  }
}
