package org.example.page;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.appium.SelenideAppium.$;
import static com.codeborne.selenide.appium.SelenideAppium.$$;
import static com.codeborne.selenide.appium.SelenideAppium.$x;

import com.codeborne.selenide.appium.SelenideAppiumCollection;
import com.codeborne.selenide.appium.SelenideAppiumElement;

import io.appium.java_client.AppiumBy;
import lombok.Getter;

@Getter
public class SearchPage extends BasePage<SearchPage> {
    private final SelenideAppiumElement
            search = $(AppiumBy.id("ru.ozon.app.android:id/etSearch")),
            searchRelatedTopicsHeader = $x("//android.widget.TextView[@content-desc=\"text\"]"),
            recommendationsTitle = $(AppiumBy.id("ru.ozon.app.android:id/headerTitleTa"));
    private final SelenideAppiumCollection
            searchRecommends = $$(AppiumBy.id("ru.ozon.app.android:id/suggestion_title")),
            searchRelatedTopics = $$(AppiumBy.id("ru.ozon.app.android:id/tvTitle")),
            searchTypeRecommends = $$(AppiumBy.id("ru.ozon.app.android:id/tapTagsV2Item"));

    public SearchPage setSearchText(String text) {
        search.sendKeys(text);
        recommendationsTitle.shouldNot(exist);
        return this;
    }
}
