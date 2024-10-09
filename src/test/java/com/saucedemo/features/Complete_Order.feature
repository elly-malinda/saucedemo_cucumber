Feature: Complete Order

  Scenario Outline: Registered User Order Products Items and Checkout Order Successfully
    Given I launched saucedemo Application
    When I Authenticate with valid "<username>" and "<password>"
    And I Enter shipping details "<fisrt_name>", "<last_name>" , "<zip_code>" and Checkout Order
    Then I verify that Order is Generated Successfully
    Examples:
      | username      | password      | fisrt_name  | last_name | zip_code|
      | standard_user | secret_sauce  | Jacob       | Mare      | 2011    |

