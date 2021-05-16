package com.streamwork.ch08.engine;

import java.util.concurrent.ArrayBlockingQueue;

import com.streamwork.ch08.api.Event;

/**
 * This is the class for intemediate event queues between processes.
 */
public class EventQueue extends ArrayBlockingQueue<Event> {
  private static final long serialVersionUID = 5299563454777716488L;

  public EventQueue(int size) {
    super(size);
  }
}
