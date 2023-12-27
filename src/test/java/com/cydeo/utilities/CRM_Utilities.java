package com.cydeo.utilities;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
This class will store the method related to CRM project
 */
public class CRM_Utilities {

    /*
    This method will login using these credentials
     */
    public static void loginCRM(WebDriver driver){
        //3. Enter valid username
        WebElement userNameLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameLogin.sendKeys("helpdesk1@cydeo.com");
        //4. Enter valid password
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordLogin.sendKeys("UserUser");
        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();

    }

    public static void loginCRM(WebDriver driver, String username, String password){
        //3. Enter valid username
        WebElement userNameLogin = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        userNameLogin.sendKeys(username);
        //4. Enter valid password
        WebElement passwordLogin = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordLogin.sendKeys(password);
        //5. Click to `Log In` button
        WebElement logInButton = driver.findElement(By.xpath("//input[@class='login-btn']"));
        logInButton.click();

    }

}
