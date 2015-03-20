package net.depoker.createjs.soundjs.client;


import net.depoker.createjs.soundjs.client.impl.HTMLAudioPluginImpl;
import net.depoker.createjs.soundjs.client.impl.SoundInstanceImpl;

/**
 * Sound Instances are created when any calls to SoundJS.play() are made. The instances are returned by the active
 * plugin for control by the user. Users can control audio directly through the instance.
 */
public class SoundInstance {

    SoundInstanceImpl overlay;

    /**
     * The plugin that created the instance. Note that this GWT wrapper only support the HTMLAudio plugin.
     * @return The plugin that created the instance.
     */
    public HTMLAudioPluginImpl getOwner() {
        return overlay.getOwner();
    }

    /**
     * Create a SountInstance using the overlay returned from SoundJS.play.
     * @param overlay The SoundInstanceImpl overlay.
     */
    public SoundInstance(SoundInstanceImpl overlay) {
        this.overlay = overlay;
    }

    /**
     * The play state of the sound. Play states are defined as constants on SoundJS
     * @return The play state.
     */
    public String getPlayState() {
        return overlay.getPlayState();
    }

    /**
     * The source of the sound.
     * @return The sound source.
     */
    public String getSrc() {
        return overlay.getSrc();
    }

    /**
     * The unique ID of the instance.
     * @return The unique ID.
     */
    public String getUniqueId() {
        return overlay.getUniqueId();
    }

    /**
     * Get the duration of the sound instance.
     * @return The duration of the sound instance in milliseconds.
     */
    public int getDuration() {
        return overlay.getDuration();
    }

    /**
     * Get the pan of a sound instance. Note that this does not work in HTML audio.
     * @return The value of the pan between -1 (left) and 1 (right).
     */
    public int getPan() {
        return overlay.getPan();
    }

    /**
     * Get the position of the playhead in the sound instance.
     * @return The position of the playhead in milliseconds.
     */
    public int getPosition() {
        return overlay.getPosition();
    }

    /**
     * Get the volume of the sound, not including how the master volume has affected it.
     * @return The volume.
     */
    public int getVolume() {
        return overlay.getVolume();
    }

    /**
     * Mute the sound.
     * @param isMuted If the sound should be muted or not.
     * @return If the mute call succeeds.
     */
    public boolean mute(boolean isMuted) {
        return overlay.mute(isMuted);
    }

    /**
     * Pause the instance.
     * @return If the pause call succeeds.
     */
    public boolean pause() {
        return overlay.pause();
    }

    /**
     * Play an instance. This API is only used to play an instance after it has been stopped or interrupted.
     * @param interrupt How this sound interrupts other instances with the same source. Interrupt values are defined as
     *                  constants on SoundJS.
     * @param delay The delay in milliseconds before the sound starts.
     * @param offset How far into the sound to begin playback.
     * @param loop The number of times to loop the audio. Use -1 for infinite loops.
     * @param volume The volume of the sound between 0 and 1.
     * @param pan The pan of the sound between -1 and 1. Note that pan does not work for HTML Audio.
     */
    public void play(String interrupt, int delay, int offset, int loop, int volume, int pan) {
        overlay.play(interrupt, delay, offset, loop, volume, pan);
    }

    /**
     * Resume a sound instance that has been paused.
     * @return If the resume call succeeds.
     */
    public boolean resume() {
        return overlay.resume();
    }

    /**
     * Set the pan of a sound instance. Note that this does not work in HTML audio.
     * @param value The pan value between -1 (left) and 1 (right).
     * @return If the setPan call succeeds.
     */
    public int setPan(int value) {
        return overlay.setPan(value);
    }

    /**
     * Set the position of the playhead in the sound instance.
     * @param value The position of the playhead in milliseconds.
     */
    public void setPosition(int value) {
        overlay.setPosition(value);
    }

    /**
     * Set the volume of the sound instance.
     * @param value Level of volume.
     * @return If the setVolume call succeeds.
     */
    public boolean setVolume(int value) {
        return overlay.setVolume(value);
    }

    /**
     * Stop a sound instance.
     * @return If the stop call succeeds.
     */
    public boolean stop() {
        return overlay.stop();
    }

    /**
     * The callback that is fired when a sound has completed playback
     * @param callback
     */
    public void setOnLoopCallback(Callback callback) {
        overlay.setOnLoopCallback(callback);
    }

    /**
     * The callback that is fired when a sound has completed playback, but has loops remaining.
     * @param callback
     */
    public void setOnCompleteCallback(Callback callback) {
        overlay.setOnCompleteCallback(callback);
    }

    /**
     * The callback that is fired when a sound has failed to start.
     * @param callback
     */
    public void setOnReadyCallback(Callback callback) {
        overlay.setOnReadyCallback(callback);
    }

    /**
     * The callback that is fired when a sound has failed to start.
     * @param callback
     */
    public void setOnPlayFailedCallback(Callback callback) {
        overlay.setOnPlayFailedCallback(callback);
    }

    /**
     * The callback that is fired when a sound has been interrupted.
     * @param callback
     */
    public void setOnPlayInterruptedCallback(Callback callback) {
        overlay.setOnPlayInterruptedCallback(callback);
    }
}
