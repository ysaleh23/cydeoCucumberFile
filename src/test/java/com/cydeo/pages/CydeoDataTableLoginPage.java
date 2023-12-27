package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CydeoDataTableLoginPage {

    public CydeoDataTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(xpath = "//input[@name='username']")
    public WebElement usernameInputBox;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordInputBox;

    @FindBy(xpath = "//button[.='Login']")
    public WebElement loginButton;




    public void loginCredentials(String username, String password){
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        loginButton.click();
    }

    public void loginCredentials(){

        usernameInputBox.sendKeys("Test");
        passwordInputBox.sendKeys("Tester");
        loginButton.click();
    }


}
