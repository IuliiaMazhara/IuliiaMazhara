package com.epam.tc.hw7.pages;

import com.epam.jdi.light.elements.common.Label;
import com.epam.jdi.light.elements.complex.WebList;
import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Icon;
import com.epam.tc.hw7.enteties.User;
import com.epam.tc.hw7.forms.LoginForm;
import org.openqa.selenium.support.FindBy;


public class JdiHomePage extends WebPage {

    @FindBy(css = ".benefit")
    WebList benefits;

    @FindBy(id = "user-name")
    public Label userName;

    @FindBy(id = "user-icon")
    public Icon userIcon;


    @Css("form") public static LoginForm loginform;

    public int getBenefitsCount() {
        return benefits.size();
    }

    public void login(User user) {
        userIcon.click();
        loginform.login(user);
    }

    public String getUserName() {
        return userName.getText();
    }
}
