package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CareerPage {

    private WebDriver driver;

    public CareerPage(WebDriver driver) {

        this.driver = driver;
    }

    By remoteCheckBox = new By.ByXPath(".//*[@class= 'job-search__filter-items job-search__filter-items--remote']");

    By locationDropDown = new By.ByXPath(".//*[@class='select2-selection__rendered']");

    By allLocations = new By.ByXPath(".//li[@title='All Locations']");


//    By dropDownItems = new By.ByXPath("//span[@class=\"select2-results\"]//li");
 //   List<WebElement> dropDownItemsList = driver.findElements(dropDownItems);






    By viewMoreLink = new By.ByXPath(".//*[@class='search-result__view-more']");

    By keyInput = new By.ByXPath(".//*[@placeholder = 'Keyword']");

    By findButton = new By.ByXPath(".//*[@class= 'recruiting-search__submit button-ui ']");

    By viewApplyButton = new By.ByXPath(".//*[@class= 'search-result__item-apply']//ul[last()");




    public void tickRemoteOption(){

        driver.findElement(remoteCheckBox).click();

    }

    public void chooseJavaLanguage(){

        driver.findElement(keyInput).sendKeys("java");

    }

    public void clickFindButton(){

        driver.findElement(findButton).click();

    }

    public void chooseAllLocations(){

        driver.findElement(locationDropDown).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", allLocations);
        js.executeScript("arguments[0].click();", allLocations);

        //Choose dropdown element with select option
        //Select selectAllLocationItemOfDropDown = new Select(driver.findElement(allLocations)));
        //selectAllLocationItemOfDropDown.deselectByValue("all_locations");

        //Choose considering scroll
        //By allLocationItemOfDropDown = new By.ByXPath(".//*[@title='All Locations']");
        //JavascriptExecutor js = (JavascriptExecutor) driver;
        //js.executeScript("arguments[0].scrollIntoView();", allLocations);




        //Choose be clicking on Xpath
      //  driver.findElement(allLocations).click();


    }

    public void openLastViewMore() {

       while (driver.findElement(viewMoreLink).isDisplayed()) {

           driver.findElement(viewMoreLink).click();

       }

    }

    public void clickViewApplyButton(){

        driver.findElement(findButton).click();

    }

}


