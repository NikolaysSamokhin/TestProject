package com.company.config;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Properties;

public final class Config {
    private static Config config;
    private Properties props;

    private Config() {
        loadProperties();
    }

    public static Config getInstance() {
        if (config == null) {
            config = new Config();
        }
        return config;
    }

    @SneakyThrows
    private void loadProperties() {
        InputStream inputStream = Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("config.properties");
        props = new Properties();
        props.load(inputStream);
        if (inputStream != null) {
            inputStream.close();
        }
    }
}



