package com.illdangag;

public class TryResourceMain {
    public static void main(String[] args) {
        try (ThrowClose throwClose = new ThrowClose()) {
            System.out.println("try block start");

            throwClose.process(true);

            System.out.println("try block end");
        } catch (Exception exception) {
            System.out.println("Exception exception");

            exception.printStackTrace();
        } finally {
            System.out.println("finally block");
        }
    }
}
