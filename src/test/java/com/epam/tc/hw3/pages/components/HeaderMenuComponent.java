package com.epam.tc.hw3.pages.components;


import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderMenuComponent {

    @FindBy(css = "[class='uui-navigation nav navbar-nav m-l8']>li")
    private List<WebElement> navigationHeader;

    @FindBy(partialLinkText = "HOME")
    private WebElement homeHeaderItem;

    @FindBy(partialLinkText = "CONTACT FORM")
    private WebElement formHeaderItem;

    @FindBy(partialLinkText = "SERVICE")
    private WebElement serviceHeaderItem;

    @FindBy(partialLinkText = "METALS & COLORS")
    private WebElement metalsAndColorsHeaderItem;

    public List<WebElement> getNavigationHeader() {
        return navigationHeader;
    }

    public WebElement getHomeHeaderItem() {
        return homeHeaderItem;
    }

    public WebElement getFormHeaderItem() {
        return formHeaderItem;
    }

    public WebElement getServiceHeaderItem() {
        return serviceHeaderItem;
    }

    public WebElement getMetalsAndColorsHeaderItem() {
        return metalsAndColorsHeaderItem;
    }

    public  int headerMenuSize() {
        return navigationHeader.size();
    }

    public void clickOnServiceItem() {
        serviceHeaderItem.click();
    }
}
