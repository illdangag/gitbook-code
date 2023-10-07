package com.illdangag.string;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StringBuilderMultiThread {
    public static void main(String[] args) throws Exception {
        int range = 10_000_000; // 100_000, 1_000_000, 10_000_000, 100_000_000
        int threadSize = 20;
        int threadJobRange = range / threadSize;

        StringBuilder stringBuilder = new StringBuilder();

        ExecutorService executorService = Executors.newFixedThreadPool(threadSize);
        List<Future> futureList = new ArrayList<>(threadSize);

        for (int threadIndex = 0; threadIndex < threadSize; threadIndex++) {
            Future future = executorService.submit(() -> {
                for (int index = 0; index < threadJobRange; index++) {
                    stringBuilder.append("O");
                }
            });
            futureList.add(future);
        }

        for (int threadIndex = 0; threadIndex < threadSize; threadIndex++) {
            futureList.get(threadIndex).get();
        }
        executorService.shutdown();
        String bufferResult = stringBuilder.toString();
        System.out.println("StringBuilder length: " + bufferResult.length());
    }
}
