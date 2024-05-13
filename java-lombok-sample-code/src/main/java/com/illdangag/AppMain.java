package com.illdangag;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;

public class AppMain {
    private static final Marker FATAL_MARKER = MarkerFactory.getMarker("FATAL");
    private static final Logger logger = LoggerFactory.getLogger(AppMain.class);

    public static void main(String[] args) throws Exception {
        for (int index = 0; index < 1000; index++) {
            logger.debug(FATAL_MARKER, "RollingFileAppender TEST: {}", index);
            Thread.sleep(1L);
        }
    }
}
