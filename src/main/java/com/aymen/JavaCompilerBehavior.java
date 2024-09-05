package com.aymen;


public class JavaCompilerBehavior {

    private volatile boolean taskCompleted = false;

    public void startTask() {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(5000);
                taskCompleted = true;
                System.out.println("Task completed");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        Thread t2 = new Thread(() -> {
            while (!taskCompleted) {
            }
            System.out.println("Detected task completion");
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public static void main(String[] args) {
        JavaCompilerBehavior instance = new JavaCompilerBehavior();
        instance.startTask();
    }
}
