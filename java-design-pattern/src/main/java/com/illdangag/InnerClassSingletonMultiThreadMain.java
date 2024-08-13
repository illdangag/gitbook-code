package com.illdangag;

import com.illdangag.pattern.singleton.InnerClassSingleton;

public class InnerClassSingletonMultiThreadMain {
    public static void main(String[] args) {
        Thread thread00 = new Thread(() -> {
            InnerClassSingleton singleton00 = InnerClassSingleton.getInstance();
            System.out.println("singleton00 hashCode: " + singleton00.hashCode());
        });

        Thread thread01 = new Thread(() -> {
            InnerClassSingleton singleton01 = InnerClassSingleton.getInstance();
            System.out.println("singleton01 hashCode: " + singleton01.hashCode());
        });

        thread00.start();
        thread01.start();
    }
}
