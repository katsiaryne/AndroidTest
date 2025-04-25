package org.example.page;

import static com.codeborne.selenide.appium.SelenideAppium.$$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

import com.codeborne.selenide.appium.SelenideAppiumCollection;

import io.appium.java_client.AppiumBy;
import lombok.Getter;

@Getter
public class CatalogPage extends BasePage<CatalogPage> {
    private final SelenideAppiumCollection categories = $$(AppiumBy.id("ru.ozon.app.android:id/productTitleTv"));

    public CatalogSubPage scrollToCategoryAndOpen(String name) {
        $x(String.format("//*[@text='%s']", name)).scrollTo().tap();
        return new CatalogSubPage();
    }
}
