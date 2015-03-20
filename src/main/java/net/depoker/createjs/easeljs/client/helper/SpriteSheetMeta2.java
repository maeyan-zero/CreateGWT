package net.depoker.createjs.easeljs.client.helper;

import net.depoker.createjs.easeljs.client.helper.impl.SpriteSheetMetaImpl;
import com.google.gwt.core.client.JavaScriptObject;

public class SpriteSheetMeta2
{
	private final SpriteSheetMetaImpl overlay;

	public SpriteSheetMeta2(String path, int width, int height, int count, int regX, int regY)
	{
		overlay = SpriteSheetMetaImpl.create(path, width, height, count, regX, regY);
	}

	public void setAnimation(JavaScriptObject animation)
	{
		overlay.setAnimation(animation);
	}

	public SpriteSheetMetaImpl getOverlay()
	{
		return overlay;
	}
}
