package com.epam.tc.hw3.pages;


import static com.epam.tc.hw3.utils.ConfigReader.getUserNameFromProperties;
import static com.epam.tc.hw3.utils.ConfigReader.getUserPasswordFromProperties;

import com.epam.tc.hw3.pages.components.HeaderMenuComponent;
import java.io.IOException;
import java.util.List;

import com.epam.tc.hw3.pages.components.SideMenuComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PageObjectHome {

    private final HeaderMenuComponent headerPageElements;

    private final SideMenuComponent sideMenuComponent;

    @FindBy(css = "[class='icons-benefit icon-practise']")
    private WebElement iconPractise;

    @FindBy(css = "[class='icons-benefit icon-custom']")
    private WebElement iconCustom;

    @FindBy(css = "[class='icons-benefit icon-multi']")
    private WebElement iconMulti;

    @FindBy(css = "[class='icons-benefit icon-base']")
    private WebElement iconBase;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementServiceMenuItem;

    @FindBy(className = "benefit-icon")
    private List<WebElement> listOfTheImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> listOfTheText;

    public PageObjectHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
        headerPageElements = new HeaderMenuComponent();
        sideMenuComponent = new SideMenuComponent();
        PageFactory.initElements(driver, headerPageElements);
        PageFactory.initElements(driver, sideMenuComponent);
    }

    public HeaderMenuComponent getHeaderPageElements() {
        return headerPageElements;
    }

    public List<WebElement> getListOfTheText() {
        return listOfTheText;
    }

    public List<WebElement> getListOfTheImages() {
        return listOfTheImages;
    }

    public WebElement getFrameButton() {
        return frameButton;
    }

    public WebElement getDifferentElementServiceMenuItem() {
        return differentElementServiceMenuItem;
    }

    public WebElement getIconPractise() {
        return iconPractise;
    }

    public WebElement getIconCustom() {
        return iconCustom;
    }

    public WebElement getIconMulti() {
        return iconMulti;
    }

    public WebElement getIconBase() {
        return iconBase;
    }

    public void clickDifferentElementServiceMenuItem() {
        differentElementServiceMenuItem.click();
    }

    public SideMenuComponent getSideMenuComponent() {
        return sideMenuComponent;
    }
}
