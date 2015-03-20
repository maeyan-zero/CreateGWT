package net.depoker.createjs.easeljs.client.helper;

import net.depoker.createjs.easeljs.client.display.impl.SpriteImpl;

public interface AnimationCallback {
    void onAnimationEnd(SpriteImpl instance, String name);
}
