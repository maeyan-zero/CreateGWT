package net.depoker.createjs.easeljs.client.event;

import com.google.gwt.core.client.JavaScriptObject;

import net.depoker.createjs.easeljs.client.display.DisplayObject;
import net.depoker.createjs.easeljs.client.event.impl.MouseEventImpl;
import com.google.gwt.user.client.Event;

public class MouseEvent {
	
	private MouseEventImpl impl;
	
	/**
	 * This is passed as the parameter to onPress, onMouseMove, onMouseUp, onMouseDown, and onClick handlers on
	 * DisplayObject instances.
	 * <p>By default, mouse events are disabled for performance reasons. In order to enabled them for a specified stage
   	 * set mouseEventsEnabled to true on your stage instance.</p>
 	 * 
	 * @param type The event type.
	 * @param stageX The mouseX position relative to the stage.
	 * @param stageY The mouseY position relative to the stage.
	 * @param target The display object this event relates to.
	 * @param nativeEvent The native DOM event related to this mouse event.
	 */
	public MouseEvent(String type, int stageX, int stageY, DisplayObject target, JavaScriptObject nativeEvent) {
		this.impl = MouseEventImpl.create(type, stageX, stageY, target.getOverlay(), nativeEvent);
	}
	
	public MouseEvent(MouseEventImpl impl) {
		this.impl = impl;
	}
	
	public MouseEventImpl getImpl() {
		return impl;
	}
	
	/**
	 * The mouseX position on the stage.
	 * @return
	 */
	public int getStageX() {
		return impl.getStageX();
	}
	
	/**
	 * The mouseY position on the stage.
	 * @return
	 */
	public int getStageY() {
		return impl.getStageY();
	}
	
	/**
	 * The type of mouse event. This will be the same as the handler it maps to (onPress, onMouseDown, onMouseUp, onMouseMove, or onClick).
	 * 
	 * @return
	 */
	public String getType() {
		return impl.getType();
	}
	

	/**
	 * 
	 * @return
	 */
	public DisplayObject getTarget() {
		return new DisplayObject(impl.getTarget());
	}
	
	public Event getNativeEvent() {
		return impl.getNativeEvent();
	}
	
}
