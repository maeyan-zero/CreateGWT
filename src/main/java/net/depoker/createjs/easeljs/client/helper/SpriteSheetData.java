package net.depoker.createjs.easeljs.client.helper;

import net.depoker.createjs.easeljs.client.helper.impl.SpriteFrameImpl;
import net.depoker.createjs.easeljs.client.helper.impl.SpriteSheetDataImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;
import com.google.gwt.dom.client.ImageElement;

public class SpriteSheetData {

    private final SpriteSheetDataImpl impl;
    private JsArrayMixed images = JavaScriptObject.createArray().cast();
    private JsArray<SpriteFrameImpl> frames = JavaScriptObject.createArray().cast();

    @SuppressWarnings("unused")
	private FrameData frameMeta;

    // TODO: animation types.

    public SpriteSheetData() {
        impl = SpriteSheetDataImpl.create();
    }

    public SpriteSheetData(SpriteSheetDataImpl overlay) {
        impl = overlay;
    }

    public SpriteSheetData(String path, FrameData data) {
    	impl = SpriteSheetDataImpl.create();
    	addImage(path);
    	setFrameData(data);
	}

	public SpriteSheetDataImpl getOverlay() {
        return impl;
    }

    public void addImage(String path) {
        images.push(path);
        impl.setImages(images);
    }

    public void addImage(ImageElement image) {
        images.push(image);
        impl.setImages(images);
    }

    public void addSpriteFrame(SpriteFrame frame) {
    	frames.push(frame.getOverlay());
        impl.setFrames(frames);
    }

    public void setFrameData(FrameData meta) {
        frameMeta = meta;
        impl.setFrames(meta.getOverlay());
    }

    // TODO: animation methods

}
