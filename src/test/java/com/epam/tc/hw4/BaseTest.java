package com.epam.tc.hw4;

import com.epam.tc.hw3.utils.DriverManager;
import com.epam.tc.hw4.utils.ActionStep;
import com.epam.tc.hw4.utils.AssertStep;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    public static WebDriver webDriver;
    protected ActionStep actionStep;
    protected AssertStep assertStep;


    @BeforeClass
    public void prepareToTest(ITestContext testContext) {
        webDriver = new DriverManager().setupDriver();
        testContext.setAttribute("driver", webDriver);
        webDriver.manage().window().maximize();
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
        actionStep = new ActionStep(webDriver);
        assertStep = new AssertStep(webDriver);
    }

    @AfterClass
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}

