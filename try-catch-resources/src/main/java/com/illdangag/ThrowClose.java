package com.illdangag;

import java.io.Closeable;
import java.io.IOException;

public class ThrowClose implements Closeable {
    public void process(boolean isThrowException) throws Exception {
        System.out.println("ThrowClose.process() called");
        if (isThrowException) {
            throw new IOException("ThrowClose.process() throw exception");
        }
    }

    @Override
    public void close() throws IOException {
        System.out.println("ThrowClose.close() called");
        throw new IOException("ThrowClose.close() throw exception");
    }
}
