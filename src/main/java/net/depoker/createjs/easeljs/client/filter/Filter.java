package net.depoker.createjs.easeljs.client.filter;

import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class Filter
{
	public abstract boolean applyFilter(Context2d ctx, double x, double y, double width, double height);

	public abstract JavaScriptObject getOverlay();
}
