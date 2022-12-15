package com.epam.tc.hw4;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import lombok.SneakyThrows;
import lombok.extern.java.Log;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest {

    public static final String CAT_URL =
        "https://upload.wikimedia.org/wikipedia/commons/b/b6/Felis_catus-cat_on_snow.jpg";

    @BeforeMethod
    public void setUp(ITestContext context) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        context.setAttribute("driver", driver);
        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    @Test(description = "description from testNg.test.description")
    @Severity(SeverityLevel.CRITICAL)
    public void testTrue() {
        Assertions.assertThat(true)
                  .isTrue();
    }

    @Test
    @Description(value = "description from allure.Description")
    public void testFalse() {
        Assertions.assertThat(true)
                  .isFalse();
    }

}
