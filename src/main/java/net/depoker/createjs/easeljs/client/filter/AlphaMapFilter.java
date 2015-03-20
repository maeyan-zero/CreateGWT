package net.depoker.createjs.easeljs.client.filter;

import net.depoker.createjs.easeljs.client.filter.impl.AlphaMapFilterImpl;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;

public class AlphaMapFilter extends Filter
{
	private AlphaMapFilterImpl overlay;

	public AlphaMapFilter(ImageElement alphaMap) {
		overlay = AlphaMapFilterImpl.create(alphaMap);
	}

	public AlphaMapFilter(CanvasElement alphaMap) {
		overlay = AlphaMapFilterImpl.create(alphaMap);
	}

	@Override
	public AlphaMapFilterImpl getOverlay() {
		return overlay;
	}

	@Override
	public boolean applyFilter(Context2d ctx, double x, double y, double width, double height) {
		return overlay.applyFilter(ctx, (float) x, (float) y, (float) width, (float) height);
	}
}
