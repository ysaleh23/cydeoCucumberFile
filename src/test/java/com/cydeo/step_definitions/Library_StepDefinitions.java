package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Library_StepDefinitions {

    @Given("user is on the login page of the library application")
    public void user_is_on_the_login_page_of_the_library_application() {
        System.out.println("Given user is on the login page of the library application.");
    }
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters the librarian username.");
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("User enters the librarian password.");
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("User sees the dashboard.");
    }
    @When("user enters student username")
    public void user_enters_student_username() {
        System.out.println("User enters username.");
    }
    @When("user enters student password")
    public void user_enters_student_password() {
        System.out.println("User enters user password.");
    }
    @When("user enters admin username")
    public void user_enters_admin_username() {
        System.out.println("User enters their admin username.");
    }
    @When("user enters admin password")
    public void user_enters_admin_password() {
        System.out.println("User enters their admin password.");
    }


}
