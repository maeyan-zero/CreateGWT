package net.depoker.createjs.easeljs.client.helper.impl;

import net.depoker.createjs.easeljs.client.geom.impl.RectangleImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.dom.client.ImageElement;

public class FrameImpl extends JavaScriptObject {

    protected FrameImpl() { }

    public final native ImageElement getImage() /*-{
         return this.image;
    }-*/;

    public final native RectangleImpl getRect() /*-{
         return this.rect;
    }-*/;

    public final native float getRegX() /*-{
        return this.regX;
    }-*/;

    public final native float getRegY() /*-{
        return this.regY;
    }-*/;

}
