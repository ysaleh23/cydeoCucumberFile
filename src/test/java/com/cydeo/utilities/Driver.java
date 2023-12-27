package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

public class Driver {

    //create a private constructor to remove access to this object

    private Driver(){}

    /*
    We make the WebDriver private because, we want to close access from outside  the class.
    We are making it static, because we will use it in a static method.
     */

    /*
    Create a re-usable utility method which will return the same driver instance once we call it.
    -If an instance doesn't exist, it will create first, and then it will always return same instance.
     */
    private static WebDriver driver; // default value = null

    public static WebDriver getDriver(){

        if (driver==null){

            /*
            We will read our browserType from the configuration.properties file.
            this way, we cna control which browser is opened from outside our code.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
            Depending on the browserType returned from the configuration.properties. Switch statement will determine
            the "case", and open the matching browser.
             */
            switch (browserType){
                case "chrome":
                    //WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "edge":
                    //WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

                case "safari":
                    //WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;



            }
        }

        return driver;

    }


    public static void closeDriver(){
        if (driver != null){
            /*
            This line will terminate the currently existing driver completely. It will not exist going forward.
             */
            driver.quit();
            /*
            We assign the value back to "null" so that my singleton
             */
            driver = null;
        }

    }

}
