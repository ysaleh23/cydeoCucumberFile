package com.cydeo.utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
This class will be storing the utility method that will be used across the project.
 */
public class BrowserUtils {

/*
This method will accept int (in seconds) and execute Thread.sleep method for given duration.
Arg: int second
 */

public static void sleep(int second){
    second *= 1000;
    try {
        Thread.sleep(second);
    }catch (InterruptedException e){

    }
}

    public static void switchWindowAndVerify( String expectedInURL, String expectedTitle){

        Set<String> allWindowHandles = Driver.getDriver().getWindowHandles();

        for (String each : allWindowHandles) {

            Driver.getDriver().switchTo().window(each);
            System.out.println("Current URL: " + Driver.getDriver().getCurrentUrl());

            if (Driver.getDriver().getCurrentUrl().contains(expectedInURL)){
                break;
            }

        }

        //5. Assert: Title contains “Etsy”
        //    Lines to be pasted:

        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }


    public static void verifyTitle(String expectedTitle){

    Assert.assertEquals(Driver.getDriver().getTitle(), expectedTitle);
 }

    public static void verifyTitleContains(String expectedTitle){

        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedTitle));
    }

    //this method accepts WebElement target, and waits for that WebElement  not to be displayed on the page.
    public static void waitForInvisibilityOfGivenElement(WebElement target){
      WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
      wait.until(ExpectedConditions.invisibilityOf(target));
    }

    //this method accepts String title, and waits for that title to contain the given String value.
    public static void waitForTitleContains(String title){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static List<String> dropDownOptions_as_String(WebElement dropdownElement) {
        Select month = new Select(dropdownElement);
        //Storing all the ACTUAL options into a List of WebElements
        List<WebElement> actualMonth_as_WebElement = month.getOptions();
        //Storing all the EMPTY list of string to store ACTUAL <option> as String
        List<String> actualMonth_as_String = new ArrayList<>();
        //Looping through the List<WebElement>, getting all options texts,a nd storing them into List<String>
        for (WebElement each : actualMonth_as_WebElement) {
            actualMonth_as_String.add(each.getText());
        }
        return actualMonth_as_String;
    }

    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){
        for (WebElement each : radioButtons) {
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }



}
