package com.epam.tc.hw5.pages.components;


import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SideMenuComponent {

    @FindBy(css = ".sidebar-menu > li")
    private List<WebElement> sideMenuItems;

    public  int sideMenuSize() {
        return sideMenuItems.size();
    }

    public List<String> getSideMenuItems() {
        return sideMenuItems.stream().map(WebElement::getText).collect(Collectors.toList());
    }
}
