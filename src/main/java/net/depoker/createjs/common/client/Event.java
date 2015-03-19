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

package net.depoker.createjs.common.client;

import net.depoker.createjs.common.client.impl.EventImpl;
import com.google.gwt.core.client.JavaScriptObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Date;

public abstract class Event {
  private final EventImpl impl;

  /**
   * Contains properties and methods shared by all events for use with EventDispatcher.
   *
   * <p>Note that Event objects are often reused, so you should never rely on an event object's state outside of the
   * call stack it was received in.</p>
   *
   * @param type The type of event.
   * @param bubbles Indicates whether the event will bubble through the display list.
   * @param cancelable Indicates whether the default behaviour of this event can be cancelled.
   */
  public Event(@NotNull String type, boolean bubbles, boolean cancelable) {
    impl = EventImpl.create(type, bubbles, cancelable);
  }

  /**
   * Contains properties and methods shared by all events for use with EventDispatcher.
   *
   * <p>Note that Event objects are often reused, so you should never rely on an event object's state outside of the
   * call stack it was received in.</p>
   *
   * @param impl Javascript instance of an {@link Event} type.
   */
  public Event(@NotNull JavaScriptObject impl) {
    this.impl = impl.cast();
  }

  //
  // methods:
  //

  // TODO: Unit test clone method

  /**
   * Sets Event/defaultPrevented to true. Mirrors the DOM event standard.
   */
  public void preventDefault() {
    impl.preventDefault();
  }

  /**
   * Causes the active listener to be removed via removeEventListener();
   */
  public void remove() {
    impl.remove();
  }

  /**
   * Provides a chainable shortcut method for setting a number of properties on the instance.
   *
   * @param props A generic object containing properties to copy to the instance.
   * @return The instance the method is called on (useful for chaining calls.)
   */
  public Event set(@NotNull JavaScriptObject props) {
    impl.set(props);
    return this;
  }

  /**
   * Sets Event/propagationStopped and Event/immediatePropagationStopped to true. Mirrors the DOM event standard.
   */
  public void stopImmediatePropagation() {
    impl.stopImmediatePropagation();
  }

  /**
   * Sets Event/propagationStopped to true. Mirrors the DOM event standard.
   */
  public void stopPropagation() {
    impl.stopPropagation();
  }

  /**
   * Returns a string representation of this object.
   *
   * @return A string representation of this object.
   */
  @Override public String toString() {
    return impl.toString();
  }

  //
  // properties:
  //

  /**
   * Indicates whether the event will bubble through the display list.
   *
   * @return Whether the event will bubble through the display list.
   */
  public boolean doesBubble() {
    return impl.bubbles();
  }

  /**
   * Indicates whether the default behaviour of this event can be cancelled via {@link Event#preventDefault()}. This is
   * set via the Event constructor.
   *
   * @return Whether the default behaviour of this event can be cancelled.
   */
  public boolean isCancelable() {
    return impl.cancelable();
  }

  /**
   * The current target that a bubbling event is being dispatched from. For non-bubbling events, this will always be the
   * same as target. For example, if childObj.parent = parentObj, and a bubbling event is generated from childObj, then
   * a listener on parentObj would receive the event with target=childObj (the original target) and
   * currentTarget=parentObj (where the listener was added).
   *
   * @return The current target that a bubbling event is being dispatched from.
   */
  public @Nullable JavaScriptObject getCurrentTarget() {
    return impl.currentTarget();
  }

  /**
   * Indicates if {@link Event#preventDefault()} has been called on this event.
   *
   * @return If preventDefault() has been called on this event.
   */
  public boolean wasDefaultPrevented() {
    return impl.defaultPrevented();
  }

  /**
   * For bubbling events, this indicates the current event phase:
   * <ol>
   *   <li>capture phase: starting from the top parent to the target</li>
   *   <li>at target phase: currently being dispatched from the target</li>
   *   <li>bubbling phase: from the target to the top parent</li>
   * </ol>
   *
   * @return The current event phase:
   */
  public int getEventPhase() {
    return impl.eventPhase();
  }

  /**
   * Indicates if {@link Event#stopImmediatePropagation()} has been called on this event.
   *
   * @return If stopImmediatePropagation() has been called on this event.
   */
  public boolean wasImmediatePropagationStopped() {
    return impl.immediatePropagationStopped();
  }

  /**
   * Indicates if {@link Event#stopPropagation()} or {@link Event#stopImmediatePropagation()} has been called on this
   * event.
   *
   * @return If stopPropagation() or stopImmediatePropagation() has been called on this event.
   */
  public boolean wasPropagationStopped() {
    return impl.propagationStopped();
  }

  /**
   * Indicates if {@link Event#remove()} has been called on this event.
   *
   * @return If remove() has been called on this event.
   */
  public boolean isRemoved() {
    return impl.removed();
  }

  /**
   * Returns the object that generated an event.
   *
   * @return The object that generated an event.
   */
  public @NotNull JavaScriptObject getTarget() {
    return impl.target();
  }

  /**
   * Returns the epoch time at which this event was created.
   *
   * @return The epoch time at which this event was created.
   */
  public @NotNull Date getTimeStamp() {
    return new Date((long)impl.timeStamp());
  }

  /**
   * Returns the type of event.
   *
   * @return The type of event.
   */
  public @NotNull String getType() {
    return impl.type();
  }

  /**
   * Returns the underlying Javascript interpolate.
   *
   * @return The underlying Javascript interpolate.
   */
  public @NotNull EventImpl getImpl() {
    return impl;
  }
}
