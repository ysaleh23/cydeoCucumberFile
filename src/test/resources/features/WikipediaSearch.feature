@wikipedia
Feature: Wikipedia search functionalities

  Background:
    Given User is on Wikipedia home page

  #@wikipedia_TestCase1
  Scenario: Wikipedia Search Functionality Title Verification
    Given User types "Steve Jobs" in the wiki search box
    When  User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title

  #@wikipedia_TestCase2
  Scenario: Wikipedia Search Functionality Header Verification
    Given User types "Steve Jobs" in the wiki search box
    When  User clicks wiki search button
    Then User sees "Steve Jobs" is in the main header

 # @wikipedia_TestCase3
  Scenario: Wikipedia Search Functionality Image Header Verification
    Given User types "Steve Jobs" in the wiki search box
    When  User clicks wiki search button
    Then User sees "Steve Jobs" is in the image header

  @scenarioOutline
  Scenario Outline: Wikipedia Search Functionality with Scenario Outline
    Given User is on Wikipedia home page
    Given User types "<searchValue>" in the wiki search box
    When  User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" is in the main header
    Then User sees "<expectedImageHeader>" is in the image header

    Examples: search values we are going to be using in this scenario outlines
      | searchValue     | expectedTitle   | expectedMainHeader | expectedImageHeader    |
      | Steve Jobs      | Steve Jobs      | Steve Jobs         | Steve Jobs             |
      | Marry Barra     | Marry Barra     | Marry Barra        | Marry Barra            |
      | Rosalind Brewer | Rosalind Brewer | Rosalind Brewer    | Rosalind Brewer        |
      | Sundar Pichai   | Sundar Pichai   | Sundar Pichai      | Sundar Pichai          |
      | Marie Curie     | Marie Curie     | Marie Curie        | Marie Skłodowska-Curie |
      | Albert Einstein | Albert Einstein | Albert Einstein    | Albert Einstein        |









