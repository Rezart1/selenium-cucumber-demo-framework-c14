package practice;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
* Scenario: Verify user can see a modal pop up once landed on the page
Given user lands on Entry Ad Page
When a pop - up appears
Then user is able to see "THIS IS A MODAL WINDOW"
And user can close the pop up
* */

public class PopUpsPractice {

      /*
    Scenario: Verify user can see a modal pop up once landed on the page
    Given user lands on Entry Ad Page
    When a pop - up appears
    Then user is able to see "THIS IS A MODAL WINDOW"
    And user can close the pop up
    */


    @Test
    public void testModalPopUp() throws InterruptedException {

        String expectedTitle = "THIS IS A MODAL WINDOW";

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/entry_ad");

        WebElement modalTitle = driver.findElement(By.cssSelector("div.modal-title>h3"));

        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(modalTitle));

        String actualTitle = modalTitle.getText();

        System.out.println("Actual title: " + actualTitle);
        System.out.println("Expected title: " + expectedTitle);
        Assert.assertTrue("Modal title verification failed!", actualTitle.equalsIgnoreCase(expectedTitle));

        WebElement closeButton = driver.findElement(By.cssSelector("div.modal-footer>p"));
        closeButton.click();

        // Option 1
        // assert that title is not displayed.
        // boolean modalTitleIsDisplayed = modalTitle.isDisplayed();
        // Assert.assertFalse("Modal is still displayed.", modalTitleIsDisplayed);

        // Option 2
        Wait<WebDriver> anotherWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        boolean isInvisible = anotherWait.until(ExpectedConditions.invisibilityOf(modalTitle));
        Assert.assertTrue(isInvisible);


        driver.quit();

    }

}
