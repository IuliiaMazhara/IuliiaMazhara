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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class AssertStep extends InitializePageObject {

    public AssertStep(WebDriver webDriver) {
        super(webDriver);
    }

    SoftAssertions soft = new SoftAssertions();

    @Step("Assert title of the page")
    public void assertTitle(String title) {
        soft.assertThat(webDriver.getTitle()).isEqualTo(title);
        soft.assertAll();
    }

    @Step("Assert login")
    public void assertLogin() {
        String nameOfLoggedUser = PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser().getText();
        soft.assertThat(nameOfLoggedUser).isEqualTo("ROMAN IOVLEV");
        soft.assertAll();
    }

    @Step("Assert Header")
    public void assertHeaderMenu() {
        List<String> expectedHeaderMenu = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        soft.assertThat(pageObjectHome.getHeaderPageElements().headerMenuSize())
                .isEqualTo(4);
        soft.assertThat(pageObjectHome.getHeaderPageElements().getHeaderMenuItems())
                .isEqualTo(expectedHeaderMenu);
    }

    @Step("Assert Images")
    public void assertImages() {
        soft.assertThat(pageObjectHome.getListOfTheImages().size()).isEqualTo(4);
        soft.assertThat(pageObjectHome.getIconPractise().isDisplayed());
        soft.assertThat(pageObjectHome.getIconCustom().isDisplayed());
        soft.assertThat(pageObjectHome.getIconMulti().isDisplayed());
        soft.assertThat(pageObjectHome.getIconBase().isDisplayed());
        soft.assertAll();
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
        List<String> actualText = new ArrayList<>();
        for (WebElement i : pageObjectHome.getListOfTheText()) {
            actualText.add(i.getText());
        }
        soft.assertThat(actualText).isEqualTo(expectedText);
        soft.assertThat(pageObjectHome.getListOfTheText().size()).isEqualTo(4);
        soft.assertAll();
    }

    @Step("Assert Iframe")
    public void assertIframe() {
        soft.assertThat(pageObjectHome.getFrameButton().isDisplayed());
        soft.assertAll();
    }

    @Step("Assert Side Menu")
    public void assertSideMenu() {
        List<String> expectedSidedMenu = Arrays.asList("Home", "Contact form", "Service",
                "Metals & Colors", "Elements packs");
        soft.assertThat(pageObjectHome.getSideMenuComponent().sideMenuSize())
                .isEqualTo(5);
        soft.assertThat(pageObjectHome.getSideMenuComponent().getSideMenuItems())
                .isEqualTo(expectedSidedMenu);
        soft.assertAll();
    }

    @Step("Assert checkbox and log")
    public void assertCheckBoxLog(String element) {
        pageObjectDifferentElements.assertCheckBoxIsSelected(element);
        pageObjectDifferentElements.assertCheckBoxLogger(element);
    }

    @Step("Assert radio box and log")
    public void assertRadioBoxLog(String metal) {
        pageObjectDifferentElements.assertRadioBoxIsSelected(metal);
        pageObjectDifferentElements.assertRadioLogger(metal);
    }

    @Step("Assert dropdown and log")
    public void assertDropDownLog(String color) {
        pageObjectDifferentElements.getDropDownComponent().assertDropDown(color);
        pageObjectDifferentElements.getDropDownComponent().assertDropDownLogger(color);
    }

}
