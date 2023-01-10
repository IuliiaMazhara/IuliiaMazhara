package com.epam.tc.hw7;


import static com.epam.tc.hw7.entities.User.ROMAN;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.entities.MetalColor;
import com.epam.tc.hw7.pages.JdiSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class JdiSiteTests {

    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        PageFactory.initSite(JdiSite.class);
    }

    @AfterSuite(alwaysRun = true)
    public void afterSuite() {
        WebDriverUtils.killAllSeleniumDrivers();
    }

    @Test(priority = 1)
    public void logInTest() {
        JdiSite.openHomePage();
        JdiSite.login(ROMAN);
        JdiSite.jdiHomePage.userName.is().text(ROMAN.getFullName());
    }

    @Test(priority = 2, dataProvider = "DataProviderJson", dataProviderClass = DataProviderMetalColor.class)
    public void metalColorTest(MetalColor metalColor) {
        JdiSite.openMetalsAndColorsPage();
        JdiSite.fillMetalsColorsForm(metalColor);
        JdiSite.verifyResultLog(metalColor);
    }
}
