package net.depoker.createjs.easeljs.client.display.impl;

import net.depoker.createjs.easeljs.client.display.DisplayObject;
import com.google.gwt.core.client.JsArray;

import java.util.Comparator;

public class ContainerImpl extends DisplayObjectImpl {

	protected ContainerImpl() {}
	
	public static native ContainerImpl create() /*-{
		return new $wnd.createjs.Container();
	}-*/;

	public final native JsArray<DisplayObjectImpl> getChildren() /*-{
		return this.children;
	}-*/;

	public final native DisplayObjectImpl addChild(DisplayObjectImpl child) /*-{
		return this.addChild(child);
	}-*/;

	public final native DisplayObjectImpl addChildAt(DisplayObjectImpl child, int index) /*-{
		return this.addChildAt(child, index);
	}-*/;

	public final native boolean removeChild(DisplayObjectImpl child) /*-{
		return this.removeChild(child);
	}-*/;

	public final native boolean removeChildAt(int index) /*-{
		return this.removeChildAt(index);
	}-*/;

	public final native void removeAllChildren() /*-{
		this.removeAllChildren();
	}-*/;

	public final native DisplayObjectImpl getChildAt(int index) /*-{
		return this.getChildAt(index);
	}-*/;

	public final native DisplayObjectImpl getChildByName(String name) /*-{
		return this.getChildByName(name);
	}-*/;

	public final native void sortChildren(Comparator<DisplayObject> sortFunction) /*-{
		this.sortChildren(function(a, b) {
			$entry(@net.depoker.createjs.easeljs.client.display.Container::fireSort(Ljava/util/Comparator;Lnet/depoker/createjs/easeljs/client/display/impl/DisplayObjectImpl;Lnet/depoker/createjs/easeljs/client/display/impl/DisplayObjectImpl;)(sortFunction, a, b));
		});
	}-*/;

	public final native int getChildIndex(DisplayObjectImpl child) /*-{
		return this.getChildIndex(child);
	}-*/;

	public final native int getNumChildren() /*-{
		return this.getNumChildren();
	}-*/;

	public final native void swapChildrenAt(int index1, int index2) /*-{
		this.swapChildrenAt(index1, index2);
	}-*/;

	public final native void swapChildren(DisplayObjectImpl child1, DisplayObjectImpl child2) /*-{
		this.swapChildren(child1, child2);
	}-*/;

	public final native void setChildIndex(DisplayObjectImpl child, int index) /*-{
		this.setChildIndex(child, index);
	}-*/;

	public final native boolean contains(DisplayObjectImpl child) /*-{
		return this.contains(child);
	}-*/;

	public final native boolean hitText(double x, double y) /*-{
		return this.hitTest(x, y);
	}-*/;

	public final native JsArray<DisplayObjectImpl> getObjectsUnderPoint(double x, double y) /*-{
		return this.getObjectsUnderPoint(x, y);
	}-*/;

	public final native DisplayObjectImpl getObjectUnderPoint(double x, double y) /*-{
		return this.getObjectUnderPoint(x, y);
	}-*/;

    public final native ContainerImpl clone(boolean recursive) /*-{
        return this.clone(recursive);
    }-*/;

}
