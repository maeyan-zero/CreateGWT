package net.depoker.createjs.soundjs.client;

import net.depoker.createjs.soundjs.client.impl.HTMLAudioPluginImpl;
import net.depoker.createjs.soundjs.client.impl.SoundJSImpl;
import com.google.gwt.core.client.GWT;
import com.google.gwt.core.client.ScriptInjector;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

/**
 * The public API for creating sounds, and controlling the overall sound levels, and affecting multiple sounds at once.
 * All SoundJS APIs are static. SoundJS can also be used as a PreloadJS plugin to help preload audio properly.
 * @author Grant Skinner @gskinner. Wrapper by Sam Edge @maeyanZero
 * @version 0.2.0
 */
public class SoundJS {

    /**
     * The duration in milliseconds to determine a timeout.
     */
    public static final int AUDIO_TIMEOUT = SoundJSImpl.getAudioTimeout();

    /**
     * Determine how audio is split, when multiple paths are specified in a source.
     */
    public static final String DELIMITER = SoundJSImpl.getDelimiter();

    /**
     * The interrupt value to use to interrupt any currently playing instance with the same source.
     */
    public static final String INTERRUPT_ANY = SoundJSImpl.getInterruptAny();

    /**
     * The interrupt value to use to interrupt the earliest currently playing instance with the same source.
     */
    public static final String INTERRUPT_EARLY = SoundJSImpl.getInterruptEarly();

    /**
     * The interrupt value to use to interrupt the latest currently playing instance with the same source.
     */
    public static final String INTERRUPT_LATE = SoundJSImpl.getInterruptLate();

    /**
     * The interrupt value to use to interrupt no currently playing instances with the same source.
     */
    public static final String INTERRUPT_NONE = SoundJSImpl.getInterruptNone();

    /**
     * Defines the playState of an instance that failed to play. This is usually caused by a lack of available channels
     * when the interrupt mode was "INTERRUPT_NONE", the playback stalled, or the sound could not be found.
     */
    public static String PLAY_FAILED = SoundJSImpl.getPlayFailed();

    /**
     * Defines the playState of an instance that completed playback.
     */
    public static String PLAY_FINISHED = SoundJSImpl.getPlayFinished();

    /**
     * Defines the playState of an instance that is still initializing.
     */
    public static String PLAY_INITED = SoundJSImpl.getPlayInited();

    /**
     * Defines the playState of an instance that was interrupted by another instance.
     */
    public static String PLAY_INTERRUPTED = SoundJSImpl.getPlayInterrupted();

    /**
     * Defines the playState of an instance that is currently playing or paused.
     */
    public static String PLAY_SUCCEEDED = SoundJSImpl.getPlaySucceeded();

    /**
     * The currently active plugin. If this is null, then no plugin could be initialized. If no plugin was specified,
     * only the HTMLAudioPlugin is tested.
     * @return The active plugin.
     */
    public static final HTMLAudioPlugin getActivePlugin() {
        HTMLAudioPluginImpl overlay = SoundJSImpl.getActivePlugin(); // warning: possible type cast exception if using
        return (overlay != null) ? new HTMLAudioPlugin(overlay) : null;       // different plugins
    }

    /**
     * Play a sound, receive an instance to control.
     * @param src The src or ID of the audio.
     * @param interrupt How to interrupt other instances of audio. Values are defined as constants on SoundJS.
     * @param delay The amount of time to delay the start of the audio. Delay is in milliseconds.
     * @param offset The point to start the audio. Offset is in milliseconds.
     * @param loop Determines how many times the audio loops when it reaches the end of a sound. Default is 0
     *             (no loops). Set to -1 for infinite.
     * @param volume The volume of the sound, between 0 and 1
     * @param pan The left-right pan of the sound (if supported), between -1 (left) and 1 (right)
     * @return A SoundInstance that can be controlled after it is created.
     */
    public static SoundInstance play(String src, String interrupt, int delay, int offset, int loop, int volume, int pan) {
        return new SoundInstance(SoundJSImpl.play(src, interrupt, delay, offset, loop, volume, pan));
    }

    /**
     * Set the volume of all sounds. This sets the volume value of all audio, and is not a "master volume". Use
     * setMasterVolume() instead.
     * @param value The volume to set on all sounds. The acceptable range is 0-1.
     * @return If the volume was set.
     */
    public static boolean setVolume(int value) {
        return SoundJSImpl.setVolume(value, null);
    }

    /**
     * Set the volume of all sounds. This sets the volume value of all audio, and is not a "master volume". Use
     * setMasterVolume() instead.
     * @param value The volume to set on all sounds. The acceptable range is 0-1.
     * @param id The specific sound ID to target.
     * @return If the volume was set.
     */
    public static boolean setVolume(int value, String id) {
        return SoundJSImpl.setVolume(value, id);
    }

