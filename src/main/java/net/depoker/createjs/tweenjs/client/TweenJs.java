package net.depoker.createjs.tweenjs.client;

import net.depoker.createjs.tweenjs.client.callbacks.TweenCallback;
import net.depoker.createjs.tweenjs.client.impl.TweenImpl;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsonUtils;

/**
 * The <b>TweenJS</b> Javascript library (wrapped for GWT) provides a simple but powerful tweening interface. It allows
 * you to chain tweens and actions together to create complex sequences. For example:
 * <pre>Tween.get(target).wait(500).to("{alpha:0,visible:false}",1000).call(onComplete);</pre>
 * This tween will wait 0.5s, tween the target's alpha property to 0 over 1s, set it's visible to false, then call the
 * onComplete function. <u>target</u> is a {@link JavaScriptObject} and <u>onComplete</u> implements the
 * {@link net.depoker.createjs.tweenjs.client.callbacks.TweenCallback} interface.
 * <p>For more information about TweenJS, please visit <a href="http://www.createjs.com">http://www.createjs.com</a></p>
 * Release notes:
 * <ul><li>installPlugin method is missing</li></ul>
 * @author Grant Skinner @gskinner
 * @author Wrapper by Sam Edge @maeyanZero
 * @version 0.2.0
 */
public class TweenJs {

    private TweenImpl overlay;

    /**
     * Constant returned by plugins to tell the tween not to use default assignment.
     */
    public static final JavaScriptObject IGNORE = TweenImpl.getIgnoreConst();

    /**
     * Constant defining the loop actionsMode for use with setPosition.
     */
    public static final int LOOP = TweenImpl.getLoopConst();

    /**
     * Constant defining the none actionsMode for use with setPosition.
     */
    public static final int REVERSE = TweenImpl.getReverseConst();

    /**
     * Constant defining the reverse actionsMode for use with setPosition.
     */
    public static final int NONE = TweenImpl.getNoneConst();


    /**
     * Creates a new Tween instance using the specified overlay.
     * @param overlay The tween overlay implementation.
     */
    public TweenJs(TweenImpl overlay) {
        this.overlay = overlay;
    }

    /**
     * Returns the JavaScriptObject overlay.
     * @return The JavaScriptObject overlay.
     */
    public TweenImpl getOverlay() {
        return this.overlay;
    }

    /**
     * Returns a new tween instance. This is functionally identical to using "new Tween(...)", but looks cleaner with
     * the chained syntax of TweenJS.
     * @param target The target object that will have its properties tweened.
     * @return The new tween instance.
     */
    public static TweenJs get(JavaScriptObject target) {
        return new TweenJs(TweenImpl.get(target));
    }

    /**
     * Returns a new tween instance. This is functionally identical to using "new Tween(...)", but looks cleaner with
     * the chained syntax of TweenJS.
     * @param target The target object that will have its properties tweened.
     * @param props The configuration properties to apply to this tween instance (ex. ).
     *              All properties default to false. Supported props are:
     *              <ul><li><b>loop</b>: sets the loop property on this tween.</li>
     *                  <li><b>useTicks</b>: uses ticks for all durations instead of milliseconds.</li>
     *                  <li><b>ignoreGlobalPause</b>: sets the ignoreGlobalPause property on this tween.</li>
     *                  <li><b>override</b>: if true, Tween.removeTweens(target) will be called to remove any other
     *                  tweens with the same target.</li>
     *                  <li><b>paused</b>: indicates whether to start the tween paused.</li>
     *                  <li><b>position</b>: indicates the initial position for this timeline</li></ul>
     * @return The new tween instance.
     */
    public static TweenJs get(JavaScriptObject target, JavaScriptObject props) {
        return new TweenJs(TweenImpl.get(target, props));
    }

    /**
     * Returns a new tween instance. This is functionally identical to using "new Tween(...)", but looks cleaner with
     * the chained syntax of TweenJS.
     * @param target The target object that will have its properties tweened.
     * @param props The configuration properties to apply to this tween instance (ex. ).
     *              All properties default to false. Supported props are:
     *              <ul><li><b>loop</b>: sets the loop property on this tween.</li>
     *                  <li><b>useTicks</b>: uses ticks for all durations instead of milliseconds.</li>
     *                  <li><b>ignoreGlobalPause</b>: sets the ignoreGlobalPause property on this tween.</li>
     *                  <li><b>override</b>: if true, Tween.removeTweens(target) will be called to remove any other
     *                  tweens with the same target.</li>
     *                  <li><b>paused</b>: indicates whether to start the tween paused.</li>
     *                  <li><b>position</b>: indicates the initial position for this timeline</li></ul>
     * @return The new tween instance.
     */
    public static TweenJs get(JavaScriptObject target, String props) {
        return new TweenJs(TweenImpl.get(target, JsonUtils.unsafeEval(props)));
    }

