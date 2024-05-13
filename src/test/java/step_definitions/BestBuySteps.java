package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BestBuySearchPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.DriverFactory;

public class BestBuySteps {
    // not needed anymore after the creation of singleton Driver class
    //private WebDriver driver = DriverFactory.getDriver("chrome");
    private BestBuySearchPage bestBuySearchPage = new BestBuySearchPage();

    @Given("user navigates to bestbuy")
    public void user_navigates_to_bestbuy() {
        //Driver.getDriver().navigate().to("https://www.bestbuy.com/");
        Driver.getDriver().navigate().to(ConfigReader.getProperty("bestbuy_url"));
    }

    @When("user enters {string} in search box")
    public void user_enters_in_search_box(String productName) {
        bestBuySearchPage.searchInputBox.sendKeys(productName);
        bestBuySearchPage.searchButton.click();
    }

}
