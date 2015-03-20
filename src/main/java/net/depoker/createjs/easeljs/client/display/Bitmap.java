package net.depoker.createjs.easeljs.client.display;

import net.depoker.createjs.easeljs.client.geom.Rectangle;
import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.Element;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.VideoElement;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.ui.Image;

import net.depoker.createjs.easeljs.client.display.impl.BitmapImpl;

/**
 * A Bitmap represents an Image, Canvas, or Video in the display list. A Bitmap can be instantiated using an existing
 * HTML element, or a string.
 */
public class Bitmap extends DisplayObject {

	private final BitmapImpl overlay;

    public Bitmap() {
		this(BitmapImpl.create());
	}

	public Bitmap(BitmapImpl impl) {
		super(impl);
		overlay = impl;
	}

	/**
	 * A Bitmap representing a Image.
	 *
	 * @param image The source object to display.
	 */
	public Bitmap(Image image) {
		super(BitmapImpl.create(image.getElement()));
		overlay = (BitmapImpl)getOverlay();
    }

    /**
     * A Bitmap representing a Canvas.
     *
     * @param canvas The source object to display.
     */
    public Bitmap(Canvas canvas) {
	    super(BitmapImpl.create(canvas.getElement()));
	    overlay = (BitmapImpl)getOverlay();
    }

    /**
     * A Bitmap representing a Video.
     *
     * @param video The source object to display.
     */
    public Bitmap(Video video) {
	    super(BitmapImpl.create(video.getElement()));
	    overlay = (BitmapImpl)getOverlay();
    }

    /**
     * A Bitmap representing a Image.
     *
     * @param image The source object to display.
     */
    public Bitmap(ImageElement image) {
	    super(BitmapImpl.create(image));
	    overlay = (BitmapImpl)getOverlay();
    }

    /**
     * A Bitmap representing a Canvas.
     *
     * @param canvas The source object to display.
     */
    public Bitmap(CanvasElement canvas) {
	    super(BitmapImpl.create(canvas));
	    overlay = (BitmapImpl)getOverlay();
    }

    /**
     * A Bitmap representing a Video.
     *
     * @param video The source object to display.
     */
    public Bitmap(VideoElement video) {
	    super(BitmapImpl.create(video));
	    overlay = (BitmapImpl)getOverlay();
    }

	/**
	 * A Bitmap constructed from a given uri.
	 *
	 * @param uri The path of the resource
	 */
	public Bitmap(String uri) {
		super(BitmapImpl.create(uri));
		overlay = (BitmapImpl)getOverlay();
	}

    /**
     * Gets the Element used to construct this object.
     *
     * @return The Bitmap dom element.
     */
    public Element getElement() {
        return overlay.getImage();
    }

	/**
	 * Specifies an area of the source image to draw. If omitted, the whole image will be drawn.
	 */
	public void setSourceRect(Rectangle rectangle) {
		overlay.setSourceRect(rectangle.getImpl());
	}

	/**
	 * Specifies an area of the source image to draw. If omitted, the whole image will be drawn.
	 */
	public Rectangle getSourceRect() {
		return overlay.getSourceRect() != null ? new Rectangle(overlay.getSourceRect()) : null;
	}

	public Bitmap clone() {
		return new Bitmap((BitmapImpl)overlay.clone());
	}
}
