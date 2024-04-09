package com.streamwork.ch04.job.homework;

import com.streamwork.ch04.api.EventCollector;
import com.streamwork.ch04.api.Source;
import com.streamwork.ch04.job.Logger;
import com.streamwork.ch04.job.TransactionEvent;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.UUID;

public class AutoTransactionSource extends Source {
    private static final long serialVersionUID = -1791461650661455535L;

    private int instance = 0;
    private final int portBase;

    private Socket socket;
    private BufferedReader reader;

    /**
     * Construct a transaction source to receive transactions.
     *
     * @param name        The name of the source.
     * @param parallelism
     * @param port        The base port. Ports from number to base port + parallelism - 1
     *                    are used by the instances of this component.
     */
    public AutoTransactionSource(String name, int parallelism, int port) {
        super(name, parallelism);

        this.portBase = port;
    }

    /**
     * Initialize an instance. This function is called from engine after the instance
     * is constructed.
     *
     * @param instance The index of the instance.
     */
    @Override
    public void setupInstance(int instance) {
        this.instance = instance;
    }

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    @Override
    public void getEvents(EventCollector eventCollector) {
        try {
            float amount;
            long merchandiseId;
            amount = Float.valueOf(getRandomNumber(1, 20));
            merchandiseId = Long.valueOf(getRandomNumber(1, 20));

            // Assuming all transactions are from the same user. Transaction id and time are generated automatically.
            int userAccount = 1;
            String transactionId = UUID.randomUUID().toString();
            Date transactionTime = new Date();
            TransactionEvent event = new TransactionEvent(transactionId, amount, transactionTime, merchandiseId, userAccount);
            eventCollector.add(event);

            Logger.log("\n");  // A empty line before logging new events.
            Logger.log("transaction (" + getName() + ") :: instance " + instance + " --> " + event + "\n");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
