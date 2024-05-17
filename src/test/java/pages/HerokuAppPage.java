package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import step_definitions.HerokuAppSteps;
import utilities.Driver;

public class HerokuAppPage {


    public HerokuAppPage(){
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[contains(text(), 'Example 1')]")
    public WebElement exampleOneLink;

    @FindBy(xpath = "//a[starts-with(text(), 'Example 2')]")
    public WebElement exampleTwoLink;

    @FindBy(css = "div#start>button")
    public WebElement startButton;

    @FindBy(css="div#finish>h4")
    public WebElement message;

}
