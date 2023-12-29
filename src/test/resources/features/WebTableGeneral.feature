@webTableGeneral
Feature: Some of the general functionality verifications


  Scenario: Dropdown options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees below options under product dropdown
      | MoneyCog   |
      | Familybea  |
      | Screenable |

  Scenario: Payment options verification
    Given user is already logged in to The Web table app
    When user is on the Order page
    Then user sees Visa as enabled payment option
    Then user sees Mastercard as enabled payment option
    Then user sees American Express as enabled payment option

  @webTableGeneral_Test3
  Scenario: Order place scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    And user enters quantity "2"
    Then user clicks to the calculate button
    And user enters customers name "Jane Doe"
    And user enters street "7th Street"
    And user enters city "New York City"
    And user enters state "New York"
    And user enters zip code "00000"
    And user selects credit card payment option "Visa"
    And user enters their credit card number "1111222233334444"
    And user enters expiration date "12/25"
    And user clicks to “Process Order”
    Then user should see "Jane Doe" int the first row of the web table

  @customerPaymentInformation_Test1
  Scenario Outline: Order place scenario
    Given user is already logged in to The Web table app
    When user is on the Order page
    And user enters quantity "<quantity>"
    Then user clicks to the calculate button
    And user enters customers name "<customerName>"
    And user enters street "<streetAddress>"
    And user enters city "<cityName>"
    And user enters state "<state>"
    And user enters zip code "<zipCode>"
    And user selects credit card payment option "<cardType>"
    And user enters their credit card number "<creditCardNumber>"
    And user enters expiration date "<expDate>"
    And user clicks to “Process Order”
    Then user should see "<expectedCustomerName>" int the first row of the web table

    Examples:

      | quantity | customerName   | streetAddress       | cityName      | state        | zipCode | cardType         | creditCardNumber | expDate | expectedCustomerName |
      | 3        | John Doe       | 21 Jump Street      | Chicago       | Illinois     | 60601   | Mastercard       | 1111222233334444 | 07/26   | John Doe             |
      | 4        | Mike Jordan    | 23 Jump Street      | Chicago       | Illinois     | 60601   | Mastercard       | 1111222233334444 | 02/26   | Mike Jordan          |
      | 5        | John Hancock   | 14 E. Pens Street   | Pittsburgh    | Pennsylvania | 23456   | Visa             | 1111222233334444 | 01/25   | John Hancock         |
#      | 18       | Steven Jackson | 7th Hollywood Blvd. | Hollywood     | Florida      | 12345   | American Express | 1111222233334444 | 10/28   | Steven Jackson       |
#      | 1        | James Donald   | 456 S. Disney Ave   | Anaheim       | California   | 00002   | Visa             | 1111222233334444 | 07/26   | James Donald         |
#      | 340      | Donald Trump   | 1st Trump Ave.      | New York City | New York     | 00003   | American Express | 1111222233334444 | 09/29   | Donald Trump         |