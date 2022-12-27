package com.epam.tc.hw4.utils;


import com.epam.tc.hw3.pages.PageObjectDifferentElements;
import com.epam.tc.hw3.pages.PageObjectHome;
import com.epam.tc.hw3.pages.PageObjectLoginPage;
import org.openqa.selenium.WebDriver;


public class InitializePageObject {

    protected PageObjectDifferentElements pageObjectDifferentElements;
    protected PageObjectHome pageObjectHome;
    protected PageObjectLoginPage pageObjectLoginPage;

    protected InitializePageObject(WebDriver webDriver) {

        pageObjectHome = new PageObjectHome(webDriver);

        pageObjectLoginPage = new PageObjectLoginPage(webDriver);

        pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
    }
}
