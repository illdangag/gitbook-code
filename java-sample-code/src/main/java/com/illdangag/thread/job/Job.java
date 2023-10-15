package com.illdangag.thread.job;

public class Job implements Runnable {
    private String name;
    private boolean throwException;

    public Job(String name, boolean throwException) {
        this.name = name;
        this.throwException = throwException;
    }

    @Override
    public void run() {
        long wait = (long) (Math.random() * 50);
        String threadName = Thread.currentThread().getName();

        System.out.printf("START: [%s, %s, %2dms]\n", this.name, threadName, wait);

        try {
            Thread.sleep(wait);
        } catch (Exception exception) {}

        if (this.throwException) {
            System.out.printf("THROW: [%s, %s]\n", this.name, threadName);
            throw new RuntimeException("Throw exception");
        }

        System.out.printf("END  : [%s, %s]\n", this.name, threadName);
    }
}