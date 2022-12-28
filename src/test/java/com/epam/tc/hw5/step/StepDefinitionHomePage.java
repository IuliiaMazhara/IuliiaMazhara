package com.epam.tc.hw5.step;

import static org.assertj.core.api.Assertions.assertThat;

import com.epam.tc.hw5.pages.PageObjectLoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class StepDefinitionHomePage extends InitializePageObject {

    @When("User open the home page of the website")
    public void user_open_the_home_page_of_the_website() {
        pageObjectHome.openHomePage();
    }

    @Then("The title of the page should be {string}")
    public void the_title_of_the_page_should_be(String title) {
        assertThat(pageObjectHome.getTitle()).isEqualTo(title);
    }

    @When("User login with the username {string} and password {string}")
    public void user_login_with_the_username_and_password(String name, String password) {
        pageObjectLoginPage
                .clickUserIcon()
                .setUsernameParameter(name)
                .setPasswordParameter(password)
                .clickSignInButton();
    }

    @Then("User {string} should be displayed")
    public void user_should_be_displayed(String user) {
        String nameOfLoggedUser = PageObjectLoginPage.using(webDriver).getNamedOfLoggedUser().getText();
        assertThat(nameOfLoggedUser).isEqualTo(user);
    }

    @When("User open Different Elements Page")
    public void user_open_different_elements_page() {
        pageObjectHome.getHeaderPageElements().clickOnServiceItem();
        pageObjectHome.clickDifferentElementServiceMenuItem();
    }

    @When("User check {string} checkbox")
    public void user_check_checkbox(String element) {
        pageObjectDifferentElements.clickOnElementCheckBox(element);
    }

    @Then("Check box {string} should be selected and logged")
    public void check_box_should_be_selected_logged(String element) {
        pageObjectDifferentElements.assertCheckBoxIsSelected(element);
        pageObjectDifferentElements.assertCheckBoxLogger(element);
    }

    @When("User check {string} radio box")
    public void user_check_radio_box(String metal) {
        pageObjectDifferentElements.clickOnMetalRadioButton(metal);
    }

    @Then("Radio box {string} should be selected and logged")
    public void radio_box_should_be_selected_and_logged(String metal) {
        pageObjectDifferentElements.assertRadioBoxIsSelected(metal);
        pageObjectDifferentElements.assertRadioLogger(metal);
    }

    @When("User select {string} dropdown")
    public void user_select_dropdown(String color) {
        pageObjectDifferentElements.getDropDownComponent().selectDropDown(color);
    }

    @Then("dropdown {string} should be selected and logged")
    public void dropdown_should_be_selected_and_logged(String color) {
        pageObjectDifferentElements.getDropDownComponent().assertDropDown(color);
        pageObjectDifferentElements.getDropDownComponent().assertDropDownLogger(color);
    }

    @When("I click on {string} button in Service dropdown")
    public void click_item__service_dropdown(String item) {
        pageObjectHome.getHeaderPageElements().clickOnServiceItem();
        pageObjectHome.clickServiceMenuItem(item);
    }
}
