package com.epam.tc.hw6;


import com.epam.tc.hw4.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.io.IOException;
import org.testng.annotations.Test;


@Feature("Check Home Page")
@Story("Title, login, header menu, images, frame, side menu")
public class TestEx1 extends BaseTest {


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
