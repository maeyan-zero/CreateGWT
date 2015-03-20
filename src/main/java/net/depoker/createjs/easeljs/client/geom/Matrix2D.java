package net.depoker.createjs.easeljs.client.geom;

import net.depoker.createjs.easeljs.client.display.Shadow;
import net.depoker.createjs.easeljs.client.geom.impl.Matrix2DImpl;

public class Matrix2D {
	
	protected Matrix2DImpl impl;
	
	public Matrix2D() {
		this(Matrix2DImpl.create());
	}
	public Matrix2D(float a, float b,
			float c, float d,
			float tx, float ty) {
		this(Matrix2DImpl.create(a, b, c, d, tx, ty));
	}
	public Matrix2D(Matrix2DImpl impl) {
		setImpl(impl);
	}
	
	public void prepend(
			float a, float b,
			float c, float d,
			float tx, float ty) {
		impl.prepend(a, b, c, d, tx, ty);
	}
	
	public void append(
			float a, float b,
			float c, float d,
			float tx, float ty) {
		impl.append(a, b, c, d, tx, ty);
	}
	
	public void prependMatrix(Matrix2D matrix) {
		impl.prependMatrix(matrix.impl);
	}
	
	public void appendMatrix(Matrix2D matrix) {
		impl.appendMatrix(matrix.impl);
	}
	
	public void prependTransform(
			float x, float y,
			float scaleX, float scaleY,
			float rotation, float skewX,
			float skewY, float regX, float regY) {
		impl.prependTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
	}
	
	public void appendTransform(
			float x, float y,
			float scaleX, float scaleY,
			float rotation, float skewX,
			float skewY, float regX, float regY) {
		impl.appendTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
	}
	
	public void skew(float skewX, float skewY) {
		impl.skew(skewX, skewY);
	}
	
	public void rotate(float angle) {
		impl.rotate(angle);
	}
	
	public void scale(float x, float y) {
		impl.scale(x, y);
	}
	
	public void translate(float x, float y) {
		impl.translate(x, y);
	}
	
	public void identity() {
		impl.identity();
	}
	
	public boolean isIdentity() {
		return impl.isIdentity();
	}
	
	public void invert() {
		impl.invert();
	}
	
	public Matrix2D decompose(Matrix2D target) {
		return new Matrix2D(impl.decompose(target.impl));
	}
	
	public Matrix2D reinitialize(
			float a, float b,
			float c, float d,
			float tx, float ty,
			float alpha, Shadow shadow, String compositeOperation) {
		impl = impl.reinitialize(a, b, c, d, tx, ty, alpha, shadow.getOverlay(), compositeOperation);
		return this;
	}
	
	public void appendProperties(
			float alpha, Shadow shadow, String compositeOperation) {
		impl.appendProperties(alpha, shadow.getOverlay(), compositeOperation);
	}
	
	public void prependProperties(
			float alpha, Shadow shadow, String compositeOperation) {
		impl.prependProperties(alpha, shadow.getOverlay(), compositeOperation);
	}
	
	public Matrix2D clone() {
		return new Matrix2D(impl.clone());
	}
	
	public float getA() {
		return impl.getA();
	}
	
	public float getB() {
		return impl.getB();
	}
	
	public float getC() {
		return impl.getC();
	}
	
	public float getD() {
		return impl.getD();
	}
	
	public float getTX() {
		return impl.getTX();
	}
	
	public float getTY() {
		return impl.getTY();
	}
	
	public float getAlpha() {
		return impl.getAlpha();
	}

	public Shadow getShadow() {
		return new Shadow(impl.getShadow());
	}

	public String getCompositeOperation() {
		return impl.getCompositeOperation();
	}
	
	public Matrix2DImpl getImpl() {
		return impl;
	}
	
	public void setA(float value) {
		impl.setA(value);
	}
	
	public void setB(float value) {
		impl.setB(value);
	}
	
	public void setC(float value) {
		impl.setC(value);
	}
	
	public void setD(float value) {
		impl.setD(value);
	}
	
	public void setTX(float value) {
		impl.setTX(value);
	}
	
	public void setTY(float value) {
		impl.setTY(value);
	}
	
	public void setAlpha(float value) {
		impl.setAlpha(value);
	}
	
	public void setShadow(Shadow value) {
		impl.setShadow(value.getOverlay());
	}
	
	public void setCompositeOperation(String value) {
		impl.setCompositeOperation(value);
	}
	
	public void setImpl(Matrix2DImpl impl) {
		this.impl = impl;
	}
}
