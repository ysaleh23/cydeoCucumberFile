@vyTrackTask
Feature:Users should be able to login
  User Story:
  As a user, I should be able to login with correct credentials to different accounts. And dashboard should be displayed.
  Accounts are: driver, sales manager, store manager

  Background:
    Given user is on the login page


  Scenario: Login as driver
    When user enters the driver information
    Then user should be able to login


  Scenario: Login as sales manager
    When user enters the sales manager information
    Then user should be able to login


  Scenario: Login as store manager
    When user enters the store manager information
    Then user should be able to login

  @vyTrackTask2
  Scenario: Login as store manager
    When user enters the "store manager" information
    Then user should be able to login

  @vyTrackTask3
  Scenario Outline: Login with different users
    Given user is on the login pages
    When the user login with given credentials from "<SheetName>" and <RowNumber>
    Then the user should be able to login and see their name

    Examples:
      | SheetName    | RowNumber |
      | VytrackUsers | 1         |
      | VytrackUsers | 2         |
      | VytrackUsers | 3         |
      | VytrackUsers | 4         |
      | VytrackUsers | 5         |
      | VytrackUsers | 6         |