package net.depoker.createjs.preloadjs.client;

import net.depoker.createjs.common.client.Event;
import net.depoker.createjs.common.client.EventListener;
import net.depoker.createjs.preloadjs.client.event.FileProgressEvent;
import net.depoker.createjs.preloadjs.client.event.FileProgressListener;
import net.depoker.createjs.preloadjs.client.event.FileStartEvent;
import net.depoker.createjs.preloadjs.client.event.FileStartListener;
import net.depoker.createjs.preloadjs.client.impl.LoadItemImpl;
import net.depoker.createjs.preloadjs.client.impl.LoadQueueImpl;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class LoadQueue extends AbstractLoader {
  private final LoadQueueImpl impl;

  public LoadQueue() {
    super(LoadQueueImpl.create());
    this.impl = (LoadQueueImpl) super.getImpl();
  }

  public LoadQueue(JavaScriptObject impl) {
    super(impl);
    this.impl = getImpl().cast();
  }

  public LoadQueue(boolean preferXhr) {
    super(LoadQueueImpl.create(preferXhr));
    this.impl = super.getImpl().cast();
  }

  public LoadQueue(boolean preferXhr, @NotNull String basePath) {
    super(LoadQueueImpl.create(preferXhr, basePath));
    this.impl = super.getImpl().cast();
  }

  //
  // methods:
  //

  public void close() {
    impl.close();
  }

  public List<LoadItem> getItems(boolean loaded) {
    JsArray<LoadItemImpl> jsArray = impl.getItems(loaded).cast();
    ArrayList<LoadItem> result = new ArrayList<>();
    for (int i = 0; i < jsArray.length(); i++) {
      LoadItem loadItem = new LoadItem(jsArray.get(i));
      result.add(loadItem);
    }
    return result;
  }

  public void installPlugin(JavaScriptObject plugin) {
    impl.installPlugin(plugin);
  }

  public void loadFile(String path) {
    impl.loadFile(path);
  }

  public void loadFile(String path, boolean loadNow) {
    impl.loadFile(path, loadNow);
  }

  public void loadFile(LoadItem loadItem) {
    impl.loadFile(loadItem.getImpl());
  }

  public void loadFile(LoadItem loadItem, boolean loadNow) {
    impl.loadFile(loadItem.getImpl(), loadNow);
  }

  public void loadManifest(String path) {
    impl.loadManifest(path);
  }

  public void loadManifest(String path, boolean loadNow) {
    impl.loadManifest(path, loadNow);
  }

  public void loadManifest(Manifest manifest) {
    impl.loadManifest(manifest.getImpl());
  }

  public void loadManifest(Manifest manifest, boolean loadNow) {
    impl.loadManifest(manifest.getImpl(), loadNow);
  }

  public void registerLoader(AbstractLoader loader) {
    impl.registerLoader(loader.getImpl());
  }

  public void remove(String idsOrUrls) {
    impl.remove(idsOrUrls);
  }

  public void removeAll() {
    impl.removeAll();
  }

  public void reset() {
    impl.reset();
  }

  public void setMaxConnections(int value) {
    impl.setMaxConnections(value);
  }

  public void setPaused(int value) {
    impl.setPaused(value);
  }

  public void setPreferXHR(boolean value) {
    impl.setPreferXHR(value);
  }

  public void unregisterLoader(AbstractLoader loader) {
    impl.unregisterLoader(loader.getImpl());
  }

  //
  // properties:
  //

  public boolean isMaintainScriptOrder() {
    return impl.maintainScriptOrder();
  }

  public LoadQueue getNext() {
    return new LoadQueue(impl.next());
  }

  public boolean isStopOnError() {
    return impl.stopOnError();
  }

  //
  // events:
  //

  public void addFileProgressListener(@NotNull final FileProgressListener listener) {
    addEventListener(EventType.FILE_PROGRESS.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onFileProgress(new FileProgressEvent(event));
      }
    });
  }

  public void addFileStartListener(@NotNull final FileStartListener listener) {
    addEventListener(EventType.FILE_START.toString(), new EventListener() {
      @Override public void handleEvent(Event event) {
        listener.onFileStart(new FileStartEvent(event));
      }
    });
  }
}
