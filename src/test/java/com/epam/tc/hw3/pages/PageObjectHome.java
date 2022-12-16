package com.epam.tc.hw3.pages;


import static com.epam.tc.hw3.utils.ConfigReader.getUserNameFromProperties;
import static com.epam.tc.hw3.utils.ConfigReader.getUserPasswordFromProperties;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class PageObjectHome {


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

    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']/li")
    private WebElement headerMenuContainer;

    @FindBy(partialLinkText = "HOME")
    private WebElement homeHeaderMenuItem;

    @FindBy(partialLinkText = "CONTACT FORM")
    private WebElement contactFormHeaderMenuItem;

    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderMenuItem;

    @FindBy(partialLinkText = "METALS & COLORS")
    private WebElement metalsAndColorsHeaderMenuItem;

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

    public WebElement getHeaderMenuContainer() {
        return headerMenuContainer;
    }

    public WebElement getHomeHeaderMenuItem() {
        return homeHeaderMenuItem;
    }

    public WebElement getContactFormHeaderMenuItem() {
        return contactFormHeaderMenuItem;
    }

    public WebElement getServiceHeaderMenuItem() {
        return serviceHeaderMenuItem;
    }

    public WebElement getMetalsAndColorsHeaderMenuItem() {
        return metalsAndColorsHeaderMenuItem;
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

    public void clickServiceMenu() {
        serviceHeaderMenuItem.click();
    }

}
