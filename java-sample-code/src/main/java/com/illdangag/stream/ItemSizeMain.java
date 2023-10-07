package com.illdangag.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.LongStream;

@Slf4j
public class ItemSizeMain {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        long executeTime = 0;
        long parallelExecuteTime = 0;

        long range = 100_000_000L; // 10_000L, 100_000L, 1_000_000L, 10_000_000L, 100_000_000L
        int repeat = 5;

        for (int index = 0; index < repeat; index++) {
            startTime = System.nanoTime();
            LongStream.range(0, range).forEach(item -> {});
            endTime = System.nanoTime();
            executeTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range).parallel().forEach(item -> {});
            endTime = System.nanoTime();
            parallelExecuteTime += (endTime - startTime);
        }

        executeTime /= repeat;
        parallelExecuteTime /= repeat;

        log.info("Stream execute time: {}ms", executeTime / 1000000D);
        log.info("Parallel stream execute time: {}ms", parallelExecuteTime / 1000000D);
    }
}
