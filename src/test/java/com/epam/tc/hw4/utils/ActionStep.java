package com.epam.tc.hw4.utils;


import static com.epam.tc.hw4.BaseTest.webDriver;

import io.qameta.allure.Step;
import java.io.IOException;
import org.openqa.selenium.WebDriver;



public class ActionStep extends InitializePageObject {

    public ActionStep(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Log in")
    public void loggIn() throws IOException {
        pageObjectLoginPage
                .clickUserIcon()
                .setUsername()
                .setPassword()
                .clickSignInButton();
    }

    @Step("Switch to iframe")
    public void switchToIframe() {
        webDriver.switchTo().frame("frame");
    }

    @Step("Switch to default window from iframe")
    public void switchToDefaultWindows() {
        webDriver.switchTo().defaultContent();
    }

    @Step("Navigate To Different Elements page")
    public void navigateToDifferentElementsPage() {
        pageObjectHome.getHeaderPageElements().clickOnServiceItem();
        pageObjectHome.clickDifferentElementServiceMenuItem();
    }

    @Step("Click on checkbox")
    public void clickOnCheckBox(String element) {
        pageObjectDifferentElements.clickOnElementCheckBox(element);
    }

    @Step("Click on radio box")
    public void clickOnRadioBox(String metal) {
        pageObjectDifferentElements.clickOnMetalRadioButton(metal);
    }

    @Step("Choose Dropdown Item")
    public void chooseDropdownItem(String color) {
        pageObjectDifferentElements.getDropDownComponent().selectDropDown(color);
    }

}
