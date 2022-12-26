package com.epam.tc.hm5;

import com.epam.tc.hw3.pages.PageObjectLoginPage;
import com.epam.tc.hw4.utils.ActionStep;
import com.epam.tc.hw4.utils.AssertStep;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.io.IOException;

public class StepDefinitionsHomePage {

    ActionStep actionStep = new ActionStep();

    AssertStep assertStep = new AssertStep();
    @Given("I open JDI GitHub site")
    public void open_website() {
        try {
            actionStep.loggIn();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("Website is opened")
    public void verify_website_is_opened() {
        assertStep.assertTitle("Home Page");

    }


//    @Given("I login as user {string}")
//    public void i_login_as_user(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I click on {string} button in Header")
//    public void i_click_on_button_in_header(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("I click on {string} button in Service dropdown")
//    public void i_click_on_button_in_service_dropdown(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("{string} page should be opened")
//    public void page_should_be_opened(String string) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
//    public void number_type_dropdowns_should_be_displayed_on_users_table_on_user_table_page(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
//    public void usernames_should_be_displayed_on_users_table_on_user_table_page(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
//    public void description_texts_under_images_should_be_displayed_on_users_table_on_user_table_page(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
//    public void checkboxes_should_be_displayed_on_users_table_on_user_table_page(Integer int1) {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("User table should contain following values:")
//    public void user_table_should_contain_following_values(io.cucumber.datatable.DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
//    }
//    @Then("droplist should contain values in column Type for user Roman")
//    public void droplist_should_contain_values_in_column_type_for_user_roman(io.cucumber.datatable.DataTable dataTable) {
//        // Write code here that turns the phrase above into concrete actions
//        // For automatic transformation, change DataTable to one of
//        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
//        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
//        // Double, Byte, Short, Long, BigInteger or BigDecimal.
//        //
//        // For other transformations you can register a DataTableType.
//        throw new io.cucumber.java.PendingException();
//    }
}
