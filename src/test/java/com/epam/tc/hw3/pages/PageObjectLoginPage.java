package com.epam.tc.hw3.pages;

import static com.epam.tc.hw3.utils.ConfigReader.getUserNameFromProperties;
import static com.epam.tc.hw3.utils.ConfigReader.getUserPasswordFromProperties;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;




public class PageObjectLoginPage {

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


    private PageObjectLoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public static PageObjectLoginPage using(WebDriver driver) {
        return new PageObjectLoginPage(driver);
    }

    public PageObjectLoginPage setUsername() throws IOException {
        this.name.sendKeys(getUserNameFromProperties());
        return this;
    }

    public PageObjectLoginPage setPassword() throws IOException {
        this.password.sendKeys(getUserPasswordFromProperties());
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
