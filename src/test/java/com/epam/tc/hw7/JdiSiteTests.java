package com.epam.tc.hw7;


import static com.epam.tc.hw7.enteties.User.ROMAN;

import com.epam.jdi.light.driver.WebDriverUtils;
import com.epam.jdi.light.elements.init.PageFactory;
import com.epam.tc.hw7.enteties.MetalColor;
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

    @Test(dataProvider = "DataProviderJson", dataProviderClass = DataProviderMetalColor.class)
    public void ex7Test(MetalColor metalColor) {
        //logInTest();
        JdiSite.openHomePage();
        System.out.println("AAAAA");
        JdiSite.openMetalsAndColorsPage();
        JdiSite.fillMetalsColorsForm(metalColor);
    }

    public void logInTest() {
        JdiSite.openHomePage();
        JdiSite.login(ROMAN);
        JdiSite.jdiHomePage.userName.is().text(ROMAN.getFullName());
    }
}
