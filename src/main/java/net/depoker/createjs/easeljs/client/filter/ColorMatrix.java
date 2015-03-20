package net.depoker.createjs.easeljs.client.filter;

import net.depoker.createjs.easeljs.client.filter.impl.ColorMatrixImpl;

public class ColorMatrix
{
	private ColorMatrixImpl overlay;

	public ColorMatrix() {
		overlay = ColorMatrixImpl.create();
	}

	public ColorMatrix(ColorMatrixImpl impl) {
		overlay = impl;
	}

	public ColorMatrix(float brightness, float contrast, float saturation, float hue) {
		overlay = ColorMatrixImpl.create(brightness, contrast, saturation, hue);
	}

	public ColorMatrixImpl getOverlay() {
		return overlay;
	}

	public ColorMatrix adjustColor(float brightness, float contrast, float saturation, float hue) {
		return new ColorMatrix(overlay.adjustColor(brightness, contrast, saturation, hue));
	}
}
