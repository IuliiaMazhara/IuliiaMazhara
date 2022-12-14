package com.epam.tc.hw3.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class DriverManager {

    private void setupChromeDriver() {
        WebDriverManager.chromedriver().setup();
    }

    public WebDriver setupDriver() {
        setupChromeDriver();
        WebDriver webDriver = new ChromeDriver();
        return webDriver;
    }
}
