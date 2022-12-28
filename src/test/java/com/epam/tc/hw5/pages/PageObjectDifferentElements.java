package com.epam.tc.hw5.pages;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.pages.components.DropDownComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class PageObjectDifferentElements extends MainPage {

    private final DropDownComponent dropDownComponent;

    public PageObjectDifferentElements(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        dropDownComponent = new DropDownComponent();
        PageFactory.initElements(driver, dropDownComponent);
    }

    public DropDownComponent getDropDownComponent() {
        return dropDownComponent;
    }

    public void clickOnElementCheckBox(String element) {
        By checkBoxElementPath = new By.ByXPath("//label[text()[contains(., ' " + element + "')]]/*[@type='checkbox']");
        WebElement checkBoxElement = webDriver.findElement(checkBoxElementPath);
        checkBoxElement.click();
    }

    public void assertCheckBoxIsSelected(String element) {
        By checkBoxElementPath = new By.ByXPath("//label[text()[contains(., ' " + element + "')]]/*[@type='checkbox']");
        WebElement checkBoxElement = webDriver.findElement(checkBoxElementPath);
        assertThat(checkBoxElement.isSelected()).isTrue();
    }

    public void assertCheckBoxLogger(String element) {
        By loggerPath = new By.ByXPath("//*[contains(text(),'" + element + ": condition changed to true')]");
        WebElement checkBoxElement = webDriver.findElement(loggerPath);
        elementIsDisplayed(checkBoxElement);
    }

    public void clickOnMetalRadioButton(String metal) {
        By radioMetalPath = new By.ByXPath("//label[text()[contains(., ' " + metal + "')]]/*[@type='radio']");
        WebElement radioElement = webDriver.findElement(radioMetalPath);
        radioElement.click();
    }

    public void assertRadioBoxIsSelected(String metal) {
        By radioMetalPath = new By.ByXPath("//label[text()[contains(., ' " + metal + "')]]/*[@type='radio']");
        WebElement radioElement = webDriver.findElement(radioMetalPath);
        elementIsDisplayed(radioElement);
    }

    public void assertRadioLogger(String metal) {
        By loggerRadioPath = new By.ByXPath("//*[contains(text(),'metal: value changed to  " + metal + "')]");
        WebElement radioLoggerElement = webDriver.findElement(loggerRadioPath);
        elementIsDisplayed(radioLoggerElement);
    }
}
