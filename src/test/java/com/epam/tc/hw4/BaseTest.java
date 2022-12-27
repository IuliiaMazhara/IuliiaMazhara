package com.epam.tc.hw4;

import com.epam.tc.hw3.utils.DriverManager;
import com.epam.tc.hw4.utils.ActionStep;
import com.epam.tc.hw4.utils.AssertStep;
import com.epam.tc.hw6.DriverFabric;
import lombok.NonNull;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public class BaseTest {
    public static WebDriver webDriver;
    protected ActionStep actionStep;
    protected AssertStep assertStep;


    @BeforeClass
    @Parameters({"isLocal", "hub", "browser"})
    public void prepareToTest(ITestContext testContext,
                              @Optional("false") final boolean isLocal, final String hub, final String browser) {
        webDriver = DriverFabric.getWebDriver(isLocal, hub, browser);
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

