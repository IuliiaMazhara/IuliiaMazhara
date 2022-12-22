package com.epam.tc.hw3.pages.components;

import static com.epam.tc.hw4.BaseTest.webDriver;

import com.epam.tc.hw3.pages.PageObjectDifferentElements;
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
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.getDropDownComponent().clickOnDropDown();
        Select dropDownColors = new Select(pageObjectDifferentElements.getDropDownComponent().getDropDownColor());
        dropDownColors.selectByVisibleText(color);
    }

    public void assertDropDown(String color) {
        PageObjectDifferentElements pageObjectDifferentElements = new PageObjectDifferentElements(webDriver);
        pageObjectDifferentElements.getDropDownComponent().clickOnDropDown();
        Select dropDownColors = new Select(pageObjectDifferentElements.getDropDownComponent().getDropDownColor());
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
