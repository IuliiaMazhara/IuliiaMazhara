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

  Scenario: User Table Page test
#    And I click on "User Table" button in Service dropdown
#    Then "User Table" page should be opened
#    And 6 Number Type Dropdowns should be displayed on Users Table on User Table Page
#    And 6 Usernames should be displayed on Users Table on User Table Page
#    And 6 Description texts under images should be displayed on Users Table on User Table Page
#    And 6 checkboxes should be displayed on Users Table on User Table Page
#    And User table should contain following values:
#      | Number | User             | Description                      |
#      | 1      | Roman            | Wolverine                        |
#      | 2      | Sergey Ivan      | Spider Man                       |
#      | 3      | Vladzimir        | Punisher                         |
#      | 4      | Helen Bennett    | Captain America some description |
#      | 5      | Yoshi Tannamuri  | Cyclope some description         |
#      | 6      | Giovanni Rovelli | Hulksome description             |
#    And droplist should contain values in column Type for user Roman
#      | Dropdown Values |
#      | Admin           |
#      | User            |
#      | Manager         |





