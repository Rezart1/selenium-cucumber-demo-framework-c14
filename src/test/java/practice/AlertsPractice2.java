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

public class AlertsPractice2 {


    /*
    * Scenario: Verify user can accept a confirm alert
        Given user lands on https://the-internet.herokuapp.com/javascript_alerts
        When user clicks on Click for JS Confirm
        And an alert appears
        Then user can see the alert message is "I am a JS Confirm"
        And user is able to decline the alert
        And user can see a message "You clicked: Cancel"
        * */
    @Test
    public void testBrowserConfirmAlert() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(2000);
        WebElement jsConfirmButton = driver.findElement(By.xpath("//*[text() = 'Click for JS Confirm']"));
        jsConfirmButton.click();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();
        Thread.sleep(2000);
        WebElement messageResult = driver.findElement(By.id("result"));
        System.out.println(messageResult.getText());
        jsConfirmButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Thread.sleep(2000);
        alert.accept();
        Thread.sleep(2000);
        messageResult = driver.findElement(By.id("result"));
        System.out.println(messageResult.getText());
        Thread.sleep(2000);
        driver.quit();
    }
}
