package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class R_VtrackLoginPage {
    public R_VtrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@name='_username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@name='_password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@name='_submit']")
    public WebElement loginButton;

    public void login(String username,String password){
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
    }

    public void login(String userType){
        userType = userType.toLowerCase().replace(" ", "_");
        String username = ConfigurationReader.getProperty("sales_manager" + "_username");
        String password = ConfigurationReader.getProperty("sales_manager" + "_password");

        login(username,password);
    }
}
