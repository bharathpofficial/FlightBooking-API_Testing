package com.FlightBookingSystem.configs;

import java.io.InputStream;
import java.util.Properties;

public class ConfigLoader {
    private static Properties props = new Properties();

    static {
        try (InputStream input = ConfigLoader.class.getClassLoader().getResourceAsStream("config.properties")) {
            props.load(input);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}
