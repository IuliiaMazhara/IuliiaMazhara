package com.epam.tc.hw4;


import com.epam.tc.hw3.pages.PageObjectDifferentElements;
import com.epam.tc.hw3.pages.PageObjectHome;
import com.epam.tc.hw3.pages.PageObjectLoginPage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import java.io.IOException;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Feature("Different Elements page")
@Story("Checkbox, Radio buttons, Dropdown")
public class TestEx2 extends BaseTest {

    @Test
    @Description("Test Different Element page")
    public void verifyDifferentElements() throws IOException {
        assertTitle("Home Page");
        assertLogin();
        navigateToDifferentElementsPage();
        assertCheckBoxLog("Water");
        assertCheckBoxLog("Wind");
        assertRadioBoxLog("Selen");
        assertDropDownLog("Yellow");
    }

    //2. Assert Browser title
    @Step
    public void assertTitle(String pageTitle) {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(webDriver.getTitle()).isEqualTo(pageTitle);
        softTitle.assertAll();
    }

    //3. Perform login
    //4. Assert Username in the left-top side of screen that user is logged in
    @Step
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

    //5. Open through the header menu Service -> Different Elements Page
    @Step
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
    @Step
    public void assertCheckBoxLog(String element) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.clickOnElementCheckBox(element);
        pageObjectDifferentElements.assertCheckBoxIsSelected(element);
        pageObjectDifferentElements.assertCheckBoxLogger(element);
    }

    //7. Select radio, Element is checked
    //9. Assert that for radio button there is a log row and value is corresponded to the status of radio button
    @Step
    public void assertRadioBoxLog(String metal) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.clickOnMetalRadioButton(metal);
        pageObjectDifferentElements.assertRadioBoxIsSelected(metal);
        pageObjectDifferentElements.assertRadioLogger(metal);
    }

    //8. Select in dropdown, Element is selected
    //9. Assert that for dropdown there is a log row and value is corresponded to the selected value.
    @Step
    public void assertDropDownLog(String color) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.selectDropDown(color);
        pageObjectDifferentElements.assertDropDown(color);
        pageObjectDifferentElements.assertDropDownLogger(color);
    }

}