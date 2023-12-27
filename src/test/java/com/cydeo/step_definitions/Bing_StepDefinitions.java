package com.cydeo.step_definitions;

import com.cydeo.pages.BingSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;

import java.security.Key;

public class Bing_StepDefinitions {

    BingSearchPage bingSearchPage = new BingSearchPage();
    @Given("User is on the Bing search page")
    public void user_is_on_the_bing_search_page() {
        Driver.getDriver().get("https://www.bing.com");
    }
    @When("User searches for orange")
    public void user_searches_for_orange() {
        BrowserUtils.sleep(2);
        //bingSearchPage.bingSearchBox.click();
        bingSearchPage.bingSearchBox.sendKeys("orange" + Keys.ENTER);

    }
    @Then("User should see the title as orange – Search")
    public void user_should_see_the_title_as_orange_search() {
        BrowserUtils.verifyTitle("orange - Search");
    }

    @When("User searches for {string}")
    public void user_searches_for(String searchValue) {
        BrowserUtils.sleep(2);
        bingSearchPage.bingSearchBox.sendKeys(searchValue + Keys.ENTER);
    }
    @Then("User should see the title as {string}")
    public void user_should_see_the_title_as(String expectedTitle) {
        BrowserUtils.verifyTitleContains(expectedTitle);
    }


}
