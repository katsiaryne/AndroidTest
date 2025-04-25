package org.example.provider;

import org.testng.annotations.DataProvider;

public class SearchDataProvider {
    @DataProvider(name = "search correct data")
    public Object[][] getSearchData() {
        return new Object[][]{{"toy"}, {"tooth"}, {"wireless"}, {"деньги"}};
    }
}
