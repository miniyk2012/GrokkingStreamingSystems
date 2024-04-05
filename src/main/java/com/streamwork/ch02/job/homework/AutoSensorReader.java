package com.streamwork.ch02.job.homework;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Source;
import com.streamwork.ch02.job.VehicleEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

class AutoSensorReader extends Source {
  private final List<String> vehicles;
  private final Random rand;

  public AutoSensorReader(String name) {
    super(name);
    vehicles = new ArrayList<>(Arrays.asList("car", "truck", "bike"));
    rand = new Random();
  }

  @Override
  public void getEvents(List<Event> eventCollector) {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    String vehicle = vehicles.get(rand.nextInt(vehicles.size()));
    eventCollector.add(new VehicleEvent(vehicle));
    System.out.println("");  // An empty line before logging new events
    System.out.println("SensorReader --> " + vehicle);
  }
}
