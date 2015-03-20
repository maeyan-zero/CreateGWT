package net.depoker.createjs.easeljs.client.display.impl;

import net.depoker.createjs.easeljs.client.geom.impl.Matrix2DImpl;
import net.depoker.createjs.easeljs.client.geom.impl.PointImpl;
import net.depoker.createjs.easeljs.client.helper.Handler;
import net.depoker.createjs.easeljs.client.helper.MouseCallback;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.dom.client.CanvasElement;

public class DisplayObjectImpl extends JavaScriptObject {

	protected DisplayObjectImpl() { }

	public final native double getAlpha() /*-{
		return this.alpha;
	}-*/;

	public final native void setAlpha(double alpha) /*-{
		this.alpha = alpha;
	}-*/;

	public final native CanvasElement getCacheCanvas() /*-{
		return this.cacheCanvas;
	}-*/;

	public final native int getId() /*-{
		return this.id;
	}-*/;

	public final native void setId(int id) /*-{
		this.id = id;
	}-*/;

	public final native boolean getMouseEnabled() /*-{
		return this.mouseEnabled;
	}-*/;

	public final native void setMouseEnabled(boolean enabled) /*-{
		this.mouseEnabled = enabled;
	}-*/;

	public final native String getName() /*-{
		return this.name;
	}-*/;
	
	public final native void setName(String name) /*-{
		this.name = name;
	}-*/;

	public final native ContainerImpl getParent() /*-{
		return this.parent;
	}-*/;

	public final native double getRegX() /*-{
		return this.regX;
	}-*/;
	
	public final native void setRegX(double x) /*-{
		this.regX = x;
	}-*/;

	public final native double getRegY() /*-{
		return this.regY;
	}-*/;
	
	public final native void setRegY(double y) /*-{
		this.regY = y;
	}-*/;

	public final native double getRotation() /*-{
		return this.rotation;
	}-*/;
	
	public final native void setRotation(double degrees) /*-{
		this.rotation = degrees;
	}-*/;

	public final native double getScaleX() /*-{
		return this.scaleX;
	}-*/;
	
	public final native void setScaleX(double scaleX) /*-{
		this.scaleX = scaleX;
	}-*/;

	public final native double getScaleY() /*-{
		return this.scaleY;
	}-*/;
	
	public final native void setScaleY(double scaleY) /*-{
		this.scaleY = scaleY;
	}-*/;

	public final native void setSkewX(double x) /*-{
		this.skewX = x;
	}-*/;

	public final native double getSkewX() /*-{
		return this.skewX;
	}-*/;

	public final native void setSkewY(double y) /*-{
		this.skewY = y;
	}-*/;

	public final native double getSkewY() /*-{
		return this.skewY;
	}-*/;

	public final native ShadowImpl getShadow() /*-{
		return this.shadow;
	}-*/;
	
	public final native void setShadow(ShadowImpl shadow) /*-{
		this.shadow = shadow;
	}-*/;
	
	public final native boolean isVisible() /*-{
		return this.isVisible();
	}-*/;

	public final native boolean getVisible() /*-{
		return this.visible;
	}-*/;

	public final native void setVisible(boolean visible) /*-{
		this.visible = visible;
	}-*/;

	public final native double getX() /*-{
		return this.x;
	}-*/;
	
	public final native void setX(double x) /*-{
		this.x = x;
	}-*/;
	
	public final native double getY() /*-{
		return this.y;
	}-*/;
	
	public final native void setY(double y) /*-{
		this.y = y;
	}-*/;

	public final native void setCompositeOperation(String value) /*-{
		this.compositeOperation = value;
	}-*/;

	public final native String getCompositeOperation() /*-{
		return this.compositeOperation;
	}-*/;

	public final native boolean getSnapToPixel() /*-{
		return this.snapToPixel;
	}-*/;

	public final native void setSnapToPixel(boolean snap) /*-{
		this.snapToPixel = snap;
	}-*/;

	public final native void setCursor(String cursor) /*-{
		this.cursor = cursor;
	}-*/;

	public final native String getCursor() /*-{
		return this.cursor;
	}-*/;

	public final native DisplayObjectImpl getHitArea() /*-{
		return this.hitArea;
	}-*/;

	public final native void setHitArea(DisplayObjectImpl hitArea) /*-{
		this.hitArea = hitArea;
	}-*/;

