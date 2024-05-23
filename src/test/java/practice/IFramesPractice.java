package practice;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFramesPractice {
    @Test
    public void interactWithElementsInDifferentIFrames() throws InterruptedException {
        // create an WebDriver object
        WebDriver driver = new ChromeDriver();
        driver.get("https://practice.expandtesting.com/iframe"); // defaultContent()
        Thread.sleep(2000);
        /*
         we need to click on play button
         however, the button and the video is located in an iframe
         in such case we will need to switch to that frame first and then we can interact with its elements
         in order to switch to a frame or iframe we will use driver.switchTo().frame()
         to specify to what frame we want to move we have 4 options:
         1. by index - not reliable
         2. by name
         3. by id
         4. by web element
         WebElement myIFrame = driver.findElement(By.cssSelector("[title='YouTube video player']"));
         */
        // when we do switchTo() it goes to a children iFrame of current page
        driver.switchTo().frame("iframe-youtube"); // switched to iframe
        Thread.sleep(2000);
        WebElement playButton = driver.findElement(By.cssSelector("button[title=Play]")); // interacted with element that belongs to iframe
        playButton.click();
        Thread.sleep(5000);

        // we need to switch to another iframe that is siblings to the one we are in
        // in order to do that we need to go back to parent of the iframe or in this case we also can go back to default page
        driver.switchTo().parentFrame(); // it goes back one generation
        // option 2
        //driver.switchTo().defaultContent(); // this method no matter how many generations you are nested it will go back to the main page

        // once we are on the parent frame we now need to switch to another frame we need to interact with
        driver.switchTo().frame("mce_0_ifr");
        WebElement content = driver.findElement(By.cssSelector("#tinymce > p"));
        System.out.println(content.getText());
        Thread.sleep(5000);

        // we now need to move back again since we want to interact with another element from another iframe
        driver.switchTo().defaultContent();


        driver.switchTo().frame("email-subscribe");
        WebElement emailInputBox = driver.findElement(By.id("email"));
        Thread.sleep(2000);

        // in order to not hardcode the email we will generate a new with faker
        Faker faker = new Faker();
        emailInputBox.sendKeys(faker.internet().emailAddress());
        emailInputBox.sendKeys(Keys.PAGE_DOWN);

        Thread.sleep(2000);
        WebElement subscribeButton = driver.findElement(By.id("btn-subscribe"));

        subscribeButton.click();
        Thread.sleep(2000);
        driver.quit();
    }

}

