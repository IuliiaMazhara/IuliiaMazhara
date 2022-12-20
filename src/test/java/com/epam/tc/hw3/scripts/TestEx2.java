package com.epam.tc.hw3.scripts;


import com.epam.tc.hw3.BaseTest;
import com.epam.tc.hw3.pages.PageObjectDifferentElements;
import com.epam.tc.hw3.pages.PageObjectHome;
import com.epam.tc.hw3.pages.PageObjectLoginPage;
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
        PageObjectLoginPage.using(webDriver)
                .clickUserIcon()
                .setUsername()
                .setPassword()
                .clickSignInButton();
        new WebDriverWait(webDriver, Duration.ofSeconds(6))
                .until(ExpectedConditions.visibilityOf(PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser()));
        String nameOfLoggedUser = PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser().getText();
        SoftAssertions softLogin = new SoftAssertions();
        softLogin.assertThat(nameOfLoggedUser).isEqualTo("ROMAN IOVLEV");
        softLogin.assertAll();
    }

    @Test(priority = 3, dataProvider = "data-provider-for-title")
    public void parameterTest(String menuItem, String pageTitle) throws IOException {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        pageObjectHome.getHeaderPageElements().clickOnServiceItem();
        By menuItems = By.partialLinkText(menuItem);
        webDriver.findElement(menuItems).click();
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(dr -> ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete"));
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(webDriver.getTitle()).isEqualTo(pageTitle);
        softTitle.assertAll();
    }

    @DataProvider(name = "data-provider-for-title")
    public Object[][] dataSetForAddition() {
        return new Object[][]{
                {"SUPPORT", "Support"},
                {"DATES", "Dates"},
                {"SEARCH", "Simple Table"},
                {"COMPLEX TABLE", "Complex Table"},
                {"SIMPLE TABLE", "Simple Table"},
                {"USER TABLE", "User Table"},
                {"TABLE WITH PAGES", "Table with pages"},
                {"DIFFERENT ELEMENTS", "Different Elements"},
                {"PERFORMANCE", "Performance page"},
        };
    }

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 4)
    public void navigateToDifferentElementsPage() {
        PageObjectHome pageObjectHome = new PageObjectHome(webDriver);
        pageObjectHome.getHeaderPageElements().clickOnServiceItem();
        pageObjectHome.clickDifferentElementServiceMenuItem();
        new WebDriverWait(webDriver, Duration.ofSeconds(3))
                .until(dr -> ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete"));
        SoftAssertions softDifferentElements = new SoftAssertions();
        softDifferentElements.assertThat(webDriver.getTitle()).isEqualTo("Different Elements");
        softDifferentElements.assertAll();
    }

    //6. Select checkboxes, Elements are checked
    //9. Assert that for each checkbox there is an individual log row
    //and value is corresponded to the status of checkbox
    @Test(priority = 5)
    public void assertCheckBox() {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.chooseWaterCheckBox();
        pageObjectDifferentElements.chooseWindCheckBox();
        boolean isWaterSelected = pageObjectDifferentElements.getWindCheckBox().isSelected();
        boolean isWindSelected = pageObjectDifferentElements.getWaterCheckBox().isSelected();
        SoftAssertions softCheckBox = new SoftAssertions();
        softCheckBox.assertThat(isWaterSelected).isTrue();
        softCheckBox.assertThat(isWindSelected).isTrue();
        softCheckBox.assertThat(pageObjectDifferentElements.getWaterCheckedLog().isDisplayed());
        softCheckBox.assertThat(pageObjectDifferentElements.getWindCheckedLog().isDisplayed());
        softCheckBox.assertAll();
    }

    //7. Select radio, Element is checked
    //9. Assert that for radio button there is a log row and value is corresponded to the status of radio button
    @Test(priority = 6, dataProvider = "data-provider-for-radio-button")
    public void assertRadioBox(String element) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.assertRadioBoxLog(element);
    }

    @DataProvider(name = "data-provider-for-radio-button")
    public Object[][] dataSetForMetals() {
        return new Object[][]{{"Gold"}, {"Silver"}, {"Bronze"}, {"Selen"}};
    }


    //8. Select in dropdown, Element is selected
    //9. Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Test(priority = 7, dataProvider = "data-provider-for-dropdown")
    public void assertDropDown(String color) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.assertDropDownLog(color);
    }

    @DataProvider(name = "data-provider-for-dropdown")
    public Object[][] dataSetForColors() {
        return new Object[][]{{"Yellow"}, {"Red"}, {"Green"}, {"Blue"}};
    }

}
