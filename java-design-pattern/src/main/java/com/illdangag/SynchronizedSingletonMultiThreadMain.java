package com.illdangag;

import com.illdangag.pattern.singleton.SynchronizedSingleton;

public class SynchronizedSingletonMultiThreadMain {
    public static void main(String[] args) {
        Thread thread00 = new Thread(() -> {
            SynchronizedSingleton singleton00 = SynchronizedSingleton.getInstance();
            System.out.println("singleton00 hashCode: " + singleton00.hashCode());
        });

        Thread thread01 = new Thread(() -> {
            SynchronizedSingleton singleton01 = SynchronizedSingleton.getInstance();
            System.out.println("singleton01 hashCode: " + singleton01.hashCode());
        });

        thread00.start();
        thread01.start();
    }
}
