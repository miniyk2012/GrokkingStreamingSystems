package com.streamwork.ch02.job.homework;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;
import com.streamwork.ch02.job.VehicleEvent;
import org.apache.commons.lang3.tuple.ImmutablePair;

import java.util.*;

class VehiclePureCounter extends Operator {
  private final Map<String, Integer> countMap = new HashMap<String, Integer>();

  public VehiclePureCounter(String name) {  super(name);  }

  @Override
  public void apply(Event vehicleEvent, List<Event> eventCollector) {
    String vehicle = ((VehicleEvent)vehicleEvent).getData();
    Integer count = countMap.getOrDefault(vehicle, 0) + 1;
    countMap.put(vehicle, count);
    eventCollector.add(new VehicleCountEvent(new ImmutablePair<>(vehicle, count)));
  }
}
