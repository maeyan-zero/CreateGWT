package net.depoker.createjs.easeljs.client.helper.impl;

import com.google.gwt.core.client.JsArrayInteger;

public class SpriteFrameImpl extends JsArrayInteger {

    protected SpriteFrameImpl() { }

    public static native SpriteFrameImpl create(int x, int y, int width, int height, int imageIndex, int regX, int regY) /*-{
        return [x, y, width, height, imageIndex, regX, regY];
    }-*/;

    public final native int getX() /*-{
        return this[0];
    }-*/;

    public final native int getY() /*-{
        return this[1];
    }-*/;

    public final native int getWidth() /*-{
        return this[2];
    }-*/;

    public final native int getHeight() /*-{
        return this[3];
    }-*/;

    public final native int getImageIndex() /*-{
        return this[4];
    }-*/;

    public final native int getRegX() /*-{
        return this[5];
    }-*/;

    public final native int getRegY() /*-{
        return this[6];
    }-*/;

}
