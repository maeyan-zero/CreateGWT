package net.depoker.createjs.easeljs.client.display.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class DomElementImpl extends DisplayObjectImpl {
	protected DomElementImpl() {
	}

	public static native DomElementImpl create(JavaScriptObject htmlElement) /*-{
			return $wnd.createjs.DOMElement(htmlElement);
  }-*/;

	public final native JavaScriptObject htmlElement() /*-{
			return this.htmlElement;
  }-*/;
}
