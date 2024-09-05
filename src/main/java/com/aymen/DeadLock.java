package com.aymen;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLock {

    static Lock firstLock = new ReentrantLock();
    static Lock secondLock = new ReentrantLock();

    //thread1
    static void task1() {
        firstLock.lock();
        //process task1
        secondLock.lock();

        firstLock.unlock();
        secondLock.unlock();
    }

//thread2
    static void task2() {

        secondLock.lock();
        //process task2
        firstLock.lock();


        secondLock.unlock();
        firstLock.unlock();

    }

    public static void main(String[] args) {
        new Thread(DeadLock::task1).start();
    }

}
