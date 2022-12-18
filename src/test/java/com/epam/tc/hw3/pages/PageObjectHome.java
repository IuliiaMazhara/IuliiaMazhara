package com.epam.tc.hw3.pages;


import static com.epam.tc.hw3.utils.ConfigReader.getUserNameFromProperties;
import static com.epam.tc.hw3.utils.ConfigReader.getUserPasswordFromProperties;

import com.epam.tc.hw3.pages.components.HeaderMenuComponent;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PageObjectHome {

    private final HeaderMenuComponent headerPageElements;
    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "i[class='fa fa-sign-in']")
    private WebElement signInButton;

    @FindBy(id = "user-name")
    private WebElement namedOfLoggedUser;

    @FindBy(css = "[class='icons-benefit icon-practise']")
    private WebElement iconPractise;

    @FindBy(css = "[class='icons-benefit icon-custom']")
    private WebElement iconCustom;

    @FindBy(css = "[class='icons-benefit icon-multi']")
    private WebElement iconMulti;

    @FindBy(css = "[class='icons-benefit icon-base']")
    private WebElement iconBase;

    @FindBy(xpath = ".//*[@class='icons-benefit icon-practise']/..//../span[@class = 'benefit-txt']")
    private WebElement practiseText;

    @FindBy(xpath = ".//*[@class='icons-benefit icon-custom']/..//../span[@class = 'benefit-txt']")
    private WebElement customText;

    @FindBy(xpath = ".//*[@class='icons-benefit icon-multi']/..//../span[@class = 'benefit-txt']")
    private WebElement multiText;

    @FindBy(xpath = ".//*[@class='icons-benefit icon-base']/..//../span[@class = 'benefit-txt']")
    private WebElement baseText;

    @FindBy(id = "frame-button")
    private WebElement frameButton;

    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementServiceMenuItem;

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private List<WebElement> headerMenu;

    @FindBy(className = "benefit-icon")
    private List<WebElement> listOfTheImages;

    @FindBy(className = "benefit-txt")
    private List<WebElement> listOfTheText;

    @FindBy(xpath = "//*[@id='mCSB_1_container']/ul/li")
    private List<WebElement> sideMenuItems;



    public PageObjectHome(WebDriver driver) {
        PageFactory.initElements(driver, this);
        headerPageElements = new HeaderMenuComponent();
        PageFactory.initElements(driver, headerPageElements);


    }

    public HeaderMenuComponent getHeaderPageElements() {
        return headerPageElements;
    }

    public List<WebElement> getHeaderMenu() {
        return headerMenu;
    }

    public List<WebElement> getSideMenuItems() {
        return sideMenuItems;
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

    public WebElement getPractiseText() {
        return practiseText;
    }

    public WebElement getCustomText() {
        return customText;
    }

    public WebElement getMultiText() {
        return multiText;
    }

    public WebElement getBaseText() {
        return baseText;
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

    public WebElement getUserIcon() {
        return userIcon;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public WebElement getNamedOfLoggedUser() {
        return namedOfLoggedUser;
    }

    public void clickUserIcon() {
        userIcon.click();
    }

    public void enterUserName() throws IOException {
        name.sendKeys(getUserNameFromProperties());
    }

    public void enterPassword() throws IOException {
        password.sendKeys(getUserPasswordFromProperties());
    }

    public void clickDifferentElementServiceMenuItem() {
        differentElementServiceMenuItem.click();
    }

}
