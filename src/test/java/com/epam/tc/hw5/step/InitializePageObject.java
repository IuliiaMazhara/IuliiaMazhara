package com.epam.tc.hw5.step;


import com.epam.tc.hw5.pages.PageObjectDifferentElements;
import com.epam.tc.hw5.pages.PageObjectHome;
import com.epam.tc.hw5.pages.PageObjectLoginPage;
import com.epam.tc.hw5.pages.PageObjectUserTable;
import com.epam.tc.hw5.utils.DriverManagerUtils;
import org.openqa.selenium.WebDriver;



public class InitializePageObject {

    protected PageObjectDifferentElements pageObjectDifferentElements;
    protected PageObjectHome pageObjectHome;
    protected PageObjectLoginPage pageObjectLoginPage;

    protected PageObjectUserTable pageObjectUserTabel;

    protected WebDriver webDriver;

    protected InitializePageObject() {

        webDriver = DriverManagerUtils.setupDriver();

        pageObjectHome = new PageObjectHome(webDriver);

        pageObjectLoginPage = new PageObjectLoginPage(webDriver);

        pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);

        pageObjectUserTabel = new PageObjectUserTable(webDriver);
    }
}
