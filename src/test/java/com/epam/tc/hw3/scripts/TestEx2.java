package com.epam.tc.hw3.scripts;


import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.pages.DropDownOfColorsOnDifferentElementPage;
import com.epam.tc.hw3.pages.PageObjectDifferentElements;
import com.epam.tc.hw3.pages.PageObjectHome;
import java.io.IOException;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class TestEx2 extends BaseTest {

    //2. Assert Browser title
    @Test(priority = 1)
    public void assertTitle() {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();
    }

    //3. Perform login
    //4. Assert Username in the left-top side of screen that user is logged in
    @Test(priority = 2)
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

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void navigateToDifferentElementsPage() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        pageObjectHome.clickServiceMenu();
        pageObjectHome.clickDifferentElementServiceMenuItem();
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
         .until(dr -> ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete"));
        SoftAssertions softDifferentElements = new SoftAssertions();
        softDifferentElements.assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
        softDifferentElements.assertAll();
    }

    //6. Select checkboxes, Elements are checked
    @Test(priority = 4)
    public void assertCheckBox() {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.chooseWaterCheckBox();
        pageObjectDifferentElements.chooseWindCheckBox();
        boolean isWaterSelected = pageObjectDifferentElements.getWindCheckBox().isSelected();
        boolean isWindSelected = pageObjectDifferentElements.getWaterCheckBox().isSelected();
        SoftAssertions softCheckBox = new SoftAssertions();
        softCheckBox.assertThat(isWaterSelected).isTrue();
        softCheckBox.assertThat(isWindSelected).isTrue();
        softCheckBox.assertAll();
    }

    //7. Select radio, Element is checked
    @Test(priority = 5, dataProvider = "data-provider-for-radio-button")
    public void assertRadioBox(String element) {
        String el = element;
        By radioMetalPath = new By.ByXPath("//label[text()[contains(., ' " + el + "')]]/*[@type='radio']");
        WebElement radioElement = webDriver.findElement(radioMetalPath);
        radioElement.click();
        Boolean isMetalSelected = radioElement.isSelected();
        SoftAssertions softRadio = new SoftAssertions();
        softRadio.assertThat(isMetalSelected).isTrue();
        softRadio.assertAll();
    }

    @DataProvider(name = "data-provider-for-radio-button")
    public Object[][] dataSetForAddition() {
        return new Object[][]{{"Gold"}, {"Silver"}, {"Bronze"}, {"Selen"}};
    }


    //8. Select in dropdown, Element is selected
    @Test(priority = 6)
    public void assertDropDown() {
        DropDownOfColorsOnDifferentElementPage dropDown = new DropDownOfColorsOnDifferentElementPage(webDriver);
        dropDown.assertSelectedDropDownItem("Yellow");
    }

    //9. Assert that for each checkbox there is an individual log row
    //and value is corresponded to the status of checkbox
    //9. Assert that for radio button there is a log row and value is corresponded to the status of radio button
    //9. Assert that for dropdown there is a log row and value is corresponded to the selected value.

    @Test(priority = 8)
    public void assertLogger() {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        SoftAssertions logger = new SoftAssertions();
        logger.assertThat(pageObjectDifferentElements.getWaterCheckedLog().isDisplayed());
        logger.assertThat(pageObjectDifferentElements.getWindCheckedLog().isDisplayed());
        logger.assertThat(pageObjectDifferentElements.getSelenCheckedLog().isDisplayed());
        logger.assertThat(pageObjectDifferentElements.getYellowCheckedLog().isDisplayed());
    }

}
