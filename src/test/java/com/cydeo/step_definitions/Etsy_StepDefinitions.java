package com.cydeo.step_definitions;

import com.cydeo.pages.EtsyHomePage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Etsy_StepDefinitions {
    EtsyHomePage searchPage = new EtsyHomePage();

    @Given("User is on Etsy homepage")
    public void user_is_on_etsy_homepage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("etsyURL"));
    }

    @Then("User should see title is as expected.")
    public void user_should_see_title_is_as_expected() {
        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        BrowserUtils.verifyTitle(expectedTitle);
    }

    @When("User types Wooden Spoon in the search box")
    public void user_types_wooden_spoon_in_the_search_box() {
        searchPage.etsySearchInputBox.sendKeys("Wooden Spoon");
    }

    @When("User clicks search button")
    public void user_clicks_search_button() {
        searchPage.clickSearchButton.click();
    }

    @Then("User sees Wooden Spoon is in the title")
    public void user_sees_wooden_spoon_is_in_the_title() {
        BrowserUtils.sleep(2);
        String woodenSpoon = "Wooden spoon";
        BrowserUtils.verifyTitleContains(woodenSpoon);
    }

    @When("User types {string} in the search box")
    public void user_types_in_the_search_box(String woodenSpoon) {
        searchPage.searchBoxEntryValues(woodenSpoon);
    }

    @Then("User sees {string} is in the title")
    public void user_sees_is_in_the_title(String entry) {
        BrowserUtils.verifyTitleContains(entry);
    }

}
