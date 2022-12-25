package com.epam.tc.hw4;


import com.epam.tc.hw3.pages.PageObjectHome;
import com.epam.tc.hw3.pages.PageObjectLoginPage;
import com.epam.tc.hw4.utils.ActionStep;
import com.epam.tc.hw4.utils.AssertStep;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;


@Feature("Check Home Page")
@Story("Title, login, header menu, images, frame, side menu")
public class TestEx1 extends BaseTest {

    AssertStep assertStep = new AssertStep();
    ActionStep actionStep = new ActionStep();

    @Test
    @Description("Test Home Page")
    public void verifyMainPage() throws IOException {
        assertStep.assertTitle("Home Page");
        actionStep.loggIn();
        assertStep.assertLogin();
        assertStep.assertHeaderMenu();
        assertStep.assertImages();
        assertStep.assertTextUnderImage();
        actionStep.switchToIframe();
        assertStep.assertIframe();
        actionStep.switchToDefaultWindows();
        assertStep.assertSideMenu();
    }

}
