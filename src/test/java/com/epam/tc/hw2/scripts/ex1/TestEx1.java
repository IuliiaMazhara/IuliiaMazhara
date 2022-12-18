package com.epam.tc.hw2.scripts.ex1;




import com.epam.tc.hw2.InitializeKillWebSite;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
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
    public void assertLogin() throws IOException {
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
        SoftAssertions softHeaderSize = new SoftAssertions();
        softHeaderSize.assertThat(headerMenuItemsSize).isEqualTo(4);
        softHeaderSize.assertAll();
        WebElement homeElement = driver.findElement(By.partialLinkText("HOME"));
        WebElement contactFormElement = driver.findElement(By.partialLinkText("CONTACT FORM"));
        WebElement serviceElement = driver.findElement(By.partialLinkText("SERVICE"));
        WebElement metalsColorsElement = driver.findElement(By.partialLinkText("METALS & COLORS"));
        SoftAssertions softHeader = new SoftAssertions();
        softHeader.assertThat(homeElement.isDisplayed());
        softHeader.assertThat(contactFormElement.isDisplayed());
        softHeader.assertThat(serviceElement.isDisplayed());
        softHeader.assertThat(metalsColorsElement.isDisplayed());
        softHeader.assertAll();
    }


    //6. Assert that there are 4 images on the Index Page, and they are displayed
    @Test
    public void assertImages() {
        List<WebElement> listOfTheImages = driver.findElements(By.className("benefit-icon"));
        int numberOfImages = listOfTheImages.size();
        SoftAssertions softNumberImages = new SoftAssertions();
        softNumberImages.assertThat(numberOfImages).isEqualTo(4);
        softNumberImages.assertAll();
        WebElement iconPractise = driver.findElement(By.cssSelector(".icon-practise"));
        WebElement iconCustom = driver.findElement(By.cssSelector(".icon-custom"));
        WebElement iconMulti = driver.findElement(By.cssSelector(".icon-multi"));
        WebElement iconBase = driver.findElement(By.cssSelector(".icon-base"));
        SoftAssertions softImages = new SoftAssertions();
        softImages.assertThat(iconPractise.isDisplayed());
        softImages.assertThat(iconCustom.isDisplayed());
        softImages.assertThat(iconMulti.isDisplayed());
        softImages.assertThat(iconBase.isDisplayed());
        softImages.assertAll();
    }

    //7. Assert that there are 4 texts on the Index Page under icons, and they have proper text
    @Test
    public void assertTextUnderImage() {
        String practicesPath = ".//*[@class='icons-benefit icon-practise']/..//../span[@class = 'benefit-txt']";
        String customPath = ".//*[@class='icons-benefit icon-custom']/..//../span[@class = 'benefit-txt']";
        String multiPath = ".//*[@class='icons-benefit icon-multi']/..//../span[@class = 'benefit-txt']";
        String basePath = ".//*[@class='icons-benefit icon-base']/..//../span[@class = 'benefit-txt']";
        WebElement practiseText = driver.findElement(new By.ByXPath(practicesPath));
        WebElement customText = driver.findElement(new By.ByXPath(customPath));
        WebElement multiText = driver.findElement(new By.ByXPath(multiPath));
        WebElement baseText = driver.findElement(new By.ByXPath(basePath));
        List<WebElement> listOfTheText = driver.findElements(By.className("benefit-txt"));
        SoftAssertions softImagesText = new SoftAssertions();
        softImagesText.assertThat(listOfTheText.size()).isEqualTo(4);
        softImagesText.assertThat(practiseText.getText()).isEqualTo("To include good practices\n"
                + "and ideas from successful\n"
                + "EPAM project");
        softImagesText.assertThat(customText.getText()).isEqualTo("To be flexible and\n"
                + "customizable");
        softImagesText.assertThat(multiText.getText()).isEqualTo("To be multiplatform");
        softImagesText.assertThat(baseText.getText()).isEqualTo("Already have good base\n"
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
        WebElement frameButton = driver.findElement(By.id("frame-button"));
        SoftAssertions softFrameButton = new SoftAssertions();
        softFrameButton.assertThat(frameButton.isDisplayed());
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

    @DataProvider(name = "dataProviderToTestSideMenu")
    public Object[][] dataSetForAddition() {
        return new Object[][]{{"Contact form", "Contact Form"}, {"Metals & Colors", "Metal and Colors"}};
    }


}
