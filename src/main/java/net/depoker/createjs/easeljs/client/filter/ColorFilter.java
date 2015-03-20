package net.depoker.createjs.easeljs.client.filter;

import net.depoker.createjs.easeljs.client.filter.impl.ColorFilterImpl;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;

public class ColorFilter extends Filter
{
	private ColorFilterImpl overlay;

	public ColorFilter(double redMultiplier, double greenMultiplier, double blueMultiplier)
	{
		overlay = ColorFilterImpl.create(redMultiplier, greenMultiplier, blueMultiplier);
	}

	public ColorFilter(int redMultiplier, int  greenMultiplier, int blueMultiplier, double alphaMultiplier,
	                   int redOffset, int greenOffset, int blueOffset, double alphaOffset)
	{
		overlay = ColorFilterImpl.create(redMultiplier, greenMultiplier, blueMultiplier, (float) alphaMultiplier,
		                                 redOffset, greenOffset, blueOffset, (float) alphaOffset);
	}

	@Override
	public boolean applyFilter(Context2d ctx, double x, double y, double width, double height)
	{
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public JavaScriptObject getOverlay()
	{
		return overlay;
	}

	public void setRedMultiplier(double value)
	{
		overlay.setRedMultiplier(value);
	}

	public void setBlueMultiplier(double value)
	{
		overlay.setBlueMultiplier(value);
	}

	public void setGreenMultiplier(double value)
	{
		overlay.setGreenMultiplier(value);
	}
}