    /**
     * Get the master volume. All sounds multiply their current volume against the master volume.
     * @return The master volume
     */
    public static int getMasterVolume() {
        return SoundJSImpl.getMasterVolume();
    }

    /**
     * Mute/Unmute all audio. Note that muted audio still plays at 0 volume, and that this method just sets the mute
     * value of each instance, and not a "global mute".
     * @param isMuted Whether the audio should be muted or not.
     * @return
     */
    public static boolean setMute(boolean isMuted) {
        return SoundJSImpl.setMuted(isMuted, null);
    }

	/**
	 * Is the SoundJS auto instance currently muted?
	 * @return True if the sound is muted.
	 */
	public static boolean isMuted() {
		return SoundJSImpl.isMuted();
	}

    /**
     * Mute/Unmute all audio. Note that muted audio still plays at 0 volume, and that this method just sets the mute
     * value of each instance, and not a "global mute".
     * @param isMuted Whether the audio should be muted or not.
     * @param id The specific sound ID (set) to target.
     * @return If the mute was set.
     */
    public static boolean setMute(boolean isMuted, String id) {
        return SoundJSImpl.setMuted(isMuted, id);
    }

    /**
     * Pause all instances.
     * @return
     */
    public static boolean pause() {
        return SoundJSImpl.pause(null);
    }

    /**
     * Pause all instances.
     * @param id The specific sound ID (set) to target.
     * @return
     */
    public static boolean pause(String id) {
        return SoundJSImpl.pause(id);
    }

    /**
     * Resume all instances. Note that the pause/resume methods do not work independantly of each instance's paused
     * state. If one instance is already paused when the SoundJS.pause method is called, then it will resume when this
     * method is called.
     * @return
     */
    public static boolean resume() {
        return SoundJSImpl.resume(null);
    }

    /**
     * Resume all instances. Note that the pause/resume methods do not work independantly of each instance's paused
     * state. If one instance is already paused when the SoundJS.pause method is called, then it will resume when this
     * method is called.
     * @param id The specific sound ID (set) to target.
     * @return
     */
    public static boolean resume(String id) {
        return SoundJSImpl.resume(id);
    }

    /**
     * Stop all audio (Global stop).
     * @return
     */
    public static boolean stop() {
        return SoundJSImpl.stop(null);
    }

    /**
     * Stop all audio (Global stop).
     * @param id The specific sound ID (set) to target.
     * @return
     */
    public static boolean stop(String id) {
        return SoundJSImpl.stop(id);
    }

    /**
     * Get a SoundInstance by a unique id. It is often useful to store audio instances by id (in form elements for
     * example), so this method provides a useful way to access the instances via their IDs.
     * @param id The id to use as lookup.
     * @return The sound instance with the specified ID.
     */
    public static SoundInstance getInstanceById(String id) {
        return new SoundInstance(SoundJSImpl.getInstanceById(id));
    }

    /**
     * Determines if SoundJS has been initialized, and a plugin has been activated.
     * @return If SoundJS has initialized a plugin.
     */
    public static boolean isReady() {
        return SoundJSImpl.isReady();
    }

	public static void installFlash() {
		SoundJSImpl.installFlashPlugin();
	}


    /**
     * Ensures the EaselJs javascript libraries have been injected into the DOM.
     * This must be called once before invoking any library methods to avoid a undefined type exception.
     * The DOM will only be manipulated if the library has not been injected yet.
     *
     * @return True if this method manipulated the DOM
     */
    public static boolean ensureInjected() {
        if (!SoundJS.isInjected()) {
            ScriptInjector.fromString(SoundJsResources.INSTANCE.soundJsScript().getText())
                          .setWindow(ScriptInjector.TOP_WINDOW)
                          .inject();
            return true;
        }
        return false;
    }

    /**
     * Checks if the EaselJs type definitions are defined, determining if the
     * javascript library has been injected yet.
     *
     * @return True if EaselJs has been injected
     */
    private static native boolean isInjected() /*-{
		// check namespace first
		if ((typeof $wnd.createjs === "undefined") || (null === $wnd.createjs)) return false;
		// namespace exists, assume if DisplayObject is defined then the entire easeljs lib is injected
		return (!(typeof $wnd.createjs.SoundJS === "undefined") && !(null === $wnd.createjs.SoundJS));
	}-*/;

    public interface SoundJsResources extends ClientBundle
    {
	    SoundJsResources INSTANCE = GWT.create(SoundJsResources.class);

	    @Source("resources/scripts/soundjs-0.3.0.min.js") TextResource soundJsScript();

	    @Source("resources/scripts/soundjs.flashplugin-0.3.0.min.js")
	    TextResource flashPluginScript();
    }
}
