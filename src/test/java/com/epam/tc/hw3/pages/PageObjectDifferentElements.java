package com.epam.tc.hw3.pages;


import com.epam.tc.hw3.pages.components.DropDownComponent;
import com.epam.tc.hw3.pages.components.HeaderMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



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

}
