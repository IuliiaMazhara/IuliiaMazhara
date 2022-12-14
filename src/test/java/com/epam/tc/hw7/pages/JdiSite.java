package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.pageobjects.annotations.JSite;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import com.epam.tc.hw7.entities.MetalColor;
import com.epam.tc.hw7.entities.User;
import com.epam.tc.hw7.pages.JdiHomePage;
import com.epam.tc.hw7.pages.MetalColorPage;


@JSite("https://jdi-testing.github.io/jdi-light/")
public class JdiSite {

    @Url("index.html")
    public static JdiHomePage jdiHomePage;

    @Url("metals-colors.html")
    public static MetalColorPage metalColorPage;

    public static void openHomePage() {
        jdiHomePage.open();
    }

    public static void openMetalsAndColorsPage() {
        metalColorPage.open();
    }

    public static void login(User user) {
        jdiHomePage.login(user);
    }

    public static String getUserName() {
        return jdiHomePage.getUserName();
    }

    public static void fillMetalsColorsForm(MetalColor metalColor) {
        metalColorPage.fillMetalAndColorForm(metalColor);
    }

    public static void verifyResultLog(MetalColor metalColor) {
        metalColorPage.assertResultLog(metalColor);
    }
}

