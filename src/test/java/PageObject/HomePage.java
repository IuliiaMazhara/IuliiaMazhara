package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    By careerLink = new By.ByXPath(".//*[@href = '/careers']");

    public void clickCareerLink(){

        driver.findElement(careerLink).click();

    }

}