	/**
	 * Returns a new tween instance. This is functionally identical to using "new Tween(...)", but looks cleaner with
	 * the chained syntax of TweenJS.
	 * @param target The target object that will have its properties tweened.
	 * @param builder The configuration properties to apply to this tween instance (ex. ).
	 *              All properties default to false. Supported props are:
	 *              <ul><li><b>loop</b>: sets the loop property on this tween.</li>
	 *                  <li><b>useTicks</b>: uses ticks for all durations instead of milliseconds.</li>
	 *                  <li><b>ignoreGlobalPause</b>: sets the ignoreGlobalPause property on this tween.</li>
	 *                  <li><b>override</b>: if true, Tween.removeTweens(target) will be called to remove any other
	 *                  tweens with the same target.</li>
	 *                  <li><b>paused</b>: indicates whether to start the tween paused.</li>
	 *                  <li><b>position</b>: indicates the initial position for this timeline</li></ul>
	 * @return The new tween instance.
	 */
	public static TweenJs get(JavaScriptObject target, TweenBuilder builder) {
		return new TweenJs(TweenImpl.get(target, builder.toJso()));
	}

    /**
     * Removes all existing tweens for a target. This is called automatically by new tweens if the "override" prop is true.
     * @param target The target object to remove existing tweens from.
     */
    public static void removeTweens(TweenJs target) {
        TweenImpl.removeTweens(target.getOverlay());
    }

    /**
     * Advances all tweens. This typically uses the Ticker class (when available), but you can call it manually if you
     * prefer to use your own "heartbeat" implementation.
     * @param delta The change in time in milliseconds since the last tick. Required unless all tweens have useTicks set
     *              to true.
     * @param paused Indicates whether a global pause is in effect. Tweens with ignoreGlobalPause will ignore this, but
     *               all others will pause if this is true.
     */
    public static void tick(int delta, boolean paused) {
        TweenImpl.tick(delta, paused);
    }

    /**
     * Read-only property specifying the total duration of this tween in milliseconds (or ticks if useTicks is true).
     * This value is automatically updated as you modify the tween.
     * @return The total duration of this tween in milliseconds.
     */
    public int getDuration() {
        return overlay.getDuration();
    }

    /**
     * Causes this tween to continue playing when a global pause is active. For example, if TweenJS is using Ticker,
     * then setting this to true (the default) will cause this tween to be paused when Ticker.setPaused(true) is called.
     * See Tween.tick() for more info. Can be set via the props param.
     * @return If ignore global pause is set.
     */
    public boolean getIgnoreGlobalPause() {
        return overlay.getIgnoreGlobalPause();
    }

    /**
     * Allows you to specify data that will be used by installed plugins. Each plugin uses this differently, but in
     * general you specify data by setting it to a property of pluginData with the same name as the plugin class.
     * <pre>myTween.pluginData.PluginClassName = data;</pre>
     * Also, most plugins support a property to enable or disable them. This is typically the plugin class name followed
     * by "_enabled".
     * <pre>myTween.pluginData.PluginClassName_enabled = false;</pre>
     * Some plugins also store instance data in this object, usually in a property named _PluginClassName. See the
     * documentation for individual plugins for more details.
     * @return The Plugin Data
     */
    public JavaScriptObject getPluginData() {
        return overlay.getPluginData();
    }

    /**
     * If true, the tween will loop when it reaches the end. Can be set via the props param.
     * @return If the tween will loop.
     */
    public boolean getLoop() {
        return overlay.getLoop();
    }

    /**
     * Queues an action to call the specified function. For example: myTween.wait(1000).call(myFunction); would call
     * myFunction() after 1s.
     *
     * @param callback The function to call.
     * @return The tween instance for chain calls.
     */
    public TweenJs call(TweenCallback callback) {
        return new TweenJs(overlay.call(callback));
    }

    /**
     * Queues an action to call the specified function. For example: myTween.wait(1000).call(myFunction); would call
     * myFunction() after 1s.
     *
     * @param callback The function to call.
     * @param params   The parameters to call the function with. If this is omitted, then the function will be called
     *                 with a single param pointing to this tween.
     * @param scope    The scope to call the function in. If omitted, it will be called in the target's scope.
     * @return The tween instance for chain calls.
     */
    public TweenJs call(TweenCallback callback, JavaScriptObject params, JavaScriptObject scope) {
        return new TweenJs(overlay.call(callback, params, scope));
    }

