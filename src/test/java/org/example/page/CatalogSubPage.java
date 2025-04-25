package org.example.page;

import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

import com.codeborne.selenide.appium.AppiumClickOptions;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.appium.java_client.AppiumBy;
import lombok.Getter;

@Getter
public class CatalogSubPage extends BasePage<CatalogSubPage> {
    private final SelenideAppiumElement
            infoMessage = $(AppiumBy.id("ru.ozon.app.android:id/closeButtonIb")),
            categoryTitle = $(AppiumBy.id("ru.ozon.app.android:id/titleTv")),
            sort = $(AppiumBy.accessibilityId("locator_tag_icon_ic_s_sort_filled")),
            filter = $(AppiumBy.id("locator_tag_icon_ic_s_filter_filled")),
            addToCartFirstElemButton = $x("(//android.view.View[@content-desc=\"ozonAddToCart\"])[1]");

    public CatalogSubPage closeInfoMessage() {
        infoMessage.tap();
        return this;
    }

    public CatalogSubPage addFirstItemToCart() {
        addToCartFirstElemButton.scrollTo().tap();
        return this;
    }

    public CatalogSubPage increaseFirstItem(int startCount) {
        SelenideAppiumElement button = $(AppiumBy.accessibilityId(String.format("ozonAddToCart_%d", startCount)));
        button.tap(AppiumClickOptions.tapWithOffset((int) (button.getSize().getWidth() * 0.4), (int) (button.getSize().getHeight() * 0.1)));
        return this;
    }

    public CatalogSubPage decsreaseFirstItem(int startCount) {
        SelenideAppiumElement button = $(AppiumBy.accessibilityId(String.format("ozonAddToCart_%d", startCount)));
        button.tap(AppiumClickOptions.tapWithOffset((int) -(button.getSize().getWidth() * 0.4), (int) (button.getSize().getHeight() * 0.1)));
        return this;
    }
}
