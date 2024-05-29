package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DemoQaPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.WaitsUtils;

import java.util.Set;

public class DemoQaSteps {
    private DemoQaPage demoQaPage = new DemoQaPage();
    private String mainWindowHandle = null;

    @Given("I land on Demo QA Browser Windows Page")
    public void i_land_on_demo_qa_browser_windows_page() {
        Driver.getDriver().get(ConfigReader.getProperty("demo_qa_windows_url"));
    }

    @Then("I can retrieve the unique identifier of the main window")
    public void i_can_retrieve_the_unique_identifier_of_the_main_window() {
        // Retrieve the current/main window handle (id)
        mainWindowHandle = Driver.getDriver().getWindowHandle();
        System.out.println("Main window ID: " + mainWindowHandle);
    }

    // New Tab || New Window
    @When("I click on {string} button")
    public void i_click_on_new_tab_button(String buttonName) throws InterruptedException {
        switch (buttonName.toUpperCase()){
            case "NEW TAB":
                WaitsUtils.waitForElementToBeClickable(demoQaPage.newTabButton, 10);
                demoQaPage.newTabButton.click();
                break;
            case "NEW WINDOW":
                WaitsUtils.waitForVisibilityOfElement(demoQaPage.newWindowButton, 10);
                demoQaPage.newWindowButton.click();
                break;
            default:
                Assert.fail("There is no such button on page! -> " + buttonName);
        }
    }

    @Then("a new window is created")
    public void a_new_window_is_created() throws InterruptedException {
        // to verify that we are on a new tab or window we will need to get one of these following things:
        // - url, title, element/content from new page itself
        // for this case we will use

        // In order to get those properties (url, title, content) we will need to switch the focus(control) of the current driver to the new tab/window
        // Steps to switch to a new window/tab
        // 1. Retrieve all window handles of all tabs and winds created in this session
        // 2. Switch to the new tab/window by using their ID
        // 3. Interact with that new tab/window

        // Retrieve all window handles of all tabs and winds created in this session
        //  getWindowHandles() - returns a set of unique ids
        Set<String> allWindowsIds = Driver.getDriver().getWindowHandles();
        System.out.println("All window IDs: " + allWindowsIds);
        System.out.println("URL before switching: " + Driver.getDriver().getCurrentUrl());

        // Make sure that once we click on new tab button we have only 2 elements in the set
        // one will the main tab and another is the one created (no more or less)
        int expectedWindowsCount = 2;
        int actualWindowsCount = allWindowsIds.size();
        Assert.assertEquals("Count of windows failed!", expectedWindowsCount, actualWindowsCount);

        // Option 2
        //WaitsUtils.waitForNumberOfWindows(2, 10);

        // can we use index in sets?
        for(String currentWindowId : allWindowsIds){
            // since sets are not ordered, we need to make sure that we don't choose same id we are currently on
            if(!mainWindowHandle.equals(currentWindowId)){
                Driver.getDriver().switchTo().window(currentWindowId);
                break;
            }
        }

        System.out.println("URL after switching: " + Driver.getDriver().getCurrentUrl());
    }

    @Then("I can see the content of new tab is {string}")
    public void i_can_see_the_content_of_new_tab_is(String expectedContent) {
        String actualContent = demoQaPage.newTabContent.getText();
        Assert.assertEquals("Content verification failed!" ,expectedContent, actualContent);
    }


    @When("I close the new tab or window")
    public void i_close_the_new_tab_or_window() throws InterruptedException {
        // quit() vs close()
        // quit() - will terminate all windows and tabs at once of current driver session
        // close() - will terminate only the current tab or window without affecting other on this driver session
        Driver.getDriver().close();
    }

    @Then("I switch to main window")
    public void i_switch_to_main_window() {
        Driver.getDriver().switchTo().window(mainWindowHandle);
    }

    @Then("I can see the url of the window is endpoint with {string}")
    public void i_can_see_the_url_of_the_window_is_endpoint_with(String endpoint) throws InterruptedException {
        String currentUrlValue = Driver.getDriver().getCurrentUrl();
        System.out.println("URL after we switched back to main window: " + currentUrlValue);
        System.out.println("The title of the page is: " + Driver.getDriver().getTitle());
        Assert.assertTrue("Url verification failed!" ,currentUrlValue.endsWith(endpoint));
    }


}

