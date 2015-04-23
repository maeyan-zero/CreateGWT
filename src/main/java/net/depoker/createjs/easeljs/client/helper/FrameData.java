/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.easeljs.client.helper;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.easeljs.client.helper.impl.FrameDataImpl;
import org.jetbrains.annotations.NotNull;

public class FrameData {

	private FrameDataImpl impl;

	public FrameData(int width, int height, int count, int regX, int regY) {
		impl = JavaScriptObject.createObject().cast();
		impl.setWidth(width);
		impl.setHeight(height);
		impl.setCount(count);
		impl.setRegX(regX);
		impl.setRegY(regY);
	}

	public FrameData(@NotNull JavaScriptObject impl) {
		this.impl = impl.cast();
	}

	public FrameDataImpl getOverlay() {
		return impl;
	}

	public double getWidth() {
		return impl.getWidth();
	}

	public void setWidth(double width) {
		impl.setWidth( width );
	}

	public double getHeight() {
		return impl.getHeight();
	}

	public void setHeight(double height ) {
		impl.setHeight( height );
	}

	public int getCount() {
		return impl.getCount();
	}

	public double getRegX() {
		return impl.getRegX();
	}

	public void setRegX(double regX) {
		impl.setRegX( regX );
	}

	public double getRegY() {
		return impl.getRegY();
	}

	public void setRegY(double regY) {
		impl.setRegY( regY );
	}
}
