package com.epam.tc.hw5.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class MainPage {

    protected WebDriver driver;

    protected MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void elementIsDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }
}
