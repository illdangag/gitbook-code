package com.illdangag.pattern.singleton;

public class InnerClassSingleton {
    private InnerClassSingleton() {
        System.out.println("Singleton 객체 생성");
        // 객체의 초기화 비즈니스 로직
        try {
            Thread.sleep(1000);
        } catch (Exception exception) {}
    }

    private static class SingletonHolder {
        private static final InnerClassSingleton INSTANCE = new InnerClassSingleton();
    }

    public static InnerClassSingleton getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
