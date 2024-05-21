package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class PopUpPage {

    public PopUpPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "div.modal-title>h3")
    public WebElement modalTitle;

    @FindBy(css = "div.modal-footer>p")
    public WebElement closeButton;

    @FindBy(id = "modal")
    public WebElement modal;

}
