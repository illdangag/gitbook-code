package com.illdangag.thread;

import java.util.concurrent.Callable;

public class ThreadMain {
    public static void main(String[] args) {
        String threadName = Thread.currentThread().getName();
        System.out.println("Main thread name: " + threadName);

        Thread thread = new MyThread();
        thread.start();

        Runnable runnable = new MyRunnable();
        Thread runableThread = new Thread(runnable);
        runableThread.start();
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("MyThread thread name: " + threadName);
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("MyRunnable thread name: " + threadName);
    }
}
