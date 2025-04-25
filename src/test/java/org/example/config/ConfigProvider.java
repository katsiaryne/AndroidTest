package org.example.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

public interface ConfigProvider {
    Config config = readConfig();

    static Config readConfig() {
        return ConfigFactory.systemProperties().hasPath("testProfile")
                ? ConfigFactory.load(ConfigFactory.systemProperties().getString("testProfile"))
                : ConfigFactory.load("application.conf");
    }

    String DEVICE_NAME = readConfig().getString("DEVICE_NAME");
    String PLATFORM_NAME = readConfig().getString("PLATFORM_NAME");
    Boolean ENSURE_WEBVIEWS_HAVE_PAGES = readConfig().getBoolean("ENSURE_WEBVIEWS_HAVE_PAGES");
    Boolean NATIVE_WEB_SCREENSHOT = readConfig().getBoolean("NATIVE_WEB_SCREENSHOT");
    Boolean CONNECT_HARDWARE_KEYBOARD = readConfig().getBoolean("CONNECT_HARDWARE_KEYBOARD");
    String APP = readConfig().getString("APP");
    String APP_ACTIVITY = readConfig().getString("APP_ACTIVITY");
    String AUTOMATION_NAME = readConfig().getString("AUTOMATION_NAME");
    String URL = readConfig().getString("URL");
}
