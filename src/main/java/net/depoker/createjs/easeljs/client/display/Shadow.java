package net.depoker.createjs.easeljs.client.display;

import net.depoker.createjs.easeljs.client.display.impl.ShadowImpl;

public class Shadow {

    private ShadowImpl overlay;

    /**
     * Encapsulates the properties required to define a shadow to apply to a DisplayObject via it's .shadow property.
     *
     * @param color   The color of the shadow.
     * @param offsetX The x offset of the shadow.
     * @param offsetY The y offset of the shadow.
     * @param blur    The size of the blurring effect.
     */
    public Shadow(String color, double offsetX, double offsetY, double blur) {
        this(ShadowImpl.create(color, offsetX, offsetY, blur));
    }

    public Shadow(ShadowImpl impl) {
        overlay = impl;
    }

    /**
     * Returns the shadow implementation object.
     * @return
     */
    public ShadowImpl getOverlay() {
        return overlay;
    }

    /**
     * Returns the blur of the shadow.
     * @return
     */
    public double getBlur() {
        return overlay.getBlur();
    }

    /**
     * Sets the blur of the shadow.
     * @param blur
     */
    public void setBlur(double blur) {
        overlay.setBlur(blur);
    }

    /**
     * Returns the color of the shadow.
     * @return
     */
    public String getColor() {
        return overlay.getColor();
    }

    /**
     * Sets the color of the shadow.
     * @param color
     */
    public void setColor(String color) {
        overlay.setColor(color);
    }

    /**
     * Returns the x offset of the shadow.
     * @return
     */
    public double getOffsetX() {
        return overlay.getOffsetX();
    }

    /**
     * Sets the x offset of the shadow.
     * @param x
     */
    public void setOffsetX(double x) {
        overlay.setOffsetX(x);
    }

    /**
     * Returns the y offset of the shadow.
     * @return
     */
    public double getOffsetY() {
        return overlay.getOffsetY();
    }

    /**
     * Sets the y offset of the shadow.
     * @param y
     */
    public void setOffsetY(double y) {
        overlay.setOffsetY(y);
    }

    /**
     * Returns a clone of this Shadow instance.
     * @return
     */
    public Shadow clone() {
        return new Shadow(overlay.clone());
    }

}
