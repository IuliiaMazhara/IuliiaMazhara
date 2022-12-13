package com.epam.tc.hw2.scripts.ex1;

import com.epam.tc.hw2.InitializeKillWebSite;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class TestEx1 extends InitializeKillWebSite {

    //2. Assert Browser title
    @Test
    public void assertTitle() {
        SoftAssertions softTitle = new SoftAssertions();
        softTitle.assertThat(driver.getTitle()).isEqualTo("Home Page");
        softTitle.assertAll();
    }

    //3. Perform login
    //4 .Assert Username is logged

    @Test
    public void assertLogin() {
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("Roman");
        driver.findElement(By.id("password")).sendKeys("Jdi1234");
        driver.findElement(By.cssSelector(("i[class='fa fa-sign-in']"))).click();
        By userName = By.id("user-name");
        WebElement userNameElement = driver.findElement(userName);
        new WebDriverWait(driver, Duration.ofSeconds(3)).until(ExpectedConditions.visibilityOf(userNameElement));
        SoftAssertions softLogin = new SoftAssertions();
        softLogin.assertThat(userNameElement.getText()).isEqualTo("ROMAN IOVLEV");
        softLogin.assertAll();
    }

    //5. Assert that there are 4 items on the header section are displayed, and they have proper texts
    @Test
    public void assertHeader() {
        List<WebElement> header = driver.findElements(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']/li"));
        int headerMenuItemsSize = header.size();
        SoftAssertions softHeader = new SoftAssertions();
        softHeader.assertThat(headerMenuItemsSize).isEqualTo(4);
        softHeader.assertThat(driver.findElements(By.partialLinkText("HOME")).size() != 0).isTrue();
        softHeader.assertThat(driver.findElements(By.partialLinkText("CONTACT FORM")).size() != 0).isTrue();
        softHeader.assertThat(driver.findElements(By.partialLinkText("SERVICE")).size() != 0).isTrue();
        softHeader.assertThat(driver.findElements(By.partialLinkText("METALS & COLORS")).size() != 0).isTrue();
        softHeader.assertAll();
    }


    //6. Assert that there are 4 images on the Index Page, and they are displayed
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

    //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
    @Test
    public void assertTextUnderImage() {
        String practicesPath = ".//*[@class='icons-benefit icon-practise']/..//../span[@class = 'benefit-txt']";
        String customPath = ".//*[@class='icons-benefit icon-custom']/..//../span[@class = 'benefit-txt']";
        String multiPath = ".//*[@class='icons-benefit icon-multi']/..//../span[@class = 'benefit-txt']";
        String basePath = ".//*[@class='icons-benefit icon-base']/..//../span[@class = 'benefit-txt']";
        By practiseText = new By.ByXPath(practicesPath);
        By customText = new By.ByXPath(customPath);
        By multiText = new By.ByXPath(multiPath);
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

    //8. Assert that there is the iframe with Frame Button exist
    //9. Switch to the iframe and check that there is Frame Button in the iframe
    //10. Switch to original window back
    @Test
    public void assertIframe() {
        driver.switchTo().frame("frame");
        SoftAssertions softFrameButton = new SoftAssertions();
        softFrameButton.assertThat(driver.findElements(By.id("frame-button")).size() != 0).isTrue();
        softFrameButton.assertAll();
        driver.switchTo().defaultContent();
    }

    //11. Assert that there are 5 items in theLeft Section are displayed, and they have proper text
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
        for (WebElement i : sideMenuItems) {
            actualMenu.add(i.getText());
        }
        SoftAssertions softLeftMenu = new SoftAssertions();
        softLeftMenu.assertThat(actualMenu.size()).isEqualTo(5);
        softLeftMenu.assertThat(actualMenu).isEqualTo(expectedMenu);
    }

}
