package com.aymen;

public class LockingThread {

    static int count = 0;


    //solution of race condition by adding
//    synchronized keyword so jvm won't let any thread modify shared resource and let only one thread at the time
    //so in reality they run in synchronize way
    static synchronized void incrementCount() {
        for (int i = 0; i < 1_000_000; i++) {
            count += 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(LockingThread::incrementCount);
        Thread t2 = new Thread(LockingThread::incrementCount);

        //they aren't running concurrently
//        t1.start();
//        t1.join();
//        t2.start();
//        t2.join();

        //this is cause race condition
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        //solution ???

        System.out.println("Show the result of counter: " + count);


    }
}
