package net.depoker.createjs.tweenjs.client;

import net.depoker.createjs.tweenjs.client.impl.TimelineImpl;
import net.depoker.createjs.tweenjs.client.impl.TweenImpl;
import com.google.gwt.core.client.JavaScriptObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Timeline {

    private TimelineImpl overlay;

    /**
     * The Timeline class synchronizes multiple tweens and allows them to be controlled as a group.
     */
    public Timeline() {
        overlay = TimelineImpl.create(null, null, null);
    }

    /**
     * The Timeline class synchronizes multiple tweens and allows them to be controlled as a group.
     * @param tweens An array of Tweens to add to this timeline. See addTween for more info.
     * @param labels An object defining labels for using gotoAndPlay/Stop. See setLabels for details.
     */
    public Timeline(List<Tween> tweens, Map<String, Integer> labels) {
        ArrayList<TweenImpl> tweensImpl = new ArrayList<TweenImpl>();
        for (Tween tween : tweens) {
            tweensImpl.add(tween.getOverlay());
        }
        overlay = TimelineImpl.create(tweensImpl, labels, null);
    }

    /**
     * The Timeline class synchronizes multiple tweens and allows them to be controlled as a group.
     * @param tweens An array of Tweens to add to this timeline. See addTween for more info.
     * @param labels An object defining labels for using gotoAndPlay/Stop. See setLabels for details.
     * @param props  The configuration properties to apply to this tween instance (ex. ). All properties default to false.
     */
    public Timeline(List<Tween> tweens, Map<String, Integer> labels, JavaScriptObject props) {
        ArrayList<TweenImpl> tweensImpl = new ArrayList<TweenImpl>();
        for (Tween tween : tweens) {
            tweensImpl.add(tween.getOverlay());
        }
        overlay = TimelineImpl.create(tweensImpl, labels, props);
    }

    public Timeline(TimelineImpl overlay) {
        this.overlay = overlay;
    }

    public TimelineImpl getOverlay() {
        return overlay;
    }

    /**
     * Read-only property specifying the total duration of this timeline in milliseconds (or ticks if useTicks is true).
     * This value is usually automatically updated as you modify the timeline. See updateDuration for more information.
     * @return
     */
    public int getDuration() {
        return overlay.getDuration();
    }

    /**
     * Causes this timeline to continue playing when a global pause is active.
     * @return
     */
    public boolean getIgnoreGlobalPause() {
        return overlay.getIgnoreGlobalPause();
    }

    /**
     * If true, the timeline will loop when it reaches the end. Can be set via the props param.
     * @return
     */
    public boolean getLoop() {
        return overlay.getLoop();
    }

    /**
     * Adds a label that can be used with gotoAndPlay/Stop.
     *
     * @param label    The label name.
     * @param position The position this label represents.
     */
    public void addLabel(String label, int position) {
         overlay.addLabel(label, position);
    }

    /**
     * Adds one or more tweens (or timelines) to this timeline. The tweens will be paused (to remove them from the
     * normal ticking system) and managed by this timeline. Adding a tween to multiple timelines will result in
     * unexpected behaviour.
     *
     * @param tweens The tween(s) to add. Accepts multiple arguments.
     */
    public void addTween(Tween ... tweens) {
        for (Tween tween : tweens) {
            overlay.addTween(tween.getOverlay());
        }
    }

    /**
     * Unpauses this timeline and jumps to the specified label.
     * @param label The label to jump to.
     */
    public void gotoAndPlay(String label) {
        overlay.gotoAndPlay(label);
    }

    /**
     * Unpauses this timeline and jumps to the specified position.
     * @param position The position in milliseconds (or ticks if useTicks is true).
     */
    public void gotoAndPlay(int position) {
        overlay.gotoAndPlay(position);
    }

    /**
     * Pauses this timeline and jumps to the specified position or label.
     * @param label The label to jump to.
     */
    public void gotoAndStop(String label) {
        overlay.gotoAndStop(label);
    }

    /**
     * Pauses this timeline and jumps to the specified position or label.
     * @param position The position in milliseconds (or ticks if useTicks is true).
     */
    public void gotoAndStop(int position) {
        overlay.gotoAndStop(position);
    }

    /**
     * Removes one or more tweens from this timeline.
     * @param tweens The tween(s) to remove. Accepts multiple arguments.
     */
    public void removeTween(Tween ... tweens) {
        for (Tween tween : tweens) {
            overlay.removeTween(tween.getOverlay());
        }
    }

    /**
     * Pauses or plays this timeline.
     * @param value Indicates whether the tween should be paused (true) or played (false).
     */
    public void setPaused(boolean value) {
        overlay.setPaused(value);
    }

    /**
     * Advances the timeline to the specified position.
     * @param value The position to seek to in milliseconds (or ticks if useTicks is true).
     */
    public void setPosition(int value) {
        overlay.setPosition(value, null);
    }

    /**
     * Advances the timeline to the specified position.
     * @param value The position to seek to in milliseconds (or ticks if useTicks is true).
     * @param actionsMode Optional parameter specifying how actions are handled. Use:
     *                    <pre>Ease.LOOP, Ease.REVERSE</pre>
     */
    public void setPosition(int value, int actionsMode) {
        overlay.setPosition(value, actionsMode);
    }

    /**
     * Advances this timeline by the specified amount of time in milliseconds (or ticks if useTicks is true). This is
     * normally called automatically by the Tween engine (via Tween.tick), but is exposed for advanced uses.
     * @param delta The time to advance in milliseconds (or ticks if useTicks is true).
     */
    public void tick(int delta) {
        overlay.tick(delta);
    }

    /**
     * Recalculates the duration of the timeline. The duration is automatically updated when tweens are added or removed,
     * but this method is useful if you modify a tween after it was added to the timeline.
     */
    public void updateDuration() {
        overlay.updateDuration();
    }
}
