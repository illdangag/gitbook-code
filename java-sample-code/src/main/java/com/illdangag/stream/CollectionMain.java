package com.illdangag.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.LinkedList;

@Slf4j
public class CollectionMain {
    public static void main(String[] args) {
        long startTime = 0;
        long endTime = 0;
        long range = 10_000_000L; // 100_000L, 1_000_000L, 10_000_000L, 100_000_000L
        int repeat = 5;

        ArrayList<Long> arrayList = new ArrayList<>();
        LinkedList<Long> linkedList = new LinkedList<>();

        for (long index = 0; index < range; index++) {
            arrayList.add(index);
            linkedList.add(index);
        }

        int arrayListExecuteTime = 0;
        int parallelArrayListExecuteTime = 0;
        int linkedListExecuteTime = 0;
        int parallelLinkedListExecuteTime = 0;

        for (int index = 0; index < repeat; index++) {
            startTime = System.nanoTime();
            arrayList.stream().reduce(0L, Long::sum);
            endTime = System.nanoTime();

            arrayListExecuteTime += endTime - startTime;

            startTime = System.nanoTime();
            arrayList.stream().parallel().reduce(0L, Long::sum);
            endTime = System.nanoTime();

            parallelArrayListExecuteTime += endTime - startTime;

            startTime = System.nanoTime();
            linkedList.stream().reduce(0L, Long::sum);
            endTime = System.nanoTime();

            linkedListExecuteTime += endTime - startTime;

            startTime = System.nanoTime();
            linkedList.stream().parallel().reduce(0L, Long::sum);
            endTime = System.nanoTime();

            parallelLinkedListExecuteTime += endTime - startTime;
        }

        arrayListExecuteTime /= repeat;
        parallelArrayListExecuteTime /= repeat;
        linkedListExecuteTime /= repeat;
        parallelLinkedListExecuteTime /= repeat;

        log.info("Stream ArrayList: {}ms", arrayListExecuteTime / 1000000D);
        log.info("Paralle stream ArrayList: {}ms", parallelArrayListExecuteTime / 1000000D);
        log.info("Stream LinkedList: {}ms", linkedListExecuteTime / 1000000D);
        log.info("Paralle stream LinkedList: {}ms", parallelLinkedListExecuteTime / 1000000D);
    }
}
