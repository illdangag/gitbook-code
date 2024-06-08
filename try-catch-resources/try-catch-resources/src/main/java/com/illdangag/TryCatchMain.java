package com.illdangag;

import java.io.IOException;

public class TryCatchMain {
    public static void main(String[] args) {
        ThrowClose throwClose = new ThrowClose();

        try {
            throwClose.process(true);
        } catch (Exception exception) {
            System.out.println("process exception. message: " + exception.getMessage());
        } finally {
            try {
                throwClose.close();
            } catch (IOException exception){
                System.out.println("close exception. message: " + exception.getMessage());
            }
        }
    }
}
