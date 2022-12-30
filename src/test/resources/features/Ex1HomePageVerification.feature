Feature: Verify elements on Home Page

  Background:
    When User open the home page of the website
    Then The title of the page should be "Home Page"
    When User login with the username "Roman" and password "Jdi1234"
    Then User "ROMAN IOVLEV" should be displayed
    When User open Different Elements Page

  Scenario: The home page elements are functional
    When User open Different Elements Page
    Then The title of the page should be "Different Elements"
    When User check "Water" checkbox
    Then Check box "Water" should be selected and logged
    When User check "Wind" checkbox
    Then Check box "Wind" should be selected and logged
    When User check "Selen" radio box
    Then Radio box "Selen" should be selected and logged
    When User select "Yellow" dropdown
    Then dropdown "Yellow" should be selected and logged
