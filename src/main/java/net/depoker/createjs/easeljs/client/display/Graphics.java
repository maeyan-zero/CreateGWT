package net.depoker.createjs.easeljs.client.display;

import java.util.List;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.dom.client.VideoElement;
import com.google.gwt.media.client.Video;
import com.google.gwt.user.client.ui.Image;

import net.depoker.createjs.easeljs.client.display.impl.GraphicsImpl;

public class Graphics {

    public static String REPEAT = "repeat";
    public static String REPEAT_X = "repeat-x";
    public static String REPEAT_Y = "repeat-y";
    public static String NO_REPEAT = "no-repeat";

	private final GraphicsImpl overlay;

    /**
     * Returns a CSS compatible color string based on the specified RGB numeric color values in the format "rgba(255,255,255,1.0)", or if alpha is null then in the format "rgb(255,255,255)". For example,
     * Graphics.getRGB(50,100,150,0.5) will return "rgba(50,100,150,0.5)".
     *
     * @param r The red component for the color, between 0 and 0xFF (255).
     * @param g The green component for the color, between 0 and 0xFF (255).
     * @param b The blue component for the color, between 0 and 0xFF (255).
     */
    public static String getRGB(int r, int g, int b) { return GraphicsImpl.getRGB(r, g, b); }

    /**
     * Returns a CSS compatible color string based on the specified RGB
     * numeric color values in the format "rgba(255,255,255,1.0)", or if
     * alpha is null then in the format "rgb(255,255,255)". For example,
     * Graphics.getRGB(50,100,150,0.5) will return "rgba(50,100,150,0.5)".
     *
     * @param r     The red component for the color, between 0 and 0xFF (255).
     * @param g     The green component for the color, between 0 and 0xFF (255).
     * @param b     The blue component for the color, between 0 and 0xFF (255).
     * @param alpha Optional. The alpha component for the color where 0 is fully transparent and 1 is fully opaque.
     */
    public static String getRGB(int r, int g, int b, double alpha) { return GraphicsImpl.getRGB(r, g, b, alpha); }

    /**
     * Returns a CSS compatible color string based on the specified HSL
     * numeric color values in the format "hsla(360,100,100,1.0)", or
     * if alpha is null then in the format "hsl(360,100,100)". For example,
     * Graphics.getHSL(150,100,70) will return "hsl(150,100,70)".
     *
     * @param hue        The hue component for the color, between 0 and 360.
     * @param saturation The saturation component for the color, between 0 and 100.
     * @param lightness  The lightness component for the color, between 0 and 100.
     */
    public static String getHSL(int hue, int saturation, int lightness) { return GraphicsImpl.getHSL(hue, saturation, lightness); }

    /**
     * Returns a CSS compatible color string based on the specified HSL
     * numeric color values in the format "hsla(360,100,100,1.0)", or if
     * alpha is null then in the format "hsl(360,100,100)". For example,
     * Graphics.getHSL(150,100,70) will return "hsl(150,100,70)".
     *
     * @param hue        The hue component for the color, between 0 and 360.
     * @param saturation The saturation component for the color, between 0 and 100.
     * @param lightness  The lightness component for the color, between 0 and 100.
     * @param alpha      Optional. The alpha component for the color where 0 is fully transparent and 1 is fully opaque.
     */
    public static String getHSL(int hue, int saturation, int lightness, double alpha) { return GraphicsImpl.getHSL(hue, saturation, lightness, alpha); }

    /**
     * The Graphics class exposes an easy to use API for generating vector drawing instructions and drawing them to a
     * specified context. Note that you can use Graphics without any dependency on the Easel framework by calling draw()
     * directly, or it can be used with the Shape object to draw vector graphics within the context of an Easel display
     * list.
     * <pre>
     * var g = new Graphics();
     * g.setStrokeStyle(1);
     * g.beginStroke(Graphics.getRGB(0,0,0));
     * g.beginFill(Graphics.getRGB(255,0,0));
     * g.drawCircle(0,0,3);
     * var s = new Shape(g);
     * s.x = 100;
     * s.y = 100;
     * stage.addChild(s);
     * stage.update();</pre>
     * Note that all drawing methods in Graphics return the Graphics instance, so they can be chained together. For
     * example, the following line of code would generate the instructions to draw a rectangle with a red stroke and
     * blue fill, then render it to the specified context2D:
     * <pre>
     * myGraphics.beginStroke("#F00").beginFill("#00F").drawRect(20, 20, 100, 50).draw(myContext2D);</pre>
     *
     * @param impl The implementation object.
     */
    public Graphics(GraphicsImpl impl) { overlay = impl; }

