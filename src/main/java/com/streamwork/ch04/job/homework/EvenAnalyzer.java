package com.streamwork.ch04.job.homework;

import com.streamwork.ch04.api.Event;
import com.streamwork.ch04.api.EventCollector;
import com.streamwork.ch04.api.GroupingStrategy;
import com.streamwork.ch04.api.Operator;
import com.streamwork.ch04.job.TransactionEvent;
import com.streamwork.ch04.job.TransactionScoreEvent;

public class EvenAnalyzer extends Operator {

    private int instance;

    public EvenAnalyzer(String name, int parallelism, GroupingStrategy grouping) {
        super(name, parallelism, grouping);
    }

    @Override
    public void setupInstance(int instance) {
        this.instance = instance;
    }

    @Override
    public void apply(Event transaction, EventCollector eventCollector) {
        TransactionEvent e = (TransactionEvent) transaction;
        System.out.println("EvenAnalyzer :: instance " + instance + " --> " + e.amount);
        // Dummy analyzer. Allow all transactions.
        eventCollector.add(new TransactionScoreEvent(e, 0.0f));
    }
}
