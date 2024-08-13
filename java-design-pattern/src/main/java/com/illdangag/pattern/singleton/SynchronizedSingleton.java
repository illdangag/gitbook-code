package com.illdangag.pattern.singleton;

public class SynchronizedSingleton {
    private static volatile SynchronizedSingleton instance;

    private SynchronizedSingleton() {
        System.out.println("Singleton 객체 생성");
        // 객체의 초기화 비즈니스 로직
        try {
            Thread.sleep(1000);
        } catch (Exception exception) {}
    }

    public static SynchronizedSingleton getInstance() {
        if (instance != null) {
            return instance;
        }

        synchronized (SynchronizedSingleton.class) {
            if (instance == null) {
                instance = new SynchronizedSingleton();
            }
            return instance;
        }
    }
}
