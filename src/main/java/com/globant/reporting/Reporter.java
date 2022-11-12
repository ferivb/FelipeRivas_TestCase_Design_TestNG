package com.globant.reporting;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Reporter {

    public Reporter(){}

    public static Logger getLogger() {
        return LoggerFactory.getLogger(Reporter.class); // Get this explained
    }

    public static void info(String text){
        getLogger().info(text);
    }

    public static void error(String text){
        getLogger().error(text);
    }

    public static void warning(String text){
        getLogger().warn(text);
    }
}
