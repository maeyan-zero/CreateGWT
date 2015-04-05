package net.depoker.createjs.easeljs.client.display;

import com.google.gwt.dom.client.Element;
import net.depoker.createjs.common.client.event.TickEvent;
import net.depoker.createjs.easeljs.client.display.impl.StageImpl;

public class Stage extends Container {

	private StageImpl overlay;

    /**
     * A stage is the root level Container for a display list. Each time its tick method is called, it will render its
     * display list to its target canvas.
     * @param canvas The canvas the stage will render to.
     */
	public Stage(Element canvas) {
		super(StageImpl.create(canvas));
		overlay = (StageImpl)getOverlay();
	}

    public Stage(StageImpl impl) {
	    super(impl);
        overlay = impl;
    }

    //
    // Parameters:
    //

    /**
     * Indicates whether the stage should automatically clear the canvas before each render. You can set this to false
     * to manually control clearing (for generative art, or when pointing multiple stages at the same canvas for example).
     * @return
     */
    public boolean getAutoClear() {
        return overlay.getAutoClear();
    };

    /**
     * Indicates whether the stage should automatically clear the canvas before each render. You can set this to false
     * to manually control clearing (for generative art, or when pointing multiple stages at the same canvas for example).
     * @param autoClear
     */
    public void setAutoClear(boolean autoClear) {
       overlay.setAutoClear(autoClear);
    };

    /**
     * The canvas the stage will render to. Multiple stages can share a single canvas, but you must disable autoClear
     * for all but the first stage that will be ticked (or they will clear each other's render).
     * @return
     */
    public Element getCanvas() {
        return overlay.getCanvas();
    };

    /**
     * Indicates whether the mouse is currently within the bounds of the canvas.
     * @return
     */
    public boolean getMouseInBounds() {
        return overlay.getMouseInBounds();
    };

    /**
     * Indicates whether the mouse is currently within the bounds of the canvas.
     * @param mouseInBounds
     */
    public void setMouseInBounds(boolean mouseInBounds) {
        overlay.setMouseInBounds(mouseInBounds);
    };

    /**
     * The current mouse Y position on the canvas. If the mouse leaves the canvas, this will indicate the most recen
     * position over the canvas, and mouseInBounds will be set to false.
     * @return
     */
    public int getMouseX() {
        return overlay.getMouseX();
    };

    /**
     * The current mouse X position on the canvas. If the mouse leaves the canvas, this will indicate the most recent
     * position over the canvas, and mouseInBounds will be set to false.
     * @return
     */
    public int getMouseY() {
        return overlay.getMouseY();
    };

    /**
     * Indicates whether this stage should use the snapToPixel property of display objects when rendering them.
     * @return
     */
    public int getSnapToPixelEnabled() {
        return overlay.getSnapToPixelEnabled();
    };

    /**
     * Indicates whether this stage should use the snapToPixel property of display objects when rendering them.
     * @param enabled
     */
    public void setSnapToPixelEnabled(boolean enabled) {
        overlay.setSnapToPixelEnabled(enabled);
    };

    /**
     * If false, tick callbacks will be called on all display objects on the stage prior to rendering to the canvas.
     * @return
     */
    public boolean getTickOnUpdate () {
        return overlay.getTickOnUpdate();
    };

    /**
     * If false, tick callbacks will be called on all display objects on the stage prior to rendering to the canvas.
     * @param tickOnUpdate
     */
    public void setTickOnUpdate (boolean tickOnUpdate) {
        overlay.setTickOnUpdate(tickOnUpdate);
    };

    //
    // Methods:
    //

    /**
     * Clears the target canvas. Useful if autoClear is set to false.
     */
    public void clear() {
        overlay.clear();
    }

    /**
     * Returns a clone of this Stage.
     * @return A clone of the current Container instance.
     */
//    @Override
//    public Stage clone() {
//        return new Stage((StageImpl)overlay.clone());
//    }

    /**
     * Enables or disables (by passing a frequency of 0) mouse over handlers (onMouseOver and onMouseOut) for this
     * stage's display list. These events can be expensive to generate, so they are disabled by default, and the frequency
     * of the events can be controlled independently of mouse move events via the optional frequency parameter.
     */
    public void enableMouseOver() {
        overlay.enableMouseOver(null);
    }

    /**
     * Enables or disables (by passing a frequency of 0) mouse over handlers (onMouseOver and onMouseOut) for this
     * stage's display list. These events can be expensive to generate, so they are disabled by default, and the frequency
     * of the events can be controlled independently of mouse move events via the optional frequency parameter.
     * @param frequency Optional param specifying the maximum number of times per second to broadcast mouse over/out events.
     *                  Set to 0 to disable mouse over events completely. Maximum is 50. A lower frequency is less
     *                  responsive, but uses less CPU. Default is 20.
     */
    public void enableMouseOver(int frequency) {
        overlay.enableMouseOver(frequency);
    }

    /**
     * Returns a data url that contains a Base64 encoded image of the contents of the stage. The returned data url can
     * be specified as the src value of an image element.
     * @return
     */
    public String toDataUrl() {
        return overlay.toDataUrl(null, null);
    }

    /**
     * Returns a data url that contains a Base64 encoded image of the contents of the stage. The returned data url can
     * be specified as the src value of an image element.
     * @param background The background color to be used for the generated image. The value can be any value HTML color
     *                   value, including HEX colors, rgb and rgba. The default value is a transparent background.
     * @param mimeType   The MIME type of the image format to be create. The default is "image/png". If an unknown MIME
     *                   type is passed in, or if the browser does not support the specified MIME type, the default value
     *                   will be used.
     * @return
     */
    public String toDataUrl(String background, String mimeType) {
        return overlay.toDataUrl(background, mimeType);
    }

    /**
     * Each time the update method is called, the stage will tick any descendants exposing a tick method (ex. BitmapAnimation)
     * and render its entire display list to the canvas.
     */

    public void update() {
	    overlay.update(null);
    }

    public void update(TickEvent tickEvent) {
        overlay.update(tickEvent.getImpl());
    }

    /**
     * The same thing as this.update().
     */
    public void tick() {
        overlay.tick();
    }

	public void setMozImageSmoothing(boolean enabled) {
		overlay.setMozImageSmoothing(getCanvas(), enabled);
	}

}
