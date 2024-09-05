package com.aymen;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class OperatingSystemBehavior {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            System.out.println("-Hello from thread1 ");
        });

        executor.submit(() -> {
                System.out.println("-Hello from thread2");
        });

    }
}

