/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.easeljs.client.geom;

import net.depoker.createjs.easeljs.client.geom.impl.RectangleImpl;

public class Rectangle {

	protected RectangleImpl impl;

	public Rectangle() {
		this(RectangleImpl.create());
	}
	public Rectangle(double x, double y, double w, double h) {
		this(RectangleImpl.create(x, y, w, h));
	}
	public Rectangle(RectangleImpl impl) {
		setImpl(impl);
	}

	public Rectangle clone() {
		return new Rectangle(impl.clone());
	}

	public double getX() {
		return impl.getX();
	}

	public double getY() {
		return impl.getY();
	}

	public double getWidth() {
		return impl.getWidth();
	}

	public double getHeight() {
		return impl.getHeight();
	}

	public RectangleImpl getImpl() {
		return impl;
	}

	public void setX(double value) {
		impl.setX(value);
	}

	public void setY(double value) {
		impl.setY(value);
	}

	public void setWidth(double value) {
		impl.setWidth(value);
	}

	public void setHeight(double value) {
		impl.setHeight(value);
	}

	public void setImpl(RectangleImpl impl) {
		this.impl = impl;
	}

}
