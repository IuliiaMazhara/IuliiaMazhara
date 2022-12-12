package com.epam.tc.hw2.scripts.ex2;

import com.epam.tc.hw2.InitializeKillWebSite;
import java.time.Duration;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;



public class TestEx2 extends InitializeKillWebSite {

    //2. Assert Browser title
    @Test(priority = 1)
    public void assertTitle() {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(driver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();
    }

    //3. Perform login
    //4. Assert Username in the left-top side of screen that user is logged in
    @Test(priority = 2)
    public void assertLogin() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.cssSelector(("i[class='fa fa-sign-in']"))).click();
        By userName = By.id("user-name");
        WebElement userNameElement = driver.findElement(userName);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(userNameElement));
        SoftAssertions softLogin = new SoftAssertions();
        softLogin.assertThat(userNameElement.getText()).isEqualTo("ROMAN IOVLEV");
        softLogin.assertAll();
    }

    //5. Open through the header menu Service -> Different Elements Page
    @Test(priority = 3)
    public void navigateToDifferentElementsPage() {
        By serviceFormElement = By.partialLinkText("SERVICE");
        By menuItemDifferentElements = By.partialLinkText("DIFFERENT ELEMENTS");
        driver.findElement(serviceFormElement).click();
        driver.findElement(menuItemDifferentElements).click();
        new WebDriverWait(driver, Duration.ofSeconds(3))
         .until(dr -> ((JavascriptExecutor) dr).executeScript("return document.readyState").equals("complete"));
        SoftAssertions softDifferentElements = new SoftAssertions();
        softDifferentElements.assertThat(driver.getTitle()).isEqualTo("Different Elements");
        softDifferentElements.assertAll();
    }

    //6. Select checkboxes, Elements are checked
    @Test(priority = 4)
    public void assertCheckBox() {
        By waterCheckBox = new By.ByXPath("//label[text()[contains(., ' Water')]]/*[@type='checkbox']");
        By windCheckBox = new By.ByXPath("//label[text()[contains(., ' Wind')]]/*[@type='checkbox']");
        WebElement waterCheckBoxElement = driver.findElement(waterCheckBox);
        WebElement windCheckBoxElement = driver.findElement(windCheckBox);
        waterCheckBoxElement.click();
        windCheckBoxElement.click();
        boolean isWaterSelected = waterCheckBoxElement.isSelected();
        boolean isWindSelected = windCheckBoxElement.isSelected();
        SoftAssertions softCheckBox = new SoftAssertions();
        softCheckBox.assertThat(isWaterSelected).isTrue();
        softCheckBox.assertThat(isWindSelected).isTrue();
        softCheckBox.assertAll();
    }

    //7. Select radio, Element is checked
    @Test(priority = 5)
    public void assertRadioBox() {
        By radioSelen = new By.ByXPath("//label[text()[contains(., ' Selen')]]/*[@type='radio']");
        WebElement radioSelenElement = driver.findElement(radioSelen);
        driver.findElement(radioSelen).click();
        Boolean isSelenSelected = radioSelenElement.isSelected();
        SoftAssertions softRadio = new SoftAssertions();
        softRadio.assertThat(isSelenSelected).isTrue();
        softRadio.assertAll();
    }

    //8. Select in dropdown, Element is selected
    @Test(priority = 6)
    public void assertDropDown() {
        By dropDownColor = new By.ByXPath(".//*[@class='colors']//*[@class='uui-form-element']");
        driver.findElement(dropDownColor).click();
        Select dropDownColors = new Select(driver.findElement(dropDownColor));
        dropDownColors.selectByVisibleText("Yellow");
        String selectedOption = dropDownColors.getFirstSelectedOption().getText();
        SoftAssertions softDropDown = new SoftAssertions();
        softDropDown.assertThat(selectedOption).isEqualTo("Yellow");
        softDropDown.assertAll();

    }

    //9. Assert that for each checkbox there is an individual log row
    //and value is corresponded to the status of checkbox
    //9. Assert that for radio button there is a log row and value is corresponded to the status of radio button
    //9. Assert that for dropdown there is a log row and value is corresponded to the selected value.

    @Test
    public void assertLogger() {
        SoftAssertions logger = new SoftAssertions();
        By waterCheckedLog = new By.ByXPath("//*[contains(text(),'Water: condition changed to true')]");
        By windCheckedLog = new By.ByXPath("//*[contains(text(),'Wind: condition changed to true')]");
        By selenCheckedLog = new By.ByXPath("//*[contains(text(),'metal: value changed to  Selen')]");
        By yellowCheckedLog = new By.ByXPath("//*[contains(text(),'Colors: value changed to Yellow')]");
        logger.assertThat(driver.findElements(waterCheckedLog).size() != 0).isTrue();
        logger.assertThat(driver.findElements(windCheckedLog).size() != 0).isTrue();
        logger.assertThat(driver.findElements(selenCheckedLog).size() != 0).isTrue();
        logger.assertThat(driver.findElements(yellowCheckedLog).size() != 0).isTrue();

    }

}

