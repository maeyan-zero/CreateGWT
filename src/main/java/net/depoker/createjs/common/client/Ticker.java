package net.depoker.createjs.common.client;

import com.google.gwt.core.client.JavaScriptObject;
import net.depoker.createjs.common.client.event.TickEvent;
import net.depoker.createjs.common.client.event.TickListener;
import net.depoker.createjs.common.client.impl.EventListenerImpl;
import net.depoker.createjs.common.client.impl.TickerImpl;
import org.jetbrains.annotations.NotNull;

public class Ticker {
	private Ticker() { // non-instantiable
	}

	public enum TimingMode {
		RAF(TickerImpl.raf()),
		RAF_SYNCHED(TickerImpl.rafSynched()),
		TIMEOUT(TickerImpl.timeout());

		private final String mode;

		TimingMode(String mode) {
			this.mode = mode;
		}

		@Override public String toString() {
			return mode;
		}

		public static TimingMode fromString(String mode) {
			for (TimingMode timingMode : values()) {
				if (timingMode.toString().equals(mode)) {
					return timingMode;
				}
			}
			return null;
		}
	}

	//
	// Methods:
	//

	public static EventListenerImpl addTickListener(final TickListener listener) {
		return addEventListener(EventType.TICK.toString(), new EventListener() {
			@Override public void handleEvent(Event event) {
				listener.onTick(new TickEvent(event));
			}
		});
	}

	public static EventListenerImpl addTickListener(final TickListener listener, boolean useCapture) {
		return addEventListener(EventType.TICK.toString(), new EventListener() {
			@Override public void handleEvent(Event event) {
				listener.onTick(new TickEvent(event));
			}
		}, useCapture);
	}

	public static boolean dispatchEvent(String type) {
		return TickerImpl.dispatchEvent(type);
	}

	public static boolean dispatchEvent(Event event) {
		return TickerImpl.dispatchEvent(event.getImpl());
	}

	public static int getEventTime(boolean runTime) {
		return TickerImpl.getEventTime(runTime);
	}

	@Deprecated
	public static int getFps() {
		return TickerImpl.getFPS();
	}

	public static int getMeasuredFps() {
		return TickerImpl.getMeasuredFPS();
	}

	public static int getMeasuredFps(int ticks) {
		return TickerImpl.getMeasuredFPS(ticks);
	}

	public static int getMeasuredTickTime() {
		return TickerImpl.getMeasuredTickTime();
	}

	public static int getMeasuredTickTime(int ticks) {
		return TickerImpl.getMeasuredTickTime(ticks);
	}

	public static int getTicks(boolean pauseable) {
		return TickerImpl.getTicks(pauseable);
	}

	public static int getTime() {
		return TickerImpl.getTime();
	}

	public static int getTime(boolean pauseable) {
		return TickerImpl.getTime(pauseable);
	}

	public boolean hasEventListener(@NotNull EventType eventType) {
		return TickerImpl.hasEventListener(eventType.toString());
	}

	public static void init() {
		TickerImpl.init();
	}

	public static void off(EventType type, EventListenerImpl listener) {
		TickerImpl.off(type.toString(), listener);
	}

	public static void off(EventType type, EventListenerImpl listener, boolean useCapture) {
		TickerImpl.off(type.toString(), listener, useCapture);
	}

	public static EventListenerImpl on(EventType type, EventListener listener) {
		return TickerImpl.on(type.toString(), EventListenerImpl.create(listener)).cast();
	}

	public static EventListenerImpl on(EventType type, EventListener listener, JavaScriptObject scope) {
		return TickerImpl.on(type.toString(), EventListenerImpl.create(listener), scope).cast();
	}

	public static EventListenerImpl on(EventType type, EventListener listener, JavaScriptObject scope, boolean once) {
		return TickerImpl.on(type.toString(), EventListenerImpl.create(listener), scope, once).cast();
	}

	public static EventListenerImpl on(EventType type, EventListener listener, JavaScriptObject scope, boolean once, JavaScriptObject data) {
		return TickerImpl.on(type.toString(), EventListenerImpl.create(listener), scope, once, data).cast();
	}

	public static EventListenerImpl on(EventType type, EventListener listener, JavaScriptObject scope, boolean once, JavaScriptObject data, boolean useCapture) {
		return TickerImpl.on(type.toString(), EventListenerImpl.create(listener), scope, once, data, useCapture).cast();
	}

	public static void removeAllEventListeners() {
		TickerImpl.removeAllEventListeners();
	}

	public static void removeAllTickEventListeners() {
		TickerImpl.removeAllEventListeners(EventType.TICK.toString());
	}

	public static void removeTickEventListener(EventListenerImpl listener) {
		TickerImpl.removeEventListener(EventType.TICK.toString(), listener);
	}

	public static void removeTickEventListener(EventListenerImpl listener, boolean useCapture) {
		TickerImpl.removeEventListener(EventType.TICK.toString(), listener, useCapture);
	}

	public static boolean willTrigger(EventType type) {
		return TickerImpl.willTrigger(type.toString());
	}

	//
	// Properties
	//

	public static int getFramerate() {
		return TickerImpl.framerate();
	}

	public static void setFramerate(int value) {
		TickerImpl.framerate(value);
	}

	public static int getInterval() {
		return TickerImpl.interval();
	}

	public static void setInterval(int value) {
		TickerImpl.interval(value);
	}

	public static int getMaxDelta() {
		return TickerImpl.maxDelta();
	}

	public static void setMaxDelta(int value) {
		TickerImpl.maxDelta(value);
	}

	public static boolean getPaused() {
		return TickerImpl.paused();
	}

	public static void setPaused(boolean value) {
		TickerImpl.paused(value);
	}

	public static TimingMode getTimingMode() {
		return TimingMode.fromString(TickerImpl.timingMode());
	}

	public static void setTimingMode(TimingMode mode) {
		TickerImpl.timingMode(mode.toString());
	}

	@Deprecated
	public static boolean getUseRaf() {
		return TickerImpl.useRaf();
	}

	//
	// Private Helpers
	//

	private static EventListenerImpl addEventListener(String type, EventListener listener) {
		return TickerImpl.addEventListener(type, EventListenerImpl.create(listener)).cast();
	}

	private static EventListenerImpl addEventListener(String type, EventListener listener, boolean useCapture) {
		return TickerImpl.addEventListener(type, EventListenerImpl.create(listener), useCapture).cast();
	}
}
