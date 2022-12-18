package com.epam.tc.hw3.pages;

import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class DropDownOfColorsOnDifferentElementPage extends PageObjectHome {

    public DropDownOfColorsOnDifferentElementPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']")
    private WebElement dropDownColor;

    public void assertSelectedDropDownItem(String dropDownItem) {
        dropDownColor.click();
        Select dropDownColors = new Select(dropDownColor);
        dropDownColors.selectByVisibleText(dropDownItem);
        String selectedOption = dropDownColors.getFirstSelectedOption().getText();
        SoftAssertions softDropDown = new SoftAssertions();
        softDropDown.assertThat(selectedOption).isEqualTo(dropDownItem);
        softDropDown.assertAll();
    }

}
