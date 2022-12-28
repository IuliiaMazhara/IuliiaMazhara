package com.epam.tc.hw5.pages;


import com.epam.tc.hw5.pages.components.HeaderMenuComponent;
import com.epam.tc.hw5.pages.components.SideMenuComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageObjectHome extends MainPage {

    private final HeaderMenuComponent headerPageElements;
    private final SideMenuComponent sideMenuComponent;
    @FindBy(partialLinkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementServiceMenuItem;

    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderItem;

    public PageObjectHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        headerPageElements = new HeaderMenuComponent();
        sideMenuComponent = new SideMenuComponent();
        PageFactory.initElements(driver, headerPageElements);
        PageFactory.initElements(driver, sideMenuComponent);
    }

    public WebElement getDifferentElementServiceMenuItem() {
        return differentElementServiceMenuItem;
    }

    public void clickDifferentElementServiceMenuItem() {
        differentElementServiceMenuItem.click();
    }

    public SideMenuComponent getSideMenuComponent() {
        return sideMenuComponent;
    }

    public void openHomePage() {
        driver.manage().window().maximize();
        driver.get("https://jdi-testing.github.io/jdi-light/index.html");
    }

    public HeaderMenuComponent getHeaderPageElements() {
        return headerPageElements;
    }

    public void clickOnServiceMenuItem() {
        serviceHeaderItem.click();
    }

    public void clickServiceMenuItem(String item) {
        By serviceMenuItemPath = new By.ByXPath("//a/span[contains(text(),'" + item + "')]");
        WebElement serviceMenuItem = driver.findElement(serviceMenuItemPath);
        serviceMenuItem.click();
    }

}

