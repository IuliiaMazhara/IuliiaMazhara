package com.epam.tc.hw3.pages.components;

import static com.epam.tc.hw4.BaseTest.webDriver;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class DropDownComponent {

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']")
    private WebElement dropDownColor;

    public void clickOnDropDown() {
        dropDownColor.click();
    }

    public void selectDropDown(String color) {
        clickOnDropDown();
        Select dropDownColors = new Select(dropDownColor);
        dropDownColors.selectByVisibleText(color);
    }

    public void assertDropDown(String color) {
        clickOnDropDown();
        Select dropDownColors = new Select(dropDownColor);
        String selectedOption = dropDownColors.getFirstSelectedOption().getText();
        SoftAssertions softDropDown = new SoftAssertions();
        softDropDown.assertThat(selectedOption).isEqualTo(color);
        softDropDown.assertAll();
    }

    public void assertDropDownLogger(String color) {
        By loggerPath = new By.ByXPath("//*[contains(text(),'Colors: value changed to " + color + "')]");
        WebElement colorLoggerElement = webDriver.findElement(loggerPath);
        SoftAssertions softDropDownLog = new SoftAssertions();
        softDropDownLog.assertThat(colorLoggerElement.isDisplayed());
        softDropDownLog.assertAll();
    }

    public WebElement getDropDownColor() {
        return dropDownColor;
    }
}
