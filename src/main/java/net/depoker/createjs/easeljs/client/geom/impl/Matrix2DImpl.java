package net.depoker.createjs.easeljs.client.geom.impl;

import com.google.gwt.core.client.JavaScriptObject;

import net.depoker.createjs.easeljs.client.display.impl.ShadowImpl;

public class Matrix2DImpl extends JavaScriptObject {
	
	protected Matrix2DImpl() { }
	
	public static final native Matrix2DImpl create() /*-{
		return new $wnd.createjs.Matrix2D();
	}-*/;
	public static final native Matrix2DImpl create(
			float a, float b, 
			float c, float d, 
			float tx, float ty) /*-{
		return new $wnd.createjs.Matrix2D(a, b, c, d, tx, ty);
	}-*/;
	
	/**
	 * Concatenates the specified matrix properties with this matrix.
	 * All parameters are required.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param tx
	 * @param ty
	 **/
	public final native void prepend(
			float a, float b,
			float c, float d,
			float tx, float ty) /*-{
		this.prepend(a, b, c, d, tx, ty);
	}-*/;
	
	/**
	 * Appends the specified matrix properties with this matrix.
	 * All parameters are required.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param tx
	 * @param ty
	 **/
	public final native void append(
			float a, float b,
			float c, float d,
			float tx, float ty) /*-{
		this.append(a, b, c, d, tx, ty);
	}-*/;
	
	/**
	 * Prepends the specified matrix with this matrix.
	 * @param matrix
	 */
	public final native void prependMatrix(Matrix2DImpl matrix) /*-{
		this.prependMatrix(matrix);
	}-*/;
	
	/**
	 * Appends the specified matrix with this matrix.
	 * @param matrix
	 */
	public final native void appendMatrix(Matrix2DImpl matrix) /*-{
		this.appendMatrix(matrix);
	}-*/;
	
	/**
	 * Generates matrix properties from the specified display object transform properties, and prepends them with this matrix.
	 * For example, you can use this to generate a matrix from a display object: var mtx = new Matrix2D();
	 * mtx.prependTransform(o.x, o.y, o.scaleX, o.scaleY, o.rotation);
	 * @param x
	 * @param y
	 * @param scaleX
	 * @param scaleY
	 * @param rotation
	 * @param skewX
	 * @param skewY
	 * @param regX Optional.
	 * @param regY Optional.
	 **/
	public final native void prependTransform(
			float x, float y,
			float scaleX, float scaleY,
			float rotation, float skewX,
			float skewY, float regX, float regY) /*-{
		this.prependTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
	}-*/;
	
	/**
	 * Generates matrix properties from the specified display object transform properties, and appends them with this matrix.
	 * For example, you can use this to generate a matrix from a display object: var mtx = new Matrix2D();
	 * mtx.appendTransform(o.x, o.y, o.scaleX, o.scaleY, o.rotation);
	 * @param x
	 * @param y
	 * @param scaleX
	 * @param scaleY
	 * @param rotation
	 * @param skewX
	 * @param skewY
	 * @param regX Optional.
	 * @param regY Optional.
	 **/
	public final native void appendTransform(
			float x, float y,
			float scaleX, float scaleY,
			float rotation, float skewX,
			float skewY, float regX, float regY) /*-{
		this.appendTransform(x, y, scaleX, scaleY, rotation, skewX, skewY, regX, regY);
	}-*/;
	
	/**
	 * Applies a rotation transformation to the matrix.
	 * 
	 * @param angle The angle in degrees.
	 */
	public final native void rotate(float angle) /*-{
		this.rotate(angle);
	}-*/;
	
	/**
	 * Applies a skew transformation to the matrix.
	 * @param skewX The amount to skew horizontally in degrees.
	 * @param skewY The amount to skew vertically in degrees.
	 */
	public final native void skew(float skewX, float skewY) /*-{
		this.skew(skewX, skewY);
	}-*/;
	
	/**
	 * Applies a scale transformation to the matrix.
	 * @param x
	 * @param y
	 */
	public final native void scale(float x, float y) /*-{
		this.scale(x, y);
	}-*/;
	
