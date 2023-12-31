Feature: Saucedemo Shopping

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked
    And the 'Sidebar' button is clicked
    And the 'ResetAppState' button is clicked
    And the page is refreshed

  Scenario Outline: Add items to the shopping cart
  When I add the '<item1>' to the shopping cart
  And I add the '<item2>' to the shopping cart
  And the 'Cart' button is clicked
  Then I should have 2 items in my shopping cart
  Examples:
    | item1          | item2             |
    | Sauce Labs Bike Light| Sauce Labs Onesie |
    | Sauce Labs Backpack| Sauce Labs Bolt T-Shirt |
    | Sauce Labs Fleece Jacket| Sauce Labs Onesie |
    | Sauce Labs Bike Light| Test.allTheThings() T-Shirt (Red) |



  Scenario Outline: Remove items from the shopping cart
    Given the 'Sidebar' button is clicked
    And the 'ResetAppState' button is clicked
    And the page is refreshed
    And I add the '<item1>' to the shopping cart
    And I add the '<item2>' to the shopping cart
    And I remove the '<item2>' from the shopping cart
    And the 'Cart' button is clicked
    Then I should have 1 items in my shopping cart
    Examples:
      | item1                 | item2               |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Fleece Jacket |
      | Sauce Labs Backpack| Sauce Labs Bolt T-Shirt |
      | Sauce Labs Fleece Jacket| Sauce Labs Onesie |
      | Sauce Labs Bike Light| Test.allTheThings() T-Shirt (Red) |


  Scenario Outline: Remove items from the shopping cart
    Given the 'Sidebar' button is clicked
    And the 'ResetAppState' button is clicked
    And the page is refreshed
    And I add the '<item1>' to the shopping cart
    And I remove the '<item1>' from the shopping cart
    And the 'Cart' button is clicked
    Then I should have 0 items in my shopping cart
    Examples:
      | item1|
      | Sauce Labs Onesie|
      | Sauce Labs Fleece Jacket |
      | Test.allTheThings() T-Shirt (Red) |
      | Sauce Labs Bike Light|




  Scenario Outline: click the checkout button
    Given I add the '<item1>' to the shopping cart
    And I add the '<item2>' to the shopping cart
    And the 'Cart' button is clicked
    Then the user is directed to '<PAGE_URL>'
    Examples:
      | item1          | item2             |PAGE_URL                            |
      | Sauce Labs Backpack | Sauce Labs Onesie |https://www.saucedemo.com/cart.html |
      | Sauce Labs Backpack| Sauce Labs Bolt T-Shirt |https://www.saucedemo.com/cart.html |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Fleece Jacket |https://www.saucedemo.com/cart.html |
      | Sauce Labs Bike Light| Test.allTheThings() T-Shirt (Red) |https://www.saucedemo.com/cart.html |


  Scenario Outline: Checkout-phase-one
    Given I add the '<item1>' to the shopping cart
    And I add the '<item2>' to the shopping cart
    And the 'Cart' button is clicked
    When the 'Checkout' button is clicked
    Then the user is directed to '<PAGE_URL>'
    Examples:
      | item1               | item2             | PAGE_URL                            |
      | Sauce Labs Backpack | Sauce Labs Onesie | https://www.saucedemo.com/checkout-step-one.html |
      | Sauce Labs Bolt T-Shirt | Sauce Labs Fleece Jacket | https://www.saucedemo.com/checkout-step-one.html |
      | Sauce Labs Backpack| Sauce Labs Bolt T-Shirt | https://www.saucedemo.com/checkout-step-one.html |
      | Sauce Labs Bike Light| Test.allTheThings() T-Shirt (Red) | https://www.saucedemo.com/checkout-step-one.html |