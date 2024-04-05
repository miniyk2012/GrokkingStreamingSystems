package com.streamwork.ch02.job.homework;

import com.streamwork.ch02.api.Job;
import com.streamwork.ch02.api.Stream;
import com.streamwork.ch02.engine.JobStarter;

public class Homework3VehicleFeeJob {

  public static void main(String[] args) {
    Job job = new Job("vehicle_count");

    Stream bridgeStream = job.addSource(new AutoSensorReader("auto-sensor-reader"));
    bridgeStream.applyOperator(new VehicleBilling("vehicle-billing"));

    JobStarter starter = new JobStarter(job);
    starter.start();
  }
}
