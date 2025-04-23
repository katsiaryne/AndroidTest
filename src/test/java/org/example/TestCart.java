package org.example;

import org.assertj.core.api.SoftAssertions;
import org.example.page.CartPage;
import org.example.page.MainPage;
import org.testng.annotations.Test;

public class TestCart extends BaseTest {
    @Test
    public void testCart() {
        CartPage page = new MainPage()
                .openCatalogPageFromBottomNavigation()
                .scrollToCategoryAndOpen("Крупная")
                .closeInfoMessage()
                .addFirstItemToCart()
                .increaseFirstItem(1)
                .increaseFirstItem(2)
                .decsreaseFirstItem(3)
                .openCartPageFromBottomNavigation();
        SoftAssertions.assertSoftly(softAssertions -> {
            softAssertions.assertThat(page.getOveralQuantity().getText())
                    .as("Проверка сообщения о количестве товаров")
                    .matches(header -> header.contains("2 товара"));
            softAssertions.assertThat(page.getProducts())
                    .as("Проверка количества отдельных видов товара")
                    .hasSize(1);
            softAssertions.assertThat(page.getQuantities().first().getText())
                    .as("Проверка количества товаров")
                    .isEqualTo("2");
        });
    }
}
