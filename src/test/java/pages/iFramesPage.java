package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class iFramesPage {
    public iFramesPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "button[title=Play]")
    public WebElement playButton;

    @FindBy(css = "#tinymce > p")
    public WebElement editorContent;

    @FindBy(id = "email")
    public WebElement emailInputBox;

    @FindBy(id = "btn-subscribe")
    public WebElement subscribeButton;

    @FindBy(id = "success-message")
    public WebElement successMessage;

    public String getRandomEmail(){
        return new Faker().internet().emailAddress();
    }


}
