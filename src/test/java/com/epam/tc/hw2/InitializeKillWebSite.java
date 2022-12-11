package com.epam.tc.hw2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public abstract  class InitializeKillWebSite {

    protected WebDriver driver = new ChromeDriver();

    @BeforeClass
    public void initWebDriver() {

        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @AfterClass
    public void releaseWebDriver() {

        if (driver != null) {
            driver.quit();

        }
    }

}