	public final native void cache(double x, double y, double w, double h) /*-{
		this.cache(x, y, w, h);
	}-*/;

	public final native void cache(double x, double y, double w, double h, double scale) /*-{
		this.cache(x, y, w, h, scale);
	}-*/;
	
	public final native void draw(JavaScriptObject ctx, boolean ignoreCache) /*-{
		this.draw(ctx, ignoreCache);
	}-*/;
	
	public final native void uncache() /*-{
		this.uncache();
	}-*/;

	public final native DisplayObjectImpl clone() /*-{
		return this.clone();
	}-*/;

    public static native boolean getSuppressCrossDomainErrors() /*-{
        return this.getSuppressCrossDomainErrors;
    }-*/;

    public static native void setSuppressCrossDomainErrors(boolean value) /*-{
        this.getSuppressCrossDomainErrors = value;
    }-*/;

    public final native void updateCache(String compositeOperation) /*-{
        this.updateCache(compositeOperation);
    }-*/;

    public final native void setMask(ShapeImpl mask) /*-{
    	this.mask = mask;
    }-*/;
    
    public final native ShapeImpl getMask() /*-{
    	return this.mask;
    }-*/;

	public final native JsArray<JavaScriptObject> getFilters() /*-{
		return this.filters;
	}-*/;

	public final native void setFilters(JsArray<JavaScriptObject> filters) /*-{
		this.filters = filters;
	}-*/;

	public final native int getCacheId() /*-{
		return this.cacheID;
	}-*/;

	public final native String getCacheDataURL() /*-{
		return this.getCacheDataURL();
	}-*/;

	public final native Matrix2DImpl getConcatenatedMatrix(JavaScriptObject mtx) /*-{
		return this.getConcatenatedMatrix(mtx);
	}-*/;

	public final native StageImpl getStage() /*-{
		return this.stage;
	}-*/;

	public final native PointImpl globalToLobal(int x, int y) /*-{
		return this.globalToLocal(x, y);
	}-*/;

	public final native boolean hitTest(int x, int y) /*-{
		return this.hitTest(x, y);
	}-*/;

	public final native PointImpl localToGlobal(int x, int y) /*-{
		return this.localToGlobal(x, y);
	}-*/;

	public final native PointImpl localToLocal(int x, int y, JavaScriptObject target) /*-{
		return this.localToLocal(x, y, target);
	}-*/;

	public final native void setTransform(double x, double y, double scaleX, double scaleY, double rotation, double skewX, double skewY, double regX, double regY) /*-{
		this.setTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
	}-*/;

	public final native void addEventListener(String eventName, Handler handler) /*-{
		this.addEventListener(eventName, function(params) {
			$entry(handler.@net.depoker.createjs.easeljs.client.helper.Handler::handle(Lcom/google/gwt/core/client/JavaScriptObject;)(params));
		});
	}-*/;

	public final native void addEventListener(String eventName, MouseCallback cb) /*-{
		this.addEventListener(eventName, function(event) {
			$entry(@net.depoker.createjs.easeljs.client.display.DisplayObject::fireMouseEvent(Lnet/depoker/createjs/easeljs/client/helper/MouseCallback;Lnet/depoker/createjs/easeljs/client/event/impl/MouseEventImpl;)(cb,event));
		});
	}-*/;

	public final native void dispatchEvent(String event) /*-{
		this.dispatchEvent(event);
	}-*/;

	public final native void dispatchEvent(String event, JavaScriptObject target) /*-{
		this.dispatchEvent(event, target);
	}-*/;

	public final native boolean hasEventListener(String type) /*-{
		return this.hasEventListener(type);
	}-*/;

	public final native void removeAllEventListeners() /*-{
		this.removeAllEventListeners();
	}-*/;

	public final native void removeAllEventListeners(String type) /*-{
		this.removeAllEventListeners(type);
	}-*/;

	public final native void set(JavaScriptObject props) /*-{
		this.set(props);
	}-*/;

	public final native void updateContext(JavaScriptObject ctx) /*-{
		this.updateContext(ctx);
	}-*/;

	public final native String toStringDisplayObject() /*-{
		return this.toString();
	}-*/;

	public final native String getPrototype() /*-{
	    return Object.prototype.toString.call(this);
	}-*/;

}
