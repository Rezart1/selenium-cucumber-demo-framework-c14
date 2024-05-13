@IBM-5546 @regression
Feature: Login Functionality
#  This is the description for functionality that we will test
#
#  Background: Preliminary steps
#    Given user navigates to orangeHrm login page
#
  @validLogin @smoke
  Scenario: User can login with valid credentials
    When user logs in with username "yoll-student" and password "Bootcamp5#"
    And user clicks login button
    Then user is redirected to the homepage
    * quit the driver
#
#  @invalidLogin @smoke
#  Scenario: User cannot login with invalid credentials
#    When user logs in with username "invalid" and password "invalid"
#    And user clicks login button
#    Then user can see an error message "Invalid Credentials"
#    * quit the driver
#
#  Scenario: User cannot login with empty username
#    When user logs in with username "" and password "invalid"
#    And user clicks login button
#    Then user can see an error message "Username cannot be empty"
#    * quit the driver
#
#  Scenario: User cannot login with empty password
#    When user logs in with username "invalid" and password ""
#    And user clicks login button
#    Then user can see an error message "Password cannot be empty"
#    * quit the driver
#
#
  @invalidLogin
  Scenario Outline: User cannot login with invalid credentials <testCase>
    When user logs in with username "<username>" and password "<password>"
    And user clicks login button
    Then user can see an error message "<errorMessage>"
    * quit the driver
    Examples:
      | username | password | errorMessage             | testCase       |
      | invalid  | invalid  | Invalid credentials      | both invalid   |
      |          | invalid  | Username cannot be empty | username empty |
      | invalid  |          | Password cannot be empty | password empty |
      |          |          | Username cannot be empty | both empty     |
