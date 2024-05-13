package step_definitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;
import pages.LoginPage;
import utilities.DriverFactory;

import java.util.List;
import java.util.Map;

public class homePageSteps {
    //private WebDriver driver = DriverFactory.getDriver("chrome"); not needed after singleton Class Driver
    private HomePage homePage = new HomePage();
    @Then("user can see following tabs:")
        public void user_can_see_following_tabs(List<String> expectedTabs) {

            // first we need to make sure that there is a specific number of tabs
            List<WebElement> actualTabs = homePage.tabs;
            Assert.assertEquals(
                    "Tabs verification failed due to the length of lists.",
                    expectedTabs.size(),
                    actualTabs.size()
            );

            // make sure that each tab has a specific name
            for(int i = 0; i < expectedTabs.size(); i++){
                String expectedTab = expectedTabs.get(i);
                String actualTab = actualTabs.get(i).getText();
                Assert.assertEquals(
                        "Tab name verification failed.",
                        expectedTab,
                        actualTab
                );

    }
}}
