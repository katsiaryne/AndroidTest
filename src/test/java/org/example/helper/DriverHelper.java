package org.example.helper;

import static org.example.config.ConfigProvider.APP;
import static org.example.config.ConfigProvider.APP_ACTIVITY;
import static org.example.config.ConfigProvider.AUTOMATION_NAME;
import static org.example.config.ConfigProvider.CONNECT_HARDWARE_KEYBOARD;
import static org.example.config.ConfigProvider.DEVICE_NAME;
import static org.example.config.ConfigProvider.ENSURE_WEBVIEWS_HAVE_PAGES;
import static org.example.config.ConfigProvider.URL;
import static org.example.config.ConfigProvider.NATIVE_WEB_SCREENSHOT;
import static org.example.config.ConfigProvider.PLATFORM_NAME;

import com.codeborne.selenide.WebDriverProvider;

import org.jspecify.annotations.NonNull;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriverHelper implements WebDriverProvider {
    protected static AndroidDriver driver;

    private static URL getUrl() {
        try {
            return new URL(URL);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    @Override
    public WebDriver createDriver(@NonNull Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(DEVICE_NAME)
                .setAppPackage(APP)
                .setAppActivity(APP_ACTIVITY)
                .setPlatformName(PLATFORM_NAME)
                .setEnsureWebviewsHavePages(ENSURE_WEBVIEWS_HAVE_PAGES)
                .setNativeWebScreenshot(NATIVE_WEB_SCREENSHOT)
                .setAutomationName(AUTOMATION_NAME)
                .setCapability("appium:connectHardwareKeyboard", CONNECT_HARDWARE_KEYBOARD);
        driver = new AndroidDriver(getUrl(), options);
        return driver;
    }
}
