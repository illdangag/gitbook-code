package com.illdangag.thread;

import com.illdangag.thread.job.Job;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolMain {
    public static void main(String[] args) throws Exception {
        List<Job> jobList = Arrays.asList(
                new Job("JOB 0", false),
                new Job("JOB 1", false),
                new Job("JOB 2", true),
                new Job("JOB 3", false),
                new Job("JOB 4", false)
        );

        // 하나의 thread를 가진 pool
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // 3개의 thread를 가진 pool
//        ExecutorService executorService = Executors.newFixedThreadPool(3);
        // 작업이 등록될 때 새로운 thread를 생성하고 일정시간 사용하지 않으면 thread를 제거하는 pool
//        ExecutorService executorService = Executors.newCachedThreadPool();

        for (Job job : jobList) {
            executorService.submit(job);
        }

        executorService.shutdown();
        executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }
}
