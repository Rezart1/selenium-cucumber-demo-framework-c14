package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class HomePage {

// we can initialize the driver in different ways;
    //First way
    public HomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
 //second way
//    private WebDriver driver;
//
//    public HomePage(WebDriver driver){
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }

    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(xpath = "//div[@class='menu']//b")
    public List<WebElement> tabs;

    @FindBy(id  = "menu_pim_viewPimModule")
    public WebElement pimTab;
    @FindBy(id = "menu_admin_viewAdminModule")
        public WebElement adminTab;

    public void clickOnTabByName(String tabName){
        for(WebElement tab: tabs){
            if(tabName.equalsIgnoreCase(tab.getText())){
                tab.click();
                break;
            }
        }
    }

}
