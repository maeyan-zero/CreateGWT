package net.depoker.createjs.easeljs.client.util;

import net.depoker.createjs.easeljs.client.display.Stage;
import net.depoker.createjs.easeljs.client.helper.Handler;
import net.depoker.createjs.easeljs.client.helper.HasTick;
import net.depoker.createjs.easeljs.client.util.impl.TickerImpl;
import com.google.gwt.core.client.JavaScriptObject;

/**
 * The Ticker class uses a static interface (ex. Ticker.getPaused()) and should not be instantiated. Provides a
 * centralized tick or heartbeat broadcast at a set interval. Listeners can subscribe to the tick event to be
 * notified when a set time interval has elapsed. Note that the interval that the tick event is called is a target
 * interval, and may be broadcast at a slower interval during times of high CPU load.
 */
public class Ticker {

	//
	// Properties:
	//
	
	/**
	 * Indicates whether Ticker should use requestAnimationFrame if it is supported in the browser. If false,
	 * Ticker will use setTimeout. If you change this value, you must call setInterval or setFPS to reinitialize
	 * the Ticker.
	 * @return
	 */
	public static boolean useRAF() {
		return TickerImpl.useRAF();
	}
	
	//
	// Methods:
	//

	/**
	 * Adds a listener for the tick event. The listener must be either an object exposing a .tick() method, or a
	 * function. The listener will be called once each tick / interval. The interval is specified via the
	 * .setInterval(ms) method. The tick method or function is passed two parameters: the elapsed time between the
	 * previous tick and the current one, and a boolean indicating whether Ticker is paused.
	 * @param listener The object or function to add as a listener.
	 * @param pausable	If false, the listener will continue to have tick called even when Ticker is paused via
	 * Ticker.pause(). Default is true.
	 */
	public static void addListener(JavaScriptObject listener, boolean pausable) {
		TickerImpl.addListener(listener, pausable);
	}

	public static void addListener(Stage stage, boolean pausable) {
		TickerImpl.addListener(stage.getOverlay(), pausable);
	}

	/**
	 * Returns the target frame rate in frames per second (FPS). For example, with an interval of 40, getFPS() will
	 * return 25 (1000ms per second divided by 40 ms per tick = 25fps).
	 * @return The current target number of frames / ticks broadcast per second.
	 */
	public static double getFPS() {
		return TickerImpl.getFPS();
	}
	
	/**
	 * Returns the current target time between ticks, as set with setInterval.
	 * @return The current target interval in milliseconds between tick events.
	 */
	public static int getInterval() {
		return TickerImpl.getInterval();
	}
	
	/**
	 * Returns the actual frames / ticks per second.
	 * @param ticks The number of previous ticks over which to measure the actual frames / ticks per second. Defaults
	 * to the number of ticks per second.
	 * @return The actual frames / ticks per second. Depending on performance, this may differ from the target frames 
	 * per second.
	 */
	public static double getMeasuredFps(int ticks) {
		return TickerImpl.getMeasuredFPS(ticks);
	}

	public static double getMeasuredFps() {
		return TickerImpl.getMeasuredFPS();
	}

	/**
	 * Returns a boolean indicating whether Ticker is currently paused, as set with setPaused.
	 * @return Whether the Ticker is currently paused.
	 */
	public static boolean getPaused() {
		return TickerImpl.getPaused();
	}
	
	/**
	 * Returns the number of ticks that have been broadcast by Ticker.
	 * @param pauseable Indicates whether to include ticks that would have been broadcast while Ticker was paused. If
	 * false only tick events broadcast while Ticker is not paused will be returned. If true, tick events that would have
	 * been broadcast while Ticker was paused will be included in the return value. The default value is false.
	 * @return Number of ticks that have been broadcast.
	 */
	public static int getTicks(boolean pauseable) {
		return TickerImpl.getTicks(pauseable);
	}
	
	/**
	 * Returns the number of milliseconds that have elapsed since the first tick event listener was added to Ticker. For
	 * example, you could use this in a time synchronized animation to determine the exact amount of time that has elapsed.
	 * @param pauseable Indicates whether to include time elapsed while Ticker was paused. If false only time elapsed while
	 * 					Ticker is not paused will be returned. If true, the value returned will be total time elapsed since
	 * 					the first tick event listener was added.
	 * @return Number of milliseconds that have elapsed since Ticker was begun.
	 */
	public static int getTime(boolean pauseable) {
		return TickerImpl.getTime(pauseable);
	}
	
	/**
	 * Initializes or resets the timer, clearing all associated listeners and fps measuring data, starting the tick. This is
	 * called automatically when the first listener is added.
	 */
	public static void init() {
		TickerImpl.init();
	}
	
	/**
	 * Removes all listeners.
	 */
	public static void removeAllListeners() {
		TickerImpl.removeAllListeners();
	}
	
	/**
	 * Removes the specified listener.
	 * @param listener The object or function to remove from listening from the tick event.
	 */
	public static void removeListener(HasTick listener) {
		TickerImpl.removeListener(listener);
	}
	
	/**
	 * Sets the target frame rate in frames per second (FPS). For example, with an interval of 40, getFPS() will return 25
	 * (1000ms per second divided by 40 ms per tick = 25fps).
	 * @param value Target number of ticks broadcast per second.
	 */
	public static void setFps(int value) {
		TickerImpl.setFPS(value);
	}
	
	/**
	 * Sets the target time (in milliseconds) between ticks. Default is 50 (20 FPS). Note actual time between ticks may be more
	 * than requested depending on CPU load.
	 * @param interval Time in milliseconds between ticks. Default value is 50.
	 */ 
	public static void setInterval(int interval) {
		TickerImpl.setInterval(interval);
	}
	
	/**
	 * While Ticker is paused, pausable listeners are not ticked. See addListener for more information.
	 * @param value Indicates whether to pause (true) or unpause (false) Ticker.
	 */
	public static void setPaused(boolean value) {
		TickerImpl.setPaused(value);
	}

	//
	// Events:
	//
	
	/**
	 * Event broadcast once each tick / interval. The interval is specified via the .setInterval(ms) or setFPS methods.
	 * @param ticker The time elapsed in milliseconds since the last tick event.
	 */
	public static void setTick(HasTick ticker) {
		TickerImpl.setTick(ticker);
	}

	public static void addEventListener(String eventName, Handler handler) {
		TickerImpl.addEventListener(eventName, handler);
	}

}
