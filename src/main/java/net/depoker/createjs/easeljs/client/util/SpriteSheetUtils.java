package net.depoker.createjs.easeljs.client.util;

import net.depoker.createjs.easeljs.client.display.SpriteSheet;
import net.depoker.createjs.easeljs.client.util.impl.SpriteSheetUtilsImpl;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ImageElement;

/**
 * The SpriteSheetUtils class is a collection of static methods for working with sprite sheets. A sprite sheet
 * is a series of images (usually animation frames) combined into a single image on a regular grid. For example,
 * an animation consisting of 8 100x100 images could be combined into a 400x200 sprite sheet (4 frames across by
 * 2 high).
 * <p>The SpriteSheetUtils class uses a static interface and should not be instantiated.</p>
 */
public class SpriteSheetUtils {

	/**
	 * Returns a single frame of the specified sprite sheet as a new PNG image.
	 * 
	 * @param spriteSheet The SpriteSheet instance to extract a frame from.
	 * @param frameIndex  The frame number or animation name to extract. If an animation name is specified, only
	 *                    the first frame of the animation will be extracted.
	 * @return a single frame of the specified sprite sheet as a new PNG image.
	 */
	public static ImageElement extractFrame(SpriteSheet spriteSheet, int frameIndex) {
		return SpriteSheetUtilsImpl.extractFrame(spriteSheet.getOverlay(), frameIndex);
	}

	public static CanvasElement mergeAlpha(Element rgbImage, Element alphaImage) {
		return SpriteSheetUtilsImpl.mergeAlpha(rgbImage, alphaImage);
	}
	
}
