package com.complya.framework.config;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class ConfigReader {
    private static final String CONFIG_FILE = "config.properties";
    private static final Properties PROPS = new Properties();

    static {
        try (InputStream in = Thread.currentThread()
                .getContextClassLoader()
                .getResourceAsStream(CONFIG_FILE)) {
            if (in == null) {
                throw new IllegalStateException("Missing " + CONFIG_FILE + " on test classpath (src/test/resources).");
            }
            PROPS.load(in);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load " + CONFIG_FILE, e);
        }
    }

    private ConfigReader() {
    }

    public static String get(String key) {
        String override = System.getProperty(key);
        if (override != null && !override.isBlank()) {
            return override.trim();
        }
        String val = PROPS.getProperty(key);
        if (val == null) {
            throw new IllegalArgumentException("Missing config key: " + key);
        }
        return val.trim();
    }

    public static String get(String key, String defaultValue) {
        String override = System.getProperty(key);
        if (override != null && !override.isBlank()) {
            return override.trim();
        }
        String val = PROPS.getProperty(key);
        return (val == null) ? defaultValue : val.trim();
    }

    public static int getInt(String key, int defaultValue) {
        String val = get(key, String.valueOf(defaultValue));
        try {
            return Integer.parseInt(val);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Config key " + key + " must be an integer. Got: " + val, e);
        }
    }

    public static boolean getBoolean(String key, boolean defaultValue) {
        String val = get(key, String.valueOf(defaultValue));
        return Boolean.parseBoolean(val);
    }
}

