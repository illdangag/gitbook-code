package com.illdangag;

import com.illdangag.pattern.singleton.Singleton;

/**
 * single thread 환경에서의 singleton 테스트
 */
public class SingletonSingleThreadMain {
    public static void main(String[] args) {
        Singleton singleton00 = Singleton.getInstance();
        Singleton singleton01 = Singleton.getInstance();

        System.out.println("singleton00 hashCode: " + singleton00.hashCode());
        System.out.println("singleton01 hashCode: " + singleton01.hashCode());
    }
}
