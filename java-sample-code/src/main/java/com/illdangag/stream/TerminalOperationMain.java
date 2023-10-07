package com.illdangag.stream;

import lombok.extern.slf4j.Slf4j;

import java.util.stream.LongStream;

@Slf4j
public class TerminalOperationMain {
    public static void main(String[] args) {
        long startTime;
        long endTime;

        long forEachParallelTime = 0;
        long countParallelTime = 0;
        long findAnyParallelTime = 0;
        long findFirstParallelTime = 0;
        long sumParallelTime = 0;
        long reduceSumParallelTime = 0;

        long forEachTime = 0;
        long countTime = 0;
        long findAnyTime = 0;
        long findFirstTime = 0;
        long sumTime = 0;
        long reduceSumTime = 0;

        long range = 100_000_000L; // 10_000L, 100_000L, 1_000_000L, 10_000_000L, 100_000_000L
        int repeat = 5;

        final long targetValue = 123456L;

        for (int index = 0; index < repeat; index++) {
            startTime = System.nanoTime();
            LongStream.range(0, range).parallel()
                    .filter(item -> item > targetValue)
                    .forEach(item -> {});
            endTime = System.nanoTime();
            forEachParallelTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range)
                    .filter(item -> item > targetValue)
                    .forEach(item -> {});
            endTime = System.nanoTime();
            forEachTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range).parallel()
                    .filter(item -> item > targetValue)
                    .count();
            endTime = System.nanoTime();
            countParallelTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range)
                    .filter(item -> item > targetValue)
                    .count();
            endTime = System.nanoTime();
            countTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range).parallel()
                    .filter(item -> item > targetValue)
                    .findAny();
            endTime = System.nanoTime();
            findAnyParallelTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range)
                    .filter(item -> item > targetValue)
                    .findAny();
            endTime = System.nanoTime();
            findAnyTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range).parallel()
                    .filter(item -> item > targetValue)
                    .findFirst();
            endTime = System.nanoTime();
            findFirstParallelTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range)
                    .filter(item -> item > targetValue)
                    .findFirst();
            endTime = System.nanoTime();
            findFirstTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range).parallel()
                    .filter(item -> item > targetValue)
                    .sum();
            endTime = System.nanoTime();
            sumParallelTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range)
                    .filter(item -> item > targetValue)
                    .sum();
            endTime = System.nanoTime();
            sumTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range).parallel()
                    .filter(item -> item > targetValue)
                    .reduce(Long::sum);
            endTime = System.nanoTime();
            reduceSumParallelTime += (endTime - startTime);

            startTime = System.nanoTime();
            LongStream.range(0, range)
                    .filter(item -> item > targetValue)
                    .reduce(Long::sum);
            endTime = System.nanoTime();
            reduceSumTime += (endTime - startTime);
        }

        forEachParallelTime /= repeat;
        countParallelTime /= repeat;
        findAnyParallelTime /= repeat;
        findFirstParallelTime /= repeat;
        sumParallelTime /= repeat;
        reduceSumParallelTime /= repeat;

        forEachTime /= repeat;
        countTime /= repeat;
        findAnyTime /= repeat;
        findFirstTime /= repeat;
        sumTime /= repeat;
        reduceSumTime /= repeat;

        log.info("forEach execute time: {}ms", forEachTime / 1000000D);
        log.info("forEach parallel execute time: {}ms", forEachParallelTime / 1000000D);
        log.info("count execute time: {}ms", countTime / 1000000D);
        log.info("count parallel execute time: {}ms", countParallelTime / 1000000D);
        log.info("findAny execute time: {}ms", findAnyTime / 1000000D);
        log.info("findAny parallel execute time: {}ms", findAnyParallelTime / 1000000D);
        log.info("findFirst execute time: {}ms", findFirstTime / 1000000D);
        log.info("findFirst parallel execute time: {}ms", findFirstParallelTime / 1000000D);
        log.info("sum execute time: {}ms", sumTime / 1000000D);
        log.info("sum parallel execute time: {}ms", sumParallelTime / 1000000D);
        log.info("reduceSum execute time: {}ms", reduceSumTime / 1000000D);
        log.info("reduceSum parallel execute time: {}ms", reduceSumParallelTime / 1000000D);
    }
}
