package com.epam.tc.hw5.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.experimental.UtilityClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


@UtilityClass
public class DriverManagerUtils {

    private static WebDriver webDriver;

    public static WebDriver setupDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--incognito");
        WebDriver webDriver = new ChromeDriver(options);
        return webDriver;
    }

    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
