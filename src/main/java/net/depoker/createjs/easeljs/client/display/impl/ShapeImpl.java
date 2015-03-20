package net.depoker.createjs.easeljs.client.display.impl;

public class ShapeImpl extends DisplayObjectImpl {

	protected ShapeImpl() {}
	
	public static native ShapeImpl create() /*-{
		return new $wnd.createjs.Shape();
	}-*/;
	
	public final native GraphicsImpl getGraphics() /*-{
		return this.graphics;
	}-*/;

    public final native ShapeImpl clone(boolean recursive) /*-{
        return this.clone(recursive);
    }-*/;

}
