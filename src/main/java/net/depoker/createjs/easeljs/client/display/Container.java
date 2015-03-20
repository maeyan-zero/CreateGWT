package net.depoker.createjs.easeljs.client.display;

import net.depoker.createjs.easeljs.client.display.impl.*;
import com.google.gwt.core.client.JsArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * A Container is a nestable display lists that allows you to work with compound display elements. For example you
 * could group arm, leg, torso and head Bitmaps together into a Person Container, and transform them as a group, while
 * still being able to move the individual parts relative to each other. Children of containers have their transform
 * and alpha properties concatenated with their parent Container. For example, a Shape with x=100 and alpha=0.5,
 * placed in a Container with x=50 and alpha=0.7 will be rendered to the canvas at x=150 and alpha=0.35. Containers
 * have some overhead, so you generally shouldn't create a Container to hold a single child.
 */
public class Container extends DisplayObject {

	private final ArrayList<DisplayObject> children = new ArrayList<DisplayObject>();

	private final ContainerImpl overlay;

	public Container() {
		this(ContainerImpl.create());
	}

	public Container(ContainerImpl impl) {
		super(impl);
		overlay = impl;
	}

	/**
	 * Returns all display objects nested in the container.
	 *
	 * @return All display objects nested in the container.
	 */
	public ArrayList<DisplayObject> getChildren() { return children; }

    /**
     * Adds a child to the top of the display list. You can also add multiple children, such as "addChild(child1, child2, ...);".
     * Returns the child that was added, or the last child if multiple children were added.
     *
     * @param child The display object to add.
     * @return The child that was added, or the last child if multiple children were added.
     */
    public DisplayObject addChild(DisplayObject child) {
	    if (child == null) return null;
	    DisplayObjectImpl impl = overlay.addChild(child.getOverlay());
	    if (impl != null) children.add(child);
	    return (impl != null) ? child : null;
	}

    /**
     * Adds a child to the display list at the specified index, bumping children at equal or greater indexes up one, and
     * setting its parent to this Container. You can also add multiple children, such as "addChildAt(child1, child2, ..., index);".
     * The index must be between 0 and numChildren. For example, to add myShape under otherShape in the display list,
     * you could use: container.addChildAt(myShape, container.getChildIndex(otherShape)). This would also bump otherShape's
     * index up by one. Returns the last child that was added, or the last child if multiple children were added.
     *
     * @param child The display object to add.
     * @param index The index to add the child at.
     * @return The child that was added, or the last child if multiple children were added.
     */
	public DisplayObject addChildAt(DisplayObject child, int index) {
		if (child == null) return null;
		DisplayObjectImpl impl = overlay.addChildAt(child.getOverlay(), index);
		if (impl != null) children.add(index, child);
		return (impl != null) ? child : null;
	}

	/**
	 * Removes the specified child from the display list. Note that it is faster to use removeChildAt() if the index is
	 * already known. You can also remove multiple children, such as "removeChild(child1, child2, ...);". Returns true
	 * if the child (or children) was removed, or false if it was not in the display list.
	 *
	 * @param child The child to remove.
	 * @return true if the child (or children) was removed, or false if it was not in the display list.
	 */
	public boolean removeChild(DisplayObject child) {
		if (child == null) return false;
		boolean result = overlay.removeChild(child.getOverlay());
		if (result) children.remove(child);
		return result;
	}

	/**
	 * Removes the child at the specified index from the display list, and sets its parent to null. You can also remove
	 * multiple children, such as "removeChildAt(2, 7, ...);". Returns true if the child (or children) was removed, or
	 * false if any index was out of range.
	 *
	 * @param index The index of the child to remove.
	 * @return Returns true if the child (or children) was removed, or false if any index was out of range.
	 */
	public boolean removeChildAt(int index) {
		boolean result = overlay.removeChildAt(index);
		if (result) children.remove(index);
		return result;
	}

	/**
	 * Removes all children from the display list.
	 */
	public void removeAllChildren() {
		children.clear();
		overlay.removeAllChildren();
	}

	/**
	 * Returns the child at the specified index.
	 *
	 * @param index The index of the child to return.
	 * @return The child at the specified index.
	 */
	public DisplayObject getChildAt(int index) {
		DisplayObjectImpl impl = overlay.getChildAt(index);
		return (impl != null) ? children.get(index) : null;
	}

	/**
	 * Returns the index of the specified child in the display list, or -1 if it is not in the display list.
	 *
	 * @param child The child to return the index of.
	 * @return The index of the specified child. -1 if the child is not found.
	 */
	public int getChildIndex(DisplayObject child) {
		return overlay.getChildIndex(child.getOverlay());
	}

