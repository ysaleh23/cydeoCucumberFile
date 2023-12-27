Feature: Google search functionality
  Agile story: As a user, when I am on the Google search page
  I should be able to search anything and see relevant results

  @appleKeyword
  Scenario: Search page default title verification
    Given User is on the Google search page
    When user searches for dogwater
    Then user should see title is dogwater

  @wip_Yousef
  Scenario: Search page default title verification
    Given User is on the Google search page
    When user searches for google
    Then user should see title is google


