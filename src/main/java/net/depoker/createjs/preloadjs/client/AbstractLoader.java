/*
 * The MIT License (MIT)
 *
 * Copyright (c) [2015] [Sam Edge]
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package net.depoker.createjs.preloadjs.client;

import net.depoker.createjs.common.client.Event;
import net.depoker.createjs.common.client.EventDispatcher;
import net.depoker.createjs.common.client.EventListener;
import net.depoker.createjs.preloadjs.client.impl.AbstractLoaderImpl;
import net.depoker.createjs.preloadjs.client.impl.LoadItemImpl;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import net.depoker.createjs.preloadjs.client.event.*;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AbstractLoader extends EventDispatcher {
  private final AbstractLoaderImpl impl;

  AbstractLoader(@NotNull JavaScriptObject impl) {
    super(impl);
    this.impl = impl.cast();
  }

  //
  // methods:
  //

  public void cancel() {
    impl.cancel();
  }

  public void destroy() {
    impl.destroy();
  }

  public @NotNull LoadItem getItem(@NotNull String value) {
    return new LoadItem(impl.getItem(value));
  }

  public @NotNull List<LoadItem> getLoadedItems() {
    JsArray<LoadItemImpl> jsArray = impl.getLoadedItems().cast();
    ArrayList<LoadItem> loadedItems = new ArrayList<>();
    for (int i = 0; i < jsArray.length(); i++) {
      LoadItem loadItem = new LoadItem(jsArray.get(i));
      loadedItems.add(loadItem);
    }
    return loadedItems;
  }

  public @Nullable JavaScriptObject getResult() {
    return impl.getResult();
  }

  public @Nullable JavaScriptObject getResult(boolean raw) {
    return impl.getResult(raw);
  }

  public @NotNull JavaScriptObject getTag() {
    return impl.getTag();
  }

  public void load() {
    impl.load();
  }

  public void setTag(@NotNull JavaScriptObject tag) {
    impl.setTag(tag);
  }

  //
  // properties
  //

  public boolean isCanceled() {
    return impl.canceled();
  }

  public boolean isLoaded() {
    return impl.loaded();
  }

  public double getProgress() {
    return impl.progress();
  }

  // TODO: Implement result formatter:
  // TODO: http://www.createjs.com/Docs/PreloadJS/classes/AbstractLoader.html#property_resultFormatter

  public @NotNull AbstractLoaderImpl getImpl() {
    return impl;
  }

  //
  // events:
  //

  public void addCompleteListener(@NotNull final CompleteListener listener) {
    addEventListener(EventType.COMPLETE.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onComplete(new CompleteEvent(event));
      }
    });
  }

  public void addErrorListener(@NotNull final ErrorListener listener) {
    addEventListener(EventType.ERROR.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onError(new ErrorEvent(event));
      }
    });
  }

  public void addFileErrorListener(@NotNull final FileErrorListener listener) {
    addEventListener(EventType.FILE_ERROR.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onFileError(new FileErrorEvent(event));
      }
    });
  }

  public void addFileLoadListener(@NotNull final FileLoadListener listener) {
    addEventListener(EventType.FILE_LOAD.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onFileLoad(new FileLoadEvent(event));
      }
    });
  }

  public void addInitializeListener(@NotNull final InitializeListener listener) {
    addEventListener(EventType.INITIALIZE.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onInitialize(new InitializeEvent(event));
      }
    });
  }

  public void addLoadStartListener(@NotNull final LoadStartListener listener) {
    addEventListener(EventType.FILE_LOAD.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onLoadStart(new LoadStartEvent(event));
      }
    });
  }

  public void addProgressListener(@NotNull final ProgressListener listener) {
    addEventListener(EventType.PROGRESS.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onProgress(new ProgressEvent(event));
      }
    });
  }
}