    /**
     * Queues an action to call the specified function. For example: myTween.wait(1000).call(myFunction); would call
     * myFunction() after 1s.
     *
     * @param callback The function to call.
     * @param params   The parameters to call the function with.
     * @return The tween instance for chain calls.
     */
    public TweenJs call(TweenCallback callback, JavaScriptObject params) {
        return new TweenJs(overlay.call(callback, params));
    }

    /**
     * Queues an action to call the specified function. For example: myTween.wait(1000).call(myFunction); would call
     * myFunction() after 1s.
     *
     * @param callback The function to call.
     * @param params   The parameters to call the function with.
     * @return The tween instance for chain calls.
     */
    public TweenJs call(TweenCallback callback, String params) {
        return new TweenJs(overlay.call(callback, JsonUtils.unsafeEval(params)));
    }

	/**
	 * Queues an action to call the specified function. For example: myTween.wait(1000).call(myFunction); would call
	 * myFunction() after 1s.
	 *
	 * @param callback The function to call.
	 * @param builder  The parameters to call the function with.
	 * @return The tween instance for chain calls.
	 */
	public TweenJs call(TweenCallback callback, TweenBuilder builder) {
		return new TweenJs(overlay.call(callback, builder.toJso()));
	}

    /**
     * Queues an action to call the specified function. For example: myTween.wait(1000).call(myFunction); would call
     * myFunction() after 1s.
     *
     * @param callback The function to call.
     * @param params   The parameters to call the function with. If this is omitted, then the function will be called
     *                 with a single param pointing to this tween.
     * @param scope    The scope to call the function in. If omitted, it will be called in the target's scope.
     * @return The tween instance for chain calls.
     */
    public TweenJs call(TweenCallback callback, String params, JavaScriptObject scope) {
        return new TweenJs(overlay.call(callback, JsonUtils.unsafeEval(params), scope));
    }

	/**
	 * Queues an action to call the specified function. For example: myTween.wait(1000).call(myFunction); would call
	 * myFunction() after 1s.
	 *
	 * @param callback The function to call.
	 * @param builder  The parameters to call the function with. If this is omitted, then the function will be called
	 *                 with a single param pointing to this tween.
	 * @param scope    The scope to call the function in. If omitted, it will be called in the target's scope.
	 * @return The tween instance for chain calls.
	 */
	public TweenJs call(TweenCallback callback, TweenBuilder builder, JavaScriptObject scope) {
		return new TweenJs(overlay.call(callback, builder.toJso(), scope));
	}

    /**
     * Queues an action to to pause this tween.
     *
     * @return The tween instance for chain calls.
     */
    public TweenJs pause() {
        return new TweenJs(overlay.pause(null));
    }

    /**
     * Queues an action to to pause the specified tween.
     *
     * @param tween The tween to play. If null, it pauses this tween.
     * @return The tween instance for chain calls.
     */
    public TweenJs pause(TweenJs tween) {
        return new TweenJs(overlay.pause(tween.getOverlay()));
    }

    /**
     * Queues an action to to play (unpause) the specified tween. This enables you to sequence multiple tweens.
     * <pre>myTween.to({x:100},500).play(otherTween);</pre>
     * @param tween
     * @return The tween instance for chain calls.
     */
    public TweenJs play(TweenJs tween) {
        return new TweenJs(overlay.play(tween.getOverlay()));
    }

    /**
     * Queues an action to set the specified props on the specified target. If target is null, it will use this tween's
     * target.
     *
     * @param props The properties to set.
     * @return The tween instance for chain calls.
     */
    public TweenJs set(JavaScriptObject props) {
        return new TweenJs(overlay.set(props));
    }

    /**
     * Queues an action to set the specified props on the specified target. If target is null, it will use this tween's
     * target.
     *
     * @param props The properties to set.
     * @return The tween instance for chain calls.
     */
    public TweenJs set(String props) {
        return new TweenJs(overlay.set(JsonUtils.unsafeEval(props)));
    }

	/**
	 * Queues an action to set the specified props on the specified target. If target is null, it will use this tween's
	 * target.
	 *
	 * @param builder The properties to set.
	 * @return The tween instance for chain calls.
	 */
	public TweenJs set(TweenBuilder builder) {
		return new TweenJs(overlay.set(builder.toJso()));
	}

    /**
     * Queues an action to set the specified props on the specified target. If target is null, it will use this tween's
     * target.
     *
     * @param props  The properties to set.
     * @param target The target to set the properties on. If omitted, they will be set on the tween's target.
     * @return The tween instance for chain calls.
     */
    public TweenJs set(JavaScriptObject props, JavaScriptObject target) {
        return new TweenJs(overlay.set(props, target));
    }

