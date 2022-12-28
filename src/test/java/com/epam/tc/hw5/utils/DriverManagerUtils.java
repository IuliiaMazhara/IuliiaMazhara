package com.epam.tc.hw5.utils;


import java.util.Objects;
import org.openqa.selenium.WebDriver;


public class DriverManagerUtils {

    private static WebDriver webDriver;

    public static WebDriver setupDriver() {
        String browserName = System
                .getProperty("browser") == null ? "chrome" : System.getProperty("browser");
        if (Objects.isNull(webDriver)) {
            webDriver = WebDriverFactory.getWebDriver(browserName);
        }
        return webDriver;
    }

    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
