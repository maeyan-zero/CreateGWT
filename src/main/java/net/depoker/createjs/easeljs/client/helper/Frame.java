package net.depoker.createjs.easeljs.client.helper;

import net.depoker.createjs.easeljs.client.geom.Rectangle;
import net.depoker.createjs.easeljs.client.helper.impl.FrameImpl;
import com.google.gwt.dom.client.ImageElement;

public class Frame {

    private FrameImpl impl;
    private Rectangle rect;

    public Frame(FrameImpl impl) {
        this.impl = impl;
        rect = new Rectangle(impl.getRect());
    }

    public ImageElement getImage() {
        return impl.getImage();
    }

    public Rectangle getRectangle() {
        return rect;
    }

    public float getRegX() {
        return impl.getRegX();
    }

    public float getRegY() {
        return impl.getRegY();
    }

}
