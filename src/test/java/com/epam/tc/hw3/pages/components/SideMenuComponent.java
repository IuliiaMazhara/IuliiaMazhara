package com.epam.tc.hw3.pages.components;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SideMenuComponent {

    @FindBy(css = "ul[class='sidebar-menu left']>li")
    private List<WebElement> sideMenuItems;

    public  int sideMenuSize() {
        return sideMenuItems.size();
    }

    public List<WebElement> getSideMenuItems() {
        return sideMenuItems;
    }

}
