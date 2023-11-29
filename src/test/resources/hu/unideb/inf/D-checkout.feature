Feature: Saucedemo user checkout

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked
    And the 'Sidebar' button is clicked
    And the 'ResetAppState' button is clicked
    And the page is refreshed
    And I add the 'Sauce Labs Backpack' to the shopping cart
    And the 'Cart' button is clicked
    And the 'Checkout' button is clicked

  Scenario Outline: Incorrect checkout attempts
    Given the 'First Name' field is filled with '<firstName>'
    And the 'Last Name' field is filled with '<lastName>'
    And the 'Zip Code' field is filled with '<zipCode>'
    When the 'Continue' button is clicked
    Then the checkout '<errorMessage>' message is shown
    Examples:
      | firstName        | lastName      |zipCode |errorMessage    |
      |   |   |   |   Error: First Name is required|
      | Mohamed |   |   |   Error: Last Name is required |
      | Mohamed |   | 12345 |   Error: Last Name is required|
      | Mohamed | Smith |   |  Error: Postal Code is required|

  Scenario Outline: Correct checkout attempts
    Given the 'First Name' field is filled with '<firstName>'
    And the 'Last Name' field is filled with '<lastName>'
    And the 'Zip Code' field is filled with '<zipCode>'
    When the 'Continue' button is clicked
    Then the user is directed to '<PAGE_URL>'
    Examples:
      | firstName | lastName| zipCode|PAGE_URL                                                |
      | Mohamed   |  Naruto | 4024   |https://www.saucedemo.com/checkout-step-two.html        |

