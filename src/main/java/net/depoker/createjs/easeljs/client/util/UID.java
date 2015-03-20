package net.depoker.createjs.easeljs.client.util;

import net.depoker.createjs.easeljs.client.util.impl.UIDImpl;

/**
 * Global utility for generating sequential unique ID numbers.
 * <p>The UID class uses a static interface (ex. UID.get()) and should not be instantiated.</p>
 */
public class UID {

	/**
	 * Returns the next unique id.
	 * @return The next unique id.
	 */
	public static int get() {
		return UIDImpl.get();
	}
	
}
