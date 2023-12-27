package com.cydeo.step_definitions;

import com.cydeo.pages.WikipediaSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Wikipedia_StepDefinitions {
    WikipediaSearchPage searchPage = new WikipediaSearchPage();
    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("testURL"));
    }

    @Given("User types {string} in the wiki search box")
    public void user_types_in_the_wiki_search_box(String steveJobs) {
       // searchPage.searchInput(ConfigurationReader.getProperty("searchInputText"));
        searchPage.searchInput(steveJobs);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        BrowserUtils.sleep(1);
        searchPage.clickAbleSearchButton.click();
    }

    @Then("User sees {string} is in the wiki title")
    public void user_sees_is_in_the_wiki_title(String steveJobs) {
        //BrowserUtils.sleep(1);
        Assert.assertTrue(Driver.getDriver().getTitle().contains(steveJobs) );
    }

    @Then("User sees {string} is in the main header")
    public void user_sees_is_in_the_main_header(String steveJobs) {
        //BrowserUtils.sleep(1);
        Assert.assertEquals(searchPage.mainHeader.getText(), steveJobs);
    }

    @Then("User sees {string} is in the image header")
    public void user_sees_is_in_the_image_header(String steveJobs) {
        Assert.assertEquals(searchPage.steveJobsImageHeader.getText(), steveJobs);
    }
}
