package net.depoker.createjs.easeljs.client.helper.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class SpriteSheetMetaImpl extends JavaScriptObject
{
	protected SpriteSheetMetaImpl() { }

	public static native SpriteSheetMetaImpl create(String path, int width, int height, int count, int regX, int regY) /*-{
		return {
			images: [path],
			frames: {
				width: width,
				height: height,
				count: count,
				regX: regX,
				regY: regY
			}
		};
	}-*/;

	public final native void setAnimation(JavaScriptObject animation) /*-{
		 this.animations = animation;
	}-*/;

}
