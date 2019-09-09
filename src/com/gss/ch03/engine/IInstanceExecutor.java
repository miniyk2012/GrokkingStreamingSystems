package com.gss.ch03.engine;

import java.util.concurrent.BlockingQueue;

/**
 * This is the interface of all component executor.
 * Each component executor has an incoming event queue and an outgoing event queue.
 * @param <I> The data type of the events in the incoming event queue
 * @param <O> The data type of the events in the outgoing event queue
 */
public interface IInstanceExecutor<I, O> {
  /**
   * Start the executor.
   */
  void start();
}