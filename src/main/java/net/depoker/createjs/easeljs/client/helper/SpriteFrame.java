package net.depoker.createjs.easeljs.client.helper;

import net.depoker.createjs.easeljs.client.helper.impl.SpriteFrameImpl;

public class SpriteFrame {

    private SpriteFrameImpl impl;

    public SpriteFrame(int x, int y, int width, int height, int imageIndex, int regX, int regY) {
         impl = SpriteFrameImpl.create(x, y, width, height, imageIndex, regX, regY);
    }

    public SpriteFrameImpl getOverlay() {
        return impl;
    }

    public int getX() {
        return impl.getX();
    }

    public int getY() {
        return impl.getY();
    }

    public int getWidth() {
        return impl.getWidth();
    }

    public int getHeight() {
        return impl.getHeight();
    }

    public int getImageIndex() {
        return impl.getImageIndex();
    }

    public int getRegX() {
        return impl.getRegX();
    }

    public int getRegY() {
        return impl.getRegY();
    }

}
