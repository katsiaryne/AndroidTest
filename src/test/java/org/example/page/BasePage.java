package org.example.page;

import static com.codeborne.selenide.appium.SelenideAppium.$;

import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.appium.java_client.AppiumBy;

public abstract class BasePage<T extends BasePage<T>> {
    private final SelenideAppiumElement catalogBottomButton = $(AppiumBy.id("ru.ozon.app.android:id/menu_catalog")),
            menuBottomButton = $(AppiumBy.id("ru.ozon.app.android:id/menu_main")),
            cartBottomButton = $(AppiumBy.id("ru.ozon.app.android:id/menu_cart")),
            profileBottomButton = $(AppiumBy.id("ru.ozon.app.android:id/menu_profile"));

    public CatalogPage openCatalogPageFromBottomNavigation() {
        catalogBottomButton.tap();
        return new CatalogPage();
    }

    public CartPage openCartPageFromBottomNavigation() {
        cartBottomButton.tap();
        return new CartPage();
    }
}
