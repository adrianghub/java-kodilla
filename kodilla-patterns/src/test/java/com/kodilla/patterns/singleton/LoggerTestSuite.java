package com.kodilla.patterns.singleton;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTestSuite {

    private final static String MSG_LOG = "2021-05-14 06:53:50.572  INFO 11788 --- [main] com.kodilla.KodillaSpringApplication: " +
            "Starting KodillaSpringApplication...";

    private static Logger logger;

    @BeforeAll
    public static void saveLogToLogger() {
        logger = Logger.INSTANCE;
        logger.log(MSG_LOG);
    }

    @Test
    void testGetFileName() {
        //Given
        //When
        String lastLog = logger.getLastLog();
        System.out.println("Opened: " + lastLog);
        //Then
        assertEquals(MSG_LOG, lastLog);
    }
}
