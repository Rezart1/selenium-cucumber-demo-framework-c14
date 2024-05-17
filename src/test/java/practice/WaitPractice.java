package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WaitPractice {
    /*
     * Thread.sleep() is not a good option to use for selenium synchronization
     * The reason is because we are stopping forcibly the execution regardless of any factors
     * If we set a wait time of 5 seconds and the wait for a page is higher it fail
     * On the other hand if the page/element if interactable in milliseconds it will still wait 5 seconds
     * This will lead to unstable test cases that might or might not fail along the way
     * */
    @Test
    public void useOfThreadSleeps() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        // Page
        WebElement usernameInputBox = driver.findElement(By.id("user-name"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        // Actions
        usernameInputBox.sendKeys("performance_glitch_user");
        passwordInputBox.sendKeys("secret_sauce");
        loginButton.click();
        // To wait until the page gets loaded we will need to wait
        Thread.sleep(10000); // dead wait, hard wait
        // We navigated to home page and we need to click on the backpack item title
        WebElement backpackTitle = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Backpack']"));
        backpackTitle.click();
        Thread.sleep(1000);
        WebElement backToProducts = driver.findElement(By.id("back-to-products"));
        backToProducts.click();
        // To wait until the page gets loaded we will need to wait
        Thread.sleep(10000);
        WebElement bikeLightTitle = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Bike Light']"));
        bikeLightTitle.click();

        driver.quit();
    }

    /*
     * One of the first solutions that are better that thread.sleep() will be implicit wait
     * To apply implicit wait we will use the driver object and manage interface
     * */
    @Test
    public void refactorWithImplicitWait() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        // implicit wait
        // when we set the duration of implicit wait it means that this wait will be applied to each and every element located with this driver
        // the 20 seconds limit is not forced all the time, it is just a max
        // if any element gets located in milliseconds it will just proceed to next one
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Page
        WebElement usernameInputBox = driver.findElement(By.id("user-name"));
        WebElement passwordInputBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));
        // Actions
        usernameInputBox.sendKeys("performance_glitch_user");
        passwordInputBox.sendKeys("secret_sauce");
        loginButton.click();
        WebElement backpackTitle = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Backpack']"));
        backpackTitle.click();
        WebElement backToProducts = driver.findElement(By.id("back-to-products"));
        backToProducts.click();
        WebElement bikeLightTitle = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Bike Light']"));
        bikeLightTitle.click();
        driver.quit();
    }


}