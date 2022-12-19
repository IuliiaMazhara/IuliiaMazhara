package com.epam.tc.hw3.pages.components;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DropDownComponent {

    @FindBy(xpath = ".//*[@class='colors']//*[@class='uui-form-element']")
    private WebElement dropDownColor;

    public void clickOnDropDown() {
        dropDownColor.click();
    }

    public WebElement getDropDownColor() {
        return dropDownColor;
    }
}
