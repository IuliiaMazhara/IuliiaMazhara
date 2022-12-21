package com.epam.tc.hw4;

import com.epam.tc.hw3.utils.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public static WebDriver webDriver;

    @BeforeClass
    public static void prepareToTest(ITestContext context) {
        webDriver = new DriverManager().setupDriver();
        context.setAttribute("driver", webDriver);
    }

    @AfterClass
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}