    /**
     * Queues an action to set the specified props on the specified target. If target is null, it will use this tween's
     * target.
     *
     * @param props  The properties to set.
     * @param target The target to set the properties on. If omitted, they will be set on the tween's target.
     * @return The tween instance for chain calls.
     */
    public TweenJs set(String props, JavaScriptObject target) {
        return new TweenJs(overlay.set(JsonUtils.unsafeEval(props), target));
    }

	/**
	 * Queues an action to set the specified props on the specified target. If target is null, it will use this tween's
	 * target.
	 *
	 * @param builder The properties to set.
	 * @param target The target to set the properties on. If omitted, they will be set on the tween's target.
	 * @return The tween instance for chain calls.
	 */
	public TweenJs set(TweenBuilder builder, JavaScriptObject target) {
		return new TweenJs(overlay.set(builder.toJso(), target));
	}

    /**
     * Pauses or plays this tween.
     * @param value Indicates whether the tween should be paused (true) or played (false).
     */
    public void setPaused(boolean value) {
        overlay.setPaused(value);
    }

    /**
     * Advances the tween to a specified position.
     *
     * @param value       The position to seek to in milliseconds (or ticks if useTicks is true).
     * @param actionsMode Optional parameter specifying how actions are handled (ie. call, set, play, pause):
     *                    <ul><li>Tween.NONE (0) - handleExecute no actions.</li></ul>
     *                    <li>Tween.LOOP (1) - if new position is less than old, then handleExecute all actions between old and
     *                    duration, then all actions between 0 and new. Defaults to LOOP.</li>
     *                    <li>Tween.REVERSE (2) - if new position is less than old, handleExecute all actions between them in
     *                    reverse.</li>
     * @return The tween instance for chain calls.
     */
    public TweenJs setPosition(int value, int actionsMode) {
        return new TweenJs(overlay.setPosition(value, actionsMode));
    }

    /**
     * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
     * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
     * properties will be set at the end of the specified duration.
     *
     * @param props    An object specifying property target values for this tween (Ex. would tween the x property of
     *                 the target to 300).
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @return The tween instance for chain calls.
     */
    public TweenJs to(String props, int duration) {
        return new TweenJs(overlay.to(JsonUtils.unsafeEval(props), duration));
    }

	/**
	 * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
	 * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
	 * properties will be set at the end of the specified duration.
	 *
	 * @param builder  An object specifying property target values for this tween (Ex. would tween the x property of
	 *                 the target to 300).
	 * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
	 * @return The tween instance for chain calls.
	 */
	public TweenJs to(TweenBuilder builder, int duration) {
		return new TweenJs(overlay.to(builder.toJso(), duration));
	}

    /**
     * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
     * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
     * properties will be set at the end of the specified duration.
     *
     * @param props    An object specifying property target values for this tween (Ex. would tween the x property of
     *                 the target to 300).
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @param ease     The easing function to use for this tween.
     * @return The tween instance for chain calls.
     */
    public TweenJs to(String props, int duration, Ease ease) {
        return new TweenJs(overlay.to(JsonUtils.unsafeEval(props), duration, ease.code, 0, 0));
    }

	/**
	 * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
	 * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
	 * properties will be set at the end of the specified duration.
	 *
	 * @param builder  An object specifying property target values for this tween (Ex. would tween the x property of
	 *                 the target to 300).
	 * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
	 * @param ease     The easing function to use for this tween.
	 * @return The tween instance for chain calls.
	 */
	public TweenJs to(TweenBuilder builder, int duration, Ease ease) {
		return new TweenJs(overlay.to(builder.toJso(), duration, ease.code, 0, 0));
	}

    /**
     * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
     * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
     * properties will be set at the end of the specified duration.
     *
     * @param props    An object specifying property target values for this tween (Ex. would tween the x property of the
     *                 target to 300).
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @param ease     The easing function to use for this tween.
     * @param param1   Parameters to pass to the corresponding ease function. Check individual function documentation
     *                 for any required parameters. An exception will be thrown if an illegal number of parameters are
     *                 supplied.
     * @return The tween instance for chain calls.
     */
    public TweenJs to(String props, int duration, Ease ease, double param1) {
        return new TweenJs(overlay.to(JsonUtils.unsafeEval(props), duration, ease.code, (float) param1, 0));
    }

