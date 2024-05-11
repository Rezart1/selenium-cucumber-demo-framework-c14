# Selenium Cucumber Framework Documentation
📝 Selenium-Cucumber-Demo-Framework Documentation
Tool	   Intention	                        Version	    Docs
Java	   Programming Language	J               DK - 20	    JDK20
Maven	   Build Tool and Dependency Management	3.9.5	    Maven 3
Selenium   UI Test Automation	                4.15.0	    Selenium 4
JUnit	   Test Framework	                    4.13.2	    JUnit 4
Cucumber   BDD Framework	                    7.15.0	    Cucumber 7


🛠 Framework Creation
Create a new project with:

Java as programming language 🌐
Maven as build tool 🛠
Git for source version control 🔄
Add necessary dependencies 📦

Selenium, JUnit 4, Cucumber - Java, Cucumber - JUnit
Create folder structure 📁

Pages, Step_definitions, Utilities, Runner, Resources.features
test
├── java
│   ├── pages
│   ├── runner
│   ├── step_definitions
│   └── utilities
└── resources
└── features
Start by creating your first Cucumber file 🥒

feature-name.feature
make sure the file extension is .feature
Add necessary plugins 🔄

Cucumber for Java
Ensure Gherkin is installed
Running your first feature: 🏃

I. Create a StepDefinition class containing Java methods that define each step from the feature file
package step_definitions;
public class LoginSteps(){
// Example of a Step Definition in Java
@Given("user is on the login page")
public void userIsOnLoginPage() {
// code to navigate to login page
}
}
II. Create a TestRunner class connecting feature file steps with Java methods from step definitions
TestRunner uses JUnit 4 annotation @RunWith() to run tests with Cucumber.class type
Customize binding and framework execution with @CucumberOptions():
feature = "path/to/features": provides the path to features of the framework
glue = "step definitions location": connects the step definitions with feature files steps
dryRun = true/false options:
If set to true, it checks if all steps in the feature file are defined but doesn't run test cases
If set to false, it runs the test cases and throws an error if steps aren't defined
monochrome = true : makes the console logs more readable
plugin = {"pretty", "html:target/reports/cucumber-reports.html"}
tags = "@smoke"
@RunWith(Cucumber.class)
@CucumberOptions(
features = "src/test/resources/features",
glue = "step_definitions",
monochrome = true,
dryRun = false,
tags = ("@runValid and @smoke"),
plugin = {"pretty", "html:target/reports/cucumber-reports.html"}
)
public class TestRunner {
// no need to add code here
}
Cucumber Keywords definitions in feature files 🗝️

Feature: Short description of the feature to be tested
Examples:
#Example 1:
Feature: User Login Functionality
#Example 2:
Feature: Reset Password Functionality
Background Will run the steps of background before each Scenario
Examples:
#Example 1:
Background: Preliminary Steps
Given user navigates to hrm login page
Scenario: Brief use case description from a user perspective
Examples:
#Example 1:
Scenario: Login with valid credentials
#Example 2:
Scenario: Login with invalid credentials
Given, When, Then, And, But, * Keywords:
Given - Preconditions or starting points
Examples:
#Example 1:
Given user navigates to login page
#Example 2:
Given admin user lands on the home page
When - Main actions performed
Examples:
#Example 1:
When user enters username and password
#Example 2:
When user clicks on admin tab
Then - Outcome or result of actions, usually at this step you need to perform an assertion
Examples:
#Example 1:
Then user is redirected to the homepage
#Example 2:
Then user can see an error message
And - Connects multiple steps within Given, When, or Then
Used to add more detail or steps without repeating the Given, When, or Then keywords
Examples:
#Example: notice how And keyword connects any steps on Given, When, Then
Scenario: Login with valid credentials
Given user is on the login page
And user has a valid account
When user enters their username
And user enters their password
And user clicks on the login button
Then user is redirected to the dashboard
And user receives a welcome message
But - Describes an exception or a contrasting scenario
Example:
#Example: notice how But keyword provides a logical output when the credentials
# are about to expire you still can login but a message will be shown
Scenario: Login with expiring credentials
Given user is on the login page
And user has a valid account
When user enters their username
And user enters their password
And user clicks on the login button
Then user is redirected to the dashboard
But user can see a warning message to change credentials
* - Asterisks:
    The asterisk * is a more generic step keyword that can be used in place of any of the other keywords ( Given, When, Then, And, But).
    It is often used when the specific type of step (setup, action, or assertion) is either clear from context or not important to the clarity of the scenario.
    The use of * doesn't imply a technical or undefined behavior; it's more about flexibility in writing the scenario.
    # Example using steps with keywords:
        Given I am logged in
        And I have items in my cart
        When I go to the checkout page
        Then I should see the total price
    # Example using steps with asteriks:
        * I am logged in
        * I have items in my cart
        * I go to the checkout page
        * I should see the total price
