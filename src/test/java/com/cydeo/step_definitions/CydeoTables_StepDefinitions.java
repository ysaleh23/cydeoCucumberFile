package com.cydeo.step_definitions;

import com.cydeo.pages.CydeoDataTableLoginPage;
import com.cydeo.pages.CydeoDataTable_BasePage;
import com.cydeo.pages.CydeoDataTable_OrderPage;
import com.cydeo.pages.CydeoDataTable_ViewAllOrdersPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Map;

public class CydeoTables_StepDefinitions {
    CydeoDataTableLoginPage loginPage = new CydeoDataTableLoginPage();
    CydeoDataTable_BasePage basePage = new CydeoDataTable_BasePage();
    CydeoDataTable_OrderPage orderPage = new CydeoDataTable_OrderPage();
    CydeoDataTable_ViewAllOrdersPage viewAllOrdersPage = new CydeoDataTable_ViewAllOrdersPage();

    @Given("User is on the login page of Web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("testURL"));
    }

    @When("User enters correct username {string}")
    public void user_enters_correct_username(String username) {
        loginPage.usernameInputBox.sendKeys(username);
    }

    @When("User enters correct password {string}")
    public void user_enters_correct_password(String password) {
        loginPage.passwordInputBox.sendKeys(password);
        BrowserUtils.sleep(2);

    }

    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String, String> loginCredentials) {
        loginPage.usernameInputBox.sendKeys(loginCredentials.get("username"));
        loginPage.passwordInputBox.sendKeys(loginCredentials.get("password"));

    }

    @When("User clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("User should see URL contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtils.sleep(2);
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().endsWith("orders"));

    }

    @Given("user is already logged in to The Web table app")
    public void user_is_already_logged_in_to_the_web_table_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("testURL"));
        loginPage.loginCredentials("Test", "Tester");
    }

    @When("user is on the Order page")
    public void user_is_on_the_order_page() {
        basePage.orderButton.click();
        BrowserUtils.sleep(2);
    }

    @Then("user sees below options under product dropdown")
    public void user_sees_below_options_under_product_dropdown(List<String> expectedProductDropdown) {
        List<String> actualProductDropdown = BrowserUtils.dropDownOptions_as_String(orderPage.productDropdown);

        Assert.assertEquals(actualProductDropdown, expectedProductDropdown);
    }

    @Then("user sees Visa as enabled payment option")
    public void user_sees_visa_as_enabled_payment_option() {
        Assert.assertTrue(orderPage.visaRadioButton.isEnabled());
    }

    @Then("user sees Mastercard as enabled payment option")
    public void user_sees_mastercard_as_enabled_payment_option() {
        Assert.assertTrue(orderPage.mastercardRadioButton.isEnabled());
    }

    @Then("user sees American Express as enabled payment option")
    public void user_sees_american_express_as_enabled_payment_option() {
        Assert.assertTrue(orderPage.americanexpressRadioButton.isEnabled());
    }


    @When("user enters quantity {string}")
    public void user_enters_quantity(String quantity) {
        orderPage.qtyInputBox.clear();
        // another option to deleting the default item in the input box.
        // orderPage.qtyInputBox.sendKeys(Keys.BACK_SPACE);
        orderPage.qtyInputBox.sendKeys(quantity);
    }

    @Then("user clicks to the calculate button")
    public void user_clicks_to_the_calculate_button() {
        orderPage.calculateButton.click();
    }

    @Then("user enters customers name {string}")
    public void user_enters_customers_name(String name) {
        orderPage.customerNameInputBox.sendKeys(name);
    }

    @Then("user enters street {string}")
    public void user_enters_street(String street) {
        orderPage.streetInputBox.sendKeys(street);
    }

    @Then("user enters city {string}")
    public void user_enters_city(String city) {
        orderPage.cityInputBox.sendKeys(city);
    }

    @Then("user enters state {string}")
    public void user_enters_state(String state) {
        orderPage.stateInputBox.sendKeys(state);
    }

    @Then("user enters zip code {string}")
    public void user_enters_zip_code(String zipCode) {
        orderPage.zipCodeInputBox.sendKeys(zipCode);
    }

    @Then("user selects credit card payment option {string}")
    public void user_selects_credit_card_payment_option(String expectedCardType) {
        BrowserUtils.clickRadioButton(orderPage.cardTypes, expectedCardType);
    }

    @Then("user enters their credit card number {string}")
    public void user_enters_their_credit_card_number(String creditCardNum) {
        orderPage.cardNumberInputBox.sendKeys(creditCardNum);
    }

    @Then("user enters expiration date {string}")
    public void user_enters_expiration_date(String expDate) {
        orderPage.cardExpDateInputBox.sendKeys(expDate);
    }

    @Then("user clicks to “Process Order”")
    public void user_clicks_to_process_order() {
        orderPage.processOrderButton.click();
    }


    @Then("user should see {string} int the first row of the web table")
    public void userShouldSeeIntTheFirstRowOfTheWebTable(String expectedName) {
        String actualName = viewAllOrdersPage.nameInWebTable.getText();

        Assert.assertEquals(actualName,expectedName);
    }
}
