Feature: Saucedemo Shopping

  Background:
    Given the home page is opened
    And the 'Username' field is filled with 'standard_user'
    And the 'Password' field is filled with 'secret_sauce'
    And the 'Login' button is clicked

  Scenario Outline: Buying a backpack and t-shirt
    Given the '<item1>' is added to the cart
    And the '<item2>' is added to the cart
    And the 'Cart' button is clicked
    And the 'Checkout' button is clicked
    And the 'First Name' field is filled with '<firstName>'
    And the 'Last Name' field is filled with '<lastName>'
    And the 'Zip Code' field is filled with '<zipcode>'
    When the 'Continue' button is clicked
#    Total: $49.66
    Then the price should read '<total>'
    Examples:
      | item1 | item2 | firstName | lastName | zipcode | total |

      | Sauce Labs Backpack | Sauce Labs Bike Light | h | h | 111 | Total: $43.18 |
      | Test.allTheThings() T-Shirt (Red) | Sauce Labs Fleece Jacket | b | b | 21 | Total: $114.44 |

