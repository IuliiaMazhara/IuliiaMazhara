package com.epam.tc.hw3.pages;

import static com.epam.tc.hw3.BaseTest.webDriver;

import com.epam.tc.hw3.pages.components.DropDownComponent;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;



public class PageObjectDifferentElements {

    private final DropDownComponent dropDownComponent;

    @FindBy(xpath = "//label[text()[contains(., ' Water')]]/*[@type='checkbox']")
    private WebElement waterCheckBox;

    @FindBy(xpath = "//label[text()[contains(., ' Wind')]]/*[@type='checkbox']")
    private WebElement windCheckBox;

    @FindBy(xpath = "//label[text()[contains(., ' Selen')]]/*[@type='radio']")
    private WebElement radioSelen;

    @FindBy(xpath = "//*[contains(text(),'Water: condition changed to true')]")
    private WebElement waterCheckedLog;

    @FindBy(xpath = "//*[contains(text(),'Wind: condition changed to true')]")
    private WebElement windCheckedLog;

    @FindBy(xpath = "//*[contains(text(),'metal: value changed to  Selen')]")
    private WebElement selenCheckedLog;

    @FindBy(xpath = "//*[contains(text(),'Colors: value changed to Yellow')]")
    private WebElement yellowCheckedLog;

    public PageObjectDifferentElements(WebDriver driver) {

        PageFactory.initElements(driver, this);
        dropDownComponent = new DropDownComponent();
        PageFactory.initElements(driver, dropDownComponent);
    }

    public WebElement getWaterCheckBox() {
        return waterCheckBox;
    }

    public WebElement getWindCheckBox() {
        return windCheckBox;
    }

    public WebElement getRadioSelen() {
        return radioSelen;
    }

    public WebElement getWaterCheckedLog() {
        return waterCheckedLog;
    }

    public WebElement getWindCheckedLog() {
        return windCheckedLog;
    }

    public WebElement getSelenCheckedLog() {
        return selenCheckedLog;
    }

    public WebElement getYellowCheckedLog() {
        return yellowCheckedLog;
    }

    public void chooseWaterCheckBox() {
        waterCheckBox.click();
    }

    public void chooseWindCheckBox() {
        windCheckBox.click();
    }

    public void chooseSelenRadioBox() {
        radioSelen.click();
    }

    public DropDownComponent getDropDownComponent() {
        return dropDownComponent;
    }

    public void assertRadioBoxLog(String element) {
        By radioMetalPath = new By.ByXPath("//label[text()[contains(., ' " + element + "')]]/*[@type='radio']");
        WebElement radioElement = webDriver.findElement(radioMetalPath);
        radioElement.click();
        Boolean isMetalSelected = radioElement.isSelected();
        By loggerPath = new By.ByXPath("//*[contains(text(),'metal: value changed to  " + element + "')]");
        WebElement radioLoggerElement = webDriver.findElement(loggerPath);
        SoftAssertions softRadio = new SoftAssertions();
        softRadio.assertThat(isMetalSelected).isTrue();
        softRadio.assertThat(radioLoggerElement.isDisplayed());
        softRadio.assertAll();
    }

    public void assertDropDownLog(String color) {
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

}
