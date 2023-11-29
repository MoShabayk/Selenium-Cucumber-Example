Feature: Saucedemo sidebar

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

    Scenario: navigate to About
      Given the 'Sidebar' button is clicked
      And the 'About' button is clicked
      Then the user is directed to 'https://saucelabs.com/'

  Scenario: navigate to Logout
    Given the 'Sidebar' button is clicked
    And the 'Logout' button is clicked
    Then the user is directed to 'https://www.saucedemo.com/'

  Scenario: navigate to All Items
    Given the 'Cart' button is clicked
    And the 'Sidebar' button is clicked
    And the 'AllItems' button is clicked
    Then the user is directed to 'https://www.saucedemo.com/inventory.html'

  Scenario Outline: click Reset App State
    Given I add the '<item1>' to the shopping cart
    And I add the '<item2>' to the shopping cart
    And the 'Sidebar' button is clicked
    And the 'ResetAppState' button is clicked
    And the 'Cart' button is clicked
    Then I should have 0 items in my shopping cart
    Examples:
      | item1                   | item2                    |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Fleece Jacket |