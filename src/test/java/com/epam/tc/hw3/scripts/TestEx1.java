package com.epam.tc.hw3.scripts;


import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.pages.PageObjectHome;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class TestEx1 extends BaseTest {

    //2. Assert Browser title
    @Test
    public void assertTitle() {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();
    }

    //3. Perform login
    //4 .Assert Username is logged

    @Test
    public void assertLogin() throws IOException {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        pageObjectHome.clickUserIcon();
        pageObjectHome.enterUserName();
        pageObjectHome.enterPassword();
        pageObjectHome.clickSignInButton();
        new WebDriverWait(webDriver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOf(pageObjectHome.getNamedOfLoggedUser()));
        SoftAssertions softLogin = new SoftAssertions();
        softLogin.assertThat(pageObjectHome.getNamedOfLoggedUser().getText()).isEqualTo("ROMAN IOVLEV");
        softLogin.assertAll();
    }

    //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
    @Test
    public void assertHeaderMenu() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        int headerMenuItemsSize = pageObjectHome.getHeaderMenu().size();
        SoftAssertions softHeader = new SoftAssertions();
        softHeader.assertThat(headerMenuItemsSize).isEqualTo(4);
        softHeader.assertThat(pageObjectHome.getHomeHeaderMenuItem().isDisplayed());
        softHeader.assertThat(pageObjectHome.getContactFormHeaderMenuItem().isDisplayed());
        softHeader.assertThat(pageObjectHome.getServiceHeaderMenuItem().isDisplayed());
        softHeader.assertThat(pageObjectHome.getMetalsAndColorsHeaderMenuItem().isDisplayed());
        softHeader.assertAll();
    }


    //6. Assert that there are 4 images on the Index Page, and they are displayed
    @Test
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
    @Test
    public void assertTextUnderImage() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        int listOfTheTextSize = pageObjectHome.getListOfTheText().size();
        SoftAssertions softImagesText = new SoftAssertions();
        softImagesText.assertThat(listOfTheTextSize).isEqualTo(4);
        softImagesText.assertThat(pageObjectHome.getPractiseText().getText()).isEqualTo("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        softImagesText.assertThat(pageObjectHome.getCustomText().getText()).isEqualTo("To be flexible and\n"
                + "customizable");
        softImagesText.assertThat(pageObjectHome.getMultiText().getText()).isEqualTo("To be multiplatform");
        softImagesText.assertThat(pageObjectHome.getBaseText().getText()).isEqualTo("Already have good base\n"
                       + "(about 20 internal and\n"
                       + "some external projects),\n"
                       + "wish to get more…");
        softImagesText.assertAll();
    }

    //8. Assert that there is the iframe with Frame Button exist
    //9. Switch to the iframe and check that there is Frame Button in the iframe
    //10. Switch to original window back
    @Test
    public void assertIframe() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        webDriver.switchTo().frame("frame");
        SoftAssertions softFrameButton = new SoftAssertions();
        softFrameButton.assertThat(pageObjectHome.getFrameButton().isDisplayed());
        softFrameButton.assertAll();
        webDriver.switchTo().defaultContent();
    }

    //11. Assert that there are 5 items in theLeft Section are displayed, and they have proper text
    @Test
    public void assertSideMenu() {
        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Home");
        expectedMenu.add("Contact form");
        expectedMenu.add("Service");
        expectedMenu.add("Metals & Colors");
        expectedMenu.add("Elements packs");
        List<String> actualMenu = new ArrayList<>();
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        for (WebElement i : pageObjectHome.getSideMenuItems()) {
            actualMenu.add(i.getText());
        }
        SoftAssertions softLeftMenu = new SoftAssertions();
        softLeftMenu.assertThat(actualMenu.size()).isEqualTo(5);
        softLeftMenu.assertThat(actualMenu).isEqualTo(expectedMenu);
    }

}
