package step_definitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HerokuAppPage;
import utilities.Driver;

import java.time.Duration;

public class HerokuAppSteps {
    private HerokuAppPage herokuAppPage = new HerokuAppPage();


    @Given("user is on heroku dynamic loading page")
    public void user_is_on_heroku_dynamic_loading_page() {
        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_loading");
    }

    @When("user clicks on example one link")
    public void user_clicks_on_example_one_link() {
        // Let's apply to element an explicit wait

        Wait<WebDriver> explicitWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(15));
        explicitWait.until(ExpectedConditions.elementToBeClickable(herokuAppPage.exampleOneLink));

        herokuAppPage.exampleOneLink.click();
    }

    @When("user clicks on start button")
    public void user_clicks_on_start_button() {
        Wait<WebDriver> explicitWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        explicitWait.until(ExpectedConditions.elementToBeClickable(herokuAppPage.startButton));
        herokuAppPage.startButton.click();
    }

//    @Then("user can see a {string} message")
//    public void user_can_see_a_message(String expectedMessage) {
//
//        // In this case the message is actually in dom but hidden
//        // So, implicit wait will actually think that element is located
//        // For such situations we will use explicit waits with a certain condition
//        // In order to apply an explicit wait we will need to create an object
//        Wait<WebDriver> explWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        // once we create the object we go ahead and use until method with a condition
//        // explicit waits are having kind of loop on the back that check for the condition each half sends (500, mils)
//        // TODO - check out the and() method
//        explWait.until(ExpectedConditions.visibilityOf(herokuAppPage.message));// this line will wait up to 10 seconds to locate the element until it is visible
//
//        String actualMessage = herokuAppPage.message.getText();
//        Assert.assertEquals("Message verification failed.", expectedMessage, actualMessage);
//    }

    @Then("user can see a {string} message")
    public void user_can_see_a_message(String expectedMessage) {

        // Another way of applying waits will Fluent Wait, basically it is very close to Explicit wait but more flexible
        Wait<WebDriver> fluentWait = new FluentWait<>(Driver.getDriver())
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(250))
                .ignoring(NoSuchElementException.class)
                .withMessage("The element failed to locate withing 10 seconds with palling time of 250 mills");

        fluentWait.until(ExpectedConditions.visibilityOf(herokuAppPage.message));

        String actualMessage = herokuAppPage.message.getText();
        Assert.assertEquals("Message verification failed.", expectedMessage, actualMessage);Assert.assertEquals("Message verification failed ", expectedMessage, actualMessage);
    }
}
