package com.cydeo.step_definitions;

import com.cydeo.pages.R_VtrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class R_VytrackLogin_StepDefinitions {
    R_VtrackLoginPage loginPage = new R_VtrackLoginPage();
    @Given("user is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }
    @When("user enters the driver information")
    public void user_enters_the_driver_information() {

        loginPage.login(ConfigurationReader.getProperty("driver_username"),ConfigurationReader.getProperty("driver_password"));

    }
    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
        BrowserUtils.sleep(5);
        Assert.assertEquals("Dashboard", Driver.getDriver().getTitle());
    }

    @When("user enters the sales manager information")
    public void user_enters_the_sales_manager_information() {
        loginPage.login(ConfigurationReader.getProperty("sales_manager_username"),ConfigurationReader.getProperty("sales_manager_password"));
    }

    @When("user enters the store manager information")
    public void user_enters_the_store_manager_information() {
        loginPage.login(ConfigurationReader.getProperty("store_manager_username"),ConfigurationReader.getProperty("store_manager_password"));
    }

    @When("user enters the {string} information")
    public void user_enters_the_information(String string) {
        loginPage.login(string);
    }
}
