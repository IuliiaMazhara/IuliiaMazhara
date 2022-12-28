Feature: Verify elements on Home Page

  Background:
    When User open the home page of the website
    Then The title of the page should be "Home Page"
    When User login with the username "Roman" and password "Jdi1234"
    Then User "ROMAN IOVLEV" should be displayed
    And I click on "User Table" button in Service dropdown
    Then The title of the page should be "User Table"

  Scenario: Vip user checkbox validation
    When I select vip checkbox for "Sergey Ivan"
    Then 1 log row has "Vip: condition changed to true" text in log section
