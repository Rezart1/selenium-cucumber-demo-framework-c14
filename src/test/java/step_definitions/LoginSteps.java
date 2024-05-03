package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverFactory;

public class LoginSteps {
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
    public void quit_the_driver(){
        driver.quit();
 }
    @When("user enter invalid username and password")
    public void user_enter_invalid_username_and_password() {
        loginPage.usernameInputBox.sendKeys("invalid");
        loginPage.passwordInputBox.sendKeys("invalid");
    }
    @Then("user can see an error message")
    public void user_can_see_an_error_message() {
        String actualErrorMessage = loginPage.errorMessage.getText();
        String expectedErrorMessage = "Invalid credentials";
        Assert.assertEquals("Error message verification failed!", expectedErrorMessage, actualErrorMessage);

    }
}
