package com.epam.tc.hw2.scripts.ex2;

import com.epam.tc.hw2.InitializeKillWebSite;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class TestEx2 extends InitializeKillWebSite {

    //Assert the login
    @Test
    public void assertLogin() {

        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.cssSelector(("i[class='fa fa-sign-in']"))).click();
        By userName = By.id("user-name");
        SoftAssertions softLogin = new SoftAssertions();
        softLogin.assertThat(driver.findElement(userName).getText()).isEqualTo("ROMAN IOVLEV");
        softLogin.assertAll();

    }


    //Navigate to the Different ElementsPage
    @Test
    public void navigateToDifferentElementsPage() {

        By serviceFormElement = By.partialLinkText("SERVICE");
        driver.findElement(serviceFormElement).click();
        By menuItemDifferentElements = By.partialLinkText("DIFFERENT ELEMENTS");
        driver.findElement(menuItemDifferentElements).click();
        SoftAssertions softDifferentElements = new SoftAssertions();
        softDifferentElements.assertThat(driver.getTitle()).isEqualTo("Different Elements");
        softDifferentElements.assertAll();

    }

    @Test
    public void assertCheckBox() {



    }

}