	/**
	 * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
	 * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
	 * properties will be set at the end of the specified duration.
	 *
	 * @param builder  An object specifying property target values for this tween (Ex. would tween the x property of the
	 *                 target to 300).
	 * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
	 * @param ease     The easing function to use for this tween.
	 * @param param1   Parameters to pass to the corresponding ease function. Check individual function documentation
	 *                 for any required parameters. An exception will be thrown if an illegal number of parameters are
	 *                 supplied.
	 * @return The tween instance for chain calls.
	 */
	public TweenJs to(TweenBuilder builder, int duration, Ease ease, double param1) {
		return new TweenJs(overlay.to(builder.toJso(), duration, ease.code, (float)param1, 0));
	}

    /**
     * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
     * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
     * properties will be set at the end of the specified duration.
     *
     * @param props    An object specifying property target values for this tween (Ex. would tween the x property of the
     *                 target to 300).
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @param ease     The easing function to use for this tween.
     * @param param1   Parameters to pass to the corresponding ease function. Check individual function documentation
     *                 for any required parameters. An exception will be thrown if an illegal number of parameters are
     *                 supplied.
     * @param param2   The second parameter.
     * @return The tween instance for chain calls.
     */
    public TweenJs to(String props, int duration, Ease ease, double param1, double param2) {
        return new TweenJs(overlay.to(JsonUtils.unsafeEval(props), duration, ease.code, (float) param1, (float) param2));
    }

	/**
	 * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
	 * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
	 * properties will be set at the end of the specified duration.
	 *
	 * @param builder  An object specifying property target values for this tween (Ex. would tween the x property of the
	 *                 target to 300).
	 * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
	 * @param ease     The easing function to use for this tween.
	 * @param param1   Parameters to pass to the corresponding ease function. Check individual function documentation
	 *                 for any required parameters. An exception will be thrown if an illegal number of parameters are
	 *                 supplied.
	 * @param param2   The second parameter.
	 * @return The tween instance for chain calls.
	 */
	public TweenJs to(TweenBuilder builder, int duration, Ease ease, double param1, double param2) {
		return new TweenJs(overlay.to(builder.toJso(), duration, ease.code, (float) param1, (float) param2));
	}


	/**
     * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
     * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
     * properties will be set at the end of the specified duration.
     *
     * @param props    An object specifying property target values for this tween (Ex. would tween the x property of
     *                 the target to 300).
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @return The tween instance for chain calls.
     */
    public TweenJs to(JavaScriptObject props, int duration) {
        return new TweenJs(overlay.to(props, duration));
    }

    /**
     * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
     * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
     * properties will be set at the end of the specified duration.
     *
     * @param props    An object specifying property target values for this tween (Ex. would tween the x property of
     *                 the target to 300).
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @param ease     The easing function to use for this tween.
     * @return The tween instance for chain calls.
     */
    public TweenJs to(JavaScriptObject props, int duration, Ease ease) {
        return new TweenJs(overlay.to(props, duration, ease.code, 0, 0));
    }

    /**
     * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
     * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
     * properties will be set at the end of the specified duration.
     *
     * @param props    An object specifying property target values for this tween (Ex. would tween the x property of the
     *                 target to 300).
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @param ease     The easing function to use for this tween.
     * @param param1   Parameters to pass to the corresponding ease function. Check individual function documentation
     *                 for any required parameters. An exception will be thrown if an illegal number of parameters are
     *                 supplied.
     * @return The tween instance for chain calls.
     */
    public TweenJs to(JavaScriptObject props, int duration, Ease ease, double param1) {
        return new TweenJs(overlay.to(props, duration, ease.code, (float) param1, 0));
    }

    /**
     * Queues a tween from the current values to the target properties. Set duration to 0 to jump to these value.
     * Numeric properties will be tweened from their current value in the tween to the target value. Non-numeric
     * properties will be set at the end of the specified duration.
     *
     * @param props    An object specifying property target values for this tween (Ex. would tween the x property of the
     *                 target to 300).
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @param ease     The easing function to use for this tween.
     * @param param1   Parameters to pass to the corresponding ease function. Check individual function documentation
     *                 for any required parameters. An exception will be thrown if an illegal number of parameters are
     *                 supplied.
     * @param param2   The second parameter.
     * @return The tween instance for chain calls.
     */
    public TweenJs to(JavaScriptObject props, int duration, Ease ease, double param1, double param2) {
        return new TweenJs(overlay.to(props, duration, ease.code, (float) param1, (float) param2));
    }

    /**
     * Queues a wait (essentially an empty tween).
     *
     * @param duration The duration of the wait in milliseconds (or in ticks if useTicks is true).
     * @return The tween instance for chain calls.
     */
    public TweenJs wait(int duration) {
        return new TweenJs(overlay.wait(duration));
    }

}
