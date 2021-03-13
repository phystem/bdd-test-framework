Feature: To test the online shopping on automation practice website

  Scenario Outline: Order T-Shirt and verify in order history
    Given I login to the application with "<email>" and "<password>"
    And I navigate to "T-shirts" category
    And I add the T-shirt to the cart
    And I continue to checkout
    And I increase the product qty
    Then I store the order details
    And I complete placing the order
    When I view the order details in order history
    Then the order details should match the stored order
    And I logout from the application
    Examples:
      | email                | password |
      | madhan-test@test.com | test1234 |

  Scenario Outline: Update personal information in My Account
    Given I login to the application with "<email>" and "<password>"
    And I navigate to personal information
    When I update my firstname
    Then the firstname should be updated
    And I logout from the application
    Examples:
      | email                | password |
      | madhan-test@test.com | test1234 |
