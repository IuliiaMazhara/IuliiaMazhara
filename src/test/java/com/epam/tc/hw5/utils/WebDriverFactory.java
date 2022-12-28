package com.epam.tc.hw5.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class WebDriverFactory {

    private static final String CHROME = "CHROME";
    private static final String FIREFOX = "FIREFOX";

    public static WebDriver getWebDriver(String browser) {
        WebDriver webDriver;
        switch (browser.toUpperCase()) {
            case FIREFOX:
                webDriver = createFirefox();
                break;
            case CHROME:
            default:
                webDriver = createChrome();
                break;
        }
        return webDriver;
    }

    private static WebDriver createChrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    private static WebDriver createFirefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

}
