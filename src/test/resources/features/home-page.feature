Feature: Homework Feature

Scenario: User can see all tabs on home page
Given user navigates to hrm login page
When user logs in with username "yoll-student" and password "Bootcamp5#"
Then user is redirected to home page
And user can see following tabs:
| Admin       |
| PIM         |
| Leave       |
| Time        |
| Recruitment |
| My Info     |
| Performance |
| Dashboard   |
| Directory   |
| Maintenance |

  Scenario: User can see all tabs on home page
    Given user navigates to hrm login page
    When user logs in with username "yoll-student" and password "Bootcamp5#"
    Then user is redirected to home page
    When user clicks on PIM tab
    And user click on Add Employee sub tab
    Then user can creat a new employee
      | firstName  | Omar |
      | lastName   | Ramo |
      | middleName | John |