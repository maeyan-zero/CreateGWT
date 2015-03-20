package net.depoker.createjs.easeljs.client.display.impl;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayNumber;
import com.google.gwt.core.client.JsArrayString;

public class GraphicsImpl extends JavaScriptObject {

	protected GraphicsImpl() {}

	public static final native String getRGB(int r, int g, int b) /*-{
		return $wnd.createjs.Graphics.getRGB(r, g, b);
	}-*/;

	public static final native String getRGB(int r, int g, int b, double alpha) /*-{
		return $wnd.createjs.Graphics.getRGB(r, g, b, alpha);
	}-*/;

	public static final native String getHSL(int hue, int saturation, int lightness) /*-{
		return $wnd.createjs.Graphics.getHSL(hue, saturation, lightness);
	}-*/;

	public static final native String getHSL(int hue, int saturation, int lightness, double alpha) /*-{
		return $wnd.createjs.Graphics.getHSL(hue, saturation, lightness, alpha);
	}-*/;
	
	public final native GraphicsImpl clear() /*-{
		return this.clear();
	}-*/;

	public final native GraphicsImpl beginBitmapFill(JavaScriptObject image) /*-{
		return this.beginBitmapFill(image);
	}-*/;
	
	public final native GraphicsImpl beginBitmapFill(JavaScriptObject image, String repetition) /*-{
		return this.beginBitmapFill(image, repetition);
	}-*/;
	
	public final native GraphicsImpl beginFill(String color) /*-{
		return this.beginFill(color);
	}-*/;
	
	public final native GraphicsImpl beginStroke(String color) /*-{
		return this.beginStroke(color);
	}-*/;

    public final native GraphicsImpl clone() /*-{
        return this.clone();
    }-*/;

    public final native GraphicsImpl decodePath(String str) /*-{
        return this.decodePath(str);
    }-*/;

    public final native GraphicsImpl endFill() /*-{
		return this.endFill();
	}-*/;
	
	public final native GraphicsImpl endStroke() /*-{
		return this.endStroke();
	}-*/;
	
	public final native GraphicsImpl moveTo(double x, double y) /*-{
		return this.moveTo(x, y);
	}-*/;
	
	public final native GraphicsImpl lineTo(double x, double y) /*-{
		return this.lineTo(x, y);
	}-*/;

	public final native GraphicsImpl arcTo(double x1, double y1, double x2, double y2, double radius) /*-{
		return this.arcTo(x1, y1, x2, y2, radius);
	}-*/;

	public final native GraphicsImpl arc(double x, double y, double radius, double startAngle, double endAngle, boolean anticlockwise) /*-{
		return this.arc(x, y, radius, startAngle, endAngle, anticlockwise);
	}-*/;

	public final native GraphicsImpl quadraticCurveTo(double cpx, double cpy, double x, double y) /*-{
		return this.quadraticCurveTo(cpx, cpy, x, y);
	}-*/;

	public final native GraphicsImpl bezierCurveTo(double cp1x, double cp1y, double cp2x, double cp2y, double x, double y) /*-{
		return this.bezierCurveTo(cp1x, cp1y, cp2x, cp2y, x, y);
	}-*/;

	public final native GraphicsImpl rect(double x, double y, double w, double h) /*-{
		return this.rect(x, y, w, h);
	}-*/;

	public final native GraphicsImpl setStrokeStyle(double thickness) /*-{
		return this.setStrokeStyle(thickness);
	}-*/;

	public final native GraphicsImpl closePath() /*-{
		return this.closePath();
	}-*/;

    public final native void draw(Context2d ctx) /*-{
        this.draw(ctx);
    }-*/;

	public final native GraphicsImpl beginLinearGradientFill(JsArrayString colors, JsArrayNumber ratios, double x0, double y0, double x1, double y1) /*-{
		return this.beginLinearGradientFill(colors, ratios, x0, y0, x1, y1);
	}-*/;

	public final native GraphicsImpl beginRadialGradientFill(JsArrayString colors, JsArrayNumber ratios, double x0, double y0, double r0, double x1, double y1, double r1) /*-{
		return this.beginRadialGradientFill(colors, ratios, x0, y0, r0, x1, y1, r1);
	}-*/;

	public final native GraphicsImpl beginLinearGradientStroke(JsArrayString colors, JsArrayNumber ratios, double x0, double y0, double x1, double y1) /*-{
		return this.beginLinearGradientStroke(colors, ratios, x0, y0, x1, y1);
	}-*/;

	public final native GraphicsImpl beginRadialGradientStroke(JsArrayString colors, JsArrayNumber ratios, double x0, double y0, double r0, double x1, double y1, double r1) /*-{
		return this.beginRadialGradientStroke(colors, ratios, x0, y0, r0, x1, y1, r1);
	}-*/;

	public final native GraphicsImpl beginBitmapStroke(JavaScriptObject image) /*-{
		return this.beginBitmapStroke(image, "repeat");
	}-*/;

	public final native GraphicsImpl beginBitmapStroke(JavaScriptObject image, String repetition) /*-{
		return this.beginBitmapStroke(image, repetition);
	}-*/;

	public final native GraphicsImpl drawRoundRect(double x, double y, double w, double h, double radius) /*-{
		return this.drawRoundRect(x, y, w, h, radius);
	}-*/;

	public final native GraphicsImpl drawRoundRectComplex(double x, double y, double w, double h, double radiusTL, double radiusTR, double radiusBR, double radiusBL) /*-{
		return this.drawRoundRectComplex(x, y, w, h, radiusTL, radiusTR, radiusBR, radiusBL);
	}-*/;

	public final native GraphicsImpl drawCircle(double x, double y, double radius) /*-{
		return this.drawCircle(x, y, radius);
	}-*/;

	public final native GraphicsImpl drawEllipse(double x, double y, double w, double h) /*-{
		return this.drawEllipse(x, y, w, h);
	}-*/;

	public final native GraphicsImpl drawPolyStar(double x, double y, double radius, int sides, double pointSize, double angle) /*-{
		return this.drawPolyStar(x, y, radius, sides, pointSize, angle);
	}-*/;

	public final native GraphicsImpl setStrokeStyle(double thickness, String caps, String joints, String miterLimit) /*-{
		return this.setStrokeStyle(thickness, caps, joints, miterLimit);
	}-*/;

}