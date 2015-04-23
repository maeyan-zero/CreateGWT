/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.easeljs.client.display;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.json.client.JSONArray;
import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;
import net.depoker.createjs.easeljs.client.display.impl.SpriteSheetImpl;
import net.depoker.createjs.easeljs.client.helper.Frame;
import net.depoker.createjs.easeljs.client.helper.FrameData;
import net.depoker.createjs.easeljs.client.helper.Handler;
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
public class SpriteSheet {

	public final static String COMPLETE = "complete";

	private final SpriteSheetImpl overlay;

	private final List<SpriteSheetCallback> completeCallbacks = new ArrayList<SpriteSheetCallback>();

	public SpriteSheet(JavaScriptObject meta) {
		overlay = SpriteSheetImpl.create(meta);
		overlay.setCompleteHandler(this);
	}

	public SpriteSheet(FrameData frameData) {
		overlay = SpriteSheetImpl.create( frameData.getOverlay() );
		overlay.setCompleteHandler(this);
	}

	public SpriteSheetImpl getOverlay() { return overlay; }

	/**
	 * Read-only property indicating whether all images are finished loading.
	 */
	public boolean isComplete() { return overlay.getComplete(); }

	public Map<String, Object> getAnimation(String animation) {
		JavaScriptObject jso = overlay.getAnimation(animation);
		if (jso == null) return null;

		Map<String, Object> map = new HashMap<String, Object>();
		JSONObject json = new JSONObject(jso);
		Set<String> keySet = json.keySet();
		for (String key : keySet) {
			JSONValue value = json.get(key);

			if (value.isNumber() != null) { // stand: 13
				map.put(key, value.isNumber().doubleValue());
			} else if (value.isArray() != null) {
				List<Object> array = new ArrayList<Object>();
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
		JsArrayString jsArray = overlay.getAnimations();
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
		return (overlay.getFrame(frameIndex) != null) ?
				new Frame(overlay.getFrame(frameIndex)) : null;
	}

	/**
	 * Returns the total number of frames in the specified animation, or in the whole sprite sheet if the
	 * animation param is omitted.
	 *
	 * @param animation The name of the animation to get a frame count for.
	 * @return The number of frames in the animation, or in the entire sprite sheet if the animation param is omitted.
	 */
	public int getNumFrames(String animation) { return overlay.getNumFrames(animation); }

	public int getNumFrames() { return overlay.getNumFrames(null); }

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
	public void addOnCompleteHandler(SpriteSheetCallback callback) { completeCallbacks.add(callback); }

	/**
	 * Adds the specified event listener.
	 *
	 * @param type The string type of the event
	 * @param listener An object with a handleEvent method, or a function that will be called when the event is dispatched
	 */
	public void addEventListener(String type, Handler listener) { overlay.addEventListener(type, listener); }

	/**
	 * Dispatches the specified event.
	 *
	 * @param event An object with a "type" property, or a string type. If a string is used, dispatchEvent will contstruct
	 *              a generic event object with "type" and "params" properties.
	 */
	public void dispatchEvent(String event) { overlay.dispatchEvent(event); }

	/**
	 * Dispatches the specified event.
	 *
	 * @param event  An object with a "type" property, or a string type. If a string is used, dispatchEvent will contstruct
	 *               a generic event object with "type" and "params" properties
	 * @param target The object to use as the target property of the event object. This will default to the dispatching object
	 */
	public void dispatchEvent(String event, DisplayObject target) { overlay.dispatchEvent(event, target.getOverlay()); }

	/**
	 * Indicates whether there is at least one listener for the specified event type.
	 *
	 * @param type The string type of the event.
	 * @return Returns true if there is at least one listener for the specified event.
	 */
	public boolean hasEventListener(String type) { return overlay.hasEventListener(type); }

	/**
	 * Removes all listeners for the specified type, or all listeners of all types.
	 */
	public void removeAllEventListeners() { overlay.removeAllEventListeners(); }

	/**
	 * Removes all listeners for the specified type, or all listeners of all types.
	 *
	 * @param type The string type of the event.
	 */
	public void removeAllEventListeners(String type) { overlay.removeAllEventListeners(type); }

	/**
	 * Fired by the overlay, wiring the pojo implementation.
	 **/
	protected void onComplete() {
		for (SpriteSheetCallback callback : completeCallbacks) {
			callback.onComplete();
		}
	}

}
