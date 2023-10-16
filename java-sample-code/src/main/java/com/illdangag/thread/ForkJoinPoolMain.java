package com.illdangag.thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinPoolMain {
    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool(2);
        List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 12, 6, 7, 8, 9, 10);
        MaxIntegerTask task = new MaxIntegerTask(list);

        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(task);
        Integer result = forkJoinTask.get();
        System.out.println(result);
    }
}

class MaxIntegerTask extends RecursiveTask<Integer> {
    private List<Integer> list;

    public MaxIntegerTask(List<Integer> list) {
        this.list = list;
    }

    @Override
    protected Integer compute() {
        String threadName = Thread.currentThread().getName();
        System.out.printf("START: [%s]\n", threadName);

        int listSize = this.list.size();

        if (listSize > 2) { // 분할
            int subSize0 = (int) Math.floor(listSize / 2f);
            int subSize1 = (int) Math.ceil(listSize / 2f);

            List<Integer> subList0 = this.list.subList(0, subSize0);
            List<Integer> subList1 = this.list.subList(listSize - subSize1, listSize);
            MaxIntegerTask subTask0 = new MaxIntegerTask(subList0);
            MaxIntegerTask subTask1 = new MaxIntegerTask(subList1);

            subTask0.fork();
            subTask1.fork();

            Integer result0 = subTask0.join();
            Integer result1 = subTask1.join();

            return Math.max(result0, result1);
        } else { // 분할하지 않음
            if (this.list.size() == 1) {
                return this.list.get(0);
            } else {
                return Math.max(this.list.get(0), this.list.get(1));
            }
        }
    }
}