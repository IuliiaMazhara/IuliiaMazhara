package com.epam.tc.hw2.scripts.ex2;

import com.epam.tc.hw2.InitializeKillWebSite;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TestEx2 extends InitializeKillWebSite {

    //Assert the title of the page
    @Test
    public void assertTitle() {

        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(driver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();


    }

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

    //Assert the header
    @Test
    public void assertHeader() {

        SoftAssertions softHeader = new SoftAssertions();
        By homeElement = By.partialLinkText("HOME");
        By contactFormElement = By.partialLinkText("CONTACT FORM");
        By serviceFormElement = By.partialLinkText("SERVICE");
        By metalsColorsElement = By.partialLinkText("METALS & COLORS");
        softHeader.assertThat(driver.findElement(homeElement).getText()).isEqualTo("HOME");
        softHeader.assertThat(driver.findElement(contactFormElement).getText()).isEqualTo("CONTACT FORM");
        softHeader.assertThat(driver.findElement(serviceFormElement).getText()).isEqualTo("SERVICE");
        softHeader.assertThat(driver.findElement(metalsColorsElement).getText()).isEqualTo("METALS & COLORS");
        softHeader.assertAll();


    }


    //Assert the images
    @Test
    public void assertImages() {

        By iconPractise = By.cssSelector("[class='icons-benefit icon-practise']");
        By iconCustom = By.cssSelector("[class='icons-benefit icon-custom']");
        By iconBenefit = By.className("benefit-icon");
        By iconBase = By.cssSelector("[class='icons-benefit icon-base']");
        SoftAssertions softImages = new SoftAssertions();
        softImages.assertThat(driver.findElements(iconPractise).size() != 0).isTrue();
        softImages.assertThat(driver.findElements(iconCustom).size() != 0).isTrue();
        softImages.assertThat(driver.findElements(iconBenefit).size() != 0).isTrue();
        softImages.assertThat(driver.findElements(iconBase).size() != 0).isTrue();
        softImages.assertAll();

    }

    //Assert the images text
    @Test
    public void assertImagesText() {


        String practicesPath = ".//span[contains(text(),'practices')]/../*/*[@class ='icons-benefit icon-practise']";
        By practiseText = new By.ByXPath(practicesPath);
        String customPath = ".//span[contains(text(),'flexible')]/../*/*[@class ='icons-benefit icon-custom']";
        By customText = new By.ByXPath(customPath);
        String multiPath = ".//span[contains(text(),'multiplatform')]/../*/*[@class ='icons-benefit icon-multi']";
        By multiText = new By.ByXPath(multiPath);
        String basePath = ".//span[contains(text(),'good base')]/../*/*[@class ='icons-benefit icon-base']";
        By baseText = new By.ByXPath(basePath);
        SoftAssertions softImagesText = new SoftAssertions();
        softImagesText.assertThat(driver.findElements(practiseText).size() != 0).isTrue();
        softImagesText.assertThat(driver.findElements(customText).size() != 0).isTrue();
        softImagesText.assertThat(driver.findElements(multiText).size() != 0).isTrue();
        softImagesText.assertThat(driver.findElements(baseText).size() != 0).isTrue();
        softImagesText.assertAll();

    }

    //Assert the frame and frame button
    @Test
    public void assertIframe() {

        driver.switchTo().frame("frame");
        SoftAssertions softFrameButton = new SoftAssertions();
        softFrameButton.assertThat(driver.findElements(By.id("frame-button")).size() != 0).isTrue();
        softFrameButton.assertAll();
        driver.switchTo().defaultContent();
    }

    //Assert the left side menu
    @Test
    public void assertSideMenu() {

        List<String> expectedMenu = new ArrayList<>();
        expectedMenu.add("Home");
        expectedMenu.add("Contact form");
        expectedMenu.add("Service");
        expectedMenu.add("Metals & Colors");
        expectedMenu.add("Elements packs");
        List<String> actualMenu = new ArrayList<>();

        By sideMenu = new By.ByXPath("//*[@id='mCSB_1_container']/ul/li");
        List<WebElement> sideMenuItems = driver.findElements(sideMenu);
        System.out.println(sideMenuItems.size());

        for (WebElement i : sideMenuItems) {
            actualMenu.add(i.getText());
        }
        SoftAssertions softLeftMenu = new SoftAssertions();
        softLeftMenu.assertThat(actualMenu.size()).isEqualTo(5);
        softLeftMenu.assertThat(actualMenu).isEqualTo(expectedMenu);


    }


}
