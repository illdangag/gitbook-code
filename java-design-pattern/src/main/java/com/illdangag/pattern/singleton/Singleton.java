package com.illdangag.pattern.singleton;

public class Singleton {
    private static Singleton instance;

    private Singleton() {
        System.out.println("Singleton 객체 생성");
        // 객체의 초기화 비즈니스 로직
        try {
            Thread.sleep(1000);
        } catch (Exception exception) {}
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
}