More information about Gherkin syntax can be found here:
Cucumber - Gherkin Syntax

Framework Definition
In the IT world, the term "framework" is used extensively and refers to a set of pre-written code, tools, and guidelines that aid in software development. To put it in a simpler context:

### Analogy: Furnishing with an IKEA Bookshelf

Imagine you want to furnish your home with a new bookshelf. You have two main options:
DIY Approach: Design and build the bookshelf from scratch. This involves selecting the wood, cutting it to size, sanding, joining, and painting. It requires significant skill, time, and effort.

IKEA Approach: Buy a bookshelf from IKEA, which comes as a flat-pack with all the pieces pre-cut, holes pre-drilled, and includes the necessary tools and instructions for assembly.

Correlation with IT Frameworks
Pre-Made Components:

IKEA: Comes with pre-cut pieces.
IT Framework: Provides pre-written code and components, saving time and effort.
Instructions and Guidelines:

IKEA: Assembly instructions guide the process.
IT Framework: Offers guidelines and conventions for structuring code and building applications.
Customization:

IKEA: Allows some customization (e.g., placement, additional decorations).
IT Framework: While using pre-built components, customization in functionality and design is possible.
Consistency and Quality:

IKEA: Known for consistent quality and design.
IT Framework: Ensures a level of consistency and reliability, incorporating best coding practices.
Community and Support:

IKEA: Online forums and videos for assistance.
IT Framework: Supported by large communities, offering additional tools and resources.
ATDD vs BDD
ATDD (Acceptance Test Driven Development)
Approach: Focuses on defining a user story with acceptance tests (AT), ensuring everyone involved clearly understands the requirements. Developers and Testers then work in parallel to fulfill these criteria.
BDD (Behavior Driven Development)
Approach: BDD extends ATDD by emphasizing user behaviors and expected outcomes. It involves writing acceptance tests in a language that describes the behavior of the software from the end-user's perspective.
Examples
ATDD Approach Example
User Story: "As a user, I want to reset my password so that I can access my account if I forget it."

Acceptance Criteria:

Users can initiate a password reset from the login page.
A reset link is sent to the user’s registered email, expiring after 24 hours.
Users can set a new password using the reset link.
BDD Approach Example
User Story: "As a user, I want to reset my password to access my account if I forget it."

Acceptance Criteria:

    Scenario: Requesting a password reset
        Given I am on the login page
        When I click on "Forgot Password"
        Then I should enter my registered email

    Scenario: Receiving a password reset email
        Given I requested a password reset
        When I submit my email
        Then I should receive a reset email within 5 minutes

    Scenario: Resetting password using the link
        Given I received a reset email
        When I use the link to set a new password
        Then my password should update and I’m redirected to login
Cucumber Parametrization
Parameterization in Cucumber is a technique used to create data-driven tests, which allows you to run the same test with different sets of data. It increases the reusability and flexibility of your tests. Here, in given examples we can see the use of different data types like String, Integer, Boolean, and Double.

