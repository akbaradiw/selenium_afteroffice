Feature: Purchase the order from ecommerce

Background: User landed to website
    Given User landing to ecommerce

Scenario Outline: Purchase Item Positive Case
    Given User Logged to website with username <username> and password <password>
    When User add item to Cart
    And User checkout item and input first name "<first_name>" last name "<last_name>" and postal code "<postal_code>"
    Then User will see message is displayed on confirmation page

Examples:
    | username      | password     | first_name | last_name | postal_code |
    | standard_user | secret_sauce | Tan        | Malaka    | 666         |

Scenario Outline: User Logout from saucedemo
    Given User Logged to website with username <username> and password <password>
    Then User Logout from website

Examples:
    | username      | password     |
    | standard_user | secret_sauce |

Scenario Outline: Purchase Item Without Input Informations
    Given User Logged to website with username <username> and password <password>
    When User add item to Cart
    And User Click Continue Button
    Then User will see error message

Examples:
    | username      | password     | 
    | standard_user | secret_sauce |


