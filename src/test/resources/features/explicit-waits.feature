@heroku_app
Feature: Practice Explicit waits

  Scenario: Utilize explicit wait with a condition visibility
    Given user is on heroku dynamic loading page
    And user click on example one link
    And user clicks the start button
    Then user can see a "Hello World" message