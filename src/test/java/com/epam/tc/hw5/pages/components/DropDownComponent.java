package com.epam.tc.hw5.pages.components;


import static com.epam.tc.hw4.BaseTest.webDriver;
import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.pages.PageObjectDifferentElements;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;





public class DropDownComponent {

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']")
    private WebElement dropDownColor;

    @FindBy(xpath = "//*[contains(text(),'Colors: value changed to Yellow')]")
    private WebElement yellowDropDownColor;

    public void clickOnDropDown() {
        dropDownColor.click();
    }

    public void selectDropDown(String color) {
        clickOnDropDown();
        Select dropDownColors = new Select(getDropDownColor());
        dropDownColors.selectByVisibleText(color);
    }

    public void assertDropDown(String color) {
        clickOnDropDown();
        Select dropDownColors = new Select(getDropDownColor());
        String selectedOption = dropDownColors.getFirstSelectedOption().getText();
        assertThat(selectedOption).isEqualTo(color);
    }

    public void assertDropDownLogger(String color) {
        yellowDropDownColor.isDisplayed();
    }

    public WebElement getDropDownColor() {
        return dropDownColor;
    }
}
