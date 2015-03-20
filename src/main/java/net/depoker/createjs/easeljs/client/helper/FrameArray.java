package net.depoker.createjs.easeljs.client.helper;

import com.google.gwt.core.client.JsArrayInteger;

public class FrameArray {

	JsArrayInteger impl;
	
	public FrameArray(JsArrayInteger array) {
		impl = array;
	}
	
	public int getX() {
		return impl.get(0);
	}
	
	public int getY() {
		return impl.get(1);
	}
	
	public int getWidth() {
		return impl.get(2);
	}
	
	public int getHeight() {
		return impl.get(3);
	}
	
	public int getImageIndex() {
		return impl.get(4);
	}
	
	public int getRegX() {
		return impl.get(5);
	}
	
	public int getRegY() {
		return impl.get(6);
	}
	
}
