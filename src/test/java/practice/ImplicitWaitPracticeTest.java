package practice;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class ImplicitWaitPracticeTest {

    /*
     * In reality the code is much faster then web application rendering/loading
     * We need to take care in our code about synchronizing it
     * The approach we have used is Thread.sleep()
     * This means we visually would identify where we need to stop execution of our code
     * And apply the wait there
     * However, there is no guarantee it will work all the time
     * Also, if the element can be located faster, code will still be paused for that amount of time
     * This leads to an increased time of execution of the scripts
     * */
    @Test
    public void testCase() throws InterruptedException {
        WebDriver driver = new ChromeDriver(); // 0.1
        driver.get("https://www.saucedemo.com/"); // 1
        WebElement usernameInputBox = driver.findElement(By.id("user-name")); // 1
        WebElement passwordInputBox = driver.findElement(By.id("password")); // 1
        WebElement loginButton = driver.findElement(By.id("login-button")); // 1
        usernameInputBox.sendKeys("performance_glitch_user"); // 1
        passwordInputBox.sendKeys("secret_sauce"); // 1
        loginButton.click(); // 1
        Thread.sleep(5000); // dead wait / hard wait
        WebElement backpackTitle = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Backpack']"));
        backpackTitle.click();
        Thread.sleep(5000); // dead wait / hard wait
        WebElement backToHomePage = driver.findElement(By.id("back-to-products"));
        backToHomePage.click();
        Thread.sleep(5000); //  // dead wait / hard wait
        WebElement bikeLightTitle = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Bike Light']"));
        bikeLightTitle.click();
        Thread.sleep(10000); //  // dead wait / hard wait
        backToHomePage = driver.findElement(By.id("back-to-products"));
        backToHomePage.click();
        driver.quit();
    }

    /*
     * In order to apply a more dynamic wait in selenium first option is: Implicit Wait
     * This wait applies globally - it applies to the whole instance of driver to all findElement() and findElements()
     * The benefit is you can set a time frame for element to locate
     * If the element is located faster - the implicit wait will not pause till the end, it will just proceed
     * If we give a timeout of 10 sec and the element is found in 2, then the execution will continue to the next line after 2 seconds
     *
     * implicit wait internally works as a loop that checks each half second if the element can be located
     *
     * */

    @Test
    public void testImplicitWaits() {
        WebDriver driver = new ChromeDriver(); // 0.1
        // apply implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/"); // 1
        WebElement usernameInputBox = driver.findElement(By.id("user-name")); // 2
        WebElement passwordInputBox = driver.findElement(By.id("password")); // 1
        WebElement loginButton = driver.findElement(By.id("login-button")); // 1
        usernameInputBox.sendKeys("performance_glitch_user"); // 1
        passwordInputBox.sendKeys("secret_sauce"); // 1
        loginButton.click(); // 1
        WebElement backpackTitle = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Backpack']"));
        backpackTitle.click();
        WebElement backToHomePage = driver.findElement(By.id("back-to-products")); // 15
        backToHomePage.click();
        WebElement bikeLightTitle = driver.findElement(By.xpath("//*[text() = 'Sauce Labs Bike Light']"));
        bikeLightTitle.click();
        backToHomePage = driver.findElement(By.id("back-to-products"));
        backToHomePage.click();
        driver.quit();
    }

}
