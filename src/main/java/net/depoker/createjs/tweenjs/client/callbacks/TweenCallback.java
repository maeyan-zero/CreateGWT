package net.depoker.createjs.tweenjs.client.callbacks;

import net.depoker.createjs.tweenjs.client.impl.TweenImpl;

/**
 * Implement this interface for Tween callback functions.
 */
public interface TweenCallback
{

    /**
     * The handler to execute on callback.
     */
    void run(TweenImpl instance);

}
