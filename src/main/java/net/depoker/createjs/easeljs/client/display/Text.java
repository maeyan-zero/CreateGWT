package net.depoker.createjs.easeljs.client.display;

import net.depoker.createjs.easeljs.client.display.impl.TextImpl;

public class Text extends DisplayObject {

	private final TextImpl overlay;
	
	public Text() {
		super(TextImpl.create());
		overlay = (TextImpl)getOverlay();
	}

	public Text(TextImpl impl)
	{
		super(impl);
		this.overlay = impl;
	}

	public Text(String text) {
		super(TextImpl.create(text));
		overlay = (TextImpl)getOverlay();
	}
	public Text(String text, String font) {
		super(TextImpl.create(text, font));
		overlay = (TextImpl)getOverlay();
	}
	public Text(String text, String font, String color) {
		super(TextImpl.create(text, font, color));
		overlay = (TextImpl)getOverlay();
	}
	
	/** 
	 * The color to draw the text in. Any valid value for the 
	 * CSS color attribute is acceptable (ex. "#F00"). 
	 */
	public String getColor() {
		return overlay.getColor();
	}
	
	/** 
	 * The font style to use. Any valid value for the CSS font 
	 * attribute is acceptable (ex. "bold 36px Arial"). 
	 */
	public String getFont() {
		return overlay.getFont();
	}
	
	/** 
	 * The text to display.
	 * 
	 * @return
	 */
	public String getText() {
		return overlay.getText();
	}
	
	
	public String getTextAlign() {
		return overlay.getTextAlign();
	}
	
	public String getTextBaseline() {
		return overlay.getTextBaseline();
	}
	
	public float getMaxWidth() {
		return overlay.getMaxWidth();
	}
	
	public boolean getOutline() {
		return overlay.getOutline();
	}
	
	public void setColor(String color) {
		overlay.setColor(color);
	}
	
	/** 
	 * The font style to use. Any valid value for the CSS font 
	 * attribute is acceptable (ex. "bold 36px Arial"). 
	 * 
	 * @param font
	 */
	public void setFont(String font) {
		overlay.setFont(font);
	}
	
	public void setText(String text) {
		overlay.setText(text);
	}
	
	public void setTextAlign(String textAlign) {
		overlay.setTextAlign(textAlign);
	}
	
	public void setTextBaseline(String textBaseline) {
		overlay.setTextBaseline(textBaseline);
	}
	
	public void setMaxWidth(int maxWidth) {
		overlay.setMaxWidth(maxWidth);
	}
	
	public void setMaxWidth(double maxWidth) {
		overlay.setMaxWidth((float)maxWidth);
	}
	
	public void setMaxWidth(float maxWidth) {
		overlay.setMaxWidth(maxWidth);
	}
	
	public void setOutline(boolean outline) {
		overlay.setOutline(outline);
	}
	
	public double getLineHeight() {
		return overlay.getLineHeight();
	}
	
	public double getLineWidth() {
		return overlay.getLineWidth();
	}
	
	public double getMeasuredLineHeight() {
		return overlay.getMeasuredLineHeight();
	}
	
	public double getMeasuredLineWidth() {
		return overlay.getMeasuredLineWidth();
	}

	//@Override
//	public Text clone()
//	{
//		return new Text(overlay.clone());
//	}
}
