package step_definitions;

import org.openqa.selenium.edge.EdgeDriver;
import utilities.Driver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PlayGround {
    public static void main(String[] args) throws IOException {
//
//            //Driver.driver = new EdgeDriver();
//
//            // Driver driver = new Driver();
//
//            // Driver.getDriver().get("https://www.google.com");
//            Driver.quitDriver();

        // In java when working with anything - we need an object
        Properties myPropertiesFile = new Properties();

        String path = "src/test/resources/configs.properties";
        FileInputStream fileInputStream = new FileInputStream(path);

        myPropertiesFile.load(fileInputStream);

        System.out.println(myPropertiesFile.getProperty("browserType"));
        System.out.println(myPropertiesFile.getProperty("hrm_url"));

    }
}
