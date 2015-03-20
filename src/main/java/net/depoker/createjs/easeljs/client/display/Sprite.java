package net.depoker.createjs.easeljs.client.display;

import net.depoker.createjs.easeljs.client.display.impl.SpriteImpl;
import net.depoker.createjs.easeljs.client.geom.Rectangle;
import net.depoker.createjs.easeljs.client.helper.AnimationCallback;

/**
 * Displays frames or sequences of frames (ie. animations) from a sprite sheet image. A sprite sheet is a series of
 * images (usually animation frames) combined into a single image. For example, an animation consisting of 8 100x100
 * images could be combined into a 400x200 sprite sheet (4 frames across by 2 high). You can display individual
 * frames, play frames as an animation, and even sequence animations together. See the SpriteSheet class for more
 * information on setting up frames and animations.
 */
public class Sprite extends DisplayObject {
	
	protected SpriteImpl overlay;

	public Sprite(SpriteSheet spriteSheet) {
		this(SpriteImpl.create(spriteSheet.getOverlay()));
	}
	
	protected Sprite(SpriteImpl impl) {
		super(impl);
		overlay = impl;
	}

    /**
     * Returns the currently playing animation.
     */
    public String getCurrentAnimation() { return overlay.getCurrentAnimation(); }

	/**
	 * Specifies the current frame index within the current playing animation. When playing normally, this will increase
	 * successively from 0 to n-1, where n is the number of frames in the current animation.
	 */
	public String getCurrentAnimationFrame() { return overlay.getCurrentAnimationFrame(); }

    /**
     * The frame that will be drawn when draw is called. Note that with some SpriteSheet data, this will advance
     * non-sequentially.
     */
    public int getCurrentFrame() { return overlay.getCurrentFrame(); }

    /**
     * When used in conjunction with animations having an frequency greater than 1, this lets you offset which tick the
     * playhead will advance on. For example, you could create two BitmapAnimations, both playing an animation with a
     * frequency of 2, but one having offset set to 1. Both instances would advance every second tick, but they would
     * advance on alternating ticks (effectively, one instance would advance on odd ticks, the other on even ticks).
     *
     * @return The BitmapAnimations current offset.
     */
    public int getOffset() { return overlay.getOffset(); }

    /**
     * When used in conjunction with animations having an frequency greater than 1, this lets you offset which tick the
     * playhead will advance on. For example, you could create two BitmapAnimations, both playing an animation with a
     * frequency of 2, but one having offset set to 1. Both instances would advance every second tick, but they would
     * advance on alternating ticks (effectively, one instance would advance on odd ticks, the other on even ticks).
     *
     * @param value The offset to assign the BitmapAnimation.
     */
    public void setOffset(int value) { overlay.setOffset(value); }

    /**
     * Prevents the animation from advancing each tick automatically. For example, you could create a sprite sheet of
     * icons, set paused to true, and display the appropriate icon by setting currentFrame.
     */
    public boolean getPaused() { return overlay.getPaused(); }

    /**
     * Prevents the animation from advancing each tick automatically. For example, you could create a sprite sheet of
     * icons, set paused to true, and display the appropriate icon by setting currentFrame.
     */
    public void setPaused(boolean paused) { overlay.setPaused(paused); }

    /**
     * The SpriteSheet instance to play back. This includes the source image, frame dimensions, and frame data. See
     * SpriteSheet for more information.
     */
    public SpriteSheet getSpriteSheet() { return new SpriteSheet(overlay.getSpriteSheet()); }

	/**
	 * Specifies a function to call whenever any animation reaches its end. It will be called with three
	 * params: the first will be a reference to this instance, the second will be the name of the animation
	 * that just ended, and the third will be the name of the next animation that will be played.
	 */
	public void setAnimationEnd(AnimationCallback callback) { overlay.setAnimationEndCallback(callback); }

	public void setFramerate(int framerate) { overlay.setFramerate(framerate); }

	//
	// Methods:
    //

	/**
	 * Advances the playhead. This occurs automatically each tick by default.
	 */
	public void advance() { overlay.advance(); }

	/**
	 * Returns a Rectangle instance defining the bounds of the current frame relative to the origin. For example,
	 * a 90 x 70 frame with regX=50 and regY=40 would return a rectangle with [x=-50, y=-40, width=90, height=70].
	 *
	 * @return A Rectangle instance. Returns null if the frame does not exist, or the image is not fully loaded.
	 */
    public Rectangle getBounds() { return (overlay.getBounds() != null) ? new Rectangle(overlay.getBounds()) : null; }

    /**
     * Sets paused to false and plays the specified animation name, named frame, or frame number.
     *
     * @param frame The frame number or animation name that the playhead should move to and begin playing.
     */
	public void gotoAndPlay(int frame) { overlay.gotoAndPlay(frame); }

    /**
     * Sets paused to false and plays the specified animation name, named frame, or frame number.
     *
     * @param frameOrSequence The frame number or animation name that the playhead should move to and begin playing.
     */
	public void gotoAndPlay(String frameOrSequence) { overlay.gotoAndPlay(frameOrSequence); }

    /**
     * Sets paused to true and seeks to the specified animation name, named frame, or frame number.
     *
     * @param frame The frame number or animation name that the playhead should move to and stop.
     */
	public void gotoAndStop(int frame) { overlay.gotoAndStop(frame); }

    /**
     * Sets paused to true and seeks to the specified animation name, named frame, or frame number.
     *
     * @param frameOrSequence The frame number or animation name that the playhead should move to and stop.
     */
	public void gotoAndStop(String frameOrSequence) { overlay.gotoAndStop(frameOrSequence); }

    /**
     * Play the bitmap sequence.
     */
    public void play() { overlay.play(); }

    /**
     * Stop the bitmap sequence.
     */
    public void stop() { overlay.stop(); }

}
