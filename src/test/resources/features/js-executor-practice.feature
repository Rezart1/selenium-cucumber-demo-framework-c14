Feature: JS Executor practice

@js_click
Scenario: Click on OHR PIM tab with JS Executor
Given user navigates to orangeHrm login page
And user logs in with valid username and password
And user clicks login button
When user clicks on PIM tab with js executor
Then url ends with "/viewEmployeeList"

@js_scroll
Scenario: Scroll to a specific element
Given user navigates to orangeHrm login page
And user logs in with valid username and password
And user clicks login button
When user clicks on PIM tab with js executor
Then user scrolls to the last employee on table

