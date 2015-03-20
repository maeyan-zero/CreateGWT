package net.depoker.createjs.easeljs.client.util.impl;

import net.depoker.createjs.easeljs.client.display.impl.SpriteSheetImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ImageElement;

public class SpriteSheetUtilsImpl extends JavaScriptObject {

	protected SpriteSheetUtilsImpl() { }
	
	public static native ImageElement extractFrame(SpriteSheetImpl spriteSheet, int frameIndex) /*-{
		return $wnd.createjs.SpriteSheetUtils.extractFrame(spriteSheet, frameIndex);
	}-*/;

	public static native CanvasElement mergeAlpha(Element rgbImage, Element alphaImage) /*-{
	    return $wnd.createjs.SpriteSheetUtils.mergeAlpha(rgbImage, alphaImage);
	}-*/;
	
}
