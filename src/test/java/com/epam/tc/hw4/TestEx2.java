package com.epam.tc.hw4;


import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.pages.PageObjectDifferentElements;
import com.epam.tc.hw3.pages.PageObjectHome;
import com.epam.tc.hw3.pages.PageObjectLoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.io.IOException;
import java.time.Duration;

import lombok.SneakyThrows;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


@Feature("Functionality of Different elements page")
@Story("Log in, checkboxes, radio buttons, logger")
public class TestEx2 extends BaseTest {

    public static final String CAT_URL= "https://en.wikipedia.org/wiki/Cat#/media/File:Cat_August_2010-4.jpg";

    //2. Assert Browser title
    @Test(priority = 1)
    @Description("Test to assert that the Home Page is displayed")
    @Step
    public void assertTitle() {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(webDriver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();
    }

    //3. Perform login
    //4. Assert Username in the left-top side of screen that user is logged in
    @Test(priority = 2)
    @Description("Test to assert that the user is able to login")
    @Step
    public void assertLogin() throws IOException {
        PageObjectLoginPage.using(webDriver).clickUserIcon().setUsername().setPassword().clickSignInButton();
        new WebDriverWait(webDriver, Duration.ofSeconds(6)).until(ExpectedConditions.visibilityOf(PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser()));
        String nameOfLoggedUser = PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser().getText();
        SoftAssertions softLogin = new SoftAssertions();
        softLogin.assertThat(nameOfLoggedUser).isEqualTo("ROMAN IOVLEV");
        softLogin.assertAll();
    }

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    @Description("Test to assert the navigation to the Different Elements page")
    @Step
    public void navigateToDifferentElementsPage() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        pageObjectHome.getHeaderPageElements().clickOnServiceItem();
        pageObjectHome.clickDifferentElementServiceMenuItem();
        new WebDriverWait(webDriver, Duration.ofSeconds(3)).until(dr -> ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete"));
        SoftAssertions softDifferentElements = new SoftAssertions();
        softDifferentElements.assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
        softDifferentElements.assertAll();
    }

    //6. Select checkboxes, Elements are checked
    //9. Assert that for each checkbox there is an individual log row
    //and value is corresponded to the status of checkbox
    @Test(priority = 4)
    @Description("Test to assert checkboxes")
    @Step
    public void assertCheckBox() {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.chooseWaterCheckBox();
        pageObjectDifferentElements.chooseWindCheckBox();
        boolean isWaterSelected = pageObjectDifferentElements.getWindCheckBox().isSelected();
        boolean isWindSelected = pageObjectDifferentElements.getWaterCheckBox().isSelected();
        SoftAssertions softCheckBox = new SoftAssertions();
        softCheckBox.assertThat(pageObjectDifferentElements.getWaterCheckedLog().isDisplayed());
        softCheckBox.assertThat(pageObjectDifferentElements.getWindCheckedLog().isDisplayed());
        softCheckBox.assertThat(isWaterSelected).isTrue();
        softCheckBox.assertThat(isWindSelected).isTrue();
        softCheckBox.assertAll();
    }

    //7. Select radio, Element is checked
    //9. Assert that for radio button there is a log row and value is corresponded to the status of radio button
    @Test(priority = 5, dataProvider = "data-provider-for-radio-button")
    @Description("Test to assert radio buttons")
    @Step
    public void assertRadioBox(String element) {
        By radioMetalPath = new By.ByXPath("//label[text()[contains(., ' " + element + "')]]/*[@type='radio']");
        WebElement radioElement = webDriver.findElement(radioMetalPath);
        radioElement.click();
        Boolean isMetalSelected = radioElement.isSelected();
        By loggerPath = new By.ByXPath("//*[contains(text(),'metal: value changed to  " + element +"')]");
        WebElement radioLoggerElement = webDriver.findElement(loggerPath);
        SoftAssertions softRadio = new SoftAssertions();
        softRadio.assertThat(isMetalSelected).isTrue();
        softRadio.assertThat(radioLoggerElement.isDisplayed());
        softRadio.assertAll();
    }

    @DataProvider(name = "data-provider-for-radio-button")
    public Object[][] dataSetForMetals() {
        return new Object[][]{{"Gold"}, {"Silver"}, {"Bronze"}, {"Selen"}};
    }


    //8. Select in dropdown, Element is selected
    //9. Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 6, dataProvider = "data-provider-for-dropdown")
    @Description("Test to assert the dropdown")
    @Step
    public void assertDropDown(String color) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.getDropDownComponent().clickOnDropDown();
        Select dropDownColors = new Select(pageObjectDifferentElements.getDropDownComponent().getDropDownColor());
        dropDownColors.selectByVisibleText(color);
        String selectedOption = dropDownColors.getFirstSelectedOption().getText();
        By loggerPath = new By.ByXPath("//*[contains(text(),'Colors: value changed to " + color + "')]");
        WebElement colorLoggerElement = webDriver.findElement(loggerPath);
        SoftAssertions softDropDown = new SoftAssertions();
        softDropDown.assertThat(selectedOption).isEqualTo(color);
        softDropDown.assertThat(colorLoggerElement.isDisplayed());
        softDropDown.assertAll();
    }

    @DataProvider(name = "data-provider-for-dropdown")
    public Object[][] dataSetForColors() {
        return new Object[][]{{"Yellow"}, {"Red"}, {"Green"}, {"Blue"}};
    }

    @Test
    @SneakyThrows
    public void testCatAttachment(){

    }
}
