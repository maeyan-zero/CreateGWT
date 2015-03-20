package net.depoker.createjs.easeljs.client.filter;

import net.depoker.createjs.easeljs.client.filter.impl.AlphaMaskFilterImpl;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;

public class AlphaMaskFilter extends Filter
{
	private AlphaMaskFilterImpl overlay;

	public AlphaMaskFilter(ImageElement mask) {
		overlay = AlphaMaskFilterImpl.create(mask);
	}

	public AlphaMaskFilter(CanvasElement mask) {
		overlay = AlphaMaskFilterImpl.create(mask);
	}

	@Override
	public AlphaMaskFilterImpl getOverlay() {
		return overlay;
	}

	@Override
	public boolean applyFilter(Context2d ctx, double x, double y, double width, double height) {
		return overlay.applyFilter(ctx, (float) x, (float) y, (float) width, (float) height);
	}
}
