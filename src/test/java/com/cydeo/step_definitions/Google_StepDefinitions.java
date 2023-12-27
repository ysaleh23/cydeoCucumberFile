package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class Google_StepDefinitions {

    @Given("User is on the Google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @When("user searches for {word}")
    public void user_searches_for_apple(String word) {
        WebElement googleSearchBar = Driver.getDriver().findElement(By.xpath("//textarea[@name='q']"));
        googleSearchBar.sendKeys(word + Keys.ENTER);
    }
    @Then("user should see title is {word}")
    public void user_should_see_title_is_apple(String word) {
       BrowserUtils.verifyTitleContains(word);
    }

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    @When("user searches for google")
    public void user_searches_for_google() {
        googleSearchPage.searchBox.sendKeys("google", Keys.ENTER);
    }
    @Then("user should see title is google")
    public void user_should_see_title_is_google() {
        BrowserUtils.verifyTitle("google - Google Search");
    }


}
