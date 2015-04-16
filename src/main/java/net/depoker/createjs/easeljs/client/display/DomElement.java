/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.easeljs.client.display;

import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Widget;
import net.depoker.createjs.easeljs.client.display.impl.DomElementImpl;

public class DomElement extends DisplayObject {
	private final DomElementImpl impl;
	private final Widget widget;

	/**
	 * Your will probably want to pass your own widgets here.
	 *
	 * @param widget The widget to pack into the display object
	 */
	public DomElement(Widget widget) {
		super( DomElementImpl.create( widget.getElement() ));
		this.impl = getOverlay().cast();
		this.widget = widget;
	}

	public Widget getWidget() {
		return widget;
	}

	public Element getHtmlElement() {
		return impl.htmlElement().cast();
	}
}
