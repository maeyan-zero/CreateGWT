package net.depoker.createjs.preloadjs.client;

import net.depoker.createjs.preloadjs.client.impl.LoadItemImpl;
import net.depoker.createjs.preloadjs.client.impl.ManifestImpl;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.List;

public class Manifest {
  protected final ManifestImpl impl;

  public Manifest() {
    impl = (ManifestImpl) ManifestImpl.createObject();
  }

  protected Manifest(ManifestImpl impl) {
    this.impl = impl;
  }

  public ManifestImpl getImpl() {
    return impl;
  }

  public List<LoadItem> getManifest() {
    ArrayList<LoadItem> list = new ArrayList<>();
    JsArray<LoadItemImpl> array = impl.getManifest();
    for (int i = 0; i < array.length(); i++) {
      list.add(new LoadItem(array.get(i)));
    }
    return list;
  }

  public String getPath() {
    return impl.getPath();
  }

  public void setManifest(List<LoadItem> manifest) {
    JsArray<LoadItemImpl> array = JavaScriptObject.createArray().cast();
    for (LoadItem loadItem : manifest) {
      array.push(loadItem.getImpl());
    }
    impl.setManifest(array);
  }

  public void setPath(String path) {
    impl.setPath(path);
  }
}
