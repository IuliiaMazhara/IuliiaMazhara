package com.epam.tc.hw5.utils;


import java.util.Objects;
import org.openqa.selenium.WebDriver;


public class DriverManagerUtils {

    private static WebDriver webDriver;

    public static WebDriver setupDriver() {
        if (Objects.isNull(webDriver)) {
            webDriver = WebDriverFactory.getWebDriver("chrome");
        }
        return webDriver;
    }

    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
