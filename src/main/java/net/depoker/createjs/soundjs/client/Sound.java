/*
 * Copyright 2012-2015 Double Edged Poker
 */

package net.depoker.createjs.soundjs.client;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import com.google.gwt.core.client.JsArrayString;
import net.depoker.createjs.common.client.Event;
import net.depoker.createjs.common.client.EventListener;
import net.depoker.createjs.common.client.impl.EventListenerImpl;
import net.depoker.createjs.soundjs.client.event.FileErrorEvent;
import net.depoker.createjs.soundjs.client.event.FileErrorListener;
import net.depoker.createjs.soundjs.client.event.FileLoadEvent;
import net.depoker.createjs.soundjs.client.event.FileLoadListener;
import net.depoker.createjs.soundjs.client.impl.SoundImpl;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Sound {
	enum EventType {
		FILE_ERROR("fileerror"),
		FILE_LOAD("fileload");

		private final String string;

		EventType(String string) {
			this.string = string;
		}

		@Override public String toString() {
			return string;
		}
	}

	//
	// Events:
	//

	public static EventListenerImpl addFileLoadListener(final FileLoadListener listener) {
		return addEventListener(EventType.FILE_LOAD.toString(), new EventListener() {
			@Override public void handleEvent(Event event) {
				listener.onFileLoad(new FileLoadEvent(event));
			}
		});
	}

	public static EventListenerImpl addFileErrorListener(final FileErrorListener listener) {
		return addEventListener(EventType.FILE_ERROR.toString(), new EventListener() {
			@Override public void handleEvent(Event event) {
				listener.onFileError(new FileErrorEvent(event));
			}
		});
	}

	//
	// Methods:
	//

	public AbstractSoundInstance createInstance(String src) {
		return new AbstractSoundInstance( SoundImpl.createInstance(src) );
	}

	public AbstractSoundInstance createInstance(String src, int startTime) {
		return new AbstractSoundInstance( SoundImpl.createInstance(src, startTime) );
	}

	public AbstractSoundInstance createInstance(String src, int startTime, int duration) {
		return new AbstractSoundInstance( SoundImpl.createInstance(src, startTime, duration) );
	}

	public static boolean dispatchEvent(String type) {
		return SoundImpl.dispatchEvent(type);
	}

	public static boolean dispatchEvent(Event event) {
		return SoundImpl.dispatchEvent(event.getImpl());
	}

	public static JavaScriptObject getCapabilities() {
		return SoundImpl.getCapabilities();
	}

	public static boolean getCapability(String key) {
		return SoundImpl.getCapability( key );
	}

	public static boolean getMute() {
		return SoundImpl.getMute();
	}

	public static double getVolume() {
		return SoundImpl.getVolume();
	}

	public static boolean hasEventListener(@NotNull EventType eventType) {
		return SoundImpl.hasEventListener(eventType.toString());
	}

	public static boolean initializeDefaultPlugins() {
		return SoundImpl.initializeDefaultPlugins();
	}

	public static boolean isReady() {
		return SoundImpl.isReady();
	}

	public static boolean loadComplete(String src) {
		return SoundImpl.loadComplete( src );
	}

	public static void off(EventType type, EventListenerImpl listener) {
		SoundImpl.off(type.toString(), listener);
	}

	public static void off(EventType type, EventListenerImpl listener, boolean useCapture) {
		SoundImpl.off(type.toString(), listener, useCapture);
	}

	public static EventListenerImpl on(EventType type, EventListener listener) {
		return SoundImpl.on(type.toString(), EventListenerImpl.create(listener)).cast();
	}

	public static EventListenerImpl on(EventType type, EventListener listener, JavaScriptObject scope) {
		return SoundImpl.on(type.toString(), EventListenerImpl.create(listener), scope).cast();
	}

	public static EventListenerImpl on(EventType type, EventListener listener, JavaScriptObject scope, boolean once) {
		return SoundImpl.on(type.toString(), EventListenerImpl.create(listener), scope, once).cast();
	}

	public static EventListenerImpl on(EventType type, EventListener listener, JavaScriptObject scope, boolean once, JavaScriptObject data) {
		return SoundImpl.on(type.toString(), EventListenerImpl.create(listener), scope, once, data).cast();
	}

	public static EventListenerImpl on(EventType type, EventListener listener, JavaScriptObject scope, boolean once, JavaScriptObject data, boolean useCapture) {
		return SoundImpl.on(type.toString(), EventListenerImpl.create(listener), scope, once, data, useCapture).cast();
	}

	public static AbstractSoundInstance play(String src) {
		return new AbstractSoundInstance( SoundImpl.play(src) );
	}

	public static AbstractSoundInstance play(String src, PlayOptions options) {
		return new AbstractSoundInstance( SoundImpl.play(src, options.impl) );
	}

	public static AbstractSoundInstance play(String src, Interrupt interrupt) {
		return new AbstractSoundInstance( SoundImpl.play(src, interrupt.toString()) );
	}

	public static AbstractSoundInstance play(String src, Interrupt interrupt, int delay) {
		return new AbstractSoundInstance( SoundImpl.play(src, interrupt.toString(), delay) );
	}

	public static AbstractSoundInstance play(String src, Interrupt interrupt, int delay, int offset) {
		return new AbstractSoundInstance( SoundImpl.play(src, interrupt.toString(), delay, offset) );
	}

	public static AbstractSoundInstance play(String src, Interrupt interrupt, int delay, int offset, int loop) {
		return new AbstractSoundInstance( SoundImpl.play(src, interrupt.toString(), delay, offset, loop) );
	}

	public static AbstractSoundInstance play(String src, Interrupt interrupt, int delay, int offset, int loop, double volume) {
		return new AbstractSoundInstance( SoundImpl.play(src, interrupt.toString(), delay, offset, loop, volume) );
	}

	public static AbstractSoundInstance play(String src, Interrupt interrupt, int delay, int offset, int loop, double volume, double pan) {
		return new AbstractSoundInstance( SoundImpl.play(src, interrupt.toString(), delay, offset, loop, volume, pan) );
	}

	public static JavaScriptObject registerManifest(List<JavaScriptObject> sounds, String basePath) {
		JsArray<JavaScriptObject> soundsArray = JsArray.createArray().cast();
		for (JavaScriptObject sound : sounds) {
			soundsArray.push( sound );
		}
		return SoundImpl.registerSounds( soundsArray, basePath );
	}

	public static boolean registerPlugins(List<JavaScriptObject> plugins ) {
		JsArray<JavaScriptObject> pluginsArray = JsArray.createArray().cast();
		for (JavaScriptObject plugin : plugins) {
			pluginsArray.push( plugin );
		}
		return SoundImpl.registerPlugins( pluginsArray );
	}

	public static JavaScriptObject registerSound(String src, String basePath) {
		return SoundImpl.registerSound( src, basePath );
	}

	public static JavaScriptObject registerSound(String src, String id, String basePath) {
		return SoundImpl.registerSound( src, id, basePath );
	}

	public static JavaScriptObject registerSound(String src, String id, JavaScriptObject data, String basePath) {
		return SoundImpl.registerSound( src, id, data, basePath );
	}

	public static void removeAllEventListeners() {
		SoundImpl.removeAllEventListeners();
	}

	public static void removeAllFileLoadEventListeners() {
		SoundImpl.removeAllEventListeners( EventType.FILE_LOAD.toString() );
	}

	public static void removeFileLoadEventListener(EventListenerImpl listener) {
		SoundImpl.removeEventListener( EventType.FILE_LOAD.toString(), listener );
	}

	public static void removeFileLoadEventListener(EventListenerImpl listener, boolean useCapture) {
		SoundImpl.removeEventListener( EventType.FILE_LOAD.toString(), listener, useCapture );
	}

	public static void removeAllFileErrorEventListeners() {
		SoundImpl.removeAllEventListeners( EventType.FILE_ERROR.toString() );
	}

	public static void removeFileErrorEventListener(EventListenerImpl listener) {
		SoundImpl.removeEventListener( EventType.FILE_ERROR.toString(), listener );
	}

	public static void removeFileErrorEventListener(EventListenerImpl listener, boolean useCapture) {
		SoundImpl.removeEventListener( EventType.FILE_ERROR.toString(), listener, useCapture );
	}

	public static void removeAllSounds() {
		SoundImpl.removeAllSounds();
	}

	public static boolean removeSound(String src, String basePath) {
		return SoundImpl.removeSound( src, basePath );
	}

	public static boolean removeSound(JavaScriptObject src, String basePath) {
		return SoundImpl.removeSound( src, basePath );
	}

	public static boolean setMute(boolean value) {
		return SoundImpl.setMute( value );
	}

	public static void setVolume(double value) {
		SoundImpl.setVolume( value );
	}

	public static void stop() {
		SoundImpl.stop();
	}

	public static boolean willTrigger(EventType type) {
		return SoundImpl.willTrigger(type.toString());
	}

	//
	// Private Helpers
	//

	private static EventListenerImpl addEventListener(String type, EventListener listener) {
		return SoundImpl.addEventListener(type, EventListenerImpl.create(listener)).cast();
	}

	private static EventListenerImpl addEventListener(String type, EventListener listener, boolean useCapture) {
		return SoundImpl.addEventListener(type, EventListenerImpl.create(listener), useCapture).cast();
	}

	//
	// properties:
	//

	public static AbstractPlugin getActivePlugin() {
		return new AbstractPlugin( SoundImpl.activePlugin() );
	}

	public static List<String> getSupportedExtensions() {
		JsArrayString extensionsArray = SoundImpl.supportedExtensions();
		ArrayList<String> extensions = new ArrayList<>();
		for (int i = 0; i < extensionsArray.length(); i++) {
			extensions.add( extensionsArray.get(i) );
		}
		return extensions;
	}
}
