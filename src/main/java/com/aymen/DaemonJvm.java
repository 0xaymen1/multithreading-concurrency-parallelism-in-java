package com.aymen;

public class DaemonJvm {

    public static void main(String[] args) {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Daemon thread is running...");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        daemonThread.setDaemon(true);
        daemonThread.start();


        //main thread exit program exist
//        jvm will not wait for the inifinite loop because we set daemon to true
        System.out.println("is exist lets see");

    }
}
