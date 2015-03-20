package net.depoker.createjs.easeljs.client.event.impl;

import net.depoker.createjs.easeljs.client.display.impl.DisplayObjectImpl;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.user.client.Event;

public class MouseEventImpl extends JavaScriptObject {

	protected MouseEventImpl() {}
	
	public static native MouseEventImpl create(String type, int stageX, int stageY, DisplayObjectImpl target, JavaScriptObject nativeEvent) /*-{
		return new $wnd.createjs.MouseEvent(type, stageX, stageY, target, nativeEvent);
	}-*/;
	
	public final native int getStageX() /*-{
		return this.stageX;
	}-*/;
	
	public final native int getStageY() /*-{
		return this.stageY;
	}-*/;
		
	public final native DisplayObjectImpl getTarget() /*-{
		return this.target;
	}-*/;
	
	public final native String getType() /*-{
		return this.type;
	}-*/;

	public final native Event getNativeEvent() /*-{
		return this.nativeEvent;
	}-*/;

}
