package StepDefinitions;

import PageObject.CareerPage;
import PageObject.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

public class StepDefinitionsCareer {

    WebDriver driver=new ChromeDriver();
    HomePage homePage = new HomePage(driver);
    CareerPage careerPage = new CareerPage(driver);


    @Before
    public void initWebDriver() {
        try {
            WebDriver driver=new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.epam.com/");
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }


    @Given("user is on EPAM Home page")
    public void user_is_on_EPAM_Home_page() {


        driver.manage().window().maximize();
        driver.get("https://www.epam.com/");
        applyForRemoteJobAllLocations();


    }



    @When("user navigates to Career page")
    public void user_navigates_to_Career_page() {
        System.out.println("2nd");

    }


    @Then("Career page is displayed")
    public void career_page_is_displayed() {
        System.out.println("3rd");

    }

    public void applyForRemoteJobAllLocations(){

        homePage.clickCareerLink();
        careerPage.tickRemoteOption();
        careerPage.chooseJavaLanguage();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1000));
        careerPage.clickFindButton();
      //  careerPage.chooseAllLocations();
        careerPage.openLastViewMore();



    }

    @After
    public void releaseWebDriver() {
        try {
            if (driver != null) {
                driver.quit();
            }
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }



}
