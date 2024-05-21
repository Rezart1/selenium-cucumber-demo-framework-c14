package practice;

import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPractice {
    @Test
    public void testBrowserAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        WebElement clickJsAlertButton = driver.findElement(By.xpath("//*[text() = 'Click for JS Alert']"));
        clickJsAlertButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        // How do we deal with alerts?
        // First we need to create an object of Alert type
        Alert alert = driver.switchTo().alert();
        System.out.println("alert description: "+alert.getText());
        Thread.sleep(2000);
        // Each alert can be different, simple alert, confirm, prompt
        // simple alerts have only OK button and description
        // confirm have Ok and Cancel buttons and description
        // prompt alert can have Ok, Cancel and an input box along with description
        // alert object has few methods:
        // accept() to click OK
        // dismiss() to click Cancel
        // getText() to get the description
        // sendKeys() to make an input
        alert.accept();
        Thread.sleep(2000);
        WebElement messageResult = driver.findElement(By.id("result"));
        System.out.println("messageResult: "+messageResult.getText());
        driver.quit();
        Thread.sleep(2000);
    }

}