    /**
     * Draws an arc defined by the radius, startAngle and endAngle arguments, centered at the position (x,y). For example
     * arc(100,100,20,0,Math.PI*2) would draw a full circle with a radius of 20 centered at 100,100. For detailed information,
     * read the <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#complex-shapes-(paths)">whatwg spec</a>.
     *
     * @param x
     * @param y
     * @param radius
     * @param startAngle    Measured in radians.
     * @param endAngle      Measured in radians.
     * @param anticlockwise
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics arc(double x, double y, double radius, double startAngle, double endAngle, boolean anticlockwise) {
        overlay.arc(x, y, radius, startAngle, endAngle, anticlockwise);
        return this;
    }

    /**
     * Draws an arc with the specified control points and radius. For detailed information, read the
     * <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#complex-shapes-(paths)">whatwg spec</a>.
     *
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     * @param radius
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics arcTo(double x1, double y1, double x2, double y2, double radius) {
        overlay.arcTo(x1, y1, x2, y2, radius);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param image The image element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(ImageElement image) {
        overlay.beginBitmapFill(image);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param image  The image element to use as the pattern.
     * @param repeat Indicates whether to repeat the image in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(ImageElement image, String repeat) {
        overlay.beginBitmapFill(image, repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param canvas The canvas element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(CanvasElement canvas) {
        overlay.beginBitmapFill(canvas);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param canvas The canvas element to use as the pattern.
     * @param repeat Indicates whether to repeat the canvas in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(CanvasElement canvas, String repeat) {
        overlay.beginBitmapFill(canvas, repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param video The video element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(VideoElement video) {
        overlay.beginBitmapFill(video);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param video  The video element to use as the pattern.
     * @param repeat Indicates whether to repeat the video in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(VideoElement video, String repeat) {
        overlay.beginBitmapFill(video, repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param image The image element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(Image image) {
        overlay.beginBitmapFill(image.getElement());
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param image  The image element to use as the pattern.
     * @param repeat Indicates whether to repeat the image in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(Image image, String repeat) {
        overlay.beginBitmapFill(image.getElement(), repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param canvas The canvas element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(Canvas canvas) {
        overlay.beginBitmapFill(canvas.getElement());
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param canvas The canvas element to use as the pattern.
     * @param repeat Indicates whether to repeat the canvas in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(Canvas canvas, String repeat) {
        overlay.beginBitmapFill(canvas.getElement(), repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param video The video element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(Video video) {
        overlay.beginBitmapFill(video.getElement());
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param video  The video element to use as the pattern.
     * @param repeat Indicates whether to repeat the video in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapFill(Video video, String repeat) {
        overlay.beginBitmapFill(video.getElement(), repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param image The image element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(ImageElement image) {
        overlay.beginBitmapStroke(image);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param image  The image element to use as the pattern.
     * @param repeat Indicates whether to repeat the image in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(ImageElement image, String repeat) {
        overlay.beginBitmapStroke(image, repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param canvas The canvas element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(CanvasElement canvas) {
        overlay.beginBitmapStroke(canvas);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param canvas The canvas element to use as the pattern.
     * @param repeat Indicates whether to repeat the canvas in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(CanvasElement canvas, String repeat) {
        overlay.beginBitmapStroke(canvas, repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param video The video element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(VideoElement video) {
        overlay.beginBitmapStroke(video);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param video  The video element to use as the pattern.
     * @param repeat Indicates whether to repeat the video in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(VideoElement video, String repeat) {
        overlay.beginBitmapStroke(video, repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param image The image element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(Image image) {
        overlay.beginBitmapFill(image.getElement());
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param image  The image element to use as the pattern.
     * @param repeat Indicates whether to repeat the image in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(Image image, String repeat) {
        overlay.beginBitmapFill(image.getElement(), repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param canvas The canvas element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(Canvas canvas) {
        overlay.beginBitmapFill(canvas.getElement());
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param canvas The canvas element to use as the pattern.
     * @param repeat Indicates whether to repeat the canvas in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(Canvas canvas, String repeat) {
        overlay.beginBitmapFill(canvas.getElement(), repeat);
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param video The video element to use as the pattern.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(Video video) {
        overlay.beginBitmapFill(video.getElement());
        return this;
    }

    /**
     * Begins a pattern fill using the specified image. This ends the current subpath.
     *
     * @param video  The video element to use as the pattern.
     * @param repeat Indicates whether to repeat the video in the fill area. One of "repeat", "repeat-x", "repeat-y",
     *               or "no-repeat". Defaults to "repeat".
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginBitmapStroke(Video video, String repeat) {
        overlay.beginBitmapFill(video.getElement(), repeat);
        return this;
    }

    /**
     * Begins a fill with the specified color. This ends the current subpath.
     *
     * @param color A CSS compatible color value (ex. "#FF0000" or "rgba(255,0,0,0.5)"). Setting to null will result in no fill.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginFill(String color) {
        overlay.beginFill(color);
        return this;
    }

    /**
     * Begins a linear gradient fill defined by the line (x0,y0) to (x1,y1).  This ends the current subpath. For example,
     * the following code defines a black to white vertical gradient ranging from 20px to 120px, and draws a square to
     * display it:
     * <pre>myGraphics.beginLinearGradientFill(["#000","#FFF"], [0,1], 0, 20, 0, 120).drawRect(20,20,120,120)</pre>;
     *
     * @param colors An array of CSS compatible color values. For example, ["#F00","#00F"] would define a gradient
     *               drawing from red to blue.
     * @param ratios An array of gradient positions which correspond to the colors. For example, [0.1,0.9] would draw
     *               the first color to 10% then interpolating to the second color at 90%.
     * @param x0     The position of the first point defining the line that defines the gradient direction and size.
     * @param y0     The position of the first point defining the line that defines the gradient direction and size.
     * @param x1     The position of the second point defining the line that defines the gradient direction and size.
     * @param y1     The position of the second point defining the line that defines the gradient direction and size.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginLinearGradientFill(List<String> colors, List<Float> ratios, double x0, double y0, double x1, double y1) {
        JsArrayNumber r = JavaScriptObject.createArray().cast();
        JsArrayString c = JavaScriptObject.createArray().cast();
        for (Float f : ratios) { r.push(f); }
        for (String s : colors) { c.push(s); }
        overlay.beginLinearGradientFill(c, r, x0, y0, x1, y1);
        return this;
    }

    /**
     * Begins a linear gradient stroke defined by the line (x0, y0) to (x1, y1). This ends the current subpath. For example,
     * the following code defines a black to white vertical gradient ranging from 20px to 120px, and draws a square to display it:
     * <pre>myGraphics.setStrokeStyle(10).beginLinearGradientStroke(["#000","#FFF"], [0, 1], 0, 20, 0, 120).drawRect(20, 20, 120, 120);</pre>
     *
     * @param colors An array of CSS compatible color values. For example, ["#F00","#00F"] would define a gradient
     *               drawing from red to blue.
     * @param ratios An array of gradient positions which correspond to the colors. For example, [0.1, 0.9] would draw
     *               the first color to 10% then interpolating to the second color at 90%.
     * @param x0     The position of the first point defining the line that defines the gradient direction and size.
     * @param y0     The position of the first point defining the line that defines the gradient direction and size.
     * @param x1     The position of the second point defining the line that defines the gradient direction and size.
     * @param y1     The position of the second point defining the line that defines the gradient direction and size.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginLinearGradientStroke(List<String> colors, List<Float> ratios, double x0, double y0, double x1, double y1) {
        JsArrayNumber r = JavaScriptObject.createArray().cast();
        JsArrayString c = JavaScriptObject.createArray().cast();
        for (Float f : ratios) { r.push(f); }
        for (String s : colors) { c.push(s); }
        overlay.beginLinearGradientStroke(c, r, x0, y0, x1, y1);
        return this;
    }

    /**
     * Begins a radial gradient fill. This ends the current subpath.
     * For example, the following code defines a red to blue radial gradient centered
     * at (100,100), with a radius of 50, and draws a circle to display it:<br/>
     * myGraphics.beginRadialGradientFill(["#F00","#00F"], [0,1], 100, 100, 0, 100, 100, 50)
     * .drawCircle(100, 100, 50);
     *
     * @param colors An array of CSS compatible color values. For example, ["#F00","#00F"] would define a gradient drawing from red to blue.
     * @param ratios An array of gradient positions which correspond to the colors. For example, [0.1,0.9] would draw the first color to 10% then interpolating to the second color at 90%.
     * @param x0     Center position of the inner circle that defines the gradient.
     * @param y0     Center position of the inner circle that defines the gradient.
     * @param r0     Radius of the inner circle that defines the gradient.
     * @param x1     Center position of the outer circle that defines the gradient.
     * @param y1     Center position of the outer circle that defines the gradient.
     * @param r1     Radius of the outer circle that defines the gradient.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginRadialGradientFill(List<String> colors, List<Float> ratios, double x0, double y0, double r0, double x1, double y1, double r1) {
        JsArrayNumber r = JavaScriptObject.createArray().cast();
        JsArrayString c = JavaScriptObject.createArray().cast();
        for (Float f : ratios) { r.push(f); }
        for (String s : colors) { c.push(s); }
        overlay.beginRadialGradientFill(c, r, x0, y0, r0, x1, y1, r1);
        return this;
    }

    /**
     * Begins a radial gradient stroke. This ends the current subpath. For example, the following code defines a red to
     * blue radial gradient centered at (100,100), with a radius of 50, and draws a rectangle to display it:<br/>
     * <pre>myGraphics.setStrokeStyle(10).beginRadialGradientStroke(["#F00","#00F"], [0,1], 100, 100, 0, 100, 100, 50).drawRect(50,90,150,110);</pre>
     *
     * @param colors An array of CSS compatible color values. For example, ["#F00","#00F"] would define a gradient drawing from red to blue.
     * @param ratios An array of gradient positions which correspond to the colors. For example, [0.1,0.9] would draw the first color to 10% then interpolating to the second color at 90%, then draw the second color to 100%.
     * @param x0     Center position of the inner circle that defines the gradient.
     * @param y0     Center position of the inner circle that defines the gradient.
     * @param r0     Radius of the inner circle that defines the gradient.
     * @param x1     Center position of the outer circle that defines the gradient.
     * @param y1     Center position of the outer circle that defines the gradient.
     * @param r1     Radius of the outer circle that defines the gradient.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginRadialGradientStroke(List<String> colors, List<Float> ratios, double x0, double y0, double r0, double x1, double y1, double r1) {
	    JsArrayNumber r = JavaScriptObject.createArray().cast();
	    JsArrayString c = JavaScriptObject.createArray().cast();
	    for (Float f : ratios) { r.push(f); }
	    for (String s : colors) { c.push(s); }
        overlay.beginRadialGradientStroke(c, r, x0, y0, r0, x1, y1, r1);
        return this;
    }

    /**
     * Begins a stroke with the specified color. This ends the current subpath.
     *
     * @param color A CSS compatible color value (ex. "#FF0000" or "rgba(255,0,0,0.5)"). Setting to null will result
     *              in no stroke.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics beginStroke(String color) {
        overlay.beginStroke(color);
        return this;
    }

    /**
     * Draws a bezier curve from the current drawing point to (x,y) using the control points (cp1x,cp1y) and (cp2x,cp2y).
     * For detailed information, read the <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#complex-shapes-(paths)">whatwg spec</a>.
     *
     * @param cp1x
     * @param cp1y
     * @param cp2x
     * @param cp2y
     * @param x
     * @param y
     */
    public Graphics bezierCurveTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) {
        overlay.bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y);
        return this;
    }

    /**
     * Clears all drawing instructions, effectively reseting this Graphics instance.
     *
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics clear() {
        overlay.clear();
        return this;
    }

    /**
     * Returns a clone of this Graphics instance.
     *
     * @return A clone of the current Graphics instance.
     */
    public Graphics clone() {
        return new Graphics(overlay.clone());
    }

    /**
     * Closes the current path, effectively drawing a line from the current drawing point to the first drawing point
     * specified since the fill or stroke was last set.
     *
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics closePath() {
        overlay.closePath();
        return this;
    }

    /**
     * Decodes a compact encoded path string into a series of draw instructions. This format is not intended to be human
     * readable, and is meant for use by authoring tools. The format uses a base64 character set, with each character
     * representing 6 bits, to define a series of draw commands.
     * <p/>
     * <p>Each command is comprised of a single "header" character followed by a variable number of alternating x and y
     * position values. Reading the header bits from left to right (most to least significant): bits 1 to 3 specify the
     * type of operation (0-moveTo, 1-lineTo, 2-quadraticCurveTo, 3-bezierCurveTo, 4-7 unused). Bit 4 indicates whether
     * position values use 12 bits (2 characters) or 18 bits (3 characters), with a one indicating the latter. Bits 5
     * and 6 are currently unused.</p>
     * <p/>
     * <p>Following the header is a series of 2 (moveTo, lineTo), 4 (quadraticCurveTo), or 6 (bezierCurveTo) parameters.
     * These parameters are alternating x/y positions represented by 2 or 3 characters (as indicated by the 4th bit in
     * the command char). These characters consist of a 1 bit sign (1 is negative, 0 is positive), followed by an 11
     * (2 char) or 17 (3 char) bit integer value. All position values are in tenths of a pixel. Except in the case of
     * move operations, this value is a delta from the previous x or y position (as appropriate).</p>
     * <p/>
     * <p>For example, the string "A3cAAMAu4AAA" represents a line starting at -150,0 and ending at 150,0. A - bits 000000.
     * First 3 bits (000) indicate a moveTo operation. 4th bit (0) indicates 2 chars per parameter. n0 - 110111011100.
     * Absolute x position of -150.0px. First bit indicates a negative value, remaining bits indicate 1500 tenths of a
     * pixel. AA - 000000000000. Absolute y position of 0. I - 001100. First 3 bits (001) indicate a lineTo operation.
     * 4th bit (1) indicates 3 chars per parameter. Au4 - 000000101110111000. An x delta of 300.0px, which is added to
     * the previous x value of -150.0px to provide an absolute position of +150.0px. AAA - 000000000000000000. A y delta
     * value of 0.</p>
     *
     * @param str The path string to decode.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics decodePath(String str) {
        overlay.decodePath(str);
        return this;
    }

    /**
     * Draws the display object into the specified context ignoring it's visible, alpha, shadow, and transform. Returns
     * true if the draw was handled (useful for overriding functionality). NOTE: This method is mainly for internal use,
     * though it may be useful for advanced uses.
     *
     * @param ctx The canvas 2D context object to draw into.
     */
    public void draw(CanvasElement ctx) {
        overlay.draw(ctx.getContext2d());
    }

    /**
     * Draws a circle with the specified radius at (x,y).
     * <pre>
     * var g = new Graphics();
     * g.setStrokeStyle(1);
     * g.beginStroke(Graphics.getRGB(0,0,0));
     * g.beginFill(Graphics.getRGB(255,0,0));
     * g.drawCircle(0,0,3);
     * var s = new Shape(g);
     * s.x = 100;
     * s.y = 100;
     * stage.addChild(s);
     * stage.update();</pre>
     *
     * @param x      coordinate center point of circle.
     * @param y      coordinate center point of circle.
     * @param radius Radius of circle.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics drawCircle(double x, double y, double radius) {
        overlay.drawCircle(x, y, radius);
        return this;
    }

    /**
     * Draws an ellipse (oval).
     *
     * @param x
     * @param y
     * @param w
     * @param h
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics drawEllipse(double x, double y, double w, double h) {
        overlay.drawEllipse(x, y, w, h);
        return this;
    }

    /**
     * Draws a star if pointSize is greater than 0 or a regular polygon if pointSize is 0 with the specified number of points.
     * For example, the following code will draw a familiar 5 pointed star shape centered at 100,100 and with a radius of 50:
     * myGraphics.beginFill("#FF0").drawPolyStar(100, 100, 50, 5, 0.6, -90); // -90 makes the first point vertical
     *
     * @param x         Position of the center of the shape.
     * @param y         Position of the center of the shape.
     * @param radius    The outer radius of the shape.
     * @param sides     The number of points on the star or sides on the polygon.
     * @param pointSize The depth or "pointy-ness" of the star points. A pointSize of 0 will draw a regular polygon (no points), a pointSize of 1 will draw nothing because the points are infinitely pointy.
     * @param angle     The angle of the first point / corner. For example a value of 0 will draw the first point directly to the right of the center.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics drawPolyStar(double x, double y, double radius, int sides, double pointSize, double angle) {
        overlay.drawPolyStar(x, y, radius, sides, pointSize, angle);
        return this;
    }

    /**
     * Draws a rounded rectangle with all corners with the specified radius.
     *
     * @param x
     * @param y
     * @param w
     * @param h
     * @param radius Corner radius.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics drawRoundRect(double x, double y, double w, double h, double radius) {
        overlay.drawRoundRect(x, y, w, h, radius);
        return this;
    }

    /**
     * Draws a rounded rectangle with different corner radiuses.
     *
     * @param x
     * @param y
     * @param w
     * @param h
     * @param radiusTL Top left corner radius.
     * @param radiusTR Top right corner radius.
     * @param radiusBR Bottom right corner radius.
     * @param radiusBL Bottom left corner radius.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics drawRoundRectComplex(double x, double y, double w, double h, double radiusTL, double radiusTR, double radiusBR, double radiusBL) {
        overlay.drawRoundRectComplex(x, y, w, h, radiusTL, radiusTR, radiusBR, radiusBL);
        return this;
    }

    /**
     * Ends the current subpath, and begins a new one with no fill. Functionally identical to beginFill(null).
     *
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics endFill() {
        overlay.endFill();
        return this;
    }

    /**
     * Ends the current subpath, and begins a new one with no stroke. Functionally identical to beginStroke(null).
     *
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics endStroke() {
        overlay.endStroke();
        return this;
    }

    /**
     * Draws a line from the current drawing point to the specified position, which become the new current drawing point.
     * For detailed information, read the <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#complex-shapes-(paths)">whatwg spec</a>.
     *
     * @param x The x coordinate the drawing point should draw to.
     * @param y The y coordinate the drawing point should draw to.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics lineTo(double x, double y) {
        overlay.lineTo(x, y);
        return this;
    }

    /**
     * Moves the drawing point to the specified position.
     *
     * @param x The x coordinate the drawing point should move to.
     * @param y The y coordinate the drawing point should move to.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics moveTo(double x, double y) {
        overlay.moveTo(x, y);
        return this;
    }

    /**
     * Draws a quadratic curve from the current drawing point to (x,y) using the control point (cpx,cpy). For detailed
     * information, read the <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#complex-shapes-(paths)">whatwg spec</a>.
     *
     * @param cpx
     * @param cpy
     * @param x
     * @param y
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics quadraticCurveTo(double cpx, double cpy, double x, double y) {
        overlay.quadraticCurveTo(cpx, cpy, x, y);
        return this;
    }

    /**
     * Draws a rectangle at (x,y) with the specified width and height using the current fill and/or stroke.
     * For detailed information, read the <a href="http://www.whatwg.org/specs/web-apps/current-work/multipage/the-canvas-element.html#complex-shapes-(paths)">whatwg spec</a>.
     *
     * @param x
     * @param y
     * @param w Width of the rectangle
     * @param h Height of the rectangle
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics rect(double x, double y, double w, double h) {
        overlay.rect(x, y, w, h);
        return this;
    }

    /**
     * Sets the stroke style for the current subpath. Like all drawing methods, this can be chained, so you can define
     * the stroke style and color in a single line of code like so:
     * <pre>myGraphics.setStrokeStyle(8).beginStroke("#F00");</pre>
     *
     * @param thickness The width of the stroke.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics setStrokeStyle(double thickness) {
        overlay.setStrokeStyle(thickness);
        return this;
    }

    /**
     * Sets the stroke style for the current subpath. Like all drawing methods, this can be chained, so you can define
     * the stroke style and color in a single line of code like so:
     * <pre>myGraphics.setStrokeStyle(8,"round").beginStroke("#F00");</pre>
     *
     * @param thickness  The width of the stroke.
     * @param caps       Indicates the type of caps to use at the end of lines. One of butt, round, or square. Defaults to "butt".
     * @param joints     Specifies the type of joints that should be used where two lines meet. One of bevel, round, or miter. Defaults to "miter".
     * @param miterLimit If joints is set to "miter", then you can specify a miter limit ratio which controls at what point a mitered joint will be clipped.
     * @return The Graphics instance the method is called on (useful for chaining calls.)
     */
    public Graphics setStrokeStyle(double thickness, String caps, String joints, String miterLimit) {
        overlay.setStrokeStyle(thickness, caps, joints, miterLimit);
        return this;
    }

}
