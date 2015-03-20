package net.depoker.createjs.easeljs.client.filter;

import net.depoker.createjs.easeljs.client.filter.impl.ColorMatrixFilterImpl;
import com.google.gwt.canvas.dom.client.Context2d;

public class ColorMatrixFilter extends Filter
{
	private ColorMatrixFilterImpl overlay;

	public ColorMatrixFilter() {
		overlay = ColorMatrixFilterImpl.create();
	}

	public ColorMatrixFilter(ColorMatrix matrix) {
		overlay = ColorMatrixFilterImpl.create(matrix.getOverlay());
	}

	@Override
	public boolean applyFilter(Context2d ctx, double x, double y, double width, double height) {
		return overlay.applyFilter(ctx, (float) x, (float) y, (float) width, (float) height);
	}

	@Override
	public ColorMatrixFilterImpl getOverlay() {
		return overlay;
	}
}
