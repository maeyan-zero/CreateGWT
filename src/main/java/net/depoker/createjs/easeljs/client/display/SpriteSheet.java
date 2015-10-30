/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.easeljs.client.display;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import com.google.gwt.user.client.Timer;
import net.depoker.createjs.common.client.Event;
import net.depoker.createjs.common.client.EventDispatcher;
import net.depoker.createjs.common.client.EventListener;
import net.depoker.createjs.easeljs.client.display.impl.SpriteSheetImpl;
import net.depoker.createjs.easeljs.client.helper.Frame;
import net.depoker.createjs.easeljs.client.helper.FrameData;
import net.depoker.createjs.easeljs.client.helper.SpriteSheetCallback;

import java.util.*;

/**
 * Encapsulates the properties and methods associated with a sprite sheet. A sprite sheet is a series of images (usually
 * animation frames) combined into a larger image (or images). For example, an animation consisting of 8 100x100 images
 * could be combined into a 400x200 sprite sheet (4 frames across by 2 high).
 * <p>The data passed to the SpriteSheet constructor defines three critical pieces of information:</p>
 * <ul><li>The image or images to use.</li>
 * <li>The positions of individual image frames. This data can be represented in one of two ways: As a regular grid of
 * sequential, equal-sized frames, or as individually defined, variable sized frames arranged in an irregular
 * (non-sequential) fashion.</li>
 * <li>Likewise, animations can be represented in two ways: As a series of sequential frames, defined by a start and end
 * frame [0,3], or as a list of frames [0,1,2,3].</li></ul>
 */
public class SpriteSheet extends EventDispatcher {

	private final SpriteSheetImpl impl;

	public SpriteSheet(JavaScriptObject meta) {
		super( SpriteSheetImpl.create( meta ) );
		this.impl = getImpl().cast();
	}

	public SpriteSheet(FrameData frameData) {
		super( SpriteSheetImpl.create( frameData.getOverlay() ) );
		this.impl = getImpl().cast();
	}

	public SpriteSheetImpl getOverlay() {
		return impl;
	}

	/**
	 * Read-only property indicating whether all images are finished loading.
	 */
	public boolean isComplete() { return impl.getComplete(); }

	public Map<String, Object> getAnimation(String animation) {
		JavaScriptObject jso = impl.getAnimation(animation);
		if (jso == null) return null;

		Map<String, Object> map = new HashMap<>();
		JSONObject json = new JSONObject(jso);
		Set<String> keySet = json.keySet();
		for (String key : keySet) {
			JSONValue value = json.get(key);

			if (value.isNumber() != null) { // stand: 13
				map.put(key, value.isNumber().doubleValue());
			} else if (value.isArray() != null) {
				List<Object> array = new ArrayList<>();
				JSONArray jsArray = value.isArray();
				for (int i = 0; i < jsArray.size(); i++) {
					jsArray.get(i);
					//array.add();
				}
			} else if (value.isString() != null) {

			}
		}

		return map;
	}

	/**
	 * Returns an array of all available animation names as strings.
	 *
	 * @return an array of animation names available on this sprite sheet.
	 */
	public ArrayList<String> getAnimations() {
		JsArrayString jsArray = impl.getAnimations();
		ArrayList<String> array = new ArrayList<String>();
		for (int i=0; i<jsArray.length(); i++) { array.add(jsArray.get(i)); }
		return array;
	}

	/**
	 * Returns an object specifying the image and source rect of the specified frame. The returned object
	 * has an image property holding a reference to the image object in which the frame frame is found, and
	 * a rect property containing a Rectangle instance which defines the boundaries for the frame within
	 * that image.
	 *
	 * @param frameIndex The index of the frame.
	 * @return a generic object with image and rect properties. Returns null if the frame does not exist,
	 * or the image is not fully loaded.
	 */
	public Frame getFrame(int frameIndex) {
		return (impl.getFrame(frameIndex) != null) ?
				new Frame(impl.getFrame(frameIndex)) : null;
	}

	/**
	 * Returns the total number of frames in the specified animation, or in the whole sprite sheet if the
	 * animation param is omitted.
	 *
	 * @param animation The name of the animation to get a frame count for.
	 * @return The number of frames in the animation, or in the entire sprite sheet if the animation param is omitted.
	 */
	public int getNumFrames(String animation) { return impl.getNumFrames( animation ); }

	public int getNumFrames() { return impl.getNumFrames(null); }

	/**
	 * The onComplete callback is called when all images are loaded. Note that this only fires if the images were not
	 * fully loaded when the sprite sheet was initialized. You should check the complete property to prior
	 * to adding an onComplete handler.
	 * <pre>
	 * var sheet = new SpriteSheet(data);
     * if (!sheet.complete) {
     *    // not preloaded, listen for onComplete:
     *    sheet.onComplete = handler;
     * }
	 * </pre>
	 *
	 * @param callback The callback to fire on the complete event
	 */
	public void addOnCompleteHandler(final SpriteSheetCallback callback) {
		addEventListener( "complete", new EventListener() {
			@Override public void handleEvent(Event event) {
				new Timer() {
					@Override public void run() {
						callback.onComplete();
					}
				}.schedule( 1 );
			}
		} );
	}

}
