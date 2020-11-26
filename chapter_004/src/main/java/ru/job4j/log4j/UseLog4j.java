package ru.job4j.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


public class UseLog4j {
    private static final Logger LOG = LogManager.getLogger(UseLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}
