package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {


        public LoginPage(){
            PageFactory.initElements(Driver.getDriver(), this);
        }

    @FindBy(id = "txtUsername")
    public WebElement usernameInputBox;

    @FindBy(id = "txtPassword")
    public WebElement passwordInputBox;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;

    }
