package org.example.page;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.appium.java_client.AppiumBy;
import lombok.Getter;

@Getter
public class WelcomePage {
    private final SelenideAppiumElement remindLaterButton = $(AppiumBy.id("ru.ozon.app.android:id/remindLater"));
    private final SelenideAppiumElement allowNotifications = $(AppiumBy.id("ru.ozon.app.android:id/allowNotification"));

    public MainPage remindLate() {
        remindLaterButton.shouldBe(visible);
        remindLaterButton.tap();
        return new MainPage();
    }
}
