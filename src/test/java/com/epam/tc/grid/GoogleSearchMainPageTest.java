package com.epam.tc.grid;

import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleSearchMainPageTest {
    public static final String URL = "https://www.google.com/?hl=en";
    private WebDriver driver;

    @BeforeClass(alwaysRun = true)
    @Parameters({"isLocal", "hub", "browser"})
    public void beforeClass(@Optional("false") final boolean isLocal,
                            final String hub,
                            final String browser) {

        driver = DriverFabric.getWebDriver(isLocal, hub, browser);
    }

    @BeforeMethod
    public void setUp() {
        driver.get(URL);
    }

    @AfterClass(alwaysRun = true)
    public void afterClass() {
        driver.quit();
    }

    @Test
    public void testSearchButton() {
        WebElement button = driver.findElement(By.cssSelector("form[role=search] input[name=btnK]"));
        Assertions.assertThat(button.getAttribute("value"))
                  .isEqualTo("Google Search");
    }

    @Test
    public void testFeelingLuckyButton() {
        WebElement button = driver.findElement(By.cssSelector("form[role=search] input[name=btnI]"));
        Assertions.assertThat(button.getAttribute("value"))
                  .isEqualTo("I'm Feeling Lucky");
    }
}
