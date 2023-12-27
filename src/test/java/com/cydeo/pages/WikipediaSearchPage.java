package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchPage {

    public WikipediaSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "searchInput")
    public WebElement searchInputBox;

    @FindBy(xpath = "//button[@class='pure-button pure-button-primary-progressive']")
    public WebElement clickAbleSearchButton;

    @FindBy(xpath = "//button[@type='button']")
    public WebElement brokeWikipedia;

    @FindBy(xpath = "//h1[@id=\"firstHeading\"]")
    public WebElement mainHeader;

    @FindBy(xpath = "//div[@style='display:inline-block']")
    public WebElement steveJobsImageHeader;

    public void searchInput(String steveJobs){
        searchInputBox.sendKeys(steveJobs);

        if (brokeWikipedia.isDisplayed()){
            brokeWikipedia.click();
        }

    }



}
