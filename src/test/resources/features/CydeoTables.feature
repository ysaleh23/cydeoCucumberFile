@cydeoDataTables
Feature: User should login into Cydeo Web tables practice

  Background:
    Given User is on the login page of Web table app

  @cydeoDataTables_Test1
  Scenario: User should be able to login with correct
  credentials
    #Given User is on the login page of Web table app
    When User enters correct username "Test"
    And User enters correct password "Tester"
    And User clicks login button
    Then User should see URL contains orders



  @cydeoDataTables_Test2
  Scenario: User should be able to login with correct
  credentials
    #Given User is on the login page of Web table app
    When User enters below credentials
      | username | Test |
      | password | Tester |
    Then User should see URL contains orders

