package net.depoker.createjs.easeljs.client.display;

import com.google.gwt.dom.client.Element;
import net.depoker.createjs.easeljs.client.display.impl.DomElementImpl;

public class DomElement extends DisplayObject {
	private final DomElementImpl impl;

	public DomElement(Element htmlElement) {
		super( DomElementImpl.create(htmlElement) );
		this.impl = getOverlay().cast();
	}

	public Element getHtmlElement() {
		return impl.htmlElement().cast();
	}
}
