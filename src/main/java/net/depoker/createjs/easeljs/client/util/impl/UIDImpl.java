package net.depoker.createjs.easeljs.client.util.impl;

import com.google.gwt.core.client.JavaScriptObject;

public class UIDImpl extends JavaScriptObject {

	protected UIDImpl() { }
	
	public static native int get() /*-{
		return $wnd.createjs.UID.get();
	}-*/;

}
