/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.preloadjs.client;


public enum EventType {
  COMPLETE("complete"),
  ERROR("error"),
  FILE_ERROR("fileerror"),
  FILE_LOAD("fileload"),
  FILE_PROGRESS("fileprogress"),
  FILE_START("filestart"),
  INITIALIZE("initialize"),
  LOAD_START("loadstart"),
  PROGRESS("progress");

  final private String string;

  EventType(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
