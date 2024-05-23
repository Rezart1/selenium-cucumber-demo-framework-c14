package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import pages.iFramesPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.WaitsUtils;

public class IFramePageSteps {
    private pages.iFramesPage iFramesPage = new iFramesPage();

    @Given("user lands on expandtesting page")
    public void user_lands_on_expandtesting_page() {
        Driver.getDriver().get(ConfigReader.getProperty("iframes_url"));
    }

    @When("user clicks on video play button")
    public void user_clicks_on_video_play_button() {
        Driver.getDriver().switchTo().frame("iframe-youtube");
        WaitsUtils.waitForElementToBeClickable(iFramesPage.playButton, 1);
        iFramesPage.playButton.click();
    }

    @Then("user can see {string}")
    public void user_can_see(String expectedMessage) {
        if (expectedMessage.contains("content")) {
            Driver.getDriver().switchTo().parentFrame();
            Driver.getDriver().switchTo().frame("mce_0_ifr");
            String contentMessage = iFramesPage.editorContent.getText();
            Assert.assertEquals("Content message verification failed!", expectedMessage, contentMessage);
        } else {
            WaitsUtils.waitForVisibilityOfElement(iFramesPage.successMessage, 1);
            String successMessage = iFramesPage.successMessage.getText();
            Assert.assertEquals("Success message verification failed!", expectedMessage, successMessage);
        }
    }

    @When("user enters the email")
    public void user_enters_the_email() {
        Driver.getDriver().switchTo().defaultContent();
        Driver.getDriver().switchTo().frame("email-subscribe");
        WaitsUtils.waitForVisibilityOfElement(iFramesPage.emailInputBox, 1);
        iFramesPage.emailInputBox.sendKeys(iFramesPage.getRandomEmail());
        iFramesPage.emailInputBox.sendKeys(Keys.PAGE_DOWN);
    }

    @When("clicks Subscribe button")
    public void clicks_subscribe_button() {
        WaitsUtils.waitForElementToBeClickable(iFramesPage.subscribeButton, 1);
        iFramesPage.subscribeButton.click();
    }

}
