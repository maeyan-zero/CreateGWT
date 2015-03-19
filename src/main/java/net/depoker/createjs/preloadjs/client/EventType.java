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

  private EventType(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return string;
  }
}
