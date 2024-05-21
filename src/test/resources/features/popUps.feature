Feature: Pop Up Practice

  @modal
  Scenario: User can see a modal pop up once landed on the page
    Given user lands on Entry Ad Page
    When a pop - up appears
    Then user is able to see “THIS IS A MODAL WINDOW”
    And user can close the pop up