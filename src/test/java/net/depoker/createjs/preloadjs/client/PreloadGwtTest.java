package net.depoker.createjs.preloadjs.client;

import com.google.gwt.junit.client.GWTTestCase;

import java.util.ArrayList;

public class PreloadGwtTest extends GWTTestCase {
  @Override
  public String getModuleName() {
    return "net.depoker.createjs.preloadjs.PreloadGwt";
  }

  public void testInjectLib() {
    assertTrue("First invocation should return true to indicate dom change.", PreloadJs.ensureInjected());
    assertFalse("Sources already injected, should return false.", PreloadJs.ensureInjected());
  }

  public void testLoadManifest() {
	  PreloadJs.ensureInjected();
    LoadQueue queue = new LoadQueue(false);
    queue.loadManifest("manifest.json");
    queue.load();
  }

  public void testLoadManifestObject() {
	  PreloadJs.ensureInjected();

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
