package com.illdangag;

import com.illdangag.pattern.singleton.Singleton;

/**
 * multi thread 환경에서의 singleton 테스트
 */
public class SingletonMultiThreadMain {
    public static void main(String[] args) {
        Thread thread00 = new Thread(() -> {
            Singleton singleton00 = Singleton.getInstance();
            System.out.println("singleton00 hashCode: " + singleton00.hashCode());
        });

        Thread thread01 = new Thread(() -> {
            Singleton singleton01 = Singleton.getInstance();
            System.out.println("singleton01 hashCode: " + singleton01.hashCode());
        });

        thread00.start();
        thread01.start();
    }
}
