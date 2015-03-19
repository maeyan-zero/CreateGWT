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

import net.depoker.createjs.common.client.impl.EventDispatcherImpl;
import net.depoker.createjs.common.client.impl.EventListenerImpl;
import com.google.gwt.core.client.JavaScriptObject;

public abstract class EventDispatcher {
  private final EventDispatcherImpl impl;

  public EventDispatcher(JavaScriptObject impl) {
    this.impl = impl.cast();
  }

  public EventListenerImpl addEventListener(Enum type, EventListener listener) {
    return addEventListener(type.toString(), listener);
  }

  public EventListenerImpl addEventListener(Enum type, EventListener listener, boolean useCapture) {
    return addEventListener(type.toString(), listener, useCapture);
  }

  public EventListenerImpl addEventListener(String type, EventListener listener) {
    return impl.addEventListener(type, EventListenerImpl.create(listener)).cast();
  }

  public EventListenerImpl addEventListener(String type, EventListener listener, boolean useCapture) {
    return impl.addEventListener(type, EventListenerImpl.create(listener), useCapture).cast();
  }

  public boolean dispatchEvent(String type) {
    return impl.dispatchEvent(type);
  }

  public boolean dispatchEvent(Event event) {
    return impl.dispatchEvent(event.getImpl());
  }

  public boolean hasEventHandler(String type) {
    return impl.hasEventListener(type);
  }

  public void off(String type, EventListenerImpl listener) {
    impl.off(type, listener);
  }

  public void off(String type, EventListenerImpl listener, boolean useCapture) {
    impl.off(type, listener, useCapture);
  }

  public EventListenerImpl on(String type, EventListener listener) {
    return impl.on(type, EventListenerImpl.create(listener)).cast();
  }

  public EventListenerImpl on(String type, EventListener listener, JavaScriptObject scope) {
    return impl.on(type, EventListenerImpl.create(listener), scope).cast();
  }

  public EventListenerImpl on(String type, EventListener listener, JavaScriptObject scope, boolean once) {
    return impl.on(type, EventListenerImpl.create(listener), scope, once).cast();
  }

  public EventListenerImpl on(String type, EventListener listener, JavaScriptObject scope, boolean once, JavaScriptObject data) {
    return impl.on(type, EventListenerImpl.create(listener), scope, once, data).cast();
  }

  public EventListenerImpl on(String type, EventListener listener, JavaScriptObject scope, boolean once, JavaScriptObject data, boolean useCapture) {
    return impl.on(type, EventListenerImpl.create(listener), scope, once, data, false).cast();
  }

  public void removeAllEventListers() {
    impl.removeAllEventListeners();
  }

  public void removeAllEventListeners(String type) {
    impl.removeAllEventListeners(type);
  }

  public void removeAllEventListeners(Enum type) {
    impl.removeAllEventListeners(type.toString());
  }

  public void removeEventListener(String type, EventListenerImpl listener) {
    impl.removeEventListener(type, listener);
  }

  public void removeEventListener(Enum type, EventListenerImpl listener) {
    impl.removeEventListener(type.toString(), listener);
  }

  public void removeEventListener(String type, EventListenerImpl listener, boolean useCapture) {
    impl.removeEventListener(type, listener);
  }

  public void removeEventListener(Enum type, EventListenerImpl listener, boolean useCapture) {
    impl.removeEventListener(type.toString(), listener);
  }

  public boolean willTrigger(String type) {
    return impl.willTrigger(type);
  }

  public boolean willTrigger(Enum type) {
    return impl.willTrigger(type.toString());
  }

  public EventDispatcherImpl getImpl() {
    return impl;
  }
}