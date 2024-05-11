package step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.BestBuySearchPage;
import utilities.DriverFactory;

public class BestBuySteps {

    private WebDriver driver = DriverFactory.getDriver("chrome");
    private BestBuySearchPage bestBuySearchPage = new BestBuySearchPage(driver);

    @Given("user navigates to best buy")
    public void user_navigates_to_best_buy() {
        driver.navigate().to("https://www.bestbuy.com/");
    }

    @When("user enters {string} in search box")
    public void user_enters_in_search_box(String productName) {
        bestBuySearchPage.searchInputBox.sendKeys(productName);
        bestBuySearchPage.searchButton.click();
    }

}
