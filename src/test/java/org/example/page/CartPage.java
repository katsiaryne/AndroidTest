package org.example.page;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.appium.java_client.AppiumBy;
import lombok.Getter;

@Getter
public class CartPage extends BasePage<CartPage> {
    private final SelenideAppiumCollection
            products = $$(AppiumBy.xpath("//android.view.ViewGroup[@resource-id=\"ru.ozon.app.android:id/splitV2ItemRootCl\"]")),
            quantities = $$(AppiumBy.id("ru.ozon.app.android:id/quantityEt"));
    private final SelenideAppiumElement overalQuantity = $(AppiumBy.id("ru.ozon.app.android:id/headerSubtitleTv"));
}
