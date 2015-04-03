package net.depoker.createjs.easeljs.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.HTMLPanel;
import net.depoker.createjs.easeljs.client.display.Stage;

/**
 * GWT implementation of EaselJS - see www.createjs.com
 */
public class EaselJs extends HTMLPanel
{
	/** The GWT Stage implementation. Each canvas has one stage only. */
	protected final Stage stage;

	public EaselJs()
	{
		this(null);
	}

	public EaselJs(String html)
	{
		super("canvas", html);
		stage = new Stage(getElement());
	}

	/**
	 * Create a new EaselJS canvas with a drawing area in the given dimensions.
	 *
	 * @param width  The default width of the drawing area in pixels.
	 * @param height The default height of the drawing area in pixels.
	 */
	public EaselJs(int width, int height)
	{
		this(null);
		setWidth(width + "px");
		setHeight(height + "px");
	}

	/**
	 * Returns the Stage.
	 *
	 * @return The EaselJs Stage for this instance.
	 */
	public Stage getStage()
	{
		return stage;
	}

	/**
	 * Sets the drawing area width of the canvas.
	 *
	 * @param width The width in pixels.
	 */
	public void setCanvasWidth(int width)
	{
		CanvasElement canvas = getElement().cast();
		canvas.setWidth(width);
	}

	/**
	 * Sets the drawing area height of the canvas.
	 *
	 * @param height The width in pixels.
	 */
	public void setCanvasHeight(int height)
	{
		CanvasElement canvas = getElement().cast();
		canvas.setHeight(height);
	}

	/**
	 * Ensures the EaselJs javascript libraries have been injected into the DOM.
	 * This must be called once before invoking any library methods to avoid a undefined type exception.
	 * The DOM will only be manipulated if the library has not been injected yet.
	 *
	 * @return True if this method manipulated the DOM
	 */
	public static boolean ensureInjected() {
		if (!EaselJs.isInjected()) {
			ScriptInjector.fromString(Resources.INSTANCE.easelJs().getText())
			              .setWindow(ScriptInjector.TOP_WINDOW)
			              .inject();
			return true;
		}
		return false;
	}

	/**
	 * Checks if the EaselJs type definitions are defined, determining if the
	 * javascript library has been injected yet.
	 *
	 * @return True if EaselJs has been injected
	 */
	private static native boolean isInjected() /*-{
		// check namespace first
		if ((typeof $wnd.createjs === "undefined") || (null === $wnd.createjs)) return false;
		// namespace exists, assume if DisplayObject is defined then the entire easeljs lib is injected
		return (!(typeof $wnd.createjs.DisplayObject === "undefined") && !(null === $wnd.createjs.DisplayObject));
	}-*/;

	/**
	 * Provides the underlying javascript source libraries required by the wrapper.
	 */
	public interface Resources extends ClientBundle  {
		Resources INSTANCE = GWT.create(Resources.class);

		@Source("easeljs-0.7.1.min.js")
		TextResource easelJs();
	}
}
