package org.example.page;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.appium.java_client.AppiumBy;
import lombok.Getter;

@Getter
public class MainPage extends BasePage<MainPage> {
    private final SelenideAppiumCollection menuItems = $$(AppiumBy.id("ru.ozon.app.android:id/titleTv"));
    private final SelenideAppiumElement search = $(AppiumBy.id("ru.ozon.app.android:id/searchTv"));
    private final SelenideAppiumElement catalogBottomButton = $(AppiumBy.id("ru.ozon.app.android:id/menu_catalog"));

    public MainPage() {
        search.shouldBe(visible);
    }

    public SearchPage toSearch() {
        search.tap();
        return new SearchPage();
    }

    public int getMenuItemsSize() {
        return menuItems.size();
    }
}
