package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoQaPage {

    public DemoQaPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "tabButton")
    public WebElement newTabButton;

    @FindBy(id = "windowButton")
    public WebElement newWindowButton;
    @FindBy(id = "sampleHeading")
    public WebElement newTabContent;

}
