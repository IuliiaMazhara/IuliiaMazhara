package com.epam.tc.hm5;


import com.epam.tc.hw3.pages.PageObjectDifferentElements;
import com.epam.tc.hw3.pages.PageObjectHome;
import com.epam.tc.hw3.pages.PageObjectLoginPage;
import io.qameta.allure.Step;

import java.io.IOException;

public class ActionStep extends BaseTest {

    @Step("Log in")
    public void loggIn() throws IOException {
        PageObjectLoginPage.using(webDriver)
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
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        pageObjectHome.getHeaderPageElements().clickOnServiceItem();
        pageObjectHome.clickDifferentElementServiceMenuItem();
    }

    @Step("Click on checkbox")
    public void clickOnCheckBox(String element) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.clickOnElementCheckBox(element);
    }

    @Step("Click on radio box")
    public void clickOnRadioBox(String metal) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.clickOnMetalRadioButton(metal);
    }

    @Step("Choose Dropdown Item")
    public void chooseDropdownItem(String color) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.getDropDownComponent().selectDropDown(color);
    }

}