	/**
	 * Translates the matrix on the x and y axes.
	 * 
	 * @param x
	 * @param y
	 */
	public final native void translate(float x, float y) /*-{
		this.translate(x, y);
	}-*/;
	
	/**
	 * Sets the properties of the matrix to those of an identity matrix (one that applies a null transformation).
	 */
	public final native void identity() /*-{
		this.identity();
	}-*/;
	
	/**
	 * Returns true if the matrix is an identity matrix.
	 * @return
	 */
	public final native boolean isIdentity() /*-{
		return this.isIdentity();
	}-*/;
	
	/**
	 * Inverts the matrix, causing it to perform the opposite transformation.
	 */
	public final native void invert() /*-{
		this.invert();
	}-*/;
	
	/**
	 * Decomposes the matrix into transform properties (x, y, scaleX, scaleY, and rotation). Note that this these values
	 * may not match the transform properties you used to generate the matrix, though they will produce the same visual
	 * results.
	 * @param target The object to apply the transform properties to. If null, then a new object will be returned.
	 */
	public final native Matrix2DImpl decompose(Matrix2DImpl target) /*-{
		return this.decompose(target);
	}-*/;

	/**
	 * Reinitializes all matrix properties to those specified.
	 * @param a
	 * @param b
	 * @param c
	 * @param d
	 * @param tx
	 * @param ty
	 * @param alpha desired alpha value
	 * @param shadow desired shadow value
	 * @param compositeOperation desired composite operation value
	 */
	public final native Matrix2DImpl reinitialize(
			float a, float b,
			float c, float d,
			float tx, float ty,
			float alpha, ShadowImpl shadow, String compositeOperation) /*-{
		return this.reinitialize(a, b, c, d, tx, ty, alpha, shadow, compositeOperation);
	}-*/;
	
	/**
	 * Appends the specified visual properties to the current matrix.
	 * @param alpha desired alpha value
	 * @param shadow desired shadow value
	 * @param compositeOperation desired composite operation value
	*/
	public final native void appendProperties(
			float alpha, ShadowImpl shadow, String compositeOperation) /*-{
		return this.appendProperties(alpha, shadow, compositeOperation);
	}-*/;
	
	/**
	 * Prepends the specified visual properties to the current matrix.
	 * @param alpha desired alpha value
	 * @param shadow desired shadow value
	 * @param compositeOperation desired composite operation value
	*/
	public final native void prependProperties(
			float alpha, ShadowImpl shadow, String compositeOperation) /*-{
		return this.prependProperties(alpha, shadow, compositeOperation);
	}-*/;
	
	/**
	 * Returns a clone of this Matrix.
	 */
	public final native Matrix2DImpl clone() /*-{
		this.clone();
	}-*/;
	
	public final native float getA() /*-{
		return this.a;
	}-*/;
	
	public final native float getB() /*-{
		return this.b;
	}-*/;
	
	public final native float getC() /*-{
		return this.c;
	}-*/;
	
	public final native float getD() /*-{
		return this.d;
	}-*/;
	
	public final native float getTX() /*-{
		return this.tx;
	}-*/;
	
	public final native float getTY() /*-{
		return this.ty;
	}-*/;
	
	public final native float getAlpha() /*-{
		return this.alpha;
	}-*/;
	
	public final native ShadowImpl getShadow() /*-{
		return this.shadow;
	}-*/;
	
	public final native String getCompositeOperation() /*-{
		return this.compositeOperation;
	}-*/;
	
	public final native void setA(float value) /*-{
		this.a = value;
	}-*/;
	
	public final native void setB(float value) /*-{
		this.b = value;
	}-*/;
	
	public final native void setC(float value) /*-{
		this.c = value;
	}-*/;
	
	public final native void setD(float value) /*-{
		this.d = value;
	}-*/;
	
	public final native void setTX(float value) /*-{
		this.ty = value;
	}-*/;
	
	public final native void setTY(float value) /*-{
		this.tx = value;
	}-*/;
	
	public final native void setAlpha(float value) /*-{
		this.alpha = value;
	}-*/;
	
	public final native void setShadow(ShadowImpl value) /*-{
		this.shadow = value;
	}-*/;
	
	public final native void setCompositeOperation(String value) /*-{
		this.compositeOperation = value;
	}-*/;
}
