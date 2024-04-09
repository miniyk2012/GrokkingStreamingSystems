package com.streamwork.ch04.job.homework;

import com.streamwork.ch04.api.Event;
import com.streamwork.ch04.api.EventCollector;
import com.streamwork.ch04.api.GroupingStrategy;
import com.streamwork.ch04.api.Operator;
import com.streamwork.ch04.job.TransactionEvent;

public class Preprocess extends Operator  {
    private int instance;

    public Preprocess(String name, int parallelism, GroupingStrategy grouping) {
        super(name, parallelism, grouping);
    }
    public Preprocess(String name, int parallelism) {
        super(name, parallelism);
    }
    @Override
    public void setupInstance(int instance) {
        this.instance = instance;
    }

    @Override
    public void apply(Event event, EventCollector eventCollector) {
        System.out.println("Preprocess :: instance " + instance + " --> ");
        TransactionEvent e = (TransactionEvent) event;
        if (e.amount % 2 == 0) {
            eventCollector.add("even", event);
        } else {
            eventCollector.add("odd", event);
        }
    }
}
