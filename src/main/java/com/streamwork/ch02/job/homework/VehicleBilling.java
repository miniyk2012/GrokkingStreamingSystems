package com.streamwork.ch02.job.homework;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;
import com.streamwork.ch02.job.VehicleEvent;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VehicleBilling extends Operator {
    static private Map<String, Integer> feeTable = new HashMap<>();
    private Integer total = 0;
    public VehicleBilling(String name) {
        super(name);
        feeTable.put("car", 10);
        feeTable.put("truck", 20);
        feeTable.put("bike", 1);
    }

    @Override
    public void apply(Event event, List<Event> eventCollector) {
        String vehicle = ((VehicleEvent)event).getData();
        total += feeTable.getOrDefault(vehicle, 0);
        System.out.printf("total = %d\n", total);
    }
}
