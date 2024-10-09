Feature: saucedemo Application Login

  Scenario Outline: Invalid user not authenticated
    Given I navigate to saucedemo application home page
    When I enter invalid user "<user>" and pwd "<pwd>" details
    Then User Authentication Fails
    Examples:
      | user | pwd |
      | locked_out_user | secret_sauce|

