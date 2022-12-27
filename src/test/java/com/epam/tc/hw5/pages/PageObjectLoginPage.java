package com.epam.tc.hw5.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjectLoginPage extends MainPage {

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


    public PageObjectLoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static PageObjectLoginPage using(WebDriver driver) {
        return new PageObjectLoginPage(driver);
    }

    public PageObjectLoginPage setUsernameParameter(String usernameParameter) {
        this.name.sendKeys(usernameParameter);
        return this;
    }

    public PageObjectLoginPage setPasswordParameter(String passwordParameter) {
        this.password.sendKeys(passwordParameter);
        return this;
    }

    public void clickSignInButton() {
        this.signInButton.click();
    }

    public PageObjectLoginPage clickUserIcon() {
        this.userIcon.click();
        return this;
    }

    public WebElement getNamedOfLoggedUser() {
        return namedOfLoggedUser;
    }
}
