package net.depoker.createjs.easeljs.client.helper;

import net.depoker.createjs.easeljs.client.helper.impl.FrameDataImpl;
import com.google.gwt.core.client.JavaScriptObject;

public class FrameData {

    private FrameDataImpl impl;

    public FrameData(int width, int height, int count, int regX, int regY) {
    	impl = JavaScriptObject.createObject().cast();
    	impl.setWidth(width);
    	impl.setHeight(height);
    	impl.setCount(count);
    	impl.setRegX(regX);
    	impl.setRegY(regY);
    }
    
    public FrameData(FrameDataImpl impl) {
        this.impl = impl;
    }

    public FrameDataImpl getOverlay() {
        return impl;
    }

    public int getWidth() {
        return impl.getWidth();
    }

    public int getHeight() {
        return impl.getHeight();
    }

    public int getCount() {
        return impl.getCount();
    }

    public int getRegX() {
        return impl.getRegX();
    }

    public int getRegY() {
        return impl.getRegY();
    }

}
