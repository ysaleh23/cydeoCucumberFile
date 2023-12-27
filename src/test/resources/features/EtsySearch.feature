@etsyTest
Feature: Etsy search functionality
  Agile Story: User should be able to type any keyword and see relevant information.

  Background:
    Given User is on Etsy homepage
  @etsyTestCase1
  Scenario: Etsy Title Verification
    #Given User is on Etsy homepage
    Then User should see title is as expected.
    #expectedTitle: Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone

  @etsyTestCase2
  Scenario: Etsy Search Functionality Title Verification (without parameterization)
    #Given User is on Etsy homepage
    When User types Wooden Spoon in the search box
    And User clicks search button
    Then User sees Wooden Spoon is in the title

    @etsyTestCase3
    Scenario: Etsy Search Functionality Title Verification (with parameterization)
     When User types "Wooden Spoon" in the search box
     And User clicks search button
     Then User sees "Wooden spoon" is in the title