The idea is that we can pass data directly from the step to methods in step definitions

String parameters
Feature file:

    Feature: Login functionality

    Scenario: Logging in with different usernames
        Given I am on the login page
        When I enter "my_username" and "password123"
        Then I should be logged in
Step definition:

    @When("I enter {string} and {string}")
    public void i_enter_username_and_password(String username, String password) {
    // Code to enter username and password
    }
Integer parameters
Feature file:

Feature: Product quantity selection

Scenario Outline: Selecting different product quantities
Given I have selected a product
When I choose a quantity of 25
Then the total should be updated accordingly
Step definition:

@When("I choose a quantity of {int}")
public void i_choose_a_quantity_of(int quantity) {
// Code to select the quantity
}
Double parameters
Feature file:

Feature: Payment processing

Scenario Outline: Processing payments of different amounts
Given I am making a payment
When I enter the amount 55.99
Then the payment should be processed
Step definition:

@When("I enter the amount {double}")
public void i_enter_the_amount(double amount) {
// Code to enter the payment amount
}
Scenario Outline
Scenario Outline is the same as Scenario Template
Scenario Outline in Cucumber is a key feature for data-driven testing.
It allows you to run the same test scenario multiple times with different sets of input values.
This is extremely useful in cases where you need to test the same functionality under various conditions.
Syntax:

Scenario Outline: Generic name for scenario
Given some step "<placeholder1>"
When some step "<placeholder2>"
Examples:
|placeholder1   |placeholder2  |
|value1         |value2        |
|anotherValue1  |anotherValue2 |
Here we can see that the steps have a placeholder wrapped in <> angle brackets. Angle brackets makes cucumber look for that placeholder in the Examples table column name Once found it will pick data from that column. Make sure that table column name matches with placeholder in steps. Otherwise, it won't pick the data from there.

The Scenario Outlines are good candidate for:

Scenarios that are similar in steps and only data changes
Where each scenario is a new user web app usage
For example one user can use both username and password as invalid creds
Others can use differen tabs empty etc..
Here each of these represents a new user launch to the app.
We use outlines for:
Login, Forms with error message fields, search bars...
Data Tables - In cucumber we can pass a larger set of data at once for a step in scenario
That sets of data can be in different forms - List, Map, List, List

Examples:

Data Table as a List
@listDataTable
Example: Data table as a List
Given this is a data table as a list
| Omar  |
| John  |
| Merry |
| Jane  |
@Given("this is a data table as a list")
public void this_is_a_data_table_as_a_list(List<String> names) {
// code
}
Data Table as a Map
@mapDataTable
Example: Data Table as a Map
Given this is a data table as a map
| first_name  | Omar |
| middle_name | Mark |
| last_name   | Ramo |
@Given("this is a data table as a map")
public void this_is_a_data_table_as_a_map(Map<String, String> person){
// code  
}
Data Table as a List<List>
@listOfListsDataTable
Example: Data Table as a List of Lists
Given this is a data table as a List of Lists
| 12313 | Omar Mark          | Ramo      |
| 13684 | Jonathan Pete Moss | Abernathy |
| 13724 | test2 nn           | Anotation |
@Given("this is a data table as a List of Lists")
public void this_is_a_data_table_as_a_list_of_lists(List<List<String>> employees){
// code  
}
Data Table as a List<Map<String, String>>
Sometimes we need to pass our table with headers and in such cases use List of Maps where the header will be the key an column values as value to the key.

@listOfMapsDataTable
Example: Data Table as a List of Maps
Given this is a data table as a List of Maps
| id    | first_mid_name     | last_name |
| 12313 | Omar Mark          | Ramo      |
| 13684 | Jonathan Pete Moss | Abernathy |
| 13724 | test2 nn           | Anotation |
@Given("this is a data table as a List of Maps")
public void this_is_a_data_table_as_a_list_of_lists(List<Map<String,String>> employees){
// code  
}