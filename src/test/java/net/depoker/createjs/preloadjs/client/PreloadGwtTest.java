package net.depoker.createjs.preloadjs.client;

import com.google.gwt.junit.client.GWTTestCase;

import java.util.ArrayList;

public class PreloadGwtTest extends GWTTestCase {
  @Override
  public String getModuleName() {
    return "net.depoker.createjs.preloadjs.PreloadGwt";
  }

  public void testInjectLib() {
    assertTrue("First invocation should return true to indicate dom change.", Injector.ensureInjected());
    assertFalse("Sources already injected, should return false.", Injector.ensureInjected());
  }

  public void testLoadManifest() {
    Injector.ensureInjected();
    LoadQueue queue = new LoadQueue(false);
    queue.loadManifest("manifest.json");
    queue.load();
  }

  public void testLoadManifestObject() {
    Injector.ensureInjected();

    ArrayList<LoadItem> items = new ArrayList<>();
    items.add(new LoadItem("about.txt"));
    items.add(new LoadItem("logo.png"));

    Manifest manifest = new Manifest();
    manifest.setPath("assets");
    manifest.setManifest(items);

    LoadQueue queue = new LoadQueue(false);
    queue.loadManifest(manifest);
    queue.load();
  }
}
