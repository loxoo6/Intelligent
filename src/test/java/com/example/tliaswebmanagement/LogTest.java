package com.example.tliaswebmanagement;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTest {

    private static final Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void testLog() {
        logger.debug("This is a DEBUG level log");
        logger.info("This is an INFO level log");
        logger.warn("This is a WARN level log");
        logger.error("This is an ERROR level log");
    }
}
