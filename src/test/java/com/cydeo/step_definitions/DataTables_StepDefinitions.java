package com.cydeo.step_definitions;

import com.cydeo.pages.DropdownPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTables_StepDefinitions {

    @Then("user should see below list")
    public void user_should_see_below_list(List<String> fruitsAndVegetables) {

        System.out.println("fruitsAndVegetables = " + fruitsAndVegetables);

        System.out.println("fruitsAndVegetables.get(1) = " + fruitsAndVegetables.get(1));

    }

    @Then("user should see a list of the pets we love")
    public void user_should_see_a_list_of_the_pets_we_love(List<String> petsWeLove) {

        System.out.println("petsWeLove = " + petsWeLove);
        System.out.println("petsWeLove.get(1) = " + petsWeLove.get(1));
    }

    @Then("officer is able to see any data he wants")
    public void officer_is_able_to_see_any_data_he_wants(Map<String,String> driverInfo) {
        System.out.println("driverInfo = " + driverInfo);
        System.out.println("driverInfo.get(\"name\") = " + driverInfo.get("name"));
        System.out.println("driverInfo.get(\"address\") = " + driverInfo.get("address"));
    }

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    DropdownPage dropdownPage = new DropdownPage();
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedMonths) {
        Select month = new Select(dropdownPage.monthDropDown);
        List<WebElement> actualMonth_as_WebElement = month.getOptions();
        List<String> actualMonth_as_String = new ArrayList<>();

        for (WebElement each : actualMonth_as_WebElement) {
            actualMonth_as_String.add(each.getText());
        }

        List<String> actualMonths = BrowserUtils.dropDownOptions_as_String(dropdownPage.monthDropDown);
        Assert.assertEquals(expectedMonths,actualMonths);
    }

    }


