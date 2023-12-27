Feature: Cucumber Data Tables implementation practices


  Scenario: List of fruits and vegetables I like
    Then user should see below list
      | orange     |
      | apple      |
      | kiwi       |
      | strawberry |
      | tomato     |
      | pear       |
      | eggplant   |

    #Create a new scenario where we list the type of pets we love
    #Print out all the strings in the list

  @petsWeLove
  Scenario: List of pets we love
    Then user should see a list of the pets we love
      | dog      |
      | cat      |
      | fish     |
      | weasel   |
      | turtle   |
      | monkey   |
      | cub lion |
      | iguana   |

  Scenario: Officer reads data about driver
    Then officer is able to see any data he wants
      | name    | Jane         |
      | surname | Doe          |
      | age     | 29           |
      | address | somewhere    |
      | state   | CA           |
      | zipcode | 99999        |
      | phone   | 111-111-1111 |

    @dataTable
  Scenario: User should be able to see all 12 months in months dropdown
    Given User is on the dropdowns page of practice tool
    Then User should see below info in month dropdown
      | January   |
      | February  |
      | March     |
      | April     |
      | May       |
      | June      |
      | July      |
      | August    |
      | September |
      | October   |
      | November  |
      | December  |