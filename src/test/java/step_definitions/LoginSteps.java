package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverFactory;

public class LoginSteps {
    private static final Logger log = LoggerFactory.getLogger(LoginSteps.class);
    private WebDriver driver = DriverFactory.getDriver("chrome");
    private LoginPage loginPage = new LoginPage(driver);
    private HomePage homePage = new HomePage(driver);

    @Given("user navigates to orangeHrm login page")
    public void user_navigates_to_orange_hrm_login_page() {
        driver.get("http://dev-hrm.yoll.io/");
    }

    @When("user logs in with valid username and password")
    public void user_logs_in_with_valid_username_and_password() {
        loginPage.usernameInputBox.sendKeys("yoll-student");
        loginPage.passwordInputBox.sendKeys("Bootcamp5#");
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user is redirected to the homepage")
    public void user_is_redirected_to_the_homepage() {
        String actualWelcomeMessage = homePage.welcomeElement.getText();
        String expectedWelcomeMessage = "Welcome Yoll";
        Assert.assertEquals("User redirect failed!", expectedWelcomeMessage, actualWelcomeMessage);
    }

    @Then("quit the driver")
    public void quit_the_driver() {
        driver.quit();
    }


    @When("user logs in with username {string} and password {string}")
    public void user_logs_in_with_username_and_password(String username, String password) {
        loginPage.usernameInputBox.sendKeys(username);
        loginPage.passwordInputBox.sendKeys(password);
    }

    @Given("this is a string {string}")
    public void this_is_a_string(String string) {
        System.out.println("This is the string parameter from feature file: " + string);
    }
    @Given("this is a double {double}")
    public void this_is_a_double(Double double1) {
        System.out.println("This is the double parameter from feature file: " + double1);
    }
    @Given("this is a integer {int}")
    public void this_is_a_integer(Integer int1) {
        System.out.println("This is the integer parameter from feature file: " + int1);
    }

    @Then("user can see an error message {string}")
    public void user_can_see_an_error_message(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.errorMessage.getText();
        Assert.assertEquals("Error message verification failed!", expectedErrorMessage, actualErrorMessage);
    }
}
