package com.epam.tc.hm5;

import com.epam.tc.hw3.utils.DriverManager;
import cucumber.api.java.After;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.Before;


public class Hook {

    public static WebDriver webDriver;

    @Before
    public void setUp() {
        webDriver = new DriverManager().setupDriver();
        webDriver.manage().window().maximize();
        webDriver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @After
    public static void tearDownDriver() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }

}
