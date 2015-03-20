package net.depoker.createjs.easeljs.client.helper.impl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayMixed;

public class SpriteSheetDataImpl extends JavaScriptObject {

    protected SpriteSheetDataImpl() { }

    public static native SpriteSheetDataImpl create() /*-{
         return eval({});
    }-*/;

    public final native void setImages(JsArrayMixed images) /*-{
        this.images = images;
    }-*/;

    public final native void setFrames(FrameDataImpl meta) /*-{
        this.frames = meta;
    }-*/;

    public final native void setFrames(JsArray<SpriteFrameImpl> frames) /*-{
        this.frames = frames;
    }-*/;

}
