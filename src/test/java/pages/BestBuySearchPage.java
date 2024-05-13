package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class BestBuySearchPage {

    public BestBuySearchPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "gh-search-input")
    public WebElement searchInputBox;

    @FindBy(css = ".header-search-button")
    public WebElement searchButton;
}

