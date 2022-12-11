package com.epam.tc.hw2.scripts.ex1;

import com.epam.tc.hw2.InitializeKillWebSite;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class TestEx1 extends InitializeKillWebSite {

    //Assert the title of the page
    @Test
    public void assertTitle() {

        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(driver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();


    }

    //Assert the login of the user
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

    //Assert the header menu
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


    //Assert the images are on the page
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

    //Assert the text is under image and the text is correct
    @Test
    public void assertTextUnderImage() {


        String practicesPath = ".//*[@class='icons-benefit icon-practise']/..//../span[@class = 'benefit-txt']";
        By practiseText = new By.ByXPath(practicesPath);
        String customPath = ".//*[@class='icons-benefit icon-custom']/..//../span[@class = 'benefit-txt']";
        By customText = new By.ByXPath(customPath);
        String multiPath = ".//*[@class='icons-benefit icon-multi']/..//../span[@class = 'benefit-txt']";
        By multiText = new By.ByXPath(multiPath);
        String basePath = ".//*[@class='icons-benefit icon-base']/..//../span[@class = 'benefit-txt']";
        By baseText = new By.ByXPath(basePath);
        SoftAssertions softImagesText = new SoftAssertions();
        softImagesText.assertThat(driver.findElement(practiseText).getText()).isEqualTo("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        softImagesText.assertThat(driver.findElement(customText).getText()).isEqualTo("To be flexible and\n"
                + "customizable");
        softImagesText.assertThat(driver.findElement(multiText).getText()).isEqualTo("To be multiplatform");
        softImagesText.assertThat(driver.findElement(baseText).getText()).isEqualTo("Already have good base\n"
                + "(about 20 internal and\n"
                + "some external projects),\n"
                + "wish to get more…");
        softImagesText.assertAll();

    }

    //Assert the frame exist and frame button is within the frame
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
