package com.epam.tc.hw5.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public abstract class MainPage {

    public WebDriver webDriver;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public String getTitle() {
        return webDriver.getTitle();
    }

    public void elementIsDisplayed(WebElement element) {
        Assert.assertTrue(element.isDisplayed());
    }
}
