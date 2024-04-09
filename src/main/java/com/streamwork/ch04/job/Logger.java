package com.streamwork.ch04.job;

public class Logger {
    public static synchronized void log(String message) {
        System.out.print(message);
    }
}
