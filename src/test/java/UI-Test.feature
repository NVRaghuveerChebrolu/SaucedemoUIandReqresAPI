@UI
Feature: Checkout items in the basket
  Please use home page of https://www.saucedemo.com/

  Scenario: Check item total cost and tax
    Given I am on the home page
    And I login in with the following details
      | userName      | Password     |
      | standard_user | secret_sauce |

    And I add the following items to the basket
      | Sauce Labs Backpack      |
      | Sauce Labs Fleece Jacket |
      | Sauce Labs Bolt T-Shirt  |
      | Sauce Labs Onesie        |

    And I  should see 4 items added to the shopping cart
    And I click on the shopping cart
    And I verify that the QTY count for each item should be 1
    And I remove the following item:
      | Sauce Labs Fleece Jacket |
    And I should see updated 3 items in the shopping cart
    And I click on the CHECKOUT button
    And I type "FirstName" for First Name
    And I type "LastName" for Last Name
    And I type "EC1A 9JU" for ZIP/Postal Code

    When I click on the CONTINUE button
    Then Item total will be equal to the total of items on the list
    And a Tax rate of 8 % is applied to the total


