package com.streamwork.ch02.job.homework;

import com.streamwork.ch02.api.Event;
import com.streamwork.ch02.api.Operator;
import org.apache.commons.lang3.tuple.Pair;

import java.util.List;

public class CountPrinter extends Operator {
    public CountPrinter(String name) {
        super(name);
    }

    @Override
    public void apply(Event event, List<Event> eventCollector) {
        Pair counter = ((VehicleCountEvent) event).getData();
        printCount(counter);
    }

    private void printCount(Pair<String, Integer> counter) {
        System.out.println("VehicleCount --> ");
        System.out.println("  " + counter.getKey() + ": " + counter.getValue());
    }
}
