package com.epam.tc.hw3.scripts;


import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.pages.PageObjectHome;
import com.epam.tc.hw3.pages.PageObjectLoginPage;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;




public class TestEx1 extends BaseTest {

    @Test
    public void verifyMainPage() throws IOException {
        assertTitle();
        assertLogin();
        assertHeaderMenu();
        assertImages();
        assertTextUnderImage();
        assertIframe();
        assertSideMenu();
    }

    //2. Assert Browser title
    public void assertTitle() {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();
    }

    //3. Perform login
    //4 .Assert Username is logged
    public void assertLogin() throws IOException {
        PageObjectLoginPage.using(webDriver)
                .clickUserIcon()
                .setUsername()
                .setPassword()
                .clickSignInButton();
        new WebDriverWait(webDriver, 3)
                .until(ExpectedConditions.visibilityOf(PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser()));
        String nameOfLoggedUser = PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser().getText();
        SoftAssertions softLogin = new SoftAssertions();
        softLogin.assertThat(nameOfLoggedUser).isEqualTo("ROMAN IOVLEV");
        softLogin.assertAll();
    }

    //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
    public void assertHeaderMenu() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        int headerMenuSize = pageObjectHome.getHeaderPageElements().headerMenuSize();
        SoftAssertions softHeader = new SoftAssertions();
        softHeader.assertThat(headerMenuSize).isEqualTo(4);
        softHeader.assertThat(pageObjectHome.getHeaderPageElements().getFormHeaderItem().isDisplayed());
        softHeader.assertThat(pageObjectHome.getHeaderPageElements().getServiceHeaderItem().isDisplayed());
        softHeader.assertThat(pageObjectHome.getHeaderPageElements().getMetalsAndColorsHeaderItem().isDisplayed());
        softHeader.assertThat(pageObjectHome.getHeaderPageElements().getHomeHeaderItem().isDisplayed());
        softHeader.assertAll();
    }

    //6. Assert that there are 4 images on the Index Page, and they are displayed
    public void assertImages() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        int imageContainerSize = pageObjectHome.getListOfTheImages().size();
        SoftAssertions softImages = new SoftAssertions();
        softImages.assertThat(imageContainerSize).isEqualTo(4);
        softImages.assertThat(pageObjectHome.getIconPractise().isDisplayed());
        softImages.assertThat(pageObjectHome.getIconCustom().isDisplayed());
        softImages.assertThat(pageObjectHome.getIconMulti().isDisplayed());
        softImages.assertThat(pageObjectHome.getIconBase().isDisplayed());
        softImages.assertAll();
    }

    //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
    public void assertTextUnderImage() {
        List<String> expectedText = new ArrayList<>();
        expectedText.add("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        expectedText.add("To be flexible and\n"
                + "customizable");
        expectedText.add("To be multiplatform");
        expectedText.add("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more???");
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        List<String> actualText = new ArrayList<>();
        for (WebElement i : pageObjectHome.getListOfTheText()) {
            actualText.add(i.getText());
        }
        SoftAssertions softText = new SoftAssertions();
        softText.assertThat(actualText).isEqualTo(expectedText);
        softText.assertThat(pageObjectHome.getListOfTheText().size()).isEqualTo(4);
        softText.assertAll();
    }

    //8. Assert that there is the iframe with Frame Button exist
    //9. Switch to the iframe and check that there is Frame Button in the iframe
    //10. Switch to original window back
    public void assertIframe() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        webDriver.switchTo().frame("frame");
        SoftAssertions softFrameButton = new SoftAssertions();
        softFrameButton.assertThat(pageObjectHome.getFrameButton().isDisplayed());
        softFrameButton.assertAll();
        webDriver.switchTo().defaultContent();
    }

    //11. Assert that there are 5 items in theLeft Section are displayed, and they have proper text

    public void assertSideMenu() {
        List<String> expectedSidedMenu = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        SoftAssertions softSideMenu = new SoftAssertions();
        softSideMenu.assertThat(pageObjectHome.getSideMenuComponent().sideMenuSize())
                .isEqualTo(5);
        softSideMenu.assertThat(pageObjectHome.getSideMenuComponent().getSideMenuItems())
                .isEqualTo(expectedSidedMenu);
        softSideMenu.assertAll();
    }

}
