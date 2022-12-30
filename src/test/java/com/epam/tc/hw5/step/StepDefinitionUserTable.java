package com.epam.tc.hw5.step;


import static org.assertj.core.api.Assertions.assertThat;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.ArrayList;
import java.util.List;


public class StepDefinitionUserTable extends InitializePageObject {

    @Then("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void number_type_dropdowns_should_be_displayed_on_users_table_on_user_table_page(Integer numOfDropDowns) {
        assertThat(pageObjectUserTable.getNumberTypeDropdowns().size()).isEqualTo(numOfDropDowns);
    }

    @Then("{int} Usernames should be displayed on Users Table on User Table Page")
    public void usernames_should_be_displayed_on_users_table_on_user_table_page(Integer numUsers) {
        assertThat(pageObjectUserTable.getUsers().size()).isEqualTo(numUsers);
    }

    @Then("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void images_should_be_displayed_on_users_table_on_user_table_page(Integer numOfImages) {
        assertThat(pageObjectUserTable.getImages().size()).isEqualTo(numOfImages);
    }

    @Then("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void checkboxes_should_be_displayed_on_users_table_on_user_table_page(Integer numOfChecks) {
        assertThat(pageObjectUserTable.getCheckboxes().size()).isEqualTo(numOfChecks);
    }

    @Then("droplist should contain values in column Type for user Roman")
    public void droplist_should_contain_values(io.cucumber.datatable.DataTable dataTable) {
        List<String> dropdownOptions = dataTable.asList();
        for (int i = 1; i < dropdownOptions.size(); i++) {
            pageObjectUserTable.valueDropdown(dropdownOptions.get(i));
        }
    }

    @When("I select vip checkbox for {string}")
    public void select_checkbox_for(String checkBoxValue) {
        if (checkBoxValue.toLowerCase().contains("ivan")) {
            pageObjectUserTable.clickVipCheckBox("ivan");
        }
    }

    @Then("{int} log row has {string} text in log section")
    public void log_row_has_text_in_log_section(Integer numOfLogs, String logText) {
        pageObjectUserTable.assertNumberOfLogItems(numOfLogs);
        pageObjectUserTable.assertLogText(logText);
    }

    @Then("User table should contain following values:")
    public void user_table_should_contain_following_values(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> userTable = dataTable.cells().subList(1, 7);
        List<String> numbers = new ArrayList<>();
        List<String> names = new ArrayList<>();
        List<String> desc = new ArrayList<>();
        userTable.forEach(els -> {
            numbers.add(els.get(0));
            names.add(els.get(1));
            desc.add(els.get(2));
        });
        assertThat(pageObjectUserTable.getNumberInTableValues()).isEqualTo(numbers);
        assertThat(pageObjectUserTable.getUserInTableValues()).isEqualTo(names);
        assertThat(pageObjectUserTable.getDescInTableValues()).isEqualTo(desc);
    }
}
