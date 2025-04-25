package org.example;

import static org.example.config.ConfigProvider.APP;
import static org.example.util.SearchPageConstants.SEARCH_RECOMMENDATIONS_SIZE;
import static org.example.util.SearchPageConstants.SEARCH_RECOMMENDATION_MIN_SIZE;
import static org.example.util.SearchPageConstants.SEARCH_RELATED_RECOMMENDATIONS_SIZE;
import static org.example.util.SearchPageConstants.SEARCH_RELATED_TOPICS_HEADER;
import static org.example.util.SearchPageConstants.SEARCH_TYPE_RECOMMENDATIONS_SIZE;

import com.codeborne.selenide.appium.SelenideAppium;

import org.assertj.core.api.SoftAssertions;
import org.example.page.MainPage;
import org.example.page.SearchPage;
import org.example.provider.SearchDataProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestSearchPage extends BaseTest {
    private MainPage mainPage;

    @BeforeMethod()
    public void setUpRestart() {
        mainPage = new MainPage();
    }

    @AfterMethod
    public void restart() {
        SelenideAppium.relaunchApp(APP, Duration.ofSeconds(3));
    }

    @Test(description = "Ввод в поиск корректных запросов, проверка соотвествия умного поиска",
            dataProviderClass = SearchDataProvider.class,
            dataProvider = "search correct data")
    public void testTestRecommendations(String text) {
        SearchPage page = mainPage
                .toSearch()
                .setSearchText(text);
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(page.getSearch().getText())
                    .as("Вводимый текст не соответствует действительному")
                    .isEqualTo(text);
            softAssertions.assertThat(page.getSearchRecommends())
                    .as("Количество рекомендаций не соответствует ожидаемым")
                    .hasSizeBetween(SEARCH_RECOMMENDATION_MIN_SIZE, SEARCH_RECOMMENDATIONS_SIZE)
                    .as("Рекомендумые переходы не соответсвуют слову для поиска")
                    .allMatch(recommend -> recommend.getText().startsWith(text));
            softAssertions.assertThat(page.getSearchRelatedTopics())
                    .as("Количество рекомендаций не соответствует ожидаемым")
                    .hasSizeBetween(SEARCH_RECOMMENDATION_MIN_SIZE, SEARCH_RELATED_RECOMMENDATIONS_SIZE);
            softAssertions.assertThat(page.getSearchRelatedTopicsHeader().getText())
                    .as("Заголовок не соответствует ожидаемому")
                    .isEqualTo(SEARCH_RELATED_TOPICS_HEADER);
            softAssertions.assertThat(page.getSearchTypeRecommends())
                    .as("Количество рекомендаций не соответствует ожидаемым")
                    .hasSizeBetween(SEARCH_RECOMMENDATION_MIN_SIZE, SEARCH_TYPE_RECOMMENDATIONS_SIZE);
        });
    }
}