	/**
	 * Returns the child with the specified name.
	 *
	 * @param name The name of the child to return.
	 * @return The child with the specified name.
	 */
	public DisplayObject getChildByName(String name) {
		DisplayObjectImpl impl = overlay.getChildByName(name);
		if (impl == null) return null;
		int index = overlay.getChildIndex(impl);
		return children.get(index);
	}

	/**
	 * Performs an array sort operation on the child list.
	 *
	 * @param sortFunction the function to use to sort the child list
	 */
	public void sortChildren(Comparator<DisplayObject> sortFunction) {
		Collections.sort(children, sortFunction);
		overlay.sortChildren(sortFunction);
	}

	/**
	 * Returns the number of children in the display list.
	 *
	 * @return The number of children in the display list.
	 */
	public int getNumChildren() {
		return overlay.getNumChildren();
	}

	/**
	 * Swaps the children at the specified indexes. Fails silently if either index is out of range.
	 *
	 * @param index1 Child index 1
	 * @param index2 Child index 2
	 */
	public void swapChildrenAt(int index1, int index2) {
		Collections.swap(children, index1, index2);
		overlay.swapChildrenAt(index1, index2);
	}

	/**
	 * Swaps the specified children's depth in the display list. Fails silently if either child is not a child of this
	 * Container.
	 *
	 * @param child1 Child display object 1
	 * @param child2 Child display object 2
	 */
	public void swapChildren(DisplayObject child1, DisplayObject child2) {
		int index1 = children.indexOf(child1);
		int index2 = children.indexOf(child2);
		if (index1 == -1 || index2 == -1) return;
		Collections.swap(children, index1, index2);
		overlay.swapChildren(child1.getOverlay(), child2.getOverlay());
	}

	/**
	 * Changes the depth of the specified child. Fails silently if the child is not a child of this container, or the
	 * index is out of range.
	 *
	 * @param child The child display object
	 * @param index The index set the child
	 */
	public void setChildIndex(DisplayObject child, int index) {
		children.set(index, child);
		overlay.setChildIndex(child.getOverlay(), index);
	}

	/**
	 * Returns true if the specified display object either is this container or is a descendent. (child, grandchild,
	 * etc) of this container.
	 *
	 * @param child The DisplayObject to be checked.
	 * @return true if the specified display object either is this container or is a descendent.
	 */
	public boolean contains(DisplayObject child) {
		return overlay.contains(child.getOverlay());
	}

    /**
     * Returns an array of all display objects under the specified coordinates that are in this container's display
     * list. This routine ignores any display objects with mouseEnabled set to false. The array will be sorted in order
     * of visual depth, with the top-most display object at index 0. This uses shape based hit detection, and can be an
     * expensive operation to run, so it is best to use it carefully. For example, if testing for objects under the
     * mouse, test on tick (instead of on mousemove), and only if the mouse's position has changed.
     *
     * @param x The x position in the container to test.
     * @param y The y position in the container to test.
     * @return An Array of DisplayObjects under the specified coordinates.
     */
    public ArrayList<DisplayObject> getObjectsUnderPoint(double x, double y) {
        JsArray<DisplayObjectImpl> jsArray = overlay.getObjectsUnderPoint(x, y);
        ArrayList<DisplayObject> arrayList = new ArrayList<DisplayObject>();

        for (int i = 0; i < jsArray.length(); i++) {
	        arrayList.add(new DisplayObject(jsArray.get(i)));
        }

        return arrayList;
    }

    /**
     * Similar to getObjectsUnderPoint(), but returns only the top-most display object. This runs significantly faster
     * than getObjectsUnderPoint(), but is still an expensive operation. See getObjectsUnderPoint() for more information.
     *
     * @param x The x position in the container to test.
     * @param y The y position in the container to test.
     * @return The top-most display object under the specified coordinates.
     */
    public DisplayObject getObjectUnderPoint(double x, double y) {
        DisplayObjectImpl impl = overlay.getObjectUnderPoint(x, y);
	    if (impl == null) return null;
	    int index = overlay.getChildIndex(impl);
	    return children.get(index);
    }

	/**
	 * Returns a clone of this Container. Some properties that are specific to this instance's current context are
	 * reverted to their defaults (for example .parent).
	 *
	 * @param recursive If true, all of the descendants of this container will be cloned recursively. If false, the
	 *                  properties of the container will be cloned, but the new instance will not have any children.
	 * @return A clone of the current Container instance.
	 */
	public Container clone(boolean recursive) {
		return new Container(overlay.clone(recursive));
	}

	/**
	 * Helper function to wrap the sort function implementation parameters.
	 *
	 * @param sortFunction The sort function to call
	 * @param a            Passed display object implementation 1
	 * @param b            Passed display object implementation 2
	 */
	private static void fireSort(Comparator<DisplayObject> sortFunction, DisplayObjectImpl a, DisplayObjectImpl b) {
		sortFunction.compare(new DisplayObject(a), new DisplayObject(b));
	}

}
