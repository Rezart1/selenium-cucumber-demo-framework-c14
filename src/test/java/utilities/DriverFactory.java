package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver getDriver(String browserType){ // chrome, firefox, edge
        return switch (browserType.toLowerCase()){
            case "firefox" -> new FirefoxDriver();
            case "safari" -> new SafariDriver();
            case "edge" -> new EdgeDriver();
            default -> new ChromeDriver();
        };
    }

}


