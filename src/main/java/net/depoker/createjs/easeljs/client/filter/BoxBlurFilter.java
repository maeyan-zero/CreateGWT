package net.depoker.createjs.easeljs.client.filter;

import net.depoker.createjs.easeljs.client.filter.impl.BoxBlurFilterImpl;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.JavaScriptObject;

public class BoxBlurFilter extends Filter
{
	private final BoxBlurFilterImpl overlay;

	public BoxBlurFilter(float blurX, float blurY, float quality) {
		overlay = BoxBlurFilterImpl.create(blurX, blurY, quality);
	}

	@Override
	public boolean applyFilter(Context2d ctx, double x, double y, double width, double height) {
		return overlay.applyFilter(ctx, (float) x, (float) y, (float) width, (float) height);
	}

	@Override
	public JavaScriptObject getOverlay() {
		return overlay;
	}
}
