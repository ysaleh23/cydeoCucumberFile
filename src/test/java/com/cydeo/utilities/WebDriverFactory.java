package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverFactory {

        //TASK: NEW METHOD CREATION
        //Method name: getDriver
        //Static method
        //Accepts String arg: browserType
        // -This arg will determine what type of browser is opened
        //- if "chrome" passed --> it will open Chrome browser
        //- if "firefox" passed -->  it will open firefox browser
        //Return type: "WebDriver"

        public static WebDriver getDriver(String  browserType){

            if (browserType.equalsIgnoreCase("chrome")){
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();

            }else if (browserType.equalsIgnoreCase("firefox")) {
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver();

            } else if (browserType.equalsIgnoreCase("edge")) {
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver();
            } else {
                System.out.println("Given string doesn't represent any browser.");
                System.out.println("Either that browser does not exist or not currently supported.");
                return null;
            }

        }





}
