package org.example;

import static org.example.helper.RunHelper.runHelper;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.appium.SelenideAppium;

import org.example.page.WelcomePage;
import org.testng.annotations.BeforeTest;


public class BaseTest{
    @BeforeTest
    public static void setup() {
        Configuration.browser = runHelper().getDriverClass().getName();
        SelenideAppium.launchApp();
        new WelcomePage().remindLate();
    }
}
