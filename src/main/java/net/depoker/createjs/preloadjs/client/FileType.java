/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.preloadjs.client;

public enum FileType {
  BINARY("binary"),
  CSS("css"),
  GET("GET"),
  IMAGE("image"),
  JAVASCRIPT("javascript"),
  JSON("json"),
  JSONP("jsonp"),
  MANIFEST("manifest"),
  POST("post"),
  SOUND("sound"),
  SPRITESHEET("spritesheet"),
  SVG("svg"),
  TEST("text"),
  VIDEO("video"),
  XML("xml");

  private final String string;

  FileType(String string) {
    this.string = string;
  }

  @Override public String toString() {
    return string;
  }

	public static FileType fromJavaScriptType(String javascriptValue) {
		for (FileType fileType : values()) {
			if (javascriptValue.equals( fileType.string )) {
				return fileType;
			}
		}

		// could be a plugin type, or just a syntax error
		throw new IllegalArgumentException( "Unknown Preload FileType: " + javascriptValue );
	}
}
