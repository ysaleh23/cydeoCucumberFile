Feature: Bing search functionality
  Agile story: As a user, when I am on the Bing search page
  I should be able to search anything and see relevant results


 #Task 2: Bing Search Title Verification
  #1. Go to https://www.google.com
  #2. Search for “orange”
  #3. Verify title is:
  #a. Expected = “orange – Search”
  #Note:
  #1. Follow POM Design Pattern
  #2. BDD implementation


 @testCase2
 Scenario: Bing page default title verification
 Given User is on the Bing search page
 When User searches for orange
 Then User should see the title as orange – Search

  @testCase3
  Scenario: Bing page default title verification
    Given User is on the Bing search page
    When User searches for "orange"
    Then User should see the title as "orange"