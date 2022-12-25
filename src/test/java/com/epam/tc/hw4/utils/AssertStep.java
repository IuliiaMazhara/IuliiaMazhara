package com.epam.tc.hw4.utils;

import static com.epam.tc.hw4.BaseTest.webDriver;

import com.epam.tc.hw3.pages.PageObjectDifferentElements;
import com.epam.tc.hw3.pages.PageObjectHome;
import com.epam.tc.hw3.pages.PageObjectLoginPage;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebElement;


public class AssertStep {

    @Step("Assert title of the page")
    public void assertTitle(String title) {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(webDriver.getTitle()).isEqualTo(title);
        softTitle.assertAll();
    }

    @Step("Assert login")
    public void assertLogin() {
        String nameOfLoggedUser = PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser().getText();
        SoftAssertions softLogin = new SoftAssertions();
        softLogin.assertThat(nameOfLoggedUser).isEqualTo("ROMAN IOVLEV");
        softLogin.assertAll();
    }

    @Step("Assert Header")
    public void assertHeaderMenu() {
        List<String> expectedHeaderMenu = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors");
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        SoftAssertions softHeaderMenu = new SoftAssertions();
        softHeaderMenu.assertThat(pageObjectHome.getHeaderPageElements().getHeaderMenuItems())
                .isEqualTo(4);
        softHeaderMenu.assertThat(pageObjectHome.getSideMenuComponent().getSideMenuItems())
                .isEqualTo(expectedHeaderMenu);
    }

    @Step("Assert Images")
    public void assertImages() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        SoftAssertions softImages = new SoftAssertions();
        softImages.assertThat(pageObjectHome.getListOfTheImages().size()).isEqualTo(4);
        softImages.assertThat(pageObjectHome.getIconPractise().isDisplayed());
        softImages.assertThat(pageObjectHome.getIconCustom().isDisplayed());
        softImages.assertThat(pageObjectHome.getIconMulti().isDisplayed());
        softImages.assertThat(pageObjectHome.getIconBase().isDisplayed());
        softImages.assertAll();
    }

    @Step("Assert text under images")
    public void assertTextUnderImage() {
        List<String> expectedText = Arrays.asList(
                "To include good practices\n"
                        + "and ideas from successful\n"
                        + "EPAM project",
                "To be flexible and\n"
                        + "customizable",
                "To be multiplatform",
                "Already have good base\n"
                        + "(about 20 internal and\n"
                        + "some external projects),\n"
                        + "wish to get more…");
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

    @Step("Assert Iframe")
    public void assertIframe() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        SoftAssertions softFrameButton = new SoftAssertions();
        softFrameButton.assertThat(pageObjectHome.getFrameButton().isDisplayed());
        softFrameButton.assertAll();
    }

    @Step("Assert Side Menu")
    public void assertSideMenu() {
        List<String> expectedSidedMenu = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        SoftAssertions sofSideMenu = new SoftAssertions();
        sofSideMenu.assertThat(pageObjectHome.getSideMenuComponent().sideMenuSize())
                .isEqualTo(5);
        sofSideMenu.assertThat(pageObjectHome.getSideMenuComponent().getSideMenuItems())
                .isEqualTo(expectedSidedMenu);
    }

    @Step("Assert check bok and log")
    public void assertCheckBoxLog(String element) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.assertCheckBoxIsSelected(element);
        pageObjectDifferentElements.assertCheckBoxLogger(element);
    }

    @Step("Assert radio bok and log")
    public void assertRadioBoxLog(String metal) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.assertRadioBoxIsSelected(metal);
        pageObjectDifferentElements.assertRadioLogger(metal);
    }

    @Step("Assert dropdown bok and log")
    public void assertDropDownLog(String color) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.getDropDownComponent().assertDropDown(color);
        pageObjectDifferentElements.getDropDownComponent().assertDropDownLogger(color);
    }

}
