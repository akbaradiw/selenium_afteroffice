Feature: Purchase the order from ecommerce

Background: User landed to website
    Given: User landing to ecommerce

Scenario: Purchase Item Positive Case
    Given User Logged to website
    When User add item to Cart
    And User checkout item
    Then User will see message is displayed on confirmation page

Scenario: User Logout from saucedemo
    Given User Logged to website
    Then User Logout from website