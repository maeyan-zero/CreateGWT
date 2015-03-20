package net.depoker.createjs.easeljs.client.helper.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class FrameDataImpl extends JavaScriptObject {

    protected FrameDataImpl() { }

    public final native int getWidth() /*-{
        return this.width;
    }-*/;

    public final native int getHeight() /*-{
        return this.height;
    }-*/;

    public final native int getCount() /*-{
        return this.count;
    }-*/;

    public final native int getRegX() /*-{
        return this.regX;
    }-*/;

    public final native int getRegY() /*-{
        return this.regY;
    }-*/;
    
    public final native void setWidth(int width) /*-{
    	this.width = width;
    }-*/;
    
    public final native void setHeight(int height) /*-{
    	this.height = height;
    }-*/;
    
    public final native void setCount(int count) /*-{
    	this.count = count;
    }-*/;
    
    public final native void setRegX(int regX) /*-{
    	this.regX = regX;
    }-*/;
    
    public final native void setRegY(int regY) /*-{
    	this.regY = regY;
    }-*/;

}
