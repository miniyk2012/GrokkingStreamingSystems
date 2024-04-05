package com.streamwork.ch02.job.homework;

import com.streamwork.ch02.api.Event;
import org.apache.commons.lang3.tuple.Pair;

public class VehicleCountEvent extends Event {
    private final Pair<String, Integer> counter;

    public VehicleCountEvent(Pair<String, Integer> counter) {
        this.counter = counter;
    }

    @Override
    public Pair<String, Integer> getData() {
        return counter;
    }
}
