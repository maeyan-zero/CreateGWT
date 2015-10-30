package net.depoker.createjs.easeljs.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import net.depoker.createjs.easeljs.client.display.Stage;

/**
 * GWT implementation of EaselJS - see www.createjs.com
 */
public class EaselJs extends Composite {

	/** The GWT Stage implementation. Each canvas has one stage only. */
	protected final Canvas canvas;
	protected final Stage stage;

	public EaselJs() {
		this( Canvas.createIfSupported() );
	}

	public EaselJs(CanvasElement element) {
		this( Canvas.wrap( element ) );
	}

	/**
	 * Create a new EaselJS canvas with a drawing area in the given dimensions.
	 *
	 * @param width  The default width of the drawing area in pixels.
	 * @param height The default height of the drawing area in pixels.
	 */
	public EaselJs(int width, int height) {
		this();
		setWidth(width + "px");
		setHeight(height + "px");
	}

	protected EaselJs(Canvas canvas) {
		this.canvas = canvas;

		if (canvas != null) {
			initWidget( canvas );
			stage = new Stage( getElement() );
		} else {
			initWidget( new HTML( "Your browser does not support HTML5." ) );
			stage = null;
		}
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

	public void add(Widget widget) {
		getElement().appendChild( widget.getElement() );
	}

	public void remove(Widget widget) {
		getElement().removeChild( widget.getElement() );
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

		@Source("easeljs-0.8.0.combined.js")
		TextResource easelJs();
	}
}
